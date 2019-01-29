<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预览表单</title>
<t:base type="jquery,easyui,layer,DatePicker"></t:base>
<script type="text/javascript" src="designPlug-in/tools/curdtools.js"></script>
<link rel="stylesheet" href="designPlug-in/Validform/css/style.css"	type="text/css" media="all" />
<link href="designPlug-in/easyui-pli/css/base.css" rel="stylesheet">

<link rel="stylesheet" href="designPlug-in/jquery-plugs/gridstack/css/gridstack.css">
<link rel="stylesheet" href="designPlug-in/Validform/css/tablefrom.css" type="text/css"/>


<!-- 地区选择插件 -->
<script type="text/javascript" src="designPlug-in/SelCity/js/Popt.js"></script>
<script type="text/javascript" src="designPlug-in/SelCity/js/citySet.js"></script>
<link href="designPlug-in/SelCity/css/sel.css" rel="stylesheet" media="all">
			
<style type="text/css">
        .grid-stack {
        /*
    background: lightgoldenrodyellow;
    */
}
.grid-stack-item-content {
    color: #2c3e50;
    text-align: center;
    /*
    background-color: #18bc9c;
    */
}
.profile-info-name{
	cursor: auto;
}
</style>

<!-- 地区选择插件 -->
<script type="text/javascript" src="designPlug-in/SelCity/js/Popt.js"></script>
<script type="text/javascript" src="designPlug-in/SelCity/js/citySet.js"></script>
<link href="designPlug-in/SelCity/css/sel.css" rel="stylesheet" media="all">


<script src="designPlug-in/jquery-plugs/gridstack/js/jquery-ui.min.js"></script>
<script src="designPlug-in/jquery-plugs/gridstack/js/bootstrap.min.js"></script>
<script src="designPlug-in/jquery-plugs/gridstack/js/lodash.min.js"></script>
<script src="designPlug-in/jquery-plugs/gridstack/js/knockout-min.js"></script>
<script src="designPlug-in/jquery-plugs/gridstack/js/gridstack.js"></script>
<script src="designPlug-in/design/design.${jsVersion }.js"></script>
<link rel="stylesheet" href="designPlug-in/template/BootstrapFormLayout.css">

</head>
<body >

<div class="htmleaf-container   layui-form">
    <div class="htmleaf-content bgcolor-3">
        <div class="container-fluid">
            <div data-bind="component: {name: 'designMainGrid', params: $data}">
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
$.bussTemplateId="${bussTemplateId }";
$.versionNum="${versionNum }";
$.businessCode="${businessCode }";
$.isEdit=false;
$.getDObject();
$.widgets_=$.getDesignWidgets_(true);
var controller;
var initializeTools_t;


function Controller(widgets) {
    var self = this;
    console.log(widgets);
    self.widgets = ko.observableArray(widgets);
    this.delete_widget = function(item) {
    	myConfirmDialog("您确定要删除吗？", function(){
    	self.widgets.remove(item);
    	layer.msg('删除成功！', {icon: 1});
    	}, function(){
       		return true;
       	},"");
    };
}



$(function() {
	initializeTools_t = window.setInterval("initializeTools()",500);
	
	ko.components.register('designMainGrid', {
	    viewModel: {
	        createViewModel: function(controller, componentInfo) {
	            var ViewModel = function(controller, componentInfo) {
	                var grid = null;
	                this.widgets = controller.widgets;
	                
	                this.afterAddWidget = function(items) {
	                    if (grid == null) {
	                        grid = $(componentInfo.element).find(".grid-stack").gridstack({
	                            auto: false
	                        }).data("gridstack");
	                    }
	                    var item = _.find(items, function(i) {
	                        return i.nodeType == 1
	                    });
	                   var widget_e_= grid.add_widget(item);
	                   var designHtmlObj =$.getDesignHtml($(widget_e_).attr("data-gs-design-id"),$(widget_e_).attr("data-gs-design-type"));
	                   $(widget_e_).find(".grid-stack-item-content").html(designHtmlObj.fieldsHtmls);
	                    ko.utils.domNodeDisposal.addDisposeCallback(item, function() {
	                        grid.remove_widget(item);
	                    });
	                    $(widget_e_).hover(function(){  
	                    	$(widget_e_).find(".field-actions").show(); 
	                    },function(){
	                    	$(widget_e_).find(".field-actions").hide();  
	                    });
	                };
	            };
	            return new ViewModel(controller, componentInfo);
	        }
	    },
	    template: [ '<div class="grid-stack" data-bind="foreach: {data: widgets, afterRender: afterAddWidget}">',
	   				'<div class="grid-stack-item" data-bind="attr: {\'data-gs-x\': $data.x, \'data-gs-y\': ',
	 				'$data.y, \'data-gs-width\': $data.width, \'data-gs-height\': $data.height,',
	 				'\'data-gs-locked\': $data.locked, ',
	  				' \'data-gs-design-id\': $data.design_id, \'data-gs-design-type\': $data.design_type, \'data-gs-auto-position\': $data.auto_position}">',
	   				'<div class="grid-stack-item-content" id="grid-stack-item-content"></div>\n',
	   				''].join('')
	});
	
    controller = new Controller($.widgets_);
    ko.applyBindings(controller);
});

function initializeTools() {
	if($(".ui-draggable").length>0){
		layui.use(['form','laytpl','element','laydate'], function(){
			form = layui.form;
			laytpl = layui.laytpl;
			layui_element = layui.element; //元素操作
			laydate = layui.laydate;
			$("input[class^='Wdate']").each(function(i){
				var $this = $(this);
				laydate.render({
				    elem:".Wdate_"+$this.attr("did"), //指定元素
				    type: $this.attr("tt")=="yymm"?"month":$this.attr("tt")
				 });
			});
		});
		window.clearInterval(initializeTools_t);
	}
}
	
    
</script>
    

 
<style type="text/css">

.profile-user-info{
border: 1px solid #CCCCCC;
}
.select{
border:1px dotted #ff0404;
}
</style>
	
</body>
</html>		