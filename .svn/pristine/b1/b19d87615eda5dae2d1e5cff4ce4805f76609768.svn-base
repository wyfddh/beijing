<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<title>新建消息</title>
	<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/userMangermen/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/userMangermen/css/public.css" media="all" />

</head>
<body class="childrenBody">

<form class="layui-form" style="width:80%;" method="post" id="form">
	<!-- 解决360浏览器自动填充账号密码输入框 -->
	<input type="text" id="aaa" style="visibility: hidden;" />   
　　	<input type="password" id="aba" style="visibility: hidden;" />
	
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">消息标题</label>
		<div class="layui-input-block">
			<input type="text" name="infoTitle" required  lay-verify="required"  autocomplete="off" class="layui-input">
		</div>
	</div>
	
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">消息内容</label>
		<div class="layui-input-block">
			<textarea name="infoContent" placeholder="请输入内容" class="layui-textarea" required lay-verify="required"></textarea>
		</div>
	</div>
	
	<div class="layui-form-item layui-row layui-form" id="div1">
	    <label class="layui-form-label">接收人</label>
	    <div class="layui-input-block">
	      <select name="receiveUserId" id="pid" required lay-verify="required">
	        <option value=""></option>
	      </select>
	    </div>
  	</div>
  	
	<input type="text" id="type1" name="type" value="1" class="hide">
	<div class="layui-form-item layui-row layui-col-xs12">
		<div class="layui-input-block">
			<button class="layui-btn layui-btn-sm" lay-submit lay-filter="addInsideInfo">确定</button>
			<button type="reset" id="reset" class="layui-btn layui-btn-sm layui-btn-primary">重置</button>
		</div>
	</div>
</form> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/userMangermen/layui/layui.js"></script>

<script type="text/javascript">
$(function() {
	
	$(".hide").hide();
	$("#reset").click();
	$.ajax({
		url:"<%=request.getContextPath()%>/insideInfo/getRecUsers.do",
		type:"post",
		success:function(result) {
			if (result.success == 1) {
				var userList = result.data;
				var userStr = "";
				for (var i = 0;i < userList.length;i++) {
					userStr += "<option value='"+userList[i].id+"'>"+userList[i].name+"</option>"
				}
				$("#pid").append(userStr);
				renderForm();
			} else {
				
			}
		}
	})
});

	function renderForm(){
	  layui.use('form', function(){
	   var form = layui.form; 
	   form.render();
	  });
	 }
	
	layui.use(['form','layer'],function(){
	    var form = layui.form
	        layer = parent.layer === undefined ? layui.layer : top.layer,
	        $ = layui.jquery;
	    
	    var pathName=window.document.location.pathname;
	    projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
	    
	    var index = parent.layer.getFrameIndex(window.name);
	 
	    form.on("submit(addInsideInfo)",function(data){
	    	
	    	var data = $("#form").serialize();
	        $.ajax({
	        	type:"post",
	        	data:data,
	        	async:false,
	        	url:projectName + '/insideInfo/save.do', 
	        	success:function(data) {
	        		data=data.data;
	        		if (data == 1) {
	        			top.layer.msg("添加成功！"); 
	        			parent.layer.close(index);
	        			 
	        		} else {
	        			top.layer.msg("系统异常添加失败！");
	        			parent.layer.close(index);
	        		}
	        		 
	        	}, 
	        	error:function(data) {
	        		top.layer.msg("系统异常添加失败！");
	    			parent.layer.close(index);
	        	}
	        })

	      /*  return false; */
	    })

	    //格式化时间
	    function filterTime(val){
	        if(val < 10){
	            return "0" + val;
	        }else{
	            return val;
	        }
	    }
	    //定时发布
	    var time = new Date();
	    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());

	})
	
</script>
</body>
</html>