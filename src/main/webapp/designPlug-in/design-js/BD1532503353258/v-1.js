/**--提交表单并刷新--******/
try{
	$("[id='botton_1532500215993']").click(function(){
		/**--执行方法体-start--******/
			$.saveData(true);
		/**--执行方法体-end--******/
	});
}catch(e){}
/**--只保存--******/
try{
	$("[id='botton_1532500239305']").click(function(){
		/**--执行方法体-start--******/
			$.saveData(false);
		/**--执行方法体-end--******/
	});
}catch(e){}
/**--取消关闭窗口--******/
try{
	$("[id='botton_1532500316889']").click(function(){
		/**--执行方法体-start--******/
			window.close();
		/**--执行方法体-end--******/
	});
}catch(e){}
