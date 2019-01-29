
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico">
	<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
  	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"  media="all"/>
  	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" /> 
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
	<style type="text/css">
		.layui-input{
			text-align: center;
			border: 0; 
		}
		#btn{
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
	<%@ include file="../organization/gmheadbtn.jsp"%> 
	
	<section class="Hui-article-box" style="overflow:auto">
	
		<div class="four steps">
		    <span class="step" style="width: 16%">开始申报</span>
		    <span class="step step" style="width: 16%">承诺书</span>
		    <span class="active step" style="width: 16%">信息登记</span>
		    <span class="disabled step" style="width: 16%">附件上传</span>
		    <span class="disabled step" style="width: 16%">总分自评</span>
		    <span class="disabled step" style="width: 16%">已提交</span>
		</div>
		<h4 class="text-c" style="font-size: 23px">${registerInfo.reportName }</h4> 
		<form class="layui-form" method="post" id="form">
			<input type="text" value="${gmReportForm.id }" class="hide" name="id">
			<input type="text" value="${registerInfo.id }" class="hide" name="reportId">
			<div style="text-align: center;font-size: 21px;color: #3bb4f2">------ 基本信息  ------</div><br>
			<table class="table table-border table-bordered radius" style="width: 60%;margin: 0 auto;">
				 
				<tbody >
					<tr>
						<td rowspan="3" class="text-c">博物馆性质</td>
						<td class=" text-c">类别</td>
						<td colspan="6">
							<div class="layui-input-block">
						    	<input type="radio" name="museumProperty" value="1" title="国有文化、文物部门" id="radio-1-1" >
						    	<input type="radio" name="museumProperty" value="2" title="国有行业部门" id="radio-1-2">
						    	<input type="radio" name="museumProperty" value="3" title="非国有" id="radio-1-3">
						    </div>
 						</td>
					</tr>
					<tr>
						<td class=" text-c">隶属层级</td>
						<td colspan="6">
							<div class="layui-input-block">
						    	<input type="radio" name="museumRelation" value="1" title="省" id="radio-2-1">
						    	<input type="radio" name="museumRelation" value="2" title="地（市、州）" id="radio-2-2">
						    	<input type="radio" name="museumRelation" value="3" title="县（区）" id="radio-2-3">
						    	<input type="radio" name="museumRelation" value="4" title="非其他（非国有博物馆选填）" id="radio-2-4">
						    </div>
						</td>
					</tr>
					<tr>
						<td class="tbinfo2 text-c">题材类型</td>
						<td colspan="6">
							<div class="layui-input-block">
						    	<input type="radio" name="museumType" value="1" title="综合地质类" id="radio-3-1">
						    	<input type="radio" name="museumType" value="2" title="考古遗址类" id="radio-3-2">
						    	<input type="radio" name="museumType" value="3" title="历史文化类" id="radio-3-3">
						    	<input type="radio" name="museumType" value="4" title="艺术类" id="radio-3-4">
						    	<input type="radio" name="museumType" value="5" title="自然类" id="radio-3-5">
						    	<input type="radio" name="museumType" value="6" title="科技类" id="radio-3-6">
						    	<input type="radio" name="museumType" value="7" title="其他类" id="radio-3-7">
						    </div>
						</td>
					</tr>
					<tr>
						<td class=" text-c" colspan="2">法人类型</td>
						<td colspan="6">
							<div class="layui-input-block">
						    	<input type="radio" name="legalPersonType" value="1" title="事业单位法人" id="radio-4-1">
						    	<input type="radio" name="legalPersonType" value="2" title="民办非企业法人" id="radio-4-2">
						    	<input type="radio" name="legalPersonType" value="3" title="非法人单位" id="radio-4-3">
						    	<input type="radio" name="legalPersonType" value="4" title="其他" id="radio-4-4">
						    </div>
						</td>
					</tr>
						<tr>
							<td class=" text-c" colspan="2">法人登记机关</td>
							<td colspan="6">
							    <div class="layui-input-block">
							      <input type="text" name="legalPersonOrgan"  autocomplete="off" class="layui-input" value="${gmReportForm.legalPersonOrgan }">
							    </div>
							</td>
						</tr>
						<tr>
							<td colspan="2" class=" text-c">现有等级</td>
							<td colspan="2" class=" ">
								<div class="layui-form-item">
									<div class="layui-input-block">
								    	<input type="radio" name="nowLevel" value="1" title="一级" id="radio-5-1">
								    	<input type="radio" name="nowLevel" value="2" title="二级" id="radio-5-2">
								    	<input type="radio" name="nowLevel" value="3" title="三级" id="radio-5-3">
								    	<input type="radio" name="nowLevel" value="4" title="其他" id="radio-5-4">
								    </div>
								</div>
							</td>
							<td colspan="2" class=" text-c">现有等级评定时间(年月)</td>
							<td colspan="2" class=" text-c">
							      <input type="text" name="nowLevelDate"   class="layui-input" id="date1" value="${gmReportForm.nowLevelDate }">
							</td>
						</tr>
						<tr>
							<td colspan="2" class=" text-c">设立时间(年月日)</td>
							<td colspan="2" class=" text-c">
								<input type="text" class="layui-input" id="date2" name="creatDate" value="${gmReportForm.creatDate }">
							</td>
							<td colspan="2" class=" text-c">正式开放时间(年月)</td>
							<td colspan="2" class=" text-c">
								<input type="text" class="layui-input" id="date3" name="openDate" value="${gmReportForm.openDate }">
							</td>
						</tr>
						<tr>
							<td colspan="2" class=" text-c">互联网址</td>
							<td colspan="2" class=" text-c">
								<input type="text"   name="url"  class="layui-input" value="${gmReportForm.url }">
							</td>
							<td colspan="2" class=" text-c">微信号</td>
							<td colspan="2" class=" text-c">
								<input type="text"   name="weixin" class="layui-input" value="${gmReportForm.weixin }">
							</td>
						</tr>
						<tr>
							<td rowspan="3" class=" text-c">法定代表人</td>
							<td class=" text-c" colspan="2">姓&nbsp;名</td>
							<td class=" text-c" colspan="2">
								<input type="text"   name="legalPersonName" class="layui-input" value="${gmReportForm.legalPersonName }">
							</td>
							<td class=" text-c" colspan="2">性&nbsp;别</td>
							<td class=" text-c">
						    	<input type="radio" name="legalPersonSex" value="0" title="男" id="radio-6-1">
						    	<input type="radio" name="legalPersonSex" value="1" title="女" id="radio-6-2">
							</td>						
						</tr>
						<tr>
							<td class=" text-c" colspan="2">出生年月</td>
							<td class=" text-c" colspan="2">
								<input type="text" class="layui-input" id="date4" name="legalPersonBirth" value="${gmReportForm.legalPersonBirth }">
							</td>
							<td class=" text-c" colspan="2">职&nbsp;称</td>
							<td class=" text-c">
								<input type="text"   name="legalPersonTitle" class="layui-input" value="${gmReportForm.legalPersonTitle }">
							</td>
						</tr>
						<tr>
							<td class=" text-c" colspan="2">学科专长</td>
							<td class=" text-c" colspan="2">
								<input type="text"   name="legalSpeciality" class="layui-input" value="${gmReportForm.legalSpeciality }">
							</td>
							<td class=" text-c" colspan="2">移动电话</td>
							<td class=" text-c">
								<input type="text"  lay-verify="phone"  name="legalTel" class="layui-input" value="${gmReportForm.legalTel }">
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
							<input type="text"   name="coverArea" lay-verify="number" class="layui-input" value="${gmReportForm. coverArea}">
						</td>
						<td class=" text-c" >建筑面积</td>
						<td class=" text-c">
							<input type="text"   name="museumArea" lay-verify="number" class="layui-input" value="${gmReportForm. museumArea}">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >展厅面积</td>
						<td class=" text-c" >
							<input type="text"   name="exhibitionArea" lay-verify="number" class="layui-input" value="${gmReportForm.exhibitionArea }">
						</td>
						<td class=" text-c" >库房面积</td>
						<td class=" text-c">
							<input type="text"   name="storeroomArea" lay-verify="number" class="layui-input" value="${gmReportForm.storeroomArea }">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >实验修复室面积</td>
						<td class=" text-c" >
							<input type="text"   name="labArea" lay-verify="number" class="layui-input" value="${gmReportForm.labArea }">
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
							<input type="text"   name="collectionTotalCount" lay-verify="num" class="layui-input" value="${gmReportForm.collectionTotalCount }">
						</td>
						<td class=" text-c" >三级以上珍贵文物数</td>
						<td class=" text-c">
							<input type="text"   name="threeLevelCulturalCount" lay-verify="num" class="layui-input" value="${gmReportForm.threeLevelCulturalCount }">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >藏品搜集</td>
						<td class=" text-c" >
							<input type="text"   name="addCollectionCount" lay-verify="num" class="layui-input" value="${gmReportForm.addCollectionCount }">
						</td>
						<td class=" text-c" >藏品修复数</td>
						<td class=" text-c">
							<input type="text"   name="repairCollectionCount" lay-verify="num" class="layui-input" value="${gmReportForm.repairCollectionCount }">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >重度腐蚀文物数</td>
						<td class=" text-c" >
							<input type="text"   name="severeCorrosionCount" lay-verify="num" class="layui-input" value="${gmReportForm.severeCorrosionCount }">
						</td>
						<td class=" text-c" colspan="2"></td>
					</tr>
					<tr>
						<td colspan="4">
							库房环境控制是否按藏品不同材质分类控制
							<div class="radio-box">
								<input type="radio" id="radio-7-1" name="environmentControl" value="1" title="是">
							    <input type="radio" id="radio-7-2" name="environmentControl" value="0" title="否">
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							一级品及特殊价值藏品是否单独保存、控制
							<div class="radio-box">
								<input type="radio" id="radio-8-1" name="preciousControl" value="1" title="是">
							    <input type="radio" id="radio-8-2" name="preciousControl" value="0" title="否">
							</div>
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
							<input type="text"   name="employeeCount" lay-verify="num" class="layui-input" value="${gmReportForm.employeeCount }">
						</td>
						<td class=" text-c" >外聘人数</td>
						<td class=" text-c">
							<input type="text"   name="externalCount" lay-verify="num" class="layui-input" value="${gmReportForm.externalCount }">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >初级职称人数</td>
						<td class=" text-c" >
							<input type="text"   name="primaryCount" lay-verify="num" class="layui-input" value="${gmReportForm.primaryCount }">
						</td>
						<td class=" text-c" >中级职称人数</td>
						<td class=" text-c">
							<input type="text"   name="middleCount" lay-verify="num" class="layui-input" value="${gmReportForm.middleCount }">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >高级职称人数</td>
						<td class=" text-c" >
							<input type="text"   name="seniorCount" lay-verify="num" class="layui-input" value="${gmReportForm.seniorCount }">
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
							<input type="text"   name="internationalConferenceCount" lay-verify="num" class="layui-input" value="${gmReportForm.internationalConferenceCount }">
						</td>
						<td class=" text-c" >举办省内学术会议（次）</td>
						<td class=" text-c">
							<input type="text"   name="provinceConferenceCount" lay-verify="num" class="layui-input" value="${gmReportForm.provinceConferenceCount }">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >牵头、参与科学项目数（项）</td>
						<td class=" text-c" >
							<input type="text"   name="scientificProjectsCount" lay-verify="num" class="layui-input" value="${gmReportForm.scientificProjectsCount }">
						</td>
						<td class=" text-c" >出版专著数（部）</td>
						<td class=" text-c">
							<input type="text"   name="publishNumber" lay-verify="num" class="layui-input" value="${gmReportForm.publishNumber }">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >发表论文数（篇）</td>
						<td class=" text-c" >
							<input type="text"   name="dissertationNumber" lay-verify="num" class="layui-input" value="${gmReportForm.dissertationNumber }">
						</td>
						<td class=" text-c" colspan="2"></td>
					</tr>
					<tr>
						<td colspan="4">
							 是否具有学术委员会
							<div class="radio-box">
								<input type="radio" id="radio-9-1" name="exitAcademicCommittee" value="1" title="是">
							    <input type="radio" id="radio-9-2" name="exitAcademicCommittee" value="0" title="否">
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							是否有学术成果获得国家、省级奖励
							<div class="radio-box">
								<input type="radio" id="radio-10-1" name="exitAcademicAwards" value="1" title="是">
							    <input type="radio" id="radio-10-2" name="exitAcademicAwards" value="0" title="否"> 
							</div>
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
							<input type="text"   name="basicDisplayCount" lay-verify="num" class="layui-input" value="${gmReportForm.basicDisplayCount }">
						</td>
						<td class=" text-c" >引进、输出展览数</td>
						<td class=" text-c">
							<input type="text"   name="inoroutExhibitionCount" lay-verify="num" class="layui-input" value="${gmReportForm.inoroutExhibitionCount }">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >临时展览数</td>
						<td class=" text-c" >
							<input type="text"   name="temporaryExhibitionCount" lay-verify="num" class="layui-input" value="${gmReportForm.temporaryExhibitionCount }">
						</td>
						<td class=" text-c" >教育活动数</td>
						<td class=" text-c">
							<input type="text"   name="eduActivitiesCount" lay-verify="num" class="layui-input" value="${gmReportForm.eduActivitiesCount }">
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
							<input type="text"   name="audienceCount" lay-verify="num" class="layui-input" value="${gmReportForm.audienceCount }">
						</td>
						<td class=" text-c" >青少年观众数</td>
						<td class=" text-c">
							<input type="text"   name="youngAudienceCount" lay-verify="num" class="layui-input" value="${gmReportForm.youngAudienceCount }">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >境外观众数</td>
						<td class=" text-c" >
							<input type="text"   name="overseasAudienceCount" lay-verify="num" class="layui-input" value="${gmReportForm.overseasAudienceCount }">
						</td>
						<td class=" text-c" colspan="2"></td>
					</tr>
					<tr>
						<td colspan="4">
							是否开设数字化展览
							<div class="radio-box">
								<input type="radio" id="radio-11-1" name="openDigitalExhibition" value="1" title="是">
							    <input type="radio" id="radio-11-2" name="openDigitalExhibition" value="0" title="否">
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							是否开发文创产品
							<div class="radio-box">
								<input type="radio" id="radio-12-1" name="developCultureProduct" value="1" title="是">
							    <input type="radio" id="radio-12-2" name="developCultureProduct" value="0" title="否">
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							是否展览和教育活动获得国家、省级奖励
							<div class="radio-box">
								<input type="radio" id="radio-13-1" name="exitNationalAward" value="1" title="是">
							    <input type="radio" id="radio-13-2" name="exitNationalAward" value="0" title="否">
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							是否有博物馆之友或志愿活动
							<div class="radio-box">
								<input type="radio" id="radio-14-1" name="exitVolunteering" value="1" title="是">
							    <input type="radio" id="radio-14-2" name="exitVolunteering" value="0" title="否">
							</div>
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
						<td colspan="4">
							是否具有公安部门出具的博物馆风险等级达标证明
							<div class="radio-box">
								<input type="radio" id="radio-15-1" name="exitRiskProof" value="1" title="是">
							    <input type="radio" id="radio-15-2" name="exitRiskProof" value="0" title="否">
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							是否具有消防部门出具的博物馆消防达标证明
							<div class="radio-box">
								<input type="radio" id="radio-16-1" name="exitFireProof" value="1" title="是">
							    <input type="radio" id="radio-16-2" name="exitFireProof" value="0" title="否">
							</div>
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
							<input type="text"   name="financialAppropriation" lay-verify="number" class="layui-input" value="${gmReportForm.financialAppropriation }">
						</td>
						<td class=" text-c" >自筹资金</td>
						<td class=" text-c">
							<input type="text"   name="selfFinancing" lay-verify="number" class="layui-input" value="${gmReportForm.selfFinancing }">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >社会捐赠</td>
						<td class=" text-c" >
							<input type="text"   name="socialDonation" lay-verify="number" class="layui-input" value="${gmReportForm.socialDonation }">
						</td>
						<td class=" text-c" >上级单位拨款（个人投入）</td>
						<td class=" text-c">
							<input type="text"   name="superiorAppropriation" lay-verify="number" class="layui-input" value="${gmReportForm.superiorAppropriation }">
						</td>
					</tr>
					<tr>
						<td rowspan="4" class=" text-c" >支出合计（万元）</td>
						<td class=" text-c" >人&nbsp;员</td>
						<td class=" text-c" >
							<input type="text"   name="personnelPay" lay-verify="number" class="layui-input" value="${gmReportForm.personnelPay }">
						</td>
						<td class=" text-c" >运&nbsp;行</td>
						<td class=" text-c">
							<input type="text"   name="workingPay" lay-verify="number" class="layui-input" value="${gmReportForm.workingPay }">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >展&nbsp;览</td>
						<td class=" text-c" >
							<input type="text"   name="exhibitionPay" lay-verify="number" class="layui-input" value="${gmReportForm.exhibitionPay }">
						</td>
						<td class=" text-c" >活动</td>
						<td class=" text-c">
							<input type="text"   name="activityPay" lay-verify="number" class="layui-input" value="${gmReportForm.activityPay }">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >文物征集</td>
						<td class=" text-c" >
							<input type="text"   name="culturalRelicsCollectPay" lay-verify="number" class="layui-input" value="${gmReportForm.culturalRelicsCollectPay }">
						</td>
						<td class=" text-c" >文物修复</td>
						<td class=" text-c">
							<input type="text"   name="culturalRelicsRepairPay" lay-verify="number" class="layui-input" value="${gmReportForm.culturalRelicsRepairPay }">
						</td>
					</tr>
					<tr>
						<td class=" text-c" >设备购置及设备维护</td>
						<td class=" text-c" >
							<input type="text"   name="equipmentPurchaseRepairPay" lay-verify="number" class="layui-input" value="${gmReportForm.equipmentPurchaseRepairPay }">
						</td>
						<td class=" text-c" >其他</td>
						<td class=" text-c">
							<input type="text"   name="otherPay" class="layui-input" lay-verify="number" value="${gmReportForm.otherPay }">
						</td>
					</tr>
				</tbody>
			</table><br><br>
		  
		    <div id="btn" class="f-r">
				<input class="btn btn-default radius " id="btn-left" type="button" value="上一步" style="width: 80px" onclick="history.go(-1)">
				<input class="btn btn-primary size-M radius " lay-submit="" lay-filter="btn-center" id="btn-center" type="button" value="保存并返回" style="width: 100px">
				<input class="btn btn-primary size-M radius " lay-submit="" lay-filter="btn-right" id="btn-right" type="button" value="下一步" style="width: 80px">
			</div> 
		</form>
	</section> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js" ></script>	
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js" ></script>	 
<script type="text/javascript">
	layui.use(['form', 'layedit', 'laydate'], function(){
		
	    var form = layui.form
	    ,layer = layui.layer
	    ,layedit = layui.layedit
	    ,laydate = layui.laydate;
	  
	    //日期 
	    laydate.render({
	    	
		    elem: '#date1',
		    type: 'month'
	    });
	    laydate.render({
		    elem: '#date2',
	    });
	    laydate.render({
		    elem: '#date3',
		    type: 'month'
	    });
	    laydate.render({
		    elem: '#date4',
		    type: 'month'
	    });
	  
	    //创建一个编辑器
	    var editIndex = layedit.build('LAY_demo_editor');
	 
	    //自定义验证规则
	    form.verify({
	      title: function(value){
	        if(value.length < 5){
	          return '标题至少得5个字符啊';
	        }
	      }
	    ,phone: [/^(?:1(?:3|5|8)\d{9})?$/, '请输入正确的手机号']
	    ,number:[/^$|^\d{1,8}(\.\d{1,2})?$/,'请输入1-8位的数字，小数点后最多2位']                    
	    ,num:[/^(\d{1,8})?$/,'请输入1-8位的整数']     
	    });       
	       
	         
	    //监听提交
	    form.on('submit(btn-center)', function(data){
		    var data = $("#form").serialize();
			console.log(data);
			$.ajax({
				type:"post",
				url:"/admin/gmReportForm/save.do",
				data:data,
				success:function(data) {
					
					if (data == "ok") {
						window.location.href="/admin/registerInfo/getInfoList.do"
					}
				}
			})
	    });
	    form.on('submit(btn-right)', function(data){
		  var data = $("#form").serialize();
			console.log(data);
			$.ajax({
				type:"post",
				url:"/admin/gmReportForm/save.do",
				data:data,
				success:function(data) {
					if (data == "ok") {
						window.location.href="/admin/gmReportUpload/form.do?reportId=${registerInfo.id}"
					}
				}
					
			})
	    });
	});
	$(document).ready(function(){
		
		
		
		$("input[name='museumProperty']").each(function() {
			if ($(this).val() == ${gmReportForm.museumProperty}) {
				$(this).next().click(); 
			}  
		}) 
		$("input[name='museumRelation']").each(function() {
			if ($(this).val() == ${gmReportForm.museumRelation}) {
				$(this).next().click(); 
			} 
		})
		$("input[name='museumType']").each(function() {
			if ($(this).val() == ${gmReportForm.museumType}) {
				$(this).next().click(); 
			}
		})
		$("input[name='legalPersonType']").each(function() {
			if ($(this).val() == ${gmReportForm.legalPersonType}) {
				$(this).next().click(); 
			}
		})
		$("input[name='nowLevel']").each(function() {
			if ($(this).val() == ${gmReportForm.nowLevel}) {
				$(this).next().click(); 
			}
		})
		$("input[name='legalPersonSex']").each(function() {
			if ($(this).val() == ${gmReportForm.legalPersonSex}) {
				$(this).next().click(); 
			}
		})
		$("input[name='environmentControl']").each(function() {
			if ($(this).val() == ${gmReportForm.environmentControl}) {
				$(this).next().click(); 
			}
		})
		$("input[name='preciousControl']").each(function() {
			if ($(this).val() == ${gmReportForm.preciousControl}) {
				$(this).next().click(); 
			}
		})
		$("input[name='exitAcademicCommittee']").each(function() {
			if ($(this).val() == ${gmReportForm.exitAcademicCommittee}) {
				$(this).next().click(); 
			}
		})
		$("input[name='exitAcademicAwards']").each(function() {
			if ($(this).val() == ${gmReportForm.exitAcademicAwards}) {
				$(this).next().click(); 
			}
		})
		$("input[name='openDigitalExhibition']").each(function() {
			if ($(this).val() == ${gmReportForm.openDigitalExhibition}) {
				$(this).next().click(); 
			}
		})
		$("input[name='developCultureProduct']").each(function() {
			if ($(this).val() == ${gmReportForm.developCultureProduct}) {
				$(this).next().click(); 
			}
		})
		$("input[name='exitNationalAward']").each(function() {
			if ($(this).val() == ${gmReportForm.exitNationalAward}) {
				$(this).next().click(); 
			}
		})
		$("input[name='exitVolunteering']").each(function() {
			if ($(this).val() == ${gmReportForm.exitVolunteering}) {
				$(this).next().click(); 
			}
		})
		$("input[name='exitRiskProof']").each(function() {
			if ($(this).val() == ${gmReportForm.exitRiskProof}) {
				$(this).next().click(); 
			}
		})
		$("input[name='exitFireProof']").each(function() {
			if ($(this).val() == ${gmReportForm.exitFireProof}) {
				$(this).next().click();  
			}
		})
		
		$(".headerNav a.report").addClass("active");   
		$(".fabu-aside>ul>li").eq(4).addClass("weihu");  
	})
	
</script> 

</body>
</html>