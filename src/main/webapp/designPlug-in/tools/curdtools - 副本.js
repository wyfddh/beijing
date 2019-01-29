//﻿var jq = jQuery.noConflict();
/**
 * 增删改工具栏
 */
window.onerror = function() {
	return true;
};
var iframe;// iframe操作对象
var win;//窗口对象
var gridname="";//操作datagrid对象名称
var windowapi, W;//内容页中调用窗口实例对象接口
try{
	if(frameElement!=null)
	windowapi = frameElement.api;
}catch(e){
	alert(e);
}

try{
	if(windowapi!=null)
	W = windowapi.opener;
}catch(e){
	alert(e);
}

var global_fileupload_lock = false ;//全局变量，true用于上传文件锁定，false 成功后解除锁定

function upload(curform) {
	upload();
}
/**
 * 添加事件打开窗口
 * @param title 编辑框标题
 * @param addurl//目标页面地址
 */
function add(title,addurl,gname,width,height) {
	gridname=gname;
	createwindow(title, addurl,width,height);
}
/**
 * 树列表添加事件打开窗口
 * @param title 编辑框标题
 * @param addurl//目标页面地址
 */
function addTreeNode(title,addurl,gname) {
	if (rowid != '') {
		addurl += '&id='+rowid;
	}
	gridname=gname;
	createwindow(title, addurl);
}
/**
 * 更新事件打开窗口
 * @param title 编辑框标题
 * @param addurl//目标页面地址
 * @param id//主键字段
 */
function update(title,url, id,width,height) {
	gridname=id;
	var rowsData = $('#'+id).datagrid('getSelections');
	if (!rowsData || rowsData.length==0) {
		tip('请选择编辑项目');
		return;
	}
	if (rowsData.length>1) {
		tip('请选择一条记录再编辑');
		return;
	}
	
	url += '&id='+rowsData[0].id;
	createwindow(title,url,width,height);
}

/**
 * 如果页面是详细查看页面，无效化所有表单元素，只能进行查看
 */
$(function(){
	if(location.href.indexOf("load=detail")!=-1){
		$(":input").attr("disabled","true");
		//$(":input").attr("style","border:0;border-bottom:1 solid black;background:white;");
	}
});

/**
 * 查看详细事件打开窗口
 * @param title 查看框标题
 * @param addurl//目标页面地址
 * @param id//主键字段
 */
function detail(title,url, id,width,height) {
	var rowsData = $('#'+id).datagrid('getSelections');
//	if (rowData.id == '') {
//		tip('请选择查看项目');
//		return;
//	}
	
	if (!rowsData || rowsData.length == 0) {
		tip('请选择查看项目');
		return;
	}
	if (rowsData.length > 1) {
		tip('请选择一条记录再查看');
		return;
	}
    url += '&load=detail&id='+rowsData[0].id;
	createdetailwindow(title,url,width,height);
}

/**
 * 多记录刪除請求
 * @param title
 * @param url
 * @param gname
 * @return
 */
function deleteALLSelect(title,url,gname) {
	gridname=gname;
    var ids = [];
    var status =[];
    var rows = $("#"+gname).datagrid('getSelections');
    if (rows.length > 0) {
    	for ( var i = 0; i < rows.length; i++) {
			if(rows[i].status!="01"){
				tip('办理中的状态不允许删除，请重新选择');
				return false;
			}
		}
    	$.dialog.confirm('你确定永久删除该数据吗?', function(r) {
		   if (r) {
				for ( var i = 0; i < rows.length; i++) {
					ids.push(rows[i].id);
				}
				$.ajax({
					url : url,
					type : 'post',
					data : {
						ids : ids.join(',')
					},
					cache : false,
					success : function(data) {
						var d = $.parseJSON(data);
						if (d.success) {
							var msg = d.msg;
							tip(msg);
							reloadTable();
							$("#"+gname).datagrid('unselectAll');
							ids='';
						}
					}
				});
			}
		});
	} else {
		tip("请选择需要删除的数据");
	}
}



/**
 * 多记录选择
 * @param title
 * @param url
 * @param gname
 * @return
 */
function batchSelectInitPassword(title,url,gname) {
	gridname=gname;
	//alert(gname);
    var ids = [];
    var status =[];
    var rows = $("#"+gname).datagrid('getSelections');
    if (rows.length > 0) {
    	for ( var i = 0; i < rows.length; i++) {
    		//alert(rows[i].dataStatus);
			if(rows[i].dataStatus=="1"){
				tip('启用状态不允许初始化密码，请重新选择');
				return false;
			}
		}
    	$.dialog.confirm('你确定初始化密码吗?', function(r) {
		   if (r) {
				for ( var i = 0; i < rows.length; i++) {
					ids.push(rows[i].id);
				}
				$.ajax({
					url : url,
					type : 'post',
					data : {
						ids : ids.join(',')
					},
					cache : false,
					success : function(data) {
						var d = $.parseJSON(data);
						if (d.success) {
							var msg = d.msg;
							tip(msg);
							reloadTable();
							$("#"+gname).datagrid('unselectAll');
							ids='';
						}
					}
				});
			}
		});
	} else {
		tip("请选择需要初始化密码的数据");
	}
}

/**
 * 查看时的弹出窗口
 * 
 * @param title
 * @param addurl
 * @param saveurl
 */
function createdetailwindow(title, addurl,width,height) {
	width = width?width:700;
	height = height?height:400;
	if(width=="100%" || height=="100%"){
		width = document.body.offsetWidth;
		height =document.body.offsetHeight-100;
	}
	if(typeof(windowapi) == 'undefined'){
		$.dialog({
			content: 'url:'+addurl,
			lock : true,
			width:width,
			height: height,
			title:title,
			opacity : 0.3,
			cache:false, 
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
		});
	}else{
		W.$.dialog({
			content: 'url:'+addurl,
			lock : true,
			width:width,
			height: height,
			parent:windowapi,
			title:title,
			opacity : 0.3,
			cache:false, 
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
			
		});
	}
	
}
// 删除调用函数
function delObj(url,name) {
	gridname=name;
	createdialog('删除确认 ', '确定删除该记录吗 ?', url,name);
}
// 删除调用函数
function confuploadify(url, id) {
	$.dialog.confirm('确定删除吗', function(){
		deluploadify(url, id);
	}, function(){
	});
}
/**
 * 执行删除附件
 * 
 * @param url
 * @param index
 */
function deluploadify(url, id) {
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		url : url,// 请求的action路径
		error : function() {// 请求失败处理函数
		},
		success : function(data) {
			var d = $.parseJSON(data);
			if (d.success) {
				$("#" + id).remove();// 移除SPAN
				m.remove(id);// 移除MAP对象内字符串
			}

		}
	});
}
// 普通询问操作调用函数
function confirmDialog(url, content,name) {
	createdialog('提示信息 ', content, url,name);
}
/**
 * 提示信息
 */
function tip_old(msg) {
	$.dialog.setting.zIndex = 1980;
	$.dialog.tips(msg, 1);
}


/**
 * 提示信息
 */
function tip(msg) {
	$(".messager-body").window('close');
	$.dialog.setting.zIndex = 1980;
	$.messager.show({
		title : '提示信息',
		msg : msg,
		timeout : 1000 * 5,
		style:{
			left:document.documentElement.offsetWidth/2-125,
			top:document.documentElement.offsetHeight/2,
			right:"",
			bottom:""
		}
	});
}
/**
 * 提示信息像alert一样
 */
function alertTip(msg,title) {
	$.dialog.setting.zIndex = 1980;
	title = title?title:"提示信息";
	$.dialog({
			title:title,
			icon:'tips.gif',
			content: msg
		});
}
/**
 * 创建添加或编辑窗口
 * 
 * @param title
 * @param addurl
 * @param saveurl
 */
function createwindow(title, addurl,width,height) {
	width = width?width:700;
	height = height?height:400;
	if(width=="100%" || height=="100%"){
		width = document.body.offsetWidth;
		height =document.body.offsetHeight-100;
	}
	if(typeof(windowapi) == 'undefined'){
		$.dialog({
			content: 'url:'+addurl,
			lock : true,
			width:width,
			height:height,
			title:title,
			opacity : 0.3,
			cache:false,
		    ok: function(){
		    	iframe = this.iframe.contentWindow;
				saveObj();
				return false;
		    },
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
		});
	}else{
		W.$.dialog({
			content: 'url:'+addurl,
			lock : true,
			width:width,
			height:height,
			parent:windowapi,
			title:title,
			opacity : 0.3,
			cache:false,
		    ok: function(){
		    	iframe = this.iframe.contentWindow;
				saveObj();
				return false;
		    },
		    cancelVal: '关闭',
		    cancel: true /*为true等价于function(){}*/
		});
	}
	
}
/**
 * 创建上传页面窗口
 * 
 * @param title
 * @param addurl
 * @param saveurl
 */
function openuploadwin(title, url,name,width, height) {
	gridname=name;
	$.dialog({
	    content: 'url:'+url,
	    cache:false,
	    button: [
	        {
	            name: '开始上传',
	            callback: function(){
	            	iframe = this.iframe.contentWindow;
					iframe.upload();
					return false;
	            },
	            focus: true
	        },
	        {
	            name: '取消上传',
	            callback: function(){
	            	iframe = this.iframe.contentWindow;
					iframe.cancel();
	            }
	        }
	    ]
	});
}
/**
 * 创建查询页面窗口
 * 
 * @param title
 * @param addurl
 * @param saveurl
 */
function opensearchdwin(title, url, width, height) {
	$.dialog({
		content: 'url:'+url,
		title : title,
		lock : true,
		height : height,
		cache:false,
		width : width,
		opacity : 0.3,
		button : [ {
			name : '查询',
			callback : function() {
				iframe = this.iframe.contentWindow;
				iframe.searchs();
			},
			focus : true
		}, {
			name : '取消',
			callback : function() {

			}
		} ]
	});
}
/**
 * 创建不带按钮的窗口
 * 
 * @param title
 * @param addurl
 * @param saveurl
 */
function openwindow(title, url,name, width, height) {
	gridname=name;
	//alert(gridname);
	if (typeof (width) == 'undefined'&&typeof (height) != 'undefined')
	{
		if(typeof(windowapi) == 'undefined'){
			$.dialog({
				content: 'url:'+url,
				title : title,
				cache:false,
				lock : true,
				width: 'auto',
			    height: height,
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}

			});
		}else{
			$.dialog({
				content: 'url:'+url,
				title : title,
				cache:false,
				parent:windowapi,
				lock : true,
				width: 'auto',
			    height: height,
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			});
		}
	}
	if (typeof (height) == 'undefined'&&typeof (width) != 'undefined')
	{
		if(typeof(windowapi) == 'undefined'){
			$.dialog({
				content: 'url:'+url,
				title : title,
				lock : true,
				width: width,
				cache:false,
			    height: 'auto',
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			});
		}else{
			$.dialog({
				content: 'url:'+url,
				title : title,
				lock : true,
				parent:windowapi,
				width: width,
				cache:false,
			    height: 'auto',
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			});
		}
	}
	if (typeof (width) == 'undefined'&&typeof (height) == 'undefined')
	{
		if(typeof(windowapi) == 'undefined'){
			$.dialog({
				content: 'url:'+url,
				title : title,
				lock : true,
				width: 'auto',
				cache:false,
			    height: 'auto',
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			});
		}else{
			$.dialog({
				content: 'url:'+url,
				title : title,
				lock : true,
				parent:windowapi,
				width: 'auto',
				cache:false,
			    height: 'auto',
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			});
		}
	}
	
	if (typeof (width) != 'undefined'&&typeof (height) != 'undefined')
	{
		if(typeof(windowapi) == 'undefined'){ 
			$.dialog({
				width: width,
			    height:height,
				content: 'url:'+url,
				title : title,
				cache:false,
				lock : true,
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			});
		}else{
			 
			$.dialog({
				width: width,
			    height:height,
				content: 'url:'+url,
				parent:windowapi,
				title : title,
				cache:false,
				lock : true,
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			});
		}
	}
}



/**
 * 创建不带按钮的窗口
 * 
 * @param title
 * @param addurl
 * @param saveurl
 */
function openMaxWindow(title, url,name) {
	gridname=name;
	var wid=getWindowInfo();
	//alert(wid.Width);alert(wid.Height);
	var width=wid.Width;
	var height=wid.Height-70;
	if(typeof(windowapi) == 'undefined'){
		$.dialog({
			content: 'url:'+url,
			title : title,
			width: width,
			height:height,
			cache:false,
			lock : true,
			close:function(){
				global_fileupload_lock = false ;//恢复锁定状态
			}

		}).zindex();
	}else{
		$.dialog({
			content: 'url:'+url,
			title : title,
			width: width,
			height:height,
			cache:false,
			parent:windowapi,
			lock : true,
			close:function(){
				global_fileupload_lock = false ;//恢复锁定状态
			}
		}).zindex();
	}
}



/**
 * 创建不带按钮的窗口
 * 
 * @param title
 * @param addurl
 * @param saveurl
 */
function openWindowByNotLock(title, url,name, width, height) {
	gridname=name;
	//alert(gridname);
	if (typeof (width) == 'undefined'&&typeof (height) != 'undefined')
	{
		if(typeof(windowapi) == 'undefined'){
			$.dialog({
				content: 'url:'+url,
				title : title,
				cache:false,
				lock : true,
				width: 'auto',
			    height: height,
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			}).zindex();
		}else{
			$.dialog({
				content: 'url:'+url,
				title : title,
				cache:false,
				parent:windowapi,
				lock : true,
				width: 'auto',
			    height: height,
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			}).zindex();
		}
	}
	if (typeof (height) == 'undefined'&&typeof (width) != 'undefined')
	{
		if(typeof(windowapi) == 'undefined'){
			$.dialog({
				content: 'url:'+url,
				title : title,
				lock : true,
				width: width,
				cache:false,
			    height: 'auto',
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			}).zindex();
		}else{
			$.dialog({
				content: 'url:'+url,
				title : title,
				lock : true,
				parent:windowapi,
				width: width,
				cache:false,
			    height: 'auto',
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			}).zindex();
		}
	}
	if (typeof (width) == 'undefined'&&typeof (height) == 'undefined')
	{
		if(typeof(windowapi) == 'undefined'){
			$.dialog({
				content: 'url:'+url,
				title : title,
				lock : true,
				width: 'auto',
				cache:false,
			    height: 'auto',
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			}).zindex();
		}else{
			$.dialog({
				content: 'url:'+url,
				title : title,
				lock : true,
				parent:windowapi,
				width: 'auto',
				cache:false,
			    height: 'auto',
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			}).zindex();
		}
	}
	
	if (typeof (width) != 'undefined'&&typeof (height) != 'undefined')
	{
		if(typeof(windowapi) == 'undefined'){ 
			$.dialog({
				width: width,
			    height:height,
				content: 'url:'+url,
				title : title,
				cache:false,
				lock : true,
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			}).zindex();
		}else{
			 
			$.dialog({
				width: width,
			    height:height,
				content: 'url:'+url,
				parent:windowapi,
				title : title,
				cache:false,
				lock : true,
				close:function(){
					global_fileupload_lock = false ;//恢复锁定状态
				}
			}).zindex();
		}
	}
}




/**
 * 创建询问窗口
 * 
 * @param title
 * @param content
 * @param url
 */
function createdialog(title, content, url,name) {
	$.dialog.confirm(content, function(){
		doSubmit(url,name);
		rowid = '';
	}, function(){
	});
}
/**
 * 执行保存
 * 
 * @param url
 * @param gridname
 */
function saveObj() {
	$('#btn_sub', iframe.document).click();
}

/**
 * 执行AJAX提交FORM
 * 
 * @param url
 * @param gridname
 */
function ajaxSubForm(url) {
	$('#myform', iframe.document).form('submit', {
		url : url,
		onSubmit : function() {
			iframe.editor.sync();
		},
		success : function(r) {
			tip('操作成功');
			reloadTable();
		}
	});
}
/**
 * 执行查询
 * 
 * @param url
 * @param gridname
 */
function search() {

	$('#btn_sub', iframe.document).click();
	iframe.search();
}

/**
 * 执行操作
 * 
 * @param url
 * @param index
 */
function doSubmit(url,name,data) {
	gridname=name;
	//--author：JueYue ---------date：20140227---------for：把URL转换成POST参数防止URL参数超出范围的问题
	var paramsData = data;
	if(!paramsData){
		paramsData = new Object();
		if (url.indexOf("&") != -1) {
			var str = url.substr(url.indexOf("&")+1);
			url = url.substr(0,url.indexOf("&"));
			var strs = str.split("&");
			for(var i = 0; i < strs.length; i ++) {
				paramsData[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
			}
		}      
	}
	//--author：JueYue ---------date：20140227---------for：把URL转换成POST参数防止URL参数超出范围的问题
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		data : paramsData,
		url : url,// 请求的action路径
		error : function() {// 请求失败处理函数
		},
		success : function(data) {
			var d = $.parseJSON(data);
			if (d.success) {
				var msg = d.msg;
				tip(msg);
			//tip(11);
				reloadTable();
			}
		}
	});
	
	
}
/**
 * 退出确认框
 * 
 * @param url
 * @param content
 * @param index
 */
function exit(url, content) {
	$.dialog.confirm(content, function(){
		window.location = url;
	}, function(){
	});
}
/**
 * 模板页面ajax提交
 * 
 * @param url
 * @param gridname
 */
function ajaxdoSub(url, formname) {
	$('#' + formname).form('submit', {
		url : url,
		onSubmit : function() {
			editor.sync();
		},
		success : function(r) {
			tip('操作成功');
		}
	});
}
/**
 * ajax提交FORM
 * 
 * @param url
 * @param gridname
 */
function ajaxdoForm(url, formname) {
	$('#' + formname).form('submit', {
		url : url,
		onSubmit : function() {
		},
		success : function(r) {
			tip('操作成功');
		}
	});
}

function opensubwin(title, url, saveurl, okbutton, closebutton) {
	$.dialog({
		content: 'url:'+url,
		title : title,
		lock : true,
		opacity : 0.3,
		button : [ {
			name : okbutton,
			callback : function() {
				iframe = this.iframe.contentWindow;
				win = frameElement.api.opener;// 来源页面
				$('#btn_sub', iframe.document).click();
				return false;
			}
		}, {
			name : closebutton,
			callback : function() {
			}
		} ]

	});
}

function openauditwin(title, url, saveurl, okbutton, backbutton, closebutton) {
	$.dialog({
		content: 'url:'+url,
		title : title,
		lock : true,
		opacity : 0.3,
		button : [ {
			name : okbutton,
			callback : function() {
				iframe = this.iframe.contentWindow;
				win = $.dialog.open.origin;// 来源页面
				$('#btn_sub', iframe.document).click();
				return false;
			}
		}, {
			name : backbutton,
			callback : function() {
				iframe = this.iframe.contentWindow;
				win = frameElement.api.opener;// 来源页面
				$('#formobj', iframe.document).form('submit', {
					url : saveurl + "&code=exit",
					onSubmit : function() {
						$('#code').val('exit');
					},
					success : function(r) {
						$.dialog.tips('操作成功', 2);
						win.location.reload();
					}
				});

			}
		}, {
			name : closebutton,
			callback : function() {
			}
		} ]

	});
}
// 添加标签
function addOneTab(subtitle, url, icon) {
	if (icon == '') {
		icon = 'icon folder';
	}
	window.top.$.messager.progress({
		text : '页面加载中....',
		interval : 300
	});
	window.top.$('#maintabs').tabs({
		onClose : function(subtitle, index) {
			window.top.$.messager.progress('close');
		}
	});
	if (window.top.$('#maintabs').tabs('exists', subtitle)) {
		window.top.$('#maintabs').tabs('select', subtitle);
		window.top.$('#maintabs').tabs('update', {
			tab : window.top.$('#maintabs').tabs('getSelected'),
			options : {
				title : subtitle,
				href:url,
				//content : '<iframe name="tabiframe"  scrolling="no" frameborder="0"  src="' + url + '" style="width:100%;height:99%;"></iframe>',
				closable : true,
				icon : icon
			}
		});
	} else {
		if (url.indexOf('isIframe') != -1) {
			window.top.$('#maintabs').tabs('add', {
				title : subtitle,
				content : '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99.4%;"></iframe>',
				closable : true,
				icon : icon
			});
		}else {
			window.top.$('#maintabs').tabs('add', {
				title : subtitle,
				href:url,
				closable : true,
				icon : icon
			});
		}
	}
}
// 关闭自身TAB刷新父TABgrid
function closetab(title) {
	//暂时先不刷新
	//window.top.document.getElementById('tabiframe').contentWindow.reloadTable();
	//window.top.document.getElementById('maintabs').contentWindow.reloadTable();
	window.top.$('#maintabs').tabs('close', title);
	//tip("添加成功");
}

//popup  
//object: this  name:需要选择的列表的字段  code:动态报表的code
function inputClick(obj,name,code) {
	 $.dialog.setting.zIndex = 2000;
	 if(name==""||code==""){
		 alert("popup参数配置不全");
		 return;
	 }
	 if(typeof(windowapi) == 'undefined'){
		 $.dialog({
				content: "url:cgReportController.do?popup&id="+code,
				lock : true,
				title:"选择",
				width:800,
				height: 400,
				cache:false,
			    ok: function(){
			    	iframe = this.iframe.contentWindow;
			    	var selected = iframe.getSelectRows();
			    	if (selected == '' || selected == null ){
				    	alert("请选择");
			    		return false;
				    }else {
					    var str = "";
				    	$.each( selected, function(i, n){
					    	if (i==0)
					    	str+= n[name];
					    	else
				    		str+= ","+n[name];
				    	});
				    	$(obj).val("");
				    	//$('#myText').searchbox('setValue', str);
					    $(obj).val(str);
				    	return true;
				    }
					
			    },
			    cancelVal: '关闭',
			    cancel: true /*为true等价于function(){}*/
			});
		}else{
			$.dialog({
				content: "url:cgReportController.do?popup&id="+code,
				lock : true,
				title:"选择",
				width:800,
				height: 400,
				parent:windowapi,
				cache:false,
			    ok: function(){
			    	iframe = this.iframe.contentWindow;
			    	var selected = iframe.getSelectRows();
			    	if (selected == '' || selected == null ){
				    	alert("请选择");
			    		return false;
				    }else {
					    var str = "";
				    	$.each( selected, function(i, n){
					    	if (i==0)
					    	str+= n[name];
					    	else
				    		str+= ","+n[name];
				    	});
				    	$(obj).val("");
				    	//$('#myText').searchbox('setValue', str);
					    $(obj).val(str);
				    	return true;
				    }
					
			    },
			    cancelVal: '关闭',
			    cancel: true /*为true等价于function(){}*/
			});
		}
}
/*
	自定义url的弹出
	obj:要填充的控件,可以为多个，以逗号分隔
	name:列表中对应的字段,可以为多个，以逗号分隔（与obj要对应）
	url：弹出页面的Url
*/
function popClick(obj,name,url) {
	 $.dialog.setting.zIndex = 2001;
	var names = name.split(",");
	var objs = obj.split(",");
	 if(typeof(windowapi) == 'undefined'){
		 $.dialog({
				content: "url:"+url,
				lock : true,
				title:"选择",
				width:700,
				height: 400,
				cache:false,
			    ok: function(){
			    	iframe = this.iframe.contentWindow;
			    	var selected = iframe.getSelectRows();
			    	if (selected == '' || selected == null ){
				    	alert("请选择");
			    		return false;
				    }else {
				    	for(var i1=0;i1<names.length;i1++){
						    var str = "";
					    	$.each( selected, function(i, n){
						    	if (i==0)
						    	str+= n[names[i1]];
						    	else{
									str+= ",";
									str+=n[names[i1]];
								}
					    	});
							if($("#"+objs[i1]).length>=1){
								$("#"+objs[i1]).val("");
								$("#"+objs[i1]).val(str);
							}else{
								$("input[name='"+objs[i1]+"']").val("");
								$("input[name='"+objs[i1]+"']").val(str);
							}
						 }
				    	return true;
				    }
					 
			    },
			    cancelVal: '关闭',
			    cancel: true /*为true等价于function(){}*/
			});
		}else{
			$.dialog({
				content: "url:"+url,
				lock : true,
				title:"选择",
				width:700,
				height: 400,
				parent:windowapi,
				cache:false,
			     ok: function(){
			    	iframe = this.iframe.contentWindow;
			    	var selected = iframe.getSelectRows();
			    	if (selected == '' || selected == null ){
				    	alert("请选择");
			    		return false;
				    }else {
				    	for(var i1=0;i1<names.length;i1++){
						    var str = "";
					    	$.each( selected, function(i, n){
						    	if (i==0)
						    	str+= n[names[i1]];
						    	else{
									str+= ",";
									str+=n[names[i1]];
								}
					    	});
					    	if($("#"+objs[i1]).length>=1){
								$("#"+objs[i1]).val("");
								$("#"+objs[i1]).val(str);
							}else{
								$("[name='"+objs[i1]+"']").val("");
								$("[name='"+objs[i1]+"']").val(str);
							}
						 }
				    	return true;
				    }
					
			    },
			    cancelVal: '关闭',
			    cancel: true /*为true等价于function(){}*/
			});
		}
}
/**
 * Qdplatform Excel 导出
 * 代入查询条件
 */
function QdplatformExcelExport(url,datagridId){
	var queryParams = $('#'+datagridId).datagrid('options').queryParams;
	$('#'+datagridId+'tb').find('*').each(function() {
	    queryParams[$(this).attr('name')] = $(this).val();
	});
	var params = '&';
	$.each(queryParams, function(key, val){
		params+='&'+key+'='+val;
	}); 
	var fields = '&field=';
	$.each($('#'+ datagridId).datagrid('options').columns[0], function(i, val){
		if(val.field != 'opt'){
			fields+=val.field+',';
		}
	}); 
	window.location.href = url+ encodeURI(fields+params);
}
/**
 * 自动完成的解析函数
 * @param data
 * @returns {Array}
 */
function qdplatformAutoParse(data){
	var parsed = [];
	$.each(data.rows,function(index,row){
		parsed.push({data:row,result:row,value:row.id});
	});
	return parsed;
}

function saveObjOfAlert(){
	if(confirm('你确定要发送吗? ')){
		saveObj();
	}else{
		return true;
	}
}
		
function MysaveObjOfAlert(str,msgTempLate){
	/**$.dialog.setting.zIndex =2100;
	$.dialog.confirm('你确定要发送'+msgTempLate+'吗? ', function(){
		MysaveObj(str);
	}, function(){
	   return true;
	});*/

	if(confirm('你确定要发送'+msgTempLate+'吗? ')){
		MysaveObj(str);
	}else{
		return true;
	}
}



function SaveObjOfAlertBySpecail(str,msgTempLate,globalChangeButtonFlag,globalChangeButtonName){
	/**$.dialog.setting.zIndex =2100;
	$.dialog.confirm('你确定要发送'+msgTempLate+'吗? ', function(){
		MysaveObj(str);
	}, function(){
	   return true;
	});*/
	if(globalChangeButtonFlag){
		if(confirm('你确定要执行'+globalChangeButtonName+'操作吗? ')){
			MysaveObj(str);
		}else{
			return true;
		}
	}else{
		if(confirm('你确定要'+msgTempLate+'吗? ')){
			MysaveObj(str);
		}else{
			return true;
		}
	}
}
/**
function RejectTask(taskName,taskId,procInstId,projectId){
	var url = 'activitiController.do?goRejectTaskPage&taskName='+taskName+'&taskId='+taskId+'&procInstId='+procInstId+'&bill_id='+projectId;
	$.dialog({
		content: 'url:'+url,
		title : '退回到上一步',
		lock : true,
		opacity : 0.3,
		width:600,
		height:300,
		zIndex:2503
	});
}
*/
			
try{	
	frameElement.api.prompt = function (content, yes, value) {
        value = value || '';
        var input;
        return $.dialog({
            id: 'Prompt',
            title:'请填写说明',
            fixed: true,
            lock: true,
            opacity: .1,
            zIndex:2503,
            content: [
        '<div style="margin-bottom:5px;font-size:14px"><font color=red >',
            content,
        '</font></div>',
        '<div >',
            '<textarea style="background-color:#F9FAF3;" cols=80 rows=10>' + value + '</textarea>',
        '</div>'
        ].join(''),
            init: function () {
                input = this.DOM.content.find('textarea')[0];
                input.select();
                input.focus();
            },
            ok: function (here) {
                return yes && yes.call(this, input.value, here);
            },
            cancel: true
        });
    };
}catch(e){}
	/**
 function  RejectTask(taskName,taskId,procInstId,projectId){
    frameElement.api.prompt("", function (explain) { 
    	$('#formobj').form('submit', {
					url : "activitiController.do?doRejectTask&taskName="+taskName+"&taskId="+taskId+"&procInstId="+procInstId+"&bill_id="+projectId+"&explain="+explain,
					onSubmit : function() {
				},
				success : function(data) {
					var dataObj=eval("("+data+")");//转换为json对象 dg
					alert(dataObj.msg);
					frameElement.api.close();
					frameElement.api.opener.reloadTable();
					tip(dataObj.msg);
				}
			});
    }, "");
  }		
		*/	
  function IsFormChanged() {
    var isChanged = false;  
    var form = document.forms[0];
    for (var i = 0; i < form.elements.length; i++) {  
        var element = form.elements[i];  
        var type = element.type;  
        if (type == "text" || type == "hidden" || type == "textarea" || type == "button") {  
            if (element.value != element.defaultValue) {  
                isChanged = true;  
                break;  
            }  
        } else if (type == "radio" || type == "checkbox") {  
            if (element.checked != element.defaultChecked) {  
                isChanged = true;  
                break;  
            }  
        } else if (type == "select-one"|| type == "select-multiple") {  
            for (var j = 0; j < element.options.length; j++) {  
            	if(element.dir=='ltr'){//特殊处理，不能作为公用的一部分
            		 isChanged = false; 
            		  break; 
            	}
                if (element.options[j].selected != element.options[j].defaultSelected) {  
                    isChanged = true;  
                    break;  
                }  
            }  
        } else {   
        }       
    }      
    return isChanged;  
} 

function goMax(){
    frameElement.api.max(); 
}


/**
var x = document.body.scrollLeft; 
 var y = document.body.scrollTop;

//获取屏幕宽度
   availWidth = parseInt(window.screen.availWidth);
    availHeight = parseInt(window.screen.availHeight);

//获取可见区域 宽度 高度
   availWidth = parseInt(document.body.clientWidth);
    availHeight = parseInt(document.body.clientHeight);
         
可见区域高度:document.body.clientHeight
总高度:document.body.scrollHeight
可见区域宽度:document.body.clientWidth
总宽度:document.body.scrollWidth

==============================================================*/
function getWindowInfo(){
 var scrollX=0,scrollY=0,width=0,height=0,contentWidth=0,contentHeight=0;
 if(typeof(window.pageXOffset)=='number')
 {
  scrollX=window.pageXOffset;
  scrollY=window.pageYOffset;
 }
 else if(document.body&&(document.body.scrollLeft||document.body.scrollTop))
 {
  scrollX=document.body.scrollLeft;
  scrollY=document.body.scrollTop;
 }
 else if(document.documentElement&&(document.documentElement.scrollLeft||document.documentElement.scrollTop))
 {
  scrollX=document.documentElement.scrollLeft;
  scrollY=document.documentElement.scrollTop;
 }

if(typeof(window.innerWidth)=='number')
 {
  width=window.innerWidth;
  height=window.innerHeight;
 }
 else if(document.documentElement&&(document.documentElement.clientWidth||document.documentElement.clientHeight))
 {
  width=document.documentElement.clientWidth;
  height=document.documentElement.clientHeight;
 }
 else if(document.body&&(document.body.clientWidth||document.body.clientHeight))
 {
  width=document.body.clientWidth;
  height=document.body.clientHeight;
 }

if(document.documentElement&&(document.documentElement.scrollHeight||document.documentElement.offsetHeight))
 {
  if(document.documentElement.scrollHeight>document.documentElement.offsetHeight){
   contentWidth=document.documentElement.scrollWidth;
   contentHeight=document.documentElement.scrollHeight;
  }
  else
  {
   contentWidth=document.documentElement.offsetWidth;
   contentHeight=document.documentElement.offsetHeight;
  }
 }
 else if(document.body&&(document.body.scrollHeight||document.body.offsetHeight))
 {
  if(document.body.scrollHeight>document.body.offsetHeight)
  {
   contentWidth=document.body.scrollWidth;
   contentHeight=document.body.scrollHeight;
  }else{
   contentWidth=document.body.offsetWidth;
   contentHeight=document.body.offsetHeight;
  }
 }
 else
 {
  contentWidth=width;
  contentHeight=height;
 }
  if(height>contentHeight)
	height=contentHeight;
  if(width>contentWidth)
	width=contentWidth;
  var rect=new Object();
  rect.ScrollX=scrollX;
  rect.ScrollY=scrollY;
  rect.Width=width;
  rect.Height=height;
  rect.ContentWidth=contentWidth;
  rect.ContentHeight=contentHeight;
  return rect;
}

function tip_dialog(title,msg) {
	$.dialog.setting.zIndex = 1980;
	$.messager.show({
		title : title,
		msg : msg,
		timeout:0,
		width:250,
		height:200
		});
}
