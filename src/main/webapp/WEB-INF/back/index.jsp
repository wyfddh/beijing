<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	String kefuPhone = pro.getProperty("kefu.phone");
	String qqqun = pro.getProperty("kefu.qqqun");

	String requestPath=request.getContextPath();
%>
<meta charset="utf-8">
<title><%=hostname %></title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="icon" href="<%=requestPath%>/back/favicon.ico">
<link rel="stylesheet" href="<%=requestPath%>/resources/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="<%=requestPath%>/resources/css/index.css" media="all" />
</head>
<body class="main_body">
	<div class="layui-layout layui-layout-admin">
		<!-- 顶部 -->
		<div class="layui-header header">
			<div class="layui-main mag0">
				<a href="#" class="logo"><img src="<%=requestPath%>/resources/images/bj_logo2.png" alt="北京市博物馆大数据平台" style="margin-top: 3px;"/></a>
				<!-- 显示/隐藏菜单 -->
				<a href="javascript:;" class="seraph hideMenu icon-caidan layui-icon layui-icon-shrink-right"></a>
				<!-- 顶级菜单 -->
				<ul class="layui-nav mobileTopLevelMenus layui-hide" mobile>
					<li class="layui-nav-item" data-menu="contentManagement"><a
						href="javascript:;"><i class="seraph icon-caidan"></i><cite>layuiCMS</cite></a>
						<dl class="layui-nav-child">
							<dd class="layui-this" data-menu="contentManagement">
								<a href="javascript:;"><i class="layui-icon"
									data-icon="&#xe63c;">&#xe63c;</i><cite>内容管理</cite></a>
							</dd>
							<dd data-menu="memberCenter">
								<a href="javascript:;"><i class="seraph icon-icon10"
									data-icon="icon-icon10"></i><cite>用户中心</cite></a>
							</dd>
							<dd data-menu="systemeSttings">
								<a href="javascript:;"><i class="layui-icon"
									data-icon="&#xe620;">&#xe620;</i><cite>系统设置</cite></a>
							</dd>
							<dd data-menu="seraphApi">
								<a href="javascript:;"><i class="layui-icon"
									data-icon="&#xe705;">&#xe705;</i><cite>使用文档</cite></a>
							</dd>
						</dl>
					</li>
				</ul>
				<ul class="layui-nav topLevelMenus layui-hide" pc>
					<li class="layui-nav-item layui-this" data-menu="contentManagement">
						<a href="javascript:;"><i class="layui-icon" data-icon="&#xe63c;">&#xe63c;</i><cite>内容管理</cite></a>
					</li>
				</ul>
				<!-- 顶部右侧菜单 -->
				<ul class="layui-nav top_menu">
					<!-- <li class="layui-nav-item" pc><a href="javascript:;"
						class="clearCache"><i class="layui-icon" data-icon="&#xe640;">&#xe640;</i><cite>清除缓存</cite><span
							class="layui-badge-dot"></span></a></li> -->
					<!-- <li class="layui-nav-item lockcms" pc>
						<a href="javascript:;">
							<i class="seraph icon-lock"></i><cite>锁屏</cite>
						</a>
					</li> -->
					
					<li class="layui-nav-item" id="userInfo"><a
						href="javascript:;"><img src="<%=requestPath%>/resources/images/face.jpg"
							class="layui-nav-img userAvatar" width="35" height="35"><cite
							class="adminName">${sessionScope.user.nickname }</cite></a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" class="modifyPassword">
									<i class="seraph icon-xiugai" data-icon="icon-xiugai"></i><cite>修改密码</cite>
								</a>
							</dd>
							<!-- <dd>
								<a href="javascript:;" class="modifyPassword"><i
									class="seraph icon-xiugai" data-icon="icon-xiugai"></i><cite>修改密码</cite></a>
							</dd> -->
							<!-- <dd>
								<a href="javascript:;" class="showNotice"><i
									class="layui-icon">&#xe645;</i><cite>系统公告</cite><span
									class="layui-badge-dot"></span></a>
							</dd> -->
							<!-- <dd pc>
								<a href="javascript:;" class="functionSetting"><i
									class="layui-icon">&#xe620;</i><cite>功能设定</cite><span
									class="layui-badge-dot"></span></a>
							</dd>
							<dd pc>
								<a href="javascript:;" class="changeSkin"><i
									class="layui-icon">&#xe61b;</i><cite>更换皮肤</cite></a>
							</dd>
							<dd>
								<a href="/back/loginOut.do" class="signOut"><i
									class="seraph icon-tuichu"></i><cite>退出</cite></a>
							</dd> -->
						</dl>
					</li>
					<c:if test="${sessionScope.user.orgTypeId == 1 }">
					<li class="layui-nav-item" pc>
						<a href="javascript:;">
							<i class="seraph icon-xiugai" data-icon="icon-xiugai"></i>
							<cite>
								<c:if test="${sessionScope.model == 'museum' }" var="ismuseum">博物馆</c:if>
								<c:if test="${sessionScope.model == 'zzOrg' }" var="iszzOrg">文物修复资质单位</c:if>
								<c:if test="${sessionScope.model == 'scOrg' }" var="isscOrg">文物收藏单位</c:if>
								<c:if test="${!ismuseum && !iszzOrg && !isscOrg }">机构类型</c:if>
							</cite>
						</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" class="museum">
									<i class="seraph icon-xiugai" data-icon="icon-xiugai"></i><cite>博物馆</cite>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" class="zzOrg">
									<i class="seraph icon-xiugai" data-icon="icon-xiugai"></i><cite>文物修复资质单位</cite>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" class="scOrg">
									<i class="seraph icon-xiugai" data-icon="icon-xiugai"></i><cite>文物收藏单位</cite>
								</a>
							</dd>
						</dl>
					</li>
					</c:if>
					<li class="layui-nav-item" pc>
						<a href="<%=request.getContextPath()%>/back/loginOut.do" class="signOut">
							<i class="seraph icon-tuichu"></i><cite>退出</cite>
						</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- 左侧导航 -->
		<div class="layui-side layui-bg-black">
			<div class="user-photo">
				<a class="img" title="我的头像"><img src="<%=requestPath%>/resources/images/face.jpg"
					class="userAvatar"></a>
				<p class="userName" style="width:190px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;text-align: center;">
						${sessionScope.user.nickname }
				</p>
			</div>
			<!-- 搜索 -->
			<!-- <div class="layui-form component">
				<select name="search" id="search" lay-search lay-filter="searchPage">
					<option value="">搜索页面或功能</option>
					<option value="1">layer</option>
					<option value="2">form</option>
				</select> <i class="layui-icon">&#xe615;</i>
			</div> -->
			<div class="navBar layui-side-scroll" id="navBar">
				<ul class="layui-nav layui-nav-tree">
					<!-- <li class="layui-nav-item layui-this"><a href="javascript:;"
						data-url="page/main.html"><i class="layui-icon" data-icon=""></i><cite>后台首页</cite></a>
					</li> -->
				</ul>
			</div>  
			<div class="kefu">
				<p>有任何疑问，请联系客服</p>
				<p>1、电话：<%=kefuPhone %></p>
				<p>2、QQ群：<%=qqqun %><a class="saoma" href="javascript:void(0);">扫码进群</a></p>
				<img class="qqqun" src="<%=requestPath%>/resources/images/U7Q9tw4bFgAcj9LB__thumbnail.png">
			</div>
		</div>
		<!-- 右侧内容 -->
		<div class="layui-body layui-form">
			<div class="layui-tab mag0" lay-filter="bodyTab" id="top_tabs_box">
				<ul class="layui-tab-title top_tab" id="top_tabs">
					 <!-- <li class="layui-this" lay-id=""><i class="layui-icon">&#xe68e;</i>
						<cite>工作台</cite>
					</li>  -->
				</ul>
				<ul class="layui-nav closeBox">
					<li class="layui-nav-item"><a href="javascript:;"><i
							class="layui-icon caozuo">&#xe643;</i> 页面操作</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" class="refresh refreshThis"><i
									class="layui-icon">&#x1002;</i> 刷新当前</a>
							</dd>
							<dd>
								<a href="javascript:;" class="closePageOther"><i
									class="seraph icon-prohibit"></i> 关闭其他</a>
							</dd>
							<dd>
								<a href="javascript:;" class="closePageAll"><i
									class="seraph icon-guanbi"></i> 关闭全部</a>
							</dd>
						</dl></li>
				</ul>
				<div class="layui-tab-content clildFrame">
				</div>
			</div>
		</div>
		<!-- 底部 -->
		<!--<div class="layui-footer footer">
			<p><span>copyright @2018 驊驊龔頾</span>　　<a onclick="donation()" class="layui-btn layui-btn-danger layui-btn-sm">捐赠作者</a></p>
		</div>-->
	</div>

	<!-- 移动导航 -->
	<div class="site-tree-mobile">
		<i class="layui-icon">&#xe602;</i>
	</div>
	<div class="site-mobile-shade"></div>
	
	<script type="text/javascript" src="<%=requestPath%>/back/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=requestPath%>/resources/js/common.js"></script>
	<script type="text/javascript" src="<%=requestPath%>/resources/layui/layui.all.js"></script>
	<script type="text/javascript" src="<%=requestPath%>/resources/js/index.js"></script>
	<script type="text/javascript" src="<%=requestPath%>/resources/js/cache.js"></script>
	<script type="text/javascript" src="<%=requestPath%>/houtaitool/js/lib/base64.js"></script>
	<script type="text/javascript" src="<%=requestPath%>/houtaitool/js/lib/carhartl-jquery-cookie-92b7715/jquery.cookie.js"></script>
	<script> 
	$(function() {
		// 鼠标移入移出事件
		$('.saoma, .qqqun').hover(function() {
		    $(".qqqun").show();
		}, function() {
			$(".qqqun").hide();
		});
		
		if('${sessionScope.mmqd}' == '1'){
			var index = layui.layer.open({
	            title : "修改密码（当前账户为默认密码，请尽快修改密码）",
	            type : 2,
	            closeBtn: 0,
	            area: ["500px", "400px"],
	            content : ['<%=requestPath%>/userManagemen/toModifyPassword.do','no'],
	            success : function(layero, index){
	                var body = layui.layer.getChildFrame('body', index);
	            },
	            end :function() {
	            }
	        })
	        window.sessionStorage.setItem("index",index);
		}
		
		$(".navBar").on("click","cite",function(){
			if($(this).text()=="革命文物筛查"){
				$(this).parent().removeAttr("data-url");  
				var pathName=window.document.location.pathname;
				var projectPath=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
				var org_id = <%=session.getValue("org_id")%>;
				
				//var storage=window.localStorage;
				//storage["org"] = org_id;
				var url = projectPath + '/houtaitool/index.html';
				sessionStorage.setItem("org",org_id);
				window.open(url);  
				//setCookie("org",org_id,url);
			}
			if($(this).text()=="考核考评"){
				$(this).parent().removeAttr("data-url");  
				var pathName=window.document.location.pathname;
				var projectPath=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
				//var org_id = <%=session.getValue("org_id")%>;
				
				//var storage=window.localStorage;
				//storage["org"] = org_id;
				var url = projectPath + '/registerInfo/getInfoList.do';
				//sessionStorage.setItem("org",org_id);
				window.open(url);  
				//setCookie("org",org_id,url);
			}
		})
	})
	function setCookie(name,value,url) {
		var t = 60; //此 cookie 将被保存 30 分钟
		var expire= new Date();
		var expiresDate = expire.setTime(expire.getTime() + (t * 60 * 1000));
		
		$.cookie(name, value, {
		  path : url,//cookie的作用域
		  expires : expiresDate
		});
		window.open(url);
	}

	</script>
	
</body>
</html>