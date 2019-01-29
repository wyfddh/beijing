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
    <title>添加用户</title>
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all"/>
<%--     <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/public/public.css" media="all" /> --%>

<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/Tags/js/jquery-2.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/Tags/js/tag.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Tags/css/tag.css" />
</head>
<style>
    .pics{
        position:relative;
        float:right;
        width:200px;
        height:200px;
        margin-right:100px;
        margin-top:100px;
    }
</style>
<body class="childrenBody">
 
<form class="layui-form" style="width:80%;"  method="post" id="form"> 
    <div>
    <div class="layui-form-item layui-row layui-col-xs7">
       <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">专题名称</label>
        <div class="layui-input-block">
            <input type="hidden" name="id" id="id"   autocomplete="off" class="layui-input">
            <input type="text" name="name" id="name"  required  lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">标签</label>
        <div class="layui-input-block">
<!--             <input type="text"  id="labelEdit"  autocomplete="off" class="layui-input"> -->
<!--             <p id="labelText"></p> -->
<!--             <input type="hidden" name="label" id="label"  autocomplete="off" class="layui-input"> -->
                <input type="text" id="tagValue">
        </div>
    </div>
    
    <div class="layui-form-item layui-row layui-col-xs12" id="phonediv">
        <label class="layui-form-label">展览展厅</label>
        <div class="layui-input-block">
            <input type="text" name="exhibitionHall" id="exhibitionHall"    autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12" id="phonehidediv">
        <label class="layui-form-label">展期</label>
        <div class="layui-input-block">
            <input type="text" id="phonehide"  autocomplete="off" class="layui-input">
            <p >                                                
                   <fmt:formatDate  value="${startTime }" pattern="yyyy-MM-dd HH:mm:ss" />-
                   <fmt:formatDate  value="${endTime }" pattern="yyyy-MM-dd HH:mm:ss" />
            </p>
        </div>
    </div>
    <div class="layui-form-item layui-form-text layui-col-xs12">
    <label class="layui-form-label">普通文本域</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容" class="layui-textarea"></textarea>
    </div>
  </div> 
    
     
   
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-sm"  lay-filter="addUser">确定</button>
            <button type="reset" id="reset" class="layui-btn layui-btn-sm layui-btn-primary">重置</button>
        </div>
    </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs5">
        <div class="pics">
        <img src="" id="iconUrl" style="width:100%;height:100%;"></img>
    </div>
    </div>
    
    </div>
</form> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/back/js/authority/userAdd.js"></script> --%>
	<script type="text/javascript">
	var flag = 0;
	layui.use(['form','layer'],function(){
	    var form = layui.form
	        layer = parent.layer === undefined ? layui.layer : top.layer,
	        $ = layui.jquery;

	    var pathName=window.document.location.pathname;
	    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
	    var index = parent.layer.getFrameIndex(window.name);
	    var tag = new Tag("tagValue");
	    var label = $("#label").val();
        if(null!=label){           
            tag.tagValue = label;
        }
        tag.initView();
        var clicks = $(".tagInput").data('events');
        debugger;
	    form.on("submit(addUser)",function(data){	        
	        var data = $("#form").serialize();
	        $.ajax({
	            type:"post",
	            data:data,
	            url:projectName + '/topic/editTopic.do', 
	            success:function(result) {
	                if (result.success == 1) {
	                    top.layer.msg("修改成功！");
	                    parent.layer.close(index);
	                    
	                } else {
	                    top.layer.msg("系统异常修改失败！");
	                    parent.layer.close(index);
	                }
	            } 
	        })
	       return false;
	    })
	    
	    
	});
	function child(data){
        var json = data;
        $("#id").val(json.topicId);
        $("#name").val(json.name);
        	$("#label").val(json.label);
       
        $("#exhibitionHall").val(json.exhibitionHall);
        $("#introduction").val(json.introduction);  
        $("#iconUrl").attr("src",json.iconUrl);                         
    }
	
	</script>
</body>
</html>