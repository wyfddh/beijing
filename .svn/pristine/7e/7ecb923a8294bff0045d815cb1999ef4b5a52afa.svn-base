
var controller_hide;
var controller;
var initializeTools_t;

function initCenter() {
	
/*
* 表单编辑区域组件注册
*
*/
ko.components.register('designMainGrid', {
	/*表单编辑页面视图模版*/
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
                        return i.nodeType == 1;
                    });
                   var widget_e_= grid.add_widget(item);
                   var designHtmlObj =$.getDesignHtml($(widget_e_).attr("data-gs-design-id"),$(widget_e_).attr("data-gs-design-type"));
                   $(widget_e_).find(".grid-stack-item-content").html(designHtmlObj.fieldsHtmls);
                   $.contextMenuByDiv(widget_e_);/*初始化右键*/
                   $.checkedEditWidget_(widget_e_);/*绑定点击事件*/
                    ko.utils.domNodeDisposal.addDisposeCallback(item, function() {
                        grid.remove_widget(item);
                    });
                    $(widget_e_).hover(function(){  
                    	$(widget_e_).find(".field-actions").show(); 
                    },function(){
                    	if($(widget_e_).find(".select").length==0){
                    		$(widget_e_).find(".field-actions").hide();  
                    	}
                    });
                };
            };
            return new ViewModel(controller, componentInfo); 
            
        }
    },
    /*
    * 控件模版
    */
    template: [ '<div class="grid-stack" data-bind="foreach: {data: widgets, afterRender: afterAddWidget}">',
   				'<div class="grid-stack-item"   data-bind="attr: {\'data-gs-x\': $data.x, \'data-gs-y\': ',
 				'$data.y, \'data-gs-width\': $data.width, \'data-gs-height\': $data.height,',
 				'\'data-gs-locked\': $data.locked, ',
  				' \'data-gs-design-id\': $data.design_id, \'data-gs-design-type\': $data.design_type, \'data-gs-auto-position\': $data.auto_position}">',
   				'<div class="grid-stack-item-content" id="grid-stack-item-content"></div>\n',
   				'<div class="field-actions" style="display: none;">',
   				'<a type="remove" id="del_frmb-fld-1" data-bind="click: $root.delete_widget" ',
   				'class="layui-icon btn " style="position: absolute;color: red;font-size:20px;" title="删除">&#xe640;</a>',
   				'</div></div></div>\n'].join('')
});
	
	
	
	
	
/**隐藏区域的属性渲染------------------**/
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
                       return i.nodeType == 1;
                   });
                  var widget_e_= grid.add_widget(item);
                  var designHtmlObj =$.getDesignHtml($(widget_e_).attr("data-gs-design-id"),$(widget_e_).attr("data-gs-design-type"));
                  $(widget_e_).find(".grid-stack-item-content").html(designHtmlObj.fieldsHtmls);
                  $.contextMenuByDiv(widget_e_);//初始化邮件
                  $.checkedEditWidget_(widget_e_);//绑定点击事件
                   ko.utils.domNodeDisposal.addDisposeCallback(item, function() {
                       grid.remove_widget(item);
                   });
                   $(widget_e_).hover(function(){  
                   	$(widget_e_).find(".field-actions").show(); 
                   },function(){
                   	if($(widget_e_).find(".select").length==0){
                   		$(widget_e_).find(".field-actions").hide();  
                   	}
                   });
               };
           };
           return new ViewModel_hide(controller_hide, componentInfo);
       }
   },
   template: [ '<div class="grid-stack" style="" data-bind="foreach: {data: widgets, afterRender: afterAddWidget}">',
  				'<div class="grid-stack-item"   data-bind="attr: {\'data-gs-x\': $data.x, \'data-gs-y\': ',
				'$data.y, \'data-gs-width\': $data.width, \'data-gs-height\': $data.height,',
				'\'data-gs-locked\': $data.locked, ',
 				' \'data-gs-design-id\': $data.design_id, \'data-gs-design-type\': $data.design_type, \'data-gs-auto-position\': $data.auto_position}">',
  				'<div class="grid-stack-item-content" id="grid-stack-item-content"></div>\n',
  				'<div class="field-actions" style="display: none;">',
  				'<a type="remove" id="del_frmb-fld-1"  data-bind="click: $root.delete_widget" ',
  				'class="layui-icon btn " style="position: absolute;color: red;font-size:20px;" title="删除">&#xe640;</a>',
  				'</div></div></div>\n'].join('')
});
    
    controller_hide = new Controller_hide($.widgets_hide);
    ko.applyBindings(controller_hide,document.getElementById("designMainGrid_hide"));
    /**隐藏区域的属性渲染------------------**/
    controller = new Controller($.widgets_);
	ko.applyBindings(controller,document.getElementById("designMainGrid_show"));
	//loadHideForm();//加载表单不显示字段列表
	
	
	
}




function initializeTools(type) {
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
			
			layui_element.on('tab(jsTabBrief)', function(data){
				  if($(this).attr("lay-id")=="designJsEvent"){
					  designJsEvent();
				  }
				  if($(this).attr("lay-id")=="designJsPreview"){
					  designJsPreview();
				  }
				  if($(this).attr("lay-id")=="designJsHelp"){
					  designJsHelp();
				  }
			});
			window.clearInterval(initializeTools_t);
			setFormDataMap_t=window.setInterval("setFormDataMap()",500);
			loadHideForm();
			initHelp('0',type); 
		});
		
	}
}


var eventJson=[],selectId="--";
function designJsEvent() {
	eventJson=[];
	var ppselect = $(".select").closest('.grid-stack-item');
	var designid =$(ppselect).attr("data-gs-design-id");
	var fieldName=$("[design-id='"+designid+"']").attr("design-fieldname");
	var id="";
	var showType=$("[design-id='"+designid+"']").attr("design-showtype");
	if(showType=="v_formGroupButton"){
		$(ppselect).find("[type='button']").each(function(i){
			var obj=new Object();
			obj.id=$(this).attr("id");
			obj.isSelect=false;
			obj.name=$(this).text();
			obj.showType=showType;
			if(i==0){
				obj.isSelect=true;
				id=obj.id;
			}
			if(selectId==obj.id){
				obj.isSelect=true;
				id=obj.id;
			}
			eventJson[eventJson.length]=obj;
		});
	}
	if(showType=="v_formButton"){
		$(ppselect).find("[type='button']").each(function(i){
			var obj=new Object();
			obj.id=$(this).attr("id");
			obj.isSelect=false;
			obj.showType=showType;
			obj.name=$(this).text();
			if(i==0){
				obj.isSelect=true;
				id=obj.id;
			}
			if(selectId==obj.id){
				obj.isSelect=true;
				id=obj.id;
			}
			eventJson[eventJson.length]=obj;
		});
	}
	if(showType=="popup"){
		$(ppselect).find("input[id^='showName_']").each(function(i){
			var obj=new Object();
			obj.id=$(this).attr("id");
			obj.isSelect=false;
			obj.showType=showType;
			obj.name=$(ppselect).find("text_content").text();
			if(i==0){
				obj.isSelect=true;
				id=obj.id;
			}
			if(selectId==obj.id){
				obj.isSelect=true;
				id=obj.id;
			}
			eventJson[eventJson.length]=obj;
		});
	}
	if(showType=="select"||showType=="list"){
		$(ppselect).find("select").each(function(i){
			var obj=new Object();
			obj.id=$(this).attr("id");
			obj.isSelect=false;
			obj.showType=showType;
			obj.name=$(ppselect).find("text_content").text();
			if(i==0){
				obj.isSelect=true;
				id=obj.id;
			}
			if(selectId==obj.id){
				obj.isSelect=true;
				id=obj.id;
			}
			eventJson[eventJson.length]=obj;
		});
	}
	if(showType=="text"||showType=="radio"
			||showType=="checkbox"||showType=="year"
			||showType=="yymm"||showType=="date"
				||showType=="datetime"||showType=="time"){
		$(ppselect).find("input").each(function(i){
			var obj=new Object();
			obj.id=$(this).attr("id");
			obj.isSelect=false;
			obj.showType=showType;
			obj.name=$(ppselect).find("text_content").text();
			if(i==0){
				obj.isSelect=true;
				id=obj.id;
			}
			if(selectId==obj.id){
				obj.isSelect=true;
				id=obj.id;
			}
			eventJson[eventJson.length]=obj;
		});
	}
	if(showType=="textarea"){
		$(ppselect).find("textarea").each(function(i){
			var obj=new Object();
			obj.id=$(this).attr("id");
			obj.isSelect=false;
			obj.showType=showType;
			obj.name=$(ppselect).find("text_content").text();
			if(i==0){
				obj.isSelect=true;
				id=obj.id;
			}
			if(selectId==obj.id){
				obj.isSelect=true;
				id=obj.id;
			}
			eventJson[eventJson.length]=obj;
		});
	}
	$("#js_event").attr("src","designController.do?designJsEvent&businessCode="+$.businessCode+"&id="+id+"&fieldName="+fieldName+"&fieldType="+showType);
}

function designJsPreview() {
	$("#js_preview").attr("src","designController.do?designJsPreview&businessCode="+$.businessCode);
}
function designJsHelp() {
	$("#js_help").attr("src","designController.do?designJsHelp");
}




function Controller(widgets) {
   var self = this;
    self.widgets = ko.observableArray(widgets);
    //控件删除
    this.delete_widget = function(item) {
    	myConfirmDialog("您确定要删除吗？", function(dindex){
    		//console.log(item);
    		$.FieldsMap[item.design_id].isShow="N";//设置表单显示为 不显示
        	//alert(item.design_type );
        	//需要确认是否是v_formPic、v_formGroupingTitle、v_formDescribeText、v_formFile、v_formDetailed， 如果是则需要删除数据库中记录数
        	//只有基于反向生成的表单才需要此判断
        	//if(item.design_type.indexOf("v_form")!=-1){//虚拟字段需要删除数据库记录
        		var fieldName=$.FieldsMap[item.design_id]["fieldName"];
                $.ajax({
                	async : false,
                    type: "POST",
                    url: "designController.do?deleteWidget&defineId="+$.defineId,
                    data:{field_name:fieldName},
                    success: function(data) {
                    	
                    	if(data.success){
                    		delete $.FieldsMap[item.design_id];  
                    		self.widgets.remove(item);
                    		//loadHideForm();//刷新左侧隐的表单不显示字段
                    		layer.msg(data.msg, {icon: 1});
                    		if($("#zbFormFieldDiv").length>0){//如果存在树形结构，那删除的时候需要取消这个节点的勾选状态
                    			var zTreeObject=$.fn.zTree.getZTreeObj("zbFormFieldDiv");
                                var checkedNodes=zTreeObject.getCheckedNodes();//得到选中的节点
                                for(var k=0;k<checkedNodes.length;k++){
                                    if(checkedNodes[k].fieldName==fieldName){
                                        zTreeObject.checkNode(checkedNodes[k]);//取消这个节点的勾选状态
                                    }
                                }
                    		}
                    	}else{
                    		layer.msg(data.msg, {icon: 5});
                    	}
                    },
                    error: function(data) {
                        parent.layer.msg("error:" + data.responseText, {
                            icon: 5
                        });
                    }
                });
        		
        		layer.close(dindex); 
        		
        	//只有基于反向生成的表单才需要此判断
        	/* }else{
        		//delete $.FieldsMap[item.design_id];  
        		self.widgets.remove(item);
        		loadHideForm();//刷新左侧隐的表单不显示字段
        		layer.msg('删除成功！', {icon: 1});
        		layer.close(dindex);
        	} */
    	}, function(){
       		return true;
       	},"");
    }
}


/**添加字段到设计区域**/
function add_new_widget_(type,designId) {
	var designHtmlObj = $.getDesignHtml(designId, type);
	var w_={
			x : 0,
			y : 0,
			width : designHtmlObj.width,
			height : designHtmlObj.height,
			design_id : designId,
			design_type : type,
			auto_position : false
		}
	controller.widgets.push(w_);
	if(designId==undefined||designId==""){
		$.FieldsMap[designId] = w_;
	}
}
/**添加字段到设计区域**/



/***删除设计区域属性-----------**/
function delete_widget_(field) {
	var ppselect = $(".select").closest('.grid-stack-item');
	var w_old={
			x : field.x,
			y : field.y,
			width : field.w,
			height : field.h,
			locked:false,
			design_id : field.id,
			design_type : field.showType,
			auto_position : false
		}
	var grid = $("#designMainGrid_show").find('.grid-stack').data('gridstack');
	grid.remove_widget(ppselect);
	controller.widgets.remove(w_old);
}
/***删除设计区域属性-----------**/


/***更新到设计区域-----------**/
function update_widget_(field) {
	var designHtmlObj = $.getDesignHtml(field.id, field.showType);
	var w_={
			x : field.x,
			y : field.y,
			width : designHtmlObj.width,
			height : designHtmlObj.height,
			locked:false,
			design_id : field.id,
			design_type : field.showType,
			auto_position : false
		}
	controller.widgets.push(w_);
}
/***更新到设计区域-----------**/






function Controller_hide(widgets) {
    var self = this;
    self.widgets = ko.observableArray(widgets);
    this.delete_widget = function(item) {
    	myConfirmDialog("您确定要删除吗？", function(dindex){
    		//console.log("item");
    		//console.log(item);
    		$.FieldsMap[item.design_id].isShow="N";//设置表单显示为 不显示
    		$.FieldsMap[item.design_id].isFormHide="N";
    		
    	self.widgets.remove(item);
		loadHideForm();//刷新左侧隐的表单不显示字段
		layer.msg('删除成功！', {icon: 1});
		layer.close(dindex);
    	}, function(){
       		return true;
       	},"");
    }
}



/**添加到隐藏区域的字段-------------**/	
function add_new_widget_hide(type,designId) {
	var designIdnew="";
	if(designId==undefined||designId==""){
		designIdnew=Date.parse(new Date())+(Math.random()*10000).toFixed(0);
	}
	var designHtmlObj = $.getDesignHtml(designId, type);
	var w_={
			x : 0,
			y : 0,
			width : designHtmlObj.width,
			height : designHtmlObj.height,
			design_id : designId,
			design_type : type,
			auto_position : false
		}
	controller_hide.widgets.push(w_);
	if(designId==undefined||designId==""){
		$.FieldsMap[designId] = w_;
	}
}
/**添加到隐藏区域的字段-------------**/	


/**删除隐藏区域的字段-------------**/	
function delete_widget_hide(field) {
var ppselect = $(".select").closest('.grid-stack-item');
var w_old={
		x : field.x,
		y : field.y,
		width : field.w,
		height : field.h,
		locked:false,
		design_id : field.id,
		design_type : field.showType,
		auto_position : false
	}
var grid = $("#designMainGrid_hide").find('.grid-stack').data('gridstack');
grid.remove_widget(ppselect);
controller_hide.widgets.remove(w_old);
}
/**删除隐藏区域的字段-------------**/		
	

	
	
/**更新隐藏区域的字段-------------**/	
function update_widget_hide(field) {
	var designHtmlObj = $.getDesignHtml_hide(field.id, field.showType);
	var w_={
			x : field.x,
			y : field.y,
			width : designHtmlObj.width,
			height : designHtmlObj.height,
			locked:false,
			design_id : field.id,
			design_type : field.showType,
			auto_position : false
		}
	//console.log("w_");
	//console.log(w_);
	controller_hide.widgets.push(w_);
}	
/**更新隐藏区域的字段-------------**/		
	
	

/**通过组件添加字段-------------------**/
function left_add_new_widget_(type,ts) {
	if("v_formFile"==type){
		var vLength = $("[design-showtype='v_formFile']").length;
		if(vLength>0){
			layer.msg('此类控件只能添加一个，如需使用多个分类附件，请选择【分类附件】',{icon: 5});
			return false;
		}
	}
	
	
	var componentMap={
			"number":{showType:"text",fieldValidType:"n",content:"数字输入框"},
			"money":{showType:"text",fieldValidType:"/^[0-9]+.?[0-9]*$/",content:"金额"},
			"email":{showType:"text",fieldValidType:"e",content:"邮箱"},
			"mobile":{showType:"text",fieldValidType:"m",content:"手机号"},
			"region":{showType:"v_formRegion",fieldValidType:"",content:"地区"},
			"personnel":{showType:"popup",fieldValidType:"",content:"用户选择"},//需要在数据来源表中定义用户选择
			"department":{showType:"popup",fieldValidType:"",content:"部门选择"},//需要在数据来源表中定义部门选择
			"phone":{showType:"text",fieldValidType:"/^[0-9\-]{6,}$/",content:"电话号码"}
	};//初始化数据map
	var has = type in componentMap;
	
	var designIdnew="";
		designIdnew="T_"+type+"_"+Date.parse(new Date())+(Math.random()*10000).toFixed(0);
		if(type.indexOf("v_form")!=-1){
			designIdnew="T"+Date.parse(new Date())+(Math.random()*10000).toFixed(0);
		}
		var w_ ={};
		$.each($.Fields, function(index, val) {
			if(val.id=="id"){
				w_[val.id]=designIdnew;
			}else if(val.id=="showType"){
				w_[val.id]=has?componentMap[type]["showType"]:type;
			}else if(val.id=="fieldName"){
				w_[val.id]=designIdnew;
			}else if(val.id=="content"){
				w_[val.id]=has?componentMap[type]["content"]:$(ts).find("p").text();
			}else if(val.id=="isShow"){
				w_[val.id]="Y";
			}else if(val.id=="bussCode"){
				w_[val.id]=$.businessCode;
			}else if(val.id=="fieldValidType"){
				w_[val.id]=has?componentMap[type]["fieldValidType"]:"";
			}else if(val.id=="tableId"){
				w_[val.id]=$.tableId;
			}else{
				w_[val.id]="";
			}
		});
		$.FieldsMap[designIdnew]=w_;
		designId=designIdnew;
	var designHtmlObj = $.getDesignHtml(designId,$.FieldsMap[designIdnew]["showType"]);
	
	w_.x =0;
	w_.y =0;
	w_.width =designHtmlObj.width;
	w_.height =designHtmlObj.height;
	w_.design_id =designId;
	w_.design_type =$.FieldsMap[designIdnew]["showType"];
	w_.auto_position =false;
	
	var w_1={
			x : 0,
			y : 0,
			width : designHtmlObj.width,
			height : designHtmlObj.height,
			design_id : designId,
			design_type : $.FieldsMap[designIdnew]["showType"],
			auto_position : false
		}
	controller.widgets.push(w_1);
	$.FieldsMap[designId] = w_;
}
/**通过组件添加字段-------------------**/





