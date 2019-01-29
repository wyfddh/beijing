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
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css">
    <!--/meta 作为公共模版分离出去-->
    <style type="text/css">
        .th-center{
    		text-align:center !important;
	    }
	    .td-center{
	    	text-align:center !important;
	    }
	    .td1{
	    	width: 300px;
	    }
	    .td2{
	    	
	    }
	    .td3{
	    	width: 300px;
	    }
	    .td4{
	    	text-align:center !important;
	    }
    </style>
    <title>文章-列表</title>
</head>
<body class="childrenBody">
<blockquote class="layui-elem-quote quoteBox">
    <form class="layui-form">
    	<input type="hidden" id="subjectId" name="subjectId" value="">
        <div class="layui-inline">
            <button class="layui-btn search_btn" type="button">刷新</button>
        </div>
        <div class="layui-inline a2">
        	<c:if test="${sessionScope.btn.add == 1 }">
	            <a class="layui-btn addNews_btn" onclick="goAdd()">新增栏目</a>
        	</c:if>
        </div>
    </form>
</blockquote>
<div id="listTree"></div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript">
$(function(){
	var layout = [
	    { name: '栏目名称',headerClass: 'td1',colClass: 'td1',style:"width: 300px !important;", field:'name', treeNodes: true },
	    { name: '唯一名称',headerClass: 'td2',colClass: 'td2', field:'uniqueName', },
	    { name: '描述', headerClass: 'td3',colClass: 'td3',field:'description', render: function(row){
	    	if(row.description == null){
	    		return "";
	    	}else{
	    		return row.description;
	    	}
	    }},
	    { name: '创建时间',headerClass: 'td4',colClass: 'td4', field:'create_time'},
	    { name: '操作',  width:240,headerClass: 'th-center',fixed: 'right', colClass: 'td-center', render: function(row){
	    	var html = ''; 
	    	if('${sessionScope.btn.edit}' == '1'){
	    		html += '<a class="layui-btn layui-btn-xs"  onclick="javascript:goEdit(\''+row.id+'\');" title="编辑">编辑</a>';
	    	}
	    	if(row.id != '1'){
		    	if('${sessionScope.btn.del}' == '1'){
		    		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  onclick="javascript:deleteSubject(\''+row.id+'\');" title="删除">删除</a>';
		    	}
	    	}
	    	return html;
	    }}
	];
	layui.use(['form','layer','table', 'tree'],function(){
		var form = layui.form,
	    layer = parent.layer === undefined ? layui.layer : top.layer,
	    $ = layui.jquery,
	    table = layui.table,
		laydate = layui.laydate;
	
	    var tableIns;
	    var initTable = function(){
	    	var dataJson = "";
	    	$.ajax({
                type: 'POST',
                url: '<%=request.getContextPath() %>/cmsSubject/ztreeList.do',
                data: {type: '1'},
                dataType: 'json',
                async: false,
                success: function (data) {
                    if(data.success == 1){
                    	dataJson = data.data;
                    }
                }
            });
	    	return layui.treeGird({
		        elem: '#listTree', //传入元素选择器
		        spreadable: false, //设置是否全展开，默认不展开
		        checkbox : false,
		        nodes: dataJson,
		        layout: layout,
		        page:true
		    });
	    }
	   
	  //初始化表格
	    var tableIns = initTable();
	  
	    form.render();
		
	  //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	  $(".search_btn").on("click",function(){
		  location.reload();
		  console.log('${sessionScope}');
	    });
	  //去新增页面
		  window.goAdd = function(){
			  var index = layui.layer.open({
			      title : "新增栏目",
			      type : 2,
			      content : "<%=request.getContextPath() %>/cmsSubject/goAdd.do?type=1",
			      area: ['500px', '600px'],
			      success : function(layero,index,data){
			          var body = layui.layer.getChildFrame('body', index);
			        //自适应高度
				  	  resizeLayer(index);
			          setTimeout(function(){
			              layui.layer.tips('点击此处返回栏目列表', '.layui-layer-setwin .layui-layer-close', {
			                  tips: 3
			              });
			          },500)
			      },
			      yse:function (index, layero) {
			          layer.close(index); //关闭弹层
			      },
			      end :function() {
			    	  location.reload();
	              }
			  });
		}
	  //去编辑页面
  		window.goEdit = function(id){
		  var index = layui.layer.open({
		      title : "编辑通知公告",
		      type : 2,
		      content : "<%=request.getContextPath() %>/cmsSubject/goEdit.do?type=1&id="+id,
		      area: ['500px', '600px'],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
			  	    //自适应高度
				  	resizeLayer(index);
		            setTimeout(function(){
		            	layui.layer.tips('点击此处返回栏目列表', '.layui-layer-setwin .layui-layer-close', {
			                  tips: 3
			              });
		            },500)
				},
		      yse:function (index, layero) {
		          layer.close(index); //关闭弹层
		      },
		      end :function() {
		    	  location.reload();
              }
		  });
	 }
		//删除
		window.deleteSubject = function(id){
			layer.confirm("确认要删除吗，删除后不能恢复", { title: "删除确认" }, function (index) {
		      layer.close(index);
		      $.post("<%=request.getContextPath() %>/cmsSubject/removeSubject.do", { id: id }, function (data) {
		          if(data.success == 1){
		          	layer.msg('删除成功');
		          }else{
		          	layer.msg(data.data);
		          }
		          location.reload();
		      });
		  });
		}
		
	});
	//时间戳转时间格式
	function timestampToTime(timestamp) {
		console.log(timestamp);
	    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
	    Y = date.getFullYear() + '-';
	    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	    D = (date.getDate() < 10 ? '0'+(date.getDate()) : date.getDate()) + ' ';
	    h = date.getHours() + ':';
	    m = date.getMinutes() + ':';
	    s = date.getSeconds();
	    return Y+M+D;
	}
});


</script>
</body>
</html>