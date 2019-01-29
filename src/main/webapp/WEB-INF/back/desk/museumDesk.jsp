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
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
.childrenBody{
	padding:10px;
	background-color: #f2f2f2;
}
.receive{
	text-align:left;
	display:block;
	white-space: nowrap;
}
.textStyle{
	height: 70px;
    text-align: center;
    line-height: 60px;
    display: inline-block;
	width:17%;
}
.ml_50{
	margin-left: 40px;
}
.mb_5{
	margin-bottom: 5px;
}
.mb_10{
	margin-bottom: 10px;
}
.pb_10{
	padding-bottom: 10px;
}
.pt_10{
	padding-top: 10px;
}
.sp_text{
	font-family: PingFang-SC-Bold;
	font-size: 1.2rem;
	font-weight: normal;
	font-stretch: normal;
	letter-spacing: 0px;
	color: #189689;
}

.card-shadow{
	box-shadow: 0px 10px 29px 0px 
		rgba(46, 56, 58, 0.1);
	border-radius: 5px;
}
.select-length{
	width:100px;
}
.container{
    position:relative;
}
.search{
        position:absolute;
        top:0px;
        left:205px;
        z-index:99;
}
</style>
<title></title>
</head>
<body class="childrenBody">
	<form class="layui-form">
		<input type="hidden" id="orgId" name="orgId" value="${orgId}"/>
		<div class="layui-row layui-col-space10">
			<div class="layui-input-inline layui-col-md6 " >
				<div class="layui-row layui-col-md12">
					<div class="layui-card">
						  <div class="layui-card-header">
				               <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/desk-p1.png" alt="">&nbsp;&nbsp;通知公告</a>
						  </div>
						  <div class="layui-card-body">
					    	<c:forEach items="${receiveList}" var="item" varStatus="sta">
								<div class="layui-row mb_10">
									<div class="layui-card card-shadow">
									        <div class="layui-card-header">
									        	<div class="layui-row layui-col-space10">
									        		<div class="layui-input-inline layui-col-md8" >
							                          <a href="javascript:noticeDetail('${item.id}','${item.isFeedBack}','${item.receiveStatus}');" style="overflow: hidden;text-overflow: ellipsis;" class="receive">
							                          ${item.title}
							                          </a>
							                         </div>
							                         <div class="layui-input-inline layui-col-md2" >
								                      <span class="receive" style="overflow: hidden;text-overflow: ellipsis;">${item.publishOrg}</span>
								                      </div>
								                      <div class="layui-input-inline layui-col-md2" >
								                      <span class="receive" style="overflow: hidden;text-overflow: ellipsis;">${item.timeTip}</span>
								                      </div>
								                  </div>
									        </div>
									        <c:if test="${not empty item.reportName && item.reportName ne null}">
									        <div class="layui-card-body">
						                   		<span><img src="<%=request.getContextPath() %>/back/images/desk-p2.png">&nbsp;${item.reportName}&nbsp;(${item.deadlineTimeStr})截止</span>
									        </div>
									          </c:if>
									   </div>
				                 </div>
	                 		</c:forEach>
			              </div>
				    </div>
				</div>
	        </div>
	        <div class="layui-input-inline layui-col-md6">
		        <div class="layui-row layui-col-md12">
						<div class="layui-card">
							  <div class="layui-card-header">
					               <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/desk-p3.png" alt="">&nbsp;&nbsp;法律法规</a>
							  </div>
							  <div class="layui-card-body">
								  	<c:if test="${not empty govLegalList && govLegalList ne null}">
						            	<div class="layui-row mb_5 container">
						            		  <div class="layui-input-inline" >
								                   <input type="text" value="" class="layui-input" name="govTitle" id="govTitle"  placeholder="法律法规查询">
								              </div>
								              <div class="search">
								              	<a class="layui-btn"  onclick="govMessage()">搜索</a>
								              </div>
								         </div>
		           					 </c:if>
		           					 <div class="layui-row" id="govList" >
	            					</div>
				              </div>
					    </div>
					</div>
	        </div>
		</div>
		<div class="layui-row layui-col-space10">
			<div class="layui-input-inline layui-col-md12">
				<div class="layui-card">
					  <div class="layui-card-header">
			               <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/desk-p4.png" alt="">&nbsp;&nbsp;日常业务填报</a>
					  </div>
					  <div class="layui-card-body">
					      <div class="layui-row">
							  	<div class="textStyle" style="padding-right:3%;padding-left:1%;">
							      <div class="layui-card card-shadow">
							      	 <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/desk-p5.png" alt="">&nbsp;&nbsp;</a><a href="javascript:jump('${codeMap.collection }','1');"  class="sp_text">藏品信息填报 ></a>
							      </div>
							    </div>
							    <div class="textStyle" style="padding-right:3%;">
							      <div class="layui-card card-shadow">
							      	 <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/desk-p6.png" alt="">&nbsp;&nbsp;</a><a  href="javascript:jump('${codeMap.exhibition }','2');"  class="sp_text">展览信息填报 ></a>
							      </div>
							    </div>
							    <div class="textStyle" style="padding-right:3%;">
							      <div class="layui-card card-shadow" >
							      	 <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/desk-p7.png" alt="">&nbsp;&nbsp;</a><a href="javascript:jump('${codeMap.study }','3');"  class="sp_text">研究成果填报 ></a>
							      </div>
							    </div>
							    <div class="textStyle" style="padding-right:3%;">
							      <div class="layui-card card-shadow" >
							      	 <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/desk-p8.png" alt="">&nbsp;&nbsp;</a><a href="javascript:jump('${codeMap.education }','4');" class="sp_text">教育活动填报 ></a>
							      </div>
							    </div>
							    <div class="textStyle">
							      <div class="layui-card card-shadow" >
							      	 <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/desk-p9.png" alt="">&nbsp;&nbsp;</a><a href="javascript:jump('${codeMap.wenchuang }','5');"  class="sp_text">文创产品填报 ></a>
							      </div>
							    </div>
						    </div>
					  </div>
			    </div>
			 </div>
	    </div>
	    <div class="layui-row layui-col-space10">
	    	<div class="layui-input-inline layui-col-md6 " >
		    	<div class="layui-card">
					  <div class="layui-card-header">
					  	   <div class="layui-input-inline layui-col-md6" >
			               		<a class="label-title"><img src="<%=request.getContextPath() %>/back/images/desk-p10.png" alt="">&nbsp;&nbsp;观众人数填报</a>
			               </div>
			               <div class="layui-input-inline layui-col-md6" style="padding-top:6px;" >
			               		<a id="save_visitor" type="button" style="float:right;width:90px;" class="label-title layui-btn layui-btn-radius layui-btn-sm" lay-submit lay-filter="saveVisitor">保存</a>
			               </div>
					  </div>
					  <div class="layui-card-body">
					      <div class="layui-row pb_10">
					      		<div class="layui-input-inline">
				                    <label class="layui-form-label" style = "width:auto;">日常观众人数填报：</label>
				                </div>
					      		<div class="layui-input-inline select-length" >
				                    <select name="year" lay-filter="yearChange">
								      	<c:forEach items="${yearList}" var="item">
											<option value="${item.year}" <c:if test="${nowYear eq item.year}">selected</c:if>>${item.year}年</option>
										</c:forEach> 
								      </select>
				                </div>
				                <div class="layui-input-inline select-length">
				                    <select name="month" lay-filter="monthChange">
								        <c:forEach items="${monthList}" var="item">
											<option value="${item.month}" <c:if test="${nowMonth eq item.month}">selected</c:if>>${item.month}月</option>
										</c:forEach> 
							        </select>
				                </div>
					      </div>
					      <div class="layui-row" id="tableOne">
	                      		<table id="daysList" lay-filter="daysList"></table>
	              		  </div>
	              		  <div class="layui-row pt_10">
			    	 			<div class="layui-col-md6">
							    	<label class="layui-form-label" style = "width:auto;" id="yearTitle" >${nowYear}年度参观 人数统计：</label>
							    </div>
					      </div>
					        <div class="layui-row pb_10" id="tableTwo">
			                      <table id="monthsList" lay-filter="monthsList"></table>
			                </div>
					  </div>
			    </div>
		    </div>
	    	<div class="layui-input-inline layui-col-md6 " >
	    		<div class="layui-card">
					  <div class="layui-card-header">
			               <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/desk-p3.png" alt="">&nbsp;&nbsp;站内消息</a>
			               <div class="layui-input-inline" style="float:right">
					                <a class="layui-btn  layui-btn-radius layui-btn-sm" onclick="goInsideInfoAdd()">发送信息</a>
					                <a class="layui-btn layui-btn-radius layui-btn-sm" onclick="messageDetailList()">已发列表</a>
				           </div>
					  </div>
					  <div class="layui-card-body">
					      <div class="layui-row">
				                <div class="layui-input-inline">
				                    <input type="text" class="layui-input searchVal" id="infoTitle" name="infoTitle" value="" placeholder="消息标题/发布单位" />
				                </div>
				                <div class="layui-input-inline container">
				                    <input type="text" style="width:200px;" class="layui-input searchVal" id="dateRange" name="dateRange" value="" placeholder="发布时间范围" />
				                    <div class="search">
				                    	<a class="layui-btn" onclick="searchMessage()">搜索</a>
				                    </div>
				                </div>
					      </div>
						  <div class="layui-row" id="mesList" >
				          </div>
			              <div class="layui-row pt_10" id="mesButton">
			            		<span  style="float:right" >
			            			   <a class="layui-btn layui-btn-sm layui-btn-radius" onclick="last()"><i class="layui-icon"></i>前一页</a>
	    							  <a class="layui-btn layui-btn-sm layui-btn-radius" onclick="next()"><i class="layui-icon"></i>后一页</a>
	    					    </span>
				         </div>
					 </div>
				</div>
	    	</div>
	    </div>
        <script type="text/html" id="monthTpl1">
		{{# if(d.month1 == null){  }}
				{{}}
		{{#	}else{  }}
				{{#  if(d.handFill1 == '1'){ }}
           			<span style="color: #1e9fff;">{{ d.month1 }}</span>
          	    {{#  } else { }}
                   {{ d.month1 }}
               {{#  } }}
	    {{#  }  }}
       </script>
       <script type="text/html" id="monthTpl2">
         {{# if(d.month2 == null){  }}
				{{}}
		{{#	}else{  }}
				{{#  if(d.handFill2 == '1'){ }}
           			<span style="color: #1e9fff;">{{ d.month2 }}</span>
          	    {{#  } else { }}
                   {{ d.month2 }}
               {{#  } }}
	    {{#  }  }}
       </script>
       <script type="text/html" id="monthTpl3">
         {{# if(d.month3 == null){  }}
				{{}}
		{{#	}else{  }}
				{{#  if(d.handFill3 == '1'){ }}
           			<span style="color: #1e9fff;">{{ d.month3 }}</span>
          	    {{#  } else { }}
                   {{ d.month3 }}
               {{#  } }}
	    {{#  }  }}
       </script>
       <script type="text/html" id="monthTpl4">
         {{# if(d.month4 == null){  }}
				{{}}
		{{#	}else{  }}
				{{#  if(d.handFill4 == '1'){ }}
           			<span style="color: #1e9fff;">{{ d.month4 }}</span>
          	    {{#  } else { }}
                   {{ d.month4 }}
               {{#  } }}
	    {{#  }  }}
       </script>
       <script type="text/html" id="monthTpl5">
         {{# if(d.month5 == null){  }}
				{{}}
		{{#	}else{  }}
				{{#  if(d.handFill5 == '1'){ }}
           			<span style="color: #1e9fff;">{{ d.month5 }}</span>
          	    {{#  } else { }}
                   {{ d.month5 }}
               {{#  } }}
	    {{#  }  }}
       </script>
       <script type="text/html" id="monthTpl6">
         {{# if(d.month6 == null){  }}
				{{}}
		{{#	}else{  }}
				{{#  if(d.handFill6 == '1'){ }}
           			<span style="color: #1e9fff;">{{ d.month6 }}</span>
          	    {{#  } else { }}
                   {{ d.month6 }}
               {{#  } }}
	    {{#  }  }}
       </script>
       <script type="text/html" id="monthTpl7">
         {{# if(d.month7 == null){  }}
				{{}}
		{{#	}else{  }}
				{{#  if(d.handFill7 == '1'){ }}
           			<span style="color: #1e9fff;">{{ d.month7 }}</span>
          	    {{#  } else { }}
                   {{ d.month7 }}
               {{#  } }}
	    {{#  }  }}
       </script>
       <script type="text/html" id="monthTpl8">
         {{# if(d.month8 == null){  }}
				{{}}
		{{#	}else{  }}
				{{#  if(d.handFill8 == '1'){ }}
           			<span style="color: #1e9fff;">{{ d.month8 }}</span>
          	    {{#  } else { }}
                   {{ d.month8 }}
               {{#  } }}
	    {{#  }  }}
       </script>
       <script type="text/html" id="monthTpl9">
        {{# if(d.month9 == null){  }}
				{{}}
		{{#	}else{  }}
				{{#  if(d.handFill9 == '1'){ }}
           			<span style="color: #1e9fff;">{{ d.month9 }}</span>
          	    {{#  } else { }}
                   {{ d.month9 }}
               {{#  } }}
	    {{#  }  }}
       </script>
       <script type="text/html" id="monthTpl10">
        {{# if(d.month10 == null){  }}
				{{}}
		{{#	}else{  }}
				{{#  if(d.handFill10 == '1'){ }}
           			<span style="color: #1e9fff;">{{ d.month10 }}</span>
          	    {{#  } else { }}
                   {{ d.month10 }}
               {{#  } }}
	    {{#  }  }}
       </script>
       <script type="text/html" id="monthTpl11">
        {{# if(d.month11 == null){  }}
				{{}}
		{{#	}else{  }}
				{{#  if(d.handFill11 == '1'){ }}
           			<span style="color: #1e9fff;">{{ d.month11 }}</span>
          	    {{#  } else { }}
                   {{ d.month11 }}
               {{#  } }}
	    {{#  }  }}
       </script>
       <script type="text/html" id="monthTpl12">
        {{# if(d.month12 == null){  }}
				{{}}
		{{#	}else{  }}
				{{#  if(d.handFill12 == '1'){ }}
           			<span style="color: #1e9fff;">{{ d.month12 }}</span>
          	    {{#  } else { }}
                   {{ d.month12 }}
               {{#  } }}
	    {{#  }  }}
       </script>
 	</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/lay	page/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<!--请在下方写此页面业务相关的脚本-->
	<!-- 分页功能 -->

<script type="text/javascript">
layui.use(['form','layer','table','laydate'],function(){
	var form = layui.form,
    layer = parent.layer === undefined ? layui.layer : top.layer,
    $ = layui.jquery,
    table = layui.table;
	laydate = layui.laydate;
	
	laydate.render({
		   elem: '#dateRange',
		   range: '~'
	});
	var flag=true;
	var year = ${nowYear};//当前选中的年
	var month = ${nowMonth};//当前选中的月
	var orgId = ${orgId};//组织id
	var daysData = {};
	var monthsData ={};
	
	var days = getDaysInMonth(year,month);
	var intDayCols =new Array();
    for(var i=1;i<days+1;i++){
    	intDayCols.push({field: 'day'+i,width:61, edit: 'text',title: i+'号'})
    }
	table.render({
        elem: '#daysList',
        url : '<%=request.getContextPath() %>/desk/dayVisitorList.do?month='+month+'&year='+year+'&orgId='+orgId, 
        page : false,
        id : "daysListTable",
        cols : [intDayCols],
        done: function(res, curr, count){
            daysData = res.data[0];
            console.log(daysData);
          }
     });
	
	var monthCols =new Array();
    for(var i=1;i<13;i++){
    	monthCols.push({field: 'month'+i, edit: 'text',title: i+'月',templet:'#monthTpl'+i})
    }
	table.render({
        elem: '#monthsList',
        url : '<%=request.getContextPath() %>/desk/monthVisitorList.do?year='+year+'&orgId='+orgId, 
        page : false,
        id : "monthsListTable",
        cellMinWidth : 67,
        cols : [monthCols],
        done: function(res, curr, count){
            monthsData = res.data[0];
            console.log(monthsData);
          }
    });
	
	searchMessage();
	govMessage();
	form.on('select(yearChange)', function(data){
    	yearChange();
	 });
	
    form.on('select(monthChange)', function(data){
    	monthChange();
	 });
    
    function yearChange(){
    	month = $("select[name='month']").val();
    	year = $("select[name='year']").val();
    	days = getDaysInMonth(year,month);
		var dayCols =new Array();
        for(var i=1;i<days+1;i++){
        	dayCols.push({field: 'day'+i,width:61, edit: 'text',title: i+'号'})
        }
		table.render({
	        elem: '#daysList',
	        url : '<%=request.getContextPath() %>/desk/dayVisitorList.do?month='+month+'&year='+year+'&orgId='+orgId, 
	        page : false,
	        id : "daysListTable",
	        cols : [dayCols],
	        done: function(res, curr, count){
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
	            monthsData = res.data[0];
	            console.log(monthsData);
	          }
	    });
    }
    
    function monthChange(){
    	month = $("select[name='month']").val();
    	year = $("select[name='year']").val();
    	days = getDaysInMonth(year,month);
		var dayCols =new Array();
        for(var i=1;i<days+1;i++){
        	dayCols.push({field: 'day'+i,width:61, edit: 'text',title: i+'号'})
        }
		table.render({
	        elem: '#daysList',
	        url : '<%=request.getContextPath() %>/desk/dayVisitorList.do?month='+month+'&year='+year+'&orgId='+orgId, 
	        page : false,
	        id : "daysListTable",
	        cols : [dayCols],
	        done: function(res, curr, count){
	            daysData = res.data[0];
	            console.log(daysData);
	          }
	     });
    }
    
    //监听每天人数表格编辑
    table.on('edit(daysList)', function(obj){
    	debugger
      var field = obj.field; //修改的field名字
      var dayCols =new Array();
      for(var i=1;i<days+1;i++){
      	dayCols.push({field: 'day'+i,width:61, edit: 'text',title: i+'号'})
      }
      if(!(/(^[0-9]\d*$)/.test($.trim(obj.value))) && $.trim(obj.value) != 0){
    	  layer.msg("请输入数字！",{icon:2});
    	  obj.value = null;
    	  daysData[field] = null;//格式化
    	  flag=false;
    	  $("#save_visitor").off()
      }else{
    	  daysData[field] = Number($.trim(obj.value));//格式化
    	  flag=true;
    	  saveVBB(); 	 	
      }
      var data1 = new Array();
      data1.push(daysData);
      table.render({
	        elem: '#daysList',
	        page : false,
	        id : "daysListTable",
	        cols : [dayCols],
	        data:data1
	    });
      if(monthsData['handFill'+month] == '1' && monthsData['month'+month] != null && monthsData['month'+month] !=""){
    	return false;  
      }
      var total = 0;
      for(var i=1;i<days+1;i++){
    	  total += Number(daysData['day'+i]);
      }
      monthsData['month'+month] = total;
      monthsData['handFill'+month] = "0";//改为非手填
      var data = new Array();
      data.push(monthsData);
      table.render({
	        elem: '#monthsList',
	        page : false,
	        id : "monthsListTable",
	        cols : [monthCols],
	        data:data
	    });
      return true;  
    });
    
  //监听每月人数表格编辑
    table.on('edit(monthsList)', function(obj){
      var field = obj.field; //修改的field名字
      if(!(/(^[1-9]\d*$)/.test($.trim(obj.value))) && $.trim(obj.value) != 0){
    	  layer.msg("请输入数字！",{icon:2});
    	  obj.value = "";
      }
   	  monthsData[field] = Number($.trim(obj.value));//格式化
      monthsData['handFill'+field.substr(field.length-1)] = '1';//手填标识1：手填
      console.log(monthsData);
    });
    
  function saveVBB(){
	  $("#save_visitor").off().on('click',function(){
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
		    	   if(data==0){
		    		   layer.msg("保存失败！",{icon:2});
	            }else{
	            	layer.msg("保存成功！");
	            }
		       },
		      error:function(msg){
		    	   layer.close(loading);
		    	   layer.msg("保存失败！",{icon:2});
		       }
		    })})
  }
  $("#save_visitor").off().on('click',function(){
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
	    	   if(data==0){
	    		   layer.msg("保存失败！",{icon:2});
          }else{
          	layer.msg("保存成功！");
          }
	       },
	      error:function(msg){
	    	   layer.close(loading);
	    	   layer.msg("保存失败！",{icon:2});
	       }
	    })})
    
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
		      },
		      end:function(){
		    	  $("#infoTitle").val("");
		    	  $("#dateRange").val("");
		    	  searchMessage();
		      }
 	      });
		  layui.layer.full(index);
		  window.sessionStorage.setItem("index",index);
	};
	
	//已发送消息列表
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
	
	//消息详情页面
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
  //法律法规详情
    window.legalDetail = function(id){
    var showIndex = layui.layer.open({
        title : "查看法律法规",
        type : 2,
        area: ['80%', '700px'],
        content : "<%=request.getContextPath() %>/legal/toShowGov.do?id="+id, 
        success : function(layero, showIndex){
            var body = layui.layer.getChildFrame('body', showIndex);
            resizeLayer(index);
            setTimeout(function(){
                layui.layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
                    tips: 3
                });
            },500) 
        },		
    }) 
    layui.layer.full(showIndex);
    window.sessionStorage.setItem("index",showIndex);
   /*  //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
    $(window).on("resize",function(){
        layui.layer.full(window.sessionStorage.getItem("index"));
    }); */
   }
  
  //通知公告详情
    window.noticeDetail = function(id,isFeedBack,receiveStatus){
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
    
    //日常业务填报
    window.jump = function(code,type){
    	var titleName;
    	if(type == '1'){
    		titleName = "藏品信息填报";
    	}else if(type == '2'){
    		titleName = "展览信息填报";
    	}else if(type == '3'){
    		titleName = "研究成果填报";
    	}else if(type == '4'){
    		titleName = "教育活动填报";
    	}else if(type == '5'){
    		titleName = "文创产品填报";
    	}
    	var index = layui.layer.open({
  	      title : titleName,
  	      type : 2,
  	      content : "<%=request.getContextPath() %>/listPageGenController.do?goConfigformList&releaseCode="+code,
  		  area: ['70%','800px'],
  		  success : function(layero,index){
  		  		var body = layui.layer.getChildFrame('body', index);
  		  		resizeLayer(index);	           
  			},
  	      yse:function (index, layero) {
  	          layer.close(index); //关闭弹层
  	      },
  	      end :function() {
            }
  	  });
    	layui.layer.full(index);
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
   	 mesStr += "<div class='layui-row'>\n" +
			"<div class='layui-card'>\n" +
		    "    <div class='layui-card-header'>\n" +
		    "    	<div class='layui-row'>\n" +
		    "    		<div class='layui-input-inline layui-col-md1' >\n" +
		    "             <span>"+j+"</span>\n" +
            "            </div>\n" +
            "              <div class='layui-input-inline layui-col-md6' >\n" +
            "                 <a href='javascript:detail(\""+messageList[i].infoId+"\",\""+messageList[i].receiverId+"\");' style='overflow: hidden;text-overflow: ellipsis;' class='receive'>" +messageList[i].infoTitle+"</a>\n" +
	         "             </div>\n" +
	         "             <div class='layui-input-inline layui-col-md2' >\n" +
	         "             	<span class='receive' style='overflow: hidden;text-overflow: ellipsis;'>"+messageList[i].orgName+"</span>\n" +
	         "             </div>\n" +
			 "    		  <div class='layui-input-inline layui-col-md3' >\n" +
			 "             <span class='receive' style='overflow: hidden;text-overflow: ellipsis;'>"+messageList[i].lastUpdatedTime+"</span>\n" +
	         "            </div>\n" +
	         "         </div>\n" +
		     "   </div>\n" +
		  " </div>\n" +
         "  </div>"
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
function govMessage(){
	$("#govList").empty();
	var title=$("#govTitle").val();
	$.ajax({
	       url:"<%=request.getContextPath()%>/desk/getGovList.do",
	       data:{"title":title},
	       type:"POST",
    success:function(data){
 	   if(data.success == 1){
             var mes = data.data;
             var mesStr = "";
             for(var i=0;i<mes.length;i++){
            	 mesStr += "<div class='layui-card card-shadow mb_5'>\n" +
				    "    <div class='layui-card-header'>\n" +
				    "    	<div class='layui-row'>\n" +
				    "    		<div class='layui-input-inline layui-col-md6' >\n" +
				    "             <a class='receive' href='javascript:legalDetail(\""+mes[i].id+"\");' style='overflow: hidden;text-overflow: ellipsis;'>"+mes[i].title+"&nbsp;(&nbsp;"+mes[i].publisher+"&nbsp;,&nbsp;"+mes[i].publishYear+"&nbsp;)</a>\n" +
		             "            </div>\n" +
		             "            <div class='layui-input-inline layui-col-md3' >\n" +
		            " <span class='receive' style='overflow: hidden;text-overflow: ellipsis;'>"+mes[i].firstKindName+"</span>\n" +
			         "             </div>\n" +
			         "             <div class='layui-input-inline layui-col-md3' >\n" +
			         "             <span class='receive' style='overflow: hidden;text-overflow: ellipsis;'>"+mes[i].secondKindName+"</span>\n" +
			         "             </div>\n" +
			         "         </div>\n" +
				     "   </div>\n" +
                "  </div>"
             }
             $("#govList").append(mesStr);
             
       }
    },
  }); 
}


</script> 
</body>
</html>