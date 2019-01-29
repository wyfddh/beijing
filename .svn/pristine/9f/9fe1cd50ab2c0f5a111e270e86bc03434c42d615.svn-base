<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="Bookmark" href="favicon.ico" >
    <link rel="Shortcut Icon" href="favicon.ico" />
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
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <!--/meta 作为公共模版分离出去-->
    <title>添加水印</title>
    <style>
    	.cover{
    		width:440px;
    		height:350px;
    		background:rgba(255,255,255,1);
    		position:absolute;
    		left:50%;
    		top:50%;
    		margin-left:-350px;
    		margin-top:-175px;
    		display:none;
    		border:6px solid rgba(100,100,100,0.8);
    		border-redius:5px;
    		padding-left:60px;
    	}
    	.head{
    		width:100%;
    		height:25px;
    		background:white;
    		padding-bottom:30px;
    	}
    	.close{
    		width:25px;
    		height:25px;
    		color:red;
    		line-height:25px;
    		text-align:center;
    		font-size:16px;
    		position:absolute;
    		right:0;
    		top:0;
    	    background:red;
    	}
    	.tag{
    		padding:10px 0 10px 0;
    	}
    	.tag span{
    		font-size:16px;
    		padding-right:20px;
    	}
    	.tag input{
    		height:25px;
    		width:280px;
    		border:1px solid #ccc;
    		outline:none;
    		padding-left:10px;
    	}
    	.beizhu{
    		padding-left:32px;
    	}
    	.btnWrap{
    		margin-top:30px;
    	}
    	.Hui-article-box{
    		overflow-y:scroll!important;
    	}
		.bgcolor{
			padding:30px 100px 0 30px;
			background:#fff;
			background-size:contain;
		}
		.imgWrap{
			width:202px;
			height:72px;
			background:#f2f2f2;
			margin-top:30px;
		}
		.imgWrap > img{
			width:100%;
			height:100%;
		}
		.red{
			color:#8b322d;
		}
		.loading{
			width:136px;
			height:10px;
			position:absolute;
			left:50%;
			margin-left:-68px;
			top:50%;
			margin-top:-5px;
			display:none;
		}
    </style>
</head>
<body>
<!--_header 作为公共模版分离出去-->
 <%@ include file="../../organization/weihuNav.jsp"%>

<!--_menu 左边slide导航开始-->
 <%@ include file="../aside.jsp" %> 
<!--/_menu 作为公共模版分离出去-->
<section class="Hui-article-box section_box bgcolor">
    <div class="btn btn-primary radius size-L addWaterImg" id="upWaterImg"  type="button">上传水印</div>
    <span class="red">请上传<font color="red"><em> <500K </em></font>大小的图片，尺寸为202*72，格式必须为<font color="red"><em> png </em></font></span>
     
    <input type="text" id="museumId" value="${objectId}" name = "objectId" hidden style="display:none;">
    <div class="imgWrap">
   		<img id="waterImg" src='${waterMarkPath}'>
    </div>
	<img class="loading" src="<%=request.getContextPath() %>/back/images/waiting.gif">
	
    <div class="btn btn-secondary radius size-M addWaterImg mt-30" id="previewWaterImg"  type="button">预览</div>
	<div class="btn btn-secondary radius size-M addWaterImg mt-30" id="resetDefault" style="margin-left:20px;"  type="button">还原默认水印</div>
	<br/>

    <div class="btn btn-primary radius size-L addWaterImg mt-30" id="addWaterImg" style="display:none;" type="button">批量添加</div>
	
   
</section>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
	$(".fabu-aside>ul>li").eq(0).addClass("fabu");
	$(".headerNav").find(".waterImg").addClass("active");
	var layerConfirm;
	isAddWatermark();
	var intervalTime = 3000;
	function isAddWatermark(){
		$.ajax({
			type: "GET",
			async:false,
			url: "<%=request.getContextPath() %>/image/isAddWatermark.do",
			success: function(result){
				if(result.success == 1){
					$("#addWaterImg").show();
				} else {
					$("#addWaterImg").hide();
				}
				
			}
		});
	}
	$('#resetDefault').click(function(){
		$.ajax({
			type: "GET",
			async:false,
			url: "<%=request.getContextPath() %>/image/resetDefaultWatermark.do",
			success: function(result){
				if(result.success == 1){
					layer.msg("还原成功",{time:intervalTime});
					$('#waterImg').attr("src", result.data);
					$("#addWaterImg").hide();
				} else {
					layer.msg("还原失败",{time:intervalTime});
				}
				$(".loading").css({display:"none"});
			}
		});
	});
    $("#upWaterImg").click(function(){
        layer.open({
            type: 2,
            title: '图片裁剪',
            shadeClose: true,
            shade: 0.8,
            area: ['800px', '730px'],
            content: '<%=request.getContextPath() %>/cropper/cropWaterImg.html',
            end: function () {
                location.reload();
            }
        });
    });

	function useWaterMark(){
		$.ajax({
			type: "GET",
			async:false,
			url: "<%=request.getContextPath() %>/image/printWatermark.do",
			success: function(result){
				if(result.success == 1){
					layer.msg(result.data,{time:intervalTime});
					$(".loading").css({display:"none"});
				} else {
					layer.msg(result.data,{time:intervalTime});
					$(".loading").css({display:"none"});
				}
			}
		});
	}

	$("#addWaterImg").click(function(){
		layerConfirm = layer.confirm('这个过程可能会持续很长时间，并且再次批量处理水印的时间是在5天后，请谨慎操作，是否继续？', {
			btn: ['继续','取消'] //按钮
		}, function(){
			$(".loading").css({display:"block"});
			layer.closeAll();
			setTimeout(function() {
				useWaterMark();
			},500)
		}, function(){
			layer.closeAll();  
		});
	});
	
	$("#previewWaterImg").click(function(){
		$.ajax({
			type: "GET",
			async:false,
			url: "<%=request.getContextPath() %>/image/testWatermarkForTest.do",
			success: function(data){
				if(data.success == 1){
					var imgUrl = data.data;
					var json = {
							  "title": "图片预览", //相册标题
							  "id": 123, //相册id
							  "start": 0, //初始显示的图片序号，默认0
							  "data": [   //相册包含的图片，数组格式
							    {
							      "alt": "效果展示图片",
							      "pid": 666, //图片id
							      "src": imgUrl, //原图地址
							      "thumb": "" //缩略图地址
							    }
							  ]
							}
					  layer.photos({
					    photos: json,
					    shade: 0.1,
					    anim: 1 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
					  });
						
				} else {
					layer.msg("图片跑丢了...",{time:100});
				}
			}
		});
	})

    
</script>
</body>
</html>