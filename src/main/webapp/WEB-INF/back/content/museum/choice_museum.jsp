<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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

<title>选择博物馆</title>
</head>
<body>
	
<!--_header 作为公共模版分离出去-->
 <%@ include file="../../header.jsp"%> 

<!--_menu 左边slide导航开始-->
 <%@ include file="../aside.jsp" %> 
<!--/_menu 作为公共模版分离出去-->

<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">
	</i> <a href="/" class="maincolor">内容管理</a> <span class="c-999 en">&gt;</span><span class="c-666">选择博物馆</span> <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<!-- 数据内容 -->
<div class="Hui-article">
		<article class="cl pd-20">
		
			<form action="<%=request.getContextPath()%>/museuminfo/getMuseumAll.do" method="post">
				<div class="col-sm-12 col-md-4 mt-20">	
					级别： 
					<span class="select-box" style="width:150px">
						<select class="select" name="level" value="${museumInfo.level}">
									<option value="0"
										<c:if test="${'' eq museumInfo.level}">selected</c:if>>全部</option>
									<option value="1"
										<c:if test="${'1' eq museumInfo.level}">selected</c:if>>一级博物馆</option>
									<option value="2"
										<c:if test="${'2' eq museumInfo.level}">selected</c:if>>二级博物馆</option>
									<option value="3"
										<c:if test="${'3' eq museumInfo.level}">selected</c:if>>三级博物馆</option>
									<option value="4"
										<c:if test="${'4' eq museumInfo.level}">selected</c:if>>未定级</option>
						</select>
					</span>
				</div>	
				<%--<div class="row cl col-sm-12 col-md-3 mt-20">
					类别：
					<span class="select-box" style="width:150px">
						<select name="categoryId" value="${museumInfo.categoryId}"
									class="select" id="selectId">
										<option value="0"
											<c:if test="${'' eq museumInfo.categoryId}">selected</c:if>>全部</option>
										<option value="1"
											<c:if test="${'1' eq museumInfo.categoryId}">selected</c:if>>历史博物馆</option>
										<option value="2"
											<c:if test="${'2' eq museumInfo.categoryId}">selected</c:if>>革命博物馆</option>
										<option value="3"
											<c:if test="${'3' eq museumInfo.categoryId}">selected</c:if>>遗址博物馆</option>
										<option value="4"
											<c:if test="${'4' eq museumInfo.categoryId}">selected</c:if>>民族民俗博物馆</option>
										<option value="5"
											<c:if test="${'5' eq museumInfo.categoryId}">selected</c:if>>文化艺术博物馆</option>
										<option value="6"
											<c:if test="${'6' eq museumInfo.categoryId}">selected</c:if>>自然博物馆</option>
										<option value="7"
											<c:if test="${'7' eq museumInfo.categoryId}">selected</c:if>>科学技术博物馆</option>
										<option value="8"
											<c:if test="${'8' eq museumInfo.categoryId}">selected</c:if>>综合博物馆</option>
								</select>
					</span>
				</div>--%>
				<div class="row cl col-sm-12 col-md-5 mt-20 text-r">
					博物馆名称：<input type="text" name="museumName" value="${museumInfo.museumName}"  style="width:150px" class="input-text">
					<button class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i>搜索</button>
					<input class="btn btn-success"  type="reset">
				</div>
				  <div style="clear:both"></div>
				</form>
		
		
		
			<div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="r">共有数据：<strong>${museumList.page.allRow}</strong> 条</span>
			</div>
			
			<div class="mt-20">
				<table class="table table-border table-bordered table-bg table-hover table-sort">
					<thead>
						<tr class="text-c">
							<th width="10">序号</th>
							<th width="80">博物馆名称</th>
							<%--<th width="80">类别</th>--%>
							<th width="80">级别</th>
							<th width="120">地区</th>
							<th width="100">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${museumList.data}" var="museum" varStatus="status">
							<tr class="text-c">
								<td>${status.index + 1}</td>
								<td>${museum.museumName}</td>
								<%--<td>${museum.categoryName}</td> --%>
								<td>${museum.level==1?'一级博物馆':museum.level==2?'二级博物馆':museum.level==3?'三级博物馆':museum.level==4?'未定级':''} </td>
								<td>${museum.cityName}</td> 
								<td><a href="<%=request.getContextPath()%>/museuminfo/goMuseumPage.do?MuseumInfoId=${museum.museumInfoId}">选择</a></td>
							</tr>
						</c:forEach> 
						
					</tbody> 
				</table>
			</div>
			<br>
			<div id="page" align="center"></div>
		</article>
	</div>
</section>	
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<!-- 分页功能 -->
	<script type="text/javascript">
		var nums = ${museumList.page.size}; //每页出现的数量
		var pages = ${museumList.page.totalPage}; //得到总页数
		//调用分页
		laypage({
		    cont: 'page',
		    pages: pages,
		    curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
		        var page = location.search.match(/page=(\d+)/);
		        return page ? page[1] : 1;
		    	}(), 
		   	skip: true, //是否开启跳页
		   	skin: '#72CDAE', //皮肤
		   	groups: 3, //连续显示分页数
		    jump: function(e, first){ //触发分页后的回调
		       if(!first){ //一定要加此判断，否则初始时会无限刷新
		         location.href = '?page='+e.curr+'&'+$('form').serialize() ;
		       }
		    }
		})
	</script>
</body>
</html>