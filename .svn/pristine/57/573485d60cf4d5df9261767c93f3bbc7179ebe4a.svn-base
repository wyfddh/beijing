<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				padding: 7px 20px;
				border-radius: 5px!important;
				text-decoration: none!important;
				margin-right: 24px!important;
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
		</style>
</head>
<body>
	<div class="headerNav">
		<c:if test="${fn:contains(sessionScope.user.level,1)==true}">
			<c:if test="${fn:contains(sessionScope.user.platformId,2)==true}">
					<a href="<%=request.getContextPath()%>/audio/getMipAudioList.do" rel="<%=request.getContextPath()%>/audio/getMipAudioList.do" title="背景音乐管理" class="listColor bgmusic">背景音乐管理</a>
			</c:if>
		</c:if>
		<a href="<%=request.getContextPath()%>/spreadtrum/getSpreadtrum.do" rel="<%=request.getContextPath()%>/spreadtrum/getSpreadtrum.do" title="省内展讯列表" class="listColor spre">
			<img style="width:16px;height:18px;" src="<%=request.getContextPath() %>/back/images/zllogo.png" alt="" />
			展览展讯
		</a>
		<c:if test="${fn:contains(sessionScope.user.platformId,2)==true}">
			<c:if test="${fn:contains(sessionScope.user.level,1)==true}">
				<a href="<%=request.getContextPath()%>/otherSpreadtrum/getOtherSpreadtrum.do?type=1" rel="<%=request.getContextPath()%>/otherSpreadtrum/getOtherSpreadtrum.do?type=1" title="省外展讯列表" class="listColor otherSpre">省外展览列表</a>
				<a href="<%=request.getContextPath()%>/otherSpreadtrum/getOtherSpreadtrum.do?type=2" rel="<%=request.getContextPath()%>/otherSpreadtrum/getOtherSpreadtrum.do?type=2" title="国外展讯列表" class="listColor abroadSpre">国外展览列表</a>
			</c:if>
		</c:if>
		<c:if test="${fn:contains(sessionScope.user.platformId,1)==true}">
			<a href="<%=request.getContextPath()%>/activity/getArticleList.do" rel="<%=request.getContextPath()%>/activity/getArticleList.do" title="活动" class="listColor">
			<img style="width:18px;height:16px;" src="<%=request.getContextPath() %>/back/images/hdlogo.png" alt="" />
				活动
			</a>
			<a href="<%=request.getContextPath()%>/articleJiLin/getArticleList.do" rel="<%=request.getContextPath()%>/articleJiLin/getArticleList.do" title="文创" class="listColor">
				<img style="width:17px;height:17px;" src="<%=request.getContextPath() %>/back/images/wwlogo.png" alt="" />文物故事</a>

			<a href="<%=request.getContextPath()%>/virtual/getVirtual.do" title="虚拟展厅" rel="<%=request.getContextPath()%>/virtual/getVirtual.do" class="listColor">
				<img style="width:18px;height:18px;" src="<%=request.getContextPath() %>/back/images/xnlogo.png" alt="" />虚拟展厅</a>

			<a href="<%=request.getContextPath()%>/wenChuang/getWenChuang.do" rel="<%=request.getContextPath()%>/wenChuang/getWenChuang.do" title="文创" class="listColor">
				<img style="width:12px;height:18px;" src="<%=request.getContextPath() %>/back/images/wclogo.png" alt="" />文创产品</a>
			<%-- <c:if test="${fn:contains(sessionScope.user.level,1)==true}">
				<a href="<%=request.getContextPath()%>/articleJiLin/getArticleList.do" rel="<%=request.getContextPath()%>/articleJiLin/getArticleList.do" title="文创" class="listColor">文章列表</a>
			</c:if> --%>
		</c:if>
					<%-- <c:if test="${fn:contains(sessionScope.user.level,1)==true}">
						<a href="<%=request.getContextPath()%>/regUserManage/info.do" rel="<%=request.getContextPath()%>/regUserManage/info.do" title="轮播图管理" class="listColor">用户详情页</a>
					</c:if> --%>
					<%-- <a href="<%=request.getContextPath()%>/museuminfo/getMuseumPage.do" rel="<%=request.getContextPath()%>/museuminfo/getMuseumPage.do" title="博物馆信息管理" class="listColor">博物馆信息管理</a>
                <a href="<%=request.getContextPath()%>/museumColumn/getMuseumColumn.do" rel="<%=request.getContextPath()%>/museumColumn/getMuseumColumn.do" title="博物馆栏目管理" class="listColor">博物馆栏目管理</a>
                <c:if test="${fn:contains(sessionScope.user.level,1)==true || fn:contains(sessionScope.user.level,2)==true}">
                        <a href="<%=request.getContextPath()%>/museuminfo/getMuseumAll.do" rel="<%=request.getContextPath()%>/museuminfo/getMuseumAll.do" title="选择博物馆" class="listColor">选择博物馆</a>
                </c:if> --%>
			</div>
</body>
</html>