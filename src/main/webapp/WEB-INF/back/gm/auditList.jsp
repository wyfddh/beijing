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
		top:200px;
	}
	.modal-body{
		height:200px;
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


<title>申报记录</title>
</head>
<body>
	<header id="head"></header>
	<%@ include file="../organization/gmheadbtn.jsp"%> 
	<%-- <%@ include file="../content/aside.jsp" %> --%>
	
	<section class="Hui-article-box" style="overflow:auto"> 
		<br> 
		<div style="position: absolute;left: 15%" id="countStatistic" class="hide">
			<span>已填写的博物馆数量：</span>  
			<span>${count }</span><br> 
			<span>未填写的博物馆数量：</span>  
			<span>${allCount }</span> 
		</div>
		<div style="position: absolute;left: 30%">
			<form action="/admin/registerInfo/getInfoList.do?" method="post" id="form">
				<div class="hide">      
	        	每页显示条数:&nbsp; 
	            <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${gmList.page.size }" name="size">
	        	</div> 
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
				<input type="text" name="name" style="height:25px " value="${registerInfo.name }"> --%>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
				<span>年度：</span>   
				<input type="text" name="years" style="width: 160px;height: 26px;border-radius: 5px;display:inline-block;" value="${registerInfo.years }" class="input-text">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="submit" value="查询" style="height:26px;width: 80px;padding-top: 1px " class="btn btn-primary size-M radius">
			</form>
		</div><br><br>
		
		<div class="table table-border table-bordered table-striped" id="#tab" style="width: 70%;margin: 0 auto;">
			<table class="table table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th>博物馆名称</th>
						<th>年度</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
					
				</thead>
				<tbody>
					<c:forEach items="${gmList.data}" var="gm" varStatus="status">
						<tr class="text-c">
							<td style="width: 40%" id="tab${status.count }">${gm.name }</td>

							<td style="width: 30%">${gm.years}</td>
							
							<td style="width: 15%" id="sta${status.count }"></td>
							
							<td style="width: 15%">
								<a href="/admin/registerInfo/auditView.do?reportId=${gm.id }" id="show${status.count }">查看</a>
								<a href="javascript:;" id="aud${status.count }" name="${gm.id }" onclick="modaldemo1(this.name)">审核</a>
								<a href="javascript:;" id="sub${status.count }" name="${gm.id }" onclick="modaldemo2(this.name)">驳回</a>
							</td>
							
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<div id="page" style="padding-left: 30px;margin-top:10px;" class="text-r"></div>
			<div id="modal-demo1" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content radius">
						<div class="modal-header">
							<h3 class="modal-title">审核申报</h3>
							<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
						</div>
						<div class="modal-body">
							<form action="/admin/registerInfo/reviewResult1.do" method="post" id="formInfo1">
								<input type="text" value="" name="id" class="hide" id="idInfo1">
								<div>
									审核结果：
									<div class="radio-box">
										<input type="radio" id="radio1" name="resultScore1" value="0" >
									    <label for="radio1">不合格</label>&nbsp;&nbsp;&nbsp;&nbsp;
									    <input type="radio" id="radio2" name="resultScore1" value="1" >
									    <label for="radio2">合格</label>&nbsp;&nbsp;&nbsp;&nbsp;
									    <input type="radio" id="radio3" name="resultScore1" value="2" >
									    <label for="radio3">优秀</label>
									</div>
								</div>
								<br>
								<div class="hui-form-items">
								    <div class="hui-form-items-title f-l">审核意见:</div>
								    <div class="hui-form-textarea f-l">
								        <textarea  name="reviewResult" rows="8" cols="80" id="area1"></textarea>
								    </div>
								</div>
								
							</form>
						</div>
						<div class="modal-footer">
							<button class="btn btn-primary size-M radius" onclick="btnSubmit1()">提交</button>
							<button class="btn" data-dismiss="modal" aria-hidden="true" >关闭</button>
						</div>
					</div>
				</div>
			</div>
			<div id="modal-demo2" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content radius">
						<div class="modal-header">
							<h3 class="modal-title">审核申报</h3>
							<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
						</div>
						<div class="modal-body">
							<form action="/admin/registerInfo/reviewResult2.do" method="post" id="formInfo2">
								<input type="text" value="" name="id" class="hide" id="idInfo2">
								<br>
								<div class="hui-form-items">
								    <div class="hui-form-items-title f-l">审核驳回意见:</div>
								    <div class="hui-form-textarea f-l">
								        <textarea  name="reviewResult" rows="8" cols="80" id="area2"></textarea>
								    </div>
								</div>
								
							</form>
						</div>
						<div class="modal-footer">
							<button class="btn btn-primary size-M radius" onclick="btnSubmit2()">提交</button>
							<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
						</div>
					</div>
				</div>
			</div>
			<div id="modal-demo3" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content radius">
						<div class="modal-header">
							<h3 class="modal-title">审核申报</h3>
							<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
						</div>
						<div class="modal-body">
							<form action="/admin/registerInfo/reviewResult3.do" method="post" id="formInfo3">
								<input type="text" value="" name="id" class="hide" id="idInfo3">
								<div>
									审核结果：
									<div class="radio-box">
										<input type="radio" id="radio3" name="resultScore2" value="0" >
									    <label for="radio3">不通过</label>&nbsp;&nbsp;&nbsp;&nbsp;
									    <input type="radio" id="radio4" name="resultScore2" value="1" >
									    <label for="radio4">通过</label>&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
								</div>
								<br>
								<div class="hui-form-items">
								    <div class="hui-form-items-title f-l">审核意见:</div>
								    <div class="hui-form-textarea f-l">
								        <textarea  name="reviewResult" rows="8" cols="80" id="area3"></textarea>
								    </div>
								</div>
								
							</form>
						</div>
						<div class="modal-footer">
							<button class="btn btn-primary size-M radius" onclick="btnSubmit3()">提交</button>
							<button class="btn" data-dismiss="modal" aria-hidden="true" >关闭</button>
						</div>
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
		
	 
	 
		function btnSubmit1() {
			var radios = document.getElementsByName("resultScore1"); 
			var value = $("#area1").val();
			if (value == null || value == "") {
				alert("请填写审核意见");
				return false;
			} else {
				for(var i=0;i<radios.length;i++) {  
			        //判断那个单选按钮为选中状态 
			        if(radios[i].checked) { 
			        	$("#formInfo1").submit(); 
			        	break;   
			        } else if (i == radios.length-1) {
			        	if (!radios[i].checked) {
			        		alert("请选择审核结果");
			        		return false;
			        	}
			        }  
			    }  
			}
			
		}
		function btnSubmit2() {
			var value = $("#area2").val();
			if (value == null || value == "") {
				alert("请填写驳回意见");
				return false;  
			} else {
				$("#formInfo2").submit();
			}
		}
		function btnSubmit3() {
			var radios = document.getElementsByName("resultScore2"); 
			var value = $("#area3").val();
			if (value == null || value == "") {
				alert("请填写审核意见");
				return false;
			} else {
				for(var i=0;i<radios.length;i++) {  
			        //判断那个单选按钮为选中状态 
			        if(radios[i].checked) { 
			        	$("#formInfo3").submit(); 
			        	break;   
			        } else if (i == radios.length-1) {
			        	if (!radios[i].checked) {
			        		alert("请选择审核结果");
			        		return false;
			        	}
			        }  
			    }  
			}
			
			 
		} 
		function modaldemo1(id) {
			$("#modal-demo1").modal("show");
			$("#idInfo1").val(id); 
			/* if (level == 2) {
				$("#modal-demo3").modal("show");
				$("#idInfo3").val(id);
			} else {
				$("#modal-demo1").modal("show");
				$("#idInfo1").val(id);
			} */
		};
		function modaldemo2(id) {
			$("#modal-demo2").modal("show");
			$("#idInfo2").val(id);
		};
	
	
		$(document).ready(function(){
			
			var orgTypeId = ${orgTypeId};
			var jsonString = ${jsonString};
			//区文委审核
			for(var i = 1;i <= jsonString.length;i++) {
				var li = jsonString[i-1];
				if (orgTypeId == 1) {
					$("#countStatistic").show(); 
					$('#aud' + i).hide();
					$('#sub' + i).hide();
					if (li.reportStatus == 0) {
						$('#sta' + i).html("未提交");
					} else if (li.reportStatus == 1) {
						$('#sta' + i).html("区文委审核中");
					} else if (li.reportStatus == 2) {
						if (li.resultScore == 0) {
							$('#sta' + i).html("不合格");
						} else if (li.resultScore == 1) {
							$('#sta' + i).html("合格");
						} else if (li.resultScore == 2) {
							$('#sta' + i).html("优秀");
						}
					} else if (li.reportStatus == 3) {
						$('#sta' + i).html("已驳回"); 
					}
					if (li.id == null) {
						$('#sta' + i).html("未填写");
						$('#show' + i).hide();
					}  
				} else {
					if (li.reportStatus == 0) {
						$('#sta' + i).html("未提交");
						$('#aud' + i).hide();
						$('#sub' + i).hide();
					} else if (li.reportStatus == 1) {
						$('#sta' + i).html("审核申报材料");
					} else if (li.reportStatus == 2) {
						if (li.resultScore == 0) {
							$('#sta' + i).html("不合格");
						} else if (li.resultScore == 1) {
							$('#sta' + i).html("合格");
						} else if (li.resultScore == 2) {
							$('#sta' + i).html("优秀");
						}
						$('#aud' + i).hide();
						$('#sub' + i).hide();
					} else if (li.reportStatus == 3) {
						$('#sta' + i).html("已驳回");  
						$('#aud' + i).hide();
						$('#sub' + i).hide(); 
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
			
			
			$("#btn-right").click(function() {
				window.location.href="/admin/registerInfo/promiseList.do"
				
			})
			
			$(".headerNav a.reportAudit").addClass("active");
			if (orgTypeId == 2) { 
				$(".fabu-aside>ul>li").eq(3).addClass("weihu");
			} else {
				$(".fabu-aside>ul>li").eq(4).addClass("weihu");
			}
			
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
