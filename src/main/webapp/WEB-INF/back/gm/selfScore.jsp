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
	.inputInfo{
	width:100px;
	height:16px;
	padding:5px;
	border:1px solid #ccc;
	}
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
		  <span class="step step" style="width: 16%">承诺书</span>
		  <span class="step step" style="width: 16%">信息登记</span>
		  <span class="step step" style="width: 16%">附件上传</span>
		  <span class="active step" style="width: 16%">总分自评</span>
		  <span class="disabled step" style="width: 16%">已提交</span>
		</div>
		
		

		<h4 class="text-c" style="font-size: 23px">${registerInfo.reportName }</h4>
		
		<div  style="width: 50%;margin:40px auto;">
			<div class="text-c" style="color:#fff;background-color:#3bb4f2; border-color:#3bb4f2;height: 40px">
				<span style="font-size: 24px">总分自评</span>
			</div>
			<div style="width: 85%;margin: 0 auto;">
				
				<form action="/admin/registerInfo/selfScore.do" method="post" id="form">
					<input type="text" value="${registerInfo.id }" name="id" class="hide">
					<br>
					<span style="font-size: 20px">最终得分：</span>
					<td class=" text-c">
						<input type="text" placeholder="请输入"  name="selfScore" class="inputInfo" value="${registerInfo.selfScore }">
					</td>
				
			
					<br><br>
					<div id="btn" class="f-r">
						<input class="btn btn-default radius " id="btn-left" type="button" value="返回" style="width: 80px" name="${registerInfo.id }" onclick="back(this.name)">
						<input class="btn btn-primary radius " id="btn-right" type="submit" value="提交申报" style="width: 80px">
					</div>
				</form>
				
			</div>
		
		</div>
		
		
	</section>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>	
	
	<script type="text/javascript">
		
	function back(id) {
		window.location.href='/admin/gmReportUpload/form.do?reportId=' + id
	}
	
		$(document).ready(function(){
			
			$("#btn-right").click(function() {
				if(window.confirm('提交后不可更改，您确定要提交吗？')){
	                return true;
	             }else{
	                return false;
	            }
			})
			
			$(".headerNav a.report").addClass("active");
			$(".fabu-aside>ul>li").eq(4).addClass("weihu");  
		})
	</script>
	

	



		


	
		
		
		
	</script>
</body>
</html>
