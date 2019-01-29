<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String wwxxwip = "http://test.tj720.com/mip/pc/index.html#/displayDetails/inner/";
%>
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
		</style>
		<script>
			$(function(){
				$(".fabu-aside>ul>li").eq(0).addClass("fabu");
				$(".headerNav").find(".spre").addClass("active").find("img").attr("src",'<%=request.getContextPath() %>/back/images/zllogoActive.png');
			})
		</script>
		<title>展览信息列表</title>
	</head>

	<body>

		<!--_header 作为公共模版分离出去-->
		<%--  <%@ include file="../header.jsp"%> --%>

		<!--_menu 左边slide导航开始-->
		<%@ include file="aside.jsp" %>
		<!--/_menu 作为公共模版分离出去-->
		<%@ include file="../fabuNav.jsp" %>
		<section class="Hui-article-box">
			
			<!--<nav class="breadcrumb"><i class="Hui-iconfont">
	</i>
				<a href="/" class="maincolor">内容管理</a> <span class="c-999 en">&gt;</span><span class="c-666">展览列表</span>
				<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
			</nav>-->
			<!-- 数据内容 -->
			<div class="Hui-article">
				<article>
					<!--添加展讯-->
					<div class="addZhanxun">
						<c:if test="${fn:contains(sessionScope.user.level,3)==true && fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
							<span class="l">
								<a class="btn btn-primary radius" data-title="添加展览" href="<%=request.getContextPath()%>/spreadtrum/toSpreAdd.do"><i class="Hui-iconfont">&#xe600;</i> 添加展览</a>
							</span>
						</c:if>
					</div>
					<div class="info">
						<form action="<%=request.getContextPath()%>/spreadtrum/getSpreadtrum.do" method="post" id="form"> 
							<div class="guanjianci">
								关键词：<input type="text" name="keys" value="${keys}" placeholder="展览名/内容" style="width:190px;height:26px" class="input-text">
							</div>
							<div class="">
								发布时间：
								<input type="text" name="staTime" value="${spreadtrum.staTime}" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:112px;height:26px"> -
								<input type="text" name="overTime" value="${spreadtrum.overTime}" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:112px;height:26px">
								&nbsp;&nbsp;&nbsp;当前状态：
								<span class="select-box" style="width:102px;height:26px;padding:2px 5px;border-radius: 5px;">
									<select class="select" name="publish" value="${spreadtrum.publish}"  size="1">
										<option value="-127" selected="selected">全部</option>
										<option value="1" <c:if test="${'1' eq spreadtrum.publish}">selected</c:if>>已发布</option>
										<option value="0" <c:if test="${'0' eq spreadtrum.publish}">selected</c:if>>待发布</option>
									</select>
								</span>
								发布人：<input type="text" style="width:102px;height:26px" class="input-text" name="userName" value="${spreadtrum.userName}">
							</div>
							<div class="star">
								<button class="btn b1" type="submit"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
								<button class="btn b2" type="button" onclick="formReset();"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>
								<!--<input class="btn btn-success" type="reset">-->
							</div>
								<div class="hide">   
						        	每页显示条数:&nbsp; 
						            <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${spreList.page.size }" name="size">
						        </div> 
							<%--<div class="col-sm-12 col-md-6 mt-20 col-lg-5">	--%>
							<%-- <c:if test="${level==2 || level==1}"> --%>
							<%-- <c:if test="${level==3}">
					 	<span class="inline pl-10">
					           <select name="erea" class="org select select-box inline" style="width:162px">
						          <option value="">所在区域</option>
						          <c:forEach items="${cityList}" var="city" varStatus="row">
						       	     <option value="${city.id}" <c:if test="${city.id eq erea}">selected</c:if> >${city.shortname}</option>
						          </c:forEach>
					           </select>
					           <select name="collectionUnit" id="museum" class="select select-box inline" style="width:162px;">
						          <option value="">收藏单位</option>
						          <c:forEach items="${musList}" var="mus" varStatus="row">
							         <option value="${mus.shortname}" <c:if test="${mus.shortname eq spreadtrum.orgId}">selected</c:if> >${mus.shortname}</option>
						          </c:forEach>
					           </select>
						 </span>
					</c:if>	 --%>
							<%--</div>	--%>
							<div style="clear:both"></div>
						</form>
					</div>
					
					<div class="" style="min-width: 1020px;padding-left: 30px">
						<span class="r" style="margin-right:35px;">共<strong style="color: #57AAD6;">${spreList.page.allRow}</strong>条数据</span>
					</div>
				
					<div class="" style="min-width: 1020px;padding-left: 30px;">
						<table class="table table-hover table-sort">
							<thead>
								<tr class="text-c">
									<th width="20">序号</th>
									<th width="50">状态</th>
									
									<c:if test="${fn:contains(sessionScope.user.level,3)==true && fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
										<th width="60">二维码</th>
									</c:if>
									<th width="80">标题</th>
									<th width="80">展期</th>
									
									<th width="100">发布单位</th>
									<th width="75">发布人</th>
									<th width="50">发布时间</th>
									<th width="150">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="recordNumber" value="${(spreList.page.currentPage - 1) * spreList.page.size }" /> 
								<c:forEach items="${spreList.data}" var="spre" varStatus="status">
									<tr class="text-c"> 
										<td>${status.count + recordNumber}</td>
										<!--<td class="state">${spre.publish==1?'已发布':spre.publish==0?'待发布':''}</td>-->
										<c:if test="${spre.publish==1}">
											<td class="state">
												<span style="background: #2A9BCF;color: #fff;padding: 5px;border-radius: 5px;">已发布</span>
											</td>
										</c:if>
										<c:if test="${spre.publish==0}">
											<td class="state">待发布</td>
										</c:if>
										<c:if test="${fn:contains(sessionScope.user.level,3)==true && fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
											<td>
											<c:if test="${fn:contains(sessionScope.user.level,3)==true && fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
												<c:if test="${spre.publish==1}">
													<a style="text-decoration:none" class="ml-5" href="javascript:void(0);" onclick="makeCodeInfo('${spre.id }',this)" title="二维码">
														<!--<div class="btn btn-primary-outline radius size-S">二维码</div>-->
														<img src="<%=request.getContextPath() %>/back/images/erweima.png" alt="" />
													</a>
												</c:if>
											</c:if>
										</td>
										</c:if>
										
										
										<td style="font-size:14px;">${spre.headline}</td>
										<td>${spre.staTime}---${spre.overTime}</td>
										
										<td>${spre.musExhibition}</td>
										<td>${spre.nickName}</td>
										<td class="td-status"><span>${spre.issemTime}</span></td>
										<!-- 预览的地址栏需要修改 -->
										<td>
											<%-- <input type="button" onclick="release('${spre.publish}','${spre.id}')" value="${spre.publish==1?'取消发布':spre.publish==0?'发布':''}" class="fabu"> --%>
											<c:if test="${fn:contains(sessionScope.user.level,3)==true && fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
												
												<c:if test="${spre.publish==0}">
													<a title="编辑" href="<%=request.getContextPath()%>/spreadtrum/getSprInfo.do?id=${spre.id}" class="ml-5" style="text-decoration:none">
														<img src="<%=request.getContextPath() %>/back/images/bianjiicon.png" alt="" />
													</a>&nbsp;
													<a style="text-decoration:none" onClick="release('${spre.publish}','${spre.id}')" title="发布">
														<img src="<%=request.getContextPath() %>/back/images/fabu.png" alt="" />
													</a>&nbsp;
												</c:if>
												<a style="text-decoration:none" href="<%=wwxxwip %>${spre.id}" title="预览" target="_blank">
													<img src="<%=request.getContextPath() %>/back/images/chakan.png" alt="" />
												</a>&nbsp;
												<c:if test="${spre.publish==1}">
													<a style="text-decoration:none" onClick="release('${spre.publish}','${spre.id}')" title="取消发布">
														<img src="<%=request.getContextPath() %>/back/images/quxiaofabuicon.png" alt="" />
													</a>&nbsp;
													<!--<a style="text-decoration:none" class="ml-5" href="javascript:void(0);" onclick="makeCodeInfo('${spre.id }',this)" title="二维码">
														<div class="btn btn-primary-outline radius size-S">二维码</div>
													</a>-->
												</c:if>
												<c:if test="${spre.publish==0}">
													<a title="删除" onclick="delSpre('${spre.id}')" class="ml-5" style="text-decoration:none">
														<img src="<%=request.getContextPath() %>/back/images/delicon.png" alt="" />
													</a>&nbsp;
												</c:if>
											</c:if>
<%-- 											<a style="text-decoration:none" href="<%=request.getContextPath()%>/${pcRootPath }#/displayDetails/inner/${spre.id}" title="预览" target="_blank">
												<img src="<%=request.getContextPath() %>/back/images/chakan.png" alt="" />
											</a>&nbsp;
--%>										<c:if test="${fn:contains(sessionScope.user.level,1)==true && fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
												<c:if test="${spre.publish==1}">
													<c:if test="${spre.sequence ne 100 }">
														<a style="text-decoration: none" href="javascript:;" onclick="toTop('${spre.id}')" title="置顶">
															<img src="<%=request.getContextPath() %>/back/images/dingzhi.png" alt="" />
														</a>&nbsp;
													</c:if>
													<c:if test="${spre.sequence eq 100 }">
														<a style="text-decoration: none" href="javascript:;" onclick="toDownSpr('${spre.id}')" title="取消置顶">
															<img src="<%=request.getContextPath() %>/back/images/cancel_stick.png" alt="" />
														</a>&nbsp;
													</c:if>
												</c:if>
											</c:if>
											<%-- <c:if test="${fn:contains(sessionScope.user.authStr,'SystemAdmin')==true}">
												<button class="btn btn-primary radius" type="button"  onclick="window.location.href='/admin/museumInfoManage/spreInfo.do?title=${spre.headline}&id=${spre.id}'">模板</button>
											</c:if> --%>
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
		<!-- 数据内容结束 -->
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>

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
		
		
			function makeCodeInfo(elText, thisTd) {
				 var cpimg = $(thisTd).parent().parent().find("#cpimg img").attr("src");
				var name = $(thisTd).parents("td").siblings(".name").html();
				 
				if(elText == null) {
					alert("沒有id，没法生成二维码。");
					elText.focus();
					return;
				}
				layer.open({
					type: 1,
					title: name,
					area:['470px','390px'],
					content: "<div id='qrcode' style='padding:20px 100px;text-align:center;'></div>" +
						"<a id='download' download='qrcode.jpg'></a>" +
						"<button class='btn button btn-primary size-S' id='save' style='float: right;margin-right: 15px;margin-bottom: 10px;'>下载</button>" //这里content是一个普通的String
				});
				var qrcode = new QRCode(document.getElementById("qrcode"), {
					text: name,
					
					width: 270,
					height: 270
				});
				var elText1 = 'http://www.jlsdmu.com/mip/front/index.html#/browseDetail/' + elText;
				/*  layer.msg(elText1, {icon: 1});*/
				 var elText1 = 'http://www.jlsdmu.com/mip/jilin2/index.html#/ExhibitionDetial?id='+elText+'&isSm=0';
				  $.ajax({
			             type: "GET",
			             url: "<%=request.getContextPath() %>/createTwoDimensionCode.do",
			             data: {content:elText1, picCollectionPicUrl:cpimg},
			             dataType: "json",
			             success: function(data){
			            	 url = data.data;
						    	$("#qrcode").html("<img style='width:270px;height:270px;' src="+url+" />");
						    	$("#download").attr("href",url);
			             }
			         });
				//qrcode.makeCode(elText1);

				//下载
				$("#save").click(function(){
	                $("#download").attr('href', url).get(0).click();
		            return false;
		        })
				/* $("#save").click(function() {
					var canvas = $('#qrcode').find("canvas").get(0);
					try { //解决IE转base64时缓存不足，canvas转blob下载
						var blob = canvas.msToBlob();
						navigator.msSaveBlob(blob, 'qrcode.jpg');
					} catch(e) { //如果为其他浏览器，使用base64转码下载
						var url = canvas.toDataURL('image/jpeg');
						$("#download").attr('href', url).get(0).click();
					}
					return false;
				}) */

			}
		</script>

		<script type="text/javascript">
			//删除的代码
			function delSpre(id) {
				layer.confirm('确定删除此信息？', {
					btn: ['确定', '再想想'] //按钮
				}, function() {
					$.ajax({
						url: "<%=request.getContextPath()%>/spreadtrum/deleteSpreadtrum.do",
						type: "post",
						data: "id=" + id,
						async: false,
						dataType: "text",
						success: function(data) {
							window.location.href = '<%=request.getContextPath()%>/spreadtrum/getSpreadtrum.do';
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
					var a = "发布";
				} else if(publish == 1) {
					var a = "取消发布";
				}
				layer.confirm('确定' + a + '此信息？', {
					btn: ['确定', '再想想'] //按钮
				}, function() {
					$.ajax({
						url: "<%=request.getContextPath()%>/spreadtrum/updatePublish.do",
						type: "post",
						data: {
							id: id
						},
						async: false,
						dataType: "text",
						success: function(data) {
							if(data == "success") {
								window.location.href = '<%=request.getContextPath()%>/spreadtrum/getSpreadtrum.do';
								layer.msg(a + '成功', {
									icon: 1
								});
							}
						},
						error: function() {
							alert("发布失败，请联系xxx");
						}
					})
				}, function() {
					layer.msg('已取消发布', {});
				});
			}
		</script>
		<!-- 分页功能 -->
		<script type="text/javascript">
			var nums = ${spreList.page.size}; //每页出现的数量
			var pages = ${
				spreList.page.totalPage
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
				skin: '#2A9BCF', //皮肤
				groups: 3, //连续显示分页数
				jump: function(e, first) { //触发分页后的回调
					if(!first) { //一定要加此判断，否则初始时会无限刷新
						location.href = '?page=' + e.curr + '&' + $('form').serialize();
					}
				}
			})
			var abc="<span>每页显示<input style='width:50px;height: 28px;' type='number'  min='5' max='100' step='5' class='input-text' id='pageSize'   value='"+${spreList.page.size }+"' name='size'>条</span>";
			$(".laypage_total").before(abc); 
		</script>
		<script type="text/javascript">
			function toTop(id) {
				$.ajax({
					url: "<%=request.getContextPath()%>/spreadtrum/toTop.do",
					type: "post",
					data: {
						ids: id
					},
					dataType: "json",
					success: function(data) {
						if(data) {
							layer.msg('置顶成功', {
								icon: 1
							});
							setTimeout(function() {
								window.location.href = window.location.href;
							}, 1000)

						} else {
							layer.msg('置顶失败', {
								icon: 2
							});
						}
					},
				})
			};
		</script>
		<script>
			function toDownSpr(id) {
				$.ajax({
					url: "<%=request.getContextPath()%>/spreadtrum/toDown.do",
					type: "post",
					data: {
						ids: id
					},
					dataType: "json",
					success: function(data) {
						if(data) {
							layer.msg('取消置顶成功', {
								icon: 1
							});
							setTimeout(function() {
								window.location.href = window.location.href;
							}, 1000)

						} else {
							layer.msg('取消置顶失败', {
								icon: 2
							});
						}
					},
				})
			};
		</script>
	</body>

</html>