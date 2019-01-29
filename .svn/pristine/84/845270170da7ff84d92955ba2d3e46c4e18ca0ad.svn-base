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
	<script>
		$(function(){
			$(".fabu-aside>ul>li").eq(0).addClass("fabu");
			$(".headerNav").find(".bgmusic").addClass("active");
		});
	</script>
    <title>首页音频列表</title>
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
    	.addAudio{
    		width:60px;
    		height:8px;
    		background:#5A98DE;
    		text-align:center;
    		line-height:8px;
    		font-size:12px;
    		color:#fff;
    		border-radius:5px;
    		cursor:pointer;
    	}
    	.Hui-article-box{
    		overflow-y:scroll!important;
    	}
		.addMusic{
			position:absolute;
			left:60px;
			top:20px;
		}
		.bgcolor{
			padding-right:100px;
			<%--background:url('<%=request.getContextPath() %>/back/images/music.png') center no-repeat;--%>
			background:#F1F2F7;
			background-size:contain;
		}
		.audioBox{
			border:1px solid rgba(102, 102, 102, 0.26);
			box-shadow:0px 0px 10px #666;
			width:330px;
			margin-left:60px;
			margin-top:100px;
			float:left;
			height:230px;
			overflow:hidden;
			background:white;
		}
    </style>
</head>
<body>
<!--_header 作为公共模版分离出去-->
 <%@ include file="../fabuNav.jsp"%>

<!--_menu 左边slide导航开始-->
 <%@ include file="aside.jsp" %> 
<!--/_menu 作为公共模版分离出去-->
<section class="Hui-article-box section_box bgcolor">
   <div class="btn btn-primary radius size-L addMusic" id="addAudio"  type="button">添加背景音乐</div>
   <c:forEach items="${mipAudioList}" var="audio" varStatus="row">
	   <div class="text-l va-m audioBox">
	        <ul>
        		<li style="padding-top:20px;">
         			<p style="padding-left:30px;"><font size="4"><strong>${audio.name }</strong></font></p>
         			<p style="padding-left:30px;"><font size="3">${audio.description }</font></p>
         			<p style="padding-left:30px;"><font size="3">${audio.createTime }</font></p>
         			<p style="padding-left:18px"><audio src="${audio.url } " controls></audio></p>
         			<input type="text" hidden name="id" value="${audio.id }">
         			<div>
         				<input class="btn btn-danger radius" onclick="del('${audio.id}')" type="button" style="float: right; margin-right:20px;" value="删除">
         				<c:if test="${audio.isOpen eq '0' && flag eq false }">
         					<input class="btn btn-primary radius" onclick="publish('${audio.id}')" type="button" style="float: right; margin-right:20px;" value="发布">
         				</c:if>
         				<c:if test="${audio.isOpen eq '1' }">
         					<input class="btn btn-primary radius" onclick="nonPublish('${audio.id}')" type="button" style="float: right; margin-right:20px;" value="取消发布">
         				</c:if>
         			</div>
                </li>
	       </ul>
	   </div>
   </c:forEach>
   <div style="clear:both"></div>
  
   <div id="page" style="margin-top:80px;padding-bottom:20px;text-align:center;"></div>
   
   <div class="cover">
   		<div class="head">
   			<div class="close">x</div>
   		</div>
     	<div class="tag"><span>音乐名称</span><input type="text" class="validate" id="audioName" placeholder="请输入名称，最多十个字"></div>
    	<div class="tag"><span class="beizhu">备注</span><input type="text" class="validate" id="audioDescription" placeholder="请输入名称，最多十个字"></div>
    	<div class="tag"><span class="beizhu">音频<div class="addAudio tag" id="upload" style="display:inline-block;margin-left:20px;">选择文件</div><img id="waiting" style="margin-left:10px;width:80px;display:none;" src="<%=request.getContextPath() %>/back/images/waiting.gif"></span>
    	<form id="uploadFormAudio" enctype="multipart/form-data" method="post">
    		<audio class="tag" src="" controls style="display:block;margin-left:72px;" id="showAudio"></audio>
    		<input type="file" accept="audio/*" name="file" hidden id="uploadFile">
    		<input type="text" value="" hidden id="audioUrl">
    	</form>
    	</div>
    		
    	<div class="btnWrap" style="margin-top:10px;">
    		<div id="save" class="btn btn-primary radius size-S" style="margin-left:20px;">保存</div>
    		<div id="cancel" class="btn btn-danger radius size-S ml-20">取消</div>
    	</div>
   </div>
   
</section>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    $("#addAudio").click(function(){
    	$(".cover").fadeIn(500);
    });
    $(".close").click(function(){
    	$(".cover").fadeOut(300);
    });
    
    $("#upload").click(function(){
    	$("#uploadFile").click();
    	return;
    });
    $("#uploadFile").change(function(){
    	$("#waiting").show();
//    	setTimeout(function(){
    	   	 var formData = new FormData($( "#uploadFormAudio" )[0]);
    			$.ajax({
    				url : "<%=request.getContextPath() %>/file/uploadAudio.do",
    				type : "post",
    				data :  formData,
    				dataType:"json",
    				 //async: false,  
    	       cache: false,  
    	       contentType: false,  
    	       processData: false,  
    	         success: function (data) {
    	        	 console.log(data);
    	             if(data.error == 1){
    	             	layer.msg(data.message, {icon: 1});
    	             }
    	             if(data.error == 0){
    	            	$("#waiting").hide();
    	                /* alert(data.url); */
    	                layer.msg('[OK]上传成功', {icon: 1});
    	                $("#audioUrl").attr("value",data.url);
    	                $("#showAudio").attr("src",data.src);
    	                setTimeout(function(){
    	             	   $("#uploadAudio").val("");
    	             	   $("#accIntAudio").val("");
    						},1000)
    	             }
    	         },
    			})
//    	},1);
    });
    
    $('#save').click(function(){
    	var name = $('#audioName').val();
    	var description = $('#audioDescription').val();
    	var url = $('#audioUrl').val();
    	if(name == ""){
    		$.Huimodalalert('音乐名称不可为空',2000);
    		return false;
    	}
    	if(description == ""){
    		$.Huimodalalert('备注不可为空',2000);
    		return false;
    	}
    	if(url == ""){
    		$.Huimodalalert('上传音频不可为空',2000);
    		return false;
    	}
    	if(name.length > 10){
    		$.Huimodalalert('音乐名称不可超过10个字',2000);
    		return false;
    	}
    	if(description.length > 10){
    		$.Huimodalalert('备注不可超过10个字',2000);
    		return false;
    	}
    	if(name != "" && name.length <= 10 && description != "" && description.length <= 10 && url != ""){
    		$.ajax({
    			url : "<%=request.getContextPath() %>/audio/save.do?name="+name+"&description="+description+"&url="+url+"&type=1",
    			type : "get",
    			dateType:"text",
    			async:false,
    	        success: function (data) {
    	             if(data.success == 0){
    	             	layer.msg(data.data, {icon: 1});
    	             }
    	             if(data.success == 1){
    	                /* alert(data.url); */
    	                layer.msg('[OK]保存成功', {icon: 1});
    	                setTimeout(function(){
    	                	window.location.reload();
    						},2000)
    	             }
    	         },
    			error:function(){
    				alert("页面错误");
    			}
    		})
    	}
    	
    });
   
    function del(id) {
    	layer.confirm("确认删除吗",{
    		btn:["确认","取消"]
    	},function(){
    		$.ajax({
    			url : "<%=request.getContextPath() %>/audio/del.do?id="+id,
    			type : "get",
    			dateType:"text",
    			async:false,
    	        success: function (data) {
    	             if(data.success == 0){
    	             	layer.msg(data.data, {icon: 1});
    	             }
    	             if(data.success == 1){
    	                /* alert(data.url); */
    	                layer.msg('[OK]删除成功', {icon: 1});
    	                	window.location.reload();
    	             }
    	         },
    		})
    	},function(){
    		layer.closeAll();
    	})
	}
    
    function publish(id) {
   		layer.confirm("确认发布吗",{
       		btn:["确认","取消"]
       	},function(){
       		$.ajax({
       			url : "<%=request.getContextPath() %>/audio/publish.do?id="+id,
       			type : "get",
       			dateType:"text",
       			async:false,
       	        success: function (data) {
       	             if(data.success == 0){
       	             	layer.msg(data.data, {icon: 1});
       	             }
       	             if(data.success == 1){
       	                /* alert(data.url); */
       	                layer.msg('[OK]发布成功', {icon: 1});
       	                window.location.reload();
       	             }
       	         },
       		})
       	},function(){
       		layer.closeAll();
       	})
	}
    
    function nonPublish(id) {
    	layer.confirm("确认取消发布吗",{
    		btn:["确认","取消"]
    	},function(){
    		$.ajax({
    			url : "<%=request.getContextPath() %>/audio/nonPublish.do?id="+id,
    			type : "get",
    			dateType:"text",
    			async:false,
    	        success: function (data) {
    	             if(data.success == 0){
    	             	layer.msg(data.data, {icon: 1});
    	             }
    	             if(data.success == 1){
    	                /* alert(data.url); */
    	                layer.msg('[OK]取消发布成功', {icon: 1});
    	                	window.location.reload();
    	             }
    	         },
    		})
    	},function(){
    		layer.closeAll();
    	})
	}
    
    
</script>

<script type="text/javascript">
		var nums = ${page.size}; //每页出现的数量
		var pages = ${page.totalPage}; //得到总页数
		//调用分页
		laypage({
		    cont: 'page',
		    pages: pages,
		    curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
		        var page = location.search.match(/page=(\d+)/);
		        return page ? page[1] : 1;
		    	}(), 
		   	skip: true, //是否开启跳页
		   	skin: '#72CDAE', //皮肤
		   	groups: 3, //连续显示分页数
		    jump: function(e, first){ //触发分页后的回调
		       if(!first){ //一定要加此判断，否则初始时会无限刷新
		         location.href = '?page='+e.curr+'&'+$('form').serialize() ;
		       }
		    }
		})
	</script>
</body>
</html>