<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta name="renderer" content="webkit|ie-comp|ie-stand">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	    <meta http-equiv="Cache-Control" content="no-siteapp" />
	    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
	    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
	    <!--[if lt IE 9]>
	    <script type="text/javascript" src="../../../../../back/lib/html5shiv.js"></script>
	    <script type="text/javascript" src="../../../../../back/lib/respond.min.js"></script>
	    <![endif]-->
	    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
	    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
	    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
	    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
	    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
	    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/header.css">
	    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/headUserGover.css">
	    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/asideUserGover.css">
	    <!--[if IE 6]>
	    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
	    <script>DD_belatedPNG.fix('*');</script><![endif]-->
	    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
        <title>企业信息审核</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/checkList.css"/>
        <script>
			$(function(){
				$(".fabu-aside>ul>li").eq(4).addClass("gongyingshang");
				$(".headerNav a.shenhe ").addClass("active");
				$(".headerNav a.shenhe  img").attr("src",'<%=request.getContextPath() %>/back/images/qiyexinxishenheicon.png');
			})
		</script>
    </head>
    <body>
    	<!--_header 作为公共模版分离出去-->
		<%@ include file="supplierNav.jsp"%>
	
		<!--_menu 左边slide导航开始-->
		<%@ include file="../content/aside.jsp"%>
		
		<section  class="Hui-article-box">
		    <!--<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 内容管理 <span class="c-gray en">&gt;</span>历史吉林文章管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>-->
		    <div class="Hui-article">
		    	<div class="checkList_table" >
    				<a href="<%=request.getContextPath()%>/cCompany/getCheckCCompanies.do?status=1">全部</a>
    				<a href="<%=request.getContextPath()%>/cCompany/getCheckCCompanies.do?status=2">待审核</a>
    				<a href="<%=request.getContextPath()%>/cCompany/getCheckCCompanies.do?status=3">已审核</a>
				</div>
				
		        <form action="<%=request.getContextPath()%>/cCompany/getCheckCCompanies.do" class="checkList">
	                <div>
	                	企业名称：
	                    <input style="width: 190px;height: 26px;padding-left: 20px;" type="text" name="companyName" value="${keys}" class="input-text" placeholder="">
	                    <input type="hidden" name="status" value="1" />
	                   	&nbsp;	&nbsp;	&nbsp;
	                   	行业类型：
	                   	<select name="categoryName">
	                   		<option value="">选择类型</option>
	                   		<option value="软件开发">软件开发</option>
	                   		<option value="文物修复">文物修复</option>
	                   	</select>
	                   	 
	                    <!--<input style="width: 190px;height: 26px;padding-left: 20px;" type="text" name="keys" value="${keys}" class="input-text" placeholder="">-->
	                </div>
	                <div class="star">
						<button class="btn b1" type="submit" title="搜索"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
						<button class="btn b2" type="reset" title="重置"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>
					</div>
	            </form>
	             
	            <form action="<%=request.getContextPath()%>/cCompany/getCheckCCompanies.do" class="checkList">
	                <div>
	                	企业名称：
	                    <input style="width: 190px;height: 26px;padding-left: 20px;" type="text" name="companyName" value="${keys}" class="input-text" placeholder="">
	                    <input type="hidden" name="status" value="2" />
	                   	&nbsp;	&nbsp;	&nbsp;
	                   	行业类型：
	                   	<select name="categoryName">
	                   		<option value="">选择类型</option>
	                   		<option value="软件开发">软件开发</option>
	                   		<option value="文物修复">文物修复</option>
	                   	</select>
	                   	 
	                    <!--<input style="width: 190px;height: 26px;padding-left: 20px;" type="text" name="keys" value="${keys}" class="input-text" placeholder="">-->
	                </div>
	                <div class="star">
						<button class="btn b1" type="submit" title="搜索"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
						<button class="btn b2" type="reset" title="重置"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>
					</div>
	            </form>
	             
	            <form action="<%=request.getContextPath()%>/cCompany/getCheckCCompanies.do" class="checkList">
	                <div>
	                	企业名称：
	                    <input style="width: 190px;height: 26px;padding-left: 20px;" type="text" name="companyName" value="${keys}" class="input-text" placeholder="">
	                    <input type="hidden" name="status" value="3" />
	                   	&nbsp;	&nbsp;	&nbsp;
	                   	行业类型：
	                   	<select name="categoryName">
	                   		<option value="">选择类型</option>
	                   		<option value="软件开发">软件开发</option>
	                   		<option value="文物修复">文物修复</option>
	                   	</select>
	                   	 
	                    <!--<input style="width: 190px;height: 26px;padding-left: 20px;" type="text" name="keys" value="${keys}" class="input-text" placeholder="">-->
	                </div>
	                <div class="star">
						<button class="btn b1" type="submit" title="搜索"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
						<button class="btn b2" type="reset" title="重置"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>
					</div>
	            </form>
	             
		            
	            <div style="clear: both"></div>
	            <div style="min-width: 1020px;padding-left: 30px;">
	                <table class="table">
	                    <thead>
	                    <tr class="text-c">
	                        <th width="80">序号</th>
	                        <th width="300">企业名称</th>
	                        <!--  <th width="300">企业主图</th>-->
	                        <th width="300">行业类型</th>
	                        <th width="300">所在地区</th>
	                        <th width="300">审核状态</th>
	                        <th width="300">操作</th>
	                    </tr>
	                    </thead>
	                    <tbody>
	                    	<c:forEach items="${result.dtoList}" var="art" varStatus="status">
		                    	<tr class="text-c">
									<td>${status.count}</td>
									<td style="font-size:14px;">${art.companyName}</td>
									<!--  <td>
										<img style='width:50px;height:50px;' src="${art.licenseUrl}" alt="" />
									</td> -->
									<td>${art.categoryName}</td>
									<td>${art.address}</td>
									<td>
										<c:if test="${art.status==2}">待审核</c:if>
										<c:if test="${art.status==3}">审核通过</c:if>
										<c:if test="${art.status==4}">审核未通过</c:if>
									</td>
									<!-- 预览的地址栏需要修改 -->
									<td class="td-manage">
										<a title="查看" href="<%=request.getContextPath()%>/cCompany/getDetail.do?id=${art.id}" target="_blank">
											<img src="<%=request.getContextPath() %>/back/images/chakan.png" alt="" />
										</a>
										<span class="checkList_shenhe" id="${art.id}">
											审核
										</span>
									</td>
								</tr>
							</c:forEach>
	                    </tbody>
	                </table>
	            </div>
	            <br>
		        <div id="page" style="padding-left: 30px;"></div>
		    </div>
		    <div>
		    </div>
		</section>   	
    	
    	
    	
    	
    	<script type="text/javascript">
    		
    		// 标签显示
    		function GetRequest() {  
			  	var url = location.search; //获取url中"?"符后的字串  
			   	var theRequest = new Object();  
			  	if (url.indexOf("?") != -1) {  
			     	var str = url.substr(1);  
			     	strs = str.split("&");  
			     	for(var i = 0; i < strs.length; i ++) { 
			     		
			        	theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);  
			        
			    	}  
			   	}  
			   	return theRequest;  
			}  
			
			$(".checkList_table>a").eq(GetRequest().status-1).addClass("checkList_table_active");
    		
    		$(".checkList").eq(GetRequest().status-1).css("display","block");
    		
    		// 查看弹窗
    		$(".checkList_shenhe").on("click",function(e){
			
				var id=$(this).attr("id");
			
				layer.open({
		            type: 1,
		            title: "审核企业信息",
		            shadeClose: true,
		            shade: 0.5,
		            maxmin: false, //开启最大化最小化按钮
		            area: ['700px', '570px'],
		            content:
		            	"<div style='padding:25px'>"
			            	+"<form >"
				            	+"<span style='font-size:14px'>审核结果：</span>"
				            	+"<input type='radio' name='status' value='3' checked>通过"
				            	+"<input type='radio' name='status' value='4' style='margin-left:20px'>不通过"
				            	+"<input type='hidden' name='id' value='"+id+"'>"
				            	+"<h3 style='font-size:14px'>原因：</h3>"
				            	+"<textarea maxlength='50' placeholder='输入审核不通过的理由，50字以内.审核通过不需要填写' class='checkList_content' name='auditMsg'></textarea>"
				            	+"<input type='button' class='zj_checkList_save' value='确认'>"
				            	+"<input type='button' class='zj_checkList_cancel' value='取消' onclick='layer.closeAll()'>"
			            	+"</form>"
		            	+"</div>"
		        });
		        
		        $(".zj_checkList_save").unbind().on("click",function(){
    			
    				var status=$("input[name='status']:checked").val(),
    					auditMsg=$(".checkList_content").val();  
    				if((auditMsg==""||auditMsg==null)&&status==4){
    					layer.msg('未填写审核信息', {icon: 2});
    					return;
    				}
	    			$.ajax({
					 	url:'<%=request.getContextPath()%>/cCompany/checkCCompany.do',
					  	type:'get',
					  	data:{
					  		id:id,
					  		status:status,
					  		auditMsg:auditMsg
					  	},
					  	dataType:"html",
					  	success: function(data){
					  		if(data==1) window.location.reload();
					   	},
					  	error: function(){
					   		alert('error');
					   	}
					});
	    		});
		        
		        
				
			});
    		
    		
    		
    		
    		
    	</script>
    	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
    	<script type="text/javascript">
			var nums = ${result.page.size}; //每页出现的数量
			var pages = ${result.page.totalPage}; //得到总页数
			//调用分页
			laypage({
			    cont: 'page',
			    pages: pages,
			    curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
			        var page = location.search.match(/currentPage=(\d+)/);
			        return page ? page[1] : 1;
			    	}(), 
			   	skip: true, //是否开启跳页
			   	skin: '#2A9BCF', //皮肤
			   	groups: 3, //连续显示分页数
			    jump: function(e, first){ //触发分页后的回调
			       	if(!first){ //一定要加此判断，否则初始时会无限刷新
			       	
			       	
			        	location.href = '?currentPage='+e.curr+'&'+"size=10&"+$("form:not(:hidden)").serialize();
			         
			       	}
			    }
			})
		</script>
 	</body>
</html>