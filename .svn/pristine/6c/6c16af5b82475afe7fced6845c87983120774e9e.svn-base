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

<title>图片数据库更新</title>
</head>
<body>
	<!--/_menu 作为公共模版分离出去-->
	<%@ include file="main.jsp"%>
	<section class="Hui-article-box">
		<form class="form form-horizontal" action="<%=request.getContextPath() %>/back/picture/restart.do" method="post">
        <div class="row cl">
            <label class="form-label col-xs-3 col-sm-3">生成进度：</label><span id="percentage">0</span>%
            <div class="formControls col-xs-6 col-sm-4">
			    <!-- The global progress bar -->
			    <div id="progress" class="progress" style="width:100%!important" >
			        <div class="progress-bar progress-bar-success" style="width:0" ></div>
			    </div>
	      
		        <p class="mt-10">
				    <span>正在处理表：</span><span id="filename"></span>
			    </p>
		        <div>
				    <p style="float:left;"><span>变更记录数：</span><span id="changecount"></span></p>
				    <p style="float:right;"><span>总处理记录数：</span><span id="totalcount"></span></p>
			    </div>
            </div>
            <div class="col-xs-3 col-sm-3"></div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <button id="start" type="button" class="btn btn-primary radius">&nbsp;&nbsp;开始&nbsp;&nbsp;</button>
            </div>
        </div>
		</form>
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
			var timeinteval=null;
			$.ajax({
				url:"<%=request.getContextPath() %>/modify/status.do",
				type:'POST',
				data: {},
				datetype:'json',
				success:function(msg){
					console.log(msg.currentIndex);
					console.log(msg.count);
					if(new Array('未开始','已完成').indexOf(msg.currentFile)<0){
						$("#start").attr('disabled','disabled');
						$("#start").addClass('disabled');
						timeinteval=setInterval(function(){
							$.ajax({
								url:"<%=request.getContextPath() %>/modify/status.do",
								type:'POST',
								data: {},
								datetype:'json',
								success:function(msg){
									show_status(msg);
								}
							});
						},3000);
					}
				}
			});
			$("#start").click(function(){
				var data=$('form').serialize();
				$.ajax({
					url:"<%=request.getContextPath() %>/modify/start.do",
					data:data,
					type:'POST',
					datetype:'json',
					success:function(msg){
						$("#start").attr('disabled','disabled');
						$("#start").addClass('disabled');
						timeinteval=setInterval(function(){
							$.ajax({
								url:"<%=request.getContextPath() %>/modify/status.do",
								type:'POST',
								data: {},
								datetype:'json',
								success:function(msg){
									show_status(msg);
								}
							});
						},3000);
		            }
				});
			});
			function show_status(msg){
				$('#filename').html(msg.currentFile);
				$('#changecount').html(msg.changecount);
				$('#totalcount').html(msg.totalcount);
				$('#percentage').html(msg.percentage);
				if(new Array('未开始','已完成').indexOf(msg.currentFile)<0){
					var progress=msg.percentage;
					$('#progress .progress-bar').css(
				            'width',
				            progress + '%'
				     );
				}else if(msg.currentFile=='未开始'){
					$('#progress .progress-bar').css(
				            'width', '0%'
				     );
					$('#percentage').html('0');
				}else{
					$('#progress .progress-bar').css(
				            'width',
				            '100%'
				     );
					clearInterval(timeinteval);
					$("#start").removeAttr('disabled');
					$('#percentage').html('100');
					alert('转换完成');
				}
			}
		});
	</script>
</body>
</html>