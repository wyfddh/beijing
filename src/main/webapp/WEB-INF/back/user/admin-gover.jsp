<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico">
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
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
    
    <style>
        .pad{
            padding-bottom: 20px;
        }
    </style>
    <title>管理员帐户管理</title>

</head>
<body>
<div id="header"></div>
<aside class="Hui-aside" id="aside" style="height: 100%;background: #72CDAE;position: fixed"></aside>
<div class="dislpayArrow hidden-xs">
    <a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<%@ include file="../main.jsp"%>
<section class="Hui-article-box section_box">
    <nav class="breadcrumb">
        <i class="Hui-iconfont">&#xe67f;</i> 首页<span class="c-gray en">&gt;</span>管理员账号管理<span class="c-gray en">&gt;</span>文章列表<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
    </nav>
   <form  method="get" action="<%=request.getContextPath() %>/admin/user/list.do">
    <div class="pd-20 Hui-article" style="margin-top: 30px;">
        <div class="row cl col-sm-12 col-xs-12 col-md-4 pad">
            注册时间：</div>
            <div class="row cl col-sm-8 col-xs-8 col-md-8" id="dis">
                <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${uqd.startCreateTime}" name="startCreateTime"  id="startCreateTime" class="input-text Wdate" style="width:120px;">
                至
                <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd '})" id="endCreateTime" value="${uqd.endCreateTime}" name="endCreateTime" class="input-text Wdate" style="width:120px;">
            </div>
        </div>
        <div class="row cl col-sm-12 col-xs-12 col-md-4 pad">
            <div class="row cl col-sm4 col-xs-4 col-md-4 text-r">姓名：</div>
            <div class="row cl col-sm-8 col-xs-8 col-md-8">
               <input type="text" class="input-text" id="trueName" name="trueName" value="${uqd.trueName}" style="width: 200px;">
            </div>
        </div>
        <div class="row cl col-sm-12 col-xs-12 col-md-4 pad">
            <div class="row cl col-sm4 col-xs-4 col-md-4 text-r">工作单位：</div>
            <div class="row cl col-sm-8 col-xs-8 col-md-8">                  
                <input type="text" class="input-text" name="deptName" id="deptName" value="${uqd.deptName}"  style="width: 200px;">
            </div>
        </div>
        <div class="row cl col-sm-12 col-xs-12 col-md-4 pad">
            <div class="row cl col-sm-4 col-xs-4 col-md-4 text-r">最后登录时间：</div>
            <div class="row cl col-sm-8 col-xs-8 col-md-8" id="dis2">
                <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="startLoginTime" value="${uqd.startLoginTime}" name="startLoginTime" class="input-text Wdate" style="width:120px;">
                至
                <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  id="endLoginTime" value="${uqd.endLoginTime}" name="endLoginTime" class="input-text Wdate" style="width:120px;">
            </div>
        </div>
        <div class="row cl col-sm-12 col-xs-12 col-md-4 pad">
            <div class="row cl col-sm4 col-xs-4 col-md-4 text-r">手机号码：</div>
            <div class="row cl col-sm-8 col-xs-8 col-md-8">                  
                <input type="text" class="input-text" name="phone" id="phone" value="${uqd.phone}"  style="width: 200px;">
            </div>
        </div>
        <div style="clear: both"></div>
        <div class="cl pd-5 mt-20" >
            <div class="row cl col-xs-12 col-sm-6 pb-20">
                <input type="submit" class="btn btn-primary size-xl" style="margin-right: 30px;margin-left: 30px;" value="搜索"/>
                <input id="clear" type="reset" class="btn btn-danger size-xl pl-30" onclick="clear();" value="重置"/>
            </div>
            <div class="row cl col-xs-12 col-sm-6 pb-20">
                <a href="<%=request.getContextPath() %>/admin/user/goAdd.do" class="btn btn-success radius" style="margin-right: 30px;margin-left: 30px;">添加管理员</a>     
            </div>
        </div>
        
        <div class="mt-20">
            <table class="table table-border table-bordered table-bg table-hover table-sort">
                <thead>
                <tr class="text-c">
                    <th width="25"><input type="checkbox" name="" value=""></th>
                    <th width="80">序号</th>
                    <th width="80">用户姓名</th>
                    <th width="80">手机号</th>
                    <th width="100">工作单位</th>
                    <th width="150">注册时间</th>
                    <th width="150">最后登录时间</th>
                    <th width="150">操作</th>
                </tr>
                </thead>
                <tbody>
             
               <c:forEach items="${userList}" var="u" varStatus="sta">
                <tr class="text-c">
                    <td><input type="checkbox" value="${u.id}" name="id"></td>
                    <td>${sta.index+1}</td>
                    <td>${u.trueName}</td>
                    <td>${u.phone}</td>
                    <c:forEach items="${orgs}" var="o">
                       <c:if test="${u.deptId eq o.id}">
                        <td>${o.name}</td>
                       </c:if>
                    </c:forEach>
                    <td>${u.createTime}</td>
                    <td>${u.loginTime}</td>
                    <td class="f-14 td-manage">
                        <a style="text-decoration:none" class="btn btn-secondary size-MINI" onClick="article_stop(this,'10001')" href="javascript:;" title="下架">编辑</a>  
                        <a style="text-decoration:none" class="btn btn-success size-MINI" href="javascript:deleteone(${u.id})" title="删除">删除</a>
                         <a class="btn btn-secondary size-MINI" href="javascript:resetPwd(${u.id})">重置密码</a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
          </div>
          <div id="page" align="center"></div>
    </div>
   </form>
</section>

	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
function clear(){
	location.href="<%=request.getContextPath()%>/admin/user/list.do";
}

//确认删除吗
function deleteone(id){
     if(confirm("确定删除吗?")){
	    	$.ajax({
	    		url:"<%=request.getContextPath()%>/admin/user/deleteAdmin.do",
	    		type:"post",
	    		data:{id:id},
	    		async:false,
	    		dataType:"text",
	    		success : function(data){
	    			window.location.href = '<%=request.getContextPath()%>/admin/user/list.do';
	    		}, 
	    		error : function(){
	    			alert("删除失败，请联系xxx");
	    		}
	    	})
	    }
  }


//确认重置密码吗
function resetPwd(id){
if(confirm("确定重置密码吗?")){
	$.ajax({
		url:"<%=request.getContextPath() %>/admin/user/resetPwd.do",
		type:"post",
		data:{id:id},
		async:false,
		dataType:"text",
		success : function(data){
			window.location.href = '<%=request.getContextPath()%>/admin/user/list.do';
		}, 
		error : function(){
			alert("重置失败，请联系xxx");
		}
	});
  }
}
//自动补全
$(function(){ 
      $("#deptName").blur(function(){

     deptName=$(this).val();
	// 	发送Ajax
	alert(1);
	$.ajax({
		url : "<%=request.getContextPath() %>/admin/user/outoFill.do", //发送地址
		type : "post",//发送的方式
		data : {deptName:deptName}, //发送的数据
		async:false,
		dataType : "json", //数据类型
		success : function(result) { 	  
	        eval("res="+result);  
	        var str="";
	        for(var i=0;i<res.length;i++){
	           str=str+"<div onclick='dian(this);'>"+res[i].name+"</div>";
	        }
	        $("#showDiv").style.display="block";
	        $("#showDiv").innerHTML=str;			
			},	
		});
     });
})
    //自动补全选定填充
   function dian(obj){
	   var str=obj.innerHTML;
	   $("#deptName").value=str;
	   $("#showDiv").style.display="none";
    }

</script>
<script type="text/javascript">
    $("#header").load("headerServe.html");
    $("#aside").load("aside-all.html");
    $('.table-sort').dataTable({
        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
        "bStateSave": true,//状态保存
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable":false,"aTargets":[0,8]}// 不参与排序的列
        ]
    });
</script>

<!-- 分页功能 -->
	<script type="text/javascript">
		var nums = ${page.size}; //每页出现的数量
		var pages = ${page.totalPage}; //得到总页数
		//调用分页
		laypage({
		    cont: 'page',
		    pages: pages,
		    curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
		        var page = location.search.match(/page=(\d+)/);
		        return page ? page[1] : 1;
		    	}(), 
		   	skip: true, //是否开启跳页
		   	skin: '#72CDAE', //皮肤
		   	groups: 3, //连续显示分页数
		    jump: function(e, first){ //触发分页后的回调
		       if(!first){ //一定要加此判断，否则初始时会无限刷新
		         location.href = '?page='+e.curr+'&'+$('form').serialize();
		       }
		    }
		})
	</script>
</body>
</html>
