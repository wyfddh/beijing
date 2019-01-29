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
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../../../back/lib/html5shiv.js"></script>
    <script type="text/javascript" src="../../../back/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/header.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/headUserGover.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/asideUserGover.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <!--/meta 作为公共模版分离出去-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <style type="text/css">
        a:hover{
            text-decoration: none;
        }
        .check-box, .radio-box{
            padding-left: 0;
        }
        .layui-layer-page .layui-layer-content{
            overflow-x: hidden!important;
        }
    </style>
    <title>系统设置博物馆转移藏品页面</title>
</head>
<body onselectstart="return false" style="-moz-user-select:none;">
<!--_heade 作为公共模版分离出去-->
<%@ include file="head.jsp"%>
<!--aside 作为公共模版分离出去-->
<%@ include file="aside.jsp"%>
<!-- <header id="head"></header>
<aside id="manaside"></aside> -->
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section  class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 系统设置 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="Hui-article">
        <form action="<%=request.getContextPath()%>/collectionTransfer/getOrganization.do" class="cl pd-20">
            <div class="row cl mt-30 ml-10">
                <div class="f-l mt-5"><span class="c-red"></span>名称:</div>
                <div class="col-xs-4">
                <input class="input-text" type="text" placeholder="输入博物馆名称" name="name" id="name" value="${name }"></div>
            </div>
            <div class="pl-30 mt-20 ml-20">
                <div class="col-xs-5 pl-30 ml-30">
                    <button class="btn btn-primary ml-5" type="submit"><i class="Hui-iconfont">&#xe709;&nbsp;</i>搜索</button>
                    <button class="btn btn-danger" name="reset" type="reset"><i class="Hui-iconfont">&#xe68f;&nbsp;</i>重置</button>
                </div>
                <div style="clear: both"></div>
            </div>
            <c:if test="${ not empty name }">
            <div class="mt-20">
                <table class="table table-border table-bordered table-bg table-hover table-sort">
                    <thead>
                    <tr class="text-c">
                        <th width="40"></th>
                        <th width="80">序号</th>
                        <th width="300">待转移博古馆</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${waitTransfer}" var="org1" varStatus="status">
                    <tr class="text-c">
                        <td><input name="org1id" type="radio" value="${org1.id}"></td>
                        <td>${status.index + 1}</td>
                        <td>${org1.name}</td>
                    </tr>
                    </c:forEach> 
                    </tbody>
                </table>
                <table class="table table-border table-bordered table-bg table-hover table-sort mt-20">
                    <thead>
                    <tr class="text-c">
                        <th width="40"></th>
                        <th width="80">序号</th>
                        <th width="300">转移至博古馆</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${transfer}" var="org2" varStatus="status">
                    <tr class="text-c">
                        <td><input name="org2id" type="radio"  value="${org2.id}"></td>
                        <td>${status.index + 1}</td>
                        <td>${org2.name}</td>
                    </tr>
                    </c:forEach> 
                    </tbody>
                </table>
            </div>
           
			<div class="pl-30 mt-20 ml-20">
                <div class="col-xs-5 pl-30 ml-30">
                    <button class="btn btn-primary ml-5" type="button" onclick="transferInfo()"><i class="Hui-iconfont">&#xe709;&nbsp;</i>转移</button>
                </div>
            </div>
             </c:if>
        </form>
    </div>
    <div>
    </div>
</section>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    //详情
    function transferInfo() {
    	var org1id = $("input:radio[name='org1id']:checked").val();
		var org2id = $('input:radio[name="org2id"]:checked').val();
    	if(org1id == undefined){
    		layer.msg('至少选择一个待转移博物馆！', {icon: 2});
    	}
    	else if(org2id == undefined){
    		layer.msg('至少选择一个转移至博物馆！', {icon: 2});
    	}
    	else{
		layer.confirm('确定转移此藏品？', {
			  btn: ['确定','再想想'] //按钮
			}, function(){
				$.ajax({
					url : "<%=request.getContextPath()%>/collectionTransfer/updateInfo.do",
					type : "post",
					data :  { org1Id:org1id,
						      org2Id:org2id},
					async: false,  
		          	cache: false,  
		          	dataType: 'json',
					success : function(data){
						if(data.error != 1){
							layer.msg('成功转移', {icon: 1});
							setTimeout(function(){
								window.location.href = window.location.href;
							},1000)
						}else{
							layer.msg(data.message, {icon: 21});
						}
					},
					error : function(data){
						layer.msg(data.message, {icon: 2});
						setTimeout(function(){
							window.location.href = window.location.href;
						},3000) 
					} 
				})
			}, function(){
			  layer.msg('已取消转移', {
			  });	
			});
    	}
	};
</script>
</body>
</html>