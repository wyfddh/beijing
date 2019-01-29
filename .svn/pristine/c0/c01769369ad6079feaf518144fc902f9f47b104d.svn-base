<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="favicon.ico">
    <link rel="Shortcut Icon" href="favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script> 
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/css/header.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>内容管理子系统</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <style>
        .logoList li:hover{
            background:#4b4b4b;
        }
    </style>
</head>
<body>
<header class="navbar-wrapper">
    <div id="nav_bar" class="navbar navbar-fixed-top" style="background: #1e2326">
        <div class="container-fluid cl">
            <i class="Hui-iconfont hidden-xs iconLogo" style="float: left;line-height: 2.8rem;color: #ffffff;font-size: 2.25rem;margin-left: 1.5rem">&#xe667;</i>
            <i class="Hui-iconfont visible-xs iconLogo" style="float: left;line-height: 2.8rem;color: #ffffff;font-size: 1.5rem;margin-left: 1.5rem">&#xe667;</i>
            <div class="logo navbar-logo f-l mr-10 hidden-xs" style="font-size: 1.5rem;line-height: 2.75rem;position: relative"><span class="titleLogo">内容管理子系统</span>
                <ul class="list logoList"  style="background:#747474">
                    <li class="system_child"><a href="<%=request.getContextPath() %>/spreadtrum/getSpreadtrum.do">内容管理子系统</a></li>
                    <li class="system_child"><a href="<%=request.getContextPath() %>/back/oCCollection/info.do">藏品服务子系统</a></li>
                    <li class="system_child"><a href="<%=request.getContextPath()%>/admin/user/adminList.do">系统管理子系统</a></li>
                </ul>
            </div>
           
            <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li style="line-height: 2.75rem" class="headimg">
                            <img src="<%=request.getContextPath() %>/${sessionScope.user.avatarUrl}" alt="" style="width:2.5rem;height:2.5rem;border-radius: 1.5rem">
                    </li>
                    <li style="text-align: center;">
                        <div id="userName" class="user" style="height: 1.2rem;line-height: 1rem;padding-top: 0.9rem">${sessionScope.user.nickname}</div>
                    </li>
                    <li style="width: 1rem;height:2.75rem;line-height: 2.75rem;">
                        <div class="line" style="margin-top: 0.6rem;border-top: none;"></div>
                    </li>
                    <li style="height: 2.75rem;">
                        <i class="Hui-iconfont" onclick="logout()" style="line-height:2.75rem;color: #ff0505;font-size: 2.25rem;margin-left: 1.5rem;margin-right: 2rem;cursor:pointer">&#xe726;</i>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<script type="text/javascript">
    $(function(){
        $(".titleLogo").click(function(){
//            alert($("#logoList").css("display")=="none")
            if($(".logoList").css("display")=="none"){
                $(".logoList").slideDown(500);
                $(".iconLogo").removeClass("rotate_currency").addClass("rotate").css({transform:"rotate(90deg)"});
            }else {
                $(".logoList").slideUp(300);
                $(".iconLogo").removeClass("rotate").addClass("rotate_currency").css({transform:"rotate(0deg)"});
            }
        })
    })
</script>
<script type="text/javascript">
	function logout() {
		window.location.href="<%=request.getContextPath() %>/back/loginOut.do";
	}
</script>
</body>