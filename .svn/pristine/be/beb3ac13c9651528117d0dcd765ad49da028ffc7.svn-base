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
        .text-c th{
      		text-align:center;
      	}
    </style>
    <title>站内信息管理</title>
</head>
<body class="childrenBody">
<form class="layui-form" id="roleForm">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" class="layui-input searchVal" id="infoTitle" name="infoTitle" value="" placeholder="消息标题" />
                </div>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input searchVal" id="dateRange" name="dateRange" value="" placeholder="发布时间范围" />
                </div>
                <div class="layui-input-inline">
                    <select id="readFlag" name="readFlag" class="layui-select">
                    	<option value=""></option>
                    	<option value="0">未读</option>
                    	<option value="1">已读</option>
                    </select>
                </div>
                
                <button class="layui-btn search_btn" lay-search type="button">搜索</button>
            </div>

            <div class="layui-inline a2">
                <a class="layui-btn layui-btn-normal addNews_btn" onclick="goInsideInfoAdd()">发信息</a>
            </div>
        </form>
    </blockquote>
    <table id="insideInfoList" lay-filter="insideInfoList"></table>
    
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript">
layui.use(['form','layer','table', 'laydate'],function(){
	var form = layui.form,
    layer = parent.layer === undefined ? layui.layer : top.layer,
    $ = layui.jquery,
    table = layui.table,
	laydate = layui.laydate;

	laydate.render({
	   elem: '#dateRange',
	   range: '~'
	});
	
	//用户列表
    var tableIns = table.render({
        elem: '#insideInfoList',
        url : '<%=request.getContextPath() %>/insideInfo/getList.do',
        cellMinWidth : 95,
        request:{
        	pageName: 'currentPage',
        	limitName: 'size'
        },
        page : true,
        limits : [10,20,25],
        limit : 10,
   	 
      
        cols : [[
        	{type:"numbers", title: '序号', width:70, align:"center"},
            {field: 'infoTitle', title: '消息标题', minWidth:200, align:"center"},
            {field: 'submitTime', title: '发布时间', align:"center",templet:function(v){
            	var st = '';
            	if(v && v != null){
            		var date = new Date(v.submitTime);
	              	st = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() + ' ' + date.getHours() + ':' + date.getMinutes()+ ':' + date. getSeconds();
            	}
            	return st;
            }},
            {field: 'readFlag', title: '状态', align:'center',minWidth:100, templet:function(d){
            	if(d.readFlag == '1'){
	            	return "已读";
            	}else if(d.readFlag == '0'){
	            	return "未读";
            	}else{
	            	return "未读";
            	}
            }},
            {title: '操作', minWidth:175,fixed:"right",align:"center",templet:function(d){
            	 
            	var html = ''; 
            		html += '<a class="layui-btn layui-btn-xs layui-btn-warm"  href="javascript:findDetail('+d.infoId+');"  title="阅读信息">阅读</a>';
            		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteNotice('+d.infoId+');" title="删除">删除</a>';
            	return html;
            }}
        ]]
    });
	
  //搜索
  $(".search_btn").on("click",function(){
    tableIns.reload({
             page: {
                 curr: 1 //重新从第 1 页开始
             },
             where: {
            	 infoTitle: $("#infoTitle").val(),  //搜索消息标题
                 dateRange: $("#dateRange").val(),  //时间范围
                 readFlag: $("#readFlag").val()  //阅读状态
             }
         })
    });
  
    window.goInsideInfoAdd = function(){
	  var index = layui.layer.open({
	      title : "新建信息",
	      type : 2,
	      content : "<%=request.getContextPath() %>/insideInfo/goAdd.do",
	       
	      area: ['700px', '500px'],
	      success : function(layero,index){
	          var body = layui.layer.getChildFrame('body', index);
	          setTimeout(function(){
	              layui.layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
	                  tips: 3
	              });
	          },500)
	      },
	      yse:function (index, layero) {
	          layer.close(index); //关闭弹层
	      }
	  });
	  layui.layer.full(index);
	    window.sessionStorage.setItem("index",index);
  }
  
  //去详情页面
 window.findDetail = function(id){
	  var index = layui.layer.open({
	      title : "信息详情",
	      type : 2,
	      content : "<%=request.getContextPath() %>/insideInfo/goDetail.do?infoId="+id,
		  area: ['700px', '500px'],
		  success : function(layero,index,data1){
		  		var body = layui.layer.getChildFrame('body', index);
	            setTimeout(function(){
	                layui.layer.tips('点击此处返回站内信息列表', '.layui-layer-setwin .layui-layer-close', {
	                    tips: 3
	                });
	            },500)
			},
	      yse:function (index, layero) {
	          layer.close(index); //关闭弹层
	      },
	      end :function() {
        		tableIns.reload();
          }
	  });
	  layui.layer.full(index);
	    window.sessionStorage.setItem("index",index);
 }
  
  window.deleteNotice=function(id){
		layer.confirm("确认要删除吗，删除后不能恢复", { title: "删除确认" }, function (index) {
          layer.close(index);
          $.post("<%=request.getContextPath() %>/insideInfo/delete.do", { infoId: id }, function (data) {
        	  data=data.data;
              if(data.success == 1){
              	$("#roleForm").submit();
              	layer.msg('删除成功');
              }else if(data.success == 0){
              	layer.msg(data.data);
              }
        	  tableIns.reload();
          }); 
      });
	}
});

</script>
</body>
</html>