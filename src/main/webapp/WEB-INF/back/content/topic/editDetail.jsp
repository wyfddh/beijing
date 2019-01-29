<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all">
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/Tags/js/jquery-2.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/Tags/js/tag.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Tags/css/tag.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<style>
    .icon{
    position:relative;
    float:right;
    }
</style>
<body>

<form class="layui-form" action="" id="layerDemo">
   <div style="position: relative">
    <div class="col-md-6" style="display:inline;">
    <div class="layui-form-item">
        <label class="layui-form-label">专题名称</label>
        <div class="layui-input-inline">
            <input type="hidden" name="id" id="id">
            <input type="text" name="name" id="name" required   placeholder="请输入专题名称" autocomplete="off" class="layui-input">
        </div>       
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">标签</label>
        <div class="layui-input-block">
            <input type="text" id="tagValue" class="layui-input">
            <i class="Hui-iconfont" style="font-size:22px;height:40px;line-height:40px;margin:5px;" id="addLabel">&#xe610;</i>
             <input type="hidden" name="label" id="label">
        </div>    
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">展览展厅</label>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" name="exhibitionHall" id="exhibitionHall">
        </div> 
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">展期</label>   
        <div class="layui-input-inline" style="width: 150px;">
	      <input type="text" class="layui-input" id="startTime" name="fristTime">
	    </div>
	    <div class="layui-form-mid">-</div>
	    <div class="layui-input-inline" style="width: 150px;">
	      <input type="text" class="layui-input" id="endTime" name="sencondTime">
	    </div> 
    </div>  
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">介绍</label>
        <div class="layui-input-inline">
            <textarea placeholder="请输入内容" class="layui-textarea" style="width:300px;height:200px;" id="introduction" name="introduction"></textarea>
        </div>
    </div>
    <input type="hidden" lay-submit lay-filter="formDemo">
    <div class="layui-form-item">
	    <div class="layui-input-block">
	      <button class="layui-btn" lay-filter="save" id="save">确定</button>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    </div>
    </div>
    </div>
	<div class="icon col-md-6" style="position:absolute;top:5px;right:5px;">
	      <span id="iconspan">
	           <img src=""  id="icon" onerror="Javascript:this.src='<%=request.getContextPath() %>/back/images/7259105_164349794186_2.jpg' " width="200px" height="200px">
	           <div style="position:absolute;width:100px;height:20px;z-indent:2;left:50px;bottom:30px;font-size:18px;">
			             编辑封面
			    </div>
	           <input type="hidden" class="layui-input" name="iconUrl" id="iconUrl">
	      </span>
	 </div>
    </div>
</form>
<script src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script>
var tag = new Tag("tagValue");   
layui.use(['laydate', 'layedit','layer','form'], function(){
        var form = layui.form;
        var layedit = layui.layedit;
        var laydate = layui.laydate;
        var layer = parent.layer === undefined ? layui.layer : top.layer;
        
        //监听提交
        form.on('submit(layerDemo)', function(data){
            return false;
        });
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#startTime' //指定元素
        });
        laydate.render({
            elem: '#endTime' //指定元素
          });
        var pathName=window.document.location.pathname;
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
        $("#save").click(function(){
        	var data = $("#layerDemo").serialize();
            $.ajax({
                type:"post",
                data:data,
                url:projectName + '/topic/editTopic.do', 
                success:function(result) {
                	var index = parent.layer.getFrameIndex(window.name);
                    if (result.success == 1) {
                        top.layer.msg("修改成功！");
                        parent.layer.close(index);
                        
                    } else {
                        top.layer.msg("系统异常修改失败！");
                        parent.layer.close(index);
                    }
                } 
            });
           return false; 
        });
        
        $("#iconspan").click(function(){        	
        	layui.layer.open({
                type: 2
                ,id: 'iconDemo' //防止重复弹出
                ,content: ['<%=request.getContextPath() %>/cropper/newCropMuseum.html','yes']
                ,area: ['900px', '700px']
                ,shade: 0 //不显示遮罩
                ,success: function(layero, index){
                    
                }
            });	
        })
        
    });
    function child(data){
     var json = data;
     $("#id").val(json.topicId);
     $("#name").val(json.name);
     $("#label").val(json.label);        
     tag.tagValue = json.label;
     tag.initView();
     $("#exhibitionHall").val(json.exhibitionHall);
     var introduction = json.introduction.trim()
     $("#introduction").val(introduction);  
     $("#icon").attr("src",json.iconUrl);   
     $("#iconUrl").val(json.iconUrl);
     var startTime = json.startTime.split('/').join('-'); 
     var endTime = json.endTime.split('/').join('-');
     $("#startTime").val(startTime);
     $("#endTime").val(endTime); 
 }

    function update(url,id){
        $("#icon").attr("src",url);
        $("#iconUrl").val(url);
    }
    
    
</script>
</body>
</html>