layui.use(['form','layer'],function(){
	var index = parent.layer.getFrameIndex(window.name);
	var form = layui.form;
	form.render();
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
	
	$("#success").click(function(){
		var ids = $("#ids").val();
		var authSetting = $('#batchSetting input[name="setting"]:checked ').val()
		console.log(ids);
		console.log(authSetting);
		var data = ids.split(",");
		var json = {"ids":data,"type":authSetting};
		 $.ajax({
	            url:projectName + '/openCollection/approvalCollection.do',
	            type:'post',
	            data:json,
	            traditional: true,
				dataType : "json",
	            success:function(result) {
	                if (result== "1") {
	                	parent.layer.msg('审核成功', {icon: 1});
	                	parent.layer.close(index);
	                    
	                } else if (result == 0){
	                	parent.layer.msg('审核失败', {icon: 1});
	                }
	            }
	        })
		
	})
	
	$("#cancel").click(function(){
		parent.layer.close(index);
	})
});