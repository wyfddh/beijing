<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/public/public.css" media="all" />
    <title>基本信息</title>
	<style>
        .a1{
            width: 150px;
        }
		.inputHead{
			width: 290px;
		}
		
    </style>
</head>
<body class="childrenBody">
<form class="layui-form">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form" id="formSearch" method="post"> 
        	<input type="hidden" id="geography" name="geography" value="">
			<input type="hidden" id="level" name="level" value="${level}"/>
	        <input type="hidden" name="orgId" id="orgId" value="${orgId}">
	        <input type="hidden"  id="totalStatus" value="${totalStatus}">
            <div class="layui-inline">
            	<c:if test="${level == 1}" >
		        	<button class="layui-btn addNews_btn" type="button"  id="addUser">添加</button>
		        </c:if>
		        <button id="btn_back" type="button" class="layui-btn">返回</button>
            </div>
        </form>
    </blockquote>
    <table id="userList" lay-filter="userList"></table>
        <!--操作-->
        
    <script type="text/html" id="userListBar">
		<a class="layui-btn layui-btn-xs" lay-event="show">查看</a>
		<c:if test="${level == 1}" >
  			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</c:if>
	</script>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript">

layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;
    

    var pathName=window.document.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 

    //用户列表
    var tableIns = table.render({
        elem: '#userList',
        url : projectName + '/relicsBureau/getListData.do?relicsBureauId=${orgId}', 
        cellMinWidth : 95,
        id : "userListTable",
        cols : [[
            {type:"numbers",title: '序号', width:70, align:"center"},
            {field: 'detailName', title: '姓名', width:100, align:"left"},
            {field: 'sex', title: '性别', width:70, align:'left', templet:function(d){
            	if(d.sex == '0'){
            		return '女';
            	}else if(d.sex == '1'){
            		return '男';
            	}else{
            		return '-';
            	}
            }},
            {field: 'technicalTitle', title: '职称', align:'left',width:150, templet:function(d){
            	if(d.technicalTitle == '0'){
            		return '高级职称';
            	}else if(d.technicalTitle == '1'){
            		return '高级职称';
            	}else if(d.technicalTitle == '2'){
            		return '高级职称';
            	}else if(d.technicalTitle == '3'){
            		return '其他';
            	}else{
            		return '-';
            	}
            }},
            {field: 'repairSpecialty', title: '修复专长', align:'left',minWidth:100, templet:function(d){
            	var repairs = d.repairSpecialty.split(",");
            	var html = "";
            	for(var i=0; i<repairs.length; i++){
            		html+='<button class="layui-btn layui-btn-xs" style="background-color: #3f9bfe;border-radius: 10px;">'+ repairs[i] +'</button>'
            	}
            	if(html == ""){
            		html = "-";
            	}
            	return html;
            }},
            {field: 'spareData3', title: '联系方式', align:'left',width:200},
            {field: 'spareData1', title: '用工形式', align:'left',width:100, templet:function(d){
            	if(d.spareData1 == '0'){
            		return '正式';
            	}else if(d.spareData1 == '1'){
            		return '聘用';
            	}else{
            		return '-';
            	}
            }},
            {field: 'spareData2', title: '是否为单位申请资质时的修复技术人员', align:'left',width:250, templet:function(d){
            	if(d.spareData2 == '0'){
            		return '否';
            	}else if(d.spareData2 == '1'){
            		return '是';
            	}else{
            		return '-';
            	}
            }},
            {title: '操作', width:200, toolbar:'#userListBar',align:"center",fixed:'right'}
        ]],
        done:function(){
        	
        }
    });

    //添加用户
    function addUser(ids, opt){
    	var tit;
    	var id = "";
    	if (opt == 'edit') {
    		tit = "编辑人员信息";
    		id = ids;
    	} else if (opt == 'show') {
    		tit = "查看人员信息";
    		id = ids;
    	} else {
    		tit = "添加人员信息";
    	}
        var index = layui.layer.open({
            title : tit,
            type : 2,
            area: ['80%', '700px'],
            content : [projectName + '/relicsBureau/goAdd.do?relicsBureauId=${orgId}&editId='+id+'&opt='+opt,'no'],
            success : function(layero, index){
            	resizeLayer(index);
            },
            end :function() {
            	tableIns.reload();
            }
        })
        layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
    }
    $(".addNews_btn").click(function(){
        addUser();
    })

    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addUser(data.id, "edit");
        }else if(layEvent === 'show'){ //查看
            addUser(data.id, "show");
        }else if(layEvent === 'del'){ //删除
            layer.confirm('确认删除该记录？',{icon:3, title:'提示信息'},function(index){
                 $.get(projectName + '/relicsBureau/deleteDetail.do',{
                	 id : data.id
                 },function(result){
                	if (result.success == 1) {
                		top.layer.msg("删除成功！");
                	} else {
                		top.layer.msg("系统异常删除失败");
                	}
                    tableIns.reload();
                    layer.close(index);
                 })
            });
        }
    });

})


//返回校验
$("#btn_back").click(function(){
	var orgId = $("#orgId").val();
    window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+orgId;
});


</script>
</body>
</html>