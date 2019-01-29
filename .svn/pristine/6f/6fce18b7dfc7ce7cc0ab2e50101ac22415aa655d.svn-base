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
<t:base type="jquery,layer"></t:base>
<script src='designPlug-in/ace/assets/js/jquery-2.0.3.min.js'></script>
<script src="designPlug-in/layer/layer.js"></script>
<script src="designPlug-in/layer/extend/layer.ext.js"></script>
<script src="designPlug-in/laypage/laypage.js"></script>
<link rel="stylesheet" href="designPlug-in/Validform/css/style.css" type="text/css">

<script src="designPlug-in/avalon/avalon1.4.js"></script>
<link href="designPlug-in/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
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
							<form method="post" action="#" class="registerform" id="cgform" tiptype="3" >
							<input type="hidden" id="id" name="id" value="${bean.id}">
							<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name"><span class="rad">*</span>指标编码</div>
										<div class="profile-info-value">
											<input class="sl-inputtext-ss" nullmsg="请填写指标编码！" datatype="*" onfocus="Validformfocusin(this)" onblur="Validformfocusout(this)" style="width: 80%;" type="text" id="fieldName" name="fieldName" value="${bean.fieldName}">
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name"><span class="rad">*</span>指标中文名</div>
										<div class="profile-info-value">
											<input class="sl-inputtext-ss" nullmsg="请填写指标中文名！" datatype="*" style="width: 80%;" type="text" id="content" name="content" value="${bean.content}">
										</div>
									</div>
								</div>
							</div>
							
							<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name"><span class="rad">*</span>指标长度</div>
										<div class="profile-info-value">
											<input class="sl-inputtext-ss" nullmsg="请填写指标长度！" datatype="n" style="width: 80%;" type="text" id="length" name="length" value="${bean.length}">
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name"><span class="rad">*</span>列表显示宽度</div>
										<div class="profile-info-value">
											<input class="sl-inputtext-ss" style="width: 80%;"  nullmsg="请填写列表显示宽度！" datatype="n" type="text" id="columnWidth" name="columnWidth" value="${bean.columnWidth}">
										</div>
									</div>
								</div>
							</div>
								<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
									<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
										<div class="profile-info-row">
											<div class="profile-info-name"><span class="rad">*</span>控件类型</div>
											<div class="profile-info-value">
												 <select style="width:100%;"  nullmsg="请选择控件类型！" datatype="*" id="showType" name="showType" onchange="selectFeildUrl(this)">
												 	<option value="">请选择</option>
													<option value="text" <c:if test="${bean.showType =='text'}">selected</c:if>>文本框</option>
													<option value="password" <c:if test="${bean.showType =='password'}">selected</c:if>>密码框</option>
													<option value="radio" <c:if test="${bean.showType =='radio'}">selected</c:if>>单选框</option>
													<option value="checkbox" <c:if test="${bean.showType =='checkbox'}">selected</c:if>>多选框</option>
													<option value="year" <c:if test="${bean.showType =='year'}">selected</c:if>>年份</option>
													<option value="yymm" <c:if test="${bean.showType =='yymm'}">selected</c:if>>年月</option>
													<option value="date" <c:if test="${bean.showType =='date'}">selected</c:if>>日期</option>
													<option value="time" <c:if test="${bean.showType =='time'}">selected</c:if>>时分秒</option>
													<option value="datetime" <c:if test="${bean.showType =='datetime'}">selected</c:if>>日期+时分秒</option>
													<option value="textarea" <c:if test="${bean.showType =='textarea'}">selected</c:if>>大文本框</option>
													<option value="list" <c:if test="${bean.showType =='list'}">selected</c:if>>下拉选择框</option>
													<option value="popup" <c:if test="${bean.showType =='popup'}">selected</c:if>>弹出选择框</option>
												</select>
											</div>
										</div>
									</div>
								</div>
							
								<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;
								<c:if test="${bean.showType!='list'&&bean.showType!='popup'&&bean.showType!='radio'&&bean.showType!='checkbox'}">display: none;</c:if>
								" id="selectBack">
									<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
										<div class="profile-info-row">
											<div class="profile-info-name">数据源</div>
											<div class="profile-info-value">
											<input type="hidden" id="dictField" name="dictField" value="${bean.dictField}">
											<input type="hidden" id="dictText" name="dictText" value="${bean.dictText}">
											<input type="hidden" id="set_windowHeight" name="windowHeight" value="${bean.windowHeight}">
											<input type="hidden" id="set_windowWidth" name="windowWidth" value="${bean.windowWidth}">
											<input type="hidden" id="inputId" name="inputId" value="${bean.inputId}">
											<input type="hidden" id="selectId" name="selectId" value="${bean.selectId}">
												<select style="width:80%;"   id="fieldHref" name="fieldHref"  onchange="resetFeildUrl(this)">
													<option value="" subdata="" >请选择</option>
													<c:forEach items="${list}" var="list">
														<option  subdata="${list.sub }" value="${list.va}" <c:if test="${bean.fieldHref ==list.va}">selected</c:if>>${list.name}</option>
													</c:forEach>
												</select>
												<i class="layui-icon" onclick='jumpSet_()'>&#xe620;</i>
											</div>
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
									<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
										<div class="profile-info-row">
											<div class="profile-info-name"><span class="rad">*</span>指标类型</div>
											<div class="profile-info-value">
												<select style="width:100%;" nullmsg="请选择指标类型！" datatype="*"  id="type" name="type">
												  <option value="">请选择</option>
												  <option value="string" <c:if test="${bean.type =='string'}">selected</c:if>>字符串</option>
												  <option value="int" <c:if test="${bean.type =='int'}">selected</c:if>>整型</option>  
												  <option value="double" <c:if test="${bean.type =='double'}">selected</c:if>>浮点型</option>  
												  <option value="Date" <c:if test="${bean.type =='Date'}">selected</c:if>>日期</option>  
												  <option value="text" <c:if test="${bean.type =='text'}">selected</c:if>>长文本</option>  
												  <option value="blob" <c:if test="${bean.type =='blob'}">selected</c:if>>二进制</option>
												 </select>
											</div>
										</div>
									</div>
								</div>
							<c:if test="${not empty parentCgformReport}">
								<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
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
								<div class="col-xs-12 col-md-12" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
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
					<li id="saveFunc"><button class="btn" type="button" onclick="save_1_()"><i class="fa fa-save btn-xs "></i> 保存</button></li>
					<li><button class="btn" type="button" onclick="closePage()"><i class="fa fa-times "></i> 关闭</button></li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="designPlug-in/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="designPlug-in/Validform/js/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript">
var form;
	layui.use(['form'], function(){
		form = layui.form;
	});
	
	
	//业务数据来源属性配置
	function jumpSet_(){
		var ht="";
		var sv=$("#fieldHref").find("option:selected").val();
		if(sv==""){
			layer.msg('请选择数据源！', {icon: 5});
			return false;
		}
		var showType=$("#showType").find("option:selected").val();
		if(showType==""){
			layer.msg('请选择控件类型！', {icon: 5});
			return false;
		}
		
		var inputids = $("#inputId").val();
		var selectids = $("#selectId").val();
		var zwyyf = $("#dictField").val();
		var sjppf = $("#dictText").val();
		var width=$("#set_windowWidth").val();
		var height=$("#set_windowHeight").val();
		width=(width!=""?width:"500");
		height=(height!=""?height:"500");
		var selectId = $("#id").val();
		$("#set_windowWidth").val(width);
		$("#set_windowHeight").val(height);
		
			ht+="<table id='set_table'  style='border-spacing: 1px;border-collapse: inherit;' cellpadding='0' cellspacing='1' class='formtable'>";
			if(showType=="popup"){
				 ht+="<tr><td class='value' style='width:100%;' align='left' colspan='5' > 输入、输出的属性排序决定赋值的顺序，二者应该保持一致</br></td>";
				ht+="</tr>";
				ht+="<tr><td style='width:20%;' align='right'><label class='Validform_label'>弹窗宽度&nbsp;</label></td>";
				ht+="<td class='value'>";
				ht+="<input id='windowWidth'  type='text' style='width:80%' class='inputxt' value='"+width+"'>";
				ht+="</td><td align='right'><label class='Validform_label'>弹窗高度&nbsp;</label></td>";
				ht+="<td class='value'>";
				ht+="<input id='windowHeight'  type='text' style='width:80%' class='inputxt' value='"+height+"'>";
				ht+="</td>";
				ht+="</tr>";
				ht+="<tr style='height:50px;'><td align='right' style='width:20%;'><label class='Validform_label'>输入属性&nbsp;</label></td>";
				ht+="<td class='value' colspan='3'>";
				ht+="<div id='inputids_'>";
				ht+=getInputidsHtml(inputids);
				ht+="</div>";
				ht+="</td>";
				ht+="</tr>";
			}
				ht+="<tr style='height:50px;'><td  align='right'><label class='Validform_label'>输出属性&nbsp;</label></td>";
				ht+="<td class='value' colspan='3'><i class='layui-icon' onclick='selectBackField()'></i>";
				ht+="<div id='selectIds_'>";
				ht+=getBackFieldsHtml(selectids);
				ht+="</div>";
				ht+="</td>";
				ht+="</tr>";
				ht+="<tr style='height:50px;'><td align='right' style='width:20%;'><label class='Validform_label'>中文引用字段&nbsp;</label></td>";
				ht+="<td class='value' colspan='3'><i class='layui-icon' onclick='selectZWYYField()'></i>";
				ht+="<div id='zwyyf_'>";
				ht+=getZWYYFHtml(zwyyf);
				ht+="</div>";
				ht+="</td>";
				ht+="</tr>";
				ht+="<tr style='height:50px;'><td align='right' style='width:20%;'><label class='Validform_label'>数据匹配字段&nbsp;</label></td>";
				ht+="<td class='value' colspan='3'><i class='layui-icon' onclick='selectSJPPField()'></i>";
				ht+="<div id='sjppf_'>";
				ht+=getSJPPFHtml(sjppf);
				ht+="</div>";
				ht+="</td>";
				ht+="</tr>";
				ht+="</table>";
		var open1=layer.open({
			  type: 1,
			  skin: '', //加上边框
			  title:"参数配置",
			  btn: ['关闭'],
			  area: ['520px', '400px'], //宽高
			  content: ht
			});
		$("#set_table").on("input", "input[type=text]", function() {
			$("#set_"+$(this).attr("id")).val($(this).val());
		});
	}

	function getInputidsHtml(inputids){
		var ht="";
		if(inputids!=""){
			for(var q=0;q<inputids.split(",").length;q++){
				var w=inputids.split(",")[q];
				ht+="<span class='layui-badge layui-bg-green' style='margin: 5px;border-radius: 5px;'>"+w+"</span>";
			}
		}
		return ht;
	}

	function getZWYYFHtml(selectids){
		var subdata=$(" #fieldHref").find("option:selected").attr("subdata");
		var ht="";
		if(selectids!=""){
			if(subdata!=""){
				var subdata1=subdata.split("@");
				for(var a=0;a<subdata1.length;a++){
					if(selectids==subdata1[a].split("#")[0]){
						ht+="<span class='layui-badge layui-bg-green' style='margin: 5px;border-radius: 5px;'>"+subdata1[a].split("#")[1]+"</span>";
					}
				}
			}
		}
		return ht;
	}

	function getSJPPFHtml(selectids){
		var subdata=$("#fieldHref").find("option:selected").attr("subdata");
		var ht="";
		if(selectids!=""){
			if(subdata!=""){
				var subdata1=subdata.split("@");
				for(var a=0;a<subdata1.length;a++){
					if(selectids==subdata1[a].split("#")[0]){
						ht+="<span class='layui-badge layui-bg-green' style='margin: 5px;border-radius: 5px;'>"+subdata1[a].split("#")[1]+"</span>";
					}
				}
			}
		}
	return ht;
	}


	function getBackFieldsHtml(selectids){
		var subdata=$("#fieldHref").find("option:selected").attr("subdata");
		var ht="";
		if(selectids!=""){
			for(var q=0;q<selectids.split(",").length;q++){
				var w=selectids.split(",")[q];
				if(w!=""){
					if(subdata!=""){
						var subdata1=subdata.split("@");
						for(var a=0;a<subdata1.length;a++){
							if(subdata1[a].split("#").length>1&&w==subdata1[a].split("#")[0]){
								ht+="<span class='layui-badge layui-bg-green' style='margin: 5px;border-radius: 5px;'>"+subdata1[a].split("#")[1]+"</span>";
							}
						}
					}
				}
			}
		}
		return ht;
	}

	function selectZWYYField(){
		var ppselect = $("#dictField").val();
		var subdata=$("#fieldHref").find("option:selected").attr("subdata");
		var f1="";
		f1+="<div class='layui-form' lay-filter='selectZWYYField'>";
		if(subdata!=""){
			var subdata1=subdata.split("@");
			for(var a=0;a<subdata1.length;a++){
				if(subdata1[a].split("#").length>1){
					f1+="<div class='layui-col-md3' style='margin:5px;'>";
					f1+="<input type='checkbox' lay-filter='myselect' id='SELECT_CK_"+subdata1[a].split("#")[0]+"' name='"+subdata1[a].split("#")[1]+"' value='"+subdata1[a].split("#")[0]+"'  title='"+subdata1[a].split("#")[1]+"'>";
					f1+="</div>";
				}
			}
		}
		f1+="</div>";
		var open2=layer.open({
			  type: 1,
			  skin: '', //加上边框
			  title:"字段选择",
			  btn: ['确定'],
			  area: ['400px', '300px'], //宽高
			  content: f1
			});
		
		if(ppselect!=""){
			for(var q=0;q<ppselect.split(",").length;q++){
				var w=ppselect.split(",")[q];
				if(w!=""){
					$("[id='SELECT_CK_"+w+"']").attr("checked",true);
				}
			}
		}
		form.render(null, 'selectZWYYField');//重新渲染
		form.on("checkbox(myselect)", function(data){
			var selectids = $("#dictField").val();
			var sv=data.value;
			if(!data.elem.checked){
				sv="";
			}
			$("#dictField").val(sv);
			selectids = $("#dictField").val();
			var selectidsHtml=getBackFieldsHtml(selectids);
			$("#zwyyf_").html(selectidsHtml); 
			$("#dictField").val(selectids);
		});
	}

	function selectSJPPField(){
		var ppselect = $("#dictText").val();
		var subdata=$("#fieldHref").find("option:selected").attr("subdata");
		var f1="";
		f1+="<div class='layui-form' lay-filter='selectSJPPField'>";
		if(subdata!=""){
			var subdata1=subdata.split("@");
			for(var a=0;a<subdata1.length;a++){
				if(subdata1[a].split("#").length>1){
					f1+="<div class='layui-col-md3' style='margin:5px;'>";
					f1+="<input type='checkbox' lay-filter='myselect' id='SELECT_CK_"+subdata1[a].split("#")[0]+"' name='"+subdata1[a].split("#")[1]+"' value='"+subdata1[a].split("#")[0]+"'  title='"+subdata1[a].split("#")[1]+"'>";
					f1+="</div>";
				}
			}
		}
		f1+="</div>";
		var open2=layer.open({
			  type: 1,
			  skin: '', //加上边框
			  title:"字段选择",
			  btn: ['确定'],
			  area: ['400px', '300px'], //宽高
			  content: f1
			});
		
		if(ppselect!=""){
			for(var q=0;q<ppselect.split(",").length;q++){
				var w=ppselect.split(",")[q];
				if(w!=""){
					$("[id='SELECT_CK_"+w+"']").attr("checked",true);
				}
			}
		}
		form.render(null, 'selectSJPPField');//重新渲染
		form.on("checkbox(myselect)", function(data){
			var selectids = $("#dictText").val();
			var sv=data.value;
			if(!data.elem.checked){
				sv="";
			}
			$("#dictText").val(sv);
			
			selectids =$("#dictText").val();
			var selectidsHtml=getBackFieldsHtml(selectids);
			$("#sjppf_").html(selectidsHtml);
			$("#dictText").val(selectids);
		});
	}

	function selectBackField(){
		var ppselect = $("#selectId").val();
		var subdata=$("#fieldHref").find("option:selected").attr("subdata");
		var f1="";
		f1+="<div class='layui-form' lay-filter='selectBackField'>";
		if(subdata!=""){
			var subdata1=subdata.split("@");
			for(var a=0;a<subdata1.length;a++){
				if(subdata1[a].split("#").length>1){
					f1+="<div class='layui-col-md3' style='margin:5px;'>";
					f1+="<input type='checkbox' lay-filter='myselect' id='SELECT_CK_"+subdata1[a].split("#")[0]+"' name='"+subdata1[a].split("#")[1]+"' value='"+subdata1[a].split("#")[0]+"'  title='"+subdata1[a].split("#")[1]+"'>";
					f1+="</div>";
				}
			}
		}
		f1+="</div>";
		var open2=layer.open({
			  type: 1,
			  skin: '', //加上边框
			  title:"字段选择",
			  btn: ['确定'],
			  area: ['400px', '300px'], //宽高
			  content: f1
			});
		
		if(ppselect!=""){
			for(var q=0;q<ppselect.split(",").length;q++){
				var w=ppselect.split(",")[q];
				if(w!=""){
					$("[id='SELECT_CK_"+w+"']").attr("checked",true);
				}
			}
		}
		form.render(null, 'selectBackField');//重新渲染
		form.on("checkbox(myselect)", function(data){
			var selectids =  $("#selectId").val();
			var sv=data.value+",";
			if(!data.elem.checked){
				selectids=selectids.replace(sv,"");
				sv="";
			}
			if(selectids!=""){
				$("#selectId").val(selectids+sv);
			}else{
				$("#selectId").val(sv);
			}
			selectids = $("#selectId").val();
			var selectidsHtml=getBackFieldsHtml(selectids);
			$("#selectIds_").html(selectidsHtml); 
			$("#selectId").val(selectids);
		});
	}

	
	
	
	var myValidform_
		$(document).ready(function(){
			InitValidform_("cgform");
		});
		
		function InitValidform_(formId) {
			myValidform_=$("#"+formId).Validform({
			tiptype:function(msg,o,cssctl){
				//msg：提示信息;
				//o:{obj:*,type:*,curform:*}, obj指向的是当前验证的表单元素（或表单对象），type指示提示的状态，值为1、2、3、4， 1：正在检测/提交数据，2：通过验证，3：验证失败，4：提示ignore状态, curform为当前form对象;
				//cssctl:内置的提示信息样式控制函数，该函数需传入两个参数：显示提示信息的对象 和 当前提示的状态（既形参o中的type）;
				if(!o.obj.is("form")){//验证表单元素时o.obj为该表单元素，全部验证通过提交表单时o.obj为该表单对象;
				var vl= $(o.obj).closest(".profile-user-info-striped").find(".Validforminfo");
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
					infohtml+="<div class='Validforminfo' style='display: block;position: absolute;left: 130px;top:-15px;z-index: 2;width:215px'>";
					infohtml+=objtiphtml;
					infohtml+="</div>";
					if(o.type==3){
						$(o.obj).closest(".profile-user-info-striped").append(infohtml);
					}
				//if(o.type==2){
					vl= $(o.obj).closest(".profile-user-info-striped").find(".Validforminfo");
					vl.fadeOut(2500);
				//}
				}
			}
		});
			//$.closeLoading_();//关闭加载窗口
		}
		
		function save_1_(){
			if(!myValidform_.check()){ return false; }
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
							var datas={group_id:$("#groupId").val()!='ABC'?$("#groupId").val():''};
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
		
		function selectFeildUrl(this1){
			var showType = $(this1).val();
			if(showType=='popup'||showType=='list'||showType=='radio'||showType=='checkbox'){
				$("#selectBack").show();
			}else{
				$("#fieldHref").val('');
				$("#selectBack").hide();
			}
		}
		function resetFeildUrl(this1){
			$("#dictField").val('');
			$("#dictText").val('');
			$("#selectId").val('');
		}
	</script>
</body>
</html>

<script type="text/javascript" src="designPlug-in/Validform/js/Validform_v5.3.2_min.js"></script>
<script src="designPlug-in/ace/assets/js/jquery.gritter.min.js"></script>
