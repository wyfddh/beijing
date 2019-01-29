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
<script src="designPlug-in/tools/icmstools.js?1212"></script>
<script src="designPlug-in/layer/SZHLCommon.js"></script>


</head>
<body>
	<div class=" page-content my-icms" style="padding: 0 10px 10px;">
		<div id="left">
			<div id="yc1" class="row" style="display: block;">
				<div class="col-lg-12">
					<div class="bg1">
						<div class="row " id="detailCulHtml" style="padding: 12px;">
							<form method="post" action="#" class="registerform" id="cgform" >
								<input type="hidden" name="id" id="id" value="${bean.id}">
								<input type="hidden" name="bussId" id="bussId" value="${bean.bussId}">
								<input type="hidden" name="defineId" id="defineId" value="${cgFormLgFieldEntity.id}">
								<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
									<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
										<div class="profile-info-row">
											<div class="profile-info-name"><span class="rad">*</span>字段名</div>
											<div class="profile-info-value">
												<c:choose>
													<c:when test="${not empty bean&&not empty bean.fieldName}">
														<input class="sl-inputtext-ss" style="width: 100%;" readonly="readonly" type="text" id="fieldName" name="fieldName" value="${bean.fieldName}">
													</c:when>
													<c:otherwise>
														<input class="sl-inputtext-ss" style="width: 100%;" readonly="readonly" type="text" id="fieldName" name="fieldName" value="${cgFormLgFieldEntity.fieldName}">
													</c:otherwise>
												</c:choose>
											</div>
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
									<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
										<div class="profile-info-row">
											<div class="profile-info-name"><span class="rad">*</span>字段中文名</div>
											<div class="profile-info-value">
												<c:choose>
													<c:when test="${not empty bean&&not empty bean.content}">
														<input class="sl-inputtext-ss" style="width: 100%;" type="text" id="content" name="content" value="${bean.content}">
													</c:when>
													<c:otherwise>
														<input class="sl-inputtext-ss" style="width: 100%;" type="text" id="content" name="content" value="${cgFormLgFieldEntity.content}">
													</c:otherwise>
												</c:choose>
											</div>
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
									<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
										<div class="profile-info-row">
											<div class="profile-info-name"><span class="rad">*</span>列宽</div>
											<div class="profile-info-value">
												<%-- <c:choose>
													<c:when test="${not empty bean && not empty bean.columnWidth}">
														<input class="sl-inputtext-ss" style="width: 40%;" type="text" id="columnWidth" name="columnWidth" value="${bean.columnWidth}">
													</c:when>
													<c:otherwise>
														<input class="sl-inputtext-ss" style="width: 40%;" type="text" id="columnWidth" name="columnWidth" value="${cgFormLgFieldEntity.columnWidth}">
													</c:otherwise>
												</c:choose> --%>
												<input class="sl-inputtext-ss" style="width: 100%;" type="text" id="columnWidth" name="columnWidth" value="${bean.columnWidth==null?'100':bean.columnWidth}">
											</div>
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
									<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
										<div class="profile-info-row">
											<div class="profile-info-name"><span class="rad">*</span>是否隐藏</div>
											<div class="profile-info-value">
											<select id="isListHide" name="isListHide" style="width: 100%;" >
											<option value="N" 
											<c:if test="${bean.isListHide=='N'}"> selected</c:if> >否</option>
											<option value="Y"
											<c:if test="${bean.isListHide=='Y'}"> selected</c:if> >是</option>
											</select>
											</div>
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
									<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
										<div class="profile-info-row">
											<div class="profile-info-name">排序</div>
											<div class="profile-info-value">
												<input class="sl-inputtext-ss" style="width: 100%;" type="text" id="sort" name="sort" value="${bean.sort}">
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="designPlug-in/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="designPlug-in/Validform/js/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			InitValidform("detailCulHtml");
		});
		
		<%-- function save_1_(){
			if(!myValidform.check()){ return false; }
			var form1= $("form").serialize();
			console.log(form1);
			var id = $("#id").val();
			$.ajax({
				async: false,
				url: "<%=path %>/cgformReportIndexController.do?" + (id!=''?'doUpdate':'doAdd'),
				type: "POST",dataType: "json",//async: false,
				data: form1,
				success: function(data) {
					if(data!=null){
						parent.layer.msg(data.msg, {icon: 1});
						if(data.success){
							console.log(data.success);
							window.parent.EntityList.query((id!=''?false:true));
							closePage();
						}
					}
				}
			});
		} --%>
		function closePage(){
			parent.layer.closeAll("iframe");
		}
	</script>
</body>
</html>

<script type="text/javascript" src="designPlug-in/Validform/js/Validform_v5.3.2_min.js"></script>
<script src="designPlug-in/ace/assets/js/jquery.gritter.min.js"></script>
