<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/iconSelect/iconpick.css"/>
<style type="text/css">
ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:360px;overflow-y:scroll;overflow-x:auto;}
</style>
<title>菜单管理-添加</title>
</head>
<body style="background:#fff;padding:10px">
<form class="layui-form" id="newForm">
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">菜单名称</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input inputText" lay-verify="required" placeholder="请输入菜单名称" id="menuname" name="menuname" style="width:300px">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">菜单类型</label>
		<div class="layui-input-block" style="width:300px">
	      <select class="layui-select" name="type" id="type" lay-filter="type" lay-verify="required" style="width:300px">
              <option value="1">菜单类型</option>
              <option value="2">按钮类型</option>
	      </select>
	    </div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">菜单链接</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input inputText" placeholder="请输入菜单链接" id="menuurl" name="menuurl" style="width:300px">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">上级菜单</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input inputText" lay-verify="required" placeholder="请选择上级菜单" id="parentname" readonly onclick="showMenu();" style="width:300px"/>
            <input type="hidden" id="parentid" name="parentid" value="">
		</div>
	</div>
	<div id="menuContent" class="menuContent" style="display:none; position: absolute;background-color: #fff;border: 1px;z-index:999;">
		<ul id="treeDemo" class="ztree" style="margin-top:0; width:290px; height: 300px; background-color: fff;"></ul>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">菜单排序</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input inputText" placeholder="请输入菜单排序，不填则默认为0" id="sequence" name="sequence" value="0" style="width:300px">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">菜单图标</label>
		<div class="layui-input-block">
			<a class="layui-btn layui-btn-primary" id="iconSelect"><i class="layui-icon layui-icon-template-1"></i></a>
			<input type="text" class="layui-input inputText" placeholder="菜单图标样式，默认：layui-icon layui-icon-template-1" id="iconremark" name="iconremark" style="width:235px;display:inline-table;" readonly="readonly">
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
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/iconSelect/iconpick.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/zTree/v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/zTree/v3/js/jquery.ztree.excheck-3.5.js"></script>
<!--/_footer /作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
//设置模块
layui.config({
	base: '<%=request.getContextPath() %>/back/lib/layui/iconSelect/'//模块存放的目录
}).extend({ //设定模块别名
    common:'iconpick'
});
layui.use(['form','layer','iconpick'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    var iconpick = layui.iconpick;
		
    function valiOnlyName(){
    	var roleids = $("#roleids").val();
    	var parentid = $("#parentid").val();
    	var result = false;
    	if(roleids == ''){
    		return false;
    	}
    	if(parentid == ''){
    		parentid = '0';
    	}
    	$.ajax({
            url:"<%=request.getContextPath() %>/menu/valiOnlyName.do",
            data:{roleids:roleids, parentid:parentid},
            type:"POST",
            async: false,
            success:function(msg){
                if(msg.success == 1){
                	result = true;
                }
            }
        });
    	return result;
    }
    
    form.verify({
	    num:[/^([\d]{11})?$/,'请输入正确手机号']      
	}); 
    form.on("submit(save)",function(data){
    	if($("#menuname").val() == ""){
            layer.open({
                title:"提示",
                content:"您还没有填写名称"
            })
        }else if($("#type").val() == ""){
            layer.open({
                title:"提示",
                content:"您还没有选择类型"
            })
        }else {
        	if($("#type").val() != '2'){
        		$("#roleids").val("");
        	}
        	$.ajax({
	            url:"<%=request.getContextPath() %>/menu/saveInfo.do",
	            data:$("#newForm").serialize(),
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
        }
       return false;
    });
    
  //用法
   iconpick.pickinit('iconSelect','iconremark');
  
   form.on('select(type)', function(data){
	   if(data.value == '2'){
		   $("#onlyString").removeClass('layui-hide');
	   }else{
		   $("#onlyString").addClass('layui-hide');
	   }
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

var zNodes =${treeNode};

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
	$("#parentid").val(vid);
	hideMenu();
}

function showMenu() {
	var cityObj = $("#parentname");
	var cityOffset = $("#parentname").offset();
	$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

	$("body").bind("mousedown", onBodyDown);
}
function hideMenu() {
	$("#menuContent").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown);
}
function onBodyDown(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "parentname" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
		hideMenu();
	}
}

$(document).ready(function(){
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
});
</script>
</body>
</html>