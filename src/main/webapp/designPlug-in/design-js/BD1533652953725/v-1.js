/**--单击事件备注信息--******/
try{
	$("[id='BD1533652953725@T15336357700008058']").click(function(){
		/**--执行方法体-start--******/
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
		/**--执行方法体-end--******/
	});
}catch(e){}
/**--单击事件备注信息--******/
try{
	$("[id='BD1533652953725@T15336357850003042']").click(function(){
		/**--执行方法体-start--******/
			
window.close();
		/**--执行方法体-end--******/
	});
}catch(e){}
