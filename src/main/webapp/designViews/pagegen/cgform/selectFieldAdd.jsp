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
<script src="designPlug-in/tools/icmstools.js"></script>
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
							<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name">数据源名称</div>
										<div class="profile-info-value">
											<input type="hidden" id="mainId" name="mainId" value="${cgformSelectBack.id}">
											<input class="sl-inputtext-ss" disabled="disabled" style="width: 80%;" type="text" value="${cgformSelectBack.selectName}">
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name"><span class="rad">*</span>字段名</div>
										<div class="profile-info-value">
											<input class="sl-inputtext-ss" itipmsg datatype="*" onfocus="Validformfocusin(this)"
											onblur="Validformfocusout(this)" 
											style="width: 80%;" type="text" id="fieldCode" 
											<c:if test="${isUse==true }"> readonly="readonly"</c:if>
											name="fieldCode" value="${bean.fieldCode}">
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name"><span class="rad">*</span>字段中文名</div>
										<div class="profile-info-value">
											<input class="sl-inputtext-ss" style="width: 80%;"  datatype="*" type="text" id="fieldName" name="fieldName" value="${bean.fieldName}">
										</div>
									</div>
								</div>
							</div>
							
							<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name">字段宽度</div>
										<div class="profile-info-value">
											<input class="sl-inputtext-ss" style="width: 80%;" type="text" id="fieldWidth" name="fieldWidth" value="${bean.fieldWidth}">
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name">是否隐藏</div>
										<div class="profile-info-value">
											 <select style="width:100%;" datatype="/^\s*$/|*" id="isHide" name="isHide">
											 	<option value="">请选择</option>
												<option value="Y" <c:if test="${bean.isHide =='Y'}">selected</c:if>>是</option>
												<option value="N" <c:if test="${bean.isHide =='N'}">selected</c:if>>否</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name">是否查询</div>
										<div class="profile-info-value">
											 <select style="width:100%;" datatype="/^\s*$/|*" id="isQuery" name="isQuery">
											 	<option value="">请选择</option>
												<option value="Y" <c:if test="${bean.isQuery =='Y'}">selected</c:if>>是</option>
												<option value="N" <c:if test="${bean.isQuery =='N'}">selected</c:if>>否</option>
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
											<input class="sl-inputtext-ss" style="width: 80%;" type="text" id="sort" name="sort" value="${bean.sort}">
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
		$(document).ready(function(){
			InitValidform_("detailCulHtml");
		});
		
		function save_1_(){
			if(!myValidform_.check()){ return false; }
			
			var form1= $("form").serialize();
			console.log(form1);
			var id = $("#id").val();
			$.ajax({
				async: false,
				url: "<%=path %>/cgformSelectFieldController.do?" + (id!=''?'doUpdate':'doAdd'),
				type: "POST",dataType: "json",//async: false,
				data: form1,
				success: function(data) {
					if(data!=null){
						parent.layer.msg(data.msg, {icon: 1});
						if(data.success){
							console.log(data.success);
							var datas={group_id:$("#mainId").val()!='ABC'?$("#mainId").val():''};
							parent.layuiTableReload("${bussCode }",datas);
							closePage();
						}
					}
				}
			});
		}
		function closePage(){
			parent.layer.closeAll("iframe");
		}
		
		
		var myValidform_;
		function InitValidform_(formId) {
			myValidform_=$("#"+formId).Validform({
			tiptype:function(msg,o,cssctl){
				//msg：提示信息;
				//o:{obj:*,type:*,curform:*}, obj指向的是当前验证的表单元素（或表单对象），type指示提示的状态，值为1、2、3、4， 1：正在检测/提交数据，2：通过验证，3：验证失败，4：提示ignore状态, curform为当前form对象;
				//cssctl:内置的提示信息样式控制函数，该函数需传入两个参数：显示提示信息的对象 和 当前提示的状态（既形参o中的type）;
				if(!o.obj.is("form")){//验证表单元素时o.obj为该表单元素，全部验证通过提交表单时o.obj为该表单对象;
					var vl= $(o.obj).closest(".profile-info-row").find(".Validforminfo");
					vl.remove();
					var objtiphtml="";
					if(o.type==3){
						objtiphtml+="<span class='Validform_checktip Validform_wrong'>";
					}
					if(o.type==2){
						objtiphtml+="<span class='Validform_checktip Validform_right'>";
					}
					objtiphtml+=msg;
					objtiphtml+="</span>";
					var objtip=$(objtiphtml);
					cssctl(objtip,o.type);
					var infohtml="";
					infohtml+="<div class='Validforminfo' style='top: 0px;display: block;position: absolute;left: 130px;z-index: 2;width:215px'>";
					infohtml+=objtiphtml;
					infohtml+="</div>";
					$(o.obj).closest(".profile-info-row").append(infohtml);
				//if(o.type==2){
					vl= $(o.obj).closest(".profile-info-row").find(".Validforminfo");
					vl.fadeOut(2500);
				//}
				}
			}
		});
			//$.closeLoading_();//关闭加载窗口
		}
		
	</script>
</body>
</html>

<script type="text/javascript" src="designPlug-in/Validform/js/Validform_v5.3.2_min.js"></script>
<script src="designPlug-in/ace/assets/js/jquery.gritter.min.js"></script>
