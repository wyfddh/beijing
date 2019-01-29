<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<title>添加人员信息</title>
	<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/public/public.css" media="all" />

<style type="text/css">
	form:after{
		display:block;
		content:'';
		clear:both;
	}
	.selectDiv{
		display: flow-root;
	}
	.layui-form-label{
		width: 260px !important;
	}
</style>
</head>

<body class="childrenBody">
 
<form class="layui-form" method="post" id="form">
	<input type="hidden" id="geography" name="geography" value="">
	<input type="hidden" id="level" name="level" value="${level}"/>
    <input type="hidden" name="orgId" id="orgId" value="${orgId}">
    <input type="hidden"  id="totalStatus" value="${totalStatus}">
    <input type="hidden" name="id"  id="id" value="${personDetailInfo.id}">
	
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label"><font color="red">*&nbsp;&nbsp;</font>姓名</label>
		<div class="layui-input-block">
			<input type="text" value="${personDetailInfo.detailName }" name="detailName" id="detailName"  lay-verify="required"  autocomplete="off" class="layui-input" style="width: 500px;">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label"><font color="red">*&nbsp;&nbsp;</font>性别</label>
		<div class="layui-input-block selectDiv" style="width: 500px;">
	      <select name="sex" id="sex" lay-verify="required">
	        <option value="">请选择</option>
	        <option value="0" <c:if test="${personDetailInfo.sex == 0 }">selected</c:if> >女</option>
	        <option value="1" <c:if test="${personDetailInfo.sex == 1 }">selected</c:if> >男</option>
	      </select>
	    </div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">出生年月</label>
		<div class="layui-input-block">
	      <input type="text" class="layui-input birthday" name="birthday"  value="${personDetailInfo.birthday }" style="width: 500px;">
	    </div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label"><font color="red">*&nbsp;&nbsp;</font>联系方式</label>
		<div class="layui-input-block">
	      <input type="text" class="layui-input" name="spareData3" id="spareData3" lay-verify="required" value="${personDetailInfo.spareData3 }" style="width: 500px;">
	    </div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">职称</label>
		<div class="layui-input-block selectDiv" style="width: 500px;">
	      <select name="technicalTitle" id="technicalTitle">
	        <option value="">请选择</option>
	        <option value="0" <c:if test="${personDetailInfo.technicalTitle == 0 }">selected</c:if> >高级职称</option>
	        <option value="1" <c:if test="${personDetailInfo.technicalTitle == 1 }">selected</c:if> >中级职称</option>
	        <option value="2" <c:if test="${personDetailInfo.technicalTitle == 2 }">selected</c:if> >初级职称</option>
	        <option value="3" <c:if test="${personDetailInfo.technicalTitle == 3 }">selected</c:if> >其他</option>
	      </select>
	    </div>
	</div>
	
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label"><font color="red">*&nbsp;&nbsp;</font>修复专长</label>
		<div class="layui-input-block selectDiv" style="width: 500px;">
			<input id="repairSpecialty" name="repairSpecialty" type="hidden" value=${personDetailInfo.repairSpecialty }>		
			<select multiple="multiple" id="repairSpecialty1" lay-filter="repairSpecialty1">
				<c:forEach items="${collectionCategory}" var="cate">
					<option value="${cate.id }" <c:if test="${cate.checked == 1 }">selected</c:if> >${cate.name }</option>
				</c:forEach>
	      	</select>
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12 hide">
		<label class="layui-form-label">从事可移动文物修复工作年限</label>
		<div class="layui-input-block">
			<input type="number" min="1" max="100" step="1" class="layui-input" lay-verify="number" name="repairYear" value="${personDetailInfo.repairYear }" style="width: 500px;">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label"><font color="red">*&nbsp;&nbsp;</font>用工形式</label>
		<div class="layui-input-block" style="width: 500px;">
			<input type="radio" name="spareData1" value="0" title="正式" <c:if test="${personDetailInfo.spareData1 == 0 }">checked</c:if> >
      		<input type="radio" name="spareData1" value="1" title="聘用" <c:if test="${personDetailInfo.spareData1 == 1 }">checked</c:if> >
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12" >
		<label class="layui-form-label">是否为离退休人员</label>
		<div class="layui-input-block">
      		<input type="radio" name="jobChanges" value="1" title="是" <c:if test="${personDetailInfo.jobChanges == 1 }">checked</c:if> >
			<input type="radio" name="jobChanges" value="0" title="否" <c:if test="${personDetailInfo.jobChanges == 0 }">checked</c:if> >
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12" >
		<label class="layui-form-label">是否为单位申请资质时的修复技术人员</label>
		<div class="layui-input-block">
      		<input type="radio" name="spareData2" value="1" title="是" <c:if test="${personDetailInfo.spareData2 == 1 }">checked</c:if> >
			<input type="radio" name="spareData2" value="0" title="否" <c:if test="${personDetailInfo.spareData2 == 0 }">checked</c:if> >
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12" style="text-align: center;">
			<c:if test="${level == 1}">
				<button id="addButton" class="layui-btn layui-btn" lay-submit lay-filter="addUser">保存</button>
			</c:if>
			<button type="button" id="reset" class="layui-btn layui-btn layui-btn-primary">取消</button>
	</div>
</form> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript">
$(function(){
    if('${opt}' == 'show'){
    	$("input").attr("disabled",true);
    	$("select").attr("disabled",true);
    	$("#addButton").hide();
    }
	layui.use(['form','layer','laydate'],function(){
	    var form = layui.form
	        layer = parent.layer === undefined ? layui.layer : top.layer,
	   		laydate=layui.laydate,
	        $ = layui.jquery;
	
	    var now = new Date();
	    var maxDate = now.getFullYear()+"-" + (now.getMonth()+1);
	    
	    lay('.birthday').each(function(){
			   laydate.render({
			      elem:this,
			      max:maxDate,
			      type:'month',
			      trigger:'click'
			   });
		 }); 
	    
	    var pathName=window.document.location.pathname;
	    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
	    var index = parent.layer.getFrameIndex(window.name);
	    
	    $("#reset").click(function() {
	    	parent.layui.layer.close(index);
	    })
	    
	    form.on("submit(addUser)",function(data){
	    	
	    	if(!data.field.spareData3){
	    		layer.msg("请填写联系方式！");
	    		return false;
	    	}
	    	var re = /^1\d{10}$/;
	    	var tel = /^0\d{2,3}-?\d{7,8}$/;
	    	if(!(re.test(data.field.spareData3)) && !(tel.test(data.field.spareData3))){
	    		layer.msg("请填写正确的联系方式！");
	    		return false;
	    	}
	    	if(!data.field.repairSpecialty){
	    		layer.msg("请选择修复专长！");
	    		return false;
	    	}
	    	if(!data.field.spareData1){
	    		layer.msg("请选择用工形式！");
	    		return false;
	    	}
	    	
	    	var data = $("#form").serialize();
	        $.ajax({
	        	type:"post",
	        	data:data,
	        	url:projectName + '/relicsBureau/personnelDetailSaveOrUpdate.do', 
	        	success:function(result) {
	        		if (result.success == 1) {
	        			top.layer.msg("操作成功！");
	        			parent.layer.close(index);
	        		} else {
	        			if(result.data){
	        				top.layer.msg(result.data);
	        			}else{
		        			top.layer.msg("系统异常添加失败！");
	        			}
	        			parent.layer.close(index);
	        		}
	        	} 
	        })
	       return false;
	    })
	    
	    initMultiSelect();
	    //初始化多选下拉框
		function initMultiSelect(){
	    	layui.config({
	    		base: projectName + '/js/',
	    	})
	    	layui.use(['multiSelect'],function() {
	    		var $ = layui.jquery,form = layui.form,multiSelect = layui.multiSelect;
	    		form.on('select(repairSpecialty1)',function(){
	    			var vals = getMultiValue();
	    			var str = vals.join(',');
	    			$("#repairSpecialty").val(str);
	    		})
	    	});
	    }
	    //获取多选下拉框的值
	    function getMultiValue(){
	    	var vals = [];
	    	$('.layui-form-checked').each(function() {
				vals.push($(this).parent().attr("lay-value"));
			})
			return vals;
	    }
	})
});


</script>
</body>
</html>