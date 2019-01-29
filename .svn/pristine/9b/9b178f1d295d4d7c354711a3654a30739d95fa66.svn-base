<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<title>新建消息</title>
	<link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/userMangermen/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/back/userMangermen/css/public.css" media="all" />

</head>
<body class="childrenBody">

<form class="layui-form" style="width:80%;" method="post" id="form">
	<!-- 解决360浏览器自动填充账号密码输入框 -->
	<input type="text" id="aaa" style="visibility: hidden;" />   
　　	<input type="password" id="aba" style="visibility: hidden;" />

	<input type="hidden" id="receiveOrgs" value="" name="receiveOrgs"/>
	<input type="hidden" id="infoId" value="${messageInfo.infoId} " name="infoId"/>
	
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">消息标题：</label>
		<div class="layui-input-block">
			<input type="text" name="infoTitle" value="${messageInfo.infoTitle }" required  lay-verify="required"  autocomplete="off" class="layui-input">
		</div>
	</div>
	
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">消息内容：</label>
		<div class="layui-input-block">
			<textarea name="infoContent" placeholder="请输入内容" value="${messageInfo.infoContent }" class="layui-textarea" required lay-verify="required"></textarea>
		</div>
	</div>
	
	<c:if test="${empty messageInfo || messageInfo eq null}">
		<div class="layui-form-item layui-row layui-form" id="div1">
		    <label class="layui-form-label">发送对象：</label>
		    <a id="btn_selectReceive" class="layui-btn layui-btn-radius layui-btn-primary" onclick="goSelectReceive();">
					<i class="layui-icon">&#xe654;</i>添加接收单位
		    </a>
	  	</div>
  	</c:if>
  	
	<div class="layui-form-item layui-row layui-col-xs12">
		<div class="layui-input-block">
			<button class="layui-btn layui-btn-sm" lay-submit lay-filter="addInsideInfo">发布</button>
			<button type="reset" id="reset" class="layui-btn layui-btn-sm layui-btn-primary">重置</button>
		</div>
	</div>
</form> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/userMangermen/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>
<script type="text/javascript">
//接收单位
var sel_receive = [];

layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    
    var pathName=window.document.location.pathname;
    projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    
    form.on("submit(addInsideInfo)",function(data){
    	if($("#infoTitle").val() == ""){
            layer.open({
                title:"提示",
                content:"您还没有填写消息标题"
            })
            return false;
        }else if(sel_receive.length == 0){
            layer.open({
                title:"提示",
                content:"您还没有选择接收单位"
            })
            return false;
        }else if($("#infoContent").val() == ''){
            layer.open({
                title:"提示",
                content:"您还没有填写消息内容"
            })
            return false;
        }else{
        	//设置接收单位
        	var receiveString = "";
        	for(var i=0; i<sel_receive.length; i++) {
        		receiveString += sel_receive[i] + ",";
			}
        	if(receiveString != ""){
        		receiveString = receiveString.substr(0, receiveString.length-1);
        	}
        	$("#receiveOrgs").val(receiveString);
        }
        $.ajax({
        	type:"post",
        	data:$("#form").serialize(),
        	async:false,
        	url:projectName + '/desk/saveMessage.do', 
        	beforeSend: function () {
  	    	   loading = layer.load();
  	       },
        	success:function(data) {
        		layer.close(loading);
        		if (data == 1) {
        			layer.msg("发送成功！");
        			setTimeout(close(),1000);
        		} else {
        			layer.msg("发送失败！",{icon:2});
        		}
        		 
        	}, 
        	error:function(data) {
        		layer.close(loading);
        		layer.msg("发送失败！",{icon:2});
        	}
        })
    })
})
	
	//关闭
$("#close").click(function(){
	close();
});

function close(){
	var index=parent.layui.layer.getFrameIndex(window.name);
	parent.layui.layer.close(index);
}


//设置接收单位的值
function setSelReceive(value){
	sel_receive = value;
	if(sel_receive.length == 0){
		$("#btn_selectReceive").html('<i class="layui-icon">&#xe654;</i>添加接收单位');
	}else{
		//更新选中信息
		$("#btn_selectReceive").html('<i class="layui-icon">&#xe613;</i>共选择'+sel_receive.length+'家任务接收单位');
	}
}
//子页面获取当前页面的接收单位
function getSelReceive(items){
	items = sel_receive;
}
//弹窗选择接收单位
function goSelectReceive(){
  var index = layui.layer.open({
      title : "选择接收单位",
      type : 2,
      content : "<%=request.getContextPath() %>/notice/publish/goSelectReceive.do",
      area: ['80%', '700px'],
      success : function(layero,index){
          var body = layui.layer.getChildFrame('body', index);
          resizeLayer(index);
          setTimeout(function(){
              layui.layer.tips('点击此处返回通知公告新建页', '.layui-layer-setwin .layui-layer-close', {
                  tips: 3
              });
          },500)
      },
      yes:function (index, layero) {
          layer.close(index); //关闭弹层
      }
  });
}
</script>
</body>
</html>