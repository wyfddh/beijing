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
	<title>添加用户</title>
	<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/public/public.css" media="all" />

<style type="text/css">
	form:after{
		display:block;
		content:'';
		clear:both;
	}
</style>
</head>

<body class="childrenBody">
 
<form class="layui-form" style="width:80%;"  method="post" id="form">
	<!-- 解决360浏览器自动填充账号密码输入框 -->
	<input type="text" id="aaa" style="visibility: hidden;" />   
　　	<input type="password" id="aba" style="visibility: hidden;" />
	
	<input type="hidden" id="orgId11">
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label"><font color="red">*&nbsp;</font>姓名</label>
		<div class="layui-input-block">
			<input type="text" name="name" id="editName" required  lay-verify="required"  autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label"><font color="red">*&nbsp;</font>所属组织</label>
		<div class="layui-input-block">
	      <select name="orgId" id="editOrg" lay-verify="required" lay-search lay-filter="orgSelect">
	        <option value=""></option> 
    		<c:forEach items="${orgList}" var="org" varStatus="row">
				<option value="${org.id}" >${org.name}</option>
			</c:forEach>
	      </select>
	    </div>
	</div>
	
	<div class="layui-form-item layui-row layui-col-xs12" id="phonediv">
		<label class="layui-form-label"><font color="red">*&nbsp;</font>登录手机号</label>
		<div class="layui-input-block">
			<input type="text" name="phone" id="editPhone"  lay-verify="required|num"  autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12 hide" id="phonehidediv">
		<label class="layui-form-label">登录手机号</label>
		<div class="layui-input-block">
			<input type="text" id="phonehide" readonly="readonly" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">邮箱</label>
		<div class="layui-input-block">
			<input type="text" name="email" id="editEmail" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12" >
		<label class="layui-form-label"><font color="red">*&nbsp;</font>密码</label>
		<div class="layui-input-block">
			<input type="password" name="password" id="password"  lay-verify="required|pass"  autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12" id="repassdiv">
		<label class="layui-form-label"><font color="red">*&nbsp;</font>确认密码</label>
		<div class="layui-input-block">
			<input type="password"  id="repassword"  lay-verify="required|repass"  autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12 hide" id="roleDiv">
		<label class="layui-form-label"><font color="red">*&nbsp;</font>角色</label>
		<div class="layui-input-block" id="roles">
	 
	    </div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">账户状态</label>
		<div class="layui-input-block">
	        <input type="checkbox" name="status" id="editStatus" lay-skin="switch" lay-text="启用|停用" value="1"> 
	        <input type="text" class="hide" id="statusHide">
	    </div>
	</div>
	<input type="text" id="type" name="type" value="1" class="hide">
	
	<input type="text" id="id" name="userId" class="hide">
	
	<div class="layui-form-item layui-row layui-col-xs12">
		<div class="layui-input-block">
			<button class="layui-btn layui-btn-sm" lay-submit lay-filter="addUser">确定</button>
			<button type="reset" id="reset" class="layui-btn layui-btn-sm layui-btn-primary">重置</button>
		</div>
	</div>
</form> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/authority/userAdd.js"></script>

</body>
</html>