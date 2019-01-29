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
        <title>企业详情</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/checkList.css"/>
        <script>
			$(function(){
				$(".fabu-aside>ul>li").eq(4).addClass("gongyingshang");
				$(".headerNav a.zhanghuguanli").addClass("active");
				$(".headerNav a.zhanghuguanli img").attr("src",'<%=request.getContextPath() %>/back/images/yonghuzhanghaoguanliicon.png');
			})
		</script>
    </head>
    <body>
    	<!--公共部分-->
		<div class="public_all">
			<!--企业信息-->
			<div class="info_all shengHeZhong">

				<!--内容部分-->
				<div class="info_content">
					<div class="info_content_alert">
						<p class="info_content_reason">查看企业信息</p>
						<!--<div class="info_content_close">
							<img src="<%=request.getContextPath() %>/back/images/checkList_close.png" >
							关闭
						</div>-->
					</div>
					<div class="info_content_message">
						<form id="info_index_form">
							<div class="info_content_message_col">
								<span>
									<span>
										企业名称:
									</span>
								</span>
								<input  type="text" value="${result.companyName}" readonly="readonly" name="companyName" style="border: none;background-color: white;"/>
							</div>
							<div class="info_content_message_col">
								<span><span>行业类型:</span></span>
								<select name="categoryName" class="info_index_categoryName">
									<option value="${result.categoryName}">${result.categoryName}</option>
								</select>
							</div>
							<div class="info_content_message_col info_content_message_address">
								<span>
									<span>所在地:</span>
								</span>
								<select name="province" class="info_province">
								<option value="${result.province}">${result.province}</option>
								</select>
								<select name="city" class="info_city">
								<option value="${result.city}">${result.city}</option>
								</select>
							</div>
							<div class="info_content_message_col info_content_message_detailAddress">
								<span><span>地址:</span></span>
								<input type="text" value="${result.address}" name="address"/>
								<%-- <p>请填写详细地址,例:海定区X路X大厦X号</p> --%>
							</div>
							<%-- <div class="info_content_message_col">
								<span><span>邮编:</span></span>
								<input type="text" value="${result.zipCode}" name="zipCode"/>
							</div> --%>
							<div class="info_content_message_col info_content_message_contact">
								<span><span>联系人:</span></span>
								<input type="text" value="${result.contacter}" name="contacter"/>
								<input type="radio" name="sex" id="" checked="checked" value="1" />先生
								<input type="radio" name="sex" id="" value="2" />女士
							</div>
							<div class="info_content_message_col">
								<span><span>联系电话:</span></span>
								<input type="text" value="${result.tel}" name="tel"/>
							</div>
							<%-- <div class="info_content_message_col">
								<span><span>传真:</span></span>
								<input type="text" value="${result.fax}" name="fax"/>
							</div> --%>
							<div class="info_content_message_col">
								<span><span>电子邮箱:</span></span>
								<input type="text" value="${result.email}" name="email"/>
							</div>
							<div class="info_content_message_col">
								<span><span style="background-image: none;">公司官网:</span></span>
								<input type="text" value="${result.url}" name="url"/>
							</div>
							<div class="info_content_message_col" style="height: auto;">
								<span><span>企业简介:</span></span>
								<textarea id="description" name="description" rows="" cols="" value="${result.description}"></textarea>
							</div>
						</form>
						<div class="info_content_message_col info_content_message_logo">
							<span><span>公司主图:</span></span>
							<div>
								<img class="info_message_showlogo" style="height:150px;width:auto;" src="${result.logoUrl}" alt="" />
								<p>
									<!--<span class="info_upload_logo">编辑照片</span>-->
									<span class="info_look_logo">预览照片</span>
								</p>
							</div>
						</div>
						<div>
							<span><span>公司视频:</span></span>
							<div>
								<video style="width:400px;height:300px;" autoplay="autoplay" controls="controls" src="${result.videoSrc}"></video>
							</div>

						</div>

						<%-- <div class="info_content_message_col info_content_message_business">
							<span><span>营业执照:</span></span>
							<div>
								<img class="info_message_showbusiness" src="${result.licenseUrl}" alt="" />
								<p>
									<!--<span class="info_upload_business">编辑照片</span>-->
									<span class="info_look_business">预览照片</span>
								</p>
							</div>
						</div> --%>
					</div>
				</div>

			</div>
		</div>

		<!--大图弹窗-->
		<div class="info_big_img">
			<img src="../images/info_defauleLogo.png" style="height:500px;width:auto;"  alt="" />
		</div>

	</body>
	<script type="text/javascript">

        document.getElementById("description").value="${result.description}";


		function clickFun(name1,name2,fun){

			var arg=arguments;

			for(var i=0;i<arg.length-1;i++){

				(function(){fun(arg[i])})();

			}

		}


		function showImg(str){
			$(".info_look_"+str).on("click",function(e){

				$(".info_big_img").css("display","block");

				$(".info_big_img").find("img").attr("src",$(".info_message_show"+str).attr("src"));

			});

		}
		clickFun("logo","business",showImg);

		$(".info_big_img").on("click",function(e){

			$(this).css("display","none");

		})



	</script>


 	</body>
</html>
