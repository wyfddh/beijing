$.fn.panel.defaults.onBeforeDestroy = function() {/* tab关闭时回收内存 */
	var frame = $('iframe', this);
	try {
		if (frame.length > 0) {
			frame[0].contentWindow.document.write('');
			frame[0].contentWindow.close();
			frame.remove();
			if ($.browser.msie) {
				CollectGarbage();
			}
		} else {
			$(this).find('.combo-f').each(function() {
				var panel = $(this).data().combo.panel;
				panel.panel('destroy');
			});
		}
	} catch (e) {
	}
};
$.parser.onComplete = function() {/* 页面所有easyui组件渲染成功后，隐藏等待信息 */
	if ($.browser.msie && $.browser.version < 7) {/* 解决IE6的PNG背景不透明BUG */
	}
	window.setTimeout(function() {
		window.top.$.messager.progress('close');
	}, 200);
};
/**
 * 部署流程图
 * 
 * @param deploymentId
 * @param resourceName
 */
function deploymentimg(deploymentId, resourceName,title) {
	if (typeof (title) == 'undefined') {
		title = "";
	}
	openwindow('流程部署详细图--'+title, 'activitiController.do?openProcessPic&tag=deployment&deploymentId=' + deploymentId + '&resourceName=' + resourceName);
}
/**
 * 办理过程流程图
 * 
 * @param taskId
 */
function processimg(taskId, title,width,height) {
	if (typeof (title) == 'undefined') {
		title = "";
	}
	if (typeof (width) == 'undefined') {
		width = "";
	}
	if (typeof (height) == 'undefined') {
		height = "";
	}
	openwindow('流程进度--当前节点:' + title, 'activitiController.do?openProcessPic&tag=task&taskId=' + taskId,'',width,height);
}
/**
 * 项目列表流程图查看
 * @param taskId
 * @param title
 * @param width
 * @param height
 */
function progress(busKey, title,width,height) {
	if (typeof (title) == 'undefined') {
		title = "";
	}
	if (typeof (width) == 'undefined') {
		width = "";
	}
	if (typeof (height) == 'undefined') {
		height = "";
	}
	openwindow('流程进度--当前节点:' + title, 'activitiController.do?openProcessPic&tag=project&businessKey='+ busKey,'',width,height);
}
/**
 * 打开流程办理页面
 */
function openhandle(taskId, title, width, height) {
	if (typeof (width) == 'undefined') {
		width = "auto";
	}
	if (typeof (height) == 'undefined') {
		height = "auto";
	}
	if (typeof (title) == 'undefined') {
		title = "";
	}
	var url = 'activitiController.do?openProcessHandle&taskId=' + taskId;
	$.dialog({
		content: 'url:'+url,
		title : '流程办理--当前环节:' + title,
		lock : true,
		opacity : 0.3,
		button : [ {
			name : '同意',
			callback : function() {
				iframe = this.iframe.contentWindow;
				var inputvar = $("[vartype]", iframe.document);
				setvar(true, inputvar, iframe);
				saveObj();
				return false;

			},
			focus : true
		}, {
			name : '驳回',
			callback : function() {
				iframe = this.iframe.contentWindow;
				var inputvar = $("[vartype]", iframe.document);
				setvar(false, inputvar, iframe);
				saveObj();
				return false;
			}
		} ]
	});
}
/**
 * 打开流程办理页面 - New (新的流程办理页面包括"表单信息","任务处理","流程跟踪")
 */
function openhandleMix(taskId, title, width, height) {
	if (typeof (width) == 'undefined') {
		width = "auto";
	}
	if (typeof (height) == 'undefined') {
		height = "auto";
	}
	if (typeof (title) == 'undefined') {
		title = "";
	}
	var url = 'taskController.do?goTaskTab&taskId=' + taskId;
	$.dialog({
		content: 'url:'+url,
		title : '流程办理--当前环节:' + title,
		lock : true,
		opacity : 0.3,
		width:900,
		height:480,
		button : [{
			name : '关闭',
			callback : function() {
				iframe = this.iframe.contentWindow;
				return true;
			}
		} ]
	});
}
/**
 * 设置流程变量
 * 
 * @param flag
 *          操作标示
 * @param varobj//作为流程变量的对象集合
 * @param iframe//页面对象
 */
function setvar(flag, varobj, iframe) {
	var keys = "opt,", values = flag + ",", types = "B,", tag = "";
	if (!flag) {
		// tag="Back";//驳回操作时变量添加后缀
	}
	varobj.each(function() {
		var value = this.value;
		if (value == "") {
			if (flag) {
				value = "同意";
			} else {
				value = "不同意";
			}
		}
		keys += this.id + tag + ",";
		values += value + ",";
		types += $("#" + this.id, iframe.document).attr("vartype") + ",";
	});
	$("#keys", iframe.document).val(keys);
	$("#values", iframe.document).val(values);
	$("#types", iframe.document).val(types);
}


/**
 * 设置流程变量
 * 
 * @param flag
 *          操作标示
 * @param varobj//作为流程变量的对象集合
 * @param iframe//页面对象
 */
function setvarDocument(flag, varobj, obj) {
	var keys = "opt,", values = flag + ",", types = "B,", tag = "";
	if (!flag) {
		// tag="Back";//驳回操作时变量添加后缀
	}
	alert(1);
	varobj.each(function() {
		var value = this.value;
		if (value == "") {
			if (flag) {
				value = "同意";
			} else {
				value = "不同意";
			}
		}
		keys += this.id + tag + ",";
		values += value + ",";
		types += $("#" + this.id, obj).attr("vartype") + ",";
	});
	alert(2);
	$("#keys", obj).val(keys);
	$("#values", obj).val(values);
	$("#types", obj).val(types);
	alert($("#keys", obj).val());
}

/**
 * 选择委托人
 * 
 * @param taskId
 */
function selectEntruster(taskId, title) {
	if (typeof (title) == 'undefined') {
		title = "";
	}
	createwindow('选择委托人' + title, 'activitiController.do?goEntrustAdd&tag=task&taskId=' + taskId,450,150);
}
