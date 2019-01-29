<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
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
    .zj_hslist_content{
    	padding: 0 !important;
    }
    .zj_hslist_chose{
    	background-color: white;
    	border-top-left-radius: 5px;
    	border-bottom-left-radius: 5px;
    	padding: 30px 30px 0px 0px;
    	padding-left:0 !important;
    	margin-top:70px;
    }
    .zj_hslist_chose input{
    	border: 1px solid #f1f2f7;
    	border-radius: 5px;
    	outline: none;
    	padding-left: 20px;
    	width: 60%;
    }
    .zj_hslist_radio{
    	width: auto !important;
    	margin-left: 10px !important;
    }
    .zj_hslist_addColl{
    	margin-bottom: 18px;
    }
    .zj_hslist_chose select{
    	border:none;
    	outline: none !important;
    }
    .zj_hslist_chose span{
    	border: 1px solid #f1f2f7;
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
    .zj_hslist_gongkai{
    	background-color: white !important;
    	border: 1px solid #2a9bcf !important;
    	color: #2a9bcf !important;
    }
    .zj_hslist_shuaxing{
    	display: block;
    	float: right;
    	margin: 3px 0 0 15px;
    }
     .zj_hslist_shuaxing>img{
    	padding-top:23px;
    }
    .zj_hslist_table{
    	background-color: white;
    	border-top: 3px solid #f1f2f7;
    	padding-top: 6px;
    }
    .zj_hslist_table td,th,table{
    	border: none !important;
    }
    .zj_hslist_table thead>tr:nth-child(1){
    	background-color: #f1f2f7 !important;
    	border-radius: 5px;
    }
    .zj_hslist_table th{
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
		.col-md-3{
			width: 31%
			}
			.cpmc input{
				width:228px !important;
			}
			.ssnd{
				width:35%;
			}
			.scdw{
				width:35%;
			}
		}
</style>
<title>化石列表</title>
</head>
<body>
	<!--/_menu 作为公共模版分离出去-->
	<%@ include file="../../content/aside.jsp" %>
	<section class="Hui-article-box">
		<form action="/admin/back/oCFossil/info.do" method="get" id="form">
		<div class="hide">   
	        	每页显示条数:&nbsp; 
	            <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${page.size }" name="size">
	        </div> 
			<div class="Hui-article">
				<article class="cl pd-20 zj_hslist_content">
					<input type="hidden" value="1" name="type"/>
					<%@ include file="../trendsheader.jsp"%>
						<div class="zj_hslist_chose">
						<ul class="secondtitle"  style="top:-96px;left:-30px">
							<li>
								<!--<a href="/mip/back/fCCollection/info.do" title="一普数据列表" style="font-size:16px!important;">一普数据列表</a>-->
								<ul class="thirdTitle">
									<li class="zj_public_wenwu"  style="margin-right:-14px">
										<a style="border:0;background:#bfd5e1;color:#ffffff;" href="/admin/back/oCCollection/info.do?type=1" rel="/mip/back/oCCollection/info.do?type=1" title="文物藏品类别">
											<img src="<%=request.getContextPath() %>/back/images/zj_wenwu_chose.png"/>
											文物表
										</a>
									</li>
									<li class="zj_public_haushi">
										<a  style="border:0;background:#bfd5e1;z-index:-10;color:#ffffff"  href="/admin/back/oCFossil/info.do?type=1" rel="/mip/back/oCFossil/info.do?type=1" title="化石藏品类别">
											<img src="<%=request.getContextPath() %>/back/images/zj_huashi.png"/>
											标本化石
										</a>
									</li>
								</ul>
							</li>
						</ul>
						<!-- 
							<div class="col-xs-12">
								<div class="col-xs-5">
									<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
										<c:if test="${fn:contains(sessionScope.user.authStr,'collectionAdmin')==true}">
											<a href="<%=request.getContextPath()%>/back/oCFossil/toAdd.do" onclick="add()" class="btn btn-primary radius zj_hslist_addColl" style="background:rgb(42, 155, 207)!important;"><i class="Hui-iconfont mr-5">&#xe600;</i>添加化石</a>
										</c:if>
									</c:if>
								</div>
							</div>
							 -->
							<div class="col-xs-12 rinm" style="margin-bottom: 13px;">
								 <div  class="col-xs-12 col-sm-3 col-md-3 cpmc">
				                       <label class="">藏品名称：</label>
								       <input type="text" name="key" id="key" value="${key}" placeholder="藏品名称" style="width:250px" class="input-text">
								</div>
								<div class="col-xs-12 col-sm-3 col-md-3 ssnd">
									所属年代：宙
									<span class="select-box inline">
										<select name="yearTypeEon" class="yearType" id="yearTypeEon">
										    <option value="">请选择</option>
										   <c:forEach items="${ytEonList}" var="eon" varStatus="row">
												<option value="${eon.id}" <c:if test="${eon.id eq mipOpenFossilInfo.yearTypeEon}">selected</c:if> >${eon.name}</option>
											</c:forEach>
										</select>
									</span>
									代
									<span class="select-box inline">
										<select name="yearTypeEra" class="yearType" id="yearTypeEra">
										    <option value="">请选择</option>
										   <c:forEach items="${ytEraList}" var="era" varStatus="row">
												<option value="${era.id}" <c:if test="${era.id eq mipOpenFossilInfo.yearTypeEra}">selected</c:if> >${era.name}</option>
											</c:forEach>
										</select>
									</span>
									纪
									<span class="select-box inline">
										<select name="yearTypeEpoch" class="yearTypeEpoch" id="yearTypeEpoch">
										    <option value="">请选择</option>
										<c:forEach items="${ytEpochList}" var="epoch" varStatus="row">
											<option value="${epoch.id}" <c:if test="${epoch.id eq mipOpenFossilInfo.yearTypeEpoch}">selected</c:if> >${epoch.name}</option>
										</c:forEach>
										</select>
									</span>
								</div>
								<div  class="col-xs-12 col-sm-3 col-md-3 wwlb">
				                    <label class="">文物类别：</label>
									<span class="select-box inline">
									<select name="collectionsCategory" class="select" >
										<option value="">全部</option>
										<%-- <option value="0" <c:if test="${'0' eq mipOpenFossilInfo.collectionType}">selected</c:if> >文物</option>
										<option value="1" <c:if test="${'1' eq mipOpenFossilInfo.collectionType}">selected</c:if> >化石</option> --%>
										<c:forEach items="${ccList}" var="cc" varStatus="row">
											<option value="${cc.id}" <c:if test="${cc.id eq mipOpenFossilInfo.collectionsCategory}">selected</c:if> >${cc.name}</option>
										</c:forEach>
									</select>
									</span>
								</div>
							</div>
							<div class="col-xs-12 rinm1" style="margin-bottom: 13px;">
								<div class="col-xs-12 col-sm-3 col-md-3 scdw">
				                    <label class="">收藏单位：</label>
				                    <span class="select-box inline">
				                    	<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
				                    		<select name="collectionUnit" id="museum" class="select" style="width:132px;">
					                            <option value="${sessionScope.user.orgId}" selected>${sessionScope.user.orgName}</option>
					                        </select>
				                    	</c:if>
				                    	<c:if test="${fn:contains(sessionScope.user.level,3)==false}">
					                        <select name="erea" class="select" style="width:132px" id="erea" onchange="selectUnit();">
					                            <option value="">所在区域</option>
					                            <c:forEach items="${cityList}" var="city" varStatus="row">
						                            <option value="${city.id}" <c:if test="${city.id eq erea}">selected</c:if> >${city.shortname}</option>
					                            </c:forEach>
					                        </select>
					                        <select name="collectionUnit" id="museum" class="select" style="width:132px;">
					                            <option value="">收藏单位</option>
					                            <c:forEach items="${musList}" var="mus" varStatus="row">
						                            <option value="${mus.id}" <c:if test="${mus.id eq mipOpenFossilInfo.collectionUnit}">selected</c:if> >${mus.shortname}</option>
					                            </c:forEach>
					                        </select>
				                    	</c:if>
				                    </span>
								</div>
								<div class="col-xs-12 col-sm-3 col-md-3">
									 馆内精品：
									 <span class="inline">
									     <label><input class="zj_hslist_radio" name="isHighQuality" type="radio" value="2" <c:if test="${'2' eq mipOpenFossilInfo.isHighQuality}">checked</c:if> >是 </label>
									     <label><input class="zj_hslist_radio" name="isHighQuality" type="radio" value="1" <c:if test="${'1' eq mipOpenFossilInfo.isHighQuality}">checked</c:if> >否 </label>
									     <label><input class="zj_hslist_radio" name="isHighQuality" type="radio" value="0" <c:if test="${'0' eq mipOpenFossilInfo.isHighQuality}">checked</c:if> >全部 </label>
									 </span>
			               		</div>
			               		<div class="col-xs-12 col-sm-3 col-md-3" style="padding-right: 0;">
									<label class="">	公开状态：</label>
									    <span class="">
									    <label><input class="zj_hslist_radio" name="isOpen" type="radio" value="2" <c:if test="${'2' eq mipOpenFossilInfo.isOpen}">checked</c:if> />已公开 </label>
									    <label><input class="zj_hslist_radio" name="isOpen" type="radio" value="1" <c:if test="${'1' eq mipOpenFossilInfo.isOpen}">checked</c:if> />未公开</label>
									    <label><input class="zj_hslist_radio" name="isOpen" type="radio" value="0" <c:if test="${'0' eq mipOpenFossilInfo.isOpen}">checked</c:if> >全部 </label>
									</span>
			               		</div>
							</div>
			               	<div class="col-xs-12">
			               		
			               	</div>
			                <div style="clear:both"></div>
							<div class="col-xs-12" >
								<div class="col-xs-5"  style="padding-bottom: 10px;">
									<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
										<c:if test="${fn:contains(sessionScope.user.authStr,'collectionAdmin')==true}">
											<a href="<%=request.getContextPath()%>/back/oCFossil/toAdd.do" onclick="add()" class="btn btn-primary radius zj_hslist_addColl" style=" margin-top: 18px;background:rgb(42, 155, 207)!important;"><i class="Hui-iconfont mr-5">&#xe600;</i>添加化石</a>
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
											<a href="javascript:;" onclick="non_publishAll()" class="btn btn btn-danger radius zj_hslist_gongkai">取消公开</a>
											<a href="javascript:void(0);" onclick="publishAll()" class="btn btn-success radius zj_hslist_gongkai">批量公开</a>
										</c:if>
									</c:if>
								</div>
							</div>
			                <div style="clear:both"></div>
						</div> 
					<div class="col-xs-12"  style="height:68px; line-height:68px;" >
						<div class="col-xs-12 col-sm-6 col-md-6">
							<span style="color:#a4a6a6">已选藏品：</span><span id="checkNumber">0</span> <input type="button" onclick="onClickHander();" value="清除" style="padding:5px 20px;background:#ffffff;border: 0;border-radius: 3px;margin-left: 20px"> <input type="button" value="批量公开" onclick="publishAll()" style="padding:5px 20px;;background:#ffffff;border: 0;border-radius: 3px;margin-left: 20px">
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6 text-r" style="color: black;padding-right:0;margin-right:0;">
									共：<span style="color: #2a9bcf;border: none;">${page.allRow }</span> 条数据
									<a class="zj_hslist_shuaxing" href="javascript:location.replace(location.href);" title="刷新" >
										<img src="<%=request.getContextPath() %>/back/images/shuaxing.png"/>
									</a>
								</div>

					</div>
					<div class="col-xs-12 zj_hslist_table">
						<table class="table table-border table-bordered table-bg table-hover table-sort">
							<thead>
								<tr class="text-c">

									<th width="25"><input type="checkbox" name="" value="" class="allIds"></th>
									<th width="50">公开</th>
									<th width="120">藏品图片</th>
									<th width="150">藏品名称</th>
									<th width="50">二维码</th>
									<th width="150">普查编号</th>
									<th width="150">藏品编号</th>
 									<th width="100">年代</th>
									<th width="60">类别</th>
									<th width="60">级别</th>
									<th width="100">收藏单位</th>
									<th width="180">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${fccList}" var="fcc" varStatus="row">
									<tr class="text-c">
										<td>
											<input type="checkbox" class="ids" value="${fcc.id }" name="ids">
										</td>
										<td>
											<c:if test="${fcc.isOpen eq '1' }">否</c:if>
											<c:if test="${fcc.isOpen eq '2' }">是</c:if>
										</td>
										<td height="120px" width="120px">
											<a href="${fcc.fpic}" data-lightbox="gallery">
												<img alt="没有图片" src="${fcc.pictureId}" style="max-height:118px;max-width:118px;">
											</a>
										</td>
										<td>
											<c:choose>
												<c:when test="${fcc.isOpen eq '1' }">
													<a style="text-decoration:none" class="ml-5" href="<%=request.getContextPath() %>/back/oCFossil/detail.do?id=${fcc.id }&type=1" title="查看">
														${fcc.name }
													</a>
												</c:when>
												<c:otherwise>
													<a style="text-decoration:none" class="ml-5" href="<%=request.getContextPath() %>/back/oCFossil/detail.do?id=${fcc.id }&type=1" title="查看">
														${fcc.name }
													</a>
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											<c:if test="${fcc.isOpen eq '2' }">
												<a style="text-decoration:none" class="ml-5" href="javascript:void(0);" onclick="makeCodeInfo('${fcc.id }',this)"   title="二维码">
													<img src="<%=request.getContextPath() %>/back/images/erweima.png"/>
												</a>
											</c:if>
										</td>
										<td>${fcc.gsNo }</td>
										<td>${fcc.gsCollectionsNo }</td>
										<td>
											${fcc.yearType }
										</td>
										<td>
											<c:forEach items="${ccList}" var="cc">
												<c:if test="${fcc.collectionsCategory == cc.id }">
													${cc.name }
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:if test="${fcc.collectionLevel eq '1' }">珍贵</c:if>
											<c:if test="${fcc.collectionLevel eq '2' }">一般</c:if>
											<c:if test="${fcc.collectionLevel eq '0' }">其他</c:if>
										</td>
										<td>
											<c:forEach items="${museums}" var="museum">
												<c:if test="${fcc.collectionUnit == museum.id }">
													${museum.name }
												</c:if>
											</c:forEach>
										</td>
										<td class="f-14 td-manage">
											<c:if test="${fn:contains(sessionScope.user.level,3) or fn:contains(sessionScope.user.level,1)}">
												<c:if test="${fn:contains(sessionScope.user.authStr,'collectionAdmin')==true}">
													<c:if test="${fcc.status eq '4' || fcc.status eq '1'}">
														<a style="text-decoration:none" href="<%=request.getContextPath() %>/back/oCFossil/toEdit.do?id=${fcc.id }" title="编辑">
															<img src="<%=request.getContextPath() %>/back/images/bianji.png"/>
														</a>
														<c:if test="${fcc.isOpen eq '1' && fcc.status eq '4' }">
															<a style="text-decoration:none" class="ml-5"  onclick="publish('${fcc.id}')"  title="发布">
																<img src="<%=request.getContextPath() %>/back/images/fabu.png"/>
															</a>
														</c:if>
														<c:if test="${fcc.status eq '1'}">
															<a style="text-decoration:none" href="javascript:void(0)" onclick="reviewContent('${fcc.userName }','${fcc.content }')" title="回退原因">
																<img src="<%=request.getContextPath() %>/back/images/th.png"/>
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
													<input type="hidden" value="${fcc.id}" id="infoId">
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
												<a style="text-decoration:none" class="ml-5" href="<%=request.getContextPath() %>/back/oCFossil/exportPicture.do?id=${fcc.id }&name=${fcc.name}" title="导出图片">
													<img src="<%=request.getContextPath() %>/back/images/chakan.png"/>
												</a>
											</c:if>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<br>
					<div id="page" align="center"></div>
				</article>
			</div>
		</form>
	</section>
	<div id="comeBack" class="pl-30" style="display: none;">
		<h3 style='font-size:14px'>原因：</h3>
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
	//级联
	<script type="text/javascript">
	$(function(){
		$(".zj_public_haushi>a").css({
			color:"#2a9bcf",
			background:"#ffffff"
		}).children().attr("src",'<%=request.getContextPath() %>/back/images/zj_huashi.png');

		$(".zj_public_cangping>a").css({
			color:"white",
			background:"#2a9bcf"
		}).children().attr("src",'<%=request.getContextPath() %>/back/images/zj_wenwu_chose.png');
		
		$(".fabu-aside>ul>li").eq(2).addClass("dongtai");
		$("#pageSize").change(function() {
	    	var size = $(this).val();
	    	if (size == "") {
	    		return false;
	    	} else {
	    		$("#pageSizeHide").val(size); 
		    	$("#form").submit();
	    	}
    	})

	    $('.org').change(function(){
	        var pid=$(this).val();
	        var obj=$(this).next('select');
	        var first=obj.children().first().clone();
	        $.ajax({
	            url:"/admin/back/oCFossil/sltMuseum.do",
	            data:{parentId:pid},
	            type:"POST",
	            success:function(msg){
	                obj.empty().append(first);
	                for(var i in msg)
	                    obj.append("<option value="+msg[i]['id']+">"+msg[i]['shortname']+"</option>");
	            }
	        });
	    });
	});
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
            url : "/admin/back/oCFossil/reviewObject.do",
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
		   	skin: '#72CDAE', //皮肤
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
	<script type="text/javascript">
	function publishAll() {
		var data = $("form").find(".ids").serialize();
		$.ajax({
			url : "<%=request.getContextPath()%>/back/oCFossil/publishAll.do",
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
							console.log("************************");
							console.log(response);
						}
					});
					setTimeout(function(){
						window.location.href = window.location.href;
					},1000)
				}else if(data == "-1"){
					layer.msg('请先上传藏品图片', {icon: 1});
				}
				else{
					layer.msg('发布失败', {icon: 2});
				}
			},
		})
	};
	function formReset() {  
	    $(':input,#myform')  
	     .not(':button, :submit, :reset, :hidden')  
	     .val('')  
	     .removeAttr('checked')  
	     .removeAttr('selected');     
	}
	function non_publishAll() {
		var data = $("form").find(".ids").serialize();
		$.ajax({
			url : "<%=request.getContextPath()%>/back/oCFossil/nonPublishAll.do",
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
			url : "<%=request.getContextPath()%>/back/oCFossil/publish.do",
			type : "get",
			data :  {ids:id},
			dataType : "json",
			success : function(data){
				if(data == "1"){
					$.ajax({
						url:"<%=request.getContextPath()%>/image/printWatermarkForEachCollection.do",
						type : "post",
						data :  data,
						dataType : "json",
						success:function(response){
							console.log("************************");
							console.log(response);
						}
					});
					layer.msg('发布成功', {icon: 1});
					setTimeout(function(){
						window.location.href = window.location.href;
					},1000)

				}else if(data == "-1"){
					layer.msg('请先上传藏品图片', {icon: 1});
				}else{
					layer.msg('发布失败', {icon: 2});
				}
			},
		})
	};

	function non_publish(id) {
		$.ajax({
			url : "<%=request.getContextPath()%>/back/oCFossil/nonPublish.do",
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
						url : "<%=request.getContextPath()%>/back/oCFossil/del.do",
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

	</script>
	<script type="text/javascript">
		$(function(){
		    $('.yearType').change(function(){
		        var pid=$(this).val();
		        var obj=$(this).next('select');
		        var first=obj.children().first().clone();
		        $.ajax({
		            url:"/admin/back/fCFossil/sltYearType.do",
		            data:{pid:pid},
		            type:"POST",
		            success:function(msg){
		                obj.empty().append(first);
		                for(var i in msg)
		                    obj.append("<option value="+msg[i]['id']+">"+msg[i]['name']+"</option>");
		            }
		        });
		    });
		});

		function toTop(id) {
			$.ajax({
				url : "<%=request.getContextPath()%>/back/oCFossil/top.do",
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
				url : "<%=request.getContextPath()%>/back/oCFossil/down.do",
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
	</script>
<script type="text/javascript">
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
                   "<button class='btn button btn-primary size-S' id='save' style='float: right;margin-right: 15px;margin-bottom: 10px;'>下载</button>" //这里content是一个普通的String
		});
	  var qrcode = new QRCode(document.getElementById("qrcode"), {
            text:name,
			width : 270,
			height : 270
		});
		 //var elText1 = 'http://www.jlsdmu.com/mip/jilin2/index.html#/scrollMode?id='+elText+'&isSm=0';
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

	/*  layer.msg(elText1, {icon: 1});*/
	/*  qrcode.makeCode(elText1); */

    //下载
    $("#save").click(function(){
        $("#download").attr('href', url).get(0).click();
        return false;
    })
    /* $("#save").click(function(){
        var canvas = $('#qrcode').find("canvas").get(0);
        try {//解决IE转base64时缓存不足，canvas转blob下载
            var blob = canvas.msToBlob();
            navigator.msSaveBlob(blob, 'qrcode.jpg');
        } catch (e) {//如果为其他浏览器，使用base64转码下载
            var url = canvas.toDataURL('image/jpeg');
            $("#download").attr('href', url).get(0).click();
        }
        return false;
    }) */

}
function reviewObject(id,status){
	var content="您确定该信息审核通过吗？";
	if(status==1){
		content="您确定该信息审核未通过吗？";
	}
	layer.confirm(content, {
        btn: ['确定','取消'] //按钮
    }, function(index){
		$.ajax({
            type : "post",
            async : true, //同步执行
            data :  {id:id,status:status},
            url : "/admin/back/oCFossil/reviewObject.do",
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
	if($("#checkNumber").html()<10){
		$("#checkNumber").html(10);
	}else{
		$("#checkNumber").html(0);
	}
})
function onClickHander(obj){
	$(".ids").attr("checked",false);
	$(".allIds").attr("checked",false);
	$("#checkNumber").html(0);
}
function selectUnit(){
	var pid = $("#erea").val();
	$.ajax({
		url:"<%=request.getContextPath() %>/museumInfoManage/region.do",
        data:{pid:pid},
        type:"POST",
        success:function(msg){
        	$("#museum").html("");
        	$("#museum").append("<option value=''>收藏单位</option>");
        	for(var i in msg){
        		$("#museum").append("<option value="+msg[i]['id']+">"+msg[i]['name']+"</option>");
        	}
        }
    });
}
$("#yearTypeEon").change(function(){
    var pid=$("#yearTypeEon").val();
    $.ajax({
        url:"/admin/back/fCFossil/sltYearType.do",
        data:{pid:pid},
        type:"POST",
        success:function(msg){
        	$("#yearTypeEra").html("");
        	$("#yearTypeEra").append("<option value=''>请选择</option>");
        	for(var i in msg){
        		$("#yearTypeEra").append("<option value="+msg[i]['id']+">"+msg[i]['name']+"</option>");
        	}
        }
    });
});
$("#yearTypeEra").change(function(){
    var pid=$("#yearTypeEra").val();
    $.ajax({
        url:"/admin/back/fCFossil/sltYearType.do",
        data:{pid:pid},
        type:"POST",
        success:function(msg){
        	$("#yearTypeEpoch").html("");
        	$("#yearTypeEpoch").append("<option value=''>请选择</option>");
        	for(var i in msg){
        		$("#yearTypeEpoch").append("<option value="+msg[i]['id']+">"+msg[i]['name']+"</option>");
        	}
        }
    });
});
</script>
</body>
</html>
