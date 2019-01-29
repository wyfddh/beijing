<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/public.css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/back/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<title>栏目-新增</title>
<style type="text/css">
ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:360px;overflow-y:scroll;overflow-x:auto;}
</style>
</head>
<body style="background:#fff;padding:10px">
<form class="layui-form" id="form">
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">栏目名称</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input inputText" lay-verify="required" placeholder="这里输入名称" value="${name }" name="name" id="name" style="width:300px">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">栏目唯一名称</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input inputText" lay-verify="required" placeholder="这里输入唯一名称（英文字母）" value="${uniqueName }" name="uniqueName" id="uniqueName" style="width:300px" onkeyup="this.value=this.value.replace(/[^a-zA-Z]/g,'')">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">栏目类别</label>
		<div class="layui-input-block" style="width: 300px;">
			<select class="layui-select" name="type" id="type" lay-verify="required" style="width:300px">
              <option value="">请选择</option>
              <option value="1">新闻动态</option>
              <option value="2">通知公告</option>
              <option value="3">学术书刊</option>
              <option value="4">学术论文</option>
              <option value="5">专家舞台</option>
	      </select>
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">上级栏目</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input inputText" placeholder="这里选择上级栏目" id="parentname" readonly onclick="showTree();" style="width:300px"/>
            <input type="hidden" id="fId" name="fId" value="${fId }">
		</div>
	</div>
	<div id="menuContent" class="menuContent" style="display:none; position: absolute;background-color: #fff;border: 1px;z-index:999;">
		<ul id="treeDemo" class="ztree" style="margin-top:0; width:290px; height: 300px; background-color: fff;"></ul>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">描述</label>
		<div class="layui-input-block">
			<textarea type="text" class="layui-textarea textarea" placeholder="这里输入描述" value="${description }" name="description" id="description" row="3" style="width:300px;resize:none;">${description }</textarea>
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12" style="margin-top:20px;">
		<div class="layui-input-block">
			<button class="layui-btn layui-btn-sm" lay-submit lay-filter="save">保存</button>
			<button type="reset" class="layui-btn layui-btn-sm layui-btn-primary" lay-filter="close" id="close">取消</button>
		</div>
	</div>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/zTree/v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/zTree/v3/js/jquery.ztree.excheck-3.5.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
		
    form.on("submit(save)",function(data){
    	//判断唯一名称是否已使用
		var isExist = checkUniqueName($("#uniqueName").val(), '')
		if(isExist){
			layer.msg("已经使用过此栏目唯一名称，请更换");
			$("#uniqueName").focus();
			return false;
		}
    	if($("#name").val() == ''){
   			layer.msg("您还没有填写栏目名称");
    	}else if($("#uniqueName").val() == ''){
    		layer.msg("您还没有填写栏目唯一名称");
    	}else if($("#type").val() == ''){
    		layer.msg("您还没有选择栏目类别");
    	}else{
    		if($("#fId").val() == ''){
    			$("#fId").val("100");
    		}
	    	$.ajax({
	          	url:"<%=request.getContextPath() %>/cmsSubject/saveSubject.do",
	            data:$("#form").serialize(),
	            type:"POST",
	            dataType: 'json',
	            success:function(msg){
	                if(msg.success == 1){
	                	layer.msg('保存成功', {icon: 1});
	                	setTimeout(function(){
	    					close();
	    				},700);
	                }else if(msg.success == 0){
	                	top.layer.msg(msg.data, {icon: 1});
	    				setTimeout(function(){
	    					close();
	    				},1000);
	                }
	            }
	        });
    	}
       return false;
    });
    
})

//关闭
$("#close").click(function(){
	close();
});

function close(){
	layer.closeAll();
    parent.location.reload();
}
/**
*返回true：存在
*返回false： 不存在
*/
function checkUniqueName(name, id){
	var isTrue = true;	//默认已经存在
	$.ajax({
		url : "<%=request.getContextPath() %>/cmsSubject/checkUniqueName.do",
		type : "post",
		data : {uniqueName:name, id:id},
		dataType : "json",
		async: false,
		success : function(data) {
			if (data.success == 1) {
				if (data.data == 0) {		//除了自己，其他未使用
					isTrue = false;
				}
			}
		}
	});
	return isTrue;
}
</script>
<script type="text/javascript">
var setting = {
	check: {
		enable: true,
		chkStyle: "radio",
		radioType: "all"   //对所有节点设置单选
	},
	view: {
		dblClickExpand: false
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		onClick: onClick,
		onCheck: onCheck
	}
};

var zNodes =${nodeList};

function onClick(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.checkNode(treeNode, !treeNode.checked, null, true);
	return false;
}

function onCheck(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
	nodes = zTree.getCheckedNodes(true),
	v = "";
	var vid = "";
	for (var i=0, l=nodes.length; i<l; i++) {
		v += nodes[i].name + ",";
		vid += nodes[i].id + ",";
	}
	if (v.length > 0 ) v = v.substring(0, v.length-1);
	if (vid.length > 0 ) vid = vid.substring(0, vid.length-1);
	var cityObj = $("#parentname");
	cityObj.attr("value", v);
	$("#fId").val(vid);
	hideTree();
}

function showTree() {
	var cityObj = $("#parentname");
	var cityOffset = $("#parentname").offset();
	$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

	$("body").bind("mousedown", onBodyDown);
}
function hideTree() {
	$("#menuContent").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown);
}
function onBodyDown(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "parentname" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
		hideTree();
	}
}

$(document).ready(function(){
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	/* zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
	var node = zTree_Menu.getNodeByParam("id","${fId }");
	$("#parentname").val(node.name);
	zTree_Menu.selectNode(node,true);//指定选中ID的节点
	zTree_Menu.expandNode(node, true, false);//指定选中ID节点展开 */
});
</script>
</body>
</html>