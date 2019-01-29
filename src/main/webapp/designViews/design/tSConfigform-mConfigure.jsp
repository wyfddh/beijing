<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<!DOCTYPE html >
<html >
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线设计表单</title>

<t:base type="jquery,easyui,tools"></t:base>

<script type="text/javascript">
	function goSelectSysCode(thiz){
		$.dialog({
			lock : true,
			title:'字典类型选择', 
			content:'url:tSConfigformController.do?goSelectSysCode&id='+ thiz,
			height : 300,
			zIndex : zIndex,
			parent : dg
		});
	}
	
	function goSelectCulIndex(thiz){
		$.dialog({
			lock : true,
			title:'字典类型选择', 
			content:'url:tSConfigformController.do?goSelectCulIndex&id='+ thiz,
			height : 300,
			zIndex : zIndex,
			parent : dg
		});
	}
	

	$(document).ready(function(){
		$("#datagrid-htable").FrozenTable(1,0,0);
	});

	
	
</script>

<style type="text/css">


.datagrid-header td:hover,.datagrid-header-row td:hover {
	background: #EAF2FF;
}

.datagrid-header-row td,.datagrid-body td{
	text-align: center;
}

.datagrid-header-row td {
	border-width: 0 1px 1px 0;
	border-color: #208FDE;
}

.datagrid-body td {
	border-color: #208FDE;
}
.datagrid-header-row td {
	background: linear-gradient(to bottom, #E0ECFF 0, #abdce7 100%);
}
</style>

</head>
<body class="easyui-layout"  style="overflow-y: auto;" >
	<form formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="designController.do?save">
		<input id="id" name="id" type="hidden" value="${cgFormHeadPage.id}">
		<div region="center">
			<table class="datagrid-htable" id="datagrid-htable" cellpadding="0" cellspacing="0" width="100%">
				<thead class="datagrid-header" >
					<tr class="datagrid-header-row" height=100px >
						<td style="width:20px;">序号</td>
						<td style="width:120px;">字段名</td>
						<td style="width:120px;">数据类型</td>
						<td style="width:120px;">字段名</td>
						<td style="width:120px;">页面显示</td>
						<td style="width:40px;">表单明细</td>
						<td style="width:40px;">表单显示</td>
						<td style="width:40px;">表单隐藏</td>
						<td style="width:30px;">可编辑</td>
						<td style="width:20px;">必填</td>
						<td style="width:60px;">明细列表能否编辑</td>
						<!-- <td>对应指标</td> -->
						<td style="width:120px;">页面控件</td>
						<td style="width:40px;">列表隐藏</td>
						<td style="width:40px;">流程变量</td>
					</tr>
				</thead>
				<tbody class="datagrid-body">
					<c:if test="${not empty list }">
						<c:forEach items="${list }" var="map" varStatus="status">
							<tr>
							<td >${status.index+1}
							<input  type="hidden" name="columns[${status.index}].id" value="${map.id }">
							<input  type="hidden" name="columns[${status.index}].linkBussCode" value="${map.linkBussCode }">
							</td>
								<td  ><input style="width: 90%;"
									type="text" name="columns[${status.index}].fieldName"
									value="${map.fieldName}" readonly="readonly"></td>
								<td ><input 
								width="90%" <c:if test="${fn:startsWith(map.showType,'v_form')}"> style="display: none" </c:if>
									type="text" name="columns[${status.index}].type"
									value="${map.type}" readonly="readonly"></td>
								<td ><input style="width: 90%;"
									type="text" name="columns[${status.index}].fieldRemark"
									value="${map.fieldRemark }"></td>
								<td ><input style="width: 90%;"
									type="text" name="columns[${status.index}].content"
									value="${map.content }"></td>
								<td ><input type="checkbox"
								<c:if test="${fn:startsWith(map.showType,'v_form')}"> style="display: none" </c:if>
									name="columns[${status.index}].isShowList"
									${map.isShowList eq 'Y'?'checked':''}></td>
								<td ><input type="checkbox"
									name="columns[${status.index}].isShow"
									${map.isShow eq 'Y'?'checked':''}></td>
								<td  ><input type="checkbox"
								<c:if test="${fn:startsWith(map.showType,'v_form')}"> style="display: none" </c:if>
									name="columns[${status.index}].isFormHide"
									${map.isFormHide eq 'Y'?'checked':''}></td>
								<td  ><input type="checkbox"
								<c:if test="${fn:startsWith(map.showType,'v_form')}"> style="display: none" </c:if>
									name="columns[${status.index}].isEdit"
									${map.isEdit eq 'Y'?'checked':''}></td>
								<td  >
									<input type="checkbox" 
									<c:if test="${fn:startsWith(map.showType,'v_form')}"> style="display: none" </c:if>
									name="columns[${status.index}].isNotnull"
									${map.isNotnull eq 'Y'?'checked':''}>
								</td>
								<td  >
									<input type="checkbox" 
									<c:if test="${fn:startsWith(map.showType,'v_form')}"> style="display: none" </c:if>
									name="columns[${status.index}].isFormDetailEdit"
									${map.isFormDetailEdit eq 'Y'?'checked':''}>
								</td>
								<td >
									<select width="90%"
									<c:if test="${fn:startsWith(map.showType,'v_form')}"> style="display: none" </c:if>
									  name="columns[${status.index}].showType">
										<option ${map.showType eq 'text'?'selected':''} value="text">文本框</option>
										<option ${map.showType eq 'password'?'selected':''} value="password">密码框</option>
										<option ${map.showType eq 'radio'?'selected':''} value="radio">单选框</option>
										<option ${map.showType eq 'checkbox'?'selected':''} value="checkbox">多选框</option>
										<option ${map.showType eq 'year'?'selected':''} value="year">年份</option>
										<option ${map.showType eq 'yymm'?'selected':''} value="yymm">年月</option>
										<option ${map.showType eq 'date'?'selected':''} value="date">日期</option>
										<option ${map.showType eq 'time'?'selected':''} value="time">时分秒</option>
										<option ${map.showType eq 'datetime'?'selected':''} value="datetime">日期+时分秒</option>
										<option ${map.showType eq 'textarea'?'selected':''} value="textarea">大文本框</option>
										<option ${map.showType eq 'list'?'selected':''} value="list">下拉选择框</option>
										<option ${map.showType eq 'popup'?'selected':''} value="popup">弹出选择框</option>
										
										<c:if test="${fn:startsWith(map.showType,'v_form')}">
											<option ${map.showType eq 'v_formFile'?'selected':''} value="v_formFile">附件</option>
											<option ${map.showType eq 'v_formPic'?'selected':''} value="v_formPic">图片</option>
											<option ${map.showType eq 'v_formDetailed'?'selected':''} value="v_formDetailed">表单明细1</option>
											<option ${map.showType eq 'v_formButton'?'selected':''} value="v_formButton">按钮</option>
											<option ${map.showType eq 'v_formGroupingTitle'?'selected':''} value="v_formGroupingTitle">分组标题</option>
											<option ${map.showType eq 'v_formGroupButton'?'selected':''} value="v_formGroupButton">按钮组</option>
											<option ${map.showType eq 'v_formDescribeText'?'selected':''} value="v_formDescribeText">描述文字</option>
											<option ${map.showType eq 'v_formTitle'?'selected':''} value="v_formTitle">表单标题</option>
											<option ${map.showType eq 'v_formOffice'?'selected':''} value="v_formOffice">正文</option>
										</c:if>
									</select>	
								</td>
								
									<td ><input type="checkbox"
									<c:if test="${fn:startsWith(map.showType,'v_form')}"> style="display: none" </c:if>
									name="columns[${status.index}].isListHide" 
									${map.isListHide eq 'Y'?'checked':''}>
	
									</td>
									
									<td >
									<select width="90%" name="columns[${status.index}].isProcessVariables"
									<c:if test="${fn:startsWith(map.showType,'v_form')}"> style="display: none" </c:if>
									 >
										<option ${map.isProcessVariables eq ''?'selected':''} value="">不作为变量</option>
										<option ${map.isProcessVariables eq 'S'?'selected':''} value="S">String变量</option>
										<option ${map.isProcessVariables eq 'N'?'selected':''} value="N">Integer变量</option>
										<option ${map.isProcessVariables eq 'L'?'selected':''} value="L">Long变量</option>
										<option ${map.isProcessVariables eq 'D'?'selected':''} value="D">Date变量</option>
										<option ${map.isProcessVariables eq 'B'?'selected':''} value="B">Boolean变量</option>
									</select> 
									</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			<c:if test="${empty list }">
				<table
					style="background: #f5f9fa; width: 100%; height: 35px; margin-bottom: 3px; border: 1px solid #DDDDDD;">
					<tbody>
						<tr>
							<td align="center" style="width: 100%;">暂无数据</td>
						</tr>
					</tbody>
				</table>
			</c:if>
		</div>
	</form>
</body>
</html>
