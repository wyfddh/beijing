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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/public.css"/>
<style type="text/css">
	.textHidden{max-width:70%; white-space:nowrap;overflow:hidden;text-overflow:ellipsis; }
</style>
<title>自定义表单-新建</title>
</head>
<body style="background:#fff;padding:10px">
<form method="post" action="#" class="registerform" id="cgform" >
	<input type="hidden" id="id" name="id" value="${bean.id}">
	<input type="hidden" id="bussType" name="bussType" value="2">
	<div id="reportAdd">
		<div>
			<input type="input" class="layui-input" style="width: 200px; margin-left: 20px;" id="defineName" name="defineName">
			<input type="hidden" id="saveType" name="saveType" value="1">
		</div>
		<div class="layui-layer-btn layui-layer-btn-" style="margin-top: 17px;">
			<a class="layui-layer-btn0" onclick="save_1_();">确定</a>
			<a class="layui-layer-btn1" onclick="close1();">取消</a>
		</div>
	</div>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/designPlug-in/tools/icmstools.js?1313"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript">
$(function(){
	
	
});

function save_1_(){
	if($("#defineName").val() == ''){
		layer.msg("名称不能为空");
		return false;
	}
	var form1= $("form").serialize();
	console.log(form1);
	var id = $("#id").val();
	var winHandler = window.open("","_blank");
	$.ajax({
		async: false,
		url: "<%=request.getContextPath() %>/cgformDefineController.do?" + (id!=''?'doUpdate':'doAdd'),
		type: "POST",dataType: "json",//async: false,
		data: form1,
		success: function(data) {
			if(data!=null){
				if(data.success){
					winHandler.location.href = "<%=request.getContextPath() %>/designController.do?design&type=2&businessCode="+data.msg;
					close1();
				}else{
					winHandler.close();
					layer.msg(data.msg, {icon: 5});
				}
			}
		}
	});
}

//关闭
$("#close").click(function(){
	close();
});

function close1(){
	var index=parent.layui.layer.getFrameIndex(window.name);
	parent.layui.layer.close(index);
}
</script>
</body>
</html>