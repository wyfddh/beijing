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
<style type="text/css">
	.dbox{
		width: 70%;
		margin: 0 auto;
	}
	.inputInfo{
		height:100%;
		width:100%;
		border: 0;
		text-align: center;
	}
	#btnReturn{
			position:fixed;
			margin:0 0 0 0;
			right:80px;
			bottom:40px;
			z-index:999;
		}
		.Hui-article-box{
		position: absolute;
		left:0
	}
	
</style>


<title>申报记录</title>
</head>
<body>
	<header id="head"></header>
	<%@ include file="../organization/gmheadbtn.jsp"%> 
	
	<section class="Hui-article-box" style="overflow:auto">
	
		
		

		<h4 class="text-c" style="font-size: 23px">${report.reportName }</h4>
		
		<div class="dbox" >
			<div class="hui-title">
		       	一： 表单信息
		    </div>
			<div style="text-align: center;font-size: 21px;color: #3bb4f2">------ 基本信息  ------</div><br>
			<div >
				<table class="table table-border table-bordered radius" style="width: 60%;margin: 0 auto;">
					<col style="width:10%" />
					<col style="width:15%" />
					<col style="width:7.5%" />
					<col style="width:17.5%" />
					<col style="width:5%" />
					<col style="width:20%" />
					<col style="width:2.5%" />
					<col style="width:22.5%" />
					<thead>
					</thead>
					<tbody >
						<tr>
							<td rowspan="3" class="text-c">博物馆性质</td>
							<td class=" text-c">类别</td>
							<td colspan="6">
								<input type="text" name="museumProperty" class="inputInfo" value="${gmReportForm.museumProperty }" readonly="readonly" id="radio-1">
							</td>
						</tr>
						<tr>
							<td class=" text-c">隶属层级</td>
							<td colspan="6">
								<input type="text" name="museumRelation" class="inputInfo" value="${gmReportForm.museumRelation }" readonly="readonly" id="radio-2">
								
							</td>
						</tr>
						<tr>
							<td class="tbinfo2 text-c">题材类型</td>
							<td colspan="6">
								<input type="text" name="museumType" class="inputInfo" value="${gmReportForm.museumType }" readonly="readonly" id="radio-3">
							</td>
						</tr>
						<tr>
							<td class=" text-c" colspan="2">法人类型</td>
							<td colspan="6">
								<input type="text" name="legalPersonType" class="inputInfo" value="${gmReportForm.legalPersonType }" readonly="readonly" id="radio-4">
							</td>
						</tr>
						<tr>
							<td class=" text-c" colspan="2">法人登记机关</td>
							<td colspan="6">
								<input type="text"   name="legalPersonOrgan" class="inputInfo" value="${gmReportForm.legalPersonOrgan }" readonly="readonly">
							</td>
						</tr>
						<tr>
							<td colspan="2" class=" text-c">现有等级</td>
							<td colspan="2" class=" ">
								<input type="text" name="nowLevel" class="inputInfo" value="${gmReportForm.nowLevel }" readonly="readonly" id="radio-5">
							</td>
							<td colspan="2" class=" text-c">现有等级评定时间(年月)</td>
							<td colspan="2" class=" text-c">
								<input type="text" class="layui-input inputInfo" id="date1" name="nowLevelDate" value="${gmReportForm.nowLevelDate }" readonly="readonly">
							</td>
						</tr>
						<tr>
							<td colspan="2" class=" text-c">设立时间(年月日)</td>
							<td colspan="2" class=" text-c">
								<input type="text" class="layui-input inputInfo" id="date2" name="creatDate" value="${gmReportForm.creatDate }" readonly="readonly">
							</td>
							<td colspan="2" class=" text-c">正式开放时间(年月)</td>
							<td colspan="2" class=" text-c">
								<input type="text" class="layui-input inputInfo" id="date3" name="openDate" value="${gmReportForm.openDate }" readonly="readonly">
							</td>
						</tr>
						<tr>
							<td colspan="2" class=" text-c">互联网址</td>
							<td colspan="2" class=" text-c">
								<input type="text"   name="url" class="inputInfo" value="${gmReportForm.url }" readonly="readonly">
							</td>
							<td colspan="2" class=" text-c">微信号</td>
							<td colspan="2" class=" text-c">
								<input type="text"   name="weixin" class="inputInfo" value="${gmReportForm.weixin }" readonly="readonly">
							</td>
						</tr>
						<tr>
							<td rowspan="3" class=" text-c">法定代表人</td>
							<td class=" text-c" colspan="2">姓&nbsp;名</td>
							<td class=" text-c" colspan="2">
								<input type="text"   name="legalPersonName" class="inputInfo" value="${gmReportForm.legalPersonName }" readonly="readonly">
							</td>
							<td class=" text-c" colspan="2">性&nbsp;别</td>
							<td class=" text-c">
								<input type="text" name="legalPersonSex" class="inputInfo" value="${gmReportForm.legalPersonSex }" readonly="readonly" id="radio-6">
							</td>						
						</tr>
						<tr>
							<td class=" text-c" colspan="2">出生年月</td>
							<td class=" text-c" colspan="2">
								<input type="text" class="layui-input inputInfo" id="date4" name="legalPersonBirth" value="${gmReportForm.legalPersonBirth }" readonly="readonly">
							</td>
							<td class=" text-c" colspan="2">职&nbsp;称</td>
							<td class=" text-c">
								<input type="text"   name="legalPersonTitle" class="inputInfo" value="${gmReportForm.legalPersonTitle }" readonly="readonly">
							</td>
						</tr>
						<tr>
							<td class=" text-c" colspan="2">学科专长</td>
							<td class=" text-c" colspan="2">
								<input type="text"   name="legalSpeciality" class="inputInfo" value="${gmReportForm.legalSpeciality }" readonly="readonly">
							</td>
							<td class=" text-c" colspan="2">移动电话</td>
							<td class=" text-c">
								<input type="text"   name="legalTel" class="inputInfo" value="${gmReportForm.legalTel }" readonly="readonly">
							</td>
						</tr>
					</tbody>
				</table>
			<br><div style="text-align: center;font-size: 21px;color: #3bb4f2">------ 博物馆面积（平方米） ------</div><br>
			
			<table class="table table-border table-bordered radius" style="width: 60%;margin: 0 auto;">
				<col style="width:25%" />
				<col style="width:25%" />
				<col style="width:25%" />
				<col style="width:25%" />
				<thead>
				</thead>
				<tbody>
					<tr>
						<td class=" text-c" >占地面积</td>
						<td class=" text-c" >
							<input type="text"   name="coverArea" class="inputInfo" value="${gmReportForm. coverArea}" readonly="readonly">
						</td>
						<td class=" text-c" >建筑面积</td>
						<td class=" text-c">
							<input type="text"   name="museumArea" class="inputInfo" value="${gmReportForm. museumArea}" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >展厅面积</td>
						<td class=" text-c" >
							<input type="text"   name="exhibitionArea" class="inputInfo" value="${gmReportForm.exhibitionArea }" readonly="readonly">
						</td>
						<td class=" text-c" >库房面积</td>
						<td class=" text-c">
							<input type="text"   name="storeroomArea" class="inputInfo" value="${gmReportForm.storeroomArea }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >实验修复室面积</td>
						<td class=" text-c" >
							<input type="text"   name="labArea" class="inputInfo" value="${gmReportForm.labArea }" readonly="readonly">
						</td>
						<td class=" text-c" colspan="2"></td>
					</tr>
				</tbody>
			</table>
			
			<br><div style="text-align: center;font-size: 21px;color: #3bb4f2">------ 藏品及文物（件/套） ------</div><br>
			<table class="table table-border table-bordered radius" style="width: 60%;margin: 0 auto;">
				<col style="width:25%" />
				<col style="width:25%" />
				<col style="width:25%" />
				<col style="width:25%" />
				<thead>
				</thead>
				<tbody>
					<tr>
						<td class=" text-c" >藏品总数</td>
						<td class=" text-c" >
							<input type="text"   name="collectionTotalCount" class="inputInfo" value="${gmReportForm.collectionTotalCount }" readonly="readonly">
						</td>
						<td class=" text-c" >三级以上珍贵文物数</td>
						<td class=" text-c">
							<input type="text"   name="threeLevelCulturalCount" class="inputInfo" value="${gmReportForm.threeLevelCulturalCount }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >藏品搜集</td>
						<td class=" text-c" >
							<input type="text"   name="addCollectionCount" class="inputInfo" value="${gmReportForm.addCollectionCount }" readonly="readonly">
						</td>
						<td class=" text-c" >藏品修复数</td>
						<td class=" text-c">
							<input type="text"   name="repairCollectionCount" class="inputInfo" value="${gmReportForm.repairCollectionCount }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >重度腐蚀文物数</td>
						<td class=" text-c" >
							<input type="text"   name="severeCorrosionCount" class="inputInfo" value="${gmReportForm.severeCorrosionCount }" readonly="readonly">
						</td>
						<td class=" text-c" colspan="2"></td>
					</tr>
					<tr>
						<td class=" text-c">库房环境控制是否按藏品不同材质分类控制:</td>
						<td colspan="3">
							<input type="text" name="environmentControl" class="inputInfo" value="${gmReportForm.environmentControl }" readonly="readonly" id="radio-7">
						</td>
					</tr>
					<tr>
						<td class=" text-c">一级品及特殊价值藏品是否单独保存、控制:</td>
						<td colspan="3">
							<input type="text" name="preciousControl" class="inputInfo" value="${gmReportForm.preciousControl }" readonly="readonly" id="radio-8">
						</td>
					</tr>
				</tbody>
			</table>
			<br><div style="text-align: center;font-size: 21px;color: #3bb4f2">------ 从业人员（人） ------</div><br>
			<table class="table table-border table-bordered radius" style="width: 60%;margin: 0 auto;">
				<col style="width:25%" />
				<col style="width:25%" />
				<col style="width:25%" />
				<col style="width:25%" />
				<thead>
				</thead>
				<tbody>
					<tr>
						<td class=" text-c" >在编总人数</td>
						<td class=" text-c" >
							<input type="text"   name="employeeCount" class="inputInfo" value="${gmReportForm.employeeCount }" readonly="readonly">
						</td>
						<td class=" text-c" >外聘人数</td>
						<td class=" text-c">
							<input type="text"   name="externalCount" class="inputInfo" value="${gmReportForm.externalCount }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >初级职称人数</td>
						<td class=" text-c" >
							<input type="text"   name="primaryCount" class="inputInfo" value="${gmReportForm.primaryCount }" readonly="readonly">
						</td>
						<td class=" text-c" >中级职称人数</td>
						<td class=" text-c">
							<input type="text"   name="middleCount" class="inputInfo" value="${gmReportForm.middleCount }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >高级职称人数</td>
						<td class=" text-c" >
							<input type="text"   name="seniorCount" class="inputInfo" value="${gmReportForm.seniorCount }" readonly="readonly">
						</td>
						<td class=" text-c" colspan="2"></td>
					</tr>
				</tbody>
			</table>
			<br><div style="text-align: center;font-size: 21px;color: #3bb4f2">------ 学术科研（上一年度） ------</div><br>
			<table class="table table-border table-bordered radius" style="width: 60%;margin: 0 auto;">
				<col style="width:25%" />
				<col style="width:25%" />
				<col style="width:25%" />
				<col style="width:25%" />
				<thead>
				</thead>
				<tbody>
					<tr>
						<td class=" text-c" >举办国际、国内学术会议（次）</td>
						<td class=" text-c" >
							<input type="text"   name="internationalConferenceCount" class="inputInfo" value="${gmReportForm.internationalConferenceCount }" readonly="readonly">
						</td>
						<td class=" text-c" >举办省内学术会议（次）</td>
						<td class=" text-c">
							<input type="text"   name="provinceConferenceCount" class="inputInfo" value="${gmReportForm.provinceConferenceCount }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >牵头、参与科学项目数（项）</td>
						<td class=" text-c" >
							<input type="text"   name="scientificProjectsCount" class="inputInfo" value="${gmReportForm.scientificProjectsCount }" readonly="readonly">
						</td>
						<td class=" text-c" >出版专著数（部）</td>
						<td class=" text-c">
							<input type="text"   name="publishNumber" class="inputInfo" value="${gmReportForm.publishNumber }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >发表论文数（篇）</td>
						<td class=" text-c" >
							<input type="text"   name="dissertationNumber" class="inputInfo" value="${gmReportForm.dissertationNumber }" readonly="readonly">
						</td>
						<td class=" text-c" colspan="2"></td>
					</tr>
					<tr>
						<td class=" text-c" >是否具有学术委员会</td>
						<td colspan="3">
							<input type="text" name="exitAcademicCommittee" class="inputInfo" value="${gmReportForm.exitAcademicCommittee }" readonly="readonly" id="radio-9">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >是否有学术成果获得国家、省级奖励</td>
						<td colspan="3">
							<input type="text" name="exitAcademicAwards" class="inputInfo" value="${gmReportForm.exitAcademicAwards }" readonly="readonly" id="radio-10">
						</td>
					</tr>
				</tbody>
			</table>
			<br><div style="text-align: center;font-size: 21px;color: #3bb4f2">------ 开放服务（上一年度/个） ------</div><br>
			<table class="table table-border table-bordered radius" style="width: 60%;margin: 0 auto;">
				<col style="width:25%" />
				<col style="width:25%" />
				<col style="width:25%" />
				<col style="width:25%" />
				<thead>
				</thead>
				<tbody>
					<tr>
						<td class=" text-c" >基本陈列数</td>
						<td class=" text-c" >
							<input type="text"   name="basicDisplayCount" class="inputInfo" value="${gmReportForm.basicDisplayCount }" readonly="readonly">
						</td>
						<td class=" text-c" >引进、输出展览数</td>
						<td class=" text-c">
							<input type="text"   name="inoroutExhibitionCount" class="inputInfo" value="${gmReportForm.inoroutExhibitionCount }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >临时展览数</td>
						<td class=" text-c" >
							<input type="text"   name="temporaryExhibitionCount" class="inputInfo" value="${gmReportForm.temporaryExhibitionCount }" readonly="readonly">
						</td>
						<td class=" text-c" >教育活动数</td>
						<td class=" text-c">
							<input type="text"   name="eduActivitiesCount" class="inputInfo" value="${gmReportForm.eduActivitiesCount }" readonly="readonly">
						</td>
					</tr>
				</tbody>
			</table>
			<br><div style="text-align: center;font-size: 21px;color: #3bb4f2">------ 观众服务（万人次） ------</div><br>
			<table class="table table-border table-bordered radius" style="width: 60%;margin: 0 auto;">
				<col style="width:25%" />
				<col style="width:25%" />
				<col style="width:25%" />
				<col style="width:25%" />
				<thead>
				</thead>
				<tbody>
					<tr>
						<td class=" text-c" >观众数</td>
						<td class=" text-c" >
							<input type="text"   name="audienceCount" class="inputInfo" value="${gmReportForm.audienceCount }" readonly="readonly">
						</td>
						<td class=" text-c" >青少年观众数</td>
						<td class=" text-c">
							<input type="text"   name="youngAudienceCount" class="inputInfo" value="${gmReportForm.youngAudienceCount }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >境外观众数</td>
						<td class=" text-c" >
							<input type="text"   name="overseasAudienceCount" class="inputInfo" value="${gmReportForm.overseasAudienceCount }" readonly="readonly">
						</td>
						<td class=" text-c" colspan="2"></td>
					</tr>
					<tr>
						<td class=" text-c" >是否开设数字化展览</td>
						<td colspan="3">
							<input type="text" name="openDigitalExhibition" class="inputInfo" value="${gmReportForm.openDigitalExhibition }" readonly="readonly" id="radio-11">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >是否开发文创产品</td>
						<td colspan="3">
							<input type="text" name="developCultureProduct" class="inputInfo" value="${gmReportForm.developCultureProduct }" readonly="readonly" id="radio-12">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >是否展览和教育活动获得国家、省级奖励</td>
						<td colspan="3">
							<input type="text" name="exitNationalAward" class="inputInfo" value="${gmReportForm.exitNationalAward }" readonly="readonly" id="radio-13">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >是否有博物馆之友或志愿活动</td>
						<td colspan="3">
							<input type="text" name="exitVolunteering" class="inputInfo" value="${gmReportForm.exitVolunteering }" readonly="readonly" id="radio-14">
						</td>
						
					</tr>
				</tbody>
			</table>
			
			<br><div style="text-align: center;font-size: 21px;color: #3bb4f2">------ 安全管理  ------</div><br>
			<table class="table table-border table-bordered radius" style="width: 60%;margin: 0 auto;">
				<thead>
				</thead>
				<tbody>
					<tr>
						<td class=" text-c" >是否具有公安部门出具的博物馆风险等级达标证明</td>
						<td colspan="3">
							<input type="text" name="exitRiskProof" class="inputInfo" value="${gmReportForm.exitRiskProof }" readonly="readonly" id="radio-15">
						</td>
						
					</tr>
					<tr>
						<td class=" text-c" >是否具有消防部门出具的博物馆消防达标证明</td>
						<td colspan="3">
							<input type="text" name="exitFireProof" class="inputInfo" value="${gmReportForm.exitFireProof }" readonly="readonly" id="radio-16">
						</td>
						
					</tr>
				</tbody>
			</table>
			
			<br><div style="text-align: center;font-size: 21px;color: #3bb4f2">------ 上一年度财务收支------</div><br>
			<table class="table table-border table-bordered radius" style="width: 60%;margin: 0 auto;">
				<col style="width:10%" />
				<col style="width:22.5%" />
				<col style="width:22.5%" />
				<col style="width:22.5%" />
				<col style="width:22.5%" />
				<thead>
				</thead>
				<tbody>
					<tr>
						<td rowspan="2" class=" text-c" >收入合计（万元）</td>
						<td class=" text-c" >财政拨款</td>
						<td class=" text-c" >
							<input type="text"   name="financialAppropriation" class="inputInfo" value="${gmReportForm.financialAppropriation }" readonly="readonly">
						</td>
						<td class=" text-c" >自筹资金</td>
						<td class=" text-c">
							<input type="text"   name="selfFinancing" class="inputInfo" value="${gmReportForm.selfFinancing }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >社会捐赠</td>
						<td class=" text-c" >
							<input type="text"   name="socialDonation" class="inputInfo" value="${gmReportForm.socialDonation }" readonly="readonly"> 
						</td>
						<td class=" text-c" >上级单位拨款（个人投入）</td>
						<td class=" text-c">
							<input type="text"   name="superiorAppropriation" class="inputInfo" value="${gmReportForm.superiorAppropriation }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td rowspan="4" class=" text-c" >支出合计（万元）</td>
						<td class=" text-c" >人&nbsp;员</td>
						<td class=" text-c" >
							<input type="text"   name="personnelPay" class="inputInfo" value="${gmReportForm.personnelPay }" readonly="readonly">
						</td>
						<td class=" text-c" >运&nbsp;行</td>
						<td class=" text-c">
							<input type="text"   name="workingPay" class="inputInfo" value="${gmReportForm.workingPay }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >展&nbsp;览</td>
						<td class=" text-c" >
							<input type="text"   name="exhibitionPay" class="inputInfo" value="${gmReportForm.exhibitionPay }" readonly="readonly">
						</td>
						<td class=" text-c" >活动</td>
						<td class=" text-c">
							<input type="text"   name="activityPay" class="inputInfo" value="${gmReportForm.activityPay }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >文物征集</td>
						<td class=" text-c" >
							<input type="text"   name="culturalRelicsCollectPay" class="inputInfo" value="${gmReportForm.culturalRelicsCollectPay }" readonly="readonly">
						</td>
						<td class=" text-c" >文物修复</td>
						<td class=" text-c">
							<input type="text"   name="culturalRelicsRepairPay" class="inputInfo" value="${gmReportForm.culturalRelicsRepairPay }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >设备购置及设备维护</td>
						<td class=" text-c" >
							<input type="text"   name="equipmentPurchaseRepairPay" class="inputInfo" value="${gmReportForm.equipmentPurchaseRepairPay }" readonly="readonly">
						</td>
						<td class=" text-c" >其他</td>
						<td class=" text-c">
							<input type="text"   name="otherPay" class="inputInfo" value="${gmReportForm.otherPay }" readonly="readonly">
						</td>
					</tr>
				</tbody>
			</table><br><br>
			</div>
		
		
		</div><br><br>
		<div class="dbox" >
			<div class="hui-title">
		       	二： 附件清单
		    </div>
		    <div>
				<table class="table table-border table-bordered table-striped" style="width: 60%;margin: 0 auto;" >
					<col style="width:12%">
					<col style="width:76%">
					<col style="width:12%">
					<tbody >
						<c:forEach items="${reportUploads}" var="reportUpload" varStatus="status">
							<tr>
								<td class="text-c">${status.count }</td>
								<td>${reportUpload.realName }</td>
								<td>
									<form id="form${status.count }" action="/admin/registerInfo/auditDown.do" method="post">
										<input type="text" name="filename" value="${reportUpload.realName }" class="hide">
										<input type="text" name="reportId" value="${report.id }" class="hide">
										<a href="javascript:;" id="down${status.count }" onclick="downClick(this.id)" >下载</a>
										<span class="hide" id="span${status.count }">未上传</span>
									</form>
									<%-- <a href="javascript:;" name="${reportUpload.realName }" onclick="downClick(this.name)">下载</a> --%>
									
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div><br><br>
		<div class="dbox" >
			<div class="hui-title">
		       	三：自评得分
		    </div><br><br><br>
		    <div style="position:relative;left: 10%"> 
		    	<span>自评分总分：</span> 
		    	<input type="text" value="${report.selfScore }" readonly="readonly">分
		    </div><br><br><br>
		    
		</div>
		<div class="dbox" class="hide" id="reviewResult">
		
		         四：审核意见
		   <br><br><br>
		    <div style="position:relative;left: 10%" id="cityReviewResult" > 
		    	<span style="display:block;position:absolute;margin:0 0 0 0">区文委审核意见：</span>    
		    	<textarea style="margin-left:86px" rows="8" cols="80"  readonly="readonly">${gmAudit.cityReviewResult }</textarea>
		    </div><br><br><br>
		    <%-- <div style="position:relative;left: 10%" id="provinceReviewResult" > 
		    	<span style="display:block;position:absolute;margin:0 0 0 0">省审核意见：</span> 
		    	<textarea style="margin-left:86px" rows="8" cols="80" readonly="readonly" >${gmAudit.provinceReviewResult }</textarea>
		    </div><br><br><br> --%>
		   
		</div>
		<div id="btnReturn" >
			<input class="btn btn-default radius " id="btn-left" type="button" value="返回" style="width: 80px;" onclick="history.go(-1)">
			
	    </div>
		
	</section>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>	
	
	<script type="text/javascript">
	
		
		if ($("#radio-1").val() == 1) {
			$("#radio-1").val("国有文化、文物部门");
		} else if ($("#radio-1").val() == 2) {
			$("#radio-1").val("国有行业部门");
		} else if ($("#radio-1").val() == 3) {
			$("#radio-1").val("非国有");
		};
		if ($("#radio-2").val() == 1) {
			$("#radio-2").val("省");
		} else if ($("#radio-2").val() == 2) {
			$("#radio-2").val("地（市、州）");
		} else if ($("#radio-2").val() == 3) {
			$("#radio-2").val("县（区）");
		} else if ($("#radio-2").val() == 4) {
			$("#radio-2").val("其他（非国有博物馆选填）");
		};
		if ($("#radio-3").val() == 1) {
			$("#radio-3").val("综合地质类");
		} else if ($("#radio-3").val() == 2) {
			$("#radio-3").val("考古遗址类");
		} else if ($("#radio-3").val() == 3) {
			$("#radio-3").val("历史文化类");
		} else if ($("#radio-3").val() == 4) {
			$("#radio-3").val("艺术类");
		} else if ($("#radio-3").val() == 5) {
			$("#radio-3").val("自然类");
		} else if ($("#radio-3").val() == 6) {
			$("#radio-3").val("科技类");
		} else if ($("#radio-3").val() == 7) {
			$("#radio-3").val("其他类");
		};
		if ($("#radio-4").val() == 1) {
			$("#radio-4").val("事业单位法人");
		} else if ($("#radio-4").val() == 2) {
			$("#radio-4").val("民办非企业法人");
		} else if ($("#radio-4").val() == 3) {
			$("#radio-4").val("非法人单位");
		} else if ($("#radio-4").val() == 4) {
			$("#radio-4").val("其他");
		};
		if ($("#radio-5").val() == 1) {
			$("#radio-5").val("一级");
		} else if ($("#radio-5").val() == 2) {
			$("#radio-5").val("二级");
		} else if ($("#radio-5").val() == 3) {
			$("#radio-5").val("三级");
		};
		if ($("#radio-6").val() == 0) {
			$("#radio-6").val("男");
		} else if ($("#radio-6").val() == 1) {
			$("#radio-6").val("女");
		};
		if ($("#radio-7").val() == 0) {
			$("#radio-7").val("否");
		} else if ($("#radio-7").val() == 1) {
			$("#radio-7").val("是");
		};
		if ($("#radio-8").val() == 0) {
			$("#radio-8").val("否");
		} else if ($("#radio-8").val() == 1) {
			$("#radio-8").val("是");
		};
		if ($("#radio-9").val() == 0) {
			$("#radio-9").val("否");
		} else if ($("#radio-9").val() == 1) {
			$("#radio-9").val("是");
		};
		if ($("#radio-10").val() == 0) {
			$("#radio-10").val("否");
		} else if ($("#radio-10").val() == 1) {
			$("#radio-10").val("是");
		};
		if ($("#radio-11").val() == 0) {
			$("#radio-11").val("否");
		} else if ($("#radio-11").val() == 1) {
			$("#radio-11").val("是");
		};
		if ($("#radio-12").val() == 0) {
			$("#radio-12").val("否");
		} else if ($("#radio-12").val() == 1) {
			$("#radio-12").val("是");
		};
		if ($("#radio-13").val() == 0) {
			$("#radio-13").val("否");
		} else if ($("#radio-13").val() == 1) {
			$("#radio-13").val("是");
		};
		if ($("#radio-14").val() == 0) {
			$("#radio-14").val("否");
		} else if ($("#radio-14").val() == 1) {
			$("#radio-14").val("是");
		};
		if ($("#radio-15").val() == 0) {
			$("#radio-15").val("否");
		} else if ($("#radio-15").val() == 1) {
			$("#radio-15").val("是");
		};
		if ($("#radio-16").val() == 0) {
			$("#radio-16").val("否");
		} else if ($("#radio-16").val() == 1) {
			$("#radio-16").val("是");
		};
		
		
		
		function downClick(id) {
			var str = id.substring(4);
			$('#form' + str).submit();

		};
		$(document).ready(function(){
			var jsonString = ${jsonString};
			for(var i = 1;i <= jsonString.length;i++) {
				var li = jsonString[i-1];
				if (li.uoloadStatus == 0) {
					$('#span' + i).show();
					$('#down' + i).hide();
				}
			}
			
			
			$("#btn-right").click(function() {
				$("#form").submit();
			})
			
			$(".headerNav a.reportAudit").addClass("active");
			var orgTypeId = ${orgTypeId};
			if (orgTypeId == 2) { 
				$(".fabu-aside>ul>li").eq(3).addClass("weihu");
			} else {
				$(".fabu-aside>ul>li").eq(4).addClass("weihu");
			}
		})
	</script>
		
	</script>
</body>
</html>
