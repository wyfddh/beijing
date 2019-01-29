<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/public/public.css" media="all" />
</head>
<body>
    <form class="layui-form" action="">
	    <div class="layui-form-item">
		    <label class="layui-form-label">字段名</label>
		    <div class="layui-input-block">
		      <input type="text" id="key" name="key"  autocomplete="off" placeholder="请输入字段名" class="layui-input">
		    </div>
	    </div>
	    <div class="layui-form-item">
            <label class="layui-form-label">字段中文名</label>
            <div class="layui-input-block">
              <input type="text" id="name" name="name"  autocomplete="off" placeholder="请输入字段中文名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
		    <label class="layui-form-label">是否作为值字段</label>
		    <div class="layui-input-block">
		      <select name="interest" id="isValueKey" lay-filter="aihao">
		        <option value="0" selected="">否</option>
		        <option value="1" >是</option>
		      </select>
		    </div>
		  </div>
        <div class="layui-form-item">
		    <div class="layui-input-block">
		      <button class="layui-btn" lay-submit="submit" lay-filter="submit">立即提交</button>
		      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		  </div>
    </form>
     <input type="hidden" id="type" value="${type}">
      <input type="hidden" id="data" value="${data}">
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
    <script type="text/javascript">
    layui.use('form', function(){
    	var form = layui.form;
    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    	 form.on('submit(submit)', function(data){
    		 var key = $("#key").val();
    		 var name = $("#name").val();
    		 var isValueKey = $("#isValueKey").val();
    		 parent.$('#key').val(key);
    		 parent.$('#name').val(name);
    		 parent.$('#isValueKey').val(isValueKey);
    		 parent.layer.close(index);
         });  
    	var type = $("#type").val();
    	if(type == "edit"){
    		var data = $("#data").val();
   
    		if(null == data){
    			return;
    		}
    		$("#key").val(data['key']);
            $("#name").val(data['name']);
            $("#isValueKey").val(data['isValueKey']);
    	}
    });
    </script>
</body>
</html>