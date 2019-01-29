<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="favicon.ico" >
    <link rel="Shortcut Icon" href="favicon.ico" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <!--/meta 作为公共模版分离出去-->
    <title>轮播图列表</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <style>
        .boxSize{
            box-sizing:border-box;
        }
        .bgWhite{
            background:#ffffff;
        }
        .pTop{
            padding-top:30px;
        }
        tbody .text-c:nth-last-child(1){
            border-bottom:none!important;
        }
        .border-radios{
            border-top-left-radius:4px;
            border-bottom-left-radius:4px;
        }
        .lastRadios{
            border-top-right-radius:4px;
            border-bottom-right-radius:4px;
        }
        .bottomline{
            width:100%;
            height:3px;
            background:#f1f2f7;
        }
    </style>
</head>
<body>
<!--_header 作为公共模版分离出去-->
 <%@ include file="../organization/weihuNav.jsp"%>
<!--_menu 左边slide导航开始-->
 <%@ include file="aside.jsp" %> 

<section class="Hui-article-box">
    <div class="pl-30 pTop boxSize bgWhite">
        <form action="" method="post">
            <div>
                <table class="table table-hover">
                    <thead>
                        <tr class="text-c">
                            <th width="50" class="border-radios">序号</th>
                            <th width="100">轮播图位置</th>
                            <th width="100">图片数量</th>
                            <th width="100">最新编辑时间</th>
                            <th width="150">最新编辑人</th>
                            <th width="100" class="lastRadios">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${mipCarouselPositions}" var="cap" varStatus="status">
                            <tr class="text-c">
                                <td>${status.index + 1}</td>
	    	                    <td>${cap.name}</td>
	    	                    <td>${cap.count}</td>
	    	                    <td>${cap.updateTime}</td>
	    	                    <td>${cap.uid}</td>
	    	                    <td class="td-manage"><a title="编辑" href="<%=request.getContextPath()%>/turnimghome/getMipCarouselList.do?carouselPositionId=${cap.id}" class="ml-5" style="text-decoration:none"><img src="<%=request.getContextPath() %>/back/images/bianji.png"></a></td>
	    	                </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
    <div class="bottomline"></div>
</section>
<%--<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>--%>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    $(".fabu-aside>ul>li").eq(3).addClass("weihu");
    $(".turnImg").addClass("active");
    $(".headerNav a.turnImg").find("img").attr("src",'<%=request.getContextPath() %>/back/images/lunbotuicon.png');
</script>
</body>
</html>