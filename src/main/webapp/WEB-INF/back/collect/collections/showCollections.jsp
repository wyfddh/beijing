<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<meta name="viewport"
    content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">

<link rel="Bookmark"
    href="<%=request.getContextPath() %>/back/favicon.ico">
<link rel="Shortcut Icon"
    href="<%=request.getContextPath() %>/back/favicon.ico" />

<link rel="stylesheet" type="text/css"
    href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"
    media="all" />
<link rel="stylesheet"
    href="<%=request.getContextPath() %>/back/css/public/public.css"
    media="all" />
    <link href="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
<!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->

<title>查看藏品</title>
<style>

.layui-select-title {
    /* width: 250px; */
}

.laytable-cell-1-cpimg {
    height: 100%;
    max-width: 100%;
    position: relative;
}

.laytable-cell-1-cpimg img {
    max-width: 100%;
    max-height: 100%;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}

.list_category {
    height: 40px;
    overflow: hidden;
}
.shuiyin{
    position: absolute;
    width: 100px;
    top: 50%;
    left:50%;
    transform:translate(-50%,-50%);
}
</style>
</head>
<body class="childrenBody">
         <input type="text" name="id" id="id" value="${id}" class="layui-hide">
       <table id="collectionsList" lay-filter="collectionsList"></table>   
       <script type="text/html" id="cpimg">
                        <a href="{{d.fpic}}" data-lightbox="gallery">
                            <img alt="没有图片" class="bbc" src="{{d.picUrl}}" >
                        </a>
                    </script>  
    <script type="text/javascript"
        src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript"
        src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
  
    <script type="text/javascript"
        src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
    <script type="text/javascript"
        src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>
    <script type="text/javascript"
        src="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
    <script type="text/javascript"
        src="<%=request.getContextPath() %>/back/js/collect/collections/showCollections.js"></script>

</body>
</html>