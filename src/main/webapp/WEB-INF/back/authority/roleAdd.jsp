<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
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
<title>角色新增</title>
</head>
<body style="background:#fff;padding:10px">
<form class="layui-form" id="form">
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">角色名称</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input inputText" lay-verify="required" placeholder="请输入角色名称" value="${roleName }" name="roleName" id="roleName" style="width:200px">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">组织类型</label>
		<div class="layui-input-block">
			<input type="checkbox" name="orgType" value="1" title="文物局" >
			<input type="checkbox" name="orgType" value="2" title="区文委">
			<input type="checkbox" name="orgType" value="3" title="博物馆">
			<input type="checkbox" name="orgType" value="4" title="文物修复资质单位">
			<input type="checkbox" name="orgType" value="5" title="其他文物收藏单位">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">备注</label>
		<div class="layui-input-block">
			<textarea type="text" class="layui-textarea textarea" placeholder="请输入备注" value="${remark }" name="remark" id="remark" row="3" style="width:200px;resize:none;">${remark }</textarea>
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12" style="margin-top:20px;">
		<div class="layui-input-block">
			<button class="layui-btn layui-btn-sm" lay-submit lay-filter="save">保存</button>
			<button type="reset" class="layui-btn layui-btn-sm layui-btn-primary" lay-filter="close" id="close">取消</button>
		</div>
	</div>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
		
    form.verify({
	    num:[/^([\d]{11})?$/,'请输入正确手机号']      
	}); 
    form.on("submit(save)",function(data){
    	var roleName = $("#roleName").val();
    	var remark = $("#remark").val();
    	if(roleName == ''){
    		layer.open({
                title:"提示",
                content:"您还没有填写角色名称"
            });
    		return false;
    	}
    	$.ajax({
          	url:"<%=request.getContextPath() %>/role/roleAdd.do",
            data:$("#form").serialize(),
            type:"POST",
            dataType: 'json',
            success:function(msg){
                if(msg.success == 1){
                	layer.msg('保存成功', {icon: 1});
                	setTimeout(function(){
    					close();
    				},700);
                }else if(msg.success == 0){
                	top.layer.msg(msg.data, {icon: 1});
    				setTimeout(function(){
    					close();
    				},1000);
                }
            }
        });
       return false;
    });
})

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