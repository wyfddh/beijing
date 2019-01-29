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
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"  media="all"/>
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
	.modal{
		top:200px;
	}
	.modal-body{
		height:400px;
	}
	.del{
		border: 0;
	}
	.file {  
	    position: relative;  
	    display: inline-block;  
	    background: #D0EEFF;  
	    border: 1px solid #99D3F5;  
	    border-radius: 4px;  
	    padding: 4px 12px;  
	    overflow: hidden;  
	    color: #1E88C7;  
	    text-decoration: none;  
	    text-indent: 0;  
	    line-height: 20px;  
	}  
	.file input {  
	    position: absolute;  
	    font-size: 100px;  
	    right: 0;  
	    top: 0;  
	    opacity: 0;  
	}  
	.file:hover {  
	    background: #AADFFD;  
	    border-color: #78C3F3;  
	    color: #004974;  
	    text-decoration: none;  
	} 
	#btn{
	position:fixed;
	margin:0 0 0 0;
	right:80px;
	bottom:40px;
	z-index:999;
	}
	.modal-body span {
		display:block; 
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
	
		<div class="four steps">
		  <span class="step" style="width: 16%">开始申报</span>
		  <span class="step step" style="width: 16%">承诺书</span>
		  <span class="step step" style="width: 16%">信息登记</span>
		  <span class="active step" style="width: 16%">附件上传</span>
		  <span class="disabled step" style="width: 16%">总分自评</span>
		  <span class="disabled step" style="width: 16%">已提交</span>
		</div>
		

		<h4 class="text-c" style="font-size: 23px">${registerInfo.reportName }</h4>
		
		<div  style="width: 60%;margin:40px auto;">
			<div style="font-size: 21px;color: #3bb4f2">------ 附件上传  ------</div><br>
			<div>附件9、10、12、13、15-17、21-25请按照附件格式填报，如格式不正确，则文件无法上传</div><br>
			<div>
				<button class="btn radius btn-primary size-L" onClick="modaldemo()">查看模板格式</button>
				<!-- <div class="f-r">
					<button class="btn radius btn-primary size-L " >清空附件</button>
					<button class="btn radius btn-primary size-L " >批量上传</button>
				</div> -->
			</div>
			<div style="width: 80%;font-size: 22px">
				<span style="margin-left: 40px">序号</span>
				<span style="margin-left: 40px">附件项目与说明</span>
				<div class="f-r">
					<span>附件</span>
				</div>
			</div>
			<form id="fileForm" action="/admin/gmReportUpload/upload.do" enctype="multipart/form-data" method="post">
				<div>
					<input type="text" id="hideData" class="hide" name="hideData">
					<table class="table table-border table-bordered table-striped" style="width: 95%">
						<col style="width:12%">
						<col style="width:50%">
						<col style="width:30%">
						<col style="width:8%">
						<tbody >
							<tr>
								<th>1</th>
								<th>博物馆章程</th>
								<th>
									<a href="javascript:;" class="file" id="up1">上传
									    <input type="file" multiple name="file" id="file1" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName1" ></p>
								</th>
								<th class="hide" id="th1">
									<a href="javascript:;" class="file" id="del1" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>2</th>
								<th>博物馆财务管理制度</th>
								<th>
									<a href="javascript:;" class="file" id="up2">上传
									    <input type="file" multiple name="file" id="file2" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName2" ></p>
								</th>
								<th class="hide" id="th2">
									<a href="javascript:;" class="file" id="del2" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>3</th>
								<th>博物馆年度审计报告、财务报表或决算报告</th>
								<th>
									<a href="javascript:;" class="file" id="up3">上传
									    <input type="file" multiple name="file" id="file3" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName3" ></p>
								</th>
								<th class="hide" id="th3">
									<a href="javascript:;" class="file" id="del3" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>4</th>
								<th>博物馆安全防范制度</th>
								<th>
									<a href="javascript:;" class="file" id="up4">上传
									    <input type="file" multiple name="file" id="file4" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName4" ></p>
								</th>
								<th class="hide" id="th4">
									<a href="javascript:;" class="file" id="del4" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>5</th>
								<th>由公安部门出具的博物馆风险等级达标证明</th>
								<th>
									<a href="javascript:;" class="file" id="up5">上传
									    <input type="file" multiple name="file" id="file5" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName5" ></p>
								</th>
								<th class="hide" id="th5">
									<a href="javascript:;" class="file" id="del5" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>6</th>
								<th>消防部门给博物馆出具的消防达标证明</th>
								<th>
									<a href="javascript:;" class="file" id="up6">上传
									    <input type="file" multiple name="file" id="file6" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName6" ></p>
								</th>
								<th class="hide" id="th6">
									<a href="javascript:;" class="file" id="del6" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>7</th>
								<th>博物馆藏品管理制度</th>
								<th>
									<a href="javascript:;" class="file" id="up7">上传
									    <input type="file" multiple name="file" id="file7" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName7" ></p>
								</th>
								<th class="hide" id="th7">
									<a href="javascript:;" class="file" id="del7" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>8</th>
								<th>博物馆藏品备案、确权情况证明</th>
								<th>
									<a href="javascript:;" class="file" id="up8">上传
									    <input type="file" multiple name="file" id="file8" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName8" ></p>
								</th>
								<th class="hide" id="th8">
									<a href="javascript:;" class="file" id="del8" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>9</th>
								<th>藏品征集清单</th>
								<th>
									<a href="javascript:;" class="file" id="up9">上传
									    <input type="file" multiple name="file" id="file9" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName9" ></p>
								</th>
								<th class="hide" id="th9">
									<a href="javascript:;" class="file" id="del9" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>10</th>
								<th>馆内藏品修复清单</th>
								<th>
									<a href="javascript:;" class="file" id="up10">上传
									    <input type="file" multiple name="file" id="file10" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName10" ></p>
								</th>
								<th class="hide" id="th10">
									<a href="javascript:;" class="file" id="del10" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>11</th>
								<th>馆内重度腐蚀文物清单</th>
								<th>
									<a href="javascript:;" class="file" id="up11">上传
									    <input type="file" multiple name="file" id="file11" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName11" ></p>
								</th>
								<th class="hide" id="th11">
									<a href="javascript:;" class="file" id="del11" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>12</th>
								<th>举办、参加学术会议情况</th>
								<th>
									<a href="javascript:;" class="file" id="up12">上传
									    <input type="file" multiple name="file" id="file12" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName12" ></p>
								</th>
								<th class="hide" id="th12">
									<a href="javascript:;" class="file" id="del12" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>13</th>
								<th>研究成果清单</th>
								<th>
									<a href="javascript:;" class="file" id="up13">上传
									    <input type="file" multiple name="file" id="file13" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName13" ></p>
								</th>
								<th class="hide" id="th13">
									<a href="javascript:;" class="file" id="del13" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>14</th>
								<th>博物馆展厅平面图</th>
								<th>
									<a href="javascript:;" class="file" id="up14">上传
									    <input type="file" multiple name="file" id="file14" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName14" ></p>
								</th>
								<th class="hide" id="th14">
									<a href="javascript:;" class="file" id="del14" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>15</th>
								<th>基本陈列清单</th>
								<th>
									<a href="javascript:;" class="file" id="up15">上传
									    <input type="file" multiple name="file" id="file15" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName15" ></p>
								</th>
								<th class="hide" id="th15">
									<a href="javascript:;" class="file" id="del15" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>16</th>
								<th>临时展览清单</th>
								<th>
									<a href="javascript:;" class="file" id="up16">上传
									    <input type="file" multiple name="file" id="file16" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName16" ></p>
								</th>
								<th class="hide" id="th16">
									<a href="javascript:;" class="file" id="del16" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>17</th>
								<th>引进输出展览清单</th>
								<th>
									<a href="javascript:;" class="file" id="up17">上传
									    <input type="file" multiple name="file" id="file17" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName17" ></p>
								</th>
								<th class="hide" id="th17">
									<a href="javascript:;" class="file" id="del17" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>18</th>
								<th>博物馆展览、讲解词备案情况证明</th>
								<th>
									<a href="javascript:;" class="file" id="up18">上传
									    <input type="file" multiple name="file" id="file18" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName18" ></p>
								</th>
								<th class="hide" id="th18">
									<a href="javascript:;" class="file" id="del18" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>19</th>
								<th>博物馆展览简介</th>
								<th>
									<a href="javascript:;" class="file" id="up19">上传
									    <input type="file" multiple name="file" id="file19" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName19" ></p>
								</th>
								<th class="hide" id="th19">
									<a href="javascript:;" class="file" id="del19" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>20</th>
								<th>博物馆讲解</th>
								<th>
									<a href="javascript:;" class="file" id="up20">上传
									    <input type="file" multiple name="file" id="file20" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName20" ></p>
								</th>
								<th class="hide" id="th20">
									<a href="javascript:;" class="file" id="del20" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>21</th>
								<th>教育项目清单</th>
								<th>
									<a href="javascript:;" class="file" id="up21">上传
									    <input type="file" multiple name="file" id="file21" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName21" ></p>
								</th>
								<th class="hide" id="th21">
									<a href="javascript:;" class="file" id="del21" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>22</th>
								<th>文化产品开发清单</th>
								<th>
									<a href="javascript:;" class="file" id="up22">上传
									    <input type="file" multiple name="file" id="file22" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName22" ></p>
								</th>
								<th class="hide" id="th22">
									<a href="javascript:;" class="file" id="del22" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>23</th>
								<th>博物馆网站、新媒体服务建设情况</th>
								<th>
									<a href="javascript:;" class="file" id="up23">上传
									    <input type="file" multiple name="file" id="file23" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName23" ></p>
								</th>
								<th class="hide" id="th23">
									<a href="javascript:;" class="file" id="del23" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>24</th>
								<th>设备购置和设备维修情况</th>
								<th>
									<a href="javascript:;" class="file" id="up24">上传
									    <input type="file" multiple name="file" id="file24" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName24" ></p>
								</th>
								<th class="hide" id="th24">
									<a href="javascript:;" class="file" id="del24" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>25</th>
								<th>员工专业进修、培训活动情况</th>
								<th>
									<a href="javascript:;" class="file" id="up25">上传
									    <input type="file" multiple name="file" id="file25" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName25" ></p>
								</th>
								<th class="hide" id="th25">
									<a href="javascript:;" class="file" id="del25" onclick="delClick(this.id)">取消</a>
								</th>							</tr>
							<tr>
								<th>26</th>
								<th>获奖证明材料</th>
								<th>
									<a href="javascript:;" class="file" id="up26">上传
									    <input type="file" multiple name="file" id="file26" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName26" ></p>
								</th>
								<th class="hide" id="th26">
									<a href="javascript:;" class="file" id="del26" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>27</th>
								<th>自评分材料</th>
								<th>
									<a href="javascript:;" class="file" id="up27">上传
									    <input type="file" multiple name="file" id="file27" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName27" ></p>
								</th>
								<th class="hide" id="th27">
									<a href="javascript:;" class="file" id="del27" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
							<tr>
								<th>28</th>
								<th>其他（可提交展览和教育活动现场图片资料或文字简介）</th>
								<th>
									<a href="javascript:;" class="file" id="up28">上传
									    <input type="file" multiple name="file" id="file28" onChange="uploadValue(this.id,this.value)">  
									</a>
									<p id="showFileName28" ></p>
								</th>
								<th class="hide" id="th28">
									<a href="javascript:;" class="file" id="del28" onclick="delClick(this.id)">取消</a>
								</th>
							</tr>
						</tbody>
					</table>
					<input type="text" class="hide" name="reportId" value="${registerInfo.id }"/>
					<input type="text" class="hide" name="status" value="2" id="status">
				<div id="btn" class="f-r">
					<input class="btn btn-default radius " id="btn-left" type="button" value="上一步" style="width: 80px" onclick="history.go(-1)">
					<input class="btn btn-primary size-M radius " id="btn-center" type="button" value="保存并返回" style="width: 100px" onclick="onclickSave()">
					<input class="btn btn-primary size-M radius " id="btn-right" type="button" value="下一步" style="width: 80px" onclick="onclickNext()">
				</div>
				</div>
			</form>
		</div>
		<div id="modal-demo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content radius">
					<div class="modal-header">
						<h3 class="modal-title">附件项目与说明<span style="font-size:12px;">(点击下载)</span></h3>
						<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
					</div>
					<div class="modal-body">
						<a href="/admin/gmReportUpload/downDemo.do?filename=1">附件9藏品征集清单</a><br>
						<a href="/admin/gmReportUpload/downDemo.do?filename=2">附件10馆内藏品修复清单</a><br>
						<a href="/admin/gmReportUpload/downDemo.do?filename=3">附件12举办、参加学术会议情况</a><br>
						<a href="/admin/gmReportUpload/downDemo.do?filename=4">附件13研究成果清单</a><br>
						<a href="/admin/gmReportUpload/downDemo.do?filename=5">附件15基本陈列清单</a><br>
						<a href="/admin/gmReportUpload/downDemo.do?filename=6">附件16临时展览清单</a><br>
						<a href="/admin/gmReportUpload/downDemo.do?filename=7">附件17引进、输出展览清单</a><br>
						<a href="/admin/gmReportUpload/downDemo.do?filename=8">附件21教育项目清单</a><br>
						<a href="/admin/gmReportUpload/downDemo.do?filename=9">附件22文化产品开发清单</a><br>
						<a href="/admin/gmReportUpload/downDemo.do?filename=10">附件23博物馆网站、新媒体服务建设情况</a><br>
						<a href="/admin/gmReportUpload/downDemo.do?filename=11">附件24设备购置和设备维修情况</a><br>
						<a href="/admin/gmReportUpload/downDemo.do?filename=12">附件25员工专业进修、培训活动情况</a><br>
						
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<div id="modal-demo2" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content radius">
					<div class="modal-header">
						<h3 class="modal-title">错误信息<span style="font-size:12px;"></span></h3>
						<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
					</div>
					<div class="modal-body">
						<span id="error9"></span>
						<span id="error10"></span>
						<span id="error12"></span>
						<span id="error13"></span>
						<span id="error15"></span>
						<span id="error16"></span>
						<span id="error17"></span>
						<span id="error21"></span>
						<span id="error22"></span>
						<span id="error23"></span>
						<span id="error24"></span>
						<span id="error25"></span>
						
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">确定</button>
					</div>
				</div>
			</div>
		</div>
		
	</section>
	   
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js" ></script>	
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js" ></script>	 
	
	<script type="text/javascript">
		
	
		var array = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0];
		function modaldemo(){
			$("#modal-demo").modal("show");
		};
	
		function onclickSave() {
			$("#status").val("1");
			$("#fileForm").submit();
			layer.open({ 
				  closeBtn: 0,
				  title: false,
				  type: 1, 
				  content: '<img src="<%=request.getContextPath() %>/back/images/loading.gif"/>',
				  anim: 4 
				}); 
		}
		
		function onclickNext() {
			$("#fileForm").submit();
			layer.open({ 
				  closeBtn: 0,
				  title: false,
				  type: 1, 
				  content: '<img src="<%=request.getContextPath() %>/back/images/loading.gif"/>',
				  anim: 4 
				}); 
		}
		//屏蔽F5  
		document.onkeydown = mykeydown;  
		function mykeydown() {  
		    if (event.keyCode == 116) //屏蔽F5刷新键     
		    {  
		        window.event.keyCode = 0;  
		        return false;  
		    }    
		}

		function uploadValue(id,value) {
			var name = value.substring(value.lastIndexOf(".")+1).toLowerCase();
            var str = id.substring(4);
            if (str == 23) {
            	if (name !="doc" && name !="docx") {
            		alert("请选择word格式文件上传！");
            		return;
            	}
            }
            var arr = [9,10,12,13,15,16,17,21,22,24,25];
            for (var j = 0;j < arr.length;j++) {
            	if (str == arr[j]) {
            		if (name !="xls" && name !="xlsx") {
            			alert("请选择execl格式文件上传！");
         		        return; 
            			break;
            		}
            		break;
            	} else if (j == arr.length-1) {
            		if (name != "xls" && name != "xlsx" && name != "doc" && name != "docx" && name != "pdf") {
            			alert("请选择execl或者word或者pdf格式文件上传！");
            			return;
            		}
            	}
            	
            }
		     
			var arr=value.split('\\'); 
			var fileName=arr[arr.length-1]; 
			 
			
			var showFileName = "showFileName" + str;
			var th = "th" + str;
			var up = "up" + str;
			$('#' + showFileName).html(fileName);
			$('#' + showFileName).show();
			$('#' + up).hide();
			$('#' + th).show();
			
			array[str-1] = str;
			//array.push(str); 
			$("#hideData").val(array);
		
		}
		function delClick(id) {
			
			var str = id.substring(3);
			
			var file = "file" + str;
			var obj = $('#' + file);
			obj.select();   
			document.execCommand("delete"); 
			
			var th = "th" + str;
			var up = "up" + str;
			var showFileName = "showFileName" + str;
			
			$('#' + th).hide(); 
			$('#' + up).show();
			$('#' + showFileName).html("");
			$('#' + showFileName).hide();
			
			array[str-1] = 0;
			$("#hideData").val(array);
			/* for(var i = 0;i < array.length;i++) {
				if (array[i] == str) {
					array.splice(i,1);
					$("#hideData").val(array);
				}
			} */
		}
		
		$(document).ready(function() {
			var jsonString = ${jsonString};
			for (var i = 1;i <= jsonString.length;i++) {
				var li = jsonString[i-1];
				if (li.uoloadStatus == 1) {
					$('#showFileName' + i).html(li.uoloadName);
				}
			}
			
			$(".headerNav a.report").addClass("active");   
			$(".fabu-aside>ul>li").eq(4).addClass("weihu"); 
			
			
			var jsonMsgList = ${jsonMsgList};
			if (jsonMsgList == "success") {
				
			} else {
				for(var key in jsonMsgList) {
					$('#showFileName' + key).html("上传失败");  
					$('#showFileName' + key).css("background","red");
					$('#error' + key).html(jsonMsgList[key]);
				}
				$("#modal-demo2").modal("show");
			}
		})
		
	</script>
	
		
	</script>
</body>
</html>
