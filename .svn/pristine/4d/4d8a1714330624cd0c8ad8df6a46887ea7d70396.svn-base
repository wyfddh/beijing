<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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

    <style type="text/css">
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

        /*表单验证*/
        .registerform li {
            padding-bottom: 20px;
        }

        .Validform_checktip {
            margin-left: 10px;
        }

        .registerform .label {
            display: inline-block;
            width: 70px;
        }

        .action {
            padding-left: 92px;
        }
    </style>
    <title>添加人员</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
</head>
<body>
<div id="header"></div>
<aside class="Hui-aside" id="aside" style="height: 100%;background: #72CDAE;position: fixed"></aside>
<div class="dislpayArrow hidden-xs">
    <a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<%@ include file="../main.jsp"%>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<section class="Hui-article-box section_box" style="overflow: inherit">
    <nav class="breadcrumb" style="background: #f7f7f7;border: none"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span
            class="c-gray en">&gt;&gt;</span> 人员添加 <span class="c-gray en">&gt;&gt;</span>
    </nav>
    <form class="registerform" method="post" action="<%=request.getContextPath() %>/admin/user/addAdmin.do">
        <div class="pd-20 Hui-article mt-20">
            <div>
                <div class="row cl col-xs-12 col-sm-12 col-md-4">
                    <label class="col-xs-6 col-sm-3 col-md-6 col-lg-4 text-r">创建人:</label>
                    <div class="col-xs-6 col-sm-8 col-lg-6 text-l"></div>
                </div>
                <div class="row cl col-xs-12 col-sm-12 col-md-4">
                    <label class="col-xs-6 col-sm-3 col-md-6 col-lg-4 text-r">创建时间:</label>
                    <div class="col-xs-6 col-sm-8 col-lg-6 text-l"></div>
                </div>
                <div class="row cl col-xs-12 col-sm-12 col-md-4 clearfix">
                    <label class="col-xs-6 col-sm-3 col-md-6 col-lg-4 text-r">最后登录时间:</label>
                    <div class="col-xs-6 col-sm-8 col-lg-6 text-l"></div>
                </div>
            </div>
            <!--表单验证-->

            <div class="ml-50">
                <div class="row cl col-xs-12 col-sm-12">
                    <h4 class="pt-20 pl-30 text-l c-orange">账号信息</h4>
                </div>
                <div class="row cl clearfix pt-10">

                </div>
                <div class="row cl clearfix pt-10">
                    <label for="" class="form-label col-xs-4 col-sm-3 text-r hei col-md-2"><span class="c-red">*</span>账号:</label>
                    <div class="col-xs-5 col-sm-7 col-md-5 col-lg-6">
                        <input id="telePhone" type="text" name="phone" class=" input-text" placeholder="请输入11位手机号"  errormsg="请输入您的手机号码！"/>
                        <span style="color:red;" id="spanTelePhone"></span></td>
                    </div>
                    <div class="Validform_checktip"></div>
                </div>
                <div class="row cl clearfix pt-10">
                    <label for="" class="col-xs-4 col-sm-3 text-r hei col-md-2"><span class="c-red">*</span>密码:</label>
                    <div class="col-xs-5 col-sm-7 col-md-5 col-lg-6">
                        <input type="password" name="password" id="password"  class="input-text" placeholder="请输入您的密码" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！"/>
                    </div>
                    <div class="Validform_checktip"></div>
                </div>
                <div class="row cl clearfix  pt-10">
                    <label for="" class="col-xs-4 col-sm-3 text-r hei col-md-2"><span class="c-red">*</span>确认密码:</label>
                    <div class="col-xs-5 col-sm-7 col-md-5 col-lg-6">
                        <input type="password"  name="newpwd" id="newpwd" placeholder="请再次输入您的密码" class="input-text" datatype="*"  nullmsg="请再输入一次密码！" errormsg="您两次输入的账号密码不一致！"/>
                    </div>
                    <div class="Validform_checktip"></div>
                </div>
                <div class="row cl clearfix  pt-10">
                    <label for="" class="col-xs-4 col-sm-3 text-r hei col-md-2"><span class="c-red">*</span>组织机构:</label>
                    <div class="col-xs-5 col-sm-7 col-md-5 col-lg-6">
                    <select name="deptId">
                      <option value="-1">--请选择单位--</option>
                      <c:forEach var="org" items="${orgs}">
                          <option value="${org.id}">${org.name}</option>
                      </c:forEach>
                    </select>
                        <!-- <input type="text" class="input-text" name="" placeholder="例如：吉林省博物院"> -->
                    </div>
                </div>
                <div class="row cl clearfix  pt-10">
                    <label for="" class="col-xs-4 col-sm-3 text-r hei col-md-2"><span class="c-red">*</span>真实姓名:</label>
                    <div class="col-xs-5 col-sm-7 col-md-5 col-lg-6">
                        <input type="text"  name="trueName" placeholder="请输入真实姓名，例如：张三" class="input-text" datatype="s2-12"  nullmsg="请输入您的名字，例如：张三！" errormsg="名字至少2个字符,最多12个字符！" />
                    </div>
                    <div class="Validform_checktip"></div>
                </div>
            </div>
            <!--添加角色开始-->
            <div class="mt-20 ml-50">
                 <div class="row cl col-xs-12 col-sm-12">
                    <h4 class="pt-20 pl-30 text-l c-orange">添加角色</h4>
                </div>
                <div style="clear: both"></div>
               
                <div class="panel panel-default col-xs-11 col-sm-10 col-md-8 col-lg-6 col-offset-2" style="padding: 0">
                    <div class="panel-body">
                        <c:forEach items="${roles}" var="r" varStatus="sta">
                        <div class="radio-box">
                            <input type="checkbox" id="checkbox-${sta.index+1}" name="roleId" value="${r.id}">
                            <label for="checkbox-${sta.index+1}">${r.name}</label>
                        </div><br/><br/>
                         </c:forEach>
                    </div>
                </div>        
            </div>
            <!--状态信息开始-->
            <div class="mt-20 ml-50">
                 <div class="row cl col-xs-12 col-sm-12">
                    <h4 class="pt-20 pl-30 text-l c-orange">状态信息</h4>
                </div>
                <label for="" class="row cl col-xs-4 col-sm-3 col-md-2 text-r">是否启用:</label>
                <div class="row cl col-xs-8 col-sm-9 pl-20">
                    <div class="radio-box">
                        <input type="radio" id="radio-13" name="status" checked value="1">
                        <label for="radio-13">是</label>
                    </div>
                    <div class="radio-box" style="padding-left: 0">
                        <input type="radio" id="radio-14" name="status" value="0">
                        <label for="radio-14">否</label>
                    </div>
                </div>

            </div>
            <!--保存开始-->
            <div class="btn-wrap row cl col-xs-10 col-sm-8 col-offset-3 pt-20">
                <input type="submit" id="save" value="保 存" class="btn btn-primary radius" />
                <input type="reset" value="取 消" class="btn btn-danger radius" />
            </div>

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
   //手机正则验证
    $(function(){
         $("#telePhone").blur(function(){
        	 alert(1);
              phone = $(this).val();
		$.ajax({
			type : "post",//发送的方式
			url : "<%=request.getContextPath()%>/admin/user/checkPhone.do", //发送地址
			data : {phone:phone}, //发送的数据
			async:false,
			dataType : "json", //数据类型
			success : function(result) {
				alert(result);
				if (result == "1") {
					$("#spanTelePhone").text("已有管理员账号！").css("color","red");
				} else if(result == "2") {
					$("#spanTelePhone").text("账号已经注册过了！").css("color","green");
					$("#password").attr("disabled","disabled");
					$("#repwd").attr("disabled","disabled");
				} else if(result == "3"){
					$("#spanTelePhone").text("账号可以使用！").css("color",
					"green");
				}
			},
			error : function(result) {
				alert("报错啦~~");
			}
		});
      });  
    })

    function choseRoles(){
        var count= $("[type=checkbox]:checked").length;
        if(count>0){
           return true;
        }else{
         alert("请选择角色！");
         return false;
      }
    }
	
   //手机是否注册验证
   //模糊匹配单位
   
   //确认保存吗
 $(function(){
     $("#save").click(function(){
         if(confirm("确定保存吗?")){
	       location.href="<%=request.getContextPath()%>/admin/user/addAdmin.do";		
	    }
     });
 })
</script>

 
<!-- <script type="text/javascript"> 
            callback:function(form){
                 var check=confirm("您确定要提交表单吗？");
                if(check){
                    form[0].submit();
                     //提交表单需要执行的代码
                 }
                 return false;
             }
         });
     })
 </script> -->


</body>
</html>
</body>
</html>