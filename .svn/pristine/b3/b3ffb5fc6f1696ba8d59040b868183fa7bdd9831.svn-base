<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/echarts/echarts.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/report/report.js"></script>
<style>
    
    .count_td{
        border-top:#cccccc solid 2px;
        border-bottom:#cccccc solid 2px;
        border-left:#cccccc solid 2px;
        border-right:#cccccc solid 2px;
        font-size:30px;
    }
    .report_td{
        width:500px;
        border-top:#cccccc solid 1px;
        border-bottom:#cccccc solid 1px;
        border-left:#cccccc solid 1px;
        border-right:#cccccc solid 1px;
    }
    .report_chat{
        width:100%;
        height:300px;
    }
</style>
<title>藏品统计</title>
</head>
<body>
<div id="top" class="top">
	<table>
	<tr>
	    <td>
	                      藏品数查询:
	    </td>
	    <td>
	        <select name="area">
			    <option value="volvo">Volvo</option>
			    <option value="saab">Saab</option>
			    <option value="fiat">Fiat</option>
			    <option value="audi">Audi</option>
			</select>   
	    </td>
	    <td>
	        <select name="museum">
			    <option value="volvo">Volvo</option>
			    <option value="saab">Saab</option>
			    <option value="fiat">Fiat</option>
			    <option value="audi">Audi</option>
			</select>
	    </td>
	    <td>
	        <table>
	            <tr id = "count">
	                
	            </tr>
	        </table>
	    </td>
	</tr>
	</table>
</div>
<HR>
<div id="report">
       <table>
            <tr>
                <td class="report_td">
                     <p class="all_count" type="collectionLevel">全省</p>
                     <p class="my_count" type="collectionLevel">本馆</p>
                     <div id="collectionLevel" class="report_chat">
                        
                     </div>
                </td>
                <td class="report_td">
                     <p class="all_count" type="collectionArea">全省</p>
                     <p class="my_count" type="collectionArea">本馆</p>
                     <div id="collectionArea" class="report_chat">
                        
                     </div>
                </td>
            </tr>
            <tr>
                <td class="report_td">
                     <p class="all_count" type="collectionYear">全省</p>
                     <p class="my_count" type="collectionYear">本馆</p>
                     <div id="collectionYear" class="report_chat">
                        
                     </div>
                </td>
                <td class="report_td">
                     <p class="all_count" type="collectionDisability">全省</p>
                     <p class="my_count" type="collectionDisability">本馆</p>
                     <div id="collectionDisability" class="report_chat">
                        
                     </div>
                </td>
            </tr>
            <tr>
                <td class="report_td" colspan="2">
                     <p class="all_count" type="collectionCatalog">全省</p>
                     <p class="my_count" type="collectionCatalog">本馆</p>
                     <div id="collectionCatalog" class="report_chat">
                        
                     </div>
                </td>
            </tr>
            <tr>
                <td class="report_td" colspan="2">
                     <p class="all_count" type="collectionTexture">全省</p>
                     <p class="my_count" type="collectionTexture">本馆</p>
                     <div id="collectionTexture" class="report_chat">
                        
                     </div>
                </td>
            </tr>
            <tr>
                <td class="report_td" colspan="2">
                     <div id="museumTop10" class="report_chat">
                        
                     </div>
                </td>
            </tr>
       </table> 
</div>
<script type="text/javascript">
   var unitId = "683";
   init();
   function init(){
	   //设置统计数
	   var str = "13954";
	   var length = str.length;
	   var html = "";
	   if(length > 0){
		   for (var i = 0; i < length; i++) {
			   var number = str.substr(i,1);
			   html = html + "<td class='count_td'>"+number+"</td>";
		   }
	   }
	   else{
		   html = "<td class='count'>"+"0"+"</td>";
	   }
	   $("#count").html(html);
	   
	   //加载报表
	   setReport("collectionLevel",null)
       
	}	
   
   //设置报表
   function setReport(divName,tab){
	   var title = "";
	   var sql = "";
	   var type = "line";
	   var tableData = [];
	   switch(divName){
	    case "collectionLevel":
	    	title="文物级别统计";
	    	sql = "select l.name as name,count(1) as count from mip_open_culturalrelic_info m "+
	    		"left JOIN mip_collection_level l on (m.collection_level = l.id and l.status = 1 ) "+
	    	"GROUP BY name";
	    	if(null != tab){
	    		sql = "select l.name as name,count(1) as count from mip_open_culturalrelic_info m "+
                "left JOIN mip_collection_level l on (m.collection_level = l.id and l.status = 1 and m.collection_unit="+
                unitId+") "+
            "GROUP BY collection_level";
	    	}
	    	type = "pie";
	    	var nameMap = {"key":"name","name":"文物级别","isValueKey":"0"};
	    	var valueMap = {"key":"count","name":"文物级别总数","isValueKey":"1"};
	    	tableData.push(nameMap);
	    	tableData.push(valueMap);
	    	break;
	    case "collectionArea":
            title="区域藏品统计表";
            sql = "select l.name as name,count(1) as count from mip_open_culturalrelic_info m "+
                "left JOIN mip_collection_level l on (m.collection_level = l.id and l.status = 1 ) "+
            "GROUP BY name";
            if(null != tab){
                sql = "select l.name as name,count(1) as count from mip_open_culturalrelic_info m "+
                "left JOIN mip_collection_level l on (m.collection_level = l.id and l.status = 1 and m.collection_unit="+
                unitId+") "+
            "GROUP BY name";
            }
            type = "pie";
            var nameMap = {"key":"name","name":"文物级别","isValueKey":"0"};
            var valueMap = {"key":"count","name":"文物级别总数","isValueKey":"1"};
            tableData.push(nameMap);
            tableData.push(valueMap);
            break;
	   }
	   myReport.getReportByType(divName,sql,title,type,tableData);	   
   }
</script>
</body>
</html>