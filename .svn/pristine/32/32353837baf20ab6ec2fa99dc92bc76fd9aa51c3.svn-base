



 
//业务数据来源属性配置
function jumpSet_(){
	var ht="";
	var sv=$("#FieldSetTable #fieldHref").find("option:selected").val();
	if(sv==""){
		layer.msg('请选择数据来源！', {icon: 5});
		return false;
	}
	
	var ppselect = $(".select").closest('.grid-stack-item');
	var inputids = ppselect.find(".dropdiv").attr("design-inputid");
	var selectids = ppselect.find(".dropdiv").attr("design-selectid");
	var zwyyf = ppselect.find(".dropdiv").attr("design-dictfield");
	var sjppf = ppselect.find(".dropdiv").attr("design-dicttext");
	var width=ppselect.find("[design-id]").attr("design-windowwidth");
	var height=ppselect.find("[design-id]").attr("design-windowheight");
	width=(width!=""?width:"500");
	height=(height!=""?height:"500");
	var selectId = ppselect.find("[design-id]").attr("design\-id");
	$.FieldsMap[selectId]["windowWidth"] = width;
	$.FieldsMap[selectId]["windowHeight"] = height;
	ppselect.find("[design-id]").attr("design\-windowheight",height);
	ppselect.find("[design-id]").attr("design\-windowwidth",width);
	
		ht+="<table id='set_table'  style='border-spacing: 1px;border-collapse: inherit;' cellpadding='0' cellspacing='1' class='formtable'>";
		if(ppselect.find(".dropdiv").attr("design-showtype")=="popup"){
			 ht+="<tr><td class='value' style='width:100%;' align='left' colspan='5' > 输入、输出的属性排序决定赋值的顺序，二者应该保持一致</br></td>";
			ht+="</tr>";
			ht+="<tr><td style='width:20%;' align='right'><label class='Validform_label'>弹窗宽度&nbsp;</label></td>";
			ht+="<td class='value'>";
			ht+="<input id='windowWidth' name='windowWidth' type='text' style='width:80%' class='inputxt' value='"+width+"'>";
			ht+="</td><td align='right'><label class='Validform_label'>弹窗高度&nbsp;</label></td>";
			ht+="<td class='value'>";
			ht+="<input id='windowHeight' name='windowHeight' type='text' style='width:80%' class='inputxt' value='"+height+"'>";
			ht+="</td>";
			ht+="</tr>";
			ht+="<tr style='height:50px;'><td align='right' style='width:20%;'><label class='Validform_label'>输入属性&nbsp;</label></td>";
			ht+="<td class='value' colspan='3'><i class='layui-icon' onclick='selectField()'></i>";
			ht+="<div id='inputids_'>";
			ht+=getInputidsHtml(inputids);
			ht+="</div>";
			ht+="</td>";
			ht+="</tr>";
		}
			ht+="<tr style='height:50px;'><td  align='right' style='width:20%;'><label class='Validform_label'>输出属性&nbsp;</label></td>";
			ht+="<td class='value' colspan='3'><i class='layui-icon' onclick='selectBackField()'></i>";
			ht+="<div id='selectIds_'>";
			ht+=getBackFieldsHtml(selectids);
			ht+="</div>";
			ht+="</td>";
			ht+="</tr>";
			if(ppselect.find(".dropdiv").attr("design-showtype")!="v_formFileByGroup"){
				ht+="<tr style='height:50px;'><td align='right' style='width:20%;'><label class='Validform_label'>中文引用字段&nbsp;</label></td>";
				ht+="<td class='value' colspan='3'><i class='layui-icon' onclick='selectZWYYField()'></i>";
				ht+="<div id='zwyyf_'>";
				ht+=getZWYYFHtml(zwyyf);
				ht+="</div>";
				ht+="</td>";
				ht+="</tr>";
				ht+="<tr style='height:50px;'><td align='right' style='width:20%;'><label class='Validform_label'>数据匹配字段&nbsp;</label></td>";
				ht+="<td class='value' colspan='3'><i class='layui-icon' onclick='selectSJPPField()'></i>";
				ht+="<div id='sjppf_'>";
				ht+=getSJPPFHtml(sjppf);
				ht+="</div>";
				ht+="</td>";
				ht+="</tr>";
			}
			ht+="</table>";
	var open1=layer.open({
		  type: 1,
		  skin: '', //加上边框
		  title:"参数配置",
		  btn: ['关闭'],
		  area: ['520px', '400px'], //宽高
		  content: ht
		});
	$("#set_table").on("input", "input[type=text]", function() {
		var selectId = ppselect.find("[design-id]").attr("design\-id");
		$.FieldsMap[selectId][$(this).attr("name")] = $(this).val();
		ppselect.find("[design-id]").attr("design\-"+$(this).attr("name"),$(this).val());
		$("body").attr("onbeforeUnload","return '';");
	});
}

function getInputidsHtml(inputids){
	var ht="";
	if(inputids!=""){
		for(var q=0;q<inputids.split(",").length;q++){
			var w=inputids.split(",")[q];
			if(w!=""){
				var stext=$("[id='"+w+"']").closest('.grid-stack-item').find("text_content").text();
				if($("[id='"+w+"']").attr("type")=="hidden"){
					stext+="-隐藏的值";
				} else if($("[id='"+w+"']").attr("id").length>7&&$("[id='"+w+"']").attr("id").substring(0,7)=="showName_"){
					stext+="-显示的值";
				}
				ht+="<span class='layui-badge layui-bg-green' style='margin: 5px;border-radius: 5px;'>"+stext+"</span>";
			}
		}
	}
	return ht;
}

function getZWYYFHtml(selectids){
	var subdata=$("#FieldSetTable #fieldHref").find("option:selected").attr("subdata");
	var ht="";
	if(selectids!=""){
		if(subdata!=""){
			var subdata1=subdata.split("@");
			for(var a=0;a<subdata1.length;a++){
				if(selectids==subdata1[a].split("#")[0]){
					ht+="<span class='layui-badge layui-bg-green' style='margin: 5px;border-radius: 5px;'>"+subdata1[a].split("#")[1]+"</span>";
				}
			}
		}
	}
	return ht;
}

function getSJPPFHtml(selectids){
	var subdata=$("#FieldSetTable #fieldHref").find("option:selected").attr("subdata");
	var ht="";
	if(selectids!=""){
		if(subdata!=""){
			var subdata1=subdata.split("@");
			for(var a=0;a<subdata1.length;a++){
				if(selectids==subdata1[a].split("#")[0]){
					ht+="<span class='layui-badge layui-bg-green' style='margin: 5px;border-radius: 5px;'>"+subdata1[a].split("#")[1]+"</span>";
				}
			}
		}
	}
return ht;
}


function getBackFieldsHtml(selectids){
	var subdata=$("#FieldSetTable #fieldHref").find("option:selected").attr("subdata");
	var ht="";
	if(selectids!=""){
		for(var q=0;q<selectids.split(",").length;q++){
			var w=selectids.split(",")[q];
			if(w!=""){
				if(subdata!=""){
					var subdata1=subdata.split("@");
					for(var a=0;a<subdata1.length;a++){
						if(subdata1[a].split("#").length>1&&w==subdata1[a].split("#")[0]){
							ht+="<span class='layui-badge layui-bg-green' style='margin: 5px;border-radius: 5px;'>"+subdata1[a].split("#")[1]+"</span>";
						}
					}
				}
			}
		}
	}
	return ht;
}

function selectZWYYField(){
	var s_dropdiv=$(".select").closest('.grid-stack-item').find(".dropdiv");
	var ppselect = s_dropdiv.attr("design-dictfield");
	var subdata=$("#FieldSetTable #fieldHref").find("option:selected").attr("subdata");
	var f1="";
	f1+="<div class='layui-form' lay-filter='selectZWYYField'>";
	if(subdata!=""){
		var subdata1=subdata.split("@");
		for(var a=0;a<subdata1.length;a++){
			if(subdata1[a].split("#").length>1){
				f1+="<div class='layui-col-md3' style='margin:5px;'>";
				f1+="<input type='checkbox' lay-filter='myselect' id='SELECT_CK_"+subdata1[a].split("#")[0]+"' name='"+subdata1[a].split("#")[1]+"' value='"+subdata1[a].split("#")[0]+"'  title='"+subdata1[a].split("#")[1]+"'>";
				f1+="</div>";
			}
		}
	}
	f1+="</div>";
	var open2=layer.open({
		  type: 1,
		  skin: '', //加上边框
		  title:"字段选择",
		  btn: ['确定'],
		  area: ['400px', '300px'], //宽高
		  content: f1
		});
	
	if(ppselect!=""){
		for(var q=0;q<ppselect.split(",").length;q++){
			var w=ppselect.split(",")[q];
			if(w!=""){
				$("[id='SELECT_CK_"+w+"']").attr("checked",true);
			}
		}
	}
	form.render(null, 'selectZWYYField');//重新渲染
	form.on("checkbox(myselect)", function(data){
		var selectids = s_dropdiv.attr("design-dictfield");
		var sv=data.value;
		if(!data.elem.checked){
			sv="";
		}
			s_dropdiv.attr("design-dictfield",sv);
		selectids = s_dropdiv.attr("design-dictfield");
		var designId=s_dropdiv.attr("design-id");
		var selectidsHtml=getBackFieldsHtml(selectids);
		$("#zwyyf_").html(selectidsHtml); 
		$.FieldsMap[designId]["dictField"] = selectids;
		$("body").attr("onbeforeUnload","return '';");
	});
}

function selectSJPPField(){
	var s_dropdiv=$(".select").closest('.grid-stack-item').find(".dropdiv");
	var ppselect = s_dropdiv.attr("design-dicttext");
	var subdata=$("#FieldSetTable #fieldHref").find("option:selected").attr("subdata");
	var f1="";
	f1+="<div class='layui-form' lay-filter='selectSJPPField'>";
	if(subdata!=""){
		var subdata1=subdata.split("@");
		for(var a=0;a<subdata1.length;a++){
			if(subdata1[a].split("#").length>1){
				f1+="<div class='layui-col-md3' style='margin:5px;'>";
				f1+="<input type='checkbox' lay-filter='myselect' id='SELECT_CK_"+subdata1[a].split("#")[0]+"' name='"+subdata1[a].split("#")[1]+"' value='"+subdata1[a].split("#")[0]+"'  title='"+subdata1[a].split("#")[1]+"'>";
				f1+="</div>";
			}
		}
	}
	f1+="</div>";
	var open2=layer.open({
		  type: 1,
		  skin: '', //加上边框
		  title:"字段选择",
		  btn: ['确定'],
		  area: ['400px', '300px'], //宽高
		  content: f1
		});
	
	if(ppselect!=""){
		for(var q=0;q<ppselect.split(",").length;q++){
			var w=ppselect.split(",")[q];
			if(w!=""){
				$("[id='SELECT_CK_"+w+"']").attr("checked",true);
			}
		}
	}
	form.render(null, 'selectSJPPField');//重新渲染
	form.on("checkbox(myselect)", function(data){
		var selectids = s_dropdiv.attr("design-dicttext");
		var sv=data.value;
		if(!data.elem.checked){
			sv="";
		}
		s_dropdiv.attr("design-dicttext",sv);
		
		selectids = s_dropdiv.attr("design-dicttext");
		var designId=s_dropdiv.attr("design-id");
		var selectidsHtml=getBackFieldsHtml(selectids);
		$("#sjppf_").html(selectidsHtml);
		$.FieldsMap[designId]["dictText"] = selectids;
		$("body").attr("onbeforeUnload","return '';");
	});
}

function selectBackField(){
	var s_dropdiv=$(".select").closest('.grid-stack-item').find(".dropdiv");
	var ppselect = s_dropdiv.attr("design-selectid");
	var subdata=$("#FieldSetTable #fieldHref").find("option:selected").attr("subdata");
	var f1="";
	f1+="<div class='layui-form' lay-filter='selectBackField'>";
	if(subdata!=""){
		var subdata1=subdata.split("@");
		for(var a=0;a<subdata1.length;a++){
			if(subdata1[a].split("#").length>1){
				f1+="<div class='layui-col-md3' style='margin:5px;'>";
				f1+="<input type='checkbox' lay-filter='myselect' id='SELECT_CK_"+subdata1[a].split("#")[0]+"' name='"+subdata1[a].split("#")[1]+"' value='"+subdata1[a].split("#")[0]+"'  title='"+subdata1[a].split("#")[1]+"'>";
				f1+="</div>";
			}
		}
	}
	f1+="</div>";
	var open2=layer.open({
		  type: 1,
		  skin: '', //加上边框
		  title:"字段选择",
		  btn: ['确定'],
		  area: ['400px', '300px'], //宽高
		  content: f1
		});
	
	if(ppselect!=""){
		for(var q=0;q<ppselect.split(",").length;q++){
			var w=ppselect.split(",")[q];
			if(w!=""){
				$("[id='SELECT_CK_"+w+"']").attr("checked",true);
			}
		}
	}
	form.render(null, 'selectBackField');//重新渲染
	form.on("checkbox(myselect)", function(data){
		var selectids = s_dropdiv.attr("design-selectid");
		var sv=data.value+",";
		if(!data.elem.checked){
			selectids=selectids.replace(sv,"");
			sv="";
		}
		if(selectids!=""){
			s_dropdiv.attr("design-selectid",selectids+sv);
		}else{
			s_dropdiv.attr("design-selectid",sv);
		}
		selectids = s_dropdiv.attr("design-selectid");
		var designId=s_dropdiv.attr("design-id");
		var selectidsHtml=getBackFieldsHtml(selectids);
		$("#selectIds_").html(selectidsHtml); 
		$.FieldsMap[designId]["selectId"] = selectids;
		$("body").attr("onbeforeUnload","return '';");
	});
}

function selectField(){
	var s_dropdiv=$(".select").closest('.grid-stack-item').find(".dropdiv");
	var ppselect = s_dropdiv.attr("design-inputid");
	var f1="";
	f1+="<div class='layui-form' lay-filter='selectField'>";
	$(".grid-stack-item").each(function(index,element1){
		$(element1).find("input,textarea,select").each(function(index,element2){
			if($(element2).attr("id")!=undefined){
				var stext=$(element1).find("text_content").text();
				f1+="<div class='layui-col-md3' style='margin:5px;'>";
				if($(element2).attr("type")=="hidden"){
					stext+="-隐藏的值";
				}else if($(element2).attr("id").length>7&&$(element2).attr("id").substring(0, 7)=="showName_"){
					stext+="-显示的值";
				}
				f1+="<input type='checkbox' lay-filter='mych' id='CK_"+$(element2).attr("id")+"' name='"+$(element1).find("text_content").text()+"' value='"+$(element2).attr("id")+"'  title='"+stext+"'>";
				f1+="</div>";
			}
		});
	  });
	f1+="</div>";
	var open2=layer.open({
		  type: 1,
		  skin: '', //加上边框
		  title:"字段选择",
		  btn: ['确定'],
		  area: ['50%', '50%'], //宽高
		  content: f1
		});
	
	if(ppselect!=""){
		for(var q=0;q<ppselect.split(",").length;q++){
			var w=ppselect.split(",")[q];
			if(w!=""){
				$("[id='CK_"+w+"']").attr("checked",true);
			}
		}
	}
	form.render(null, 'selectField');//重新渲染
	form.on("checkbox(mych)", function(data){
		var inputids = s_dropdiv.attr("design-inputid");
		var sv=data.value+",";
		if(!data.elem.checked){
			inputids=inputids.replace(sv,"");
			sv="";
		}
		if(inputids!=""){
			s_dropdiv.attr("design-inputid",inputids+sv);
		}else{
			s_dropdiv.attr("design-inputid",sv);
		}
		inputids = s_dropdiv.attr("design-inputid");
		var designId=s_dropdiv.attr("design-id");
		var inputidsHtml=getInputidsHtml(inputids);
		$("#inputids_").html(inputidsHtml); 
		$.FieldsMap[designId]["inputId"] = inputids;
		$("body").attr("onbeforeUnload","return '';");
	});
}




function setFormDataMap(){
	layui_element.on('tab(docDemoTabBrief)', function(data){
		  if($(this).attr("lay-id")=="formSet"){
			  setFormDataMap()
		  }
	});
	
	laytpl.fn = function(f,id){
		if(f!=undefined ){
			eval(f+"(id)");
		}
	}
	
	var getTpl = document.getElementById('Tdemo').innerHTML;
	laytpl(getTpl).render($.FormData, function(html){
		window.clearInterval(setFormDataMap_t); 
		document.getElementById('FormDataTable').innerHTML=html;
		$.each($.FormDataMap, function(n,node) {
			var ew= $("#FormDataTable").find("#"+n).length;
			if(ew>0){
				$("#FormDataTable").find("#"+n).val(node);
			}
		});
	});
	try{
		$.designBinding();
	}catch(e){
	}
}

function getSelectList(id){
	var selectList=[];
	$.ajax({
	    async: false,
	    cache: false,
	    type: 'GET',
	    url: "designController.do?getSelectList", // 请求的action路径
	    error: function() { // 请求失败处理函数
	    },
	    success: function(data) {
	    	selectList=data;
	    }
	});
	return selectList;
}

$("#tab_right").height((document.body.clientHeight-148));