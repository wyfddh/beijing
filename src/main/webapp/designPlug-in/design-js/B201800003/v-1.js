/**--关闭--******/
try{
	$("[id='C002']").click(function(){
		/**--执行方法体-start--******/
			window.close();
		/**--执行方法体-end--******/
	});
}catch(e){}
/**--保存--******/
try{
	$("[id='C001']").click(function(){
		/**--执行方法体-start--******/
			$.saveData(false);
		/**--执行方法体-end--******/
	});
}catch(e){}