<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Hosting Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
        Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<title></title>
<t:base type="jquery"></t:base>

<script src='designPlug-in/ace/assets/js/jquery-2.0.3.min.js'></script>
<script src="designPlug-in/layer/layer.js"></script>
<script src="designPlug-in/layer/extend/layer.ext.js"></script>
<script src="designPlug-in/laypage/laypage.js"></script>
<link rel="stylesheet" href="designPlug-in/Validform/css/style.css" type="text/css">
<link href="designPlug-in/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
<script src="designPlug-in/avalon/avalon1.4.js"></script>
<script type="text/javascript" src="designPlug-in/My97DatePicker/WdatePicker.js"></script>

<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/plus.css"/>
<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/ace-rtl.min.css"/>
<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/ace.min.css"/>
<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/font-awesome.min-plus.css"/>
<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/plus-new.css"/>
<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/my-plus-new.css"/>
<script src="designPlug-in/tools/icmstools.js?1313"></script>
<script src="designPlug-in/layer/SZHLCommon.js"></script>


</head>
<body onbeforeunload="refreshParentQuery(${oper!='add'?false:true});">
	<div class=" page-content my-icms" style="padding: 0 10px 10px;">
		<div id="left">
			<div id="yc1" class="row" style="display: block;">
				<div class="col-lg-12">
					<div class="bg1">
						<div class="row " id="detailCulHtml" style="padding: 12px;">
							<form method="post" action="#" class="registerform" id="cgform" >
							<input type="hidden" id="id" name="id" value="${bean.id}">
							<input type="hidden" id="bussType" name="bussType" value="${bussType}">
							<div class="col-xs-12 col-md-6" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name"><span class="rad">*</span>表单名称</div>
										<div class="profile-info-value">
											<input class="sl-inputtext-ss" itipmsg datatype="*" onfocus="Validformfocusin(this)" onblur="Validformfocusout(this)" style="width: 80%;" type="text" id="defineName" name="defineName" value="${bean.defineName}">
										</div>
									</div>
								</div>
							</div>
							<%-- <div class="col-xs-12 col-md-6" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name"><span class="rad">*</span>表单分类</div>
										<div class="profile-info-value">
											 <select style="width:100%;" datatype="/^\s*$/|*" id="type" name="type">
											 	<option value="">请选择</option>
												<option value="1" <c:if test="${bean.type =='1'}">selected</c:if>>研究</option>
												<option value="2" <c:if test="${bean.type =='2'}">selected</c:if>>藏品</option>
												<option value="3" <c:if test="${bean.type =='3'}">selected</c:if>>展览</option>
												<option value="4" <c:if test="${bean.type =='4'}">selected</c:if>>教育</option>
											</select>
										</div>
									</div>
								</div>
							</div> --%>
							<div class="col-xs-12 col-md-6" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name"><span class="rad">*</span>存储方式</div>
										<div class="profile-info-value">
											<select style="width:100%;" datatype="/^\s*$/|*" id="saveType" name="saveType">
											  <option value="1" <c:if test="${bean.saveType =='1'}">selected</c:if>>建表存储</option>
											  <option value="2" <c:if test="${bean.saveType =='2'}">selected</c:if>>键值存储</option>  
											 </select>
										</div>
									</div>
								</div>
							</div>
							<c:if test="${not empty parentCgformReport}">
								<div class="col-xs-12 col-md-6" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
									<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
										<div class="profile-info-row">
											<div class="profile-info-name">上级编码</div>
											<div class="profile-info-value">
												<input type="hidden" id="groupId" name="groupId" value="${parentCgformReport.id}">
												<input class="sl-inputtext-ss" style="width: 80%;" disabled="disabled" type="text" id="fieldName" value="${parentCgformReport.fieldName}">
											</div>
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-md-6" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
									<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
										<div class="profile-info-row">
											<div class="profile-info-name">上级指标</div>
											<div class="profile-info-value">
												<input class="sl-inputtext-ss" style="width: 80%;" disabled="disabled" type="text" id="content" value="${parentCgformReport.content}">
											</div>
										</div>
									</div>
								</div>
							</c:if>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="nav-btu" style="padding-right: 30px; box-sizing: border-box;">
				<ul>
					<li id="saveFunc"><button class="btn" type="button" onclick="save_1_()"><i class="fa fa-save btn-xs "></i> 开始设计表单</button></li>
					<li><button class="btn" type="button" onclick="closePage()"><i class="fa fa-times "></i> 关闭</button></li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="designPlug-in/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="designPlug-in/Validform/js/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			InitValidform("detailCulHtml");
		});
		
		
		function save_1_(){
			if(!myValidform.check()){ return false; }
			var form1= $("form").serialize();
			console.log(form1);
			var id = $("#id").val();
			var winHandler = window.open("","_blank");
			$.ajax({
				async: false,
				url: "<%=path %>/cgformDefineController.do?" + (id!=''?'doUpdate':'doAdd'),
				type: "POST",dataType: "json",//async: false,
				data: form1,
				success: function(data) {
					if(data!=null){
						if(data.success){
							winHandler.location.href = "designController.do?design&type=${bussType}&businessCode="+data.msg;
							parent.layuiTableReload("${bussCode }",{});
							closePage();
						}else{
							winHandler.close();
							parent.layer.msg(data.msg, {icon: 5});
						}
					}
				}
			});
		}
		function closePage(){
			parent.layer.closeAll("iframe");
		}
	</script>
</body>
</html>

<script type="text/javascript" src="designPlug-in/Validform/js/Validform_v5.3.2_min.js"></script>
<script src="designPlug-in/ace/assets/js/jquery.gritter.min.js"></script>
