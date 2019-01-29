<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<!--[if lt IE 9]>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/html5shiv.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/respond.min.js"></script>
    <![endif]-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/header.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/headUserGover.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/asideUserGover.css">
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
a:hover {
	text-decoration: none;
}

.check-box, .radio-box {
	padding-left: 0;
}

.layui-layer-page .layui-layer-content {
	overflow-x: hidden !important;
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
			/*添加视频样式*/
			
			.addVideoIMG {
				display: none;
			}
			
			.addVideoIMG .body {
				padding: 30px;
			}
			
			.addVideoIMG .body label {
				display: inline-block;
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
</style>
<title>博物馆信息运营</title>
</head>
<body>
<!--_header 作为公共模版分离出去-->
<%@ include file="../fabuNav.jsp" %>
 
<!--_menu 左边slide导航开始-->
 <%@ include file="aside.jsp" %>
<section  class="Hui-article-box">
    <div class="Hui-article">
    	<div class="pt-10 pl-30">
	    	<div class="mb-20">
	    		<span> <a href="/admin/spreadtrum/getSpreadtrum.do">< 返回</a></span>
	    	</div>
	    	<div>
	    		<span class="btn btn-primary radius">${title}</span>
	    	</div>
	   	</div>
        <form action="<%=request.getContextPath()%>/museumInfoManage/spreInfo.do" class="huodong">
        	<input type="hidden" value="${title}" name="title" id="title">
        	<input type="hidden" value="${spreId}" name="id" id="id">
        	<input type="hidden" value="${orgId}" name="orgId" id="orgId">
            <div>
            	<c:if test="${fn:contains(sessionScope.user.level,1)}">
		          	<span class="1">
		          		<a href="javascript:void(0)" onclick="addVideo()" class="btn btn-primary radius" style="text-decoration:none" title="新增"><i class="Hui-iconfont">&#xe600;新增</i></a>
		          	</span>
		        </c:if>
            </div>
            <div style="clear: both"></div>
            <div style="min-width: 1020px">
                <table class="table">
                    <thead>
                    <tr class="text-c">
                        <th width="80">序号</th>
                        <th width="300">封面</th>
                        <th width="200">类别</th>
                        <th width="200">单位</th>
                        <th width="300">操作人</th>
                        <th width="300">上传时间</th>
                        <th width="300">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                     <c:forEach items="${dtoList}" var="u" varStatus="sta">  
	                    <tr class="text-c">
	                        <td>${sta.index+1}</td>
	                        <td>
		                        <div style="position: relative;">
									<img width="120" height="80" src="${u.imageUrl}" alt="" />
								</div>
	                        </td>
	                        <td>
	                        <c:if test="${u.type==0}">三折页</c:if>
	                        <c:if test="${u.type==1}">易拉宝</c:if>
	                        </td>
	                        <td>${u.unitName}</td>
	                        <td>${u.userName}</td>
	                        <td>${u.creatTime}</td>
	                        <td>
		                        <c:if test="${fn:contains(sessionScope.user.level,1)}">
			                        <a title="删除"  onclick="delect('${u.id}')" class="ml-5" style="text-decoration:none;color: #2A9BCF;">
										删除
									</a>
								</c:if>
								<a title="下载" href="${u.psdUrl}" class="ml-5" style="text-decoration:none;color: #2A9BCF;">
									下载
								</a>
	                        </td>
	                    </tr>
	                    </c:forEach>
                    </tbody>
                </table>
                <br>
				<div id="page" align="center"></div> 
            </div>
        </form>
    </div>
</section>
<div id="layer111">
	<div id="addVideoIMG" class="addVideoIMG">
		<div class="body">
			<div class="one">
				<span id="shengji" class="inline">类别:&nbsp;
                   <span style="width: 120px;height: 26px;padding: 2px 5px;border-radius: 5px;" class="select-box">
                        <select name="area" class="select regionType" size="1" style="style="width:100px" id="manageTyep">
						    <option value="0">三折页</option>
						    <option value="1">易拉宝</option>
						</select>
                    </span>
				</span>
			</div>
			<div class="one one1">
				<input id="readonly" readonly="readonly" type="text" placeholder="请选择PSD文件" />
				<a id="uploadVideo" href="javascript:">浏览</a>
				<input type="file" id="file_upload" hidden="hidden" />
			</div>
			<div class="vedio">
				<label for="title">封面:</label>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
	$(".fabu-aside>ul>li").eq(0).addClass("fabu");
	$(".headerNav").find(".spre").addClass("active").find("img").attr("src",'<%=request.getContextPath() %>/back/images/zllogoActive.png');
	var appName = '<%=request.getContextPath() %>';
	var imgUrl = ""; //图片封面上传参数
	var urlPsd = ""; //视频地址
	//添加左边样式。
	$('.regionType').change(function(){
	     var pid=$(this).val();
	     var obj=$(this).parent().next("span").find("select");
	     var first=obj.children().first().clone();
	     $.ajax({
	       	url:appName + "/museumInfoManage/region.do",
	         data:{pid:pid},
	         type:"POST",
	         success:function(msg){
	             obj.empty().append(first);
	             var sub=obj.next('select');
	             while(sub.length>0){
	             	first=sub.children().first().clone();
	             	sub.empty().append(first);
	                 sub=sub.next('select');
	             }
	             for(var i in msg)
	                 obj.append("<option value="+msg[i]['id']+">"+msg[i]['name']+"</option>");
	        }
	    });
	});
	$('.addType').change(function(){
	     var pid=$(this).val();
	     var obj=$(this).parent().next("span").find("select");
	     var first=obj.children().first().clone();
	     $.ajax({
	       	url:appName + "/museumInfoManage/region.do",
	         data:{pid:pid},
	         type:"POST",
	         success:function(msg){
	             obj.empty().append(first);
	             var sub=obj.next('select');
	             while(sub.length>0){
	             	first=sub.children().first().clone();
	             	sub.empty().append(first);
	                 sub=sub.next('select');
	             }
	             for(var i in msg)
	                 obj.append("<option value="+msg[i]['id']+">"+msg[i]['name']+"</option>");
	        }
	    });
	});
	//upload 上传保存
	$("#uploadSave").on("click",function(){
		var type = $("#manageTyep").val();
		var spreId = $("#id").val();
		var orgId = $("#orgId").val();
		var fileName = $("#readonly").val();
		if(fileName != null || fileName != ""){
			var strs= new Array(); //定义一数组 
			strs=fileName.split("\\"); //字符分割 
			fileName = strs[strs.length-1];
			console.log("fileName:"+fileName);
			console.log("spreId:"+spreId);
		}
		if(urlPsd){
			if(imgUrl){
				//发送保存请求
				$.ajax({
					type:"post",
					url:"<%=request.getContextPath() %>/museumInfoManage/addSpreInfo.do",
						dateType:"json",
						data:{type:type,imgUrl:imgUrl,urlPsd:urlPsd,fileName:fileName,spreId:spreId,orgId:orgId},
						success:function(data){
							console.log(data);
							if(data=="1"){
							layer.msg('保存成功', {icon: 1});
							setTimeout(function(){
								window.location.reload();
							},1000)
						}else{
							layer.msg("保存失败，请稍后再试") 
						}
					}
					
				});
			}else{
				layer.msg("请先上传封面")
			}
		}else{
			layer.msg("请先上传模板")
		}
	})
	//添加PSD文件浏览
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
       xhr.open("POST", "<%=request.getContextPath() %>/file/upload.do",true);  
//	        xhr.open("POST", "http://192.168.1.188:8080/mip/file/uploadVideo.do",true);  
	  
	        xhr.send(fd);  
	        xhr.onreadystatechange = function(){
	        	if(xhr.readyState == 4 && xhr.status==200){
	        		$("#model").css("display","none");
	        		console.log(xhr.responseText);
	        		if(JSON.parse(xhr.responseText).error ==0){
	        			console.log("成功");
	        			urlPsd= JSON.parse(xhr.responseText).url;
	        			$("#readonly").val($("#file_upload").val());
	        			
	        		}else if(JSON.parse(xhr.responseText).error ==1){
	        			console.log("失败");
	        			$("#file_upload").val("");
						$("#readonly").val("");
	        			layer.msg(JSON.parse(xhr.responseText).message);
	        		}
//	        		var json = J;
//	        		
	        	}
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
	
	function delect(id){
		var spreId = $("#id").val();
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath() %>/museumInfoManage/delectSpre.do",
				dateType:"json",
				data:{id:id,spreId:spreId},
				success:function(data){
					console.log(data);
					if(data=="1"){
					layer.msg('删除成功', {icon: 1});
					setTimeout(function(){
						window.location.reload();
					},1000)
				}else{
					layer.msg("删除失败，请稍后再试") 
				}
			}
			
		});
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
    function addVideo() {
		layer.open({
			type: 1,
			title: '上传模板',
			shadeClose: true,
			shade: 0.5,
			area: ['520px', '420px'],
			content: $("#addVideoIMG"),
		});
	}
/* 	var nums = ${page.size}; //每页出现的数量
	var pages = ${page.totalPage}; //得到总页数
	//调用分页
	laypage({
	    cont: 'page',
	    pages: pages,
	    curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
	        var page = location.search.match(/currentPage=(\d+)/);
	        return page ? page[1] : 1;
	    	}(), 
	   	skip: true, //是否开启跳页
	   	skin: '#72CDAE', //皮肤
	   	groups: 3, //连续显示分页数
	    jump: function(e, first){ //触发分页后的回调
	       if(!first){ //一定要加此判断，否则初始时会无限刷新
	         location.href = '?currentPage='+e.curr+'&'+$('form').serialize() ;
	       }
	    }
	}) */
</script>
</body>
</html>