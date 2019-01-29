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
    <title>通知公告发布-列表</title>
</head>
<body class="childrenBody">
<form class="layui-form" id="roleForm">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" class="layui-input searchVal" id="key" name="key" value="" placeholder="通知公告名称关键词搜索" />
                </div>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input searchVal" id="dateRange" name="dateRange" value="" placeholder="发布日期范围" />
                </div>
                <div class="layui-input-inline">
                    <select id="status" name="status" class="layui-select">
                    	<option value="">状态</option>
                    	<option value="1">未发布</option>
                    	<option value="2">已发布</option>
                    	<option value="3">已撤回</option>
                    </select>
                </div>
<!--                 <div class="layui-input-inline"> -->
<!--                     <select id="publisher" name="publisher" class="layui-select"> -->
<!--                     	<option value="">发布人</option> -->
<!--                     </select> -->
<!--                 </div> -->
                <button class="layui-btn search_btn" type="button">搜索</button>
            </div>

            <div class="layui-inline a2">
                <button class="layui-btn layui-btn-primary" type="reset">重置</button>
            </div>
            <div class="layui-inline a2">
            	<c:if test="${sessionScope.btn.add == 1 }">
	                <a class="layui-btn addNews_btn" onclick="goAdd()">新建通知公告</a>
            	</c:if>
            </div>
        </form>
    </blockquote>
</form>
    <table id="noticeList" lay-filter="noticeList"></table>
    
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript">
$(function(){
	layui.use(['form','layer','table', 'laydate'],function(){
		var form = layui.form,
	    layer = parent.layer === undefined ? layui.layer : top.layer,
	    $ = layui.jquery,
	    table = layui.table,
		laydate = layui.laydate;
	
		laydate.render({
		    elem: '#dateRange'
		   ,range: true
		});
		
		//用户列表
	    var tableIns = table.render({
	        elem: '#noticeList',
	        url : '<%=request.getContextPath() %>/notice/publish/getListData.do',
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
	            {type:"numbers", title: '序号'},
	            {field: 'title', title: '通知公告名称', templet:function(d){
	            	return '<a  style="color:#01AAED;"  href="javascript:detailView(\''+d.id+'\');" title="预览-'+d.title+'">'+d.title+'</a>'
	            }},
	            {field: 'publisher', title: '发布人', templet:function(d){
	            	if(d.publishStatus == '2'){
		            	return d.publisherName;
	            	}else{
	            		return "-"
	            	} 
	            }},
	            {field: 'publishOrgName', title: '发布单位', templet:function(d){
	            	if(d.publishStatus == '2'){
		            	return d.publishOrgName;
	            	}else{
	            		return "-"
	            	} 
	            }},
	            {field: 'lastupdateTime', title: '发布日期', templet:function(d){
	            	if(d.publishStatus == '2' && d.lastupdateTime != ''){
		            	return timestampToTime(d.lastupdateTime);
	            	}else{
	            		return "-"
	            	} 
	            }},
	            {field: 'lookSituation', title: '查阅情况', templet:function(d){
	            	if(d.publishStatus == '2'){
		            	return "<a title='点击查看查阅情况' style='color:#01AAED;' href='javascript:receiveCondition(\""+d.id+"\",\""+d.isfeedback+"\");'>" + d.isLookNum + "/" + d.totalLookNum + "</a>";
	            	}else{
	            		return "-"
	            	}
	            }},
	            {field: 'lookSituation', title: '是否需要填报反馈', templet:function(d){
	            	if(d.publishStatus == '2' || d.publishStatus == '1'){
		            	if(d.isfeedback == '1'){
		            		return "是";
		            	}else{
		            		return "否";
		            	}
	            	}else{
	            		return "-";
	            	}
	            }},
	            {field: 'lookSituation', title: '填报情况', templet:function(d){
	            	if(d.publishStatus == '2' && d.isfeedback == '1'){
	            		return "<a title='点击查看填报情况' style='color:#01AAED;' href='javascript:receiveCondition(\""+d.id+"\",\""+d.isfeedback+"\");'>" + d.isWriteNum + "/" + d.totalWriteNum + "</a>";
	            	}else{
	            		return "-"
	            	}
	            }},
	            {field: 'lookSituation', title: '状态', templet:function(d){
	            	if(d.publishStatus == '1'){
// 		            	return '<button class="layui-btn layui-btn-primary layui-btn-xs">未发布</button>';
		            	return '未发布';
	            	}else if(d.publishStatus == '2'){
// 		            	return '<button class="layui-btn layui-btn-xs">已发布</button>';
		            	return '已发布';
	            	}else if(d.publishStatus == '3'){
		            	return '已撤回';
	            	}
	            }},
	            {title: '操作',align:"center",fixed: 'right',width:250,templet:function(d){
	            	var html = ''; 
	            	if(d.publishStatus == '2' && d.isfeedback == '1'){
		            	if('${sessionScope.btn.detail }' == '1'){
		            		html += '<a class="layui-btn layui-btn-xs layui-btn-primary" href="javascript:reportWriteView(\''+d.reportCode+'\', \''+d.id+'\');" title="填报详情">填报详情</a>';
		            	}
	            	}
	            	if(d.publishStatus == '1' || d.publishStatus == '3'){
	            		if('${sessionScope.btn.pub }' == '1'){
		            		html += '<a class="layui-btn layui-btn-xs"  href="javascript:publish(\''+d.id+'\');" title="发布">发布</a>';
	            		}
	            	}
	            	if(d.publishStatus == '2'){
	            		if('${sessionScope.btn.pub }' == '1'){
		            		html += '<a class="layui-btn layui-btn-xs"  href="javascript:recall(\''+d.id+'\');" title="撤回">撤回</a>';
	            		}
	            	}
	            	if('${sessionScope.btn.edit }' == '1'){
	           			html += '<a class="layui-btn layui-btn-xs"  href="javascript:goEdit(\''+d.id+'\');" title="编辑">编辑</a>';
	            	}
	            	if('${sessionScope.btn.del }' == '1'){
	            		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteNotice(\''+d.id+'\');" title="删除">删除</a>';
	            	}
	            	return html;
	            }}
	        ]]
	    });
		
	  //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	  $(".search_btn").on("click",function(){
		if($("#key").val() == '' && $("#dateRange").val() == '' && $("#status").val() == '' && $("#publisher").val() == ''){
			layer.msg("请输入筛选条件");
		}  
	    tableIns.reload({
	             page: {
	                 curr: 1 //重新从第 1 页开始
	             },
	             where: {
	                 key: $("#key").val(),  //搜索的关键字
	                 dateRange: $("#dateRange").val(),  //时间范围
	                 status: $("#status").val(),  //状态
	                 publisher: $("#publisher").val()  //发布人
	             }
	         })
	    });
	  //去新增页面
		  window.goAdd = function(){			
			  var index = layui.layer.open({
			      title : "新建通知公告",
			      type : 2,
			      content : "<%=request.getContextPath() %>/notice/publish/goAdd.do",
			      area: ['90%', '800px'],
			      success : function(layero,index,data){
			          var body = layui.layer.getChildFrame('body', index);
			          resizeLayer(index);
	//	 	          body.find("#id").val(data.id);  //登录名
			          setTimeout(function(){
			              layui.layer.tips('点击此处返回通知公告列表', '.layui-layer-setwin .layui-layer-close', {
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
	  //去编辑页面
  		window.goEdit = function(id){
		   var index = layui.layer.open({
		      title : "编辑通知公告",
		      type : 2,
		      content : "<%=request.getContextPath() %>/notice/publish/goEdit.do?id="+id,
			  area: ['90%', '800px'],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
			  		resizeLayer(index);
		            setTimeout(function(){
		                layui.layer.tips('点击此处返回通知公告列表', '.layui-layer-setwin .layui-layer-close', {
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
	  //去预览页面
  		window.detailView = function(id){
		  var index = layui.layer.open({
		      title : "通知公告详情",
		      type : 2,
		      content : "<%=request.getContextPath() %>/notice/publish/goDetailView.do?id="+id,
			  area: ['90%', '800px'],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
			  		resizeLayer(index);
		            setTimeout(function(){
		                layui.layer.tips('点击此处返回通知公告列表', '.layui-layer-setwin .layui-layer-close', {
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
	  //去通知公告查阅/填报情况列表页
  		window.receiveCondition = function(id, isfeedback){
		  var title = "";
		  if(isfeedback == '1'){
			  title = "填报情况";
		  }else{
			  title = "查阅情况";
		  }
		  var index = layui.layer.open({
		      title : title,
		      type : 2,
		      content : "<%=request.getContextPath() %>/notice/publish/goReceiveCondition.do?id="+id,
			  area: ['90%', '800px'],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
			  		resizeLayer(index);
		            setTimeout(function(){
		                layui.layer.tips('点击此处返回通知公告列表', '.layui-layer-setwin .layui-layer-close', {
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
	  //填报详情
  		window.reportWriteView = function(id, noticeId){
  			$.post("<%=request.getContextPath() %>/notice/publish/getReportData.do", { id: id }, function (data) {
  				if(data.code == 1){
	  				var index = layui.layer.open({
	  			      title : "填报详情",
	  			      type : 2,
	  			      content : "<%=request.getContextPath() %>/listPageGenNoticeController.do?goConfigformList&releaseCode="+data.data+"&noticeId="+noticeId,
	  				  area: ['90%', '90%'],
	  				  success : function(layero,index,data1){
	  			  		var body = layui.layer.getChildFrame('body', index);
	  			  		resizeLayer(index);
	  				  }
	  			  });
  				}else{
  					layer.msg(data.msg);
  				}
	      }); 
	 }
		//删除
		window.deleteNotice = function(id){
			layer.confirm("确认要删除吗，删除后不能恢复", { title: "删除确认" }, function (index) {
		      layer.close(index);
		      $.post("<%=request.getContextPath() %>/notice/publish/deleteNotice.do", { id: id }, function (data) {
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
		window.publish = function(id){
			layer.confirm("确认要发布吗？", { title: "发布确认" }, function (index) {
		      layer.close(index);
		      $.post("<%=request.getContextPath() %>/notice/publish/publishNotice.do", { id: id }, function (data) {
		          if(data.code == 1){
		          	layer.msg('发布成功');
		          }else if(data.code == 0){
		          	layer.msg(data.msg);
		          }
		          tableIns.reload();
		      }); 
		  });
		}
		//撤回
		window.recall = function(id){
			layer.confirm("确认要撤回吗？", { title: "撤回确认" }, function (index) {
		      layer.close(index);
		      $.post("<%=request.getContextPath() %>/notice/publish/backNotice.do", { id: id }, function (data) {
		          if(data.code == 1){
		          	layer.msg('撤回成功');
		          }else if(data.code == 0){
		          	layer.msg(data.msg);
		          }
		          tableIns.reload();
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