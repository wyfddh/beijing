<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
 <%
	String wwxxwip = "http://test.tj720.com/mip/pc/index.html#/activitydetails/";
%>
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
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
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
    <script>
			$(function(){
				$(".fabu-aside>ul>li").eq(0).addClass("fabu");
				$(".headerNav a.huodong").addClass("active");
				$(".headerNav a.huodong").find("img").attr("src",'<%=request.getContextPath() %>/back/images/hdlogoActive.png');
			})
		</script>
    <title>活动管理列表</title>
</head>
<body>
	<!--_header 作为公共模版分离出去-->
	<%@ include file="../../../fabuNav.jsp"%>

	<!--_menu 左边slide导航开始-->
	<%@ include file="../../aside.jsp"%>
	<!--/_menu 作为公共模版分离出去-->
<!--<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>-->
<section  class="Hui-article-box">
    <!--<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 内容管理 <span class="c-gray en">&gt;</span> 活动管理 <span class="c-gray en">&gt;</span> 活动列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>-->
    <!--添加活动-->
    
    <div class="Hui-article">
    	<div class="addHuoDong">
	     <c:if test="${fn:contains(sessionScope.user.level,3)==true}">
		          	<span class="1">
		              	<a href="<%=request.getContextPath()%>/activity/toActivityAdd.do" class="btn btn-primary radius" ><i class="Hui-iconfont mr-5">&#xe600;</i>添加</a>
		          	</span>
	    	</c:if>
	   	</div>
        <form action="<%=request.getContextPath()%>/activity/getArticleList.do" class="huodong" id="form">
            <!--<div class="">-->
                <div class="">
                	关键词：
                    <input style="width: 190px;height: 26px;padding-left: 20px;"  type="text" class="input-text" name="keys" value="${keys}" placeholder="活动名称/活动内容">
                </div>
                <div class="">
                	发布时间：
                    <input style="width: 114px;height: 26px;" type="text" name="staTime" value="${activity.staTime}" onfocus="WdatePicker()" id="datemin" class="input-text Wdate">
                	&nbsp;至&nbsp;
                    <input style="width: 114px;height: 26px;" type="text" name="overTime" value="${activity.overTime}" onfocus="WdatePicker()" id="datemax" class="input-text Wdate">
                	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发布状态：
                    <span style="width: 114px;height: 26px;padding: 2px 5px;border-radius: 5px;" class="select-box">
                        <select class="select" name="publish" value="${activity.publish}"  size="1">
							<option value="-1" selected="selected">全部</option>
							<option value="1" <c:if test="${'1' eq activity.publish}">selected</c:if>>已发布</option>
							<option value="0" <c:if test="${'0' eq activity.publish}">selected</c:if>>待发布</option>
						</select>
                    </span>
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发布人：
                    <span style="width: 114px;height: 26px;padding: 2px 5px;border-radius: 5px;" class="select-box">
                        <select class="select" name="userId" size="1">
                       	 	<option value="">全部</option>
                             <c:forEach items="${userList}" var="u" varStatus="row">
	                            <option value="${u.id}" <c:if test="${u.id eq activity.userId}">selected</c:if> >${u.nickName}</option>
                            </c:forEach>
                        </select>
                    </span>
                </div>
                <!-- <div class="">发布单位：</div>
                <div class="formControls col-xs-2 mt-10">
                    <span class="select-box">
                        <select class="select" name="adminRole" size="1">
                            <option value="地区">地区</option>
                        </select>
                    </span>
                </div> -->
                <!--<br>
                <div class="">
	                    <label class="">收藏单位：</label>
	                    <span class="inline">
	                    	<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
	                    		<select name="collectionUnit" id="museum" class="select select-box inline" style="width:162px;">
		        
		                            <option value="${sessionScope.user.orgId}" selected>${sessionScope.user.orgName}</option>
		                        </select>
	                    	</c:if>
	                    	<c:if test="${fn:contains(sessionScope.user.level,3)==false}">
		                        <select name="erea" class="org select select-box inline" style="width:162px">
		                            <option value="">所在区域</option>
		                            <c:forEach items="${cityList}" var="city" varStatus="row">
			                            <option value="${city.id}" <c:if test="${city.id eq erea}">selected</c:if> >${city.shortname}</option>
		                            </c:forEach>
		                        </select>
		                        <select name="orgId" id="museum" class="select select-box inline" style="width:162px;">
		                            <option value="0">收藏单位</option>
		                            <c:forEach items="${musList}" var="mus" varStatus="row">
			                            <option value="${mus.id}" <c:if test="${mus.id eq activity.orgId}">selected</c:if> >${mus.shortname}</option>
		                            </c:forEach>
		                        </select>
	                    	</c:if>
	                    </span>
	                </div>-->
                <!-- <div class="formControls col-xs-2 mt-10 ml-15">
                    <span class="select-box">
                        <select class="select" name="adminRole" size="1">
                            <option value="单位">单位</option>
                        </select>
                    </span>
                </div> -->
                <div class="hide">  
	            	每页显示条数:&nbsp;
	                <input placeholder="每页显示条数"  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${activityList.page.size }" name="size">
	            </div>
                <div class="star" style="display:block;width:100%;">
								<button class="btn b1" type="submit" title="搜索"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
								<button class="btn b2" type="reset" title="重置"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>
								<!--<input class="btn btn-success" type="reset">-->
								<span style="float:right;color:#000;">共${activityList.page.allRow}条数据</span>
							</div>
            <!--</div>-->
            </form>
            <div style="clear: both"></div>
            <div style="min-width: 1020px;padding-left: 30px;"> 
                <table class="table">
                    <thead>
                    <tr class="text-c">
                        <th width="100">序号</th>
                        <th width="500">活动名称</th>
                        <th width="200">活动时间</th>
                        <th width="100">发布状态</th>
                        <th width="100">发布单位</th>
                        <th width="150">发布人</th>
                        <th width="300">发布时间</th>
                        <th width="300">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="recordNumber" value="${(activityList.page.currentPage - 1) * activityList.page.size }" />
                    <c:forEach items="${activityList.data}" var="activity" varStatus="status">
							<tr class="text-c">
								<td>${status.count + recordNumber}</td>
								<td>${activity.activityName}</td>
								<td>${activity.activityDate}</td> 
								<td class="state">${activity.publish==1?'已发布':activity.publish==0?'待发布':''}</td>
								<td class="state">${activity.musExhibition}</td>
								<td>${activity.nickName}</td>
								<td class="td-status"><span>${activity.issemTime}</span></td>
								<!-- 预览的地址栏需要修改 -->
								<td class="td-manage">
								<c:if test="${fn:contains(sessionScope.user.level,3)==true}">
								<c:if test="${fn:contains(sessionScope.user.authStr,'contentAdmin')==true}">
								<c:if test="${activity.publish==1}">
								 		<a title="取消发布" onclick="release('${activity.publish}','${activity.id}')" href="javascript:;">
								 			<img src="<%=request.getContextPath() %>/back/images/quxiaofabuicon.png" alt="" />
								 		</a>&nbsp;
								</c:if>
								<c:if test="${activity.publish==0}">
									<a title="编辑" href="<%=request.getContextPath()%>/activity/getActivityInfo.do?id=${activity.id}">
										<img src="<%=request.getContextPath() %>/back/images/bianjiicon.png" alt="" />
									</a>&nbsp;
									<a title="发布" onclick="release('${activity.publish}','${activity.id}')" href="javascript:;">
										<img src="<%=request.getContextPath() %>/back/images/fabu.png" alt="" />
										
									</a>&nbsp;
								</c:if>
								</c:if>
								</c:if>
										<a title="查看" href="<%=wwxxwip %>${activity.id}" target="_blank">
											<img src="<%=request.getContextPath() %>/back/images/chakan.png" alt="" />
										</a>&nbsp;
										
								<c:if test="${activity.publish==0}">
									<a title="删除" href="javascript:;" onclick="delSpre('${activity.id}')">
										<img src="<%=request.getContextPath() %>/back/images/delicon.png" alt="" />
									</a>&nbsp;
								</c:if>
								</td>
							</tr>
						</c:forEach> 
                    </tbody>
                </table>
            </div>
            <br>
        <div id="page" style="padding-left: 30px;"></div>
    </div>
    <div>
    </div>
</section>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script> --%>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<!-- <script type="text/javascript">
    $('.table-sort').dataTable({
//        "info": false,
        "paging": true,
        "searching": false,
        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
        "stateSave": true,
        "displayStart": 1, //一开始显示第一页
        "bStateSave": true,//状态保存
        "pagingType": "full_numbers",
        "aoColumnDefs": [
//            {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
            {"orderable":false,"aTargets":[0,8]}// 制定列不参与排序
        ],
        "aLengthMenu": [10, 25, 50, -1]  //也可以直接用一维数组设置数量
    });
</script> -->
<script type="text/javascript">

$(function() {
    $("#pageSize").change(function() {
    	var size = $(this).val();
    	if (size == "") {
    		return false;
    	} else {
    		$("#pageSizeHide").val(size); 
	    	$("#form").submit();
    	}
    })
})
//删除的代码
function delSpre(id){
layer.confirm('确定删除此信息？', {
		  btn: ['确定','取消'] //按钮
		}, function(){
			$.ajax({
				url : "<%=request.getContextPath()%>/activity/deleteActivity.do",
				type : "post",
				data : "id="+id,
				async:false,
				dataType : "text",
				success : function(data){
					window.location.href = '<%=request.getContextPath()%>/activity/getArticleList.do';
		  			layer.msg('成功删除', {icon: 1});
				},
				error : function(){
		  			layer.msg('删除失败', {icon: 1});
				}
			}) 
		}, function(){
		  layer.msg('已取消删除', {
		  });	
		});
	<%-- --%>
}
//发布的功能
function release(publish,id){
	if(publish == 0){
		var a = "发布";
	} else if(publish == 1){
		var a = "取消发布";
	}
	layer.confirm('确定'+a+'此信息？', {
		 btn: ['确定','取消'] //按钮
		}, function(){
			$.ajax({
				url : "<%=request.getContextPath()%>/activity/updatePublish.do",
				type : "post",
				data :{id:id},
				async:false,
				dataType : "text",
				success : function(data){
					if(data == "success"){
					window.location.href = '<%=request.getContextPath()%>/activity/getArticleList.do';
		 			layer.msg(a+'成功', {icon: 1});
					}
				},
				error : function(){
					alert("发布失败，请联系xxx");
				}
			})
		}, function(){
		  layer.msg('已取消发布', {
		  });
		});
}

</script>
<!-- 分页功能 -->
	<script type="text/javascript">
		var nums = ${activityList.page.size}; //每页出现的数量
		var pages = ${activityList.page.totalPage}; //得到总页数
		//调用分页
		laypage({
		    cont: 'page',
		    pages: pages,
		    curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
		        var page = location.search.match(/page=(\d+)/);
		        return page ? page[1] : 1;
		    	}(), 
		   	skip: true, //是否开启跳页
		   	skin: '#2A9BCF', //皮肤
		   	groups: 3, //连续显示分页数
		    jump: function(e, first){ //触发分页后的回调
		       if(!first){ //一定要加此判断，否则初始时会无限刷新
		         location.href = '?page='+e.curr+'&'+$('form').serialize() ;
		       } 
		    }
		})
		var abc="<span>每页显示 <input style='width:50px;height: 28px;' type='number'  min='5' max='100' step='5' class='input-text' id='pageSize'   value='"+${activityList.page.size }+"' name='size'>条</span>";
		$(".laypage_total").before(abc); 
	</script>
	<!-- 级联 -->
	<script type="text/javascript">
	var appName = '<%=request.getContextPath() %>';
	$(function(){
	    $('.org').change(function(){
	        var pid=$(this).val();
	        var obj=$(this).next('select');
	        var first=obj.children().first().clone();
	        $.ajax({
	            url: appName + "/back/oCCollection/sltMuseum.do",
	            data:{parentId:pid},
	            type:"POST",
	            datatype:"json",
	            success:function(msg){
	            	 obj.empty().append(first);
	                for(var i in msg){
	                    obj.append("<option value="+msg[i]['id']+">"+msg[i]['shortname']+"</option>");
	                }
	            }
	        });
	    });
	});
	</script>
</body>
</html>