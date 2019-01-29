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
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
    <!--/meta 作为公共模版分离出去-->
    <style type="text/css">
        *{
            padding:0;
            margin:0;
        }
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
            padding: 30px 0 0 30px;
        }
        .huodong input{
            line-height: 26px;
            border-radius: 5px;
        }
        .huodong .brnWrap button{
            background: #2A9BCF;
            color: #fff;
            border-radius: 5px;
        }
        .huodong .brnWrap button img{
            margin-top: -3px;
        }
        .huodong .brnWrap button.b2{
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
        thead>tr>th:nth-child(1){
            border-top-left-radius:7px;
            border-bottom-left-radius:7px;
        }
        thead>tr>th:nth-last-child(1){
            border-top-right-radius:7px;
            border-bottom-right-radius:7px;
        }
        tbody>tr>th{
            font-size: 14px!important;
            font-family: "Microsoft YaHei"!important;
            color: rgb(51, 51, 51)!important;
        }
        .selectInput{
            border: 1px solid rgb(241, 242, 247);
            border-radius: 4px;
            background-color: rgb(252, 252, 252);
            width: 188px;
            height: 24px;
        }
        .zhanghaoInput{
            border: 1px solid rgb(241, 242, 247);
            border-radius: 4px;
            background-color: rgb(252, 252, 252);
            width: 193px;
            height: 24px;
            box-sizing:border-box;
            padding-left:10px;
        }
        .brnWrap{
            width:100%;
            height:65px;
            padding-top:15px;
            box-sizing:border-box;
        }
        .tableWrap{
            min-width:1020px;
            padding-left:30px;
        }
        .checkDetail{
            width:26px;
            height:26px;
            cursor:pointer;
        }
        .xiajia{
            width:48px;
            height:23px;
            border: 1px solid rgb(42, 155, 207);
            border-radius: 4px;
            box-sizing:border-box;
            font-size: 12px;
            font-family: "Microsoft YaHei";
            color: rgb(42, 155, 207);
            line-height: 21px;
            background:#fff!important;
            cursor:pointer;
            margin-top:1px;
            margin-left:10px;
        }
        .layui-layer-page{
            border-radius:7px!important;
            overflow:hidden!important;
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
            font-size: 18px!important;
            font-family: "PingFang";
            color: rgb(51, 51, 51);
            font-weight: bold;
        }
        .layui-layer-setwin{
            top:30px!important;
        }
        .reasonWrap{
            width:100%;
            height:345px;
            padding:30px;
            box-sizing:border-box;
        }
        .reasonTitle{
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(51, 51, 51);
        }
        .reasonContent{
            border: 1px solid rgb(241, 242, 247);
            border-radius: 4px;
            background-color: rgb(252, 252, 252);
            width: 647px;
            height: 198px;
            box-sizing:border-box;
            margin-top:10px;
            resize:none;
        }
        .coverBtn{
            width:100%;
            padding-top:20px;
        }
        .coverBtn > button{
            border:1px solid rgb(42, 155, 207);
            box-sizing:border-box;
            border-radius: 4px;
            background-color: rgb(42, 155, 207);
            width: 101px;
            height: 36px;
            font-size: 14px;
            font-family: "Microsoft YaHei";
            color: rgb(255, 255, 255);
            margin-right:10px;
            cursor:pointer;
        }
        .coverBtn > button > img{
            width:18px;
            height:18px;
            margin-right:5px;
        }
        .coverBtn > button:nth-child(2){
            background:#fff;
            color:rgb(42, 155, 207);
        }
    </style>
    <title>文创产品管理</title>
</head>
<body>
<!--_header 作为公共模版分离出去-->
<%@ include file="../supplierNav.jsp"%>

<!--_menu 左边slide导航开始-->
<%@ include file="../../content/aside.jsp"%>

<section  class="Hui-article-box">
    <div class="Hui-article">
        <form action="<%=request.getContextPath()%>/cWenChuang/getWenChuangList.do" class="huodong">
            <div class="searchTitle">
                <span>
                    文创类型：
                    <select class="selectInput" type="text" name="categoryId" value="${curStatus}">
                        <option value="">--请选择--</option>
                        <c:forEach items="${categories}" var="var" varStatus="num">
                            <option value="${var.id}" <c:if test="${var.id == categoryId}">selected</c:if> > ${var.categoryName}</option>
                        </c:forEach>
                    </select>
                </span>
                <span class="ml-30">
                    登录账号：
                    <input type="text" name="key" value="${key}" class="zhanghaoInput" placeholder="文创产品名称/公司名称">
                </span>
            </div>
            <div class="brnWrap">
                <button class="btn b1 mr-20" type="submit" title="搜索"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
                <button class="btn b2" type="reset" title="重置"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>
            </div>
        </form>
        <div class="tableWrap">
            <table class="table">
                <thead>
                    <tr class="text-c">
                        <th width="60">序号</th>
                        <th width="200">文创产品名称</th>
                        <th width="200">公司名称</th>
                        <th width="150">文创类型</th>
                        <th width="100">产品价格(元)</th>
                        <th width="200">创建时间</th>
                        <th width="200">操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${wenChuangList}" var="article" varStatus="status">
                        <tr  class="text-c">
                            <td>${status.count}</td>
                            <td>${article.productName}</td>
                            <td>${article.userName}</td>
                            <td>${article.categoryName}</td>
                            <td>${article.productPrice}</td>
                            <td>${article.createTimeStr}</td>
                            <td>
                                <a  href="<%=request.getContextPath()%>/cWenChuang/getCWenChuangDetail.do?id=${article.id}" target="_blank" title="查看">
                                    <img class="checkDetail" src="<%=request.getContextPath() %>/back/images/yulanicon.png">
                                </a>
                                <button class="xiajia" data="${article.id}">下架</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <br>
        <div id="page" style="padding-left: 30px;"></div>
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
    <%--css样式添加--%>
    $(function(){
        $(".fabu-aside>ul>li").eq(4).addClass("gongyingshang");
        $(".headerNav a.wenhuaguanli").addClass("active");
        $(".headerNav a.wenhuaguanli img").attr("src",'<%=request.getContextPath() %>/back/images/qiyewenchuangguanliicon.png');

        <%--下架--%>
        var paramsId;             //要下架的那个id
        var layerReason;          //定义一个layer
        $("tbody").delegate(".xiajia","click",function(){
            paramsId = $(this).attr("data");              //拿到要下架的id
            layerReason = layer.open({
                type: 1,
                title: '下架文创产品',
                shadeClose: true,
                shade: 0.5,
                maxmin: true, //开启最大化最小化按钮
                area: ['700px', '425px'],
                content:''+
                    '<form>'+
                        '<div class="reasonWrap" id="reasonWrap">'+
                            '<span class="reasonTitle">下架原因</span>'+
                            '<textarea id="reason" cols="20" class="reasonContent"></textarea>'+
                            '<div class="coverBtn">'+
                                '<button class="confirm"><img src="<%=request.getContextPath() %>/back/images/save.png">确认</button>'+
                                '<button class="cancel"><img src="<%=request.getContextPath() %>/back/images/cancel.png">取消</button>'+
                            '</div>'+
                        '</div>'+
                    '</form>',
            });
        });

        //点击确定下架
        $(document).on('click', '.confirm', function(e) {
            e = e || event;
            e.preventDefault();
            var reason = $("#reason").val();                //下架原因
            $.ajax({
                url:"<%=request.getContextPath()%>/cWenChuang/publishDown.do",
                type:"GET",
                data:{
                    id:paramsId,
                    reason:reason
                },
                dataType:"json",
                async:false
            }).success(function(response){
                layer.close(layerReason);                     //关闭layer
                console.log(response);
                if(response == 1){
                    window.location.reload();
                }else{
                    layer.msg("下架失败",{time:2000});
                }
            }).error(function(error){
                console.log(error)
            })
        });
        //取消下架
        $(document).on('click', '.cancel', function(e) {
            e = e || event;
            e.preventDefault();
            layer.closeAll();
        });
        <%--分页--%>
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
            skip: true,                                                         //是否开启跳页
            skin: '#2a9bcf',                                                     //皮肤
            groups: 3, //连续显示分页数
            jump: function(e, first){                                           //触发分页后的回调
                if(!first){                                                     //一定要加此判断，否则初始时会无限刷新
                    location.href = '?currentPage='+e.curr+'&'+$('form').serialize() ;
                }
            }
        })
    });
</script>
</body>
</html>