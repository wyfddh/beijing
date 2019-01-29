<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <script type="text/javascript" src="../../../../back/lib/html5shiv.js"></script>
    <script type="text/javascript" src="../../../../back/lib/respond.min.js"></script>
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
        .huodong{
				padding: 30px;
			}
        tbody .text-c{
				border-bottom: 1px solid #DDDDDD;
			}
			thead>tr{
				background: #F1F2F7!important;
				height: 60px!important;
				border-radius: 7px!important;
			}
			thead>tr>th{
				color: #666666!important;
			}
			.userguanli{
				border: 1px solid #2A9BCF;
				padding: 5px 10px;
				color: #2A9BCF;
				border-radius: 5px;
			}
			.userguanli:hover{
				color: #2A9BCF;
			}
			.info .star{
				margin-top: 20px;
			}
			.td-manage a{
				color:#2A9BCF;
				margin-right: 10px;
			}
			.td-manage a:hover{
				color: #2c84ad;
			}
			
		/*弹出窗样式*/	
		.layui-layer-border{
            border:none!important;
            box-shadow:none!important;
            border-radius:5px!important;
            overflow:hidden!important;
        }
        .layui-layer-title{
            height:75px!important;
            line-height:70px!important;
            border-bottom:5px solid #f1f2f7!important;
            box-sizing:border-box;
            background:#fff!important;
            font-size: 18px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
            font-weight: bold;
        }
        .layui-layer-setwin{
            top:30px!important;
        }
        
    </style>
    <title>角色管理</title>
</head>
<body>
<header id="head"></header>
<!--_header 作为公共模版分离出去-->
 <%@ include file="../weihuNav.jsp"%> 
<!--_menu 左边slide导航开始-->
 <%@ include file="../../content/aside.jsp" %>
<section  class="Hui-article-box">
    <div class="Hui-article">
       	<div class="info">
	        <form action="<%=request.getContextPath()%>/role/info.do" method="post" class="huodong" id="roleForm">
        		<div class="guanjianci">
					登录账户：&nbsp;
					<input type="text" name="roleName" value="${example.roleName}" style="width:190px;height:26px;padding-left: 10px;" class="input-text">
				</div>
	        	<div class="star" style="display:block;width:100%;">
					<button class="btn b1" type="submit"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
					<button class="btn b1" type="submit"><img src="<%=request.getContextPath() %>/back/images/jiajia.png" alt="" />添加角色</button>
				</div>
	        </form>
       	</div>
            <div>
                <table class="table">
                    <thead>
                    <tr class="text-c">
                        <th width="80">序号</th>
                        <th width="300">角色名称</th>
<!--                         <th width="150">创建人</th> -->
                        <th width="300">创建时间</th>
                        <th width="300">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${roles}" var="r" varStatus="sta">  
                    <tr class="text-c">
                        <td>${sta.index+1}</td>
                        <td>${r.roleName}</td>
<%--                         <td>${r.creatorId}</td> --%>
                        <td>${r.createTime}</td>
                        <td class="td-manage">
<%--                             <a style="text-decoration:none" class="userguanli"  href="javascript:edit('${r.id}', '${r.roleName}');" title="人员管理">人员管理</a> --%>
                            <a style="text-decoration:none;"  href="javascript:edit1('${r.id}', '${r.roleName}');" title="编辑权限">编辑权限</a>
                            <a style="text-decoration:none;"  href="javascript:deleteRole('${r.id}');" title="删除">删除</a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <br>
					<div id="page" align="center"></div>
            </div>
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
	$(function(){
		var level = ${level};
		if (level == 2) { 
			$(".fabu-aside>ul>li").eq(2).addClass("weihu");
		} else {
			$(".fabu-aside>ul>li").eq(3).addClass("weihu");
		}
		$(".headerNav a.jueseguanli").addClass("active");
		$(".headerNav a.jueseguanli").find("img").attr("src",'<%=request.getContextPath() %>/back/images/jueseicon.png');
	})
    function edit(value, name){
        layer.open({
            type: 2,
            title: '人员管理-'+name,
            shadeClose: true,
            shade: 0.5,
            maxmin: true, //开启最大化最小化按钮
            area: ['880px', '600px'],
            content: ['<%=request.getContextPath() %>/role/userManage.do?areap=null&unitp=null&keywordp=null&roleGrade='+value,'yes']
        });
    }
	function deleteRole(id){
		layer.confirm("确认要删除吗，删除后不能恢复", { title: "删除确认" }, function (index) {
            layer.close(index);
            $.post("<%=request.getContextPath() %>/role/deleteRole.do", { roleId: id }, function (data) {
                if(data.success == 1){
                	layer.msg('删除成功');
                }else if(data.success == 0){
                	layer.msg(data.data);
                }
            }); 
        });
	}
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
		         location.href = '?page='+e.curr+'&'+$('form').serialize() ;
		       }
		    }
		})
	</script>
</body>
</html>