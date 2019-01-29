<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/public.css"/>
<style type="text/css">
	.th-center{
    	text-align:center !important;
    }
    .td-center{
    	text-align:center !important;
    }
</style>
<title>菜单管理</title>
</head>
<body class="childrenBody">
<form class="layui-form" action="<%=request.getContextPath()%>/role/info.do" id="roleForm">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline a2">
                <a class="layui-btn" onclick="reload();">刷新</a>
<%--                 <c:if test="${sessionScope.btn.add == 1 }"> --%>
	                <a class="layui-btn" onclick="goAdd();">添加菜单</a>
<%--                 </c:if> --%>
            </div>
        </form>
    </blockquote>
    <div id="listTree"></div>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	function reload(){
		location.reload();
	}
	function goAdd(){
        layer.open({
            type: 2,
            title: '菜单管理-添加',
            shadeClose: true,
            shade: 0.5,
            area: ['40%', '600px'],
            content: ['<%=request.getContextPath() %>/menu/goAdd.do','yes']
        });
    }
	function goEdit(id){
        layer.open({
            type: 2,
            title: '菜单管理-编辑',
            shadeClose: true,
            shade: 0.5,
            area: ['40%', '600px'],
            content: ['<%=request.getContextPath() %>/menu/goEdit.do?id='+id,'yes']
        });
    }
	function deleteMenu(id){
		layer.confirm("确认要删除吗，删除后不能恢复", { title: "删除确认" }, function (index) {
            layer.close(index);
            $.post("<%=request.getContextPath() %>/menu/deleteMenu.do", { id: id }, function (data) {
                if(data.success == 1){
                	layer.open({
                        title:"提示",
                        content:"删除成功",
                        yes:function(){
                        	location.reload();
                        }
                    })
                }else if(data.success == 0){
                	layer.msg(data.data);
                }
            }); 
        });
	}
</script>
<script type="text/javascript">
var list = '${sessionScope.btn}'
var layout = [
    { name: '菜单名称', field:'menuname', treeNodes: true, headerClass: '', colClass: '', style: '' },
    { name: '类别', field:'type',  headerClass: '', colClass: '', style: '', render: function(row){
    	var show = '菜单类型';
    	if(row.type == '1'){
    		show = '<span class="layui-badge-rim">菜单</span>';
    		
    	}else if(row.type == '2'){
    		show = '<span class="layui-badge layui-bg-gray">按钮</span>';
    	}
    	return show;
    }},
    { name: '排序', field:'sequence', headerClass: '', colClass: '', style: '' },
    { name: '图标', field:'iconremark',  headerClass: '', colClass: '', style: '', render: function(row){
    	if(row.type == '1'){
	    	if(row.iconremark != ''){
	    		return '<i class="'+row.iconremark+'"></i>';
	    	}else{
		    	return '<i class="layui-icon layui-icon-template-1"></i>';
	    	}
    	}else{
    		return "-";
    	}
    }},
    { name: '唯一标识', field:'roleids',  headerClass: '', colClass: '', style: '', render: function(row){
    	if(row.type == '1'){
    		return "-";
    	}else{
    		return row.roleids;
    	}
    }},
    { name: '链接', field:'menuurl',  headerClass: '', colClass: '', style: '' },
    { name: '操作',  headerClass: 'th-center', colClass: 'td-center',fixed: 'right', render: function(row){
    	var html = ''; 
    		if('${sessionScope.btn.edit}' == '1'){
	    		html += '<a class="layui-btn layui-btn-xs"  onclick="javascript:goEdit(\''+row.id+'\');" title="编辑">编辑</a>';
    		}
    		if('${sessionScope.btn.del}' == '1'){
	    		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  onclick="javascript:deleteMenu(\''+row.id+'\');" title="删除">删除</a>';
    		}
    		
    	return html;
    }}
];

layui.use(['form', 'tree', 'layer'], function() {
    var layer = layui.layer, form = layui.form, $ = layui.jquery;

    var tree1 = layui.treeGird({
        elem: '#listTree', //传入元素选择器
        spreadable: false, //设置是否全展开，默认不展开
        checkbox : false,
        nodes: ${menuList},
        layout: layout
    });
    
    form.render();
    
    var arr = layui.getSelected(tree1);
    console.log(arr.length)
});
</script>
</body>
</html>