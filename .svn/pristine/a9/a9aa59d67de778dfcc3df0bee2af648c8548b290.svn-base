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
	.modal{
		top:100px;
	}

	#btn{
		height:31px;
		margin-bottom:20px;
	}
	.Hui-article-box{
		position: absolute;
		left:0
	}

</style>


<title>工作总结</title> 
</head>
<body>
	<header id="head"></header>
	<%@ include file="../organization/gmheadbtn.jsp"%> 
	
	<section class="Hui-article-box" style="overflow:auto"> 
		<br><br> 
		<div id="btnHide" style="position: relative;left: 29px">
			<button class="btn radius btn-primary   size-L " onclick="museumSummary()" id="museumSummary">博物馆总结</button>
			<button class="btn radius btn-primary  size-L " onclick="museumSummary()" id="citySummary">博物馆总结</button>
			<button class="btn radius  size-L " onclick="mySummary()" >我的总结</button>
		</div> 
		<div style="position: absolute;left: 15%" id="countStatistic" class="hide">
			<span>已填写的博物馆数量：</span>  
			<span>${workCount }</span><br>   
			<span>未填写的博物馆数量：</span>  
			<span>${allCount }</span> 
		</div>
		<div style="position: absolute;left: 30%">
			<form action="/admin/gmWork/workList.do" method="post" id="form">
				<div class="hide">         
	        	每页显示条数:&nbsp; 
	            <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${gmList.page.size }" name="size">
	        	</div> 
				<!-- <div class="province f-l"> 
					<span>博物馆：</span> 
					<input type="text" name="cityName" style="height:25px ">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</div>  -->
				<span>单位</span>
	        	<span style="width: 190px;height: 26px;padding: 2px 5px;border-radius: 5px;" class="select-box">
                	<select name="area" class="select regionType" size="1" style="" id="diqu">
				    	<option value="">文物局</option>
				   		<c:forEach items="${area}" var="a" varStatus="row">
							<option value="${a.id}" <c:if test="${a.id eq dto.area}">selected</c:if> >${a.name}</option>
						</c:forEach>
					</select>   
                </span>&nbsp;&nbsp;
               	<span style="width: 190px;height: 26px;padding: 2px 5px;border-radius: 5px;" class="select-box">
                    <select name="unit" class="select" size="1" style="" id="danwei">
			    		<option value="">博物馆</option>
				    	<c:forEach items="${unit}" var="u" varStatus="row">
							<option value="${u.id}" <c:if test="${u.id eq dto.unit}">selected</c:if> >${u.name}</option>
						</c:forEach>
					</select>    
                </span>   
				<%-- <span>博物馆：</span>
				<input type="text" name="name" style="height:25px " value="${gmWork.name }"> --%>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   
			  
				<span>年度：</span>
				<input type="text" class="input-text" name="years" style="width: 160px;height: 26px;border-radius: 5px;display:inline-block;" value="${gmWork.years }"> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				
				<input type="submit" value="查询" style="height:25px;width: 80px;padding-top: 1px " class="btn btn-primary size-M radius">
			</form>
		</div><br><br>
		
		<div class="table table-border table-bordered table-striped" id="#tab" style="width: 70%;margin: 0 auto;">
			<table class="table table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th >博物馆名称</th>
						<!-- <th class="province">文物局</th> -->
						<th>年度</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
					 
				</thead>
				<tbody>
					<c:forEach items="${gmList.data}" var="gm" varStatus="status">
						<tr class="text-c">
							<td style="width: 40%" class="">${gm.name }</td>
							<%-- <td style="width: 40%" class="province">${gm.name }</td> --%>
							<td style="width: 30%">${gm.years}</td>
							<td style="width: 5%" id="sta${status.count }">未提交</td> 
							<td style="width: 15%">
								<a href="javascript:;" id="show${status.count }" name="${gm.id }" onclick="show(this.name)">查看</a>
								<a href="/admin/gmWork/download.do?id=${gm.id }" id="down${status.count }" >下载</a>
							</td>
							
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<div id="page" style="padding-left: 30px;margin-top:10px;" class="text-r"></div>
		</div>
		<div id="modal-demo2" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 80%">
				<div class="modal-content radius" >
					<div class="modal-header">
						<h3 class="modal-title text-c">${newYears }年度${name }工作总结</h3>
						<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
					</div>
					<div class="modal-body" style="width: 100%;height: 600px">
						<iframe src="" id="iframe" style="height: 100%;width: 90%"></iframe>
					</div>
					<div class="modal-footer" id="btndiv">
						<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>	
	
	<script type="text/javascript">
	
		var appName = '<%=request.getContextPath() %>';	
	
		function show(id) {
			
			var data = {"id":id};
			$.ajax({
				url:"/admin/gmWork/show.do",
				data:data,
				type:"post",
				success:function(data) {
					var map = JSON.parse(data);
					var name = map.name;    
					var msg = map.msg;
					if (msg == "ok") {
						$("#iframe").attr("src",'<%=request.getContextPath() %>/upload/' + name + '/' + 'index.html');
						$("#modal-demo2").modal("show");
					} else {
						alert("预览失败，请下载查看该文件！");    
					}
				}
				
			})
		}
		function museumSummary() {
			window.location.href="/admin/gmWork/workList.do"
		}
		
		function mySummary() {
			window.location.href="/admin/gmWork/mySummary.do"
		}
	
	
		$(document).ready(function(){
			var orgTypeId = ${orgTypeId};
			if (orgTypeId == "1") {
				$("#countStatistic").show(); 
			}
			
			var jsonString = ${jsonString};
			for(var i = 1;i <= jsonString.length;i++) {
				var li = jsonString[i-1];
				if (orgTypeId == "1") {
					if (li.workStatus == 1) {
						$('#sta' + i).html("已提交");
					} 
					if (li.id == null) {
						$('#sta' + i).html("未填写");
						$('#show' + i).hide();
						$('#down' + i).hide(); 
					}
				} else {
					if (li.workStatus == 1) {
						$('#sta' + i).html("已提交");
					} 
				}
				 
			}
			
			
			$('.regionType').change(function(){
		        var pid=$(this).val();
		        var obj=$(this).parent().next("span").find("select");
		        var first=obj.children().first().clone();
		        $.ajax({
		          	url:appName + "/museumInfoManage/region.do",
		            data:{pid:pid},
		            type:"POST",
		            success:function(msg){   
		                obj.empty().append(first);
		                var sub=obj.next('select');
		                while(sub.length>0){
		                	first=sub.children().first().clone();
		                	sub.empty().append(first);
		                    sub=sub.next('select');
		                }
		                for(var i in msg)
		                    obj.append("<option value="+msg[i]['id']+">"+msg[i]['name']+"</option>");
		            }
		        });
		    });
			
			
			var nums = ${gmList.page.size}; //每页出现的数量
			var pages = ${gmList.page.totalPage}; //得到总页数
			
			$(".headerNav a.work").addClass("active");
			if (orgTypeId == "2") { 
				$(".fabu-aside>ul>li").eq(3).addClass("weihu");
				$("#museumSummary").show();
				$("#citySummary").hide();
			} else {
				$(".fabu-aside>ul>li").eq(4).addClass("weihu");
				$("#museumSummary").hide();
				$("#citySummary").show();
			}
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
			var abc="<span>每页显示<input style='width:50px;height: 28px;' type='number'  min='5' max='100' step='5' class='input-text' id='pageSize'   value='"+${gmList.page.size }+"' name='size'>条</span>";
			$(".laypage_total").before(abc);
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
	</script>
	

	



		


	
		
		
		
	</script>
</body>
</html>
