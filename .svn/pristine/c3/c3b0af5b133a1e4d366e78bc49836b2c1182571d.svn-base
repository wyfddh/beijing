<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<%@include file="/designContext/unified.jsp"%>
<t:layuiTable name="tSBaseParameterList" pageSize="${cgformBuss.pageSize }" 
	pagination="${cgformBuss.isPage=='Y'?'true':'false' }"  initSort="${cgformBuss.initSort }" limits="${cgformBuss.limits }"
	tableTitleUrl="listPageGenController.do?getListTitle&bussCode=${bussCode }"
	tableQueryUrl="listPageGenController.do?getQueryList&bussCode=${bussCode }"
	tableDataUrl="listPageGenController.do?getListData&bussCode=${bussCode }&${initParameter }"
 	bussCode="${bussCode }" isCheckbox="${cgformBuss.isCheckbox=='Y'?'true':'false' }"
 	isIndex="${ cgformBuss.isIndex=='Y'?'true':'false' }"
 	onLoadSuccess="reloadData" >
  <c:if test="${initParameter_buss_type!='3'&&initParameter_buss_type!='4' }">
  <t:layuiButton title="创建表单" operationCode="addMain" icon="layui-btn layui-btn-normal addNews_btn" url="aceAutoController.do?modePage&type=page&releaseCode=${bussCode }" funname="addMain"></t:layuiButton>
  </c:if>
  <t:layuiTableBar title="编辑"  exp="status#eq#0" operationCode="edit" icon="layui-btn layui-btn-xs"   url="aceAutoController.do?modePage&type=page&releaseCode=${bussCode }" funname="updateMain"></t:layuiTableBar>
  <c:if test="${initParameter_buss_type!='3'&&initParameter_buss_type!='4' }">
  <t:layuiTableBar title="启用"  exp="status#eq#0" operationCode="goRelease"  icon="layui-btn layui-btn-danger layui-btn-xs"   url="aceAutoController.do?doBatchDel&releaseCode=${bussCode }" funname="goRelease"></t:layuiTableBar>
  <t:layuiTableBar title="注销"  exp="status#eq#1" operationCode="goCancelRelease"  icon="layui-btn layui-btn-danger layui-btn-xs"   url="aceAutoController.do?doBatchDel&releaseCode=${bussCode }" funname="goCancelRelease"></t:layuiTableBar>
  <t:layuiTableBar title="删除"  exp="status#eq#0" operationCode="del"  icon="layui-btn layui-btn-danger layui-btn-xs"   url="aceAutoController.do?doBatchDel&releaseCode=${bussCode }" funname="deleteSelect"></t:layuiTableBar>
  </c:if>
  <%-- <t:layuiTableBar operationCode="detail" title="查看" icon="layui-btn layui-btn-primary layui-btn-xs"   url="aceAutoController.do?modePage&isDisabled=true&type=page&releaseCode=${bussCode }" funname="detail"></t:layuiTableBar> --%>
</t:layuiTable>

<script type="text/javascript">
function reloadData(){
	$("[data-field='buss_type']").children().each(function(){
	    if($(this).text() == '1'){
	        $(this).text("业务表单");
	    }else if($(this).text() == '2'){
	         $(this).text("非业务表单");
		}
	    else if($(this).text() == '3'){
	         $(this).text("系统表单");
		}
	});
	$("[data-field='status']").children().each(function(){
	    if($(this).text() == '0'){
	        $(this).text("未启用");
	    }else if($(this).text() == '1'){
	         $(this).text("已启用");
		}
	});
	$("[data-field='save_type']").children().each(function(){
	    if($(this).text() == '1'){
	        $(this).text("建表存储");
	    }else if($(this).text() == '2'){
	         $(this).text("键值存储");
		}
	});
	$("[data-field='type']").children().each(function(){
	    if($(this).text() == '1'){
	        $(this).text("研究");
	    }else if($(this).text() == '2'){
	         $(this).text("藏品");
		}else if($(this).text() == '3'){
	         $(this).text("展览");
		}else if($(this).text() == '4'){
	         $(this).text("教育");
		}
	});
}

function jumpPage(url,pageTitle){
	console.log(url);
	layer.open({
		  type: 2,
		  title: pageTitle,
		  shadeClose: false,//点击背景不关闭
		  scrollbar: false,//滚动条已锁
		  resize:true,//是否允许放大缩小
		  content: url,
		  area: ['50%', '60%'],
		  maxmin: true,
		  cancel: function(index){
			  layer.confirm('确定要关闭吗？', {
				  icon: 3,
				  btn: ['确定','取消'] //按钮
			  }, function(){
				  layer.close(index);
				  layer.closeAll('dialog');
			  }, function(){
				  return;
			  });
			  return false;
		  }
	});
}
//新建-----------------------
function addMain(title, url, name, width, height,data) {
	jumpPage("<%=path %>/cgformDefineController.do?goAdd&bussCode=${bussCode }&type=${initParameter_buss_type}","新增业务表单");
}
//新建-----------------------
//修改-----------------------
function updateMain(title, url, name, width, height, data) {
	if(data.status=="1"){
		layer.msg("已启用的业务不能进行修改！", {icon: 5});
		return true;
	}
	jumpPage("<%=path %>/cgformDefineController.do?goUpdate&bussCode=${bussCode }&type=${initParameter_buss_type}&id="+data.id,"编辑业务表单");
}
//修改-----------------------
//查看-----------------------
function detail(title, url, name, width, height, data) {
    window.open(url + "&id=" + data.id, "_blank");
}
//查看-----------------------

//删除-----------------------
    function deleteSelect(title, url, name, width, height, data) {
    	if(data.status=="1"){
			layer.msg("已启用的业务不能删除！", {icon: 5});
    		return true;
		}
		myConfirmDialog("您确定要删除吗？", function(){
		$.ajax({
			url: "cgformDefineController.do?doBatchDel",
			type: "POST",dataType: "json",//async: false,
			data: {ids: data.id},
			success: function(data) {
				if(data!=null){
					layer.msg(data.msg, {icon: 1});
					layuiTableReload("${bussCode }",{});
					return true;
				}
			}
		});
		}, function(){ return true; }, "");
    }
    function goRelease(title, url, name, width, height, data){
		if(data.status=="1"){
			layer.msg("已启用的业务不可再次启用！", {icon: 5});
    		return true;
		}
		myConfirmDialog("已启用业务将不能进行修改，您确定要启用操作吗？", function(){
			$.ajax({
				url: "cgformDefineController.do?doRelease",
				type: "POST",dataType: "json",//async: false,
				data: {id: data.id,status:1},
				success: function(data) {
					if(data!=null){
						if(data.success){
							layer.msg("启用成功", {icon: 1});
							layuiTableReload("${bussCode }",{});
						}else{
							layer.msg(data.msg!="启用失败"?data.msg:"启用失败", {icon: 5});
						}
						return true;
					}
				}
			});
			}, function(){ return true; }, "");
	}
	 function goCancelRelease(title, url, name, width, height, data){
		if(data.status!="1"){
			layer.msg("未启用的业务不可注销！", {icon: 5});
    		return true;
		}
		myConfirmDialog("您确定要注销操作吗？", function(){
			$.ajax({
				url: "cgformDefineController.do?doRelease",
				type: "POST",dataType: "json",//async: false,
				data: {id: data.id,status:0},
				success: function(data) {
					if(data!=null){
						if(data.success){
							layer.msg("注销成功", {icon: 1});
							layuiTableReload("${bussCode }",{});
						}else{
							layer.msg(data.msg, {icon: 5});
						}
						return true;
					}
				}
			});
			}, function(){ return true; }, "");
	}
</script>