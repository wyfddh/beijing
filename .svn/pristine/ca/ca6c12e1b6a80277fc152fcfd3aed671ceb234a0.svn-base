<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<script type="text/javascript"
	src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/back/static/h-ui/js/H-ui.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back/static/h-ui.admin/skin/default/skin.css"
	id="skin" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back/css/cover.css" />
<!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
<!--/meta 作为公共模版分离出去-->
<title>博物馆栏目管理</title>
<meta name="keywords" content="">
<meta name="description" content="">
<style>
.tabBar {
	border-bottom: none;
}

.tx {
	text-align: right !important;
}

.but {
	color: #ffffff;
	background: #DD514C;
}

.out {
	background: grey;
	border: 1px solid grey;
}

.tabBar span.tabMsg {
	background: none;
	border: none;
	color: #000000;
}

.tabBar span.current {
	background: #3c8560 !important;
	color: #ffffff !important;
	border-radius: 15px;
}

#must {
	/*display: none;*/

}

.img_wrap {
	padding: 50px 0;
	border: 1px solid #e6e6e6;
	color: #6e6e6e;
	margin-left: 15px;
}

.smimg {
	text-align: center;
}

.describe {
	padding: 15px 0 20px 15px;
	margin-left: -100px;
}

.button {
	width: 30px;
	height: 20px;
	line-height: 1px !important;
	text-align: center;
}

.img_msg {
	padding-left: 15px;
}

.img_msg img {
	width: 256px;
	height: 143px;
}

.button_wrap {
	text-align: center;
}

.button_wrap>.sub {
	margin-left: -143px;
}

.turnImgWrap {
	border: 1px solid #CCCCCC;
	padding: 20px 10px;
	margin-top: 20px;
	cursor: pointer !important;
}

.img {
	width: 250px;
	height: 155px;
	background: #f7f7f7;
	cursor: pointer;
}

.delAll {
	position: absolute;
	right: 15px;
	top: 10px;
}

.int-text {
	width: 80%;
	outline: none;
	border: 1px solid #E6E6E6;
	height: 25px;
}

.upfile {
	display: block;
	width: 100%;
	height: 100%;
	position: absolute;
	left: 0;
	top: 0;
	opacity: 0;
}

.Hui-article-box {
	overflow-x: hidden !important;
	overflow-y: auto !important;
}
</style>
</head>
<body>
	<!--_header 作为公共模版分离出去-->
	<%@ include file="../../header.jsp"%>

	<!--_menu 左边slide导航开始-->
	<%@ include file="../aside.jsp"%>
	<!--/_menu 作为公共模版分离出去-->
	<div class="dislpayArrow hidden-xs">
		<a class="pngfix" href="javascript:void(0);"
			onClick="displaynavbar(this)"></a>
	</div>
	<section class="Hui-article-box section_box"> <nav
		class="breadcrumb"> <i class="Hui-iconfont">&#xe67f;</i> 首页<span
		class="c-gray en">&gt;</span>内容管理<span class="c-gray en">&gt;</span>栏目管理<a
		class="btn btn-success radius r"
		style="line-height: 1.6em; margin-top: 3px"
		href="javascript:location.replace(location.href);" title="刷新"><i
		class="Hui-iconfont">&#xe68f;</i></a> </nav>
	<div class="pd-20 Hui-article" style="padding: 50px;">
		<%--<div>--%>
			<%--<a class="btn btn-primary">栏目管理</a>--%>
			<%--&lt;%&ndash;<p style="display: inline-block;border-left: 1px solid #797979;height: 28px;margin-left: 20px;line-height: 25px;">&ndash;%&gt;--%>
			<%--<!-- <a href=""  class="c-primary ml-20" style="cursor: pointer">更新栏目缓存</a></p>--%>
            <%--<a href="" class="btn btn-primary" style="float: right;cursor: pointer!important;">新建栏目</a>-->--%>
		<%--</div>--%>
		<form action="" method="post" class="mt-20">
			<table
				class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="150">栏目名称</th>
						<th width="150">栏目类型</th>
						<th width="90">所属模型</th>
						<th width="300">管理操作</th>
					</tr>
				</thead>
				<tbody>
					<tr class="text-c">
						<td>场馆介绍</td>
						<td>内部栏目</td>
						<td>文章类型</td>
						<td class="td-manage"><c:if
								test="${fn:contains(sessionScope.user.level,3)==true}">
								<c:if
									test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
									<!-- <a title="设置" href="javascript:;" onclick="member_edit()" class="ml-5 btn btn-default" style="text-decoration:none">设置</a> -->
									<a title="编辑"
										href="<%=request.getContextPath()%>/museumColumn/toUpdatePage.do?title=场馆介绍&name=introduce&id=${museum.id}"
										class="ml-5 btn btn-primary" style="text-decoration: none">编辑</a>
									<!--<a title="栏目" href="javascript:;" onclick="member_edit('编辑','member-add.html','4','','510')" class="ml-5 btn btn-success" style="text-decoration:none">关闭栏目</a>-->
								</c:if>
							</c:if></td>
					</tr>
					<tr class="text-c">
						<c:if test="${fn:contains(sessionScope.user.platformId,1)==true}">
							<td>历史沿革</td>
							<td>内部栏目</td>
							<td>文章类型</td>
							<td class="td-manage"><c:if
									test="${fn:contains(sessionScope.user.level,3)==true}">
									<c:if
										test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
										<!-- <a title="设置" href="javascript:;" onclick="member_edit()" class="ml-5 btn btn-default" style="text-decoration:none">设置</a> -->
										<a title="编辑"
											href="<%=request.getContextPath()%>/museumColumn/toUpdatePage.do?title=历史沿革&name=buyTicket&id=${museum.id}"
											onclick="member_edit()" class="ml-5 btn btn-primary"
											style="text-decoration: none">编辑</a>
										<!--<a title="栏目" href="javascript:;" onclick="member_edit('编辑','member-add.html','4','','510')" class="ml-5 btn btn-success" style="text-decoration:none">关闭栏目</a>-->
									</c:if>
								</c:if>
						</c:if>

						<c:if test="${fn:contains(sessionScope.user.platformId,2)==true}">
							<td>如何买票</td>
							<td>内部栏目</td>
							<td>文章类型</td>
							<td class="td-manage"><c:if
									test="${fn:contains(sessionScope.user.level,3)==true}">
									<c:if
										test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
										<!-- <a title="设置" href="javascript:;" onclick="member_edit()" class="ml-5 btn btn-default" style="text-decoration:none">设置</a> -->
										<a title="编辑"
											href="<%=request.getContextPath()%>/museumColumn/toUpdatePage.do?title=如何买票&name=buyTicket&id=${museum.id}"
											onclick="member_edit()" class="ml-5 btn btn-primary"
											style="text-decoration: none">编辑</a>
										<!--<a title="栏目" href="javascript:;" onclick="member_edit('编辑','member-add.html','4','','510')" class="ml-5 btn btn-success" style="text-decoration:none">关闭栏目</a>-->
									</c:if>
								</c:if>
						</c:if>
					</tr>
					<tr class="text-c">
						<c:if test="${fn:contains(sessionScope.user.platformId,1)==true}">
							<td>展览概况</td>
							<td>内部栏目</td>
							<td>文章类型</td>
							<td class="td-manage"><c:if
									test="${fn:contains(sessionScope.user.level,3)==true}">
									<c:if
										test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
										<!-- <a title="设置" href="javascript:;" onclick="member_edit()" class="ml-5 btn btn-default" style="text-decoration:none">设置</a> -->
										<a title="编辑"
											href="<%=request.getContextPath()%>/museumColumn/toUpdatePage.do?title=展览概况&name=nearby&id=${museum.id}"
											onclick="member_edit()" class="ml-5 btn btn-primary"
											style="text-decoration: none">编辑</a>
										<!--<a title="栏目" href="javascript:;" onclick="member_edit('编辑','member-add.html','4','','510')" class="ml-5 btn btn-success" style="text-decoration:none">关闭栏目</a>-->
									</c:if>
								</c:if></td>
						</c:if>
						<c:if test="${fn:contains(sessionScope.user.platformId,2)==true}">
							<td>附近餐饮</td>
							<td>内部栏目</td>
							<td>文章类型</td>
							<td class="td-manage"><c:if
									test="${fn:contains(sessionScope.user.level,3)==true}">
									<c:if
										test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
										<!-- <a title="设置" href="javascript:;" onclick="member_edit()" class="ml-5 btn btn-default" style="text-decoration:none">设置</a> -->
										<a title="编辑"
											href="<%=request.getContextPath()%>/museumColumn/toUpdatePage.do?title=附近餐饮&name=nearby&id=${museum.id}"
											onclick="member_edit()" class="ml-5 btn btn-primary"
											style="text-decoration: none">编辑</a>
										<!--<a title="栏目" href="javascript:;" onclick="member_edit('编辑','member-add.html','4','','510')" class="ml-5 btn btn-success" style="text-decoration:none">关闭栏目</a>-->
									</c:if>
								</c:if></td>
						</c:if>
					</tr>
					<tr class="text-c">
						<c:if test="${fn:contains(sessionScope.user.platformId,1)==true}">
							<td>藏品介绍</td>
							<td>内部栏目</td>
							<td>文章类型</td>
							<td class="td-manage"><c:if
									test="${fn:contains(sessionScope.user.level,3)==true}">
									<c:if
										test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
										<!--   <a title="设置" href="javascript:;" onclick="member_edit()" class="ml-5 btn btn-default" style="text-decoration:none">设置</a> -->
										<a title="编辑"
											href="<%=request.getContextPath()%>/museumColumn/toUpdatePage.do?title=藏品介绍&name=visitNotes&id=${museum.id}"
											onclick="member_edit()" class="ml-5 btn btn-primary"
											style="text-decoration: none">编辑</a>
										<!--<a title="栏目" href="javascript:;" onclick="member_edit('编辑','member-add.html','4','','510')" class="ml-5 btn btn-success" style="text-decoration:none">关闭栏目</a>-->
									</c:if>
								</c:if></td>
						</c:if>
						<c:if test="${fn:contains(sessionScope.user.platformId,2)==true}">
							<td>参观须知</td>
							<td>内部栏目</td>
							<td>文章类型</td>
							<td class="td-manage"><c:if
									test="${fn:contains(sessionScope.user.level,3)==true}">
									<c:if
										test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
										<!--   <a title="设置" href="javascript:;" onclick="member_edit()" class="ml-5 btn btn-default" style="text-decoration:none">设置</a> -->
										<a title="编辑"
											href="<%=request.getContextPath()%>/museumColumn/toUpdatePage.do?title=参观须知&name=visitNotes&id=${museum.id}"
											onclick="member_edit()" class="ml-5 btn btn-primary"
											style="text-decoration: none">编辑</a>
										<!--<a title="栏目" href="javascript:;" onclick="member_edit('编辑','member-add.html','4','','510')" class="ml-5 btn btn-success" style="text-decoration:none">关闭栏目</a>-->
									</c:if>
								</c:if></td>
						</c:if>
					</tr>
					<tr class="text-c">
						<c:if test="${fn:contains(sessionScope.user.platformId,1)==true}">
							<td>参观感言</td>
							<td>内部栏目</td>
							<td>文章类型</td>
							<td class="td-manage"><c:if
									test="${fn:contains(sessionScope.user.level,3)==true}">
									<c:if
										test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
										<!-- <a title="设置" href="javascript:;" onclick="member_edit()" class="ml-5 btn btn-default" style="text-decoration:none">设置</a> -->
										<a title="编辑"
											href="<%=request.getContextPath()%>/museumColumn/toUpdatePage.do?title=参观感言&name=serviceInformation&id=${museum.id}"
											onclick="member_edit()" class="ml-5 btn btn-primary"
											style="text-decoration: none">编辑</a>
										<!--<a title="栏目" href="javascript:;" onclick="member_edit('编辑','member-add.html','4','','510')" class="ml-5 btn btn-success" style="text-decoration:none">关闭栏目</a>-->
									</c:if>
								</c:if></td>
						</c:if>
						<c:if test="${fn:contains(sessionScope.user.platformId,2)==true}">
							<td>服务信息</td>
							<td>内部栏目</td>
							<td>文章类型</td>
							<td class="td-manage"><c:if
									test="${fn:contains(sessionScope.user.level,3)==true}">
									<c:if
										test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
										<!-- <a title="设置" href="javascript:;" onclick="member_edit()" class="ml-5 btn btn-default" style="text-decoration:none">设置</a> -->
										<a title="编辑"
											href="<%=request.getContextPath()%>/museumColumn/toUpdatePage.do?title=服务信息&name=serviceInformation&id=${museum.id}"
											onclick="member_edit()" class="ml-5 btn btn-primary"
											style="text-decoration: none">编辑</a>
										<!--<a title="栏目" href="javascript:;" onclick="member_edit('编辑','member-add.html','4','','510')" class="ml-5 btn btn-success" style="text-decoration:none">关闭栏目</a>-->
									</c:if>
								</c:if></td>
						</c:if>
					</tr>
					<tr class="text-c">
						<td>馆内藏品</td>
						<td>外部栏目</td>
						<td>列表类型</td>
						<td class="td-manage"><c:if
								test="${fn:contains(sessionScope.user.level,3)==true}">
								<c:if
									test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
									<!-- <a title="设置" href="javascript:;" onclick="member_edit()" class="ml-5 btn btn-default" style="text-decoration:none">设置</a> -->
									<a title="编辑"
										href="<%=request.getContextPath()%>/back/oCCollection/info.do"
										onclick="member_edit()" class="ml-5 btn btn-primary"
										style="text-decoration: none">编辑</a>
									<!--  <a title="栏目" href="javascript:;" onclick="member_edit()" class="ml-5 btn btn-success unit" style="text-decoration:none">关闭栏目</a> -->
								</c:if>
							</c:if></td>
					</tr>
					<tr class="text-c">
						<td>展览资讯</td>
						<td>外部栏目</td>
						<td>列表类型</td>
						<td class="td-manage"><c:if
								test="${fn:contains(sessionScope.user.level,3)==true}">
								<c:if
									test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
									<!-- <a title="设置" href="javascript:;" onclick="member_edit()" class="ml-5 btn btn-default" style="text-decoration:none">设置</a> -->
									<a title="编辑"
										href="<%=request.getContextPath()%>/museumColumn/toSpreadtrumPage.do"
										onclick="member_edit()" class="ml-5 btn btn-primary"
										style="text-decoration: none">编辑</a>
									<c:if test="${museum.spreOpen==0}">
										<a title="开启栏目"
											onClick="spreOpen('${museum.spreOpen}','${museum.id}','${museum.orgId}')"
											class="ml-5 btn btn-success unit"
											style="text-decoration: none">开启栏目</a>
									</c:if>
									<c:if test="${museum.spreOpen==1}">
										<a title="关闭栏目"
											onClick="spreOpen('${museum.spreOpen}','${museum.id}','${museum.orgId}')"
											class="ml-5 btn btn-success unit"
											style="text-decoration: none">关闭栏目</a>
									</c:if>
								</c:if>
							</c:if></td>
					</tr>
					<tr class="text-c">
						<td>虚拟展厅</td>
						<td>外部栏目</td>
						<td>列表类型</td>
						<td class="td-manage"><c:if
								test="${fn:contains(sessionScope.user.level,3)==true}">
								<c:if
									test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
									<!-- <a title="设置" href="javascript:;" onclick="member_edit()" class="ml-5 btn btn-default" style="text-decoration:none" disabled>设置</a> -->
									<a title="编辑"
										href="<%=request.getContextPath()%>/museumColumn/toVirtualPage.do"
										onclick="member_edit()" class="ml-5 btn btn-primary"
										style="text-decoration: none">编辑</a>
									<c:if test="${museum.virOpen==0}">
										<a title="开启栏目"
											onClick="virOpen('${museum.virOpen}','${museum.id}')"
											class="ml-5 btn btn-success unit"
											style="text-decoration: none">开启栏目</a>
									</c:if>
									<c:if test="${museum.virOpen==1}">
										<a title="关闭栏目"
											onClick="virOpen('${museum.virOpen}','${museum.id}')"
											class="ml-5 btn btn-success unit"
											style="text-decoration: none">关闭栏目</a>
									</c:if>
								</c:if>
							</c:if></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	</section>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">

   //开启关闭展栏栏目
 	function spreOpen(spreOpen,id,orgId){
 		if(spreOpen == 0){
 			var a = "开启";
 		}
 		if(spreOpen == 1){
 			var a = "关闭";
 		}
 		layer.confirm('确定'+a+'此栏目？', {
 			 btn: ['确定','再想想'] //按钮
 			}, function(){
 				$.ajax({
 					url : "<%=request.getContextPath()%>/museumColumn/updateSpreOpen.do",
 					type : "post",
 					data :{id:id,orgId:orgId},
 					async:false,
 					dataType : "text",
 					success : function(data){
 						if(data == "success"){
 			 			layer.msg('操作成功', {icon: 1});
 						window.location.href = '<%=request.getContextPath()%>/museumColumn/getMuseumColumn.do';
 						}
 					},
 					error : function(){
 						alert("操作栏目失败，请联系xxx");
 					}
 				})
 			}, function(){
 			  layer.msg('已取消操作', {
 			  });
 			});
 	}
 	//开启关闭展厅栏目
 	function virOpen(virOpen,id,orgId){
 		if(virOpen == 0){
 			var a = "关闭";
 		}
 		if(virOpen == 1){
 			var a = "开启";
 		}

 		layer.confirm('确定'+a+'此栏目？', {
 			 btn: ['确定','再想想'] //按钮
 			}, function(){
 				$.ajax({
 					url : "<%=request.getContextPath()%>/museumColumn/updateVirOpen.do",
 					type : "post",
 					data :{id:id,orgId:orgId},
 					async:false,
 					dataType : "text",
 					success : function(data){
 						if(data == "success"){
 			 			layer.msg('操作成功', {icon: 1});
 						window.location.href = '<%=request.getContextPath()%>/museumColumn/getMuseumColumn.do';
												}
											},
											error : function() {
												alert("操作栏目失败，请联系xxx");
											}
										})
							}, function() {
								layer.msg('已取消操作', {});
							});
		}
	</script>
</body>
</html>
