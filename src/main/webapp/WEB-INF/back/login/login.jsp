<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
 	String hostname = "";
	Properties pro = new Properties(); 
 	String realpath = request.getRealPath("/WEB-INF/classes"); 
 	try{  
 		//读取配置文件
 		FileInputStream in = new FileInputStream(realpath+"/config.properties"); 
 		pro.load(new InputStreamReader(in, "UTF-8")); 
 	}
	catch(FileNotFoundException e){ 
    	 out.println(e); 
 	} 
 	catch(IOException e){
 		out.println(e);
 	} 

	//通过key获取配置文件
	hostname = pro.getProperty("web.hostname"); 
 %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
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
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<title>江西省可移动文物普查数据资源服务平台</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
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
        html,body{
       		font-size:20px;
       }
        body{
            position:absolute;
            top:0;
            left:0;
            width:100%;
            height:100%;
            background:#ffffff;
            overflow-x:hidden;
            min-width:992px;
        }
        .loginWraper{
            background:url("<%=request.getContextPath() %>/login/image/bg.png") center center no-repeat!important;
            width:100%;
            height:100%;
            position:relative;
            vertical-align:middle;
        }
        #bakcLoginForm{
            position:absolute;
            width:374px;
            height:503px;
            background:url("<%=request.getContextPath() %>/login/image/login_panner.png") center center no-repeat!important;
            left:56%;
            top:237px;
        }
        .fz{
            font-size:30px;
        }
        .hov:hover{
            text-decoration: none;
        }
        .msg{
        	display: none;
        }
        .verification_code{
            display: none;
        }
        input{
        	outline:none;
        }
        input:hover{
            border:0px !important;
            outline:none;
        }
        .top{
        	text-align: center;
        	position:fixed;
        	width:100%;
        	z-index:9999;
        }
        .top-img{
       		margin-top: 2.1rem;
        	transform:scale(0.83);
         	display: inline-block;
        }
        .userLogin_cn{
        	width: 94px;
			height: 23px;
			font-family: SourceHanSansCN-Medium;
			font-size: 24px;
        }
        .userLogin_en{
        	width: 56px;
			height: 13px;
			font-family: SourceHanSansCN-Medium;
			font-size: 12px;
        }
        #phone, #password{
        	width: 210px;
        	height: 31px;
        	margin-left: 95px;
        	border: 0px;
        	font-size: 18px !important;
        }
        #verification{
        	background:url("<%=request.getContextPath() %>/login/image/vfc_icon.png") 52px 0px no-repeat!important;
        }
        #verificationCode{
        	width: 95px;
        	height: 31px;
        	margin-top: 30px;
        	margin-left: 95px;
        	border: 0px;
        	font-size: 16px !important;
        }
        #imgCode{
        	width: 92px;
        	height: 40px;
        	margin-left: 230px;
        	margin-top: -36px;
        	border: 1px black solid;
        }
        #login{
        	background:url("<%=request.getContextPath() %>/login/image/login_icon.png") center center no-repeat!important;
        	width: 271px;
			height: 44px;
			border: none;
			cursor: pointer;
        }
        #errorMsg{
        	font-size: 16px !important;
        	text-align: center;
        }
    </style>
</head>
<body>
    <input type="hidden" id="TenantId" name="TenantId" value="" />
    <div class="top">
	    <img alt="" src="<%=request.getContextPath() %>/login/image/login_title.png" class="top-img">
    </div>
    <div class="loginWraper">
            <form id="bakcLoginForm" class="form" method="post">
            	<input name="userType" value="2" hidden="hidden">
            	<input name="isback" value="1" hidden="hidden">
                <div style="margin-top:164px;height: 41px;padding-top: 5px;">
                	<input id="phone" name="phone" type="text" placeholder="请输入您的帐户" value="">
                </div>
                <div style="margin-top:43px;height: 41px;padding-top: 4px;">
                    <input id="password" name="password" type="password" placeholder="请输入您的密码" autocomplete="off" onfocus="" value="">
                </div>
                <!---->
                <div id="bankLine" style="height: 5px;"></div>
                <div class="verification_code" style="margin-top:15px;" id="verification">
                 	<input id="verificationCode" name="verificationCode" type="text" autocomplete="off" placeholder="验证码" required>
                 	<img id="imgCode" src="<%=request.getContextPath() %>/getImgCode.do" onclick="changeimg('imgCode','verificationCode')" title="看不清，换一张">
                </div>
                <div class="clearfix"></div>
                <div id="msg" style="padding-top:10px;">
                    <div id="errorMsg" style="color: red">
							<!-- <i class="Hui-iconfont c-danger">&#xe6e0;</i>&nbsp;登录失败，原因可能是： -->
                    </div>
                </div>
                <div class="clearfix"></div>
                <div style="margin-top:20px;">
                    <div style="text-align: center;">
                        <input name="" id="login" type="button">
                    </div>
                </div>
                <div class="clearfix"></div>
            </form>
        <div class="foot"></div>
    </div>

    <!--<div class="footer">Copyright 你的公司名称 by H-ui.admin.page.v3.0</div>-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
<!-- 登录功能 -->
<script type="text/javascript">
$(function(){

    function toLogin(){
    	var data = $('#bakcLoginForm').serialize();
        var value = $("#verification").css("display");
        if(value != "none" ){
            var text = $("#verificationCode").val();
            if(null == text || text == ""){
                alert("验证码未填写");
                return;
            }
        }
		$.ajax({
			url : "<%=request.getContextPath() %>/frontLogin.do",
			type : "post",
			data :  data,
			dataType : "json",
			success : function(result){
				if(!result.data.sessionAdminName){
					//失败
					$("#verification").removeClass("verification_code");
					$("#msg").removeClass("msg");
					$("#errorMsg").html('<i class="Hui-iconfont c-danger">&#xe6e0;</i>'+'登录失败，原因可能是：'+result.data.tipMessage);
					if(result.data.errorTimes>4){
						$("#login").attr("disabled",true).addClass("btn disabled radius");
						setTimeout(function(){
							$("#login").attr("disabled",false).removeClass("btn disabled radius");
						},7200000)
					}
				} else {
					$("#verification").addClass("verification_code");
					<%-- window.location.href="<%=request.getContextPath() %>/back/index.do"; --%>
					window.location.href="<%=request.getContextPath() %>/entrance.do";
				}
			},
		})
    }
    $('#login').click(function() {
        toLogin();
	});
    document.onkeyup = function (event) {
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if (e && e.keyCode == 13) {
            toLogin();
        }
    };
});
</script>
<script type="text/javascript">
$(function(){
	$('#wxLogin').click(function() {
		$.ajax({
			url : "<%=request.getContextPath() %>/wxLogin.do",
			type : "get",
			success : function(result){
				if(result == "0"){
					//失败
					layer.msg('取消置顶成功', {icon: 1});
					}
			    if(result == "1") {
					//成功
					window.location.href="<%=request.getContextPath() %>/back/index.do";
				}
			},
		})
	});
});
</script>
<script type="text/javascript">
function changeimg(imgId,inputId){
	try{
		document.getElementById(imgId).src='<%=request.getContextPath() %>/getImgCode.do?'+Math.random(); 
		document.getElementById(inputId).focus();
	}catch(ex){}
	return false;
}
</script>
<script type="text/javascript">
    //当登录帐户密码验证失败的时候    $("#msg").removeClass("msg");
    //当同一个账号登录失败超过n次的时候      $("#verification").removeClass("verification_code");
    //点击提交按钮后当输入的验证码是错误的时候      $("#hint_msg").removeClass("hint_msg");
</script>
</html>