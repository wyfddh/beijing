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
	.modal-body{
		height:200px;
		
	}
	.modal-dialog{
	}
	.file {  
	    position: relative;  
	    display: inline-block;  
	    background: #D0EEFF;  
	    border: 1px solid #99D3F5;  
	    border-radius: 4px;  
	    padding: 4px 12px;  
	    overflow: hidden;  
	    color: #1E88C7;  
	    text-decoration: none;  
	    text-indent: 0;  
	    line-height: 20px;  
	}  
	.file input {  
	    position: absolute;  
	    font-size: 100px;  
	    right: 0;  
	    top: 0;  
	    opacity: 0;  
	}  
	.file:hover {  
	    background: #AADFFD;  
	    border-color: #78C3F3;  
	    color: #004974;  
	    text-decoration: none;  
	} 
	#btndiv{
		position: absolute;
		bottom: 0;
		right:0;
	}
	.laypageskin_molv{
	margin-top:10px;
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
	
	<section class="Hui-article-box">
		<h4 class="text-c">${name }工作总结</h4>
		<div>
			<div id="btnHide" class="hide f-l" style="position: relative;left: 29px">      
				<button class="btn radius   size-L " onclick="museumSummary()" id="museumSummary">博物馆总结</button>
				<button class="btn radius   size-L " onclick="museumSummary()" id="citySummary">博物馆总结</button>
				<button class="btn radius btn-primary size-L " onclick="mySummary()" >我的总结</button>
			</div>
			<div class="">
				<button class="btn radius btn-primary size-L f-r" id="btnRight" onClick="modaldemo()" style="position: relative;right: 29px">填写新总结</button>
			</div>
		</div>
		<br><br>
		          
		 
		<div class="table table-border table-bordered table-striped" id="#tab">
			<table class="table table-hover table-sort">
				
				<tbody>
					<c:forEach items="${gmList.data}" var="gm" varStatus="status">
						<form action="/admin/gmWork/submit.do" method="post" id="form${status.count }">
							<input type="text" class="hide" name="id" value="${gm.id }">
							<tr class="text-c">
								<td style="width: 5%" id="tab${status.count }">${status.count }</td>
								<td style="width: 70%">${gm.workName}</td>
								<td style="width: 5%" id="sta${status.count }">未提交</td>
								<td style="width: 15%">
									<a href="javascript:;" id="edi${status.count }" name="${gm.id }" onclick="edi(this.name)">编辑</a>
									<a href="javascript:;" id="show${status.count }" name="${gm.id }" onclick="show(this.name)">查看</a>
									<a href="javascript:;" id="sub${status.count }"  name="${status.count }"   onclick="sub(this.name)">提交</a>
									<a href="/admin/gmWork/download.do?id=${gm.id }" id="down${status.count }" >下载</a>
								</td>
							</tr>
						</form>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="page" style="padding-left: 30px;" class="text-r"></div>
		<div id="modal-demo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content radius">
					<div class="modal-header">
						<h3 class="modal-title text-c hide newWorkName" >${newWorkName }</h3> 
						<h3 class="modal-title text-c hide oldWorkName" ></h3>           
						<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
					</div>
					<div class="modal-body">
						<form action="/admin/gmWork/upload.do" method="post" id="upload" enctype="multipart/form-data">
							<div>
								<input type="text" name="years" class="hide" value="${newYears}"/>
								<input type="text" name="id" class="hide" value="" id="id"> 
								<a href="javascript:;" class="file" id="up">请上传附件
								    <input type="file" multiple name="file" id="file" onchange="upload(this.value)">  
								</a>
								<p id="showFileName" ></p>
								<span class="hide" id="sp">
									<a href="javascript:;" class="file" id="del" >取消</a>
								</span>
							</div>
							<div class="modal-footer" id="btndiv">
								<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
								<button class="btn btn-primary" id="btnDown" type="button" onclick="saveReturn()">保存并返回</button>   
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div id="modal-demo2" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 80%">
				<div class="modal-content radius" >  
					<div class="modal-header">
						<h3 class="modal-title text-c hide oldWorkName" ></h3>   
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
	
		function saveReturn() {
			 var file = document.getElementById('file'); 
			 var showFileName = $("#showFileName").html();
			 if (file.value == "" && showFileName == "") { 
				 alert("请选择您需要上传的文件！");    
				 return false;
			 } else {
				 $("#upload").submit();
			 }
			
		}
	
		function upload(value) {
			var name = value.substring(value.lastIndexOf(".")+1).toLowerCase();
			if (name != "doc" && name != "docx") {
    			alert("请选择word格式文件上传！");
    			return;
    		}
			
			var arr=value.split('\\'); 
			var fileName=arr[arr.length-1];
			
			$("#up").hide();
			$("#showFileName").html(fileName);
			$("#showFileName").show();
			$("#sp").show();
		}	
	
		function edi(id) {
			var data = {"id":id};
			$.ajax({
				Type:"post",
				url:"/admin/gmWork/form.do",
				data:data,
				success:function(data) {
					oldWorkName = data.workName;
					$("#modal-demo").modal("show");
					$(".oldWorkName").html(oldWorkName); 
					$(".oldWorkName").show();
					$(".newWorkName").hide();
					$("#showFileName").html(data.fileUpload);
					$("#showFileName").show();
					$("#id").val(data.id)
				}
			})
		}
	
		function modaldemo(){ 
			$("#showFileName").html("");   
			$("#modal-demo").modal("show");
			$(".newWorkName").show(); 
			$(".oldWorkName").hide();
		};
		
		function sub(str) {
			if(window.confirm('提交后不可更改，您确定要提交吗？')){
               $('#form' + str).submit();
            }
			
		}
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
						alert("预览失败，请下载查看该文件！") 
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
			
			var maxYear = ${maxYears};
			var nowYear = ${nowYear};
			if ((maxYear + 1) == nowYear) { 
				$("#btnRight").hide(); 
			}  
			
			var orgTypeId = ${orgTypeId};
			if (orgTypeId == "1" || orgTypeId == "2") {
				$("#btnHide").show();
			};
			
			
			var jsonString = ${jsonString};
			for(var i = 1;i <= jsonString.length;i++) {
				var li = jsonString[i-1];
				if (li.workStatus == 1) {
					$('#sta' + i).html("已提交");
					$('#edi' + i).hide();
					$('#sub' + i).hide();
				}
			}
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
			/* $("#file").change(function() {
				
				var value = $("#file").val();
				
				
			}) */
			
			$("#del").click(function() {
				
				$("#file").select();   
				document.execCommand("delete"); 
				
				$("#up").show();
				$("#showFileName").html("");
				$("#showFileName").hide();
				$("#sp").hide();
				
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
	
	
</body>
</html>
