<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="favicon.ico" >
    <link rel="Shortcut Icon" href="favicon.ico" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/header.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/aside.css">
    <title>人员管理</title>
</head>
<body>
<div id="header"></div>
<aside class="Hui-aside" id="aside" style="height: 100%;background: #72CDAE;position: fixed"></aside>
<div class="dislpayArrow hidden-xs">
    <a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<%@ include file="../main.jsp"%>
<section  class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 内容管理 <span class="c-gray en">&gt;</span> 文章列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="Hui-article">
        <form action="" class="cl pd-20">
            <!--组织机构和关键字输入-->
            <div class="row cl col-12 text-l pt-20">
                组织机构:
                <input type="text" class="input-text mr-50" id="goverment" name="" style="width:150px">
                关键字:
                <input type="text" class="input-text" id="keywords" name="" placeholder="账号/真实姓名" style="width:150px">
            </div>
            <!--搜索重置按钮-->
            <div class="cl pd-5 bg-1 bk-gray mt-20 text-c">
                <span class="">
                    <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius" title="搜索"><i class="Hui-iconfont">&#xe665;</i> 搜索</a>
                    <a class="btn btn-primary radius" href="javascript:;" title="重置"><i class="Hui-iconfont">&#xe66c;</i> 重置</a>
                </span>
            </div>
            <div class="row cl col-12 pt-10 text-r">
                <button class="btn btn-success radius"><i class="Hui-iconfont">&#xe600;</i>添加人员</button>
            </div>
            <div class="">
                <table class="table table-border table-bordered table-bg table-hover table-sort">
                    <thead>
                    <tr class="text-c">
                        <th width="100">序号</th>
                        <th>账号</th>
                        <th width="100">真实姓名</th>
                        <th>工作单位</th>
                        <th width="200">所属角色</th>
                        <th width="200">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="u" varStatus="sta">
                    <tr class="text-c">
                        <td>${sta.index+1}</td>
                        <td>${u.userName}</td>
                        <td>${u.trueName}</td>
                        <td class="text-l">
                          <c:forEach items="${orgs}" var="o">
                             <c:if test="${u.deptId eq o.id}">
                               ${o.name}
                             </c:if>
                          </c:forEach>
                        </td>
                        <td>${roleName}</td>
                        <td class="td-manage">
                            <a style="text-decoration:none" class="ml-5" onClick="picture_edit('图库编辑','picture-add.html','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
                            <a style="text-decoration:none" class="ml-5" onClick="picture_del(this,'10001')" href="javascript:deleteone(${u.id},${roleId});" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <!--<div id="cover">-->
                <!--<div class="top">-->
                    <!--<p style="color: #ffffff;padding-left: 20px;">添加人员</p>-->
                    <!--<div class="Hui-iconfont btn btn-danger" id="close">&#xe6a6;</div>-->
                <!--</div>-->
                <!--<div class="row cl mt-50">-->
                    <!--<input type="search" class="input-text ml-30" placeholder="账号/组织机构/真实姓名" style="width: 300px;">-->
                    <!--<a href="#" class="btn btn-primary radius">搜索</a>-->
                <!--</div>-->
                <!--<div class="table">-->
                    <!--<div class="left">-->
                        <!--<p>所有人员</p>-->
                        <!--<table class="table table-border table-bordered table-bg table-hover table-sort">-->
                            <!--<tbody>-->
                            <!--<tr class="text-c">-->
                                <!--<th width="40"><input name="" type="checkbox" value=""></th>-->
                                <!--<td>001</td>-->
                                <!--<td>分类名称</td>-->
                                <!--<td><a href="javascript:;">管理员</a></td>-->
                            <!--</tr>-->
                            <!--</tbody>-->
                        <!--</table>-->
                    <!--</div>-->
                    <!--<button class="btn badge-primary">添加</button>-->
                    <!--<div class="right"></div>-->
                <!--</div>-->

            <!--</div>-->
        </form>
    </div>
    <div>
    </div>
</section>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript">
    $("#head").load("head.html");
    $("#manaside").load("aside_roleManagement.html");
</script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript">
    function deleteone(id,roleId){
    	if(confirm("确定删除吗?")){
	    	$.ajax({
	    		url:"<%=request.getContextPath()%>/role/deleteUser.do",
	    		type:"post",
	    		data:{id:id,roleId:roleId},
	    		async:false,
	    		dataType:"json",
	    		success : function(data){
	    			window.location.href = '<%=request.getContextPath()%>/role/userManage.do?id='+roleId;
	    		}, 
	    		error : function(){
	    			alert("删除失败，请联系xxx");
	    		}
	    	})
  }
    	
    	
    }


</script>
<script type="text/javascript">
    $('.table-sort').dataTable({
        "info": false,
        "paging": true,
        "searching": false,
        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
        "stateSave": true,
        "displayStart": 1, //一开始显示第一页
        "bStateSave": true,//状态保存
        "pagingType": "full_numbers",
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable":false,"aTargets":[0,8]}// 制定列不参与排序
        ]
    });
</script>
</body>
</html>