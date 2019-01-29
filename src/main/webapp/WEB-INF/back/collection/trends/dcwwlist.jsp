<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--  <%@ page import="com.tj720.mip.utils.HasAuth" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico">
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="back/lib/html5.js"></script>
<script type="text/javascript" src="back/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
	<link href="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<style>
body{
	width: 100%;
    background: url(/admin/back/images/bg_body.png) !important;
    height: 100%;
    background-size: cover
}
   .lig{
    	line-height:30px;
    }
    .navbar-wrapper{
    	display: none;
    }
    .Hui-article-box{
    	top: 0 !important;
    	background:0 !important;
    }
    .Hui-article{
    	top: 0 !important;
    }
    .zj_wwlist_content{
    	padding: 0 !important;
    }
    .zj_wwlist_chose{
    	background-color: white;
    	border-top-left-radius: 5px;
    	border-bottom-left-radius: 5px;
    	padding: 30px 30px 0px 30px;
    	padding-left:0 !important;
    	margin-top:70px;
    }
    .zj_wwlist_chose input{
    	border: 1px solid #f1f2f7;
    	border-radius: 5px;
    	outline: none;
    	padding-left: 20px;
    	width: 60%;
    }
    .zj_wwlist_radio{
    	width: auto !important;
    	margin-left: 10px !important;
    }
    .zj_wwlist_addColl{
    	margin-bottom: 18px;
    }
    .zj_wwlist_chose select{
    	border: none;
    	outline: none !important;
    }
    .zj_wwlist_chose span{
    	border-radius: 5px;
    }
    #reset{
    	color: #2a9bcf;
    	background-color: white;
    	border: 1px solid #2a9bcf;
    }
    #reset>img{
    	display: block;
    	float: left;
    	margin-right: 5px;
    	margin-top: 3px;
    }
    .zj_wwlist_gongkai{
    	background-color: white !important;
    	border: 1px solid #2a9bcf !important;
    	color: #2a9bcf !important;
    }
    .zj_wwlist_shuaxing>img{
    	padding-top:23px;
    }
    .zj_wwlist_shuaxing{
    	display: block;
    	float: right;
    	margin: 3px 0 0 15px;
    }
    .zj_wwlist_table{
    	background-color: white;
    	border-top: 3px solid #f1f2f7;
    	padding-top: 6px;
    }
    .zj_wwlist_table td,th,table{
    	border: none !important;
    }
    .zj_wwlist_table thead>tr:nth-child(1){
    	background-color: #f1f2f7 !important;
    	border-radius: 5px;
    }
    .zj_wwlist_table th{
    	padding-top: 24px !important;
    	padding-bottom: 24px !important;
    }
    #laypage_0{
    	text-align: left;
    	margin: 0;
    	padding: 40px 0 0 20px;
    	border-top: 3px solid #f1f2f7;
    	background-color: white;
    }
    .list_category {
    	height:80px;
    	overflow: hidden;
    }
    .more{
    	text-align:center;
    }
    .add_audio{
    	display: none;
    }
    .checkList_content{
		border: 1px solid #f1f2f7;
		width: 520px;
		height: 270px;
		padding: 6px 10px;
		font-size: 14px;
		background-color: #fcfcfc;
		border-radius: 5px;
		resize:none;
	}
	.zj_checkList_save{
	    display: block;
	    float: left;
		background-color: #2a9bcf;
		color: white;
		padding: 9px 15px 9px 35px;
		border-radius: 5px;
		text-decoration: none;
		height: 18px;
		line-height: 18px;
		border: 1px solid #2a9bcf;
		height: 36px;
		background-image: url(../images/save.png);
		background-repeat: no-repeat;
		background-position: 10px center;
		margin: 32px 0 15px 0px;
		cursor: pointer;
	}
	.zj_checkList_cancel{
		display: block;
		float: left;
		background-color: white;
		color: #2a9bcf;
		padding: 9px 15px 9px 35px;
		border-radius: 5px;
		text-decoration: none;
		height: 18px;
		line-height: 18px;
		border: 1px solid #2a9bcf;
		height: 36px;
		background-image: url(../images/cancel.png);
		background-repeat: no-repeat;
		background-position: 10px center;
		margin: 32px 0 15px 15px;
		cursor: pointer;
	}
	.rinm{
		margin-top:-88px;
	}
	.rinm1{
		margin-top:-32px;
	}
	@media only screen and (max-width:1366px ) {
	.cpmc input{
		width:52%;
	}
	.ypbh input{
		width:52%;
	}
	.cynd select{
		width:auto !important;
	}
	.qtnd span{
		width:50% !important;
	}
	.qtnd select{
		width:100% !important;
	}
	.select{
		width:100% !important;
	}
	.scdw>span{
		width:54% !important;
	}
	.scdw>span>select{
		width:48% !important;
	}
	.wccd>span{
		width:55% !important;
	}
	}
</style>
<title>藏品列表</title>
</head>
<body>
	<!--/_menu 作为公共模版分离出去-->
	<%@ include file="../../content/aside.jsp" %>
	<section class="Hui-article-box">
		<form action="/admin/back/oCCollection/info.do?type=1" method="get" id="form">
			<div class="hide">   
	        	每页显示条数:&nbsp; 
	            <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${page.size }" name="size">
	        </div> 
			<div class="Hui-article">
				<article class="cl pd-20 zj_wwlist_content">
					<input type="hidden" value="1" name="type"/>
					<%@ include file="../trendsheader.jsp"%>

					<div class="zj_wwlist_chose">
						<ul class="secondtitle" style="top:-96px;left:-30px">
							<li>
								<!--<a href="/mip/back/fCCollection/info.do" title="一普数据列表" style="font-size:16px!important;">一普数据列表</a>-->
								<ul class="thirdTitle">
									<li class="zj_public_wenwu" style="margin-right:-14px">
										<a style="border:0;background:#ffffff;color:#2a9bcf;" href="/admin/back/oCCollection/info.do?type=1" rel="/mip/back/oCCollection/info.do?type=1" title="文物藏品类别">
											<img src="<%=request.getContextPath() %>/back/images/zj_wenwu.png"/>
											文物表
										</a>
									</li>
									<li class="zj_public_haushi">
										<a  style="border:0;background:#bfd5e1;z-index:-10;color:#ffffff" href="/admin/back/oCFossil/info.do?type=1" rel="/mip/back/oCFossil/info.do?type=1" title="化石藏品类别">
											<img src="<%=request.getContextPath() %>/back/images/zj_huashi_chose.png"/>
											标本化石
										</a>
									</li>
								</ul>
							</li>
						</ul>
						<!-- 
						<div class="col-md-12">
							<div class="col-md-12">
								<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
									<c:if test="${fn:contains(sessionScope.user.authStr,'collectionAdmin')==true}">
										<a href="<%=request.getContextPath()%>/back/oCCollection/toAdd.do" onclick="add()" class="btn btn-primary radius zj_wwlist_addColl" style="background:rgb(42, 155, 207)!important;"><i class="Hui-iconfont mr-5">&#xe600;</i>添加藏品</a>
									</c:if>
								</c:if>
							</div>
						</div>
 						-->
						<div class="col-xs-12"  style="margin-bottom: 13px;margin-top:-88px">
							<ul class="list_category" id="categoryList">
								<div class="col-xs-12" style="margin-bottom: 13px;">
									<div class="col-xs-12 col-sm-3 col-md-3 cangpin">
										<label class="">藏品名称 &nbsp&nbsp&nbsp&nbsp&nbsp ：</label>
				                    	<input type="text" name="key" id="key" value="${key}" placeholder="藏品名称" class="input-text" maxlength="100">
									</div>
									<div class="col-xs-12 col-sm-8 col-md-8">
										<label class="">藏品编号&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp：</label>
				                    	<input type="text" name="gsCollectionsNo" id="gsCollectionsNoId" value="${mipOpenCulturalrelicInfo.gsCollectionsNo}" placeholder="可输入多条藏品编号,以空格隔开,最多50条" class="input-text">
				                    	<%-- <textarea name = "gsCollectionsNo" id = "gsCollectionsNoId" style='border: 1px solid #94BBE2; width:355px;height:30px;overflow: hidden;font-size:1.3em;
				                    	display: table-cell; vertical-align: middle;line-height:25px;' rows=1>${mipOpenCulturalrelicInfo.gsCollectionsNo}</textarea> --%>
				                    	<%-- <textarea class="textarea" name = "gsCollectionsNo" id = "gsCollectionsNoId" style='width:356px;height:30px;overflow: hidden;font-size:1.3em;
				                    	display: table-cell; vertical-align: middle;' rows=1>${mipOpenCulturalrelicInfo.gsCollectionsNo}</textarea>--%>
									</div>
								</div>
								<div class="col-xs-12" style="margin-bottom: 13px;">
									<div class="col-xs-12 col-sm-3 col-md-3 yibu">
										<label class="">一普编号 &nbsp&nbsp&nbsp&nbsp&nbsp ：</label>
				                    	<input type="text" name="gsNo" id="gsNo" value="${gsNo}" placeholder="请输入一普编号" class="input-text" maxlength="100">
									</div>
									<div class="col-xs-12 col-sm-3 col-md-3">
										<label class="">公开状态&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp：</label>
									    <span class="">
									    	<!-- 省级管理员 -->
									    	<c:if test="${fn:contains(sessionScope.user.level,1)}">
									    		<label><input class="zj_wwlist_radio" name="levelStatus" type="radio" value="1,3,4" <c:if test="${'1,3,4' eq levelStatus}">checked</c:if>/>全部 </label>
									    		<label><input class="zj_wwlist_radio" name="levelStatus" type="radio" value="3" <c:if test="${'3' eq levelStatus}">checked</c:if>/>待审核</label>
									    		<label><input class="zj_wwlist_radio" name="levelStatus" type="radio" value="4" <c:if test="${'4' eq levelStatus}">checked</c:if>/>审核通过</label>
									    		<label><input class="zj_wwlist_radio" name="levelStatus" type="radio" value="1" <c:if test="${'1' eq levelStatus}">checked</c:if>/>未通过</label>
									    	</c:if>
									    	<!-- 博物馆级管理员 -->
									    	<c:if test="${fn:contains(sessionScope.user.level,3)}">
									    		<label><input class="zj_wwlist_radio" name="levelStatus" type="radio" value="1,2,4" <c:if test="${'1,2,4' eq levelStatus}">checked</c:if>/>全部 </label>
									    		<label><input class="zj_wwlist_radio" name="levelStatus" type="radio" value="2" <c:if test="${'2' eq levelStatus}">checked</c:if>/>待审核</label>
									    		<label><input class="zj_wwlist_radio" name="levelStatus" type="radio" value="4" <c:if test="${'4' eq levelStatus}">checked</c:if>/>审核通过</label>
									    		<label><input class="zj_wwlist_radio" name="levelStatus" type="radio" value="1" <c:if test="${'1' eq levelStatus}">checked</c:if>/>未通过</label>
									    	</c:if>
									    </span>
								    </div>
								    <div class="col-xs-12 col-sm-3 col-md-3 cynd">
										<label class="">常用年代：</label>
										<span class="select-box inline">
										<select name="" class="select" id="commonYearId" style="width:220px;">
											<option value="">全部</option>
											<option value="45" <c:if test="${45 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>新石器时代</option>
											<option value="48" <c:if test="${48 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>商</option>
											<option value="49" <c:if test="${49 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>周</option>
											<option value="50" <c:if test="${50 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>西周</option>
											<option value="51" <c:if test="${51 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>东周</option>
											<option value="55" <c:if test="${55 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>汉</option>
											<option value="56" <c:if test="${56 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>西汉</option>
											<option value="57" <c:if test="${57 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>东汉</option>
											<option value="79" <c:if test="${79 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>唐</option>
											<option value="87" <c:if test="${87 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>宋</option>
											<option value="93" <c:if test="${93 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>元</option>
											<option value="94" <c:if test="${94 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>明</option>
											<option value="95" <c:if test="${95 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>清</option>
											<option value="96" <c:if test="${96 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>民国</option>
											<option value="97" <c:if test="${97 eq mipOpenCulturalrelicInfo.yearType}">selected</c:if>>中华人民共和国</option>
										</select>
										</span>
									</div>
									<div class="col-xs-12 col-sm-3 col-md-3 qtnd" style="margin-left:-60px">
										<label class="">其他年代：</label>
										<span class="select-box inline">
										<select name="" class="select" id="orhterYearId" style="width:220px;">
											<option value="">全部</option>
											<c:forEach items="${ytList}" var="yt" varStatus="row">
												<c:if test="${yt.id != 45 && yt.id != 48 &&yt.id != 49 &&yt.id != 50 &&yt.id != 51 &&yt.id != 55 &&yt.id != 56 &&yt.id != 57 &&yt.id != 79 &&yt.id != 87 &&yt.id != 93 &&yt.id != 94 &&yt.id != 95 &&yt.id != 96 &&yt.id != 97}">
													<option value="${yt.id}" <c:if test="${yt.id eq mipOpenCulturalrelicInfo.yearType}">selected</c:if> >${yt.name}</option>
												</c:if>
											</c:forEach>
										</select>
										</span>
									</div>
								</div>
								<div class="col-xs-12" style="margin-bottom: 13px;">
									<div class="col-xs-12 col-sm-3 col-md-3">
										<label class="">藏品质地 &nbsp&nbsp&nbsp&nbsp&nbsp ：</label>
										<span class="select-box inline">
				                    	<select name="gsTexture" class="select"  style="width:220px;">
											<option value="">所有</option>
											<%-- <option value="2" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 2}">selected</c:if>>无机质</option>
											<option value="1" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 1}">selected</c:if>>有机质</option> --%>
											<option value="1" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 1}">selected</c:if>>木</option>
											<option value="2" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 2}">selected</c:if>>竹</option>
											<option value="3" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 3}">selected</c:if>>纸</option>
											<option value="4" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 4}">selected</c:if>>毛</option>
											<option value="5" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 5}">selected</c:if>>丝</option>
											<option value="6" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 6}">selected</c:if>>石</option>
											<option value="7" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 7}">selected</c:if>>瓷</option>
											<option value="8" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 8}">selected</c:if>>泥</option>
											<option value="9" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 9}">selected</c:if>>陶</option>
											<option value="10" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 10}">selected</c:if>>铜</option>
											<option value="11" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 11}">selected</c:if>>铁</option>
											<option value="12" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 12}">selected</c:if>>金</option>
											<option value="13" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 13}">selected</c:if>>银</option>
											<option value="14" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 14}">selected</c:if>>皮革</option>
											<option value="15" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 15}">selected</c:if>>砖瓦</option>
											<option value="16" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 16}">selected</c:if>>玻璃</option>
											<option value="17" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 17}">selected</c:if>>骨角牙</option>
											<option value="18" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 18}">selected</c:if>>宝玉石</option>
											<option value="19" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 19}">selected</c:if>>棉麻纤维</option>
											<option value="20" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 20}">selected</c:if>>其他金属</option>
											<option value="21" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 21}">selected</c:if>>其他植物质</option>
											<option value="22" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 22}">selected</c:if>>其他动物质</option>
											<option value="23" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 23}">selected</c:if>>其他有机物</option>
											<option value="24" <c:if test="${mipOpenCulturalrelicInfo.gsTexture eq 24}">selected</c:if>>其他无机物</option>
										</select>
										</span>
									</div>
									<div class="col-xs-12 col-sm-3 col-md-3">
				                        <label class="">文物类别&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp：</label>
										<span class="select-box inline">
										<select name="collectionsCategory" class="select" style="width:220px;">
											<option value="">全部</option>
											<c:forEach items="${ccList}" var="cc" varStatus="row">
												<option value="${cc.id}" <c:if test="${cc.id eq mipOpenCulturalrelicInfo.collectionsCategory}">selected</c:if> >${cc.name}</option>
											</c:forEach>
										</select>
										</span>
									</div>
									<div class="col-xs-12 col-sm-3 col-md-3 scdw">
										<label class="">收藏单位：</label>
					                    <span class="inline select-box">
					                    	<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
					                    		<select name="collectionUnit" id="museum" class="select" style="width:105px;">
						                            <option value="${sessionScope.user.orgId}" selected>${sessionScope.user.orgName}</option>
						                        </select>
					                    	</c:if>
					                    	<c:if test="${fn:contains(sessionScope.user.level,3)==false}">
						                        <select name="erea" class="org select select-box inline" style="width:105px">
						                            <option value="">所在区域</option>
						                            <c:forEach items="${cityList}" var="city" varStatus="row">
							                            <option value="${city.id}" <c:if test="${city.id eq erea}">selected</c:if> >${city.shortname}</option>
						                            </c:forEach>
						                        </select>
						                        <select name="collectionUnit" id="museum" class="select select-box inline" style="width:110px;">
						                            <option value="">收藏单位</option>
						                            <c:forEach items="${musList}" var="mus" varStatus="row">
							                            <option value="${mus.id}" <c:if test="${mus.id eq mipOpenCulturalrelicInfo.collectionUnit}">selected</c:if> >${mus.shortname}</option>
						                            </c:forEach>
						                        </select>
					                    	</c:if>
					                    </span>
									</div>
									<div class="col-xs-12 col-sm-3 col-md-3" style="margin-left:-60px;">
									 <label class="">文物来源：</label>
										<span class="select-box inline">
										<select name="gsSource" class="select" style="width:220px;">
											<option value="">请选择</option>
											<option value="征集购买"  <c:if test="${'征集购买' eq mipOpenCulturalrelicInfo.gsSource}">selected</c:if>>征集购买</option>
											<option value="接受捐赠"  <c:if test="${'接受捐赠' eq mipOpenCulturalrelicInfo.gsSource}">selected</c:if>>接受捐赠</option>
											<option value="依法交换"  <c:if test="${'依法交换' eq mipOpenCulturalrelicInfo.gsSource}">selected</c:if>>依法交换</option>
											<option value="拨交"  <c:if test="${'拨交' eq mipOpenCulturalrelicInfo.gsSource}">selected</c:if>>拨交</option>
											<option value="移交"  <c:if test="${'移交' eq mipOpenCulturalrelicInfo.gsSource}">selected</c:if>>移交</option>
											<option value="旧藏"  <c:if test="${'旧藏' eq mipOpenCulturalrelicInfo.gsSource}">selected</c:if>>旧藏</option>
											<option value="发掘"  <c:if test="${'发掘' eq mipOpenCulturalrelicInfo.gsSource}">selected</c:if>>发掘</option>
											<option value="采集"  <c:if test="${'采集' eq mipOpenCulturalrelicInfo.gsSource}">selected</c:if>>采集</option>
											<option value="拣选"  <c:if test="${'拣选' eq mipOpenCulturalrelicInfo.gsSource}">selected</c:if>>拣选</option>
											<option value="其他"  <c:if test="${'其他' eq mipOpenCulturalrelicInfo.gsSource}">selected</c:if>>其他</option>
										</select>
										</span>
										
									</div>
								</div>
								<div class="col-xs-12" style="margin-bottom: 13px;">
									<div class="col-xs-12 col-sm-3 col-md-3">
									<label class="">质地类别&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp：</label>
										<span class="select-box inline">
										<select name="gsTextureCategory" id="gsTextureCategoryId" class="select"  style="width:220px;">
											<option value="">全部</option>
											<option value="单一质地" <c:if test="${'单一质地' eq mipOpenCulturalrelicInfo.gsTextureCategory}">selected</c:if>>单一质地</option>
											<option value="复合或组合质地" <c:if test="${'复合或组合质地' eq mipOpenCulturalrelicInfo.gsTextureCategory}">selected</c:if>>复合或组合质地</option>
										</select>
										</span>
										
										
									</div>
									<div class="col-xs-12 col-sm-3 col-md-3">
									<label class="">质地子类别 &nbsp&nbsp：</label>
										<span class="select-box inline">
										<select name="gsTextureSubcategories" class="select" id="gsTextureSubcategoriesId" style="width:220px;">
											<option value="">全部</option>
											<c:if test="${'单一质地' eq mipOpenCulturalrelicInfo.gsTextureCategory}">
												<option value="有机质" <c:if test="${'有机质' eq mipOpenCulturalrelicInfo.gsTextureSubcategories}">selected</c:if>>有机质</option>
		    									<option value="无机质" <c:if test="${'无机质' eq mipOpenCulturalrelicInfo.gsTextureSubcategories}">selected</c:if> >无机质</option>	
											</c:if>
											<c:if test="${'复合或组合质地' eq mipOpenCulturalrelicInfo.gsTextureCategory}">
												<option value="有机复合或组合" <c:if test="${'有机复合或组合' eq mipOpenCulturalrelicInfo.gsTextureSubcategories}">selected</c:if>>有机质</option>
		    									<option value="无机复合或组合" <c:if test="${'无机复合或组合' eq mipOpenCulturalrelicInfo.gsTextureSubcategories}">selected</c:if> >无机质</option>
		    									<option value="有机无机复合或组合" <c:if test="${'有机无机复合或组合' eq mipOpenCulturalrelicInfo.gsTextureSubcategories}">selected</c:if> >无机质</option>
											</c:if>
										</select>
										</span>
										
				                       
									</div>
									<div class="col-xs-12 col-sm-3 col-md-3">
										<label class="">文物级别：</label>
										<span class="select-box inline">
										<select name="collectionLevel" class="select" style="width:220px;">
											<option value="">全部</option>
											<option value="0" <c:if test="${'0' eq mipOpenCulturalrelicInfo.collectionLevel}">selected</c:if>>珍贵文物</option>
											<option value="1" <c:if test="${'1' eq mipOpenCulturalrelicInfo.collectionLevel}">selected</c:if> >一级</option>
											<option value="2" <c:if test="${'2' eq mipOpenCulturalrelicInfo.collectionLevel}">selected</c:if> >二级</option>
											<option value="3" <c:if test="${'3' eq mipOpenCulturalrelicInfo.collectionLevel}">selected</c:if> >三级</option>
											<option value="4" <c:if test="${'4' eq mipOpenCulturalrelicInfo.collectionLevel}">selected</c:if> >一般</option>
											<option value="5" <c:if test="${'5' eq mipOpenCulturalrelicInfo.collectionLevel}">selected</c:if> >未定级</option>
										</select>
										</span>
									</div>
									<div class="col-xs-12 col-sm-3 col-md-3 wccd" style="margin-left:-60px ">
										<label class="">完残程度：</label>
										<span class="select-box inline">
										<select name="endResidueLevel" class="select" style="width:220px;">
											<option value="">全部</option>
											<option value="完整" <c:if test="${'完整' eq mipOpenCulturalrelicInfo.endResidueLevel}">selected</c:if>>完整</option>
											<option value="基本完整" <c:if test="${'基本完整' eq mipOpenCulturalrelicInfo.endResidueLevel}">selected</c:if>>基本完整</option>
											<option value="残缺" <c:if test="${'残缺' eq mipOpenCulturalrelicInfo.endResidueLevel}">selected</c:if>>残缺</option>
											<option value="严重残缺（含缺失部件）" <c:if test="${'严重残缺（含缺失部件）' eq mipOpenCulturalrelicInfo.endResidueLevel}">selected</c:if>>严重残缺（含缺失部件）</option>
											
										</select>
										</span>
									</div>
								</div>
								<div class="col-xs-12 rzsj" style="margin-bottom: 13px;">
									<div class="col-xs-12 col-sm-3 col-md-3">
										<label class="">入藏时间范围：</label>
										<span class="select-box inline">
										<select name="gsEntryWarehouseTimeFrame" class="select" style="width:220px;">
											<option value="">全部</option>
											<option value="1949.10.1前" <c:if test="${'1949.10.1前' eq mipOpenCulturalrelicInfo.gsEntryWarehouseTimeFrame}">selected</c:if>>1949.10.1前</option>
											<option value="1949.10.1-1965" <c:if test="${'1949.10.1-1965' eq mipOpenCulturalrelicInfo.gsEntryWarehouseTimeFrame}">selected</c:if>>1949.10.1-1965</option>
											<option value="1966-1976" <c:if test="${'1966-1976' eq mipOpenCulturalrelicInfo.gsEntryWarehouseTimeFrame}">selected</c:if>>1966-1976</option>
											<option value="1977-2000" <c:if test="${'1977-2000' eq mipOpenCulturalrelicInfo.gsEntryWarehouseTimeFrame}">selected</c:if>>1977-2000</option>
											<option value="2001至今" <c:if test="${'2001至今' eq mipOpenCulturalrelicInfo.gsEntryWarehouseTimeFrame}">selected</c:if>>2001至今</option>
										</select>
										</span>
									</div>
									<div class="col-xs-12 col-sm-3 col-md-3 zlfw">
										<label class="">质量范围&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp：</label>
										<span class="select-box inline">
										<select name="massRange" class="select" style="width:220px;">
											<option value="">全部</option>
											<option value="&lt;0.01kg" <c:if test="${'<0.01kg' eq mipOpenCulturalrelicInfo.massRange}">selected</c:if>>&lt;0.01kg</option>
											<option value="0.01-1kg" <c:if test="${'0.01-1kg' eq mipOpenCulturalrelicInfo.massRange}">selected</c:if>>0.01-1kg</option>
											<option value="1-50kg" <c:if test="${'1-50kg' eq mipOpenCulturalrelicInfo.massRange}">selected</c:if>>1-50kg</option>
											<option value="50-100kg" <c:if test="${'50-100kg' eq mipOpenCulturalrelicInfo.massRange}">selected</c:if>>50-100kg</option>
											<option value="100-1000kg" <c:if test="${'100-1000kg' eq mipOpenCulturalrelicInfo.massRange}">selected</c:if>>100-1000kg</option>
											<option value=">1000kg" <c:if test="${'>1000kg' eq mipOpenCulturalrelicInfo.massRange}">selected</c:if>>>1000kg</option>
										</select>
										</span>
									</div>
									<div class="col-xs-12 col-sm-3 col-md-3 gkzt" style="padding-right: 0 !important;">
									    <label class="">公开状态：</label>
									    <span class="">
									    <label><input class="zj_wwlist_radio" name="isOpen" type="radio" value="2" <c:if test="${'2' eq mipOpenCulturalrelicInfo.isOpen}">checked</c:if> />已公开 </label>
									    <label><input class="zj_wwlist_radio" name="isOpen" type="radio" value="1" <c:if test="${'1' eq mipOpenCulturalrelicInfo.isOpen}">checked</c:if> />未公开</label>
									    <label><input class="zj_wwlist_radio" name="isOpen" type="radio" value="0" <c:if test="${'0' eq mipOpenCulturalrelicInfo.isOpen}">checked</c:if> >全部 </label>
									    </span>
									</div>
									<div class="col-xs-12 col-sm-3 col-md-3 jjc" style="padding-right: 0 !important;" >
									    <label class="">讲解词：</label>
									    <span class="">
									    <label><input class="zj_wwlist_radio" name="description" type="radio" value="" checked/>全部 </label>
									    <label><input class="zj_wwlist_radio" name="description" type="radio" value="1" <c:if test="${'1' eq mipOpenCulturalrelicInfo.description}">checked</c:if>/>有</label>
									    <label><input class="zj_wwlist_radio" name="description" type="radio" value="2" <c:if test="${'2' eq mipOpenCulturalrelicInfo.description}">checked</c:if>/>无 </label>
									    </span>
									</div>
								</div>
							</ul>
							<div class="more">
								<div style="width:100%;">
								<div style="width:30%;height:30px;border-top:1px solid;border-top-color:#c9ccdc;margin:0 0;float: left;display:inline;"></div>
								<div style="cursor:pointer;width:20%;height:30px;border-bottom:1px solid;border-left:1px solid;border-right:1px solid;border-color:#c9ccdc;margin:0 0;float: left;display:inline;" id="gFinalId">高级检索</div>
								<div style="width:30%;height:30px;border-top:1px solid;border-top-color:#c9ccdc;margin:0 0;float: left;display:inline;"></div>
								</div>
							</div>
						</div>
						<div class="col-xs-12"  style="margin-top: -38px;padding-right:0;margin-right:0;width:auto;">
							<div class="col-xs-12 col-sm-6 col-md-6" style="width:auto;">
								<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
									<c:if test="${fn:contains(sessionScope.user.authStr,'collectionAdmin')==true}">
										<a href="<%=request.getContextPath()%>/back/oCCollection/toAdd.do" onclick="add()" class="btn btn-primary radius zj_wwlist_addColl" style="background:rgb(42, 155, 207)!important; margin-top: 18px;"><i class="Hui-iconfont mr-5">&#xe600;</i>添加藏品</a>
									</c:if>
								</c:if>
							    <button name="search" class="btn btn-primary radius" type="submit" style="background-color:rgb(42, 155, 207)">
							    	<img src="<%=request.getContextPath() %>/back/images/fangdajing.png"/>
							    	搜索
							    </button>
							    <button name="reset" id="reset" class="btn btn-success radius" type="button" onclick="formReset();">
							    	<img src="<%=request.getContextPath() %>/back/images/chongzhi.png"/>
							    	重置
							    </button>
								<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
									<c:if test="${fn:contains(sessionScope.user.authStr,'collectionAdmin')==true}">
										<a href="javascript:;" onclick="non_publishAll()" class="btn btn btn-danger radius zj_wwlist_gongkai">取消公开</a>
										<a href="javascript:;" onclick="publishAll()" class="btn btn-success radius zj_wwlist_gongkai">批量公开</a>
									</c:if>
								</c:if>
							</div>
						</div>
		                <div style="clear: both;"></div>
					</div>

					<div  class="col-xs-12" style="height:68px; line-height:68px;" >
						<div class="col-xs-12 col-sm-6 col-md-6">
							<span style="color:#a4a6a6">已选藏品：</span><span id="checkNumber">0</span> <input type="button" onclick="onClickHander();" value="清除" style="padding:5px 20px;background:#ffffff;border: 0;border-radius: 3px;margin-left: 20px"> <input type="button" value="批量公开" onclick="publishAll()" style="padding:5px 20px;;background:#ffffff;border: 0;border-radius: 3px;margin-left: 20px">
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6 text-r" style="color: black;padding-right:0;margin-right:0;">
								共：<span style="color: #2a9bcf;border: none !important;">${page.allRow }</span> 条数据
								<a class="zj_wwlist_shuaxing" href="javascript:location.replace(location.href);" title="刷新" >
									<img src="<%=request.getContextPath() %>/back/images/shuaxing.png"/>
								</a>
							</div>
					</div>

					<div class="col-xs-12 zj_wwlist_table">
						<table class="table table-border table-bordered table-bg table-hover table-sort">
							<thead>
								<tr class="text-c">
									<th width="25"><input type="checkbox" name="" value="${fn:length(fccList)}" class="allIds"></th>
									<th width="50">公开</th>
									<th width="120">藏品图片</th>
									<th width="250">普查名称</th>
									<th width="250">藏品原名</th>
									<th width="250">讲解词</th>
									<th width="50">二维码</th>
									<th width="150">普查编号</th>
									<th width="150">藏品编号</th>
 									<th width="100">年代</th>
									<th width="60">类别</th>
									<th width="95">质地</th>
									<th width="95">质量</th>
									<th width="95">入藏年度</th>
									<th width="95">保存状态</th>
									<th width="95">文物来源</th>
									<th width="60">级别</th>
									<!--<th width="50">精品</th>-->
									<c:if test="${fn:contains(sessionScope.user.level,1)}">
										<th width="100">收藏单位</th>
									</c:if>
									<th width="130">操作</th>
 								</tr>
							</thead>
							<tbody>
								<c:forEach items="${fccList}" var="fcc" varStatus="row">
									<tr class="text-c">
										<td>
											<input type="checkbox" class="ids" value="${fcc.id }" name="ids">
										</td>

										<!--公开-->
										<td>
											<c:if test="${fcc.isOpen eq '1' }">否</c:if>
											<c:if test="${fcc.isOpen eq '2' }">是</c:if>
										</td>
										<!--图片-->
										<td id="cpimg" height="120px" width="120px">
											<a href="${fcc.fpic}" data-lightbox="gallery">
												<img alt="没有图片" src="${fcc.picUrl}" style="max-height:118px;max-width:118px;">
											</a>
										</td>
										<!--藏品名-->
										<%-- <td class="name">
											<c:if test="${fn:contains(sessionScope.user.level,3) or fn:contains(sessionScope.user.level,1)}">
												<c:if test="${fn:contains(sessionScope.user.authStr,'collectionAdmin')==true}">
													<c:choose>
														<c:when test="${fcc.isOpen eq '1' }">
															<a style="text-decoration:none;font-weight:bold;" href="<%=request.getContextPath() %>/back/oCCollection/toEdit.do?id=${fcc.id }">
																${fcc.name }
															</a>
														</c:when>
														<c:otherwise>
															<a style="text-decoration:none;font-weight:bold;" class="ml-5" href="<%=request.getContextPath() %>/back/oCCollection/detail.do?id=${fcc.id }">
																${fcc.name }
															</a>
														</c:otherwise>
													</c:choose>
												</c:if>
											</c:if>
										</td> --%>
										<td class="name">
											<a style="text-decoration:none;font-weight:bold;" class="ml-5" href="<%=request.getContextPath() %>/back/oCCollection/detail.do?id=${fcc.id }&type=1">
												${fcc.name }
											</a>
										</td>
										<td>
											${fcc.formerly }
										</td>
										<!-- 讲解词 -->
										<td>
											<c:if test="${fcc.description eq '' }"><a href="javascript:void(0);" onclick="system_category_add('讲解词','addView.do?id=${fcc.id}','600','350')">添加</a></c:if>
											<c:if test="${fcc.description != '' && fn:length(fcc.description) > 10}"><a href="javascript:void(0);" onclick="system_category_add('讲解词','addView.do?id=${fcc.id}','600','350')">${fn:substring(fcc.description, 0, 10)}...</a></c:if>
											<c:if test="${fcc.description != '' && fn:length(fcc.description) <= 10}"><a href="javascript:void(0);" onclick="system_category_add('讲解词','addView.do?id=${fcc.id}','600','350')">${fcc.description}</a></c:if>
										</td>
										<!--二维码-->
										<td>
											<c:if test="${fcc.isOpen eq '2' }">
												<a style="text-decoration:none" class="ml-5" href="javascript:void(0);" onclick="makeCodeInfo('${fcc.id }',this)"  title="二维码">
													<img src="<%=request.getContextPath() %>/back/images/erweima.png"/>
												</a>
											</c:if>
										</td>

										<!--普查编号-->
										<td>${fcc.gsNo }</td>
										<!--藏品编号-->
										<td>${fcc.gsCollectionsNo }</td>
										<!--年代-->
										<td>
											<c:forEach items="${ytList}" var="yt">
												<c:if test="${fcc.yearType == yt.id }">
													${yt.name }
												</c:if>
											</c:forEach>
										</td>
										<!--类别-->
										<td>
											<c:forEach items="${ccList}" var="cc">
												<c:if test="${fcc.collectionsCategory == cc.id }">
													${cc.name }
												</c:if>
											</c:forEach>
										</td>
										<!-- 质地 -->
										<td>
												${fcc.gsTexture }
										</td>
										<!-- 质量 -->
										<td>
												${fcc.mass }${fcc.massUnit }
										</td>
										<!-- 入藏年度 -->
										<td>
												${fcc.gsEntryWarehouseYear }
										</td>
										<!-- 保存状态 -->
										<td>
												${fcc.gsStorageState }
										</td>
										<!-- 文物来源 -->
										<td>
												${fcc.gsSource }
										</td>
										<!--级别-->
										<td>
											<c:if test="${fcc.collectionLevel eq '1' }">一级</c:if>
											<c:if test="${fcc.collectionLevel eq '2' }">二级</c:if>
											<c:if test="${fcc.collectionLevel eq '3' }">三级</c:if>
											<c:if test="${fcc.collectionLevel eq '4' }">一般</c:if>
											<c:if test="${fcc.collectionLevel eq '5' }">未定级</c:if>
										</td>
										<!-- 收藏单位 -->
										<c:if test="${fn:contains(sessionScope.user.level,1)}">
											<td>
												<c:forEach items="${museums}" var="museum">
													<c:if test="${fcc.collectionUnit == museum.id }">
														${museum.name }
													</c:if>
												</c:forEach>
											</td>
										</c:if>
										<!--操作-->
										<td class="f-14 td-manage" style="width: 250px;">
											<%-- <a style="text-decoration:none" class="ml-5" href="<%=request.getContextPath() %>/back/oCCollection/detail.do?id=${fcc.id }" title="查看">
												<img src="<%=request.getContextPath() %>/back/images/chakan.png"/>
											</a> --%>
											<c:if test="${fn:contains(sessionScope.user.level,3) or fn:contains(sessionScope.user.level,1)}">
												<c:if test="${fn:contains(sessionScope.user.authStr,'collectionAdmin')==true}">
													<c:if test="${fcc.status eq '4' || fcc.status eq '1'}">
														<a style="text-decoration:none" href="<%=request.getContextPath() %>/back/oCCollection/toEdit.do?id=${fcc.id }" title="编辑">
															<img src="<%=request.getContextPath() %>/back/images/bianji.png"/>
														</a>
														<c:if test="${fcc.status eq '1'}">
															<a style="text-decoration:none" href="javascript:void(0)" onclick="reviewContent('${fcc.userName }','${fcc.content }')" title="回退原因">
																<img src="<%=request.getContextPath() %>/back/images/th.png"/>
															</a>
														</c:if>
														<c:if test="${fcc.isOpen eq '1' && fcc.status eq '4' }">
															<a style="text-decoration:none" class="ml-5"  onclick="publish('${fcc.id}')"  title="发布">
																<img src="<%=request.getContextPath() %>/back/images/fabu.png"/>
															</a>
														</c:if>
														<c:if test="${fcc.gsNo eq ''}">
															<a style="text-decoration:none" class="ml-5" href="javascript:;" onclick="deleteColl('${fcc.id}')" title="删除">
																<img src="<%=request.getContextPath() %>/back/images/delicon.png"/>
															</a>
														</c:if>
													</c:if>
													<c:if test="${fcc.isOpen eq '2' }">
														<c:if test="${fcc.sequence ne 100 }">
															<a style="text-decoration:none" class="ml-5" href="javascript:;" onclick="toTop('${fcc.id}')" title="置顶">
																<img src="<%=request.getContextPath() %>/back/images/dingzhi.png"/>
															</a>
														</c:if>
														<c:if test="${fcc.sequence eq 100 }">
															<a style="text-decoration:none" class="ml-5" href="javascript:;" onclick="toDown('${fcc.id}')" title="取消置顶">
																<img src="<%=request.getContextPath() %>/back/images/cancel_stick.png"/>
															</a>
														</c:if>
													</c:if>
												</c:if>
												<c:if test="${fn:contains(sessionScope.user.authStr,'SystemAdmin')==true}">
													<c:if test="${fn:contains(sessionScope.user.level,1)  and fcc.status eq '3'}">
														<button class="btn btn-success radius" type="button" onclick="reviewObject('${fcc.id}','4')">确定</button>
														<button class="btn btn-danger radius" type="button" onclick="review('${fcc.id}','1')">退回</button>
													</c:if>
													<c:if test="${fn:contains(sessionScope.user.level,3) and fcc.status eq '2'}">
														<button class="btn btn-success radius"  type="button" onclick="reviewObject('${fcc.id}','3')">确定</button>
														<button class="btn btn-danger radius" type="button" onclick="review('${fcc.id}','1')">退回</button>
													</c:if>
												</c:if>
											</c:if>
											<c:if test="${fcc.isOpen eq '1' && fcc.status eq '4'}">
												<a style="text-decoration:none" class="ml-5" href="<%=request.getContextPath() %>/back/oCCollection/exportPicture.do?id=${fcc.id }&name=${fcc.name}" title="导出图片">
													<img src="<%=request.getContextPath() %>/back/images/chakan.png"/>
												</a>
											</c:if>
										</td>
										

										<!--<td>${fcc.gsTexture }</td>-->

										<!--<td>
											<c:if test="${fcc.isHighQuality eq '1' }">否</c:if>
											<c:if test="${fcc.isHighQuality eq '2' }">是</c:if>
										</td>-->
										<%-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','/back/oCCollection/detail.do','${fcc.id}')" title="查看">查看</u></td> --%>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<br>
					<div id="page" align="center" style="height: 500px;"></div>
				</article>
			</div>
		</form>
	</section>
	<div id="comeBack" class="pl-30" style="display: none;">
		<h3 style='font-size:14px'>原因：</h3>
		<input type="hidden" value="${fcc.id}" id="infoId">
		<textarea maxlength='50' placeholder='输入审核不通过的理由，50字以内.审核通过不需要填写' class='checkList_content' name='auditMsg'></textarea>
		<input type='button' class='zj_checkList_save' value='确认'>
		<input type='button' class='zj_checkList_cancel' value='取消' onclick='layer.closeAll()'>
	</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript"
    	 src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>

	<!--/请在上方写此页面业务相关的脚本-->
		<script type="text/javascript">
		
		$(function(){
			 $("#pageSize").change(function() {
			    	var size = $(this).val();
			    	if (size == "") {
			    		return false;
			    	} else {
			    		$("#pageSizeHide").val(size); 
				    	$("#form").submit();
			    	}
		    })
		})
		
		$(".fabu-aside>ul>li").eq(2).addClass("dongtai");

		$(".zj_public_cangping>a").css({
			color:"#2a9bcf",
			background:"#ffffff",
		}).children().attr("src",'<%=request.getContextPath() %>/back/images/zj_wenwu.png');
		$(".zj_public_cangping>a").css({
			color:"white",
			background:"#2a9bcf"
		}).children().attr("src",'<%=request.getContextPath() %>/back/images/zj_wenwu_chose.png');

		$(".zj_checkList_save").unbind().on("click",function(){
			var id = $("#infoId").val();
			var status = "1";
			var auditMsg=$(".checkList_content").val();  
			if((auditMsg==""||auditMsg==null)&&status==4){
				layer.msg('未填写审核信息', {icon: 2});
				return;
			}
			$.ajax({
	            type : "post",
	            async : true, //同步执行
	            data :  {id:id,status:status,auditMsg:auditMsg},
	            url : "<%=request.getContextPath() %>/back/oCCollection/reviewObject.do",
	            dataType : "json", //返回数据形式为json
	            success : function(result) {
	            	console.log(result);
	            	layer.msg('审核成功', {icon: 1});
					setTimeout(function(){
						window.location.href = window.location.href;
					},1000)
	            },
	            error : function(errorMsg) {
	            	console.log(errorMsg);
	            }
	        });
		});
		function formReset() {  
		    $(':input,#myform')  
		     .not(':button, :submit, :reset, :hidden')  
		     .val('')  
		     .removeAttr('checked')  
		     .removeAttr('selected');     
		}
		function makeCodeInfo(elText,thisTd) {
	        console.log(elText)
	        var cpimg = $(thisTd).parent().parent().find("#cpimg img").attr("src");
			var name = $(thisTd).parents("td").siblings(".name").html();
			 if (elText == null) {
				alert("沒有普查编号，没法生成二维码。");
				elText.focus();
				return;
			}
			 layer.open({
				  type: 1,
	              title:name,
	              area:['470px','390px'],
				  content: "<div id='qrcode' style='padding:20px 100px;text-align:center;'></div>"+
	                       "<a id='download' download='qrcode.jpg'></a>"+
	                       "<button class='btn button btn-primary size-S' id='save' style='float: right;margin-right: 15px;margin-bottom: 10px;background-color:#2a9bcf'>下载</button>" //这里content是一个普通的String
				});
			  var qrcode = new QRCode(document.getElementById("qrcode"), {
	                text:name,
					width : 270,
					height : 270
				});
				// var elText1 = 'http://www.jlsdmu.com/mip/jilin2/index.html#/scrollMode?id='+elText+'&isSm=0';
				 var elText1 = 'http://bwsc.scmuseum.cn/mip/sc/m/index.html#/scrollMode?id='+elText+'&isSm=0';
				  $.ajax({
			             type: "GET",
			             url: "<%=request.getContextPath() %>/createTwoDimensionCode.do",
			             data: {content:elText1, picCollectionPicUrl:cpimg},
			             dataType: "json",
			             success: function(data){
			            	console.log(data);
					    	url = data.data;
					    	$("#qrcode").html("<img style='width:270px;height:270px;' src="+url+" />");
					    	$("#download").attr("href",url);
			             }
			         });

	        //下载
	        $("#save").click(function(){
                $("#download").attr('href', url).get(0).click();
	            return false;
	        })

		}
</script>
	<!-- 级联 -->
	<script type="text/javascript">
	$(function(){
	    $('.org').change(function(){
	        var pid=$(this).val();
	        var obj=$(this).next('select');
	        var first=obj.children().first().clone();
	        $.ajax({
	            url:"<%=request.getContextPath() %>/back/oCCollection/sltMuseum.do",
	            data:{parentId:pid},
	            type:"POST",
	            datatype:"json",
	            success:function(msg){
	            	 obj.empty().append(first);
	                for(var i in msg){
	                    obj.append("<option value="+msg[i]['id']+">"+msg[i]['shortname']+"</option>");
	                }
	            }
	        });
	    });
	});
	</script>
	<!-- 分页功能 -->
	<script type="text/javascript">
		var nums = ${page.size}; //每页出现的数量
		var pages = ${page.totalPage}; //得到总页数
		//调用分页
		laypage({
		    cont: 'page',
		    pages: pages,
		    curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
		        var page = location.search.match(/page=(\d+)/);
		        return page ? page[1] : 1;
		    	}(),
		   	skip: true, //是否开启跳页
		   	skin: '#2a9bcf', //皮肤
		   	groups: 3, //连续显示分页数
		    jump: function(e, first){ //触发分页后的回调
		       if(!first){ //一定要加此判断，否则初始时会无限刷新
		         location.href = '?page='+e.curr+'&'+$('form').serialize() ;
		       }
		    }
		})
		var abc="<span>每页显示<input style='width:50px;height: 28px;' type='number'  min='5' max='100' step='5' class='input-text' id='pageSize'   value='"+${page.size }+"' name='size'>条</span>";
		$(".laypage_total").before(abc); 
	</script>

	<%--批量公开--%>
	<script type="text/javascript">
		function publishAll() {
			var data = $("form").find(".ids").serialize();
			if(data == ''){
				layer.msg('请勾选藏品', {icon: 2});
				return false;
			}
			layer.confirm('是否确认发布？', {
				  btn: ['确定','再想想'] //按钮
				}, function(){
					$.ajax({
						url : "<%=request.getContextPath()%>/back/oCCollection/publishAll.do",
						type : "post",
						data :  data,
						dataType : "json",
						success : function(data){
							if(data == "1"){
								layer.msg('发布成功', {icon: 1});
								var data1 = $("form").find(".ids").serialize();
								$.ajax({
									url:"<%=request.getContextPath()%>/image/printWatermarkForEachCollection.do",
									type : "post",
									data :  data1,
									dataType : "json",
									success:function(response){
										console.log(response);
									}
								});
								setTimeout(function(){
									window.location.href = window.location.href;
								},1000)
							}else if(data == "-1"){
								layer.msg('请先上传藏品图片', {icon: 2});
							}else if(data == "-2"){
								layer.msg('请先确认是否通过审核', {icon: 2});
							}
							else{
								layer.msg('发布失败', {icon: 2});
							}
						},
					})
				}, function(){
					
				});
		};

		function non_publishAll() {
			var data = $("form").find(".ids").serialize();
			$.ajax({
				url : "<%=request.getContextPath()%>/back/oCCollection/nonPublishAll.do",
				type : "post",
				data :  data,
				dataType : "json",
				success : function(data){
					if(data == "1"){
						layer.msg('取消发布成功', {icon: 1});
						setTimeout(function(){
							window.location.href = window.location.href;
						},1000)
					}else if(data == "-1"){

					}else{
						layer.msg('取消发布失败', {icon: 2});
					}
				},
			})
		};

		function publish(id) {
			$.ajax({
				url : "<%=request.getContextPath()%>/back/oCCollection/publish.do",
				type : "get",
				data :  {ids:id},
				dataType : "json",
				success : function(data){
					console.log(data);
					if(data == "1"){
						layer.msg('发布成功', {icon: 1});
						$.ajax({
							url:"<%=request.getContextPath()%>/image/printWatermarkForEachCollection.do",
							type : "post",
							data :  {ids:id},
							dataType : "json",
							success:function(response){
								console.log("************************");
								console.log(response);
							}
						});
						setTimeout(function(){
							window.location.href = window.location.href;
						},1000)

					}else if(data == "-1"){
						layer.msg('请先上传藏品图片', {icon: 2});
					}else if(data == "-2"){
						layer.msg('请先确认是否通过审核', {icon: 2});
					}
					else{
						layer.msg('发布失败', {icon: 2});
					}
				},
			})
		};
		function non_publish(id) {
			$.ajax({
				url : "<%=request.getContextPath()%>/back/oCCollection/nonPublish.do",
				type : "post",
				data :  {ids:id},
				dataType : "json",
				success : function(data){
					if(data == "1"){
						layer.msg('取消发布成功', {icon: 1});
						setTimeout(function(){
							window.location.href = window.location.href;
						},1000)

					}else if(data == "-1"){

					}else{
						layer.msg('取消发布失败', {icon: 2});
					}
				},
			})
		};

		function deleteColl(id) {
			layer.confirm('确定删除此信息？', {
				  btn: ['确定','再想想'] //按钮
				}, function(){
					$.ajax({
						url : "<%=request.getContextPath()%>/back/oCCollection/del.do",
						type : "post",
						data :  {ids:id},
						dataType : "json",
						async: false,
						success : function(data){
							if(data){
								layer.msg('成功删除', {icon: 1});
								setTimeout(function(){
									window.location.href = window.location.href;
								},1000)

							}else{
								layer.msg('删除失败', {icon: 2});
							}
						},
					})
				}, function(){
				  layer.msg('已取消删除', {
				  });
				});
		};

		function toTop(id) {
			$.ajax({
				url : "<%=request.getContextPath()%>/back/oCCollection/top.do",
				type : "post",
				data :  {ids:id},
				dataType : "json",
				success : function(data){
					if(data){
						layer.msg('置顶成功', {icon: 1});
						setTimeout(function(){
							window.location.href = window.location.href;
						},1000)

					}else{
						layer.msg('置顶失败', {icon: 2});
					}
				},
			})
		};

		function toDown(id) {
			$.ajax({
				url : "<%=request.getContextPath()%>/back/oCCollection/down.do",
				type : "post",
				data :  {ids:id},
				dataType : "json",
				success : function(data){
					if(data){
						layer.msg('取消置顶成功', {icon: 1});
						setTimeout(function(){
							window.location.href = window.location.href;
						},1000)

					}else{
						layer.msg('取消置顶失败', {icon: 2});
					}
				},
			})
		};
		
		var a = 1
		$("#gFinalId").click(function(){//.more
			a++
			if (a%2==0) {
				$("#gFinalId").html("收起高级检索");
				$("#categoryList").css("height","auto")
				$("#categoryList").css("overflow","auto")
			}else{
				$("#gFinalId").html("高级检索");
				var textarea= document.getElementById("gsCollectionsNoId");
				var categoryHeight = 80;
				if(textarea.clientHeight > 30){
					categoryHeight = textarea.clientHeight-30+categoryHeight;
				}
				$("#categoryList").css("height",categoryHeight+"px")
				$("#categoryList").css("overflow","hidden")
			}
		})
		$("#commonYearId").change(function(){
		    var opt=$("#commonYearId").val();
		    if(opt != ""){
		    	$("#orhterYearId").val("");
		    	$("#commonYearId").attr("name","yearType")
		    	$("#orhterYearId").attr("name","yearType2")
		    }
		});
		$("#orhterYearId").change(function(){
		    var opt=$("#orhterYearId").val();
		    if(opt != ""){
		    	$("#commonYearId").val("");
		    	$("#commonYearId").attr("name","yearType2")
		    	$("#orhterYearId").attr("name","yearType")
		    }
		});
		$("#gsTextureCategoryId").change(function(){
		    var opt=$("#gsTextureCategoryId").val();
		    if(opt == "单一质地"){
		    	$("#gsTextureSubcategoriesId").html("");
		    	$("#gsTextureSubcategoriesId").append(
		    			'<option value="">全部</option>'+
		    			'<option value="有机质" >有机质</option>'+
		    			'<option value="无机质"  >无机质</option>'		
		    	);
		    }
		    if(opt == "复合或组合质地"){
		    	$("#gsTextureSubcategoriesId").html("");
		    	$("#gsTextureSubcategoriesId").append(
		    			'<option value="">全部</option>'+
		    			'<option value="有机复合或组合"  >有机复合或组合</option>'+
		    			'<option value="无机复合或组合"  >无机复合或组合</option>'+
		    			'<option value="有机无机复合或组合"  >有机无机复合或组合</option>'	
		    	);
		    }
		    if(opt == ""){
		    	$("#gsTextureSubcategoriesId").html("");
		    	$("#gsTextureSubcategoriesId").append(
		    			'<option value="">全部</option>'
		    	);
		    }
		});
		
		$('#gsCollectionsNoId').bind('input propertychange', function() {
			var val = $(this).val();
			var r = /\s+/g;
			val = val.replace(r, ' ');
			/* var rr = /\r\n/g;
			val = val.replace(rr, '\n');
			var rrr = /\n/g;
			val = val.replace(rrr, '\n'); */
			$(this).val(val);
			var arr = val.split(' ');
			if(arr && arr.length > 50){
				var valKz = "";
				for(var i = 0;i<50; i++){
					valKz += arr[i]+" ";
				}
				$(this).val(valKz);
				return false;
			}
			var isopen = isopenCategory();
		    var textarea= document.getElementById("gsCollectionsNoId"); 
			if(val.length > 30 && textarea.clientHeight <= 30){
				textarea.style.height=textarea.clientHeight+30+"px";
				if(!isopen){
					$("#categoryList").css("height",$("#categoryList").height()+30+"px");
				}
			}
		    if(val.length % 30 == 0 && val.length != 0){
		    	if(val.length < textarea.clientHeight){
		    		textarea.style.height=val.length+"px";
		    		if(!isopen){
			    		if(val.length > 80){
			    			$("#categoryList").css("height",val.length+"px");
			    		}else{
			    			$("#categoryList").css("height","80px");
			    		}
		    		}
		    	}else{
		    		textarea.style.height=val.length+30+"px";//textarea.clientHeight
		    		if(!isopen){
			    		$("#categoryList").css("height",$("#categoryList").height()+30+"px");
		    		}
		    	}
		    }
		    document.getElementById("textareaImgId").style.top = textarea.clientHeight-21+"px";
		});
		$('#textareaImgId').bind("click",function(){
			$('#gsCollectionsNoId').val("");
			document.getElementById("textareaImgId").style.top = 9+"px";
			var textarea= document.getElementById("gsCollectionsNoId");
			textarea.style.height = 30+"px";
			var isopen = isopenCategory();
			if(!isopen){
	    		$("#categoryList").css("height","80px");
    		}
		});
		function isopenCategory(){
			var nr = $("#gFinalId").html();
			var isopen = nr.indexOf("收起")>=0;
			return isopen;
		}
		//讲解词新增
		function system_category_add(title,url,w,h){
			layer_show(title,url,w,h);
		}
		function reviewObject(id,status){
			var content="您确定该信息审核通过吗？";
			layer.confirm(content, {
		        btn: ['确定','取消'] //按钮
		    }, function(index){
				$.ajax({
		            type : "post",
		            async : true, //同步执行
		            data :  {id:id,status:status},
		            url : "<%=request.getContextPath() %>/back/oCCollection/reviewObject.do",
		            dataType : "json", //返回数据形式为json
		            success : function(result) {
		            	console.log(result);
		            	layer.msg('审核成功', {icon: 1});
						setTimeout(function(){
							window.location.href = window.location.href;
						},1000)
		            },
		            error : function(errorMsg) {
		            	console.log(errorMsg);
		            }
		        });
			}, function(index){
		        layer.close(index);  //关闭弹出层
		    });
		}
		function review(id,status){
			$("#infoId").val(id);
			layer.open({
				type: 1,
				title: '回退原因',
				shadeClose: true,
				shade: 0.5,
				area: ['600px', '470px'],
				content: $("#comeBack"),
			});
		}
		function reviewContent(name,content){
			layer.open({
				type: 1,
				title: '回退原因',
				shadeClose: true,
				shade: 0.5,
				area: ['600px', '490px'],
				content: "<div class='pl-30'>"+
						"<label>审核人:</label>"+
						"<label>"+name+"</label>"+
						"<h3 style='font-size:14px'>原因：</h3>"+
						"<textarea maxlength='50' placeholder='输入审核不通过的理由，50字以内.审核通过不需要填写' class='checkList_content' name='auditMsg'>"+content+"</textarea>"+
						"<input type='button' class='zj_checkList_cancel' value='取消' onclick='layer.closeAll()'>"+
						"</div>"
			});
		}
		$(".ids").click(function(){
			$("#checkNumber").html($("input[type='checkbox']:checked").length);
		})
		$(".allIds").click(function(){
			var num = $(this).val();
			if($("#checkNumber").html()<num){
				$("#checkNumber").html(num);
			}else{
				$("#checkNumber").html(0);
			}
		})
		function onClickHander(obj){
			$(".ids").attr("checked",false);
			$(".allIds").attr("checked",false);
			$("#checkNumber").html(0);
	}
	</script>
</body>
</html>
