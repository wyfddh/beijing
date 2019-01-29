<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,java.io.*"
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
	    .layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
		     top: 50%;
		     transform: translateY(-50%);
		}
    </style>
    <title>文创产品-列表</title>
</head>
<body class="childrenBody">
<form class="layui-form" id="roleForm">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
            	<div class="layui-input-inline">
            		<input class="layui-input inputText" placeholder="专题名称/标签" type="text" id="key" name="key">
            	</div>
            	<div class="layui-input-inline" style="width: 100px;">
	            	<select class="layui-select" name="status" id="status">
	            		<option value="">发布状态</option>
						<option value="2">已发布</option>
						<option value="1">待发布</option>
					</select>
            	</div>
            	<div class="layui-input-inline">
	            	<select class="layui-select" name="museumId" id="museumId">
	            		<option value="">发布单位</option>
						<c:forEach items="${musList}" var="mus" varStatus="row">
							<option value="${mus.id}">${mus.name}</option>
						</c:forEach>
					</select>
            	</div>
            	<div class="layui-input-inline" >
	                <button class="layui-btn search_btn" type="button">搜索</button>
	                <c:if test="${sessionScope.btn.add == 1 }">
		                <a class="layui-btn addNews_btn" onclick="goAdd()">新增</a>
	            	</c:if>
	            	<c:if test="${sessionScope.btn.export == 1 }">
		                <a class="layui-btn export_btn" onclick="exportCollection()">导出</a>
	            	</c:if>
               </div>
            </div>
        </form>
    </blockquote>
    <table id="noticeList" lay-filter="noticeList"></table>
    
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript">
	layui.use(['form','layer','table', 'laydate'],function(){
		var form = layui.form,
	    layer = parent.layer === undefined ? layui.layer : top.layer,
	    $ = layui.jquery,
	    table = layui.table,
		laydate = layui.laydate;
		
		//用户列表
	    var tableIns = table.render({
	        elem: '#noticeList',
	        url : '<%=request.getContextPath() %>/topic/getListData.do',
	        cellMinWidth : 80,
	        request:{
	        	pageName: 'currentPage',
	        	limitName: 'size'
	        },
	        page : true,
	        limits : [10,20,25],
	        limit : 10,
	        id : "noticeListTable",
	        cols : [[
	        	{type:'checkbox'},
	            {type:"numbers", title: '序号',align:"center"},
	            {field: 'name', title: '专题名称'},
	            {field: 'collectionCount', title: '藏品数量'},
	            {field: 'label', title: '标签',templet:function(d){
	            	if (!isEmpty(d.label)) {
	            		var arr=new Array();
	            		var str = "";
	            		arr = d.label.split(',');
	            		for (var i=0;i<arr.length;i++) {
	            			str+='<button class="layui-btn layui-btn-xs" style="background-color: #3f9bfe;border-radius: 10px;">'+ arr[i] +'</button>'
	            		}
	            		return str;
	            	} else {
	            		return "";
	            	}
	            }},
	            {field: 'type', title: '专题分类'},
	            {field: 'publishOrgName', title: '发布单位'},
	            {field: 'publishTime', title: '发布时间', templet:function(d){
	            	if(d.status != '2' || d.publishTime == null){
	            		return "-";
	            	}else{
	            		return timestampToTime(d.publishTime);
	            	}
            		return '<button class="layui-btn layui-btn-primary layui-btn-xs">未发布</button>';
	            }},
	            {field: 'status', title: '状态', templet:function(d){
	            	if(d.status == '1'){
	            		return '<button class="layui-btn layui-btn-primary layui-btn-xs">未发布</button>';
	            	}else if(d.status == '2'){
	            		return '<button class="layui-btn layui-btn-xs">已发布</button>';
	            	}else{
	            		return "-";
	            	}
	            }},
	            {title: '操作',align:"center",fixed: 'right',width:240,templet:function(d){
	            	var html = ''; 
	           			html += '<a class="layui-btn layui-btn-xs layui-btn-primary"  href="javascript:goEdit(\''+d.id+'\');"  title="查看">查看</a>';
	            	if(d.status == '1'){
		            	if('${sessionScope.btn.pub}' == '1' && d.isShow == '1'){
		           			html += '<a class="layui-btn layui-btn-xs"  href="javascript:pub(\''+d.id+'\');" title="发布">发布</a>';
		            	}
		            	if('${sessionScope.btn.del}' == '1' && d.isShow == '1'){
		            		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteLink(\''+d.id+'\');" title="删除">删除</a>';
		            	}
	            	}else if(d.status == '2'){
	            		if('${sessionScope.btn.pub}' == '1' && d.isShow == '1'){
		           			html += '<a class="layui-btn layui-btn-xs"  href="javascript:unpub(\''+d.id+'\');" title="取消发布">取消发布</a>';
		            	}
	            	}
	            	return html;
	            }}
	        ]]
	    });
		
	    function isEmpty(obj){
	        if(typeof obj == "undefined" || obj == null || obj == "")	{
	            return true;
	        }else{
	            return false;
	        }
	    };
		
	  //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	  $(".search_btn").on("click",function(){
		if($("#key").val() == '' && $("#status").val() == '' && $("#museumId").val() == ''){
			layer.msg("请输入筛选条件");
		}  
	    tableIns.reload({
	             page: {
	                 curr: 1 //重新从第 1 页开始
	             },
	             where: {
	                 key: $("#key").val(),  //搜索的关键字
	                 status: $("#status").val(),  //状态
	                 museumId: $("#museumId").val()  //博物馆id
	             }
	         })
	    });
	  //去新增页面
		  window.goAdd = function(){
			  var index = layui.layer.open({
			      title : "新增藏品专题",
			      type : 2,
			      content : "<%=request.getContextPath() %>/topic/goAdd.do",
			      area: ['500px', '300px'],
			      success : function(layero,index,data){
			          var body = layui.layer.getChildFrame('body', index);
					  //自适应高度
				  	  resizeLayer(index);
			          setTimeout(function(){
			              layui.layer.tips('点击此处返回藏品专题列表', '.layui-layer-setwin .layui-layer-close', {
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
		}
	  //去编辑页面
  		window.goEdit = function(id){
		  var index = layui.layer.open({
		      title : "编辑藏品专题",
		      type : 2,
		      content : "<%=request.getContextPath() %>/topic/goEditTopicPage.do?topicId="+id,
		      area: ['700px', '750px'],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
					//自适应高度
			  	  	resizeLayer(index);
		            setTimeout(function(){
		                layui.layer.tips('点击此处返回藏品专题列表', '.layui-layer-setwin .layui-layer-close', {
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
		//删除
		window.deleteLink = function(id){
			layer.confirm("确认要删除吗，删除后不能恢复", { title: "删除确认" }, function (index) {
		      layer.close(index);
		      $.post("<%=request.getContextPath() %>/topic/deleteTopic.do", { id: id }, function (data) {
		          if(data.code == 1){
		          	layer.msg('删除成功');
		          }else if(data.code == 0){
		          	layer.msg(data.msg);
		          }
		          tableIns.reload();
		      }); 
		  });
		}
		//发布
		window.pub = function(id){
			layer.confirm("确认要发布吗", { title: "发布确认" }, function (index) {
		      layer.close(index);
		      updatePublish(id);
		  });
		}
		//取消发布
		window.unpub = function(id){
			layer.confirm("确认要取消发布吗", { title: "取消发布确认" }, function (index) {
		      layer.close(index);
		      updatePublish(id);
		  });
		}
		
		//发布获取取消发布
		function updatePublish(id){
			$.post("<%=request.getContextPath() %>/topic/publishTopic.do", { id: id }, function (data) {
		          if(data == 'success'){
		          	layer.msg('操作成功');
		          }else if(data == 'error'){
		          	layer.msg(data);
		          }
		          tableIns.reload();
		      }); 
		}
		
		window.exportCollection = function(){
			var checkStatus = table.checkStatus('noticeListTable'); //test即为基础参数id对应的值
			if(checkStatus.data.length == 0){
				layer.msg("请选择需要导出的专题!");
				return false;
			}
			var dataListString = "";
			for(var i=0; i<checkStatus.data.length; i++){
				dataListString += checkStatus.data[i].id + ",";
			}
			if(dataListString.length > 0){
				dataListString = dataListString.substring(0, dataListString.length-1);
			}
			console.log(dataListString);
			window.location.href ="<%=request.getContextPath() %>/topic/exportCollection.do?topicIds="+dataListString;
		}
		
	});
	//时间戳转时间格式
	function timestampToTime(obj) {
		var date =  new Date(obj);
	    var y = 1900+date.getYear();
	    var m = "0"+(date.getMonth()+1);
	    var d = "0"+date.getDate();
	    var h = date.getHours() + ':';
	    var mi = date.getMinutes();
	    var s = date.getSeconds();
	    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
	}


</script>
</body>
</html>