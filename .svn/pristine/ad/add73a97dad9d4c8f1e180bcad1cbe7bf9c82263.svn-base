<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="favicon.ico">
    <link rel="Shortcut Icon" href="favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
<%--    <script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>  --%>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/content_gover.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>外省编辑展览信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
	<style>
        .img_wrap{
            width: 300px;
            height: 300px;
            position: absolute;
            top:50%;
            laft:100%;
            margin-top: -150px;
            margin-left: 500px;
            background: red;
        }
        .box-size{
            width: 300px!important;height:230px!important;
        }
        .box-size-M{
            width: 235px!important;height:195px!important;
        }
        .box-size-S{
            width: 190px!important;height:155px!important;
        }
        .box-size-L{
            width: 285px!important;height:225px!important;
        }
        .grid-bg{
            background: #00CCFF!important;color: #ffffff;
        }
        #DataTables_Table_0_filter{
            display: none;
        }
        #coverVideo{
            width: 1000px;height: 500px;background: rgba(0,0,0,0.7);position: fixed;left: 25%;top:20%;border:5px solid lightslategray;min-width: 800px;display: none;
        }
        #coverAudio{
            width: 1000px;height: 500px;background: rgba(0,0,0,0.7);position: fixed;left: 25%;top:20%;border:5px solid lightslategray;min-width: 800px;display: none;
        }
        #coverPic{
        	 z-index:999; width: 1000px;height: 500px;background: rgba(0,0,0,0.7);position: fixed;left: 25%;top:20%;border:5px solid lightslategray;min-width: 800px;display: none;
        }
        .close{
            position: absolute;right: 0;
        }
        .lig{
            line-height:30px
        }
        .Hui-article-box {
            overflow-x:hidden!important;
            overflow-y:inherit!important;
        }
        #editor{
            width:100%;
            height:400px;
        }
        .button_wrap{
            width:100%;
            height:80px;
            box-sizing:border-box;
            padding:0;
            margin:0;
        }
        .button_wrap > h3{
            width:600px;
            line-height:80px;
            float: left;
            font-size: 18px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
            font-weight: bold;
            box-sizing:border-box;
            padding:0 0 0 50px;
            margin:0;
        }
        .butt_new{
            border-radius: 4px;
            width: 101px;
            height: 36px;
            float: right;
            text-align: center;
            line-height: 36px;
            margin-top: 22px;
            cursor: pointer;
            box-sizing:border-box;
            border:1px solid rgb(42, 155, 207);
            padding:0;
            color:rgb(42, 155, 207);
            margin-left:12px;
        }
        .butt_new > a{
            color:rgb(42, 155, 207);
        }
        .saveBtn{
            background:rgb(42, 155, 207);
            color:#fff;
        }
    </style>
</head>
<body style="position:absolute;left:0;right:0;top:0;bottom:0;">
<section  style="width:1200px;margin:0 auto;background:#fff;min-height:100%;">
    <form class="form form-horizontal" action="<%=request.getContextPath()%>/otherSpreadtrum/addOrUpdate.do" method="post">
    	<input type="hidden" value="${otherSpre.id}" name="id" />
        <div class="button_wrap">
            <h3>外省编辑展览信息</h3>
            <div class="butt_new">
                <a href="<%=request.getContextPath()%>/otherSpreadtrum/getOtherSpreadtrum.do?type=1">取消</a>
            </div>
            <div class="btn butt_new saveBtn" id="subBtn">
                保存
            </div>
        </div>

        <article class="cl pd-20" style="padding-left: 3rem">
            <p id="issue">
                <span id="issueTime" name="userName">发布人：<span>${otherSpre.nickName}</span></span>
            </p>
            <p><span class="c-red">*</span>标题：<input type="text" class="input-text" id="title" style="width: 50%" name="headline" value="${otherSpre.headline}"></p>
	        <p>展馆的名称：<input type="text" class="input-text" style="width: 50%" name="musExhibition" value="${otherSpre.musExhibition}"></p>
            <div style="padding-bottom: 1rem;">
                 <div class="clearfloat">
                     <span><span class="c-red">*</span>主图：</span>
                 	  <%-- <div  class="box" style="padding-left: 2rem;padding-top: 0.3rem">
                     	<img src="${otherSpre.pictureThumb}"  style="max-width:297px;max-height:167px;" alt="图片加载失败">
                     </div> --%>
                 	 <div  class="box" style="padding-left: 60px;padding-top: 0.3rem">
                     	<a href="#" class="btn btn-primary radius col-md-5" id="mypicture"><i class="Hui-iconfont">&#xe642;</i> 上传图片</a>
                     	<input type="hidden" name="picture" value="${otherSpre.picture}" id="picId"/>
                     	<img src="${otherSpre.pictureThumb}" id="image_id"  style="max-width:297px;max-height:167px;margin-top:50px;margin-left:-100px;" alt="图片加载失败">             
                     </div>
                 </div>
            </div>
            
            <div class="row cl">
                <label class="form-label" style="float: left;padding-left: 1rem;"><span class="c-red">*</span>内容：</label>
                <div class="formControls col-8" style="margin-left: 3.5rem;">
					<script id="editor" type="text/plain" name="content">${otherSpre.content}</script>
                </div>
            </div>
        </article>
    </form>
    <!--图片遮罩层开始-->
        <form id="uploadFormPic" enctype="multipart/form-data" method="post" >
	         <div id="coverPic">
	             <a href="javascript:;" class="Hui-iconfont c-white btn btn-danger close">&#xe6a6;</a>
	             <div class="row cl pt-20 pl-30 col-offset-1" style="padding-top: 120px;">
	                 <label class="col-xs-4 col-sm-3 text-r col-md-2 c-white lig" id="cTitle">请选择图片：</label>
	                 <div class="formControls col-xs-8 col-sm-9 col-md-8">
		                 <span class="btn-upload form-group">
		                     <input class="upload-url" type="text" name="uploadfile" id="uploadPic" readonly nullmsg="请添加附件！" style="outline: none;border: 1px solid #DDDDDD;height: 29px;">
		                     <a href="#" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
		         			<input type="file" name="file" class="input-file"  id="accIntPic">
		         			<input type="hidden" name="typeId" value="5">
		         			<input type="hidden" name="objectId" value=""/>
		    			 </span>
	                 </div>
	             </div>
	             <div class="row cl text-c pd-40">
	             	<input type="button" id="uploadPic_button" value="上传" class="btn btn-primary radius upload">
	                 <input type="reset" href="javascript:;" class="btn btn-danger radius ml-20" id="close" value="重置" />
	             </div>
	         </div>
         </form>
</section>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
	 //点击图片按钮
	$("#mypicture").click(function(){
	    $("#cTitle").html("请添加图片");
	    $("#coverPic").slideDown(500);
	});
	//点击关闭按钮
	$(".close").click(function(){
	    $("#coverPic").slideUp(300);
	});
	//上传图片
	$(function(){
		$("#uploadPic_button").click(function() {
			 var formData = new FormData($( "#uploadFormPic" )[0]);
			$.ajax({
				url : "<%=request.getContextPath() %>/file/uploadPicture.do&typeId=6",
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
	                	var a=$("#accIntPic")[0].files[0];
	                	var b = new FileReader();
	                	b.readAsDataURL(a);
	                	b.onload=function(){
	                		$("#image_id")[0].src=b.result;
	                		$("#picId")[0].value=data.picId;
	                	}
	                	console.log(data.url);
	                   layer.msg('[OK]上传成功', {icon: 1});
	                   setTimeout(function(){
							$.cookie('word_msg', '1'); 
						},1000);
	                   $("#coverPic").slideUp(300);
	                }
	            },
			})
		});
	});
	$(function(){
	       var ue = UE.getEditor('editor',{
	    	   initialFrameHeight: 400, 'enterTag':'',
	    	   toolbars: [
	               [
	   		        'insertimage', //多图上传
	   		        'justifyleft', //居左对齐
	   		        'justifyright', //居右对齐
	   		        'justifycenter', //居中对齐
	               ]
	           ],
	       });
	       UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
	   	   UE.Editor.prototype.getActionUrl = function(action){
		   		if(action == '/resource/upload/images'){
		   			return '<%=request.getContextPath() %>/aaaa/uploadImage.do';
		   		}else{
		   			return this._bkGetActionUrl.call(this, action);
		   		}
	   	}
	});
</script>
    <script type="text/javascript">
         function hasPrice(){
              var val = $("input:radio[name='exhibitioType']:checked").val();
              if(val == 0){
                   $("#dis").css({display:"block"});
              }
              if(val == 1){
                   $("#dis").css({display:"none"});
              }
         }
         hasPrice();
         $("input:radio[name='exhibitioType']").change(function(){
              hasPrice();
         });

         $("#subBtn").click(function(){
         <%--console.log(cont);--%>
              if($('input:radio[name="exhibitioType"]:checked').val() == 0 && ($("#datemin").val() == "" || $("#datemax").val() == "")){
                   layer.open({
                        title: '提示',
                        content: '您还没有选择展览日期'
                   });
                   return false;
              }else if($("#title").val() == ""){
                   layer.open({
                        title: '提示',
                        content: '您还没有添加标题'
                   });
                   return false;
              }else if($("#image_id").attr("src") == ""){
                   layer.open({
                        title: '提示',
                        content: '您还没有添加主图'
                   });
                   return false;
              }else if(UE.getEditor('editor').getContent() == ""){
                   layer.open({
                        title: '提示',
                        content: '您还没有添加内容'
                   });
                   return false;
              }else{
                   layer.open({
                       title: '提示',
                       content: '保存成功'
                   });
                   setTimeout(function(){
                       $("form")[0].submit();
                   },500);
              }
         })
    </script>
</body>
</html>