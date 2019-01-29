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
<title>藏品专题-新建</title>
</head>
<body style="background:#fff;padding:10px">
<form class="layui-form" id="newForm">
	<input type="hidden" id="id" name="id" value="">
	<div class="layui-col-xs12" style="padding-right: 20px;padding-left: 20px;">
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">专题名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input inputText" lay-verify="required" placeholder="请输入菜单名称" id="name" name="name" style="width:300px">
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12" style="margin-top:20px;">
			<div class="layui-input-block">
				<button lay-submit class="layui-btn layui-btn-sm layui-btn-primary" lay-filter="close">以后再说</button>
				<button lay-submit class="layui-btn layui-btn-sm" lay-filter="save">开始添加藏品</button>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript">
layui.use(['form','layer','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    	laydate = layui.laydate;
	
    form.on("submit(save)",function(data){
    	saveOrPublish('1');
        return false;
    });
    form.on("submit(close)",function(data){
    	saveOrPublish('2');
        return false;
    });
    
    //保存获取发布
    var saveOrPublish = function(status){
    	if($("#name").val() == ""){
            layer.open({
                title:"提示",
                content:"您还没有填写专题名称"
            })
        }else {
       		saveFunction(status);
        }
    }
    
    var saveFunction = function(status){
    	$.ajax({
            url:"<%=request.getContextPath() %>/topic/saveTopic.do",
            data:$("#newForm").serialize(),
            type:"POST",
            success:function(msg){
                if(msg.success == 1){
                	if(status == '1'){		//暂存
                		/* layer.msg('保存成功'); */
				 		window.location.href="<%=request.getContextPath() %>/topic/goEditTopicPage.do?topicId="+msg.data.id;
                	}else if(status == '2'){
                		layer.msg('保存成功');
                		setTimeout(function(){
        					close();
        				},700);
                	}
                }else{
                	layer.msg(msg.data);
                }
            }
        });
    }
    
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