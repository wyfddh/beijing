<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
        .text-c th{
      		text-align:center;
      	}
      	.hidden{
      	display:none;
      	}
    </style>
    <title>修改记录-列表</title>
</head>
<body class="childrenBody">
<form class="layui-form" id="roleForm">
    <blockquote class="layui-elem-quote layui-hide" id="gsjz">馆舍建筑</blockquote>
    <blockquote class="layui-elem-quote layui-hide" id="shfw">社会服务</blockquote>
    <table id="recordList" lay-filter="recordList"></table>
    <blockquote class="layui-elem-quote layui-hide" id="jbcl">基本陈列</blockquote>
    <table id="displayList" lay-filter="displayList"></table>
    <blockquote class="layui-elem-quote layui-hide" id="jcss">基础设施</blockquote>
    <table id="buildList"  lay-filter="buildList"></table>

    <blockquote class="layui-elem-quote layui-hide" id="warehouse">库房信息</blockquote>
    <table id="warehouseList"  lay-filter="warehouseList"></table>

    <blockquote class="layui-elem-quote layui-hide" id="showroom">展厅信息</blockquote>
    <table id="showroomList"  lay-filter="showroomList"></table>
    <blockquote class="layui-elem-quote layui-hide" id="relicsUnit">基本信息</blockquote>
    <table id="relicsUnitList"  lay-filter="relicsUnitList"></table>
    <blockquote class="layui-elem-quote layui-hide" id="relicsBureau">基本信息</blockquote>
    <table id="relicsBureauList"  lay-filter="relicsBureauList"></table>
    <blockquote class="layui-elem-quote layui-hide" id="relicsBureauPersonChange">专职技术人员变动情况</blockquote>
    <table id="relicsBureauPersonList"  lay-filter="relicsBureauPersonChangeList"></table>
    <blockquote class="layui-elem-quote layui-hide" id="relicsBureauPersonDetail">专职技术人员详情</blockquote>
    <table id="relicsBureauPersonList"  lay-filter="relicsBureauPersonDetailList"></table>
    <input type="hidden" id="museumId" name="museumId" value="${museumId }">
    <input type="hidden" id="recordType" name="recordType" value="${recordType }">
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/museum/js/showRecordList.js"></script>
<script type="text/javascript">

</script>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="show" >查看</a>
</script>
</body>
</html>