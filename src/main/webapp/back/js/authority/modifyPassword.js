layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    var pathName=window.document.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    var index = parent.layer.getFrameIndex(window.name);
    form.verify({ 
    	pass:[/(.+){6,12}$/, '密码必须6到12位']
    	,repass:function(repassValue){
    		var passvalue = $('#password').val();
    		if(repassValue != passvalue){
    			return '两次输入的密码不一致!';
    		}
    	}
    });
    
    var initForm = function() {
    	$(".hide").hide(); 
    }
    
    initForm();
    // 勉强解决360自动提示输入已保存密码，挡住提示层
    $(".pass").change(function() {
    	
    	var thisval = $(this).val();
    	if (thisval != '') {
    		$(this).attr("type","password");
    	} else {
    		$(this).attr("type","text");
    	}
    })
    $("#reset").click(function() {
    	$(".pass").attr("type","text");
    })
    
    $("#passwordOld").blur(function() {
    	var pass = $("#passwordOld").val();
    	//$("#passwordOld").val(hex_md5(pass));
    	var userId = $("#userId").val();
    	$.ajax({
    		url:projectName + '/userManagemen/checkPassword.do',
    		data:{"password":hex_md5(pass),"userId":userId},
    		type:'post',
    		success:function(result) {
    			var msg = result.success;
    			if (msg == 2) {
    				layer.msg('原密码输入不正确！', {icon: 5}); 
    			} else if (msg == 2){
    				layer.msg('系统异常！', {icon: 5}); 
    			}
    		}
    	})
    })
    
    
    
    form.on("submit(modifyPassword)",function(data){
    	var password=$("#password").val();
    	var userId = $("#userId").val();
    	var data = $("#form").serialize();
        $.ajax({
        	type:'post',
        	data:{"password":hex_md5(password),"userId":userId},
        	url:projectName + '/userManagemen/modifyPassword.do', 
        	success:function(result) {
        		if (result.success == 1) {
        			top.layer.msg("修改成功，请重新登陆！");
        			top.window.location.href = projectName + "/back/loginOut.do";
//        			parent.layer.close(index);
        		} else {
        			if(result.success == 0){
        				top.layer.msg(result.data);
        			}else{
        				top.layer.msg("系统异常修改失败！");
        				parent.layer.close(index);
        			}
        		}
        	} 
        })
       return false;
    })
    
    window.relogin = function(){
    	top.window.location.href = projectName + "/back/loginOut.do";
    }
    
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



