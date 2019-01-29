<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/public.css"/>
<style type="text/css">
	.textHidden{max-width:70%; white-space:nowrap;overflow:hidden;text-overflow:ellipsis; }
	.layui-nav{
		background-color: #F4F4F4 !important;
 		color: #373737; 
	}
	.layui-nav cite{
 		color: #373737; 
	}
	.layui-nav a{
 		color: #373737 !important; 
	}
	.layui-nav-item:hover{
		background-color: #E1E1E1 !important;
	}
	.layui-nav-item a:hover{
		background-color: #E1E1E1 !important;
	}
	.layui-nav-tree .layui-this>a, .layui-nav-tree .layui-this>a:hover{
		background-color: #E1E1E1 !important;
	}
</style>
<title>表单选择</title>
</head>
<body style="background:#F4F4F4;padding:10px">
<div class="layui-col-xs3" style="height: -webkit-fill-available;position: relative;">
	<input type="hidden" id="bussCode" name="bussCode" value="">
	<input type="hidden" id="bussName" name="bussName" value="">
	<input type="hidden" id="defineCode" name="defineCode" value="">
	<div style="height: 40px;">
		<input type="text" class="layui-input inputText" placeholder="关键词搜索" id="key" name="key" style="width:100%;">
	</div>
	<div class="layui-col-xs6" style="background-color: #F4F4F4;position: absolute;top: 40px;bottom: 0;left: 0;">
		<div class="layui-col-xs12" style="background-color: #F4F4F4;">
			<label style="font-size: 14px;margin: 10px;color:#999999;">我的表单</label>
			<ul class="layui-nav layui-nav-tree" style="height: 100%;width: 100%;" lay-filter="reportMenu">
				<li class="layui-nav-item item1 layui-this">
					<a href="javascript:getReportList('1');"><cite>全部</cite></a>
				</li>
				<li class="layui-nav-item item1">
					<a href="javascript:getReportList('2');"><cite>最常用的</cite></a>
				</li>
				<li class="layui-nav-item item1">
					<a href="javascript:getReportList('3');"><cite>上次使用的</cite></a>
				</li>
				<%-- <li class="layui-nav-item item1">
					<a href="javascript:void(0);"><cite>系统模板</cite></a>
				</li> --%>
			</ul>
		</div>
		<hr>
		<!-- <div class="layui-col-xs12" style="background-color: #F4F4F4;">
			<label style="font-size: 14px;margin: 10px;color:#999999;">我的分类</label>
			<ul class="layui-nav layui-nav-tree" lay-filter="report">
			  <li class="layui-nav-item item2"><a href="javascript:;">默认展开</a></li>
			  <li class="layui-nav-item item2"><a href="javascript:;">解决方案</a></li>
			  <li class="layui-nav-item item2"><a href="">产品</a></li>
			  <li class="layui-nav-item item2"><a href="">大数据</a></li>
			</ul>
		</div> -->
	</div>
	<div class="layui-col-xs6" style="position: absolute;top: 40px;bottom: 0;right: 0;border-right: 1px solid #E6E6E6;">
		<label style="font-size: 14px;color:#999999;top: 10px;padding-left: 10px;">选择表单</label>
		<ul class="layui-nav layui-nav-tree" lay-filter="report" style="width: 100%;position: absolute;top: 19px;bottom: 0;overflow-y: scroll;" id="reportList">
		</ul>
	</div>
</div>
<div class="layui-col-xs9" style="height: -webkit-fill-available;border: 0px;">
	<iframe scrolling="auto" id="viewFrame" src=""  style="height:-webkit-fill-available;width: 100%;border: 0px;"></iframe>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript">
$(function(){
	$(".item1").click(function(){
		$(".item1").removeClass("layui-this");
		$(this).addClass("layui-this");
	});
	$("#key").keydown(function(e) {  
        if (e.keyCode == 13) {  
        	if($("#key").val() != ''){
        		$(".item1").removeClass("layui-this");
	        	getReportList('',$("#key").val());
        	}else{
        		getReportList('1');
        	}
        }
   });
	//默认选中全部
	getReportList('1');
});
layui.use(['form','layer','laydate','element'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    	laydate = layui.laydate;
    	var element = layui.element;
	
  	//监听导航点击
    element.on('nav(report)', function(elem){
    	$(".item2").removeClass("layui-this");
    	elem.addClass("layui-this");
    });
})
//获取表单数据
function getReportList(item, name){
	$.ajax({
        url:"<%=request.getContextPath() %>/notice/publish/getReportListDate.do",
        data:{item:item, name:name},
        type:"POST",
        success:function(msg){
            if(msg.code == 1){
            	$("#reportList").html("");
            	var list = msg.data;
            	for (var i = 0; i < list.length; i++) {
            		$("#reportList").append('<li class="layui-nav-item item2" id="itme'+list[i].define_id+'" title="'+list[i].buss_name+'"><a href="javascript:void(0);" onclick="viewReport(\''+list[i].define_id+'\',\''+list[i].define_code+'\',\''+list[i].id+'\');">'+list[i].buss_name+'</a></li>');
				}
            }else{
            	layer.msg(msg.msg);
            }
        }
    });
}
function viewReport(defineid, code, id){
	$("#bussCode").val(id);
	$("#defineCode").val(code);
	$("#bussName").val($("#itme"+defineid).attr("title"));
	$(".item2").removeClass("layui-this");
	$("#itme"+defineid).addClass("layui-this");
	document.getElementById("viewFrame").src="<%=request.getContextPath() %>/designController.do?designPreviewHtml&defineId="+defineid+"&businessCode="+code+"&bussTemplateId=&versionNum=-1";
}

//关闭
$("#close").click(function(){
	close();
});

function close(){
	var index=parent.layui.layer.getFrameIndex(window.name);
	parent.layui.layer.close(index);
}
</script>
</body>
</html>