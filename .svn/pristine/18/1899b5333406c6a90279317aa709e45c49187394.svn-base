<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
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
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../../../back/lib/html5shiv.js"></script>
    <script type="text/javascript" src="../../../back/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/header.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/headUserGover.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/asideUserGover.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <!--/meta 作为公共模版分离出去-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <style type="text/css">
        a:hover{
            text-decoration: none;
        }
        .check-box, .radio-box{
            padding-left: 0;
        }
        .layui-layer-page .layui-layer-content{
            overflow-x: hidden!important;
        }
        .clearfix:after{content:"\20";display:block;height:0;clear:both;visibility:hidden}.clearfix{zoom:1}
	    .tabBar {border-bottom: 2px solid #222}
	    .tabBar span {background-color: #e8e8e8;cursor: pointer;display: inline-block;float: left;font-weight: bold;height: 30px;line-height: 30px;padding: 0 15px}
	    .tabBar span.current{background-color: #222;color: #fff}
	    .tabCon {display: none}
	    .size{
	       font-size:14px;
	       color:#2d2d2d;
	    }
	    .indent{
	       text-indent:2em;
	    }
	     .addHuoDong{
				overflow: hidden;
				height: 72px;
				border-bottom: 1px solid #F1F2F7;
			}
			.addHuoDong>span{
				margin: 20px 32px;
				    display: block;
			}
			.addHuoDong>span>a{
				background: #2A9BCF!important;
			}
			.addHuoDong>span>a:hover{
				border-color: #2A9BCF!important;
			}
			.huodong{
				padding: 30px;
			}
			.huodong input{
				line-height: 26px;
				border-radius: 5px;
			}
			.huodong>div{
				margin: 12px 0;
			}
			.huodong .star{
				margin-top: 20px;
			}
			.huodong .star button{
				background: #2A9BCF;
				color: #fff;
				border-radius: 5px;
			}
			.huodong .star button img{
				margin-top: -3px;
			}
			.huodong .star button.b2{
				background: #fff;
				color: #2A9BCF;
				border-color: #2A9BCF;
			}
			tbody .text-c{
				border-bottom: 1px solid #DDDDDD;
			}
			thead>tr{
				background: #F1F2F7!important;
				height: 60px!important;
				border-radius: 7px!important;
			}
			thead>tr>th{
				color: #666666!important;
			}
    </style>
    <script>
		
	</script>
    <title>以图搜图设置</title>
</head>
<body onselectstart="return false" style="-moz-user-select:none;">
<!--_heade 作为公共模版分离出去-->
<%@ include file="../organization/weihuNav.jsp"%>
<!--aside 作为公共模版分离出去-->
<%@ include file="../content/aside.jsp"%>
<!-- <header id="head"></header>
<aside id="manaside"></aside> -->
<!--<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>-->
<section  class="Hui-article-box">
    <!--<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 以图搜图设置 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>-->
	<div class="Hui-article">
	    <article class="">
	    	<div class="addHuoDong">
		          	<span class="1" style="font-size: 20px;font-weight: bold;">
		          		更新数据集
		          	</span>
	   	</div>
	        <div id="tab_demo" class="HuiTab">
                <!--<div class="tabBar cl"><span>更新数据集</span><span id='statusTab' style='display:none;'>更新图片库状态</span></div>-->
                <div class="tabCon">
		            <form class="form form-horizontal pl-30 mt-30 hidden" action="" method="post">
		            	<H1>基本设置</H1>
						<p class="size">此处为以图搜图基本设置，如需修改请联系服务提供商。</p>
	     				<p class="size" style="padding-left:15px;">数据集ID：<input class="input-text" style="width:500px;" type="text" name="image_set_id" value='k1vl7dzw'></p>
						<p class="size">服务ID：<input class="input-text" style="width:500px;" name="service_id" value='lzsiqi6s'></p>
                        <button id="commitConfig" type="button" disabled='disabled' class="btn btn-primary radius disabled">&nbsp;&nbsp;提交&nbsp;&nbsp;</button>
		            </form>
		            <form id="startForm" class="form form-horizontal mt-30" action="<%=request.getContextPath() %>/back/picture/restart.do" method="post">
						<p class="size indent">第三方以图搜图供应商的数据集中保存以图搜图返回的图片集合，数据集中的图片越多，以图搜图的结果越准确。</p>
		            	<p class="size indent">数据集只使用平台公开藏品的图片数据，你可以提交一定比例的公开藏品图片到以图搜图的数据集。初始化状态的数据集使用测试数据，没有使用真实藏品数据。</p>
		            	<p class="size indent">更新数据集根据提供藏品数量不同，会有几十分钟到几小时的更新时间；</p>
		            	<p class="size indent">在完成提交后，以图搜图系统会根据图片生成索引，根据藏品数量的不同，会有若干天的索引生成时间。</p>
		            	<p class="size indent">目前数据集使用的公开藏品数据百分比为：<span>0</span></p>
		            	<p class="size indent">
		            		<input type="checkbox" id='check' name='check' vlaue="1">
		            		同意更新数据集，提供公开藏品主图百分比为：
							<span class="select-box ml-30" style="width:300px">
								<select name='setPercentage' class="select" size="1" value="0" style="width:260px">
			            			<option value='100'>100%</option>
			            			<option value='70'>70%</option>
			            			<option value='50'>50%</option>
			            			<option value='30'>30%</option>
			            			<option value='10'>10%</option>
			            		</select>
							</span>
						</p>
						<p class="size indent">
	                        <button id="start" type="button" class="btn btn-primary radius">&nbsp;&nbsp;更新数据集&nbsp;&nbsp;</button>
                        </p>
		            </form>
    			</div>
                <div class="tabCon">
	        		<div class="row cl mt-30 ml-10">
	            		<label class="f-l size">生成进度：</label>
	            		<div class="f-l size">
						    <!-- The global progress bar -->
						    <div id="progress" class="progress" style="width:100%!important" >
						        <div class="progress-bar progress-bar-success" style="width:0" ></div>
						    </div>
			    		    <p class="mt-10">
							    <span>运行状态：</span><span id="status"></span>
						    </p>
			    		    <p class="mt-10">
							    <span>提示信息：</span><span id="message"></span>
						    </p>
			    		    <p class="mt-10">
							    <span>上一次错误：</span><span id="error"></span>
						    </p>
	            		</div>
	            		<div class="col-xs-3 col-sm-3"></div>
	        		</div>
	   			 </div>
	        </div>
	    </article>
	</div>
</section>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
	<script>
	
		$(function(){
			var level = ${level};
			if (level == 2) { 
				$(".fabu-aside>ul>li").eq(2).addClass("weihu");
			} else {
				$(".fabu-aside>ul>li").eq(3).addClass("weihu");
			}
			$(".headerNav a.yitusoutu").addClass("active");
			$(".headerNav a.yitusoutu").find("img").attr("src",'<%=request.getContextPath() %>/back/images/yituicon.png');
			var timeinteval=null;
			$.ajax({
				url:"<%=request.getContextPath() %>/back/pictureSearch/status.do",
				type:'POST',
				data: {},
				datetype:'json',
				success:function(msg){
					if(msg.status!="未开始"){
						$("#start").attr('disabled','disabled');
						$("#start").addClass('disabled');
						$('#statusTab').show();
						timeinteval=setInterval(function(){
							$.ajax({
								url:"<%=request.getContextPath() %>/back/pictureSearch/status.do",
								type:'POST',
								data: {},
								datetype:'json',
								success:function(msg){
									play_status(msg);
								}
							});
						},3000);
					}
				}
			});
			$("#start").click(function(){
				if(!$('#check').prop('checked')){
					alert("请确认提供公开藏品图片");
					return false;
				}
				var data=$('#startForm').serialize();
				$.ajax({
					url:"<%=request.getContextPath() %>/back/pictureSearch/start.do",
					data:data,
					type:'POST',
					datetype:'json',
					success:function(msg){
						switch(msg){
						default:
							$("#start").attr('disabled','disabled');
							$("#start").addClass('disabled');
							$('#statusTab').show();
							timeinteval=setInterval(function(){
								$.ajax({
									url:"<%=request.getContextPath() %>/back/pictureSearch/status.do",
									type:'POST',
									data: {},
									datetype:'json',
									success:function(msg){
										play_status(msg);
									}
								});
							},3000);
						}
		            }
				});
			});
		});
		function play_status(msg){
			$('#status').html(msg.status);
			$('#message').html(msg.message);
			$('#error').html(msg.error);
			$('#progress .progress-bar').css(
		            'width',
		            msg.process + '%'
		     );
			if(msg.status=="处理完成")
				clearInterval(timeinteval);
		}
		$(function(){
			$.Huitab("#tab_demo .tabBar span","#tab_demo .tabCon","current","click","0")}
		);
	</script>
</body>
</html>