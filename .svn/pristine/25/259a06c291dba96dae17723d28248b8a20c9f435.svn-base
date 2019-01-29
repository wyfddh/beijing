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
	<title>藏品专题分类</title>
	<style>
        .a1{
            width: 150px;
        }
		.inputHead{
			width: 290px;
		}
    </style>
</head>
<body class="childrenBody" style="overflow-y: scroll;">
<form class="layui-form">
    <blockquote class="layui-elem-quote quoteBox">
        <form  class="layui-form" id="formSearch" method="post"> 
            <div class="layui-inline">
				<div class="layui-input-inline" >
			    	<input type="text" id="name"  placeholder="输入名称关键字搜索" autocomplete="off" class="layui-input inputHead">
			    </div>
			    
			    <button class="layui-btn" type="button"  id="search">查询</button>
			    <button class="layui-btn addNews_btn" type="button"  id="addUser">新增</button>
            </div>   
        </form>
    </blockquote>
    <table id="legalTypeList" lay-filter="legalTypeList" lay-data="{id: 'legalTypeListTable'}" ></table>
        <!--操作-->
    <script type="text/html" id="legalTypeListBar">
		<a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
        <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
    </script>
    <br>
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
   
    
    //用户列表
    var tableIns = table.render({
        elem: '#legalTypeList',
        url : projectName + '/topicType/getListData.do', 
        cellMinWidth : 95,
        request:{
        	pageName: 'currentPage',
        	limitName: 'size'
        },
        page : true,
        limits : [10,15,20,25],
        limit : 10,
        id : "topicTypeId",
        cols : [[
            {type:"numbers", title: '序号', width:70, align:"center"},
            {field: 'name', title: '分类名', align:"center"},
            {field: 'describe', title: '描述',  align:'center'},
            {title: '操作', templet:'#legalTypeListBar',fixed:"right",align:"center"}
        ]]
    });
    
    function reloadTable() {
    	tableIns.reload();
    }
    
    $("#search").click(function() {
    	tableIns.reload({
    		where: { //设定异步数据接口的额外参数，任意设
    			name: $("#name").val()
  		  	}
  		  	,page: {
  		  		curr: 1 //重新从第 1 页开始
  		  	}
  		});
    })
    
    //添加分类
    function addUser(edit){
    	var tit = "添加分类";
    	if (edit) {
    		tit = "修改分类"
    	}
        var index = layui.layer.open({
            title : tit,
            type : 2,
            closeBtn:1 ,
            area: ['700px', '500px'],
            content: [projectName + '/topicType/goAdd.do','no'], 
            success : function(layero, index){
            	resizeLayer(index);
                var body = layui.layer.getChildFrame('body', index);
               
                if(edit){
                	debugger;
                	body.find("#name").val(edit.name);
                	body.find("#describe").val(edit.describe);
                	body.find("#id").val(edit.id);
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回专题分类列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)  
            },
            end :function() {
            	tableIns.reload();
            }
        })
        /*layui.layer.full(index);*/ 
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    $(".addNews_btn").click(function(){
        addUser();
    })
 

    var initData = function() {
    	$(".hide").hide(); 
    }
    initData();
    //列表操作
    table.on('tool(legalTypeList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addUser(data);
        }else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除？',{icon:3, title:'提示信息'},function(index){
                 $.get(projectName + '/topicType/deleteType.do',{
                     id : data.id
                 },function(result){
                	 var msg = result.success;
                	 if (msg == 1) {
                		 layer.close(index);
                		 top.layer.msg("删除成功！");
                    	 tableIns.reload();  
                	 } else{
                		 layer.close(index);
                    	 top.layer.msg(result.data);
                	 }
                	 
                 })
            });
        }
    });
})


</script>
</body>
</html>