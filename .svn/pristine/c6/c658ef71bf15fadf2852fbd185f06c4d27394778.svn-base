<%@ page language="java" import="java.util.*,java.io.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
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
		hostname = pro.getProperty("web.hostname"); 
	
		String requestPath=request.getContextPath();
	%>

    <meta charset="UTF-8">
    <title><%=hostname %></title>
    <link rel="stylesheet" href="<%=requestPath%>/front/baike/css/reset.css">
    <style>
	    *{
	        padding: 0;
	        margin: 0;
	    }
	    .loginTop{
	        background: url("<%=requestPath%>/resources/images/login1.png") center no-repeat;
	        background-size: auto 100%;
	        width: 100%;
	        height: 425px;
	        margin: 0 auto;
	        position: relative;
	    }
	    .loginTop img{
	        display: block;
	        position: absolute;
	        left: 50%;
	        top: 50%;
	        transform: translate(-50%,-50%);
	        margin: auto;
	        width: 486px;
	        height: 143px;
	    }
	    .inputCSS{
	        outline: none;
	        width: 315px;
	        height: 42px;
	        border: none;
	        border-radius: 8px;
	        border-width: 1px;
	        display: block;
	        text-indent: 14px;
	        font-size: 14px;
	        color: #666;
	    }
	    #phone, #password{
	    	width: 280px;
	    }
	    #verificationCode{
	    	width: 200px;
	    }
	    #bakcLoginForm{
	        width: 320px;
	        height: auto;
	        margin:0 auto;
	        margin-top: 20px;
	        padding-bottom: 50px;
	    }
	    .submit{
	        text-align: center;
	        line-height: 32px;
	        width: 320px;
	        height: 45px;
	        font-size: 20px;
	        color: white;
	        background-color: #3597e3;
	        display: block;
	        margin: 0 auto;
	        border: none;
	        border-radius: 4px;
	        cursor:pointer;
	        padding-top: 10px;
	    }
	    .NO,.check,.passW{
	        position: relative;
	        width: 100%;
	        margin-bottom: 30px;
	        position: relative;
	        border: 1px solid #B5BCC4;
 	        height: 45px;
 	        border-radius: 4px;
	    }
	    .NO img,.passW img{
	        position: absolute;
	        right: 15px;
    		top: 10px;
	    }
	    .check img{
	    	position: absolute;
	        right: 40px;
    		top: 7px;
	    }
	    .check #refresh{
	    	position: absolute;
	        right: 18px;
    		top: 15px;
    		cursor:pointer;
	    }
	    .lg_cw{
	    	position: relative;
	    	width: 100%;
	    	height: 40px;
	    }
    </style>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/md5.js"></script>
</head>
<body>
	<div class="loginTop">
       <img src="<%=requestPath%>/resources/images/login2.png" alt="">
   </div>
   <form id="bakcLoginForm" class="form" method="post">
       <div class="lg_cw"><div id="err_msg" style="display:none;color: red;"><div class="lg_cw0">用户名或密码错误</div><div class="lg_cw1"></div></div></div>
       <div class="NO">
        	<input type="text" class="inputCSS" placeholder="请输入您的帐户" id="phone" name="phone">
           	<img src="<%=requestPath%>/resources/images/user.png" alt="">
       </div>
       <div class="passW">
         	<input type="password" class="inputCSS" placeholder="请输入您的密码" id="password" name="password">
            <img src="<%=requestPath%>/resources/images/lock.png" alt="">
       </div>
       <div id="verification" style="display: none;" class="check">
         	<input id="verificationCode" name="verificationCode" type="text" class="inputCSS" placeholder="验证码">
         	<img id="imgCode" src="<%=request.getContextPath() %>/getImgCode.do" >
         	<img id="refresh" onclick="changeimg('imgCode','verificationCode')" title="看不清，换一张" src="<%=request.getContextPath() %>/resources/images/refresh.png" >
       </div>
       <div id="login" class="submit btn disabled radius" id="login"><b>登&nbsp;&nbsp;&nbsp;录</b></div>
   </form>
<%-- <div class="lg_main">
    <div class="lg_left">
        <img class="aa" src="<%=requestPath%>/resources/images/lg_left.png" alt="">
    </div>
    <div class="lg_right">
    	<form id="bakcLoginForm" class="form" method="post">
	        <img class="lg_user" src="<%=requestPath%>/resources/images/lg_user.png" alt="">
	        <div class="lg_name">管理员，您好！</div>
	        <div class="lg_cw"><div id="err_msg" style="display:none;"><div class="lg_cw0">用户名或密码错误</div><div class="lg_cw1"></div></div></div>
	        <div class="lg_num">用户名</div>
	        <div class="lg_num1"><input id="phone" name="phone" type="text" placeholder="请输入您的帐户" value="10100000011"></div>
	        <div class="lg_psd">密码</div>
	        <div class="lg_num1"><input id="password" name="password" type="password" placeholder="请输入您的密码" autocomplete="off" onfocus="" value="123456"></div>
	        <div id="verification" style="display:none;">
		        <div class="lg_psd">验证码</div>
		        <div class="lg_num1"><input id="verificationCode" name="verificationCode" type="text"><span class="lg_yzm"><img id="imgCode" style="margin-top: -4px;margin-right: 28px;" src="<%=request.getContextPath() %>/getImgCode.do" ><img src="<%=requestPath%>/resources/images/lg_re.png" onclick="changeimg('imgCode','verificationCode')" title="看不清，换一张" alt=""></span></div>
	        </div>
	        <div id="login" class="lg_dl"><img src="<%=requestPath%>/resources/images/login.png" alt=""></div>
        </form>
    </div>
</div> --%>
</body>

<script type="text/javascript">
$(function(){

    function toLogin(){
    	
    	var password=$("#password").val();
		var phone = $("#phone").val();
		var verificationCode = $("#verificationCode").val();
		var value = $("#verification").css("display");
		if(value != "none" ){
			var text = $("#verificationCode").val();
			if(null == text || text == ""){
			    alert("验证码未填写");
				return;
			}
		}
		//alert(data);
		$.ajax({
			url : "<%=request.getContextPath() %>/frontLogin.do",
			type : "post",
			data :  {"password":hex_md5(password),"phone":phone,"verificationCode":verificationCode,isback:'1'},
			dataType : "json",
			success : function(result){
				console.log(result);
				if(!result.data.sessionAdminName){
					//失败
					$("#verification").show();
					$("#err_msg").show();
					$(".lg_cw0").text(result.data.tipMessage);
					if(result.data.errorTimes>4){
						$("#login").attr("disabled",true).addClass("btn disabled radius");
						setTimeout(function(){
							$("#login").attr("disabled",false).removeClass("btn disabled radius");
						},7200000)
					}
				} else {
					$("#verification").addClass("verification_code");
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

function changeimg(imgId,inputId){
	try{
		document.getElementById(imgId).src='<%=request.getContextPath() %>/getImgCode.do?'+Math.random(); 
		document.getElementById(inputId).focus();
	}catch(ex){}
	return false;
}

</script>

</html>