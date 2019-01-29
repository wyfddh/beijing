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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/public.css"/>
<style type="text/css">
	.textHidden{max-width:70%; white-space:nowrap;overflow:hidden;text-overflow:ellipsis; }
</style>
<title>文创产品-新建</title>
</head>
<body style="background:#fff;padding:10px">
<form class="layui-form" id="newForm">
	<input type="hidden" id="id" name="id" value="">
	<input type="hidden" id="pictureId" name="pictureId" value="">
	<div class="layui-col-xs12" style="padding-right: 20px;padding-left: 20px;">
		<div class="layui-form-item layui-row layui-col-xs12">
			<input type="text" class="layui-input inputText" lay-verify="required" placeholder="标题" id="productName" name="productName" style="width:70%;display: inline-block;">
			<button type="button" class="layui-btn" lay-submit lay-filter="save" style="float:right; margin-right:50px;">保存</button>
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12">
			<label><b>主图</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<div id="showImg" style="width: 95%;height: 150px;display: none;margin-bottom: 10px;"><a href="javascript:void(0);" ><img id="titleImgShow" style="max-height: 100%;max-width: 100%;" src="" ></a></div>
			<button type="button" class="layui-btn layui-btn-radius layui-btn-primary" id="uploadImg"><i class="layui-icon">&#xe67c;</i>上传标题图</button>
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12" style="margin-top: 10px;">
			<label><b>类别</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12" style="vertical-align:middle;width:95%;">
			<select class="layui-select" name="categoryId" id="categoryId" lay-verify="required">
			<c:forEach items="${categoryList }" var="list">
				<option value="${list.id }">${list.categoryName }</option>
			</c:forEach>
			</select>
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12" style="margin-top: 10px;">
			<label><b>产品编号</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12" style="vertical-align:middle;">
			<input type="text" class="layui-input inputText" lay-verify="required" placeholder="这里输入产品编号" value="" name="productNumber" id="productNumber" style="width:95%;">
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12" style="margin-top: 10px;">
			<label><b>产品价格（元）</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12" style="vertical-align:middle;">
			<input type="text" class="layui-input inputText" lay-verify="required|ver_double" placeholder="这里输入产品价格（元）" value="" name="productPrice" id="productPrice" style="width:95%;">
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12" style="margin-top: 10px;">
			<label><b>设计元素</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12" style="vertical-align:middle;">
			<textarea type="text" class="layui-textarea textarea" onkeyup="checkLength(this);" placeholder="说点什么吧..." value="" name="designElements" id="designElements" row="3" style="width:95%;resize:none;"></textarea>
		  &nbsp;限制字数：256   剩余字数：<span id="sy" style="color:Red;">256</span>
		</div>
		
	</div>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.all.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/lang/zh-cn/zh-cn.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript">
//初始化富文本编辑器
var cn = UE.getEditor('editorCh',{
    toolbars: [[
            'indent', '|',
            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'insertimage', 'imageleft', 'imageright', 'imagecenter'
        ]],
    initialFrameHeight: 500
});
</script>
<script type="text/javascript">
layui.use(['form','layer','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    	laydate = layui.laydate;
	
   	laydate.render({
   	    elem: '#deadlineTime'
   	    ,type: 'datetime'
   	    ,format: 'yyyy-MM-dd HH:mm'
   	  });
   	
   	form.verify({
		ver_double: [/^[0-9]+([.]{1}[0-9]+){0,1}$/, '只能输入数字类型']
  	});
   	
    form.on("submit(save)",function(data){
    	saveOrPublish('1');
        return false;
    });
    form.on("submit(publish)",function(data){
    	layer.confirm('是否确认发布？', {icon: 3, title: '发布确认'}, function (index) {
	    	saveOrPublish('2');
	    	layer.close(index);
    	});
        return false;
    });
    
    //保存获取发布
    var saveOrPublish = function(status){
    	if($("#productName").val() == ""){
            layer.open({
                title:"提示",
                content:"您还没有填写文创产品名称"
            })
        }else if($("#pictureId").val() == ""){
            layer.open({
                title:"提示",
                content:"您还没有上传文创产品图"
            })
        }else if($("#categoryId").val() == ""){
            layer.open({
                title:"提示",
                content:"您还没有选择类别"
            })
        }else if($("#productNumber").val() == ""){
            layer.open({
                title:"提示",
                content:"您还没有填写产品编号"
            })
        }else if($("#productPrice").val() == ""){
            layer.open({
                title:"提示",
                content:"您还没有填写产品产品价格"
            })
        }else {
       		saveFunction(status);
        }
    }
    
    var saveFunction = function(status){
    	$.ajax({
            url:"<%=request.getContextPath() %>/wenChuang/save.do",
            data:$("#newForm").serialize(),
            type:"POST",
            success:function(msg){
                if(msg.code == 1){
                	if(status == '1'){		//暂存
                		layer.msg('保存成功');
                	}else if(status == '2'){
                		layer.msg('发布成功');
                	}
                	setTimeout(function(){
    					close();
    				},700);
                }else{
                	layer.msg(msg.msg);
                }
            }
        });
    }
    
    $("#uploadImg").click(function(){
    	var index = layui.layer.open({
		      title : "裁剪图片",
		      type : 2,
		      content : "<%=request.getContextPath() %>/cropper/Article_crop.jsp?type=4",
			  area: ['90%', '600px'],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
		            setTimeout(function(){
		                layui.layer.tips('点击此处返回文创产品', '.layui-layer-setwin .layui-layer-close', {
		                    tips: 3
		                });
		            },500)
				},
		      yse:function (index, layero) {
		          layer.close(index); //关闭弹层
		      }
		  });
    	layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
    });
    
})

//子页面调用
function setTitleImg(absolurl, relativeurl){
	$('#titleImgShow').attr('src', absolurl); //图片链接（base64）
	$('#pictureId').val(relativeurl); //相对路径
	$("#showImg").show();
}

//关闭
$("#close").click(function(){
	close();
});

function close(){
	var index=parent.layui.layer.getFrameIndex(window.name);
	parent.layui.layer.close(index);
}

function checkLength(which) {
    var maxChars = 256; //
    if (which.value.length > maxChars)
    {
        alert("您输入的字数超出限制!");
        // 超过限制的字数了就将 文本框中的内容按规定的字数 截取
        which.value = which.value.substring(0,maxChars);
        return false;
    }
    else
    {
        var curr = maxChars - which.value.length; //250 减去 当前输入的
        $("#sy").html(curr.toString());
        return true;
    }
}
</script>
</body>
</html>