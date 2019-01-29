<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<!DOCTYPE html >
<html >
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<t:base type="jquery,easyui,DatePicker,layer"></t:base>
<link rel="stylesheet" href="designPlug-in/Validform/css/tablefrom.css" type="text/css">
</head>
<body>
		<table  style="border-spacing: 1px;border-collapse: inherit;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<th style="width:20%;" align="center">函数内容</th>
				<th  align="center">详细信息</th>
			</tr>
			<tr>
				<td  align="right">保存&nbsp;</td>
				<td align="left" class="value">&nbsp;$.saveData(true);//参数true表示是否刷新当前页面。</td>
			</tr>
			<tr>
				<td align="right">执行父页面保存&nbsp;</td>
				<td align="left" class="value">&nbsp;parent.$.saveData(true);//参数true表示是否刷新当前页面。</td>
			</tr>
			<tr>
				<td align="right">提交审批流程&nbsp;</td>
				<td align="left" class="value">&nbsp;$.submitBusiness();</td>
			</tr>
			<tr>
				<td align="right">关闭页面&nbsp;</td>
				<td align="left" class="value">&nbsp;window.close();</td>
			</tr>
		</table>
</body>
</html>
<script type="text/javascript">
$(function() {
	parent.$("#js_help").height($("body").height());
});
</script>



	