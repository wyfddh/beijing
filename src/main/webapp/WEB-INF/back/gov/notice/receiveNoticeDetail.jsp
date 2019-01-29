<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>   
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
    <!--/meta 作为公共模版分离出去-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<style type="text/css">
	.textHidden{max-width:70%; white-space:nowrap;overflow:hidden;text-overflow:ellipsis; }
</style>
<title>通知公告-详情</title>
</head>
<body style="background:#fff;padding:10px">
<form class="layui-form" id="newForm">
	<div class="layui-col-xs8" style="padding-right: 20px;">
		<div class="layui-card-header layui-row layui-col-xs12" style="text-align: center;">
			<label><b>${receiveNoticeDetail.title }</b></label>
		</div>
		<div class="layui-card-body layui-row layui-col-xs12">
			${receiveNoticeDetail.content }
		</div>		
	</div>
	<div class="layui-col-xs4" style="padding-left: 20px;">

		<div class="layui-form-item layui-row layui-col-xs12">
			<label><b>发布单位</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<a id="publishOrg" class="layui-btn layui-btn-radius layui-btn-primary">
				<i class="layui-icon">&#xe68e;</i>${receiveNoticeDetail.publishOrgName}
			</a>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label><b>发布时间</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<a id="lastUpdateTime" class="layui-btn layui-btn-radius layui-btn-primary">
				<i class="layui-icon">&#xe637;</i>${receiveNoticeDetail.publishTime}
			</a>
		</div>
		<c:if test="${ !''.equals(receiveNoticeDetail.attachmentIds)  }">
			<div class="layui-form-item layui-row layui-col-xs12" style="margin-top: 30px;">
				<label><b>附件</b></label>
			</div>
			<div class="layui-form-item layui-row layui-col-xs12">
				<div id="showFile"></div>
			</div>
		</c:if>
		<c:if test="${receiveNoticeDetail.isfeedback == 1 }">
			<div class="layui-form-item layui-row layui-col-xs12" style="margin-top: 30px;">
				<label><b>填报信息</b></label>
			</div>
			<div class="layui-form-item layui-row layui-col-xs12">
				<a id="lastUpdateTime" class="layui-btn layui-btn-radius layui-btn-primary">
					<i class="layui-icon">&#xe655;</i>${receiveNoticeDetail.reportName}
				</a>
			</div>
			<div class="layui-form-item layui-row layui-col-xs12">
				<a id="lastUpdateTime" class="layui-btn layui-btn-radius layui-btn-primary">
					<i class="layui-icon">&#xe637;</i>填报截止时间: ${receiveNoticeDetail.deadlineTimeStr}
				</a>
			</div>
			<c:if test="${receiveNoticeDetail.isfill == 0 }">
				<c:if test="${receiveNoticeDetail.deadlineTime > now}">
					<c:if test="${receiveNoticeDetail.receiveStatus == 1 }">
						<div class="layui-form-item layui-row layui-col-xs12" style="margin-top:50px;">
							<button class="layui-btn " lay-submit lay-filter="save">在线填报</button>
						</div>
					</c:if>
					<c:if test="${receiveNoticeDetail.receiveStatus == 2 }">
						<div class="layui-form-item layui-row layui-col-xs12" style="margin-top:50px;">
							<button class="layui-btn " lay-submit lay-filter="save">修改填报</button>
							<button class="layui-btn  layui-btn-normal" lay-submit lay-filter="send">提交填报</button>
						</div>
					</c:if>
				</c:if>
			</c:if>
			<c:if test="${receiveNoticeDetail.isfill == 1 }">
				<c:if test="${receiveNoticeDetail.receiveStatus == 1 }">
					<div class="layui-form-item layui-row layui-col-xs12" style="margin-top:50px;">
						<button class="layui-btn " lay-submit lay-filter="save">在线填报</button>
					</div>
				</c:if>
				<c:if test="${receiveNoticeDetail.receiveStatus == 2 }">
					<div class="layui-form-item layui-row layui-col-xs12" style="margin-top:50px;">
						<button class="layui-btn " lay-submit lay-filter="save">修改填报</button>
						<button class="layui-btn  layui-btn-normal" lay-submit lay-filter="send">提交填报</button>
					</div>
				</c:if>
			</c:if>
		</c:if>		
	</div>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/jQuery-searchableSelect/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/jQuery-searchableSelect/jquery.searchableSelect.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript">
$(function(){
	 layui.use(['form','layer','laydate','upload'],function(){
	    	form = layui.form
	        layer = parent.layer === undefined ? layui.layer : top.layer,
	        $ = layui.jquery;
	}); 
	//刷新文件显示
	var uploadsJsonString = '${uploads}';
	if(uploadsJsonString != ''){
		var uploads = JSON.parse(uploadsJsonString);
		refreshFile(uploads);
	}
	form.render();
	
	form.on("submit(save)",function(data){
		reportSave();
        return false;
    });
	form.on("submit(send)",function(data){
		reportSend();
        return false;
    });
	
    var reportSave = function(){ 
    	var defineCode = '${receiveNoticeDetail.defineCode}';
    	var otherParameters = encodeURIComponent('{id:\'${receiveNoticeDetail.detailId}\'}');
    	var reportId = '${receiveNoticeDetail.reportId}';
    	var index = layui.layer.open({
    	      title : "填报表单",
    	      type : 2,
    	      content : "<%=request.getContextPath() %>/aceAutoController.do?modePage&type=page&releaseCode="+defineCode+"&otherParameters="+otherParameters+"&mainId="+reportId,
    	      area: ['95%','95%'],
    	      success : function(layero,index){
    	          var body = layui.layer.getChildFrame('body', index);
     	          resizeLayer(index); 
    	      },
    	      end :function() {
    	    	  location.reload();
              }
    	  });
    } 
    var reportSend = function(){ 
    	var defineCode = '${receiveNoticeDetail.defineCode}';
    	var reportId = '${receiveNoticeDetail.reportId}';
    	layer.confirm("确认要提交吗", { title: "提交确认" }, function (index) {
		    layer.close(index);	     
	    	$.ajax({
				url : "<%=request.getContextPath()%>/editPageGenController.do?doUpdateStatus&status=1&releaseCode="+defineCode+"&mainId="+reportId,
				dataType : "json",
				async: false,
				success : function(data){					
					var id = '${receiveNoticeDetail.detailId}';
					$.ajax({
						url : "<%=request.getContextPath()%>/notice/receive/changeStatus.do?id="+id+"&receiveStatus="+4,
						dataType : "json",
						async: false,
						success : function(data){
							if(data==1){
								layer.msg('提交成功', {icon: 1});
								setTimeout(function(){
								 	var index=parent.layui.layer.getFrameIndex(window.name);
						           	parent.layui.layer.close(index);
			    				},700);    
							}else{
								layer.msg('系统异常', {icon: 2});
							}
						}
					})									
				}
			})
			
    	});
    } 
})
	//刷新文件显示
function refreshFile(uploads){
	//清空showFile中的html
	$("#showFile").html("");
	//循环插入文件显示
	for (var i = 0; i < uploads.length; i++) {
		$("#showFile").append('<button type="button" title="下载附件" class="layui-btn layui-btn-radius layui-btn-primary textHidden" onclick="downFile(\''+uploads[i].resultPath+'\',\''+uploads[i].realFileName+'\')"><i class="layui-icon">&#xe66e;</i>'+uploads[i].realFileName+'</button>');
	}
}
	
function downFile(path,fileName) {
	var projectName = '<%=request.getContextPath() %>';
	var url = projectName + '/attach/downFile.do?path='+path+'&fileName='+fileName;
	 window.location.href = url;		
}

//关闭
$("#close").click(function(){
    parent.layer.closeAll();
})

</script>
</body>
</html>