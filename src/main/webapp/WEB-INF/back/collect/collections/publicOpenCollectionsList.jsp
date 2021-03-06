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
	href="<%=request.getContextPath() %>/back/lib/layui/2.4.3/css/layui.css"
	media="all" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/back/css/public/public.css"
	media="all" />
	<link href="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
<!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->

<title>藏品管理</title>
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
.shuiyin{
	position: absolute;
    width: 100px;
    top: 50%;
	left:50%;
	transform:translate(-50%,-50%);
}
</style>
</head>
<body class="childrenBody">
	<div class="layui-tab layui-tab-brief" lay-filter="layTab">
		<ul class="layui-tab-title">
		<c:if test="${level eq 1 || level eq 2}">
			<li  class="${(level eq 1 || level eq 2)   ? 'layui-this' : '' }">待审核</li>
		</c:if>
			<li class="${!(level eq 1 || level eq 2)  ? 'layui-this' : '' }">已公开</li>
		
		</ul>
		<div class="layui-tab-content">
			<c:if test="${level eq 1 || level eq 2}">
			<div class="layui-tab-item layui-show">
				<form class="layui-form">
					<blockquote class="layui-elem-quote quoteBox">
						<form class="layui-form" id="formSearch1" method="post">
							<input type="text" id="pageType" name="pageType" class="layui-hide" value="${pageType }">
							<div class="layui-row">
								<label class="layui-form-label">申请单位：</label>
								<div class="layui-col-md2 layui-col-lg2">
									<div class="layui-input-inline layui-col-md12 layui-col-lg12">
										<select name="collectionUnit" id="applyDept" class="select"
											lay-search>
											<option value="">全部</option>
											<c:forEach items="${musList}" var="mus" varStatus="row">
												<option value="${mus.id}">${mus.name}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="layui-col-md2 layui-col-lg2">
                                        <div class="layui-input-inline layui-col-md12 layui-col-lg12">
                                            <select name="status" id="status" lay-search>
                                                <option value="">状态</option>
                                                <option value="1">待审核</option>
                                                <option value="2">审核通过</option>
                                                <option value="3">审核不通过</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="layui-inline" style="margin-left: 25px">
                                <button class="layui-btn search_btn" type="button" lay-submit
                                        lay-filter="search" id="search">搜索</button>
                                    <button type="reset" style="margin-left: 17px" id="resetBtn"
                                        class="layui-btn layui-btn-primary">重置</button>
                                        <button class="layui-btn " style="width:120px;" id="batchApproval">
                                                                                            批量审核
                                </button>
                            </div>
							</div>						
						</form>
					</blockquote>
					<table id="openCollectionsList" lay-filter="openCollectionsList"></table>
					<!-- 藏品图片 -->
					<script type="text/html" id="cpimg">
						<a href="{{d.fpic}}" data-lightbox="gallery">
							<img alt="没有图片" class="bbc" src="{{d.picUrl}}" >
						</a>
					</script>
				</form>
			</div>
			</c:if>
			<div class="layui-tab-item ${!(level eq 1 || level eq 2)   ? 'layui-show' : '' }">
				<blockquote class="layui-elem-quote quoteBox">
					<form class="layui-form">
						<div class="layui-row">
							<label class="layui-form-label">藏品条件：</label>
<!-- 							<div class="layui-col-md2 layui-col-lg2"> -->
<!-- 								<div class="layui-input-inline layui-col-md12 layui-col-lg12"> -->
<!-- 									<input type="text" id="key1" name="key" placeholder="藏品名称" -->
<!-- 										autocomplete="off" class="layui-input"> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="layui-col-md2 layui-col-lg2"> -->
<!-- 								<div class="layui-input-inline layui-col-md12 layui-col-lg12"> -->
<!-- 									<input type="text" id="gsNo1" name="gsNo" placeholder="请输入一普编号" -->
<!-- 										autocomplete="off" class="layui-input"> -->
<!-- 								</div> -->
<!-- 							</div> -->
							<div class="layui-col-md2 layui-col-lg2">
								<div class="layui-input-inline layui-col-md12 layui-col-lg12">
									<select name="collectionUnit" id="applyDept1" lay-search>
										<option value="">申请单位</option>
										<c:forEach items="${musList}" var="mus" varStatus="row">
											<option value="${mus.id}">${mus.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="layui-inline" style="margin-left: 25px">
                                <button class="layui-btn search_btn1" type="button" lay-submit
                                    lay-filter="search" id="search1">搜索</button>
                                <button type="reset" style="margin-left: 17px" id="resetBtn1"
                                    class="layui-btn layui-btn-primary">重置</button>
                                <button class="layui-btn " style="width:120px;" id="batchRemove">
                                                                                            批量移除
                                </button>
                            </div>
<!-- 							<div class="layui-col-md2 layui-col-lg2"> -->
<!-- 								<div class="layui-input-inline layui-col-md12 layui-col-lg12"> -->
<!-- 									<select name="collectionsCategory" id="collectionsCategory1" -->
<!-- 										lay-search> -->
<!-- 										<option value="">文物类别</option> -->
<%-- 										<c:forEach items="${ccList1}" var="cc" varStatus="row"> --%>
<%-- 											<option value="${cc.id}">${cc.name}</option> --%>
<%-- 										</c:forEach> --%>
<!-- 									</select> -->
<!-- 								</div> -->
<!-- 							</div> -->
							
						</div>
<!-- 						<div class="layui-row"> -->
							
<!-- 						</div> -->
						<input type="text" id="level" name="level" value="${level}" class="layui-hide">
						<input type="text" id="orgId" name="orgId" value="${orgId}" class="layui-hide">
					</form>
				</blockquote>
				<table id="openCollectionsFossilList" lay-filter="openCollectionsFossilList"></table>
				<!-- 藏品图片 -->
				<script type="text/html" id="cpimg1">
					<a href="{{d.fpic}}" data-lightbox="gallery">
						<img alt="没有图片" class="bbc" src="{{d.picUrl}}" >
					</a>
				</script>				
                <script type="text/html" id="openCollectionsListTableBar">
                       <a class="layui-btn layui-btn-xs" lay-event="show">查看</a>
                       <a class="layui-btn layui-btn-xs {{d.status!= 1  ? 'layui-hide' : '' }}" lay-event="approval">审核</a>
                </script>
                <script type="text/html" id="openCollectionsFossilListTableBar">
                       <c:if test="${level eq 1}">
                       <a class="layui-btn layui-btn-xs" lay-event="remove">从公众公开库移除</a>
                      </c:if>
                      <c:if test="${!(level eq 1)}">
                       <a class="layui-btn layui-btn-xs {{checkAuth("${orgId}",d.collectionUnit) ? 'layui-hide' : '' }}" lay-event="remove">从公众公开库移除</a>
                      </c:if>
                </script>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/layui/2.4.3/layui.js"></script>
		<script type="text/javascript"
        src="<%=request.getContextPath() %>/back/lib/layui/2.4.3/layer/layer.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/js/collect/collections/publicOpenCollectionsList.js"></script>

</body>
</html>