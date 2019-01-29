<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
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
        *{
            padding:0;
            margin:0;
        }
        body{
            width: 100%;
            position: absolute;
            left: 0;
            right:0;
            top:0;
            bottom:0;
            box-sizing: border-box;
        }
        .article_content_wrap{
            width: 1200px;
            margin: 0 auto;
            height: 100%;
            background: #f1f2f7;
        }
        .article_content_wrap > .article_content{
            width: 862px;
            height: 100%;
            background: #fff;
            margin: 0 auto;
        }
        .article_header{
            width: 100%;
            height: 77px;
            box-sizing: border-box;
            border-bottom: 1px solid #cccccc;
            position: relative;
            padding: 0 25px;
        }
        .article_header > h3{
            font-size: 18px;
            font-family: "Microsoft YaHei";
            color: rgb(51, 51, 51);
            font-weight: bold;
            line-height: 77px;
            box-sizing: border-box;
            padding:0;
        }
        .article_header > button{
            width: 102px;
            height: 36px;
            border-radius: 4px;
            background-color: rgb(42, 155, 207);
            position: absolute;
            right: 25px;
            top: 20px;
            border: none;
            outline: none;
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(254, 255, 255);
            line-height: 36px;
            cursor: pointer;
        }
        .article_content > .content{
            width: 100%;
            padding: 0 25px;
            box-sizing: border-box;
        }
        .article_content > .content > .subTitle{
            width: 100%;
            height: 69px;
            border-bottom: 1px solid #cccccc;
        }
        .article_content > .content > .subTitle > h3{
            font-size: 18px;
            font-family: "Microsoft YaHei";
            color: rgb(51, 51, 51);
            font-weight: bold;
            line-height: 68px;
            box-sizing: border-box;
            padding:0;
        }
        .article_type{
            width: 100%;
            height: 57px;
            box-sizing: border-box;
            padding-top: 20px;
        }
        .commonTitle{
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(51, 51, 51);
            font-weight: bold;
        }
        .commonContent{
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(51, 51, 51);
        }
        .typeContent{
            margin-right: 20px;
        }
        .element{
            width: 100%;
        }
        .mainPic{
            width: 100%;
            height: 300px;
            box-sizing: border-box;
            padding-top: 20px;
        }
        .f-l{
            float: left;
        }
        .img{
            width: 410px;
            height: 100%;
            margin-left: 10px;
        }
        .img > .imgWrap{
            width: 410px;
            height: 231px;
            overflow: hidden;
            border-radius: 5px;
        }
        .img > .imgWrap > img{
            width: 100%;
            height:100%;
            object-fit: cover;
        }
        .img > p{
            width: 100%;
            height: 40px;
            line-height: 40px;
            text-align: center;
        }
        .img > p > a {
            font-size: 14px;
            font-family: "PingFang";
            color: rgb(42, 155, 207);
            text-decoration: underline;
        }
        .info_big_img{
            position: fixed;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            background-color: rgba(0,0,0,0.5);
            z-index: 99999;
            display: none;
        }
        .info_big_img>img{
            display: block;
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            margin: auto;
        }
    </style>
    <title>文创产品管理</title>
</head>
<body>

    <div class="article_content_wrap">
        <div class="article_content">
            <div class="article_header">
                <h3>查看文创产品</h3>
                <button id ="closeIndex">关闭</button>
            </div>
            <div class="content">
                <div class="subTitle">
                    <h3>${detail.productName}</h3>
                </div>
                <div class="article_type">
                    <span class="commonTitle">文创类型 :</span>
                    <span class="commonContent typeContent">${detail.categoryName}</span>
                    <span class="commonTitle">价格 :</span>
                    <span class="commonContent">${detail.productPrice}元</span>
                </div>
                <div class="element">
                    <span class="commonTitle">设计元素 :</span>
                    <span class="commonContent">${detail.designElements}</span>
                </div>
                <div class="mainPic">
                    <span class="commonTitle f-l">主图 :</span>
                    <div class="img f-l">
                        <div class="imgWrap">
                            <img id="mainImgSrc" src="${detail.pictureUrl}" alt="">
                        </div>
                        <p>
                            <a href="javascript:void(0);" id="checkBig">预览图片</a>
                        </p>
                    </div>
                </div>
                <div class="introduce">
                    <span class="commonTitle">产品介绍 :</span>
                    <span class="commonContent">${detail.content}</span>
                </div>
            </div>
        </div>
    </div>
    <%--查看大图--%>
    <div class="info_big_img">
        <img id="bigImg" src="" alt="" />
    </div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script> --%>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
    $(function(){

        <%--点击取消--%>
        $("#closeIndex").click(function(){
            window.close();
        });

        <%--查看大图--%>
        $("#checkBig").click(function(){
            var src = $("#mainImgSrc").attr("src");
            $("#bigImg").attr("src",src);
            $(".info_big_img").show(5);
        });

        <%--关闭查看大图--%>
        $(".info_big_img").click(function(){
            $(".info_big_img").hide(5);
        });
    });
</script>
</body>
</html>