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
                    <input type="text" lay-search class="layui-input searchVal" id="phone" name="phone" placeholder="模糊搜索账号" />
                </div>
                <div class="layui-input-inline">
                    <select id="org_id" name="org_id" lay-search>
                    	<option value="">全部</option>
                    	<c:if test="${orgList != null }">
                    		<c:forEach items="${orgList }" var="org" >
                    			<option value="${org.id }">${org.name }</option>
                    		</c:forEach>
                    	</c:if>
                    </select>
                </div>
                <button lay-submit class="layui-btn search_btn" lay-filter="search">搜索</button>
            </div>

            <div class="layui-inline a2">
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </form>
    </blockquote>
    <table id="logList" lay-filter="logList"></table>
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
        elem: '#logList',
        url : '<%=request.getContextPath() %>/mipLog/getLogList.do',
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
            {field: 'updateby', title: '姓名'},
            {field: 'orgName', title: '所属组织'},
            {field: 'phone', title: '登陆账号'},
            {field: 'createtime', title: '操作时间'},
            {field: 'ip', title: '操作IP'},
            {field: 'status', title: '登陆状态',templet:function(d){
            	var html = "";
            	if(d.status == 0){
//             		html = "通用密码登录操作失败";
            		html = "<font color='red'>登录操作失败</font>";
            	}else if(d.status == 1){
            		html = "<font color='green'>登录操作成功</font>";
//             		html = "通用密码登录操作成功";
            	}else if(d.status == 2){
            		html = "<font color='green'>登录操作成功</font>";
            	}else if(d.status == 3){
            		html = "<font color='red'>登录操作失败</font>";
            	}else {
            		html = "<font color='red'>空</font>";
            	}
            	return html;
            }}
        ]]
    });
    form.on('submit(search)', function(data){
    	if($("#phone").val() == '' && $("#org_id").val() == ''){
    		layer.msg("请输入筛选条件");
    	}
        tableIns.reload({
           page: {
               curr: 1 //重新从第 1 页开始
           },
           where: {
          	 phone: $("#phone").val(),  //搜索的关键字
          	 org_id: $("#org_id").val()  //搜索的关键字
           }
        })
        return false;
    });
	
});
	
</script>
</body>
</html>