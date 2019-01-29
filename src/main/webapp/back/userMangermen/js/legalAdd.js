layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    var layedit = layui.layedit;
    var area = layedit.build('textarea',{
    	tool: [
    	       'strong' //加粗
    	       ,'italic' //斜体
    	       ,'underline' //下划线
    	       ,'del' //删除线
    	       ,'|' //分割线
    	       ,'left' //左对齐
    	       ,'center' //居中对齐
    	       ,'right' //右对齐
    	       ,'link' //超链接
    	       ,'unlink' //清除链接
//    	       ,'face' //表情
//    	       ,'image' //插入图片
//    	       ,'help' //帮助
    	     ]
    	,height: 500
    }); //建立编辑器
   
    
    var nowdate = new Date;
    var nowyear = nowdate.getFullYear(); 
    var laydate = layui.laydate;
    
    laydate.render({
		  elem: '#publishYear' 
		  ,type: 'year'
		  ,max:nowyear
		});
    
    
    var pathName=window.document.location.pathname;
    projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    
    var index = parent.layer.getFrameIndex(window.name);
    
    var upload = layui.upload;
    var uploadInst = upload.render({
        elem: '#fileBtn' //绑定元素
        ,url: projectName + '/attach/uploadLegal.do' //上传接口
        ,data:{
        	projectName:"legal"
        }
    	,auto:true
    	,field:"file"
    	,accept:"file"
		,before: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
   			//加载层-风格4
   			layer.msg('上传中', {
   			  icon: 16
   			  ,shade: 0.5
   			});
   		}
        ,done: function(res){
        	layer.closeAll(); //关闭loading
          //上传完毕回调
        	var resultCode = res.code
        	var msg = res.msg;
        	if (resultCode == 1) {
        		var resultMap = res.data;
        		$("#resultPath").val(resultMap.resultPath);
            	$("#realFileName").val(resultMap.realFileName);
            	$("#isjunk").val(resultMap.isjunk);
            	$("#size").val(resultMap.size);
            	$("#typeCode").val(resultMap.typeCode);
            	
            	$("#isChange").val("1");
            	
            	$("#fileBtn").hide();
            	$("#divtext").text(resultMap.realFileName);
            	$("#fileHide").show();
        	}
        	top.layer.msg(msg);
        	
        }
        ,error: function(){
          //请求异常回调
        }
      });
 
    form.on('select(firstKind)', function(data){
    	$("#secondKind option[value!='']").remove();  
    	var firstKindId = {"firstKindId":data.value};
    	getSecondKindList(firstKindId);
	});  
    
    
    
    
    function getSecondKindList(firstKindId) {
    	$.ajax({
    		url:projectName + '/legal/getSecondKindList.do', 
    		data:firstKindId,
    		type:"post",
    		async:false,
    		success:function(result) {
    			var secondKindList = result.data;
    			var secondStr = "";
    			if (secondKindList != null) {
    				for (var i = 0;i < secondKindList.length;i++) {
        				secondStr +="<option value='"+secondKindList[i].id+"' >"+secondKindList[i].typeName+"</option>"
        			}
        			$("#secondKind").append(secondStr); 
    			}
    			form.render();
    		}
    	})
    }
    
    form.on("submit(submitBtn)",function(data){
    	layedit.sync(area);
    	var formData = $("#form").serialize();
        $.ajax({
        	type:"post",
        	data:formData,
        	async:false,
        	url:projectName + '/legal/save.do', 
        	success:function(result) {
        		var msg = result.success;
        		var type = result.data;
        		if (type == "1") {
        			if (msg == "1") {
            			top.layer.msg("添加成功！"); 
            			parent.layer.close(index);
            		} else {
            			top.layer.msg("系统异常添加失败！");
            			parent.layer.close(index);
            		}
        		} else if (type == "2") {
        			if (msg == "1") {
            			top.layer.msg("修改成功！"); 
            			parent.layer.close(index);
                        
            		} else {
            			top.layer.msg("系统异常修改失败！");
            			parent.layer.close(index);
            		}
        		}
        	}, 
        	error:function(data) {
        		top.layer.msg("系统异常");
    			parent.layer.close(index);
        	}
        })

      /*  return false; */
    })

    var initForm = function() {
    	
    	setTimeout(function() {
    		var typeval = $("#saveType").val();
    		
    		//2修改3查看
    		if (typeval != 1) {
    			var firstId = {"firstKindId":$("#firstKindHide").val()};
        		getSecondKindList(firstId);
        		var secondId = $("#secondKindHide").val();
        		$("#secondKind option[value='"+secondId+"']").attr("selected",true);
        		form.render();
        		
        		$("#fileBtn").hide();
            	$("#fileHide").show();
        		
        		var areaval = $("#textareaHide").val();
        		layedit.setContent(area, areaval, false);  
    		}
    		
    	},100)
    }
    initForm();
    
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

function cancelFile() {
	$("#fileBtn").show();
	$("#divtext").text("");
	$("#fileHide").hide();
	var resultPath = $("#resultPath").val();
	$.ajax({
		type:"post",
		url:projectName + '/attach/cancelFile.do',
		data:{"resultPath":resultPath},
		success:function(result) {
			
		}
	})
}
function downFile() {
	var hideUrl = $("#hideUrl").val();
	var fileName = $("#divtext").text();
	window.location.href=projectName + '/attach/downFile.do?path=' + hideUrl + '&fileName=' + fileName
	
}




