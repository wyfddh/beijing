<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="A simple jQuery image cropping plugin.">
    <meta name="keywords" content="HTML, CSS, JS, JavaScript, jQuery plugin, image cropping, image crop, image move, image zoom, image rotate, image scale, front-end, frontend, web development">
    <meta name="author" content="Fengyuan Chen">
    <title>Cropper</title>
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/upload/jquery-publicity20151104/tailor/css/cropper.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/upload/jquery-publicity20151104/tailor/css/main.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->
<!-- Content -->
<div class="container">
    <div class="row">
        <div class="col-md-9">
            <!-- <h3 class="page-header">Demo:</h3> -->
            <div class="img-container">
                <img id="image" src="<%=request.getContextPath()%>/upload/jquery-publicity20151104/tailor/img/picture.jpg" alt="Picture">
            </div>
        </div>
    </div>
    <div class="col-md-3">
        <div class="docs-preview clearfix">
            <div class="img-preview preview-lg"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 docs-buttons">
            <div class="btn-group">
                <button type="button" class="btn btn-primary" data-method="setDragMode" data-option="move" title="Move">
            <span class="docs-tooltip" data-toggle="tooltip" title="移动图片">
              <span class="fa fa-arrows"></span>
            </span>
                </button>
                <button type="button" class="btn btn-primary" data-method="setDragMode" data-option="crop" title="Crop">
            <span class="docs-tooltip" data-toggle="tooltip" title="开始裁剪">
              <span class="fa fa-crop"></span>
            </span>
                </button>
            </div>

            <div class="btn-group">
                <button type="button" class="btn btn-primary" data-method="zoom" data-option="0.1" title="Zoom In">
            <span class="docs-tooltip" data-toggle="tooltip" title="放大">
              <span class="fa fa-search-plus"></span>
            </span>
                </button>
                <button type="button" class="btn btn-primary" data-method="zoom" data-option="-0.1" title="Zoom Out">
            <span class="docs-tooltip" data-toggle="tooltip" title="缩小">
              <span class="fa fa-search-minus"></span>
            </span>
                </button>
            </div>

            <div class="btn-group">
                <button type="button" class="btn btn-primary" data-method="move" data-option="-10" data-second-option="0" title="Move Left">
            <span class="docs-tooltip" data-toggle="tooltip" title="左移">
              <span class="fa fa-arrow-left"></span>
            </span>
                </button>
                <button type="button" class="btn btn-primary" data-method="move" data-option="10" data-second-option="0" title="Move Right">
            <span class="docs-tooltip" data-toggle="tooltip" title="右移">
              <span class="fa fa-arrow-right"></span>
            </span>
                </button>
                <button type="button" class="btn btn-primary" data-method="move" data-option="0" data-second-option="-10" title="Move Up">
            <span class="docs-tooltip" data-toggle="tooltip" title="上移">
              <span class="fa fa-arrow-up"></span>
            </span>
                </button>
                <button type="button" class="btn btn-primary" data-method="move" data-option="0" data-second-option="10" title="Move Down">
            <span class="docs-tooltip" data-toggle="tooltip" title="下移">
              <span class="fa fa-arrow-down"></span>
            </span>
                </button>
            </div>

            <div class="btn-group">
                <button type="button" class="btn btn-primary" data-method="reset" title="Reset">
            <span class="docs-tooltip" data-toggle="tooltip" title="重置">
              <span class="fa fa-refresh"></span>
            </span>
                </button>
                <label class="btn btn-primary btn-upload" for="inputImage" title="Upload image file">
                    <form method="post" id="uploadFormPic" enctype="multipart/form-data" id="pic">
                        <input type="file" class="sr-only" id="inputImage" name="file" accept=".jpg,.png">
                        <input type="hidden" id="tailor" name="tailor" vlaue="" >
                    </form>
                    <span class="docs-tooltip" data-toggle="tooltip" title="选择上传图片">
              <span class="fa fa-upload"></span>
            </span>
                </label>
            </div>
            <input type="button" id="uploadPic_button" value="上传图片" class="btn btn-success sc_btn">

        </div>
    </div>
</div>
<!-- Scripts -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script src="<%=request.getContextPath()%>/upload/jquery-publicity20151104/tailor/js/cropper.js"></script>
<script src="<%=request.getContextPath()%>/upload/jquery-publicity20151104/tailor/js/main.js"></script>
<script type="text/javascript">
//上传图片
$(function(){
	/* $("#image").cropper({
		aspectRatio:1/1,
		preview:'.img-container',
	    strict:true
	  });  */
	  var objectId = ${objectId};
	  var typeId = "";
	$("#uploadPic_button").click(function() {
		 var formData = new FormData($( "#uploadFormPic" )[0]);
		$.ajax({
			url : "<%=request.getContextPath() %>/file/uploadPicture.do?objectId = "+objectId+"&typeId="+typeId,
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
                console.log(formData);
                if(data.error == 0){
                   layer.msg('[OK]上传成功', {icon: 1});
                   setTimeout(function(){
                	    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
				        parent.layer.close(index);
						$.cookie('word_msg', '1'); 
						location.reload(true);
					},1000)
                }
            },
		})
	});
});

</script>
</body>	
</html>