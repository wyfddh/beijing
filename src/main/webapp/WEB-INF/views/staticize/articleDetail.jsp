<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<div class="f14 mt10 mb20 b1 bl-5 p0 r3 no-right-radius BCEEE">
						<pre class="b0 p10 BGFFF">${article.brief}</pre>
					</div>	
					<div class="f14 mt-3 imgCenter">${article.content}</div>
				</div>
			</div>
			
		</div>
	</div>
	<!-- footer -->
	<jsp:include page="footer.jsp" flush="true" />
</body>
</html>
