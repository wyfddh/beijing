<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        .check-box, .radio-box{
            padding-left: 0;
        }
        .layui-layer-page .layui-layer-content{
            overflow-x: hidden!important;
        }


        <%--新改的样式--%>
        body{
            background:#fff!important;
        }
        .contentWrap{
            width: 860px;
            margin:0 auto;
            background:#fff;
            padding:80px 0;
        }
        #subForm{
            border:2px solid #f1f2f7;
            border-radius:5px;
            overflow:hidden;
        }
        .fixedHead{
            width:860px;
            height:80px;
            position:fixed;
            top:0;
            left:50%;
            margin-left:-430px;
            background:#fff;
            z-index:1000;
            border-bottom:1px solid #f2f2f2;
            box-sizing:border-box;
        }
        .fixedHead > .title{
            width:200px;
            float:left;
            font-size: 18px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
            font-weight: bold;
            line-height: 80px;
        }
        .fixedHead > .btn_jilin{
            border-radius: 4px;
            width: 101px;
            height: 36px;
            float:right;
            text-align:center;
            line-height:36px;
            margin-top:22px;
            cursor:pointer;
        }
        .fixedHead > .btn_jilin > span{
            padding-left:8px;
            vertical-align:middle;
        }
        .fixedHead > .btn_jilin > img{
            vertical-align:middle;
        }
        .fixedHead > .confirm{
            background-color: rgb(42, 155, 207);
            color:#fff;
            margin-right:12px;
        }
        .fixedHead > .cancel{
            border:1px solid rgb(42, 155, 207);
            color:rgb(42, 155, 207);
        }
        .addMainPic{
            background-color: rgb(241, 242, 247);
            width: 100%;
            height: 175px;
        }
        .addMainPic > #imgWrap{
            width:100%;
            height:100%;
            text-align:center;
            cursor:pointer;
        }
        .addMainPic > #imgWrap > .newImg{
            width:100%;
            height:100%;
            object-fit:contain;
        }
        .addMainPic > #imgWrap > .addimg{
            margin-top:60px;
            width:34px;
            height:28px;
        }
        .addMainPic > #imgWrap > p{
            margin-top:10px;
            font-size: 18px;
            font-family: "PingFang";
            color: rgb(102, 102, 102);
            font-weight: bold;
        }
        .hide{
            display:none;
        }
        .show{
            display:block;
        }
        .addTitle{
            width:100%;
            height:56px;
            border-bottom:1px solid rgb(241, 242, 247);
            box-sizing:border-box;
        }
        .addTitle > input{
            width:100%;
            height:100%;
            font-size: 20px;
            font-family: "PingFang";
            outline:none;
            border:none;
            padding-left:8px;
        }
        .typeWrap{
            width:100%;
            height:40px;
            border-bottom:1px solid rgb(241, 242, 247);
            box-sizing:border-box;
            padding-left:8px;
        }
        .typeWrap > label{
            font-size: 14px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
        }
        .typeNum{
            width:100%;
            height:40px;
            padding-top:10px;
            box-sizing:border-box;
        }
        .typeNum span{
            padding-right:22px;
        }
        .typeNum label{
            font-size: 14px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
        }
        .contentEdit{
            width:100%;
        }
        .edui-default .edui-editor{
            border:none!important;
        }
        .edui-default .edui-editor-toolbarboxouter{
            border-bottom:none!important;
            box-shadow:none!important;
        }
        .edui-default .edui-editor-iframeholder{
            background:rgb(241, 242, 247);
        }
        .edui-default .edui-toolbar{
            background:#fff;
        }
        #leimu{
            border:none;
            font-size: 14px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
            height:38px;
            line-height:38px;
        }
    </style>
    <title>历史文章录入</title>
</head>
<body>
<section class="contentWrap">
    <form class="form form-horizontal" action="<%=request.getContextPath() %>/articleJiLin/addAndUpdate.do" id="subForm" method="post">
        <div class="fixedHead">
            <div class="title">普查风采</div>
            <div class="btn_jilin cancel" id="cancel"><img src="<%=request.getContextPath() %>/back/images/cancel.png"><span>取消</span></div>
            <div class="btn_jilin confirm" id="confirm"><img src="<%=request.getContextPath() %>/back/images/save.png"><span>保存</span></div>
        </div>

        <div class="addMainPic">
            <div id="imgWrap" class="upPic">
                <img class="addimg" src="<%=request.getContextPath() %>/back/images/addPic.png">
                <input type="hidden" name="pictureId" class="pictureId"/>
                <p class="addWord">添加主图</p>
                <img class="newImg hide" src="">
            </div>
        </div>

        <div class="addTitle">
            <input type="text" name="headline" placeholder="请输入文章名称" id="title">
        </div>
        <input type="hidden" value="1" id="leimu" name="articleCategory">
         <!--  <div class="typeWrap">
            <label for="leimu">类型 :</label>
             <select name="articleCategory" size="1" id="leimu">
                <c:forEach items="${categoryList}" var="category">
                    <option value="${category.id}">${category.categoryName}</option>
                </c:forEach>
            </select>
        </div>-->
        <div class="contentEdit">
            <script id="editor" type="text/plain" style="width:856px;" name="content"></script>
        </div>
    </form>
    <form id="upload" style="position:absolute;z-index:-1;left:-300px">
        <input id="file" type="file" name="file">
    </form>
</section>
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
    //初始化富文本编辑器
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

    //上传图片
    $("#imgWrap").click(function(){
        $("#file").click();
        return false;
    });

    //图片上传并回显
    $("#file").change(function(){
        var formData = new FormData($("#upload")[0]);
        $.ajax({
            url : "<%=request.getContextPath() %>/file/uploadPicture.do?typeId=11&objectId=",
            type : "post",
            data :  formData,
            dataType:"json",
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function(data){
                $(".newImg").removeClass("hide").addClass("show").attr("src",data.url);
                $(".pictureId").val(data.picId);
                $(".addimg").removeClass("show").addClass("hide");
                $(".addWord").removeClass("show").addClass("hide");
                layer.msg('[OK]上传成功', {icon: 1});
            }
        });
    });

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
        }else if($(".newImg").hasClass("hide")){
            layer.alert('图片不能为空', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            return false;
        }else if(UE.getEditor('editor').getContent() == ""){
            layer.alert('您还没有添加文章内容', {
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
            },500);
        }
    });

    //点击取消按钮
    $("#cancel").click(function(){
        layer.confirm('您确定要退出本页面吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.closeAll();  //关闭弹出层
            window.history.back(-1);  //关闭弹出层
        }, function(){
            layer.closeAll();  //关闭弹出层
        });
    })
</script>
</body>
</html>