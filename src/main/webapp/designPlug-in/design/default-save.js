/***
 * 
 * 此方法体内可以随意更改,form_default_save函数名不能更改
 * 
 * 
 */

function form_default_save(){
	console.log("执行默认保存方法-----------------");
	$.saveData(true);
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
	$.ajax({
	        url: projectName+"/notice/receive/changeStatusByReport.do",
	        data:{otherParameters: $.otherParameters, receiveStatus:'2', reportId: $.mainId},
	        type:"POST",
	        asynx: false,
	        success:function(msg){
	        }
	});
	var index=parent.layui.layer.getFrameIndex(window.name);
	parent.layui.layer.close(index);
}