<!DOCTYPE html>
<html style="background-color: #f6f6f6;">
<head>
<title>${taskDefName}

</title> 
${config_iframe_head }


</head>
 <body >
<div  style="background-color: #fff;" class="row"  id="processNodeActionBtn">
</div>


${config_iframe_bottom }

<div  style="margin-bottom: 10px;background-color: #fff;" class="row mainbody"  id="mainGrid_">
<form method="post" action="" class="registerform " id="mainPageForm" name="mainPageForm">
	 <div id="designMainGrid_show" style="position: relative;">
		<div  class="htmleaf-container  layui-form" style="background-color: #FFFFFF;padding: 0 10px 10px 10px;">
		    <div class="htmleaf-content bgcolor-3">
			<div class="container-fluid">
			    <div data-bind="component: {name: 'designMainGrid', params: $data}">
			    </div>
			</div>
		    </div>
		</div>
	</div>
	<div id="designMainGrid_hide_"  style="display: none;">
		<div class="htmleaf-container myhide">
		    <div class="htmleaf-content bgcolor-3">
			<div class="container-fluid">
			    <div data-bind="component: {name: 'designMainGrid_hide', params: $data}">
			    </div>
			</div>
		    </div>
		</div>
	</div>
</form>

</div>
<div class="my-menu-center menu">
<div id="myMenu"></div>
</div>
<!--
<div class="bottom-wrap">
        <a class="toggle-button" onclick="if($('.side-catalog').is(':hidden')){$('.side-catalog').show(500);$(this).text('收起');}else{$('.side-catalog').hide(500);$(this).text('展开');}" href="javascript:void(0);"></a>
</div>
<div class="side-catalog" style="visibility: visible; bottom: 160px;right: 0px;margin-right: 20px;border: 1px solid #CCCCCC;">
    <div class="side-bar">
	<em class="circle start"></em>
	<em class="circle end"></em>
    </div>
    <div class="catalog-scroller">
	<dl class="catalog-list" id="${businessCode}catalogScrollerHtml">
		
	    
	</dl>
    </div>
</div>
-->



<script type="text/javascript">
if("${status}"!="1"){
alert('未发布的业务不允许填写数据！');
window.close();
}


var isclean=0;
var setBussObj_t,setAttachObj_t;
var controller;
var controller_hide;


$(function() {
	$.bussTemplateId="${bussTemplateId }";
	$.versionNum="${versionNum }";
	$.businessCode="${businessCode }";
	$.releaseCode="${releaseCode }";
	$.formServerUrl="";
	$.oaServerUrl="";
	$.otherParameters="${otherParameters}";
	$.isEdit=false;
	$.isEnd="${isEnd}";//流程结束标记
	$.mainId="${mainId}";
	$.taskId="${taskId}";
	$.configformId="${configformId}";
	$.Loading({type:"html",speed:200,loadPicNum:2,msg:"正在加载元素...",autoHide:false});
	<#if processKey!=''>
	//获得流程中配置的表单集合----------start--------
	$.getProcessNodeAction("${id}","","${businessCode}");
	//获得流程中配置的表单集合----------end--------
	</#if>
	<#if isEnd=='true'>
	$.getEndButton();
	</#if>
	$.windowResize();
	$.getDObject();
	$.widgets_=$.getDesignWidgets_(true);
	$.widgets_hide=$.getDesignWidgets_hide(true);
	setBussObj_t = window.setInterval("setBussDataObj_()",500);
	setAttachObj_t = window.setInterval("setAttachDataObj_()",500);




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
                };
            };
            return new ViewModel(controller, componentInfo);
        }
    },
    template: [ '<div class="grid-stack" data-bind="foreach: {data: widgets, afterRender: afterAddWidget}">',
   				'<div class="grid-stack-item" data-bind="attr: {\'data-gs-x\': $data.x, \'data-gs-y\': $data.y,',
				'\'data-gs-locked\': $data.locked, ',
 				' \'data-gs-width\': $data.width, \'data-gs-height\': $data.height,',
  				' \'data-gs-design-id\': $data.design_id, \'data-gs-design-type\': $data.design_type, \'data-gs-auto-position\': $data.auto_position}">',
   				'<div class="grid-stack-item-content" id="grid-stack-item-content"></div>\n',
   				''].join('')
});


    
    controller = new Controller($.widgets_);
    ko.applyBindings(controller,document.getElementById("designMainGrid_show"));





ko.components.register('designMainGrid_hide', {
    viewModel: {
        createViewModel: function(controller_hide, componentInfo) {
            var ViewModel_hide = function(controller_hide, componentInfo) {
                var grid = null;
                this.widgets = controller_hide.widgets;
                
                this.afterAddWidget = function(items) {
                	
                    if (grid == null) {
                        grid = $(componentInfo.element).find(".grid-stack").gridstack({
                            auto: false
                        }).data("gridstack");
                    }
                    var item = _.find(items, function(i) {
                        return i.nodeType == 1
                    });
                    console.log("item---------");
                    console.log(items);
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
            return new ViewModel_hide(controller_hide, componentInfo);
        }
    },
    template: [ '<div class="grid-stack"  data-bind="foreach: {data: widgets, afterRender: afterAddWidget}">',
   				'<div class="grid-stack-item" data-bind="attr: {\'data-gs-x\': $data.x, \'data-gs-y\': ',
 				'$data.y, \'data-gs-width\': $data.width, \'data-gs-height\': $data.height,',
 				'\'data-gs-locked\': $data.locked, ',
  				' \'data-gs-design-id\': $data.design_id, \'data-gs-design-type\': $data.design_type, \'data-gs-auto-position\': $data.auto_position}">',
   				'<div class="grid-stack-item-content" id="grid-stack-item-content"></div>\n',
   				'<div class="field-actions" style="display: none;">',
   				'<a type="remove" id="del_frmb-fld-1" data-bind="click: $root.delete_widget" ',
   				'class="design-icon-closeelement-bg-circle btn " title="删除"></a>',
   				'<a type="edit" onclick="editWidget_(this)" class="btn design-icon-task_custom_mode_edit" title="编辑"></a>',
   				'</div></div></div>\n'].join('')
});
    controller_hide = new Controller_hide($.widgets_hide);
    ko.applyBindings(controller_hide,document.getElementById("designMainGrid_hide_"));

});



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
	}
}

function Controller_hide(widgets) {
        var self = this;
        console.log("widgets------------");
        console.log(widgets);
        self.widgets = ko.observableArray(widgets);
        console.log(widgets);
        this.delete_widget = function(item) {
        	myConfirmDialog("您确定要删除吗？", function(){
        		console.log("item");
        		console.log(item);
        		delete $.FieldsMap[item.design_id];  
        	self.widgets.remove(item);
        	layer.msg('删除成功！', {icon: 1});
        	}, function(){
           		return true;
           	},"");
        }
 }

function setBussDataObj_() {
	if($(".ui-draggable").length>0){
		$.closeLoading_();//关闭加载窗口
		/**
		var jsS='designPlug-in/design-js/'+$.businessCode;
		if("${nodeCode}"!=""){
			jsS+="/${nodeCode}";
		}
		var head = document.getElementsByTagName('head')[0];
		var script = document.createElement('script');
		script.type = 'text/javascript';
		script.src = jsS+'/v'+$.versionNum+'.js';
		head.appendChild(script);
		*/
		try{
			eval("InitDefaultJsString_"+$.businessCode+"()");
		} catch (e) {}

		$.initAttach();//初始化附件上传
		window.clearInterval(setBussObj_t); 
			$.getBussDataJson();
			$.getLinkBussDataJson();
			$.getVFormPicDataJson();
			$.getAttachDataJson('v_formFileByGroup');
			<#if isEnd!='true'>//已经办结的不需要初始化验证插件
				InitValidform("mainPageForm");
			</#if>
			//catalog_();
	}
}

function catalog_(){
	var catalogScrollerHtml="";
	$(".para-title").each(function(i,val) {
		catalogScrollerHtml+="<dt class='catalog-title level1'>";
		catalogScrollerHtml+="<em class='pointer'></em>";
		catalogScrollerHtml+="<a href='#"+(i+1)+"' class='title-link'>";
		catalogScrollerHtml+="<span class='text'>";
		catalogScrollerHtml+="<span class='title-index'>"+(i+1)+"</span>";
		catalogScrollerHtml+="<span class='title-link' nslog-type='10002802'>"+$(val).text()+"</span>";
		catalogScrollerHtml+="</span>";
		catalogScrollerHtml+="</a>";
		catalogScrollerHtml+="</dt>";
		$(val).attr("id",(i+1));
	});
	catalogScrollerHtml+="<a class='arrow' href='javascript:void(0);' style='top: 57px;'></a>";
	$("#${businessCode}catalogScrollerHtml").html(catalogScrollerHtml);
}


function setAttachDataObj_() {
	isclean++;
	if($("#preview").length>0){
		window.clearInterval(setAttachObj_t); 
		$.getAttachDataJson('v_formFile');
	}
	if(isclean>20){//如果大于10秒则关闭，说明没有附件控件
		window.clearInterval(setAttachObj_t); 
	}
}


</script>

</body>
</html>






