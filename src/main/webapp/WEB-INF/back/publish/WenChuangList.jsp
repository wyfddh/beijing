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
    <!--/meta 作为公共模版分离出去-->
    <style type="text/css">
        .laytable-cell-1-imgUrl{  /*最后的pic为字段的field*/
	      height: 100%;
	    }
	    .layui-icon{
	    	margin-right: 0px !important;
	    }
    </style>
    <title>文创产品-列表</title>
</head>
<body class="childrenBody">
<form class="layui-form" id="roleForm">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
        <input type="hidden" id="level" name="level" value="${level}">
            <div class="layui-inline">
            	<div class="layui-input-inline">
            		<input class="layui-input inputText" placeholder="产品编号/产品名称" type="text" id="key" name="key">
            	</div>
            	<div class="layui-input-inline">
            		<input class="layui-input inputText" placeholder="开始价格" type="text" id="staPrice" name="staPrice" style="width: 100px;display: inline-block;" onkeyup="this.value=this.value.replace(/[^\d]/g,'') ">
            		&nbsp;&nbsp;-&nbsp;&nbsp;
            		<input class="layui-input inputText" placeholder="结束价格" type="text" id="overPrice" name="overPrice" style="width: 100px;display: inline-block;" onkeyup="this.value=this.value.replace(/[^\d]/g,'') ">
            	</div>
            	<div class="layui-input-inline" style="width: 100px;">
	            	<select class="layui-select" name="publish" id="publish">
	            		<option value="">发布状态</option>
						<option value="0">未发布</option>
						<option value="1">已发布</option>
					</select>
            	</div>
            	<div class="layui-input-inline" style="width: 100px;">
	            	<select class="layui-select" name="categoryId" id="categoryId" >
	            		<option value="">文创类别</option>
					<c:forEach items="${categoryList }" var="list">
						<option value="${list.id }">${list.categoryName }</option>
					</c:forEach>
					</select>
            	</div>
            	<div class="layui-input-inline" >
	            	<select class="layui-select" name="categoryId" id="categoryId">
	            		<option value="">所属博物馆</option>
					<c:forEach items="${orgList }" var="list">
						<option value="${list.id }">${list.name }</option>
					</c:forEach>
					</select>
            	</div>
            	<div class="layui-input-inline" >
	                <button class="layui-btn search_btn" type="button">搜索</button>
	                <c:if test="${sessionScope.btn.add == 1 }">
		                <a class="layui-btn addNews_btn" onclick="goAdd()">新增</a>
	            	</c:if>
               </div>
            </div>

           <%--  <div style="margin-top:10px" class="layui-inline a2">
            	<c:if test="${sessionScope.btn.add == 1 }">
	                <a class="layui-btn addNews_btn" onclick="goAdd()">新增</a>
            	</c:if>
            </div> --%>
        </form>
    </blockquote>
    <table id="noticeList" lay-filter="noticeList"></table>
    
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript">
$(function(){
	layui.use(['form','layer','table', 'laydate'],function(){
		var form = layui.form,
	    layer = parent.layer === undefined ? layui.layer : top.layer,
	    $ = layui.jquery,
	    table = layui.table,
		laydate = layui.laydate;
		var level = $("#level").val();
		//用户列表
	    var tableIns = table.render({
	        elem: '#noticeList',
	        url : '<%=request.getContextPath() %>/wenChuang/getListData.do',
	        cellMinWidth : 80,
	        request:{
	        	pageName: 'currentPage',
	        	limitName: 'size'
	        },
	        page : true,
	        limits : [10,20,25],
	        limit : 10,
	        id : "noticeListTable",
	        cols : [[
	            {type:"numbers", title: '序号',align:"center"},
	            {field: 'productNumber', title: '产品编号'},
	            {field: 'productName', title: '产品名称'},
	            {field: 'categoryName', title: '产品类别'},
	            {field: 'productPrice', title: '产品价格（元）'},
	            {field: 'publish', title: '发布状态', templet:function(d){
	            	
	            	if(d.publish == '0'){
		          		return "<span style='color:#0099ff;'>未提交</span>";
		          	}else if(d.publish == '1'){
		          		return "<span style='color:#0099ff;'>已发布</span>";
		          	}else if(d.publish == '3'){
		          		return "<span style='color:#0099ff;'>待审批</span>";
		          	}else if(d.publish == '4'){
		          		return '<a style="color:red;" href="javascript:sendBack(\''+d.id+'\',\''+d.message+'\');">已驳回</a>';
		          	}else {
		          		return "-";
		          	}
	            }},
	            {field: 'nickName', title: '发布人'},
	            {field: 'publishTime', title: '发布时间', templet:function(d){
	            	if(d.publish == '1'){
	            		return timestampToTime(d.publishTime);
	            	}else{
	            		return "-";
	            	}
	            }},
	            {title: '操作',align:"center",fixed: 'right',width:240,templet:function(d){
	            	var html = ''; 
	           			html += '<a class="layui-btn layui-btn-xs layui-btn-primary"  href="javascript:view(\''+d.id+'\');"  title="预览">预览</a>';
	           		if(level == '1'){
		        	  	if(d.publish=='0' || d.publish == '4'){
	        		  		html += '<a class="layui-btn layui-btn-xs"  href="javascript:saveData(\''+d.id+'\');" title="提交审批">提交审批</a>';
	        		  		html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
	             			html += '<a class="layui-btn layui-btn-danger layui-btn-xs"  href="javascript:deleteLink(\''+d.id+'\');" title="删除">删除</a>';
		            	}else if(d.publish=='1'){
		        	  		html += '<a class="layui-btn layui-btn-xs"  href="javascript:publishBack(\''+d.id+'\');" title="取消发布">取消发布</a>';
	            		}else if(d.publish=='3'){
	             			html += '<a class="layui-btn layui-btn-danger layui-btn-xs"  href="javascript:deleteLink(\''+d.id+'\');" title="删除">删除</a>';
	            		}
	           		}else if(level == '2'){
	           			if(d.publish=='0' || d.publish == '4'){
	        		  		html += '<a class="layui-btn layui-btn-xs"  href="javascript:publish1(\''+d.id+'\');" title="发布">发布</a>';
	        		  		html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
	             			html += '<a class="layui-btn layui-btn-danger layui-btn-xs"  href="javascript:deleteLink(\''+d.id+'\');" title="删除">删除</a>';
		            	}else if(d.publish=='1'){
		            		if('${orgId}' == d.orgId){
			        	  		html += '<a class="layui-btn layui-btn-xs"  href="javascript:publishBack(\''+d.id+'\');" title="取消发布">取消发布</a>';
		            		}else{
			        	  		html += '<a class="layui-btn layui-btn-xs"  href="javascript:saveData1(\''+d.id+'\');" title="取消发布">取消发布</a>';
		            		}
	            		}else if(d.publish=='3'){
		            		html += '<a class="layui-btn layui-btn-xs"  href="javascript:publish(\''+d.id+'\');" title="审批">审批</a>';
	            		}
	           		}
	            	return html;
	            }}
	        ]]
	    });
		
	  //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	  $(".search_btn").on("click",function(){
		if($("#key").val() == '' && $("#staPrice").val() == '' && $("#overPrice").val() == '' && $("#publish").val() == '' && $("#categoryId").val() == '' && $("#orgId").val() == ''){
			layer.msg("请输入筛选条件");
		}  
	    tableIns.reload({
	             page: {
	                 curr: 1 //重新从第 1 页开始
	             },
	             where: {
	                 key: $("#key").val(),  //搜索的关键字
	                 staPrice: $("#staPrice").val(),  //时间范围
	                 overPrice: $("#overPrice").val(),  //时间范围
	                 publish: $("#publish").val(),  //状态
	                 categoryId: $("#categoryId").val(),  //类别
	                 orgId: $("#orgId").val()  //机构
	             }
	         })
	    });
	  //去新增页面
		  window.goAdd = function(){
			  var index = layui.layer.open({
			      title : "新增文创产品",
			      type : 2,
			      content : "<%=request.getContextPath() %>/wenChuang/goAdd.do",
			      area: ['700px', '750px'],
			      success : function(layero,index,data){
			          var body = layui.layer.getChildFrame('body', index);
					  //自适应高度
				  	  resizeLayer(index);
			          setTimeout(function(){
			              layui.layer.tips('点击此处返回文创产品列表', '.layui-layer-setwin .layui-layer-close', {
			                  tips: 3
			              });
			          },500)
			      },
			      yse:function (index, layero) {
			          layer.close(index); //关闭弹层
			      },
			      end :function() {
	            		tableIns.reload();
	              }
			  });
			  layui.layer.full(index);
		       window.sessionStorage.setItem("index",index);
		}
	  //去编辑页面
  		window.goEdit = function(id){
		  var index = layui.layer.open({
		      title : "编辑文创产品",
		      type : 2,
		      content : "<%=request.getContextPath() %>/wenChuang/goEdit.do?id="+id,
		      area: ['700px', '750px'],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
// 		       		body.find("#id").val(data.data.notice.id);  //id
					//自适应高度
				  	  resizeLayer(index);
		            setTimeout(function(){
		                layui.layer.tips('点击此处返回文创产品列表', '.layui-layer-setwin .layui-layer-close', {
		                    tips: 3
		                });
		            },500)
				},
		      yse:function (index, layero) {
		          layer.close(index); //关闭弹层
		      },
		      end :function() {
            		tableIns.reload();
              }
		  });
		  layui.layer.full(index);
	        window.sessionStorage.setItem("index",index);
	 }
		//删除
		window.deleteLink = function(id){
			layer.confirm("确认要删除吗，删除后不能恢复", { title: "删除确认" }, function (index) {
		      layer.close(index);
		      $.post("<%=request.getContextPath() %>/wenChuang/delete.do", { id: id }, function (data) {
		          if(data.code == 1){
		          	layer.msg('删除成功');
		          }else if(data.code == 0){
		          	layer.msg(data.msg);
		          }
		          tableIns.reload();
		      }); 
		  });
		}
		//预览
		window.view = function(id){
			window.open("<%=webIp %>/html/createDetail.html?bg="+id);
		}
		
		window.publish=function(id){
			
			var index = layui.layer.open({
			      title : "编辑内容",
			      type : 2,
			      content : "<%=request.getContextPath() %>/cmsArticel/goPublish.do?id="+id+"&type=edit&tableName=mip_wenchuang&message=",
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
			    	  tableIns.reload();
		           }
			  });
			
		}

		 window.publishBack=function(id){
			layer.confirm("确认要取消发布吗", { title: "取消发布确认" }, function (index) {
			      layer.close(index);
			      updatePublish(id);
			  });
		}
		//提交审核
		window.saveData=function(id){
			layer.confirm("确认要提交审批吗？", { title: "提交审批确认" }, function (index) {
		      layer.close(index);
		      //var sql = "update mip_wenchuang set publish = 3  where id= "+"'"+id+"'";
		      $.post("<%=request.getContextPath() %>/cmsArticel/saveData.do", { 'id': id,'tableName':'mip_wenchuang'}, function (data) {
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
		window.saveData1=function(id){
			layer.confirm("确认要取消发布吗？", { title: "取消发布确认" }, function (index) {
		      layer.close(index);
		      //var sql = "update mip_wenchuang set publish = 3  where id= "+"'"+id+"'";
		      $.post("<%=request.getContextPath() %>/cmsArticel/saveData.do", { 'id': id,'tableName':'mip_wenchuang'}, function (data) {
		          if(data.code == 1){
		          	layer.msg('取消成功');
		          }else{
		          	layer.msg(data.msg);
		          }
		          tableIns.reload();
		      }); 
		  });
		}

		//驳回详情
		window.sendBack=function(id,message){   
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
					},
			      yse:function (index, layero) {
			          layer.close(index); //关闭弹层
			      },
			      end :function() {
			    	  tableIns.reload();
		          }
			  });
		}
		
		//提交审核
		window.publish1 = function(id){
			layer.confirm("确认要发布吗？", { title: "发布确认" }, function (index) {
		      layer.close(index);
		      $.post("<%=request.getContextPath() %>/cmsArticel/shenPi.do", 
		    		  { 'tableName':'mip_wenchuang','result':'1','message':'','id':id }, function (data) {
		          if(data.code == 1){
		          	layer.msg('发布成功');
		          }else{
		          	layer.msg(data.msg);
		          }
		          tableIns.reload();
		      }); 
		  });
		}
		
		
		//发布获取取消发布
		function updatePublish(id){
			$.post("<%=request.getContextPath() %>/wenChuang/updatePublish.do", { id: id }, function (data) {
		          if(data.code == 1){
		          	layer.msg('操作成功');
		          }else if(data.code == 0){
		          	layer.msg(data.msg);
		          }
		          tableIns.reload();
		      }); 
		}
		
	});
	//时间戳转时间格式
	function timestampToTime(obj) {
		var date =  new Date(obj*1000);
	    var y = 1900+date.getYear();
	    var m = "0"+(date.getMonth()+1);
	    var d = "0"+date.getDate();
	    var h = date.getHours() + ':';
	    var mi = date.getMinutes();
	    var s = date.getSeconds();
	    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
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