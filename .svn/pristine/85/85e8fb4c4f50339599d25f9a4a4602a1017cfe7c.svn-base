<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预览表单</title>
<t:base type="jquery,easyui,layer,DatePicker"></t:base>
<link href="designPlug-in/easyui-pli/css/base.css" rel="stylesheet">
  <link rel="stylesheet" href="designPlug-in/template/demo.css">
<script type="text/javascript">
var url_="designController.do?designPreviewHtmlIframe&versionNum=${versionNum}&bussTemplateId=${bussTemplateId}&businessCode=${businessCode }&configformId=${configformId }";

var theme_list_open = false;
$(document).ready(function () {
	function fixHeight() {
		var headerHeight = $("#switcher").height();
		$("#iframe").attr("height", $(window).height()-84 + "px");
	}
	$(window).resize(function () {
		fixHeight();
	}).resize();
	//响应式预览
	$('.icon-monitor').addClass('active');
	$(".icon-mobile-3").click(function () {
		$('#iframe-wrap').removeClass().addClass('mobile-width-3');
		$('.icon-tablet,.icon-mobile-1,.icon-monitor,.icon-mobile-2,.icon-mobile-3').removeClass('active');
		$(this).addClass('active');
		$("#iframe").attr("src", url_);
		return false;
	});

	$(".icon-mobile-2").click(function () {
		$('#iframe-wrap').removeClass().addClass('mobile-width-2');
		$('.icon-tablet,.icon-mobile-1,.icon-monitor,.icon-mobile-2,.icon-mobile-3').removeClass('active');
		$(this).addClass('active');
		$("#iframe").attr("src", url_);
		return false;
	});

	$(".icon-mobile-1").click(function () {
		$('#iframe-wrap').removeClass().addClass('mobile-width');
		$('.icon-tablet,.icon-mobile,.icon-monitor,.icon-mobile-2,.icon-mobile-3').removeClass('active');
		$(this).addClass('active');
		$("#iframe").attr("src", url_);
		return false;
	});

	$(".icon-tablet").click(function () {
		$('#iframe-wrap').removeClass().addClass('tablet-width');
		$('.icon-tablet,.icon-mobile-1,.icon-monitor,.icon-mobile-2,.icon-mobile-3').removeClass('active');
		$(this).addClass('active');
		return false;
	});

	$(".icon-monitor").click(function () {
		$('#iframe-wrap').removeClass().addClass('full-width');
		$('.icon-tablet,.icon-mobile-1,.icon-monitor,.icon-mobile-2,.icon-mobile-3').removeClass('active');
		$(this).addClass('active');
		$("#iframe").attr("src", url_);
		return false;
	});
	$("#iframe").attr("src", url_);
});
</script>
<style type="text/css">
        .grid-stack {
        /*
    background: lightgoldenrodyellow;
    */
}
.grid-stack-item-content {
    color: #2c3e50;
    text-align: center;
    /*
    background-color: #18bc9c;
    */
}
</style>
</head>
<body >
<div id="switcher">
  <div class="center" >
  <div style="text-align: center;margin-left: 45%;">
    <ul>
        <li class="device-monitor"><a href="javascript:"><div class="icon-monitor active"></div></a></li>
        <li class="device-mobile"><a href="javascript:"><div class="icon-tablet"> </div></a></li>
        <li class="device-mobile"><a href="javascript:"><div class="icon-mobile-1"> </div></a></li>
        <li class="device-mobile-2"><a href="javascript:"><div class="icon-mobile-2"> </div></a></li>
        <li class="device-mobile-3"><a href="javascript:"><div class="icon-mobile-3"> </div></a></li>
    </ul>
    </div>
  </div>
</div>
<div id="iframe-wrap" class="full-width">
<iframe id="iframe" src="" frameborder="0" width="100%" height="652px"> </iframe>
    </div>
</body>
</html>		