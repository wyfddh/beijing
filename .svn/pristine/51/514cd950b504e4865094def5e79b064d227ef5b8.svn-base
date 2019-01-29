<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
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
				$(".fabu-aside>ul>li").eq(5).addClass("xingzhengguanli");
				 $(".headerNav a.infoshangbao").addClass("active");
				 $(".headerNav a.infoshangbao").find("img").attr("src",'<%=request.getContextPath() %>/back/images/infoshangbaoicon.png');
			})
		</script>
    <title>前台日志列表</title>
</head>
<body>
	<!--_header 作为公共模版分离出去-->
	<%@ include file="./superNav.jsp"%>

	<!--_menu 左边slide导航开始-->
	<%@ include file="../content/aside.jsp"%>
	<!--/_menu 作为公共模版分离出去-->
<!--<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>-->
<section  class="Hui-article-box">
    <!--<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 内容管理 <span class="c-gray en">&gt;</span> 活动管理 <span class="c-gray en">&gt;</span> 活动列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>-->
    <!--添加活动-->
    
    <div class="Hui-article">
    		<form action="<%=request.getContextPath()%>/mipLog/getFrontInfoList.do" class="huodong">
            <div>
                	账户名:&nbsp;
                    <input placeholder="手机号" style="width: 190px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="zhanghao"  value="${dto.phone}" name="phone">
           			&nbsp;&nbsp;状态:&nbsp;
           			<span style="width: 114px;height: 26px;padding: 2px 5px;border-radius: 5px;" class="select-box">
	           			<select name="opStatus" class="select regionType" size="1" id="typeId">
	           				<option value="">请选择</option>
							<option value="0" <c:if test="${dto.opStatus == '0'}">selected</c:if>>失败</option>
							<option value="1" <c:if test="${dto.opStatus == '1'}">selected</c:if>>成功</option>
						</select>
					</span>
           			&nbsp;&nbsp;类型:&nbsp;
           			<span style="width: 114px;height: 26px;padding: 2px 5px;border-radius: 5px;" class="select-box">
	           			<select name="opType" class="select regionType" size="1" id="opStatusId">
	           				<option value="">请选择</option>
							<option value="1" <c:if test="${dto.opType == '1'}">selected</c:if>>浏览</option>
							<option value="2" <c:if test="${dto.opType == '2'}">selected</c:if>>操作</option>
							<option value="3" <c:if test="${dto.opType == '3'}">selected</c:if>>登录</option>
						</select>
					</span>
					&nbsp;&nbsp;时间:&nbsp;
                    <input style="width: 110px;height: 26px;" type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;" name="stateTime"  value="${dto.stateTime}">
                    &nbsp;至&nbsp;
                    <input style="width: 110px;height: 26px;" type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax" class="input-text Wdate" style="width:120px;" name="endTime" value="${dto.endTime}">
            </div>
            <div class="star" style="display:block;width:100%;">
					<button class="btn b1" type="submit" title="搜索"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
					<button class="btn b2" type="reset" title="重置"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>
					<!--<input class="btn btn-success" type="reset">-->
					<span style="float:right;color:#000;padding-right:20px;">共${page.allRow}条数据</span>
				</div>
            <div style="clear: both"></div>
            <div style="min-width: 1020px;padding-left: 30px;padding-right:30px;margin-top: 30px;"> 
                <table class="table">
                    <thead>
                    <tr class="text-c">
                        <th width="100">序号</th>
                        <th width="300">状态</th>
                        <th width="300">类型</th>
                        <th width="300">备注</th>
                        <th width="300">时间</th>
                        <th width="300">用户</th>
                        <th width="300">手机号</th>
                        <th width="300">ip</th>
                    </tr>
                    </thead>
                    <tbody>
	                   <c:forEach items="${listMipLog}" var="info" varStatus="status">
								<tr class="text-c">
									<td>${status.index + 1}</td>
									<td>
										<!-- 操作状态(0：失败；1：成功)-->
										<c:if test="${info.opStatus == '0'}">失败</c:if>
										<c:if test="${info.opStatus == '1'}">成功</c:if>
									</td> 
									<td>
										<!-- 操作类型（1：浏览，2：操作（增加，删除，修改）；3：登录） -->
										<c:if test="${info.opType == '1'}">浏览</c:if>
										<c:if test="${info.opType == '2'}">操作</c:if>
										<c:if test="${info.opType == '3'}">登录</c:if>
									</td> 
									<td>${info.mark}</td> 
									<td>
										<fmt:parseDate value="${info.createTime}" pattern="yyyyMMddHHmmss" var="date"></fmt:parseDate>
     									<fmt:formatDate value="${date}"  pattern="yyyy-MM-dd HH:mm"/>
     								</td> 
									<td>${info.userId}</td> 
									<td>${info.phone}</td> 
									<td>${info.ip}</td> 
								</tr>
						</c:forEach>  
                    </tbody>
                </table>
            </div>
            <br>
        <div id="page" style="padding-left: 30px;"></div>
    </form>
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
<!-- 分页功能 -->
	<script type="text/javascript">
		var nums = ${page.size}; //每页出现的数量
		var pages = ${page.totalPage}; //得到总页数
		//调用分页
		laypage({
		    cont: 'page',
		    pages: pages,
		    curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
		        var page = location.search.match(/currentPage=(\d+)/);
		        return page ? page[1] : 1;
		    	}(), 
		   	skip: true, //是否开启跳页
		   	skin: '#2A9BCF', //皮肤
		   	groups: 3, //连续显示分页数
		    jump: function(e, first){ //触发分页后的回调
		       if(!first){ //一定要加此判断，否则初始时会无限刷新
		         location.href = '?currentPage='+e.curr+'&'+$('form').serialize() ;
		       }
		    }
		})
	</script>
</body>
</html>