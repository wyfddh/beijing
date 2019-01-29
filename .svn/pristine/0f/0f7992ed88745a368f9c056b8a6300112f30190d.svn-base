<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
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
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/jQuery-searchableSelect/jquery.searchableSelect.css"/>
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
    <style type="text/css">       
         .layui-col-xs12{
        	width:400px;
        }
    </style>
    <title>组织机构管理博物馆编辑</title>
</head>
<body style="background:#fff;padding:10px;">
<div class="">
    <form id="newForm" class="layui-form">
    	<input type="hidden" name="id" value="${organization.id }">
    	<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">组织名称</label>
			<div class="layui-input-block">
				<input onblur="blurName()" type="text" class="layui-input" lay-verify="required" placeholder="请输入登录名" id="nameNew" name="name" value="${organization.name }" style="width:250px">
			</div>
		</div>
         <div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">组织类型</label>
			<div class="layui-input-block userSex">
				<input type="radio" name="orgTypeId" value="1" title="文物局">
				<input type="radio" name="orgTypeId" value="2" title="区文委">
				<input type="radio" name="orgTypeId" value="3" title="博物馆">
				<input type="radio" name="orgTypeId" value="4" title="文物修复资质单位">
				<input type="radio" name="orgTypeId" value="5" title="其他文物收藏单位">
			</div>
		</div>
		 <div class="layui-row">
			<div class="magb15 layui-col-md4 layui-col-xs12">
				<label class="layui-form-label" style="margin-bottom: 20px;padding-left: 0;width: 95px;">上级主管单位</label>
				<div class="layui-input-block">
					<select name="parentId" lay-search>
						<option value="0">选择上级主管单位</option>
						<c:forEach items="${orgList}" var="org" varStatus="row">
							<option value="${org.id}" <c:if test="${org.id eq organization.parentId}">selected</c:if>>${org.name}</option>	
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="layui-row">
			<div class="magb15 layui-col-md4 layui-col-xs12">
				<label class="layui-form-label" style="padding-left: 0;width: 95px;">通知公告接收角色</label>
				<div class="layui-input-block">
					<select name="shortname"  lay-verify="required" lay-search>
						<option value="">选择角色</option>
						<c:forEach items="${roleList}" var="role" varStatus="row">
							<option value="${role.id}" <c:if test="${role.id eq organization.shortname}">selected</c:if>>${role.roleName}</option>	
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">是否直属馆</label>
			<div class="layui-input-block">
				<input  type="radio" name="platformId" value="1" title="是" lay-filter="type">
		      	<input  type="radio" name="platformId" value="0" title="否" lay-filter="type" checked="checked">
		    </div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12" style="margin-top:20px;">
			<div class="layui-input-block">
				<button class="layui-btn layui-btn-sm" lay-submit lay-filter="addUser">确定</button>
				<button id="close" type="reset" class="layui-btn layui-btn-sm layui-btn-primary">取消</button>
			</div>
		</div>
    </form>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/jQuery-searchableSelect/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/jQuery-searchableSelect/jquery.searchableSelect.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<!--/_footer /作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
appName = '<%=request.getContextPath()%>';
	$(function(){	
		var orgType = '${organization.orgTypeId}';
		$(":radio[name='orgTypeId'][value='" + orgType + "']").attr("checked", "checked");
		var platformId = '${organization.platformId}';
		$(":radio[name='platformId'][value='" + platformId + "']").attr("checked", "checked");
		
		layui.use(['form','layer'],function(){
			form = layui.form;  
			form.render();
	        layer = parent.layer === undefined ? layui.layer : top.layer,
	        $ = layui.jquery;
		    form.verify({
			    num:[/^([\d]{11})?$/,'请输入正确手机号']      
			}); 
		    form.on("submit(addUser)",function(data){
		    	$.ajax({
		            url:appName+"/organization/museum/addOrUpdate.do",
		            data:$("#newForm").serialize(),
		            type:"POST",
		            success:function(data){
		                 if(data.success == 1){
		                	top.layer.msg('修改成功', {icon: 1});
							setTimeout(function(){
								parent.layui.layer.closeAll("iframe");
						        location.reload();
							},1000)	
		            	}else{
		            		top.layer.msg('修改失败', {icon: 2});
		            	}
		            }
		        });
	        	return false;
		    })
		})
	});
		
function blurName(){
	var value = $("#nameNew").val();
	if(value){
		$.ajax({
			url: appName+"/organization/museum/checkOrgName.do?orgName="+value,
			type:"get",
			dataType:"json",
			success:function(data){
				console.log(data);
				if(data=="1"){
					console.log("成功");
				}else{
				      layer.open({
			                title:"提示",
			                content:"名称已存在"
			            })
				}
			}
		})
	}
	
}
	        
  $("#close").click(function(){
      parent.layui.layer.closeAll();
      location.reload();
  });

	
</script>
</body>
</html>