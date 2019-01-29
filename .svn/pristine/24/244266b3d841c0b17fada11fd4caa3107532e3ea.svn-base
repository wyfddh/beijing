<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style>
    body{
        background: #f1f2f7;}
        *{
            padding: 0;
            margin: 0;
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
        
    </style>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/checkList.css"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <title>查看企业产品名称</title>
</head>
<body>
<div class="article_content_wrap">
    <div class="article_content">
        <div class="article_header">
            <h3>查看企业产品</h3>
            <button onclick="window.close()">关闭</button>
        </div>
        <div class="content">
            <div class="subTitle">
                <h3>${product.productName}</h3>
            </div>
            <div class="article_type">
                <span class="commonTitle">价格 :</span>
                <span class="commonContent typeContent">${product.productPrice}元</span>
                <span class="commonTitle">规格 :</span>
                <span class="commonContent">${product.productStandard}</span>
            </div>
       <!--      <div class="element">
                <span class="commonTitle">设计元素 :</span>
                <span class="commonContent">形象是物体的外部特征，是形象是物体的外部特征，是可见的。形象包括视觉元素的各部分，所有的概念元素如点、线、面在见于画形象是物体的外部特征，是可见的。形象包括视觉元素的各部分，所有的概念元素如点、线、面在见于画形象是物体的外部特征，是可见的。形象包括视觉元素的各部分，所有的概念元素如点、线、面在见于画可见的。形象包括视觉元素的各部分，所有的概念元素如点、线、面在见于画</span>
            </div> -->
            <div class="mainPic">
                <span class="commonTitle f-l">主图 :</span>
                <div class="img f-l">
                    <div class="imgWrap">
                        <img id="imgSrc" src="${product.imgSrc}" alt="">
                    </div>
                    <p>
                        <a class="info_look_logo" href="javascript:">预览图片</a>
                    </p>
                </div>
            </div>
            <div class="introduce">
                <span class="commonTitle">产品介绍 :</span>
                <span class="commonContent">${product.content}</span>
            </div>
        </div>
    </div>

</div>
<!--大图弹窗-->
		<div class="info_big_img">
			<img src="../images/info_defauleLogo.png" alt="" />
		</div>
		<script>
		$(".info_look_logo").on("click",function(){
				$(".info_big_img").css("display","block");
				$(".info_big_img").find("img").attr("src",$("#imgSrc").attr("src"));
		})
		
		$(".info_big_img").on("click",function(e){
	
			$(this).css("display","none");
			
		})
		</script>
</body>

</html>