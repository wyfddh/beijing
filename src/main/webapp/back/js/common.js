/**
 * 公共js，用于存放公共方法
 */
function resizeLayer(layerIndex) {
    var docWidth = $(window).width();
    var docHeight = $(window).height();
    var layerInitWidth = $("#layui-layer"+layerIndex).width();
    var layerInitHeight = $("#layui-layer"+layerIndex).height();
    var minWidth = layerInitWidth > docWidth ? docWidth : layerInitWidth;
    var minHeight = layerInitHeight > docHeight ? docHeight : layerInitHeight;
    /*
	 * console.log("doc:",docWidth,docHeight);
	 * console.log("lay:",layerInitWidth,layerInitHeight);
	 * console.log("min:",minWidth,minHeight);
	 */
    if(layerInitHeight > docHeight){
    	layui.layer.style(layerIndex, {
    		top: 0,
    		width: minWidth,
    		height:minHeight
    	});
    }else{
    	layui.layer.style(layerIndex, {
    		width: minWidth,
    		height:minHeight
    	});
    }
}　

// 获取当前日期yy-mm-dd
// date 为时间对象
function getDateStr3(date) {
	var year = "";
	var month = "";
	var day = "";
	var now = date;
	year = ""+now.getFullYear();
	if((now.getMonth()+1)<10){
	    month = "0"+(now.getMonth()+1);
	}else{
	    month = ""+(now.getMonth()+1);
	}
	if((now.getDate())<10){
	    day = "0"+(now.getDate());
	}else{
	    day = ""+(now.getDate());
	}
	return year+"-"+month+"-"+day;
}
/*******************************************************************************
 * 获得相对当前周AddWeekCount个周的起止日期 AddWeekCount为0代表当前周 为-1代表上一个周 为1代表下一个周以此类推
 ******************************************************************************/ 
function getWeekStartAndEnd(AddWeekCount) { 
	// 起止日期数组
	var startStop = new Array(); 
	// 一天的毫秒数
	var millisecond = 1000 * 60 * 60 * 24; 
	// 获取当前时间
	var currentDate = new Date();
	// 相对于当前日期AddWeekCount个周的日期
	currentDate = new Date(currentDate.getTime() + (millisecond * 7*AddWeekCount));
	// 返回date是一周中的某一天
	var week = currentDate.getDay(); 
	// 返回date是一个月中的某一天
	var month = currentDate.getDate();
	// 减去的天数
	var minusDay = week != 0 ? week - 1 : 6; 
	// 获得当前周的第一天
	var currentWeekFirstDay = new Date(currentDate.getTime() - (millisecond * minusDay)); 
	// 获得当前周的最后一天
	 var currentWeekLastDay = new Date(currentWeekFirstDay.getTime() + (millisecond * 6));
	// 添加至数组
	startStop.push(currentWeekFirstDay); 
	startStop.push(currentWeekLastDay); 
	
	return startStop; 
}

//日期月份/天的显示，如果是1位数，则在前面加上'0'
function getFormatDate(arg) {
    if (arg == undefined || arg == '') {
        return '';
    }

    var re = arg + '';
    if (re.length < 2) {
        re = '0' + re;
    }

    return re;
}

