<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/echarts/echarts.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/report/report.js"></script>
<title>报表demo</title>
</head>
<body>
    <div id="demo" style="width:800px;height:400px;">
                   
     </div>
     <script type="text/javascript">
         
     var divName = "demo";
     var sql = "select name,count(case  t.status when 0 then t.type end) as a,count(case  t.status when 1 then t.type end) as b"
    	 + " from report_demo t"+
    	 " GROUP BY name" + " order by case `name` when \'周一\' then 0 when \'周二\' then 1 when \'周三\' then 2 end  asc";
     var title = "面积图demo";
     var type = "pieMult";
     var tableData = [{"key":"name","name":"时间","isValueKey":"0"},{"key":"a","name":"未完成","isValueKey":"1"},{"key":"b","name":"已完成","isValueKey":"1"}]
     myReport.getReportByType(divName,sql,title,type,tableData);   
     </script>
</body>
</html>