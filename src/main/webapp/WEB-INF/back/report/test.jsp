<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自定义报表demo</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/public/public.css" media="all" />
</head>
<body>

    <div class="layui-container">
	    <div class="layui-row">
		    <div class="col-sm-3 tree-ber-po" style="padding-left: 0; display: block;">
		    <div class="tree-ber-shou">
		        <img src="designPlug-in/ace/assets/avatars/home-images/btn_l.png" />
		    </div>
		    <div class="tree-ber" style="display: block;">
		        <div class="input-icon"style=" margin: 3px 5px;">                                                       
		            <input type='text' id='searchtree' style="width:95%;height:25px;"  />
		            <i id="iconSerch" onClick="findTree()" class="fa fa-search position-absolute" style="right: 15px;top: 5px;"></i>                        
		        </div>
		        <div id="tree2" class="ztree" style="width:100%;height:565px;overflow:auto;border:0px solid #000;padding:0px;"></div>
		        <input type="hidden" name="mainId" id="mainId" />
		    </div>
		    </div>
	    </div>
	  </div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/gov/legalAdd.js"></script>
</body>
</html>