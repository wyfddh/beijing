<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
 <!DOCTYPE html>
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
    <!--/meta 作为公共模版分离出去-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <style type="text/css">
   
    </style>
    <title>通知公告接收列表</title>
</head>
<body onselectstart="return false" style="-moz-user-select:none;padding:10px;">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form" id="myform">    
	            <div class="layui-inline">
	                <div class="layui-input-inline">
	                    <input type="text" class="layui-input searchVal" placeholder="请输入通知公告名称"  name="key" id="key"/>
	                </div>
	                <div class="layui-input-inline">
				        <input type="text" class="layui-input" id="lastUpdateTime" name="lastUpdateTime" placeholder="发布日期范围 ">
			      	</div>
	                <div class="layui-input-inline" style="width:150px;">
	                    <select id="isFeedBack" name="isFeedBack">
	                      	<option value="">是否需要反馈</option>
                        	<option value="1">是</option>
                        	<option value="0">否</option>
	                    </select>
	                </div>
	                <div class="layui-input-inline">
						<select name="publishOrg" id="publishOrg" lay-search>
							<option value="">选择发布单位</option>
							<c:forEach items="${orgList}" var="org" varStatus="row">
								<option value="${org.id}" >${org.name}</option>	
							</c:forEach>
						</select>
					</div>
					<div class="layui-input-inline" style="width:150px;">
	                    <select id="receiveStatus" name="receiveStatus">
	                      	<option value="">选择状态</option>
                        	<option value="0">未查阅</option>
                        	<option value="1">未填写</option>
                        	<option value="2">未提交</option>
                        	<option value="3">已撤回</option>
                        	<option value="4">已提交</option>
                        	<option value="5">已查阅</option>
	                    </select>
	                </div>
	                <a class="layui-btn search_btn search" data-type="reload"  name="search">搜索</a>
	                <a class="layui-btn layui-btn-primary reset" data-type="reload" name="reset" style="margin-left:0px">重置</a>
                	<input type="reset" id="reset" value="重置" hidden>
	            </div>		            
    		</form> 
  	</blockquote>  	           
     <div>
         <table class="layui-hide" id="receiveList"></table>                
     </div>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/jQuery-searchableSelect/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/jQuery-searchableSelect/jquery.searchableSelect.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript">
$(function(){
	layui.use(['form','layer','table','laytpl','laydate'],function(){
	     	form = layui.form,
	        layer = parent.layer === undefined ? layui.layer : top.layer,
	        $ = layui.jquery,
	        laytpl = layui.laytpl,
	        table = layui.table,
	        laydate = layui.laydate;
	})	
	 //日期范围
	laydate.render({
	    elem: '#lastUpdateTime'
	    ,range: true
	 });
	
   tableIns = table.render({
	    elem: '#receiveList',
	    url:'<%=request.getContextPath() %>/notice/receive/getList.do',
	    request:{
        	pageName: 'currentPage',
        	limitName: 'size'
	     },
	    page : true,
	    limits : [10,15,20,25],
        limit : 10,
	    cols: [[
	       {type:'numbers'}
	      ,{field:'title',title: '通知公告名称'}
	      ,{field:'lastUpdateTime',title: '发布时间', templet:function(d){
	          	if(d.receiveStatus == '3'){
	     	      	return "-";
	        	}else{
	        		return d.lastUpdateTime;
	        	}
        	}}
	      ,{field:'isFeedBack',title: '是否需要反馈', templet:function(d){
	          	if(d.receiveStatus == '3'){
	            	return "-";
	        	}else if(d.isFeedBack=="0"){
	        		return "否";
	        	}else{
	        		return "是";
	        	}
        	}}
	      ,{field:'deadlineTime',title: '反馈截止时间', templet:function(d){
	          	if(d.receiveStatus != '3' && d.deadlineTime != null){
	            	return d.deadlineTimeStr;
	  	    	}else{
	        		return "-";
	        	}
        	}}
	      ,{field:'publishOrg',title: '发布单位', templet:function(d){
	          	if(d.receiveStatus == '3'){
	            	return "-";
	        	}else{
	        		return d.publishOrg;
	        	}
        	}}
	      ,{field:'receiver',title: '当前负责人', templet:function(d){
	          	if(d.receiveStatus == '3'){
	            	return "-";
	        	}else{
	        		return d.receiver;
	        	}
        	}}
	      ,{field:'receiveStatus',title: '状态', templet:function(d){
	          	if(d.receiveStatus == '0'){
	            	return "未查阅";
	        	}else if(d.receiveStatus == '1'){
	        		return '<span style="color: #FFB800;">未填写</span>';
	        	}else if(d.receiveStatus == '2'){
	        		return '<span style="color: #FFB800;">未提交</span>';
	        	}else if(d.receiveStatus == '3'){
	        		return "已撤回";
	        	}else if(d.receiveStatus == '4'){
	        		return "已提交";
	        	}else if(d.receiveStatus == '5'){
	        		return "已查阅";
	        	}
        	}}
	      ,{width:200, title: '操作',align:"center",fixed:'right',templet:function(d){
          	var html = ''; 
          	if('${sessionScope.btn.show }' == '1'){
	        	if(d.receiveStatus == '0'){        		
	        		html += '<a class="layui-btn layui-btn-xs"  href="javascript:view(\''+d.id+'\','+d.isFeedBack+','+d.receiveStatus+');" title="查阅">查阅</a>';
	        	}else if(d.receiveStatus == '1'){
	        		html += '<a class="layui-btn layui-btn-xs"  href="javascript:view(\''+d.id+'\','+d.isFeedBack+','+d.receiveStatus+');" title="查看详情">查看详情</a>';
	        	}else if(d.receiveStatus == '2'){
	        		html += '<a class="layui-btn layui-btn-xs"  href="javascript:view(\''+d.id+'\','+d.isFeedBack+','+d.receiveStatus+');" title="查看详情">查看详情</a>';
	        	}else if(d.receiveStatus == '3'){
	        		html += '-';
	        	}else if(d.receiveStatus == '4'){
	        		html += '<a class="layui-btn layui-btn-xs"  href="javascript:view(\''+d.id+'\','+d.isFeedBack+','+d.receiveStatus+');" title="查看详情">查看详情</a>';
	        	}else if(d.receiveStatus == '5'){
	        		html += '<a class="layui-btn layui-btn-xs"  href="javascript:view(\''+d.id+'\','+d.isFeedBack+','+d.receiveStatus+');" title="查看详情">查看详情</a>';
	        	}
        	}
          	if('${sessionScope.btn.send }' == '1'){
          		 if(d.receiveStatus == '1'){
	        		html += '<a class="layui-btn layui-btn-xs"  href="javascript:send(\''+d.id+'\');" title="转发">转发</a>';
          		 }
          	}
        	return html;
        }}
	    ]]
	  }); 
	 
	 
})

function reloadTable() {
	tableIns.reload({
		  where: { //设定异步数据接口的额外参数，任意设
			  key: $("#key").val(),
			  lastUpdateTime: $("#lastUpdateTime").val(),
			  isFeedBack: $("#isFeedBack").val(),
			  publishOrg: $("#publishOrg").val(),
			  receiveStatus: $("#receiveStatus").val()
		  }
		  ,page: {
		    curr: 1 //重新从第 1 页开始
		  }
		});
}

$(".search").click(function() {
	reloadTable();
})
//点击重置
$(".reset").click(function(){
    	$("#key").val('') ; 
    	$("#lastUpdateTime").val('') ; 
    	$("#isFeedBack").val('');
    	$("#publishOrg").val('');
    	$("#receiveStatus").val('');
    	form.render();
    	reloadTable();
});

function view(id,isFeedBack,receiveStatus){
	if(receiveStatus=='0'){//如果是未查阅
		if(isFeedBack == '0'){  //如果是不需反馈 直接变为已查阅
			receiveStatus = "5";
		}else{                   //如果是需反馈 变为未填写
			receiveStatus = "1";
		}
		$.ajax({
			url : "<%=request.getContextPath()%>/notice/receive/changeStatus.do?id="+id+"&receiveStatus="+receiveStatus,
			dataType : "json",
			async: false,
			success : function(data){
				if(data==1){
					console.log("更新状态成功")
				}else{
					layer.msg('系统异常', {icon: 2});
				}
			}
		})
	}
    var index = layui.layer.open({
	      title : "通知公告详情",
	      type : 2,
	      content : "<%=request.getContextPath() %>/notice/receive/goDetail.do?id="+id,
		  area: ['70%','800px'],
		  success : function(layero,index){
		  		var body = layui.layer.getChildFrame('body', index);
		  		resizeLayer(index);	           
			},
	      yse:function (index, layero) {
	          layer.close(index); //关闭弹层
	      },
	      end :function() {
	    	  reloadTable();
          }
	  });
    layui.layer.full(index);  
    window.sessionStorage.setItem("index",index);
}

function send(id){
	var url = "<%=request.getContextPath() %>/notice/receive/goSend.do?id="+id;
    layer.open({
        type: 2,
        title: '通知公告转发',
        shadeClose: true,
        shade: 0.5,
        maxmin: true, //开启最大化最小化按钮
        area: ['600px', '300px'],
        content: [url,'no'],
        end: function () {
        	reloadTable();
        }
    });
};

</script>
</body>
</html>