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

        <%--新改的样式--%>
        body{
            background:#fff!important;
        }
        .contentWrap{
            margin:0 auto;
            background:#fff;
            padding:30px 0;
        }
        #subForm{
            
        }
        .fixedHead{
            left:50%;
            background:#fff;
            z-index:1000;
            box-sizing:border-box;
            padding-left: 30px;
        }
        .fixedHead > .btn_jilin{
            border-radius: 4px;
            width: 101px;
            height: 36px;
            float:left;
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
            margin-left:10px;
            margin-right:40px;
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
            padding-left: 40px;
            margin-bottom: 20px;
        }
        input{
        	height: 40px;
			line-height: 40px;
			border: 1px solid #F1F2F7;
			background: #FCFCFC;
			border-radius: 4px;
			width: 350px;
			padding-left: 15px;
        }
    </style>
    <title>藏品专题-新建</title>
</head>
<body>
<section  class="contentWrap">
    <form  action="<%=request.getContextPath() %>/wenChuang/addAndUpdate.do" id="subForm" method="post">
        <div class="addTitle">
        	<!-- <label>专题名称：</label> -->
            <input style="width:90%;" type="text" name="name" placeholder="请输入专题名称" id="name">
        </div>

        <div class="fixedHead">
            <div class="btn_jilin confirm" id="confirm"><img src="<%=request.getContextPath() %>/back/images/save.png"><span>保存</span></div>
            <div class="btn_jilin cancel" id="cancel"><img src="<%=request.getContextPath() %>/back/images/cancel.png"><span>取消</span></div>
        </div>

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

    //表单验证
    $("#confirm").on("click",function(){
        if($("#name").val() == ''){
            top.layer.alert('您还没有填写专题名称', {
                skin: 'layui-layer-lan',
                closeBtn: 0,
                anim: 4 //动画类型
            });
            return false;
        }
        $.ajax({
            type: "POST",
            url: "<%=request.getContextPath() %>/topic/saveTopic.do",
            data: {name:$("#name").val()},
            dataType: "json",
            success: function(data){
           		if(data.success == 1){
           			parent.layer.closeAll();
					parent.layer.msg('保存成功', {icon: 1});
	           		window.parent.init();//访问父页面方法 
       			}
            }
   	 })
   }) ;  
    
  //点击取消按钮
    $("#cancel").click(function(){
    	parent.layer.closeAll();
    })
</script>
</body>
</html>