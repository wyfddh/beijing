/**
 * 
 * 

//页面表单数据保存方法-----start------
$.saveData(true) //true:是否刷新当前页面
//页面表单数据保存方法-----end------

//父页面表单数据保存方法-----start------
parent.$.saveData(true) //true:是否刷新当前页面
//父页面表单数据保存方法-----end------
//提交审批流程-----start------
$.submitBusiness();
//提交审批流程-----end------


$("#").click(function(){
       	
      });


//页面鼠标提示信息方法-----------start--------------------
$(function() {
	$("input").each(function(i,obj) {
	var fieldAlert= $(obj).attr("fieldAlert");
	if(fieldAlert!=""&&fieldAlert!=null){
		$(obj).click(function(){
			layer.tips(fieldAlert, $(obj),{
			  tips: [1, '#0FA6D8'], //还可配置颜色
			  time: 4000
			});
		});
	   }
	});
	$("textarea").each(function(i,obj) {
	var fieldAlert= $(obj).attr("fieldAlert");
	if(fieldAlert!=""&&fieldAlert!=null){
		$(obj).click(function(){
			layer.tips(fieldAlert, $(obj),{
			  tips: [1, '#0FA6D8'], //还可配置颜色
			  time: 4000
			});
		});
	   }
	});
});
//页面鼠标提示信息方法-----------end--------------------



弹出选择提供以下回调方法
确定时回调方法

 * 
 * 
 * 
*/


$(function() {
	$("#B201800018\\@T15275649510007663").click(function(){
       		$.saveData(true);
	});
	$("#B201800018\\@T15275649510004364").click(function(){
       		window.close();
	});
});