<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String wwxxwip = "http://test.tj720.com/mip/pc/index.html#/displayDetails/inner/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="<%=request.getContextPath()%>/back/favicon.ico">
    <link rel="Shortcut Icon" href="<%=request.getContextPath()%>/back/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/css/cover.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
    <!--/meta 作为公共模版分离出去-->
    <style>

        body{
            background-color: #FFF;
        }
        .headerNav{
            height: 98px;
            border-radius: 7px;
            background: #fff;
            position: absolute;
            top: 0px;
            left: 145px;
            right: 0;
            bottom: 0;
            line-height: 98px;
            padding-left: 30px;
        }
        .headerNav a{
            color: #2A9BCF!important;
            display: inline-block;
            height: 24px;
            line-height: 24px;
            border: 1px solid #2A9BCF;
            padding: 7px 20px;
            border-radius: 5px!important;
            text-decoration: none!important;
            margin-right: 24px!important;
        }
        .headerNav a:hover{
            color: #2A9BCF!important;
            background: #fff!important;
        }
        .headerNav a.zhanlan{
            color: #fff!important;
            background: #2A9BCF!important;
        }
        .headerNav a img{
            width: 18px;
            height: 18px;
            margin-top: -5px;
            margin-right: 5px;
        }
        .addZhanxun{
            overflow: hidden;
            height: 72px;
            border-bottom: 1px solid #F1F2F7;
        }
        .addZhanxun>span{
            margin: 20px 32px;
        }
        .addZhanxun>span>a{
            background: #2A9BCF!important;
        }
        .addZhanxun>span>a:hover{
            border-color: #2A9BCF!important;
        }
        .info{
            padding-left: 32px;
        }
        .info div{
            margin: 10px 0;
        }
        .info input{
            line-height: 26px;
            border-radius: 5px;
        }
        .info .star{
            margin-top: 20px;
        }
        .info .star button{
            background: #2A9BCF;
            color: #fff;
            border-radius: 5px;
        }
        .info .star button img{
            margin-top: -3px;
        }
        .info .star button.b2{
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

    <title>藏品专题库</title>
</head>

<body>

<!-- 数据内容 -->
<div class="Hui-article">
    <article>
        <div class="info" style="margin-top: 30px;">
            <form action="<%=request.getContextPath()%>/topic/goSelectCollection.do" method="post" id="form">
                <div class="guanjianci">
                    关键词：<input type="text" name="name" value="${name}" placeholder="藏品名称" style="width:190px;height:26px" class="input-text">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;藏品类别：
                    <span class="select-box" style="width:102px;height:26px;padding:2px 5px;border-radius: 5px;">
									<select class="select" name="collectionsCategory"  size="1">
										<option value="">全部</option>
										<c:forEach items="${category }" var="cate">
                                            <option value="${cate.id }">${cate.name }</option>
                                        </c:forEach>
									</select>
								</span>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;藏品年代：
                    <span class="select-box" style="width:102px;height:26px;padding:2px 5px;border-radius: 5px;">
									<select class="select" name="yearType"  size="1">
										<option value="">全部</option>
										<c:forEach items="${year }" var="year">
                                            <option value="${year.id }">${year.name }</option>
                                        </c:forEach>
									</select>
								</span>
                </div>
                <div class="star">
                    <button class="btn b1" type="button" onclick="initTable(1);"><img src="<%=request.getContextPath() %>/back/images/fangdajing.png" alt="" />搜索</button>
                    <button class="btn b2" type="button" onclick="formReset();"><img src="<%=request.getContextPath() %>/back/images/chongzhi.png" alt="" />重置</button>
                </div>
                <div class="star">
                    <span style="margin-right:20px;">已选择<strong style="color: #57AAD6;" id="isSelectedNum">0</strong>条数据</span>
                    <button class="btn b1" type="button" onclick="confirm();"><i class="Hui-iconfont">&#xe6a7;</i>批量添加</button>
                </div>
                <div class="hide">
                    每页显示条数:&nbsp;
                    <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="pageSizeHide"  value="" name="size">
                    <input  style="width: 110px;height: 26px;padding-left: 10px;" type="text" class="input-text" id="tourId"  value="${tourId}" name="tourId">
                </div>
                <div style="clear:both"></div>
            </form>
        </div>

        <div class="" style="min-width: 1020px;padding-left: 30px">
            <span class="r" style="margin-right:35px;">共<strong style="color: #57AAD6;" id="allRow"></strong>条数据</span>
        </div>

        <div class="" style="min-width: 1020px;padding-left: 30px;">
            <table class="table table-hover table-sort">
                <thead>
                <tr class="text-c">
                    <th width="20"><input type="checkbox" class="item-title"></th>
                    <th width="20">序号</th>
                    <th width="50">藏品名称</th>

                    <th width="60">类别</th>
                    <th width="80">级别</th>
                    <th width="80">年代</th>

                    <th width="100">存放博物馆</th>
                    <th width="80">操作</th>
                </tr>
                </thead>
                <tbody id="table-tbody">
                <tr class="text-c">
                    <td colspan="7" style="text-align: center;">无数据</td>
                </tr>
                </tbody>
            </table>
        </div>
        <br>
        <div id="page" style="padding-left: 30px;"></div>
    </article>
</div>
</section>



<!-- 数据内容结束 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jQueryPrint/jQuery.print.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jQueryPrint/clipboard.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript">
    var nums = 1; //每页出现的数量
    var totalPage = 1; //得到总页数
    initTable(1);
    function initTable(currentPage){
        $.ajax({
            type: "GET",
            url: "<%=request.getContextPath() %>/tour/getSelectCollectionData.do?page=" + currentPage + "&" + $('form').serialize(),
            data: {},
            dataType: "json",
            success: function(data){
                if(data.success == 1){
                    var datas = data.data;
                    var pages = data.page;
                    $("#table-tbody").html("");
                    $(".item-title").removeAttr("checked");
                    var num = (pages.currentPage - 1) * pages.size;
                    if(datas.length > 0){
                        for (var i = 0; i < datas.length; i++) {
                            var tableDate = '<tr class="text-c">';
                            var index = item.indexOf(datas[i].id);
                            if (index == -1) {
                                tableDate += '<td><input type="checkbox" class="item" value="'+datas[i].id+'" onclick="selectItme(this);"></td>';
                            }else{
                                tableDate += '<td><input type="checkbox" class="item" value="'+datas[i].id+'" onclick="selectItme(this);" checked></td>';
                            }
                            tableDate += '<td>'+(i+1+num)+'</td>';
                            tableDate += '<td>'+datas[i].name+'</td>';
                            tableDate += '<td>'+datas[i].collectionsCategory+'</td>';
                            tableDate += '<td>'+datas[i].collectionLevel+'</td>';
                            tableDate += '<td>'+datas[i].yearType+'</td>';
                            tableDate += '<td>'+datas[i].collectionUnit+'</td>';
                            tableDate += '<td>'+'<button class="layui-btn layui-btn-normal" onclick="submit(\''+datas[i].id+'\')">+添加</button>' +'</td>';
                            $("#table-tbody").append(tableDate);
                        }
                    }else{
                        $("#table-tbody").append('<td colspan="7" style="text-align: center;">无数据</td>');
                    }
                    nums = pages.size;
                    totalPage = pages.totalPage;
                    $("#pageSizeHide").val(nums);
                    $("#allRow").text(pages.allRow);
                    initPage(nums, totalPage, pages.currentPage);
                }else{

                }
            }
        });
    }



</script>
<script type="text/javascript">
    var item = [];

    function selectItme(e){
        if($(e)[0].checked){
            var index = item.indexOf($(e).val());
            if (index == -1) {
                item.push($(e).val());
            }
        }else{
            var index = item.indexOf($(e).val());
            if (index > -1) {
                item.splice(index, 1);
            }
        }
        $("#isSelectedNum").text(item.length);
        console.log(item);
    }
    $(".item-title").click(function(){
        if($(this)[0].checked){
            $(".item").each(function () {
                var index = item.indexOf($(this).val());
                if (index == -1) {
                    item.push($(this).val());
                }
            });
        }else{
            $(".item").each(function () {
                var index = item.indexOf($(this).val());
                if (index > -1) {
                    item.splice(index, 1);
                }
            });
        }
        $("#isSelectedNum").text(item.length);
        console.log(item);
    });


    function confirm(){
        $.ajax({
            type: "GET",
            url: "<%=request.getContextPath() %>/tour/batchSaveCollection.do",
            data: {tourId:$("#tourId").val(), collectionIds:item.join()},
            dataType: "json",
            success: function(data){
                if(data.success == 1){
                    layer.msg("保存成功");
                }else{
                    layer.msg("保存失败");
                }
                var index=parent.layui.layer.getFrameIndex(window.name);
                parent.layui.layer.close(index);
            }
        });
    }
    function formReset(){
        $(".guanjianci input").val("");
        $(".guanjianci select").val("");
    }

    function submit(collectionId) {
        $.ajax({
            type: "GET",
            url: "<%=request.getContextPath() %>/tour/batchSaveCollection.do",
            data: {tourId:$("#tourId").val(), collectionIds:collectionId},
            dataType: "json",
            success: function(data){
                if(data.success == 1){
                    layer.msg("保存成功");
                }else{
                    layer.msg("保存失败");
                }
                var index=parent.layui.layer.getFrameIndex(window.name);
                parent.layui.layer.close(index);
            }
        });
    }

</script>

<!-- 分页功能 -->
<script type="text/javascript">
    function initPage(nums, pages, currentPage){
        //调用分页
        laypage({
            cont: 'page',
            pages: pages,
            curr: function() { //通过url获取当前页，也可以同上（pages）方式获取
                return currentPage ? currentPage : 1;
            }(),
            skip: true, //是否开启跳页
            skin: '#2A9BCF', //皮肤
            groups: 3, //连续显示分页数
            jump: function(e, first) { //触发分页后的回调
                if(!first) { //一定要加此判断，否则初始时会无限刷新
                    initTable(e.curr);
// 							location.href = '?page=' + e.curr + '&' + $('form').serialize();
                }
            }
        })
        var abc="<span>每页显示<input style='width:50px;height: 28px;' type='number'  min='5' max='100' step='5' class='input-text' id='pageSize'   value='"+nums+"' name='size'>条</span>";
        $(".laypage_total").before(abc);
    }
</script>
</body>

</html>