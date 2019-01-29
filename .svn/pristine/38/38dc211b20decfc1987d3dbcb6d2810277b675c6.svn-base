<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
	<style>
	.boxsize{
		box-sizing:border-box!important;
	}
	.height26{
		height:26px;
		border:1px solid #ddd;
		border-radius:5px;
		box-sizing:border-box;
		padding:2px 5px;
	}
	.width120{
		width:120px;
	}
	.wigth150{
		width:150px;
	}
	.width200{
		width:200px;
	}
	.width250{
		width:250px;
	}
	.width600{
		width:600px;
	}
	.divwidth{
		width:400px;
		height:30px;
		margin:10px 0;
		float:left;
	}
	</style>
<title>国外展览信息列表</title>
</head>
<body>
	
<!--_header 作为公共模版分离出去-->
 <%@ include file="../../fabuNav.jsp"%>

<!--_menu 左边slide导航开始-->
 <%@ include file="../aside.jsp" %> 
<!--/_menu 作为公共模版分离出去-->
<section class="Hui-article-box boxsize">
	<div class="Hui-article boxsize">
		<article class="cl boxsize" style="padding-left:30px;">
			<div class="cl">
				<form action="<%=request.getContextPath()%>/otherSpreadtrum/getOtherSpreadtrum.do" method="post">
					<input type="hidden" name="type" value="${otherSpreadtrum.type}"/>
					<div class="divwidth">
						发布时间：
						<input type="text" name="staTime"  value="${otherSpreadtrum.staTime}" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate height26 width120">
				    		-
				    	<input type="text" name="overTime"  value="${otherSpreadtrum.overTime}" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax" class="input-text Wdate height26 width120">
					</div>
					<div class="divwidth">
				    	当前状态：
				        <span>
					    	<select class="height26 wigth150" name="publish"  value="${otherSpreadtrum.publish}" size="1">
							    <option value="-128" selected="selected">全部</option>
							    <option value="1" <c:if test="${'1' eq otherSpreadtrum.publish}">selected</c:if>>已发布</option>
							    <option value="0" <c:if test="${'0' eq otherSpreadtrum.publish}">selected</c:if>>待发布</option>
						    </select>
					    </span>
					</div>
					<div class="divwidth">发布单位：<input type="text" class="input-text width200 height26"  value="${otherSpreadtrum.musExhibition}" name="musExhibition"></div>
					<div class="divwidth">创建人：<input type="text" class="input-text width200 height26"  value="${otherSpreadtrum.userName}" name="userName"></div>
					<div class="divwidth" style="width:600px;">
						关键词：<input type="text" name="keys" value="${keys}" class="input-text width250 height26">
						<button class="btn" style="background:#2A9BCF;height:26px;color:#fff;line-height:17px!important;" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
						<input class="btn" style="height:26px;color:#000;line-height:17px!important;"  type="reset">
					</div>
				</form>
			</div>
			<div class="boxsize" style="padding-right:30px;">
				<a class="btn btn-primary radius" style="background:#2A9BCF!important;" data-title="添加展览" href="<%=request.getContextPath()%>/otherSpreadtrum/toOutSpreAdd.do?type=2"><i class="Hui-iconfont">&#xe600;</i> 添加展览</a>
				<span class="r">共有数据：<strong>${otherSpreList.page.allRow}</strong> 条</span>
			</div>
			<div class="mt-20 boxsize" style="padding-right:30px;">
				<table class="table">
					<thead>
						<tr class="text-c" >
							<th width="80">序号</th>
							<th width="150">标题</th>
							<th width="200">展期</th>
							<th width="120">展馆名称</th>
							<th width="80">当前状态</th>
							<th width="75">发布人</th>
							<th width="60">发布时间</th>
							<th width="120">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${otherSpreList.data}" var="otherspre"  varStatus="status">
							<tr class="text-c">
								<td>${ status.index + 1}</td>
								<td style="font-size:14px;">${otherspre.headline}</td>
								<td>${otherspre.staTime}---${otherspre.overTime}</td> 
								<td>${otherspre.musExhibition}</td>
								<td>${otherspre.publish==1?'已发布':otherspre.publish==0?'待发布':''}</td>
								<td>${otherspre.nickName}</td>
								<td class="td-status"><span>${otherspre.issueTime}	</span></td>
								<!-- 预览的地址栏需要修改 -->
								<td>
									 <a style="text-decoration:none" href="<%=request.getContextPath()%>/${pcRootPath }#/displayDetails/outer/${otherspre.id}" title="预览" target="_blank"><i class="Hui-iconfont">&#xe695;</i></a>  
									 <%-- <input type="button" onclick="release('${spre.publish}','${spre.id}')" value="${spre.publish==1?'取消发布':spre.publish==0?'发布':''}" class="fabu"> --%>
									 <c:if test="${otherspre.publish==1}">
									 	<a style="text-decoration:none" onClick="release('${otherspre.publish}','${otherspre.id}')" title="取消发布"><i class="Hui-iconfont">&#xe631;</i></a>
									 </c:if>
									 <c:if test="${otherspre.publish==0}">
									 	<a style="text-decoration:none" onClick="release('${otherspre.publish}','${otherspre.id}')" title="发布"><i class="Hui-iconfont">&#xe615;</i></a>
										<a title="编辑" href="<%=request.getContextPath()%>/otherSpreadtrum/getOutSprInfo.do?id=${otherspre.id}" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
										<a title="删除" onclick="delSpre('${otherspre.id}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
									 </c:if>
								</td>
							</tr>
						</c:forEach> 
					</tbody>
				</table>
			</div>
			<br>
			<div id="page" align="left"></div>
		</article>
	</div>
<!-- 数据内容结束 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
	$(function(){
		$(".fabu-aside>ul>li").eq(0).addClass("fabu");
		$(".headerNav").find(".abroadSpre").addClass("active").find("img").attr("src",'<%=request.getContextPath() %>/back/images/zllogoActive.png');
	});
//删除的代码
	function delSpre(id){
		layer.confirm('确定删除此信息？', {
			  btn: ['确定','再想想'] //按钮
			}, function(){
				$.ajax({
					url : "<%=request.getContextPath()%>/otherSpreadtrum/deleteSpreadtrum.do",
					type : "post",
					data : "id="+id,
					async:false,
					dataType : "text",
					success : function(data){
						window.location.href = '<%=request.getContextPath()%>/otherSpreadtrum/getOtherSpreadtrum.do?type=2';
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
					url : "<%=request.getContextPath()%>/otherSpreadtrum/updatePublish.do",
					type : "post",
					data :{id:id},
					async:false,
					dataType : "text",
					success : function(data){
						if(data == "success"){
						window.location.href = '<%=request.getContextPath()%>/otherSpreadtrum/getOtherSpreadtrum.do?type=2';
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
	var nums = ${otherSpreList.page.size}; //每页出现的数量
	var pages = ${otherSpreList.page.totalPage}; //得到总页数
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