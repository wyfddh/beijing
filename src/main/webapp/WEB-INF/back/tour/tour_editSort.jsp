<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
        *{
            margin: 0;
            padding: 0;
        }
        .a1{
            height: 414px;
            border:1px solid #e0e0e0;
            padding: 15px 10px 0;
        }
        .a2{
            height:70px;
            background-color: #f9f9f9;
            text-align: center;
        }
        .a2 img{
            transform: translateY(22px);
            cursor: pointer;
        }
        .a3{
            transform: translateX(-25px);
            margin-top: 12px;
            margin-left: 20px;
        }
        .a4{
            padding-bottom: 30px;
        }
        .a5{
            height:68px;
            background-color: #f9f9f9;
            margin-top: 12px;
            transition: all 0.5s;
            margin-left: 25px;
        }
        .a5:nth-child(1){
            margin-top: 0;
        }
        .a5:hover{
            transform: translate3d(0,0,1000px);
            box-shadow: 0 0 15px #ddd;
        }
        .a5 img{
            display: inline-block;
            float: left;
            width: 40px;
            height: 40px;
            margin-left: 18px;
            margin-top: 14px;
        }
        .a5 label{
            display: inline-block;
            float: left;
            width: 20px;
            height: 40px;
            margin-left: 18px;
            margin-top: 14px;
            padding-top: 10px;
        }
        .a6{
            width: 55%;
            font-size: 12px;
            float: left;
            margin-left: 10px;
            margin-top: 14px;
        }
        .a7{
            color: #666;
        }
        .a8{
            font-size: 12px;
            float: left;
            margin-left: 10px;
            margin-top: 14px;
        }
        .a8{
            font-size: 12px;
            float: left;
            margin-left: 50px;
            margin-top: 14px;
        }
        .a8 span{
            width: 29px;
            height: 29px;
            background-repeat: no-repeat;
            margin: 0px;
            margin-top: 10px;
            margin-left: 10px;
            display: block;
            background-position: 0px 29px;
            display: inline-block;
        }
        .a8 .up1 span{
            background: url(<%=request.getContextPath() %>/back/images/up.png) ;
        }
        .a8 .up2 span, .a8 .up3 span{
            background: url(<%=request.getContextPath() %>/back/images/up.png) ;
            background-position: 0px 29px;
        }
        .a8 .up2 span:hover, .a8 .up3 span:hover{
            background: url(<%=request.getContextPath() %>/back/images/up.png) ;
            background-position: 0px 104px;
        }
        .a8 .down1 span,.a8 .down2 span{
            background: url(<%=request.getContextPath() %>/back/images/down.png) ;
            background-position: 0px 29px;
        }
        .a8 .down1 span:hover,.a8 .down2 span:hover{
            background: url(<%=request.getContextPath() %>/back/images/down.png) ;
            background-position: 0px 104px;
        }
        .a8 .down3 span{
            background: url(<%=request.getContextPath() %>/back/images/down.png) ;
        }
    </style>
    <title>藏品专题-新建</title>
</head>
<body>
<section  class="contentWrap">
    <div class="a3">
        <div class="a4">
            <c:forEach items="${collectionList }" var="list" varStatus="num">
                <div class="a5">
                    <label>${num.index + 1 }</label>
                    <img src="${list.url }" alt="">
                    <div class="a6">
                        <div class="a7">${list.name }</div>
                    </div>
                    <span class="a8">
	                	<c:if test="${num.index == 0 and !num.last}">
                            <a class="up1" title="上移"><span></span></a>
                            <a class="down1 down" title="下移" onclick="editSort('down', '${list.tourCollectionId}');"><span></span></a>
                        </c:if>
	                	<c:if test="${num.index == 0 and num.last}">
                            <a class="up1" title="上移"><span></span></a>
                            <a class="down3" title="下移"><span></span></a>
                        </c:if>
	                	<c:if test="${num.index != 0 and !num.last }">
                            <a class="up2 up" title="上移" onclick="editSort('up', '${list.tourCollectionId}');"><span></span></a>
                            <a class="down2 down" title="下移" onclick="editSort('down', '${list.tourCollectionId}');"><span></span></a>
                        </c:if>
	                	<c:if test="${num.index != 0 and num.last }">
                            <a class="up3 up" title="上移" onclick="editSort('up', '${list.tourCollectionId}');"><span></span></a>
                            <a class="down3" title="下移"><span></span></a>
                        </c:if>
	                </span>
                </div>
            </c:forEach>
        </div>
    </div>
    </div>
</section>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<%--<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui.admin/js/H-ui.admin.page.js"></script>--%>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>

<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.all.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/lang/zh-cn/zh-cn.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">

    function editSort(type, id){
        $.ajax({
            type: "POST",
            url: "<%=request.getContextPath() %>/tour/editSequence.do",
            data: {id:id, type: type},
            dataType: "json",
            success: function(data){
                if(data.success == 1){
                    location.reload();
                }else{
                    alert(data.data);
                }
            }
        });
    }

    //点击取消按钮
    $("#cancel").click(function(){
        top.layer.confirm('您确定要退出本页面吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.closeAll();  //关闭弹出层
            window.history.back(-1);  //关闭弹出层
        }, function(){
            layer.closeAll();  //关闭弹出层
        });
    })
</script>
</body>
</html>