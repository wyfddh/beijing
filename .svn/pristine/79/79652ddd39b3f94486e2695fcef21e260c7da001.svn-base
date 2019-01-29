<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../../../../../back/lib/html5shiv.js"></script>
    <script type="text/javascript" src="../../../../../back/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/header.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/headUserGover.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/asideUserGover.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <!--/meta 作为公共模版分离出去-->
    <style type="text/css">
        a:hover{
            text-decoration: none;
        }
        .check-box, .radio-box{
            padding-left: 0;
        }
        .layui-layer-page .layui-layer-content{
            overflow-x: hidden!important;
        }
    </style>
    <title>文章管理</title>
</head>
<body>
<header id="head"></header>
<aside id="manaside"></aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section  class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 内容管理 <span class="c-gray en">&gt;</span> 文章列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="Hui-article">
        <form action="" class="cl pd-20">
            <div class="row cl mt-30 ml-10">
                <div class="f-l mt-5 ml-20">发布时间：</div>
                <div class="col-xs-2">
                    <input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate">
                </div>
                <div class="f-l mt-5">至</div>
                <div class="col-xs-2">
                    <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax" class="input-text Wdate">
                </div>
                <div class="f-l mt-5 ml-20">发布状态：</div>
                <div class="formControls col-xs-2">
                    <span class="select-box">
                        <select class="select" name="adminRole" size="1">
                            <option value="地区">全部</option>
                        </select>
                    </span>
                </div>
                <div class="f-l mt-5 ml-20">文章类目：</div>
                <div class="formControls col-xs-2">
                    <span class="select-box">
                        <select class="select" name="adminRole" size="1">
                            <option value="地区">全部</option>
                        </select>
                    </span>
                </div>
                <div class="clearfix"></div>
                <div class="f-l mt-15 ml-20">&nbsp;&nbsp;&nbsp;关键词：</div>
                <div class="formControls col-xs-4 mt-10">
                    <input type="text" class="input-text" placeholder="文章标题/文章内容">
                </div>
                <div class="mt-10 text-l col-xs-6">
                    <button class="btn btn-primary ml-50"><i class="Hui-iconfont">&#xe709;&nbsp;</i>搜索</button>
                    <button class="btn btn-danger ml-30"><i class="Hui-iconfont">&#xe68f;&nbsp;</i>重置</button>
                </div>
            </div>
            <div class="pl-30 mr-50 text-r">
                <div class="btn btn-danger" id="add"><i class="Hui-iconfont">&#xe600;&nbsp;添加</i></div>
            </div>
            <div style="clear: both"></div>
            <div class="mt-20">
                <table class="table table-border table-bordered table-bg table-hover table-sort">
                    <thead>
                    <tr class="text-c">
                        <th width="40"><input name="" type="checkbox" value=""></th>
                        <th width="80">序号</th>
                        <th width="500">标题</th>
                        <th width="200">文章类目</th>
                        <th width="300">发布状态</th>
                        <th width="150">发布人</th>
                        <th width="300">发布时间</th>
                        <th width="300">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="text-c">
                        <td><input name="" type="checkbox" value=""></td>
                        <td>1</td>
                        <td>11254545655</td>
                        <td>习大大</td>
                        <td>吉林博物馆</td>
                        <td>张三</td>
                        <td>2016-05-20 17:00</td>
                        <td class="td-manage">
                            <a href="javascript:;"><div class="btn btn-primary size-S">编辑</div></a>&nbsp;
                            <a href="javascript:;"><div class="btn btn-danger size-S" onclick="del()">删除</div></a>
                            <a href="javascript:;"><div class="btn btn-secondary size-S">预览</div></a>
                            <a href="javascript:;"><div class="btn btn-success size-S" onclick="fabu()">发布</div></a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
    <div>
    </div>
</section>
<script type="text/javascript">
    $("#head").load("../../../organization/asideUserGover.html");
    $("#manaside").load("../../../organization/headUserGover.html");
</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<%--<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>--%>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
    $('.table-sort').dataTable({
//        "info": false,
        "paging": true,
        "searching": false,
        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
        "stateSave": true,
        "displayStart": 1, //一开始显示第一页
        "bStateSave": true,//状态保存
        "pagingType": "full_numbers",
        "aoColumnDefs": [
//            {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
            {"orderable":false,"aTargets":[0,7]}// 制定列不参与排序
        ]
    });
</script>
<script type="text/javascript">
    function del(){
        layer.confirm('您确定要删除该条信息吗？', {
            btn: ['确定','取消'] //按钮
        }, function(index){
//            layer.msg('我点击了确定按钮', {icon: 1});
            //点击确定之后需要执行的函数
            layer.alert('删除成功', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            setTimeout(function(){
                layer.closeAll();  //关闭弹出层
            },1000);
        }, function(index){
            layer.close(index);  //关闭弹出层
        });
    };
    function fabu(){
        layer.confirm('您确定要发布这条消息吗？', {
            btn: ['确定','取消'] //按钮
        }, function(index){
//            layer.msg('我点击了确定按钮', {icon: 1});
            //点击确定之后需要执行的函数
            layer.alert('发布成功', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            setTimeout(function(){
                layer.closeAll();  //关闭弹出层
            },1000);
        }, function(index){
            layer.close(index);  //关闭弹出层
        });
    }
</script>
</body>
</html>