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
clickcallback_"+BussCode+"_"+field_name+"(newindex_,layero, index);
//获取选择页面datagrid选中对象
var q_ = parent.layer.getChildFrame('.datagrid-view2 .datagrid-row-selected', index);
if (q_.length > 1) {
var id="",name="";
    for (var i2 = 0; i2 < q_.length; i2++) {
	id = id + $(q_[i2]).find("[field='id']").text();
	name= name + $(q_[i2]).find("[field='tableName']").text();
	if (i2 != (q_.length - 1)) {
	    id += ',';
	    name += ',';
	}
    }
   $("#402881e65c24124c015c264618420061\\@data4").val(id);
   $("#402881e65c24124c015c264b27470067_showName").val(name);
}
if (q_.length ==1) {
   $("#402881e65c24124c015c264618420061\\@data4").val($(q_[0]).find("[field='id']").text());
   $("#402881e65c24124c015c264b27470067_showName").val($(q_[0]).find("[field='tableName']").text());
}
else {
    parent.layer.msg('请选择！', {icon: 5});
    return;
}

//获取选择页面函数
$(layero.find('iframe')[0]).attr("name",layero.find('iframe')[0]['id']);
var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
//调用授权提交方法
var flag = iframeWin.mySubmit();

清除时回调方法
clearAll_"+BussCode+"_"+field_name+"(index_)
$("#402881e65c24124c015c264618420061\\@data4").val("");
   $("#402881e65c24124c015c264b27470067_showName").val("");

//调用授权提交方法
var nodes = iframeWin.getSNode();
if(nodes){//获得ztree对象中的值
$("#T001\\@data2").val(nodes[0].id);
$("#showName_T001_data2").val(nodes[0].name);
}
 * 
 * 
 * 
*/


$(function() {
$("#B201800033\\@T1528098962000361").click(function(){
       	$.saveData(true);
      });
$("#B201800033\\@T15280989610009154").click(function(){
       	window.colse();
      });