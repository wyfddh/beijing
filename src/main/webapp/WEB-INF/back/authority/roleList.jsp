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
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/public.css"/>
    <!--/meta 作为公共模版分离出去-->
    <style type="text/css">
        /* .text-c th{
      		text-align:center;
      	} */
    </style>
    <title>角色管理</title>
</head>
<body class="childrenBody">
<form class="layui-form" id="roleForm">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" class="layui-input searchVal" id="roleName" name="roleName" placeholder="模糊搜索角色名称" />
                </div>
                <button lay-submit class="layui-btn search_btn" lay-filter="search">搜索</button>
            </div>

            <div class="layui-inline a2">
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
            <div class="layui-inline a2">
            	<c:if test="${sessionScope.btn.add == 1 }">
	                <a class="layui-btn addNews_btn" onclick="javascript:goAdd();">添加角色</a>
            	</c:if>
            </div>
        </form>
    </blockquote>
    <table id="roleList" lay-filter="roleList"></table>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript">
layui.use(['form','layer','table', 'laydate'],function(){
	var form = layui.form,
    layer = parent.layer === undefined ? layui.layer : top.layer,
    $ = layui.jquery,
    table = layui.table,
	laydate = layui.laydate;
	
	//用户列表
    var tableIns = table.render({
        elem: '#roleList',
        url : '<%=request.getContextPath() %>/role/getListInfo.do',
        cellMinWidth : 80,
        request:{
        	pageName: 'currentPage',
        	limitName: 'size'
        },
        page : true,
        limits : [10,20,25],
        limit : 10,
        id : "roleListTable",
        cols : [[
            {type:"numbers", title: '序号'},
            {field: 'roleName', title: '角色名称'},
            {field: 'remark', title: '备注'},
            {field: 'createTime', title: '创建时间'},
            {title: '操作',align:"center",fixed: 'right',templet:function(d){
            	var html = ''; 
            		if('${sessionScope.btn.edit }' == '1'){
	        			html += '<a class="layui-btn layui-btn-xs"  href="javascript:edit(\''+d.id+'\', \''+d.roleName+'\');" title="编辑">编辑</a>';
            		}
            		if('${sessionScope.btn.config }' == '1'){
	           			html += '<a class="layui-btn layui-btn-xs"  href="javascript:edit1(\''+d.id+'\', \''+d.roleName+'\');" title="权限配置">权限配置</a>';
            		}
            		if('${sessionScope.btn.del }' == '1'){
	            		html += '<a class="layui-btn layui-btn-xs layui-btn-danger"  href="javascript:deleteRole(\''+d.id+'\');" title="删除">删除</a>';
            		}
            	return html;
            }}
        ]]
    });
    form.on('submit(search)', function(data){
    	if($("#roleName").val() == ''){
    		layer.msg("请输入筛选条件");
    	}
        tableIns.reload({
           page: {
               curr: 1 //重新从第 1 页开始
           },
           where: {
          	 roleName: $("#roleName").val(),  //搜索的关键字
           }
        })
        return false;
    });
	
    window.edit = function(value, name){
		layer.open({
            type: 2,
            title: '角色管理-编辑',
            shadeClose: true,
            shade: 0.5,
            area: ['500px', '500px'],
            content: ['<%=request.getContextPath() %>/role/goEdit.do?id='+value,'yes'],
            yse:function (index, layero) {
		          layer.close(index); //关闭弹层
	        },
            end :function() {
        		tableIns.reload();
          	}
        });
    }
    window.goAdd = function(){
        layer.open({
            type: 2,
            title: '角色管理-添加',
            shadeClose: true,
            shade: 0.5,
            area: ['500px', '500px'],
            content: ['<%=request.getContextPath() %>/role/goAdd.do','yes'],
            yse:function (index, layero) {
		          layer.close(index); //关闭弹层
	        },
            end :function() {
        		tableIns.reload();
          	}
        });
    }
    window.edit1 = function(value, name){
		layer.open({
            type: 2,
            title: '角色管理-权限配置',
            shadeClose: true,
            shade: 0.5,
            area: ['400px', '650px'],
            content: ['<%=request.getContextPath() %>/role/goEditAuthor.do?id='+value,'yes'],
            yse:function (index, layero) {
		          layer.close(index); //关闭弹层
	        },
            end :function() {
        		tableIns.reload();
          	}
        });
    }
    window.deleteRole = function(id){
		layer.confirm("确认要删除吗，删除后不能恢复", { title: "删除确认" }, function (index) {
            layer.close(index);
            $.post("<%=request.getContextPath() %>/role/deleteRole.do", { roleId: id }, function (data) {
                if(data.success == 1){
                	tableIns.reload();
                	layer.msg('删除成功');
                }else if(data.success == 0){
                	layer.msg(data.data);
                }
            }); 
        });
	}
});
	
</script>
</body>
</html>