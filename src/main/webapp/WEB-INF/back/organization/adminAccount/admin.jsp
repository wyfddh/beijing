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
				padding: 30px;
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
<title>管理员账号管理</title>
</head>
<body>
<!--_header 作为公共模版分离出去-->
 <%@ include file="../weihuNav.jsp"%> 
 
<!--_menu 左边slide导航开始-->
 <%@ include file="../../content/aside.jsp" %>
<!--<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>-->
<section  class="Hui-article-box">
    <!--<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理<span class="c-gray en">&gt;</span> 管理员账号 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>-->
    <div class="Hui-article">
    	<div class="addHuoDong">
		          	<span class="1">
		          		<a href="<%=request.getContextPath()%>/admin/user/getInfolist.do?adminId=null" class="btn btn-primary radius" style="text-decoration:none" title="添加管理员"><i class="Hui-iconfont">&#xe600;添加管理员</i></a>
		          	</span>
	   	</div>
        <form action="<%=request.getContextPath()%>/admin/user/adminList.do" class="huodong" id="form">
            <div>
                	账户名:&nbsp;
                    <input placeholder="手机号" style="width: 190px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="zhanghao"  value="${dto.phone}" name="phone">
                	&nbsp;&nbsp;姓名: &nbsp;
                    <input style="width: 190px;height: 26px;" type="text" class="input-text" id="xingming"  value="${dto.userName}" name="userName">
		                 <span id="shengji" class="inline">
                           	&nbsp;&nbsp;&nbsp;单位:&nbsp;
                           	
                           	<span style="width: 114px;height: 26px;padding: 2px 5px;border-radius: 5px;" class="select-box">
		                        <select name="area" class="select regionType" size="1" style="style="width:100px" id="diqu">
								    <option value="">文物局</option>
								   <c:forEach items="${area}" var="a" varStatus="row">
										<option value="${a.id}" <c:if test="${a.id eq dto.area}">selected</c:if> >${a.name}</option>
									</c:forEach>
								</select>
		                    </span>&nbsp;&nbsp;
                           	<span style="width: 114px;height: 26px;padding: 2px 5px;border-radius: 5px;" class="select-box">
		                        <select name="unit" class="select" size="1" style="width:100px" id="danwei">
							    	<option value="">博物馆</option>
								    <c:forEach items="${unit}" var="u" varStatus="row">
										<option value="${u.id}" <c:if test="${u.id eq dto.unit}">selected</c:if> >${u.name}</option>
									</c:forEach>
								</select>
		                    </span>
							
					</span>
            </div>
            <div>
            		创建时间:&nbsp;
                    <input style="width: 110px;height: 26px;" type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;" name="createTimeS"  value="${dto.createTimeS}">
                   	&nbsp;至&nbsp;
                    <input style="width: 110px;height: 26px;" type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax" class="input-text Wdate" style="width:120px;" name="createTimeE" value="${dto.createTimeE}">
                	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                	最后登录时间:&nbsp;
                    <input style="width: 110px;height: 26px;" type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin1" class="input-text Wdate" style="width:120px;" name="lastLoginTimeS"  value="${dto.lastLoginTimeS}">
                    &nbsp;至&nbsp;
                    <input style="width: 110px;height: 26px;" type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax1" class="input-text Wdate" style="width:120px;" name="lastLoginTimeE"  value="${dto.lastLoginTimeE}">
            </div>   
            <div class="hide">  
            	每页显示条数:&nbsp;
                <input placeholder="每页显示条数"  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${page.size }" name="size">
            </div>
            
            <div class="star" style="display:block;width:100%;">
								<button class="btn b1" type="submit" title="搜索"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
								<button class="btn b2" type="button" onclick="formReset();" title="重置"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>
								<!--<input class="btn btn-success" type="reset">-->
								<span style="float:right;color:#000;padding-right:20px;">共${page.allRow}条数据</span>
							</div>
            <div style="clear: both"></div>
            <div style="min-width: 1020px">
                <table class="table">
                    <thead>
                    <tr class="text-c">
                        <!--<th width="40"><input name="" type="checkbox" value=""></th>-->
                        <th width="80">序号</th>
                        <th width="300">手机号</th>
                        <th width="200">真实姓名</th>
                        <th width="300">单位</th>
                        <!--<th width="300">创建人</th>-->
                        <th width="300">创建时间</th>
                        <th width="300">最后登录时间</th>
                        <th width="300">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                     <c:set var="recordNumber" value="${(page.currentPage - 1) * page.size }" />
                     <c:forEach items="${userAll}" var="u" varStatus="sta">  
	                    <tr class="text-c">
	                    <!--<td><input name="" type="checkbox" value=""></td>-->
	                        <td>${sta.count + recordNumber}</td>
	                        <td>${u.phone}</td>
	                        <td>${u.userName}</td>
	                         <td>${u.orgName}</td>
	                         <!--<td>没有字段</td>-->
	                        <td>${u.createTime}</td>
							
	                        <td>
							<c:if test="${u.lastLoginTime>0}" >
	                        <jsp:useBean id="dateValue" class="java.util.Date"/>

							<jsp:setProperty name="dateValue" property="time" value="${u.lastLoginTime*1000}"/>
							
	                        <fmt:formatDate value="${dateValue}" pattern="yyyy/MM/dd HH:mm"/>
							</c:if>
	                        </td>
	                        <td class="td-manage">
	                            <a title="修改" href="<%=request.getContextPath()%>/admin/user/getInfolist.do?adminId=${u.id}">
	                            	<img src="<%=request.getContextPath() %>/back/images/bianjiicon.png" alt="" />
	                            </a>&nbsp;
	                            <a title="重置密码" onclick="rePassword('${u.id}')" href="javascript:;">
	                            	<img src="<%=request.getContextPath() %>/back/images/repeatpwd.png" alt="" />
	                            </a>&nbsp;    
	                            <c:if test="${fn:startsWith(u.phone,'10') eq false}">
		                            <a title="删除" onclick="deleteRole('${u.id}')" href="javascript:;">
		                            	<img src="<%=request.getContextPath() %>/back/images/delicon.png" alt="" />
		                            </a>
	                            </c:if> 
	                           <%--  <a title="导出信息" onclick="downLoad('${u.id}')" href="javascript:;"> 
	                            	<img src="<%=request.getContextPath() %>/back/images/download.png" alt="" />
	                            </a> --%>
	                        </td>
	                    </tr>
	                    </c:forEach>
                    </tbody>
                </table>
                <br>
				<div id="page" align="center"></div> 
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

//二级联动
var appName = '<%=request.getContextPath() %>';
$(function(){
	//添加左边样式。
	var level = ${level};
	if (level == 2) { 
		$(".fabu-aside>ul>li").eq(2).addClass("weihu");
	} else {
		$(".fabu-aside>ul>li").eq(3).addClass("weihu");
	}
	$(".headerNav a.guanliyuanguanli").addClass("active");
	$(".headerNav a.guanliyuanguanli").find("img").attr("src",'<%=request.getContextPath() %>/back/images/bowuguanicon.png');
	
	 
    $('.regionType').change(function(){
        var pid=$(this).val();  
        var obj=$(this).parent().next("span").find("select");
        var first=obj.children().first().clone();
        $.ajax({
          	url:appName + "/museumInfoManage/region.do",
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
    
    
    $("#pageSize").change(function() {
    	var size = $(this).val();
    	if (size == "") {
    		return false;
    	} else {
    		$("#pageSizeHide").val(size); 
	    	$("#form").submit();
    	}
    })
});
function downLoad(id) {
	window.location.href='<%=request.getContextPath()%>/admin/download.do?id=' + id;
}

function formReset() {  
    $(':input,#myform')  
     .not(':button, :submit, :reset, :hidden')  
     .val('')  
     .removeAttr('checked')  
     .removeAttr('selected');     
}
function deleteRole(id){
    layer.confirm('您确定要删除该条信息吗？', {
        btn: ['确定','取消'] //按钮
    }, function(index){
        //点击确定之后需要执行的函数
   		$.ajax({
			url : "<%=request.getContextPath()%>/admin/user/deleteAdmin.do",
			type : "post",
			data :  {adminId:id},
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
	function rePassword(value){
		layer.confirm(
				 '<div class="f-l mt-5 ml-20">设置新密码：</div>'+
	             '<div class="formControls col-xs-7">'+
	                  '<input type="password" id="newPass" class="input-text"  value="${dto.userName}" name="userName">'+
	             '</div>'+
	             '<div style="clear:both;"></div>'+
	             '<div class="f-l mt-20 ml-20">确认新密码：</div>'+
	             '<div class="formControls col-xs-7 mt-15">'+
	                  '<input type="password" id="newPassAgain" class="input-text"  value="${dto.userName}" name="userName">'+
	             '</div>'
			, {
			  btn: ['确认','取消'] //按钮
			}, function(pass, index){
				 var len = $("#newPass").val().length;
				 var newPassWord = $("#newPass").val();
				 var newPassWordAgain = $("#newPassAgain").val();
		         if((len < 8) || (len > 18)){
		             layer.alert('密码必须为8-18位', {
		                 skin: 'layui-layer-lan',
		                 closeBtn: 0,
		                 anim: 4 //动画类型
		             });
		             return false;
		         }else if(newPassWord != newPassWordAgain){
		        	  layer.alert('您两次输入的密码不一致！', {
			                 skin: 'layui-layer-lan',
			                 closeBtn: 0,
			                 anim: 4 //动画类型
			          });
		        	  return false;
		         }else {
		        	  $.ajax({
                          url : "<%=request.getContextPath()%>/admin/user/updatePassword.do",
                          type : "post",
                          data :  {"adminId":value,
                        	  	   "password":$("#newPassAgain").val()
                          			},
                          success : function(data){
                          if(data == 'SUCCESS'){
                        	  //新改的密码为pass，执行你的提交的方法
         		              layer.alert('修改密码成功', {
         		                 skin: 'layui-layer-lan',
         		                 closeBtn: 0,
         		                 anim: 4 //动画类型
         		             });
         		            setTimeout(function(){
         		                 layer.closeAll();    //关闭弹出层
         		             },1000);
                          }else{
                               layer.msg('保存失败', {icon: 2});
                          } 
                          },
                     })
		         }
			});
}
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
		var abc="<span>每页显示 <input style='width:50px;height: 28px;' type='number'  min='5' max='100' step='5' class='input-text' id='pageSize'   value='"+${page.size }+"' name='size'>条</span>";
		$(".laypage_total").before(abc); 
//	    判断省级地级或者博物馆管理员
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
	</script>  
	<script>
	   $("#reset").click(function(){
		   $("#datemin").val("");
		   $("#datemax").val("");
		   $("#datemin1").val("");
		   $("#datemax1").val("");
		   $("#zhanghao").val("");
		   $("#xingming").val("");
	   })
	</script>
</body>
</html>