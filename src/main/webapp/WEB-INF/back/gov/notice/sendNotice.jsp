<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
 <!DOCTYPE html>
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
    <!--/meta 作为公共模版分离出去-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <style type="text/css">  
    </style>
    <title>转发页面</title>
</head>
<body onselectstart="return false" style="-moz-user-select:none;padding:10px;">

<section  class="">
<form id="newForm" class="layui-form">
    <div class="boxSize bgWhite">
       <div class="layui-row">
			<div class="magb15 layui-col-md4 layui-col-xs12">
				<label class="layui-form-label" style="padding-left: 0;width: 95px;">转发给</label>
				<div class="layui-input-block">
					<select name="receiver" id="receiver" lay-verify="required" lay-search>
						<option value="">选择人员</option>
						<c:forEach items="${userList}" var="user" varStatus="row">
							<option value="${user.id}" >${user.userName}</option>	
						</c:forEach>
					</select>
				</div>
			</div>
		</div> 
		<div class="layui-form-item layui-row layui-col-xs12" style="margin-top:20px;">
			<div class="layui-input-block">
				<input type="hidden" id="id" value="${id}"></input>
				<button class="layui-btn layui-btn-sm" lay-submit lay-filter="confirm">确定</button>
				<button id="close" type="reset" class="layui-btn layui-btn-sm layui-btn-primary">取消</button>
			</div>
		</div>  	                     
    </div>
    </form>
</section>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/jQuery-searchableSelect/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/jQuery-searchableSelect/jquery.searchableSelect.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript">
$(function(){
	layui.use(['form','layer','table','laytpl','laydate'],function(){
	     	form = layui.form,
	        layer = parent.layer === undefined ? layui.layer : top.layer,
	        $ = layui.jquery,
	        laytpl = layui.laytpl,
	        table = layui.table,
	        laydate = layui.laydate;
	})	
	form.render('select');
	
	form.on("submit(confirm)",function(data){
		var id = $("#id").val();
		var receiver = $("#receiver").val();
		$.ajax({
			url : "<%=request.getContextPath()%>/notice/receive/changeReceiver.do?id="+id+"&receiver="+receiver,
			dataType : "json",
			async: false,
			success : function(data){
				if(data==1){
					parent.layer.closeAll();
					parent.layer.msg('转发成功', {icon: 1});
				}else{
					parent.layer.msg('转发失败', {icon: 2});
				}
			}
		})
    	return false;
    })
})
	
	//关闭
    $("#close").click(function(){
        parent.layer.closeAll();
    });

</script>
</body>
</html>