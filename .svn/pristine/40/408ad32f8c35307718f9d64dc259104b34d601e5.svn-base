<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
    <%--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/public.css"/>--%>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
    <style type="text/css">
        .textHidden{max-width:70%; white-space:nowrap;overflow:hidden;text-overflow:ellipsis; }
    </style>
    <title>导览-新建</title>
</head>
<body style="background:#fff;padding:10px;">
<form class="layui-form" id="newForm">
    <input type="hidden" id="id" name="id" value="">
    <div class="layui-col-xs12" style="">
        <div class="layui-form-item layui-row" style="text-align:center;width: 320px;">
            <label class="layui-form-label" style="">审批状态：</label>
            <div class="layui-input-block" style="width: 200px;float: left;margin-left: 0px;">
                <%--<select class="layui-select" name="status" id="status" style="width: 82%;">--%>
                    <%--<option value="">请选择审批状态</option>--%>
                    <%--<option value="1">通过</option>--%>
                    <%--<option value="0">不通过</option>--%>
                <%--</select>--%>

                <input type="radio"  name="status" value="1" title="通过">
                <input type="radio"   name="status" value="0" title="不通过">
            </div>
        </div>
        <input type="text" hidden="true" value="${approvalTourId }" id = "tourId" name = "tourId">
        <div class="layui-form-item layui-row layui-col-xs12" style="text-align:center">
            <div class="">
                <button class="layui-btn layui-btn-sm layui-btn-primary" id="close">取消</button>
                <button lay-submit class="layui-btn layui-btn-sm" lay-filter="save">确认</button>
            </div>
        </div>
    </div>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript">
    var index = parent.layer.getFrameIndex(window.name);
    layui.use(['form','layer','laydate','upload'],function(){
        var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery;
        laydate = layui.laydate;

        form.on("submit(save)",function(data){
            saveOrPublish('1');
            return false;
        });
        form.on("submit(close)",function(data){
            saveOrPublish('2');
            return false;
        });

        //保存获取发布
        var saveOrPublish = function(status){
            if($("input[name='status']:checked").val() == "" || $("input[name='status']:checked").val() == null){
                layer.open({
                    title:"提示",
                    content:"您还没有选择审核状态"
                })
            }else {
                saveFunction(status);
            }
        }

        var saveFunction = function(status){
            $.ajax({
                url:"<%=request.getContextPath() %>/tour/approvalTour.do",
                data:{
                    status : $("input[name='status']:checked").val(),
                    tourId : $("#tourId").val()
                },
                type:"POST",
                success:function(msg){
                    if(msg.success == 1){
                            setTimeout(function(){
                                close();
                            },700);
                            /* layer.msg('保存成功'); */
                        parent.layer.close(index);
                    }else{
                        layer.msg(msg.data);
                    }
                }
            });
        }

    })

    //关闭
    $("#close").click(function(){
        parent.layer.close(index);
    });

    function close(){
        var index=parent.layui.layer.getFrameIndex(window.name);
        parent.layui.layer.close(index);
    }

</script>
</body>
</html>