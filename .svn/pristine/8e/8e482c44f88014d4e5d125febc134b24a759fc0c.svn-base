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
	<title>修改密码</title>
	<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/public/public.css" media="all" />

</head>
<body class="childrenBody">
 
<form class="layui-form" style="width:80%;"  method="post" id="form">
	<!-- 解决360浏览器自动填充账号密码输入框 -->
	<input type="text" id="aaa" style="visibility: hidden;" />   
　　	<input type="password" id="aba" style="visibility: hidden;" />
	
	<div class="layui-form-item layui-row layui-col-xs12" >
		<label class="layui-form-label">原密码</label>
		<div class="layui-input-block">
			<input type="text"  id="passwordOld"  lay-verify="required|pass"  autocomplete="off" class="layui-input pass">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12" >
		<label class="layui-form-label">新密码</label>
		<div class="layui-input-block">
			<input type="text" name="password" id="password"  lay-verify="required|pass"  autocomplete="off" class="layui-input pass">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12" id="repassdiv">
		<label class="layui-form-label">确认密码</label>
		<div class="layui-input-block">
			<input type="text"  id="repassword"  lay-verify="required|repass"  autocomplete="off" class="layui-input pass">
		</div>
	</div>
	
	<input type="text" id="userId" value="${sessionScope.user.userId }" name="userId" class="layui-hide">
	
	<div class="layui-form-item layui-row layui-col-xs12">
		<div class="layui-input-block">
			<button class="layui-btn layui-btn-sm" lay-submit lay-filter="modifyPassword">确定</button>
			<button type="reset" class="layui-btn layui-btn-sm layui-btn-primary" onclick="relogin();">取消</button>
		</div>
	</div>
</form> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/authority/modifyPassword.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/md5.js"></script>

</body>
</html>