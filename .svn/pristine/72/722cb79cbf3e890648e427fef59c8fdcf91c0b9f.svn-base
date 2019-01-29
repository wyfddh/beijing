
var curStatus = "init", curAsyncCount = 0, asyncForAll = false,
goAsync = false;

function initzTree(){
	if(type_=="1"){
	var setting = {
			check: {
				enable: true
			},
			view: {
				selectedMulti: false
			},
			async: {
				enable: true,
				url:getUrl,
				autoParam:["id", "name=n", "level=lv"],
				otherParam:{"otherParam":"zTreeAsyncTest"},
				dataFilter: filter
			}, 
			data: {
				simpleData: {
					enable: true
				}
			},
			callback : {
	            beforeCheck : zTreeBeforeCheck,
	            onCheck : onCheck,
	            beforeAsync: beforeAsync,
	            onAsyncSuccess: onAsyncSuccess,
                onAsyncError: onAsyncError
	        }
		};
	$.fn.zTree.init($("#zbFormFieldDiv"), setting);
	fuzzySearch('zbFormFieldDiv','#searchtree',null,true); //初始化模糊搜索方法
}
	$("#tab_left").height((document.body.clientHeight-148));
}
function beforeAsync() {
    curAsyncCount++;
}

function onAsyncSuccess(event, treeId, treeNode, msg) {
    curAsyncCount--;
    if (curStatus == "expand") {
        expandNodes(treeNode.children);
    } else if (curStatus == "async") {
        asyncNodes(treeNode.children);
    }
    if (curAsyncCount <= 0) {
        if (curStatus != "init" && curStatus != "") {
            asyncForAll = true;
        }
        curStatus = "";
    }
    expandAll();//调用写好的展开全部节点方法
}

function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
    curAsyncCount--;
    if (curAsyncCount <= 0) {
        curStatus = "";
        if (treeNode!=null) asyncForAll = true;
    }
}

function expandAll() {
    var zTree = $.fn.zTree.getZTreeObj("zbFormFieldDiv");
    if (asyncForAll) {
        zTree.expandAll(true);
    } else {
        expandNodes(zTree.getNodes());
        if (!goAsync) {
            curStatus = "";
        }
    }
}
function expandNodes(nodes) {
	console.log("---------------nodes");
	console.log(nodes);
    if (!nodes) return;
    curStatus = "expand";
    var zTree = $.fn.zTree.getZTreeObj("zbFormFieldDiv");
    for (var i=0, l=nodes.length; i<l; i++) {
        zTree.expandNode(nodes[i], true, false, false);
        if (nodes[i].isParent && nodes[i].zAsync) {    
            expandNodes(nodes[i].children);
        } else {
            goAsync = true;
        }
    }
}


//加载表单不显示字段列表
function loadHideForm(){
	if(type_!="1"){//只有是数据库反向生成才显示字段页签
		var getHideFormListTpl = document.getElementById('hideFormList').innerHTML;
		laytpl(getHideFormListTpl).render($.FieldsMap, function(html){
			html=html.replace(/(^\s*)|(\s*$)/g, "");
			if(html!=""){
				document.getElementById('hideFormFieldDiv').innerHTML=html;
			}
		});
	}
}

//点击左侧隐藏表单,显示到右侧设计页面
function show_widget_(obj,id){
	$.FieldsMap[id].isShow="Y";//设置表单显示为 不显示
	//追加到设计页面
	add_new_widget_($.FieldsMap[id].showType,id);
	//controller.widgets.push($.FieldsMap[id]);
	//删除自己
	$(obj).remove();
}

function zTreeBeforeCheck(treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj("zbFormFieldDiv");
    zTree.expandNode(treeNode, true, true, true);
    //zTree.reAsyncChildNodes(treeNode, "refresh");//勾选前先展开下级节点
    //zTree.checkNode(treeNode, !treeNode.checked, null, true);
    if(treeNode.isParent){
    	layer.msg('父级节点不能选择，请重新选择！', {icon: 5});
    }
    return !treeNode.isParent;
}

function onCheck(e, treeId, treeNode) {
	var index;
    	var nodes = treeNode.children;
    	var zTree = $.fn.zTree.getZTreeObj("zbFormFieldDiv");
    	var indexextids = $("[design-indexextid='"+treeNode.indexExtId+"']").length;
    	if(treeNode.isParent){
    		for (var i = 0;i<nodes.length;i++) {
                if (!nodes[i].isParent) {//isParent判断是否为父级，也就是是否有下级
                	indexextids = $("[design-indexextid='"+nodes[i].indexExtId+"']").length;
                	var nd= nodes[i];
                	if(treeNode.checked){
                		//if(indexextids==0){
                		//	index=layer.confirm("您确定要添加【"+nd.name+"】吗？", {
                    	//		  btn: ["确定","取消"] //按钮
                    	//		}, function(){
                   				ztree_add_new_widget_(nd);
                   		//		layer.close(index);
                    	//		}, function(){
                    	//			zTree.checkNode(nd, false,true,true);
                        //       		return true;
                    	//		});
                		//}
                	}else{
                		if(indexextids>0){
                			//index=layer.confirm("您确定要删除【"+nd.name+"】吗？", {
                			//  btn: ["确认","关闭"] //按钮
                			//}, function(){
                				ztree_delete_widget_(nd);
                			//	layer.msg('删除成功！', {icon: 1});
                			//	layer.close(index);
                			//}, function(){
                			//	zTree.checkNode(nd, true,true,true);
                           	//	return true;
                			//});
                		}
                	}
                }
            }
    	}else{
    		if(treeNode.checked){
    			if(indexextids==0){
    				//index=layer.confirm("您确定要添加【"+treeNode.name+"】吗？", {
          			//  btn: ["确定","取消"] //按钮
          			//}, function(){
         				ztree_add_new_widget_(treeNode);
         			//	layer.close(index);
          			//}, function(){
          			//	zTree.checkNode(treeNode, false,true,true);
                   	//	return true;
          			//});
    			}
        	}else{
        		if(indexextids>0){
        			//index=layer.confirm("您确定要删除【"+treeNode.name+"】吗？", {
      			  //btn: ["确认","关闭"] //按钮
      			//}, function(){
      				ztree_delete_widget_(treeNode);
      				//layer.msg('删除成功！', {icon: 1});
      				//layer.close(index);
      			//}, function(){
      				//zTree.checkNode(treeNode, true,true,true);
               	//	return true;
      			//});
        		}
        	}
    	}
}


function ztree_delete_widget_(treeNode) {
	var ppselect = $("[design-indexextid='"+treeNode.indexExtId+"']").closest(".grid-stack-item");
	var w_old={
			x : $(ppselect).attr("data-gs-x"),
			y : $(ppselect).attr("data-gs-y"),
			width : $(ppselect).attr("data-gs-width"),
			height : $(ppselect).attr("data-gs-height"),
			locked:false,
			design_id : $(ppselect).attr("data-gs-design-id"),
			design_type : $(ppselect).attr("data-gs-design-type"),
			auto_position : false
		}
	$.ajax({
    	async : false,
        type: "POST",
        url: "designController.do?deleteWidget&defineId="+defineId_,
        data:{field_name:$("[design-indexextid='"+treeNode.indexExtId+"']").attr("design-fieldname")},
        success: function(data) {
        },
        error: function(data) {
            parent.layer.msg("error:" + data.responseText, {
                icon: 5
            });
        }
    });
	var grid = $("[design-indexextid='"+treeNode.indexExtId+"']").closest(".grid-stack").data("gridstack");
	grid.remove_widget(ppselect);
	try{controller.widgets.remove(w_old);}catch(e){}
	try{controller_hide.widgets.remove(w_old);}catch(e){}
	delete $.FieldsMap[$(ppselect).attr("data-gs-design-id")];
}

function getUrl(treeId,treeNode) {
    var param = "";
    if(treeNode!=undefined){
    	param = "&defineId="+defineId_+"&indexExtId="+treeNode.indexExtId+"&id=" + treeNode.id;
    }
    return "designController.do?getIndexTree" + param;
}

function filter(treeId, parentNode, childNodes) {
	if (!childNodes) return null;
	for (var i=0, l=childNodes.length; i<l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	}
	return childNodes;
}


function ztree_add_new_widget_(treeNode) {
	var designIdnew="T"+Date.parse(new Date())+(Math.random()*10000).toFixed(0);
	var w_ ={};
	$.each($.Fields, function(index, val) {
		var has = val.id in treeNode;
		 if(val.id=="id"){
			w_[val.id]=designIdnew;
		}else if (has) {
			w_[val.id]=treeNode[val.id];
        }else if(val.id=="content"){
			w_[val.id]=treeNode.name;
		}else if(val.id=="isShow"){
			w_[val.id]="Y";
		}else if(val.id=="bussCode"){
			w_[val.id]=businessCode_;
		}else if(val.id=="tableId"){
			w_[val.id]=tableId_;
		}else{
			w_[val.id]="";
		}
	});
	$.FieldsMap[designIdnew]=w_;
	var designHtmlObj = $.getDesignHtml(designIdnew, treeNode.showType);
	w_.x =0;
	w_.y =0;
	w_.width =designHtmlObj.width;
	w_.height =designHtmlObj.height;
	w_.design_id =designIdnew;
	w_.design_type =treeNode.showType;
	w_.auto_position =false;
	controller.widgets.push(w_);
	$.FieldsMap[designIdnew] = w_;
	form.render(null, 'designMainGrid_show_filter');
}


	