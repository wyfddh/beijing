<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico">
<link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
<!--[if lt IE 9]>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/html5shiv.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/respond.min.js"></script>
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
a:hover {
	text-decoration: none;
}

.check-box, .radio-box {
	padding-left: 0;
}

.layui-layer-page .layui-layer-content {
	overflow-x: hidden !important;
}

#aside111 {
	background: #72CDAE;
	height: 100%;
	position: fixed;
}

.hei {
	line-height: 30px;
}

.blue {
	color: #00a0e9 !important;
}

h4 {
	color: #333333;
}
.addBwgUserbox{
	width: 860px;
	margin: 0 auto;
	background: #FFFFFF;
}
.containerBox{
	position: relative;
}
.containerBox h1{
	font-size: 18px;
	color: #333333;
	padding-top: 30px;
}
.save{
	position: absolute;
	top: 30px;
	right: 0;
}
<%--新改的样式--%>
        body{
            background:#fff!important;
        }
        .contentWrap{
            width: 860px;
            margin:0 auto;
            background:#fff;
            padding:80px 0;
        }
        #subForm{
            border:2px solid #f1f2f7;
            border-radius:5px;
            overflow:hidden;
        }
        .fixedHead{
            width:860px;
            height:80px;
            background:#fff;
            /*z-index:1000;*/
            /*border-bottom:1px solid #f2f2f2;*/
            /*box-sizing:border-box;*/
        }
        .fixedHead > .title{
            width:200px;
            float:left;
            font-size: 18px;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
            font-weight: bold;
            line-height: 80px;
        }
        .fixedHead > .btn_jilin{
            border-radius: 4px;
            width: 101px;
            height: 36px;
            float:right;
            text-align:center;
            line-height:36px;
            margin-top:22px;
            cursor:pointer;
        }
        .fixedHead > .btn_jilin > span{
            padding-left:8px;
            vertical-align:middle;
        }
        .fixedHead > .btn_jilin > img{
            vertical-align:middle;
        }
        .fixedHead > .confirm{
            background-color: rgb(42, 155, 207);
            color:#fff;
            margin-right:12px;
        }
        .fixedHead > .cancel{
            border:1px solid rgb(42, 155, 207);
            color:rgb(42, 155, 207);
        }
        .clearfix ul{
        	overflow: hidden;
        }
       .clearfix ul li{
       	float: left;
       	margin-right: 15px;
       }
       input{
       	outline: none;
       	height: 24px!important;
       	line-height: 24px!important;
       	border: 1px solid #F1F2F7;
       	border-radius: 5px;
       	color: #999999;
       }
       .info>div{
       	margin-bottom: 22px;
       }
       .padding20{
       	width: 100%; 
       	height: 7px;
       	background: #F1F2F7;
       }
</style>
<title>编辑管理员</title>
</head>
<body>

<!--<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>-->
<section>
    <!--<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 编辑管理员 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>-->
    <div class="addBwgUserbox">
        <form class="registerform" method="post" id="registForm" action="<%=request.getContextPath()%>/admin/user/updateAdmin.do">
            <div class="containerBox">
            	<div class="fixedHead">
		            <div class="title">添加管理员</div>
		            <div class="btn_jilin cancel" id="cancel"><img src="<%=request.getContextPath() %>/back/images/cancel.png"><span>取消</span></div>
		            <div class="btn_jilin confirm" id="submit"><img src="<%=request.getContextPath() %>/back/images/save.png"><span>保存</span></div>
		        </div>
		        <div class="clearfix" style="margin-bottom: 24px;">
                		<ul>
                			<li>
                				<label for="uname" class="">创建人:</label>
                				<input title="${user.nickName}" style="height: 26px;line-height: 26px;padding: 0 5px;" readonly="readonly" id="uname" type="text" value="${user.nickName}" />
                			</li>
                			<li>
                				<label class="">创建时间:</label>
                				<input style="width: 180px;height: 26px;" type="text" readonly="readonly" id="datemin" class="input-text Wdate" style="width:120px;" name="createTimeS"  value="${admin.createTime}">
                			</li>
                			<li>
                				<label class="">最后登录时间:</label>
                        		<input style="width: 180px;height: 26px;" type="text" readonly="readonly" id="datemin" class="input-text Wdate" style="width:120px;" name="createTimeS"  value="${admin.lastLoginTime}">
                			</li>
                		</ul>
                </div>
                <div class="padding20"></div>
                <!--新建表单-->
                <div>
                    <h4>账号信息</h4>
                    <div class="info">
                        <div class="">
                            <span class="c-red" style="opacity:0">*</span>账号:
                            <input style="width:216px;" type="text" value="${admin.phone }" id="account" name="phone" readonly class=" input-text bg-gray" datatype="m" errormsg="请输入11位手机号码！"/>
                            <!--<div class="Validform_checktip"></div>-->
                            &nbsp;&nbsp;&nbsp;
                            <label for="trueName"><span class="c-red">*</span>真实姓名:</label>
                            <input style="width:216px;" type="text" id="trueName" value="${admin.userName }" name="userName" placeholder="请输入真实姓名，例如：张三" class="input-text refdis" datatype="s2-12"  nullmsg="请输入您的名字，例如：张三！" errormsg="名字至少2个字符,最多12个字符！" />
                        </div>
                        <div id="shengji">
                            <span class="c-red">*</span>单位:
                            	<span style="width: 114px;height: 26px;padding: 2px 5px;border-radius: 5px;" class="select-box">
		                           <select name="area" class="select regionType"  size="1" style="width:100px;" id="diqu">
									    <option value="">文物局</option>
									   <c:forEach items="${area}" var="a" varStatus="row">
											<option value="${a.id}" <c:if test="${a.id eq areaId}">selected</c:if> >${a.name}</option>
										</c:forEach>
									</select>
								</span>
								<span style="width: 114px;height: 26px;padding: 2px 5px;border-radius: 5px;" class="select-box">
									<select name="unit" class="select" size="1" style="width:100px;" id="danwei">
									    <option value="">博物馆</option>
									   <c:forEach items="${unit}" var="u" varStatus="row">
											<option value="${u.id}" <c:if test="${u.id eq unitId}">selected</c:if> >${u.name}</option>
										</c:forEach>
									</select>
								</span>
                        </div>
                    </div>
                </div>
                <div class="padding20"></div>
                <!--添加角色开始-->
                <div class="">
                    <h4>
                    	添加角色
                    	<span style="font-size: 16px; color: #999999;">至少勾选一个</span>
                    </h4>
                    <div style="clear: both"></div>
                    <div class="" style="padding: 0">
                        <div style="margin-top: 20px;margin-bottom: 28px;" class="">
                        	<c:forEach items="${role}" var="u">
							    <div class="radio-box">
                                    <input type="checkbox" value="${u.id}"  name="roleId" class="refdis rolecheck"
			                        	<c:forEach items="${oldUr}" var="o">
			                        		<c:if test="${u.id eq o.roleId}">checked="checked"</c:if>
                                		</c:forEach>>
                                    <label>${u.roleName}</label>
                              </div>
							</c:forEach>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
                <div class="padding20"></div>
                <!--状态信息开始-->
                <div class="">
                    <h4>状态信息</h4>
                    <div style="clear: both"></div>
                    <div class>
                       <div class="radio-box">
							<input type="radio" value="1" name="status" <c:if test="${1 eq admin.status}">checked="checked"</c:if> class="refdis">
							<label for="radio-13">启用</label>
						</div>
						<div class="radio-box" style="padding-left: 0">
							<input type="radio" value="0" name="status" <c:if test="${0 eq admin.status}">checked="checked"</c:if> class="refdis">
							<label for="radio-14">停用</label>
						</div>
                    </div>

                </div>
            </div>
        </form>
    </div>
    <div>
    </div>
</section>
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
	 $("#cancel").click(function(){
        layer.confirm('您确定要退出本页面吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.closeAll();  //关闭弹出层
            window.location.href="<%=request.getContextPath()%>/admin/user/adminList.do";
//          window.history.back(-1);  //关闭弹出层
        }, function(){
            layer.closeAll();  //关闭弹出层
        });
    })
    $("#account").focus(function(){
        $(this).css({outline:"none"})
    })
    //表单验证
    var phoneNum = /^1[3|4|5|8|0|1|2]\d{9}$/;
    var val = "";
    $(".rolecheck").click(function(){
    	$(this).attr("checked","checked");
    	return val=$('input[name="roleId"]:checked').val();
    })
    $("#submit").click(function(){
    	 if((gover == "1")&&($("#diqu").val() == "")){
             layer.open({
                 title:"提示",
                 content:"您还没有选择地区"
             });
             return false;
         }else if((gover == "1")&&($("#danwei").val() == "")){
             layer.open({
                 title:"提示",
                 content:"您还没有选择单位"
             });
             return false;
         }else if((gover == "2")&&($("#danwei").val() == "")){
             layer.open({
                 title:"提示",
                 content:"您还没有选择单位"
             });
             return false;
         }else if($("#trueName").val() == ""){
            layer.open({
                title:"提示",
                content:"您还没有添加真实姓名"
            });
            return false;
        }else {
            layer.open({
                title:"提示",
                content:"验证成功"
            });
            setTimeout(function(){
                $("#registForm").submit();
                layer.closeAll();
            },1000);
        }
    });
//  判断省级地级或者博物馆管理员
    var gover = ${level};
    function judge(){
        //    省级 |  地级
        if(gover == "1" || gover=="2"){
            $("#diqu").css({"display":"block"});
            $("#danwei").css({"display":"block"});
            return false;
        }else if(gover == "3"){//    博物馆管理员
            $("#shengji").css({"display":"none"});
            return false;
        }
    }
    judge();
	var appName = '<%=request.getContextPath() %>';
  //二级联动
    $(function(){
        $('.regionType').change(function(){
            var pid=$(this).val();
            var obj=$(this).parent().next("span").find("select");
            var first=obj.children().first().clone();
            $.ajax({
              	url:appName + "/admin/region.do",
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
</script>
</body>
</html>