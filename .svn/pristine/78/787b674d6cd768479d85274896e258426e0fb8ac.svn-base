<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<%@include file="/designContext/unified.jsp"%>
<t:layuiTable name="tSBaseParameterList" pageSize="${cgformBuss.pageSize }" 
	pagination="${cgformBuss.isPage=='Y'?'true':'false' }"  initSort="${cgformBuss.initSort }" limits="${cgformBuss.limits }"
	tableTitleUrl="listPageGenController.do?getListTitle&bussCode=${bussCode }"
	tableQueryUrl="listPageGenController.do?getQueryList&bussCode=${bussCode }"
	tableDataUrl="listPageGenController.do?getListData&bussCode=${bussCode }&${initParameter }"
 	bussCode="${bussCode }" isCheckbox="${cgformBuss.isCheckbox=='Y'?'true':'false' }"
 	tableHeight="${cgformBuss.tableHeight}"
 	tableWidth="${cgformBuss.tableWidth}"
 	isIndex="${ cgformBuss.isIndex=='Y'?'true':'false' }" >
  <t:layuiButton title="录入" operationCode="addMain" icon="layui-btn layui-btn-normal addNews_btn" url="aceAutoController.do?modePage&type=page&releaseCode=${bussCode }" funname="addMain"></t:layuiButton>
  <t:layuiTableBar title="编辑" operationCode="edit" icon="layui-btn layui-btn-xs"   url="aceAutoController.do?modePage&type=page&releaseCode=${bussCode }" funname="updateMain"></t:layuiTableBar>
  <t:layuiTableBar title="删除" operationCode="del"  icon="layui-btn layui-btn-danger layui-btn-xs"   url="aceAutoController.do?doBatchDel&releaseCode=${bussCode }" funname="deleteSelect"></t:layuiTableBar>
  <t:layuiTableBar operationCode="detail" title="查看" icon="layui-btn layui-btn-primary layui-btn-xs"   url="aceAutoController.do?modePage&isDisabled=true&type=page&releaseCode=${bussCode }" funname="detail"></t:layuiTableBar>
</t:layuiTable>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript">
function refreshIframe(selectBusCode,busCode,mainId){
	$('#tSBaseParameterList_right_windows iframe').attr('src',"listPageGenController.do?goConfigDetailformList&mainId="+mainId+"&selectBusCode="+selectBusCode+"&bussCode="+busCode);
}
//新建-----------------------
function addMain(title, url, name, width, height,data) {
//     window.open(url, '_blank');
    var index = layui.layer.open({
	      title : "新建",
	      type : 2,
	      content : url,
		  area: ['90%', '90%'],
		  success : function(layero,index,data1){
		  		var body = layui.layer.getChildFrame('body', index);
		  		resizeLayer(index);
		  },
	      end :function() {
	    	  location.reload();
	      }
    });
}
//新建-----------------------
//修改-----------------------
function updateMain(title, url, name, width, height, data) {
	console.log(data);
//     window.open(url + "&mainId=" + data.id, "_blank");
    var index = layui.layer.open({
	      title : "修改",
	      type : 2,
	      content : url + "&mainId=" + data.id,
		  area: ['90%', '90%'],
		  success : function(layero,index,data1){
		  		var body = layui.layer.getChildFrame('body', index);
		  		resizeLayer(index);
		  },
	      end :function() {
	    	  location.reload();
	      }
  });
}
//修改-----------------------
//查看-----------------------
function detail(title, url, name, width, height, data) {
//     window.open(url + "&mainId=" + data.id, "_blank");
    var index = layui.layer.open({
	      title : "查看",
	      type : 2,
	      content : url + "&mainId=" + data.id,
		  area: ['90%', '90%'],
		  success : function(layero,index,data1){
		  		var body = layui.layer.getChildFrame('body', index);
		  		resizeLayer(index);
		  }
	});
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