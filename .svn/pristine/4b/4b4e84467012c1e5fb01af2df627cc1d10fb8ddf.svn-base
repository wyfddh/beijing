<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico">
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="back/lib/html5.js"></script>
<script type="text/javascript" src="back/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
<link href="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>一普数据列表</title>
<style>
    .navbar-wrapper{
    	display: none;
    }
    .Hui-article-box{
    	top: 0 !important;
    }
    .Hui-article{
    	top: 0 !important;
    }
    .zj_yplist2_content{
    	padding: 0 !important;
    	background-color: #f1f2f7;
    }
    .zj_yplist2_chose{
    	background-color: white;
    	border-top-left-radius: 5px;
    	border-bottom-left-radius: 5px;
    	padding: 30px;
    	padding-left:0 !important;
    }
    .zj_yplist2_chose input{
    	border: 1px solid #f1f2f7;
    	border-radius: 5px;
    	outline: none;
    	padding-left: 20px;
    	width: 60%;
    }
    .zj_yplist2_radio{
    	width: auto !important;
    	margin-left: 10px !important;
    }
    .zj_yplist2_addColl{
    	margin-bottom: 18px;
    }
    .zj_yplist2_chose select{
    	border: none !important;
    	outline: none !important;
    }
    .zj_yplist2_chose span{
    	border: 1px solid #f1f2f7;
    	border-radius: 5px;
    }
    #reset{
    	color: #2a9bcf;
    	background-color: white;
    	border: 1px solid #2a9bcf;
    }
    #reset>img{
    	display: block;
    	float: left;
    	margin-right: 5px;
    	margin-top: 3px;
    }
    .zj_yplist2_gongkai{
    	background-color: white !important;
    	border: 1px solid #2a9bcf !important;
    	color: #2a9bcf !important;
    }
    .zj_yplist2_shuaxing{
    	background-color: white !important;
    	display: block;
    	float: right;
    	margin: 3px 0 0 15px;
    }
    .zj_yplist2_table{
    	background-color: white;
    	border-top: 3px solid #f1f2f7;
    	padding-top: 6px;
    }
    .zj_yplist2_table td,th,table{
    	border: none !important;
    }
    .zj_yplist2_table thead>tr:nth-child(1){
    	/*background-color: #f1f2f7 !important;*/
    	background-color: teal !important;
    	border-radius: 5px;
    }
    .zj_yplist2_table th{
    	padding-top: 24px !important;
    	padding-bottom: 24px !important;
    }
    #laypage_0{
    	text-align: left;
    	margin: 0;
    	padding: 40px 0 0 20px;
    	border-top: 3px solid #f1f2f7;
    	background-color: white;
    }

</style>
</head>
<body>
	<!--/_menu 作为公共模版分离出去-->
	<%@ include file="../../content/aside.jsp" %>
	<section class="Hui-article-box">
		<form action="<%=request.getContextPath() %>/back/fCFossil/info.do" method="get">
			<div class="Hui-article">
				<article class="cl pd-20 zj_yplist2_content">
					<%@ include file="../main.jsp"%>

					<div class="zj_yplist2_chose">
						<div class="col-xs-12"  style="margin-bottom: 13px;">
							<div class="col-xs-12">
								藏品名称：
								<input type="text" name="key" id="key" value="${key}" placeholder="藏品名称" style="width:250px" class="input-text">
							</div>
							
						</div>
						<div class="col-xs-12" style="margin-bottom: 13px;">
							
							<div class="col-xs-6">
								所属年代：
								宙
								<span class="select-box inline">
									<select name="yearTypeEon" class="yearType">
									    <option value="">请选择</option>
									   <c:forEach items="${ytEonList}" var="eon" varStatus="row">
											<option value="${eon.id}" <c:if test="${eon.id eq fCFossil.yearTypeEon}">selected</c:if> >${eon.name}</option>
										</c:forEach>
									</select>
								</span>
								代
								<span class="select-box inline">
									<select name="yearTypeEra" class="yearType">
									    <option value="">请选择</option>
									   <c:forEach items="${ytEraList}" var="era" varStatus="row">
											<option value="${era.id}" <c:if test="${era.id eq fCFossil.yearTypeEra}">selected</c:if> >${era.name}</option>
										</c:forEach>
									</select>
								</span>
								纪
								<span class="select-box inline">
									<select name="yearTypeEpoch" class="yearTypeEpoch">
									    <option value="">请选择</option>
									   <c:forEach items="${ytEpochList}" var="epoch" varStatus="row">
											<option value="${epoch.id}" <c:if test="${epoch.id eq fCFossil.yearTypeEpoch}">selected</c:if> >${epoch.name}</option>
										</c:forEach>
									</select>
								</span>
							</div>
						
							<div class="col-xs-6">
								文物类别：
								<span class="select-box inline">
								<select name="collectionsCategory" class="select">
									<option value="">全部</option>
									<c:forEach items="${ccList}" var="cc" varStatus="row">
										<option value="${cc.id}" <c:if test="${cc.id eq fCFossil.collectionsCategory}">selected</c:if> >${cc.name}</option>
									</c:forEach>
								</select>
								</span>
							</div>
						</div>
						<div class="col-xs-12" style="margin-bottom: 13px;">
						
							<div class="col-xs-6">
								文物级别：
								<span class="select-box inline">
									<select name="collectionLevel" class="select">
										<option value="">全部</option>
										<option value="1" <c:if test="${'1' eq fCFossil.collectionLevel}">selected</c:if> >珍贵</option>
										<option value="2" <c:if test="${'2' eq fCFossil.collectionLevel}">selected</c:if> >一般</option>
										<option value="3" <c:if test="${'3' eq fCFossil.collectionLevel}">selected</c:if> >其他</option>
									</select>
								</span>
							</div>
							<div class="col-xs-6">
								收藏单位：
								<span class="select-box inline">
									<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
			                    		<select name="collectionUnit" id="museum" class="select select-box inline" style="width:132px;">

				                            <option value="${sessionScope.user.orgId}" selected>${sessionScope.user.orgName}</option>
				                        </select>
			                    	</c:if>
			                    	<c:if test="${fn:contains(sessionScope.user.level,3)==false}">
				                        <select name="erea" class="org select select-box inline" style="width:132px">
				                            <option value="">所在区域</option>
				                            <c:forEach items="${cityList}" var="city" varStatus="row">
					                            <option value="${city.id}" <c:if test="${city.id eq erea}">selected</c:if> >${city.shortname}</option>
				                            </c:forEach>
				                        </select>
				                        <select name="collectionUnit" id="museum" class="select select-box inline" style="width:132px;">
				                            <option value="">收藏单位</option>
				                            <c:forEach items="${musList}" var="mus" varStatus="row">
					                            <option value="${mus.id}" <c:if test="${mus.id eq fCFossil.collectionUnit}">selected</c:if> >${mus.shortname}</option>
				                            </c:forEach>
				                        </select>
			                    	</c:if>
			                    </span>
							</div>
						</div>
						<div class="col-xs-12" style="margin-bottom: 13px;">
							<div class="col-xs-6">
								馆内精品：
								<span>
								<label><input class="zj_yplist2_radio" name="isHighQuality" type="radio" value="2" <c:if test="${'2' eq fCFossil.isHighQuality}">checked</c:if> />是 </label>
								<label><input class="zj_yplist2_radio" name="isHighQuality" type="radio" value="1" <c:if test="${'1' eq fCFossil.isHighQuality}">checked</c:if> />否 </label>
								</span>
							</div>
							<div class="col-xs-6">
								公开状态：
								<span>
								<label><input class="zj_yplist2_radio" name="isOpen" type="radio" value="2" <c:if test="${'2' eq fCFossil.isOpen}">checked</c:if> />已公开 </label>
								<label><input class="zj_yplist2_radio" name="isOpen" type="radio" value="1" <c:if test="${'1' eq fCFossil.isOpen}">checked</c:if> />未公开</label>
								</span>
							</div>
						</div>
						<div class="col-xs-12">
							<div class="col-xs-5">
							    <button name="search" class="btn btn-primary radius" type="submit" style="background-color:rgb(42, 155, 207)">
							    	<img src="<%=request.getContextPath() %>/back/images/fangdajing.png"/>
							    	搜索
							    </button>
							    <button name="reset" id="reset" class="btn btn-success radius" type="reset">
							    	<img src="<%=request.getContextPath() %>/back/images/chongzhi.png"/>
							    	重置
							    </button>
							</div>
						</div>
						<div style="clear: both;"></div>
					</div>

					<%-- <span class="select-box inline">
					<select name="yearType" class="select">
						<option value="">全部</option>
						<c:forEach items="${ytList}" var="yt" varStatus="row">
							<option value="${yt.pathName}" <c:if test="${yt.pathName eq fCFossil.yearType}">selected</c:if> >${yt.pathName}</option>
						</c:forEach>
					</select>
					</span> --%>
					<%-- <select name="erea" class="org select select-box inline">
						<option value="">所在区域</option>
						<c:forEach items="${cityList}" var="city" varStatus="row">
							<option value="${city.id}" <c:if test="${city.id eq erea}">selected</c:if> >${city.shortname}</option>
						</c:forEach>
					</select>
					<select name="collectionUnit" id="museum" class="select select-box inline">
						<option value="">收藏单位</option>
						<c:forEach items="${musList}" var="mus" varStatus="row">
							<option value="${mus.id}" <c:if test="${mus.id eq fCFossil.collectionUnit}">selected</c:if> >${mus.name}</option>
						</c:forEach>
					</select> --%>



					<div class="zj_yplist2_table col-xs-12">
						<table class="table table-border table-bordered table-bg table-hover table-sort">
							<thead>
								<tr class="text-c">
									<th width="25"><input type="checkbox" name="" value=""></th>
									<th width="120">缩略图</th>
									<th width="100">收藏单位</th>
									<th width="100">普查编号</th>
									<th width="100">藏品编号</th>
									<th width="170">名称</th>
									<th width="140">年代</th>
									<th width="135">类别</th>
									<th width="95">采集地</th>
									<th width="95">级别</th>
									<th width="50">精品</th>
									<th width="50">公开</th>
									<th width="100">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${fccList}" var="fcc" varStatus="row">
									<tr class="text-c">
										<td><input type="checkbox" value="" name=""></td>
										<td>
											<a href="${fcc.pictureIds}" data-lightbox="gallery">
												<img alt="图片丢失" src="${fcc.pictureIds }" width="118">
											</a>
										</td>
										<td>
											<c:forEach items="${museums}" var="museum">
												<c:if test="${fcc.collectionUnit == museum.id }">
													${museum.name }
												</c:if>
											</c:forEach>
										</td>
										<td>${fcc.gsNo }</td>
										<td>${fcc.gsCollectionsNo }</td>
										<td>
											<a style="text-decoration:none" class="ml-5" href="<%=request.getContextPath() %>/back/fCFossil/detail.do?id=${fcc.id }" title="查看">
												${fcc.name }
											</a>
										</td>

										<td>${fcc.yearType }</td>
										<td>
											<c:forEach items="${ccList}" var="cc">
												<c:if test="${fcc.collectionsCategory == cc.id }">
													${cc.name }
												</c:if>
											</c:forEach>
										</td>
										<td>${fcc.collectionPlace }</td>
										<td>
											<c:if test="${fcc.collectionLevel eq '1' }">珍贵</c:if>
											<c:if test="${fcc.collectionLevel eq '2' }">一般</c:if>
											<c:if test="${fcc.collectionLevel eq '3' }">其他</c:if>
										</td>
										<td>
											<c:if test="${fcc.isHighQuality eq '1' }">否</c:if>
											<c:if test="${fcc.isHighQuality eq '2' }">是</c:if>
										</td>
										<td>
											<c:if test="${fcc.isOpen eq '1' }">否</c:if>
											<c:if test="${fcc.isOpen eq '2' }">是</c:if>
										</td>
										<!-- <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','url','id')" title="查看">查看</u></td> -->
										<td class="f-14 td-manage">
											<a style="text-decoration:none" class="ml-5" href="<%=request.getContextPath() %>/back/fCFossil/detail.do?id=${fcc.id }" title="查看">
												<img src="<%=request.getContextPath() %>/back/images/chakan.png"/>
											</a>
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
		</form>
	</section>


	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
	<!-- 前台分页功能 -->
	<!-- <script type="text/javascript">
		$('.table-sort').DataTable({
			searching: false,
		});
	</script> -->

	<!--/请在上方写此页面业务相关的脚本-->
	<!-- 城市博物馆级联 -->
	<script type="text/javascript">
	var appName = '<%=request.getContextPath() %>';
	$(function(){
		$(".fabu-aside>ul>li").eq(1).addClass("cangpin");
		$(".zj_public_yipuhuashi>a").css({
			color:"white",
			background:"#2a9bcf"
		}).children().attr("src",'<%=request.getContextPath() %>/back/images/zj_yipu_chose.png');



	    $('.org').change(function(){
	        var pid=$(this).val();
	        var obj=$(this).next('select');
	        var first=obj.children().first().clone();
	        $.ajax({
	            url: appName + "/back/fCCollection/sltMuseum.do",
	            data:{parentId:pid},
	            type:"POST",
	            success:function(msg){
	                obj.empty().append(first);
	                for(var i in msg)
	                    obj.append("<option value="+msg[i]['id']+">"+msg[i]['shortname']+"</option>");
	            }
	        });
	    });
	});
	</script>
	<script type="text/javascript">
		$(function(){
		    $('.yearType').change(function(){
		        var pid=$(this).val();
		        var obj=$(this).next('select');
		        var first=obj.children().first().clone();
		        $.ajax({
		            url: appName + "/back/fCFossil/sltYearType.do",
		            data:{pid:pid},
		            type:"POST",
		            success:function(msg){
		                obj.empty().append(first);
		                for(var i in msg)
		                    obj.append("<option value="+msg[i]['id']+">"+msg[i]['name']+"</option>");
		            }
		        });
		    });
		});
	</script>
	<!-- 分页功能 -->
	<script type="text/javascript">
		var nums = ${page.size}; //每页出现的数量
		var pages = ${page.totalPage}; //得到总页数
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
		         location.href = '?page='+e.curr+'&'+$('form').serialize();
		       }
		    }
		})
	</script>
</body>
</html>
