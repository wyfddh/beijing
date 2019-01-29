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
		<link rel="Bookmark" href="<%=request.getContextPath()%>/back/favicon.ico">
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
		<style>
			.headerNav{
				height: 98px;
				/*width: 100%;*/
				border-radius: 7px;
				background: #fff;
				position: absolute;
			    top: 0px;
			    left: 145px;
			        right: 0;
    bottom: 0;
			    line-height: 98px;
			    padding-left: 30px;
			}
			.headerNav a{
				color: #2A9BCF!important;
				display: inline-block;
				height: 24px;
				line-height: 24px;
				border: 1px solid #2A9BCF;
				padding: 7px 20px;
				border-radius: 5px!important;
				text-decoration: none!important;
				margin-right: 24px!important;
			}
			.headerNav a:hover{
				color: #2A9BCF!important;
				background: #fff!important;
			}
			.headerNav a.zhanlan{
				color: #fff!important;
				background: #2A9BCF!important;
			}
			.headerNav a img{
				width: 18px;
				height: 18px;
				margin-top: -5px;
				margin-right: 5px;
			}
			.addZhanxun{
				overflow: hidden;
				height: 72px;
				border-bottom: 1px solid #F1F2F7;
			}
			.addZhanxun>span{
				margin: 20px 32px;
			}
			.addZhanxun>span>a{
				background: #2A9BCF!important;
			}
			.addZhanxun>span>a:hover{
				border-color: #2A9BCF!important;
			}
			.info{
				padding-left: 32px;
			}
			.info div{
				margin: 10px 0;
			}
			.info input{
				line-height: 26px;
				border-radius: 5px;
			}
			.info .star{
				margin-top: 20px;
			}
			.info .star button{
				background: #2A9BCF;
				color: #fff;
				border-radius: 5px;
			}
			.info .star button img{
				margin-top: -3px;
			}
			.info .star button.b2{
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
			#duteyangshi .layui-layer-border{
            border:none!important;
            box-shadow:none!important;
            border-radius:5px!important;
            overflow:hidden!important;
        }
        #duteyangshi .layui-layer-title{
            height:75px!important;
            line-height:70px!important;
            border-bottom:5px solid #f1f2f7!important;
            box-sizing:border-box;
            background:#fff!important;
            font-size: 18px!important;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
            font-weight: bold;
        }
        #duteyangshi .layui-layer-setwin{
            top:30px!important;
        }
        #yulan{
        	width: 838px;
        	margin: 0 auto;
        	margin-top: 30px;
        }
        #yulan>div{
        	width: 430px;
        	height: 320px;
        	overflow: hidden;
        	border-radius: 7px;
        	margin: 0 12px 0 0;
        	float: left;
        }
        #yulan>span>b{
        	font-size: 20px;
        	color: #333232;
        	font-weight: normal;
        }
        #yulan>span>span{
        	margin: 5px 0;
        	display: inline-block;
        	font-size: 14px;
        	color: #959595;
        }
        #yulan>span>font{
        	font-weight: bold;
        	color: #333;
        	font-size: 16px;
        }
        #contentStr{
        	color: #333;
        	font-size: 16px;
        }
		</style>
		<script>
			
		</script>
		<title>策展管理</title>
	</head>

	<body>
		<%@ include file="../weihuNav.jsp" %>
		
		<%@ include file="../../content/aside.jsp" %>
		<section class="Hui-article-box">
			<!-- 数据内容 -->
			<div class="Hui-article">
				<article>
					<div style="padding-top: 10px;" class="info">
						<form action="<%=request.getContextPath()%>/curation/curation.do" method="post" id="curationForm">
							<div class="hide">   
					        	每页显示条数:&nbsp; 
					            <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${CurationExample.size }" name="size">
					        </div> 
							<div class="guanjianci">
								关键词：<input type="text" name="keys" value="${keys}" placeholder="策展人/标题" style="width:190px;height:26px;padding-left: 10px;" class="input-text">
								&nbsp;&nbsp;&nbsp;
								审核状态：
								<span class="select-box" style="width:102px;height:26px;padding:2px 5px;border-radius: 5px;">
									<select class="select" name="publish" size="1" style="color: #999999;">
										<option value="2" <c:if test="${cura.publish==2}">selected</c:if>>待审核</option>
										<option value="0" <c:if test="${cura.publish==0}">selected</c:if>>全部</option>
										<option value="3" <c:if test="${cura.publish==3}">selected</c:if>>已审核</option>
									</select>
								</span>
							</div>
							<div class="">
								策展时间：
								<input type="text" name="staTime" value="${cura.staTime}" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:112px;height:26px;color: #999999;"> -
								<input type="text" name="overTime" value="${cura.overTime}" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax" class="input-text Wdate" style="width:112px;height:26px;color: #999999;">
							</div>
							<div class="star" style="display:block;width:100%;">
								<button class="btn b1" type="submit"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
								<button class="btn b2" type="button" onclick="formReset();"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>
								<span style="float:right;color:#000;padding-right:20px;">共${allPage}条数据</span>
							</div>
							<div style="clear:both"></div>
						</form>
					</div>
					<div class="" style="min-width: 1020px;padding-left: 30px;">
						<table class="table table-hover table-sort">
							<thead>
								<tr class="text-c">
									<th width="20">序号</th>
									<th width="50">状态</th>
									<th width="80">标题</th>
									<th width="75">策展人</th>
									<th width="50">策展时间</th>
									<th width="150">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="recordNumber" value="${(CurationExample.currentPage - 1) * CurationExample.size }" />
								<c:forEach items="${listweihu}" var="spre" varStatus="status">
									<tr class="text-c">
									<td>${status.count + recordNumber}
									</td>
									<td>
									<c:if test="${spre.status>2}">
										<span style="background: #2A9BCF;color: #fff;padding: 5px;border-radius: 5px;">已审核</span>
									</c:if>
									<c:if test="${spre.status<3}">待审核</c:if>
									</td>
									<td>${spre.title}</td>
									<td>${spre.userName}</td>
									<td>
									<fmt:parseDate value="${spre.createTime}" pattern="yyyyMMddHHmmss" var="date"></fmt:parseDate>
     								<fmt:formatDate value="${date}"  pattern="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td>
										<!--  <a title="预览" onclick="edit(this)" inmStr="${spre.imgSrc}" userName="${spre.userName}" titleStr="${spre.title}" contentStr="${spre.description}" href="javascript:" class="ml-5" style="text-decoration:none">-->
										<a title="预览" href="<%=request.getContextPath()%>/curation/toCheckCuration.do?id=${spre.id}" class="ml-5" style="text-decoration:none">
											<img src="<%=request.getContextPath() %>/back/images/chakan.png" alt="" />
										</a>&nbsp;
										<a title="删除" onClick="delSpre('${spre.id}')" class="ml-5" style="text-decoration:none">
											<img src="<%=request.getContextPath() %>/back/images/delicon.png" alt="" />
										</a>&nbsp;
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
		<div id="duteyangshi">
			<div id="yulan" style="display: none;">
				<div>
					<img id="inmStr" width="430" height="320" src="" alt="" />
				</div>
				<span>
					<b id="titleStr"></b> <br />
					<span>策展人 : <span id="userName2"></span></span><br />
					<font>简介：</font>
					<span id="contentStr2">
					</span>
				</span>
			</div>
		</div>
		
		<!-- 数据内容结束 -->
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>

		<script type="text/javascript">
			$(function(){
				var level = ${level};
				if (level == 2) { 
					$(".fabu-aside>ul>li").eq(2).addClass("weihu");
				} else {
					$(".fabu-aside>ul>li").eq(3).addClass("weihu"); 
				}
				$(".headerNav a.cezhanguanli").addClass("active");
				$(".headerNav a.cezhanguanli").find("img").attr("src",'<%=request.getContextPath() %>/back/images/cezhanicon.png');
				 $("#pageSize").change(function() {
				    	var size = $(this).val();
				    	if (size == "") {
				    		return false;
				    	} else {
				    		$("#pageSizeHide").val(size); 
					    	$("#curationForm").submit();
				    	}
			    })
			})
			//用户预览   
			function edit(obj){
				console.log(obj);
				var inmStr = $(obj).attr("inmStr");
				var titleStr =$(obj).attr("titleStr");
				var contentStr= $(obj).attr("contentStr");
				var userName = $(obj).attr("userName");
				console.log(contentStr);
				$("#inmStr").attr("src",inmStr);
		        $("#contentStr2").text(contentStr);
				$("#titleStr").text(titleStr);
				$("#userName2").text(userName);
		        layer.open({
		            type: 1,
		            title: '策展预览',
		            shadeClose: true,
		            shade: 0.5,
		            maxmin: true, //开启最大化最小化按钮
		            area: ['880px', '600px'],
		            content:$("#yulan"),
		        });
    		}
			//用户预览审核
			function check(id){
				
			}
			function formReset() {  
			    $(':input,#myform')  
			     .not(':button, :submit, :reset, :hidden')  
			     .val('')  
			     .removeAttr('checked')  
			     .removeAttr('selected');     
			}
			//删除的代码
			function delSpre(id) {
				layer.confirm('确定删除此信息？', {
					btn: ['确定', '再想想'] //按钮
				}, function() {
					$.ajax({
						url: "<%=request.getContextPath()%>/curation/delectCuration.do",
						type: "post",
						data: "id=" + id,
						async: false,
						dataType: "text",
						success: function(data) {
							$("#curationForm").submit();
							layer.msg('成功删除--删除队+1', {
								icon: 1
							});
						},
						error: function() {
							layer.msg('删除失败--异常队+1', {
								icon: 1
							});
						}
					})
				}, function() {
					layer.msg('已取消删除', {});
				});
				<%-- --%>
			}
			//发布的功能
			function release(publish, id) {
				if(publish == 2) {
					var a = "审核";
				} else if(publish == 4) {
					var a = "取消审核";
				}
				layer.confirm('确定' + a + '此信息？', {
					btn: ['确定', '再想想'] //按钮
				}, function() {
					$.ajax({
						url: "<%=request.getContextPath()%>/curation/updateStatus.do",
						type: "post",
						data: {
							id: id
						},
						async: false,
						dataType: "text",
						success: function(data) {
							if(data == "success") {
								$("#curationForm").submit();
								layer.msg(a + '成功', {
									icon: 1
								});
							}
						},
						error: function() {
							alert("审核失败，请联系xxx");
						}
					})
				}, function() {
					layer.msg('已取消审核', {});
				});
			}
		</script>
		<!-- 分页功能 -->
		<script type="text/javascript">
			var nums = ${
				CurationExample.size
			}; //每页出现的数量
			var pages = ${
				CurationExample.totalPage
			}; //得到总页数
			//调用分页
			laypage({
				cont: 'page',
				pages: pages,
				curr: function() { //通过url获取当前页，也可以同上（pages）方式获取
					var page = location.search.match(/page=(\d+)/);
					return page ? page[1] : 1;
				}(),
				skip: true, //是否开启跳页
				skin: '#72CDAE', //皮肤
				groups: 3, //连续显示分页数
				jump: function(e, first) { //触发分页后的回调
					if(!first) { //一定要加此判断，否则初始时会无限刷新
						location.href = '?page=' + e.curr + '&' + $('form').serialize();
					}
				}
			})
			var abc="<span>每页显示<input style='width:50px;height: 28px;' type='number'  min='5' max='100' step='5' class='input-text' id='pageSize'   value='"+${CurationExample.size }+"' name='size'>条</span>";
			$(".laypage_total").before(abc); 
		</script>

	</body>

</html>