<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/public/public.css" media="all" />
<!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
	<title>藏品变动列表</title>
	<style>
    </style>
</head>
<body class="childrenBody">
<form class="layui-form" id="roleForm">
	<div class="layui-row" style="padding-bottom:30px;padding-top:10px;">
		<div class="layui-col-md1">
			<a id="show_change" type="button" class="layui-btn">进行对比</a>
		</div>
	</div>
    <table id="changeList" lay-filter="changeList"></table>
     <!--操作-->
   	<script type="text/html" id="changeListBar">
    	  <a class="layui-btn layui-btn-xs"  lay-event="detail">查看</a>
	</script>  
    <input type="hidden" id="selectId" name="selectId" value="${selectId }">
    <input type="hidden" id="collectionType" name="collectionType" value="${collectionType }">
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript">
layui.use(['form','layer','table','laytpl'],function(){
	   var form = layui.form,
	        layer = parent.layer === undefined ? layui.layer : top.layer,
	        $ = layui.jquery,
	        laytpl = layui.laytpl,
	        table = layui.table;
	  
	 
	    var pathName=window.document.location.pathname;
	    projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
	    var selectId=$("#selectId").val();
	    var collectionType=$("#collectionType").val();
	    var renderList=[];
	    //用户列表
    	renderList = [	{checkbox: true},
    	               {type:"numbers",title: '序号', width:50, align:"center"},
    	               {field: 'version', title: '版本编号',  align:"center"},
    	               {field: 'userName', title: '操作人',  align:'center'},
    	               {field: 'creatTime', title: '操作时间', align:'center'},
    	               {field: 'versionType', title: '类型', align:'center'},
    	               {title: '操作',templet:'#changeListBar',align:"center"}
    	           ];
   	   var tableIns = table.render({
	           elem: '#changeList',
	           url : projectName + '/objectChange/getVersionSelect.do?selectId='+selectId, 
	           cellMinWidth : 95,
	           request:{
	           	pageName: 'currentPage',
	           	limitName: 'size'
	           },
	           page : false,
	           height : 500,   
	           limit : 999,
	           id : "changeListTable",
	           cols :[renderList]
	        });
	    
	    
	    var ids = [];
	    
	    table.on('checkbox(changeList)', function (obj) {
	           if(obj.checked==true){
	            	ids.push(obj.data.id);
	           }else{
                   for(var i=0;i<ids.length;i++){
                      if(ids[i]==obj.data.id){
                    	  ids.remove(i);
                       }
                  }
	           }
	    });
	    
	    $("#show_change").click(function(){
	    	var contentId = "";
	    	if(ids.length != "2"){
	    		layer.msg("请选择两条数据！");
	    	}else{
	    		contentId =  ids[0]+","+ids[1]
	    		var index = layer.open({
	                type: 2,
	                title: '版本对比详情',
	                shadeClose: true,
	                shade: 0.5,
	                area: ['1100px', '600px'],
	                content: [projectName+'/objectChange/compareVersionSelect.do?contentId='+ contentId+'&contentType='+collectionType,'yes']
	            });
	    	}
	    });
	    
	  //列表操作
	    table.on('tool(changeList)', function(obj){
	        var layEvent = obj.event,
	            data = obj.data;
	        if(layEvent === 'detail'){ 
	        	var index = layer.open({
	                type: 2,
	                title: '藏品详情',
	                shadeClose: true,
	                shade: 0.5,
	                area: ['1200px', '600px'],
	                content: [projectName+'/objectChange/versionSelect.do?contentId='+ data.id+'&contentType='+collectionType,'yes'],
	                success: function(layero, index){
	                	resizeLayer(index);
	                }
	            });
	        }
	    });
	})
	
	//删除数组自定义函数
    Array.prototype.remove=function(dx)
    {
        if(isNaN(dx)||dx>this.length){return false;}
        for(var i=0,n=0;i<this.length;i++)
        {
            if(this[i]!=this[dx])
            {
                this[n++]=this[i]
            }
        }
        this.length-=1
    }

</script>
</body>
</html>