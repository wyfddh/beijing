<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Hosting Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
        Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<title></title>

<script src='designPlug-in/ace/assets/js/jquery-2.0.3.min.js'></script>
<script src="designPlug-in/layer/layer.js"></script>
<script src="designPlug-in/layer/extend/layer.ext.js"></script>
<script src="designPlug-in/laypage/laypage.js"></script>
<t:base type="layer"></t:base>
<link rel="stylesheet" href="designPlug-in/layui-2.3.0/css/public.css">

</head>
<body >
	<div class="layui-tab layui-tab-brief layui-form"    style="margin-top: 10px;" >
		<ul class="layui-tab-title">
		<c:if test="${cgformDefine.bussType!='3' }">
			 <li class="layui-this"  >使用中表单<span class=""></span></li>
		     <li class="" >业务表单<span class=""></span></li>
		     <li class=""  >非业务表单<span class=""></span></li>
	     </c:if>
	     <c:if test="${cgformDefine.bussType=='3' }">
		     <li class="layui-this"  >系统表单<span class=""></span></li>
		  </c:if>
	   </ul>
	   <div class="layui-tab-content" >
	   <c:if test="${cgformDefine.bussType!='3' }">
			<div class="layui-tab-item layui-show"  >
				<div class="layui-row layui-col-space10 panel_box" type="1" >
					<c:forEach items="${defineList3}" var="define">
						<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md2 layui-col-lg2" style="margin-bottom: 30px;width: 170px;">
							<a href="javascript:;" >
								<div class="panel_icon layui-bg-cyan">
									<i class="layui-anim layui-icon" ></i>
								</div>
								<div class="panel_word outIcons">
									<span>${define.countsize}</span>
									<em>${define.define_code}</em></br>
									<em>${define.define_name}</em>
								</div>
							</a>
							<c:if test="${define.id==bean.defineId }">
								<span class="layui-badge" style="position: absolute;top: 5px;right: 5px;">使用中</span>
							</c:if>
							<input lay-filter="jsTabBrief" type="radio" id="defineId" name="defineId" value="${define.id}" 
							<c:if test="${define.id==bean.defineId }"> checked </c:if>
							title="引用此表单" >
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="layui-tab-item"  >
				<div class="layui-row layui-col-space10 panel_box" >
					<c:forEach items="${defineList1}" var="define">
						<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md2 layui-col-lg2">
							<a href="javascript:;" >
								<div class="panel_icon layui-bg-cyan">
									<i class="layui-anim layui-icon" ></i>
								</div>
								<div class="panel_word outIcons">
									<span>${define.countsize}</span>
									<em>${define.define_code}</em></br>
									<em>${define.define_name}</em>
								</div>
							</a>
							<input lay-filter="jsTabBrief" type="radio" id="defineId" name="defineId" value="${define.id}" 
							<c:if test="${define.id==bean.defineId }"> checked </c:if>
							title="引用此表单" >
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="layui-tab-item"  >
				<div class="layui-row layui-col-space10 panel_box"  >
					<c:forEach items="${defineList2}" var="define">
						<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md2 layui-col-lg2">
							<a href="javascript:;" >
								<div class="panel_icon layui-bg-cyan">
									<i class="layui-anim layui-icon" ></i>
								</div>
								<div class="panel_word outIcons">
									<span>${define.countsize}</span>
									<em>${define.define_code}</em></br>
									<em>${define.define_name}</em>
								</div>
							</a>
							<input lay-filter="jsTabBrief" type="radio" id="defineId" name="defineId" value="${define.id}" 
							<c:if test="${define.id==bean.defineId }"> checked </c:if>
							title="引用此表单" >
						</div>
					</c:forEach>
				</div>
			</div>
			</c:if>
			<c:if test="${cgformDefine.bussType=='3' }">
			<div class="layui-tab-item layui-show"  >
				<div class="layui-row layui-col-space10 panel_box"   type="4">
					<c:forEach items="${defineList4}" var="define">
						<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md2 layui-col-lg2">
							<a href="javascript:;" >
								<div class="panel_icon layui-bg-cyan">
									<i class="layui-anim layui-icon" ></i>
								</div>
								<div class="panel_word outIcons">
									<em>${define.define_code}</em></br>
									<em>${define.define_name}</em>
								</div>
							</a>
							<c:if test="${define.id==bean.defineId }">
								<span class="layui-badge" style="position: absolute;top: 5px;right: 5px;">使用中</span>
							</c:if>
							<span style="display: none;">
							<input lay-filter="jsTabBrief" type="radio"  id="defineId" name="defineId" value="${define.id }"
							<c:if test="${define.id==bean.defineId }"> checked </c:if>
							 title="引用此表单" >
							使用中</span>
						</div>
					</c:forEach>
				</div>
			</div>
			</c:if>
		</div>
	</div>
	<script type="text/javascript">
	
	layui.use(['form','element'], function(){
		var form = layui.form;
		parent.$("#defineId").val("${bean.defineId}");
		form.on("radio(jsTabBrief)", function(data){
			parent.$("#defineId").val(data.value);
			$(".layui-badge-dot").removeClass("layui-badge-dot");
			$(".layui-tab-title .layui-this").find("span").attr("class","layui-badge-dot");
		});
	});
	
	 function initSort(){
		var badge= $(".layui-badge").closest('.layui-col-xs12');
		var box= $(".layui-badge").closest('.panel_box');
		var dhtml=badge.prop("outerHTML");
		box.prepend(dhtml);
		badge.remove();
		$(".layui-tab-title .layui-this").find("span").attr("class","layui-badge-dot");
    }
	$(document).ready(function(){
		initSort();
	});
	
	</script>
</body>
</html>
