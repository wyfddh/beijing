<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico">
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="back/lib/html5.js"></script>
<script type="text/javascript" src="back/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>藏品图片导入</title>
</head>
<body>
	<!--/_menu 作为公共模版分离出去-->
	<%@ include file="main.jsp"%>
	<section class="Hui-article-box" style="overflow-y:scroll">
		<form class="form form-horizontal" action="<%=request.getContextPath() %>/back/picture/start.do" method="post">
        <div class="row cl">
            <label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>原图根目录：</label>
            <div class="formControls col-xs-6 col-sm-4">
                <input type="text" class="input-text" value="" placeholder="" name="srcPath"
                       datatype="*" nullmsg="请填写原图目录">
            </div>
            <div class="col-xs-3 col-sm-3"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>生成图根目录：</label>
            <div class="formControls col-xs-6 col-sm-4">
                <input type="text" class="input-text" value="" placeholder="" name="targetPath"
                       datatype="*" nullmsg="请填写生成图目录">
            </div>
            <div class="col-xs-3 col-sm-3"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>需要处理的错误图片目录：</label>
            <div class="formControls col-xs-6 col-sm-4">
                <input type="text" class="input-text" value="" placeholder="" name="errorPath"
                       datatype="*" nullmsg="请填写错误图片目录">
            </div>
            <div class="col-xs-3 col-sm-3"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-3 col-sm-3">生成进度：</label>
            <div class="formControls col-xs-6 col-sm-4">
			    <!-- The global progress bar -->
			    <div id="progress" class="progress" style="width:100%!important" >
			        <div class="progress-bar progress-bar-success" style="width:0" ></div>
			    </div>
		      
			        <p class="cl mt-10">
					    <span>正在处理文件：</span><span id="filename"></span>
				    </p>
			        <div class="cl mt-10">
					    <p style="float:left;"><span>处理文件数：</span><span  id="filecount"></span></p>
					    <p style="float:right;"><span>总文件数：</span><span id="count"></span></p>
				    </div>
			        <div class="cl mt-10">
					    <p style="float:left;"><span>处理不对数：</span><span  id="skipcount"></span></p>
					    <p style="float:right;"><span>处理总文件数：</span><span id="totalcount"></span></p>
				    </div>
			        <p  class="cl mt-10">
					    <span>检查文件数：</span><span  id="testcount"></span>
				    </p>
			        <p  class="cl mt-10">
					    <span>误差文件数：</span><span  id="subvalue"></span>
				    </p>
            </div>
            <div class="col-xs-3 col-sm-3"></div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <button id="start" type="button" class="btn btn-primary radius">&nbsp;&nbsp;开始&nbsp;&nbsp;</button>
            </div>
        </div>
		</form>
        <div class="cl">
	        <p  class="cl mt-10">
		        <span>线程状态：</span><span id="status"></span>
		    </p>
	        <p  class="cl mt-10">
		        <span>其他错误：</span>
		    </p>
	        <div id="templist" class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
	        </div>
	        <p  class="cl mt-10">
		        <span>文件名错误：</span>
		    </p>
	        <div id="skipfiles" class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
	        </div>
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
			var timeinterval=null;
			$.ajax({
				url:"<%=request.getContextPath() %>/back/picture/status.do",
				type:'POST',
				data: {},
				datetype:'json',
				success:function(msg){
					console.log(msg.currentIndex);
					console.log(msg.count);
					if(parseInt(msg.currentIndex)<parseInt(msg.count)&&msg.status!='TERMINATED'){
						$("#start").attr('disabled','disabled');
						$("#start").addClass('disabled');
						timeinterval=setInterval(function(){
							$.ajax({
								url:"<%=request.getContextPath() %>/back/picture/status.do",
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
				var data=$('form').serialize();
				$.ajax({
					url:"<%=request.getContextPath() %>/back/picture/start.do",
					data:data,
					type:'POST',
					datetype:'json',
					success:function(msg){
						switch(msg){
						case '-1':
							alert("原图根目录不能为空！");
							break;
						case '-2':
							alert("生成图根目录不能为空！");
							break;
						case '-3':
							alert("错误图片目录不能为空！");错误图片目录
							break;
						default:
							$("#start").attr('disabled','disabled');
							$("#start").addClass('disabled');
							timeinterval=setInterval(function(){
								$.ajax({
									url:"<%=request.getContextPath() %>/back/picture/status.do",
									type:'POST',
									data: {},
									datetype:'json',
									success:function(msg){
										play_status(msg)
									}
								});
							},3000);
						}
		            }
				});
			});
			function play_status(msg){
				$('#filename').html(msg.currentFile);
				$('#filecount').html(msg.currentIndex);
				$('#skipcount').html(msg.skipCount);
				$('#testcount').html(msg.testCount);
				$('#count').html(msg.count);
				$('#totalcount').html(msg.totalCount);
				$('#subvalue').html(msg.subvalue);
				$('#status').html(msg.status);
				console.log(msg.currentIndex);
				console.log(msg.count);
				console.log(msg.skipfiles);
				var index=parseInt(msg.currentIndex)+parseInt(msg.skipCount);
				var count=parseInt(msg.count);
				if(index<count){
					var progress=index*100/count;
					$('#progress .progress-bar').css(
				            'width',
				            progress + '%'
				     );
					if(msg.status=='TERMINATED'){
						clearInterval(timeinterval);
						$("#start").removeAttr('disabled');
						$("#start").removeClass('disabled');
						setTimeout("alert('转换结束');",1);
					}
				}else if(count==0){
					$('#progress .progress-bar').css(
				            'width', '0%'
				     );
				}else{
					$('#progress .progress-bar').css(
				            'width',
				            '100%'
				     );
					clearInterval(timeinterval);
					$("#start").removeAttr('disabled');
					$("#start").removeClass('disabled');
					setTimeout("alert('转换完成');",1);
				}
				if(msg.templist.length>0){
					var htmlcount=$('#templist').children().length;
					console.log(htmlcount);
					var filecount=msg.templist.length;
					var count=Math.min(htmlcount,filecount)
					for(var i=0;i<count;i++){
						var html=msg.templist[i];
						var item=$('#templist').children().eq(i);
						console.log(item.html());
						if(item.html()!=html)
							item.html(html);
					}
					for(var i=count;i<htmlcount;i++){
						$('#templist').children().remove(i);
					}
					for(var i=count;i<filecount;i++){
						var html='<p>'+msg.templist[i]+'</p>';
						$('#templist').append(html);
					}
				}
				if(msg.skipfiles.length>0){
					var htmlcount=$('#skipfiles').children().length;
					console.log(htmlcount);
					var filecount=msg.skipfiles.length;
					var count=Math.min(htmlcount,filecount)
					for(var i=0;i<count;i++){
						var html=msg.skipfiles[i];
						var item=$('#skipfiles').children().eq(i);
						console.log(item.html());
						if(item.html()!=html)
							item.html(html);
					}
					for(var i=count;i<htmlcount;i++){
						$('#skipfiles').children().remove(i);
					}
					for(var i=count;i<filecount;i++){
						var html='<p>'+msg.skipfiles[i]+'</p>';
						$('#skipfiles').append(html);
					}
				}
			}
		});
	</script>
</body>
</html>