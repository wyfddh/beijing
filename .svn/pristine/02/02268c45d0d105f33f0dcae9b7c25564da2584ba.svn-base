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
<title>轮播图-添加</title>
</head>
<body style="background:#fff;padding:10px">
<form class="layui-form" id="newForm">
	<input type="hidden" id="carouselPositionId" name="carouselPositionId" value="${carouselPositionId }">
	<input type="hidden" id="file_id" name="file_id" value="">
	<input type="hidden" id="file_resultPath" name="file_resultPath" value="">
	<input type="hidden" id="file_realFileName" name="file_realFileName" value="">
	<input type="hidden" id="file_isjunk" name="file_isjunk" value="">
	<input type="hidden" id="file_size" name="file_size" value="">
	<input type="hidden" id="file_typeCode" name="file_typeCode" value="">
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">链接地址</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input inputText" lay-verify="urlVerify" placeholder="这里输入链接地址" id="url" name="url" style="width:300px">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">所属博物馆</label>
		<div class="layui-input-block" style="width: 300px;">
			<select id="orgId" name="orgId" style="width: 300px;">
				<option>请选择</option>
				<c:forEach items="${orgList}" var="org" varStatus="row">
					<option value="${org.id}" >${org.name}</option>	
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">轮播图</label>
		<div class="layui-input-block">
			<button type="button" class="layui-btn" id="test1">上传轮播</button>
			<input type="hidden" id="pictureId" name=pictureId>
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<div class="layui-input-block">
			<img id="iconImg" src="" style="border: 1px black solid;display: none;max-width: 300px;max-height: 300px;">
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12" style="margin-top:20px;">
		<div class="layui-input-block">
			<button class="layui-btn layui-btn-sm" lay-submit lay-filter="save">保存</button>
			<button type="reset" class="layui-btn layui-btn-sm layui-btn-primary" lay-filter="close" id="close">取消</button>
		</div>
	</div>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<!--/_footer /作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
layui.use(['form','layer','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
		
    var match = /^((ht|f)tps?):\/\/[\w\-]+(\.[\w\-]+)+([\w\-\.,@?^=%&:\/~\+#]*[\w\-\@?^=%&\/~\+#])?$/;
  //自定义验证规则
    form.verify({
       urlVerify: function(val){
    	   if(val != ''){
    		   if(!match.test(val)){
    			   return "不是正确的链接";
    		   }
    	   }
       }
    });
    form.on("submit(save)",function(data){
    	if($("#pictureId").val() == ""){
            layer.msg('您还没有上传图片');
        }else {
        	$.ajax({
	            url:"<%=request.getContextPath() %>/banner/addInfo.do",
	            data:$("#newForm").serialize(),
	            type:"POST",
	            success:function(msg){
	                if(msg.success == 1){
	                	layer.msg('保存成功', {icon: 1});
	                	setTimeout(function(){
	    					close();
	    				},700);
	                }else if(msg.success == 0){
	                	top.layer.msg(msg.data, {icon: 1});
	    				setTimeout(function(){
	    					close();
	    				},1000);
	                }
	            }
	        });
        }
       return false;
    });
    
    var upload = layui.upload;
    var uploadInst = upload.render({
        elem: '#test1' //绑定元素
        ,url: '<%=request.getContextPath() %>/attach/uploadLegal.do' //上传接口
        ,data:{
        	projectName:"publish"
        }
    	,auto:true
    	,field:"file"
    	,accept:"images"
    	,acceptMime:'image/*'
   		,before: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
  			//加载层-风格4
  			layer.msg('上传中', {
  			  icon: 16
  			  ,shade: 0.5
  			});
  		}
        ,done: function(res){
        	layer.closeAll(); //关闭loading
          //上传完毕回调
        	var resultMap = res.data;
          	if(res.code == 1){
          		$("#iconImg").show();
	        	$("#iconImg").attr("src", resultMap.absolutePath);
	        	
	        	$("#pictureId").val(resultMap.id);
	        	$("#file_id").val(resultMap.id);
	        	$("#file_resultPath").val(resultMap.resultPath);
	        	$("#file_realFileName").val(resultMap.realFileName);
	        	$("#file_isjunk").val(resultMap.isjunk);
	        	$("#file_size").val(resultMap.size);
	        	$("#file_absolutePath").val(resultMap.absolutePath);
	        	$("#file_typeCode").val(resultMap.typeCode);
          	}
       		layer.msg(res.msg);
        	
        	/* $("#id").val(resultMap.id);
        	$("#resultPath").val(resultMap.resultPath);
        	$("#realFileName").val(resultMap.realFileName);
        	$("#isjunk").val(resultMap.isjunk);
        	$("#size").val(resultMap.size);
        	$("#typeCode").val(resultMap.typeCode); */
        }
        ,error: function(){
          //请求异常回调
        }
      });
    
  //删除服务器上的文件
	function cancelFile(resultPath) {
		$.ajax({
			type:"post",
			url:'<%=request.getContextPath() %>/attach/cancelFile.do',
			data:{"resultPath":resultPath},
			success:function(result) {
				//删除成功
			}
		})
	}
})

//关闭
$("#close").click(function(){
	close();
});

function close(){
	var index=parent.layui.layer.getFrameIndex(window.name);
	parent.layui.layer.close(index);
}
</script>
</body>
</html>