<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/public.css"/>
<style type="text/css">
	.textHidden{max-width:70%; white-space:nowrap;overflow:hidden;text-overflow:ellipsis; }
</style>
<title>通知公告-详情预览</title>
</head>
<body style="background:#fff;padding:10px">
<form class="layui-form" id="newForm">
	<input type="hidden" id="id" name="id" value="${notice.id }">
	<div class="layui-col-xs8" style="padding-right: 20px;">
		<div class="layui-card-header layui-row layui-col-xs12" style="text-align: center;">
			<label><b>${notice.title }</b></label>
		</div>
		<div class="layui-card-body layui-row layui-col-xs12">
			${notice.content }
		</div>
	</div>
	<div class="layui-col-xs4" style="padding-left: 20px;">
		<div class="layui-form-item layui-row layui-col-xs12">
			<label><b>发布对象</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<button type="button" id="btn_selectReceive" class="layui-btn layui-btn-radius layui-btn-primary"></button>
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12" style="margin-top: 30px;">
			<label><b>附件</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<div id="showFile"></div>
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12" style="margin-top: 30px;">
			<label><b>填报信息</b></label>
		</div>
		<c:if test="${notice.isfeedback == 1 }">
			<div class="layui-form-item layui-row layui-col-xs12 iswrite" style="vertical-align:middle;">
				<c:if test="${empty notice.reportCode }" var="reportCodeIsNull">
					<a class="layui-btn layui-btn-radius layui-btn-primary" href="javascript:void(0);"><i class="layui-icon">&#xe63c;</i>无</a>
				</c:if>
				<c:if test="${!reportCodeIsNull }">
					<a class="layui-btn layui-btn-radius layui-btn-primary" href="javascript:goViewReport('${notice.defineId }', '${notice.defineCode }');"><i class="layui-icon">&#xe63c;</i>${notice.reportName }</a>
				</c:if>
			</div>
			<c:if test="${not empty notice.deadlineTime }">
				<div class="layui-form-item layui-row layui-col-xs12 iswrite" style="vertical-align:middle;">
					<a id="lastUpdateTime" class="layui-btn layui-btn-radius layui-btn-primary">
						<i class="layui-icon">&#xe637;</i>填报截止时间: <fmt:formatDate value='${notice.deadlineTime }' pattern='yyyy-MM-dd HH:mm' />
					</a>
				</div>
				<div class="layui-form-item layui-row layui-col-xs12 iswrite" style="vertical-align:middle;">
					<a id="lastUpdateTime" class="layui-btn layui-btn-radius layui-btn-primary">
						<i class="layui-icon">&#xe715;</i>超过截止时间是否允许继续填报: <c:if test="${notice.isfill == 1 }" var="isfill">是</c:if><c:if test="${!isfill }">否</c:if>
					</a>
				</div>
			</c:if>
		</c:if>
	</div>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript">
//接收单位
var sel_receive = [];
//附件
var uploads = [];

layui.use(['form','layer','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    	laydate = layui.laydate;
	
	//刷新文件显示
	window.refreshFile = function(){
		//清空showFile中的html
		$("#showFile").html("");
		//循环插入文件显示
		for (var i = 0; i < uploads.length; i++) {
			if(uploads[i].isjunk == 0 || uploads[i].isjunk == '0'){
				$("#showFile").append('<button type="button" title="下载附件" class="layui-btn layui-btn-radius layui-btn-primary textHidden" onclick="downFile(\''+uploads[i].resultPath+'\',\''+uploads[i].realFileName+'\')"><i class="layui-icon">&#xe66e;</i>'+uploads[i].realFileName+'</button>');
			}
		}
		form.render();
	}
	
	//刷新接收单位
	var receiveString = '${receiveOrgs }';
	if(receiveString != ''){
		sel_receive = receiveString.split(",");
		setSelReceive(sel_receive);
		console.log(sel_receive);
	}
	
	//刷新文件显示
	var uploadsJsonString = '${uploads }';
	if(uploadsJsonString != ''){
		console.log(uploadsJsonString);
		uploads = JSON.parse(uploadsJsonString);
		refreshFile();
		console.log(uploads);
	}
})

//设置接收单位的值
function setSelReceive(value){
	sel_receive = value;
	$("#btn_selectReceive").html('<i class="layui-icon">&#xe613;</i>共选择'+sel_receive.length+'家任务接收单位');
}

function downFile(path,fileName) {
	var projectName = '<%=request.getContextPath() %>';
	var url = projectName + '/attach/downFile.do?path='+path+'&fileName='+fileName;
	window.location.href = url;
}
/*预览表单*/
function goViewReport(defineid, code){
	var index1 = layui.layer.open({
      title : "预览",
      type: 2,
      content : "<%=request.getContextPath() %>/designController.do?designPreviewHtml&defineId="+defineid+"&businessCode="+code+"&bussTemplateId=&versionNum=-1",
      area: ['80%', '800px'],
      success : function(layero,index,data){
          resizeLayer(index);
      }
   });
}

//关闭
$("#close").click(function(){
	close();
});

function close(){
	var index=parent.layui.layer.getFrameIndex(window.name);
	parent.layui.layer.close(index);
}
</script>
</body>
</html>