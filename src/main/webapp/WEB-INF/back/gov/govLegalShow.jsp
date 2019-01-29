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
	<title>查看</title>
	<style>
        .a1{
            width: 150px;
        }
		.inputHead{
			width: 290px;
		}
		#title{
			text-align: center;
			font-size: 18px;
			font-weight: bold;
		}
		.f-r {
			float: right;
		}
		.downLoad {
	        position: absolute;
	        top: 3px;
	        right: 15px;
    	}
    </style>
</head>
                    
<body class="childrenBody" style="overflow-y: scroll;">
<form class="layui-form">
        <div id="title">${govInfo.title }</div><br><br>
        <div id="leftDiv" class="layui-inline">
        	分类：&nbsp;&nbsp;&nbsp;&nbsp;<span id="firstKind">${govInfo.firstKindName }</span>&nbsp;&nbsp;/&nbsp;&nbsp;<span id="secondKind">${govInfo.secondKindName }</span>
        </div>
        <div id="rightDiv" class="layui-inline f-r">
        	<span id="publisher">${govInfo.publisher }</span>&nbsp;&nbsp;/&nbsp;&nbsp;<span id="publishYear">${govInfo.publishYear }</span>年&nbsp;&nbsp;/&nbsp;&nbsp;<span id="code">${govInfo.code }</span>号
        </div>
        <div id="area">${govInfo.content }</div>
        <c:if test="${not empty govInfo.realFileName && govInfo.realFileName ne null}">
	        <div id="file">
	        	<div>附件</div>
	        	<input type="text" id="hideUrl" class="layui-hide" value="${govInfo.resultPath }">
	        	<div style="width:250px;height: 35px;position:relative">
					<img src="<%=request.getContextPath() %>/back/images/upload1.png" >
					<div style="width:180px;position:absolute;top: 8px;left: 35px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis; " id="divtext">
						${govInfo.realFileName }
					</div>
			        <a href="#" onclick="downFile()" id="downFile">
			            <img src="<%=request.getContextPath() %>/back/images/downloadx.png" class="downLoad" />
			        </a>
				</div>
	        </div>
        </c:if>
    <br>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>

<script type="text/javascript">

function downFile() {
	var hideUrl = $("#hideUrl").val();
	var fileName = $("#divtext").text();
	window.location.href='<%=request.getContextPath() %>/attach/downFile.do?path=' + hideUrl + '&fileName=' + fileName;
}

</script>
 
</body>
</html>