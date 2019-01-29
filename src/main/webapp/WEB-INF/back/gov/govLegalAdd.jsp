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
	<title>发布</title>
	<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/public/public.css" media="all" />
<style type="text/css">
	.layui-input-block{
		margin-left: 30px;
	}
 
    .delete {
        position: absolute;
        top: 3px;
        right: 15px;
       	
    } 
    .downLoad {
        position: absolute;
        top: 3px;
        right: 15px;
       	
    }
    .aa label{
    	padding-left:0px;
    	text-align:left;
    }
</style>
</head>
<body class="childrenBody">
<form class="layui-form"  method="post" id="form">
	<!-- 解决360浏览器自动填充账号密码输入框 -->
	<input type="text" id="aaa" style="visibility: hidden;" />   
　　	<input type="password" id="aba" style="visibility: hidden;" />
	
	<div class=" layui-col-space30 layui-fluid">
		<div class="layui-row">
		    <div class="layui-input-inline layui-col-sm9">
		    	<input name="title" type="text" id="title" placeholder="标题" lay-verify="required"  autocomplete="off" class="layui-input">
		    	<textarea name="content" placeholder="请输入内容" class="layui-textarea" id="textarea"></textarea>
		    </div> 
		    <input type="text" class="hide" id="textareaHide" />
		    <div class=" layui-input-inline layui-col-sm3 aa" >
		    	<div class="layui-input-block" id="saveBtn">
		    		<button class="layui-btn layui-btn-sm" lay-submit lay-filter="submitBtn" type="button">发布</button>
		    	</div>
		    	<div class="layui-input-block">
		    		<label class="layui-form-label">一级分类</label>
		    	</div>
		    	<div class="layui-input-block" >
		    		<select name="firstKindId" id="firstKind"   lay-filter="firstKind">  
				        <option value="">一级分类</option>  
				    </select>
				    <input type="text" class="hide" id="firstKindHide" />
		    	</div>
		    	<div class="layui-input-block">
		    		<label class="layui-form-label">二级分类</label>
		    	</div>
		    	<div class="layui-input-block ">
			        <select name="secondKindId" id="secondKind"   lay-filter="secondKind">  
			        	<option value="">二级分类</option>  
			        </select>
			        <input type="text" class="hide" id="secondKindHide" />
			    </div>
			    <div class="layui-input-block" >
			    	<label class="layui-form-label">发布单位</label>
			    	<input name="publisher" type="text" id="publisher" lay-verify="required"  autocomplete="off" class="layui-input">
			    </div>
			    <div class="layui-input-block" >
			    	<label class="layui-form-label">发布年份</label>
			    	<input name="publishYear" type="text" id="publishYear" lay-verify="required"  autocomplete="off" class="layui-input">
			    </div>
			    <div class="layui-input-block" >
			    	<label class="layui-form-label">条款号</label>
			    	<input name="code"  type="text" id="code" lay-verify="required|number"  autocomplete="off" class="layui-input">
			    </div>
			    <div class="layui-input-block" >
			    	<label class="layui-form-label">附件</label>
			    	<input type="text" id="hideUrl" class="hide">
			    </div>
			    <div class="layui-input-block" >
			    	
				    <button type="button" class="layui-btn layui-block" id="fileBtn">
						<i class="layui-icon">&#xe67c;</i>上传附件
					</button>
				    
				    <div style="width:250px;height: 35px;position:relative" class="hide" id="fileHide">
						<img src="<%=request.getContextPath() %>/back/images/upload1.png" >
						<div style="width:180px;position:absolute;top: 8px;left: 35px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis; " id="divtext">
						</div>
						<a href="#" onclick="cancelFile()" id="delFile">
				            <img src="<%=request.getContextPath() %>/back/images/x.png" class="delete" />
				        </a>
				        <a href="#" onclick="downFile()" id="downFile" class="hide">
				            <img src="<%=request.getContextPath() %>/back/images/downloadx.png" class="downLoad" />
				        </a>
					</div>
					 
					
					<input type="text" class="hide" name="resultPath" value="" id="resultPath" />  
					<input type="text" class="hide" name="realFileName" value="" id="realFileName" />  
					<input type="text" class="hide" name="isjunk" value="" id="isjunk" />  
					<input type="text" class="hide" name="size" value="" id="size" />  
					<input type="text" class="hide" name="typeCode" value="" id="typeCode" />
					<input type="text" class="hide" name="isChange" value="0" id="isChange" />
			    </div>
			    <input type="text" class="hide" name="type" id="saveType" />  
			    <input type="text" class="hide" name="id" id="legalId" />  
			    <input type="text" class="hide" name="attachmentId" id="attachmentId" />  
			    <input type="text" class="hide" name="isNoneFile" id="isNoneFile" value="0">
		    </div>
		</div>
	</div>
</form> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/gov/legalAdd.js"></script>

</body>
</html>