<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<%@include file="/designContext/unified.jsp"%>
<t:layuiTable name="tSBaseParameterList" pageSize="${cgformBuss.pageSize }" 
	pagination="${cgformBuss.isPage=='Y'?'true':'false' }"  initSort="${cgformBuss.initSort }" limits="${cgformBuss.limits }"
	tableTitleUrl="listPageGenNoticeController.do?getListTitle&bussCode=${bussCode }"
	tableQueryUrl="listPageGenNoticeController.do?getQueryList&bussCode=${bussCode }"
	tableDataUrl="listPageGenNoticeController.do?getListData&bussCode=${bussCode }&noticeId=${noticeId }&${initParameter }"
 	bussCode="${bussCode }" isCheckbox="${cgformBuss.isCheckbox=='Y'?'true':'false' }"
 	tableHeight="${cgformBuss.tableHeight}"
 	tableWidth="${cgformBuss.tableWidth}"
 	isIndex="${ cgformBuss.isIndex=='Y'?'true':'false' }" >
  <t:layuiTableBar operationCode="detail" title="查看" icon="layui-btn layui-btn-primary layui-btn-xs"   url="aceAutoController.do?modePage&isDisabled=true&type=page&releaseCode=${bussCode }" funname="detail"></t:layuiTableBar>
</t:layuiTable>

<script type="text/javascript">
function refreshIframe(selectBusCode,busCode,mainId){
	$('#tSBaseParameterList_right_windows iframe').attr('src',"listPageGenNoticeController.do?goConfigDetailformList&mainId="+mainId+"&selectBusCode="+selectBusCode+"&bussCode="+busCode);
}
//新建-----------------------
function addMain(title, url, name, width, height,data) {
    window.open(url, '_blank');
}
//新建-----------------------
//修改-----------------------
function updateMain(title, url, name, width, height, data) {
	console.log(data);
    window.open(url + "&mainId=" + data.id, "_blank");
}
//修改-----------------------
//查看-----------------------
function detail(title, url, name, width, height, data) {
    window.open(url + "&mainId=" + data.id, "_blank");
}
//查看-----------------------

//删除-----------------------
    function deleteSelect(title, url, name, width, height, data) {
        myConfirmDialog('您确定要删除吗？', function() {
            $.getJSON(url, {
                id: data.id
            }, function(resultData) {
                layer.msg('删除成功！', {
                    icon: 1
                });
                layuiTableReload("${bussCode }",getQueryData_${bussCode }());
                return true;
            });
        }, function() {
            return true;
        }, '');
    }

</script>