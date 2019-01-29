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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css">
<style type="text/css">
	ul.ztree {margin-top: 10px;width:220px;}
</style>
<title>角色管理-权限配置</title>
</head>
<body style="background:#fff;padding:10px">
<form class="layui-form">
	<input type="hidden" id="roleid" nam="roleid" value="${roleid }">
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
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
		
    form.verify({
	    num:[/^([\d]{11})?$/,'请输入正确手机号']      
	}); 
    form.on("submit(save)",function(data){
    	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = treeObj.getCheckedNodes(true);
		console.log(nodes);
		var roleid = $("#roleid").val();
		var ids = "";
		for (var i = 0; i < nodes.length; i++) {
			ids += nodes[i].id + ","
		}
		if(ids.length > 0){
			ids = ids.substring(0, ids.length-1);
		}
		$.ajax({
          	url:"<%=request.getContextPath() %>/roleMenu/authorityEdit.do",
            data:{roleid:roleid, menus:ids},
            type:"POST",
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
       return false;
    });
})

//关闭
$("#close").click(function(){
	close();
});

function close(){
	var index=parent.layui.layer.getFrameIndex(window.name);
	parent.layui.layer.close(index);
}
</script>
<script type="text/javascript">
var setting = {
	check: {
		enable: true,
		chkboxType: {"Y": "", "N": ""}
	},
	view: {
		showLine: false
	},
	data: {
		simpleData: {
			enable: true
		}
	}
};

var zNodes =${menuZtreeList};

$(document).ready(function(){
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
// 	setting.check.chkboxType = { "Y" : "", "N" : "" };
});

</script>
</body>
</html>