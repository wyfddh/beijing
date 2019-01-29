<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="<%=request.getContextPath()%>/back/favicon.ico">
<link rel="Shortcut Icon" href="<%=request.getContextPath()%>/back/favicon.ico" />
<title>Insert title here</title>
	<style>
		.headerNav{
			height: 98px;
			/*width: 100%;*/
			border-radius: 7px;
			background: #fff;
			position: absolute;
		    top: 0px;
		    left: 145px;
		    right: 0;
    		bottom: 0;
		    line-height: 98px;
		    padding-left: 30px;
		}
		.headerNav a{
			color: #2A9BCF!important;
			display: inline-block;
			height: 24px;
			line-height: 24px;
			border: 1px solid #2A9BCF;
			border-radius: 5px!important;
			text-decoration: none!important;
		}
		.headerNav a:hover{
			color: #2A9BCF!important;
			background: #fff!important;
		}
		.headerNav a.active{
			color: #fff!important;
			background: #2A9BCF!important;
		}
		.headerNav a img{
			width: 18px;
			height: 18px;
			margin-top: -5px;
			margin-right: 5px;
		}
		.addZhanxun{
			overflow: hidden;
			height: 72px;
			border-bottom: 1px solid #F1F2F7;
		}
		.addZhanxun>span{
			margin: 20px 32px;
		}
		.addZhanxun>span>a{
			background: #2A9BCF!important;
		}
		.addZhanxun>span>a:hover{
			border-color: #2A9BCF!important;
		}
		.info{
			padding-left: 32px;
		}
		.info div{
			margin: 10px 0;
		}
		.info input{
			line-height: 26px;
			border-radius: 5px;
		}
		.info .star{
			margin-top: 20px;
		}
		.info .star button{
			background: #2A9BCF;
			color: #fff;
			border-radius: 5px;
		}
		.info .star button img{
			margin-top: -3px;
		}
		.info .star button.b2{
			background: #fff;
			color: #2A9BCF;
			border-color: #2A9BCF;
		}
		tbody .text-c{
			border-bottom: 1px solid #DDDDDD;
		}
		thead>tr{
			background: #F1F2F7!important;
			height: 60px!important;
			border-radius: 7px!important;
		}
		thead>tr>th{
			color: #666666!important;
		}
		@media only screen and (min-width: 1655px){
			.headerNav a.padding_max_anv{
				padding: 7px 12px;
				margin-right: 0px!important;
			}
		}
		@media only screen and (min-width: 1500px){
			.headerNav a.padding_max{
				padding: 7px 12px;
				margin-right: 0px!important;
			}
		}
		@media only screen and (min-width: 1370px) and (max-width:1500px){
			.headerNav a.padding_second{
				padding: 7px 7px;
				margin-right: 0px!important;
			}
		}
		@media only screen and (min-width: 1235px) and (max-width:1360px){
			.headerNav a.padding_third{
				padding: 5px 2px;
				margin-right: 2px!important;
			}
		}
		@media only screen and (min-width: 1124px) and (max-width:1235px){
			.headerNav a.forth{
				padding: 4px 1px;
				margin-right: 1px!important;
			}
			.headerNav a img{
				margin-right:0;
				width:13px;
				height:13px;
				margin-top:-3px;
			}
		}
	</style>
</head>
<body>
	<div class="headerNav">
		<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
		<a href="<%=request.getContextPath()%>/museuminfo/getMuseumPage.do" rel="<%=request.getContextPath()%>/museuminfo/getMuseumPage.do" title="网站维护" class="wangzhanweihu padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:18px;height:18px;" src="<%=request.getContextPath() %>/back/images/webweihu.png" alt="" />
			网站维护
		</a>
		<a href="<%=request.getContextPath()%>/museuminfo/getMuseumName.do" rel="<%=request.getContextPath()%>/museuminfo/getMuseumName.do" title="基本信息" class="jibenxinxi basicInfo padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:16px;height:18px;" src="<%=request.getContextPath() %>/back/images/jibeninfo.png" alt="" />
			基本信息
		</a>
		<a href="<%=request.getContextPath()%>/image/toWaterMark.do" rel="<%=request.getContextPath()%>/image/toWaterMark.do" title="水印管理" class="waterImg  padding_max padding_second padding_third forth padding_max_anv">
				<img style="width:16px;height:18px;" src="<%=request.getContextPath() %>/back/images/zllogo.png" alt="" />水印
			</a>
		</c:if>
		<c:if test="${fn:contains(sessionScope.user.level,1)==true || fn:contains(sessionScope.user.level,2)==true}">
		<a href="<%=request.getContextPath()%>/curation/curation.do" rel="" title="策展管理" class="cezhanguanli padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:15px;height:18px;" src="<%=request.getContextPath() %>/back/images/cezhan.png" alt="" />
			策展管理
		</a>
		<c:if test="${fn:contains(sessionScope.user.level,1)==true}">
			<a href="<%=request.getContextPath()%>/turnimggrid/getMipCarouselPositionList.do" rel="" title="轮播图管理" class="turnImg padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:23px;height:15px;" src="<%=request.getContextPath() %>/back/images/lunbotu.png" alt="" />
			轮播图管理
		</a>
		</c:if>
		<%-- <a href="<%=request.getContextPath()%>/getUser/user/userAdmin.do" rel="" title="用户账号管理" class="userguanli padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:17px;height:13px;" src="<%=request.getContextPath() %>/back/images/userGuanli.png" alt="" />
			用户账户管理
		</a> --%>
		</c:if>
		<a href="<%=request.getContextPath()%>/userManagemen/list.do" title="账户管理" class="zhanghuguanli padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:18px;height:15px;" src="<%=request.getContextPath() %>/back/images/bowuguan.png" alt="" />
			账户管理
		</a>
		<%-- <a href="<%=request.getContextPath()%>/admin/user/adminList.do" title="管理员账号管理" class="guanliyuanguanli padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:18px;height:15px;" src="<%=request.getContextPath() %>/back/images/bowuguan.png" alt="" />
			管理员账号管理
		</a> --%>
		<a href="<%=request.getContextPath()%>/role/info.do" title="角色管理" class="jueseguanli padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:14px;height:16px;" src="<%=request.getContextPath() %>/back/images/juse.png" alt="" />
			角色管理
		</a>
		<a href="<%=request.getContextPath()%>/menu/goList.do" title="菜单管理" class="caidanguanli padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:14px;height:16px;" src="<%=request.getContextPath() %>/back/images/juse.png" alt="" />
			菜单管理
		</a>
		<a href="<%=request.getContextPath()%>/organization/museum/info.do" title="组织机构" class="zuzhijigou museum padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:16px;height:16px;" src="<%=request.getContextPath() %>/back/images/jigoubowuguan.png" alt="" />
			组织机构
		</a>
		<%-- <c:if test="${fn:contains(sessionScope.user.level,1)==true }">
		<a href="<%=request.getContextPath()%>/organization/relic/info.do" title="文物局" class="zuzhijigou wenwuju padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:16px;height:14px;" src="<%=request.getContextPath() %>/back/images/jigou.png" alt="" />
			组织机构-文物局
		</a>
		</c:if>
		<c:if test="${fn:contains(sessionScope.user.level,1)==true || fn:contains(sessionScope.user.level,2)==true}">
		<a href="<%=request.getContextPath()%>/organization/museum/info.do" title="博物馆" class="zuzhijigou museum padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:16px;height:16px;" src="<%=request.getContextPath() %>/back/images/jigoubowuguan.png" alt="" />
			组织机构--博物馆
		</a>
		</c:if> --%>
		<c:if test="${fn:contains(sessionScope.user.level,1)==true || fn:contains(sessionScope.user.level,2)==true}">
		<a href="<%=request.getContextPath()%>/back/pictureSearch/index.do" title="以图搜图" class="yitusoutu padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:16px;height:16px;" src="<%=request.getContextPath() %>/back/images/yitu.png" alt="" />
			以图搜图
		</a>
		</c:if>
		<a href="<%=request.getContextPath()%>/back/audioSearch/index.do" title="讲解词审核" class="checkAudio padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:14px;height:16px;" src="<%=request.getContextPath() %>/back/images/check_audio_active.png" alt="" />
			讲解词审核
		</a>
		<a href="<%=request.getContextPath()%>/museumInfoManage/info.do" title="博物馆信息运营" class="manage padding_max padding_second padding_third forth padding_max_anv">
			<img style="width:14px;height:16px;" src="<%=request.getContextPath() %>/back/images/check_audio_active.png" alt="" />
			博物馆信息运营
		</a>
		<%-- <a href="<%=request.getContextPath()%>/museuminfo/getMuseumPage.do" rel="<%=request.getContextPath()%>/museuminfo/getMuseumPage.do" title="博物馆信息管理" class="listColor">博物馆信息管理</a>
			<a href="<%=request.getContextPath()%>/museumColumn/getMuseumColumn.do" rel="<%=request.getContextPath()%>/museumColumn/getMuseumColumn.do" title="博物馆栏目管理" class="listColor">博物馆栏目管理</a>
			<c:if test="${fn:contains(sessionScope.user.level,1)==true || fn:contains(sessionScope.user.level,2)==true}">
					<a href="<%=request.getContextPath()%>/museuminfo/getMuseumAll.do" rel="<%=request.getContextPath()%>/museuminfo/getMuseumAll.do" title="选择博物馆" class="listColor">选择博物馆</a>
			</c:if> --%>
		
	</div>
</body>
</html>