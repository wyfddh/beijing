<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<!DOCTYPE html >
<html >
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表单设计| ${title }</title>
<t:base type="jquery,easyui,DatePicker,layer"></t:base>

<!-- 树形插件 -->
<link rel="stylesheet" href="designPlug-in/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="designPlug-in/zTree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="designPlug-in/zTree/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="designPlug-in/zTree/js/fuzzysearch.js"></script>
<script type="text/javascript" src="designPlug-in/zTree/js/jquery.ztree.exhide-3.5.js"></script>

<!-- 表单验证插件 -->
<link rel="stylesheet" href="designPlug-in/Validform/css/style.css"	type="text/css" media="all" />

<!-- 按钮图标插件 -->
<link href="designPlug-in/easyui-pli/css/base.css" rel="stylesheet">

 
<!-- js编辑插件 -->
<link rel="stylesheet" href="designPlug-in/codemirror/codemirror.css">
<script src="designPlug-in/codemirror/codemirror.js"></script>
<script src="designPlug-in/codemirror/xml.js" type="text/javascript"></script>
<script src="designPlug-in/codemirror/codemirror.js"></script>


<link rel="stylesheet" href="designPlug-in/template/BootstrapFormLayout.css">
<link rel="stylesheet" href="designPlug-in/jquery-plugs/gridstack/css/gridstack.css">
<link rel="stylesheet" href="designPlug-in/jquery-plugs/gridstack/css/design-font.css">
<link rel="stylesheet" href="designPlug-in/jquery-plugs/gridstack/css/jquery.contextMenu.css">
<link rel="stylesheet" href="designPlug-in/layui-2.3.0/css/global.css">
<script type="text/javascript">
var layui_element,form,laytpl,laydate;
</script>
<link rel="stylesheet" type="text/css"	href="designPlug-in/help/introjs.css" />
<script type="text/javascript" src="designPlug-in/help/introjs.js"></script>

</head>
<body class="easyui-layout" onbeforeUnload="" >
<!-- 
<div region="north" border="false"  title=""  style="background-color: #235FBA;height:35px; padding:0px; overflow: hidden;" >
    <div style="margin:5px 0 0 20px ;font-size: 20px;color: #fff;font-weight: 700;">表单设计器</div>
</div>
 -->
<div region="west" id="design_left" 
title="控件选择" style="overflow-y: hidden;width:235px;padding:0px;height: 100%;"
  href="designController.do?designLeft&defineId=${defineId}&type=${type }"
 split="true"    >
</div>
<div region="north"  id="design_north"  split="false" title="" style="overflow-y: hidden;height:54px;padding:1px;">
		<div type="button" class="layui-btn layui-btn-danger" onclick="saveHtml()" style="margin:5px;" >
			<i class="design-icon-saveToKnowledge"></i>
			保存
		</div>
		<div type="button" class="layui-btn layui-btn-normal" onclick="designPreviewHtml()"  style="margin:5px;">
			<i class="design-icon-dynamicDisplay"></i>
			预览
		</div>
		<div type="button" class="layui-btn layui-btn-normal" onclick="initHelp('1','${type }');"  style="margin:5px;">
			<i class="design-icon-help_outline"></i>
			再看一次介绍
		</div>
		<div type="button" class="layui-btn layui-btn-normal" onclick="window.close()"  style="margin:5px;">
			<i class="design-icon-closeelement-bg-circle"></i>
			关闭
		</div>
		<%--
		<a href="#" class="easyui-linkbutton" icon="icon-save" onclick="saveHtml()" plain="true">保存设置</a>
		<a href="#" class="easyui-linkbutton" icon="icon-html" onclick="viewHtml()" plain="true">查看HTML</a>
		--%>
		<%--<a href="#" class="easyui-linkbutton" icon="icon-js" onclick="saveUserDefinedJsMethod()" plain="true">自定义JS</a>
		
		<a href="#" class="easyui-linkbutton" icon="icon-search" onclick="designPreviewHtml()" plain="true">预览</a>
		<a href="#" class="easyui-linkbutton" icon="icon-add1" title="全部到设计区域" onclick="allFiledAdd()" plain="true">全部添加</a>
		<a href="#" class="easyui-linkbutton" icon="icon-delete" title="全部移除，重新逐个添加" onclick="allFiledRemove()" plain="true">全部移除</a>
	--%>
</div>
<div region="center" id="design_center" style="overflow-y:auto;padding:1px;" 
href="designController.do?designCenter&type=${type }&defineId=${defineId}&businessCode=${businessCode }&bussTemplateId=${bussTemplateId }&versionNum=${versionNum }"
 split="true"  >
</div>
<div region="east" id="design_right"  href="designController.do?designRight" 
iconCls="icon-reload" title="属性设置" split="true" style="overflow: hidden;width:254px;" >
</div>

<script type="text/javascript">
//阻止浏览器默认右键点击事件

//setInterval("saveHtml()","120000");//每隔2分钟执行一次saveHtml()函数，执行无数次。

var editor=null;
function mConfig(){
saveHtml('false');
layer.open({
	  type: 2,
	  title:"配置主列表",
	  shadeClose: false, //开启遮罩关闭
	  area: ["90%", "90%"], //宽高
	  content: "designController.do?mconfigure&versionNum=${versionNum }&bussTemplateId=${bussTemplateId}&bussCode=${businessCode }",
	  btn: ['保存','关闭']
	,yes: function(index, layero){
		var form1= parent.layer.getChildFrame("form", index);
           $.ajax({
               type: "POST",
               url: $(form1).attr("action"),
               data: $(form1).serialize(),
               success: function (data) {
               	parent.layer.close(index); //如果设定了yes回调，需进行手工关闭
               	parent.layer.msg('操作成功！', {icon: 1});
               	window.location.reload();
               },
               error: function(data) {
               	parent.layer.msg("error:"+data.responseText, {icon: 5});
               }
           });
	  }
	  ,cancel: function(){}
	});
}

function allFiledMandatory(){
	layer.load();
	/**
	var grid = $("#designMainGrid_show").find('.grid-stack').data('gridstack');
	$(".grid-stack-item").each(function(index,ths) {
        var el = $(ths);
        try {
        	$.FieldsMap[el.attr("data-gs-design-id")].isShow="N";//设置表单显示为 不显示
        	grid.remove_widget(el);
        } catch (e) {}
    });
	*/
	loadHideForm();//刷新左侧隐的表单不显示字段
	layer.closeAll('loading');
}

function allFiledAdd(){
	layer.load();
	$("#hideFormFieldDiv .my-control").each(function(index,ths) {
        $(ths).click();
    });
	loadHideForm();//刷新左侧隐的表单不显示字段
	layer.closeAll('loading');
}

function allFiledReadOnly(){
	layer.load();
	loadHideForm();//刷新左侧隐的表单不显示字段
	layer.closeAll('loading');
}


function allFiledRemove(){
	layer.load();
	var grid = $("#designMainGrid_show").find('.grid-stack').data('gridstack');
	$(".grid-stack-item").each(function(index,ths) {
        var el = $(ths);
        try {
        	$.FieldsMap[el.attr("data-gs-design-id")].isShow="N";//设置表单显示为 不显示
        	grid.remove_widget(el);
        } catch (e) {}
    });
	loadHideForm();//刷新左侧隐的表单不显示字段
	layer.closeAll('loading');
}


function saveHtml(isAlertMsg){
	layer.load();
	var serialized_data = _.map($("#designMainGrid_show").find(".grid-stack > .grid-stack-item:visible"), function (el) {
        el = $(el);
        var node = el.data("_gridstack_node");
        return {
            x: node.x,
            y: node.y,
            width: node.width,
            design_id: el.attr("data-gs-design-id"),
            height: node.height
        };
    }, this);
	 var is_=true;
	$.each(serialized_data, function(n,node) {
		$.FieldsMap[node.design_id]["x"]=node.x;
        $.FieldsMap[node.design_id]["y"]=node.y;
        $.FieldsMap[node.design_id]["w"]=node.width;
        $.FieldsMap[node.design_id]["h"]=node.height;
        if($.FieldsMap[node.design_id]["showType"]=="v_formDetailed"){
        	if($.FieldsMap[node.design_id]["linkBussCode"]==""){
				layer.msg('明细表单中未关联业务编码',{icon: 4});
				 is_=false;
        	}
			if($.FieldsMap[node.design_id]["mainField"]==""){
				layer.msg('明细表单中未关联主表字段，请选择关联主表字段',{icon: 4});
				 is_=false;
        	}
        	if($.FieldsMap[node.design_id]["detailField"]==""){
        		layer.msg('明细表单中未关联明细表字段',{icon: 4});
        		 is_=false;
        		 
        	}
        }
    	});
	if(!is_){
		layer.closeAll('loading');
		return false;
	}
	
	$.ajax({
		async : true,
		cache : false,
		type : 'POST',
		data : {FieldsMap:JSON.stringify($.FieldsMap),FormDataMap:JSON.stringify($.FormDataMap)},
		url : "designController.do?saveJson&defineId=${defineId}&businessCode=${businessCode }&bussTemplateId=${bussTemplateId }&versionNum=${versionNum }",// 请求的action路径
		error : function() {// 请求失败处理函数
			if(isAlertMsg==''||isAlertMsg==null||isAlertMsg=='undifine'){
				layer.msg('保存失败',{icon: 4});
			}
			layer.closeAll('loading');
		},
		success : function(data) {
			//console.log(isAlertMsg);
			var data0=eval("("+data+")");
			if(isAlertMsg==''||isAlertMsg==null||isAlertMsg=='undifine'){
				layer.msg('保存成功',{icon: 1});
				$("body").attr("onbeforeUnload","");
			}
			if(data0.defineCode!=""){
				window.location.href="designController.do?design&type=2&businessCode="+data0.defineCode;
			}
			layer.closeAll('loading');
			
		}
	});
}
	
function viewHtml(){
	layer.open({
		  type: 1,
		  title:"查看HTML",
		  shadeClose: false, //开启遮罩关闭
		  area: ["60%", "80%"], //宽高
		  content: "<textarea id='demotext__' style='display: none' ></textarea>",
		  btn: ['保存','关闭']
		,yes: function(index, layero){
		       alert("正在建设");
		  }
		  ,cancel: function(){}
		});
		
	$("#demotext__").val($(".htmleaf-content").html());
	layer.load(0, {time: 2000});
	setTimeout(function(){
		var editor = CodeMirror.fromTextArea(document.getElementById("demotext__"), {
		    lineNumbers: true,
		    mode: "text/xml",
		    matchBrackets: true,
		    lineWrapping: true
		  });
		},2000);
}

function saveUserDefinedJsMethod(){
	layer.open({
		  type: 1,
		  title:"自定义JS",
		  shadeClose: false, //开启遮罩关闭
		  area: ["90%", "90%"], //宽高
		  content: "<textarea id='UserDefinedJsText__' style='display: none' ></textarea>",
		  btn: ['保存','关闭']
		,yes: function(index, layero){
			  saveJsHtml();
		  }
		  ,cancel: function(){}
		});
	
		//通过ajax获取js文件
		$.ajax({
			async : false,
			cache : false,
			type : 'GET',
			url : "designController.do?getUserDefinedJsTextData&nodeCode=${nodeCode}&businessCode=${businessCode}&versionNum=${versionNum }",// 请求的action路径
			error : function() {// 请求失败处理函数
			},
		    success: function (data) {
		    	var UserDefinedJsHtml = data.UserDefinedJsText;
		    	$("#UserDefinedJsText__").val(UserDefinedJsHtml);
		    	layer.load(0, {time: 2000});
		    	setTimeout(function(){
		    		editor = CodeMirror.fromTextArea(document.getElementById("UserDefinedJsText__"), {
		    		    lineNumbers: true,
		    		    mode: "text/xml",
		    		    matchBrackets: true,
		    		    lineWrapping: true
		    		  });
		    		},2000);
		    },
		    error: function(data) {
		    	parent.layer.msg("error:"+data.responseText, {icon: 5});
		    }
		});
}

function saveJsHtml(){
	//alert($(".CodeMirror-code").text());
	//console.log(editor.getValue());
    $.ajax({
  	  async : false,
        type: "POST",
        url: "designController.do?updateUserDefinedJsTextData&nodeCode=${nodeCode}&businessCode=${businessCode}&versionNum=${versionNum }",
        data:{jsText:editor.getValue()},
        success: function (data) {
      	  if(data.msg=="0"){
      		  //保存失败
      		  layer.msg('保存失败',{icon: 1});
      	  }else{
      		  layer.msg('保存成功',{icon: 1});
      	  }
        },
        error: function(data) {
        	parent.layer.msg("error:"+data.responseText, {icon: 5});
        }
    });
}

function designPreviewHtml(){
	saveHtml();
	window.open("designController.do?designPreviewHtml&defineId=${defineId }&businessCode=${businessCode }&bussTemplateId=${bussTemplateId }&versionNum=${versionNum }");
}



</script>



</body>
</html>		

