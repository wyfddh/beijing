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
        .Hui-article{
           overflow-x: hidden;
           overflow-y: auto;
        }
        <%--新改的样式--%>
        body{
            background:#fff!important;
        }
        *{
            padding:0;
            margin:0;
            box-sizing:border-box;
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
        .activityType{
            width:100%;
            height:40px;
            line-height:40px;
        }
        .activityType > select{
            border:none;
            height:40px;
            font-size: 14px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
        }
        .activityInfo{
            width:100%;
            height:118px;
            border-bottom:1px solid rgb(241, 242, 247);
            padding-left:6px;
        }
        .time{
            width:100%;
            height:39px;
            line-height:25px;
        }
        .time span{
            vertical-align:sub;
            color:#ff6c60;
        }
        .time label{
            font-size: 14px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
            margin-right:10px;
        }
        .time > input{
            border: 1px solid rgb(241, 242, 247);
            border-radius: 4px;
            background-color: rgb(252, 252, 252);
            width: 358px;
            height: 24px;
            padding-left:8px;
        }
        .time > .timeInput{
            width: 177px;
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
    </style>
    <title>活动管理详情</title>
</head>
<body>
<section class="contentWrap">
    <form action="<%=request.getContextPath() %>/activity/addOrUpdate.do" class="form form-horizontal" id="subForm" method="post" enctype="multipart/form-data">
    	<input type="hidden" name="id" value="${article.id}"/>
        <div class="fixedHead">
            <div class="title">编辑活动</div>
            <div class="btn_jilin cancel" id="cancel"><img src="<%=request.getContextPath() %>/back/images/cancel.png"><span>取消</span></div>
            <div class="btn_jilin confirm submitall" id="confirm"><img src="<%=request.getContextPath() %>/back/images/save.png"><span>保存</span></div>
        </div>

        <div class="addMainPic">
            <div id="imgWrap" class="upPic">
                <img class="addimg hide" id="upImgIcon" src="<%=request.getContextPath() %>/back/images/addPic.png">
                <p class="addWord hide" id="upMainImgWord">添加主图</p>
                <img id="image_id" class="newImg" src="${article.pictureThumb}">
                <input type="hidden" name="pictureId" id="picId" value="${article.pictureId}"/>
            </div>
        </div>

        <div class="addTitle">
            <input type="text" name="activityName" placeholder="请输入活动名称" id="name" value="${article.activityName }">
        </div>

        <div class="activityInfo">
            <div class="activityType">
                <select name="activityCategory"  size="1" id="leimu">
                    <c:forEach items="${categoryList}" var="c">
                        <option value="${c.id}" <c:if test="${article.activityCategory eq c.id}">selected</c:if> >${c.categoryName}</option>
                        <!-- Stu类中必须有set和get方法 -->
                    </c:forEach>
                </select>
            </div>

            <div class="time">
                <label for="datemin"><span>*</span> 时间 :</label>
                <input type="text" name="activityDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="datemin1" class="timeInput Wdate" value="${article.activityDate}">
                <input type="text" name="specificDate" onfocus="WdatePicker({dateFmt:'HH:mm:ss'})" id="datemin" class="timeInput Wdate" value="${article.specificDate}">
            </div>

            <div class="time">
                <label for="datemin"><span>*</span> 地点 :</label>
                <input type="text" name="activityPlace" placeholder="活动地点" id="address" value="${article.activityPlace }">
            </div>
        </div>

        <div class="contentEdit">
            <script id="editor" type="text/plain" style="width:100%;" name="content">${article.content}</script>
        </div>
            <%--<div class="f-l ml-20">发布单位：</div>--%>
            <%--<div class="formControls col-xs-2">--%>
                <%--&nbsp;&nbsp;&nbsp;&nbsp;${article.musExhibition}--%>
            <%--</div>--%>
            <%--<div class="f-l ml-20">发布人：</div>--%>
            <%--<div class="formControls col-xs-2">--%>
                 <%--&nbsp;&nbsp;&nbsp;&nbsp;${article.musExhibition}--%>
            <%--</div>--%>
    </form>
    <form id="upload" class="hide">
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
        initialFrameHeight: 400,
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
    $(".newImg").click(function(){
        $("#file").click();
        return false;
    });
    //图片上传并回显
    $("#file").change(function(){
        var formData = new FormData($("#upload")[0]);
        $.ajax({
            url : "<%=request.getContextPath() %>/file/uploadPicture.do?typeId=12&objectId=",
            type : "post",
            data :  formData,
            dataType:"json",
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function(data){
                if(data.error == 0){
                    $("#upImgIcon").hide(0);
                    $("#upMainImgWord").hide(0);
                    $("#image_id").removeClass("hide").attr("src",data.url);
                    $("#picId").val(data.picId);
                    layer.msg('[OK]上传成功', {icon: 1});
                }else{
                    layer.msg(data.message, {icon: 1});
                }
            }
        });
    });

    //表单验证
    $("#confirm").on("click",function(){
        if($("#name").val() == ""){
            layer.alert('活动名称不能为空', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            return false;
        }else if($("#address").val() == ""){
            layer.alert('活动地点不能为空', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            return false;
        }else if($("#datemin1").val() == ""){
            layer.alert('您还没有选择活动日期', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            return false;
        }else if($("#datemin").val() == ""){
            layer.alert('您还没有选择具体时间', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            return false;
        }else if($("#picId").val() == ""){
            layer.alert('您还没有上传产品图片', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            return false;
        }else if($("#leibie").val() == "请选择"||$("#leibie").val() == ""){
            layer.alert('您还没有选择活动类型', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            return false;
        }else if(UE.getEditor('editor').getContent() == ""){
            layer.alert('您还没有添加内容', {
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
    });
</script>
</body>
</html>