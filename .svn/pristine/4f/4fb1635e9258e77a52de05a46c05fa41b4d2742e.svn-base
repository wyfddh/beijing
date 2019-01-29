<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<title>添加分类</title>
	<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/public/public.css" media="all" />

</head>
<body class="childrenBody">
 

<form class="layui-form" style="width:80%;" method="post" id="form">
	<!-- 解决360浏览器自动填充账号密码输入框 -->
	<input type="text" id="aaa" style="visibility: hidden;" />   
　　	<input type="password" id="aba" style="visibility: hidden;" />
	
	<input type="hidden" id="id" name="id">
	<div class="layui-form-item layui-row layui-col-xs12" id="divTypeName">
		<label class="layui-form-label"><font color="red">*&nbsp;&nbsp;</font>分类名</label>
		<div class="layui-input-block">
			<input type="text" name="name" id="name" required  lay-verify="required|typeName"  autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item layui-row" id="divLevel">
	    <label class="layui-form-label">描述</label>
	    <div class="layui-input-block">
	        <textarea rows="3" style="resize:none;width: 100%;" name="describe" id="describe" class="layui-textarea"></textarea>
	    </div>
	</div>
	<br>
	<div class="layui-form-item layui-row layui-col-xs12">
		<div class="layui-input-block">
			<button class="layui-btn layui-btn-sm" lay-submit lay-filter="addLegalType">确定</button>
			<button type="button" id="cancel" class="layui-btn layui-btn-sm layui-btn-primary">取消</button>
		</div>
	</div>
</form> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript">
layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    
    var pathName=window.document.location.pathname;
    projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    
    var index = parent.layer.getFrameIndex(window.name);
 
    form.on("submit(addLegalType)",function(data){
    	var data = $("#form").serialize();
    	var msg;
    	var type = $("#type1").val();
    	if (type == 1) {
    		msg = "添加";
    	} else {
    		msg = "修改";
    	}
        $.ajax({
        	type:"post",
        	data:data,
        	async:false,
        	url:projectName + '/topicType/addOrUpdate.do', 
        	success:function(result) {
        		if (result.success == 1) {
        			top.layer.msg(msg + '成功！'); 
        			parent.layer.close(index);
        		} else {
        			top.layer.msg('系统异常' + msg + '失败！');
        			parent.layer.close(index);
        		}
        	}
        })

    })
    
    $("#cancel").click(function(){
    	var index=parent.layui.layer.getFrameIndex(window.name);
    	parent.layui.layer.close(index);
    });
    
    var initData = function() {
    	$(".hide").hide();
    }
    initData();

})


</script>

</body>
</html>