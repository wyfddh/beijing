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
<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico">
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/back/css/trendsManage.css" />
<link href="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >

<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript"	src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript"	src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript"	src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>
<title>藏品变动列表</title>
<style type="text/css">
	.collection{
		width: 90px;
	}
</style>
</head>
<body>
	<!--/_menu 作为公共模版分离出去-->
	<%@ include file="../../content/aside.jsp" %>
	<section class="Hui-article-box">
		<form action="/admin/trendsManage/info.do" method="get" id="infoFrom">
			<div class="hide">   
	        	每页显示条数:&nbsp; 
	            <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${page.size }" name="size">
	        </div> 
			<input type="hidden" id="collectionType" name="collectionType" value="${collectionType}">
			<div class="Hui-article">
				<article class="cl pd-20 zj_wwlist_content">
					<%@ include file="../trendsheader.jsp"%>
					<!-- 搜索条件区域 -->
					<div class="zj_wwlist_chose">
						<div class="pl-30">
							<span class="btn btn-primary collection"> 文物</span>
							<span class="btn btn-default collection"> 标本化石</span>
						</div>
						<div class="mt-20 pb-10">
							<div class="col-xs-12 col-sm-6 col-md-6 pl-30">
								<label class="">藏品名称：</label>
		                    	<input type="text" name="name" id="name" value="${dcVersion.name}" placeholder="藏品名称" class="input-text">
							</div>
						</div>
						<div class="mt-35 pb-10">
							<div class="col-xs-12 col-sm-6 col-md-6 collectionDiv">
								<div class="col-xs-12 col-sm-6 col-md-5">
									<label class="">常用年代：</label>
									<span class="select-box inline">
									<select name="yearType" class="select"  style="width:150px;" id="yearType">
										<option value="">全部</option>
										<option value="">全部</option>
										<option value="45" <c:if test="${45 eq dcVersion.yearType}">selected</c:if>>新石器时代</option>
										<option value="48" <c:if test="${48 eq dcVersion.yearType}">selected</c:if>>商</option>
										<option value="49" <c:if test="${49 eq dcVersion.yearType}">selected</c:if>>周</option>
										<option value="50" <c:if test="${50 eq dcVersion.yearType}">selected</c:if>>西周</option>
										<option value="51" <c:if test="${51 eq dcVersion.yearType}">selected</c:if>>东周</option>
										<option value="55" <c:if test="${55 eq dcVersion.yearType}">selected</c:if>>汉</option>
										<option value="56" <c:if test="${56 eq dcVersion.yearType}">selected</c:if>>西汉</option>
										<option value="57" <c:if test="${57 eq dcVersion.yearType}">selected</c:if>>东汉</option>
										<option value="79" <c:if test="${79 eq dcVersion.yearType}">selected</c:if>>唐</option>
										<option value="87" <c:if test="${87 eq dcVersion.yearType}">selected</c:if>>宋</option>
										<option value="93" <c:if test="${93 eq dcVersion.yearType}">selected</c:if>>元</option>
										<option value="94" <c:if test="${94 eq dcVersion.yearType}">selected</c:if>>明</option>
										<option value="95" <c:if test="${95 eq dcVersion.yearType}">selected</c:if>>清</option>
										<option value="96" <c:if test="${96 eq dcVersion.yearType}">selected</c:if>>民国</option>
										<option value="97" <c:if test="${97 eq dcVersion.yearType}">selected</c:if>>中华人民共和国</option>
									</select>
									</span>
								</div>
								<div class="col-xs-12 col-sm-6 col-md-7">
			                        <label class="">其他年代：</label>
									<span class="select-box inline">
									<select name="otherYearType" class="select" style="width:150px;" id="otherYearType">
										<option value="">全部</option>
										<c:forEach items="${yearTypeList}" var="yt" varStatus="row">
											<c:if test="${yt.id != 45 && yt.id != 48 &&yt.id != 49 &&yt.id != 50 &&yt.id != 51 &&yt.id != 55 &&yt.id != 56 &&yt.id != 57 &&yt.id != 79 &&yt.id != 87 &&yt.id != 93 &&yt.id != 94 &&yt.id != 95 &&yt.id != 96 &&yt.id != 97}">
												<option value="${yt.id}" <c:if test="${yt.id eq otherYearType}">selected</c:if> >${yt.name}</option>
											</c:if>
										</c:forEach>
									</select>
									</span>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6 collectionDiv" style="display: none">
								<div class="col-xs-12 col-sm-6 col-md-4">
									<label class="">宙：</label>
									<span class="select-box inline">
									<select name="yearTypeEon" class="select"  style="width:150px;" id="yearTypeEon" onchange="selectEon();">
										<option value="">全部</option>
										<c:forEach items="${yearTypeEonList}" var="yt" varStatus="row">
											<option value="${yt.id}" <c:if test="${yt.id eq dcVersion.yearTypeEon}">selected</c:if>>${yt.name}</option>
										</c:forEach>
									</select>
									</span>
								</div>
								<div class="col-xs-12 col-sm-6 col-md-4">
									<label class="">代：</label>
									<span class="select-box inline">
									<select name="yearTypeEra" class="select"  style="width:150px;" id="yearTypeEra" onchange="selectEpo();">
										<option value="">全部</option>
										<c:forEach items="${yearTypeEraList}" var="yt" varStatus="row">
											<option value="${yt.id}" <c:if test="${yt.id eq dcVersion.yearTypeEra}">selected</c:if>>${yt.name}</option>
										</c:forEach>
									</select>
									</span>
								</div>
								<div class="col-xs-12 col-sm-6 col-md-4">
									<label class="">纪：</label>
									<span class="select-box inline">
									<select name="yearTypeEpoch" class="select"  style="width:150px;" id="yearTypeEpoch">
										<option value="">全部</option>
										<c:forEach items="${yearTypeEpochList}" var="yt" varStatus="row">
											<option value="${yt.id}" <c:if test="${yt.id eq dcVersion.yearTypeEpoch}">selected</c:if>>${yt.name}</option>
										</c:forEach>
									</select>
									</span>
								</div>
							
							</div>
							<c:if test="${level==1}">
								<div class="col-xs-12 col-sm-6 col-md-6">
			                        <label class="">收藏单位：</label>
									<span class="select-box inline">
									<select name="collectionUnit" class="select" style="width:150px;">
										<option value="">全部</option>
										<c:forEach items="${organizationList}" var="cc" varStatus="row">
											<option value="${cc.id}" <c:if test="${cc.id eq dcVersion.collectionUnit}">selected</c:if>>${cc.name}</option>
										</c:forEach>
									</select>
									</span>
								</div>
							</c:if>
						</div>
						<div class="mt-35 pb-10 ml-30">
							<label class="">文物类别：</label>
							<span class="select-box inline">
							<select name="collectionCategory" class="select" style="width:150px;">
								<option value="">全部</option>
								<c:forEach items="${collectionCategoryList}" var="cc" varStatus="row">
									<option value="${cc.id}" <c:if test="${cc.id eq dcVersion.collectionCategory}">selected</c:if>>${cc.name}</option>
								</c:forEach>
							</select>
							</span>
						</div>
						<div class="mt-45 ml-30 pb-10">
							<div class="col-xs-12 col-sm-6 col-md-6">
							    <button name="search" class="btn btn-primary radius" type="submit" style="background-color:rgb(42, 155, 207)">
							    	<img src="<%=request.getContextPath() %>/back/images/fangdajing.png"/>
							    	搜索
							    </button>
							    <button name="reset" id="reset" class="btn btn-success radius" type="button" onclick="formReset();">
							    	<img src="<%=request.getContextPath() %>/back/images/chongzhi.png"/>
							    	重置
							    </button>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6 text-r" style="color: black;padding-right:0;margin-right:0;">
								共 <span style="color: #2a9bcf;border: none !important;">${page.allRow }</span> 条数据
								<a class="zj_wwlist_shuaxing" href="javascript:location.replace(location.href);" title="刷新" >
									<img src="<%=request.getContextPath() %>/back/images/shuaxing.png"/>
								</a>
							</div>
						</div>
					</div>
					
					<!-- 展示列表区域 -->
					<div class="col-xs-12 zj_wwlist_table">
						<table class="table table-border table-bordered table-bg table-hover table-sort">
							<thead>
								<tr class="text-c">
									<th width="50">序号</th>
									<th width="50">缩略图</th>
									<th width="50">普查名称</th>
									<th width="50">藏品原名</th>
									<th width="50">一普编号</th>
									<th width="50">所属年代</th>
									<th width="50">文物类别</th>
									<th width="50">文物级别</th>
									<c:if test="${level==1}">
										<th width="50">收藏单位</th>
									</c:if>
									<th width="50">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="recordNumber" value="${(page.currentPage - 1) * page.size }" />
								<c:forEach items="${versionSelectList}" var="fcc" varStatus="row">
									<tr class="text-c">
										<td>${row.count + recordNumber}</td>
										<td>
											<a href="${fcc.imageUrl}" data-lightbox="gallery">
												<img alt="没有图片" src="${fcc.imageUrl}" style="max-height:118px;max-width:118px;">
											</a>
										</td>
										<td>${fcc.name}</td>
										<td>${fcc.formerly}</td>
										<td>${fcc.gsNo}</td>
										<td>${fcc.yearType}</td>
										<td>${fcc.collectionCategory}</td>
										<td>${fcc.collectionLevel}</td>
										<c:if test="${level==1}">
											<td>${fcc.collectionUnit}</td>
										</c:if>
										<td><a style="text-decoration:none;color: #438EB9" href="javascript:void(0)" onclick="versionChange('${fcc.id}');">版本变动情况</a></td>
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
	<div id="pop1" class="shade"></div>
	<div id="pop2" style="z-index:101;width: 740px;background-color: #ffffff;position:absolute;min-height:200px;top:35%;left:30%;display: none;">
		<div style="width: 100%;height: 30px;background-color: #0099ff;">
			<label style="font-size: 16px;color:#ffffff;padding-left:15px;">变动版本</label>
			<a href="javascript:void(0)" class="close mr-10" style="float: right;font-size: 20px;opacity: 0.5;">×</a>
		</div>
		<div class="mt-10 ml-20">
			<select onchange="sort()" id="sortSelect">
				<option value="1">顺序</option>
				<option value="2">倒序</option>
			</select>
		</div>
		<div>
			<table class="table table-border table-bordered table-bg table-hover table-sort mt-10">
				<thead>
					<tr class="text-c">
						<th width="50"></th>
						<th width="50">版本编号</th>
						<th width="50">操作人</th>
						<th width="50">操作时间</th>
						<th width="50">类型</th>
						<th width="50">操作</th>
					</tr>
				</thead>
				<tbody id="versionList">
				</tbody>
				<tbody id="versionListOrder">
				</tbody>
			</table>
		</div>
		<div class="mt-20 mb-20">
			<form action="/admin/trendsManage/compareVersionSelect.do" method="get" id="contentCompare" target="_blank">
				<input type="hidden" name="contentId" id="contentId">
				<input type="hidden" name="contentType" id="contentType">
				<div style="background-color: #0099ff;width: 140px;height: 20px;margin-left: 300px;margin:0 auto;text-align:center;padding-top: 10px;padding-bottom: 10px;">
					<a href="javascript:void(0)" onclick="compare();">进行对比</a>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
	$(".fabu-aside>ul>li").eq(2).addClass("dongtai");
	$(function(){
		var num = $("#collectionType").val()-1;
		$(".collection").removeClass("btn-primary").addClass("btn-default");
		$(".collection").eq(num).removeClass("btn-default").addClass("btn-primary");
		$(".collectionDiv").hide().eq(num).show();
		$("#versionList").hide();
		$("#versionListOrder").show();
		$("#pageSize").change(function() {
		    	var size = $(this).val();
		    	if (size == "") {
		    		return false;
		    	} else {
		    		$("#pageSizeHide").val(size); 
			    	$("#infoFrom").submit();
		    	}
	    })
	});
	$("#yearType").on('change',function(){
		 $("#otherYearType")[0].selectedIndex = 0;
		
	});
	$("#otherYearType").on('change',function(){
		 $("#yearType")[0].selectedIndex = 0;
	});
	$(".close").click(function (){
		$("#pop1").hide();
		$("#pop2").hide();
	});
	$(".collection").click(function (){
		$("#collectionType").val($(this).index()+1);
		document.getElementById("infoFrom").submit();
	});
	function formReset() {  
	    $(':input,#myform')  
	     .not(':button, :submit, :reset, :hidden')  
	     .val('')  
	     .removeAttr('checked')  
	     .removeAttr('selected');     
	}
	function versionChange(selectId){
		$("#pop1").show();
		$("#pop2").show();
		var contentType = $("#collectionType").val();
		$.ajax({
            type: "POST",
            url: "<%=request.getContextPath() %>/trendsManage/getVersionSelect.do",
            data: {selectId:selectId},
            dataType: "json",
            success: function(data){
           	console.log(data);
           		if(data.success==1){
           			$("#versionList").html("");
           			for(var i=0;i<data.data.length;i++){
	           			$("#versionList").append(
		          				'<tr class="text-c">'
			   						+'<td><input type="checkbox" name="versionCheck" onclick="onClickHander(this)" value="'+data.data[i].id+'"></td>'
			   						+'<td>'+data.data[i].version+'</td>'
			   						+'<td>'+data.data[i].userName+'</td>'
			   						+'<td>'+data.data[i].creatTime+'</td>'
			   						+'<td>'+data.data[i].versionType+'</td>'
			   						+'<td><a href="<%=request.getContextPath() %>/trendsManage/versionSelect.do?contentId='+data.data[i].id+'&contentType='+contentType+'">查看</a></td>'
		   						+'</tr>'		
	           			);
           			}
           			$("#versionListOrder").html("");
           			for(var i=data.data.length-1;i>-1;i--){
	           			$("#versionListOrder").append(
		          				'<tr class="text-c">'
			   						+'<td><input type="checkbox" name="versionCheck" onclick="onClickHander(this)" value="'+data.data[i].id+'"></td>'
			   						+'<td>'+data.data[i].version+'</td>'
			   						+'<td>'+data.data[i].userName+'</td>'
			   						+'<td>'+data.data[i].creatTime+'</td>'
			   						+'<td>'+data.data[i].versionType+'</td>'
			   						+'<td><a href="<%=request.getContextPath() %>/trendsManage/versionSelect.do?contentId='+data.data[i].id+'&contentType='+contentType+'">查看</a></td>'
		   						+'</tr>'		
	           			);
           			}
           		}
            }
        });
	}
	function onClickHander(obj){
		if($("input[type='checkbox']:checked").length>2){
			obj.checked = false;
			layer.msg('最多只能选中两个选项');
		}
	}
	function compare(){
		 var checkArry = document.getElementsByName("versionCheck");
		 var contentId = "";
		 for (var i = 0; i < checkArry.length; i++) { 
             if(checkArry[i].checked == true){
            	 if(contentId!=""){
            		 contentId+=",";
            		 contentId+=checkArry[i].value;
            	 }else{
            		 contentId+=checkArry[i].value;
            	 }
             }
         }
		 var strs= new Array(); //定义一数组 
		 strs=contentId.split(","); //字符分割 
		 if(strs.length!=2){
			 layer.msg('必须选中两个选项才能进行比较');
			 return false;
		 }
		 $("#pop1").hide();
		 $("#pop2").hide();
		 $("#contentId").val(contentId);
		 $("#contentType").val($("#collectionType").val());
		 document.getElementById("contentCompare").submit();
	}
	function selectEon(){
		var id = $("#yearTypeEon").val();
		if(id==""){
			return false;
		}
	    $.ajax({
	      url : "/admin/trendsManage/selectEra.do",
	      type : "post",
	      data :  {id:id},
	      dataType : "json",
	      success : function(data){
	      if(data.success==1){
	    	  $("#yearTypeEra").empty();
	    	  $("#yearTypeEra").append(
	    	  	'<option value="">代</option>'
	    	  )
	    	  for(var i=0;i<data.data.length;i++){
	        	  $("#yearTypeEra").append(
	        	  	'<option value="'+data.data[i].id+'">'+data.data[i].name+'</option>'
	        	  )
	    	  }
	      }else{
	          }
	      },
	   })
	}
	
	function selectEpo(){
		var id = $("#yearTypeEra").val();
		if(id==""){
			return false;
		}
		$.ajax({
			url : "/admin/trendsManage/selectEra.do",
			type : "post",
			data :  {id:id},
			dataType : "json",
			success : function(data){
				if(data.success==1){
					$("#yearTypeEpoch").empty();
					$("#yearTypeEpoch").append(
						'<option value="">纪</option>'
					)
					for(var i=0;i<data.data.length;i++){
						$("#yearTypeEpoch").append(
							'<option value="'+data.data[i].id+'">'+data.data[i].name+'</option>'
						)
					}
				}else{}
			},
		})
	}
	
	function sort(){
		if(1==$("#sortSelect").val()){
			$("#versionList").hide();
			$("#versionListOrder").show();
		}else{
			$("#versionList").show();
			$("#versionListOrder").hide();
		}
	}
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
		        var page = location.search.match(/currentPage=(\d+)/);
		        return page ? page[1] : 1;
		    	}(),
		   	skip: true, //是否开启跳页
		   	skin: '#2a9bcf', //皮肤
		   	groups: 3, //连续显示分页数
		    jump: function(e, first){ //触发分页后的回调
		       if(!first){ //一定要加此判断，否则初始时会无限刷新
		         location.href = '?currentPage='+e.curr+'&'+$('form').serialize() ;
		       }
		    }
		})
		var abc="<span>每页显示<input style='width:50px;height: 28px;' type='number'  min='5' max='100' step='5' class='input-text' id='pageSize'   value='"+${page.size }+"' name='size'>条</span>";
		$(".laypage_total").before(abc); 
	</script>
</body>
</html>