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
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/public/public.css" media="all" />
<!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
	<title>文物分类</title>
	<style>
        .a1{
            width: 150px;
        }
		.inputHead{
			width: 290px;
		}
    </style>
</head>
<body class="childrenBody" style="overflow-y: scroll;">
<form class="layui-form">
    <blockquote class="layui-elem-quote quoteBox">
        <form  class="layui-form" id="formSearch" method="post"> 
            <div class="layui-inline">
				<div class="layui-input-inline" >
			    	<input type="text" id="typeNameId"  placeholder="输入名称关键字搜索" autocomplete="off" class="layui-input inputHead">
			    </div>
			    
			    <button class="layui-btn addNews_btn" type="button"  id="addUser">新增</button>
            </div>   
        </form>
    </blockquote>
    <table id="legalTypeList" lay-filter="legalTypeList" lay-data="{id: 'legalTypeListTable'}" ></table>
        <!--操作-->
    <script type="text/html" id="legalTypeListBar">
		<a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
        <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
    </script>
    <br>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/gov/legalTypeList.js"></script>
 
</body>
</html>