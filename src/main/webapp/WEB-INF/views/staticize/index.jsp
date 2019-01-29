<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="css.jsp" flush="true" />
</head>
<body class="BG_COLOR">
	<!-- top navbar -->
	<jsp:include page="topNav.jsp" flush="true" />
	<!-- Top Search-->
	<jsp:include page="topSearch.jsp" flush="true" />
	
	<div class="container p0 mt20">
		<div class="row min-h p0 m0">
			<!-- leftMenu -->
			<jsp:include page="left.jsp" flush="true" />
			<div class="col-xs-9 p0 BG_COLOR m0 pt0">
				<div class="BGFFF min-h500 p20">
					<div class="col-xs-12 p3 pl10 mr10 f14 fb mb20 adorn-bl-3">文章列表233333</div>
					<div class="cb"></div>
					<c:forEach var="f" items="${articleList}" varStatus="status">
						<div class="dashed-t">
							<a href="${f.id}.html" class="p10 pl0 f16 fb dis w C000 no_unl">${f.name}</a>
							<div class ="f14 C555">${f.brief}</div>
							<div class="tr C999 f12 p10"><span class="C999 pl20">${f.createTime}</span></div>
						</div>
					</c:forEach>
				</div>
			</div>
			
		</div>
	</div>

	<!-- footer -->
	<jsp:include page="footer.jsp" flush="true" />
</body>
</html>
