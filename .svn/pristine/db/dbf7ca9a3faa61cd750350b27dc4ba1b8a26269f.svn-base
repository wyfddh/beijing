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
<title>审批</title>
</head>
<body style="background:#fff;padding:10px">
<form class="layui-form" id="form">
	<input type="hidden" id="id" name="id" value="${id}">
	<input type="hidden" id="pageType" name="pageType" value="${pageType}">
	<input type="hidden" id="message" name="message" value="${message}">
	<input type="hidden" id="tableName" name="tableName" value="${tableName}">
	<div class="layui-inline layui-col-md12" id ="hide">
		<div class="layui-input-inline layui-col-md12">
               <label class="layui-form-label">审核结果：</label>
               <div class="layui-col-md7 layui-input-inline">
                     <input type="radio" name="result" value="1"  title="审核通过">
                     <input type="radio" name="result" value="0"  title="驳回">
               </div>
         </div>
	</div>
	<div class="layui-inline layui-col-md12">
		<label class="layui-form-label">驳回理由：</label>
		<div class="layui-input-inline layui-col-md9" style="width:280px">
			<textarea class="layui-textarea message" name="message" id="message" value="">${message}</textarea>
		</div>
	</div>
	<div class="layui-inline layui-col-md12" style="margin-top:20px;" id="editBtn">
		<div class="layui-input-block">
			<button class="layui-btn layui-btn-sm" lay-submit lay-filter="save">确定</button>
			<button type="reset" class="layui-btn layui-btn-sm layui-btn-primary" lay-filter="close" id="close">取消</button>
		</div>
	</div>
	<div class="layui-inline layui-col-md12" style="margin-top:20px;" id="showBtn">
		<div class="layui-input-block">
			<button type="button" class="layui-btn layui-btn-sm layui-btn-primary"  id="back">关闭</button>
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
    var pageType = $("#pageType").val();
    var tableName = $("#tableName").val();
    if(pageType =='view'){
    	$("#hide").hide();
    	$("#editBtn").hide();
    	$("textarea").attr('disabled',"disabled");
    }else{
    	$("#showBtn").hide();
    }
    form.on("submit(save)",function(data){
    	if($("input[type='radio']:checked").length==0){
    		layer.msg('请选择审批结果');
    		return false;
    	}
    	var result = $("input[type='radio']:checked").val();
    	var message  = $(".message").val();
    	var id = $("#id").val();
      $.post("<%=request.getContextPath() %>/cmsArticel/shenPi.do", 
    		  { 'tableName':tableName,'result':result,'message':message,'id':id }, function (data) {
          if(data.code == 1){
          	layer.msg('提交成功');
          	setTimeout(function(){
          		close();
			},1000)
          }else{
          	layer.msg(data.msg);
          }
      }); 
       return false;
    });
})

//关闭
$("#close").click(function(){
	close();
});

//关闭
$("#back").click(function(){
	close();
});

function close(){
	var index=parent.layui.layer.getFrameIndex(window.name);
	parent.layui.layer.close(index);
}

//格式化时间
function filterTime(val){
    if(val < 10){
        return "0" + val;
    }else{
        return val;
    }
}
</script>
</body>
</html>