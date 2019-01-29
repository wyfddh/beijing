<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="favicon.ico">
    <link rel="Shortcut Icon" href="favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
   <script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script> 
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/content_gover.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>增加虚拟展厅信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <style>
        .img_wrap{
            width: 300px;
            height: 300px;
            position: absolute;
            top:50%;
            laft:100%;
            margin-top: -150px;
            margin-left: 500px;
            background: red;
        }
        .box-size{
            width: 300px!important;height:230px!important;
        }
        .box-size-M{
            width: 235px!important;height:195px!important;
        }
        .box-size-S{
            width: 190px!important;height:155px!important;
        }
        .box-size-L{
            width: 285px!important;height:225px!important;
        }
        .grid-bg{
            background: #00CCFF!important;color: #ffffff;
        }
        #DataTables_Table_0_filter{
            display: none;
        }
        #coverVideo{
            width: 1000px;height: 500px;background: rgba(0,0,0,0.7);position: fixed;left: 25%;top:20%;border:5px solid lightslategray;min-width: 800px;display: none;
        }
        #coverAudio{
            width: 1000px;height: 500px;background: rgba(0,0,0,0.7);position: fixed;left: 25%;top:20%;border:5px solid lightslategray;min-width: 800px;display: none;
        }
        #coverPic{
        	 z-index:999; width: 1000px;height: 500px;background: rgba(0,0,0,0.7);position: fixed;left: 25%;top:20%;border:5px solid lightslategray;min-width: 800px;display: none;
        }
        .lig{
            line-height:30px
        }
        .Hui-article-box {
         overflow-x:hidden!important;
         overflow-y:auto!important;
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
            min-height:600px;
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
        .virtualType{
            width:100%;
            height:40px;
            line-height:40px;
            padding-left:6px;
        }
        .virtualType > select{
            border:none;
            height:40px;
            font-size: 14px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
        }
        .virtualUrl{
            width:100%;
            height:115px;
            padding-left:6px;
        }
        .subTitle{
            font-size: 14px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
            line-height: 3.513;
        }
        .subTitle > span{
            vertical-align:sub;
            color:#ff6c60;
        }
        .urlWrap{
            line-height:25px;
            padding-left:10px;
        }
        .urlTitle{
            display:inline-block;
            width:100px;
            font-size: 14px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
        }
        .urlWrap > input{
            border: 1px solid rgb(241, 242, 247);
            border-radius: 4px;
            background-color: rgb(241, 242, 247);
            width: 535px;
            height: 24px;
            padding-left:8px;
        }
        .simpleIntroduce{
            width:100%;
            height:120px;
            padding-top:10px;
            padding-left:6px;
        }
        textarea{
            border: 1px solid rgb(241, 242, 247);
            border-radius: 4px;
            background-color: rgb(241, 242, 247);
            width: 535px;
            height: 108px;
            margin-left:67px;
            padding:10px;
            resize:none;
        }
        .topVertical{
            vertical-align:top;
        }
        .topVertical > span{
            vertical-align:top;
            display:inline-block;
            padding-top:3px;
        }
        .close{
            width:80px;
            height:42px;
            background:#F8F8F8;
            float:right;
            border:none;
            outline:none;
            line-height:42px;
            text-align:right;
            padding:0 20px;
        }
    </style>
</head>
<body>
    <section class="contentWrap">
        <form class="form form-horizontal" action="<%=request.getContextPath()%>/virtual/addAndUpdate.do" method="post" id="subForm">
            <div class="fixedHead">
                <div class="title">发布虚拟展厅</div>
                <div class="btn_jilin cancel" id="cancel"><img src="<%=request.getContextPath() %>/back/images/cancel.png"><span>取消</span></div>
                <div class="btn_jilin confirm" id="confirm"><img src="<%=request.getContextPath() %>/back/images/save.png"><span>保存</span></div>
            </div>

            <div class="addMainPic">
                <div id="imgWrap" class="upPic">
                    <img class="addimg" id="upImgIcon" src="<%=request.getContextPath() %>/back/images/addPic.png">
                    <p class="addWord" id="upMainImgWord">添加主图</p>
                    <img id="image_id" class="newImg hide" src="">
                    <input type="hidden" name="viMasterMap" id="picId">
                </div>
            </div>

            <div class="addTitle">
                <input type="text" name="viName" placeholder="请输入虚拟展厅名称" id="title">
            </div>

            <div class="virtualType">
                <select name="viClassify"  size="1">
                    <option value="1" selected="selected">三维虚拟漫游</option>
                    <option value="2">全景漫游</option>
                </select>
            </div>

            <div class="virtualUrl">
                <label class="subTitle"><span>*</span> 虚拟展厅网址:</label>
                <p class="urlWrap"><span class="urlTitle">PC端(URL)</span><input type="text" id="pcurl" name="viPCUrl"></p>
                <p class="urlWrap"><span class="urlTitle">移动端(URL)</span><input type="text" id="mobilurl" name="viMoveUrl"></p>
            </div>

            <div class="simpleIntroduce">
                <label class="subTitle topVertical"><span>*</span> 简介</label>
                <textarea name="viIntro" cols="20" rows="30"  placeholder="说点什么...最少输入10个字符" onKeyUp="textarealength(this,100)"></textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
            </div>
    </section>
    <%-- <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script> --%>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/1.4.3/ueditor.config.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/validate-methods.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery.validation/1.14.0/messages_zh.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/webuploader/0.1.5/webuploader.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript">
	    $(".close").click(function(){
	    	window.parent.location.reload(); //刷新父页面
	    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    	parent.layer.close(index);  // 关闭layer
	    });
        //点击上传图片
        $("#imgWrap").click(function(){
            layer.open({
                type: 2,
                title: '裁剪图片',
                shadeClose: true,
                shade: 0.8,
                area: ['800px', '730px'],
                content: '<%=request.getContextPath() %>/cropper/cropvir.html' //iframe的url
            });
        });

        //点击保存
        $("#confirm").click(function(){
             if($("#title").val() == ""){
                 layer.open({
                     title: '提示',
                     content: '您还没有添加虚拟展厅名称'
                 });
                 return false;
             }else if($("#image_id").attr("src") == ""){
                 layer.open({
                     title: '提示',
                     content: '您还没有添加主图'
                 });
                 return false;
             }else if($("#pcurl").val() == ""){
                 layer.open({
                     title: '提示',
                     content: '您还没有添加pc端地址'
                 });
                 return false;
             }else if($("#mobilurl").val() == ""){
                 layer.open({
                     title: '提示',
                     content: '您还没有添加移动端地址'
                 });
                 return false;
             }else if($("textarea").val() == ""){
                  layer.open({
                      title: '提示',
                      content: '您还没有添加简介'
                  });
                  return false;
             }else{
                  layer.open({
                      title: '提示',
                      content: '保存成功'
                  });
                  setTimeout(function(){
                      $("form")[0].submit();
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