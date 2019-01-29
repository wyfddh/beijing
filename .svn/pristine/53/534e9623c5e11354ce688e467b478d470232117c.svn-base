<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="ie=edge" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/login.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/public.css" />
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
	<title>登录</title>
</head>
<body>
	<form id="bakcLoginForm" method="post">
		<input type="hidden" id="isback" name="isback" value="1">
		<div class="bg_box">
			<span>吉林省可移动文物动态登录平台</span>
			<div class="bg_banner">
				<div class="login">
					<div class="login_content">
						<span>欢迎登录</span>
						<div class="Input_box">
							<div class="input_img"><input type="text" placeholder="请输入账号" id="phone" name="phone"/><img src="<%=request.getContextPath() %>/back/images/people.png" /></div>
							<div  class="input_img"><input type="password" placeholder="请输入密码" id="password" name="password"/><img src="<%=request.getContextPath() %>/back/images/lock.png" /></div>
							<div class="lght verification_code" style="margin-top:20px;" id="verification">
								<label class="form-label f-l fz" style="opacity:0;"><i class="Hui-iconfont">&#xe60e;</i></label>
								<div class="formControls col-xs-10" style="display:flex;width:100%;padding:0;margin-top: -30px;">
									<input id="verificationCode" name="verificationCode" class="input-text size-L" type="text" autocomplete="off" placeholder="图形验证码" required style="width:78px;">
									<img id="imgCode" src="<%=request.getContextPath() %>/getImgCode.do" onclick="changeimg('imgCode','verificationCode')">
									<a style="line-height: 2;" id="kanbuq" href="javascript:" onclick="changeimg('imgCode','verificationCode')">看不清，换一张</a>
								</div>
							</div>
							<div class="msg lght" id="msg" style=";">
			                    <label class="form-label f-l fz" style="opacity:0;"><i class="Hui-iconfont">&#xe60e;</i></label>
			                    <div class="formControls col-xs-10" id="errorMsg" style="color: red;width:100%;padding:0;">
			                    </div>
			                </div>
			                <input name="" id="login" type="button" class="btn btn-success radius" style="text-indent:0;width:100%;height:40px;background:#2a9bcf;font-size:18px;margin-top:10px !important;font-family:微软雅黑;" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;"> &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;
						</div>
					</div>
					<div class="bg_login">
					</div>
				</div>
			</div>
		</div>
	</form>
	<script src="<%=request.getContextPath() %>/back/lib/jquery/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript">
		$("input").eq(0).focus(function(){
			$(this).addClass("focus")
			$(".Input_box img").eq(0).attr("src","/admin/back/images/hover_people.png")
		})
		$("input").eq(0).blur(function(){
			$(this).removeClass("focus")
			$(".Input_box img").eq(0).attr("src","/admin/back/images/people.png")
		})
		$("input").eq(1).focus(function(){
			$(this).addClass("focus")
			$(".Input_box img").eq(1).attr("src","/admin/back/images/hover_lock.png")
		})
		$("input").eq(1).blur(function(){
			$(".Input_box img").eq(1).attr("src","/admin/back/images/lock.png")
			$(this).removeClass("focus")
		})
	    $("input").focus(function(){
            $("input").css({border:"1px solid #cccccc","box-shadow": "none"});
            $(this).css({border:"1px solid #10b690","box-shadow": "0 0 3px #10b690"});
        })
        $("input").blur(function(){
            $(this).css({border:"1px solid #cccccc","box-shadow": "none"});
        })
	</script>
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
		//alert(data);
		$.ajax({
			url : "<%=request.getContextPath() %>/frontLogin.do",
			type : "post",
			data :  data,
			dataType : "json",
			success : function(result){
				console.log(result);
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
				} 
				if(result.success==1){
					$("#verification").addClass("verification_code");
					window.location.href='<%=request.getContextPath() %>/back/oCCollection/info.do?type=1';
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
<script type="text/javascript">
        $("input").focus(function(){
            $("input").css({border:"1px solid #cccccc","box-shadow": "none"});
            $(this).css({border:"1px solid #10b690","box-shadow": "0 0 3px #10b690"});
        })
        $("input").blur(function(){
            $(this).css({border:"1px solid #cccccc","box-shadow": "none"});
        })
</script>
</body>
</html>