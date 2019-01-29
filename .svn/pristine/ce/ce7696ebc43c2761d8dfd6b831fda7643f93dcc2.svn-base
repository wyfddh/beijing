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
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="Bookmark" href="<%=request.getContextPath()%>/back/favicon.ico">
		<link rel="Shortcut Icon" href="<%=request.getContextPath()%>/back/favicon.ico" />
		<!--[if lt IE 9]>
<script type="text/javascript" src="back/lib/html5.js"></script>
<script type="text/javascript" src="back/lib/respond.min.js"></script>
<![endif]-->
		<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui/css/H-ui.min.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/H-ui.admin.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/style.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/css/cover.css" />
		<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
		<!--/meta 作为公共模版分离出去-->
		<style type="text/css">
			.addHuoDong {
				overflow: hidden;
				height: 72px;
				border: none!important;
			}
			
			.addHuoDong>span {
				margin: 20px 32px;
				display: block;
			}
			
			.addHuoDong>span>a {
				background: #2A9BCF!important;
			}
			
			.addHuoDong>span>a:hover {
				border-color: #2A9BCF!important;
			}
			
			.huodong {
				padding: 30px;
				padding-bottom: 0;
			}
			
			.huodong input {
				line-height: 26px;
				border-radius: 5px;
			}
			
			.huodong>div {
				margin: 12px 0;
			}
			
			.huodong .star {
				margin-top: 20px;
			}
			
			.huodong .star button {
				background: #2A9BCF;
				color: #fff;
				border-radius: 5px;
			}
			
			.huodong .star button img {
				margin-top: -3px;
			}
			
			.huodong .star button.b2 {
				background: #fff;
				color: #2A9BCF;
				border-color: #2A9BCF;
			}
			
			tbody .text-c {
				border-bottom: 1px solid #DDDDDD;
			}
			
			thead>tr {
				background: #F1F2F7!important;
				height: 60px!important;
				border-radius: 7px!important;
			}
			
			thead>tr>th {
				color: #666666!important;
			}
			
			.nav {
				height: 60px;
				line-height: 60px;
				padding-left: 30px;
				color: #999999;
				border-bottom: 1px solid #F1F2F7;
			}
			
			.nav span {
				color: #333333;
			}
			
			#layer111 .layui-layer-title {
				height: 60px !important;
				line-height: 60px !important;
				background: #2A9BCF !important;
				color: #FFFFFF !important;
			}
			
			#layer111 .layui-layer-ico {
				background: url('<%=request.getContextPath() %>/back/images/layericon.png') no-repeat;
			}
			
			#layer111 .layui-layer-setwin {
				top: 24px!important;
			}
			/*添加视频样式*/
			
			.addVideoIMG {
				display: none;
			}
			
			.addVideoIMG .body {
				padding: 30px;
			}
			
			.addVideoIMG .body label {
				display: inline-block;
				text-align: right;
				width: 60px;
				;
				margin-right: 15px;
			}
			
			.addVideoIMG .body div.one {
				height: 40px;
				margin-bottom: 15px;
			}
			
			.addVideoIMG .body div.one input {
				height: 40px;
				line-height: 40px;
				border: 1px solid #F1F2F7;
				background: #FCFCFC;
				border-radius: 4px;
				width: 350px;
				padding-left: 15px;
			}
			
			.addVideoIMG .body div.one1 input {
				width: 245px;
			}
			
			.addVideoIMG .body div.one1 a {
				display: inline-block;
				text-align: center;
				color: #2A9BCF;
				height: 40px;
				line-height: 40px;
				border: 1px solid #2A9BCF;
				background: #DFF0F8;
				border-radius: 4px;
				width: 80px;
				margin-left: 20px;
				text-decoration: none;
			}
			
			.addVideoIMG .body div img {
				border: 1px solid #F1F2F7;
				border-radius: 5px;
				cursor: pointer;
			}
			
			.addVideoIMG .footer a.left {
				display: inline-block;
				width: 216px;
				height: 40px;
				text-align: center;
				line-height: 40px;
				background: #2A9BCF;
				color: #FFFFFF;
				margin-right: 20px;
				border-radius: 5px;
				text-decoration: none;
				margin-top: 5px;
			}
			
			.addVideoIMG .footer a.right {
				display: inline-block;
				width: 216px;
				height: 40px;
				text-align: center;
				line-height: 40px;
				border: 1px solid #DFDFDF;
				color: #666666;
				border-radius: 5px;
				text-decoration: none;
				margin-top: 5px;
			}
			#model{
				position: fixed;
				top: 0;
				left: 0;
				right:0;
				bottom: 0;
				background: rgba(0,0,0,.7);
				z-index: 99999999999999999999999999999;
				display: none;
			}
			#model .box{
				position: absolute;
				top:50%;
				left: 50%;
				width: 514px;
				height: 148px;
				margin-top:-74px;
				margin-left: -257px;
				background: #fff;
				border-radius: 5px;
			}
		</style>
		<script>
			$(function() {
				$(".fabu-aside>ul>li").eq(0).addClass("fabu");
				$(".headerNav a.vedio").addClass("active");
				$(".headerNav a.vedio").find("img").attr("src", '<%=request.getContextPath() %>/back/images/vediologoicon.png');
			})
		</script>
		<title>虚拟展厅列表</title>
	</head>

	<body>

		<!--_header 作为公共模版分离出去-->
		<%@ include file="../fabuNav.jsp"%>

		<!--_menu 左边slide导航开始-->
		<%@ include file="aside.jsp" %>
		<!--/_menu 作为公共模版分离出去-->

		<section class="Hui-article-box">
			<!--<nav class="breadcrumb"><i class="Hui-iconfont">
	</i> <a href="/" class="maincolor">内容管理</a> <span class="c-999 en">&gt;</span><span class="c-666">展厅列表</span> <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>-->
			<!-- 数据内容 -->
			<div class="Hui-article">
				<article class="">
					<div class="nav">
						首页>发布><span>视频</span>
					</div>
					<div class="addZhanxun" style="border:none">
						<%-- <c:if test="${fn:contains(sessionScope.user.level,3)==true && fn:contains(sessionScope.user.authStr,'contentAdmin')==true}"> --%>
							<span class="l">
									<a class="btn btn-primary radius" onclick="addVideo()" data-title="添加视频" href="javascript:"><i class="Hui-iconfont">&#xe600;</i> 添加视频</a>
							</span>
						<%-- </c:if> --%>
					</div>
					<div class="" style="min-width: 1020px;padding-left: 30px">
						<span class="r" style="margin-right:35px;">共<strong style="color: #57AAD6;">${page.allRow}</strong>条数据</span>
					</div>
					<!--<div>
			
				<span class="r">共有数据：<strong>${virtualList.page.allRow}</strong> 条</span>
			</div>-->
					<div style="min-width: 990px;padding-left: 30px;">
						<table class="table">
							<thead>
								<tr class="text-c">
									<th width="10">序号</th>
									<th width="80">封面</th>
									<th width="80">视频名称</th>
									<th width="80">发布时间</th>
									<th width="100">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${videoList}" var="virtual" varStatus="status">
									<tr class="text-c">
										<td>${status.count}</td>
										<td>
												<div style="position: relative;">
													<img width="120" height="80" src="${virtual.imgUrl}" alt="" />
													<img  onclick="playVideo('${virtual.url}')"  class="play2" style="position: absolute;top:50%;left: 50%;margin-left: -16px;margin-top: -16px; cursor: pointer;"  src="<%=request.getContextPath() %>/back/images/playPoFang.png" alt="" />
												</div>
										</td>
										<td>${virtual.name}</td>
										<td>
											<fmt:parseDate value="${virtual.createTime}" pattern="yyyyMMddHHmmss" var="date"></fmt:parseDate>
     								<fmt:formatDate value="${date}"  pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<!-- 预览的地址栏需要修改 -->
										<td>
											<a title="编辑"  onclick="setVideo('${virtual.id}','${virtual.name}','${virtual.imgUrl}','${virtual.url}')" class="ml-5" style="text-decoration:none;color: #2A9BCF;">
												编辑
											</a>
											<a title="删除" onclick="deleteVideo('${virtual.id}')" class="ml-5" style="text-decoration:none;color: #2A9BCF;">
												删除
											</a>
										</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
					<br>
					<div id="page" style="padding-left: 30px;"></div>
				</article>
			</div>
		</section>
		<div id="layer111">
			<div id="addVideoIMG" class="addVideoIMG">
				<div class="body">
					<div class="one">
						<label for="title">标题:</label>
						<input id="title" type="text" maxlength="10" placeholder="请输入视频标题，不超过10个字" />
					</div>
					<div class="one one1">
						<label for="title">视频文件:</label>
						<input id="readonly" readonly="readonly" type="text" placeholder="请选择视频文件" />
						<a id="uploadVideo" href="javascript:">浏览</a>
						<input type="file" id="file_upload" hidden="hidden" />
					</div>
					<div class="vedio">
						<label for="title">视频封面:</label>
						<img id="uploadImg" width="135" height="90" src="<%=request.getContextPath() %>/back/images/uploadImg.png" alt="" />
						<input type="file" id="img_upload" hidden="hidden" />
					</div>
				</div>
				<div class="footer">
					<a id="uploadSave" class="left" href="javascript:">确认上传</a>
					<a id="quxiao" class="right" href="javascript:">取消</a>
				</div>
			</div>
			<div id="delete" class="addVideoIMG">
				<div class="body" style="padding: 0;text-align: center;">
					<img src="<%=request.getContextPath() %>/back/images/deleteVideo.png" alt="" />
				</div>
				<div class="footer">
					<a id="delSave" id="" class="left" href="javascript:">确认</a>
					<a id="delquxiao" class="right" href="javascript:">取消</a>
				</div>
			</div>
			<div id="setVideo" class="addVideoIMG">
				<div class="body">
					<div class="one">
						<label for="title1">标题:</label>
						<input id="title1" type="text" maxlength="10" placeholder="请输入视频标题，不超过10个字" />
					</div>
					<div class="one one1">
						<label for="readonly1">视频文件:</label>
						<input id="readonly1" readonly="readonly" type="text" placeholder="请选择视频文件" />
						<a id="uploadVideo1" href="javascript:">浏览</a>
						<input type="file" id="file_upload1" hidden="hidden" />
					</div>
					<div class="vedio">
						<label for="uploadImg1">视频封面:</label>
						<img id="uploadImg1" width="135" height="90" src="<%=request.getContextPath() %>/back/images/uploadImg.png" alt="" />
						<input type="file" id="img_upload1" hidden="hidden" />
					</div>
				</div>
				<div class="footer">
					<a id="uploadSave1" class="left" href="javascript:">确认上传</a>
					<a id="quxiao1" class="right" href="javascript:">取消</a>
				</div>
			</div>
			
			<div id="delete1" class="addVideoIMG">
				<div class="body" style="padding: 0;text-align: center;">
					<img src="<%=request.getContextPath() %>/back/images/setVideo.png" alt="" />
				</div>
				<div class="footer">
					<a id="delSave1" class="left" href="javascript:">确认</a>
					<a id="delquxiao1" class="right" href="javascript:">取消</a>
				</div>
			</div>
			
		</div>
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
		
		
		<script type="text/javascript">

			function addVideo() {
				layer.open({
					type: 1,
					title: '上传视频',
					shadeClose: true,
					shade: 0.5,
					area: ['510px', '410px'],
					content: $("#addVideoIMG"),
				});
			}
			//播放
			function playVideo(url) {
				$(".Hui-article-box").css("z-index","0");
				$(".Hui-aside").css("z-index","0");
				layer.open({
					type: 1,
					title: false,
					closeBtn: 0,
					shadeClose: true,
					area: ['900px', '600px'],
//					skin: 'yourclass',
					content:'<video id="video" autoplay style="background:#000000;" width="900" height="600" src='+url+' controls="controls">您的浏览器不支持 video 标签。</video>'
				});
			}
			//编辑
			function setVideo(id,name,imgUrl,url){
				console.log(id)
				console.log(name)
				console.log(imgUrl)
				console.log(url)
				did=id;
				$("#title1").val(name);
				$("#readonly1").val(url);
				$("#uploadImg1").attr("src",imgUrl);
				layer.open({
					type: 1,
					title: '上传视频',
					shadeClose: true,
					shade: 0.5,
					area: ['510px', '410px'],
					content: $("#setVideo"),
				});
			}
			//删除
			function deleteVideo(id) {
				delId = id;
				layer.open({
					type: 1,
					title: '上传视频',
					shadeClose: true,
					shade: 0.5,
					area: ['510px', '332px'],
					content: $("#delete"),
				});
			}
			$(function() {
				var imgUrl = ""; //图片封面上传参数
				var urlVideo = ""; //视频地址
				//删除视频取消
				$("#delquxiao").on("click", function() {
					layer.closeAll();
				})
				//删除视频确认
				$("#delSave").on("click", function() {
					$.ajax({
						type:"post",
						url:"<%=request.getContextPath() %>/videoSearch/delectVideo.do",
						data:{id:delId},
						dateType:"json",
						success:function(data){
							console.log(data);
							layer.closeAll();
							layer.msg("删除成功")
							setTimeout(function(){
								window.location.reload();
							},500)
						}
					});
				})
				//添加视频撤销
				$("#quxiao").on("click", function() {
					layer.closeAll();
					$("#title").val("");
					$("#file_upload").val("");
					$("#readonly").val("");
					$("#img_upload").val("");
					$("#uploadImg").attr("src","<%=request.getContextPath() %>/back/images/uploadImg.png");
				})
				//upload 上传保存
				$("#uploadSave").on("click",function(){
					var name = $("#title").val();
					if(name){
						if(urlVideo){
							if(imgUrl){
								//发送保存请求
								$.ajax({
									type:"post",
									url:"<%=request.getContextPath() %>/videoSearch/saveVideo.do",
									dateType:"json",
									data:{name:name,imgUrl:imgUrl,url:urlVideo},
									success:function(data){
										console.log(data);
										if(data=="success"){
											layer.closeAll();
											layer.open({
											  type: 1,
											  title: false,
											  closeBtn: 0,
											  shadeClose: true,
											  area: ['520px', '160px'],
//											  skin: 'yourclass',
											  content: '<img src="<%=request.getContextPath() %>/back/images/successSave.png" />'
											});
											setTimeout(function(){
												window.location.reload();
											},500)
										}else{
											layer.msg("保存失败，请稍后再试") 
										}
									}
									
								});
							}else{
								layer.msg("请先上传视频封面")
							}
						}else{
							layer.msg("请先上传视频")
						}
					}else{
						layer.msg("视频名称不能为空")
					} 
				})
				//添加视频浏览
				$("#uploadVideo").on("click", function() {
					$("#file_upload").click();
				})
				
				var input = document.getElementById("file_upload");  
				//文件域选择文件时, 执行readFile函数  
				input.addEventListener('change',readFile,false);
				function readFile(){   
				    file = this.files[0];   
				    upload();
				}  
				//上传文件  
				function upload(){  
				        var xhr = new XMLHttpRequest();  
				  
				        var fd = new FormData();  
				  
				        fd.append("file", file);  
				  
				        //监听事件  
				        xhr.upload.addEventListener("progress", uploadProgress, false);  
				  
				        //发送文件和表单自定义参数   
				        xhr.open("POST", "<%=request.getContextPath() %>/file/uploadVideo.do",true);  
//				        xhr.open("POST", "http://192.168.1.188:8080/mip/file/uploadVideo.do",true);  
				  
				        xhr.send(fd);  
				        xhr.onreadystatechange = function(){
				        	if(xhr.readyState == 4 && xhr.status==200){
				        		$("#model").css("display","none");
				        		console.log(xhr.responseText);
				        		if(JSON.parse(xhr.responseText).error ==0){
				        			console.log("成功");
				        			urlVideo= JSON.parse(xhr.responseText).src;
				        			$("#readonly").val($("#file_upload").val());
				        			
				        		}else if(JSON.parse(xhr.responseText).error ==1){
				        			console.log("失败");
				        			$("#file_upload").val("");
									$("#readonly").val("");
				        			layer.msg(JSON.parse(xhr.responseText).message);
				        		}
//				        		var json = J;
//				        		
				        	}
				        }
				    }  
				  
			    function uploadProgress(evt){  
			    	$("#model").css("display","block");
			        if (evt.lengthComputable) {                    
			            //evt.loaded：文件上传的大小   evt.total：文件总的大小                      
			            var percentComplete = Math.round((evt.loaded) * 100 / evt.total);      
			            //加载进度条，同时显示信息            
			            $("#percent").html(percentComplete + '%')  
			            $("#progressNumber").css("width",""+percentComplete+"%");               
			        }  
			    }
				//上传图片封面
				$("#uploadImg").on("click", function() {
					$("#img_upload").click();
				})
				$("#img_upload").on("change", function() {
					var input = $("#img_upload")[0];
					var formDdata = new FormData();
					formDdata.append('file', input.files[0]);
					formDdata.append('typeId', 1);
					formDdata.append('objectId', "");
					$.ajax({
						url: "<%=request.getContextPath() %>/file/uploadPicture.do",
						type: 'post',
						data: formDdata,
						dataType: "json",
						async: false,
						cache: false,
						contentType: false,
						processData: false,
						success: function(data) {
							console.log(data);
							if(data.error == 0) {
								console.log("成功");
								imgUrl = data.url;
								$("#uploadImg").attr("src",imgUrl);
								
							} else {
								layer.msg("图片选择失败");
							}
						},
						error: function(error) {
							console.log(error);
						}
					})
				})
			})
		</script>
		<script>
				var urlVideo1 ="";
				var setvideoJump;
			//编辑视频浏览
				$("#uploadVideo1").on("click", function() {
					$("#file_upload1").click();
				})
				//编辑视频撤销
				$("#quxiao1").on("click", function() {
					layer.closeAll();
					$("#title1").val("");
					$("#file_upload1").val("");
					$("#readonly1").val("");
					$("#img_upload1").val("");
					$("#uploadImg1").attr("src","<%=request.getContextPath() %>/back/images/uploadImg.png");
				})
				//编辑upload 上传保存
				$("#uploadSave1").on("click",function(){
					var name = $("#title1").val();
					var vedioIMG=$("#uploadImg1").attr("src");
					var urlVideo1 = $("#readonly1").val();
					if(name){
						if(urlVideo1){
							if(vedioIMG.indexOf("uploadImg")==-1){
								//发送保存请求
								$.ajax({
									type:"post",
									url:"<%=request.getContextPath() %>/videoSearch/saveVideo.do",
									dateType:"json",
									data:{id:did,name:name,imgUrl:vedioIMG,url:urlVideo1},
									success:function(data){
										console.log(data);
										if(data=="success"){
											layer.closeAll();
											layer.open({
											  type: 1,
											  title: false,
											  closeBtn: 0,
											  shadeClose: true,
											  area: ['520px', '160px'],
//											  skin: 'yourclass',
											  content: '<img src="<%=request.getContextPath() %>/back/images/successSave.png" />'
											});
											setTimeout(function(){
												window.location.reload();
											},2000)
										}else{
											layer.msg("保存失败，请稍后再试")
										}
									}
									
								});
							}else{
								layer.msg("请先上传视频封面")
							}
						}else{
							layer.msg("请先上传视频")
						}
					}else{
						layer.msg("视频名称不能为空")
					}
				})
				var input1 = document.getElementById("file_upload1");  
				//文件域选择文件时, 执行readFile函数  
				input1.addEventListener('change',readFile,false);
				function readFile(){   
				    file = this.files[0];   
				    setvideoJump = layer.open({
						type: 1,
						title: '上传视频',
						shadeClose: true,
						shade: 0.5,
						area: ['510px', '332px'],
						content: $("#delete1"),
					});
				}
				//修改视频取消
				$("#delquxiao1").on("click", function() {
					layer.close(setvideoJump);
				})
				//修改视频确认
				$("#delSave1").on("click", function() {
					 upload();
				})
				//上传文件  
				function upload(){  
				        var xhr = new XMLHttpRequest();  
				  
				        var fd = new FormData();  
				  
				        fd.append("file", file);  
				  
				        //监听事件  
				        xhr.upload.addEventListener("progress", uploadProgress, false);  
				  
				        //发送文件和表单自定义参数   
//				        xhr.open("POST", "<%=request.getContextPath() %>/file/uploadVideo.do",true);  
				        xhr.open("POST", "http://192.168.1.188:8080/mip/file/uploadVideo.do",true);  
				  
				        xhr.send(fd);  
				        xhr.onreadystatechange = function(){
				        	if(xhr.readyState == 4 && xhr.status==200){
				        		$("#model").css("display","none");
				        		layer.close(setvideoJump);
				        		console.log(xhr.responseText);
				        		if(JSON.parse(xhr.responseText).error ==0){
				        			console.log("成功");
				        			urlVideo1= JSON.parse(xhr.responseText).src;
				        			$("#readonly1").val($("#file_upload1").val());
				        			
				        		}else if(JSON.parse(xhr.responseText).error ==1){
				        			console.log("失败");
				        			$("#file_upload1").val("");
									$("#readonly1").val("");
				        			layer.msg(JSON.parse(xhr.responseText).message);
				        		}
//				        		var json = J;
//				        		
				        	}
				        }
				    }  
				  
			    function uploadProgress(evt){  
			    	$("#model").css("display","block");
			        if (evt.lengthComputable) {                    
			            //evt.loaded：文件上传的大小   evt.total：文件总的大小                      
			            var percentComplete = Math.round((evt.loaded) * 100 / evt.total);      
			            //加载进度条，同时显示信息            
			            $("#percent").html(percentComplete + '%')  
			            $("#progressNumber").css("width",""+percentComplete+"%");               
			        }  
			    }
				//上传图片封面
				$("#uploadImg1").on("click", function() {
					$("#img_upload1").click();
				})
				$("#img_upload1").on("change", function() {
					var input = $("#img_upload1")[0];
					var formDdata = new FormData();
					formDdata.append('file', input.files[0]);
					formDdata.append('typeId', 1);
					formDdata.append('objectId', "");
					$.ajax({
						url: "<%=request.getContextPath() %>/file/uploadPicture.do",
						type: 'post',
						data: formDdata,
						dataType: "json",
						async: false,
						cache: false,
						contentType: false,
						processData: false,
						success: function(data) {
							console.log(data);
							if(data.error == 0) {
								console.log("成功");
//								vedioIMG = data.url;
								$("#uploadImg1").attr("src",data.url);
								
							} else {
								layer.msg("图片选择失败");
							}
						},
						error: function(error) {
							console.log(error);
						}
					})
				})
		</script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
		<script type="text/javascript">
			//删除的代码 
			function delvirtual(id) {
				layer.confirm('确定删除此信息？', {
					btn: ['确定', '再想想'] //按钮
				}, function() {
					$.ajax({
						url: "<%=request.getContextPath()%>/virtual/deleteVirtual.do",
						type: "post",
						data: "id=" + id,
						async: false,
						dataType: "text",
						success: function(data) {
							window.location.href = '<%=request.getContextPath()%>/virtual/getVirtual.do';
							layer.msg('成功删除--删除队+1', {
								icon: 1
							});
						},
						error: function() {
							layer.msg('删除失败--异常队+1', {
								icon: 1
							});
						}
					})
				}, function() {
					layer.msg('已取消删除', {});
				});
				<%-- --%>
			}
			//发布的功能
			function release(publish, id) {
				if(publish == 0) {
					var a = "发布";
				} else if(publish == 1) {
					var a = "取消发布";
				}
				layer.confirm('确定' + a + '此信息？', {
					btn: ['确定', '再想想'] //按钮
				}, function() {
					$.ajax({
						url: "<%=request.getContextPath()%>/virtual/updatePublish.do",
						type: "post",
						data: {
							id: id
						},
						async: false,
						dataType: "text",
						success: function(data) {
							if(data == "success") {
								window.location.href = '<%=request.getContextPath()%>/virtual/getVirtual.do';
								layer.msg(a + '成功', {
									icon: 1
								});
							}
						},
						error: function() {
							alert("发布失败，请联系xxx");
						}
					})
				}, function() {
					layer.msg('已取消发布', {});
				});
			} 
		</script>
		<!-- 分页功能 -->
		<script type="text/javascript">
			var nums = ${
				page.size
			}; //每页出现的数量
			var pages = ${
				page.totalPage
			}; //得到总页数
			//调用分页 
			laypage({
				cont: 'page',
				pages: pages,
				curr: function() { //通过url获取当前页，也可以同上（pages）方式获取
					var page = location.search.match(/currentPage=(\d+)/);
					return page ? page[1] : 1;
				}(),
				skip: true, //是否开启跳页
				skin: '#2A9BCF', //皮肤
				groups: 3, //连续显示分页数 
				jump: function(e, first) { //触发分页后的回调
					if(!first) { //一定要加此判断，否则初始时会无限刷新
						location.href = '?currentPage=' + e.curr + '&' + $('form').serialize();
					}
				} 
			})
		</script>
	</body>

</html>