<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--  <%@ page import="com.tj720.mip.utils.HasAuth" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
	<link href="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<style>
   .lig{
    	line-height:30px;
    }
    .navbar-wrapper{
    	display: none;
    }
    .Hui-article-box{
    	top: 0 !important;
    }
    .Hui-article{
    	top: 0 !important;
    }
    .zj_wwlist_content{
    	padding: 0 !important;
    	background-color: #f1f2f7;
    }
    .zj_wwlist_chose{
    	background-color: white;
    	border-top-left-radius: 5px;
    	border-bottom-left-radius: 5px;
    	padding: 30px;
    	padding-left:0 !important;
    }
    .zj_wwlist_chose input{
    	border: 1px solid #f1f2f7;
    	border-radius: 5px;
    	outline: none;
    	padding-left: 20px;
    	width: 60%;
    }
    .zj_wwlist_radio{
    	width: auto !important;
    	margin-left: 10px !important;
    }
    .zj_wwlist_addColl{
    	margin-bottom: 18px;
    }
    .zj_wwlist_chose select{
    	border: none;
    	outline: none !important;
    }
    .zj_wwlist_chose span{
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
    .zj_wwlist_gongkai{
    	background-color: white !important;
    	border: 1px solid #2a9bcf !important;
    	color: #2a9bcf !important;
    }
    .zj_wwlist_shuaxing{
    	background-color: white !important;
    	display: block;
    	float: right;
    	margin: 3px 0 0 15px;
    }
    .zj_wwlist_table{
    	background-color: white;
    	border-top: 3px solid #f1f2f7;
    	padding-top: 6px;
    }
    .zj_wwlist_table td,th,table{
    	border: none !important;
    }
    .zj_wwlist_table thead>tr:nth-child(1){
    	background-color: #f1f2f7 !important;
    	border-radius: 5px;
    }
    .zj_wwlist_table th{
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
    .list_category {
    	height:45px;
    	overflow: hidden;
    }
    .more{
    	text-align:center;
    }
    .select_tab {
    	color:"white";
		background:"#2a9bcf";
    }
</style>
<title>公开藏品列表</title>
</head>
<body>
	<!--/_menu 作为公共模版分离出去-->
	<%@ include file="../../content/aside.jsp" %>
	<section class="Hui-article-box">
		<form action="/admin/collectionInfo/info.do" method="get" id="form">
			<div class="hide">   
	        	每页显示条数:&nbsp; 
	            <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${page.size }" name="size">
	        </div> 
			<div class="Hui-article">
				<article class="cl pd-20 zj_wwlist_content">

					<%@ include file="../main.jsp"%>

					<div class="zj_wwlist_chose">
						<ul class="secondtitle">
							<li>
								<!--<a href="/mip/back/fCCollection/info.do" title="一普数据列表" style="font-size:16px!important;">一普数据列表</a>-->
								<ul class="thirdTitle">
									<li class="zj_public_wenwu">
										<c:if test="${openCollectionInfo.collectionType eq 1}">
											<a href="/admin/collectionInfo/info.do?collectionType=0" rel="/collectionInfo/info.do" title="文物藏品类别">
												<img src="<%=request.getContextPath() %>/back/images/zj_wenwu.png"/>
												文物表
											</a>
										</c:if>
										<c:if test="${openCollectionInfo.collectionType eq 0}">
											<a style="color:white;background:#2a9bcf;" href="/admin/collectionInfo/info.do?collectionType=0" rel="/collectionInfo/info.do" title="文物藏品类别">
												<img src="<%=request.getContextPath() %>/back/images/zj_wenwu_chose.png"/>
												文物表
											</a>
										</c:if>
									</li>
									<li class="zj_public_haushi">
										<c:if test="${openCollectionInfo.collectionType eq 0}">
											<a href="/admin/collectionInfo/info.do?collectionType=1" rel="/collectionInfo/info.do" title="化石藏品类别">
												<img src="<%=request.getContextPath() %>/back/images/zj_huashi.png"/>
												标本化石
											</a>
										</c:if>
										<c:if test="${openCollectionInfo.collectionType eq 1}">
											<a style="color:white;background:#2a9bcf;" href="/admin/collectionInfo/info.do?collectionType=1" rel="/collectionInfo/info.do" title="化石藏品类别">
												<img src="<%=request.getContextPath() %>/back/images/zj_huashi_chose.png"/>
												标本化石
											</a>
										</c:if>
									</li>
								</ul>
							</li>
						</ul>
						<%-- <div class="col-md-12">
							<div class="col-md-12">
								<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
									<c:if test="${fn:contains(sessionScope.user.authStr,'collectionAdmin')==true}">
										<a href="<%=request.getContextPath()%>/back/oCCollection/toAdd.do" onclick="add()" class="btn btn-primary radius zj_wwlist_addColl" style="background:rgb(42, 155, 207)!important;"><i class="Hui-iconfont mr-5">&#xe600;</i>添加藏品</a>
									</c:if>
								</c:if>
							</div>
						</div> --%>

						<div class="col-xs-12"  style="margin-bottom: 13px;">
							<ul class="list_category" id="categoryList">
								<div class="col-xs-12" style="margin-bottom: 13px;">
									<div class="col-xs-12 col-sm-6 col-md-6">
										<!-- <label  id="keyTypeId" class="">藏品名称:</label> -->
										<select id="keyTypeOpenId" class="select" name="keyType" style="width:85px;float: left;padding: 4px 0;" disabled="disabled">
											<option value="0">藏品名称</option>
											<%-- <option value="1" <c:if test="${1 eq keyType}">selected</c:if>>藏品原名</option> --%>
		                            		<%-- <option value="2" <c:if test="${2 eq keyType}">selected</c:if>>普查名称</option> --%>
											<option value="3" <c:if test="${3 eq keyType}">selected</c:if>>一普编号</option>
											<%-- <option value="4" <c:if test="${4 eq keyType}">selected</c:if>>藏品编号</option> --%>
										</select>
				                    	<input type="text" name="key" id="key" value="${key}" placeholder="请输入藏品名称或普查名称" class="input-text" maxlength="100">
				                    	<input type="text" name="collectionType" hidden="hidden" value="${openCollectionInfo.collectionType}">
									</div>
								</div>
								
								<div class="col-xs-12" style="margin-bottom: 13px;">
								<c:if test="${openCollectionInfo.collectionType eq 0}">
									<div class="col-xs-12 col-sm-6 col-md-3">
										<label class="">常用年代：</label>
										<span class="select-box inline">
										<select name="" class="select" id="commonYearId" style="width:150px;">
											<option value="">全部</option>
											<option value="45" <c:if test="${45 eq openCollectionInfo.yearType}">selected</c:if>>新石器时代</option>
											<option value="48" <c:if test="${48 eq openCollectionInfo.yearType}">selected</c:if>>商</option>
											<option value="49" <c:if test="${49 eq openCollectionInfo.yearType}">selected</c:if>>周</option>
											<option value="50" <c:if test="${50 eq openCollectionInfo.yearType}">selected</c:if>>西周</option>
											<option value="51" <c:if test="${51 eq openCollectionInfo.yearType}">selected</c:if>>东周</option>
											<option value="55" <c:if test="${55 eq openCollectionInfo.yearType}">selected</c:if>>汉</option>
											<option value="56" <c:if test="${56 eq openCollectionInfo.yearType}">selected</c:if>>西汉</option>
											<option value="57" <c:if test="${57 eq openCollectionInfo.yearType}">selected</c:if>>东汉</option>
											<option value="79" <c:if test="${79 eq openCollectionInfo.yearType}">selected</c:if>>唐</option>
											<option value="87" <c:if test="${87 eq openCollectionInfo.yearType}">selected</c:if>>宋</option>
											<option value="93" <c:if test="${93 eq openCollectionInfo.yearType}">selected</c:if>>元</option>
											<option value="94" <c:if test="${94 eq openCollectionInfo.yearType}">selected</c:if>>明</option>
											<option value="95" <c:if test="${95 eq openCollectionInfo.yearType}">selected</c:if>>清</option>
											<option value="96" <c:if test="${96 eq openCollectionInfo.yearType}">selected</c:if>>民国</option>
											<option value="97" <c:if test="${97 eq openCollectionInfo.yearType}">selected</c:if>>中华人民共和国</option>
										</select>
										</span>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-3">
										<label class="">其他年代：</label>
										<span class="select-box inline">
										<select name="" class="select" id="orhterYearId" style="width:150px;">
											<option value="">全部</option>
											<c:forEach items="${ytList}" var="yt" varStatus="row">
												<c:if test="${yt.id != 45 && yt.id != 48 &&yt.id != 49 &&yt.id != 50 &&yt.id != 51 &&yt.id != 55 &&yt.id != 56 &&yt.id != 57 &&yt.id != 79 &&yt.id != 87 &&yt.id != 93 &&yt.id != 94 &&yt.id != 95 &&yt.id != 96 &&yt.id != 97}">
													<option value="${yt.id}" <c:if test="${yt.id eq openCollectionInfo.yearType}">selected</c:if> >${yt.name}</option>
												</c:if>
											</c:forEach>
										</select>
										</span>
									</div>
									</c:if>
									<div class="col-xs-12 col-sm-6 col-md-6">
										<label class="">收藏单位：</label>
					                    <span class="inline select-box">
					                    	<%-- <c:if test="${fn:contains(sessionScope.user.level,3)==true}">
					                    		<select name="collectionUnit" id="museum" class="select" style="width:173px;">
						                            <option value="${sessionScope.user.orgId}" selected>${sessionScope.user.orgName}</option>
						                        </select>
					                    	</c:if>
					                    	<c:if test="${fn:contains(sessionScope.user.level,3)==false}"> --%>
						                        <select name="area" class="org select select-box inline" style="width:173px">
						                            <option value="">所在区域</option>
						                            <c:forEach items="${cityList}" var="city" varStatus="row">
							                            <option value="${city.id}" <c:if test="${city.id eq area}">selected</c:if> >${city.shortname}</option>
						                            </c:forEach>
						                        </select>
						                        <select name="collectionUnit" id="museum" class="select select-box inline" style="width:173px;">
						                            <option value="">收藏单位</option>
						                            <c:forEach items="${musList}" var="mus" varStatus="row">
							                            <option value="${mus.id}" <c:if test="${mus.id eq openCollectionInfo.collectionUnit}">selected</c:if> >${mus.shortname}</option>
						                            </c:forEach>
						                        </select>
					                    	<%-- </c:if> --%>
					                    </span>
									</div>
								</div>
								<div class="col-xs-12" style="margin-bottom: 13px;">
									<div class="col-xs-12 col-sm-6 col-md-6">
				                        <label class="">文物类别：</label>
										<span class="select-box inline">
										<select name="collectionsCategory" class="select"  style="width:460px;">
											<option value="">全部</option>
											<c:forEach items="${ccList}" var="cc" varStatus="row">
												<option value="${cc.id}" <c:if test="${cc.id eq openCollectionInfo.collectionsCategory}">selected</c:if> >${cc.name}</option>
											</c:forEach>
										</select>
										</span>
									</div>
								</div>
							</ul>
							<div class="more">
								<div style="width:100%;">
								<div style="width:30%;height:30px;border-top:1px solid;border-top-color:#c9ccdc;margin:0 0;float: left;display:inline;"></div>
								<div style="cursor:pointer;width:20%;height:30px;border-bottom:1px solid;border-left:1px solid;border-right:1px solid;border-color:#c9ccdc;margin:0 0;float: left;display:inline;" id="gFinalId">高级检索</div>
								<div style="width:30%;height:30px;border-top:1px solid;border-top-color:#c9ccdc;margin:0 0;float: left;display:inline;"></div>
								</div>
							</div>
						</div>
						<div class="col-xs-12"  style="margin-top: 13px;padding-right:0;margin-right:0;">
							<div class="col-xs-12 col-sm-6 col-md-6">
							    <button name="search" class="btn btn-primary radius" type="submit" style="background-color:rgb(42, 155, 207)">
							    	<img src="<%=request.getContextPath() %>/back/images/fangdajing.png"/>
							    	搜索
							    </button>
							    <button name="reset" id="reset" class="btn btn-success radius" type="button" onclick="formReset();">
							    	<img src="<%=request.getContextPath() %>/back/images/chongzhi.png"/>
							    	重置
							    </button>
								<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
									<c:if test="${fn:contains(sessionScope.user.authStr,'collectionAdmin')==true}">
										<a href="javascript:;" onclick="non_publishAll()" class="btn btn btn-danger radius zj_wwlist_gongkai">取消公开</a>
										<a href="javascript:;" onclick="publishAll()" class="btn btn-success radius zj_wwlist_gongkai">批量公开</a>
									</c:if>
								</c:if>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6 text-r" style="color: black;padding-right:0;margin-right:0;">
								共：<span style="color: #2a9bcf;border: none !important;">${page.allRow }</span> 条数据
								<a class="zj_wwlist_shuaxing" href="javascript:location.replace(location.href);" title="刷新" >
									<img src="<%=request.getContextPath() %>/back/images/shuaxing.png"/>
								</a>
							</div>
						</div>

		                <div style="clear: both;"></div>

					</div>

					<div class="col-xs-12 zj_wwlist_table">
						<table class="table table-border table-bordered table-bg table-hover table-sort">
							<thead>
								<tr class="text-c">
									<th width="25">序号</th>
									<th width="120">缩略图</th>
									<th width="250">普查名称</th>
									<!-- <th width="250">藏品原名</th> -->
									<th width="50">所属年代</th>
									<th width="150">文物类别</th>
									<th width="150">文物级别</th>
 									<th width="100">收藏单位</th>
									<!-- <th width="130">操作</th> -->
 								</tr>
							</thead>
							<tbody>
								<c:set var="recordNumber" value="${(page.currentPage - 1) * page.size }" /> 
								<c:forEach items="${listCollectionInfo}" var="fcc" varStatus="row">
									<tr class="text-c">
										<td>${row.count + recordNumber}</td>
										<!-- 缩略图 -->
										<td id="cpimg" height="120px" width="120px">
											<%-- <a href="${fcc.fpic}" data-lightbox="gallery">
												<img alt="没有图片" src="${fcc.picUrl}" style="max-height:118px;max-width:118px;">
											</a> --%>
											<img alt="没有图片" src="${fcc.pictureIds}" style="max-height:118px;max-width:118px;">
										</td>
										<!-- 普查名称-->
										<td class="name">
											${fcc.name }
										</td>
										<!-- 藏品原名 -->
										<%-- <td class="name">
											${fcc.name }
										</td> --%>
										<!--年代-->
										<td>
											<c:forEach items="${ytList}" var="yt">
												<c:if test="${fcc.yearType == yt.id }">
													${yt.name }
												</c:if>
											</c:forEach>
										</td>
										<!--类别-->
										<td>
											<c:forEach items="${ccList}" var="cc">
												<c:if test="${fcc.collectionsCategory == cc.id }">
													${cc.name }
												</c:if>
											</c:forEach>
										</td>
										<!--级别-->
										<td>
											<c:if test="${fcc.collectionLevel eq '1' }">一级</c:if>
											<c:if test="${fcc.collectionLevel eq '2' }">二级</c:if>
											<c:if test="${fcc.collectionLevel eq '3' }">三级</c:if>
											<c:if test="${fcc.collectionLevel eq '4' }">一般</c:if>
											<c:if test="${fcc.collectionLevel eq '5' }">未定级</c:if>
										</td>
										<td>
											<c:forEach items="${museums}" var="museum">
												<c:if test="${fcc.collectionUnit == museum.id }">
													${museum.name }
												</c:if>
											</c:forEach>
										</td>
										<!-- <td>
											音频
										</td> -->
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<br>
					<div id="page" align="center" style="height: 500px;"></div>
				</article>
			</div>
		</form>
	</section>


<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
	<%-- <script type="text/javascript"
		src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script> --%>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript"
    	 src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>

	<!--/请在上方写此页面业务相关的脚本-->
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
		
		$(".fabu-aside>ul>li").eq(1).addClass("cangpin");


		<%-- $(".zj_public_wenwu>a").css({
			color:"white",
			background:"#2a9bcf"
		}).children().attr("src",'<%=request.getContextPath() %>/back/images/zj_wenwu_chose.png'); --%>
		$(".zj_public_gkcangpin>a").css({
			color:"white",
			background:"#2a9bcf"
		}).children().attr("src",'<%=request.getContextPath() %>/back/images/zj_wenwu_chose.png');

		function makeCodeInfo(elText,thisTd) {
	        console.log(elText)
	        var cpimg = $(thisTd).parent().parent().find("#cpimg img").attr("src");
			var name = $(thisTd).parents("td").siblings(".name").html();
			 if (elText == null) {
				alert("沒有普查编号，没法生成二维码。");
				elText.focus();
				return;
			}
			 layer.open({
				  type: 1,
	              title:name,
	              area:['470px','390px'],
				  content: "<div id='qrcode' style='padding:20px 100px;text-align:center;'></div>"+
	                       "<a id='download' download='qrcode.jpg'></a>"+
	                       "<button class='btn button btn-primary size-S' id='save' style='float: right;margin-right: 15px;margin-bottom: 10px;background-color:#2a9bcf'>下载</button>" //这里content是一个普通的String
				});
			  var qrcode = new QRCode(document.getElementById("qrcode"), {
	                text:name,
					width : 270,
					height : 270
				});
				 //var elText1 = 'http://www.jlsdmu.com/mip/jilin2/index.html#/scrollMode?id='+elText+'&isSm=0';
			 	 var elText1 = 'http://bwsc.scmuseum.cn/mip/sc/m/index.html#/scrollMode?id='+elText+'&isSm=0';
				  $.ajax({
			             type: "GET",
			             url: "<%=request.getContextPath() %>/createTwoDimensionCode.do",
			             data: {content:elText1, picCollectionPicUrl:cpimg},
			             dataType: "json",
			             success: function(data){
			            	console.log(data);
					    	url = data.data;
					    	$("#qrcode").html("<img style='width:270px;height:270px;' src="+url+" />");
					    	$("#download").attr("href",url);
			             }
			         });

	        //下载
	        $("#save").click(function(){
                $("#download").attr('href', url).get(0).click();
	            return false;
	        })

		}
</script>
	<!-- 级联 -->
	<script type="text/javascript">
	$(function(){
	    $('.org').change(function(){
	        var pid=$(this).val();
	        var obj=$(this).next('select');
	        var first=obj.children().first().clone();
	        $.ajax({
	            url:"/admin/back/oCCollection/sltMuseum.do",
	            data:{parentId:pid},
	            type:"POST",
	            datatype:"json",
	            success:function(msg){
	            	 obj.empty().append(first);
	                for(var i in msg){
	                    obj.append("<option value="+msg[i]['id']+">"+msg[i]['shortname']+"</option>");
	                }
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
		   	skin: '#2a9bcf', //皮肤
		   	groups: 3, //连续显示分页数
		    jump: function(e, first){ //触发分页后的回调
		       if(!first){ //一定要加此判断，否则初始时会无限刷新
		         location.href = '?page='+e.curr+'&'+$('form').serialize() ;
		       }
		    }
		})
		var abc="<span>每页显示<input style='width:50px;height: 28px;' type='number'  min='5' max='100' step='5' class='input-text' id='pageSize'   value='"+${page.size }+"' name='size'>条</span>";
		$(".laypage_total").before(abc); 
	</script>

	<%--批量公开--%>
	<script type="text/javascript">
	function formReset() {  
	    $(':input,#myform')  
	     .not(':button, :submit, :reset, :hidden')  
	     .val('')  
	     .removeAttr('checked')  
	     .removeAttr('selected'); 
	    $("#keyTypeOpenId option[value='0']").attr("selected","selected");  
	}
		function publishAll() {
			var data = $("form").find(".ids").serialize();
			$.ajax({
				url : "<%=request.getContextPath()%>/back/oCCollection/publishAll.do",
				type : "post",
				data :  data,
				dataType : "json",
				success : function(data){
					if(data == "1"){
						layer.msg('发布成功', {icon: 1});
						var data1 = $("form").find(".ids").serialize();
						$.ajax({
							url:"<%=request.getContextPath()%>/image/printWatermarkForEachCollection.do",
							type : "post",
							data :  data1,
							dataType : "json",
							success:function(response){
								console.log(response);
							}
						});
						setTimeout(function(){
							window.location.href = window.location.href;
						},1000)
					}else if(data == "-1"){
						layer.msg('请先上传藏品图片', {icon: 1});
					}
					else{
						layer.msg('发布失败', {icon: 2});
					}
				},
			})
		};

		function non_publishAll() {
			var data = $("form").find(".ids").serialize();
			$.ajax({
				url : "<%=request.getContextPath()%>/back/oCCollection/nonPublishAll.do",
				type : "post",
				data :  data,
				dataType : "json",
				success : function(data){
					if(data == "1"){
						layer.msg('取消发布成功', {icon: 1});
						setTimeout(function(){
							window.location.href = window.location.href;
						},1000)
					}else if(data == "-1"){

					}else{
						layer.msg('取消发布失败', {icon: 2});
					}
				},
			})
		};

		function publish(id) {
			$.ajax({
				url : "<%=request.getContextPath()%>/back/oCCollection/publish.do",
				type : "get",
				data :  {ids:id},
				dataType : "json",
				success : function(data){
					console.log(data);
					if(data == "1"){
						layer.msg('发布成功', {icon: 1});
						$.ajax({
							url:"<%=request.getContextPath()%>/image/printWatermarkForEachCollection.do",
							type : "post",
							data :  {ids:id},
							dataType : "json",
							success:function(response){
								console.log("************************");
								console.log(response);
							}
						});
						setTimeout(function(){
							window.location.href = window.location.href;
						},1000)

					}else if(data == "-1"){
						layer.msg('请先上传藏品图片', {icon: 1});
					}else{
						layer.msg('发布失败', {icon: 2});
					}
				},
			})
		};

		function non_publish(id) {
			$.ajax({
				url : "<%=request.getContextPath()%>/back/oCCollection/nonPublish.do",
				type : "post",
				data :  {ids:id},
				dataType : "json",
				success : function(data){
					if(data == "1"){
						layer.msg('取消发布成功', {icon: 1});
						setTimeout(function(){
							window.location.href = window.location.href;
						},1000)

					}else if(data == "-1"){

					}else{
						layer.msg('取消发布失败', {icon: 2});
					}
				},
			})
		};

		function deleteColl(id) {
			layer.confirm('确定删除此信息？', {
				  btn: ['确定','再想想'] //按钮
				}, function(){
					$.ajax({
						url : "<%=request.getContextPath()%>/back/oCCollection/del.do",
						type : "post",
						data :  {ids:id},
						dataType : "json",
						async: false,
						success : function(data){
							if(data){
								layer.msg('成功删除', {icon: 1});
								setTimeout(function(){
									window.location.href = window.location.href;
								},1000)

							}else{
								layer.msg('删除失败', {icon: 2});
							}
						},
					})
				}, function(){
				  layer.msg('已取消删除', {
				  });
				});
		};

		function toTop(id) {
			$.ajax({
				url : "<%=request.getContextPath()%>/back/oCCollection/top.do",
				type : "post",
				data :  {ids:id},
				dataType : "json",
				success : function(data){
					if(data){
						layer.msg('置顶成功', {icon: 1});
						setTimeout(function(){
							window.location.href = window.location.href;
						},1000)

					}else{
						layer.msg('置顶失败', {icon: 2});
					}
				},
			})
		};

		function toDown(id) {
			$.ajax({
				url : "<%=request.getContextPath()%>/back/oCCollection/down.do",
				type : "post",
				data :  {ids:id},
				dataType : "json",
				success : function(data){
					if(data){
						layer.msg('取消置顶成功', {icon: 1});
						setTimeout(function(){
							window.location.href = window.location.href;
						},1000)

					}else{
						layer.msg('取消置顶失败', {icon: 2});
					}
				},
			})
		};
		
		var a = 1
		$("#gFinalId").click(function(){
			a++
			if (a%2==0) {
				$("#gFinalId").html("收起高级检索");
				$("#categoryList").css("height","auto")
				$("#categoryList").css("overflow","auto")
				/* $("#keyTypeOpenId").show();
				$("#keyTypeId").hide(); */
				$("#keyTypeOpenId").removeAttr("disabled");
			}else{
				$("#gFinalId").html("高级检索");
				$("#categoryList").css("height","45px")
				$("#categoryList").css("overflow","hidden")
				/* $("#keyTypeOpenId").hide();
				$("#keyTypeId").show(); */
				$("#keyTypeOpenId").attr("disabled","disabled");
				$("#keyTypeOpenId").val("0");
			}
		})
		$("#commonYearId").change(function(){
		    var opt=$("#commonYearId").val();
		    if(opt != ""){
		    	$("#orhterYearId").val("");
		    	$("#commonYearId").attr("name","yearType")
		    	$("#orhterYearId").attr("name","yearType2")
		    }
		});
		$("#orhterYearId").change(function(){
		    var opt=$("#orhterYearId").val();
		    if(opt != ""){
		    	$("#commonYearId").val("");
		    	$("#commonYearId").attr("name","yearType2")
		    	$("#orhterYearId").attr("name","yearType")
		    }
		});
		$("#keyTypeOpenId").change(function(){
			$("#key").val("");
		});
	</script>
</body>
</html>
