<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="plug-in/ace/assets/js/jquery.min.js"></script>
<script src="plug-in/layer/layer.js"></script>
<script src="plug-in/layer/extend/layer.ext.js"></script>
<script src="plug-in/laypage/laypage.js"></script>
<!-- basic styles -->
<link href="plug-in/ace/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="plug-in/ace/assets/css/font-awesome.min.css" />
<!-- ace styles -->
<link rel="stylesheet" href="plug-in/ace/assets/css/font-awesome.min-plus.css" />
<link rel="stylesheet" href="plug-in/ace/assets/css/ace.min.css" />
<link rel="stylesheet" href="plug-in/ace/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="plug-in/ace/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="plug-in/ace/assets/css/fullcalendar.css" />
<link rel="stylesheet" href="plug-in/ace/assets/css/ace-rtl.min.css" />
<script src="plug-in/ace/assets/js/ace-extra.min.js"></script>
<link rel="stylesheet" type="text/css" href="plug-in/ace/assets/css/Outbound.css">
<link rel="stylesheet" type="text/css" href="plug-in/ace/assets/css/indexmove.css"/>
<script type="text/javascript">
function refreshIframe(selectBusCode,busCode){
	parent.refreshIframe(selectBusCode,busCode,"${mainId}");
}
</script>
</head>
<body  >
<table  style="width: 100%;">
<tr>
<c:if test="${fn:length(tSConfigformList_)>0 }">
<td style="width: 10px;" align="center"  valign="top">
<div class="afw-cen-left" style="width: 100%;">
	<ul class="tab" style="padding-left: 0px;">
	<c:forEach items="${tSConfigformList_}" var="poVal" varStatus="stuts">
		<li id="jcTabLi" 
		<c:if test="${selectBusCode==poVal.busCode }">class="cur-a"</c:if>
		<c:if test="${selectBusCode!=poVal.busCode }">class="cur-a cur"</c:if>
		 onclick="refreshIframe('${poVal.busCode}','${bussCode }');">
			<a href="javaScript:void(0)">${poVal.busName}</a>
		</li>
	</c:forEach>
	</ul>
</div>
</td>
</c:if>
<td nowrap  align="center"  valign="top">
<t:configform name="tSDetailList" pageSize="10"  pagination="true" listStyle="db"
 linkBussCode="${linkBussCode }" bussCode="${bussCode }" versions="${versions }" 
 mainId="${mainId }" configformId="${configformId }">
  <%-- 
  <t:cfToolBar title="录入" icon="icon-add" url="aceAutoController.do?modePage&type=page&configformId=${configformId}&bussCode=${linkBussCode }&versions=${versions }" funname="addMain"></t:cfToolBar>
  <t:cfToolBar title="编辑" icon="icon-edit" filterStatus="status|01|草稿状态不允许删除,status|02|已提交的状态不允许提交"  url="aceAutoController.do?modePage&type=page&versions=${versions }&configformId=${configformId}&bussCode=${linkBussCode }" funname="updateMain"></t:cfToolBar>
  <t:cfToolBar title="删除"  icon="icon-remove" filterStatus="status|01|草稿状态不允许删除,status|02|已提交的状态不允许提交"  url="aceAutoController.do?doBatchDel&bussCode=${linkBussCode }" funname="deleteSelect"></t:cfToolBar>
  <t:cfToolBar title="提交"  icon="icon-remove" filterStatus="status|01|草稿状态不允许删除,status|02|已提交的状态不允许提交"  url="aceAutoController.do?submitMainByBusiness&bussCode=${linkBussCode }" funname="submitMainByBusiness"></t:cfToolBar>
  <t:cfToolBar title="查看" icon="icon-search" filterStatus="status|01|草稿状态不允许删除,status|02|已提交的状态不允许提交"  url="aceAutoController.do?modePage&isDisabled=true&type=page&configformId=${configformId}&bussCode=${linkBussCode }&versions=${versions }" funname="detail"></t:cfToolBar>
 --%>
</t:configform>
</td>
</tr>


</table>
</body>
