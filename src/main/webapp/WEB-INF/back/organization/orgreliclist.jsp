<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <!DOCTYPE html> -->
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
    <script type="text/javascript" src="../../../back/lib/html5shiv.js"></script>
    <script type="text/javascript" src="../../../back/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/header.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/headUserGover.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/asideUserGover.css">
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
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

        <%--新改的样式--%>
        *{
            <%--margin:0;--%>
            <%--padding:0;--%>
            <%--box-sizing:border-box;--%>
        }
        .addOrgWrap{
            height: 70px;
            border-top-left-radius: 7px;
            border-top-right-radius: 7px;
            background: #fff;
            box-sizing:border-box;
            border-bottom:1px solid #f1f2f7;
            padding-top:18px;
        }
        .addOrg{
            border-radius: 4px;
            background-color: rgb(42, 155, 207);
            width: 115px;
            height: 33px;
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(255, 255, 255);
            line-height: 33px;
            text-align:center;
        }
        .boxSize{
            box-sizing:border-box;
        }
        .bgWhite{
            background:#ffffff;
        }
        .Hui-article-box{
			overflow:auto !important;        
        }
        .pTop{
            padding-top:30px;
        }
        .border-radios{
            border-top-left-radius:4px;
            border-bottom-left-radius:4px;
        }
        .lastRadios{
            border-top-right-radius:4px;
            border-bottom-right-radius:4px;
        }
        #page{
            border-top:3px solid #f1f2f7;
            padding-top:30px;
            margin-left:-30px;
        }
        tbody .text-c:nth-last-child(1){
            border-bottom:none!important;
        }
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
    <title>组织机构管理文物局列表</title>
</head>
<body onselectstart="return false" style="-moz-user-select:none;">
<!--_heade 作为公共模版分离出去-->
<%@ include file="weihuNav.jsp"%>
<!--aside 作为公共模版分离出去-->
<%@ include file="../content/aside.jsp"%>

<section  class="Hui-article-box">
    <%--<div class="addOrgWrap pl-30">--%>
        <%--<div class="addOrg"><i class="Hui-iconfont">&#xe600;</i>添加组织机构</div>--%>
    <%--</div>--%>
    <div class="pl-30 pTop boxSize bgWhite">
        <form action="<%=request.getContextPath() %>/organization/relic/info.do" id="form" method="post">
        	<div class="hide">   
	        	每页显示条数:&nbsp; 
	            <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="${page.size }" name="size">
	        </div> 
            <div>
                <table class="table">
                    <thead>
                        <tr class="text-c">
                            <th width="80" class="border-radios">序号</th>
                            <th width="300">名称</th>
                            <th width="200">层级</th>
                            <th width="300">上级</th>
                            <th width="150" class="lastRadios">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                      <c:if test="${'1' eq level }">
                      	 <c:set var="recordNumber" value="${(page.currentPage - 1) * page.size }" /> 
                         <c:forEach items="${orgList}" var="org" varStatus="status">
							<tr class="text-c">
								<td>${status.count + recordNumber}</td>
		                        <td>${org.name}</td>
		                         <c:if test="${'1' eq org.level }">
                                	<td>1级</td>
                                </c:if>
                                 <c:if test="${'2' eq org.level }">
                                	<td>2级</td>
                                </c:if>
		                         <c:if test="${'0' eq org.parentId }">
                                	<td>国家文物局</td>
                                </c:if>
                                 <c:if test="${'16' eq org.parentId }">
                                	<td>山东省文物局</td>
                                </c:if>
                                <c:if test="${'7' eq org.parentId }">
                                	<td>吉林省文物局</td>
                                </c:if>
                                <c:if test="${'24' eq org.parentId }">
                                	<td>吉林省文物局</td>
                                </c:if>
		                        <td class="td-status">
		                        	<c:if test="${fn:contains(sessionScope.user.level,1)==true}">
                                    <a href="javascript:;" onclick="edit(${org.id})" class="mr-10"><img src="<%=request.getContextPath() %>/back/images/bianji.png" title="编辑"></a>
                                    </c:if>
                                    <a href="javascript:;" onclick="detail(${org.id})"><img src="<%=request.getContextPath() %>/back/images/chakan.png" title="查看"></a>
                                </td>
		                     </tr>
						</c:forEach> 
						</c:if> 
						<c:if test="${'2' eq level }">
						<td class="text-c"><input name="" type="checkbox" value="" ></td>
						<td class="text-c">001</td>
						<td class="text-c">${organization1.name }</td>
						<c:if test="${'1' eq level }">
                              <td class="text-c">1级</td>
                        </c:if>
                        <c:if test="${'2' eq level }">
                               <td class="text-c">2级</td>
                        </c:if>
						 <c:if test="${'0' eq organization1.parentId }">
                               <td class="text-c">国家文物局</td>
                         </c:if>
                        <c:if test="${'16' eq organization1.parentId }">
                               <td class="text-c">山东省文物局</td>
                        </c:if>
                        <c:if test="${'7' eq organization1.parentId }">
                               <td class="text-c">吉林省文物局</td>
                         </c:if>
						<td class="text-c">
                                    <a href="javascript:void(0);" onclick="edit(${organization1.id})" title="编辑"><img src="<%=request.getContextPath() %>/back/images/bianji.png"></a>
                                    <a href="javascript:void(0);" onclick="detail(${organization1.id})" title="查看"><img src="<%=request.getContextPath() %>/back/images/chakan.png"></a>
                        </td>
						</c:if>
                    </tbody>
                </table>
            </div>
            <div id="page" align="left" class="pl-30"></div>
        </form>
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
    //添加左边样式。
    $(".fabu-aside>ul>li").eq(3).addClass("weihu");
    $(".wenwuju").addClass("active");
    $(".headerNav a.wenwuju").find("img").attr("src",'<%=request.getContextPath() %>/back/images/jigouicon.png');
    <%--编辑--%>
    function edit(value){
    	var url = '<%=request.getContextPath() %>/organization/relic/edit.do?relicOrganizationId='+value;
        layer.open({
            type: 2,
            title: '文物局编辑',
            shadeClose: true,
            shade: 0.5,
            maxmin: true, //开启最大化最小化按钮
            area: ['880px', '600px'],
            content: [url,'no'],
            end: function () {
                location.reload();
            }
        });
    }
    <%--查看--%>
    function detail(value){
    	var url = '<%=request.getContextPath() %>/organization/relic/detail.do?relicOrganizationId='+value;
        layer.open({
            type: 2,
            title: '文物局详情',
            shadeClose: true,
            shade: 0.5,
            maxmin: true, //开启最大化最小化按钮
            area: ['880px', '600px'],
            content: [url,'no'],
            end: function () {
                location.reload();
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
    var abc="<span>每页显示<input style='width:50px;height: 28px;' type='number'  min='5' max='100' step='5' class='input-text' id='pageSize'   value='"+${page.size }+"' name='size'>条</span>";
	$(".laypage_total").before(abc); 
</script>  
</body>  
</html>     