<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,java.io.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	Properties pro = new Properties(); 
	String realpath = request.getRealPath("/WEB-INF/classes"); 
	try{  
		//读取配置文件
		FileInputStream in = new FileInputStream(realpath+"/config.properties"); 
		pro.load(new InputStreamReader(in, "UTF-8")); 
	}
	catch(FileNotFoundException e){ 
		 out.println(e); 
	} 
	catch(IOException e){
		out.println(e);
	} 

	//通过key获取配置文件
	String webIp = pro.getProperty("pc.ip"); 
	String viewUrl = webIp + "/html";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/public.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/zTree/v3/css/metroStyle/metroStyle.css">
    <!--/meta 作为公共模版分离出去-->
    <style type="text/css">
		.laytable-cell-1-titleImageSrc{  /*最后的pic为字段的field*/
	      height: 100%;
/* 	      max-width: 100%; */
	    }
	    .layui-elem-field{
	    	height: -webkit-fill-available;
	    }
	    body{
/* 	    	min-width: 1200px; */
	    }
    </style>
    <title>文章-列表</title>
</head>
<body class="childrenBody">
<div class="layui-col-xs2">
	<fieldset class="layui-elem-field" style="margin-right: 20px;">
		<legend>栏目</legend>
		<div class="layui-field-box">
			<div class="layui-row layui-col-space10">
				<div class="layui-col-md12">
					<ul id="treeDemo" class="ztree"></ul>
				</div>
			</div>
		</div>
	</fieldset>
</div>
<div class="layui-col-xs10">
	<form class="layui-form" id="roleForm">
	    <blockquote class="layui-elem-quote quoteBox">
	        <form class="layui-form">
	        	<input type="hidden" id="subjectId" name="subjectId" value="">
	        	<input type="hidden" id="level" name="level" value="${level}">
	            <div class="layui-inline">
	                <div class="layui-input-inline">
	                    <input type="text" class="layui-input searchVal" id="key" name="key" value="" placeholder="文章名称关键词搜索" />
	                </div>
	                <div class="layui-input-inline">
	                    <select id="status" name="status" class="layui-select searchVal">
	                    	<option value="">状态</option>
	                    	<option value="1">未发布</option>
	                    	<option value="2">已发布</option>
	                    </select>
	                </div>
	                <button class="layui-btn search_btn" type="button">搜索</button>
	            </div>
	
	            <div class="layui-inline a2">
	                <button class="layui-btn layui-btn-primary reset" type="button">清空</button>
	            </div>
	            <div class="layui-inline a2">
	            	<c:if test="${sessionScope.btn.add == 1 }">
		                <a class="layui-btn addNews_btn" onclick="goAdd()">新增内容</a>
	            	</c:if>
	            </div>
	        </form>
	    </blockquote>
	    <table id="articleList" lay-filter="articleList"></table>
	</form>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript">
$(function(){
	layui.use(['form','layer','table', 'laydate'],function(){
		var form = layui.form,
	    layer = parent.layer === undefined ? layui.layer : top.layer,
	    $ = layui.jquery,
	    table = layui.table,
		laydate = layui.laydate;
	
		laydate.render({
		    elem: '#dateRange'
		   ,range: true
		});
		
		//左边ztree的初始化
		var appName = '<%=request.getContextPath()%>';
	    var setting = {
	        view: {
	            dblClickExpand: false,
	            showLine: false,
	            selectedMulti: false
	        },
	        data: {
	            simpleData: {
	                enable: true,
	                idKey: "id",
	                pIdKey: "pId",
	                rootPId: ""
	            }
	        },
	        callback: {
	            beforeClick: function (treeId, treeNode) {
	                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	                if (false) {//treeNode.isParent
	                    zTree.expandNode(treeNode);
	                    return false;
	                } else {
	                    $("#subjectId").val(treeNode.id);
	                    if(treeNode.type == 5){
	                    	tableIns.reload({
				   	             page: {
				   	                 curr: 1 //重新从第 1 页开始
				   	             },
				   	             where: {
				   	                 subjectId:treeNode.id		//栏目id
				   	             },
				   	          	cols : setting2
				   	         })
	                    }else if(treeNode.type == 2){
	                    	tableIns.reload({
				   	             page: {
				   	                 curr: 1 //重新从第 1 页开始
				   	             },
				   	             where: {
				   	                 subjectId:treeNode.id		//栏目id
				   	             },
				   	          	cols : setting3
				   	         })
	                    }else{
		                    tableIns.reload({
				   	             page: {
				   	                 curr: 1 //重新从第 1 页开始
				   	             },
				   	             where: {
				   	                 subjectId:treeNode.id		//栏目id
				   	             },
				   	          	cols : setting1
				   	         })
	                    }
	                    return true;
	                }
	            }
	        }
	    };
	    var zNodes;
	    $(document).ready(function () {
	        initNode();
	    });
	    function initNode() {
	        $.ajax({
	            type: 'GET',
	            url: appName + "/cmsSubject/list.do",
	            dataType: "text",
	            success: function (data) {
	                var obj = eval('(' + data + ')');
	                zNodes = obj.data;
	                var t = $("#treeDemo");
	                t = $.fn.zTree.init(t, setting, zNodes);
	                var node = t.getNodes()[0];
	                while (node.children != null) {
	                    node = node.children[0];
	                }
	                t.selectNode(node);
	                $("#subjectId").val(node.id);
	                tableIns = initTable(node.id);
	            }
	        });
	    }
	    
		//用户列表
	    var tableIns;
	    var level = $("#level").val();
		var setting1 = [[
            {type:"numbers", title: '序号'},
            {field: 'titleImageSrc', title: '标题图片',width: 200, align:"center", templet:function(d){
            	if(d.titleImageSrc != undefined && d.titleImageSrc != ''){
	            	return '<img style="max-width:150px;max-height:60px;" src="' + d.titleImageSrc + '">';
            	}else{
            		return "-"
            	}
            }},
            {field: 'title', title: '标题', templet:function(d){
            	return d.title;
            }},
            {field: 'publisher', title: '发布单位'},
            {field: 'createTime', title: '创建时间'},
            {field: 'status', title: '状态',width:100,templet:function(d){
            	if(d.status == '1'){
            		return "<span style='color:#0099ff;'>未提交</span>";
            	}else if(d.status == '2'){
            		return "<span style='color:#0099ff;'>已发布</span>";
            	}else if(d.status == '3'){
            		return "<span style='color:#0099ff;'>待审批</span>";
            	}else if(d.status == '4'){
            		return '<a style="color:red;" href="javascript:sendBack(\''+d.id+'\',\''+d.message+'\');">已驳回</a>';
            	}else {
            		return "-";
            	}
            }},
            {title: '操作',width:240,align:"center",fixed: 'right', style:"height:100px;", templet:function(d){
            	var html = ''; 
            		html += '<a class="layui-btn layui-btn-xs layui-btn-primary"  href="javascript:viewArticle(\''+d.id+'\');" title="预览">预览</a>';
            	if(level == '1'){
            		if(d.status == '1'){
	           			html += '<a class="layui-btn layui-btn-xs"  href="javascript:saveData(\''+d.id+'\');" title="提交审批">提交审批</a>';
	              		html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
	               		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteNotice(\''+d.id+'\');" title="删除">删除</a>';
            		}else if(d.status == '2'){
		            	html += '<a class="layui-btn layui-btn-xs"  href="javascript:stopPublish(\''+d.id+'\');" title="取消发布">取消发布</a>';
            		}else if(d.status == '4'){
						html += '<a class="layui-btn layui-btn-xs"  href="javascript:saveData(\''+d.id+'\');" title="提交审批">提交审批</a>';
	              		html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
	               		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteNotice(\''+d.id+'\');" title="删除">删除</a>';
            		}
            	}else if(level == '2'){
            		if(d.status == '1'){
            			html += '<a class="layui-btn layui-btn-xs"  href="javascript:publish1(\''+d.id+'\');" title="发布">发布</a>';
	              		html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
	               		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteNotice(\''+d.id+'\');" title="删除">删除</a>';
            		}else if(d.status == '2'){
            			if('${orgId}' == d.publisher){
			            	html += '<a class="layui-btn layui-btn-xs"  href="javascript:stopPublish(\''+d.id+'\');" title="取消发布">取消发布</a>';
            			}else{
			            	html += '<a class="layui-btn layui-btn-xs"  href="javascript:saveData1(\''+d.id+'\');" title="取消发布">取消发布</a>';
            			}
            		}else if(d.status == '3'){
	            		html += '<a class="layui-btn layui-btn-xs"  href="javascript:publish(\''+d.id+'\');" title="审批">审批</a>';
            		}
            	}
            	return html;
            }}
        ]];
		
		var setting2 = [[
            {type:"numbers", title: '序号'},
            {field: 'titleImageSrc', title: '专家头像',width: 200, align:"center", templet:function(d){
            	if(d.titleImageSrc != undefined && d.titleImageSrc != ''){
	            	return '<img style="max-width:150px;max-height:60px;" src="' + d.titleImageSrc + '">';
            	}else{
            		return "-"
            	}
            }},
            {field: 'title', title: '专家姓名',templet:function(d){
            	return d.title;
            }},
            {field: 'publisher', title: '发布单位'},
            {field: 'createTime', title: '创建时间'},
            {field: 'status', title: '状态',width:100,templet:function(d){
            	if(d.status == '1'){
            		return "<span style='color:#0099ff;'>未提交</span>";
            	}else if(d.status == '2'){
            		return "<span style='color:#0099ff;'>已发布</span>";
            	}else if(d.status == '3'){
            		return "<span style='color:#0099ff;'>待审批</span>";
            	}else if(d.status == '4'){
            		return '<a style="color:red;" href="javascript:sendBack(\''+d.id+'\',\''+d.message+'\');">已驳回</a>';
            	}else {
            		return "-";
            	}
            }},
            {title: '操作',width:240,align:"center",fixed: 'right', style:"height:100px;", templet:function(d){
            	var html = ''; 
//             		html += '<a class="layui-btn layui-btn-xs"  href="javascript:goView(\''+d.id+'\');" title="详情">详情</a>';
            		html += '<a class="layui-btn layui-btn-xs layui-btn-primary"  href="javascript:viewArticle(\''+d.id+'\');" title="预览">预览</a>';
           		if(level == '1'){
               		if(d.status == '1'){
   	           			html += '<a class="layui-btn layui-btn-xs"  href="javascript:saveData(\''+d.id+'\');" title="提交审批">提交审批</a>';
   	              		html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
   	               		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteNotice(\''+d.id+'\');" title="删除">删除</a>';
               		}else if(d.status == '2'){
   		            	html += '<a class="layui-btn layui-btn-xs"  href="javascript:stopPublish(\''+d.id+'\');" title="取消发布">取消发布</a>';
               		}else if(d.status == '4'){
   						html += '<a class="layui-btn layui-btn-xs"  href="javascript:saveData(\''+d.id+'\');" title="提交审批">提交审批</a>';
   	              		html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
   	               		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteNotice(\''+d.id+'\');" title="删除">删除</a>';
               		}
               	}else if(level == '2'){
               		if(d.status == '1'){
            			html += '<a class="layui-btn layui-btn-xs"  href="javascript:publish1(\''+d.id+'\');" title="发布">发布</a>';
	              		html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
	               		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteNotice(\''+d.id+'\');" title="删除">删除</a>';
            		}else if(d.status == '2'){
            			if('${orgId}' == d.publisher){
			            	html += '<a class="layui-btn layui-btn-xs"  href="javascript:stopPublish(\''+d.id+'\');" title="取消发布">取消发布</a>';
            			}else{
			            	html += '<a class="layui-btn layui-btn-xs"  href="javascript:saveData1(\''+d.id+'\');" title="取消发布">取消发布</a>';
            			}
            		}else if(d.status == '3'){
	            		html += '<a class="layui-btn layui-btn-xs"  href="javascript:publish(\''+d.id+'\');" title="审批">审批</a>';
            		}
               	}
            	return html;
            }}
        ]];
		
		//通知公告，无图
		var setting3 = [[
            {type:"numbers", title: '序号'},
            {field: 'title', title: '标题', templet:function(d){
            	return d.title;
            }},
            {field: 'publisher', title: '发布单位'},
            {field: 'createTime', title: '创建时间'},
            {field: 'status', width:100,title: '状态',templet:function(d){
            	if(d.status == '1'){
            		return "<span style='color:#0099ff;'>未提交</span>";
            	}else if(d.status == '2'){
            		return "<span style='color:#0099ff;'>已发布</span>";
            	}else if(d.status == '3'){
            		return "<span style='color:#0099ff;'>待审批</span>";
            	}else if(d.status == '4'){
            		return '<a style="color:red;" href="javascript:sendBack(\''+d.id+'\',\''+d.message+'\');">已驳回</a>';
            	}else {
            		return "-";
            	}
            }},
            {title: '操作',width:240,align:"center",fixed: 'right', style:"height:100px;", templet:function(d){
            	var html = ''; 
//             		html += '<a class="layui-btn layui-btn-xs"  href="javascript:goView(\''+d.id+'\');" title="详情">详情</a>';
            		html += '<a class="layui-btn layui-btn-xs layui-btn-primary"  href="javascript:viewArticle(\''+d.id+'\');" title="预览">预览</a>';
           		if(level == '1'){
               		if(d.status == '1'){
   	           			html += '<a class="layui-btn layui-btn-xs"  href="javascript:saveData(\''+d.id+'\');" title="提交审批">提交审批</a>';
   	              		html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
   	               		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteNotice(\''+d.id+'\');" title="删除">删除</a>';
               		}else if(d.status == '2'){
   		            	html += '<a class="layui-btn layui-btn-xs"  href="javascript:stopPublish(\''+d.id+'\');" title="取消发布">取消发布</a>';
               		}else if(d.status == '4'){
   						html += '<a class="layui-btn layui-btn-xs"  href="javascript:saveData(\''+d.id+'\');" title="提交审批">提交审批</a>';
   	              		html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
   	               		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteNotice(\''+d.id+'\');" title="删除">删除</a>';
               		}
               	}else if(level == '2'){
               		if(d.status == '1'){
            			html += '<a class="layui-btn layui-btn-xs"  href="javascript:publish1(\''+d.id+'\');" title="发布">发布</a>';
	              		html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
	               		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteNotice(\''+d.id+'\');" title="删除">删除</a>';
            		}else if(d.status == '2'){
            			if('${orgId}' == d.publisher){
			            	html += '<a class="layui-btn layui-btn-xs"  href="javascript:stopPublish(\''+d.id+'\');" title="取消发布">取消发布</a>';
            			}else{
			            	html += '<a class="layui-btn layui-btn-xs"  href="javascript:saveData1(\''+d.id+'\');" title="取消发布">取消发布</a>';
            			}
            		}else if(d.status == '3'){
	            		html += '<a class="layui-btn layui-btn-xs"  href="javascript:publish(\''+d.id+'\');" title="审批">审批</a>';
            		}
               	}
            	return html;
            }}
        ]];
		
	    //初始化表格
	    var initTable = function(subjectId){
	    	return table.render({
		        elem: '#articleList',
		        url : '<%=request.getContextPath() %>/cmsArticel/getListData.do',
		        cellMinWidth : 80,
		        request:{
		        	pageName: 'currentPage',
		        	limitName: 'size'
		        },
		        where:{
		        	subjectId:subjectId		//栏目id
		        },
		        page : true,
		        limits : [10,20,25],
		        limit : 10,
		        id : "articleListTable",
		        cols : setting1
		    });
	    }
		
	    window.viewArticle = function(id){
	    	var zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
		    var node = zTree_Menu.getNodeByParam("id",$("#subjectId").val());
		    var currentType = node.type;
			if(currentType =='1' || currentType =='2'){
				window.open("<%=viewUrl %>/chapterDetail.html?bg="+id);
			}else if(currentType == '3'){
				window.open("<%=viewUrl %>/shukanDetail.html?bg="+id);
			}else if(currentType == '4'){
				window.open("<%=viewUrl %>/xueshuDetail.html?bg="+id);
			}else if(currentType == '5'){
				window.open("<%=viewUrl %>/zhaunjia.html?bg="+id);
			}
		}
	    
	  //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	  $(".search_btn").on("click",function(){
		if($("#key").val() == '' && $("#status").val() == ''){
			layer.msg("请输入筛选条件");
		}  
	    tableIns.reload({
	             page: {
	                 curr: 1 //重新从第 1 页开始
	             },
	             where: {
	                 key: $("#key").val(),  //搜索的关键字
	                 status: $("#status").val(),  //状态
	                 subjectId:$("#subjectId").val()		//栏目id
	             }
	         });
	    });
	  //清空
	  $(".reset").on("click",function(){
		  $(".searchVal").val("");
		  form.render();
	  });
	  //去新增页面
		  window.goAdd = function(){
			  var zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
			  var node = zTree_Menu.getNodeByParam("id",$("#subjectId").val());
			  var currentType = node.type;
			  var width = '90%';
			  var height = '750px';
			  if(currentType == '3'){
				  width = '700px';
				  height = '750px';
			  }
		  	  var subjectId = $("#subjectId").val();
			  var index = layui.layer.open({
			      title : "新增内容",
			      type : 2,
			      content : "<%=request.getContextPath() %>/cmsArticel/goAdd.do?subjectId="+subjectId,
			      area: [width, height],
			      success : function(layero,index,data){
			          var body = layui.layer.getChildFrame('body', index);
			          resizeLayer(index);
			          setTimeout(function(){
			              layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
			                  tips: 3
			              });
			          },500)
			      },
			      yse:function (index, layero) {
			          layer.close(index); //关闭弹层
			      },
			      end :function() {
			    	  tableIns.reload({
				             page: {
				                 curr: 1 //重新从第 1 页开始
				             },
				             where: {
				                 subjectId:$("#subjectId").val()		//栏目id
				             }
				     });
	              }
			  });
			  layui.layer.full(index);
		}
	  //去编辑页面
  		window.goEdit = function(id){
  			var zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
			  var node = zTree_Menu.getNodeByParam("id",$("#subjectId").val());
			  var currentType = node.type;
			  var width = '90%';
			  var height = '750px';
			  if(currentType == '3'){
				  width = '700px';
				  height = '750px';
			  }
		  var index = layui.layer.open({
		      title : "编辑内容",
		      type : 2,
		      content : "<%=request.getContextPath() %>/cmsArticel/goEdit.do?id="+id,
			  area: [width, height],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
			  		//自适应高度
			  		resizeLayer(index);
		            setTimeout(function(){
		                layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
		                    tips: 3
		                });
		            },500)
				},
		      yse:function (index, layero) {
		          layer.close(index); //关闭弹层
		      },
		      end :function() {
		    	  tableIns.reload({
			             page: {
			                 curr: 1 //重新从第 1 页开始
			             },
			             where: {
			                 subjectId:$("#subjectId").val()		//栏目id
			             }
			     });
              }
		  });
		  layui.layer.full(index);
	 }
	  //去预览页面
  		window.goView = function(id){
  			var zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
			  var node = zTree_Menu.getNodeByParam("id",$("#subjectId").val());
			  var currentType = node.type;
			  var width = '90%';
			  var height = '750px';
			  if(currentType == '3'){
				  width = '700px';
				  height = '750px';
			  }
		  var index = layui.layer.open({
		      title : "预览内容",
		      type : 2,
		      content : "<%=request.getContextPath() %>/cmsArticel/goView.do?id="+id,
			  area: [width, height],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
			  		//自适应高度
			  		resizeLayer(index);
		            setTimeout(function(){
		                layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
		                    tips: 3
		                });
		            },500)
				},
		      yse:function (index, layero) {
		          layer.close(index); //关闭弹层
		      },
		      end :function() {
		    	  tableIns.reload({
			             page: {
			                 curr: 1 //重新从第 1 页开始
			             },
			             where: {
			                 subjectId:$("#subjectId").val()		//栏目id
			             }
			     });
              }
		  });
		  layui.layer.full(index);
	 }
		//删除
		window.deleteNotice = function(id){
			layer.confirm("确认要删除吗，删除后不能恢复", { title: "删除确认" }, function (index) {
		      layer.close(index);
		      $.post("<%=request.getContextPath() %>/cmsArticel/removeArticle.do", { id: id }, function (data) {
		          if(data.code == 1){
		          	layer.msg('删除成功');
		          }else{
		          	layer.msg(data.msg);
		          }
		          tableIns.reload();
		      }); 
		  });
		}
		//审核页面
		window.publish = function(id){
			
			var index = layui.layer.open({
			      title : "编辑内容",
			      type : 2,
			      content : "<%=request.getContextPath() %>/cmsArticel/goPublish.do?id="+id+"&type=edit&tableName=cms_article&message=",
				  area: ["700px", "500px"],
				  success : function(layero,index,data1){
				  		var body = layui.layer.getChildFrame('body', index);
				  		//自适应高度
				  		resizeLayer(index);
			            setTimeout(function(){
			                layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
			                    tips: 3
			                });
			            },500)
					},
			      yse:function (index, layero) {
			          layer.close(index); //关闭弹层
			      },
			      end :function() {
			    	  tableIns.reload({
				             page: {
				                 curr: 1 //重新从第 1 页开始
				             },
				             where: {
				                 subjectId:$("#subjectId").val()		//栏目id
				             }
				     });
	              }
			  });
		}
		
		//驳回详情
		window.sendBack = function(id,message){
			debugger
			var index = layui.layer.open({
			      title : "编辑内容",
			      type : 2,
			      content : "<%=request.getContextPath() %>/cmsArticel/goPublish.do?id="+id+"&type=view&message="+message,
				  area: ["700px", "500px"],
				  success : function(layero,index,data1){
				  		var body = layui.layer.getChildFrame('body', index);
				  		//自适应高度
				  		resizeLayer(index);
			            setTimeout(function(){
			                layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
			                    tips: 3
			                });
			            },500)
					},
			      yse:function (index, layero) {
			          layer.close(index); //关闭弹层
			      },
			      end :function() {
			    	  tableIns.reload({
				             page: {
				                 curr: 1 //重新从第 1 页开始
				             },
				             where: {
				                 subjectId:$("#subjectId").val()		//栏目id
				             }
				     });
	              }
			  });
		}
		
		//取消发布
		window.stopPublish = function(id){
			layer.confirm("确认要取消发布吗11？", { title: "取消发布确认" }, function (index) {
		      layer.close(index);
		      $.post("<%=request.getContextPath() %>/cmsArticel/stopArticle.do", { id: id }, function (data) {
		          if(data.code == 1){
		          	layer.msg('取消成功');
		          }else{
		          	layer.msg(data.msg);
		          }
		          tableIns.reload();
		      }); 
		  });
		}
		
		//提交审核
		window.saveData = function(id){
			layer.confirm("确认要提交审批吗？", { title: "提交审批确认" }, function (index) {
		      layer.close(index);
		      //var sql = "update cms_article set status = '3', modify_time = "+updateTime+ "  where id= "+id;
		      $.post("<%=request.getContextPath() %>/cmsArticel/saveData.do", { 'id': id,'tableName':'cms_article'}, function (data) {
		          if(data.code == 1){
		          	layer.msg('提交成功');
		          }else{
		          	layer.msg(data.msg);
		          }
		          tableIns.reload();
		      }); 
		  });
		}
		//提交审核
		window.saveData1 = function(id){
			layer.confirm("确认要取消发布吗？", { title: "取消发布确认" }, function (index) {
		      layer.close(index);
		      //var sql = "update cms_article set status = '3', modify_time = "+updateTime+ "  where id= "+id;
		      $.post("<%=request.getContextPath() %>/cmsArticel/saveData.do", { 'id': id,'tableName':'cms_article'}, function (data) {
		          if(data.code == 1){
		          	layer.msg('取消成功');
		          }else{
		          	layer.msg(data.msg);
		          }
		          tableIns.reload();
		      }); 
		  });
		}
		//提交审核
		window.publish1 = function(id){
			layer.confirm("确认要发布吗？", { title: "发布确认" }, function (index) {
		      layer.close(index);
		      $.post("<%=request.getContextPath() %>/cmsArticel/shenPi.do", 
		    		  { 'tableName':'cms_article','result':'1','message':'','id':id }, function (data) {
		          if(data.code == 1){
		          	layer.msg('发布成功');
		          }else{
		          	layer.msg(data.msg);
		          }
		          tableIns.reload();
		      }); 
		  });
		}
		
	});
	//时间戳转时间格式
	function timestampToTime(timestamp) {
		console.log(timestamp);
	    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
	    Y = date.getFullYear() + '-';
	    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	    D = (date.getDate() < 10 ? '0'+(date.getDate()) : date.getDate()) + ' ';
	    h = date.getHours() + ':';
	    m = date.getMinutes() + ':';
	    s = date.getSeconds();
	    return Y+M+D;
	}
	
	//格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
});


</script>
</body>
</html>