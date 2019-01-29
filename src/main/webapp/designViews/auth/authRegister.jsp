<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@include file="/designContext/mytags.jsp"%>
<%
%>

<c:if test="${flag!='1'}">
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>授权注册</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src='designPlug-in/ace/assets/js/jquery-2.0.3.min.js'></script>
<!-- basic styles -->

<link rel="stylesheet" href="designPlug-in/ace/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="designPlug-in/ace/assets/css/font-awesome.min-plus.css" />
<link rel="stylesheet" href="designPlug-in/ace/assets/css/ace.min.css" />
<link rel="stylesheet" href="designPlug-in/ace/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="designPlug-in/ace/assets/css/ace-skins.min.css" />
<link id="easyuiTheme" rel="stylesheet" href="designPlug-in/easyui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="designPlug-in/easyui/themes/icon.css" type="text/css"></link>
<script src="designPlug-in/ace/assets/js/ace-extra.min.js"></script>
<link rel="stylesheet" href="designPlug-in/Validform/css/tablefrom/default.css" type="text/css"/>
</head>
<body >
</c:if>


	<div class="navbar navbar-default"  id="navbar">

	<div class="navbar-container" id="navbar-container">	
		<div class="navbar-header pull-left">
			<div  class="navbar-brand" style="margin-top:10px;color:#000000;">
				  <i class="icon-leaf"></i>
					在线表单设计组件-授权注册
			</div><!-- /.brand -->
		</div>
	</div>
</div>

<div class="main-container" id="main-container" align="center">
<form id="formobj" action="authController.do?authorization" name="formobj" method="post" enctype="multipart/form-data">
<input type="hidden" id="btn_sub" class="btn_sub"/>
<br>
<table style="width:80%;" cellpadding="0" cellspacing="1" class="formtable">
<tr>
	<td style="width:20%" align="right">
		<label class="Validform_label">
			注册码&nbsp;
		</label>
	</td>
	<td style="width:80%" class="value" >
		<input type="text" id="registerCode" name="registerCode" value="${registerCode }" style="width: 90%;" readonly="readonly"/>
	</td>
</tr>
<c:if test="${isLocalAuth}">
<tr style="display:none">
</c:if>
<c:if test="${!isLocalAuth}">
<tr style="display:none">
</c:if>
	<td style="width:20%" align="right">
		<label class="Validform_label">
			版本码&nbsp;
		</label>
	</td>
	<td style="width:80%" class="value" >
		<input type="text" id="registerModuleCode" name="registerCode" value="${registerModuleCode }" style="width: 90%;" readonly="readonly"/>
	</td>
</tr>
<tr style="display: none;">
	<td style="width:20%" align="right">
		<label class="Validform_label">
			授权码&nbsp;
		</label>
	</td>
	<td style="width:80%" class="value" >
		<textarea rows="8" cols="30" id="licenseCode" name="licenseCode" style="width: 90%;"></textarea>
	</td>
</tr>
<tr>
	<td style="width:20%" align="right">
		<label class="Validform_label">
			授权文件&nbsp;
		</label>
	</td>
	<td style="width:80%" class="value" >
		<input type="file" id="licenseFile" name="licenseFile" accept="lic" />
	</td>
</tr>

<c:if test="${isLocalAuth}">
<tr style="display:none">
</c:if>
<c:if test="${!isLocalAuth}">
<tr style="display:none">
</c:if>
	<td style="width:20%" align="right">
		<label class="Validform_label">
			版本文件&nbsp;
		</label>
	</td>
	<td style="width:80%" class="value" >
		<input type="file" id="moduleLicenseFile" name="moduleLicenseFile" accept="lic" />
	</td>
</tr>

<tr id="sub_tr">
	<td style="width:20%" align="right">
		<label class="Validform_label">
			&nbsp;
		</label>
	</td>
	<td style="width:80%" class="value" >
	<a href="#" class="easyui-linkbutton" icon="icon-add" onclick="subForm2()" plain="true">提交</a>
	</td>
</tr>
</table>
</form>
</div>

<c:if test="${flag!='1'}">
<script src="designPlug-in/ace/assets/js/bootstrap.min.js"></script>
<script src="designPlug-in/ace/assets/js/typeahead-bs2.min.js"></script>
<!-- page specific plugin scripts -->
<!-- ace scripts -->
<script src="designPlug-in/ace/assets/js/ace-elements.min.js"></script>
<script src="designPlug-in/ace/assets/js/ace.min.js"></script>
<!-- inline scripts related to this page -->
<script src="designPlug-in/ace/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="designPlug-in/ace/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="designPlug-in/ace/assets/js/jquery.slimscroll.min.js"></script>
<script src="designPlug-in/ace/assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="designPlug-in/ace/assets/js/jquery.sparkline.min.js"></script>

</body>
</html>
</c:if>
<script type="text/javascript">
if("${flag}"=="1"){
	window.location.replace('authController.do?register');
}
$("#btn_sub").click(function(){
	subForm2();
});
function subForm2(){
	var filePath = $("#licenseFile").val();
	if(filePath){

		var i = filePath.lastIndexOf('.');
		var len = filePath.length;
		var str = filePath.substring(len,i+1);
		
		var extName = "LIC";
		if(extName.indexOf(str.toUpperCase()) < 0)  {     
			tip("限lic文件格式!"); 
		 	return ;
		}
    	formobj.submit();
	}else{
    	tip("请选择授权文件");
    	return false;
	}
	
}


<c:if test="${!empty result}">
var resultSuccess = ${result.success};
var msg = "${result.msg}";
if(resultSuccess){
		window.location.href="<%= request.getContextPath( )%>";
}else{
	alert(msg);
}
</c:if>
</script>

