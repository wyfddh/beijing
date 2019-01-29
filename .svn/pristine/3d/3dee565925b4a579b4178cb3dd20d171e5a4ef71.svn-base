<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>

<!DOCTYPE html>
<html>
 <head>
  <t:base type="jquery,easyui,tools"></t:base>
    <script type="text/javascript" src="designPlug-in/layer/layer.js"></script>
    <script type="text/javascript" src="designPlug-in/layui/layui.js"></script>
    <style type="text/css">
    .datagrid-header, .datagrid-toolbar, .datagrid-pager, .datagrid-footer-inner {
    border-color: #eeeeee;
}
.datagrid-row-selected {
    background: #eeeeee;
}
.datagrid-header, .datagrid-td-rownumber {
   background-color: #f8f8f8;
        background: #f8f8f8;
    }
.datagrid-header td, .datagrid-body td, .datagrid-footer td {
    border-color: #b0afb0;
}
.panel-header, .panel-body {
    border-color: #eeeeee;
}
.datagrid-row-over, .datagrid-header td.datagrid-header-over {
    background: #f3f3f3;
}
    
    </style>
    </head>
 <body class="easyui-layout" >
 <div region="center" style="padding: 1px;">
<table class="easyui-datagrid" id="select_data_${sCode }" fit="true" rownumbers="true"
fitColumns="true"
    data-options="url:'editPageGenController.do?getSelectData&sCode=${sCode }',
    singleSelect:true,
    pagination:false,
    singleSelect:true">
    <thead>
		<tr>
		<c:if test="${not empty fieldList }">
			<c:forEach items="${fieldList }" var="map" varStatus="status">
				<th data-options="field:'${map.field_code }',
				hidden:${map.is_hide eq 'Y'?'true':'false'},
				width:${map.field_width eq ''||map.field_width eq null?'50':map.field_width}">${map.field_name}</th>
			</c:forEach>
		</c:if>
		</tr>
    </thead>
</table>
</div>
</body>
 <script type="text/javascript">
 
 function backDataToPage(){
	 var rowsData = $('#select_data_${sCode }').datagrid('getSelections');
	 if (!rowsData || rowsData.length==0) {
		 layer.msg('请选择一条数据',{icon: 4});
			return;
		}
	 if("${inputId}"!=""&&"${selectId}"!=""){
		 if("${inputId}".split(",").length=="${selectId}".split(",").length){
			 var l="${inputId}".split(",");
			 var s="${selectId}".split(",");
			 for(var i=0;i<l.length;i++){
				 try{
					 parent.document.getElementById(l[i]).value = rowsData[0][s[i]];
				 }catch(e){}
			 }
		 }else{
			 layer.msg('参数配置错误，inputId和selectId参数个数必须相等',{icon: 4});
			 return;
		 }
	 }else{
		 layer.msg('参数配置错误，inputId和selectId参数不能为空',{icon: 4});
		 return;
	 }
 }
 
 </script>