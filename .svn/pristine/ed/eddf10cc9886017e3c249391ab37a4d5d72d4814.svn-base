<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="favicon.ico">
<link rel="Shortcut Icon" href="favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/css/cover.css" />
<style>
	#coverAudio{
	    width: 1000px;height: 500px;background: rgba(0,0,0,0.7);position: fixed;left: 25%;top:20%;border:5px solid lightslategray;min-width: 800px; z-index:100; display: none;
	}
	 .Hui-article-box{
	     overflow-x: hidden!important;
	     overflow-y: auto!important;
	 }
	<%--新改的样式--%>
	.boxSize{
		box-sizing:border-box;
	}
	.headWrap{
		width:100%;
		height:125px;
	}
	.headImgWrap{
		border-radius: 50%;
		border:5px solid rgb(241, 242, 247);
		width: 88px;
		height: 88px;
		float:left;
		overflow:hidden;
		cursor:pointer;
	}
	.headImgWrap img{
		width:100%;
		height:100%;
	}
	.titleWrap{
		width:800px;
		height:88px;
		float:left;
	}
	.name{
		width:100%;
		height:44px;
		line-height:44px;
		font-size: 22px;
		font-family: "PingFang";
		color: rgb(51, 51, 51);
		font-weight: bold;
		padding-left:30px;
		margin-bottom:0;
	}
	.address{
		font-size: 14px;
		font-family: "PingFang";
		color: rgb(51, 51, 51);
		line-height:35px;
	}
	.address input{
		border: 1px solid rgb(230, 230, 230);
		border-radius: 4px;
		background-color: rgb(252, 252, 252);
		width: 225px;
		height: 24px;
		padding-left:20px;
	}
	.address span{
		padding-right:10px;
	}
	.includeStar{
		display:inline-block;
		position:relative;
	}
	.star{
		position:absolute;
		left:7px;
		top:-2px;
		font-size:16px;
	}
	.c_red{
		color:#ff6c60;
	}
	.lineWrap{
		width:100%;
		height:56px;
	}
	.lineTitle{
		width:60px;
		height:100%;
		font-size: 14px;
		font-family: "PingFang";
		color: rgb(51, 51, 51);
		position:relative;
		padding-left:15px;
		box-sizing:border-box;
		float:left;
		line-height:1.7;
	}
	.lineStar{
		font-size:16px;
		position:absolute;
		left:0;
		top:1px;
	}
	.dengji{
		border: 1px solid rgb(230, 230, 230);
		border-radius: 4px;
		background-color: rgb(252, 252, 252);
		width: 100px;
		height: 24px;
		padding-left:7px;
	}
	.price{
		border: 1px solid rgb(230, 230, 230);
		border-radius: 4px;
		background-color: rgb(252, 252, 252);
		width: 120px;
		height: 24px;
		padding-left:10px;
	}
	.foreWords{
		width:90px;
	}
	.heightWrap{
		height:75px;
	}
	.openTime{
		border: 1px solid rgb(230, 230, 230);
		border-radius: 4px;
		background-color: rgb(252, 252, 252);
		width: 376px;
		height: 55px;
		resize:none;
	}
	.inputText{
		border: 1px solid rgb(230, 230, 230);
		border-radius: 4px;
		background-color: rgb(252, 252, 252);
		width: 225px;
		height: 24px;
		padding-left:10px;
	}
	.map{
		height:350px;
	}
	#editWrap{
		border-radius: 4px;
		<%--background-color: rgb(252, 252, 252);--%>
		width: 715px;
		height: 350px;
		float:left;
	}
	#editor{
		margin:0;
	}
	#edui1{
		height: 350px;
		width:713px!important;
	}
	#edui1_bottombar{
		display:none!important;
	}
	#edui1_iframeholder{
		height:310px!important;
	}
	.buttonWrap{
		width:100%;
		height:70px;
		padding-left:90px;
		box-sizing:border-box;
		padding-top:30px;
	}
	.subBtn{
		border-radius: 4px;
		width: 101px;
		height: 36px;
		font-size: 14px;
		font-family: "Microsoft YaHei";
		color: rgb(255, 255, 255);
		line-height: 36px;
		text-align:center;
		box-sizing:border-box;
		float:left;
		margin-right:12px;
		cursor:pointer;
	}
	.subBtn > img{
		vertical-align:text-top;
	}
	.conform{
		background-color: rgb(42, 155, 207);
	}
	.cancel{
		border:1px solid rgb(42, 155, 207);
		line-height: 34px;
		background:#fff;
		color: rgb(42, 155, 207);
	}
</style>
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
<script>DD_belatedPNG.fix('*');</script><![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>博物馆信息管理</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
	<!--_header 作为公共模版分离出去-->
	<%@ include file="../../organization/weihuNav.jsp"%>
	<!--_menu 左边slide导航开始-->
	<%@ include file="../aside.jsp"%>
	<!--/_menu 作为公共模版分离出去-->

	<section class="Hui-article-box">
	<div class="pl-30 pr-20">
		<form action="<%=request.getContextPath()%>/museuminfo/update.do" method="post" class="form form-horizontal biaodan" id="subForm">
			<input type="hidden" value="${museumInfo.id}" name="id" id="id">
			<input type="hidden" value="${orga.cityId}" name="cityId" id="cityId">
            <input type="hidden" value="${orga.name}" name="museumName" id="museumName">
			<!--博物馆信息开始-->

			<div class="headWrap boxSize pt-20">
				<div class="headImgWrap boxSize">
					<c:if test="${museumInfo.logoUrl eq ''}">
						<img id="upLogo" src="<%=request.getContextPath()%>/back/images/upLogo.png">
					</c:if>
					<c:if test="${museumInfo.logoUrl ne ''}">
						<img id="upLogo" src="${museumInfo.logoUrl}">
					</c:if>
					<input id="logoId" name="logoId" type="hidden" value="${museumInfo.logo}">
					<input id="logoUrl" name="logoUrl" type="hidden" value="${museumInfo.logoUrl}">
				</div>

				<div class="titleWrap">
					<p class="name">${orga.name}</p>
					<p class="name address"><span>${pArea.name }</span><span>${area.name}</span><span class="includeStar"><input type="text" name="address" id="address" placeholder="详细地址" value="${museumInfo.address}"><span class="star c_red">*</span></span></p>
				</div>
			</div>

			<div class="lineWrap">
				<div class="lineTitle"><span class="c_red lineStar">*</span> 级别 : </div>
				<select class="dengji" id="selectId" name="level" value="${museumInfo.level}">
					<option value="">请选择</option>
					<option value="1" <c:if test="${'1' eq museumInfo.level}">selected</c:if>>一级博物馆</option>
					<option value="2" <c:if test="${'2' eq museumInfo.level}">selected</c:if>>二级博物馆</option>
					<option value="3" <c:if test="${'3' eq museumInfo.level}">selected</c:if>>三级博物馆</option>
					<option value="4" <c:if test="${'4' eq museumInfo.level}">selected</c:if>>未定级</option>
				</select>
			</div>

			<div class="lineWrap">
				<div class="lineTitle"><span class="c_red lineStar">*</span> 票务 : </div>
				<div class="radio-box" style="padding-left: 0;padding-top:2px;">
					<input type="radio" id="radio-1" name="ticket" value="1" ${museumInfo.ticket==1?'checked':''}> <label for="radio-1">免费</label>
				</div>
				<div class="radio-box" style="padding-left:0;">
					<input type="radio" id="radio-2" name="ticket" value="2" ${museumInfo.ticket==2?'checked':''}> <label for="radio-1">收费</label>
				</div>
				<input type="text" class="price" name="ticketPrice" value="${museumInfo.ticketPrice}" placeholder="票价，选择收费必填">
			</div>

			<div class="lineWrap heightWrap">
				<div class="lineTitle foreWords"><span class="c_red lineStar">*</span> 开放时间 : </div>
				<textarea class="openTime" id="openTime" name="openingHours">${museumInfo.openingHours}</textarea>
			</div>

			<div class="lineWrap">
				<div class="lineTitle foreWords"><span class="c_red lineStar">*</span> 联系电话 : </div>
				<input type="text" class="inputText" id="phone" name="telephone" value="${museumInfo.telephone}">
			</div>

			<div class="lineWrap map">
				<div class="lineTitle foreWords"><span class="c_red lineStar">*</span> 地理信息 : </div>
				<div id="editWrap">
					<script id="editor" type="text/plain" name="geography">${museumInfo.geography}</script>
				</div>
			</div>

			<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
				<c:if test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
					<div class="buttonWrap">
						<div class="subBtn conform save" id="configNew"><img src="<%=request.getContextPath() %>/back/images/save.png"> 保存</div>
						<div class="subBtn cancel" id="cancel"><img src="<%=request.getContextPath() %>/back/images/cancel.png"> 取消</div>
					</div>
				</c:if>
			</c:if>
		</form>
	</div>
	</section>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/ueditor/ueditor.all.min.js"> </script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery.base64.js"></script>
	<script type="text/javascript">
		$(".fabu-aside>ul>li").eq(3).addClass("weihu");
		$(".basicInfo").addClass("active");
		$(".headerNav a.basicInfo").find("img").attr("src",'<%=request.getContextPath() %>/back/images/jibeninfoicon.png');
    	//初始化富文本编辑器
    	var ue = UE.getEditor('editor',{
    		toolbars: [['map']]
    	});
		//点击单选按钮
	    function hasPrice(){
	    	var val = $("input:radio[name='ticket']:checked").val();
	    	if(val == 1){
	    		$(".price").attr("disabled","disabled").val("");
	    	}else if(val == 2){
	    		$(".price").removeAttr("disabled","disabled");
	    	}else if(val == undefined){
				$(".price").attr("disabled","disabled").val("");
			}
	    }
	    hasPrice();
	    $("input:radio[name='ticket']").change(function(){
			hasPrice();
	    });

	    function encodeBase64(mingwen,times){    
	        var code="";    
	        var num=1;    
	        if(typeof times=='undefined'||times==null||times==""){    
	           num=1;    
	        }else{    
	           var vt=times+"";    
	           num=parseInt(vt);    
	        }    
	        if(typeof mingwen=='undefined'||mingwen==null||mingwen==""){    
	        }else{    
	            $.base64.utf8encode = true;    
	            code=mingwen;    
	            for(var i=0;i<num;i++){    
	               code=$.base64.btoa(code);    
	            }    
	        }    
	        return code;    
	    }; 
	    //表单验证
	    $(".save").click(function(){
	    	var level = $("#selectId").val();
	    	var ticket = $("input:radio[name='ticket']:checked").val();
	    	var openingHours = $("#openTime").val();
	    	var ticketPrice = $(".price").val();
	    	var address = $("#address").val();
	    	var telephone = $("#phone").val();
	    	var geography = UE.getEditor('editor').getContent();
	    	var logoId = $("#logoId").val();
	    	var logoUrl = $("#logoUrl").val();
	    	var id = $("#id").val();
	    	var cityId = $("#cityId").val();
	    	var museumName = $("#museumName").val();
	    	var result =  encodeBase64(geography);
	        if($("#selectId").val() == ""){
	            layer.open({
	                 title: '提示',
	                 content: '您还没有选择级别'
	            });
	            return false;
	        }else if($("input:radio[name='ticket']:checked").val() == 2 && ($(".price").val() == "")){
	             layer.open({
	                 title: '提示',
	                 content: '您还没有添加票价'
	             });
	             return false;
	        }else if($("#openTime").val() == ""){
	            layer.open({
	                title: '提示',
	                content: '您还没有添加开放时间'
	            });
	            return false;
	        }else if($("#address").val() == ""){
	            layer.open({
	                title: '提示',
	                content: '您还没有添加详细地址'
	            });
	            return false;
	        }else if($("#phone").val() == ""){
	            layer.open({
	                title: '提示',
	                content: '您还没有添加联系电话'
	            });
	            return false;
	        }else if(UE.getEditor('editor').getContent() == ""){
	            layer.open({
	                title: '提示',
	                content: '您还没有添加地理信息'
	            });
	            return false;
	        }else{
	            
               /* setTimeout(function(){
                    //$("form#subForm")[0].submit();
               },500); */
	            $.ajax({
	       			cache: true,
	       			type: "POST",
	       			url:  "<%=request.getContextPath()%>/museuminfo/update.do",
	       			data: {level:level,ticket:ticket,openingHours:openingHours,ticketPrice:ticketPrice,address:address,telephone:telephone,geography:result,
	       				logoId:logoId,logoUrl:logoUrl,id:id,cityId:cityId,museumName:museumName},// 你的formid
	       			dataType:"json",
	       			async: false,
	       			success: function(data) {
	       				if(data.success==1){
	       					layer.confirm('保存成功', {
	       						btn: ['确定'] //按钮
	       					}, function(){
	       						location.reload();
	       					});
	       				}
	       				
	       			}
	       		});
	        }
	    });
		//上传logo
		$("#upLogo").click(function(){
			var thatLogo = $(this);
			layer.open({
				type: 2,
				title: '裁剪图片',
				shadeClose: true,
				shade: 0.5,
				area: ['800px', '730px'],
				content: '<%=request.getContextPath() %>/cropper/cropMuseumLogo.html' //iframe的url
			});
		});
		//点击取消按钮
		$("#cancel").click(function(){
			layer.confirm('您确定要退出本页面吗？', {
				btn: ['确定','取消'] //按钮
			}, function(){
				layer.closeAll();  //关闭弹出层
				window.history.back(-1);  //关闭弹出层
				window.location.href = "<%=request.getContextPath() %>/admin/admin/user/adminList.do"
			}, function(){
				layer.closeAll();  //关闭弹出层
			});
		});
	</script>
</body>
</html>