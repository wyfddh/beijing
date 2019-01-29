<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<%@include file="/designContext/unified.jsp"%>
<t:layuiTable name="tSBaseParameterList" pageSize="${cgformBuss.pageSize }" 
	pagination="${cgformBuss.isPage=='Y'?'true':'false' }"  initSort="${cgformBuss.initSort }" limits="${cgformBuss.limits }"
	tableTitleUrl="listPageGenController.do?getListTitle&bussCode=${bussCode }"
	tableQueryUrl="listPageGenController.do?getQueryList&bussCode=${bussCode }"
	tableDataUrl="listPageGenController.do?getListData&bussCode=${bussCode }"
 	bussCode="${bussCode }" isCheckbox="${cgformBuss.isCheckbox=='Y'?'true':'false' }"
 	isIndex="${ cgformBuss.isIndex=='Y'?'true':'false' }"
 	onLoadSuccess="reloadData" >
  <t:layuiButton title="录入" operationCode="addMain" icon="layui-btn layui-btn-normal addNews_btn" url="aceAutoController.do?modePage&type=page&releaseCode=${bussCode }" funname="addMain"></t:layuiButton>
  <t:layuiTableBar title="编辑" exp="status#eq#0" operationCode="edit" icon="layui-btn layui-btn-xs"   url="aceAutoController.do?modePage&type=page&releaseCode=${bussCode }" funname="updateMain"></t:layuiTableBar>
  <t:layuiTableBar title="编辑表单" exp="status#eq#0" operationCode="editDefine" icon="layui-btn layui-btn-xs"   url="aceAutoController.do?modePage&type=page&releaseCode=${bussCode }" funname="editDefine"></t:layuiTableBar>
  <t:layuiTableBar title="发布" exp="status#eq#0" operationCode="goRelease"  icon="layui-btn layui-btn-danger layui-btn-xs"   url="aceAutoController.do?doBatchDel&releaseCode=${bussCode }" funname="goRelease"></t:layuiTableBar>
  <t:layuiTableBar title="取消发布" exp="status#eq#1" operationCode="goCancelRelease"  icon="layui-btn layui-btn-danger layui-btn-xs"   url="aceAutoController.do?doBatchDel&releaseCode=${bussCode }" funname="goCancelRelease"></t:layuiTableBar>
  <t:layuiTableBar title="删除" exp="status#eq#0" operationCode="del"  icon="layui-btn layui-btn-danger layui-btn-xs"   url="aceAutoController.do?doBatchDel&releaseCode=${bussCode }" funname="deleteSelect"></t:layuiTableBar>
  <%-- <t:layuiTableBar operationCode="detail" title="查看" icon="layui-btn layui-btn-primary layui-btn-xs"   url="aceAutoController.do?modePage&isDisabled=true&type=page&releaseCode=${bussCode }" funname="detail"></t:layuiTableBar> --%>
</t:layuiTable>

<script type="text/javascript">
function reloadData(){
	$("[data-field='is_index']").children().each(function(){
	    if($(this).text() == 'Y'){
	        $(this).text("是");
	    }else if($(this).text() == 'N'){
	         $(this).text("否");
		}
	});
	$("[data-field='status']").children().each(function(){
	    if($(this).text() == '0'){
	        $(this).text("未发布");
	    }else if($(this).text() == '1'){
	         $(this).text("已发布");
		}
	});
	$("[data-field='is_page']").children().each(function(){
		if($(this).text() == 'Y'){
	        $(this).text("是");
	    }else if($(this).text() == 'N'){
	         $(this).text("否");
		}
	});
}

function jumpPage(url,pageTitle){
	layer.open({
		  type: 2,
		  title: pageTitle,
		  shadeClose: false,//点击背景不关闭
		  scrollbar: false,//滚动条已锁
		  resize:true,//是否允许放大缩小
		  content: url,
		  area: ['70%', '90%'],
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
	jumpPage("cgformBussController.do?goAdd&bussCode=${bussCode }","新增业务类型");
}
//新建-----------------------
//修改-----------------------
function updateMain(title, url, name, width, height, data) {
	if(data.status=="1"){
		layer.msg("已发布的业务不能进行修改！", {icon: 5});
		return true;
	}
	jumpPage("cgformBussController.do?goUpdate&bussCode=${bussCode }&id="+data.id,"编辑业务类型");
}
//修改-----------------------
//查看-----------------------
function detail(title, url, name, width, height, data) {
	window.open(url + "&id=" + data.id, "_blank");
}
//查看-----------------------

function editDefine(title, url, name, width, height, data){
	var winHandler = window.open("","_blank");
	$.ajax({
		async: false,
		url: "<%=path %>/cgformDefineController.do?getDefine",
		type: "POST",dataType: "json",//async: false,
		data: {bussId:data.id},
		success: function(data) {
			if(data!=null){
				var returnMsg = data.obj;
				//if(data.success){
					winHandler.location.href = "designController.do?design&type="+returnMsg.split(",")[1]+"&businessCode="+returnMsg.split(",")[0];
				//}else{
				//	winHandler.location.href = "designController.do?designPreviewHtml&defineId="+returnMsg.split(",")[2]+"&businessCode="+returnMsg.split(",")[0]
					//winHandler.close();
				//}
			}
		}
	});
}

//删除-----------------------
    function deleteSelect(title, url, name, width, height, data) {
    	if(data.status=="1"){
			layer.msg("已发布的业务不能删除！", {icon: 5});
    		return true;
		}
		myConfirmDialog("您确定要删除吗？", function(){
		$.ajax({
			url: "cgformBussController.do?doBatchDel",
			type: "POST",dataType: "json",//async: false,
			data: {ids: data.id},
			success: function(data) {
				if(data!=null){
					if(!data.success){
						layer.msg(data.msg, {icon: 5});
					}else{
						layer.msg(data.msg, {icon: 1});
						layuiTableReload("${bussCode }",{});
					}
					
					return true;
				}
			}
		});
		}, function(){ return true; }, "");
    }
    function goRelease(title, url, name, width, height, data){
		if(data.status=="1"){
			layer.msg("已发布的业务不可再次发布！", {icon: 5});
    		return true;
		}
		myConfirmDialog("已发布业务将不能进行修改，您确定要发布操作吗？", function(){
			$.ajax({
				url: "cgformBussController.do?doRelease",
				type: "POST",dataType: "json",//async: false,
				data: {id: data.id,status:1},
				success: function(data) {
					if(data!=null){
						if(data.success){
							layer.msg("发布成功", {icon: 1});
							layuiTableReload("${bussCode }",{});
						}else{
							layer.msg(data.msg!="发布失败"?data.msg:"发布失败", {icon: 5});
						}
						return true;
					}
				}
			});
			}, function(){ return true; }, "");
	}
	 function goCancelRelease(title, url, name, width, height, data){
		if(data.status!="1"){
			layer.msg("未发布的业务不可取消发布！", {icon: 5});
    		return true;
		}
		myConfirmDialog("您确定要取消发布操作吗？", function(){
			$.ajax({
				url: "cgformBussController.do?doRelease",
				type: "POST",dataType: "json",//async: false,
				data: {id: data.id,status:0},
				success: function(data) {
					if(data!=null){
						if(data.success){
							layer.msg("取消发布成功", {icon: 1});
							layuiTableReload("${bussCode }",{});
						}else{
							layer.msg("取消发布失败", {icon: 5});
						}
						return true;
					}
				}
			});
			}, function(){ return true; }, "");
	}
</script>