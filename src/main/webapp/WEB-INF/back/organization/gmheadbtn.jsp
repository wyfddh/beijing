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
			    left: 0px;
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
		
	
		<c:if test="${fn:contains(sessionScope.user.orgTypeId,3)==true}">
			<a href="<%=request.getContextPath()%>/registerInfo/getInfoList.do"  rel="<%=request.getContextPath()%>/registerInfo/getInfoList.do"  title="考评申报" class="report ">考评申报</a>
		</c:if>
		<c:if test="${fn:contains(sessionScope.user.orgTypeId,2)==true || fn:contains(sessionScope.user.orgTypeId,1)==true}">
			<a href="<%=request.getContextPath()%>/registerInfo/getInfoList.do" rel="<%=request.getContextPath()%>/registerInfo/getInfoList.do" title="考评审核" class="reportAudit ">考评审核</a>
		</c:if>
		
		<a href="<%=request.getContextPath()%>/gmWork/workList.do" style='margin-top:29px' rel="<%=request.getContextPath()%>/gmWork/workList.do" title="工作总结" class="work">工作总结</a>
		
		<c:if test="${fn:contains(sessionScope.user.orgTypeId,1)==true }">
			<a href="<%=request.getContextPath()%>/gmMuseumStatistics/list.do" rel="<%=request.getContextPath()%>/gmMuseumStatistics/list.do" title="博物馆统计" class="museumStatistics">博物馆统计</a>
		</c:if>
	</div>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
</body>
 
</html>