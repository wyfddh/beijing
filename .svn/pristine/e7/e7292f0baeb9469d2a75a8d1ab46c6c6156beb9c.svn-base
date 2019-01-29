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
<body onbeforeunload="refreshParentQuery(${oper!='add'?false:true});">
	<div class=" page-content my-icms" style="padding: 0 10px 10px;">
		<div id="left">
			<div id="yc1" class="row" style="display: block;">
				<div class="col-lg-12">
					<div class="bg1">
						<div class="row " id="detailCulHtml" style="padding: 12px;">
							<form method="post" action="#" class="registerform" id="cgform" >
							<input type="hidden" id="id" name="id" value="${bean.id}">
							<input type="hidden" id="selectCode" name="selectCode" value="${bean.selectCode}">
							<input type="hidden" id="showType" name="showType" value="1">
							<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name"><span class="rad">*</span>数据源名称</div>
										<div class="profile-info-value">
											<input class="sl-inputtext-ss"  datatype="*" nullmsg="请输入数据源名称！" style="width: 80%;" type="text" id="selectName" name="selectName" value="${bean.selectName}">
										</div>
									</div>
								</div>
							</div>
							<%-- <div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name">json获取url地址</div>
										<div class="profile-info-value">
											<input class="sl-inputtext-ss" style="width: 80%;" type="text" id="jsonUrl" name="jsonUrl" value="${bean.jsonUrl}">
										</div>
									</div>
								</div>
							</div> --%>
							<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name">Sql</div>
										<div class="profile-info-value">
											<textarea class="sl-inputtext-ss" style="width: 80%;height:189px;"  id="jsonSql" name="jsonSql" value="">${bean.jsonSql}</textarea>
										</div>
									</div>
								</div>
							</div>
							<%-- <div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name">回调函数</div>
										<div class="profile-info-value">
											<input class="sl-inputtext-ss" style="width: 80%;" type="text" id="backFunction" name="backFunction" value="${bean.backFunction}">
										</div>
									</div>
								</div>
							</div> --%>
							<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name">备注</div>
										<div class="profile-info-value">
											<input class="sl-inputtext-ss" style="width: 80%;" type="text" id="remark" name="remark" value="${bean.remark}">
										</div>
									</div>
								</div>
							</div>
							
							<%-- <div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name"><span class="rad">*</span>展示方式</div>
										<div class="profile-info-value">
											 <select style="width:100%;" datatype="/^\s*$/|*" id="showType" name="showType">
											 	<option value="">请选择</option>
												<option value="1" <c:if test="${bean.showType =='1'}">selected</c:if>>列表</option>
												<option value="2" <c:if test="${bean.showType =='2'}">selected</c:if>>树</option>
											</select>
										</div>
									</div>
								</div>
							</div> --%>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="nav-btu" style="padding-right: 30px; box-sizing: border-box;">
				<ul>
					<li id="saveFunc"><button class="btn" type="button" onclick="save_1_()"><i class="fa fa-save btn-xs "></i> 保存</button></li>
					<li><button class="btn" type="button" onclick="closePage()"><i class="fa fa-times "></i> 关闭</button></li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="designPlug-in/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="designPlug-in/Validform/js/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript">
		//InitValidform("detailCulHtml");
		
		function save_1_(){
			/* if(!myValidform.check()){ return false; } */
			var selectName = $("#selectName").val();
			var selectCode = $("#selectCode").val();
			var showType = $("#showType").val();
			if(selectName==null||selectName==''){
				parent.layer.msg("请输入数据源名称！", {icon: 5});
				return false;
			}
			/**else if(showType==null||showType==''){
				parent.layer.msg("请选择展示方式！", {icon: 5});
				return false;
			}
			*/
			var form1= $("form").serialize();
			var id = $("#id").val();
			$.ajax({
				async: false,
				url: "<%=path %>/cgformSelectBackController.do?" + (id!=''?'doUpdate':'doAdd'),
				type: "POST",dataType: "json",//async: false,
				data: form1,
				success: function(data) {
					if(data!=null){
						if(data.success){
							parent.layer.msg(data.msg, {icon: 1});
							console.log(data.success);
							var datas={main_id:$("#id").val()!='ABC'?$("#id").val():''};
							parent.layuiTableReload("${bussCode }",datas);
							parent.loadTree('');
							closePage();
						}else{
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
<script src="designPlug-in/ace/assets/js/jquery.gritter.min.js"></script>
