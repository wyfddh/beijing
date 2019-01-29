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
    <!--[if lt IE 9]>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/html5shiv.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/respond.min.js"></script>
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
        #wechat{
            color:#00be00;
            font-size: 30px;
            display: inline-block;
            margin-top: -14px;
        }
        #qq{
            color:#3ac6df;
            font-size: 30px;
            display: inline-block;
            margin-top: -14px;
        }
        .binding{
            line-height: 1px!important;
            color: #666666;
            position: relative;
            top:-4px
        }
        .word{
            color: #333333;
        }
        .config{
            color: #666666;
            font-size: 14px;
        }
        .tabBar span.current{
            background: #16B57F;
        }
        .tabBar{
            border-bottom: 2px solid #16B57F;
        }
        h4{
            font-weight: 600;
        }
    </style>
    <title>用户详情</title>
</head>
<body>
<header id="head"></header>
<aside id="manaside"></aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section  class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 内容管理 <span class="c-gray en">&gt;</span> 用户详情 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="Hui-article">
        <form action="" class="cl pd-20">
            <div id="tab-system" class="HuiTab">
                <div class="tabBar cl"><span>账号</span><span>用户心情</span></div>
                <div class="tabCon">
                    <div class="pl-10">
                        <h4>账号信息</h4>
                    </div>
                    <div class="pl-30 clearfix">
                        <div class="f-l">账号：</div>
                        <div class="col-xs-9">18922223333</div>
                    </div>
                    <div class="pl-30 clearfix mt-20">
                        <div class="f-l">微信：</div>
                        <div class="col-xs-9">
                            <i class="Hui-iconfont" id="wechat">&#xe694;</i>
                            <span class="pl-20 binding">未绑定/已绑定</span>
                            <span class="pl-20 binding word">微信 UnionID：</span>
                            <span class="pl-20 binding word">ca675648187</span>
                        </div>
                    </div>
                    <div class="pl-30 clearfix mt-20">
                        <div class="f-l ml-5">QQ：</div>
                        <div class="col-xs-9">
                            <i class="Hui-iconfont" id="qq">&#xe67b;</i>
                            <span class="pl-20 binding">未绑定/已绑定</span>
                            <span class="pl-20 binding word">QQ openid：</span>
                            <span class="pl-20 binding word">ca675648187</span>
                        </div>
                    </div>

                    <div class="pl-10">
                        <h4>个人信息</h4>
                    </div>
                    <div class="pl-30 clearfix ">
                        <div class="f-l">
                            <div class="f-l">头像</div>
                            <div class="img f-l ml-15 pt-5">
                                <img src="<%=request.getContextPath() %>/back/images/head.png" alt="">
                            </div>
                        </div>
                        <div class="col-xs-9">
                            <div class="col-xs-4 lh-28">
                                <span>昵称：</span>
                                <span class="config">王二小</span>
                            </div>
                            <div class="col-xs-4 lh-28">
                                <span>性别：</span>
                                <span class="config">待定</span>
                            </div>
                            <div class="clearfix"></div>
                            <div class="col-xs-4 lh-28">
                                <span>地区：</span>
                                <span class="config">山东省  济南市  XX县</span>
                            </div>
                            <div class="col-xs-4 lh-28">
                                <span>职业：</span>
                                <span class="config">工程师</span>
                            </div>
                            <div class="clearfix"></div>
                            <div class="col-xs-12 lh-28">
                                <span>生日：</span>
                                <span class="config">1992-02-29</span>
                            </div>
                            <div class="col-xs-12 lh-28">
                                <span>标签：</span>
                                <span class="config">文物爱好者</span>
                            </div>
                        </div>
                    </div>
                    <div class="pl-10">
                        <h4>状态信息</h4>
                    </div>
                    <div class="pl-30">
                        <div class="f-l">是否启用帐号</div>
                        <div class="radio-box ml-50">
                            <input type="radio" value="1" name="roleId" class="refdis rolecheck">
                            <label>启用</label>
                        </div>
                        <div class="radio-box">
                            <input type="radio" value="2" name="roleId" class="refdis rolecheck">
                            <label>停用</label>
                        </div>
                    </div>
                    <div class="pl-30 mt-20">
                        <div class="btn btn-primary size-S">返回列表</div>
                    </div>
                </div>
                <div class="tabCon">
                    <h2>程序员正在加紧开发中...</h2>
                </div>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });
        $.Huitab("#tab-system .tabBar span","#tab-system .tabCon","current","click","0");
    });
</script>
</body>
</html>