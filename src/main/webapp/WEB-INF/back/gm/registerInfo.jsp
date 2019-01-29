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
<style type="text/css">
	#btn-left {
		position: absolute;
		left:29px;
	}
	#btn-right {
		position: absolute;
		right:29px;
	}
	#btn{
		height:31px;
		margin-bottom:10px;
	}
	#page{
	margin-top:10px
	}
	.Hui-article-box{
		position: absolute;
		left:0
	}

</style>


<title>申报记录</title>
</head>
<body>
	<header id="head"></header>
	<%@ include file="../organization/gmheadbtn.jsp"%> 
	
	<section class="Hui-article-box">  
		<h4 class="text-c">${name }绩效考评申报记录</h4>
		<div id="btn">
			<button class="btn radius btn-primary  size-L " id="btn-left">申报记录</button>
			<!-- <input class="btn btn-primary size-M radius" id="btn-left" type="button" value="申报记录"> -->
			<!-- <input class="btn btn-primary size-M radius f-r" id="btn-right" type="button" value="填写新申报"> -->
			<button class="btn radius btn-primary size-L f-r" id="btn-right" type="button">填写新申报</button>
		</div>
		    
		<div class="table table-border table-bordered table-striped" id="#tab">
			<table class="table table-hover table-sort">
				
				<tbody>
					<c:forEach items="${gmList.data}" var="gm" varStatus="status">
						<tr class="text-c">
							<td style="width: 5%" id="tab${status.count }">${status.count }</td>

							<td style="width: 70%">${gm.reportName}</td>
							
							<td style="width: 5%" id="sta${status.count }"></td>
							
							<td style="width: 15%">
								<a href="/admin/gmReportForm/form.do?reportId=${gm.id }" id="edi${status.count }" >编辑</a>
								<a href="/admin/gmReportForm/show.do?reportId=${gm.id }" >查看</a>
								<a href="javascript:;" id="sub${status.count }" name="${gm.id }" onclick="sub(this.name)">提交</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="page" style="padding-left: 30px;" class="text-r"></div>
	</section>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>	
	
	<script type="text/javascript">
		function sub(id) {
			if(window.confirm('提交后不可更改，您确定要提交吗？')){
	              window.location.href='/admin/registerInfo/submit.do?reportId=' + id;
	            }
		}
		$(document).ready(function(){
			
			var maxYear = ${maxYear}; 
			var nowYear = ${nowYear};
			if ((maxYear + 1) == nowYear) {
				$("#btn-right").hide();   
			}
			
			
			var orgTypeId = ${orgTypeId};
			if (orgTypeId == "2") { 
				$(".fabu-aside>ul>li").eq(3).addClass("weihu");
			} else {
				$(".fabu-aside>ul>li").eq(4).addClass("weihu");
			}
			$(".headerNav a.report").addClass("active");  
			var jsonString = ${jsonString};
			for(var i = 1;i <= jsonString.length;i++) {
				
				var li = jsonString[i-1];
				if (li.reportStatus == 0) {
					$('#sta' + i).html("未提交");
				};
				if (li.reportStatus == 1) {
					$('#sta' + i).html("已提交");
					$('#edi' + i).hide();
					$('#sub' + i).hide();
				};
				if (li.reportStatus == 2) {
					$('#edi' + i).hide();
					$('#sub' + i).hide();
					if (li.resultScore == 0) {
						$('#sta' + i).html("不合格");
						$('#sta' + i).css("color","red");
					};
					if (li.resultScore == 1) {
						$('#sta' + i).html("合格");
						$('#sta' + i).css("color","Orange");
					};
					if (li.resultScore == 2) {
						$('#sta' + i).html("优秀");
						$('#sta' + i).css("color","green");
					};
				};
				if (li.reportStatus == 3) {
					$('#sta' + i).html("已驳回");
				}
			}
			
			$("#btn-right").click(function() {
				window.location.href="/admin/registerInfo/promiseList.do"
				
			})
			
			var nums = ${gmList.page.size}; //每页出现的数量
			var pages = ${gmList.page.totalPage}; //得到总页数
			
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
			
		})
	</script>
	

	



		


	
		
		
		
	</script>
</body>
</html>
