<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <!--/meta 作为公共模版分离出去-->
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
        .int{
            height: 20px;
            border: 1px solid #DDDDDD;
        }
        #diji{
            display: none;
        }
        body{
        	background: #FFFFFF!important;
        }
        .addHuoDong{
				overflow: hidden;
				height: 72px;
				border-bottom: 1px solid #F1F2F7;
			}
			.addHuoDong>span{
				margin: 20px 32px;
				    display: block;
			}
			.addHuoDong>span>a{
				background: #2A9BCF!important;
			}
			.addHuoDong>span>a:hover{
				border-color: #2A9BCF!important;
			}
			.huodong{
				padding: 20px;
			}
			.huodong input{
				line-height: 26px;
				border-radius: 5px;
			}
			.huodong>div{
				margin: 12px 0;
			}
			.huodong .star{
				margin-top: 20px;
			}
			.huodong .star button{
				background: #2A9BCF;
				color: #fff;
				border-radius: 5px;
			}
			.huodong .star button img{
				margin-top: -3px;
			}
			.huodong .star button.b2{
				background: #fff;
				color: #2A9BCF;
				border-color: #2A9BCF;
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
    </style>
    <title>角色编辑</title>
</head>
<body>
        <form action="<%=request.getContextPath()%>/role/userManage.do" class="huodong">
        	<input type="hidden" id="roleGrade" name="roleGrade" value="<%=request.getParameter("roleGrade")%>">
            <div class="mt-30">
                <!--省级管理员-->
                <div id="shengji">
                    <div class="formControls">
                    	关键字:
                   		 <input placeholder="账户/手机号" style="width: 190px;height: 26px;padding-left: 10px;" type="text" class="int" value="${keyword2 }" name="keywordp">
                        &nbsp;&nbsp;&nbsp;
                        <span id="unit">
                        	单位:
		                    
		                    <span style="width: 114px;height: 26px;padding: 2px 5px;border-radius: 5px;" class="select-box">
	                            <select name="areap" class="select regionType"  size="1" style="width:100px;" id="diqu">
									    <option value="">地区</option>
									   <c:forEach items="${area}" var="a" varStatus="row">
											<option value="${a.id}" <c:if test="${a.id eq area2}">selected</c:if> >${a.name}</option>
										</c:forEach>
								</select>
							 </span>&nbsp;&nbsp;
							 <span style="width: 114px;height: 26px;padding: 2px 5px;border-radius: 5px;" class="select-box">
								<select name="unitp" class="select" size="1" style="width:100px;" id="danwei">
									    <option value="">单位</option>
									   <c:forEach items="${unit}" var="u" varStatus="row">
											<option value="${u.id}" <c:if test="${u.id eq unit2}">selected</c:if> >${u.name}</option>
										</c:forEach>
								</select>
							 </span>&nbsp;&nbsp;
                        </span>
                    </div>
                </div>
          <%--       <!--地级管理员-->
                <div class="formControls col-xs-5" id="diji">
                    <div class="formControls col-xs-8">
                        <span>
                            <select name="unitTypeEra" class="select" size="1" id="dijiUnit">
								    <option value="">单位</option>
								   <c:forEach items="${unit}" var="u" varStatus="row">
										<option value="${u.id}" <c:if test="${u.id eq collection.unitTypeEra}">selected</c:if> >${u.name}</option>
									</c:forEach>
								</select> 
                        </span>
                    </div>
                </div> --%>
            </div>
            <div style="clear: both"></div>
            <div class="star">
                <button class="btn b1" type="submit"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
				<button class="btn b2" type="reset"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>
            <div style="clear: both"></div>
            <div class="mt-20">
                <table class="table">
                    <thead>
                    <tr class="text-c">
                        <th width="80">序号</th>
                        <th width="300">手机号</th>
                        <th width="200">真实姓名</th>
                        <th width="300">单位</th>
                        <th width="150">所属角色</th>
                        <th width="300">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                       <c:forEach items="${userAll}" var="u" varStatus="sta">  
	                    <tr class="text-c">
	                        <td>${sta.index+1}</td>
	                        <td>${u.phone}</td>
	                        <td>${u.userName}</td>
	                         <td>${u.orgName}</td>
	                        <td>${u.roleName}</td>
	                        <td class="td-manage">
	                            <a onclick="deleteRole('${u.id}')" href="javascript:;">
	                            	<img src="<%=request.getContextPath() %>/back/images/delicon.png" alt="" />
	                            </a>
	                        </td>
	                    </tr>
	                    </c:forEach>
                    </tbody>
                </table>
                <br>
				<div id="page" align="center"></div> 
            </div>
        </form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
//    判断省级地级或者博物馆管理员
    var gover = ${level};
    function judge(){
        //    省级
        if(gover == "1"){
            $("#diqu").css({"display":"block"});
            $("#danwei").css({"display":"block"});
            return false;
        }
        //    地级
        if(gover == "2"){
            $("#diqu").css({"display":"none"});
            $("#danwei").css({"display":"block"});
            return false;
        }
        //    博物馆管理员
        if(gover == "3"){
            $("#shengji").css({"display":"none"});
            return false;
        }
    }
    judge();
</script>
<script type="text/javascript">
//二级联动
var appName = '<%=request.getContextPath() %>';
$(function(){
    $('.regionType').change(function(){
        var pid=$(this).val();
        var obj=$(this).parent().next().find('select');
        var first=obj.children().first().clone();
        $.ajax({
          	url:appName + "/role/region.do",
            data:{pid:pid},
            type:"POST",
            success:function(msg){
                obj.empty().append(first);
                var sub=obj.next('select');
                while(sub.length>0){
                	first=sub.children().first().clone();
                	sub.empty().append(first);
                    sub=sub.next('select');
                }
                for(var i in msg)
                    obj.append("<option value="+msg[i]['id']+">"+msg[i]['name']+"</option>");
            }
        });
    });
});

function deleteRole(id){
    layer.confirm('您确定要删除该条信息吗？', {
        btn: ['确定','取消'] //按钮
    }, function(index){
        //点击确定之后需要执行的函数
        		$.ajax({
				url : "<%=request.getContextPath() %>/role/deleteUser.do",
				type : "post",
				data :  {userId:id,
						roleGrade: $('#roleGrade').val()},
				async: false,
				success : function(data){
					if(data == "SUCCESS"){
						layer.alert('删除成功', {
					            skin: 'layui-layer-lan',
					            closeBtn: 0,
					            anim: 4 //动画类型
					    });
						setTimeout(function(){
							window.location.href = window.location.href;
						},1000)
						
					}else{
						layer.msg('删除失败', {icon: 2});
				        setTimeout(function(){
				            layer.closeAll();  //关闭弹出层
				        },1000);
					}
				    },
			    })
    }, function(index){
        layer.close(index);  //关闭弹出层
    });
};
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