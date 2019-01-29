<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico">
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/css/trendsManage.css" />
<link href="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >

<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/echarts.common.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript"	src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript"	src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript"	src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>
<title>藏品动态统计</title>
<style type="text/css">
.spanWidth{
	width: 110px;
}
.floatLeft{
	float: left;
}
.floatRight{
	float: right;
}
.clearFloat{
	clear: both;
}
.overviewDiv{
	background: #cccccc;
}
.rightDiv{
	width: 250px;
}
span{
	border: none;
	display:-moz-inline-box;
	display:inline-block;
}
.centerDiv{
	text-align: center;
}
.infoDiv{
	display: none;
}
.bodycolor{
	    background-color:white;
}
</style>
</head>
<body class="bodycolor">
		<form action="/admin/trendsManage/info.do" method="get" id="infoFrom">
			<div class="Hui-article">
				<article class="cl pd-20 zj_wwlist_content">
					<div class="zj_wwlist_chose">
						<c:if test="${level==1}">
							<div class="pl-30">
								<span class="btn btn-primary collection spanWidth">概览</span>
								<span class="btn btn-default collection"> 地区分布统计</span>
							</div>
						</c:if>
						<div class="infoDiv">
							<div class="pl-30 pt-20 pb-10">截止到 <label id="nowTime"></label> 日</div>
							<c:if test="${level==1}">
								<div class="pl-30">
									<div class="floatLeft overviewDiv" style="display:flex;">
										<div style="display:flex;background: #01b48a;align-items: center;width: 66px;height: 70px;justify-content: center;">
											<img alt="" src="<%=request.getContextPath() %>/back/images/allNumber.png" style="width: 60px;height: 47px;background: #01b48a;">
										</div>
										<div class="floatRight ml-10 mr-20">
											<div  class="pt-10 pb-5 centerDiv">藏品总数</div>
											<div id="objectAllNum" class="centerDiv">${changeDto.allNumber}</div>
										</div>
									</div>
									<div class="floatLeft ml-10">
										<div class="overviewDiv pt-5 pb-5 mb-5 rightDiv">
											<label class="pl-10">新增藏品次数</label>
											<label class="pl-20" id="objectAddNum">${changeDto.addNumber}</label>
											<label class="floatRight mr-5" id="addDetails">详情></label>
										</div>
										<div class="overviewDiv pt-5 pb-5 rightDiv">
											<label class="pl-10">编辑藏品次数</label>
											<label class="pl-20" id="objectEditNum">${changeDto.editNumber}</label>
											<label class="floatRight mr-5" id="editDetails">详情></label>
										</div>
									</div>
								</div>
							</c:if>
							<c:if test="${level ne '1'}">
								<div class="pl-30">
									<div class="floatLeft overviewDiv" style="display:flex;">
										<div style="display:flex;background: #01b48a;align-items: center;width: 66px;height: 70px;justify-content: center;">
											<img alt="" src="<%=request.getContextPath() %>/back/images/allNumber.png" style="width: 60px;height: 47px;background: #01b48a;">
										</div>
										<div class="floatRight ml-10 mr-20">
											<div  class="pt-10 pb-5 centerDiv">本馆藏品总数</div>
											<div id="objectAllNum" class="centerDiv">${changeDto.allNumber}</div>
										</div>
									</div>
									<div class="floatLeft ml-10">
										<div class="overviewDiv pt-5 pb-5 mb-5 rightDiv">
											<label class="pl-10">本馆新增藏品次数</label>
											<label class="pl-20" id="objectAddNum">${changeDto.addNumber}</label>
										</div>
										<div class="overviewDiv pt-5 pb-5 rightDiv">
											<label class="pl-10">本馆编辑藏品次数</label>
											<label class="pl-20" id="objectEditNum">${changeDto.editNumber}</label>
										</div>
									</div>
								</div>
							</c:if>
							<div class="clearFloat"></div>
							<div class="pl-30 pt-20 pb-20 nowTime">
								<span class="btn btn-primary nowTimeOne spanWidth">最近七天</span>
								<span class="btn btn-default nowTimeOne spanWidth"> 最近一个月</span>
								<span class="btn btn-default nowTimeOne spanWidth"> 最近一年</span>
								<span class="ml-20" style="background: #e6e6e6;width:110px;height: 29px;">
									<select id="changeStatus" class="select"  style="width:110px;height: 27px;background: #e6e6e6;">
										<option value="0">所有变更</option>
										<option value="1">新增藏品数</option>
										<option value="2">编辑藏品数</option>
									</select>
								</span>
								<input type="hidden" id="versionTimeType" value="1">
								<input type="hidden" id="versionStatus" value="0">
							</div>
							<div id="main" style="height: 400px;padding: 10px;"></div>
							<div style="text-align: center" id="showText">最近七天所有变更统计</div>
						</div>
						<div class="infoDiv">
							<div class="mt-25 ml-15">
								<div class="col-xs-12 col-sm-6 col-md-3">
									<label class="">地区：</label>
									<span class="select-box inline">
									<select name="mipArea" class="select"  style="width:150px;" id="mipArea">
										<option value="">全部</option>
									</select>
									</span>
								</div>
								<div class="col-xs-12 col-sm-6 col-md-3">
									<label class="">类别：</label>
									<span class="select-box inline">
									<select  class="select"  style="width:150px;" id="changeType">
										<option value="0">所有</option>
										<option value="1">新增</option>
										<option value="2">编辑</option>
									</select>
									</span>
								</div>
								<div class="col-xs-12 col-sm-6 col-md-6">
									<label class="">时间：</label>
									<input style="width: 120px;height: 26px;" type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" name="lastLoginTimeS"  value="">
				                    &nbsp;至&nbsp;
				                    <input style="width: 120px;height: 26px;" type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax" class="input-text Wdate" name="lastLoginTimeE"  value="">
				                    <span class="btn btn-primary spanWidth ml-20" id="isOk">确认</span>
								</div>
								<div class="clearFloat"></div> 
								<div id="mainPie" style="height: 400px;padding: 10px;margin-top: 40px;"></div>
								<input type="hidden" id="picArea" value="0">
								<input type="hidden" id="picType" value="0">
							</div>
						</div>
					</div>
				</article>
			</div>
		</form>
<script type="text/javascript">
$(".fabu-aside>ul>li").eq(2).addClass("dongtai");
$(function(){
	 var myDate = new Date();
	  var year = myDate.getFullYear();  //获取完整的年份(4位,1970-????)
	  var month = myDate.getMonth()+1;   //获取当前月份(0-11,0代表1月)
	  var day = myDate.getDate();    //获取当前日(1-31)
	  $("#nowTime").html(year+"-"+month+"-"+day);
	  $(".infoDiv").eq(0).show();
});
</script>
<script type="text/javascript">
    $(function() {
        var myChart = echarts.init(document.getElementById('main'));
        //图表显示提示信息
       myChart.showLoading();
        //定义图表options
        var options = {
            title: {
                text: "趋势图",
                sublink: "http://www.stepday.com/myblog/?Echarts"
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: []
               
            },
            toolbox: {
                show: true,
                feature: {
                    mark: false
                }
            },
            calculable: true,
            xAxis: [
                {
                    type: 'category',
                    data: []
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    splitArea: { show: true }
                }
            ],
            series: []
            };
                //通过Ajax获取数据
                $.ajax({
                    type : "post",
                    async : false, //同步执行
                    url : "/admin/objectChange/showEchartLine.do",
                    dataType : "json", //返回数据形式为json
                    success : function(result) {
                        if (result) {
                            //将返回的category和series对象赋值给options对象内的category和series
                            //因为xAxis是一个数组 这里需要是xAxis[i]的形式
                                options.xAxis[0].data = result.category;
                                options.series = result.series;
                                options.legend.data = result.legend;
                                myChart.hideLoading();
                                myChart.setOption(options);
                        }
                    },
                    error : function(errorMsg) {
                        alert("图表请求数据失败啦!");
                    }
                });
                $(".nowTimeOne").click(function (){
	                $(".nowTimeOne").removeClass("btn-primary").addClass("btn-default");
	        		$(this).removeClass("btn-default").addClass("btn-primary");
	        		$("#versionTimeType").val($(this).index()+1);
	        		$("#showText").html($(this).html()+$("#changeStatus").find("option:selected").text()+"统计");
	        		showLine();
                });
                $('#changeStatus').change(function(){
                	$("#versionStatus").val($("#changeStatus").val());
                	$("#showText").html($(".nowTime>.btn-primary").text()+$("#changeStatus").find("option:selected").text()+"统计");
                	showLine();
                })
                $('#changeType').change(function(){ 
                	$("#picType").val($("#changeType").val());
                	showPie();
                })
                $('#mipArea').change(function(){ 
                	$("#picArea").val($("#mipArea").val());
                	showPie();
                })
                $('#isOk').click(function(){ 
                	showPie();
                });
                $("#editDetails").click(function(){
                	$(".collection").removeClass("btn-primary").addClass("btn-default");
                	$(".collection").eq(1).removeClass("btn-default").addClass("btn-primary");
                	$(".infoDiv").hide().eq(1).show();
                	$("#changeType").get(0).selectedIndex = 2;
                	$("#picType").val("2");
               	 	$("#picArea").val("0");
            		getAreaList();
                	showPie();
                });
                $("#addDetails").click(function(){
                	$(".collection").removeClass("btn-primary").addClass("btn-default");
                	$(".collection").eq(1).removeClass("btn-default").addClass("btn-primary");
                	$(".infoDiv").hide().eq(1).show();
                	$("#changeType").get(0).selectedIndex = 1;
                	$("#picType").val("1");
               	 	$("#picArea").val("0");
            		getAreaList();
                	showPie();
                });
                function showLine(){
                	var type=$("#versionTimeType").val();
                	var status=$("#versionStatus").val();
                	 $.ajax({
	                     type : "post",
	                     async : false, //同步执行
	                     data:{type:type,status:status},
	                     url : "/admin/trendsManage/showEchartLine.do",
	                     dataType : "json", //返回数据形式为json
	                     success : function(result) {
	                         if (result) {
	                             //将返回的category和series对象赋值给options对象内的category和series
	                             //因为xAxis是一个数组 这里需要是xAxis[i]的形式
	                                 options.xAxis[0].data = result.category;
	                                 options.series = result.series;
	                                 options.legend.data = result.legend;
	                                 myChart.hideLoading();
	                                 myChart.setOption(options);
	                         }
	                     },
	                     error : function(errorMsg) {
	                         alert("图表请求数据失败啦!");
	                     }
	                 });
                }
            });
    $(".collection").click(function (){
    	$(".collection").removeClass("btn-primary").addClass("btn-default");
    	$(this).removeClass("btn-default").addClass("btn-primary");
    	$(".infoDiv").hide().eq($(this).index()).show();
    	if(1==$(this).index()){
    		showPie();
    		getAreaList();
    	}
    })
    function getAreaList(){
    	$.ajax({
            type : "post",
            async : true, //同步执行
            url : "/admin/objectChange/getAreaList.do",
            dataType : "json", //返回数据形式为json
            success : function(result) {
            	if(result.success==1){
	            	$("#mipArea").html("");
	            	$("#mipArea").append(
		            		'<option value="0">所有</option>'
		            );
	            	for(var i=0;i<result.data.length;i++){
		            	$("#mipArea").append(
		            		'<option value="'+result.data[i].id+'">'+result.data[i].name+'</option>'
		            	);
	            	}
	            	console.log(result);
            	}
            },
            error : function(errorMsg) {
            }
        });
    }
    function showPie(){
    	 var myChart = echarts.init(document.getElementById('mainPie'));
    	 var picType = $("#picType").val();
    	 var picArea = $("#picArea").val();
    	 var beginTime = $("#datemin").val(); 
    	 var endTime = $("#datemax").val();
         //图表显示提示信息
         myChart.showLoading();
         //定义图表options
         var options = {
             title : {
                 text : '北京市博物馆藏品动态统计',  
//                  subtext : '藏品变动',
                 x : 'center'
             },
             tooltip : {
                 trigger : 'item',
                 formatter : "{a} <br/>{b} : {c} ({d}%)"
             },
             legend : {
                 orient : 'vertical',
                 left : 'left',
                 data : []
             },
             series : [ {
                 name : '访问来源',
                 type : 'pie',
                 data : []
             } ]
         };
         //通过Ajax获取数据
         $.ajax({
             type : "post",
             async : false, //同步执行
             data:{picType:picType,picArea:picArea,beginTime:beginTime,endTime:endTime},
             url : "/admin/objectChange/showEchartPie.do",
             dataType : "json", //返回数据形式为json
             success : function(result) {
                 if (result) {
                     options.legend.data = result.legend;

                     //将返回的category和series对象赋值给options对象内的category和series
                     //因为xAxis是一个数组 这里需要是xAxis[i]的形式
                     options.series[0].name = result.series[0].name;
                     options.series[0].type = result.series[0].type;
                     var serisdata = result.series[0].data;

                     //jquery遍历
                     var value = [];
                     $.each(serisdata, function(i, p) {
                         value[i] = {
                             'name' : p['name'],
                             'value' : p['value']
                         };
                     });
                     options.series[0]['data'] = value;

                     myChart.hideLoading();
                     myChart.setOption(options);
                 }
             },
             error : function(errorMsg) {
                 alert("图表请求数据失败啦!");
             }
         });
        
          myChart.on("click", eConsole);
          myChart.on("hover", eConsole);
    }
    //增加监听事件
    function eConsole(param) {
    	$("#mipArea option").each(function (){
    	    if($(this).text()==param.data.name){
    	        $(this).attr('selected',true);
    	        $("#picArea").val($(this).val());
            	showPie();
    	    }
    	});
     }
</script>
</body>
</html>