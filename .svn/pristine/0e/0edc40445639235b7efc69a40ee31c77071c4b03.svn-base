<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/userMangermen/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/userMangermen/css/public.css" media="all" />
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
.hideInput{
	display: none;
}
.input-length{
	width:300px;
}
</style>
<title></title>
</head>
<body class="childrenBody">
	<form class="layui-form">
        <blockquote class="layui-elem-quote quoteBox">
        	<form class="layui-form"> 
	            <div class="layui-inline">
		            <div class="layui-input-inline">
		            	<input placeholder="输入机构名称/电话检索"  type="text" class="input-text layui-input input-length" id="museumName"  name="museumName">
					</div>
					 <div class="layui-input-inline"> 
						<select name="area" id="area">
					    	<option value="">选择区域</option>
						  	<c:forEach items="${areaList}" var="u">
								<option value="${u.id}">${u.name}</option>
							</c:forEach> 
						</select>
					 </div>
					 <c:if test="${sessionScope.model != 'zzOrg' && sessionScope.model != 'scOrg'}">
					 <div  class="layui-input-inline"> 
						<select name="museumType" id="museumType">
					    	<option value="">机构类型</option>
							<c:forEach items="${typeList}" var="u">
								<option value="${u.number}">${u.value}</option>
							</c:forEach> 
						</select>
					 </div>
					 </c:if>
					<button class="layui-btn search_btn" type="button">搜索</button>
	            </div>
            </form>
	     </blockquote> 
	     <table id="museumList" lay-filter="museumList"></table>
 	</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<!--请在下方写此页面业务相关的脚本-->
	<!-- 分页功能 -->
<script type="text/javascript">
layui.use(['form','layer','table'],function(){
	var form = layui.form,
    layer = parent.layer === undefined ? layui.layer : top.layer,
    $ = layui.jquery,
    table = layui.table;
	
    var tableIns = table.render({
        elem: '#museumList',
        url : '<%=request.getContextPath() %>/museuminfo/getMuseumList.do', 
        request:{
        	pageName: 'currentPage',
        	limitName: 'size'
        },
        cellMinWidth : 95,
        page : true,
        limits : [10,15,20,25],
        limit : 10,
        id : "museumListTable",
        cols : [[
            {type:"numbers",title: '序号', width:70, align:"center"},
            {field: 'museumName', title: '机构名称', align:"left",templet:function(d){
            	return '<a  style="color:#0099ff;"  href="javascript:detail(\''+d.museumId+'\');" title="查看组织资料详情">'+d.museumName+'</a>'
            }},
            {field: 'area', title: '区域', minWidth:200, align:'left'},
            {field: 'museumType', title: '机构类型', align:'left',minWidth:100},
            {field: 'phone', title: '电话', align:'left',minWidth:100},
            {field: 'allDataPer', title: '资料完整度', align:'left',minWidth:100,templet:function(d){
            	if(d.allDataPer == '1'){
            		return "已完成";
            	}else{
            		return "未完成";
            	}
            }},
            {title: '操作',align:"center",fixed: 'right',templet:function(d){
            	var html = '<a class="layui-btn layui-btn-xs"  href="javascript:detail(\''+d.museumId+'\');" title="查看详情">查看详情</a>'; 
            	return html;
            }}
        ]],
        done:function(){
        	
        }
    });
  
    $(".search_btn").on("click",function(){
    	table.reload("museumListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
            	museumName:$("#museumName").val(),
           	 	area: $("#area").val(),  
           		museumType:$("#museumType").val()		
            }
        })
   });
    
    window.detail=function(value){
    	window.location.href="<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+value;
    }
});		
</script> 
</body>
</html>