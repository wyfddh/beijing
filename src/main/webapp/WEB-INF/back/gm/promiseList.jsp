<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--  <%@ page import="com.tj720.mip.utils.HasAuth" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico">
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="back/lib/html5.js"></script>
<script type="text/javascript" src="back/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
	<link href="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
	.Hui-article-box{
		position: absolute;
		left:0
	}

</style>


<title>申报记录</title>
</head>
<body>
	<header id="head"></header>
	<%@ include file="../organization/gmheadbtn.jsp"%> 
	
	<section class="Hui-article-box">
	
		<div class="four steps">
		  <span class="step" style="width: 16%">开始申报</span>
		  <span class="active step" style="width: 16%">承诺书</span>
		  <span class="disabled step" style="width: 16%">信息登记</span>
		  <span class="disabled step" style="width: 16%">附件上传</span>
		  <span class="disabled step" style="width: 16%">总分自评</span>
		  <span class="disabled step" style="width: 16%">已提交</span>
		</div>
		
		<form>
			
		</form>

		<h4 class="text-c" style="font-size: 23px;margin-top:10px;">${newYears }年度${name }绩效考评申报</h4>
		
		<div  style="width: 50%;margin:40px auto;">
			<div class="text-c" style="color:#fff;background-color:#3bb4f2; border-color:#3bb4f2;height: 40px">
				<span style="font-size: 24px">承诺书</span>
			</div>
			<div style="width: 85%;margin: 0 auto;">
				<span style="font-size: 21px">我博物馆郑重承诺：<br><br>

				1、全面填写申请报告的各项数据，此次报送的绩效考评所有材料均真实无误、无虚报情况，并对其真实性负责，承担因材料不实而引发的全部责任和后果。<br><br>

				2、同意专家对本次绩效考评的评审结论，如有异议，服从我市绩效考评部门的最终裁决。<br><br><br><br>
				
				
				<div class="text-r">${name }</div>
				<br><br>
				<form action="/admin/registerInfo/reportForm.do" method="post" id="form">
					<input type="text" value="${newYears}" name="years" class="hide">
				</form>
				<div id="btn" class="f-r">
					<input class="btn btn-default radius " id="btn-left" type="button" value="不同意" style="width: 80px" onclick="history.go(-1)">
					<input class="btn btn-default radius " id="btn-right" type="button" value="同意(10)" style="width: 80px">
				</div>
				</span>
			</div>
		
		</div>
		
		
	</section>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>	
	
	<script type="text/javascript">

    var delay = 11;
	timeDown();    
    function timeDown() { 
 		var t = setTimeout("timeDown()", 1000);
        if (delay > 0) {
            delay--;
            $("#btn-right").val("同意(" + delay + ")");
        } else {
     		clearTimeout(t); 
     		$("#btn-right").val("同意");
     		$("#btn-right").css({"background":"#3bb4f2"});
        }        
    } 
	$(document).ready(function(){
		$("#btn-right").click(function() {
			if ($("#btn-right").val() == "同意")	{
				$("#form").submit();
				
			}
		})
		
		$(".headerNav a.report").addClass("active");
		$(".fabu-aside>ul>li").eq(4).addClass("weihu");   
	})
	</script>
		
</body>
</html>
