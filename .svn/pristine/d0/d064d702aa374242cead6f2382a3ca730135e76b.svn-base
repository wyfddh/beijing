<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>表单自定义按钮</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body >
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="designController.do?saveTab">
	<input id="id" name="id" type="hidden" value="${designTabPage.id }">
	<input id="formId" name="formId" type="hidden" value="${designTabPage.formId }">
	<input id="defineCode" name="defineCode" type="hidden" value="${designTabPage.defineCode }">
	<input id="tabCode" name="tabCode" type="hidden" value="${designTabPage.tabCode }">
	<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right"><label class="Validform_label"> 页签名称 &nbsp;</label></td>
			<td class="value">&nbsp;<input class="inputxt" id="tabName" name="tabName" ignore="ignore" value="${designTabPage.tabName}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 关联业务编码 &nbsp;</label></td>
			<td class="value">&nbsp;<input class="inputxt" id="linkBussCode" name="linkBussCode" ignore="ignore" value="${designTabPage.linkBussCode}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 关联主表字段 &nbsp;</label></td>
			<td class="value">&nbsp;<input class="inputxt" id="mainField" name="mainField" ignore="ignore" value="${designTabPage.mainField}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 明细表字段 &nbsp;</label></td>
			<td class="value">&nbsp;<input class="inputxt" id="detailField" name="detailField" ignore="ignore" value="${designTabPage.detailField}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 显示图标样式&nbsp; </label></td>
			<td class="value">&nbsp;
			<select class="inputxt" name="tabIcon" id="tabIcon">
			<option value="icon-save" <c:if test="${designTabPage.tabIcon=='icon-save'}">selected="selected"</c:if>>保存</option>
				<option value="icon-print" <c:if test="${designTabPage.tabIcon=='icon-print'}">selected="selected"</c:if>>打印</option>
				<option value="icon-tasks" <c:if test="${designTabPage.tabIcon=='icon-tasks'}">selected="selected"</c:if>>办理记录</option>
				<option value="icon-sitemap" <c:if test="${designTabPage.tabIcon=='icon-sitemap'}">selected="selected"</c:if>>流程图</option>
				<option value="icon-download-alt" <c:if test="${designTabPage.tabIcon=='icon-download-alt'}">selected="selected"</c:if>>附件下载</option>
				<option value="icon-remove-sign" <c:if test="${designTabPage.tabIcon=='icon-remove-sign'}">selected="selected"</c:if>>关闭</option>
			</select></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 显示顺序 &nbsp;</label></td>
			<td class="value">&nbsp;<input class="inputxt" id="orderNum" name="orderNum" datatype="n" value="${designTabPage.orderNum}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 使用状态&nbsp; </label></td>
			<td class="value">&nbsp;<select name="tabStatus" class="inputxt" id="tabStatus">
				<option value="0" <c:if test="${designTabPage.tabStatus=='0'}">selected="selected"</c:if>>禁用</option>
				<option value="1" <c:if test="${designTabPage.tabStatus=='1'}">selected="selected"</c:if>>使用</option>
			</select> <span class="Validform_checktip"></span></td>
		</tr>
	</table>
</t:formvalid>
</body>
</html>