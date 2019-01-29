<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script>
    <style>
        .top{
            height: 300px;
            border-radius: 7px;
            background: #fff;
            position: absolute;
            top: 0px;
            left: 0px;
            right: 0;
            bottom: 0;
            padding-left: 30px;
        }
        .mycontainer{
            margin-left:1px;
            margin-right:1px;
        }
        .myrow{
            margin-top:15px;
            height:40px;
            margin-right:50px;
        }
        .main{
            border-radius: 7px;
            background: #fff;
            position: absolute;
            top: 320px;
            left: 0px;
            right: 0;
            bottom: 0;
            padding-left: 30px;
        }
        .images{
            width:100px;
            height:100px;

        }
        .img:hover .imgdiv{
            display:block
        }
        .imgdiv{
            position: absolute;
            background: #ccc;
            height:100%;
            display:none;
            opacity:0.6;
        }
        .img{
            width:100px;
            height:100px;
            margin:15px;
        }
        .imageList{
            font-size:25px;
            margin:15px;
        }
        .iconColor{
            color:rgba(243, 149, 29, 0.68);
            opacity:0.8;
        }
        .delete{
            position:absolute;
            left:1px;
            bottom:1px;
        }
        .show{
            position:absolute;
            right:1px;
            bottom:1px;
        }
        .addcollection{
            color:#004cffa3;
            margin-left:5px;
            font-weight:500;
        }
        .gocollectionList{
            color:#004cffa3;
            margin-left:5px;
            font-weight:500;
        }
        .empty{
            position:relative;
            left:37%;
            margin-top:10px;
            font-size: 14px;
            font-weight: normal;
        }
        .picDiv{
            position:relative;
            left:40%;
            top:10%;
        }

        .introduction {
            margin: 10px 0 15px;
            font-size: 14px;
            line-height: 1.6em;
            color: #5e646b;

        }
        .imageInfo{

        }
        .labelcss{
        	width: 200px;
        	overflow: hidden;
        	text-overflow: ellipsis;
        }
        .labelcss p{
        	max-height: 54px;
        }
        .labelcss label{
            font-weight:bold;
        }
        .labelcss1{
        	max-width: 200px;
        	overflow: hidden;
        	text-overflow: ellipsis;
        }
        .labelcss1 p{
        	max-height: 120px;
        }
        .labelcss1 label{
            font-weight:bold;
        }
        .shou{
            cursor:pointer;
        }
    </style>

    <title>编辑导览</title>
</head>

<body>
<!--/_menu 作为公共模版分离出去-->
<div class="top">
    <div class="container mycontainer">
        <div class="row myrow">
            <div class=" col-md-3">
                <img src="${tour.iconUrl}" id="iconUrl" onerror="Javascript:this.src='<%=request.getContextPath() %>/back/images/null_pic-12491114727.jpg' " width="200px" height="200px">
                <input type="hidden" class="layui-input" name="iconUrl" id="iconUrlPlus" value="${tour.iconUrl}">
            </div>
            <div class=" col-md-5">
                <div class="row myrow">
                    <div class="col-md-12 labelcss">
                        <label id="name" style="font-size:16px;font-weight:bold;">${tour.name}</label>
                        <input  type="hidden" value="${tour.id}" id="tourId">
                    </div>
                </div>

                <div class="row myrow">
                    <div class="col-md-6 labelcss">
                    <i class="Hui-iconfont">&#xe60d;</i>
                    <label>创建人</label>
                    <p id="publishOrg" style="color:gray;" class="introduction" title="${tour.publishOrgName}">${tour.publishOrgName}</p>
                    </div>
                    <div class="col-md-6 labelcss">
                    <i class="Hui-iconfont">&#xe6c9;</i>
                    <label>数字展厅地址</label>
                    <p id="exhibitionHall" style="color:gray;" class="introduction" title="${tour.virtualUrl}">${tour.virtualUrl}</p>
                    </div>
                </div>

                <div class="row myrow">
                    <div class="col-md-12 labelcss" title="${tour.address}">
	                    <i class="Hui-iconfont">&#xe690;</i>
	                    <label>地址</label>
	                    <p  id="address" style="color:gray;" class="introduction">${tour.address}</p>
                    </div>
                    
                    <div class="col-md-12 labelcss1">
	                    <i class="Hui-iconfont">&#xe64b;</i>
	                    <label>标签</label>
	                    <p  style="color:gray;"  class="introduction">
	                    <span id="label">
	                    <c:if test="${tour.label ne null && tour.label!=''}">${tour.label}</c:if>
	                    <c:if test="${tour.label == null || tour.label ==''}">暂无标签</c:if>
	                    </span>
	                    </p>
                    </div>
                </div>

                <div class="row myrow">
                </div>
            </div>
            <div class=" col-md-4">
                <div class="row myrow">
                    <div class="col-md-12">
                        <div style="position:absolute;right:0px;">
                            <c:if test="${tour.status != '2'}">
                            <input class="btn btn-primary-outline radius size-s" type="button" id="edit" value="编辑">
                            </c:if>
                            <input class="btn btn-primary-outline radius size-s" type="button" id="back"  value="关闭">
                        </div>
                    </div>
                </div>

                <div class="row myrow">
                    <div class="col-md-12 labelcss">
                        <label style="font-weight:bold;">展览介绍</label>
                        <p id="introduction" class="introduction" title="${tour.introduction}">
                        	${tour.introduction}
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="main">
    <div class="row" >
        <div class="col-md-3">
            <div>
                <label style="font-size:16px;font-weight:700;">专题藏品</label>
                <label style="font-size:14px;color: gray;" id="collectionCount"></label>
                <c:if test="${tour.status != '2'}">
                    <label class="shou" style="color:cornflowerblue;" id="addCollection">+添加</label>
                    <label class="shou" style="color:cornflowerblue;" id="sort">排序</label>
                </c:if>
            </div>
        </div>
        <div class="col-md-9" >
            <div style="position:relative;float:right;margin-right: 10px;">
                <i class="Hui-iconfont iconColor" id="imageList" style="font-size:25px;cursor:pointer"> &#xe6c0;</i>
                <i class="Hui-iconfont" id="imageLi" style="font-size:25px;cursor:pointer">&#xe6bf;</i>
            </div>
        </div>
    </div>
    <hr>
    <div class="row imageInfo" id="images">

    </div>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<!-- 数据内容结束 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jQueryPrint/jQuery.print.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jQueryPrint/clipboard.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/qrcode.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jQueryPrint/jQuery.print.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jQueryPrint/clipboard.min.js"></script>
<script type="text/javascript">
    var tourId = $("#tourId").val();
    layui.use(['form','layer','table'],function(){
        var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery;
        var table = layui.table;

        var index1=parent.layer.getFrameIndex(window.name);
        parent.layer.full(index1);

        var imageList = [];

        init();
        function init(){
            var tourId = $("#tourId").val();
            //加载图集
            var json = {"tourId":tourId};
            $.ajax({
                url: "<%=request.getContextPath()%>/tour/getCollectionList.do",
                type: "post",
                data: json,
                async: false,
                dataType: "text",
                success: function(result) {
                    result =  eval("(" + result + ")");
                    var list = result.data;
                    imageList = list;
                    if(null != list && list.length>0){
                        var htmlStr = "";
                        for (var i = 0; i < list.length; i++) {
                            var url = list[i].url;
                            var id = list[i].id;
                            var tempHtml = "";
                            if(i/12==0){
                                tempHtml = "<div class='row'>"
                                    +"<div class='col-md-1 img'><div class='col-md-12 imgdiv'><img data="+id+" class='delete'/><img data="+id+" class='show'/></div><img src="+url+" class='images'/></div>";
                            }
                            else{
                                if((i+1)/12==0){
                                    tempHtml = "<div class='col-md-1 img'><div class='col-md-12 imgdiv'><img data="+id+" class='delete'/><img data="+id+" class='show'/></div><img src="+url+" class='images'/></div>"
                                        +"</div>";
                                }else{
                                    tempHtml = "<div class='col-md-1 img'><div class='col-md-12 imgdiv'><img data="+id+" class='delete'/><img data="+id+" class='show'/></div><img src="+url+" class='images'/></div>";
                                }
                            }
                            htmlStr = htmlStr+tempHtml;
                        }
                        $("#images").html(htmlStr);
                        $(".delete").attr("src","<%=request.getContextPath()%>/back/images/delete.svg");
                        $(".show").attr("src","<%=request.getContextPath()%>/back/images/show.svg");
                    }else{
                        $("#sort").hide();
                        var picStr = "<div class='picDiv'><img src='../back/images/Group 3.png'></img></div>"
                        var htmlStr = "<div class='empty'><p>您还没有添加藏品呢，赶快添加藏品充实您的专题~<a class='addcollection'>开始添加</a></p></div>";
                        htmlStr = picStr+htmlStr;
                        $("#images").html(htmlStr);
                    }
                    var str = list.length+"件藏品";
                    $("#collectionCount").text(str);

                },
                error: function() {
                    alert("数据请求异常，请联系管理员");
                }
            })
        }
        //编辑按钮
        $("#edit").click(function(){
            var tourId = $("#tourId").val();
            var name = $("#name").text();
            var publishOrg = $("#publishOrg").text();
            var label = $("#label").text();
            if(label.indexOf("暂无标签")>-1){
                label = "";
            }
            var iconUrl = $("#iconUrlPlus").val();
            var address = $("#address").text();
            var startTime = $("#startTime").text();
            var endTime = $("#endTime").text();
            var introduction = $("#introduction").text();
            var url = '<%=request.getContextPath() %>/tour/goInfoEdit.do?id='+tourId;
            var json = {"tourId":tourId,"name":name,"publishOrg":publishOrg,"label":label,"address":address,"introduction":introduction
                ,"startTime":startTime,"endTime":endTime,"iconUrl":iconUrl};
            layer.open({
                type: 2
                ,id: 'layerDemo' //防止重复弹出
                ,title: name
                ,content: ['<%=request.getContextPath() %>/tour/goInfoEdit.do?id='+tourId,'yes']
                ,area: ['780px', '650px']
                ,offset: ['15%', '30%']
                ,shade: 0 //不显示遮罩
                ,yes: function(){
                    layer.closeAll();
                },
                end:function(){
                    location.reload();
                }
                ,success: function(layero, index1){
                }
            });
        });
        $('.images').on('error',function(){
            $(this).attr("src",'<%=request.getContextPath() %>/back/images/null_pic-12491114727.jpg');
        });
        //添加藏品按钮
        $("#addCollection").click(function(){
            if('${tourId.status}' == '2'){
                layer.msg("发布状态，不允许编辑!");
                return false;
            }
            var tourId = $("#tourId").val();
            var json = {"tourId":tourId};
            var index = layui.layer.open({
                title : "添加藏品",
                type : 2,
                shade: 0.5,
                content : '<%=request.getContextPath()%>/tour/goSelectCollection.do?tourId='+tourId,
                area: ['95%', '95%'],
                end:function(){
                    location.reload();
                }
            });
            layui.layer.full(index);
            window.sessionStorage.setItem("index",index);
        });

        //排序按钮
        $("#sort").click(function(){
            var tourId = $("#tourId").val();

            layer.open({
                type: 2,
                title: '排列顺序',
                shadeClose: true,
                shade: 0.5,
                area: ['650px', '700px'],
                content: '<%=request.getContextPath()%>/tour/goEditSort.do?tourId='+tourId,
                end:function(){
                    location.reload();
                }
            });
        });
        //切换中图模式
        $("#imageList").click(function(){
            var list = imageList;
            $("#imageList").addClass("iconColor");
            $("#imageLi").removeClass("iconColor");
            if(null != list && list.length>0){
                var htmlStr = "";
                for (var i = 0; i < list.length; i++) {
                    var url = list[i].url;
                    var id = list[i].id;
                    var tempHtml = "";
                    if(i/12==0){
                        tempHtml = "<div class='row'>"
                            +"<div class='col-md-1 img'><div class='col-md-12 imgdiv'><img data="+id+" class='delete'/><img data="+id+" class='show'/></div><img src="+url+" class='images'/></div>";
                    }
                    else{
                        if((i+1)/12==0){
                            tempHtml = "<div class='col-md-1 img'><div class='col-md-12 imgdiv'><img data="+id+" class='delete'/><img data="+id+" class='show'/></div><img src="+url+" class='images'/></div>"
                                +"</div>";
                        }else{
                            tempHtml = "<div class='col-md-1 img'><div class='col-md-12 imgdiv'><img data="+id+" class='delete'/><img data="+id+" class='show'/></div><img src="+url+" class='images' /></div>";
                        }
                    }
                    htmlStr = htmlStr+tempHtml;
                }
                $("#images").html(htmlStr);
                $(".delete").attr("src","<%=request.getContextPath()%>/back/images/delete.svg");
                $(".show").attr("src","<%=request.getContextPath()%>/back/images/show.svg");
            }else{
                $("#sort").hide();
                var picStr = "<div class='picDiv'><img src='../back/images/Group 3.png'></img></div>"
                var htmlStr = "<div class='empty'><p>您还没有添加藏品呢，赶快添加藏品充实您的专题~<a class='addcollection'>开始添加</a></p></div>";
                htmlStr = picStr+htmlStr;
                $("#images").html(htmlStr);
            }

        });
        //添加藏品
        $(".addcollection").click(function(){
            if('${tour.status}' == '2'){
                layer.msg("发布状态，不允许编辑!");
                return false;
            }
            var tourId = $("#tourId").val();
            var json = {"tourId":tourId};
            var index = layui.layer.open({
                title : "添加藏品",
                type : 2,
                shade: 0.5,
                content : '<%=request.getContextPath()%>/tour/goSelectCollection.do?tourId='+tourId,
                area: ['95%', '95%'],
                end:function(){
                    location.reload();
                }
            });
            layui.layer.full(index);
            window.sessionStorage.setItem("index",index);

        })
        $(".delete").click(function(){
            var id = $(this).attr("data");
            layer.confirm('真的删除么', function(index){
                if(id==null){
                    layer.msg("id为空，不允许删除!");
                    return;
                }
                deleteCollection(id);
                layer.close(index);
            });
        })
        $(".show").click(function(){
            var id = $(this).attr("data");
            goCollection(id);
        })
        //切换列表模式
        $("#imageLi").click(function(){
            var list = imageList;
            $("#imageLi").addClass("iconColor");
            $("#imageList").removeClass("iconColor");
            if(null != list){
                var tableStr = "<table id='imageTable' lay-filter='demoEvent'></table>";
                $("#images").html(tableStr);
                var imageData = [];
                for (var i = 0; i < list.length; i++) {
                    var url = list[i].url;
                    var name = list[i].name;
                    var tempData = {"id":list[i].id,"name":list[i].name,"collectionsCategory":list[i].collectionsCategory,"sort":list[i].sort
                        ,"collectionLevel":list[i].collectionLevel,"gsNo":list[i].gsNo,"yearType":list[i].yearType,
                        "collectionUnit":list[i].collectionUnit};
                    imageData.push(tempData);
                }
                table.render({
                    elem: '#imageTable'
                    ,height: 315
                    ,data:imageData
                    ,cellMinWidth: 80
                    ,page: true //开启分页
                    ,cols: [[ //表头
                        {field: 'id', title: 'ID', sort: false}
                        ,{field: 'name', title: '藏品名称',event: 'showCollection',templet: '<div><a data={{d.id}}" class="layui-table-link showLi">{{d.name}}</a></div>'}
                        ,{field: 'collectionsCategory', title: '类别'}
                        ,{field: 'collectionLevel', title: '级别'}
                        ,{field: 'gsNo', title: '一普编号'}
                        ,{field: 'yearType', title: '年代'}
                        ,{field: 'collectionUnit', title: '存放博物馆'}
                        ,{field: 'sort', title: '排序', sort: false}
                        ,{fixed: 'right',title: '操作', width:'70', align:'center', toolbar: '#barDemo'}
                    ]]
                    ,done: function(res, curr, count){
                        $("[data-field='id']").css('display','none');
                    }
                });
            }
        })

        table.on('tool(demoEvent)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                goCollection(data.id);
            } else if(obj.event === 'del'){
                layer.confirm('确定删除么?', function(index){
                    deleteCollection(data.id);
                    layer.close(index);
                });
            }
        });
    });

    $("#deleteCollection").click(function(){
        var id = $(this).attr("data");
        deleteCollection(id);
    })
    $(".Hui-iconfont.deleteLi").click(function(){
        var id = $(this).attr("data");
        if(id==null){
            layer.msg("id为空，不允许删除!");
            return;
        }
        deleteCollection(id);
    })
    $(".layui-table-link.showLi").click(function(){
        var id = $(this).attr("data");
        goCollection(id);
    })
    function deleteCollection(id){
        var tourId = $("#tourId").val();
        var json = {"tourId":tourId,"collectionId":id};
        $.ajax({
            type:"post",
            data:json,
            url:'<%=request.getContextPath()%>/tour/deleteCollectionById.do',
            success:function(result) {
                var index = parent.layer.getFrameIndex(window.name);
                if (result.success == 1) {
                    top.layer.msg("删除成功！");
                    location.reload();
                } else {
                    top.layer.msg("系统异常删除失败！");
                }
            }
        });
    }
    //查看藏品
    function goCollection(id){
        var json = {"tourId":tourId,"collectionId":id};
        layer.open({
            type: 2,
            title: '查看藏品',
            shadeClose: true,
            shade: 0.5,
            area: ['95%', '95%'],
            content: '<%=request.getContextPath()%>/back/oCCollection/detail.do?id='+id,
            end:function(){
                location.reload();
            }
        });


    }
    $("#back").click(function(){
        var index=parent.layui.layer.getFrameIndex(window.name);
        parent.layui.layer.close(index);
    });
    $('.introduction').each(function(){
        var maxwidth=160;
        if($(this).text().length>maxwidth){
            //截取字符串
            $(this).text($(this).text().substring(0,maxwidth));
            //多余的用省略号显示
            $(this).html($(this).html()+'...');
        }
    });


    $(".delete").click(function(){
        var id = $(this).attr("data");
        layer.confirm('真的删除么', function(index){
            if(id==null){
                layer.msg("id为空，不允许删除!");
                return;
            }
            deleteCollection(id);
            layer.close(index);
        });
    })

</script>
</body>

</html>