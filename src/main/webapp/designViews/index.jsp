<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>在线表单设计组件</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<script type="text/javascript">
	window.jQuery || document.write("<script src='designPlug-in/ace/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>
<!-- basic styles -->

<link href="designPlug-in/ace/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="designPlug-in/ace/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="designPlug-in/ace/assets/css/font-awesome.min-plus.css" />
<!--[if IE 7]>
  <link rel="stylesheet" href="designPlug-in/ace/assets/css/font-awesome-ie7.min.css" />
<![endif]-->

<!-- page specific plugin styles -->

<!-- fonts -->

<!-- ace styles -->

<link rel="stylesheet" href="designPlug-in/ace/assets/css/ace.min.css" />
<link rel="stylesheet" href="designPlug-in/ace/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="designPlug-in/ace/assets/css/ace-skins.min.css" />

<!--[if lte IE 8]>
  <link rel="stylesheet" href="designPlug-in/ace/assets/css/ace-ie.min.css" />
<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->

<script src="designPlug-in/ace/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
<script src="designPlug-in/ace/assets/js/html5shiv.js"></script>
<script src="designPlug-in/ace/assets/js/respond.min.js"></script>
<![endif]-->
<!--  <script type="text/javascript" src="designPlug-in/ace/assets/workplan/initMeet.js"></script> -->

<link rel="stylesheet" href="designPlug-in/ace/assets/css/fullcalendar.css" />


<script src="designPlug-in/layer/layer.js"></script>
<script src="designPlug-in/layer/extend/layer.ext.js"></script>
<script src="designPlug-in/laypage/laypage.js"></script>
<script type="text/javascript"
	src="designPlug-in/My97DatePicker/WdatePicker.js"></script>
<script src="designPlug-in/avalon/avalon1.4.js"></script>

<script src="designPlug-in/jquery-plugs/gridstack/js/list.js"></script>





<!-- 集成需要引入以下文件 -->
<link rel='stylesheet' href='designPlug-in/layui-2.3.0/css/layui.css' type=text/css >
<script type=text/javascript src='designPlug-in/layui-2.3.0/layui.js'></script>
<!-- 集成需要引入以下文件 -->

</head>

<body  ms-controller="main_bs_controller"  >
	<div class="navbar navbar-default"  id="navbar">
	<script type="text/javascript">
		try{ace.settings.check('navbar','fixed')}catch(e){}
	</script>

	<div class="navbar-container" id="navbar-container">	
		
		<div class="navbar-header pull-left">
			<a href="#" class="navbar-brand" style="margin-top:20px;color:#000000;">
				  <i class="icon-leaf"></i>
					在线表单设计组件
			</a><!-- /.brand -->
			
		</div>
		<div class="navbar-header pull-left">
			<!-- a href="#" class="navbar-brand" >
				<small style="line-height:60px;">
				</small>
			</a> --><!-- /.brand -->
		</div><!-- /.navbar-header -->
	</div>
</div>

<div class="main-container" id="main-container">
	<script type="text/javascript">
		try{ace.settings.check('main-container' , 'fixed')}catch(e){}
	</script>

	<div class="main-container-inner">
		<a class="menu-toggler" id="menu-toggler" href="#">
			<span class="menu-text"></span>
		</a>

		<div class="sidebar" id="sidebar">
			<script type="text/javascript">
				try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
			</script>


			<ul class="nav nav-list" id="indexmenuhtml">
                
			</ul>
		</li>

	</ul><!-- /.nav-list -->

           
			<script type="text/javascript">
				try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
			</script>
		</div>

		<div class="main-content">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
				</script>

				<ul class="breadcrumb">
					<li>
						<i  ms-class-1="{{model.selectIcon}}" ></i>
						{{model.selectMenu}}
					</li>
				</ul><!-- .breadcrumb -->
			</div>
			<div class="progress progress-mini" style="height:0px;width: 100%;margin-bottom: 0px;">
				<div class="progress-bar progress-danger" id="progress-danger-i" style="width: 0%;"></div>
			</div>
			<div class="page-content" style="padding:5px 15px 3px 12px;" >
				<div class="row"   ms-include-src="PageCodeRdm" data-include-rendered='Temprender'>
				</div><!-- /.row -->
			</div>
			<!-- /.page-content -->
			
			
		</div><!-- /.main-content -->
	</div><!-- /.main-container-inner -->
</div><!-- /.main-container -->
<!--[if !IE]> -->



<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='designPlug-in/ace/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
	if("ontouchend" in document) document.write("<script src='designPlug-in/ace/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>

<script src="designPlug-in/ace/assets/js/bootstrap.min.js"></script>
<script src="designPlug-in/ace/assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<!-- ace scripts -->

<script src="designPlug-in/ace/assets/js/ace-elements.min.js"></script>
<script src="designPlug-in/ace/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script src="designPlug-in/ace/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="designPlug-in/ace/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="designPlug-in/ace/assets/js/jquery.slimscroll.min.js"></script>
<script src="designPlug-in/ace/assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="designPlug-in/ace/assets/js/jquery.sparkline.min.js"></script>

</body>
</html>
<script type="text/javascript">

function SelModelMenu(functionurl,functionid,busscode,functionname,functionicon,thisObj) {
	if(functionurl==""||functionurl==null){
		model.PageCodeRdm = "designViews/ace/Loading.html";
		layer.msg('正在研发中......', {icon: 4});
		return true;
	}
	$("#progress-danger-i").css("background","#2a91d8").css("width","100%");
	if (functionurl!=''&&functionurl!=null) {
		$(".nav-list li").each(function(){
			$(this).removeClass("active");
		});
		try{
			$(thisObj).parent().addClass("active");
		}catch(e){
			$(thisObj).addClass("active");
		}
		model.selectIcon=functionicon;
		model.selmenulev2(functionurl,functionid,busscode,functionname);
	} else {//默认展示首页
		model.selectIcon="fa fa-home fa-fw";
		model.PageCodeRdm = "designViews/ace/Loading.html";
	}
}

var model = avalon.define({
	$id: "main_bs_controller",
	DWData: {},//单位信息
	DBCount: 0,//待办消息数量
	selectMenu:'首页',
	selectIcon:'fa fa-home fa-fw',
	isnull: false,//是否有数据
	helpCode:"",//帮助CODE
	helpFile:"",//帮助文件名称
	helpPage:"",//帮助文件默认页码
	selmenulev2: function (functionurl,functionid,busscode,functionname) {
		model.page.pageindex = 1;
		model.page.total = 0;
		model.rdm = Math.random();
		var functionurl_=functionurl+"&clickFunctionId="+functionid+"&bussCode="+busscode;
		model.selectMenu=functionname;
		model.PageCodeRdm = functionurl_+"&r="+ Math.random();
		
	},//选中二级菜单事件
	PageCode: "designViews/ace/Loading",//需要加载的模板
	PageCodeRdm: "designViews/ace/Loading.html",//需要加载的模板
	rdm: Math.random(),//随机数
	Temprender: function () {
		setTimeout("$('#progress-danger-i').css('width','0%').css('background','#FFFFFF')",1000);
	},//组件加载完成事件
	INDEXMENU: [],
	GETINDEXMENU: function () {
		//可改成动态加载菜单数据
		$.getJSON("data.json", { P1: "PCINDEX" }, function (resultData) {
			//model.INDEXMENU = resultData;
			var shtml=indexmenuhtml(resultData);
			$("#indexmenuhtml").html(shtml);
			var liLength=$(".nav-list li").eq(0).find("li").length;
			$("#progress-danger-i").css("background","#2a91d8").css("width","100%");
			if(liLength>0){
				model.PageCodeRdm = resultData[0].subs[0].functionurl+"&bussCode="+resultData[0].subs[0].busscode+"&r="+ Math.random();
				model.selectMenu=resultData[0].subs[0].functionname;
				$(".nav-list li").eq(0).addClass("open");
				$(".nav-list li").eq(0).find("li").eq(0).addClass("active");
			}else{
				$(".nav-list li").eq(0).addClass("active");
				model.PageCodeRdm = resultData[0].functionurl+"&bussCode="+resultData[0].busscode+"&r="+ Math.random();
				model.selectMenu=resultData[0].functionname;
				//$(".nav-list li").eq(0).find("a").eq(0).click();
			}
			model.selectIcon=resultData[0].functionicon;
		});
	},//获取菜单数据
	page: { pageindex: 1, pagecount: 10, total: 0 }, //分页参数
	pageNum: [{ "num": 10 }, { "num": 20 }, { "num": 30 }, { "num": 50 }, { "num": 100 }],
	search: { seartype: "1", searchcontent: "1" }
});
avalon.ready(function () {
	model.GETINDEXMENU();
});




function indexmenuhtml(indexmenuData) {
	var shtml="";
	$(indexmenuData).each(function(i,val) {
		shtml+="<li >";
		if(val.subs.length>0){
			shtml+="<a href='#'  class='dropdown-toggle'  busscode='"+val.busscode+"'  menuid='"+val.id+"'  >";
			shtml+="<i class='"+val.functionicon+"'></i>";
			shtml+="<span class='menu-text'>"+val.functionname+"</span>";
			shtml+="<b   class='arrow icon-angle-down'></b>";
			shtml+="</a>";
			shtml+="<ul class='submenu' >";
			$(val.subs).each(function(i,val2) {
				shtml+="<li   style='cursor: pointer;'>";
				if(val2.subs.length>0){
					shtml+="<a href='#' class='dropdown-toggle'>";
					shtml+="<i class='icon-double-angle-right'></i>";
					shtml+=""+val2.functionname+"";
					shtml+="<b class='arrow icon-angle-down'></b>";
					shtml+="</a>";
					shtml+="<ul class='submenu'>";
					$(val2.subs).each(function(i,val3) {
						shtml+="<li style='cursor: pointer;'>";
						shtml+="<a title='"+val3.functionname+"'  menuid='"+val3.id+"'  onclick=\"SelModelMenu('"+val3.functionurl+"','"+val3.functionid+"','"+val3.busscode+"','"+val3.functionname+"','"+val.functionicon+"',this)\">";
						shtml+=""+val3.functionname+"";
						shtml+="</a>";
						shtml+="</li>";
					});
					shtml+="</ul>";
				}else{
					shtml+="<a title='"+val2.functionname+"'  menuid='"+val2.id+"'  onclick=\"SelModelMenu('"+val2.functionurl+"','"+val2.functionid+"','"+val2.busscode+"','"+val2.functionname+"','"+val.functionicon+"',this)\">";
					shtml+="<i class='icon-double-angle-right'></i>";
					shtml+=""+val2.functionname+"";
					shtml+="</a>";
				}
				shtml+="</li>";
			});
			shtml+="<li>";
			shtml+="</li>";
			shtml+="</ul>";
		}else{
			shtml+="<a busscode='"+val.busscode+"'  menuid='"+val.id+"' onclick=\"SelModelMenu('"+val.functionurl+"','"+val.functionid+"','"+val.busscode+"','"+val.functionname+"','"+val.functionicon+"',this)\" class='dropdown-toggle'   >";
			shtml+="<i class='"+val.functionicon+"'></i>";
			shtml+="<span class='menu-text'>"+val.functionname+"</span>";
			shtml+="</a>";
		}
		shtml+="</li>";
	
	});
	return shtml;
}
</script>


