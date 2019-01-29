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
      	.hidden{
      	display:none;
      	}
      	.laytable-cell-1-4 {
    		width:100px !important;
		}
    </style>
    <title>列表</title>
</head>
<body class="childrenBody">
<form class="layui-form" id="form">
    <table id="messageList"  lay-filter="messageList"></table>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/museum/js/showRecordList.js"></script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="show" >查看</a>
</script>

<script type="text/javascript">
layui.use(['form','layer','table'],function(){
	var form = layui.form,
    layer = parent.layer === undefined ? layui.layer : top.layer,
    $ = layui.jquery,
    table = layui.table;
    var tableIns = table.render({
        elem: '#messageList',
        url : '<%=request.getContextPath() %>/desk/messageList.do', 
        request:{
        	pageName: 'currentPage',
        	limitName: 'size'
        },
        cellMinWidth : 95,
        page : true,
        limits : [10,15,20,25],
        limit : 10,
        id : "messageListTable",
        cols : [[
            {type:"numbers",title: '序号', minWidth:100, align:"center"},
            {field: 'submitTime', title: '发送时间', align:"left"},
            {field: 'infoTitle', title: '消息名称', align:'left',minWidth:200},
            {field: 'receiverName', title: '发送对象', align:'left',minWidth:200},
            {title: '操作',width:100,align:"center",templet:function(d){
            	var html = '<a class="layui-btn layui-btn-xs"  href="javascript:detail(\''+d.infoId+'\',\''+d.receiverId+'\');" title="查看">查看</a>'; 
            	return html;
            }}
        ]],
    });
  
    //去详情页面
    window.detail = function(id,receiverId){
   	  var index = layui.layer.open({
   	      title : "信息详情",
   	      type : 2,
   	      content : "<%=request.getContextPath() %>/desk/goListDetail.do?infoId="+id+"&type=check",
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
});	
</script>
</body>
</html>