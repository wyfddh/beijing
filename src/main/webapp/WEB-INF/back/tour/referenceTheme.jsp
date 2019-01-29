<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="java.util.*,java.io.*"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="<%=request.getContextPath()%>/back/favicon.ico">
    <link rel="Shortcut Icon" href="<%=request.getContextPath()%>/back/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/css/cover.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/2.4/css/layui.css"/>
    <!--/meta 作为公共模版分离出去-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
    <!--/meta 作为公共模版分离出去-->
    <style type="text/css">
        .textHidden{max-width:70%; white-space:nowrap;overflow:hidden;text-overflow:ellipsis; }
    </style>
    <title>文创产品-列表</title>
    <style type="text/css">
        .layui-table-cell .layui-form-radio{
            margin-top: 30%;
        }
    </style>
</head>
<body class="childrenBody">
<form class="layui-form" id="roleForm">
    <table id="noticeList" lay-filter="noticeList"></table>
    <div class="layui-form-item layui-row layui-col-xs12" style="margin-top:40px;margin-right: 100px">
        <div class="layui-input-block">
            <input class="btn btn-primary-outline radius size-s" type="button" id="back"  value="取消">
            <input class="btn btn-primary-outline radius size-s" type="button" id="save" value="引用">
        </div>
    </div>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/2.4/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript">
    layui.use(['form','layer','table', 'laydate'],function(){
        var form = layui.form;
            layer = parent.layer === undefined ? layui.layer : top.layer;
            $ = layui.jquery;
            table = layui.table;
            laydate = layui.laydate;

        //用户列表
        var tableIns = table.render({
            elem: '#noticeList',
            url : '<%=request.getContextPath() %>/tour/getThemeData.do',
            cellMinWidth : 80,
            request:{
                pageName: 'currentPage',
                limitName: 'size'
            },
            page : true,
            limits : [10],
            limit : 10,
            id : "noticeListTable",
            cols : [[
                {type:'radio'},
                {field: 'name', title: '专题名称'},
                {field: 'collectionCount', title: '藏品数量'},
                {field: 'publishOrgName', title: '发布单位'}
            ]]
        });

        window.saveTheme = function () {
            var checkStatus = layui.table.checkStatus('noticeListTable').data;
            var id = checkStatus[0].id;

            console.log(id);
            $.post("<%=request.getContextPath() %>/tour/saveTheme.do", { mipTopicId: id }, function (data) {
                if(data.success == 1){
                    close();
                    /* layer.msg('保存成功'); */
                    window.location.href="<%=request.getContextPath() %>/tour/goEdit.do?id="+data.data;
                }else if(data.success == 0){
                    layer.msg(data.msg);
                }
            });
        }
    });
    
    

    function close(){
        var index=parent.layui.layer.getFrameIndex(window.name);
        parent.layui.layer.close(index);
    }

    $("#back").click(function(){
        var index=parent.layui.layer.getFrameIndex(window.name);
        parent.layui.layer.close(index);
    });
    
    $("#save").click(function () {
        var checkStatus = layui.table.checkStatus('noticeListTable').data;
        var id = checkStatus[0].id;
        $.ajax({
            url:"<%=request.getContextPath() %>/tour/saveTheme.do",
            data:{ mipTopicId: id },
            type:"POST",
            success:function(data){
                if(data.success == 1){
                    window.location.href="<%=request.getContextPath() %>/tour/goEdit.do?id="+data.data.id;
                }else{
                    layer.msg(msg.data);
                }
            },
            error : function(data){
                layer.msg(data.msg);
            }
        });
    })

</script>
</body>
</html>