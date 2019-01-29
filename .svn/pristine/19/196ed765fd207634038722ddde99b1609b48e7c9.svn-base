 var localObj = window.location;
              var contextPath = localObj.pathname.split("/")[1];
 var basePath = localObj.protocol + "//" + localObj.host + "/"+ contextPath;

//report对象
var REPORT = function(){
	
}
var charts = [];
REPORT.prototype.getReportByType = function(divName,selectType,title,type,convertData){
	var myChart = echarts.getInstanceById($("#"+divName).attr("_echarts_instance_")); 
	if (myChart != null && myChart != "" && myChart != undefined) {
        myChart.dispose();
    } 
	myChart = echarts.init(document.getElementById(divName));
	charts.push(myChart);
     var newType = type;
     if(type == "barZoom"){
    	 newType = "bar";
     }else if(type == "barZoomThin"){
    	 newType = "bar";
     }else if(type == "barZoomErect"){
    	 newType = "bar";
     }else if(type == "stackedarea"){
    	 newType = "line";
     }
     else if(type == "pieMult"){
    	 newType = "pie";
     }
     
	 var json = {"title":title,"selectType":selectType,"type":newType,"convertData":convertData};
     $.ajax({
         url:basePath+"/report/getPreviewReport.do",
         type:"POST",  
         dataType:"json",
         contentType: "application/json",                 
         data:JSON.stringify(json), 
         success:function(data){
        	 var result = data.data;
        	 switch(type){
        	 	case "line":
        	 		 var option = {
                        title: result.title,
                        tooltip: {},
                        xAxis: {data:result.xAxis},
                        yAxis: {},
                        legend: result.legend,
                        series: result.series
                    };
        	 	case "stackedarea":
        	 		var option = {
	                     title: result.title,
	                     tooltip: {show: true, // 是否显示提示框组件 
	                    	 trigger: 'axis', //坐标轴触发，用在柱状图，折线图等会使用类目轴的图表中使用 
	                    	 formatter: function( params ) { 
	                    	 return params[0].name + " ： " + params[0].data; // 由于可能有多个series，因此params[0].name和.data表示第一个series的该坐标点 xAxis值和yAxis值 
	                    	 }},
	                     xAxis: {
	                    	 boundaryGap: false,
	                    	 data:result.xAxis
	                     },
	                     yAxis: [{type: 'value'}],
	                     legend: result.legend,
	                     series: result.series	                     
	                 };
        	 		 break;
        	 	case "barZoomErect":
        	 		var option = {
	                     title: result.title,
	                     tooltip: {},
	                     xAxis: {},
	                     yAxis: {data:result.xAxis},
	                     legend: result.legend,
	                     series: result.series	                     
	                 };
        	 		break;
        	 	case "bar":
        	 		var option = {
	                     title: result.title,
	                     tooltip: {},
	                     xAxis: {data:result.xAxis},
	                     yAxis: {},
	                     legend: result.legend,
	                     series: result.series	                     
	                 };
        	 		break;
        	 	case "barZoom":
        	 		var option = {
	                     title: result.title,
	                     tooltip: {},
	                     xAxis: {data:result.xAxis},
	                     yAxis: {},
	                     legend: result.legend,
	                     series: result.series,
	                     dataZoom : [
	             	    	{
	                             type: 'slider',
	                             show: true,
	                             start: 0,
	                             end: 50,
	                             handleSize: 8
	                         },
	                         {
	                             type: 'inside',
	                             start: 0,
	                             end: 10
	                         },
	                         {
	                             type: 'slider',
	                             show: true,
	                             yAxisIndex: 0,
	                             filterMode: 'empty',
	                             width: 12,
	                             height: '70%',
	                             handleSize: 8,
	                             showDataShadow: false,
	                             left: '93%'
	                         }
	             	    ]
	                 };       	 		
        	 		break;
        	 	case "barZoomThin":
        	 		var option = {
	                     title: result.title,
	                     tooltip: {},
	                     xAxis: {data:result.xAxis},
	                     yAxis: {},
	                     legend: result.legend,
	                     series: result.series,
	                     dataZoom : [
	             	    	{
	                             type: 'slider',
	                             show: true,
	                             start: 0,
	                             end: 10,
	                             handleSize: 8
	                         },
	                         {
	                             type: 'inside',
	                             start: 0,
	                             end: 10
	                         },
	                         {
	                             type: 'slider',
	                             show: true,
	                             yAxisIndex: 0,
	                             filterMode: 'empty',
	                             width: 12,
	                             height: '70%',
	                             handleSize: 8,
	                             showDataShadow: false,
	                             left: '93%'
	                         }
	             	    ]
	                 };       	 		
        	 		break;
        	 	case "pie":
        	 		var option = {
                        title: result.title,
                        tooltip: {},
                        legend: result.legend,
                        series: result.series
                    };
        	 		break;
        	 	case "pieMult":
        	 		var option = {
                        title: result.title,
                        tooltip: {},
                        legend: result.legend,
                        series:function(){
	                        	var serie=[];
	                        	var info = result.series;
	                        	for( var i=0;i < info.length;i++){
	                        	var item={
		                        	name:info[i].name,
		                        	data:info[i].data,
		                        	type:info[i].type,
		                        	radius:['50%', '70%'],
		                        	center: ['50%', '60%'],
		                            label: {
		                                normal: {
		                                    show: true,
		                                    formatter: '{b}: {c}({d}%)'
		                                }
		                            }
	                        	}
	                        	serie.push(item);
	                        	};
	                        	return serie;
                        	}()
                    };
        	 		break;
        	 }             
             // 使用刚指定的配置项和数据显示图表。
             myChart.setOption(option);         
         },
         error:function(msg){
//        	 alert("数据请求异常");
         }
   });
}
/**
 * sql简单组装
 */
REPORT.prototype.assembleSqlSimple =  function(convertData){
	for (var i = 0; i < convertData.length; i++) {
		var temp = convertData[i];
		//是否为主表选择关系
		if(temp.isMainTable){
			var tableName = temp.tableName;
			
		}
	}
}
var resizeWorldMapContainer = function () {
    worldMapContainer.style.width = window.innerWidth+'px';
    worldMapContainer.style.height = window.innerHeight+'px';
};

window.onresize = function(){//在所有图表之后
    for(var i = 0; i < charts.length; i++){
        charts[i].resize();
    }
};

var myReport = new REPORT();
