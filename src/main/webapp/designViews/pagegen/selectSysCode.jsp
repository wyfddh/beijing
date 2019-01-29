<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<t:base type="jquery"></t:base>
<link rel="stylesheet" href="plug-in/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="plug-in/zTree/js/jquery.ztree.core-3.5.js"></script>
	
<link href="plug-in/ace/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="plug-in/ace/assets/css/font-awesome.min.css" />
<!--[if IE 7]>
  <link rel="stylesheet" href="plug-in/ace/assets/css/font-awesome-ie7.min.css" />
<![endif]-->
<!-- page specific plugin styles -->
<link rel="stylesheet" href="plug-in/ace/assets/css/jquery-ui-1.10.3.custom.min.css" />
<!-- ace styles -->
<link rel="stylesheet" href="plug-in/ace/assets/css/ace.min.css" />
<link rel="stylesheet" href="plug-in/ace/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="plug-in/ace/assets/css/ace-skins.min.css" />
<!--[if lte IE 8]>
  <link rel="stylesheet" href="plug-in/ace/assets/css/ace-ie.min.css" />
<![endif]-->
<!-- inline styles related to this page -->
<!-- ace settings handler -->
<script src="plug-in/ace/assets/js/ace-extra.min.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="plug-in/ace/assets/js/html5shiv.js"></script>
<script src="plug-in/ace/assets/js/respond.min.js"></script>
<![endif]-->
	
	
	
<script type="text/javascript">

/**
var dg;
$(document).ready(function(){
	dg = frameElement.api,W = dg.opener;
	dg.button({
		id:'saveButton',
		name : '确定',
		callback : function() {
				var zTree = $.fn.zTree.getZTreeObj("id_treeDemo"),
				nodes = zTree.getSelectedNodes();
				if (nodes.length == 0) {
					alert("请选择!");
					return false;
				}else{
					W.document.getElementById(dg.data.codeId).value=nodes[0].id;
					W.document.getElementById(dg.data.codeNameId).value=nodes[0].name;
					//dg.opener.returnDepartSelect(nodes);
				}
			return true;
		}
	},{
		id:'closeButton',
		name : '关闭',
		callback : function() {
			return true;
		}
	});
});
*/
</script>
</head>
<body >
<div class="main-container" id="main-container">
<input  id="codeId" style="width:80%;" type="hidden" name="codeId" value="">
<input  id="codeNameId" style="width:80%;" type="hidden"  name="codeNameId"  value="">
<input  id="isParentId" style="width:80%;" type="hidden"  name="isParentId"  value="">
<div class="col-xs-12">
<div class="form-actions" style="margin:0px;padding:0px;">
	<div class="input-group">
		<input  id="search_condition" style="width:80%;" placeholder="请输入搜索条件" type="text" class="form-control" name="message">
		<span class="input-group-btn">
			<div class="btn btn-sm btn-info no-radius"  onclick="searchM()" type="button">
				搜索
			</div>
		</span>
	</div>
</div>
</div>
	<div class="col-xs-12" >
		<ul id="id_treeDemo" class="ztree"></ul>
	</div>
</div>
</body>
</html>

<SCRIPT type="text/javascript">
	//初始化树
	var setting = {
		view:{expandSpeed:($.browser.msie && parseInt($.browser.version) <= 6) ? "" : "fast"},
		data:{simpleData:{enable:true}},
		callback:{onClick:zTreeOnClick}
	};
	function zTreeOnClick(event, treeId, treeNode){
		$("#codeId").val(treeNode.code);
		$("#codeNameId").val(treeNode.name);
		$("#isParentId").val(treeNode.isParent);
	}
	function searchM(){
		$.ajax({
			url: "listPageGenController.do?getSelectSysCode1&defVal=${defVal}&typegroupCode=${typegroupCode}",
			type: "POST",dataType: "json",//async: false,
			data: {param: $.trim($("#search_condition").val())},
			success: function(data) {
				if(data!=null){
					var treeObj = $.fn.zTree.init($("#id_treeDemo"), setting, data);
					//treeObj.expandAll(true); //展开所有节点
					var nodes = treeObj.transformToArray(treeObj.getNodes()); //获取所有节点
					for(var i=0; i<nodes.length; i++){
						if(!nodes[i].isParent) break;
						treeObj.expandNode(nodes[i], true);
					}
				}
			}
		});
	}
	$(document).ready(function() {
		searchM();
	});
/**
		var setting = {
			view: {
				selectedMulti: false,
				dblClickExpand:false,
				expandSpeed: ($.browser.msie && parseInt($.browser.version)<=6)?"":"fast"
				
			},
			async: {
				enable: true,
				url:"listPageGenController.do?getSelectSysCode&defVal=${defVal}&typegroupCode=${typegroupCode}",
				autoParam:["id", "name=n", "level=lv"],
				otherParam:{"otherParam":"zTreeAsyncTest"},
				dataFilter: filter
			},
			data: {
			    simpleData: {
			      enable:true,
			      idKey: "id",
			      pIdKey: "pId",
			      rootPId: "root"
			    }
			  },
			callback: {
				beforeAsync: beforeAsync,
				onAsyncError: onAsyncError,
				onAsyncSuccess: onAsyncSuccess,
				onClick: onClick,
				onNodeCreated: zTreeOnNodeCreated
			}
		};

		function filter(treeId, parentNode, childNodes) {
			if (!childNodes) return null;
			for (var i=0, l=childNodes.length; i<l; i++) {
				childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
			}
			return childNodes;
		}
		var log, className = "dark";
		function beforeAsync(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" beforeAsync ]&nbsp;&nbsp;&nbsp;&nbsp;" + ((!!treeNode && !!treeNode.name) ? treeNode.name : "root") );
			return true;
		}
		function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
			showLog("[ "+getTime()+" onAsyncError ]&nbsp;&nbsp;&nbsp;&nbsp;" + ((!!treeNode && !!treeNode.name) ? treeNode.name : "root") );
		}
		function onAsyncSuccess(event, treeId, treeNode, msg) {
			showLog("[ "+getTime()+" onAsyncSuccess ]&nbsp;&nbsp;&nbsp;&nbsp;" + ((!!treeNode && !!treeNode.name) ? treeNode.name : "root") );
		}
		
		function showLog(str) {
			if (!log) log = $("#log");
			log.append("<li class='"+className+"'>"+str+"</li>");
			if(log.children("li").length > 8) {
				log.get(0).removeChild(log.children("li")[0]);
			}
		}
		function getTime() {
			var now= new Date(),
			h=now.getHours(),
			m=now.getMinutes(),
			s=now.getSeconds(),
			ms=now.getMilliseconds();
			return (h+":"+m+":"+s+ " " +ms);
		}

		function refreshNode(e) {
			var zTree = $.fn.zTree.getZTreeObj("id_treeDemo"),
			type = e.data.type,
			silent = e.data.silent,
			nodes = zTree.getSelectedNodes();
			if (nodes.length == 0) {
				alert("请先选择一个父节点");
			}
			for (var i=0, l=nodes.length; i<l; i++) {
				zTree.reAsyncChildNodes(nodes[i], type, silent);
				if (!silent) zTree.selectNode(nodes[i]);
			}
		}

		$(document).ready(function(){
			$.fn.zTree.init($("#id_treeDemo"), setting);
			$("#refreshNode").bind("click", {type:"refresh", silent:false}, refreshNode);
			$("#refreshNodeSilent").bind("click", {type:"refresh", silent:true}, refreshNode);
			$("#addNode").bind("click", {type:"add", silent:false}, refreshNode);
			$("#addNodeSilent").bind("click", {type:"add", silent:true}, refreshNode);
		});
		
		function onClick(e,treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("id_treeDemo");
			var isParent = treeNode.isParent;
			document.getElementById("isParentId").value=isParent;
			document.getElementById("codeId").value=treeNode.code;
			document.getElementById("codeNameId").value=treeNode.name;
			zTree.expandNode(treeNode);
		}
		
		
		function searchM() {
			  var param = $.trim($("#search_condition").val());
			  var treeObj = $.fn.zTree.getZTreeObj("id_treeDemo");
			  var node = treeObj.getNodeByParam("id", 0, null);
			  if(param != ""){
			    treeObj.setting.async.otherParam=["param", param];
			  }else {
			    //搜索参数为空时必须将参数数组设为空
			    treeObj.setting.async.otherParam=[];
			  }
			  treeObj.reAsyncChildNodes(node, "refresh");
			}

			function zTreeOnNodeCreated(event, treeId, treeNode) {
			  var param = $.trim($("#search_condition").val());
			  var treeObj = $.fn.zTree.getZTreeObj("id_treeDemo");
			  //只有搜索参数不为空且该节点为父节点时才进行异步加载
			  if(param != "" && treeNode.isParent){
			    treeObj.reAsyncChildNodes(treeNode, "refresh");
			  } 
			};
		
		
		
		//-->
*/
</SCRIPT>

