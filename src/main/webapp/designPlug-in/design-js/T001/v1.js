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





 * 
 * 
 * 
*/
$(function() {
$("#T001\\@T15266243100004509").click(function(){
       	$.saveData(true)
      });
$("#T001\\@T15266243170007818").click(function(){
       window.close();
      });

});


function clickcallback_T001_data2(newindex_,layero, index){
$(layero.find('iframe')[0]).attr("name",layero.find('iframe')[0]['id']);
var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
//调用授权提交方法
var nodes = iframeWin.getSNode();
if(nodes){
$("#T001\\@data2").val(nodes[0].id);
$("#showName_T001_data2").val(nodes[0].name);
}

}