/**--单击事件备注信息--******/
try{
	$("[id='BD1533621838881@T15331067290005378']").click(function(){
		/**--执行方法体-start--******/
			$.saveData(false);
		/**--执行方法体-end--******/
	});
}catch(e){}
/**--单击事件备注信息--******/
try{
	$("[id='BD1533621838881@T15331069350001617']").click(function(){
		/**--执行方法体-start--******/
			window.close();
		/**--执行方法体-end--******/
	});
}catch(e){}
/**--单击事件备注信息--******/
try{
	$("[id='BD1533621838881@T15331069120008922']").click(function(){
		/**--执行方法体-start--******/
			$.saveData(false);
$.ajax({
        url:"<%=request.getContextPath() %>/notice/receive/changeStatus.do",
        data:{id: $.otherParameters.id, receiveStatus:'2', reportId: $.mainId},
        type:"POST",
        asynx: false,
        success:function(msg){
           	var index=parent.layui.layer.getFrameIndex(window.name);
           	parent.layui.layer.close(index);
        }
});
		/**--执行方法体-end--******/
	});
}catch(e){}
/**--单击事件备注信息--******/
try{
	$("[id='BD1533621838881@T1533106831000443']").click(function(){
		/**--执行方法体-start--******/
			window.close();
		/**--执行方法体-end--******/
	});
}catch(e){}
