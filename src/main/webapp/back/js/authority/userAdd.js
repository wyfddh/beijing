layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    var pathName=window.document.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    var index = parent.layer.getFrameIndex(window.name);
    form.verify({ 
    	num:function(phoneval) {
    		var checkPhone = /^([\d]{11})?$/;
    		if (!checkPhone.test(phoneval)) {
    			return '请输入正确手机号';
    		}
    		var status = 2;
    		$.ajax({
    			type:"post",
    			data:{"phone":phoneval},
    			async:false,
    			url:projectName + '/userManagemen/check.do',
    			success:function(result) {
    				if (result.success == 2) {
    					status = 0;
    				}
    			}
    		})
    		if (status == 0) {
    			return '手机号重复';
    		}
    	}
    	,pass:[/(.+){6,12}$/, '密码必须6到12位']
    	,repass:function(repassValue){
    		var passvalue = $('#password').val();
    		if(repassValue != passvalue){
    			return '两次输入的密码不一致!';
    		}
    	}
    	,box:function(value) {
    		var arr = new Array();
    		$("#roles").find("input:checkbox[name='roleBox']:checked").each(function(i){
                arr[i] = $(this).val();
            });
    		if (arr.length == 0) {
    			return '请选择用户角色';
    		}
    	}
    				
    });
    
    var initForm = function() {
    	$(".hide").hide(); 
    	var typeval
    	runAsync().then(function(data){
    	    setTimeout(function(){
	        	console.log(1111,typeval);
	        	if (typeval == 2) {
	        		var id = $("#id").val();
	    			getRoleList(id);
	        	}
	        }, 500);
    	});
    	function runAsync(){
    	    var p = new Promise(function(resolve, reject){
    	        setTimeout(function(){
    	        	typeval = $("#type").val();
    	    		if($("#orgId11").val() != ''){
    	        		$("#roles").empty();
    	            	form.render();
    	            	var orgId = $("#orgId11").val();
    	            	if (orgId != "") {
    	            		getRoleByOrg(orgId);
    	            	} else {
    	            		$("#roleDiv").hide();
    	            	}
    	        	}
    	    		if (typeval == 2) {
    	    			$("#reset").hide();
    	    			var statusval = $("#statusHide").val();
    	    			if (statusval == 1) {
    	    				$("#editStatus").click();
    	    			}
    	    			var orgId = $("#editOrg").val();
//    	    			getRoleByOrg(orgId);
    	    			form.render();

    	    		}
    	    		resolve('随便什么数据');
    	        }, 100);
    	    });
    	    return p;            
    	}
    
    	/*setTimeout(function() {
    		var typeval = $("#type").val();
    		if($("#orgId11").val() != ''){
        		$("#roles").empty();
            	form.render();
            	var orgId = $("#orgId11").val();
            	if (orgId != "") {
            		getRoleByOrg(orgId);
            	} else {
            		$("#roleDiv").hide();
            	}
        	}
    		if (typeval == 2) {
    			$("#reset").hide();
    			var statusval = $("#statusHide").val();
    			if (statusval == 1) {
    				$("#editStatus").click();
    			}
    			var orgId = $("#editOrg").val();
//    			getRoleByOrg(orgId);
    			form.render();
    			var id = $("#id").val();
    			setTimeout(function() {
    				getRoleList(id);
    			},100);
    		}
    	},100);*/
    }
    
    initForm();
    
    $("#reset").click(function() {
    	$("#roles").empty();
    	$("#roleDiv").hide();
    })
    
    $("#password").change(function() {
    	var passval =  $("#password").val();
    	if (passval != "") {
    		$("#password").attr("lay-verify","required|pass");
    		$("#repassdiv").show();
    		$("#repassword").attr("lay-verify","required|repass");
    	} else {
    		$("#password").removeAttr("lay-verify");
    		$("#repassdiv").hide();
    		$("#repassword").removeAttr("lay-verify");
    		$("#repassword").val("");
    	}
    })
    
    form.on('select(orgSelect)',function(data) {
    	$("#roles").empty();
    	form.render();
    	var orgId = data.value;
    	if (orgId != "") {
    		getRoleByOrg(orgId);
    	} else {
    		$("#roleDiv").hide();
    	}
    	
    });
    function getRoleByOrg(orgId) {
    	$.ajax({
			url:projectName + '/userManagemen/getRoleByOrg.do',
			data:{"orgId":orgId},
			type:"post",
			asyne:false,
			success:function(result) {
				if (result.success == 1) {
					var roles = result.data;
					var roleStr = "";
					for (var i = 0;i < roles.length;i++) {
						roleStr +="<input type='checkbox' name='roleBox' lay-verify='box' title='"+roles[i].name+"' value='"+roles[i].id+"' ></input>"
					}
					$("#roles").append(roleStr);
					form.render();
					$("#roleDiv").show();
				} else {
					top.layer.msg("系统异常！");
				}
			}
		})
    }
    function getRoleList(id) {
    	$.ajax({
			url:projectName + '/userManagemen/getRoleList.do',
			data:{"id":id},
			type:"post",
			asyne:false,
			success:function(result) {
				var roles = result.data;
				if (result.success == 1) {
					$("input[name='roleBox']").each(function() { 
						var _this=$(this);
						console.log(_this);
						for (var i = 0;i < roles.length;i++) {
							if (_this.val() == roles[i].roleId) {
								_this.next().click(); 
							}
						}
					});
					form.render();
				}
			}
		})
    }
    
    form.on("submit(addUser)",function(data){
    	
    	var data = $("#form").serialize();
        $.ajax({
        	type:"post",
        	data:data,
        	url:projectName + '/userManagemen/save.do', 
        	success:function(result) {
        		if (result.success == 1) {
        			top.layer.msg("操作成功！");
        			parent.layer.close(index);
                    
        		} else {
        			top.layer.msg("系统异常添加失败！");
        			parent.layer.close(index);
        		}
        	} 
        })
       return false;
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



