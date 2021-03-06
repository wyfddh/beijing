<%@page import="com.tj720.mip.springbeans.Config"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    Config config1 = new Config();
    String picUrl = config1.getRootPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all">
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/Tags/js/jquery-2.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/Tags/js/tag.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/Tags/css/tag.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<style>
    .icon{
        position:relative;
        float:right;
    }
    .layui-form-item{
        margin-left:5px;
        margin-top:15px;
    }
    .layui-form-label{
        width: 100px;
    }
</style>
<body>

<form class="layui-form" action="" id="layerDemo">
    <div style="position: relative">
        <div class="col-md-6" style="display:inline;">
            <div class="layui-form-item">
                <label class="layui-form-label">导览名称</label>
                <div class="layui-input-inline">
                    <input type="hidden" name="id" id="id">
                    <input type="text" name="name" style="width: 325px" id="name" required   placeholder="请输入导览名称" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">地址</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" style="width: 325px" name="address" id="address">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">标签</label>
                <div class="layui-input-block">
                    <div style="width:400px;" id="labelContainer">
                        <input type="text" id="tagValue" class="layui-input">

                        <input type="hidden" name="label" id="label">
                    </div>
                </div>
            </div>
            <div class="layui-form-item" >
                <label class="layui-form-label" style="width: 100px">数字展厅地址</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" style="width: 325px" name="virtualUrl" id="virtualUrl">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">展期</label>
                <div class="layui-input-inline" style="width: 150px;">
                    <input type="text" class="layui-input" id="startDate" name="startDate">
                </div>
                <div class="layui-form-mid">-</div>
                <div class="layui-input-inline" style="width: 150px;">
                    <input type="text" class="layui-input" id="endDate" name="endDate">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">展览介绍</label>
                <div class="layui-input-inline">
                    <textarea placeholder="请输入内容" class="layui-textarea" style="width:325px;height:200px;" id="introduction" name="introduction"></textarea>
                </div>
            </div>
            <input type="hidden" lay-submit lay-filter="formDemo">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-filter="save" id="save">确定</button>
                    <button class="layui-btn layui-btn-primary" id="cancel">取消</button>
                </div>
            </div>
        </div>
        <div class="icon col-md-6" style="position:absolute;top:5px;right:5px;">
	      <span id="iconspan">
	           <img src=""  id="icon" onerror="Javascript:this.src='<%=request.getContextPath() %>/back/images/null_pic-12491114727.jpg' " width="200px" height="200px">
	           <div style="position:absolute;width:100px;height:20px;z-indent:2;left:63px;bottom:4px;font-size:18px;">
			             编辑封面
			    </div>
	           <input type="hidden" class="layui-input" name="iconUrl" id="iconUrl">
	      </span>
        </div>
    </div>
</form>
<script src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script>
    var tag = new Tag("tagValue");
    layui.use(['laydate', 'layedit','layer','form'], function(){
        var form = layui.form;
        var layedit = layui.layedit;
        var laydate = layui.laydate;
        var layer = parent.layer === undefined ? layui.layer : top.layer;
        var index = parent.layer.getFrameIndex(window.name); //获取当前窗口索引
        //监听提交
        form.on('submit(layerDemo)', function(data){
            return false;
        });
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#startDate' //指定元素
        });
        laydate.render({
            elem: '#endDate' //指定元素
        });
        var pathName=window.document.location.pathname;
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
        $("#save").click(function(){
            //var data = $("#layerDemo").serialize();
            $.ajax({
                type:"post",
                //data:data,
                dataType : 'JSON',
                data : param(),
                url:projectName + '/tour/editTour.do',
                success:function(result) {
                    var index = parent.layer.getFrameIndex(window.name);
                    if (result.success == 1) {
                        top.layer.msg("修改成功！");
                        parent.layer.close(index);

                    } else {
                        top.layer.msg("系统异常修改失败！");
                        parent.layer.close(index);
                    }
                },
            });
            return false;
        });

        $("#iconspan").click(function(){
            layui.layer.open({
                type: 2
                ,id: 'iconDemo' //防止重复弹出
                ,content: ['<%=request.getContextPath() %>/cropper/tour.html','yes']
                ,area: ['780px', '600px']
                ,shade: 0 //不显示遮罩
                ,success: function(layero, index){

                }
            });
        })

        $("#cancel").click(function(){
            layer.close(index);
        })

    });
    $(function(){
        child();
    })
    function child(){
        $("#id").val('${infoTour.id}');
        $("#name").val('${infoTour.name}');
        $("#label").val('${infoTour.label}');
        tag.tagValue = '${infoTour.label}';
        tag.initView();
        $("#address").val('${infoTour.address}');
        $("#virtualUrl").val('${infoTour.virtualUrl}');
        $("#introduction").val( '${infoTour.introduction}'.trim());
        $("#icon").attr("src",'${infoTour.iconUrl}');
        $("#iconUrl").val('${infoTour.iconUrl}');
        var startDate = '${infoTour.startDate}'.split('/').join('-');
        var endDate = '${infoTour.endDate }'.split('/').join('-');
        <%--$("#startDate").val('${infoTour.startDate}');--%>
        <%--$("#endDate").val('${infoTour.endDate}');--%>
        if(startDate != NaN && startDate != null && startDate != undefined && startDate!= ''){
            var start = timestampToTime(startDate);
            $("#startDate").val(start);
        }
        if (endDate != NaN && endDate != null && endDate != undefined && endDate != '') {
            var end = timestampToTime(endDate);
            $("#endDate").val(end);
        }
    }

    function update(url,id,url1){
        console.log(url);
        var urlStr = url1;
        console.log(urlStr);
        $("#icon").attr("src",urlStr);
        $("#iconUrl").val(url);
    }

    //时间戳转时间格式
    function timestampToTime(obj) {
        var date =  new Date(obj);
        var y = 1900+date.getYear();
        var m = "0"+(date.getMonth()+1);
        var d = "0"+date.getDate();
        var h = date.getHours() + ':';
        var mi = date.getMinutes();
        var s = date.getSeconds();
        return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
    }

    function param(){
            var id = $("#id").val();
            var name = $("#name").val();
            var label =  $("#label").val();
            var address = $("#address").val();
           var virtualUrl = $("#virtualUrl").val();
            var introduction = $("#introduction").val();
           var iconUrl = $("#iconUrl").val();
            var startDateStr = $("#startDate").val();
            var endDateStr = $("#endDate").val();
            return {
                id :id,
                name : name,
                label :label,
                address : address,
                virtualUrl : virtualUrl,
                introduction : introduction,
                iconUrl : iconUrl,
                startDateStr : startDateStr,
                endDateStr : endDateStr
            }
    }
</script>
</body>
</html>