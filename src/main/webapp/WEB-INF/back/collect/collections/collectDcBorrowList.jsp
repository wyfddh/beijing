<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">

<link rel="Bookmark"
	href="<%=request.getContextPath() %>/back/favicon.ico">
<link rel="Shortcut Icon"
	href="<%=request.getContextPath() %>/back/favicon.ico" />

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"
	media="all" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/back/css/public/public.css"
	media="all" />
<link href="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
<!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->

<title>馆际交流</title>
<style>


.layui-select-title {
	/* width: 250px; */
}

.laytable-cell-1-cpimg {
	height: 100%;
	max-width: 100%;
	position: relative;
}

.laytable-cell-1-cpimg img {
	max-width: 100%;
	max-height: 100%;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.list_category {
	height: 40px;
	overflow: hidden;
}
</style>
</head>
<body class="childrenBody">
	<div class="layui-tab layui-tab-brief" lay-filter="layTab">
		<ul class="layui-tab-title">
			<li class="layui-this">文物</li>
			<li>标本化石</li>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<form class="layui-form">
					<blockquote class="layui-elem-quote quoteBox">
						<form class="layui-form" id="formSearch1" method="post">
							<input type="text" id="pageType" name="pageType" class="layui-hide" value="${pageType }">
							<div class="layui-row">
								<label class="layui-form-label">藏品名称：</label>
								<div class="layui-col-md2 layui-col-lg2">
									<div class="layui-input-inline layui-col-md12 layui-col-lg12">
										<input type="text" id="key" name="key" placeholder="藏品名称" autocomplete="off" class="layui-input">
									</div>
								</div>
								<label class="layui-form-label">一普编号：</label>
								<div class="layui-col-md2 layui-col-lg2">
									<div class="layui-input-inline layui-col-md12 layui-col-lg12">
										<input type="text" id="gsNo" name="gsNo" placeholder="请输入一普编号"
											autocomplete="off" class="layui-input">
									</div>
								</div>
								<label class="layui-form-label">收藏单位：</label>
								<div class="layui-col-md2 layui-col-lg2">
									<div class="layui-input-inline layui-col-md12 layui-col-lg12 ">
										<select name="collectionUnit" id="museum" class="select"
											lay-search>
											<option value="">全部</option>
											<c:forEach items="${musList}" var="mus" varStatus="row">
												<option value="${mus.id}">${mus.name}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="layui-row">
								<label class="layui-form-label">常用年代：</label>
								<div class="layui-col-md2 layui-col-lg2">
									<div class="layui-input-inline layui-col-md12 layui-col-lg12 ">
										<select name="" id="commonYearId" lay-search
											lay-filter="commonYearId">
											<option value="">全部</option>
											<option value="45">新石器时代</option>
											<option value="48">商</option>
											<option value="49">周</option>
											<option value="50">西周</option>
											<option value="51">东周</option>
											<option value="55">汉</option>
											<option value="56">西汉</option>
											<option value="57">东汉</option>
											<option value="79">唐</option>
											<option value="87">宋</option>
											<option value="93">元</option>
											<option value="94">明</option>
											<option value="95">清</option>
											<option value="96">民国</option>
											<option value="97">中华人民共和国</option>
										</select>
									</div>
								</div>
								<label class="layui-form-label">其他年代：</label>
								<div class="layui-col-md2 layui-col-lg2">
									<div class="layui-input-inline layui-col-md12 layui-col-lg12 ">
										<select name="" id="orhterYearId" lay-search
											lay-filter="orhterYearId">
											<option value="">全部</option>
											<c:forEach items="${ytList}" var="yt" varStatus="row">
												<c:if
													test="${yt.id != 45 && yt.id != 48 &&yt.id != 49 &&yt.id != 50 &&yt.id != 51 &&yt.id != 55 &&yt.id != 56 &&yt.id != 57 &&yt.id != 79 &&yt.id != 87 &&yt.id != 93 &&yt.id != 94 &&yt.id != 95 &&yt.id != 96 &&yt.id != 97}">
													<option value="${yt.id}">${yt.name}</option>
												</c:if>
											</c:forEach>
										</select>
									</div>
								</div>
								<input type="text" id="yearType" class="layui-hide">
								<label class="layui-form-label">文物类别：</label>
								<div class="layui-col-md2 layui-col-lg2">
									<div class="layui-input-inline layui-col-md12 layui-col-lg12 ">
										<select name="collectionsCategory" id="collectionsCategory"
											lay-search>
											<option value="">全部</option>
											<c:forEach items="${ccList}" var="cc" varStatus="row">
												<option value="${cc.id}">${cc.name}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="layui-inline">
									<button class="layui-btn search_btn" type="button" lay-submit
										lay-filter="search" id="search">搜索</button>
									<button type="reset" id="resetBtn"
										class="layui-btn layui-btn-primary">重置</button>
								</div>
							</div>

						</form>
					</blockquote>
					<table id="collectDcBorrowList" lay-filter="collectDcBorrowList"></table>
					<!-- 藏品图片 -->
					<script type="text/html" id="cpimg">
					<a href="{{d.fpic}}" data-lightbox="gallery">
						<img alt="没有图片" class="bbc" src="{{d.picUrl}}" >
					</a>
					</script>
				</form>
			</div>
			<div class="layui-tab-item">
				<blockquote class="layui-elem-quote quoteBox">
					<form class="layui-form">
						<div class="layui-row">
							<label class="layui-form-label">藏品名称：</label>
							<div class="layui-col-md2 layui-col-lg2">
								<div class="layui-input-inline layui-col-md12 layui-col-lg12">
									<input type="text" id="key1" name="key" placeholder="藏品名称"
										autocomplete="off" class="layui-input inputHead">
								</div>
							</div>
							<label class="layui-form-label">一普编号：</label>
							<div class="layui-col-md2 layui-col-lg2">
								<div class="layui-input-inline layui-col-md12 layui-col-lg12">
									<input type="text" id="gsNo1" name="gsNo" placeholder="请输入一普编号"
										autocomplete="off" class="layui-input inputHead">
								</div>
							</div>
							<label class="layui-form-label">收藏单位：</label>
							<div class="layui-col-md2 layui-col-lg2">
								<div class="layui-input-inline layui-col-md12 layui-col-lg12 ">
									<select name="collectionUnit" id="museum1" lay-search>
										<option value="">全部</option>
										<c:forEach items="${musList}" var="mus" varStatus="row">
											<option value="${mus.id}">${mus.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="layui-row">
							<label class="layui-form-label">常用年代：</label>
							<div class="layui-col-md2 layui-col-lg2">
								<div class="layui-input-inline layui-col-md12 layui-col-lg12 ">
									<select name="" id="commonYearId1" lay-search
										lay-filter="commonYearId1">
										<option value="">全部</option>
										<option value="45">新石器时代</option>
										<option value="48">商</option>
										<option value="49">周</option>
										<option value="50">西周</option>
										<option value="51">东周</option>
										<option value="55">汉</option>
										<option value="56">西汉</option>
										<option value="57">东汉</option>
										<option value="79">唐</option>
										<option value="87">宋</option>
										<option value="93">元</option>
										<option value="94">明</option>
										<option value="95">清</option>
										<option value="96">民国</option>
										<option value="97">中华人民共和国</option>
									</select>
								</div>
							</div>
							<label class="layui-form-label">其他年代：</label>
							<div class="layui-col-md2 layui-col-lg2">
								<div class="layui-input-inline layui-col-md12 layui-col-lg12 ">
									<select name="" id="orhterYearId1" lay-search
										lay-filter="orhterYearId1">
										<option value="">全部</option>
										<c:forEach items="${ytList}" var="yt" varStatus="row">
											<c:if
												test="${yt.id != 45 && yt.id != 48 &&yt.id != 49 &&yt.id != 50 &&yt.id != 51 &&yt.id != 55 &&yt.id != 56 &&yt.id != 57 &&yt.id != 79 &&yt.id != 87 &&yt.id != 93 &&yt.id != 94 &&yt.id != 95 &&yt.id != 96 &&yt.id != 97}">
												<option value="${yt.id}">${yt.name}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
							</div>
							<input type="text" id="yearType1" class="layui-hide">
							<label class="layui-form-label">文物类别：</label>
							<div class="layui-col-md2 layui-col-lg2">
								<div class="layui-input-inline layui-col-md12 layui-col-lg12 ">
									<select name="collectionsCategory" id="collectionsCategory1"
										lay-search>
										<option value="">全部</option>
										<c:forEach items="${ccList}" var="cc" varStatus="row">
											<option value="${cc.id}">${cc.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="layui-inline">
								<button class="layui-btn search_btn1" type="button" lay-submit
									lay-filter="search" id="search1">搜索</button>
								<button type="reset" id="resetBtn1"
									class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
					</form>

				</blockquote>
				<table id="collectDcBorrowFossilList"
					lay-filter="collectDcBorrowFossilList"></table>
				<!-- 藏品图片 -->
				<script type="text/html" id="cpimg1">
				<a href="{{d.fpic}}" data-lightbox="gallery">
					<img alt="没有图片" class="bbc" src="{{d.picUrl}}" >
				</a>
				</script>

			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/js/collect/collections/collectDcBorrowList.js"></script>

</body>
</html>