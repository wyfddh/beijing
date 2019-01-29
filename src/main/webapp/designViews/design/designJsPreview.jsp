<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<!DOCTYPE html >
<html >
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<t:base type="jquery,easyui,DatePicker,layer"></t:base>
<!-- 表单验证插件 -->
<link rel="stylesheet" href="designPlug-in/Validform/css/style.css"	type="text/css" media="all" />

<!-- js编辑插件 -->
<link rel="stylesheet" href="designPlug-in/codemirror/codemirror.css">
<script src="designPlug-in/codemirror/codemirror.js"></script>
<script src="designPlug-in/codemirror/xml.js" type="text/javascript"></script>
<script src="designPlug-in/codemirror/codemirror.js"></script>

</head>
<body>
	<textarea class="layui-border-box site-demo-text site-demo-code" id="LAY_democode" spellcheck="false" readonly="readonly">
	${jsHtml }
	</textarea>
</body>
</html>


<script type="text/javascript">
$(function() {
	parent.$("#js_preview").height($("body").height());
});
var editor = CodeMirror.fromTextArea(document.getElementById("LAY_democode"), {
    lineNumbers: true,
    mode: "text/xml",
    matchBrackets: true,
    lineWrapping: true
  });
</script>





	