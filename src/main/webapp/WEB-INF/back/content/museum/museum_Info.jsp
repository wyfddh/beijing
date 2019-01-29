<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="favicon.ico">
<link rel="Shortcut Icon" href="favicon.ico" />
<!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back/static/h-ui.admin/skin/default/skin.css"
	id="skin" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/css/cover.css" />
<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/css/jquery.gridly.css" /> --%>
<style>
.tabBar {
	border-bottom: none;
}

.tabBar span.current {
	background: #3c8560;
}

.tx {
	text-align: right !important;
}
#coverAudio{
    width: 1000px;height: 500px;background: rgba(0,0,0,0.7);position: fixed;left: 25%;top:20%;border:5px solid lightslategray;min-width: 800px; z-index:100; display: none;
}
.turnImgWrap{
    width: 156px;
    height: 108px;
 		float: left;
    border-radius: 5px;
    margin: 0 10px 10px 5px;
    position: relative;
    border: 1px solid #d4d4d4;
		cursor: pointer;
}
.img{
    width: 156px;
    height: 108px;
    border-radius: 5px;
}
.img img{
    width: 156px;
    height: 108px;
    border-radius: 5px;
}
 .delAll{
 	background-color: rgba(255,255,255,0);
 	border: none;
 	display: block;
    position: absolute;
    left: -10px;
    top:-10px;
 }
 .int-text{
     width: 80%;
     outline: none;
     border: 1px solid #E6E6E6;
     height: 25px;
 }
 .upfile{
     display: block;
     width: 100%;
     height: 100%;
     position: absolute;
     left: 0;
     top:0;
     opacity: 0;
     cursor: pointer;
 }
 .Hui-article-box{
     overflow-x: hidden!important;
     overflow-y: auto!important;
 }
 .lianjie{
     margin-top: 100px;
 }
#editor{
   margin-left:-10px;
}
.tabCon ul{
	overflow: hidden;
}
.tabCon ul li {
float:left;
height:560px;

border:1px solid #ddd;
margin:0 40px;
margin-bottom:40px;
}
/* .tabCon ul li:nth-child(2),.tabCon ul li:nth-child(5),.tabCon ul li:nth-child(8){
margin:0 50px;
} */
.tabCon ul li p {
	text-align:center;
	font-size:26px;
	color:gold;
}
.tabCon ul li p input {
	margin-right:10px;
}


.zj_museumInfo{
	border-radius:5px ;
}
.zj_museumInfo_title{
	font-size: 16px;
	font-weight: bold;
	padding: 30px 0 12px 30px;
	border-bottom: 1px solid #f1f2f7;
}
.add{
	padding: 17px 0 20px 30px;
	border-bottom: 5px solid #f1f2f7;
}
#addNew>img{
	display: block;
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	margin: auto;
}
.addImgLogo{
	display: block;
	text-align: center;
	line-height: 100px;
	font-size: 40px;
	width: 156px;
    height: 108px;
}
.zj_museumInfo_audio{
	padding: 17px 0 20px 30px;
	border-bottom: 5px solid #f1f2f7;
}
.zj_museumInfo_audio>span:nth-child(1){
	display: block;
	color: white;
	background-color: #2a9bcf;
	width: 82px;
	border-radius: 5px;
	padding: 10px;
	font-size: 14px;
	line-height: 16px;
	margin-bottom: 18px;
	cursor: pointer;
}
.zj_museumInfo_type{
	padding: 17px 0 20px 30px;
	border-bottom: 5px solid #f1f2f7;
}

#zj_museumInfo_slider{
	padding-left:10px
}

#zj_museumInfo_slider ul img{
	display: block;
	width: 144px;
	height: 101px;
	border-radius:5px;
}
#zj_museumInfo_slider li{
	width: 144px;
	margin: 0 10px;
}
#zj_museumInfo_slider li p{
	margin-top: 10px;
}
#zj_museumInfo_slider .bd,.slider{
	width: 820px;
	margin: 0;
}
#zj_museumInfo_slider .prev{
	display: block;
	position: absolute;
	padding: 10px;
	cursor: pointer;
	left: -20px;
	top: 33px;
}
#zj_museumInfo_slider .next{
	display: block;
	position: absolute;
	padding: 10px;
	cursor: pointer;
	right: -20px;
	top: 33px;
}
.zj_museumInfo_column{
	padding-left: 30px;
	padding-bottom: 100px;
	border-bottom: 5px solid #f1f2f7;
	position: relative;
}
.zj_museumInfo_column>p{
	font-size: 14px;
	color: #7a7a7a;
}
.zj_museumInfo_column>p>span{
	color: #999999;
}
#zj_museumInfo_column{
	width: 565px;
}
.zj_museumInfo_columnImg{
	display: block;
	float: left;
	width: 100px;
	height: 76px;
	margin:0 6px 50px;
	border-radius: 5px;
	overflow: hidden;
	position: relative;
}
.zj_museumInfo_columnImg a{
	display: block;
	position: absolute;
	bottom: 0;
	left: 0;
	width: 100px;
	background-image: url(<%=request.getContextPath()%>/back/images/zj_museuminfo_edit.png);
	background-repeat: no-repeat;
	background-position: 15px center;
	color: white;
	background-color: rgba(0,0,0,0.5);
	font-size: 10px;
	padding: 3px 0 3px 30px;
	text-decoration: none;

}
.zj_museumInfo_columnImg img{
	display: block;
	width: 100px;
	height: 76px;
}
.zj_museumInfo_column_1{
	display: block;
	position: absolute;
	top: 115px;
	left: 70px;
	font-size: 14px;
}
.zj_museumInfo_column_1{
	display: block;
	position: absolute;
	top: 115px;
	left: 70px;
	font-size: 14px;
}
.zj_museumInfo_column_2{
	display: block;
	position: absolute;
	top: 115px;
	left: 175px;
	font-size: 14px;
}
.zj_museumInfo_column_3{
	display: block;
	position: absolute;
	top: 115px;
	left: 288px;
	font-size: 14px;
}
.zj_museumInfo_column_4{
	display: block;
	position: absolute;
	top: 115px;
	left: 400px;
	font-size: 14px;
}
.zj_museumInfo_column_5{
	display: block;
	position: absolute;
	top: 115px;
	left: 515px;
	font-size: 14px;
}
.layui-layer-border{
    border:none!important;
    box-shadow:none!important;
    border-radius:5px!important;
    overflow:hidden!important;
}
.layui-layer-title{
    height:75px!important;
    line-height:70px!important;
    border-bottom:5px solid #f1f2f7!important;
    box-sizing:border-box;
    background:#fff!important;
    font-size: 18px;
    font-family: "PingFang";
    color: rgb(51, 51, 51);
    font-weight: bold;
}
.layui-layer-setwin{
    top:30px!important;
}
#edui1{
	width: 872px !important;
}
.zj_museuminfo_saveOut{
	background-color: white;
	width: 100%;
	position: fixed;
	bottom: 0;
}
.zj_museuminfo_save{
    display: block;
	background-color: #2a9bcf;
	color: white;
	padding: 9px 15px 9px 35px;
	border-radius: 5px;
	text-decoration: none;
	height: 18px;
	line-height: 18px;
	border: 1px solid #2a9bcf;
	height: 36px;
	background-image: url(<%=request.getContextPath() %>/back/images/save.png);
	background-repeat: no-repeat;
	background-position: 10px center;
	margin: 12px 0 36px 30px;
	cursor: pointer;
}
.zj_museumInfo_addColum{
	display: block;
	float: left;
	width: 100px;
	height: 76px;
	margin:0 6px 50px;
	border-radius: 5px;
	overflow: hidden;
	position: relative;

}
.zj_museumInfo_addColum img{
	display: block;
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	margin: auto;
	cursor: pointer;
}
.addColum_title{
	border: 1px solid #f1f2f7;
	width: 214px;
	padding: 6px 10px;
	font-size: 14px;
	background-color: #fcfcfc;
	border-radius: 5px;
}
.addColum_content{
	border: 1px solid #f1f2f7;
	width: 820px;
	height: 296px;
	padding: 6px 10px;
	font-size: 14px;
	background-color: #fcfcfc;
	border-radius: 5px;
	resize:none;
}
.zj_addColum_save{
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
	background-image: url(<%=request.getContextPath() %>/back/images/save.png);
	background-repeat: no-repeat;
	background-position: 10px center;
	margin: 32px 0 15px 54px;
	cursor: pointer;
}
.zj_addColum_cancel{
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
	background-image: url(<%=request.getContextPath() %>/back/images/cancel.png);
	background-repeat: no-repeat;
	background-position: 10px center;
	margin: 32px 0 15px 15px;
	cursor: pointer;
}
</style>
<!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>博物馆信息管理</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>

	<%@ include file="../../organization/weihuNav.jsp"%>

	<!--_menu 左边slide导航开始-->
	<%@ include file="../aside.jsp"%>
	<!--/_menu 作为公共模版分离出去-->

	<div id="header"></div>
	<section class="Hui-article-box section_box">
		<!--<nav class="breadcrumb"> <i class="Hui-iconfont">&#xe67f;</i> 首页<span
		class="c-gray en">&gt;</span>内容管理<span class="c-gray en">&gt;</span>信息管理<a
		class="btn btn-success radius r"
		style="line-height: 1.6em; margin-top: 3px"
		href="javascript:location.replace(location.href);" title="刷新"><i
		class="Hui-iconfont">&#xe68f;</i></a>
		</nav>-->
	<div class="Hui-article">
		<form action="<%=request.getContextPath()%>/museuminfo/updateNew.do" method="post" class="form form-horizontal biaodan" id="subForm">
			<div class="zj_museumInfo">
				<!--轮播图-->
				<div class="zj_museumInfo_title">
					<span>博物馆轮播图</span>
				</div>
				<div class="add">
				<input type="hidden" name="pictureId" value="">
					<c:forEach items="${museumCarouselInfo}" var="muc" varStatus="status">
						<div class="turnImgWrap" ondrop="drop(event,this)" ondragover="allowDrop(event)" draggable="true" ondragstart="drag(event, this)">
							<div class="img">
								<img src="${muc.id}">
								<input type="hidden" name="pictureId" value="${muc.pictureid}">
							</div>
							<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
								<c:if test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
									<button class="delAll">
										<img src="<%=request.getContextPath()%>/back/images/zj_museuminfo_delete.png" alt="" />
									</button>
								</c:if>
							</c:if>
						</div>
					</c:forEach>
					<c:if test="${fn:length(museumCarouselInfo)==0}">
						<div class="turnImgWrap"  ondrop="drop(event,this)" ondragover="allowDrop(event)" draggable="true" ondragstart="drag(event, this)">
							<div class="img">
								<span class="addImgLogo">+</span>
								<input type="hidden" name="pictureId"/>
							</div>
							<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
								<c:if test="${fn:contains(sessionScope.user.authStr,'+contentAdmin+')==true}">
									<button class="delAll" id="del"><img src="<%=request.getContextPath()%>/back/images/zj_museuminfo_delete.png" alt="" /></button>
								</c:if>
							</c:if>
						</div>
					</c:if>
					<div class="turnImgWrap" id="addNew" style="border: none;">
						<img src="<%=request.getContextPath()%>/back/images/zj_museuminfo_addImg.png" alt="" />
					</div>
					<div style="clear: both;"></div>
				</div>

				<!--讲解词-->
				<div class="zj_museumInfo_title">
					<span>博物馆讲解词</span>
				</div>
				<div class="zj_museumInfo_audio">
					<span id="myaudio">
						<i class="Hui-iconfont">&#xe600;</i>
	            		添加音频
					</span>
					<audio src="${museumInfo.audioPath }" controls></audio>
					<input type="text" class="input-text hidden" name="fAudio" value="${museumInfo.fAudio }" id="upload_audio">
				</div>
				<!--换皮肤-->
				<div class="zj_museumInfo_title">
					<span>更换皮肤</span>
				</div>
				<div class="zj_museumInfo_type">
					<div id="zj_museumInfo_slider">
						<div class="slider">
							<div class="bd" style="overflow: hidden;position: relative;height: 143px;">
								<ul class="museum_type" style="width: 1476px;position: absolute;">
									<li>
										<img src="<%=request.getContextPath()%>/back/images/museum_default.jpg" >
										<p><input name="thinId" type="radio" value="0" <c:if test="${museumInfo.thinId eq '0'}">checked="checked"</c:if> />默认</p>
									</li>
									<li>
										<img src="<%=request.getContextPath()%>/back/images/museum_revolution.jpg">
										<p><input name="thinId" type="radio" value="1" <c:if test="${museumInfo.thinId eq '1'}">checked="checked"</c:if> />革命</p>
									</li>
									<li>
										<img src="<%=request.getContextPath()%>/back/images/museum_remember.jpg" >
										<p><input name="thinId" type="radio" value="2" <c:if test="${museumInfo.thinId eq '2'}">checked="checked"</c:if> />纪念</p>
									</li>
									<li>
										<img src="<%=request.getContextPath()%>/back/images/museum_history-1.jpg" >
										<p><input name="thinId" type="radio" value="3" <c:if test="${museumInfo.thinId eq '3'}">checked="checked"</c:if> />历史</p>
									</li>
									<li>
										<img src="<%=request.getContextPath()%>/back/images/museum_history-2.jpg" >
										<p><input name="thinId" type="radio" value="4" <c:if test="${museumInfo.thinId eq '4'}">checked="checked"</c:if> />历史</p>
									</li>
									<li>
										<img src="<%=request.getContextPath()%>/back/images/museum_history-3.png" >
										<p><input name="thinId" type="radio" value="5" <c:if test="${museumInfo.thinId eq '5'}">checked="checked"</c:if> />历史</p>
									</li>
									<li>
										<img src="<%=request.getContextPath()%>/back/images/museum_nationalities.jpg" >
										<p><input name="thinId" type="radio" value="6" <c:if test="${museumInfo.thinId eq '6'}">checked="checked"</c:if> />民俗</p>
									</li>
									<li>
										<img src="<%=request.getContextPath()%>/back/images/museum_art.jpg" >
										<p><input name="thinId" type="radio" value="7" <c:if test="${museumInfo.thinId eq '7'}">checked="checked"</c:if> />艺术</p>
									</li>
									<li>
										<img src="<%=request.getContextPath()%>/back/images/museum_natural.jpg" >
										<p><input name="thinId" type="radio" value="8" <c:if test="${museumInfo.thinId eq '8'}">checked="checked"</c:if> />自然</p>
									</li>
								</ul>
							</div>
							<span class="prev">
								<img src="<%=request.getContextPath()%>/back/images/zj_museuminfo_back.png" alt="" />
							</span>
							<span class="next">
								<img src="<%=request.getContextPath()%>/back/images/zj_museuminfo_next.png" alt="" />
							</span>
						</div>
					</div>
					<!--<script type="text/javascript" src="http://lib.h-ui.net/jquery.SuperSlide/2.1.1/jquery.SuperSlide.min.js"></script>-->
					<script type="text/javascript">
						$(function(){
							var left=true,
								right=false;

							$(".next").on("click",function(){


								if(left && !$(".museum_type").is(":animated")){

									$(".museum_type").animate({
											left:"-=656px"
										},200,function(){

										right=true;

										parseInt($(".museum_type").css("left"))<=-656 && (left=false)

									});


									// $(".museum_type").animate({
									// 		left:"-=164px"
									// 	},200,function(){
									//
									// 	right=true;
									//
									// 	parseInt($(".museum_type").css("left"))<=-656 && (left=false)
									//
									// });

								}

							});


							$(".prev").on("click",function(){
								if(right && !$(".museum_type").is(":animated")){
									// $(".museum_type").animate({
									// 	left:"+=164px"
									// },200,function(){
									//
									// 	left=true;
									//
									// 	parseInt($(".museum_type").css("left"))>=0 && (right=false)
									//
									// });
									$(".museum_type").animate({
										left:"+=656px"
									},200,function(){

										left=true;

										parseInt($(".museum_type").css("left"))>=0 && (right=false)

									});

								}

							})

//							var bl=true;
//
//							$(".next").on("click",function(){
//
//								var dis=parseInt($(".museum_type").css("left"));
//
//								if(dis<=-656 || dis>=0){
//
//
//
//
//								}
//
//
//
//							});





						});
					</script>
				</div>
				<!--主页栏目-->
				<div class="zj_museumInfo_title">
					<span>主页栏目</span>
				</div>
				<div class="zj_museumInfo_column">
					<p style="margin-top: 15px;">可选栏目（拖动到你想放置的位置）</p>

					<script src="//cdnjs.cloudflare.com/ajax/libs/Sortable/1.6.0/Sortable.min.js"></script>
					<style>
						.list-group-item{
							float: left !important;
							display: block;
							padding: 10px;
							background-color: chartreuse;
							margin: 5px;
						}
					</style>
					<ul id="zj_museumInfo_column">
					<c:forEach items="${subjectList}" var="sub" varStatus="status">
					<c:choose>
						<c:when test="${sub.name=='场馆介绍'||sub.name=='历史沿革'||sub.name=='展览概况'||sub.name=='藏品总说'||sub.name=='参观须知'||sub.name=='如何买票'||sub.name=='周边服务'||sub.name=='服务信息'||sub.name=='参观指南'||sub.name=='附近餐饮'}">
							<c:if test="${sub.name=='场馆介绍'}">
							<li class="zj_museumInfo_columnImg">
								<img src="<%=request.getContextPath()%>/back/images/colum_cgjs.jpg" alt="" />
								<a onclick="edit('title=${sub.name}&name=${sub.name}&id=${sub.id}','${sub.name}')">${sub.name}</a>
								<input type="hidden" name="colmu" value="${sub.id}" />
								<input type="hidden" name="colmuName" value="${sub.name}" />
							</li>
							</c:if>
							<c:if test="${sub.name=='历史沿革'}">
							<li class="zj_museumInfo_columnImg">
								<img src="<%=request.getContextPath()%>/back/images/colum_lsyg.jpg" alt="" />
								<a onclick="edit('title=${sub.name}&name=${sub.name}&id=${sub.id}','${sub.name}')">${sub.name}</a>
								<input type="hidden" name="colmu" value="${sub.id}" />
								<input type="hidden" name="colmuName" value="${sub.name}" />
							</li>
							</c:if>
							<c:if test="${sub.name=='展览概况'}">
							<li class="zj_museumInfo_columnImg">
								<img src="<%=request.getContextPath()%>/back/images/colum_zlgk.jpg" alt="" />
								<a onclick="edit('title=${sub.name}&name=${sub.name}&id=${sub.id}','${sub.name}')">${sub.name}</a>
								<input type="hidden" name="colmu" value="${sub.id}" />
								<input type="hidden" name="colmuName" value="${sub.name}" />
							</li>
							</c:if>
							<c:if test="${sub.name=='藏品总说'}">
							<li class="zj_museumInfo_columnImg">
								<img src="<%=request.getContextPath()%>/back/images/colum_cpzs.jpg" alt="" />
								<a onclick="edit('title=${sub.name}&name=${sub.name}&id=${sub.id}','${sub.name}')">${sub.name}</a>
								<input type="hidden" name="colmu" value="${sub.id}" />
								<input type="hidden" name="colmuName" value="${sub.name}" />
							</li>
							</c:if>
							<c:if test="${sub.name=='参观须知'||sub.name=='参观指南'}">
							<li class="zj_museumInfo_columnImg">
								<img src="<%=request.getContextPath()%>/back/images/colum_cgzl.jpg" alt="" />
								<a onclick="edit('title=${sub.name}&name=${sub.name}&id=${sub.id}','${sub.name}')">${sub.name}</a>
								<input type="hidden" name="colmu" value="${sub.id}" />
								<input type="hidden" name="colmuName" value="${sub.name}" />
							</li>
							</c:if>
							<c:if test="${sub.name=='如何买票'}">
							<li class="zj_museumInfo_columnImg">
								<img src="<%=request.getContextPath()%>/back/images/colum_rhgp.jpg" alt="" />
								<a onclick="edit('title=${sub.name}&name=${sub.name}&id=${sub.id}','${sub.name}')">${sub.name}</a>
								<input type="hidden" name="colmu" value="${sub.id}" />
								<input type="hidden" name="colmuName" value="${sub.name}" />
							</li>
							</c:if>
							<c:if test="${sub.name=='周边服务'||sub.name=='附近餐饮'}">
							<li class="zj_museumInfo_columnImg">
								<img src="<%=request.getContextPath()%>/back/images/colum_fjcy.jpg" alt="" />
								<a onclick="edit('title=${sub.name}&name=${sub.name}&id=${sub.id}','${sub.name}')">${sub.name}</a>
								<input type="hidden" name="colmu" value="${sub.id}" />
								<input type="hidden" name="colmuName" value="${sub.name}" />
							</li>
							</c:if>
							<c:if test="${sub.name=='服务信息'}">
							<li class="zj_museumInfo_columnImg">
								<img src="<%=request.getContextPath()%>/back/images/colum_fwxx.jpg" alt="" />
								<a onclick="edit('title=${sub.name}&name=${sub.name}&id=${sub.id}','${sub.name}')">${sub.name}</a>
								<input type="hidden" name="colmu" value="${sub.id}" />
								<input type="hidden" name="colmuName" value="${sub.name}" />
							</li>
							</c:if>
						</c:when>
						<c:otherwise>
							<li class="zj_museumInfo_columnImg">
								<img src="<%=request.getContextPath()%>/back/images/colum_default.jpg" alt="" />
								<a onclick="edit('title=${sub.name}&name=${sub.name}&id=${sub.id}','${sub.name}')">${sub.name}</a>
								<input type="hidden" name="colmu" value="${sub.id}" />
								<input type="hidden" name="colmuName" value="${sub.name}" />
							</li>
						</c:otherwise>
					</c:choose>

					</c:forEach>
						<span class="zj_museumInfo_addColum">
							<img src="<%=request.getContextPath()%>/back/images/zj_museuminfo_addImg.png" alt="" />
						</span>
					</ul>
					<div style="clear: both;"></div>
					<span class="zj_museumInfo_column_1">
						栏目一
					</span>
					<span class="zj_museumInfo_column_2">
						栏目二
					</span>
					<span class="zj_museumInfo_column_3">
						栏目三
					</span>
					<span class="zj_museumInfo_column_4">
						栏目四
					</span>
					<span class="zj_museumInfo_column_5">
						栏目五
					</span>

					<script type="text/javascript">
					    Sortable.create(zj_museumInfo_column,{animation: 300});
					</script>
				</div>
			</div>
			<input type="hidden" value="${museumInfo.id}" name="id">
			<input type="hidden" value="${orga.cityId}" name="cityId">
            <input type="hidden" value="${orga.name}" name="museumName">
			<!--<div id="tab-category" class="HuiTab">
				<div class="tabBar cl" style="border-bottom: 3px solid #747474">
					<span id="msg">博物馆信息</span><span id="pic" style="border-left: 2px solid #747474; border-right: 2px solid #747474;">博物馆轮播图</span><span id="thin">皮肤</span>
				</div>
				<div class="tabCon">
					<h3 style="color: #333333">博物馆基本信息</h3>
					<div>
						<div class="row cl col-xs-12 col-sm-6">
							<label class="form-label col-xs-4 text-r tx"><span class="c-red">*</span>博物馆名称:</label>
							<div class="formControls col-xs-8">
								<input disabled="disabled"
									style="outline: none; border: none; font-size: 15px; background: none;padding-top:5px;"
									value="${orga.name} " />
							</div>
						</div>
						<div class="row cl col-xs-12 col-sm-6">
							<label class="form-label col-xs-4 text-r tx"><span class="c-red">*</span>级别:</label>
							<div class="formControls col-xs-8">
								<select class="select" id="selectId" name="level" value="${museumInfo.level}">
									<option value="">请选择</option>
									<option value="1"
										<c:if test="${'1' eq museumInfo.level}">selected</c:if>>一级博物馆</option>
									<option value="2"
										<c:if test="${'2' eq museumInfo.level}">selected</c:if>>二级博物馆</option>
									<option value="3"
										<c:if test="${'3' eq museumInfo.level}">selected</c:if>>三级博物馆</option>
									<option value="4"
										<c:if test="${'4' eq museumInfo.level}">selected</c:if>>未定级</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row cl col-xs-12 col-sm-6">
						<label class="form-label col-xs-4 text-r tx"><span class="c-red">*</span>地区: </label>
						<div class="formControls col-xs-8">
							<input disabled="disabled"
								style="outline: none; border: none; font-size: 15px; background: none; padding-top:5px;"
								value="${pArea.name }  ${area.name} " />
						</div>
					</div>

					<div>
						<div class="row cl col-xs-12 col-sm-6">
							<label class="form-label col-xs-4 text-r tx"><span class="c-red">*</span>票务:</label>
							<div class="formControls col-xs-8">
								<div class="signl_check pt-5">
									<div class="radio-box" style="padding-left: 0">
										<input type="radio" id="radio-1" name="ticket" value="1"
											${museumInfo.ticket==1?'checked':''}> <label
											for="radio-1">免费</label>
									</div>
									<div class="radio-box">
										<input type="radio" id="radio-2" name="ticket" value="2"
											${museumInfo.ticket==2?'checked':''}> <label
											for="radio-1">收费</label>
									</div>
								</div>
							</div>
						</div>
						<div class="row cl col-xs-12 col-sm-6">
							<label class="form-label col-xs-4 text-r tx">票价:</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text price" name="ticketPrice"
									value="${museumInfo.ticketPrice}" placeholder="选择收费必填">
							</div>
						</div>
					</div>
	                <div class=clearfix></div>
					<div>
						<div class="row cl col-xs-12 col-sm-6">
							<label class="formControls col-xs-4 text-r tr"><span class="c-red">*</span>开放时间:</label>
							<div class="formControls col-xs-8">
								<textarea class="textarea" id="openTime" name="openingHours">${museumInfo.openingHours}</textarea>
							</div>
						</div>

                    <div class="row cl">
                        <label class="col-xs-4 col-sm-3 text-r col-md-2">音频介绍：</label>
                        <div class="formControls col-xs-3 col-sm-3 col-md-3">
                        <audio src="${museumInfo.audioPath }" controls></audio>
                            <a href="#" class="btn btn-primary radius col-md-5" id="myaudio"><i class="Hui-iconfont">&#xe642;</i> 添加音频</a>
                            <p style="line-height: 30px;" id="audioMsg" class="msg audio hidden"><i class="Hui-iconfont pt-5" style="font-size: 16px;color: #00CC44">&#xe6a8;</i></p>

                        </div>
                        <input type="text" class="input-text hidden" name="fAudio" value="${museumInfo.fAudio }" id="upload_audio">
                    </div>
					</div>
					<div style="clear: both"></div>
					<div>
						<div class="row cl col-xs-12 col-sm-6">
							<label class="formControls col-xs-4 text-r tr"><span class="c-red">*</span>详细地址:</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="address" id="address"
									value="${museumInfo.address}">
							</div>

							<label class="formControls col-xs-4 text-r tr mt-20"><span class="c-red">*</span>联系电话:</label>
							<div class="formControls col-xs-8 mt-20">
								<input type="text" class="input-text" id="phone" name="telephone" value="${museumInfo.telephone}">
							</div>
						</div>
					</div>
					<div class="row cl pt-20">
						<label class="col-xs-4 col-sm-3 text-r col-md-2">上传Logo:</label>
						<div class="formControls col-xs-3 col-sm-3 col-md-3">
							<div style="width:70px;height:70px;border:1px solid #ddd;cursor:pointer;">
								<c:if test="${museumInfo.logoUrl eq ''}">
									<img id="upLogo" src="<%=request.getContextPath()%>/back/images/upLogo.png" style="width:100%;height:100%;">
								</c:if>
								<c:if test="${museumInfo.logoUrl ne ''}">
									<img id="upLogo" src="${museumInfo.logoUrl}" style="width:100%;height:100%;">
								</c:if>
								<input id="logoId" name="logoId" type="text" value="" style="display:none;">
								<input id="logoUrl" name="logoUrl" type="text" value="" style="display:none;">
							</div>
						</div>
					</div>
					<div style="clear: both"></div>
					<div>
						<div class="row cl col-xs-12 col-sm-6">
							<label class="formControls col-xs-4 text-r tr hui-iconfont-text-width"><span class="c-red">*</span>地理信息:</label>
						</div>
						<div class="formControls col-xs-12 col-sm-8 col-offset-2">
							<script id="editor" type="text/plain"
								style="width:100%;height:400px;" name="geography">${museumInfo.geography}</script>
						</div>
					</div>
					<div style="clear: both"></div>
					<div>
						<div class="row cl col-xs-12 col-sm-6">
							<label
								class="formControls col-xs-4 text-r tr hui-iconfont-text-width"></label>
						</div>
						<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
						<c:if test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
						</c:if>
						</c:if>
					</div>
				</div>
					<div class="tabCon">
						<h3 style="color: #333333">皮肤</h3>
						<div>
							<ul>
								<li>
									<img src="<%=request.getContextPath()%>/pic/thin/博物馆详情.png" >
									<p><input name="thinId" type="radio" value="0" <c:if test="${museumInfo.thinId eq '0'}">checked="checked"</c:if> />默认</p>
								</li>
								<li>
									<img src="<%=request.getContextPath()%>/pic/thin/博物馆详情_革命.png" >
									<p><input name="thinId" type="radio" value="1" <c:if test="${museumInfo.thinId eq '1'}">checked="checked"</c:if> />革命</p>
								</li>
								<li>
									<img src="<%=request.getContextPath()%>/pic/thin/博物馆详情_纪念.png" >
									<p><input name="thinId" type="radio" value="2" <c:if test="${museumInfo.thinId eq '2'}">checked="checked"</c:if> />纪念</p>
								</li>
								<li>
									<img src="<%=request.getContextPath()%>/pic/thin/博物馆详情_历史.png" >
									<p><input name="thinId" type="radio" value="3" <c:if test="${museumInfo.thinId eq '3'}">checked="checked"</c:if> />历史</p>
								</li>
								<li>
									<img src="<%=request.getContextPath()%>/pic/thin/博物馆详情_历史1.png" >
									<p><input name="thinId" type="radio" value="4" <c:if test="${museumInfo.thinId eq '4'}">checked="checked"</c:if> />历史</p>
								</li>
								<li>
									<img src="<%=request.getContextPath()%>/pic/thin/博物馆详情_历史2.png" >
									<p><input name="thinId" type="radio" value="5" <c:if test="${museumInfo.thinId eq '5'}">checked="checked"</c:if> />历史</p>
								</li>
								<li>
									<img src="<%=request.getContextPath()%>/pic/thin/博物馆详情_民俗.png" >
									<p><input name="thinId" type="radio" value="6" <c:if test="${museumInfo.thinId eq '6'}">checked="checked"</c:if> />民俗</p>
								</li>
								<li>
									<img src="<%=request.getContextPath()%>/pic/thin/博物馆详情_艺术.png" >
									<p><input name="thinId" type="radio" value="7" <c:if test="${museumInfo.thinId eq '7'}">checked="checked"</c:if> />艺术</p>
								</li>
								<li>
									<img src="<%=request.getContextPath()%>/pic/thin/博物馆详情_自然.png" >
									<p><input name="thinId" type="radio" value="8" <c:if test="${museumInfo.thinId eq '8'}">checked="checked"</c:if> />自然</p>
								</li>
							</ul>
						</div>
					</div>
				</div>-->
				<input type="submit" style="opacity: 0;height: 0;overflow: hidden;" id="submit" value="保存">
				<div class="zj_museuminfo_saveOut">
					<input type="button" class="zj_museuminfo_save" value="保存">
				</div>

		</form>
		<form id="upload" style="position: absolute; z-index: -100; left:0;top:0;opacity: 0;">
			<input id="file" type="file" name="file">
		</form>
         <!--音频遮罩层开始-->
        <form id="uploadFormAudio" enctype="multipart/form-data" method="post" >
	         <div id="coverAudio">
	             <a href="javascript:;" class="Hui-iconfont c-white btn btn-danger close">&#xe6a6;</a>
	             <div class="row cl pt-20 pl-30 col-offset-1" style="padding-top: 120px;">
	                 <label class="col-xs-4 col-sm-3 text-r col-md-2 c-white lig" id="cTitle">请选择音频文件：</label>
	                 <div class="formControls col-xs-8 col-sm-9 col-md-8">
		                 <span class="btn-upload form-group">
		                     <input class="upload-url" type="text" name="uploadfile" id="uploadAudio" readonly nullmsg="请添加附件！" style="outline: none;border: 1px solid #DDDDDD;height: 29px;">
		                     <a href="#" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
		         			<input type="file" name="file" class="input-file"  id="accIntAudio">
		    			 </span>
	                 </div>
	             </div>
	             <div class="row cl text-c pd-40">
	             	<input type="button" id="uploadAudio_button" value="上传" class="btn btn-primary radius upload">
	                <input type="reset" href="javascript:;" class="btn btn-danger radius ml-20" id="close" value="重置" />
	             </div>
	         </div>
         </form>
	</div>
</section>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/ueditor/ueditor.all2.js"> </script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script>
		$(".zj_museuminfo_save").on("click",function(){

			$(".zj_museumInfo_columnImg").each(function(index,item){

				index>=5 && $(this).find("input").remove();

			});

			$("#submit").click();

		});

		$(".zj_museumInfo_addColum>img").on("click",function(e){

			layer.open({
	            type: 1,
	            title: "新增博物馆栏目",
	            shadeClose: true,
	            shade: 0.5,
	            maxmin: false, //开启最大化最小化按钮
	            area: ['890px', '600px'],
	            content:
	            	"<div style='padding:25px'>"
	            	+"<form action='<%=request.getContextPath()%>/museuminfo/creatSbuject.do' method='post'>"
	            	+"<span style='font-size:14px'>栏目名称：</span>"
	            	+"<input type='text' placeholder='请输入栏目名称最多四个字' maxlength='4' class='addColum_title' name='addColumTitle'>"
	            	+"<input type='hidden' name='addColumMuseumId' value='${museumInfo.id}'>"
	            	+"<input type='hidden' name='addSubject' value='1'>"
	            	+"<input type='hidden' name='addModel' value='1'>"
	            	+"<h3 style='font-size:14px'>栏目内容：</h3>"
	            	+"<textarea class='addColum_content' name='addColumText'></textarea>"
	            	+"<input id='addColum' type='submit' style='opacity:0;height:0;' value='保存'>"
	            	+"<input type='button' class='zj_addColum_save' value='保存'>"
	            	+"<input type='button' class='zj_addColum_cancel' value='取消' onclick='layer.closeAll()'>"
	            	+"</form>"
	            	+"</div>"
	        });

		});

		$(document).on("click",".zj_addColum_save",function(e){

//			$(".zj_museumInfo_addColum").before($(".zj_museumInfo_columnImg").last().clone());


			var titleVal=$(".addColum_title").val(),
				bl=false;

			$("#zj_museumInfo_column").find("a").each(function(index,item){

				($(item).text() == titleVal || titleVal=="") && (bl=true)

			});

			if(bl){

				$(".addColum_title").val("").attr("placeholder","标题输入错误！！！");

			}else{

				$("#addColum").click();

			}

		});

	</script>




	<script type="text/javascript">
//       $.Huitab("#tab-category .tabBar span", "#tab-category .tabCon", "current", "click", "0");
//       var ue = UE.getEditor('editor',{
//       	toolbars: [
//               ['map']
//           ],
//       });
        /*  ue.ready(function() {
	         //设置编辑器的内容
	         ue.setContent('${museumInfo.geography}',true);
	     }); */
    </script>
	<script type="text/javascript">

		function edit(value,name){
	        layer.open({
	            type: 2,
	            title: name,
	            shadeClose: true,
	            shade: 0.5,
	            maxmin: true, //开启最大化最小化按钮
	            area: ['890px', '600px'],
	            content: ['<%=request.getContextPath()%>/museumColumn/toUpdatePage.do?'+value]
	        });
	    }

	    function hasPrice(){
	         var val = $("input:radio[name='ticket']:checked").val();
	         if(val == 1){
	               $(".price").attr("disabled","disabled").val("");
	         }
	         if(val == 2){
	               $(".price").removeAttr("disabled","disabled");
	         }
	    }
	    hasPrice();
	    $("input:radio[name='ticket']").change(function(){
	         hasPrice();
	    });


	    //表单验证
	    $(".save").click(function(){
	        if($("#selectId").val() == ""){
	            layer.open({
	                 title: '提示',
	                 content: '您还没有选择级别'
	            });
	            return false;
	        }else if($("input:radio[name='ticket']:checked").val() == 2 && ($(".price").val() == "")){
	             layer.open({
	                 title: '提示',
	                 content: '您还没有添加票价'
	             });
	             return false;
	        }else if($("#openTime").val() == ""){
	            layer.open({
	                title: '提示',
	                content: '您还没有添加开放时间'
	            });
	            return false;
	        }else if($("#address").val() == ""){
	            layer.open({
	                title: '提示',
	                content: '您还没有添加详细地址'
	            });
	            return false;
	        }else if($("#phone").val() == ""){
	            layer.open({
	                title: '提示',
	                content: '您还没有添加联系电话'
	            });
	            return false;
	        }else if(UE.getEditor('editor').getContent() == ""){
	            layer.open({
	                title: '提示',
	                content: '您还没有添加地理信息'
	            });
	            return false;
	        }else{
//	        	var formData = new FormData($("form#subForm")[0]);
//	    		$.ajax({
//<%--	    			url : "<%=request.getContextPath() %>/museuminfo/update.do",--%>
//	    			type : "post",
//	    			data :  formData,
//	    			dataType:"json",
//	                success: function (data) {alert(3);
//	    	            layer.open({
//		                	title: '提示',
//		                	content: '提交成功'
//		            	});
//                	}
//	    		});
//    			return false;

	            layer.open({
	                title: '提示',
	                content: '提交成功'
	            });
//               setTimeout(function(){
//                  $("form#subForm")[0].submit();
//               },500);
	        }
	    });
	</script>
<script type="text/javascript">
	$(function(){

		$(".close").click(function(){

			$("#coverAudio").slideUp(300);

		})
		$(".fabu-aside>ul>li").eq(3).addClass("weihu");
		$(".headerNav a.wangzhanweihu").addClass("active");
		$(".headerNav a.wangzhanweihu").find("img").attr("src",'<%=request.getContextPath() %>/back/images/webweihuicon.png');
	});



    //点击新增按钮
    var contentAdmin = 'contentAdmin';
    $("#addNew").on("click",function(){
        $("#addNew").before('<div class="turnImgWrap"  ondrop="drop(event,this)" ondragover="allowDrop(event)" draggable="true" ondragstart="drag(event, this)"> ' +
                        '<div class="img">'+
                        	'<span class="addImgLogo">+</span>'+
                            '<input type="hidden" name="pictureId"/>'+
                        '</div>' +
                        '<c:if test="${fn:contains(sessionScope.user.level,3)==true}">'+
						'<c:if test="${fn:contains(sessionScope.user.authStr,'+contentAdmin+')==true}">'+
                        '<button class="delAll" id="del"><img src="<%=request.getContextPath()%>/back/images/zj_museuminfo_delete.png" alt="" /></button>'+
                        '</c:if>'+
                        '</c:if>'+
                '</div>'


        );
        return false;
    });

    //点击删除按钮
    $(".add").delegate("button","click",function(){
        $(this).parent(".turnImgWrap").remove();
    });


    var that;
    $(".add").delegate(".img","click",function(){
		<%--$(".img").removeAttr("id");--%>
	    <%--$(this).attr("id","addPic");--%>
    	that=$(this);
    	<%--$("#file").click();--%>
    	<%--return false;--%>
		layer.open({
			type: 2,
			title: '裁剪图片',
			shadeClose: true,
			shade: 0.8,
			area: ['800px', '730px'],
			content: '<%=request.getContextPath() %>/cropper/cropMuseum.html' //iframe的url
		});
    });
    <%--//图片上传并回显--%>
    <%--$("#file").change(function(){--%>
    	<%--var formData = new FormData($("#upload")[0]);--%>
    	<%--$.ajax({--%>
    		<%--url : "<%=request.getContextPath() %>/file/uploadPicture.do?typeId=14&objectId=",--%>
			<%--type : "post",--%>
			<%--data :  formData,--%>
			<%--dataType:"json",--%>
			<%--async: false,--%>
          	<%--cache: false,--%>
          	<%--contentType: false,--%>
          	<%--processData: false,--%>
            <%--success: function(data){--%>
            	<%--$(that).find("span").html("<img src="+data.url+">");--%>
        		<%--$(that).find("input").val(data.picId);//.attr("name","'+data.picId+'")--%>
               <%--layer.msg('[OK]上传成功', {icon: 1});--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>
  //上传音频
    $(function(){
    	$("#uploadAudio_button").click(function() {
    		 var formData = new FormData($( "#uploadFormAudio" )[0]);
    		 if($("#accIntAudio").val()==null||$("#accIntAudio").val()==""){
    			 layer.msg('请选择音频地址', {icon: 1});
    			 return;
    		 }

    		$.ajax({
    			url : "<%=request.getContextPath() %>/file/uploadAudio.do",
    			type : "post",
    			data :  formData,
    			dataType:"json",
    			 async: false,
              cache: false,
              contentType: false,
              processData: false,
                success: function (data) {
                    if(data.error == 1){
                    	layer.msg(data.message, {icon: 1});
                    }
                    if(data.error == 0){
                       layer.msg('[OK]上传成功', {icon: 1});
                       $("#upload_audio").attr("value",data.url);
                       $("audio").attr("src",data.src);
                       setTimeout(function(){
                    	   $("#coverAudio").slideUp(300);
                    	   $("#uploadAudio").val("");
                    	   $("#accIntAudio").val("");
    					},1000)
                    }
                },
    		})
    	});
    });
	//点击音频按钮
	$("#myaudio").click(function(){
	    $("#cTitle").html("请添加音频文件");
	    $("#coverAudio").slideDown(500);
	});
</script>
	<%--上传logo--%>
	<script>
		$("#upLogo").click(function(){
			var thatLogo = $(this);
			layer.open({
				type: 2,
				title: '裁剪图片',
				shadeClose: true,
				shade: 0.8,
				area: ['800px', '730px'],
				content: '<%=request.getContextPath() %>/cropper/cropMuseumLogo.html' //iframe的url
			});
		});
	</script>

</body>
</html>
