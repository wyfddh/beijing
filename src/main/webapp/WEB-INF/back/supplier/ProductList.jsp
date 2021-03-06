<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
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
    <script type="text/javascript" src="../../../../../back/lib/html5shiv.js"></script>
    <script type="text/javascript" src="../../../../../back/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/header.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/headUserGover.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/asideUserGover.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/checkList.css"/>
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
				$(".fabu-aside>ul>li").eq(4).addClass("gongyingshang");
				$(".headerNav a.chanpinguanli").addClass("active");
				$(".headerNav a.chanpinguanli img").attr("src",'<%=request.getContextPath() %>/back/images/qiyechanpinguanliicon.png');
			})
		</script>
    <title>企业产品管理</title>
</head>
<body>
	<!--_header 作为公共模版分离出去-->
	<%@ include file="supplierNav.jsp"%>

	<!--_menu 左边slide导航开始-->
	<%@ include file="../content/aside.jsp"%>
	<!--/_menu 作为公共模版分离出去-->
<!--<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>-->
<section  class="Hui-article-box">
    <!--<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 内容管理 <span class="c-gray en">&gt;</span>历史吉林文章管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>-->
    <div class="Hui-article">
        <form action="<%=request.getContextPath()%>/cProduct/getCproductsList.do" class="huodong">
                <div>
                	公司名称：
                    <input style="width: 190px;height: 26px;" type="text" name="companyName" value="" class="input-text" placeholder="">
                   	&nbsp;	&nbsp;	&nbsp;
                   	 产品名称：
                    <input style="width: 190px;height: 26px;" type="text" name="productName" value="" class="input-text" placeholder="">
                </div>
                 <div class="star">
								<button class="btn b1" type="submit" title="搜索"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
								<button class="btn b2" type="reset" title="重置"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>	
				</div>
             </form>
            <%-- <div class="" style="min-width: 1020px;padding-left: 30px">
						<span class="r" style="margin-right:35px;">共<strong style="color: #57AAD6;">${list.page.allRow}</strong>条数据</span>
			</div> --%>
            <div style="clear: both"></div>
            <div style="min-width: 1020px;padding-left: 30px;padding-right: 30px;">
                <table class="table">
                    <thead>
                    <tr class="text-c">
                        <th width="80">序号</th>
                        <th width="500">产品名称</th>
                        <th width="500">公司名称</th>
                        <th width="200">产品价格(元)</th>
                        <th width="200">状态</th>
                        <th width="300">创建时间</th>
                        <th width="300">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    
                    <c:forEach items="${list}" var="conn"  varStatus="status">
							<tr class="text-c">
								<td>${status.count}</td>
								<td>${conn.productName}</td>
								<td>${conn.compayName}</td>
								<td>${conn.productPrice}</td>
								<td>已上架</td> 
								<td class="td-status"><span>
								<fmt:parseDate value="${conn.createTime}" pattern="yyyyMMddHHmmss" var="date"></fmt:parseDate>
     								<fmt:formatDate value="${date}"  pattern="yyyy-MM-dd HH:mm:ss"/>
								</span></td>
								<!-- 预览的地址栏需要修改 -->
								<td class="td-manage">
										<a title="查看" href="<%=request.getContextPath()%>/cProduct/getCpoducts.do?id=${conn.id}" target="_blank">
											<img src="<%=request.getContextPath() %>/back/images/chakan.png" alt="" />
										</a>&nbsp;
										<a id='${conn.id}' class="checkList_shenhe" style="border: 1px solid #2A9BCF; color: #2A9BCF;padding: 5px 10px;border-radius: 5px;text-decoration: none;position: relative;top: 3px;" style="text-decoration:none"title="启用">
											下架
										</a>&nbsp;
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
<script type="text/javascript">
$(".checkList_shenhe").on("click",function(e){
	
	var id=$(this).attr("id");

	layer.open({
        type: 1,
        title: "审核企业信息",
        shadeClose: true,
        shade: 0.5,
        maxmin: false, //开启最大化最小化按钮
        area: ['700px', '545px'],
        content:
        	"<div style='padding:25px'>"
            	+"<form >"
	            	+"<input type='hidden' name='id' value='"+id+"'>"
	            	+"<h3 style='font-size:14px;position:relative;top:-10px;'>下架原因：</h3>"
	            	+"<textarea maxlength='50' placeholder='请输入下架原因,50字以内' class='checkList_content' name='auditMsg'></textarea>"
	            	+"<input type='button' class='zj_checkList_save' value='确认'>"
	            	+"<input type='button' class='zj_checkList_cancel' value='取消' onclick='layer.closeAll()'>"
            	+"</form>"
        	+"</div>"
    });
    
    $(".zj_checkList_save").unbind().on("click",function(){
		var auditMsg=$(".checkList_content").val();    			
		$.ajax({
		 	url:'<%=request.getContextPath()%>/cProduct/undercarriageCproducts.do',
		  	type:'get',
		  	data:{
		  		id:id,
		  		reason:auditMsg
		  	},
		  	dataType:"text",
		  	success: function(data){
		  		if(data){
		  		layer.msg("下架成功");
		  		setTimeout(function(){window.location.reload()},2000);
		  		}else{
		  		layer.msg("下架失败");
		  		setTimeout(function(){window.location.reload()},2000);
		  		}
		  		
		   	},
		  	error: function(){
		   		alert('error');
		   	}
		});
	});
});
//启用的功能
function release(publish, id) {
		var b ="";
				if(publish == 0) {
					var a = "停用";
					b = "/cCompany/notEnable.do";
				} else if(publish == 1) {
					var a = "启用";
					b = "/cCompany/enable.do";
				}
				layer.confirm('确定' + a + '此信息？', {
					btn: ['确定', '再想想'] //按钮
				}, function() {
					$.ajax({
						url: "<%=request.getContextPath()%>"+b,
						type: "post",
						data: {
							id: id,
						},
						async: false,
						dataType: "text",
						success: function(data) {
							if(data == "1") {
							
								window.location.href = '<%=request.getContextPath()%>/cCompany/getCcompanies.do';
								
							}
						},
						error: function() {
							alert("启用失败，请联系xxx");
						}
					})
				}, function() {
					layer.msg('已取消启用', {});
				});
			}

</script>
<!-- 分页功能 -->
	<script type="text/javascript">
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