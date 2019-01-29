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
				margin-top: 25px;
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
		<c:if test="${fn:contains(sessionScope.user.platformId,1)==true}">
			<a href="<%=request.getContextPath()%>/topic/goList.do" rel="<%=request.getContextPath()%>/topic/goList.do" title="专题库" class="listColor zhuantiku">
				<img style="width:16px;height:18px;" src="<%=request.getContextPath() %>/back/images/wclogo.png" alt="" />藏品专题库
			</a>
		</c:if>
	</div>
</body>
</html>