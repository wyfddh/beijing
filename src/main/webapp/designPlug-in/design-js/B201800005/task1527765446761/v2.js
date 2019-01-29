/**
 * 
 * 

//页面表单数据保存方法-----start------
$.saveData(true) //true:是否刷新当前页面
//页面表单数据保存方法-----end------

//父页面表单数据保存方法-----start------
parent.$.saveData(true) //true:是否刷新当前页面
//父页面表单数据保存方法-----end------
//提交审批流程-----start------
$.submitBusiness();
//提交审批流程-----end------


$("#").click(function(){
       	
      });


//页面鼠标提示信息方法-----------start--------------------
$(function() {
	$("input").each(function(i,obj) {
	var fieldAlert= $(obj).attr("fieldAlert");
	if(fieldAlert!=""&&fieldAlert!=null){
		$(obj).click(function(){
			layer.tips(fieldAlert, $(obj),{
			  tips: [1, '#0FA6D8'], //还可配置颜色
			  time: 4000
			});
		});
	   }
	});
	$("textarea").each(function(i,obj) {
	var fieldAlert= $(obj).attr("fieldAlert");
	if(fieldAlert!=""&&fieldAlert!=null){
		$(obj).click(function(){
			layer.tips(fieldAlert, $(obj),{
			  tips: [1, '#0FA6D8'], //还可配置颜色
			  time: 4000
			});
		});
	   }
	});
});
//页面鼠标提示信息方法-----------end--------------------




 * 
 * 
 * 
*/


$(function() {
$("#B201800005\\@T15272276910005267").click(function(){
       	$.saveData(true);
      });
$("#B201800005\\@T15272276910007628").click(function(){
       	window.colse();
      });
});

function clickcallback_B201800005_cartype_id(newindex_,layero, index){
	$(layero.find('iframe')[0]).attr("name",layero.find('iframe')[0]['id']);
		//var iframeWin = window[layero.find('iframe')[0]['name']];
		var iframeWin = $(layero).find('iframe')[0].contentWindow;
		console.log(iframeWin);
		//调用授权提交方法
	    var nodes = iframeWin.getSNode();
	    console.log(JSON.stringify(nodes));
	    if(nodes){//获得ztree对象中的值
	        $("#B201800005\\@cartype_id").val(nodes[0].id);
	        $("#showName_B201800005_cartype_id").val(nodes[0].name);
	    }else{
			parent.layer.msg('请选择！', {icon: 5});
	        return;
		}
	}

function clearAll__B201800005_cartype_id(index_){
	$("#_B201800005\\@cartype_id").val("");
	$("#showName_B201800005_cartype_id").val("");
}

function clickcallback_B201800005_carinfo_id(newindex_,layero, index){
	$(layero.find('iframe')[0]).attr("name",layero.find('iframe')[0]['id']);
		//var iframeWin = window[layero.find('iframe')[0]['name']];
		var iframeWin = $(layero).find('iframe')[0].contentWindow;
		//调用授权提交方法
	    var nodes = iframeWin.getSNode();
	     console.log(JSON.stringify(nodes));
	    if(nodes){//获得ztree对象中的值
	        $("#B201800005\\@carinfo_id").val(nodes[0].id);
	        $("#showName_B201800005_carinfo_id").val(nodes[0].name);
			$("#B201800005\\@cost").val(nodes[0].otherParaTwo);
			$("#B201800005\\@driver").val(nodes[0].otherParaOne);
	    }else{
			parent.layer.msg('请选择！', {icon: 5});
	        return;
		}
	}

function clearAll__B201800005_carinfo_id(index_){
	$("#_B201800005\\@carinfo_id").val("");
	$("#showName_B201800005_carinfo_id").val("");
	$("#B201800005\\@cost").val("");
	$("#B201800005\\@driver").val("");
}