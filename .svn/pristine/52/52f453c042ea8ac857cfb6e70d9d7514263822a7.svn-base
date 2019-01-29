<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">  
<head>     
    <meta charset="UTF-8">    
    <meta name="renderer" content="webkit|ie-comp|ie-stand">  
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" > 
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/html5shiv.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/header.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/headUserGover.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/asideUserGover.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script> 
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <!--/meta 作为公共模版分离出去-->
    <style type="text/css">
    .black_overlay{   
            position: absolute;   
            top:0;
            left:0;
            right:0;
            bottom:0;
            z-index:1001;   
        } 
        a:hover{
            text-decoration: none;
        } 
        .check-box, .radio-box{
            padding-left: 0;
        }
        .layui-layer-page .layui-layer-content{
            overflow-x: hidden!important;
        }
        .addHuoDong{ 
				overflow: hidden;
				height: 72px;
				border-bottom: 1px solid #F1F2F7;
			}
			.addHuoDong>span{
				margin: 20px 32px;
				    display: block;
			}
			.addHuoDong>span>a{
				background: #2A9BCF!important;
			}
			.addHuoDong>span>a:hover{
				border-color: #2A9BCF!important;
			}
			.huodong{
				padding: 30px; 
			}
			.huodong input{
				line-height: 26px; 
				border-radius: 5px;
			}
			.huodong>div{
				margin: 12px 0; 
			}
			.huodong .star{ 
				margin-top: 20px;
			}
			.huodong .star button{
				background: #2A9BCF;  
				color: #fff;
				border-radius: 5px;
			}
			.huodong .star button img{
				margin-top: -3px; 
			}
			.huodong .star button.b2{
				background: #fff;
				color: #2A9BCF;
				border-color: #2A9BCF;
			}
			#info h2,#info h3{
				text-align: center;
				padding: 10px!important;
			}
			#info h3{
				border-bottom: 1px solid #ddd;
			}
			#info .box{
				border: 1px solid #ddd;
			}
			#info .box div{
				height: 40px;
				border-bottom: 1px solid #ddd;
			}
			#info .box div.col{
				height: 120px;
			}
			#info .box div.col label.yiyi{
				line-height: 120px;
				height: 120px;
			}
			#info .box div label{
				display: inline-block;
				height: 40px;
				line-height: 40px;
				text-align: center;
				width: 19%;
				border-right: 1px solid #DDDDDD;
				border-left: 1px solid #DDDDDD;
			}
			#info .box div label.left{
				border-left: none;
			}
			#info .box div input[type="text"],#info .box div input[type="number"]{
				width: 30%;
				outline: none;
				/*height: 40px;*/
				/*line-height: 40px;*/
				margin-top: -2px; 
				border: none; 
				border: 1px solid #ddd;height:36px;
				line-height: 36px;
			}
			#submit{
				width: 120px;
				height: 40px;
				line-height: 40px;
				background: #2A9BCF!important;
				color: #FFFFFF;
				border: none;
				border-radius: 5px;
				position: fixed;
				top: 136px;
    			right: 50px;
			}
    </style>
    <script>
		    $(function(){
				$(".fabu-aside>ul>li").eq(4).addClass("xingzhengguanli");
				 $(".headerNav a.infoshangbao").addClass("active");
				 $(".headerNav a.infoshangbao").find("img").attr("src",'<%=request.getContextPath() %>/back/images/infoshangbaoicon.png');
			})
			function clickPlay(type){
		    	if(type==0){
		    	$(".isChange").attr("disabled", true);
		    	}else{
		    	$(".isChange").attr("disabled", false);
		    	}
		    }
			function canpin(type){
		    	if(type==0){
		    	$(".collectionSecurity").attr("disabled", true);
		    	}else{
		    	$(".collectionSecurity").attr("disabled", false);
		    	}
		    }
			function gzhong(type){
		    	if(type==0){
		    	$(".guanzhong1").attr("disabled", true);
		    	}else{
		    	$(".guanzhong1").attr("disabled", false);
		    	}
		    }
		</script>
    <title>活动管理列表</title>
</head>
<body>
	<!--_header 作为公共模版分离出去-->
	<%@ include file="./superNav.jsp"%>

	<!--_menu 左边slide导航开始-->
	<%@ include file="../content/aside.jsp"%>
	<!--/_menu 作为公共模版分离出去-->
<!--<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>-->
<section  class="Hui-article-box">
    <!--<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 内容管理 <span class="c-gray en">&gt;</span> 活动管理 <span class="c-gray en">&gt;</span> 活动列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>-->
    <!--添加活动-->
    
    <div class="Hui-article" style="padding-bottom: 20px;">
        <div  class="huodong">
        </div>
            <div style="clear: both"></div>
            <div style="min-width: 1020px;padding-left: 30px;padding-right:30px;">
            	<form style="position: relative; " action="<%=request.getContextPath()%>/registerInfo/saveRegister.do" id="info">
            		<h2>2017年度博物馆信息登记表</h2>
            		<div class="box">
            			<h3>博物馆基本信息</h3>
            			<div>
            				<label class="left" for="name">
            					博物馆名称
            				</label>
            				<input id="name" name="museumName" type="text" value="${reg.museumName }" />
            				<label for="datemin">
            					设立时间
            				</label>
            				<input id="datemin" class="Wdate" type="text" name="establishTime" value="${reg.establishTime }" onFocus="WdatePicker({lang:'zh-tw'})"/>
            			</div>
            			<div>
            				<label class="left" for="address">
            					地址 
            				</label>
            				<input id="address" name="address" type="text" value="${reg.address }" />
            				<label for="email">
            					邮编
            				</label> 
            				<input id="text" name="zipCode" type="text" value="${reg.zipCode }" />
            			</div>
            			<div>
            				<label class="left" for="phone">
            					电话
            				</label> 
            				<input id="phone" name="tel" type="text" value="${reg.tel }" />
            				<label for="web"> 
            					网站
            				</label>
            				<input id="web" name="websiteUrl" type="text" value="${reg.websiteUrl }" />
            			</div>
            			<div>
            				<label class="left" for="weixin">
            					微信
            				</label>
            				<input id="weixin" name="weixin" type="text" value="${reg.weixin }" />
            				<label for="weibo">
            					微博
            				</label>
            				<input id="weibo" name="weibo" type="text" value="${reg.weibo }" />
            			</div> 
            			<div>
            				<label class="left" for="museumType">
            					博物馆类型
            				</label>
            				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="museumType" type="radio" name="museumType" value="综合地质类" <c:if test='${"综合地质类" eq reg.museumType}'>checked="checked"</c:if>/>综合地质类 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="museumType" type="radio" name="museumType" value="考古遗址类" <c:if test='${"考古遗址类" eq reg.museumType}'>checked="checked"</c:if>/>考古遗址类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="museumType" type="radio" name="museumType" value="历史文化类" <c:if test='${"历史文化类" eq reg.museumType}'>checked="checked"</c:if>/>历史文化类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="museumType" type="radio" name="museumType" value="艺术类" <c:if test='${"艺术类" eq reg.museumType}'>checked="checked"</c:if>/>艺术类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="museumType" type="radio" name="museumType" value="自然科技类" <c:if test='${"自然科技类" eq reg.museumType}'>checked="checked"</c:if>/>自然科技类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="museumType" type="radio" name="museumType" value="其他类" <c:if test='${"其他类" eq reg.museumType}'>checked="checked"</c:if>/>其他类
            			</div>
            			<div>
            				<label class="left" for="museumProperty">
            					博物馆性质 
            				</label>
            				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="museumProperty" type="radio" name="museumProperty" value="国有文物部门所属博物馆" <c:if test='${"国有文物部门所属博物馆" eq reg.museumProperty}'>checked="checked"</c:if>/>国有文物部门所属博物馆 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="museumProperty" type="radio" name="museumProperty" value="国有行业性博物馆" <c:if test='${"国有行业性博物馆" eq reg.museumProperty}'>checked="checked"</c:if>/>国有行业性博物馆&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="museumProperty" type="radio" name="museumProperty" value="非国有博物馆" <c:if test='${"非国有博物馆" eq reg.museumProperty}'>checked="checked"</c:if>/>非国有博物馆&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            			</div>
            			<div> 
            				<label class="left" for="museumGrade"> 
            					博物馆级别 
            				</label>
            				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="museumGrade" type="radio" name="museumLevel" value="一级" <c:if test='${"一级" eq reg.museumLevel}'>checked="checked"</c:if>/>一级 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="museumGrade" type="radio" name="museumLevel" value="二级" <c:if test='${"二级" eq reg.museumLevel}'>checked="checked"</c:if>/>二级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="museumGrade" type="radio" name="museumLevel" value="三级" <c:if test='${"三级" eq reg.museumLevel}'>checked="checked"</c:if>/>三级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="museumGrade" type="radio" name="museumLevel" value="无级别" <c:if test='${"无级别" eq reg.museumLevel}'>checked="checked"</c:if>/>无级别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            			</div>
            			<div>
            				<label class="left" for="administrationRelation">
            					行政隶属关系
            				</label>
            				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="administrationRelation" type="radio" name="museumRelation" value="中央级" <c:if test='${"中央级" eq reg.museumRelation}'>checked="checked"</c:if>/>中央级 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="administrationRelation" type="radio" name="museumRelation" value="省级" <c:if test='${"省级" eq reg.museumRelation}'>checked="checked"</c:if>/>省级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="administrationRelation" type="radio" name="museumRelation" value="地市级" <c:if test='${"地市级" eq reg.museumRelation}'>checked="checked"</c:if>/>地市级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="administrationRelation" type="radio" name="museumRelation" value="县级以下" <c:if test='${"县级以下" eq reg.museumRelation}'>checked="checked"</c:if>/>县级以下&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            			</div>
            			<div>
            				<label class="left" for="MercyRelief">
            					举办者
            				</label>
            				<input id="MercyRelief" name="organizer" type="text" value="${reg.organizer }" />
            				<label for="juridicalPerson">
            					法定代表人
            				</label>
            				<input id="juridicalPerson" name="legalPerson" type="text" value="${reg.legalPerson }" />
            			</div>
            			<div>
            				<label class="left" for="registration">
            					法人登记类型
            				</label>
            				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="registration" type="radio" name="legalPersonRegisterType" value="事业单位法人" <c:if test='${"事业单位法人" eq reg.legalPersonRegisterType}'>checked="checked"</c:if>/>事业单位法人 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="registration" type="radio" name="legalPersonRegisterType" value="民办非企业法人" <c:if test='${"民办非企业法人" eq reg.legalPersonRegisterType}'>checked="checked"</c:if>/>民办非企业法人 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="registration" type="radio" name="legalPersonRegisterType" value="非法人单位" <c:if test='${"非法人单位" eq reg.legalPersonRegisterType}'>checked="checked"</c:if>/>非法人单位 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="registration" type="radio" name="legalPersonRegisterType" value="其他" <c:if test='${"其他" eq reg.legalPersonRegisterType}'>checked="checked"</c:if>/>其他 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<%-- <input id="registration" type="radio" name="legalPersonRegisterType" value="民办非企业法人" <c:if test='${fn:contains(reg.legalPersonRegisterType,民办非企业法人) == true}'>checked="checked"</c:if>/>民办非企业法人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="registration" type="radio" name="legalPersonRegisterType" value="非法人单位" <c:if test='${fn:contains(reg.legalPersonRegisterType,非法人单位) == true}'>checked="checked"</c:if>/>非法人单位&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="registration" type="radio" name="legalPersonRegisterType" value="其他" <c:if test='${fn:contains(reg.legalPersonRegisterType,其他) == true}'>checked="checked"</c:if>/>其他&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --%>
            			</div>
            			<div>
            				<label class="left" for="organ">
            					法人登记机关
            				</label>
            				<input id="organ" name="legalPersonRegisterOrgan" type="text" value="${reg.legalPersonRegisterOrgan }" />
            				<label for="number">
            					法人登记号码
            				</label>
            				<input id="number" name="legalPersonRegisterNumber" type="text" value="${reg.legalPersonRegisterNumber}" />
            			</div>
            			<div>
            				<label class="left" for="Building">
            					馆舍建筑类型
            				</label>
            				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="Building" type="radio" name="libBuildType" value="文物保护单位" <c:if test='${"文物保护单位" eq reg.libBuildType}'>checked="checked"</c:if>/>文物保护单位 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="Building" type="radio" name="libBuildType" value="当代建筑" <c:if test='${"当代建筑" eq reg.libBuildType}'>checked="checked"</c:if>/>当代建筑&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="Building" type="radio" name="libBuildType" value="近现代历史建筑" <c:if test='${"近现代历史建筑" eq reg.libBuildType}'>checked="checked"</c:if>/>近现代历史建筑&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="Building" type="radio" name="libBuildType" value="综合类建筑" <c:if test='${"综合类建筑" eq reg.libBuildType}'>checked="checked"</c:if>/>综合类建筑&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            			</div>
            			<div>
            				<label class="left" for="coveredarea">
            					建筑面积（平方米）
            				</label>
            				<input id="coveredarea" name="museumArea" type="number" value="${reg.museumArea }" />
            				<label for="Exhibitionarea">
            					展厅面积（平方米）
            				</label>
            				<input id="Exhibitionarea" name="exhibitionArea" type="number" value="${reg.exhibitionArea }" />
            			</div>
            			<div>
            				<label class="left" for="Warehousearea">
            					库房面积（平方米）
            				</label>
            				<input id="Warehousearea" name="storeroomArea" type="number" value="${reg.storeroomArea }" />
            				<label for="Laboratory">
            					实验室修复面积（平方米）
            				</label>
            				<input id="Laboratory" name="labArea" type="number" value="${reg.labArea }" />
            			</div>
            			<div>
            				<label class="left" for="worker">
            					在编职工（人）
            				</label>
            				<input id="worker" name="employeeNumber" type="number" value="${reg.employeeNumber }" />
            				<label for="gaojiworker">
            					高级职称人数（人）
            				</label>
            				<input id="gaojiworker" name="seniorNumber" type="number" value="${reg.seniorNumber }" />
            			</div>
            			<div>
            				<label class="left" for="postulant">
            					登记注册志愿者（人）
            				</label>
            				<input id="postulant" name="registerVolunteers" type="number" value="${reg.registerVolunteers }" />
            			</div>
            			<div>
            				<label class="left" for="Maincollection">
            					主要藏品
            				</label>
            				<input id="Maincollection" name="mainCollection" type="text" value="${reg.mainCollection }" />
            				<label for="collectioncount">
            					藏品总量（件/套）
            				</label>
            				<input id="collectioncount" name="collectionTotalCounts" type="number" value="${reg.collectionTotalCounts }" />
            			</div>
            			<div>
            				<label class="left" for="newcollectioncount">
            					新增藏品总数（件/套）
            				</label>
            				<input id="newcollectioncount" name="newAddCollectionCounts" type="number" value="${reg.newAddCollectionCounts }" />
            				<label for="historicalcount">
            					文物数量（件/套）
            				</label>
            				<input id="historicalcount" name="culturalCounts" type="number" value="${reg.culturalCounts }" />
            			</div>
            			<div style="border-bottom: none;">
            				<label class="left" for="0" style="color: #ffffff;">
            					0
            				</label>
            				<span style="display: inline-block;width: 30%;border: 1px solid transparent;"></span>
            				<label for="yijiwenwu">
            					一级文物数量（件/套）
            				</label>
            				<input style="border: 1px solid #ddd;height:36px;" id="yijiwenwu" name="oneLevelCulturalCounts" type="number" value="${reg.oneLevelCulturalCounts }" />
            			</div>
            			<div style="border-bottom: none;">
            				<label class="left" for="zhengui">
            					珍贵文物数量（件/套）
            				</label>
            					<input id="zhengui" style="border: 1px solid #ddd;height:36px;" name="珍贵文物数量" type="number" value="" />
            				<label for="erjiwenwu">
            					二级文物数量（件/套）
            				</label>
            				<input style="border: 1px solid #ddd;height:36px;" id="erjiwenwu" name="twoLevelCulturalCounts" type="number" value="${reg.twoLevelCulturalCounts }" />
            			</div>
            			<div>
            				<label class="left" for="0" style="color: #ffffff;">
            					0
            				</label>
            				<span style="display: inline-block; width: 30%;border: 1px solid transparent;"></span>
            				<label for="sanjiwenwu">
            					三级文物数量（件/套）
            				</label>
            				<input style="border: 1px solid #ddd;height:36px;" id="sanjiwenwu" name="threeLevelCulturalCounts" type="number" value="${reg.threeLevelCulturalCounts }" />
            			</div>
            			<h3>博物馆社会职能发挥情况</h3>
            			<div>
            				<label class="left" for="kaifangdate">
            					全年开放天数（天）
            				</label>
            				<input id="kaifangdate" name="openDays" type="number" value="${reg.openDays }" />
            				<label for="feerkaifang">
            					是否免费开放
            				</label>
            				&nbsp;&nbsp;&nbsp;
            				<input id="feerkaifang" type="radio" name="isFreeOpen" value="1" <c:if test='${"1" eq reg.isFreeOpen}'>checked="checked"</c:if>/>是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="feerkaifang" type="radio" name="isFreeOpen" value="0" <c:if test='${"0" eq reg.isFreeOpen}'>checked="checked"</c:if> />否&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            			</div>
            			<div>
            				<label style="width: 25%;" class="left" for="zongCount">
            					各级免费开放专项资金总额（万元）
            				</label>
            				<input id="zongCount" name="freeOpenMoney" type="number" value="${reg.freeOpenMoney }" />
            			</div>
            			<div style="height:160px;">
            				<label style="height:160px;position: relative;top: -136px;" class="left">
            					<span style="position: relative;top: 57px;">
            						基本陈列内容
            					</span>
            				</label>
            				<textarea style="width: 80%; height: 158px;"  name="baseDisplayContent" >${reg.baseDisplayContent}</textarea>
            			</div>
            			<div>
            				<label class="left" for="chenlie">
            					基本陈列数量（个）
            				</label>
            				<input id="chenlie" name="baseDisplayCounts" type="number" value="${reg.baseDisplayCounts }" />
            				<label for="linzhan">
            					临时展览数量（个）
            				</label>
            				<input id="linzhan" name="tempExhibitionCounts" type="number" value="${reg.tempExhibitionCounts }" />
            			</div>
            			<div>
            				<label class="left" for="cehua">
            					策划教育项目数量（个）
            				</label>
            				<input id="cehua" name="planEduCounts" type="number" value="${reg.planEduCounts }" />
            				<label for="jiaoyu">
            					实施教育活动次数（次）
            				</label>
            				<input id="jiaoyu" name="applyEduCounts" type="number" value="${reg.applyEduCounts }" />
            			</div>
            			<div>
            				<label class="left" for="guanzhong">
            					观众总数（万人）
            				</label>
            				<input id="guanzhong" name="totalAudience" type="number" value="${reg.totalAudience }" />
            				<label for="canguan">
            					免费参观人数（万人）
            				</label>
            				<input id="canguan" name="freeAudienceCounts" type="number" value="${reg.freeAudienceCounts }" />
            			</div>
            			<div>
            				<label class="left" for="weichegnnian">
            					未成年观众数（万人）
            				</label>
            				<input id="weichegnnian" name="juvenileAudienceCounts" type="number" value="${reg.juvenileAudienceCounts }" />
            				<label for="jingwai">
            					境外参观人数（万人）
            				</label>
            				<input id="jingwai" name="overseasAudienceCounts" type="number" value="${reg.overseasAudienceCounts }" />
            			</div>
            			<h3>博物馆重大事项变更情况</h3>
            			<div>
            				<label class="left" for="biangen">
            					有无变更
            				</label>
            				&nbsp;&nbsp;&nbsp;
            				<input id="biangen" type="radio" name="isChange" value="1" <c:if test='${"1" eq reg.isChange}'>checked="checked"</c:if> onclick="clickPlay('1');"/>有&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="biangen" type="radio" name="isChange" value="0" <c:if test='${"0" eq reg.isChange}'>checked="checked"</c:if> onclick="clickPlay('0');"/>无&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            			</div>
            			<div>
            				<label class="left" >
            					名称
            				</label>
            				<label class="left" style="width: 10%;">
            					由
            				</label>
            				<input style="width: 30%;" name="oldMuseumName" type="text" value="${reg.oldMuseumName }" class="isChange"/>
            				<label style="width: 8%;">
            					变更为
            				</label>
            				<input style="width: 30%;" name="newMuseumName" type="text" value="${reg.newMuseumName }" class="isChange"/>
            			</div>
            			<div>
            				<label class="left" >
            					法人代表
            				</label>
            				<label class="left" style="width: 10%;">
            					由
            				</label>
            				<input style="width: 30%;" name="oldLegalPerson" type="text" value="${reg.oldLegalPerson }" class="isChange"/>
            				<label style="width: 8%;">
            					变更为
            				</label>
            				<input style="width: 30%;" name="newLegalPerson" type="text" value="${reg.newLegalPerson }" class="isChange"/>
            			</div>
            			<div>
            				<label class="left" >
            					馆址
            				</label>
            				<label class="left" style="width: 10%;">
            					由
            				</label>
            				<input style="width: 30%;" name="oldAdress" type="text" value="${reg.oldAdress }" class="isChange"/>
            				<label style="width: 8%;">
            					变更为
            				</label>
            				<input style="width: 30%;" name="newAdress" type="text" value="${reg.newAdress }" class="isChange"/>
            			</div>
            			<div>
            				<label class="left" for="zhangcheng">
            					章程有无变更
            				</label>
            				&nbsp;&nbsp;&nbsp;
            				<input id="zhangcheng" type="radio" name="ruleIsChange" value="1" <c:if test='${"1" eq reg.ruleIsChange}'>checked="checked"</c:if>/>有&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            				<input id="zhangcheng" type="radio" name="ruleIsChange" value="0" <c:if test='${"0" eq reg.ruleIsChange}'>checked="checked"</c:if>/>无&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            			</div>
            			<h3>博物馆安全情况</h3>
            			<div style="height:160px;">
            				<label style="height:160px;position: relative;top: -136px;" class="left">
            					<span style="position: relative;top: 57px;">
            						藏品安全情况
            					</span>
            				</label>
            				<label style="height:160px;position: relative;top: -136px;width: 20%;" class="left">
            					<span style="position: relative;top: 57px;">
            					&nbsp;&nbsp;&nbsp;
	            				<input id="zhangcheng" type="radio"  name="collectionSecurity" <c:if test='${"1" eq security}'>checked="checked"</c:if> onclick="canpin('1');"/>有&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            				<input id="zhangcheng" type="radio"  name="collectionSecurity" <c:if test='${"0" eq security}'>checked="checked"</c:if> onclick="canpin('0');"/>无&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</span>            				
            				</label>
            				<textarea placeholder="如有安全情况，请具体说明" style="width: 55%; height: 158px;"  name="collectionSecurity" class="collectionSecurity">${reg.collectionSecurity }</textarea>
            			</div>
            			<div style="height:160px;">
            				<label style="height:160px;position: relative;top: -136px;" class="left">
            					<span style="position: relative;top: 57px;">
            						观众安全情况
            					</span>
            				</label>
            				<label style="height:160px;position: relative;top: -136px;width: 20%;" class="left">
            					<span style="position: relative;top: 57px;">
            					&nbsp;&nbsp;&nbsp;
	            				<input id="zhangcheng" type="radio"  name="audienceSecurity" <c:if test='${"1" eq asecurity}'>checked="checked"</c:if> onclick="gzhong('1');"/>有&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            				<input id="zhangcheng" type="radio"  name="audienceSecurity" <c:if test='${"0" eq asecurity}'>checked="checked"</c:if> onclick="gzhong('0');"/>无&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</span>            				
            				</label>
            				<textarea placeholder="如有安全情况，请具体说明" style="width: 55%; height: 158px;"  name="audienceSecurity" class="guanzhong1">${reg.audienceSecurity }</textarea>
            			</div>
            			<h3>备注（其他需要说明的情况）</h3>
            			<textarea placeholder="如有安全情况，请具体说明" style="width: 98%; height: 158px;"  name="mark" >${reg.mark }</textarea>
            		</div>
            		<c:if test='${null eq reg.id}'>
            		<input id="submit" type="submit" value="提交"/>
            		</c:if>
            		<c:if test='${"1" eq zhezhao}'>
            		<div id="fade" class="black_overlay"></div> 
            		</c:if>
            	</form>
            </div>
     
    </div>
    <div>
    </div>
</section>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script> --%>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>

 
	
</body>
</html>