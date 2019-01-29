<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>

</head>
<body>
	<form id="inter_form">
		接口url：<input name="inter-url" id="url" style='width: 300px'/>
		eg:&nbsp;&nbsp;&nbsp;&nbsp;spreadtrum/getSpreadtrum.do
		<br/>
		请求方式：
		<input type="radio" name="inter-method" value="get"/>get
		<input type="radio" name="inter-method" value="post"/>post
		<br/>
		请求参数:
		<input type="text" name="inter_method" id="parameter" style='width: 1000px'>
		eg:&nbsp;&nbsp;&nbsp;&nbsp;id=1&name=CMQ&type=男神&...
	</form>
	
<button id="button" onclick="toMethod()">点击测试</button>
<div id="result"></div>
</body>
<script type="text/javascript">
function toMethod(){
	var requestUrl = $("#url").val();
	var methodType = $('input:radio:checked').val();
	var parameter = $("#parameter").val() 
	 $.ajax({
		url:"<%=request.getContextPath()%>/"+requestUrl,
		type:methodType,
		data:parameter,
		async:false,
		dataType:"text",
		success : function(data){
            $("#result").html(data);
			/* var result=new Array();
                for(var i in data)
                    result.push(i+"="+JSON.stringify(data[i]));
                $("#result").html(JSON.stringify(data));//result.join("<br />")); */
		}, 
		error : function(){
			alert("报错，请联系CMQ");
		}
	}) 
	
}
</script>


</html>