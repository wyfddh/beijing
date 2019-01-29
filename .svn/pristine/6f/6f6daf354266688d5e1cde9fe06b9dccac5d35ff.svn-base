<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="bitbug_favicon.ico">
    <link rel="Shortcut Icon" href="bitbug_favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/backstatic/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/backstatic/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/backlib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/backstatic/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/backstatic/h-ui.admin/css/style.css"/>
    <style>
        .Hui-article-box{
            overflow-x: hidden!important;
            overflow-y: auto!important;
        }
        .ziti{
            line-height: 40px;
        }
        .zj_museuminfo_save {
		      
			background-color: #2a9bcf;
			color: white;
			padding: 9px 15px 9px 35px;
			border-radius: 5px;
			text-decoration: none;
			height: 18px;
			line-height: 18px;
			border: 1px solid #2a9bcf;
			height: 36px;
			background-image: url(<%=request.getContextPath() %>/back/images/save.png);
			background-repeat: no-repeat;
			background-position: 10px center;
			margin: 12px 0 12px 0px;
		}
		.museuminfo_del {
		                
			background-color: #2a9bcf;
			color: white;
			padding: 9px 15px 9px 35px;
			border-radius: 5px;
			text-decoration: none;
			height: 18px;
			line-height: 18px;
			border: 1px solid #2a9bcf;
			height: 36px;
			background-image: url(<%=request.getContextPath() %>/back/images/save.png);
			background-repeat: no-repeat;
			background-position: 10px center;
			margin: 12px 0 12px 0px;
		
		}
    </style>
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>栏目修改</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
</head>
<body>
<div class="dislpayArrow hidden-xs">
    <a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<section class="Hui-article-box section_box">
    <div>
        <form id="test1">
            <div>
                <div>
                	<input type="hidden" value='${name}' name='name'>
                    <input type="hidden" value="${id}" name="id">
                    <script id="editor" type="text/plain" name="value">${museumList}</script>
                </div>
            </div>
            <div>
	            <input type="button" class="zj_museuminfo_save" value="保存"> 
	            <input type="button" class="museuminfo_del" value="删除" name="${id }" onclick="deleteInfo(this.name)"> 
            </div>
   	 </form>   
   </div>
</section>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<!--<script type="text/javascript" src="<%=request.getContextPath() %>lib/jquery/1.9.1/jquery.min.js"></script>-->
<!-- <script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.page.js"></script>

<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> -->
<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.all2.js"> </script>

<script type="text/javascript">
	function deleteInfo(id) {
		var data = {"id":id};
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath()%>/museumColumn/delMuseumColumn.do",
			data:data, 
			async: true,  
			success: function(data) {
// 				$(".layui-layer-shade",parent.document).click();  
				parent.location.reload();
// 				window.location.href="/admin/museuminfo/getMuseumPage.do";  
            }, 
		})
		
	}   
	$(".zj_museuminfo_save").on("click",function(e){
		
		$.ajax({
            type: "POST",
            url:"<%=request.getContextPath()%>/museumColumn/updateMuseumColumn.do",
            data:$('#test1').serialize(),// 你的formid
            async: true,
            success: function(data) {
            	
            	
                $(".layui-layer-shade",parent.document).click();
                
            },
            error:function(){
            }
        });
		
		
	});
	
	


    var ue = UE.getEditor('editor',{
    	initialFrameHeight: 400,
    	toolbars: [
            [
		        'indent',		//首行缩进
		        'insertimage', //多图上传
		        'justifyleft', //居左对齐
		        'justifyright', //居右对齐
		        'justifycenter', //居中对齐
            ]
        ],
    });
    
    
    
    
</script>
</body>
</html>