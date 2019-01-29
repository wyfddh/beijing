<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/userMangermen/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/userMangermen/css/public.css" media="all" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/admin.css" media="all" />
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
body{
	min-width: 1400px;
}
.input-length{
	width:300px;
}
.childrenBody{
	padding:30px;
}
.layui-row{
	padding-bottom:10px;
}
.layuiadmin-card-text{
	padding: 10px;
}
.layui-text-center{
	overflow: hidden;
	white-space: nowrap;
 	height: 22px !important; 
 	margin: 0px !important;
 	text-overflow: ellipsis;
 	padding-right: 44px;
}
.layui-text-center button{
	position: absolute;
    right: 15px;
}
.layui-text-bottom{
	float: right;
	text-align: right;
	padding-right: 15px;
}
.layui-text-bottom label{
	color: #CCC;
    font-size: 12px;
    right: 0;
}
.layuiadmin-card-text .layui-text-top a{
	padding-left: 10px;
	vertical-align: center;
    font-size: 14px !important;
}
.layuiadmin-card-text .layui-text-top{
    border-radius: 4px;
    padding-top: 5px !important;
    padding-bottom: 5px !important;
    margin-top: 10px;
}
.layuiadmin-card-text{
	background-color: #fff !important;
}

.span1{
	margin-left: 50px;
}
.report_chat{
	width: 100%;
	height: 300px;
}
.reportFather:after{
	content:"";
	display:block;
	clear:both;
}
.reportFather{
	padding-bottom: 30px;
}
#businessTypeDiv .layui-unselect{
	height: 30px;
}

.reportChat1{
	width:70px !important;
	float: right;
	position: absolute;
	z-index:999;
	right:70px;
}
.reportChat1 select{
	width:70px !important;
}

</style>
<title></title>
</head>
<body class="childrenBody" style="background-color: #f2f2f2;padding:10px;">
	<form class="layui-form">
		<input type="hidden" id="orgId" name="orgId" value="${orgId}"/>
		<div class="layui-row layui-col-space10">
			<div class="layui-col-md6">
				<div class="layui-row layui-col-md12">
					<div class="layui-card">
					  <div class="layui-card-header">
			               <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/desk-p1.png" alt="">&nbsp;&nbsp;通知公告</a>
					  </div>
					  <div class="layui-card-body">
			            <div class="layui-collapse" lay-accordion="">
				            <c:forEach items="${publishList}" var="item" varStatus="sta">
								<div class="layui-colla-item">
									<div class="layui-colla-title layui-row" style="height: 31px;background-color: #ffffff;">
										<div class="layui-input-inline layui-col-md6">
											<a href="javascript:void(0);" style="text-align: left; display: block;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" title="${item.title}">${item.title}</a>
										</div>
										<div class="layui-input-inline layui-col-md3" style="padding-left: 20px;">
											<span style="text-align: left; display: block"><fmt:formatDate value="${item.lastupdateTime }" pattern="yyyy-MM-dd" />发布</span>
										</div>
										<div class="layui-input-inline layui-col-md3">
											<c:if test="${item.isfeedback == '1' }" var="isFeedBack">
												<c:if test="${not empty item.deadlineTime }"
													var="deadLineTypeIsNotNull">
													<span style="text-align: left; display: block"><fmt:formatDate value="${item.deadlineTime }" pattern="yyyy-MM-dd HH:mm" />截至</span>
												</c:if>
												<c:if test="${!deadLineTypeIsNotNull }">
													<span style="text-align: left; display: block">无截至时间</span>
												</c:if>
											</c:if>
											<c:if test="${!isFeedBack }">
												<span style="text-align: left; display: block">不需要填写反馈</span>
											</c:if>
										</div>
										<c:if test="${not empty item.reportName && item.reportName ne null}">
											<div class="layui-input-inline layui-col-md12">
												<a class="label-title"><img src="<%=request.getContextPath()%>/back/images/file_pic.png" alt="">${item.reportName}<span>(${item.deadlineTimeStr})截止</span></a>
											</div>
										</c:if>
									</div>
									<div class="layui-colla-content">
										<c:if test="${item.isfeedback == '1' }" var="isFeedBack">
											<div style="width: 50px;display: inline-block; float: left;">已填报</div>
											<div class="layui-progress layui-progress-big" lay-showpercent="yes" style="margin-left: 50px;">
												<div class="layui-progress-bar" lay-percent="${item.isWriteNum }家" style="width: ${item.isWritePercent };"></div>
							                </div>
							                <div style="width: 50px;display: inline-block; float: left;transform: translate(-50px,10px);">未填报</div>
											<div class="layui-progress layui-progress-big" lay-showpercent="yes" style="margin-top: 10px;margin-bottom: 10px;margin-left: 50px;">
												<div class="layui-progress-bar" lay-percent="${item.totalWriteNum - item.isWriteNum }家" style="width: ${item.notWritePercent };"></div>
							                </div>
							                <c:if test="${item.isWriteNum == item.totalWriteNum }" var="isAll">
								                <span class="span1">已填报<b><font style="color: #5FB878;">${item.isWriteNum }</font></b>家，已全部完成填报，点击<a href="javascript:receiveCondition('${item.id }', '${item.isfeedback }');" style="color: #01AAED;">查看详情</a></span>
							                </c:if>
							                <c:if test="${!isAll }">
								                <span class="span1">已填报<b><font style="color: #5FB878;">${item.isWriteNum }</font></b>家，还剩<b><font style="color: #F00;">${item.totalWriteNum - item.isWriteNum }</font></b>家未填报，点击<a href="javascript:receiveCondition('${item.id }', '${item.isfeedback }');" style="color: #01AAED;">查看详情</a></span>
							                </c:if>
										</c:if>
										<c:if test="${!isFeedBack }">
											<div style="width: 50px;display: inline-block; float: left;">已查阅</div>
											<div class="layui-progress layui-progress-big" lay-showpercent="yes" style="margin-left: 50px;">
												<div class="layui-progress-bar" lay-percent="${item.isLookNum }家" style="width: ${item.isLookPercent };"></div>
							                </div>
											<div style="width: 50px;display: inline-block; float: left;transform: translate(-50px,10px);">未查阅</div>
											<div class="layui-progress layui-progress-big" lay-showpercent="yes" style="margin-top: 10px;margin-bottom: 10px;margin-left: 50px;">
												<div class="layui-progress-bar" lay-percent="${item.totalLookNum - item.isLookNum }家" style="width: ${item.notLookPercent };"></div>
							                </div>
							                <c:if test="${item.isLookNum == item.totalLookNum }" var="isAll1">
								                <span class="span1">已查阅<b><font style="color: #5FB878;">${item.isLookNum }</font></b>家，已全部完成查阅，点击<a href="javascript:receiveCondition('${item.id }', '${item.isfeedback }');" style="color: #01AAED;">查看详情</a></span>
							                </c:if>
							                <c:if test="${!isAll1 }">
								                <span class="span1">已查阅<b><font style="color: #5FB878;">${item.isLookNum }</font></b>家，还剩<b><font style="color: #F00;">${item.totalLookNum - item.isLookNum }</font></b>家未查阅，点击<a href="javascript:receiveCondition('${item.id }', '${item.isfeedback }');" style="color: #01AAED;">查看详情</a></span>
							                </c:if>
										</c:if>
									</div>
								</div>
							</c:forEach>
						</div>
					  </div>
					</div>
		        </div>
			</div>
	        <div class="layui-col-md6">
				<div class="layui-card">
				  <div class="layui-card-header">
	                 <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/desk-p3.png" alt="">&nbsp;&nbsp;站内消息</a>
	                 <div class="layui-input-inline" style="float:right">
		                 <a class="layui-btn  layui-btn-radius" onclick="goInsideInfoAdd()">发送信息</a>
			             <a class="layui-btn layui-btn-radius" onclick="messageDetailList()">已发列表</a>
		             </div>
				  </div>
				  <div class="layui-card-body">
				  	 <div class="layui-row">
				  	  	 <div class="layui-input-inline">
		                    <input type="text" class="layui-input searchVal" id="infoTitle" name="infoTitle" value="" placeholder="消息标题" />
		                 </div>
		                 <div class="layui-input-inline">
		                    <input type="text" class="layui-input searchVal" id="dateRange" name="dateRange" value="" placeholder="发布时间范围" />
		                 </div>
		                 <a class="layui-btn layui-btn-radius" onclick="searchMessage()">搜索</a>
		                
				  	  </div>
		              <div class="" id="mesList">
		              </div>
		              <div class="layui-row" id="mesButton">
		            		<span  style="float:right" >
		            			   <a class="layui-btn layui-btn-sm" onclick="last()"><i class="layui-icon"></i>前一页</a>
    							  <a class="layui-btn layui-btn-sm" onclick="next()"><i class="layui-icon"></i>后一页</a>
    					    </span>
			         </div>
				  </div>
				</div>
	        </div>
		</div>
		<div class="layui-row layui-col-md12">
			<div class="layui-input-inline layui-col-md12">
	            <div class="layui-card">
				  <div class="layui-card-header">
	                 <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/desk-p4.png" alt="">&nbsp;&nbsp;机构日常业务动态</a>
                     <button id="todayDynamic" type="button" class="layui-btn layui-btn-primary layui-btn-sm" style="margin-left: 15px;"></button>
                     <div id="businessTypeDiv" class="layui-input-inline" style="width: 100px;height: 30px;margin-left: 15px;">
	                     <select id="businessType" lay-filter="businessType">
					        <option value="">全部类型</option>
					        <option value="1">藏品</option>
					        <option value="2">社教</option>
					        <option value="3">展览</option>
<!-- 					        <option value="4">研究</option> -->
<!-- 					        <option value="5">文创</option> -->
					      </select>
                     </div>
				  </div>
				  <div class="layui-card-body">
				    	<ul class="layui-row layui-col-space10" id="todayUl">
							<!-- <li class="layui-col-xs3">
								<div class="layuiadmin-card-text">
									<p class="layui-text-center" title="东郊展馆常设展览">
										<b>东郊展馆常设展览东郊展馆常设展览东展馆常设展览东</b>&nbsp;&nbsp;
										<button class="layui-btn layui-btn-xs" type="button">展览</button>
									</p>
									<div class="layui-text-top" style="background-color: #f8f8f8;">
										<a href="javascript:void(0);">北京文物局</a>
										<span class="layui-text-bottom"><label>19天前</label></span>
									</div>
									<hr>
								</div>
							</li> -->
						</ul>
				  </div>
				</div>
			</div>
        </div>
		<div class="layui-row layui-col-md12">
			<div class="layui-card">
			  <div class="layui-card-header">
                 <a class="label-title"><img src="<%=request.getContextPath()%>/back/images/tongji.png" alt="">&nbsp;&nbsp;统计图表</a>
			  </div>
			  <div class="layui-card-body layui-col-space15 reportFather">
					<div class="layui-col-md6">
                     	<div class="reportChat1">
	                     	<select id="report_select1" lay-filter="report_select1">
	                     		<option value="1">按天</option>
	                     		<option value="2">按月</option>
	                     		<option value="3">按年</option>
	                     	</select>
                     	</div>
						<div id="attendanceDay" class="report_chat">
                     	</div>
					</div>
					<div class="layui-col-md6">
						<div class="reportChat1">
	                     	<select id="report_select2" lay-filter="report_select2">
	                     		<option value="1">按天</option>
	                     		<option value="2" selected>按月</option>
	                     		<option value="3">按年</option>
	                     	</select>
                     	</div>
						<div id="attendanceMonth" class="report_chat">
                     	</div>
					</div>
					<div class="layui-col-md6">
						<div id="collectionCount" class="report_chat">
                     	</div>
					</div>
					<div class="layui-col-md6">
						<div id="tempExhibition" class="report_chat">
                     	</div>
					</div>
			  </div>
			</div>
        </div>
        
 	</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/lay	page/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laydate/laydate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/echarts/echarts.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/report/report.js"></script>
<!--请在下方写此页面业务相关的脚本-->
	<!-- 分页功能 -->
<script type="text/javascript">
layui.use(['form','layer','table', 'laydate'],function(){
	var form = layui.form,
    layer = parent.layer === undefined ? layui.layer : top.layer,
    $ = layui.jquery,
    table = layui.table;
	var laydate = layui.laydate;
	
	searchMessage();
	
	var year = ${nowYear};//当前选中的年
	var month = ${nowMonth};//当前选中的月
	var orgId = ${orgId};//组织id
	var daysData = {};
	var monthsData ={};
	
	var days = getDaysInMonth(year,month);
	var intDayCols =new Array();
    for(var i=1;i<days+1;i++){
    	intDayCols.push({field: 'day'+i,minWidth:40, edit: 'text',title: i+'号'})
    }
    
    laydate.render({
      elem: '#todayDynamic'
      ,type: 'date'
      ,trigger: 'click' //采用click弹出
   	  ,show: false //直接显示
   	  ,isInitValue: false
   	  ,value: "全部时间"
      ,done: function(value, date, endDate){
    	  if(value == ''){
    		  $("#todayDynamic").text("全部时间");
    	  }
    	  searchTodayDynamic($("#todayDynamic").text());
      }
    });
    laydate.render({
		   elem: '#dateRange',
		   range: '~'
	});
    searchTodayDynamic();
    form.on('select(businessType)', function(data){
    	searchTodayDynamic($("#todayDynamic").text());
   	}); 
    
    form.on('select(report_select1)', function(data){
    	if($("#report_select1").val() == '1'){
	    	initReport("attendanceDay");
    	}else if($("#report_select1").val() == '2'){
	    	initReport("attendanceDay2");
    	}else if($("#report_select1").val() == '3'){
	    	initReport("attendanceDay3");
    	}
   	}); 
    form.on('select(report_select2)', function(data){
    	if($("#report_select2").val() == '1'){
	    	initReport("attendanceMonth");
    	}else if($("#report_select2").val() == '2'){
	    	initReport("attendanceMonth2");
    	}else if($("#report_select2").val() == '3'){
	    	initReport("attendanceMonth3");
    	}
   	}); 
    
	table.render({
        elem: '#daysList',
        url : '<%=request.getContextPath() %>/desk/dayVisitorList.do?month='+month+'&year='+year+'&orgId='+orgId, 
        page : false,
        id : "daysListTable",
        cols : [intDayCols],
        done: function(res, curr, count){
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
            daysData = res.data[0];
            console.log(daysData);
          }
     });
	
	var monthCols =new Array();
    for(var i=1;i<13;i++){
    	monthCols.push({field: 'month'+i,minWidth:40, edit: 'text',title: i+'月'})
    }
	table.render({
        elem: '#monthsList',
        url : '<%=request.getContextPath() %>/desk/monthVisitorList.do?year='+year+'&orgId='+orgId, 
        page : false,
        id : "monthsListTable",
        cols : [monthCols],
        done: function(res, curr, count){
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
            monthsData = res.data[0];
            console.log(monthsData);
          }
    });
	
	form.on('select(yearChange)', function(data){
    	yearOrMonthchange();
	 });
	
    form.on('select(monthChange)', function(data){
    	yearOrMonthchange();
	 });
    
    function yearOrMonthchange(){
    	month = $("select[name='month']").val();
    	year = $("select[name='year']").val();
    	days = getDaysInMonth(year,month);
		var dayCols =new Array();
        for(var i=1;i<days+1;i++){
        	dayCols.push({field: 'day'+i,minWidth:40, edit: 'text',title: i+'号'})
        }
		table.render({
	        elem: '#daysList',
	        url : '<%=request.getContextPath() %>/desk/dayVisitorList.do?month='+month+'&year='+year+'&orgId='+orgId, 
	        page : false,
	        id : "daysListTable",
	        cols : [dayCols],
	        done: function(res, curr, count){
	            //如果是异步请求数据方式，res即为你接口返回的信息。
	            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
	            daysData = res.data[0];
	            console.log(daysData);
	          }
	     });
		$("#yearTitle").text(year+'年度参观 人数统计：');
		
	    table.render({
	        elem: '#monthsList',
	        url : '<%=request.getContextPath() %>/desk/monthVisitorList.do?year='+year+'&orgId='+orgId, 
	        page : false,
	        id : "monthsListTable",
	        cols : [monthCols],
	        done: function(res, curr, count){
	            //如果是异步请求数据方式，res即为你接口返回的信息。
	            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
	            monthsData = res.data[0];
	            console.log(monthsData);
	          }
	    });
    }
    
    //监听每天人数表格编辑
    table.on('edit(daysList)', function(obj){
      var field = obj.field; //修改的field名字
      daysData[field] = Number(obj.value);//格式化
      daysData = obj.data; //得到所在行所有键值
      var total = 0;
      for(var i=1;i<days+1;i++){
    	  total += Number(daysData['day'+i]);
      }
      monthsData['month'+month] = total;
      var data = new Array();
      data.push(monthsData);
      table.render({
	        elem: '#monthsList',
	        page : false,
	        id : "monthsListTable",
	        cols : [monthCols],
	        data:data
	    });
    });
    
    //提交表单
	form.on('submit(saveVisitor)', function(data){
		var resultData = $.extend({}, daysData,monthsData);
		delete resultData.createTime;
		delete resultData.updateTime;
		$.ajax({
		       url:"<%=request.getContextPath()%>/desk/save.do",
		       data:resultData,
		       type:"POST",
		      beforeSend: function () {
 	    	   loading = layer.load();
 	       },
	       success:function(data){
	    	  layer.close(loading);
	    	   if(data == 1){
	    		   layer.msg("保存成功！");
                    setTimeout(function(){
							window.location.href = window.location.href;
						},1000)
                }else if(data == 0){
                	layer.msg("保存失败！",{icon:2});
                }
	       },
	      error:function(msg){
	    	   layer.close(loading);
	    	   layer.msg("保存失败！",{icon:2});
	       }
	    }); 
	});
	//去消息详情页面
    window.detail = function(id,receiverId){
   	  var index = layui.layer.open({
   	      title : "信息详情",
   	      type : 2,
   	      content : "<%=request.getContextPath() %>/desk/goDetail.do?infoId="+id+"&receiverId="+receiverId+"&type=read",
   		  area: ['700px', '500px'],
   		  success : function(layero,index,data1){
   		  		var body = layui.layer.getChildFrame('body', index);
   		  		resizeLayer(index);
   	            setTimeout(function(){
   	                layui.layer.tips('点击此处返回站内信息列表', '.layui-layer-setwin .layui-layer-close', {
   	                    tips: 3
   	                });
   	            },500)
   			},
   	      yse:function (index, layero) {
   	          layer.close(index); //关闭弹层
   	      },
   	  });
   		layui.layer.full(index);
	  window.sessionStorage.setItem("index",index);
    }
    window.messageDetailList = function(){
	  var index = layui.layer.open({
	      title : "已发送消息列表",
	      type : 2,
	      content : "<%=request.getContextPath() %>/desk/goMessageList.do",
	      area: ['70%', '600px'],
	      success : function(layero,index){
	          var body = layui.layer.getChildFrame('body', index);
	          resizeLayer(index);
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
	};
	window.goInsideInfoAdd = function(){
	  var index = layui.layer.open({
	      title : "新建信息",
	      type : 2,
	      content : "<%=request.getContextPath() %>/desk/messageInfo.do",
	       
	      area: ['90%', '800px'],
	      success : function(layero,index){
	          var body = layui.layer.getChildFrame('body', index);
	          resizeLayer(index);
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
	};
	
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
			},
	      yse:function (index, layero) {
	          layer.close(index); //关闭弹层
	      }
	  });
	  layui.layer.full(index);
	  window.sessionStorage.setItem("index",index);
	}
	//查看自定义表单
	window.viewReport = function(code, mainId){
	  var index = layui.layer.open({
	      title : "查看",
	      type : 2,
	      content : "<%=request.getContextPath() %>/aceAutoController.do?modePage&isDisabled=true&type=page&releaseCode="+code+"&mainId="+mainId,
		  area: ['90%', '800px'],
		  success : function(layero,index,data1){
		  		var body = layui.layer.getChildFrame('body', index);
		  		resizeLayer(index);
			},
	      yse:function (index, layero) {
	          layer.close(index); //关闭弹层
	      }
	  });
	  layui.layer.full(index);
	  window.sessionStorage.setItem("index",index);
	}
    
});

//根据年月计算当月最大天数
function getDaysInMonth(year,month){
	month = parseInt(month,10);  //parseInt(number,type)这个函数后面如果不跟第2个参数来表示进制的话，默认是10进制。
	var temp = new Date(year,month,0);
	return temp.getDate();
}

var totalPage=0;//总页数
var allRow=0;//总条数
var size=5;//每页条数
var currentPage=0;//当前页数
var messageList = new Array();
function searchMessage(){
	$("#mesList").empty();
	var infoTitle=$("#infoTitle").val();
	var dateRange=$("#dateRange").val();
	$.ajax({
	       url:"<%=request.getContextPath()%>/desk/getMessageList.do",
	       data:{"infoTitle":infoTitle,"dateRange":dateRange},
	       type:"POST",
       success:function(data){
 	   if(data.success == 1){
 		     messageList = data.data;
             allRow = messageList.length;
             if(allRow>0){
            	 $("#mesButton").show();
            	 totalPage =parseInt((allRow+size-1)/size);
            	 currentPage =1;
            	 renderMess(currentPage);
            	 //渲染上一页，下一页
             }else{
            	 $("#mesButton").hide();
             }
       }
    },
  }); 
}
function renderMess(page){
	$("#mesList").empty();
	var start = size * (currentPage - 1);
	if(page<totalPage){
		var end = start+size;
	}else{
		var end = allRow;
	}
	var mesStr = "";
	for(var i=start;i<end;i++){
		var j=i+1;
		mesStr += " <div class='layui-col-space10'>\n" +
	    "    		   <div class='layui-input-inline layui-col-md1' >\n" +
         "                <span>"+j+"</span>\n" +
         "             </div>\n" +
         "             <div class='layui-input-inline layui-col-md6' >\n" +
         "                <a href='javascript:detail(\""+messageList[i].infoId+"\",\""+messageList[i].receiverId+"\");' style='overflow: hidden;text-overflow: ellipsis;' class='receive'>" +messageList[i].infoTitle+"</a>\n" +
         "             </div>\n" +
         "             <div class='layui-input-inline layui-col-md2' >\n" +
         "               <span class='receive' style='overflow: hidden;text-overflow: ellipsis;'>"+messageList[i].orgName+"</span>\n" +
         "             </div>" +
	    "    		   <div class='layui-input-inline layui-col-md3' >\n" +
	    "                <span class='receive' style='overflow: hidden;text-overflow: ellipsis;'>"+messageList[i].lastUpdatedTime+"</span>\n" +
         "             </div>\n" +
         "         </div>" +
			"  <hr>"
    }
    $("#mesList").append(mesStr);
}
function last(){
	if(currentPage >1){
		currentPage--;
		renderMess(currentPage);
	}else{
		return false;
	}
}

function next(){
	if(currentPage>0 && currentPage<totalPage){
		currentPage++;
		renderMess(currentPage);
	}else{
		return false;
	}
}


//今日动态
function searchTodayDynamic(date){
	$.ajax({
       url:"<%=request.getContextPath()%>/desk/getTodayDynamicData.do",
       data:{"date":date, type:$("#businessType").val()},
       type:"POST",
	   success:function(data){
		   if(data.success == 1){
	          console.log(data.data);
	          var datas = data.data;
	          var todayHtml = "";
	          $("#todayUl").html("");
	          for (var i = 0; i < datas.length; i++) {
	        	  todayHtml += '<li class="layui-col-xs3">';
	        	  todayHtml += 		'<div class="layuiadmin-card-text">';
	        	  todayHtml += 			'<a href="javascript:viewReport(\''+datas[i].code+'\',\''+datas[i].id+'\');"><p class="layui-text-center" title="'+datas[i].showName+'"><b>'+datas[i].showName+'</b>&nbsp;&nbsp;';
	        	  if(datas[i].action == '藏品'){
		        	  todayHtml += 				'<button class="layui-btn layui-btn-xs" style="background-color: #4DD7E2;" type="button">'+datas[i].action+'</button></p></a>';
	        	  }else if(datas[i].action == '社教'){
		        	  todayHtml += 				'<button class="layui-btn layui-btn-normal layui-btn-xs" type="button">'+datas[i].action+'</button></p></a>';
	        	  }else if(datas[i].action == '展览'){
		        	  todayHtml += 				'<button class="layui-btn layui-btn-xs" type="button">'+datas[i].action+'</button></p></a>';
	        	  }
	        	  todayHtml += 			'<div class="layui-text-top" style="background-color: #f8f8f8;">';
	        	  todayHtml += 				'<a href="javascript:void(0);">'+datas[i].orgName+'</a>';
	        	  todayHtml += 				'<span class="layui-text-bottom"><label>'+datas[i].intervalDate+'</label></span>';
	        	  todayHtml += 			'</div>';
        		  todayHtml += 			'<hr>';
      			  todayHtml += 		'</div>';
  				  todayHtml += 	'</li>';
 			 }
	         $("#todayUl").html(todayHtml);
	       }
	   }
	}); 
}

$(function(){
	//局属博物馆观众人数
	initReport("attendanceDay");
	//全市博物馆观众人数
	initReport("attendanceMonth2");
	//本站上线藏品总数量
	initReport("collectionCount");
	//临时展览举办每月次数
	initReport("tempExhibition");
});

//初始化报表
function initReport(selectType){
	var sql = "";
	var title = "";
	var type = "";
	var tableData = [];		//x轴和Y轴指定
	switch(selectType){
		case "attendanceDay" :
			/* var startDay = new Date();
			startDay.setDate(startDay.getDate() - 8);
			var sql1 = "";
			for (var i = 7; i > 0; i--) {
				startDay.setDate(startDay.getDate() + 1);
				sql1 += " select '"+getFormatDate(startDay.getMonth()+1)+"/"+getFormatDate(startDay.getDate())+"' as day,IFNULL(sum(day"+startDay.getDate()+"), 0) as num " +
					"from museum_visitor_number a "+
					"INNER JOIN mip_organization b on(a.museum_id=b.id and b.platform_id = '1') "+
					"where a.`year` = '"+startDay.getFullYear()+"' and a.`month` = '"+(startDay.getMonth()+1)+"' ";
				if(i != 1){
					sql1 += " UNION ALL ";
				}
			}
			sql = sql1; */
			title = "局属博物馆观众人数";
			type = "line";
			var nameMap = {"key":"day","name":"日期","isValueKey":"0"};
	    	var valueMap = {"key":"num","name":"访问量","isValueKey":"1"};
	    	tableData.push(nameMap);
	    	tableData.push(valueMap);
			break;
		case "attendanceDay2" :
			/* var startDay = new Date();
			startDay.setMonth(startDay.getMonth()-7);
			var sql1 = "";
			for (var i = 1; i <= 6; i++) {
				startDay.setMonth(startDay.getMonth() + 1);
				sql1 += " select '"+startDay.getFullYear()+"年"+getFormatDate(startDay.getMonth()+1)+"月' as month,IFNULL(sum(month_total), 0) as num " +
					"from museum_visitor_number a "+
					"INNER JOIN mip_organization b on(a.museum_id=b.id and b.platform_id = '1') "+
					"where a.`year` = '"+startDay.getFullYear()+"' and a.`month` = '"+(startDay.getMonth()+1)+"' ";
				if(i != 6){
					sql1 += " UNION ALL ";
				}
			}
			sql = sql1; */
			title = "局属博物馆观众人数";
			type = "line";
			var nameMap = {"key":"month","name":"日期","isValueKey":"0"};
	    	var valueMap = {"key":"num","name":"访问量","isValueKey":"1"};
	    	tableData.push(nameMap);
	    	tableData.push(valueMap);
			break;
		case "attendanceDay3" :
			/* var startDay = new Date();
			startDay.setYear(startDay.getFullYear()-6);
			var sql1 = "";
			for (var i = 1; i <= 6; i++) {
				startDay.setYear(startDay.getFullYear() + 1);
				sql1 += " select '"+startDay.getFullYear()+"年' as year,IFNULL(sum(month_total), 0) as num " +
					"from museum_visitor_number a "+
					"INNER JOIN mip_organization b on(a.museum_id=b.id and b.platform_id = '1') "+
					"where a.`year` = '"+startDay.getFullYear() +"'";
				if(i != 6){
					sql1 += " UNION ALL ";
				}
			}
			sql = sql1; */
			title = "局属博物馆观众人数";
			type = "line";
			var nameMap = {"key":"year","name":"日期","isValueKey":"0"};
	    	var valueMap = {"key":"num","name":"访问量","isValueKey":"1"};
	    	tableData.push(nameMap);
	    	tableData.push(valueMap);
			break;
		case "attendanceMonth" :
			/* var startDay = new Date();
			startDay.setMonth(startDay.getMonth()-7);
			var sql1 = "";
			for (var i = 7; i > 0; i--) {
				startDay.setDate(startDay.getDate() + 1);
				sql1 += " select '"+getFormatDate(startDay.getMonth()+1)+"/"+getFormatDate(startDay.getDate())+"' as day,IFNULL(sum(day"+startDay.getDate()+"), 0) as num " +
					"from museum_visitor_number a where a.`year` = '"+startDay.getFullYear()+"' and a.`month` = '"+(startDay.getMonth()+1)+"' ";
				if(i != 1){
					sql1 += " UNION ALL ";
				}
			}
			sql = sql1; */
			title = "全市博物馆观众人数";
			type = "line";
			var nameMap = {"key":"day","name":"日期","isValueKey":"0"};
	    	var valueMap = {"key":"num","name":"访问量","isValueKey":"1"};
	    	tableData.push(nameMap);
	    	tableData.push(valueMap);
			break;
		case "attendanceMonth2" :
			/* var startDay = new Date();
			startDay.setMonth(startDay.getMonth()-7);
			var sql1 = "";
			for (var i = 1; i <= 6; i++) {
				startDay.setMonth(startDay.getMonth() + 1);
				sql1 += " select '"+startDay.getFullYear()+"年"+getFormatDate(startDay.getMonth()+1)+"月' as month,IFNULL(sum(month_total), 0) as num " +
					"from museum_visitor_number a where a.`year` = '"+startDay.getFullYear()+"' and a.`month` = '"+(startDay.getMonth()+1)+"' ";
				if(i != 6){
					sql1 += " UNION ALL ";
				}
			}
			sql = sql1; */
			title = "全市博物馆观众人数";
			type = "line";
			var nameMap = {"key":"month","name":"日期","isValueKey":"0"};
	    	var valueMap = {"key":"num","name":"访问量","isValueKey":"1"};
	    	tableData.push(nameMap);
	    	tableData.push(valueMap);
			break;
		case "attendanceMonth3" :
			/* var startDay = new Date();
			startDay.setYear(startDay.getFullYear()-6);
			var sql1 = "";
			for (var i = 1; i <= 6; i++) {
				startDay.setYear(startDay.getFullYear() + 1);
				sql1 += " select '"+startDay.getFullYear()+"年' as year,IFNULL(sum(month_total), 0) as num " +
					"from museum_visitor_number a where a.`year` = '"+startDay.getFullYear() +"'";
				if(i != 6){
					sql1 += " UNION ALL ";
				}
			}
			sql = sql1; */
			title = "全市博物馆观众人数";
			type = "line";
			var nameMap = {"key":"year","name":"日期","isValueKey":"0"};
	    	var valueMap = {"key":"num","name":"访问量","isValueKey":"1"};
	    	tableData.push(nameMap);
	    	tableData.push(valueMap);
			break;
		case "collectionCount" :
			/* sql = "select b.name, count(a.id) as num from mip_open_culturalrelic_info a " +
				" left join mip_collection_level b on(a.collection_level = b.id) " +
				" GROUP BY b.id "; */
			title = "本站上线藏品总数量";
			type = "pieMult";
			var nameMap = {"key":"name","name":"藏品级别","isValueKey":"0"};
	    	var valueMap = {"key":"num","name":"藏品数量","isValueKey":"1"};
	    	tableData.push(nameMap);
	    	tableData.push(valueMap);
			break;
		case "tempExhibition" :
			<%-- $.ajax({
		       url:"<%=request.getContextPath()%>/desk/getExhibitionSql.do",
		       data:{},
		       type:"POST",
		       async: false,
		       success:function(data){
		    	   if(data.success == 1){
		    		   sql = data.data;
		    		   
	                }else{
	                	layer.msg("获取失败！",{icon:2});
	                }
		       },
		       error:function(msg){
		    	   layer.msg("获取失败！",{icon:2});
		       }
		    });  --%>
			
			title = "临时展览每月举办次数";
   		    type = "bar";
   		    var nameMap = {"key":"month","name":"日期","isValueKey":"0"};
   	        var valueMap = {"key":"num","name":"次数","isValueKey":"1"};
   	        tableData.push(nameMap);
   	        tableData.push(valueMap);
			break;
	}
	var divName = selectType;
	if(selectType == "attendanceDay2" || selectType == "attendanceDay3"){
		divName = "attendanceDay";
	}else if(selectType == "attendanceMonth2" || selectType == "attendanceMonth3"){
		divName = "attendanceMonth";
	}
    myReport.getReportByType(divName,selectType,title,type,tableData);
}

</script> 
</body>
</html>