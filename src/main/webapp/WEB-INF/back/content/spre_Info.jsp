<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script> 
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
	<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script> --%>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.all.js"> </script>
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

    <title>编辑展览信息</title>
 <style>
     .Hui-article-box{
            overflow-x: hidden!important;
            overflow-y: auto!important;
            }
</style>
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
		    width: 1000px;height: 500px;background: rgba(0,0,0,0.7);position: fixed;left: 25%;top:20%;border:5px solid lightslategray;min-width: 800px; z-index:1000; display: none;
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
         overflow-y:auto!important;
        }
        <%--新改的样式--%>
        body{
            background:#fff!important;
        }
        *{
            padding:0;
            margin:0;
            box-sizing:border-box;
        }
        .contentWrap{
            width: 860px;
            margin:0 auto;
            background:#fff;
            padding:80px 0;
        }
        #subForm{
            border:2px solid #f1f2f7;
            border-radius:5px;
            overflow:hidden;
        }
        .fixedHead{
            width:860px;
            height:80px;
            position:fixed;
            top:0;
            left:50%;
            margin-left:-430px;
            background:#fff;
            z-index:1000;
            border-bottom:1px solid #f2f2f2;
            box-sizing:border-box;
        }
        .fixedHead > .title{
            width:200px;
            float:left;
            font-size: 18px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
            font-weight: bold;
            line-height: 80px;
        }
        .fixedHead > .btn_jilin{
            border-radius: 4px;
            width: 101px;
            height: 36px;
            float:right;
            text-align:center;
            line-height:36px;
            margin-top:22px;
            cursor:pointer;
        }
        .fixedHead > .btn_jilin > span{
            padding-left:8px;
            vertical-align:middle;
        }
        .fixedHead > .btn_jilin > img{
            vertical-align:middle;
        }
        .fixedHead > .confirm{
            background-color: rgb(42, 155, 207);
            color:#fff;
            margin-right:12px;
        }
        .fixedHead > .cancel{
            border:1px solid rgb(42, 155, 207);
            color:rgb(42, 155, 207);
        }
        .addMainPic{
            background-color: rgb(241, 242, 247);
            width: 100%;
            height: 175px;
        }
        .addMainPic > #imgWrap{
            width:100%;
            height:100%;
            text-align:center;
            cursor:pointer;
        }
        .addMainPic > #imgWrap > .newImg{
            width:100%;
            height:100%;
            object-fit:contain;
        }
        .addMainPic > #imgWrap > .addimg{
            margin-top:60px;
            width:34px;
            height:28px;
        }
        .addMainPic > #imgWrap > p{
            margin-top:10px;
            font-size: 18px;
            font-family: "PingFang";
            color: rgb(102, 102, 102);
            font-weight: bold;
        }
        .hide{
            display:none;
        }
        .show{
            display:block;
        }
        .addTitle{
            width:100%;
            height:56px;
            border-bottom:1px solid rgb(241, 242, 247);
            box-sizing:border-box;
        }
        .addTitle > input{
            width:100%;
            height:100%;
            font-size: 20px;
            font-family: "PingFang";
            outline:none;
            border:none;
            padding-left:8px;
        }
        .displayType{
            width:100%;
            height:37px;
            background:#f1f2f7;
            box-sizing:border-box;
            padding-left:6px;
            line-height:37px;
        }
        .radio-box{
            padding-left:0;
        }
        .addAudioBtn{
            width:100%;
            height:56px;
            background:#fff;
            padding-top:10px;
            padding-left:6px;
            box-sizing:border-box;
        }
        .addAudio {
            border-radius: 4px;
            background-color: rgb(42, 155, 207);
            width: 101px;
            height: 36px;
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(255, 255, 255);
            line-height: 36px;
            text-align:center;
            cursor:pointer;
        }
        .audioPlayer{
            width:100%;
            height:81px;
            background:#f1f2f7;
        }
        .audioPlayer > audio{
            width:312px;
            background:rgba(0,0,0,0.8);
            color:rgba(0,0,0,0.8);
            margin-top:26px;
        }
        .contentEdit{
            width:100%;
        }
        .edui-default .edui-editor{
            border:none!important;
        }
        .edui-default .edui-editor-toolbarboxouter{
            border-bottom:none!important;
            box-shadow:none!important;
        }
        .edui-default .edui-editor-iframeholder{
            background:rgb(241, 242, 247);
        }
        .edui-default .edui-toolbar{
            background:#fff;
        }
        #dis > input{
            margin-top:-3px;
            width:200px!important;
        }

        <%--弹出框的样式开始--%>
        #coverAudio{
            width: 100%;
            height: 100%;
            background: rgba(0,0,0,0.8);
            position: fixed;
            left: 0;
            top:0;
            z-index:1001;
        }
        .audioWrap{
            border-radius: 4px;
            background-color: rgb(255, 255, 255);
            position: absolute;
            left: 50%;
            top: 50%;
            margin-top:-194px;
            margin-left:-361px;
            width: 722px;
            height: 388px;
        }
        .coverTitle{
            width:100%;
            padding: 0 0 0 20px;
            height: 42px;
            line-height: 42px;
            border-bottom: 1px solid #eee;
            font-size: 14px;
            color: #333;
            overflow: hidden;
            background-color: #F8F8F8;
            border-radius: 2px 2px 0 0;
            box-sizing:border-box;
        }
        .close{
            width:80px;
            height:42px;
            background:#F8F8F8;
            float:right;
            border:none;
            outline:none;
            line-height:42px;
            text-align:right;
            padding:0 20px;
        }
        .coverContent{
            width:100%;
            height:345px;
            padding-top:110px;
        }
        .lig{
            line-height:30px;
            padding-left:80px;
            font-size: 16px;
            font-family: "Microsoft YaHei";
            color: rgb(51, 51, 51);
        }
        #uploadAudio{
            border: 1px solid rgb(42, 155, 207);
            border-radius: 4px;
            background-color: rgb(255, 255, 255);
            width: 275px;
            height: 31px;
            padding-left:10px;
            color:#dddddd;
        }
        .look{
            border-radius: 4px;
            background-color: rgb(42, 155, 207);
            width: 137px;
        }
        .btnWrap{
            padding-left:208px;
            padding-top:24px;
        }
        .btnWrap > .coverBtn{
            border-radius: 4px;
            width: 60px;
            height: 26px;
            line-height:26px;
            font-size: 14px;
            font-family: "Microsoft YaHei";
            float:left;
            padding:0 6px;
            text-align:justify;
            cursor:pointer;
        }
        .btnWrap > .coverBtn:nth-child(1){
            background-color: rgb(42, 155, 207);
            color:#fff;
        }
        .btnWrap > .coverBtn:nth-child(2){
            width: 62px;
            border: 1px solid rgb(42, 155, 207);
            color:rgb(42, 155, 207);
            margin-left:12px;
        }
    </style>
</head>
<body>
<section class="contentWrap">
    <form class="form form-horizontal" action="<%=request.getContextPath()%>/spreadtrum/addAndUpdate.do" method="post"  enctype="multipart/form-data" id="subForm">
    	<input type="hidden" value="${spreadtrum.id}" name="id">


        <div class="fixedHead">
            <div class="title">编辑展览</div>
            <div class="btn_jilin cancel" id="cancel"><img src="<%=request.getContextPath() %>/back/images/cancel.png"><span>取消</span></div>
            <div class="btn_jilin confirm submitall" id="subBtn"><img src="<%=request.getContextPath() %>/back/images/save.png"><span>保存</span></div>
        </div>

        <div class="addMainPic">
            <div id="imgWrap" class="upPic">
                <img class="addimg hide" id="upImgIcon" src="<%=request.getContextPath() %>/back/images/addPic.png">
                <p class="addWord hide" id="upMainImgWord">添加主图</p>
                <img id="image_id" class="newImg" src="${spreadtrum.pictureThumb}">
                <input type="hidden" name="picture" id="picId" value="${spreadtrum.picture}">
            </div>
        </div>

        <div class="addTitle">
            <input type="text" name="headline" placeholder="请输入展览名称" id="title" value="${spreadtrum.headline}">
        </div>

        <div class="displayType">
            <div class="radio-box">
                <input type="radio" id="radioOne" name="exhibitioType" value="0" ${spreadtrum.exhibitioType==0?'checked':''}>
                <label for="radioOne">临时展览</label>
            </div>
            <div class="radio-box">
                <input type="radio" id="radioTwo" name="exhibitioType" value="1" ${spreadtrum.exhibitioType==1?'checked':''}>
                <label for="radioTwo">常设展览</label>
            </div>
            <span class="text-c hide" style="text-align: left;" id="dis"> 展期：
                <input type="text" value="${spreadtrum.staTime}" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" name="staTime" class="input-text Wdate">
                到
                <input type="text" value="${spreadtrum.overTime}" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax" name="overTime"  class="input-text Wdate">
            </span>
        </div>

        <div style="clear:both;"></div>

        <div class="addAudioBtn">
            <div class="addAudio" id="myaudio"><i class="Hui-iconfont">&#xe600;</i> 添加音频</div>
        </div>

        <div class="audioPlayer">
            <audio controls src="${spreadtrum.audioPath }" preload="true"></audio>
        </div>
        <input type="text" class="input-text hidden" name="fAudio" value="${spreadtrum.fAudio }" id="upload_audio">

        <div class="contentEdit">
            <script id="editor" type="text/plain" style="width:856px;" name="content">${spreadtrum.content}</script>
        </div>
            <%--<p id="issue">--%>
                <%--<span id="issueTime">发布单位：<span class="f-14">${spreadtrum.musExhibition}</span></span>--%>
                <%--<span id="issuePerson" name="userName">发布人：<span>${spreadtrum.nickName}</span></span>--%>
            <%--</p>--%>

            <%--
            <p>编辑：<input id="title" type="text" class="input-text" style="width: 50%" name="editor" value="${spreadtrum.editor}"></p>
            --%>
            <%--<p class="mt-20">PC端虚拟展厅地址(URL)：<input type="text" id="pcurl" class="input-text" style="width: 50%" name="viPCUrl" value="${spreadtrum.viPCUrl}"></p>--%>
            <%--<p>移动端虚拟展厅地址(URL)：<input type="text" id="mobilurl" class="input-text" style="width: 50%" name="viMoveUrl" value="${spreadtrum.viMoveUrl}"></p>--%>
        </form>
         <!--音频遮罩层开始-->
        <form id="uploadFormAudio" enctype="multipart/form-data" method="post" >
	         <div id="coverAudio" class="hide">
                 <div class="audioWrap">
                     <div class="coverTitle">
                         添加音频
                         <div class="Hui-iconfont btn c-black close">&#xe6a6;</div>
                     </div>
                     <div class="coverContent">
                         <label class="c-white lig f-l" id="cTitle1">请选择音频文件：</label>
                         <span class="btn-upload form-group">
                             <input class="upload-url" type="text" name="uploadfile" id="uploadAudio" readonly placeholder = "请添加附件!">
                             <a href="#" class="btn btn-primary look"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
                             <input type="file" name="file" class="input-file"  id="accIntAudio">
                         </span>

                         <div class="btnWrap">
                             <div class="coverBtn" id="uploadAudio_button"><img src=""><i class="Hui-iconfont">&#xe642;</i> 上传</div>
                             <div class="coverBtn" id="resetClick"><img src=""><i class="Hui-iconfont">&#xe68f;</i> 重置</div>
                             <input type="reset" id="reset" class="btn ml-20 hide" value="重置">
                         </div>
                     </div>
                 </div>
	         </div>
         </form>
</section>

<script type="text/javascript">
    //点击临时展览和常设展览
    $(function(){
        $("#radioOne").click(function(){
            var val = $('input:radio[name="exhibitioType"]:checked').val();
            if(val == "0"){
                $("#dis").show();
            }else{
                $("#dis").hide();
            }
        });
        $("#radioTwo").click(function(){
            $("#dis").hide();
        })
    });
    //初始化富文本编辑器
	$(function(){
		var ue = UE.getEditor('editor',{
	        toolbars: [['source', 'indent','insertimage','justifyleft','justifyright','justifycenter','justifyjustify',]],
	        initialFrameHeight: 400
	    });
	    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
	    UE.Editor.prototype.getActionUrl = function(action){
	        if(action == '/resource/upload/images'){
	            return '<%=request.getContextPath() %>/aaaa/uploadImage.do';
	        }else{
	            return this._bkGetActionUrl.call(this, action);
	        }
	    };
	});

    //点击添加音频按钮
    $("#myaudio").click(function(){
        $("#coverAudio").show(0);
    });

    //点击关闭按钮
    $(".close").click(function(){
    	window.parent.location.reload(); //刷新父页面
    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    	parent.layer.close(index);  // 关闭layer
    });

    //点击图片按钮
    $("#imgWrap").click(function(){
        layer.open({
            type: 2,
            title: '裁剪图片',
            shadeClose: true,
            shade: 0.8,
            area: ['800px', '730px'],
            content: '<%=request.getContextPath() %>/cropper/crop.html' //iframe的url
        });
    });
    //点击保存
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
        	 $.ajax({
        			cache: true,
        			type: "POST",
        			url:  "<%=request.getContextPath()%>/spreadtrum/addAndUpdate.do",
        			data: $('#subForm').serialize(),// 你的formid
        			dataType:"json",
        			async: false,
        			success: function(data) {
        				if(data==0){
        				layer.msg('图片不存在', {icon: 2});
        				}else if(data ==1){
	        				layer.msg('保存成功', {icon: 1});
	        				setTimeout(function(){
	        					window.location.href = '<%=request.getContextPath()%>/spreadtrum/getSpreadtrum.do';
	        		        },2000);
        				}
        			}
        		});

         }
    });

    //点击取消按钮
    $("#cancel").click(function(){
        layer.confirm('您确定要退出本页面吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.closeAll();  //关闭弹出层
            window.history.back(-1);  //关闭弹出层
        }, function(){
            layer.closeAll();  //关闭弹出层
        });
    });

    //上传音频
    $(function(){
    	$("#uploadAudio_button").click(function() {
            if($( "#accIntAudio" ).val() == ""){
                layer.open({
                    title: '提示',
                    content: '您还没有添加任何音频'
                });
            }else{
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
                        }else if(data.error == 0){
                           layer.msg('[OK]上传成功', {icon: 1});
                           $("#upload_audio").attr("value",data.url);
                           $("audio").attr("src",data.src);
                           $("#coverAudio").hide(0);
                        }
                    }
    		    })
            }
    	});
    });
    //重置
    $("#resetClick").click(function(){
        $("#reset").click();
    })
</script>
</body>
</html>