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
    <script type="text/javascript" src="../../../../../back/lib/jquery/1.9.1/jquery.min.js"></script>
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
        #imgWrap{
            width: 295px;
            height: 195px;
            text-align: center;
            background: #f7f7f7;
            display: table-cell;
            padding: 5px;
            cursor: pointer;
            vertical-align: middle;
            font-size: 60px;
            color: #D9D9D9;
        }
    </style>
    <title>历史详情</title>
</head>
<body>
<header id="head"></header>
<aside id="manaside"></aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section  class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 内容管理 <span class="c-gray en">&gt;</span> 历史吉林 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="Hui-article">
        <form action="" class="cl pd-20" id="subForm">
            <div class="row cl mt-30 ml-10">
                <div class="f-l ml-20">发布时间: </div>
                <div class="formControls col-xs-2">
                    2016-04-20
                </div>
                <div class="f-l ml-20">发布单位: </div>
                <div class="formControls col-xs-2">
                    吉林省博物院
                </div>
                <div class="f-l ml-20">发布人: </div>
                <div class="formControls col-xs-2">
                    王二小
                </div>
                <div style="clear: both"></div>
                <div class="f-l mt-15 ml-20"><span class="c-red">*</span>文章类目：</div>
                <div class="formControls col-xs-4 mt-10">
                    <span class="select-box">
                        <select class="select" name="adminRole" size="1" id="leimu">
                            <option value="请选择">请选择</option>
                        </select>
                    </span>
                </div>
                <div class="clearfix"></div>
                <div class="f-l mt-15 ml-50"><span class="c-red">*</span>标题：</div>
                <div class="formControls col-xs-4 mt-10">
                    <input type="text" class="input-text" placeholder="标题" id="title">
                </div>

                <div style="clear: both"></div>
                <div class="f-l ml-30 pl-5 mt-5"><span class="c-red">*</span>缩略图：</div>
                <div class="formControls col-xs-10 mt-30 ml-0">
                    <div id="imgWrap" class="upPic">
                        <span class="addimg">+</span>
                        <input type="hidden" name="pictureId"/>
                    </div>
                </div>
                <div class="formControls col-xs-12 mt-10 clearfix ml-15">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="btn btn-primary size-S upPic">上传</div>
                    <div class="btn btn-danger size-S ml-15" id="delPic">删除</div>
                </div>
                <div class="f-l mt-15 ml-40"><span class="c-red">*</span>内容：</div>
                <div class="formControls col-xs-8 mt-15 ml-5">
                    <script id="editor" type="text/plain" style="width:100%;height:400px;" name="content"></script>
                </div>
            </div>
            <div class="ml-50 mt-20">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <div class="btn btn-success ml-50 radius" id="confirm">提交</div>
                <div class="btn btn-danger radius ml-30">取消</div>
            </div>
        </form>
        <form id="upload" style="position:absolute;z-index:-1;left:-300px">
            <input id="file" type="file" name="file">
        </form>
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

<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.all.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/lang/zh-cn/zh-cn.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
var ue = UE.getEditor('editor',{
    toolbars: [['source', 'indent','insertimage','justifyleft','justifyright','justifycenter','justifyjustify',]],
    initialFrameHeight: 400
});
UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
UE.Editor.prototype.getActionUrl = function(action){
    if(action == '/resource/upload/images'){
        return '<%=request.getContextPath() %>/aaaa/uploadImage.do';
    }else{
        return this._bkGetActionUrl.call(this, action);
    }
};
</script>
<script type="text/javascript">
    //上传图片
    var that;
    $(".upPic").click(function(){
        that=$(this);
        $("#file").click();
        return false;
    });
    //图片上传并回显
    $("#file").change(function(){
        var formData = new FormData($("#upload")[0]);
        $.ajax({
            url : "",
            type : "post",
            data :  formData,
            dataType:"json",
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function(data){
                $(that).find("span").html("<img src="+data.url+">");
                $(that).find("input").val(data.picId);//.attr("name","'+data.picId+'")
                layer.msg('[OK]上传成功', {icon: 1});
            }
        });
    });

//    删除图片
    $("#delPic").on("click",function(){
        alert(0000)
        $(".addimg").html("+");
    });
</script>
<script type="text/javascript">
    //表单验证
    $("#confirm").on("click",function(){
        if($("#leimu").val() == "请选择" || $("#leimu").val() == ""){
            layer.alert('您还没有选择文章类目', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            return false;
        }else if($("#title").val() == ""){
            layer.alert('标题不能为空', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            return false;
        }else if($(".addimg").html() == "+"){
            layer.alert('您还没有上传产品图片', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            return false;
        }else if(UE.getEditor('editor').getContent() == ""){
            layer.alert('您还没有添加产品介绍', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            return false;
        }else{
            layer.msg('保存成功',{icon:6});
            setTimeout(function(){
                layer.close();
                $("#subForm").submit();
            },1000);
        }
    })
</script>
</body>
</html>