<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
    <!--/meta 作为公共模版分离出去-->
    <style type="text/css">
        .childrenBody{
        	background-color: #f2f2f2;
        }
        .fontColor1{
        	color: #1AA094;
        }
    </style>
    <title>系统信息</title>
</head>
<body class="childrenBody">

	<div class="layui-col-md6" style="padding: 5px;">
		<div class="layui-card">
		  <div class="layui-card-header">CPU信息</div>
		  <div class="layui-card-body">
		  	<table class="layui-table" id="cpu">
            <colgroup>
              <col width="120"><col>
            </colgroup>
            <tbody id="cpuBody">
            	<tr><td>CPU数量</td><td id="cpu1">0</td></tr>
            	<tr><td>CPU总量</td><td id="cpu2">0MHz</td></tr>
            	<tr><td>CPU类别</td><td id="cpu3"></td></tr>
            	<tr><td>CPU使用率</td><td id="cpu4" class="fontColor1">0%</td></tr>
            </tbody>
          </table>
		  </div>
		</div>
		<div class="layui-card">
		  <div class="layui-card-header">内存信息</div>
		  <div class="layui-card-body">
		  	<table class="layui-table" id="pan">
            <colgroup>
              <col width="120"><col>
            </colgroup>
            <tbody>
            	<tr><td>内存总量</td><td id="nc1">0G</td></tr>
            	<tr><td>内存使用量</td><td id="nc2" class="fontColor1">0G</td></tr>
            	<tr><td>内存使用率</td><td id="nc3" class="fontColor1">0%</td></tr>
            </tbody>
          </table>
		  </div>
		</div>
	</div>
	<div class="layui-col-md6" style="padding: 5px;">
	  <div class="layui-card">
		<div class="layui-card-header">硬盘信息</div>
		  <div class="layui-card-body">
		  	<table class="layui-table" id="pan">
            <colgroup>
              <col width="120"><col>
            </colgroup>
            <tbody id="panBody">
            </tbody>
          </table>
		  </div>
		</div>
	</div>


<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript">
layui.use(['form','layer','table', 'element'],function(){
	var form = layui.form,
    layer = parent.layer === undefined ? layui.layer : top.layer,
    $ = layui.jquery,
    table = layui.table;
	var element = layui.element;
	
	getcpuData();
	getncData();
	getpanData();
	
	
	function getcpuData() {
    	$.ajax({
    		type:"post",
    		url:'<%=request.getContextPath() %>/sysinfo/getCpuTotal.do',
    		success:function(result) {
    			if (result.success == 1) {
    				var map = result.data;
    				$("#cpu1").text(map.cpusl);
    				$("#cpu2").text(map.cpuzl+"MHz");
    				$("#cpu3").text(map.cpuzl1);
    				$("#cpu4").text(map.zdsyl);
    				form.render();
    			}
    		}
    	})
    }
	function getncData() {
    	$.ajax({
    		type:"post",
    		url:'<%=request.getContextPath() %>/sysinfo/getPhysicalMemory.do',
    		success:function(result) {
    			if (result.success == 1) {
    				var map = result.data;
    				$("#nc1").text(map.nczl);
    				$("#nc2").text(map.ncsy);
    				$("#nc3").text(map.ncsybfb);
    				form.render();
    			}
    		}
    	})
    }
	function getpanData() {
    	$.ajax({
    		type:"post",
    		url:'<%=request.getContextPath() %>/sysinfo/testFileSystemInfo.do',
    		success:function(result) {
    			if (result.success == 1) {
    				var list = result.data;
    				for (var i = 0; i < list.length; i++) {
						var map = list[i];
						if(returnTotal(map.panTotal) != 0){
		    				$("#panBody").append('<tr><td>'+returnTotal(map.panName)+'</td><td>当前总量[<font class="fontColor1">'+returnTotal(map.panTotal)+'</font>]，已使用[<font class="fontColor1">'+returnTotal(map.panUsage)+'</font>]，剩余[<font class="fontColor1">'+returnTotal(map.panFree)+'</font>]</td></tr>');
						}
					}
    				form.render();
    			}
    		}
    	})
    }
	
	function returnTotal(num){
		if(!num || num == null || num == ''){
			return 0;
		}else{
			return num;
		}
	}
});
	
</script>
</body>
</html>