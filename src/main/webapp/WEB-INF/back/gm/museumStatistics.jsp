<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--  <%@ page import="com.tj720.mip.utils.HasAuth" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico">
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="back/lib/html5.js"></script>
<script type="text/javascript" src="back/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
	<link href="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
	#btn-left {
		position: absolute;
		left:29px;
		width: 100px;
	}
	#btn-right {
		position: absolute;
		right:29px;
	}
	#btn{
	
		height:31px;
		margin-bottom:10px;
		
	}
	.statistics{
		margin-left: 31px;     
	}
	.pre {
		width:45%;  
		height: 400px;          
		padding: 10px;     
		margin-top: 40px;
		position: relative;
		left: 20px;  
	  
	}  
	.Hui-article-box{
		position: absolute;
		left:0
	}

</style>  


<title>博物馆统计</title>
</head>
<body>
	<header id="head"></header>
	<%@ include file="../organization/gmheadbtn.jsp"%> 
	
	<section class="Hui-article-box" style="overflow:auto">       
		  
		<div id="btn">
			<button class="btn radius btn-primary  size-L "  id="btn-left">概况</button> 
		</div>   <br> <br> 
		          
		<div>    
			<div id="museumProperty" class="pre f-l" ></div>             
			<div id="museumRelation" class="pre f-l" ></div>       
		</div>    <br>     
		<div id="museumType" class="" style="height: 400px;  padding: 10px;"></div>   
	</section>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/echarts.common.min.js"></script>
	
	<script type="text/javascript">
		var museumPropertyCount1 = ${museumPropertyCount1 };
		var museumPropertyCount2 = ${museumPropertyCount2 };
		var museumPropertyCount3 = ${museumPropertyCount3 };
		
		var museumRelationCount1 = ${museumRelationCount1 };
		var museumRelationCount2 = ${museumRelationCount2 };
		var museumRelationCount3 = ${museumRelationCount3 };
		var museumRelationCount4 = ${museumRelationCount4 };
		
		var museumTypeCount1 = ${museumTypeCount1 };
		var museumTypeCount2 = ${museumTypeCount2 };
		var museumTypeCount3 = ${museumTypeCount3 };
		var museumTypeCount4 = ${museumTypeCount4 };
		var museumTypeCount5 = ${museumTypeCount5 };
		var museumTypeCount6 = ${museumTypeCount6 };
		var museumTypeCount7 = ${museumTypeCount7 };
		echarts.init(document.getElementById('museumProperty')).setOption({   
			title: {
				text : '博物馆类别统计',   
				x : 'center'
			},
			tooltip: {
				triggerOn:'mousemove',
				formatter:'{b}数量:&nbsp;&nbsp;&nbsp;&nbsp;{c}({d}%)'                
			}, 
	        series: {
	            type: 'pie',
	            data: [
	                {name: '国有文化、文物部门', value: museumPropertyCount1},
	                {name: '国有行业部门', value: museumPropertyCount2},
	                {name: '非国有', value: museumPropertyCount3}
	            ]
	        }
	    });  
		echarts.init(document.getElementById('museumRelation')).setOption({   
			title: {
				text : '隶属层级统计',    
				x : 'center'
			},
			tooltip: {
				triggerOn:'mousemove',
				formatter:'{b}数量:&nbsp;&nbsp;&nbsp;&nbsp;{c}({d}%)'                
			}, 
	        series: {
	            type: 'pie',
	            data: [
	                {name: '省', value: museumRelationCount1},
	                {name: '地（市、州）', value: museumRelationCount2},
	                {name: '县（区）', value: museumRelationCount3},  
	                {name: '其他（非国有博物馆选填）', value: museumRelationCount4}
	            ] 
	        }
	    }); 
		  
		echarts.init(document.getElementById('museumType')).setOption({   
			title: {
				text : '题材类型统计'
				 
			},  
			tooltip: {               
			}, 
			legend: {
                data:['数量']    
            },
			xAxis: {
	                data: ["综合地质类","考古遗址类","历史文化类","艺术类","自然类","科技类","其他类"]
	        },
	        yAxis: {
	        	  
	        },
	        series: {
	        	name: '数量',  
	        	type: 'bar',
                data: [museumTypeCount1, museumTypeCount2, museumTypeCount3, museumTypeCount4, museumTypeCount5, museumTypeCount6,museumTypeCount7]
	            
	        }
	    }); 
	
	
	
		$(document).ready(function(){
			var orgTypeId = ${orgTypeId};
			if (orgTypeId == "2") { 
				$(".fabu-aside>ul>li").eq(3).addClass("weihu");
			} else {
				$(".fabu-aside>ul>li").eq(4).addClass("weihu");
			}
			$(".headerNav a.museumStatistics").addClass("active");  
			
			
			  
		})
	</script>
	

	



		


	
		
		
		
	</script>
</body>
</html>
