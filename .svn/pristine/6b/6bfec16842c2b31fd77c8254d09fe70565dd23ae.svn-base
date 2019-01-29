<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/css/cover.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/css/audio.css" />
<style type="text/css">
	   .zj_add_message{
        	width: 100%;
        	padding: 24px 0;
        	border-bottom: 1px solid #f1f2f7;
        	margin-bottom: 13px;
        }
        .zj_add_message>span{
        	font-size: 16px;
        }
        .zj_add_audio{
        	padding-bottom: 18px;
        	border-bottom: 6px solid #f1f2f7;
        }
        
        .zj_add_audio>span:nth-child(1){
        	display: block;
        	color: white;
        	background-color: #2a9bcf;
        	width: 82px;
        	border-radius: 5px;
        	padding: 10px;
        	font-size: 14px;
        	line-height: 16px;
        	margin-bottom: 18px;
        	cursor: pointer;
        	float:left;
        }
        .zj_add_audio>span:nth-child(1)>i{
        	font-size: 16px;
        	color: white;
        }
</style>
<title>讲解词</title>
</head>
<body style="background-color:#fff;">
<div class="add_digital_exhibition_div_id">
	<div id="add_multimedia_information" class="add_digital_exhibition_img" style="display: block;">
		<div class="body" style="padding-bottom: 0px;">
			<form class="form form-horizontal" id="modify_form_vedio_id">
				<div class="zj_add_audio">
	                <textarea name="description" class="textarea">${culturalrelic.description}</textarea>
				</div>
				<div style="margin-top: 10px;">
	            	<div class="zj_add_audio" style="border-bottom:0px;">
	            		<span id="myaudio">
	            			<i class="Hui-iconfont">&#xe600;</i>
	            			添加音频
	            		</span>
	            		<audio src="${audioUrl}" controls></audio>
	            		<input type="text" class="input-text hidden" name="fAudio" value="${audioRootUrl}" id="upload_audio">
	            		<input type="text" id="id" name="id" hidden="hidden" value="${culturalrelic.id}"/>
	            	</div>
				</div>
			</form>
		</div>
		<div class="footer">
			<a id="save_multimedia_information" class="left" href="javascript:">确认</a>
			<a id="cancel_add_multimedia_information" class="right" href="javascript:">取消</a>
		</div>
	</div>
</div>
<!-- 加载进度条 -->
<div id="model">
	<div class="box">
		<div style="width: 420px;margin: 0 auto;margin-top: 50px;">
			<p style="color: #2A9BCF;">
				正在上传...
				<font style="float: right; color: #2A9BCF;" id="percent">0%</font>  
			</p>
			<div style="background:#F0FAFF;width:420px; border-radius:4px; border:1px solid #BFE1F1; height:10px;margin-top:5px">  
		        <div id="progressNumber" style="background:#2A9BCF;width:0px;height:10px" >  
		        </div>      
		    </div>  
		</div>
	</div>
</div>
 <!--音频遮罩层开始-->
  <form id="uploadFormAudio" enctype="multipart/form-data" method="post" >
    <div id="coverAudio">
        <a href="javascript:;" class="Hui-iconfont c-white btn btn-danger close">&#xe6a6;</a>
        <div class="row cl pt-20 pl-30 col-offset-1" style="padding-top: 120px;">
            <label class="col-xs-4 col-sm-3 text-r col-md-2 c-white lig" id="audioTitle">请选择音频文件：</label>
            <div class="formControls col-xs-8 col-sm-9 col-md-8">
             <span class="btn-upload form-group">
                 <input class="upload-url" type="text" name="uploadfile" id="uploadAudio" readonly nullmsg="请添加附件！" style="outline: none;border: 1px solid #DDDDDD;width:80px;height: 29px;">
                 <a href="#" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
     			<input type="file" name="file" class="input-file"  id="accIntAudio">
			 </span>
            </div>
        </div>
        <div class="row cl text-c pd-40">
        	<input type="button" id="uploadAudio_button" value="上传" class="btn btn-primary radius upload">
            <input type="reset" href="javascript:;" class="btn btn-danger radius ml-20" value="重置" />
        </div>
    </div>
   </form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.min.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
	//点击音频按钮
	$("#myaudio").click(function(){
	    $("#audioTitle").html("请添加音频文件");
	    $("#coverAudio").slideDown(500);
	});
	$(".close").click(function(){
	    $("#coverAudio").slideUp(300);
	});
	//上传音频
	$(function(){
		$("#uploadAudio_button").click(function() {
			var audio = $("#accIntAudio").val();
			if(audio==""||audio==null){
				layer.msg('[ERROR]请选择音频文件', {icon: 2});
				return;
			}
			 var formData = new FormData($( "#uploadFormAudio" )[0]);
			$.ajax({
				url : "<%=request.getContextPath() %>/file/uploadAudio.do",
				type : "post",
				data :  formData,
				dataType:"json",
				 async: false,  
	          cache: false,  
	          contentType: false,  
	          processData: false,  
	            success: function (data) {
	                if(data.error == 1){
	                	layer.msg(data.message, {icon: 1});
	                }
	                if(data.error == 0){
	                   /* alert(data.url); */
	                   layer.msg('[OK]上传成功', {icon: 1});
	                   $("#upload_audio").attr("value",data.url);
	                   $("audio").attr("src",data.src);
	                   setTimeout(function(){
	                	   $("#coverAudio").slideUp(300);
	                	   $("#uploadAudio").val("");
	                	   $("#accIntAudio").val("");
						},1000)
	                }
	            },
			})
		});
	});
	//取消
	$("#cancel_add_multimedia_information").on("click", function() {
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	})
	//保存
	$("#save_multimedia_information").on("click", function() {
		// 校验名称
		/* if($.trim($("#video_name").val()) == ""){
			layer.msg("请填写名称")
	        return false;
		} */
		// 通过验证发送请求
	   	$.ajax({
	       url:"<%=request.getContextPath()%>/back/oCCollection/saveView.do",
	       data:$('#modify_form_vedio_id').serialize(),
	       type:"POST",
		   dataType: 'json',
	       success:function(data){
	    	   if(data.success == '1'){
	    		  layer.msg('[OK]保存成功', {icon: 1});
	    		  setTimeout(function(){
	    		  //parent.parent.location.href = href;
	    		  parent.location.href='<%=request.getContextPath()%>/back/oCCollection/info.do';
	    		  var index = parent.layer.getFrameIndex(window.name);
	    		  parent.layer.close(index);
			      },2000);
	           }
	       },
	       error: function(error) {
				console.log(error);
				layer.msg("保存失败");
			}
	   });
	})
</script>
</body>
</html>
