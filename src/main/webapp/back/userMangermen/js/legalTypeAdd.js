layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    
    var pathName=window.document.location.pathname;
    projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    
    var index = parent.layer.getFrameIndex(window.name);
    
    form.on('radio(kind)', function(data){ 
    	if (data.value == 2) { 
    		$("#div1").show();
    		$("#pid").attr("lay-verify","required");
    	} else {
    		$("#div1").hide();
    		$("#pid").removeAttr("lay-verify");
    	} 
    });  
 
    form.on("submit(addLegalType)",function(data){
    	
    	var data = $("#form").serialize();
        $.ajax({
        	type:"post",
        	data:data,
        	async:false,
        	url:projectName + '/legalType/save.do', 
        	success:function(data) {
        		if (data == 1) {
        			top.layer.msg("添加成功！"); 
        			parent.layer.close(index);
                    
        		} else {
        			top.layer.msg("系统异常添加失败！");
        			parent.layer.close(index);
        		}
        	}, 
        	error:function(data) {
        		top.layer.msg("系统异常添加失败！");
    			parent.layer.close(index);
        	}
        })

      /*  return false; */
    })

    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());

})