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
<title>文章-编辑</title>
</head>
<body style="background:#fff;padding:10px">
<form class="layui-form" id="newForm">
	<input type="hidden" id="id" name="id" value="${article.id }">
	<input type="hidden" id="status" name="status" value="${article.status }">
	<input type="hidden" id="subjectId" name="subjectId" value="${article.subjectId }">
	<input type="hidden" id="titleImageSrc" name="titleImageSrc" value="${article.titleImageSrc }">
	<input type="hidden" id="pdfUrl" name="pdfUrl" value="${article.pdfUrl }">
	<input type="hidden" id="file_id" name="file_id" value="${file_id }">
	<input type="hidden" id="file_resultPath" name="file_resultPath" value="${file_resultPath }">
	<input type="hidden" id="file_realFileName" name="file_realFileName" value="${file_realFileName }">
	<input type="hidden" id="file_isjunk" name="file_isjunk" value="${file_isjunk}">
	<input type="hidden" id="file_size" name="file_size" value="${file_size }">
	<input type="hidden" id="file_typeCode" name="file_typeCode" value="${file_typeCode }">
	<div class="layui-col-xs12" style="padding-left: 20px;">
		<div class="layui-form-item layui-row layui-col-xs12">
			<input type="text" class="layui-input inputText" lay-verify="required" placeholder="标题" value="${article.title }" id="title" name="title" style="width:70%;display: inline;">
			<!--<script id="editorCh" type="text/plain" style="width:100%;" name="content">${article.content }</script>  -->
<!-- 			<button type="button" lay-submit class="layui-btn layui-btn-danger" lay-filter="publish" id="publish" style="float: right;">发布</button> -->
			<button type="button" class="layui-btn layui-btn-primary" id="close" onclick="close();" style="float: right;">关闭</button>
			<button type="button" class="layui-btn" lay-submit lay-filter="save" style="float: right;margin-right: 10px;">暂存</button>
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12">
			<label><b>标题图</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
		<c:if test="${not empty article.titleImageSrc }" var="imgIsNotNull">
			<div id="showImg" style="width: 95%;height: 200px;margin-bottom: 10px;"><a onclick="deleteImg()" href="javascript:void(0);" title="点击删除"><img id="titleImgShow" style="max-height: 100%;max-width: 100%;" src="${article.titleImageSrc }" ></a></div>
		</c:if>
		<c:if test="${!imgIsNotNull }">
			<div id="showImg" style="width: 95%;height: 200px;display: none;margin-bottom: 10px;"><a onclick="deleteImg()" href="javascript:void(0);" title="点击删除"><img id="titleImgShow" style="max-height: 100%;max-width: 100%;" src="${article.titleImageSrc }" ></a></div>
		</c:if>
			<button type="button" class="layui-btn layui-btn-radius layui-btn-primary" id="uploadImg"><i class="layui-icon">&#xe67c;</i>上传标题图</button>
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12" style="margin-top: 10px;">
			<label><b>期刊文件</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<c:if test="${not empty file_realFileName }" var="pdfIsNotNull">
				<div id="showFile">
					<a class="layui-btn layui-btn-radius layui-btn-primary" onclick="deleteFile()" title="点击删除"><i class="layui-icon">&#xe66e;</i>${file_realFileName }</a>
				</div>
			</c:if>
			<c:if test="${!pdfIsNotNull }">
				<div id="showFile"></div>
			</c:if>
			<button type="button" class="layui-btn layui-btn-radius layui-btn-primary" id="fileBtn2"><i class="layui-icon">&#xe67c;</i>上传期刊文件</button>
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12" style="margin-top: 10px;">
			<label><b>作者</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12" style="vertical-align:middle;">
			<input type="text" class="layui-input inputText" placeholder="这里输入学术论文作者" value="${article.author }" name="author" id="author" style="width:95%;">
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12" style="margin-top: 10px;">
			<label><b>描述</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12" style="vertical-align:middle;">
			<textarea type="text" class="layui-textarea textarea sy" onkeyup="checkLength(this);" placeholder="这里输入描述" value="${article.description }" name="description" id="description" row="3" style="width:95%;resize:none;">${article.description }</textarea>
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
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript">
//初始化富文本编辑器
/* var cn = UE.getEditor('editorCh',{
//     toolbars: [['source', 'indent', 'insertimage','justifyleft','justifyright','justifycenter','justifyjustify',]],
    initialFrameHeight: 500
}); */
</script>
<script type="text/javascript">
$(function(){
	
});
//接收单位
var sel_receive = [];
//附件
var uploads = [];

layui.use(['form','layer','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    	laydate = layui.laydate;
	
   	laydate.render({
   	    elem: '#deadlineTime'
   	    ,type: 'datetime'
   	    ,format: 'yyyy-MM-dd HH:mm'
   	  });
    
    var maxChars = 256;
    var which = $(".sy")[0].value.length;;
    var curr = maxChars-which;
     $("#sy").html(curr);
   	
    form.on("switch(isfeedback)", function(data){
    	if(data.elem.checked){
	    	$(".iswrite").show();
	    	layui.layer.tips('若选择此项，超过截至时间后，接收单位依然可以进行数据填报', '.outTimeIsContinueWrite', {
                tips: 3
            });
    	}else{
	    	$(".iswrite").hide();
    	}
    });
    
    form.on("submit(save)",function(data){
    	saveOrPublish('1');
        return false;
    });
    form.on("submit(publish)",function(data){
    	layer.confirm('是否确认发布？', {icon: 3, title: '发布确认'}, function (index) {
	    	saveOrPublish('2');
	    	layer.close(index);
    	});
        return false;
    });
    
    //保存获取发布
    var saveOrPublish = function(status){
    	if($("#title").val() == ""){
    		layer.msg('您还没有填写标题');
        }else if($("#titleImageSrc").val() == ""){
        	layer.msg('您还没有上传标题图片');
        }else if($("#pdfUrl").val() == ""){
        	layer.msg('您还没有上传期刊文件');
        }else {
      		saveFunction(status);
        }
    }
    
    var saveFunction = function(status){
    	if(status == '1'){		//暂存
        	$("#status").val("1");
    	}else if(status == '2'){
        	$("#status").val("2");
    	}else{
    		layer.msg("操作异常");
    	}
    	$.ajax({
            url:"<%=request.getContextPath() %>/cmsArticel/modify.do",
            data:$("#newForm").serialize(),
            type:"POST",
            success:function(msg){
                if(msg.code == 1){
                	if(status == '1'){		//暂存
                		layer.msg('保存成功');
                	}else if(status == '2'){
                		layer.msg('发布成功');
                	}
                	setTimeout(function(){
    					close();
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
		      content : "<%=request.getContextPath() %>/cropper/Article_crop.jsp?type=2",
			  area: ['90%', '600px'],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
		            setTimeout(function(){
		                layui.layer.tips('点击此处返回文章详情', '.layui-layer-setwin .layui-layer-close', {
		                    tips: 3
		                });
		            },500)
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
	        	console.log(uploads);
	        	$("#showFile").html("");
	        	$("#pdfUrl").val(resultMap.id);
	        	$("#file_id").val(resultMap.id);
	        	$("#file_resultPath").val(resultMap.resultPath);
	        	$("#file_realFileName").val(resultMap.realFileName);
	        	$("#file_isjunk").val(resultMap.isjunk);
	        	$("#file_size").val(resultMap.size);
	        	$("#file_absolutePath").val(resultMap.absolutePath);
	        	$("#file_typeCode").val(resultMap.typeCode);
	        	$("#showFile").append('<a class="layui-btn layui-btn-radius layui-btn-primary textHidden" onclick="deleteFile()" title="点击删除"><i class="layui-icon">&#xe66e;</i>'+resultMap.realFileName+'</a>');
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
// 		    cancelFile($("#titleImageSrc").val());
		    $("#titleImageSrc").val("");
		    $('#titleImgShow').attr('src', '');
		    $("#showImg").hide();
			layer.close(index);
        })
	}
	//点击文件删除
	window.deleteFile = function(){
		layer.confirm('确定删除PDF文档？', {icon: 3, title: '删除确认'}, function (index) {
// 		    cancelFile($("#file_resultPath").val());
		    $("#pdfUrl").val("");
		    $('#showFile').html('');
		    $("#file_id").val("");
        	$("#file_resultPath").val("");
        	$("#file_realFileName").val("");
        	$("#file_isjunk").val("");
        	$("#file_size").val("");
        	$("#file_absolutePath").val("");
        	$("#file_typeCode").val("");
			layer.close(index);
        })
	}
	//删除服务器上的文件
	function cancelFile(resultPath) {
		<%-- $.ajax({
			type:"post",
			url:'<%=request.getContextPath() %>/attach/cancelFile.do',
			data:{"resultPath":resultPath},
			success:function(result) {
				//删除成功
			}
		}) --%>
	}
})

//子页面获取当前页面的接收单位
function setTitleImg(absolurl, relativeurl){
	$('#titleImgShow').attr('src', absolurl); //图片链接（base64）
	$('#titleImageSrc').val(relativeurl); //相对路径
	$("#showImg").show();
}

//关闭
$("#close").click(function(){
	close();
});

function close(){
	var index=parent.layui.layer.getFrameIndex(window.name);
	parent.layui.layer.close(index);
}
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