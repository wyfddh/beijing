<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.lang.*,java.util.*,java.io.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>   
<%
   	Properties pro = new Properties();
   	String realpath = request.getRealPath("/WEB-INF/classes");
   	try {
   		//读取配置文件
   		FileInputStream in = new FileInputStream(realpath + "/config.properties");
   		pro.load(new InputStreamReader(in, "UTF-8"));
   	} catch (FileNotFoundException e) {
   		out.println(e);
   	} catch (IOException e) {
   		out.println(e);
   	}

   	//通过key获取配置文件
   	String fileSize = pro.getProperty("web.fileSize");
   	
   	String type = request.getParameter("type");//用request得到
   	String size = "1.3333333333333333";
   	if("1".equals(type)){
   		size = "1.3333333333333333";
   	}else if("2".equals(type)){
   		size = "0.75";
   	}else if("3".equals(type)){
   		size = "NaN";
   	}else if("4".equals(type)){
   		size = "1";
   	}else{
   		size = "1.3333333333333333";
   	}
   	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>图片裁剪</title>
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../back/lib/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../back/userMangermen/css/public.css" media="all" />
	<link rel="stylesheet" href="css/cropper.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/tether.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        @media (min-width: 576px) {
            .container{
                width: 760px;
                height: 285px;
            }
        }
        body{
            background-color: rgb(247, 247, 247);
        }
        .person{
            font-size: 12px;
            font-family: "NSimSun";
            color: rgb(31, 148, 145);
            line-height: 1.827;
            text-align: justifyLeft;
        }
        /* input{
            background-color: rgb(255, 255, 255);
            width: 240px;
            height: 20px;
            outline: none;
            border: none;
            font-size: 12px;
            margin-left: 10px;
        } */
        .warn{
            font-size: 12px;
            font-family: "NSimSun";
            color: rgb(204, 204, 204);
            line-height: 1.827;
            text-align: justifyLeft;
        }
    </style>
</head>
<body class="childrenBody">
<div class="layui-col-xs8">
	<div>
	    <div class="img-container">
	        <img id="image" src="img/cropperPic.jpg" alt="Picture">
	    </div>
	</div>
	<div class="row">
        <div class="col-md-12 docs-buttons">
            <!--重置上传图片-->
            <div class="btn-group btn-group-xs">
                <button type="button" class="btn btn-primary btn-sm" data-method="reset" title="重置" onclick="reset();">
                    <span class="docs-tooltip" data-toggle="tooltip" data-animation="false" title="重置">
                        <i class="layui-icon">&#xe9aa;</i>
                    </span>
                </button>
                <label class="btn btn-primary btn-upload btn-sm" for="inputImage" title="Upload image file">
                    <form id="registerForm" enctype="multipart/form-data"  method="post" action=""> <!-- class="sr-only" id="inputImage" -->
                        <input type="file" name="file" class="sr-only" id="inputImage" accept=".jpg,.jpeg,.png,.gif,.bmp,.tiff">
                        <input type="hidden" id="tailor" name="tailor" vlaue="" >
                        <input type="hidden" id="cezhan_id" name="id" vlaue="" >
                        <input type="hidden" id="num" name="num" vlaue="" >
                        <input type="hidden" id="commit_title" name="title" vlaue="" >
                    </form>

                    <span class="docs-tooltip" data-toggle="tooltip" data-animation="false" title="上传图片">
		                <i class="layui-icon">&#xe67c;</i>
		            </span>
                </label>
            </div>

            <!--确认选择和返回-->
            <button type="button" class="btn btn-success btn-sm confirm" style="cursor: pointer" title="确认上传">确认上传</button>

            <div class="modal fade docs-cropped" id="getCroppedCanvasModal" aria-hidden="true" aria-labelledby="getCroppedCanvasTitle" role="dialog" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="getCroppedCanvasTitle">Cropped</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body"></div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <a class="btn btn-primary" id="download" href="javascript:void(0);" download="cropped.jpg">Download</a>
                        </div>
                    </div>
                </div>
            </div>
            <div style="margin-bottom: 20px"></div>
        </div>
    </div>
</div>
<div class="layui-col-xs4" style="padding-left: 30px;">
	<div>
	    <div class="docs-preview clearfix" style="max-width: 98%;">
	        <div class="img-preview preview-lg" style="max-width: 100%;"></div>
	    </div>
	</div>
	<!-- <h3>Toggles:</h3> -->
	<div class="docs-toggles" style="margin-top: 30px;">
		<b>推荐尺寸</b><br><br>
		<label class="radio-inline" style="margin-left: 20px;display: none;" id="size43">
	        <input type="radio" id="aspectRatio1" name="aspectRatio" value="1.3333333333333333" title="【普通】4:3" checked>&nbsp;【4:3】普通
		</label>
		<label class="radio-inline" style="margin-left: 20px;display: none;" id="size34">
        	<input type="radio" id="aspectRatio2" name="aspectRatio" value="0.75" title="【学术期刊】3:4">&nbsp;【3:4】
		</label>
		<label class="radio-inline" style="margin-left: 20px;display: none;" id="size11">
        	<input type="radio" id="aspectRatio3" name="aspectRatio" value="1" title="【文创产品】1:1">&nbsp;【1:1】
		</label>
		<label class="radio-inline" style="margin-left: 20px;display: none;" id="sizeFree">
       		<input type="radio" id="aspectRatio4" name="aspectRatio" value="NaN" title="自定义">&nbsp;【自定义】
		</label>
	</div>
</div>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/tether.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/common.js"></script>
<script type="text/javascript" src="../back/lib/layui/layui.js"></script>
<script src="js/cropper.js"></script>
<script type="text/javascript">
    var size = '<%=size %>';
   	var type = '<%=type %>';
   	if(type == '1'){
 		$("#size43").show();
 		$("#aspectRatio1").prop('checked', true);
 	}else if(type == '2'){
 		$("#size34").show();
 		$("#aspectRatio2").prop('checked', true);
 	}else if(type == '3'){
 		$("#sizeFree").show();
 		$("#aspectRatio4").prop('checked', true);
 	}else if(type == '4'){
 		$("#size11").show();
 		$("#aspectRatio3").prop('checked', true);
 	}else{
 		$("#size43").show();
 		$("#aspectRatio1").prop('checked', true);
 	}
</script>
<script src="js/main.js"></script>
<script src="../back/lib/layer/2.4/layer.js"></script>
<script>
$('#image').cropper({
	aspectRatio: <%=size %>,
	strict:false,
	preview: '.img-preview',
	resizable:true
});
</script>
<script type="text/javascript">
    $(".confirm").click(function () {
        if(!$('#inputImage').val()){
            layer.msg("请先上传图片",{time:2000});
            return false;
        }
        var fileData = $("#inputImage");
        var size = fileData.get(0).files[0].size;
        var fileSize = '<%=fileSize %>';
        if(size > (parseInt(fileSize))*1024*1024){
        	layer.msg("图片超出大小，限制"+fileSize+"M",{time:2000});
            return false;
        }
        
        $("#tailor").val(JSON.stringify($("#image").cropper("getData")));
        var formData = new FormData($("#registerForm")[0]);
        console.log($("#image").cropper("getData"));
        $.ajax({
            url: '<%=request.getContextPath() %>/attach/cutPicture.do?projectName=publish',
            type: "post",
            data: formData,
            dataType: "json",
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (result) {
                console.log(result);
                if(result.code == 1){
                    var absoluteUrl = result.data.absolutePath;                               //图片的绝对url
                    var relativeUrl = result.data.resultPath;                               //图片的相对url
                    //再把url返回去保存
                    layer.msg("上传成功",{time:2000});
                    window.parent.setTitleImg(absoluteUrl, relativeUrl);
                    var index=parent.layui.layer.getFrameIndex(window.name);
                    parent.layui.layer.close(index);
                }else{
                    var errorMsg = result.data || result.error.message;
                    parent.layer.open({
                        title: '提示',
                        content: errorMsg
                    })
                }
            },
            error: function (errData) {
                layer.alert(errData.message,{
                    icon:0,
                    skin:'layer-ext-moon'
                });
            }
        });

    })
    
    function reset(){
    	location.reload();
    }
</script>
</body>
</html>