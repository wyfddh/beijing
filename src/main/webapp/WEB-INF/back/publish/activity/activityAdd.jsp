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
	.hide{
        display:none;
    }
    .show{
        display:block;
    }
</style>
<title>亲子活动-新建</title>
</head>
<body style="background:#fff;padding:10px">
<form class="layui-form" id="newForm">
	<div class="layui-col-xs8" style="padding-right: 20px;">
		<div class="layui-form-item layui-row layui-col-xs12">
		    <input type="hidden" name="activityCategory" id="activityCategory" value="1"/>  
			<input type="hidden" id="pictureId" name="pictureId" value="">
			<input type="text" class="layui-input inputText" lay-verify="required" placeholder="请输入活动标题" id="activityName" name="activityName" style="width:100%;">
			<script id="editorCh" type="text/plain" style="width:100%;" name="content"></script>			
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<button class="layui-btn " lay-submit lay-filter="save">保存</button>
			<button type="reset" class="layui-btn  layui-btn-primary" lay-filter="close" id="close">取消</button>
		</div>
	</div>
	<div class="layui-col-xs4" style="padding-left: 20px;">
		<div class="layui-form-item layui-row layui-col-xs12">
			<label><b>标题图</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<div id="showImg" style="width: 95%;height: 100px;display: none;margin-bottom: 10px;"><a onclick="deleteImg()" href="javascript:void(0);" title="点击删除"><img id="titleImgShow" style="max-height: 100%;max-width: 100%;" src="" ></a></div>
			<button type="button" class="layui-btn layui-btn-radius layui-btn-primary" id="uploadImg"><i class="layui-icon">&#xe67c;</i>上传标题图</button>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12" >
			<label><b>活动时间</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12" style="vertical-align:middle;">
			<div class="layui-input-inline" style="width:300px;">
				  <input type="text" class="layui-input" id="activityTime" name="activityTime" placeholder="选择时间 ">
			 </div>
        </div>
         <div class="layui-form-item layui-row layui-col-xs12">
			<label><b>活动地址</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12" style="vertical-align:middle;">
			<div class="layui-input-inline" style="width:300px;">
				  <input type="text" class="layui-input inputText" lay-verify="required" placeholder="请输入活动地址"id="activityPlace" name="activityPlace">
			 </div>
        </div>
        <div class="layui-form-item layui-row layui-col-xs12">
				<label><b>活动描述</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12" style="vertical-align:middle;">
			<textarea type="text" class="layui-textarea textarea" onkeyup="checkLength(this);" placeholder="这里输入描述" value="" name="module" id="module"  style="width:300px;height:100px;resize:none;"></textarea>
		      &nbsp;限制字数：256   剩余字数：<span id="sy" style="color:Red;">256</span>
		</div>
	</div>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.all.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript">
$(function(){
	//初始化富文本编辑器
	var cn = UE.getEditor('editorCh',{
	    toolbars: [['source', 'indent', 'insertimage','justifyleft','justifyright','justifycenter','justifyjustify',]],
	    initialFrameHeight: 400
	});
	
	
});

layui.use(['form','layer','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    	laydate = layui.laydate;
    	//日期范围
    	laydate.render({
    	    elem: '#activityTime'
    	    ,type: 'datetime'
    	    ,range: true
    	 });	
    form.render();
 	form.on("submit(save)",function(data){
 		saveFunction();
        return false;
    });
	
    var saveFunction = function(){    	
    	$.ajax({
            url:"<%=request.getContextPath() %>/activityAdmin/save.do",
            data:$("#newForm").serialize(),
            type:"POST",
            success:function(msg){
                if(msg.code == 1){
                	layer.msg('保存成功');
                	setTimeout(function(){
                		parent.layui.layer.closeAll();
    				},700);
                }else{
                	layer.msg(msg.msg);
                }
            }
        });
    }
    
    $("#uploadImg").click(function(){
    	var index = layui.layer.open({
		      title : "裁剪图片",
		      type : 2,
		      content : "<%=request.getContextPath() %>/cropper/Article_crop.jsp",
			  area: ['90%', '600px'],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
				},
		      yse:function (index, layero) {
		          layer.close(index); //关闭弹层
		      }
		  });
    	layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
    });
    
    var upload = layui.upload;
    var uploadInst = upload.render({
        elem: '#fileBtn2' //绑定元素
        ,url: '<%=request.getContextPath() %>/attach/uploadLegal.do' //上传接口
        ,data:{
        	projectName:"publish"
        }
    	,auto:true
    	,field:"file"
    	,accept:"file"
    	,size:102400
    	,acceptMime:"application/pdf"
   		,before: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
   			//加载层-风格4
   			layer.msg('上传中', {
   			  icon: 16
   			  ,shade: 0.5
   			});
   		}
        ,done: function(res){
        	layer.closeAll(); //关闭loading
          //上传完毕回调
        	var resultMap = res.data;
          	if(res.code == 1){
	        	$('#titleImgShow').attr('src', resultMap.absolutePath); //图片链接（base64）
	        	$("#showFile").append('<a class="layui-btn layui-btn-radius layui-btn-primary" onclick="deleteFile()" title="点击删除"><i class="layui-icon">&#xe66e;</i>'+resultMap.realFileName+'</a>');
          	}
       		layer.msg(res.msg);
        }
        ,error: function(){
          //请求异常回调
        }
      });
	//点击文件删除
	window.deleteImg = function(){
		layer.confirm('确定删除标题图片？', {icon: 3, title: '删除确认'}, function (index) {
		    cancelFile($("#pictureId").val());
		    $("#pictureId").val("");
		    $('#titleImgShow').attr('src', '');
		    $("#showImg").hide();
			layer.close(index);
        })
	}
	//删除服务器上的文件
	function cancelFile(resultPath) {
		$.ajax({
			type:"post",
			url:'<%=request.getContextPath() %>/attach/cancelFile.do',
			data:{"resultPath":resultPath},
			success:function(result) {
				//删除成功
			}
		})
	}
})

//子页面获取当前页面
function setTitleImg(absolurl, relativeurl){
	$('#titleImgShow').attr('src', absolurl); //图片链接（base64）
	$('#pictureId').val(relativeurl); //相对路径
	$("#showImg").show();
}

//关闭
$("#close").click(function(){
	parent.layui.layer.closeAll();
});

function checkLength(which) {
    var maxChars = 256; //
    if (which.value.length > maxChars)
    {
        alert("您输入的字数超出限制!");
        // 超过限制的字数了就将 文本框中的内容按规定的字数 截取
        which.value = which.value.substring(0,maxChars);
        return false;
    }
    else
    {
        var curr = maxChars - which.value.length; //250 减去 当前输入的
        $("#sy").html(curr.toString());
        return true;
    }
}
</script>
</body>
</html>