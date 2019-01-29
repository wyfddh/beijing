<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="<%=request.getContextPath()%>/back/favicon.ico" >
<link rel="Shortcut Icon" href="<%=request.getContextPath()%>/back/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="back/lib/html5.js"></script>
<script type="text/javascript" src="back/lib/respond.min.js"></script>
<![endif]-->
<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/css/cover.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
	.addHuoDong{
				overflow: hidden;
				height: 72px;
				border-bottom: 1px solid #F1F2F7;
			}
			.addHuoDong>span{
				margin: 20px 32px;
				    display: block;
			}
			.addHuoDong>span>a{
				background: #2A9BCF!important;
			}
			.addHuoDong>span>a:hover{
				border-color: #2A9BCF!important;
			}
			.huodong{
				padding: 30px;
				padding-bottom: 0;
			}
			.huodong input{
				line-height: 26px;
				border-radius: 5px;
			}
			.huodong>div{
				margin: 12px 0;
			}
			.huodong .star{
				margin-top: 20px;
			}
			.huodong .star button{
				background: #2A9BCF;
				color: #fff;
				border-radius: 5px;
			}
			.huodong .star button img{
				margin-top: -3px;
			}
			.huodong .star button.b2{
				background: #fff;
				color: #2A9BCF;
				border-color: #2A9BCF;
			}
			tbody .text-c{
				border-bottom: 1px solid #DDDDDD;
			}
			thead>tr{
				background: #F1F2F7!important;
				height: 60px!important;
				border-radius: 7px!important;
			}
			thead>tr>th{
				color: #666666!important;
			}
</style>
<script>
			$(function(){
				$(".fabu-aside>ul>li").eq(0).addClass("fabu");
				$(".headerNav a.xnzhangting").addClass("active");
				$(".headerNav a.xnzhangting").find("img").attr("src",'<%=request.getContextPath() %>/back/images/xnlogoActive.png');
			})
		</script>
<title>虚拟展厅列表</title>
</head>
<body>
	
<!--_header 作为公共模版分离出去-->
 <%@ include file="../../fabuNav.jsp"%> 

<!--_menu 左边slide导航开始-->
 <%@ include file="../aside.jsp" %> 
<!--/_menu 作为公共模版分离出去-->

<section class="Hui-article-box">
	<!--<nav class="breadcrumb"><i class="Hui-iconfont">
	</i> <a href="/" class="maincolor">内容管理</a> <span class="c-999 en">&gt;</span><span class="c-666">展厅列表</span> <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>-->
<!-- 数据内容 -->
<div class="Hui-article">
		<!--添加虚拟展厅-->
					<div class="addZhanxun">
						<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
							<span class="l">
								<a class="btn btn-primary radius" data-title="添加展厅" href="<%=request.getContextPath()%>/virtual/toVirtualAdd.do"><i class="Hui-iconfont">&#xe600;</i> 添加虚拟展厅</a>
							</span>
						</c:if>
					</div>
			<article class="">
				<div>
				<form action="<%=request.getContextPath()%>/virtual/getVirtual.do" method="post" class="huodong" id="form">
					<div>
						关键词：<input style="width: 190px;height: 26px;" type="text" name="keys" value="${keys}"  style="width:250px" class="input-text">
					</div>
					<div>
						当前状态： 
						<span class="select-box" style="width: 100px;height: 26px;padding: 2px 5px;border-radius: 5px;">
							<select class="select" name="publish" value="${virtual.publish}" size="1">
								<option value="-127" selected="selected">全部</option>
								<option value="1" <c:if test="${'1' eq virtual.publish}">selected</c:if>>已发布</option>
								<option value="0" <c:if test="${'0' eq virtual.publish}">selected</c:if>>待发布</option>
							</select>
						</span>
						&nbsp;&nbsp;&nbsp;类型:
						<span class="select-box" style="width: 100px;height: 26px;padding: 2px 5px;border-radius: 5px;">
							<select class="select" name="viClassify" value="${virtual.viClassify}" size="1">
								<option value="" selected="selected">全部</option>
								<option value="1" <c:if test="${'1' eq virtual.viClassify}">selected</c:if>>三维虚拟漫游</option>
								<option value="2" <c:if test="${'2' eq virtual.viClassify}">selected</c:if>>全景漫游</option>
							</select>
						</span>
						&nbsp;&nbsp;&nbsp;
						<c:if test="${level==2 || level==1}">
						 	<div>	
								发布单位：<input type="text" name="orgId"  value="${virtual.orgId}" style="width: 190px;height: 26px;" class="input-text">
							</div>
						</c:if>		
					</div>
					<div class="hide">   
						        	每页显示条数:&nbsp; 
						            <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${virtualList.page.size }" name="size">
						        </div> 
					<div class="star">
								<button class="btn b1" type="submit"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
								<button class="btn b2" type="button" onclick="formReset();"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>
								<!--<input class="btn btn-success" type="reset">-->
					</div>
				</form>
			</div>
			<div class="" style="min-width: 1020px;padding-left: 30px">
						<span class="r" style="margin-right:35px;">共<strong style="color: #57AAD6;">${virtualList.page.allRow}</strong>条数据</span>
			</div>
			<!--<div>
			
				<span class="r">共有数据：<strong>${virtualList.page.allRow}</strong> 条</span>
			</div>-->
			<div style="min-width: 990px;padding-left: 30px;">
				<table class="table">
					<thead>
						<tr class="text-c">
							<th width="10">序号</th>
							<th width="80">虚拟博物馆名称</th>
							<th width="80">类型</th>
							<th width="80">录入时间</th>
							<th width="120">当前状态</th>
							<th width="75">所属单位</th>
							<th width="100">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="recordNumber" value="${(virtualList.page.currentPage - 1) * virtualList.page.size }" />
						<c:forEach items="${virtualList.data}" var="virtual" varStatus="status">
							<tr class="text-c">
								<td>${status.count + recordNumber}</td>
								<td>${virtual.viName}</td>
								<td>${virtual.viClassify==1?'三维虚拟漫游':virtual.viClassify==2?'全景漫游':''}</td>
								<td>${virtual.staTime}</td>
								<%-- <td class="state">${virtual.publish==1?'已发布':virtual.publish==0?'待发布':''}
									
								</td> --%>
								<c:if test="${virtual.publish==1}">
											<td class="state">
												<span style="background: #2A9BCF;color: #fff;padding: 5px;border-radius: 5px;">已发布</span>
											</td>
										</c:if>
										<c:if test="${virtual.publish==0}">
											<td class="state">待发布</td>
										</c:if>
								<td>${virtual.musExhibition}</td>
								<!-- 预览的地址栏需要修改 -->
								<td>
									 <%-- <input type="button" onclick="release('${virtual.publish}','${virtual.id}')" value="${virtual.publish==1?'取消发布':virtual.publish==0?'发布':''}" class="fabu"> --%>
									 <c:if test="${fn:contains(sessionScope.user.level,3)==true && fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
										 <c:if test="${virtual.publish==1}">
										 	<a style="text-decoration:none" onClick="release('${virtual.publish}','${virtual.id}')" title="取消发布">
										 		<img src="<%=request.getContextPath() %>/back/images/quxiaofabuicon.png" alt="" />
										 	</a>&nbsp;
										 </c:if>
										 <c:if test="${virtual.publish==0}">
											<a title="编辑" href="<%=request.getContextPath()%>/virtual/getVirInfo.do?id=${virtual.id}" class="ml-5" style="text-decoration:none">
												<img src="<%=request.getContextPath() %>/back/images/bianjiicon.png" alt="" />
											</a>&nbsp;
										 	<a style="text-decoration:none" onClick="release('${virtual.publish}','${virtual.id}')" title="发布">
										 		<img src="<%=request.getContextPath() %>/back/images/fabu.png" alt="" />
										 	</a>&nbsp;
										 </c:if>
									 </c:if>
									 <a style="text-decoration:none" href="${virtual.viPCUrl}" title="预览" target="_blank">
									 	<img src="<%=request.getContextPath() %>/back/images/chakan.png" alt="" />
									 </a>&nbsp; 
									 <c:if test="${fn:contains(sessionScope.user.level,3)==true && fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
										 <c:if test="${virtual.publish==0}">
											<a title="删除" onclick="delvirtual('${virtual.id}')" class="ml-5" style="text-decoration:none">
												<img src="<%=request.getContextPath() %>/back/images/delicon.png" alt="" />
											</a>&nbsp;
										 </c:if>
									 </c:if>
									 <c:if test="${fn:contains(sessionScope.user.authStr,'SystemAdmin')==true}">
										<button class="btn btn-primary radius" type="button"  onclick="window.location.href='/admin/museumInfoManage/spreInfo.do?title=${virtual.viName}&id=${virtual.id}&orgId=${virtual.orgId}'">模板</button>
									 </c:if>
								</td>
							</tr>
						</c:forEach> 
						
					</tbody>
				</table>
			</div>
			<br>
			<div id="page" style="padding-left: 30px;"></div>
		</article>
	</div>
</section>	
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
		<script type="text/javascript">
		
		$(function(){
			 $("#pageSize").change(function() {
			    	var size = $(this).val();
			    	if (size == "") {
			    		return false;
			    	} else {
			    		$("#pageSizeHide").val(size); 
				    	$("#form").submit();
			    	} 
		    })
		})
//删除的代码
	function delvirtual(id){
		layer.confirm('确定删除此信息？', {
			  btn: ['确定','再想想'] //按钮
			}, function(){
				$.ajax({
					url : "<%=request.getContextPath()%>/virtual/deleteVirtual.do",
					type : "post",
					data : "id="+id,
					async:false,
					dataType : "text",
					success : function(data){
						window.location.href = '<%=request.getContextPath()%>/virtual/getVirtual.do';
			  			layer.msg('成功删除--删除队+1', {icon: 1});
					},
					error : function(){
			  			layer.msg('删除失败--异常队+1', {icon: 1});
					}
				}) 
			}, function(){
			  layer.msg('已取消删除', {
			  });	
			});
		<%-- --%>
	}
//发布的功能
	function release(publish,id){
		if(publish == 0){
			var a = "发布";
		} else if(publish == 1){
			var a = "取消发布";
		}
		layer.confirm('确定'+a+'此信息？', {
			 btn: ['确定','再想想'] //按钮
			}, function(){
				$.ajax({
					url : "<%=request.getContextPath()%>/virtual/updatePublish.do",
					type : "post",
					data :{id:id},
					async:false,
					dataType : "text",
					success : function(data){
						if(data == "success"){
						window.location.href = '<%=request.getContextPath()%>/virtual/getVirtual.do';
			 			layer.msg(a+'成功', {icon: 1});
						}
					},
					error : function(){
						alert("发布失败，请联系xxx");
					}
				})
			}, function(){
			  layer.msg('已取消发布', {
			  });
			});
	}
	function formReset() {  
	    $(':input,#myform')  
	     .not(':button, :submit, :reset, :hidden')  
	     .val('')  
	     .removeAttr('checked')  
	     .removeAttr('selected');     
	}
</script>
<!-- 分页功能 -->
	<script type="text/javascript">
		var nums = ${virtualList.page.size}; //每页出现的数量
		var pages = ${virtualList.page.totalPage}; //得到总页数
		//调用分页
		laypage({
		    cont: 'page',
		    pages: pages,
		    curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
		        var page = location.search.match(/page=(\d+)/);
		        return page ? page[1] : 1;
		    	}(), 
		   	skip: true, //是否开启跳页
		   	skin: '#2A9BCF', //皮肤
		   	groups: 3, //连续显示分页数
		    jump: function(e, first){ //触发分页后的回调
		       if(!first){ //一定要加此判断，否则初始时会无限刷新
		         location.href = '?page='+e.curr+'&'+$('form').serialize() ;
		       }
		    }
		})
		var abc="<span>每页显示<input style='width:50px;height: 28px;' type='number'  min='5' max='100' class='input-text' id='pageSize'   value='"+${virtualList.page.size }+"' name='size'>条</span>";
		$(".laypage_total").before(abc); 
	</script>
</body>
</html>