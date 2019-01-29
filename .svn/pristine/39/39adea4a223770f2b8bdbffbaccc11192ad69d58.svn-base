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

<title>藏品管理</title>
<style>
.layui-select-title {
	/* width: 200px; */
}
.shuiyin{
	position: absolute;
    width: 100px;
    top: 50%;
	left:50%;
	transform:translate(-50%,-50%);
}

.myBtn{
    background:#168EFD;
    border-radius:5px;
    font-size:14px;
    font-family:PingFang-SC-Heavy;
    font-weight:800;
    color:rgba(255,255,255,1);
    text-align: center;
    line-height:20px;
    padding: 5px 15px;
    border-width: 0px;
    margin-right: 20px;
}

.selectedNum img{
    margin-right: 12px;
}
.selectedNum span{
    vertical-align: middle;
}
.selectedNum b{
   color: #0077FF;
}
.agileTable{
    width: 1400px;
    margin-left: 40px;
}
.daochu{
    position: relative;
    width: 90px;
    text-align: left;
}
.daochu span{
    display: block;
    position: absolute;
    background-color: white;
    color: #009688;
    width: 30px;
    height: 30px;
    line-height:30px;
    text-align: center;
    top: 0;
    border: 2px solid #009688;
    border-bottom-right-radius: 4px;
    border-top-right-radius: 4px;
    right: 0;
}
.daochuList{
    position: absolute;
    width: 190px;
    background-color: #F4F8F9;
    border-radius: 4px;
    color: #0C0C0C;
    box-shadow:0px 14px 40px 0px rgba(23,128,224,0.1);
    z-index: 100;
    font-size:12px;
    font-family:PingFang-SC-Medium;
    font-weight:500;
    color:rgba(178,184,190,1);
    line-height:17px;
    left: 0;
    top: 35px;
    display: none;
}
.daochuList.show{
    display: block;
}
.daochuList li{
    color:#999;
    padding: 10px;
    text-align: left;
}
.daochuList li:hover{
    cursor: pointer;
    background-color: #009688;
    color: white;
}
.layui-btn:hover {
    opacity: 1;
    filter: alpha(opacity=80);
    /* color: #fff; */
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
							<ul class="list_category" id="categoryList">
								<div class="layui-row">  
									<label class="layui-form-label">常用条件：</label>
									<div class="layui-col-md4 layui-col-lg4">
										<div class="layui-input-inline layui-col-md12 layui-col-lg12">
											<input type="text" id="key" name="key" placeholder="请输入一普编号/藏品名称搜索" autocomplete="off" class="layui-input " >
										</div>
									</div>
									<div class="layui-col-md2 layui-col-lg2">
										<div class="layui-input-inline layui-col-md12 layui-col-lg12">
											<select name="" id="commonYearId" lay-search lay-filter="commonYearId">
												<option value="">常用年代</option>
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
									<div class="layui-col-md2 layui-col-lg2">
										<div class="layui-input-inline layui-col-md12 layui-col-lg12">
											<select name="" id="orhterYearId" lay-search lay-filter="orhterYearId">
												<option value="">其他年代</option>
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
									<div class="layui-col-md2 layui-col-lg2">
                                        <div class="layui-input-inline layui-col-md12 layui-col-lg12">
                                            <select name="gjOpen" id="gjOpen" lay-search>
                                                <option value="">馆际公开状态</option>
                                                <option value="2">已公开</option>
                                                <option value="1">未公开</option>
                                            </select>
                                        </div>
                                    </div>
								</div>
								
								<div class="layui-row">
									<label class="layui-form-label">其他条件：</label>
									<div class="layui-col-md2 layui-col-lg2">
										<div class="layui-input-inline layui-col-md12 layui-col-lg12">
											<select name="collectionsCategory" id="collectionsCategory" lay-search>
												<option value="">藏品类别</option>
												<c:forEach items="${ccList}" var="cc" varStatus="row">
													<option value="${cc.id}">${cc.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="layui-col-md2 layui-col-lg2">
										<div class="layui-input-inline layui-col-md12 layui-col-lg12">
											<select name="collectionLevel" id="collectionLevel"
												lay-search>
												<option value="">文物级别</option>
												<option value="0">珍贵文物</option>
												<option value="1">一级</option>
												<option value="2">二级</option>
												<option value="3">三级</option>
												<option value="4">一般</option>
												<option value="5">未定级</option>
											</select>
										</div>
									</div>
									<div class="layui-col-md2 layui-col-lg2">
										<div class="layui-input-inline layui-col-md12 layui-col-lg12">
											<select name="gsTexture" id="gsTexture" lay-search>
												<option value="">藏品质地</option>
												<option value="1">有机质</option> --%>
												<option value="1">木</option>
												<option value="2">竹</option>
												<option value="3">纸</option>
												<option value="4">毛</option>
												<option value="5">丝</option>
												<option value="6">石</option>
												<option value="7">瓷</option>
												<option value="8">泥</option>
												<option value="9">陶</option>
												<option value="10">铜</option>
												<option value="11">铁</option>
												<option value="12">金</option>
												<option value="13">银</option>
												<option value="14">皮革</option>
												<option value="15">砖瓦</option>
												<option value="16">玻璃</option>
												<option value="17">骨角牙</option>
												<option value="18">宝玉石</option>
												<option value="19">棉麻纤维</option>
												<option value="20">其他金属</option>
												<option value="21">其他植物质</option>
												<option value="22">其他动物质</option>
												<option value="23">其他有机物</option>
												<option value="24">其他无机物</option>
											</select>
										</div>
									</div>
									
									<div class="layui-col-md2 layui-col-lg2">
										<div class="layui-input-inline layui-col-md12 layui-col-lg12">
											<select name="collectionUnit" id="museum" class="select"
												lay-search>
												<option value="">收藏单位</option>
												<c:forEach items="${musList}" var="mus" varStatus="row">
													<option value="${mus.id}">${mus.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									
									<div class="layui-col-md2 layui-col-lg2">
										<div class="layui-input-inline layui-col-md12 layui-col-lg12">
											<select name="isOpen" id="isOpen" lay-search>
												<option value="">公众公开状态</option>
		                                        <option value="3">待审核</option>
		                                        <option value="2">已公开</option>
		                                        <option value="1">未公开</option>
											</select>
										</div>
									</div>
								</div>
								<div class="layui-row">
									<div class="layui-inline" style="margin-left: 25px">
										<button class="layui-btn search_btn" type="button" lay-submit lay-filter="search" id="search">搜索</button>
										<button type="reset" style="margin-left: 17px" id="resetBtn" class="layui-btn layui-btn-primary">重置</button>
										<c:if test="${sessionScope.btn.add eq 1 }">
											<button type="button" class="layui-btn addNews_btn">添加藏品</button>
										</c:if>
										<button type="button" class="layui-btn addToTopic">添加到专题</button>
										<c:if test="${level eq 3 || level eq 4 || level eq 5}">
										<button class="layui-btn daochu openSetting"  style="width:120px;">藏品公开<span>…</span>
									         <ul class="daochuList">
									             <li class="daochuItem" data-type="1">馆际公开</li>
									             <li class="daochuItem" data-type="1">申请公众公开</li>
									             <li class="daochuItem" data-type="1">全部公开</li>
									         </ul>  
									        </button>
									    </c:if>
									</div>
								</div>
							</ul>
						</form>
					</blockquote>
					<table id="collectionsList" lay-filter="collectionsList"></table>
					<!--操作-->
					<script type="text/html" id="collectionsListBar">
<!--
						<c:if test="${sessionScope.btn.show eq 1 }">
							<a class="layui-btn layui-btn-xs layui-btn-primary" lay-event="show">查看</a>
						</c:if>
-->
						<c:if test="${sessionScope.btn.edit eq 1 }">
							{{#  if(d.isOpen == '1'){ }}
								<a class="layui-btn layui-btn-xs " lay-event="edit">编辑</a>
							{{#  } }}
						</c:if>
					
						<c:if test="${sessionScope.btn.top eq 1 }">
							{{#  if(d.sequence == '50'){ }}
								<a class="layui-btn layui-btn-xs " lay-event="top">置顶</a>
  							{{#  } else { }}
								<a class="layui-btn layui-btn-xs " lay-event="down">取消置顶</a>
 							{{#  } }}
						</c:if>
						<c:if test="${sessionScope.btn.del eq 1 }">
							{{#  if(d.isOpen == '1'){ }}
								<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
							{{#  } }}
						</c:if>
					</script>
					<!-- 藏品图片 -->
					<script type="text/html" id="cpimg">
						<a href="{{d.fpic}}" data-lightbox="gallery">
							<img alt="没有图片" class="bbc" src="{{d.picUrl}}" >
						</a>
					</script>
					<!-- 讲解词 -->
					<script type="text/html" id="description">
						{{#  if(d.description == ''){ }}
							<a href="javascript:void(0);" >无</a>
  						{{#  } else { }}
    						<a href="javascript:void(0);" style="width:120px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">{{d.description}}</a>
 						{{#  } }}
					</script>
					<script type="text/html" id="qrcode">
						{{#  if(d.isOpen == 2){ }}
							<a style="text-decoration:none" class="" href="javascript:void(0);" onclick="makeCodeInfo('{{d.id}}',this)"  title="二维码">
								<img src="<%=request.getContextPath() %>/back/images/erweima.png"/>
							</a>
  						{{#  } }}
					</script>
				</form>
			</div>
			<div class="layui-tab-item">
				<blockquote class="layui-elem-quote quoteBox">
					<form class="layui-form">
						<div class="layui-row">
							<label class="layui-form-label">常用条件：</label>
							<div class="layui-col-md4 layui-col-lg4">
								<div class="layui-input-inline layui-col-md12 layui-col-lg12">
									<input type="text" id="key1" name="key" placeholder="请输入一普编号/藏品名称搜索" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-col-md2 layui-col-lg2">
								<div class="layui-input-inline layui-col-md12 layui-col-lg12">
									<select name="collectionsCategory" id="collectionsCategory1"
										lay-search>
										<option value="">文物类别</option>
										<c:forEach items="${ccList1}" var="cc" varStatus="row">
											<option value="${cc.id}">${cc.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="layui-col-md2 layui-col-lg2">
								<div class="layui-input-inline layui-col-md12 layui-col-lg12">
									<select name="collectionUnit" id="museum1" lay-search>
										<option value="">收藏单位</option>
										<c:forEach items="${musList}" var="mus" varStatus="row">
											<option value="${mus.id}">${mus.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="layui-col-md2 layui-col-lg2">
                                  <div class="layui-input-inline layui-col-md12 layui-col-lg12">
                                      <select name="gjOpen" id="gjOpen" lay-search>
                                          <option value="">馆际公开状态</option>
                                          <option value="2">已公开</option>
                                          <option value="1">未公开</option>
                                      </select>
                                  </div>
                            </div>
						</div>
						<div class="layui-row">
							<label class="layui-form-label">其他条件：</label>
							<div class="layui-col-md2 layui-col-lg2">
								<div class="layui-input-inline layui-col-md12 layui-col-lg12">
									<select name="yearTypeEon" class="yearType" id="yearTypeEon" lay-filter="yearTypeEon">
										<option value="">宙</option>
										<c:forEach items="${ytEonList}" var="eon" varStatus="row">
											<option value="${eon.id}">${eon.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="layui-col-md2 layui-col-lg2">
								<div class="layui-input-inline layui-col-md12 layui-col-lg12">
									<select name="yearTypeEra" class="yearType" id="yearTypeEra" lay-filter="yearTypeEra">
										<option value="">代</option>
										<c:forEach items="${ytEraList}" var="era" varStatus="row">
											<option value="${era.id}">${era.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="layui-col-md2 layui-col-lg2">
								<div class="layui-input-inline layui-col-md12 layui-col-lg12">
									<select name="yearTypeEpoch" class="yearTypeEpoch" id="yearTypeEpoch">
										<option value="">纪</option>
										<c:forEach items="${ytEpochList}" var="epoch" varStatus="row">
											<option value="${epoch.id}">${epoch.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
                            <div class="layui-col-md2 layui-col-lg2">
                                <div class="layui-input-inline layui-col-md12 layui-col-lg12">
                                    <select name="isOpen" id="isOpen" lay-search>
                                        <option value="">公众公开状态</option>
                                        <option value="3">待审核</option>
                                        <option value="2">已公开</option>
                                        <option value="1">未公开</option>
                                    </select>
                                </div>
                            </div>
							<div class="layui-col-md2 layui-col-lg2">
								<div class="layui-input-inline layui-col-md12 layui-col-lg12">
									<select name="isHighQuality" id="isHighQuality" lay-search>
										<option value="">馆内精品</option>
										<option value="2">是</option>
										<option value="1">否</option>
									</select>
								</div>
							</div>
						</div>
						<div class="layui-row">
							<div class="layui-inline" style="margin-left: 25px">
								<button class="layui-btn search_btn1" type="button" lay-submit
									lay-filter="search" id="search1">搜索</button>
								<button type="reset" style="margin-left: 17px" id="resetBtn1"
									class="layui-btn layui-btn-primary">重置</button>
		
								<c:if test="${sessionScope.btn.add eq 1 }">
									<button type="button" class="layui-btn addNews_btn1">添加化石</button>
									<button type="button" class="layui-btn addToTopic1">添加到专题</button>
								</c:if>
								<c:if test="${level eq 3 || level eq 4 || level eq 5}">
								<button class="layui-btn daochu openSetting" style="width:120px;" >藏品公开<span>…</span>
                                 <ul class="daochuList">
                                     <li class="daochuItem" data-type="2">馆际公开</li>
                                     <li class="daochuItem" data-type="2">申请公众公开</li>
                                     <li class="daochuItem" data-type="2">全部公开</li>
                                 </ul>  
                                </button>
                                </c:if>
							</div>
						</div>
					</form>
				</blockquote>
				<table id="collectionsFossilList" lay-filter="collectionsFossilList"></table>
				<!--操作-->
				<script type="text/html" id="collectionsFossilListBar">
<!--
					<c:if test="${sessionScope.btn.show eq 1 }">
						<a class="layui-btn layui-btn-xs layui-btn-primary" lay-event="show">查看</a>
					</c:if>
-->
					<c:if test="${sessionScope.btn.edit eq 1 }">
						{{#  if(d.isOpen == '1'){ }}
							<a class="layui-btn layui-btn-xs " lay-event="edit">编辑</a>
						{{#  } }}
					</c:if>
					<c:if test="${sessionScope.btn.top eq 1 }">
						{{#  if(d.sequence == '50'){ }}
							<a class="layui-btn layui-btn-xs " lay-event="top">置顶</a>
  						{{#  } else { }}
							<a class="layui-btn layui-btn-xs " lay-event="down">取消置顶</a>
 						{{#  } }}
					</c:if>
					<c:if test="${sessionScope.btn.del eq 1 }">
						{{#  if(d.isOpen == '1'){ }}
							<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
						{{#  } }}
					</c:if>
				</script>
		<!-- 藏品图片 -->
				<script type="text/html" id="cpimg1">
					<a href="{{d.fpic}}" data-lightbox="gallery">
						<img alt="没有图片" class="bbc" src="{{d.pictureId}}" >
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
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/js/collect/collections/collectionsList.js"></script>

</body>
</html>