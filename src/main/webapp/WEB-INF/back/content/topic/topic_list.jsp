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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui/css/H-ui.min.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/H-ui.admin.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/style.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/css/cover.css" />
		<!--/meta 作为公共模版分离出去-->
		<style>
		
			.headerNav{
				height: 98px;
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
		
		<title>藏品专题库</title>
	</head>

	<body>

		<!--_menu 左边slide导航开始-->
		<%@ include file="../aside.jsp" %>
		<!--/_menu 作为公共模版分离出去-->
		<%@ include file="fabuNav_topic.jsp" %>
		<section class="Hui-article-box">
			
			<!-- <nav class="breadcrumb"><i class="Hui-iconfont">
	</i>
				<a href="/" class="maincolor">内容管理</a> <span class="c-999 en">&gt;</span><span class="c-666">展览列表</span>
				<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
			</nav> -->
			<!-- 数据内容 -->
			<div class="Hui-article">
				<article>
					<!--添加展讯-->
					<div class="addZhanxun">
						<c:if test="${fn:contains(sessionScope.user.level,3)==true && fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
							<span class="l">
								<a class="btn btn-primary radius" data-title="添加展览" href="javascript:addPic();"><i class="Hui-iconfont">&#xe600;</i> 创建专题</a>
							</span>
						</c:if>
					</div>
					<div class="info">
						<form action="<%=request.getContextPath()%>/topic/goList.do" method="post" id="form"> 
							<div class="guanjianci">
								关键词：<input type="text" name="key" value="${key}" placeholder="专题名称" style="width:190px;height:26px" class="input-text">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前状态：
								<span class="select-box" style="width:102px;height:26px;padding:2px 5px;border-radius: 5px;">
									<select class="select" name="status" value="${status}"  size="1">
										<option value="">全部</option>
										<option value="2" <c:if test="${'2' eq status}">selected</c:if>>已发布</option>
										<option value="1" <c:if test="${'1' eq status}">selected</c:if>>待发布</option>
									</select>
								</span>
							</div>
							<div class="star">
								<button class="btn b1" type="submit"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
								<button class="btn b2" type="button" onclick="formReset();"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>
							</div>
								<div class="hide">   
						        	每页显示条数:&nbsp; 
						            <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${page.size }" name="size">
						        </div> 
							<div style="clear:both"></div>
						</form>
					</div>
					
					<div class="" style="min-width: 1020px;padding-left: 30px">
						<span class="r" style="margin-right:35px;">共<strong style="color: #57AAD6;">${page.allRow}</strong>条数据</span>
					</div>
				
					<div class="" style="min-width: 1020px;padding-left: 30px;">
						<table class="table table-hover table-sort">
							<thead>
								<tr class="text-c">
									<th width="20">序号</th>
									<th width="50">状态</th>
									
									<th width="60">二维码</th>
									<th width="80">专题名称</th>
									<th width="80">藏品数量</th>
									
									<th width="100">发布单位</th>
									<th width="50">发布时间</th>
									<th width="150">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="recordNumber" value="${(page.currentPage - 1) * page.size }" /> 
								<c:forEach items="${list}" var="spre" varStatus="status">
									<tr class="text-c"> 
										<td>${status.count + recordNumber}</td>
										<c:if test="${spre.status==2}">
											<td class="state">
												<span style="background: #2A9BCF;color: #fff;padding: 5px;border-radius: 5px;">已发布</span>
											</td>
										</c:if>
										<c:if test="${spre.status==1}">
											<td class="state">待发布</td>
										</c:if>
										<td>
											<c:if test="${spre.status==2}">
												<a style="text-decoration:none" class="ml-5" href="javascript:void(0);" onclick="makeCodeInfo('${spre.id }',this,'${spre.name }')" title="二维码">
													<img src="<%=request.getContextPath() %>/back/images/erweima.png" alt="" />
												</a>
											</c:if>
										</td>
										
										
										<td style="font-size:14px;">${spre.name}</td>
										<td>${spre.collectionCount}</td>
										
										<td>${spre.publishOrgName}</td>
										<td class="td-status">
											<c:if test="${spre.status==2}">
												<span><fmt:formatDate value="${spre.publishTime}" pattern="yyyy-MM-dd HH:mm" /></span>
											</c:if>
										</td>
										<!-- 预览的地址栏需要修改 -->
										<td>
												<a style="text-decoration:none" href="<%=request.getContextPath()%>/CollectionTopic/goCreateTopicPage.do?topicId=${spre.id}" title="查看">
													<img src="<%=request.getContextPath() %>/back/images/yulanicon.png" alt="" />
												</a>&nbsp;
												<%-- <a title="编辑" onclick="goCollectionSelect('${spre.id}');" class="ml-5" style="text-decoration:none">
													<img src="<%=request.getContextPath() %>/back/images/bianjiicon.png" alt="" />
												</a>&nbsp; --%>
											<c:if test="${fn:contains(sessionScope.user.level,3)==true && fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
												<c:if test="${spre.status==1}">
													<a style="text-decoration:none" onClick="release('${spre.status}','${spre.id}')" title="发布">
														<img src="<%=request.getContextPath() %>/back/images/fabu.png" alt="" />
													</a>&nbsp;
													<a title="删除" onclick="delSpre('${spre.id}')" class="ml-5" style="text-decoration:none">
														<img src="<%=request.getContextPath() %>/back/images/delicon.png" alt="" />
													</a>&nbsp;
												</c:if>
												<c:if test="${spre.status==2}">
													<a style="text-decoration:none" onClick="release('${spre.status}','${spre.id}')" title="取消发布">
														<img src="<%=request.getContextPath() %>/back/images/quxiaofabuicon.png" alt="" />
													</a>&nbsp;
												</c:if>
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
		
		
		
		<!-- 数据内容结束 -->
		<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jQueryPrint/jQuery.print.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jQueryPrint/clipboard.min.js"></script>
		
		<script>
			$(function(){
				$(".fabu-aside>ul>li").eq(5).addClass("zhuanti");
				$(".headerNav").find(".zhuantiku").addClass("active").find("img").attr("src",'<%=request.getContextPath() %>/back/images/zllogoActive.png');
			})
			
		</script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#pageSize").change(function() {
					debugger;
			    	var size = $(this).val();
			    	console.log(size);
			    	if (size == "") {
			    		return false;
			    	} else {
			    		$("#pageSizeHide").val(size); 
				    	$("#form").submit();
			    	}
			    })
			});
			
			//打开新增
			function addPic() {
				layer.open({
					type: 2,
					title: '创建专题',
					shadeClose: true,
					shade: 0.5,
					area: ['650px', '300px'],
					content: '<%=request.getContextPath()%>/topic/goAdd.do',
					end:function(){
						location.reload();
					}
				});
			}
			//编辑查看
			function goCollectionSelect(id) {
				layer.open({
					type: 2,
					title: '添加藏品',
					shadeClose: true,
					shade: 0.5,
					area: ['95%', '95%'],
					content: '<%=request.getContextPath()%>/topic/goSelectCollection.do?topicId='+id,
					end:function(){
						location.reload();
					}
				});
			}
			
		</script>

		<script type="text/javascript">
		
		function makeCodeInfo(elText, thisTd,imgName) {
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
					"<button class='btn button btn-primary size-S' id='downQrcode' style='float: right;margin-right: 15px;margin-bottom: 10px;'>下载</button>"+ 
					"<button class='btn button btn-primary size-S' id='printQrcode' style='float: right;margin-right: 15px;margin-bottom: 10px;'>打印</button>"+
					"<button class='btn button btn-primary size-S' id='copyUrl' style='float: right;margin-right: 15px;margin-bottom: 10px;'>复制链接</button>"
			});
			var qrcode = new QRCode(document.getElementById("qrcode"), {
				text: name,
				width: 270,
				height: 270
			});
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
			$("#downQrcode").click(function(){
				var form = $("<form>");   //定义一个form表单
		        form.attr('style','display:none');   //在form表单中添加查询参数
		        form.attr('target','');
		        form.attr('method','post');
		        form.attr('action',"<%=request.getContextPath() %>/download/downLoadImage.do");
		       
		        var input1 = $('<input>'); 
		        input1.attr('type','hidden'); 
		        input1.attr('name','urlImage'); 
		        input1.attr('value',url); 
		        
		        var input2 = $('<input>'); 
		        input2.attr('type','hidden'); 
		        input2.attr('name','name'); 
		        input2.attr('value',imgName); 
		       
		        $('body').append(form);  //将表单放置在web中
		        form.append(input1);   //将查询参数控件提交到表单上
		        form.append(input2);
		        form.submit();   //表单提交
	        });
			$("#printQrcode").click(function() {
				$("#qrcode").print({
					globalStyles: false,
				    mediaPrint: false,
				    stylesheet: null,
				    noPrintSelector: ".no-print",
				    iframe: false,
				    append: null,
				    prepend: null,
				    deferred: $.Deferred()
				})
			})
			$("#copyUrl").click(function() {
				var clipboard = new Clipboard('.btn', {
				        text: function() {
				            return elText1;
				        }
				    });
			    clipboard.on('success',
			    function(e) {
			        top.layer.msg("复制成功");
			    });
			})

		}
		
			//删除的代码
			function delSpre(id) {
				layer.confirm('确定删除此信息？', {
					btn: ['确定', '再想想'] //按钮
				}, function() {
					$.ajax({
						url: "<%=request.getContextPath()%>/topic/deleteTopic.do",
						type: "post",
						data: "id=" + id,
						async: false,
						dataType: "text",
						success: function(data) {
							if(data.success == 1){
								location.reload();
								layer.msg('成功删除！', {
									icon: 1
								});
							}else{
								location.reload();
								layer.msg('删除失败！', {
									icon: 1
								});
							}
						},
						error: function() {
							layer.msg('删除失败！', {
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
				if(publish == 1) {
					var a = "发布";
				} else if(publish == 2) {
					var a = "取消发布";
				}
				layer.confirm('确定' + a + '此信息？', {
					btn: ['确定', '再想想'] //按钮
				}, function() {
					$.ajax({
						url: "<%=request.getContextPath()%>/topic/publishTopic.do",
						type: "post",
						data: {
							id: id
						},
						async: false,
						dataType: "text",
						success: function(data) {
							if(data == "success") {
								location.reload();
								layer.msg(a + '成功', {
									icon: 1
								});
							}else{
								alert("发布失败，请联系管理员");
							}
						},
						error: function() {
							alert("发布失败，请联系管理员");
						}
					})
				}, function() {
					layer.msg('已取消发布', {});
				});
			}
		</script>
		<!-- 分页功能 -->
		<script type="text/javascript">
			var nums = ${page.size}; //每页出现的数量
			var pages = ${
				page.totalPage
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
			var abc="<span>每页显示<input style='width:50px;height: 28px;' type='number'  min='5' max='100' step='5' class='input-text' id='pageSize'   value='"+${page.size }+"' name='size'>条</span>";
			$(".laypage_total").before(abc); 
		</script>
	</body>

</html>