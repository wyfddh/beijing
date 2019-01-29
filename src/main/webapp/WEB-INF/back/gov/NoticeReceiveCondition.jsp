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
    <style type="text/css">
    .laytable-cell-1-7, .laytable-cell-1-5{
    	width: 100px !important;
    }
    .layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
	     top: 50%;
	     transform: translateY(-50%);
	}
    </style>
    <title>通知公告-填报查看</title>
</head>
<body class="childrenBody">
<form class="layui-form" id="roleForm">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" class="layui-input searchVal" id="key" name="key" value="" placeholder="输入机构单位名称检索" />
                </div>
                <div class="layui-input-inline">
                    <select id="lookStatus" name="lookStatus" class="layui-select">
                    	<option value="">阅读状态</option>
                    	<option value="0">未查阅</option>
                    	<option value="1">已查阅</option>
                    </select>
                </div>
                <c:if test="${isfeedback == '1' }">
	                <div class="layui-input-inline">
	                    <select id="writeStatus" name="writeStatus" class="layui-select">
	                    	<option value="">填报状态</option>
	                    	<option value="0">未填写</option>
	                    	<option value="1">未提交</option>
	                    	<option value="2">已提交</option>
	                    </select>
	                </div>
                </c:if>
                <button class="layui-btn search_btn" type="button">搜索</button>
            </div>
			
            <div class="layui-inline a2">
				<c:if test="${isfeedback == '1' }" var="isfeedback">
	                <a class="layui-btn layui-btn-normal addNews_btn" onclick="urges()">一键催办</a>
				</c:if>
				<c:if test="${!isfeedback }">
	                <a class="layui-btn layui-btn-normal addNews_btn" onclick="urges()">一键提醒</a>
				</c:if>
    	            <a class="layui-btn layui-btn-primary addNews_btn" onclick="exportToExcel()">导出</a>
            </div>
        </form>
    </blockquote>
    <table id="noticeList" lay-filter="noticeList"></table>
    
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
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
		
		var isFeedSetting = [[]];
		if('${isfeedback}' == 'true'){ 
			isFeedSetting = [[
	            {type:'checkbox', align:"center"},
	            {type:"numbers", title: '序号',align:"center"},
	            {field: 'receiveOrgName', title: '机构单位名称'},
	            {field: 'receiveStatus', title: '查阅状态', templet:function(d){
	            	if(d.receiveStatus == '0'){
	            		return "未查阅";
	            	}else{
	            		return "已查阅";
	            	}
	            }},
	            {field: 'lookTime', title: '查阅时间', templet:function(d){
	            	if(d.receiveStatus == '0'){
	            		return "-";
	            	}else{
		            	return timestampToTime(d.lookTime);
	            	}
	            }},
	            {field: 'receiveStatus', title: '填报状态', templet:function(d){
	            	if(d.receiveStatus == '0' || d.receiveStatus == '1'){
	            		return "未填写";
	            	}else if(d.receiveStatus == '2'){
	            		return "未提交";
	            	}else if(d.receiveStatus == '4'){
	            		return "已提交";
	            	}
	            }},
	            {field: 'writeTime', title: '填报时间', templet:function(d){
	            	if(d.receiveStatus == '0' || d.receiveStatus == '1'){
	            		return "-";
	            	}else if(d.receiveStatus == '2'){
	            		return timestampToTime(d.writeTime);
	            	}else if(d.receiveStatus == '4'){
	            		return timestampToTime(d.writeTime);
	            	}
	            }},
	            {title: '操作',align:"center",style:"width:100px;",fixed:"right",templet:function(d){
	            	var html = ''; 
	            	if(d.receiveStatus == '0' || d.receiveStatus == '1' || d.receiveStatus == '2'){
		        		html += '<a class="layui-btn layui-btn-xs layui-btn-warm"  href="javascript:urge(\''+d.orgId+'\');" title="催办">催办</a>';
	            	}else if(d.receiveStatus == '4'){
	            		html += '<a class="layui-btn layui-btn-xs"  href="javascript:view(\''+d.bussCode+'\',\''+d.reportId+'\');" title="查看">查看</a>';
	            	}
	            	return html;
	            }}
	        ]]
		}else{
			isFeedSetting = [[
	            {type:'checkbox', align:"center"},
	            {type:"numbers", title: '序号',align:"center"},
	            {field: 'receiveOrgName', title: '机构单位名称'},
	            {field: 'receiveStatus', title: '查阅状态', templet:function(d){
	            	if(d.receiveStatus == '0'){
	            		return "未查阅";
	            	}else{
	            		return "已查阅";
	            	}
	            }},
	            {field: 'lookTime', title: '查阅时间', templet:function(d){
	            	if(d.receiveStatus == '0'){
	            		return "-";
	            	}else{
		            	return timestampToTime(d.lookTime);
	            	}
	            }},
	            {title: '操作',align:"center",style:"width:100px;",fixed:"right",templet:function(d){
	            	var html = ''; 
	            	if(d.receiveStatus == '0'){
		        		html += '<a class="layui-btn layui-btn-xs layui-btn-warm"  href="javascript:urge(\''+d.orgId+'\');" title="提醒查阅">提醒查阅</a>';
	            	}else{
	            		html += '-';
	            	}
	            	return html;
	            }}
	        ]]
		}
		
		
		//用户列表
	    var tableIns = table.render({
	        elem: '#noticeList',
	        url : '<%=request.getContextPath() %>/notice/publish/getReceiveListCondition.do?noticeId=${noticeId}',
	        cellMinWidth : 80,
	        request:{
	        	pageName: 'currentPage',
	        	limitName: 'size'
	        },
	        page : true,
	        limits : [10,20,30,40,50,60,70,80,90,100,1000],
	        limit : 10,
	        id : "noticeListTable",
	        cols : isFeedSetting
	    });
		
	  //搜索
	  $(".search_btn").on("click",function(){
		if($("#key").val() == '' && $("#lookStatus").val() == '' && $("#writeStatus").val() == ''){
			layer.msg("请输入筛选条件");
		}  
	    tableIns.reload({
	             page: {
	                 curr: 1 //重新从第 1 页开始
	             },
	             where: {
	                 key: $("#key").val(),  //搜索的关键字
	                 lookStatus: $("#lookStatus").val(),  //时间范围
	                 writeStatus: $("#writeStatus").val()  //状态
	             }
	         })
	    });
		//一键催办或者一键提醒
		window.urges = function(){
			//获取当前类别
			var isfeedback = '${isfeedback}';
			var recever = "";
			var checkItem = layui.table.checkStatus('noticeListTable');
			console.log(checkItem);
			var checkOrg = "";
			for (var i = 0; i < checkItem.data.length; i++) {
				checkOrg += checkItem.data[i].orgId + ",";
			}
			if(!checkOrg == ""){
				checkOrg = checkOrg.substring(0, checkOrg.length-1);
			}
			console.log(checkOrg);
			if(checkOrg == ""){
			   layer.msg('请勾选通知对象');
			}else{
				layer.confirm("确认通知选中的接收单位？", { title: "通知确认" }, function (index) {
				      layer.close(index);
				      $.post("<%=request.getContextPath() %>/notice/publish/OnekeyUrges.do", {checkOrg:checkOrg, noticeId:'${noticeId}', isfeedback: isfeedback }, function (data) {
				          if(data.code == 1){
				          	layer.msg('通知成功');
				          }else{
				          	layer.msg(data.msg);
				          }
				          tableIns.reload();
				      }); 
				  });
			}
		}
		//单个催办或者提醒
		window.urge = function(checkOrg){
			//获取当前类别
			var isfeedback = '${isfeedback}';
			var recever = "";
			console.log(checkOrg);
			if(checkOrg == ""){
			   layer.msg('请勾选通知对象');
			}else{
				layer.confirm("确认通知该接收单位？", { title: "通知确认" }, function (index) {
				      layer.close(index);
				      $.post("<%=request.getContextPath() %>/notice/publish/OnekeyUrges.do", {checkOrg:checkOrg, noticeId:'${noticeId}', isfeedback: isfeedback }, function (data) {
				          if(data.code == 1){
				          	layer.msg('通知成功');
				          }else{
				          	layer.msg(data.msg);
				          }
				          tableIns.reload();
				      }); 
				  });
			}
		}
	});
	
	
	//导出到excel
	window.exportToExcel = function() {
		var projectName = '<%=request.getContextPath() %>';
		var url = projectName + '/notice/publish/exportReceiveListCondition.do?noticeId=${noticeId}';
		if($("#key").val() != ''){
			url += '&key='+$("#key").val();
		}
		if($("#lookStatus").val() != ''){
			url += '&lookStatus='+$("#lookStatus").val();
		}
		if($("#writeStatus").val() != '' && $("#writeStatus").val() != undefined){
			url += '&writeStatus='+$("#writeStatus").val();
		}
		window.location.href = url;
	}
	
	/*查看*/
	window.view = function(code, mainId){
		var index1 = layui.layer.open({
		      title : "查看",
		      type : 2,
		      content : "<%=request.getContextPath() %>/aceAutoController.do?modePage&isDisabled=true&type=page&releaseCode="+code+"&mainId="+mainId,
		      area: ['90%', '95%'],
		      success : function(layero,index,data){
		          resizeLayer(index);
		      }
		  });
	}
	
	//时间戳转时间格式
	function timestampToTime(timestamp) {
		console.log(timestamp);
	    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
	    Y = date.getFullYear() + '-';
	    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	    D = (date.getDate() < 10 ? '0'+(date.getDate()) : date.getDate()) + ' ';
	    h = date.getHours() + ':';
	    m = date.getMinutes();
	    s = date.getSeconds();
	    return Y+M+D+h+m;
	}
});


</script>
</body>
</html>