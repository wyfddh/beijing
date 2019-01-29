/***
 * 
 * 此方法体内可以随意更改,form_default_colse函数名不能更改
 * 
 * 
 */

function form_default_close(){
	console.log("执行默认关闭方法-----------------");
	var index=parent.layui.layer.getFrameIndex(window.name);
	parent.layui.layer.close(index);
}