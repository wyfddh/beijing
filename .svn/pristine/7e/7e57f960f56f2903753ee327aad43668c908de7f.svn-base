<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>表单自定义按钮</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body >
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="designController.do?saveButton">
	<input id="id" name="id" type="hidden" value="${designButtonPage.id }">
	<input id="formId" name="formId" type="hidden" value="${designButtonPage.formId }">
	<input id="defineCode" name="defineCode" type="hidden" value="${designButtonPage.defineCode }">
	<input id="buttonCode" name="buttonCode" type="hidden" value="${designButtonPage.buttonCode }">
	<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" style="width: 20%;"><label class="Validform_label"> 按钮名称 &nbsp;</label></td>
			<td class="value">&nbsp;<input class="inputxt" id="buttonName" name="buttonName" ignore="ignore" value="${designButtonPage.buttonName}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 按钮类型&nbsp; </label></td>
			<td class="value">&nbsp;<select class="inputxt" name="buttonType" id="buttonType">
				<option value="" >自定义</option>
				<%-- <option value="print" <c:if test="${designButtonPage.buttonType=='print'}">selected="selected"</c:if>>打印</option>
				<option value="taskInst" <c:if test="${designButtonPage.buttonType=='taskInst'}">selected="selected"</c:if>>办理记录</option>
				<option value="flowChart" <c:if test="${designButtonPage.buttonType=='flowChart'}">selected="selected"</c:if>>流程图</option>
				<option value="fileDow" <c:if test="${designButtonPage.buttonType=='fileDow'}">selected="selected"</c:if>>附件下载</option>
				<option value="wClose" <c:if test="${designButtonPage.buttonType=='wClose'}">selected="selected"</c:if>>关闭</option> --%>
			</select> <span class="Validform_checktip"></span></td>
		</tr>
		<%-- 
		<tr>
			<td align="right"><label class="Validform_label"> 按钮样式&nbsp; </label></td>
			<td class="value">&nbsp;<select class="inputxt" name="buttonStyle" id="buttonStyle">
				<option value="link" <c:if test="${designButtonPage.buttonStyle=='link'}">selected="selected"</c:if>>link</option>
				<option value="button" <c:if test="${designButtonPage.buttonStyle=='button'}">selected="selected"</c:if>>button</option>
			</select> <span class="Validform_checktip"></span></td>
		</tr> --%>
		<%-- <tr>
			<td align="right"><label class="Validform_label"> 动作类型&nbsp; </label></td>
			<td class="value">&nbsp;<select class="inputxt" name="optType" id="optType">
				<option value="js" <c:if test="${designButtonPage.optType=='js'}">selected="selected"</c:if>>js</option>
				<option value="action" <c:if test="${designButtonPage.optType=='action'}">selected="selected"</c:if>>action</option>
			</select> <span class="Validform_checktip"></span></td>
		</tr> --%>
		<tr>
			<td align="right"><label class="Validform_label"> 显示顺序 &nbsp;</label></td>
			<td class="value">&nbsp;<input class="inputxt" id="orderNum" name="orderNum" datatype="n" value="${designButtonPage.orderNum}"> <span class="Validform_checktip"></span></td>
		</tr>
		<%-- <tr>
			<td align="right"><label class="Validform_label"> 显示图标样式&nbsp; </label></td>
			<td class="value">&nbsp;
			<select class="inputxt" name="buttonIcon" id="buttonIcon">
			<option value="icon-save" <c:if test="${designButtonPage.buttonIcon=='icon-save'}">selected="selected"</c:if>>保存</option>
				<option value="icon-print" <c:if test="${designButtonPage.buttonIcon=='icon-print'}">selected="selected"</c:if>>打印</option>
				<option value="icon-tasks" <c:if test="${designButtonPage.buttonIcon=='icon-tasks'}">selected="selected"</c:if>>办理记录</option>
				<option value="icon-sitemap" <c:if test="${designButtonPage.buttonIcon=='icon-sitemap'}">selected="selected"</c:if>>流程图</option>
				<option value="icon-download-alt" <c:if test="${designButtonPage.buttonIcon=='icon-download-alt'}">selected="selected"</c:if>>附件下载</option>
				<option value="icon-remove-sign" <c:if test="${designButtonPage.buttonIcon=='icon-remove-sign'}">selected="selected"</c:if>>关闭</option>
			</select></td>
		</tr> --%>
		<%-- <tr>
			<td align="right"><label class="Validform_label"> 显示表达式&nbsp; </label></td>
			<td class="value">&nbsp;<input class="inputxt" id="exp" name="exp" ignore="ignore" value="${designButtonPage.exp}"> <span class="Validform_checktip"></span></td>
		</tr> --%>
		<tr>
			<td align="right"><label class="Validform_label"> 使用状态&nbsp; </label></td>
			<td class="value">&nbsp;<select name="buttonStatus" class="inputxt" id="buttonStatus">
				<option value="1" <c:if test="${designButtonPage.buttonStatus=='1'}">selected="selected"</c:if>>使用</option>
				<option value="0" <c:if test="${designButtonPage.buttonStatus=='0'}">selected="selected"</c:if>>禁用</option>
			</select> <span class="Validform_checktip"></span></td>
		</tr>
	</table>
</t:formvalid>
</body>
</html>