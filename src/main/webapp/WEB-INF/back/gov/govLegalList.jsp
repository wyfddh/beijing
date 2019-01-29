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
<!--/meta 作为公共模版分离出去-->
	<title>法律法规</title>
	<style>
        .a1{
            width: 150px;
        }
		.inputHead{
			width: 290px;
		}
    </style>
</head>
<body class="childrenBody">
<script type="text/javascript">
	map = ${btn};
</script>
<form class="layui-form">
    <blockquote class="layui-elem-quote quoteBox">
        <form  class="layui-form" id="formSearch" method="post"> 
            <div class="layui-inline">
				<div class="layui-input-inline" >
			    	<input type="text" id="title" placeholder="输入标题关键字搜索" autocomplete="off" class="layui-input inputHead" value="${userName }">
			    </div>
			    <div class="layui-input-inline " >
			      <select id="firstKind"  lay-search class="inputHead" lay-filter="firstKind">  
			        <option value="">一级分类</option>  
			      </select>
			    </div>
			    <div class="layui-input-inline ">
			      <select id="secondKind"  lay-search class="inputHead" lay-filter="secondKind">  
			        <option value="">二级分类</option>  
			      </select>
			    </div>
			    <div class="layui-input-inline" >
			    	<input type="text" id="dateRange" placeholder="发布日期范围" autocomplete="off" class="layui-input inputHead" value="${dateRange }">
			    </div>
			    <div class="layui-input-inline ">
			      <select lay-search class="inputHead" id="publisher" lay-filter="publisher">   
			        <option value="">发布单位</option>  
			      </select>
			    </div>
		        <button class="layui-btn" type="button"  id="searchBtn">搜索</button>
		        <button type="reset" id="resetBtn1"  class="layui-btn layui-btn-primary">重置</button> 
		        <c:if test="${sessionScope.btn.add eq 1}">
			        <button class="layui-btn addNews_btn" type="button"  id="addUser">发布</button>
		        </c:if>
            </div>   
        </form>
    </blockquote>
    <table id="legalList" lay-filter="legalList"></table>
        <!--操作-->
    <script type="text/html" id="legalListBar">
		<c:if test="${sessionScope.btn.edit eq 1}">
        	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		</c:if>
		<!--
		<c:if test="${sessionScope.btn.show eq 1}">
        	<a class="layui-btn layui-btn-xs layui-btn-primary" lay-event="show">查看</a>
		</c:if>
		-->
		<c:if test="${sessionScope.btn.del eq 1}">
			 <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
		</c:if>
    </script>
    <br>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/gov/legalList.js"></script>

</body>
</html>