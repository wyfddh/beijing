<%@page import="org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%-- <%@page import="com.tj720.mip.springbeans.Config"%> --%>
<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String currentIp = "http://test.tj720.com";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script>
var html = document.querySelector('html');
var width = window.innerWidth;
html.style.fontSize = width*20/1920+ 'px';
window.onresize=function(){
	html = document.querySelector('html');
    width = window.innerWidth;
    html.style.fontSize = width*20/1920+ 'px';
}
</script>
<style type="text/css">
	*{
        padding:0;
        margin:0;
    }
	body {
		position:absolute;
        top:0;
        left:0;
        width:100%;
        height:100%;
        background:#ffffff;
        overflow-x:hidden;
        min-width:992px;
        line-height: 18px;
	}
	.divbg{
         background:url("<%=request.getContextPath() %>/login/image/entrbg.png") center center no-repeat!important;
         width:100%;
         height:100%;
         position:relative;
         vertical-align:middle;
     }
     .divclick{
       	position:absolute;
       	z-index:999;
     	width: 1020px;
     	height: 420px;
     	margin: auto;
	    top: 0;
	    left: 0;
	    right: 0;
	    bottom: 0;
     }
     .en01,.en02,.en03,.en04{
     	width: 500px;
		height: 200px;
     	float: left;
     	background:url("<%=request.getContextPath() %>/login/image/entr_floor.png") center center no-repeat!important;
		text-align: center;
     }
     .en04:hover{
		cursor: pointer;
      }
     .en01:hover, .en02:hover, .en03:hover {
     	width: 498px;
		height: 198px;
		cursor: pointer;
     }
     .en01:hover{
     	border: 1px solid #26b5d1;
     }
     .en02:hover{
     	border: 1px solid #f4b03f;
     }
     .en03:hover{
     	border: 1px solid #ec685c;
     }
     .en01,.en03{
     	margin-right: 20px;
     }
     .en01, .en02{
     	margin-bottom: 20px;
     }
     .icon{
     	width: 75px;
     	height: 74px;
     	margin-top: 8%;
     	display: inline-block;
     }
     .icon1{
     	background:url("<%=request.getContextPath() %>/login/image/entr_icon1.png") center center no-repeat!important;
     }
     .icon2{
     	background:url("<%=request.getContextPath() %>/login/image/entr_icon2.png") center center no-repeat!important;
     }
     .icon3{
     	background:url("<%=request.getContextPath() %>/login/image/entr_icon3.png") center center no-repeat!important;
     }
     .font{
     	font-family: Microsoft YaHei;
     	font-size: 24px;
     }
     .font1{
     	color: #26b5d1;
     }
     .font2{
     	color: #f4b03f;
     }
     .font3{
     	color: #ec685c;
     }
     .add{
     	width: 62px;
     	height: 62px;
     	background:url("<%=request.getContextPath() %>/login/image/entr_add.png") center center no-repeat!important;
     	display: inline-block;
     	margin-top: 69px;
     }
     .title{
     	position:absolute;
       	z-index:9999;
     	margin-top: 5rem;
     	background:url("<%=request.getContextPath() %>/login/image/entr_title.png") center center no-repeat!important;
     	transform:scale(0.83);
       	display: inline-block;
       	width: 100%;
       	height: 7rem;
     }

</style>

<title>登录选项</title>
</head>
<body>
	<div class="title"></div>
	<div class="divclick">
		<span class="en01" onclick="link('<%=request.getContextPath() %>/back/oCCollection/info.do?type=1');">
			<span class="icon icon1"></span><br><br>
			<span class="font font1">江西省综合管理与服务平台管理系统</span>
		</span>
		<span class="en02" onclick="link('#');">
			<span class="icon icon2"></span><br><br>
			<span class="font font2">江西省博物馆门户网站管理系统</span>
		</span>
		<span class="en03" onclick="linkOther('<%=currentIp %>/cms/adminLogin.do?phone=${user.phone }&userType=2');">
			<span class="icon icon3"></span><br><br>
			<span class="font font3">江西省文物信息网管理系统</span>
		</span>
		<span class="en04">
			<span class="add"></span>
		</span>
	</div>
	<div class="divbg">
		
	</div>
</body>

<script type="text/javascript">
	function link(url){
		window.location.href=url;
	}
	
	function linkOther(url){
		$.ajax({
			url : url,
			type : "post",
			data :  {},
			dataType : "json",
			async: false,
			success : function(result){
				console.log(result);
				if(result.success == 1){
					console.log(result.other);
					window.location.href = '<%=currentIp %>'+result.others;
				} else {
					alert("信息错误!");
				}
			}
		});
	}
</script>
</html>