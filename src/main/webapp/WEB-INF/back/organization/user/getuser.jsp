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
        	width: 470px;
        	margin: 0 auto;
        	margin-top: 30px;
        }
        #yulan>div{
        	width: 80px;
        	height: 80px;
        	border-radius: 50%;
        	overflow: hidden;
        	border: 4px solid #F1F2F7;
        	margin-bottom: 10px;
        }
        #yulan b{
        	font-weight: normal;
        	margin-left: 20px;
        }
       	.museumSel{
		border: 1px solid rgb(241, 242, 247);
		border-radius: 4px;
		background-color: rgb(252, 252, 252);
		width: 129px;
		height: 24px;
		box-sizing:border-box;
		}
		</style>
		
		<title>用户账户管理</title>
	</head>

	<body>

		<%@ include file="../weihuNav.jsp" %>
		
		<%@ include file="../../content/aside.jsp" %>
		<section class="Hui-article-box">
			
			<!--<nav class="breadcrumb"><i class="Hui-iconfont">
	</i>
				<a href="/" class="maincolor">内容管理</a> <span class="c-999 en">&gt;</span><span class="c-666">展览列表</span>
				<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
			</nav>-->
			<!-- 数据内容 -->
			<div class="Hui-article">
				<article>
					<div style="padding-top: 10px;" class="info">
						<form action="<%=request.getContextPath()%>/getUser/user/userAdmin.do" method="post" id="userForm">
							<div class="hide">   
					        	每页显示条数:&nbsp; 
					            <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${example.size }" name="size">
					        </div> 
							<div class="guanjianci">
								登录账户：&nbsp;
								<input type="text" name="phone" value="${example.phone}" style="width:190px;height:26px;padding-left: 10px;" class="input-text">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								用户昵称：<input type="text" name="nickName" value="${example.nickName}" style="width:160px;height:26px;padding-left: 10px;" class="input-text">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								注册时间：&nbsp;
								<input type="text" name="creatStaTime" value="${example.creatStaTime}" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:112px;height:26px;color: #999999;"> 至
								<input type="text" name="creatOverTime" value="${example.creatOverTime}" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax" class="input-text Wdate" style="width:112px;height:26px;color: #999999;">
							</div>
							<div class="">
								最后登录时间：
								<input type="text" name="lastLongStaTime" value="${example.lastLongStaTime}" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:112px;height:26px;color: #999999;"> 至
								<input type="text" name="lastLongOverTime" value="${example.lastLongOverTime}" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax" class="input-text Wdate" style="width:112px;height:26px;color: #999999;">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账号类型：
								<select name="nameType" class="museumSel pl-10" size="1" id="nameType">
									<option value="">全部</option>
									<option value="1" <c:if test="${1 ==example.nameType}">selected</c:if>>手机</option>
									<option value="2" <c:if test="${2 ==example.nameType}">selected</c:if>>微信</option>
								</select>
							</div>
							<div class="star" style="display:block;width:100%;">
								<button class="btn b1" type="submit"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
								<button class="btn b2" type="button" onclick="formReset();"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>
								<span style="float:right;color:#000;padding-right:20px;">共${totle}条数据</span>
							</div>
							<div style="clear:both"></div>
						</form>
					</div>
					<div class="" style="min-width: 1020px;padding-left: 30px;">
						<table class="table table-hover table-sort">
							<thead>
								<tr class="text-c">
									<th width="20">序号</th>
									<th width="80">登录账号</th>
									<th width="75">用户昵称</th>
									<th width="50">账户类型</th>
									<th width="120">注册时间</th>
									<th width="120">最后登录时间</th>
									<th width="150">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="recordNumber" value="${(example.currentPage - 1) * example.size }" /> 
								<c:forEach items="${userList}" var="spre" varStatus="status">
									<tr class="text-c">
										<td>${status.count + recordNumber}</td>
										<td>${spre.phone}</td>
										<td>${spre.nickName}</td>
										<td>
										<c:if test="${fn:length(spre.phone) >11}">微信</c:if>
										<c:if test="${fn:length(spre.phone) ==11}">手机</c:if>
										</td>
										<td style="font-size:14px;">
										<fmt:formatDate value="${spre.createtime}" pattern="yyyy-MM-dd"/>
										</td>
										
										<!-- <td class="td-status">${spre.lastLoginTime}</td> -->
										
										<td>
											<c:if test="${spre.lastLoginTime>0}" >
						                        <jsp:useBean id="dateValue" class="java.util.Date"/>
					
												<jsp:setProperty name="dateValue" property="time" value="${spre.lastLoginTime*1000}"/>
												
						                        <fmt:formatDate value="${dateValue}" pattern="yyyy/MM/dd HH:mm"/>
											</c:if>
				                        </td>
										<!-- 预览的地址栏需要修改 -->
										<td>
											<c:if test="${spre.status==0}">
												<a style="border: 1px solid #2A9BCF; color: #2A9BCF;padding: 5px 10px;border-radius: 5px;text-decoration: none;" style="text-decoration:none" onClick="release('1','${spre.id}')" title="启用">
													启用
												</a>&nbsp;
											</c:if>
											<c:if test="${spre.status==1}">
												<a style="border: 1px solid #2A9BCF; color: #2A9BCF;padding: 5px 10px;border-radius: 5px;text-decoration: none;" style="text-decoration:none" onClick="release('0','${spre.id}')" title="停用">
													停用
												</a>&nbsp;
											</c:if>
										
											<a title="预览" onclick="edit(this)" userName="${spre.nickName}" userImg="${spre.avatarurl}" userPhone="${spre.phone}" onclick="edit(this)" href="javascript:" class="ml-5" style="text-decoration:none">
												<img src="<%=request.getContextPath() %>/back/images/chakan.png" alt="" />
											</a>&nbsp;
											<a title="删除" href="Javascript:"  onclick="delSpre('${spre.id}')" class="ml-5" style="text-decoration:none">
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
					<img id="userImg" width="80" height="80" src="" alt="" />
				</div>
				<span>
					<p>
						昵称：<span id="userName2"></span>
					</p>
					<p>
						账号类型：<span id="lx"></span> <b>登录账号：<span id='userPhone'></span></b>
					</p>
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
				$(".headerNav a.userguanli").addClass("active");
				$(".headerNav a.userguanli").find("img").attr("src",'<%=request.getContextPath() %>/back/images/userGuanliicon.png');
				 $("#pageSize").change(function() {
				    	var size = $(this).val();
				    	if (size == "") {
				    		return false;
				    	} else {
				    		$("#pageSizeHide").val(size); 
					    	$("#userForm").submit();
				    	}
			    })
			})
			//用户预览
			function edit(obj){
				console.log(obj);
				var userImg = $(obj).attr("userImg");
				var userPhone= $(obj).attr("userPhone");
				var userName = $(obj).attr("userName");
				var lx = userPhone.length == 11?"手机":"微信";
				$("#userImg").attr("src",userImg);
				$("#userName2").text(userName);
				$("#lx").text(lx);
				$("#userPhone").text(userPhone);
		        layer.open({
		            type: 1,
		            title: '用户详情',
		            shadeClose: true,
		            shade: 0.5,
		            maxmin: true, //开启最大化最小化按钮
		            area: ['530px', '350px'],
		            content:$("#yulan"),
		        });
    		}
			//删除的代码
			function delSpre(id) {
				layer.confirm('确定删除此信息？', {
					btn: ['确定', '再想想'] //按钮
				}, function() {
					$.ajax({
						url: "<%=request.getContextPath()%>/getUser/user/delectUser.do",
						type: "post",
						data: "id=" + id,
						async: false,
						dataType: "text",
						success: function(data) {
							$("#userForm").submit();
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
			function formReset() {  
			    $(':input,#myform')  
			     .not(':button, :submit, :reset, :hidden')  
			     .val('')  
			     .removeAttr('checked')  
			     .removeAttr('selected');     
			}
			//发布的功能
			function release(publish, id) {
				if(publish == 0) {
					var a = "停用";
				} else if(publish == 1) {
					var a = "启用";
				}
				layer.confirm('确定' + a + '此信息？', {
					btn: ['确定', '再想想'] //按钮
				}, function() {
					$.ajax({
						url: "<%=request.getContextPath()%>/getUser/user/updateUserStatus.do",
						type: "post",
						data: {
							id: id,
							status:publish
						},
						async: false,
						dataType: "text",
						success: function(data) {
							if(data == "success") {
								$("#userForm").submit();
								layer.msg(a + '成功', {
									icon: 1
								});
							}
						},
						error: function() {
							alert("启用失败，请联系xxx");
						}
					})
				}, function() {
					layer.msg('已取消启用', {});
				});
			}
		</script>
		<!-- 分页功能 -->
		<script type="text/javascript">
			var nums = ${
				example.size
			}; //每页出现的数量
			var pages = ${
				example.totalPage
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
			var abc="<span>每页显示<input style='width:50px;height: 28px;' type='number'  min='5' max='100' step='5' class='input-text' id='pageSize'   value='"+${example.size }+"' name='size'>条</span>";
			$(".laypage_total").before(abc); 
		</script>
	</body>

</html>