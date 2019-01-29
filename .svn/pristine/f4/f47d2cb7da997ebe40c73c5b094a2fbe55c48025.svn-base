layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    
    var pathName=window.document.location.pathname;
    projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    
    var index = parent.layer.getFrameIndex(window.name);
    
    
    form.verify({ 
    	typeName:function(typeName){
    		var status = 0;
    		$.ajax({
    			url:projectName + '/legalType/check.do',
    			data:{"typeName":typeName},
    			type:"post",
    			async:false,
    			success:function(result) {
    				var res = result.success;
    				if (res == 2) {
    					status = 1;
    				}
    			}
    		})
    		if (status == 1) {
    			return '分类名重复！';
    		}
    	}
    });
    
    function initForm() {
    	setTimeout(function(){
    		var kindRadio = $("#kindRadio").val();
//    		$("input:radio[value='"+kindRadio+"']").attr('checked','true');
    		
    		
    		form.render();
    	},100)
    }
    
    
    initForm();
    
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
    	var msg;
    	var type = $("#type1").val();
    	if (type == 1) {
    		msg = "添加";
    	} else {
    		msg = "修改";
    	}
        $.ajax({
        	type:"post",
        	data:data,
        	async:false,
        	url:projectName + '/legalType/save.do', 
        	success:function(result) {
        		if (result == 1) {
        			top.layer.msg(msg + '成功！'); 
        			parent.layer.close(index);
        		} else {
        			top.layer.msg('系统异常' + msg + '失败！');
        			parent.layer.close(index);
        		}
        	}, 
        	error:function(result) {
        		top.layer.msg('系统异常' + msg + '失败！');
    			parent.layer.close(index);
        	}
        })

      /*  return false; */
    })
    
    var initData = function() {
    	$(".hide").hide();
//    	$.ajax({
//    		url:projectName + '/legalType/getFirstKind.do',
//    		type:"post",
//    		success:function(result) {
//    			if (result.success == 1) {
//    				var kindList = result.data;
//    				var kindStr = "";
//    				for (var i = 0;i < kindList.length;i++) {
//    					kindStr += "<option value='"+kindList[i].id+"'>"+kindList[i].typeName+"</option>"
//    				}
//    				$("#pid").append(kindStr);
//    				form.render();
//    			} else {
//    				
//    			}
//    		}
//    	})
    }
    initData();
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

