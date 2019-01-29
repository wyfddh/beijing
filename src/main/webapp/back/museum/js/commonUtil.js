    
	//校验input[type=text]，select，textarea有没有填,将需要校验的字段加上typeOne的class，len为单选框的个数
	function checkFullCom(count){
		var num = 0;
		$(".typeOne").each(function(){
			var a = this.value;
			if(a ==null || a==""){
				num++;
			}
		})
		//页面所有的单选框选中的个数
		var len=$("input[type='radio']:checked").length;
		
		if(num>0 || len !=count){
			return false;
		}else{
			return true;
		}
	}
	
	
function isFull(len){
		 var params = $("input[type!='hidden'],select,textarea").serializeArray();
		 var count=$("input[type='radio']:checked").length+$("input[type='checkbox']:checked").length;
		 var num = 0;
		 for( i in params ){
		 	if(params[i].value == "" || params[i].value == null){
		 		num++;
		 	}
		 }
		 if(num==0 && count>=len){
			 return "1";
		 }else{
			 return "0";
		 }
	}
	
	var inputsData=[];
	var textareasData=[];
	var selectsData=[];

	//页面编辑数据
	function initFileds(){
	    // 记录下表单中的原始值
	       var inputs = $("input[type!=hidden][type!=file]");
	       var textareas = $("textarea:visible");
	       var selects = $("select[type!=hidden]");
	       inputsData = new Array(inputs.length);
	       for (var i=0;i<inputs.length;i++) {
	           inputsData[i] = inputs[i].value;
	           if (inputs[i].type=="radio" || inputs[i].type=="checkbox" ) {
	               inputsData[i]=inputs[i].checked;
	           }
	       }
	       textareasData = new Array(textareas.length);
	       for (var i=0;i<textareas.length;i++) {
	           textareasData[i] = textareas[i].value;
	       }
	       selectsData = new Array(selects.length);
	       for (var i=0;i<selects.length;i++) {
	           selectsData[i] = selects[i].value;
	       }
	}
	/*
	 * 判断表单中值是否被修改了
	 * submitCommand 表单有改动时,执行的javascript代码
	 */
	function checkModification() {
	    var inputs = $("input[type!=hidden][type!=file]");
	    var textareas = $("textarea:visible");
	    var selects = $("select[type!=hidden]");
	    var hasBeenChanged = false;
	    if(inputs.length != inputsData.length || textareas.length != textareasData.length || selects.length !=selectsData.length){
	    	return true;
	    }
	    for (var i=0;i<inputsData.length;i++) {
	        if ((inputs[i].type=="radio" || inputs[i].type=="checkbox")&&(inputs[i].checked!=inputsData[i])) {
	            hasBeenChanged = true;
	            break;
	        }
	        if (inputs[i].type!="radio" && inputs[i].type!="checkbox" && inputsData[i]!=inputs[i].value) {
	            hasBeenChanged = true;
	            break;
	        }
	    }
	    for (var i=0;i<textareasData.length;i++) {
	        if (textareasData[i]!=textareas[i].value) {
	            hasBeenChanged = true;
	            break;
	        }
	    }
	    for (var i=0;i<selectsData.length;i++) {
	        if (selectsData[i]!=selects[i].value) {
	            hasBeenChanged = true;
	            break;
	        }
	    }
	    return hasBeenChanged;
	}
