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
        .laytable-cell-1-imgUrl{  /*最后的pic为字段的field*/
	       height: 100%;
	    }
	    .layui-icon{
	    	margin-right: 0px !important;
	    }
    </style>
    <title>轮播图管理-列表</title>
</head>
<body class="childrenBody">
<div class="layui-tab layui-tab-brief" lay-filter="banner">
  <ul class="layui-tab-title">
  	<c:forEach items="${positionList }" var="posList" varStatus="num">
  		<c:if test="${num.index == 0 }" var="isNotFirst">
		    <li class="layui-this" lay-id="${posList.id }">${posList.name }</li>
  		</c:if>
  		<c:if test="${!isNotFirst }">
		    <li lay-id="${posList.id }">${posList.name }</li>
  		</c:if>
  	</c:forEach>
  </ul>
  <div class="layui-tab-content" style="height: 100px;display: none;" id="bannerContent">
    <div class="layui-tab-item layui-show">
		<form class="layui-form" id="roleForm">
		    <blockquote class="layui-elem-quote quoteBox">
		        <form class="layui-form">
		            <div class="layui-inline">
		                <button class="layui-btn search_btn" type="button">刷新</button>
		            </div>
		            <div class="layui-inline a2">
		            	<c:if test="${sessionScope.btn.add == 1 }">
			                <a class="layui-btn addNews_btn" onclick="goAdd()">添加轮播图</a>
		            	</c:if>
		            </div>
		        </form>
		    </blockquote>
		    <table id="bannerList" lay-filter="bannerList"></table>
		    
		</form>
    </div>
  </div>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript">
$(function(){
	layui.use(['form','layer','table', 'laydate', 'element'],function(){
		var form = layui.form,
	    layer = parent.layer === undefined ? layui.layer : top.layer,
	    $ = layui.jquery,
	    table = layui.table,
	    element = layui.element, //Tab的切换功能，切换事件监听等，需要依赖element模块
		laydate = layui.laydate;
		var currentPosId = "";
		
		//初始化表格
		var initTable = function(){
			return table.render({
		        elem: '#bannerList',
		        url : '<%=request.getContextPath() %>/banner/getListData.do',
		        cellMinWidth : 80,
		        request:{
		        	pageName: 'currentPage',
		        	limitName: 'size'
		        },
		        where:{
		        	searchPositionId: currentPosId
		        },
		        page : true,
		        id : "bannerListTable",
		        cols : [[
		            {type:"numbers", title: '序号',align:"center"},
		            {field: 'imgUrl', title: '图片', style:"height:100px;padding:0px;", align:'center', templet:function(d){
		            	if(d.imgUrl == '' || d.imgUrl == null){
		            		return '-';
		            	}else{
		            		return '<img src="'+d.imgUrl+'"style="height:96px;max-width:100%;margin:2px 0px;">';
		            	}
		            }},
		            {field: 'url', title: '超链接',  align:"center",templet:function(d){
		            	if(d.url == ''){
		            		return "-";
		            	}else{
		            		return '<a href="'+d.url+'" target="view_window">点击跳转</a>';
		            	}
		            }},
		            {title: '操作',width:240,align:"center",templet:function(d){
		            	var html = ''; 
		            	if('${sessionScope.btn.edit }' == '1'){
		           			html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
		            	}
		            	if('${sessionScope.btn.del }' == '1'){
		            		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteLink(\''+d.id+'\');" title="删除">删除</a>';
		            	}
		            	if('${sessionScope.btn.edit }' == '1'){
		            		html += '<a class="layui-btn layui-btn-xs layui-btn-primary"  href="javascript:editSequence(\'up\',\''+d.id+'\');" title="上移"><i class="layui-icon">&#xe619;</i></a>';
		            		html += '<a class="layui-btn layui-btn-xs layui-btn-primary"  href="javascript:editSequence(\'down\',\''+d.id+'\');" title="下移"><i class="layui-icon">&#xe61a;</i></a>';
		            	}
		            	return html;
		            }}
		        ]]
		    });
		}
		
		currentPosId = $(".layui-this").attr("lay-id");
		if(currentPosId != undefined && currentPosId != ''){
			$("#bannerContent").show();
			//用户列表
		    var tableIns = initTable();
		}
		//表格刷新
		function tableRefresh(){
			tableIns.reload({
	             page: {
	                 curr: 1 //重新从第 1 页开始
	             },
	             where: {
	            	 searchPositionId: currentPosId
	             }
	         })
		}
		
		element.on('tab(banner)', function(elem){
// 		    location.hash = 'test='+ $(this).attr('lay-id');
		    console.log($(this).attr('lay-id'));
		    currentPosId = $(this).attr("lay-id");
		    tableRefresh();
		});
		
		
	  //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	  $(".search_btn").on("click",function(){
		  tableRefresh();
	    });
	  //去新增页面
		  window.goAdd = function(){
			  var index = layui.layer.open({
			      title : "添加轮播图",
			      type : 2,
			      content : "<%=request.getContextPath() %>/banner/goAdd.do?carouselPositionId="+currentPosId,
			      area: ['500px;', '500px'],
			      success : function(layero,index,data){
			          var body = layui.layer.getChildFrame('body', index);
			          //自适应高度
				  	  resizeLayer(index);
			          setTimeout(function(){
			              layui.layer.tips('点击此处返回轮播图列表', '.layui-layer-setwin .layui-layer-close', {
			                  tips: 3
			              });
			          },500)
			      },
			      yse:function (index, layero) {
			          layer.close(index); //关闭弹层
			      },
			      end :function() {
			    	  tableRefresh();
	              }
			  });
		}
	  //去编辑页面
  		window.goEdit = function(id){
		  var index = layui.layer.open({
		      title : "编辑轮播图",
		      type : 2,
		      content : "<%=request.getContextPath() %>/banner/goEdit.do?id="+id,
		      area: ['500px;', '500px'],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
// 		       		body.find("#id").val(data.data.notice.id);  //id
					//自适应高度
				  	  resizeLayer(index);
		            setTimeout(function(){
		                layui.layer.tips('点击此处返回轮播图列表', '.layui-layer-setwin .layui-layer-close', {
		                    tips: 3
		                });
		            },500)
				},
		      yse:function (index, layero) {
		          layer.close(index); //关闭弹层
		      },
		      end :function() {
		    	  tableRefresh();
              }
		  });
	 }
		//删除
		window.deleteLink = function(id){
			layer.confirm("确认要删除吗，删除后不能恢复", { title: "删除确认" }, function (index) {
		      layer.close(index);
		      $.post("<%=request.getContextPath() %>/banner/removeBanner.do", { id: id }, function (data) {
		          if(data.code == 1){
		          	layer.msg('删除成功');
		          }else if(data.code == 0){
		          	layer.msg(data.msg);
		          }
		          tableRefresh();
		      }); 
		  });
		}
		
		/**
		 * 修改排序
		 */
		window.editSequence = function(type, id){
			$.ajax({
				type: 'POST',
				url:"<%=request.getContextPath()%>/banner/editSequence.do",
				data:{id:id, type:type},
				dataType: 'json',
				success: function(data){
					tableRefresh();
				},
				error:function(data) {
					console.log(data.data);
				},
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