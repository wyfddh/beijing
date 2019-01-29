<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.tj720.mip.springbeans.Config"%>
<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String rootUrl = "http://bwsc.scmuseum.cn:90/files";
	String currentIp = "http://test.tj720.com";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="favicon.ico">
    <link rel="Shortcut Icon" href="favicon.ico"/>-->
		<!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
		<!--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css"/>-->
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/aside.css">
		<!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
		<!--/meta 作为公共模版分离出去-->

		<title>内容管理子系统</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<style>
			.secondTitle li a:hover {
				background: #747474!important;
				color: #ffffff;
			}
			
			.current {
				background: #747474!important;
				color: #ffffff;
			}
			
			dl dt:hover {
				background: #747474!important;
				border-left: 1px solid #dc1720;
			}
			#userName{
				box-shadow: #E2E3E3 2px 2px 5px; 
				position: absolute;top: 20px;left: 27px;padding-top:0;width: 80px;	
				display: none;
			}
			#userName a{
				display: block!important;
				color: #FFF!important;
				background: #2A9BCF!important;
				height: 28px;
				text-align: center;
				line-height: 28px;
				font-size: 16px;
				text-decoration: none;
			}
			#userName a.setMima{
				border-top-left-radius: 5px;
				border-top-right-radius: 5px;
				color: #2A9BCF!important;
				background: #fff!important;
			}
			#userName a.centerA{
				
			}
			#userName a.repeat{
				border-bottom-left-radius: 5px;
				border-bottom-right-radius: 5px;
				color: #2A9BCF!important;
				background: #fff!important;
			}
			/*弹出窗样式*/	
		.onlyTc .layui-layer-border{
            border:none!important;
            box-shadow:none!important;
            border-radius:5px!important;
            overflow:hidden!important;
        }
        .onlyTc .layui-layer-title{
            height:75px!important;
            line-height:70px!important;
            border-bottom:5px solid #f1f2f7!important;
            box-sizing:border-box;
            background:#fff!important;
            font-size: 18px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
            font-weight: bold;
        }
        .onlyTc .layui-layer-setwin{
            top:30px!important;
        }
        #setPwd lebal{
        	display: inline-block;
        	width: 70px;
        	text-align: right;
        }
        #setPwd input{
        	width: 196px;
        	height: 26px;
        	line-height: 26px;
        	outline: none;
        	border: 1px solid #F1F2F7;
        	background: #FCFCFC;
        }
        .containerPwd>div{
        	margin-bottom: 20px;
        }
         .line{
            width:100%;
            height:50px;
            box-sizing:border-box;
            line-height:50px;
            border:none;
                margin-top: 40px;
   			 margin-left: 42px;
        }
        .line:after{
            display:block;
            content:"";
            clear:both;
        }
        .title{
            width:50px;
            height:100%;
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(51, 51, 51);
            float:left;
            text-align:right;
            padding-right:15px;
        }
        .topSel{
            border: 1px solid rgb(241, 242, 247);
            border-radius: 4px;
            background-color: rgb(252, 252, 252);
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(51, 51, 51);
            width: 260px;
            height: 24px;
            margin-top:13px;
        }
        .fabu-aside>ul>li>a>span{
        	color:#2aa1bc;
        }
        .secondLine{
            float:left;
            width:350px;
        }
        .inputText{
            border: 1px solid rgb(241, 242, 247);
            border-radius: 4px;
            background-color: rgb(252, 252, 252);
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(51, 51, 51);
            width: 260px;
            height: 24px;
            margin-top:13px;
            padding-left:8px;
            box-sizing:border-box;
        }
        .areaSel{
            width:80px;
            margin-right:11px;
        }
        .langInput{
            width: 420px;
        }
        .seconeLineTwo{
            width:490px;
        }
        .areaText{
            border: 1px solid rgb(241, 242, 247);
            border-radius: 4px;
            background-color: rgb(252, 252, 252);
            width: 770px;
            height: 121px;
            resize:none;
            margin-top:13px;
        }
        .bigLine{
            height:150px;
        }
        .subBtn{
            border-radius: 4px;
            width: 101px;
            height: 36px;
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(255, 255, 255);
            line-height: 36px;
            text-align:center;
            box-sizing:border-box;
            float:left;
            margin-right:12px;
            cursor:pointer;
        }
        .subBtn > img{
            vertical-align:text-top;
        }
        .conform{
            background-color: rgb(42, 155, 207);
        }
        .cancel{
            border:1px solid rgb(42, 155, 207);
            line-height: 34px;
            background:#fff;
            color: rgb(42, 155, 207);
        }
        .star{
            color:#ff7267;
            display:inline-block;
            padding-right: 4px;
        }
        .radioInput{
            margin-top:0;
            vertical-align:sub;
            margin-right:5px;
        }
        .containerPwd{
        	position: relative;
        }
        #userNameP{
        	color:#ffffff;
        }
        .containerPwd p{
        	position: absolute;
		        top: 132px;
    		left: 75px;
    		color: #ED4747;
        }
			/*       a{
			 	* 
       display:block;
       width:100%;
      } */
		</style>
	</head>

	<body>
		<aside class="Hui-aside" id="aside" style="background:url(/admin/back/images/bg_aside.png);position:fixed;height:100%;">

			<!--<input runat="server" id="divScrollValue" type="hidden" value="" />-->
			<%-- <div class="menu_dropdown bk_2">
   		<c:if test="${fn:contains(sessionScope.user.level,1)==true}">
	        <dl id="menu-article">
	         	<dt class="listColor">媒体管理<i class="Hui-iconfont menu_dropdown-arrow listColor">&#xe6d7;</i></dt>
            	<dd >
               		<ul class="secondTitle">
                   		<li><a href="<%=request.getContextPath()%>/turnimggrid/getMipCarouselPositionList.do" rel="
			<%=request.getContextPath()%>/turnimggrid/getMipCarouselPositionList.do" title="轮播图管理" class="listColor">轮播图管理</a>
			</li>
			<c:if test="${fn:contains(sessionScope.user.platformId,2)==true}">
				<li>
					<a href="<%=request.getContextPath()%>/audio/getMipAudioList.do" rel="<%=request.getContextPath()%>/audio/getMipAudioList.do" title="背景音乐管理" class="listColor">背景音乐管理</a>
				</li>
			</c:if>
			</ul>
			</dd>
			</dl>
			</c:if>
			<dl id="menu_comments">
				<dt class="listColor">展览管理<i class="Hui-iconfont menu_dropdown-arrow listColor">&#xe6d7;</i></dt>
				<dd>
					<ul class="secondTitle">
						<li>
							<a href="<%=request.getContextPath()%>/spreadtrum/getSpreadtrum.do" rel="<%=request.getContextPath()%>/spreadtrum/getSpreadtrum.do" title="省内展讯列表" class="listColor">展览列表</a>
						</li>
					</ul>
				</dd>
			</dl>
			<c:if test="${fn:contains(sessionScope.user.platformId,2)==true}">
				<c:if test="${fn:contains(sessionScope.user.level,1)==true}">
					<dl id="menu-member">
						<dt class="listColor">外省展览管理<i class="Hui-iconfont menu_dropdown-arrow listColor">&#xe6d7;</i></dt>
						<dd>
							<ul class="secondTitle">
								<li>
									<a href="<%=request.getContextPath()%>/otherSpreadtrum/getOtherSpreadtrum.do?type=1" rel="<%=request.getContextPath()%>/otherSpreadtrum/getOtherSpreadtrum.do?type=1" title="省外展讯列表" class="listColor">省外展览列表</a>
								</li>
							</ul>
						</dd>
					</dl>
					<dl id="menu-admin">
						<dt class="listColor">国外展览管理<i class="Hui-iconfont menu_dropdown-arrow listColor">&#xe6d7;</i></dt>
						<dd>
							<ul class="secondTitle">
								<li>
									<a href="<%=request.getContextPath()%>/otherSpreadtrum/getOtherSpreadtrum.do?type=2" rel="<%=request.getContextPath()%>/otherSpreadtrum/getOtherSpreadtrum.do?type=2" title="国外展讯列表" class="listColor">国外展览列表</a>
								</li>
							</ul>
						</dd>
					</dl>
				</c:if>
			</c:if>

			<dl id="menu-tongji">
				<dt class="listColor">虚拟展厅管理<i class="Hui-iconfont menu_dropdown-arrow listColor">&#xe6d7;</i></dt>
				<dd>
					<ul class="secondTitle">
						<li>
							<a href="<%=request.getContextPath()%>/virtual/getVirtual.do" title="虚拟展厅列表" rel="<%=request.getContextPath()%>/virtual/getVirtual.do" class="listColor">虚拟展厅列表</a>
						</li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-system">
				<dt class="listColor">博物馆管理<i class="Hui-iconfont menu_dropdown-arrow listColor">&#xe6d7;</i></dt>
				<dd>
					<ul class="secondTitle">
						<li>
							<a href="<%=request.getContextPath()%>/museuminfo/getMuseumPage.do" rel="<%=request.getContextPath()%>/museuminfo/getMuseumPage.do" title="博物馆信息管理" class="listColor">博物馆信息管理</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/museumColumn/getMuseumColumn.do" rel="<%=request.getContextPath()%>/museumColumn/getMuseumColumn.do" title="博物馆栏目管理" class="listColor">博物馆栏目管理</a>
						</li>
						<c:if test="${fn:contains(sessionScope.user.level,1)==true || fn:contains(sessionScope.user.level,2)==true}">
							<li>
								<a href="<%=request.getContextPath()%>/museuminfo/getMuseumAll.do" rel="<%=request.getContextPath()%>/museuminfo/getMuseumAll.do" title="选择博物馆" class="listColor">选择博物馆</a>
							</li>
						</c:if>
					</ul>
				</dd>
			</dl>
			<c:if test="${fn:contains(sessionScope.user.platformId,1)==true}">
				<dl id="menu-activity">
					<dt class="listColor">活动管理<i class="Hui-iconfont menu_dropdown-arrow listColor">&#xe6d7;</i></dt>
					<dd>
						<ul class="secondTitle">
							<li>
								<a href="<%=request.getContextPath()%>/activity/getArticleList.do" rel="<%=request.getContextPath()%>/activity/getArticleList.do" title="活动" class="listColor">活动列表</a>
							</li>
						</ul>
					</dd>
				</dl>
				<dl id="menu-activity">
					<dt class="listColor">文创管理<i class="Hui-iconfont menu_dropdown-arrow listColor">&#xe6d7;</i></dt>
					<dd>
						<ul class="secondTitle">
							<li>
								<a href="<%=request.getContextPath()%>/wenChuang/getWenChuang.do" rel="<%=request.getContextPath()%>/wenChuang/getWenChuang.do" title="文创" class="listColor">文创列表</a>
							</li>
						</ul>
					</dd>
				</dl>
				<c:if test="${fn:contains(sessionScope.user.level,1)==true}">
					<dl id="menu-activity">
						<dt class="listColor">历史吉林文章管理<i class="Hui-iconfont menu_dropdown-arrow listColor">&#xe6d7;</i></dt>
						<dd>
							<ul class="secondTitle">
								<li>
									<a href="<%=request.getContextPath()%>/articleJiLin/getArticleList.do" rel="<%=request.getContextPath()%>/articleJiLin/getArticleList.do" title="文创" class="listColor">文章列表</a>
								</li>
							</ul>
						</dd>
					</dl>
				</c:if>
			</c:if>
			<c:if test="${fn:contains(sessionScope.user.level,1)==true}">
				<dl id="menu-article">
					<dt class="listColor">注册用户管理<i class="Hui-iconfont menu_dropdown-arrow listColor">&#xe6d7;</i></dt>
					<dd>
						<ul class="secondTitle">
							<li>
								<a href="<%=request.getContextPath()%>/regUserManage/info.do" rel="<%=request.getContextPath()%>/regUserManage/info.do" title="轮播图管理" class="listColor">用户详情页</a>
							</li>
						</ul>
					</dd>
				</dl>
			</c:if>
			</div> --%>
			<!-- 左边导航栏 -->
			<div class="fabu-aside">
				<!--用户头像-->
				<div>
					<p>
						<c:if test="${'' eq sessionScope.user.avatarUrl}">
							<img src="<%=request.getContextPath() %>/back/images/heae-img.png" alt="" style="width:82px;height:82px;border-radius: 50%">
						</c:if>
						<c:if test="${'' ne sessionScope.user.avatarUrl}">
							<img src="<%=rootUrl %>/${sessionScope.user.avatarUrl}" alt="" style="width:82px;height:82px;border-radius: 50%">
						</c:if>
					</p>
				</div>
				<!--<p>${sessionScope.user.nickname}</p>--> 
				<div id="userNameP" style="position: relative;padding-top:0;width: 100%; margin: 10px 0;">
					<span></span>
					<img style="margin-left: 5px;" src="<%=request.getContextPath() %>/back/images/xiala.png" alt="" />
					<div id='userName' style="">
						<a class="setMima" href="<%=currentIp %>/admin/entrance.do">返回桌面</a>
						<a class="centerA" onClick="setPwd()" href="javascript:">修改密码</a>
						<a class="repeat" href="<%=request.getContextPath() %>/back/loginOut.do">重新登录</a>
					</div>
				</div>
				<ul>
					<li>
						<a href="/admin/spreadtrum/getSpreadtrum.do">
							<img src="<%=request.getContextPath() %>/back/images/fabulogo.png" alt="" />
							<br />
							<span>内容管理</span>
						</a>
						
					</li>
					<li>
						<a href="/admin/back/oCCollection/info.do">
							<img src="<%=request.getContextPath() %>/back/images/cangpin.png" alt="" />
							<br />
							<span style="color:#eb685d;">藏品库</span>
						</a>
					</li>
					<c:if test="${fn:contains(sessionScope.user.level,1)==true||fn:contains(sessionScope.user.level,3)==true}">
						<li>
							<a href="/admin/back/oCCollection/info.do?type=1">
								<img src="<%=request.getContextPath() %>/back/images/dongtai.png" alt="" />
								<br />
								<span style="color:#d8825a;">藏品登录管理</span>
							</a>
						</li>
					</c:if>
					<c:if test="${fn:contains(sessionScope.user.authStr,'SystemAdmin')==true ||fn:contains(sessionScope.user.level,1)==true}">
						<li>
							<a href="/admin/admin/user/adminList.do">
								<img src="<%=request.getContextPath() %>/back/images/weihu.png" alt="" />
								<br />
								<span style="color:#bc9657">信息维护</span>
							</a>
						</li>
					</c:if>
					<c:if test="${fn:contains(sessionScope.user.platformId,1)==true}">
						<li>
							<a href="/admin/registerInfo/getInfoList.do">
								<img src="<%=request.getContextPath() %>/back/images/xingzhengguanli.png" alt="" />
								<br />
								<span style="color:#bc9657">行政管理</span>   
							</a>
						</li>
					</c:if>
					<c:if test="${fn:contains(sessionScope.user.level,1)==true}">
<!-- 						<li> -->
<!-- 							<a href="/admin/quesQuestionnaire/questionnaireList.do"> -->
<%-- 								<img src="<%=request.getContextPath() %>/back/images/th.png" alt="" /> --%>
<!-- 								<br /> -->
<!-- 								<span style="color:#d8825a;">问卷调查管理</span> -->
<!-- 							</a> -->
<!-- 						</li> -->
					</c:if>
					<c:if test="${fn:contains(sessionScope.user.platformId,2)==true}">
<!-- 						<li> -->
<!-- 							<a href="/admin/cCompany/getCcompanies.do"> -->
<%-- 								<img src="<%=request.getContextPath() %>/back/images/gongyinshang.png" alt="" /> --%>
<!-- 								<br /> -->
<!-- 								<span>供应商</span> -->
<!-- 							</a> -->
<!-- 						</li> -->
					</c:if>
					<%-- <li>
						<a href="/admin/mipLog/getInfoList.do">
							<img src="<%=request.getContextPath() %>/back/images/gongyinshang.png" alt="" />
							<br />
							<span>日志管理</span>
						</a>
					</li> --%>
				</ul>

			</div>

		</aside>
		<div class="onlyTc">
			<div id="setPwd" style="display: none;">
			<div class="containerPwd" style="width:274px;margin: 30px auto;">
				<div>
					<lebal for="yPwd">原密码：</lebal>
					<input id="yPwd" type="password" />
				</div>
				<div>
					<lebal for="Pwd">新密码：</lebal>
					<input id="Pwd" type="password" />
				</div>
				<div>
					<lebal for="nPwd">确认密码：</lebal>
					<input id="nPwd" type="password" />
				</div>
				<p id="info"></p>
				<div class="line" align="left">
		            <div class="subBtn conform" id="configNew" onclick="okPwd()" "><img src="<%=request.getContextPath() %>/back/images/save.png"> 确认修改</div>
		            <button class="subBtn cancel" id="close" onclick="layer.closeAll()" ><img src="<%=request.getContextPath() %>/back/images/cancel.png"> 取消</button>
		        </div>
			</div>
		</div>
		</div>
		
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
		<script>
			var userId ='${sessionScope.user.userId}';
			var curUrl = window.location.href;
			var urlState = false;
			function setPwd(){
			    layer.open({
			            type: 1,
			            title: '修改密码',
			            shadeClose: true,
			            shade: 0.5,
			            maxmin: true, //开启最大化最小化按钮
			            area: ['514px', '368px'],
			            content:$("#setPwd"),
			        });
			}
			function okPwd(){
				var yPwd = $("#yPwd").val();//原密码
				var Pwd = $("#Pwd").val();//新密码
				var nPwd = $("#nPwd").val();//确认密码
				var passwordReg= /^[0-9A-Za-z_]{8,18}$/; //密码的正则表达式
				if(yPwd == ''){
					$("#info").html("原密码不能为空");
                   return;
                }else if(!(passwordReg.test(yPwd))){
                	$("#info").html("原密码必须为8-18为数字或字母");
                    return;
                }else if(Pwd == ''){
                	$("#info").html("新密码不能为空");
                    return;
                }else if(Pwd == yPwd){
                	$("#info").html("不能使用原来的密码");
                    return;
                }else if(!(passwordReg.test(Pwd))){
                	$("#info").html("密码必须为8-18为数字或字母");
                    return;
                }else if(Pwd != nPwd){
                	$("#info").html("您两次输入的密码不一致");
                    return;
                }else {
                    //userId  yPwd  Pwd
                    $.ajax({
                    	type:"post",
                    	url:"<%=request.getContextPath() %>/changePassword.do",
                    	dataType:'json',
                    	data:{"id":userId,"password":yPwd,"newPassword":Pwd},
                    	success:function(data){
                    		console.log(data);
                    		if(data.success==1){
                    			layer.msg("修改成功，即将重新登录");
                    			setTimeout(function(){
                    				window.location.href="<%=request.getContextPath() %>/back/loginOut.do";
                    			},3000);
                      			
                    		}else if(data.success==2){
                    			//账号不存在
                    			layer.alert("账号不存在，请重新输入");
                    			$("#yPwd").val("");//原密码
								$("#Pwd").val("");//新密码
								$("#nPwd").val("");//确认密码
                    		}else{
                    			//密码错误
                    			layer.msg("密码错误，请重新输入");
                    			$("#yPwd").val("");//原密码
								$("#Pwd").val("");//新密码
								$("#nPwd").val("");//确认密码
                    		}
                    	}
                    });
                }
			}
			<%--遍历a标签--%>
			$(".menu_dropdown a").each(function() {
				if((curUrl + '/').indexOf($(this).attr('rel')) > -1 && $(this).attr('rel') != '') {
					<%--console.log($(this));--%>
					$(this).addClass('current');
					<%--console.log($(this).parents("secondTitle"));--%>
					$(this).parents().css('display', 'block');
					urlState = true;
				} else {
					$(this).removeClass('current');
				}
				if(!urlState) {
					$(".menu_dropdown a").removeClass('current');
				}
			})
			
			$(function(){
				var name = '${sessionScope.user.nickname}';
				if(name.length>7){
					$("#userNameP span").text(name.substring(0,7)+"...")
				} else {
					$("#userNameP span").text(name)
				}
				$("#userNameP").on("mouseenter",function(){
					$("#userName").css("display","block");
				})
				$("#userNameP").on("mouseleave",function(){
					$("#userName").css("display","none");
				})
			})
		</script>
	</body>

</html>