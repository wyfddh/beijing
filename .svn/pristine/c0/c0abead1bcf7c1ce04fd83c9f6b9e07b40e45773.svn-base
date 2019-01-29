<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
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
.childrenBody{
	padding:20px;
}
.hideInput{
	display: none;
}
.layui-elem-field{
	    	height: -webkit-fill-available;
	    }
</style>
<title>机构人员信息</title>
</head>
<body class="childrenBody">
<div class="layui-col-xs2">
	<fieldset class="layui-elem-field" style="margin-right: 20px;">
		<legend>部门</legend>
		<c:if test="${'1' eq level}">
			<div class="layui-col-xs-offset2" style="padding-top:10px;">
				<a class="layui-btn layui-btn-xs"  href="javascript:addDep();" title="新增">新增</a>
				<a class="layui-btn layui-btn-xs"  href="javascript:editDep();" title="编辑">编辑</a>
				<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteDep();" title="删除">删除</a>
			</div>
		</c:if>
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
	 <form action="<%=request.getContextPath()%>/museumPerson/personList.do" class="layui-form" id="formSearch" method="post">
			<input type="hidden" id="museumId" name="museumId" value="${museumId}">
			<input type="hidden" id="level" name="level" value="${level}">
			<input type="hidden" id="department" name="department" value="${department}">
			<input type="hidden" id="treeName" name="treeName" value="">
			<blockquote class="layui-elem-quote quoteBox">
		            <div class="layui-inline">
						<div class="layui-input-inline" >
					    	<input type="text" id="personName"  name="personName" placeholder="输入姓名/手机号查询" autocomplete="off" class="layui-input inputHead">
					    </div>
				        <button class="layui-btn search_btn" type="button" lay-submit lay-filter="search" id="search">搜索</button> 
				        <c:if test="${'1' eq level}">
					   		 <a class="layui-btn addNews_btn" type="button"  id="btn_add">添加人员</a>
					    </c:if>
					    <a class="layui-btn addNews_btn" type="button"  id="btn_back">返回</a>
		            </div>   
            </blockquote>
			<table id="personList" lay-filter="personList"></table>
    </form>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">

	layui.use(['form','layer','table'],function(){
		var form = layui.form,
	    layer = parent.layer === undefined ? layui.layer : top.layer,
	    $ = layui.jquery,
	    table = layui.table;
	
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
	                    $("#department").val(treeNode.id);
	                    $("#treeName").val(treeNode.name);
	                    tableIns.reload({
			   	             page: {
			   	                 curr: 1 //重新从第 1 页开始
			   	             },
			   	             where: {
			   	            	 museumId:$("#museumId").val(),
			   	            	department:treeNode.id		//栏目id
			   	             },
			   	          	cols : colsList
			   	         })
	                    return true;
	                }
	            }
	        }
	    };
	    var zNodes;
	  //用户列表
	    var tableIns;
	    $(document).ready(function () {
	        initNode();
	    });
	    function initNode() {
	    	var museumId = '${museumId}';
	        $.ajax({
	            type: 'GET',
	            url: appName + "/museumPerson/departTree.do",
	            data:{"museumId":museumId},
	            dataType: "text",
	            success: function (data) {
	                var obj = eval('(' + data + ')');
	                zNodes = obj.data;
	                var t = $("#treeDemo");
	                t = $.fn.zTree.init(t, setting, zNodes);
	                var node = t.getNodes()[0];
	                t.selectNode(node);
	                $("#treeName").val(node.name);
	                $("#department").val(node.id);
	                tableIns = initTable(node.id);
	            }
	        });
	    }
	    
		
		
		var  colsList= [[
		                 {type:"numbers", title: '序号', width:70, align:"center"},
		                 {field: 'name', title: '姓名', align:"center"},
		                 {field: 'phone', title: '手机号', align:"center"},
		                 {field: 'idNumber', title: '身份证号', align:"center"},
		                 {field: 'departmentName', title: '所在部门',width:300, align:"center"},
		                 {field: 'job', title: '职务', align:"center"},
		                 {title: '操作',width:200,align:"center",templet:function(d){
		                 	var html = ''; 
	                		html += '<a class="layui-btn layui-btn-xs"  href="javascript:edit(\''+d.id+'\');" title="编辑">编辑</a>';
	                 		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deletePerson(\''+d.id+'\');" title="删除">删除</a>';
		                 	return html;
		                 }}
		             ]];
	    //初始化表格
	    var initTable = function(department){
	    	var museumId = '${museumId}';
	    	return table.render({
		        elem: '#personList',
		        url : '<%=request.getContextPath() %>/museumPerson/personList.do',
		        cellMinWidth : 80,
		        request:{
		        	pageName: 'currentPage',
		        	limitName: 'size'
		        },
		        where:{
		        	museumId:museumId,
		        	department:department		//部门
		        },
		        page : true,
		        limits : [10,20,25],
		        limit : 10,
		        id : "personListTable",
		        cols :colsList
		    });
	    }
		
	  //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	  $(".search_btn").on("click",function(){
	    tableIns.reload({
	             page: {
	                 curr: 1 //重新从第 1 页开始
	             },
	             where: {
	            	 museumId:$("#museumId").val(),
	            	 personName: $("#personName").val(),  //搜索的关键字
	                 department:$("#department").val()		//栏目id
	             }
	         })
	    });
	  
	  window.edit = function(id){
		  var museumId= $("#museumId").val();
			var index = layui.layer.open({
			      title : "人员情况修改",
			      type : 2,
			      content : '<%=request.getContextPath() %>/museumPerson/personInfo.do?personId='+ id+'&museumId='+museumId,
			      area: ['970px', '800px'],
			      success : function(layero,index,data){
			          var body = layui.layer.getChildFrame('body', index);
			          resizeLayer(index);
			          setTimeout(function(){
			              layui.layer.tips('点击此处返回人员列表', '.layui-layer-setwin .layui-layer-close', {
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
				            	 museumId:$("#museumId").val(),
				            	 department:$("#department").val()		//部门
				             }
				     });
	              }
			  });
		}
		window.deletePerson = function(id){
			//删除
				layer.confirm("确认要删除吗，删除后不能恢复", { title: "删除确认" }, function (index) {
			      layer.close(index);
			      $.post("<%=request.getContextPath() %>/museumPerson/deletePerson.do", { personId: id }, function (data) {
			          if(data.success == 1){
			          	layer.msg('删除成功');
			          }else{
			          	layer.msg(data.data);
			          }
			          tableIns.reload();
			      }); 
			  });
		}
		
		$("#btn_add").click(function() {
			var treeName=$("#treeName").val();
			var department = $("#department").val();
			var museumId = $("#museumId").val();
			if(department ==""){
				layer.msg("请先选择部门");
				return false;
			}
			layer.confirm("确认要在给"+treeName+"新增人员吗？", {  
		        btn: ['确定','取消'] //按钮
		    }, function(index){
		    	layer.close(index);  //关闭弹出层
		        //点击确定之后需要执行的函数
		    	var index = layui.layer.open({
				      title : "人员情况新增",
				      type : 2,
				      content : '<%=request.getContextPath() %>/museumPerson/personInfo.do?museumId='+museumId+'&department='+department,
				      area: ['970px', '800px'],
				      success : function(layero,index,data){
				          var body = layui.layer.getChildFrame('body', index);
				          resizeLayer(index);
				          setTimeout(function(){
				              layui.layer.tips('点击此处返回人员列表', '.layui-layer-setwin .layui-layer-close', {
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
					            	 museumId:$("#museumId").val(),
					            	 department:$("#department").val()		//部门
					             }
					     });
		              }
				  });
		    }, function(index){
		        layer.close(index);  //关闭弹出层
		    });
		});
		
		$("#btn_back").click(function() {
			var museumId = $("#museumId").val();
	        window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+museumId;
		});
		
		//去新增页面
		  window.addDep = function(){
			var museumId= $("#museumId").val();
			  var index = layui.layer.open({
			      title : "新增部门",
			      type : 2,
			      content : "<%=request.getContextPath() %>/museumPerson/addDep.do?museumId="+museumId,
			      area: ['500px', '400px'],
			      success : function(layero,index,data){
			          var body = layui.layer.getChildFrame('body', index);
			        //自适应高度
				  	  //resizeLayer(index);
			          setTimeout(function(){
			              layui.layer.tips('点击此处返回部门列表', '.layui-layer-setwin .layui-layer-close', {
			                  tips: 3
			              });
			          },500)
			      },
			      yse:function (index, layero) {
			          layer.close(index); //关闭弹层
			      },
			      end :function() {
			    	  location.reload();
	              }
			  });
		}
	  //去编辑页面
		window.editDep = function(id){
			var museumId= $("#museumId").val();
		  var index = layui.layer.open({
		      title : "编辑部门",
		      type : 2,
		      content : "<%=request.getContextPath() %>/museumPerson/editDep.do?museumId="+museumId,
		      area: ['500px', '400px'],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
			  	    //自适应高度
				  	//resizeLayer(index);
		            setTimeout(function(){
		            	layui.layer.tips('点击此处返回部门列表', '.layui-layer-setwin .layui-layer-close', {
			                  tips: 3
			              });
		            },500)
				},
		      yse:function (index, layero) {
		          layer.close(index); //关闭弹层
		      },
		      end :function() {
		    	  location.reload();
            }
		  });
	 }
		//删除
		window.deleteDep = function(id){
			var museumId= $("#museumId").val();
			  var index = layui.layer.open({
			      title : "编辑部门",
			      type : 2,
			      content : "<%=request.getContextPath() %>/museumPerson/goDelete.do?museumId="+museumId,
			      area: ['500px', '400px'],
				  success : function(layero,index,data1){
				  		var body = layui.layer.getChildFrame('body', index);
				  	    //自适应高度
					  	//resizeLayer(index);
			            setTimeout(function(){
			            	layui.layer.tips('点击此处返回部门列表', '.layui-layer-setwin .layui-layer-close', {
				                  tips: 3
				              });
			            },500)
					},
			      yse:function (index, layero) {
			          layer.close(index); //关闭弹层
			      },
			      end :function() {
			    	  location.reload();
	            }
			  });
		}
	});
    
</script>
</body>
</html>