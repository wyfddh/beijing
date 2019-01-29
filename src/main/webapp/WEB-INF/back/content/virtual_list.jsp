<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
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

<title>虚拟展厅列表</title>
</head>
<body>
	
<!--_header 作为公共模版分离出去-->
 <%@ include file="../header.jsp"%> 

<!--_menu 左边slide导航开始-->
 <%@ include file="aside.jsp" %> 
<!--/_menu 作为公共模版分离出去-->

<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">
	</i> <a href="/" class="maincolor">内容管理</a> <span class="c-999 en">&gt;</span><span class="c-666">展览列表</span> <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<!-- 数据内容 -->
<div class="Hui-article">
		<article class="cl pd-20">
			<div class="row cl">
			  <form action="<%=request.getContextPath()%>/virtual/getVirtual.do" method="post">
				<div class="col-sm-6 pt-10 col-md-4 col-lg-4">
					当前状态： 
					<span class="select-box" style="width:150px">
						<select class="select" name="publish" value="${virtual.publish}" size="1">
							<option value="-128" selected="selected">全部</option>
							<option value="1" <c:if test="${'1' eq virtual.publish}">selected</c:if>>已发布</option>
							<option value="0" <c:if test="${'0' eq virtual.publish}">selected</c:if>>待发布</option>
						</select>
					</span>
				</div>
				<div class="col-sm-6 pt-10 col-md-4 col-lg-3">
					类型:
					<span class="select-box" style="width:150px">
						<select class="select" name="viClassify" value="${virtual.viClassify}" size="1">
							<option value="" selected="selected">全部</option>
							<option value="1" <c:if test="${'1' eq virtual.viClassify}">selected</c:if>>三维虚拟漫游</option>
							<option value="2" <c:if test="${'2' eq virtual.viClassify}">selected</c:if>>全景漫游</option>
						</select>
					</span>
				</div>
				<div class="col-sm-6 pt-10 col-md-4 col-lg-4">
					所属单位：<input type="text" style="width:200px" class="input-text" name="viUnit" value="${virtual.viUnit}">
				</div>
				<div class="col-sm-6 pt-10 col-md-12">
					关键词：<input type="text" name="keys" value="${keys}"  style="width:250px" class="input-text">
					<button class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i>搜索</button>
					<input class="btn btn-success"  type="reset">
				</div>
				<div style= "colar:both"></div>
				</form>
			</div>
			<div class="cl pd-5 bg-1 bk-gray mt-20 ">
				<span class="l">
				<a class="btn btn-primary radius" data-title="添加展览" href="<%=request.getContextPath()%>/virtualadtrum/tovirtualAdd.do"><i class="Hui-iconfont">&#xe600;</i> 添加展览</a>
				</span>
				<span class="r">共有数据：<strong>${virtualList.page.allRow}</strong> 条</span>
			</div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-bg table-hover table-sort">
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
						<c:forEach items="${virtualList.data}" var="virtual" varStatus="status">
							<tr class="text-c">
								<td>${status.index + 1}</td>
								<td>${virtual.viName}</td>
								<td>${virtual.viClassify==1?'三维虚拟漫游':virtual.viClassify==2?'全景漫游':''}</td>
								<td>${virtual.staTime}</td>
								<td class="state">${virtual.publish==1?'已发布':virtual.publish==0?'待发布':''}</td>
								<td>${virtual.viUnit}</td>
								<!-- 预览的地址栏需要修改 -->
								<td>
									 <a style="text-decoration:none" href="<%=request.getContextPath() %>/shandong_project/index.html#/displayDetails/inner/${virtual.id}" title="预览" target="_blank"><i class="Hui-iconfont">&#xe695;</i></a>  
									 <%-- <input type="button" onclick="release('${virtual.publish}','${virtual.id}')" value="${virtual.publish==1?'取消发布':virtual.publish==0?'发布':''}" class="fabu"> --%>
									 <c:if test="${virtual.publish==1}">
									 	<a style="text-decoration:none" onClick="release('${virtual.publish}','${virtual.id}')" title="取消发布"><i class="Hui-iconfont">&#xe631;</i></a>
									 </c:if>
									 <c:if test="${virtual.publish==0}">
									 	<a style="text-decoration:none" onClick="release('${virtual.publish}','${virtual.id}')" title="发布"><i class="Hui-iconfont">&#xe615;</i></a>
										<a title="编辑" href="<%=request.getContextPath()%>/virtualadtrum/getSprInfo.do?id=${virtual.id}" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
										<a title="删除" onclick="delvirtual('${virtual.id}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
									 </c:if>
								</td>
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
<!-- 数据内容结束 -->
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
//删除的代码
	function delvirtual(id){
		layer.confirm('确定删除此信息？', {
			  btn: ['确定','再想想'] //按钮
			}, function(){
				$.ajax({
					url : "<%=request.getContextPath()%>/virtual/deleteSpreadtrum.do",
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