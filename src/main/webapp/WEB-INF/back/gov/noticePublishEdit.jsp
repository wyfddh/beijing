<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/public.css"/>
<style type="text/css">
	.textHidden{max-width:70%; white-space:nowrap;overflow:hidden;text-overflow:ellipsis; }
</style>
<title>通知公告-编辑</title>
</head>
<body style="background:#fff;padding:10px">
<form class="layui-form" id="newForm">
	<input type="hidden" id="id" name="id" value="${notice.id }">
	<input type="hidden" id="receiveOrgs" name="receiveOrgs" value="${receiveOrgs }">
	<input type="hidden" id="uploads" name="uploads" value="${uploads }">
	<input type="hidden" id="submitStatus" name="submitStatus" value="">
	<input type="hidden" id="reportCode" name="reportCode" value="${notice.reportCode }">
	<div class="layui-col-xs8" style="padding-right: 20px;">
		<div class="layui-form-item layui-row layui-col-xs12">
			<input type="text" class="layui-input inputText" lay-verify="required" placeholder="标题" id="title" name="title" value="${notice.title }" style="width:100%;">
			<script id="editorCh" type="text/plain" style="width:100%;" name="content">${notice.content }</script>
		</div>
	</div>
	<div class="layui-col-xs4" style="padding-left: 20px;">
		<div class="layui-form-item layui-row layui-col-xs12" style="text-align: right;padding-right:20px;">
			<c:if test="${notice.publishStatus != 2 }">
				<button type="button" class="layui-btn" lay-submit lay-filter="save">暂存</button>
				<button type="button" lay-submit class="layui-btn layui-btn-danger" lay-filter="publish" id="publish">发布</button>
			</c:if>
			<c:if test="${notice.publishStatus == 2 }">
				<button type="button" class="layui-btn" lay-submit lay-filter="save">暂存</button>
			</c:if>
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12">
			<label><b>发布对象</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<button type="button" id="btn_selectReceive" class="layui-btn layui-btn-radius layui-btn-primary<c:if test="${notice.publishStatus == 2 }"> layui-btn-disabled</c:if>" onclick="goSelectReceive();" <c:if test="${notice.publishStatus == 2 }">disabled</c:if>>
				<c:if test="${notice.publishStatus != 2 }">
					<i class="layui-icon">&#xe654;</i>添加接收单位
				</c:if>
			</button>
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12" style="margin-top: 30px;">
			<label><b>附件</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<div id="showFile"></div>
			<c:if test="${notice.publishStatus != 2 }">
				<button type="button" class="layui-btn layui-btn-radius layui-btn-primary" id="fileBtn"><i class="layui-icon">&#xe67c;</i>添加附件</button>
			</c:if>
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12" style="margin-top: 30px;">
			<label><b>其他设置</b></label>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12" style="vertical-align:middle;">
			<label style="margin-right: 20px;">是否需要填写反馈</label>
			<input type="checkbox" id="isfeedback" name="isfeedback" value="1" lay-filter="isfeedback" lay-skin="switch" lay-text="是|否" <c:if test="${notice.isfeedback == 1 }">checked</c:if> <c:if test="${notice.publishStatus == 2 }">disabled</c:if>>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12 iswrite" style="vertical-align:middle;" id="setReport">
			<c:if test="${empty notice.reportCode }" var="reportCodeIsNull">
				<a href="javascript:goSelectReport();" <c:if test="${notice.publishStatus == 2 }">disabled</c:if> >设置填报表单</a>
			</c:if>
			<c:if test="${!reportCodeIsNull }">
				<a class="layui-btn layui-btn-radius layui-btn-primary<c:if test="${notice.publishStatus == 2 }"> layui-btn-disabled</c:if>" href="javascript:goSelectReport();" <c:if test="${notice.publishStatus == 2 }">disabled</c:if>><i class="layui-icon">&#xe63c;</i>${notice.reportName }</a>
			</c:if>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12 iswrite" style="vertical-align:middle;">
			<a href="javascript:void(0);" id="setEndTime">设置填报截止时间</a>
			<input type="text" class="layui-input" id="deadlineTime" name="temp_deadlineTime" value="<fmt:formatDate value='${notice.deadlineTime }' pattern='yyyy-MM-dd HH:mm' />" placeholder="填报截止时间" style="width: 150px;"/>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12 iswrite" style="vertical-align:middle;">
			<label style="margin-right: 20px;" class="outTimeIsContinueWrite">超过截至时间允许继续填报</label>
			<input type="checkbox" id="isfill" name="isfill" value="1" lay-skin="switch" lay-text="是|否" <c:if test="${notice.isfill == 1 }">checked</c:if> >
		</div>
		
	</div>
</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/ueditor.all.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/ueditor/lang/zh-cn/zh-cn.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript">
//初始化富文本编辑器
var cn = UE.getEditor('editorCh',{
    toolbars: [[
        'fullscreen', 'undo', 'redo', '|',
        'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
        'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
        'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
        'directionalityltr', 'directionalityrtl', 'indent', '|',
        'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
        'link', 'unlink', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
        'simpleupload', 'insertimage', 'pagebreak', '|',
        'horizontal', 'date', 'time', 'spechars', '|',
        'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', '|',
        'print', 'preview', 'searchreplace'
    ]],
    initialFrameHeight: 400
});
</script>
<script type="text/javascript">
//接收单位
var sel_receive = [];
//附件
var uploads = [];
$(function(){
	if($("#isfeedback").get(0).checked){
		$(".iswrite").show();
		if($("#deadlineTime").val() != ''){
			$("#deadlineTime").show();
		}else{
			$("#deadlineTime").hide();
		}
	}else{
		$(".iswrite").hide();
	}
	$("#setEndTime").on("click", function(){
		$("#deadlineTime").show();
	});
	
});

layui.use(['form','layer','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    	laydate = layui.laydate;
	
   	laydate.render({
   	    elem: '#deadlineTime'
   	    ,type: 'datetime'
   	    ,format: 'yyyy-MM-dd HH:mm'
   	  });
    
    form.on("switch(isfeedback)", function(data){
    	if('${notice.publishStatus}' == '2'){
    		return false;
    	}
    	if(data.elem.checked){
	    	$(".iswrite").show();
	    	layui.layer.tips('若选择此项，超过截至时间后，接收单位依然可以进行数据填报', '.outTimeIsContinueWrite', {
                tips: 3
            });
    	}else{
	    	$(".iswrite").hide();
    	}
    });
    
    form.on("submit(save)",function(data){
    	saveOrPublish('1');
        return false;
    });
    form.on("submit(publish)",function(data){
    	layer.confirm('是否确认发布？', {icon: 3, title: '发布确认'}, function (index) {
	    	saveOrPublish('2');
	    	layer.close(index);
    	});
        return false;
    });
    
    //保存获取发布
    var saveOrPublish = function(status){
    	var cpublishStatus = '${notice.publishStatus}'
   		var isChecked = $("#isfeedback")[0].checked;
    	if($("#title").val() == ""){
            layer.open({
                title:"提示",
                content:"您还没有填写标题"
            })
        }else if(sel_receive == false){
            layer.open({
                title:"提示",
                content:"您还没有选择接收单位"
            })
        }else if(isChecked && $("#reportCode").val() == ''){
            layer.open({
                title:"提示",
                content:"您还没有设置填报表单"
            })
        }else if(isChecked && $("#deadlineTime").val() == ''){
            layer.open({
                title:"提示",
                content:"您还没有设置截止时间"
            })
        }else {
        	if(cpublishStatus != 2){
	        	//设置接收单位
	        	var receiveString = "";
	        	for(var i=0; i<sel_receive.length; i++) {
	        		receiveString += sel_receive[i] + ",";
				}
	        	if(receiveString != ""){
	        		receiveString = receiveString.substr(0, receiveString.length-1);
	        	}
	        	$("#receiveOrgs").val(receiveString);
	        	
	        	//设置附件
	        	if(uploads != undefined && uploads.length != 0){
	        		var uploadJson = JSON.stringify(uploads);
		        	console.log(uploadJson);
	        		$("#uploads").val(uploadJson);
	        	}
        	}
        	
        	if(status == '1'){		//暂存
	        	$("#submitStatus").val(cpublishStatus);
        	}else if(status == '2'){
	        	$("#submitStatus").val("2");
        	}else{
        		layer.msg("操作异常");
        	}
        	$.ajax({
	            url:"<%=request.getContextPath() %>/notice/publish/editNotice.do",
	            data:$("#newForm").serialize(),
	            type:"POST",
	            success:function(msg){
	                if(msg.code == 1){
	                	if(status == '1'){		//暂存
	                		layer.msg('保存成功');
	                	}else if(status == '2'){
	                		layer.msg('发布成功');
	                	}
	                	setTimeout(function(){
	    					close();
	    				},700);
	                }else{
	                	layer.msg(msg.msg);
	                }
	            }
	        });
        }
    }
    
    var upload = layui.upload;
    var uploadInst = upload.render({
        elem: '#fileBtn' //绑定元素
        ,url: '<%=request.getContextPath() %>/attach/uploadLegal.do' //上传接口
        ,data:{
        	projectName:"notice"
        }
    	,auto:true
    	,field:"file"
    	,accept:"file"
   		,before: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
   			//加载层-风格4
   			layer.msg('上传中', {
   			  icon: 16
   			  ,shade: 0.5
   			});
   		}
        ,done: function(res){
        	layer.closeAll(); //关闭loading
          //上传完毕回调
        	var resultMap = res.data;
          	if(res.code == 1){
	        	uploads.push(resultMap);
	        	console.log(uploads);
	        	//刷新文件显示
	        	refreshFile();
          	}
       		layer.msg(res.msg);
        	
        	/* $("#id").val(resultMap.id);
        	$("#resultPath").val(resultMap.resultPath);
        	$("#realFileName").val(resultMap.realFileName);
        	$("#isjunk").val(resultMap.isjunk);
        	$("#size").val(resultMap.size);
        	$("#typeCode").val(resultMap.typeCode); */
        }
        ,error: function(){
          //请求异常回调
        }
      });
	//刷新文件显示
	window.refreshFile = function(){
		//清空showFile中的html
		$("#showFile").html("");
		//循环插入文件显示
		for (var i = 0; i < uploads.length; i++) {
			if(uploads[i].isjunk == 0 || uploads[i].isjunk == '0'){
				$("#showFile").append('<button type="button" class="layui-btn layui-btn-radius layui-btn-primary textHidden<c:if test="${notice.publishStatus == 2 }"> layui-btn-disabled</c:if>"<c:if test="${notice.publishStatus == 2 }"> disabled</c:if> onclick="deleteFile(\''+uploads[i].id+'\',\''+uploads[i].realFileName+'\')"><i class="layui-icon">&#xe66e;</i>'+uploads[i].realFileName+'</button>');
			}
		}
		form.render();
	}
	//点击文件删除
	window.deleteFile = function(value, filename){
		layer.confirm('确定删除'+filename+'？', {icon: 3, title: '删除确认'}, function (index) {
			for(var i=0;i<=uploads.length-1;i++){
		        if(uploads[i].id==value){
		        	if(uploads[i].isnew == 1){
		        		//真实删除文件
			        	cancelFile(uploads[i].resultPath);
			        	uploads.splice(i,1);
		        	}else{
			        	//将jsjunk设置为1
			        	uploads[i].isjunk = '1';
		        	}
		        }
		    }
			//刷新文件显示
			refreshFile();
			console.log(uploads);
			layer.close(index);
        })
	}
	
	//刷新接收单位
	var receiveString = $("#receiveOrgs").val();
	if(receiveString != ''){
		sel_receive = receiveString.split(",");
		setSelReceive(sel_receive);
		console.log(sel_receive);
	}
	
	//刷新文件显示
	var uploadsJsonString = '${uploads }';
	if(uploadsJsonString != ''){
		console.log(uploadsJsonString);
		uploads = JSON.parse(uploadsJsonString);
		refreshFile();
		console.log(uploads);
	}
})

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
          setTimeout(function(){
              layui.layer.tips('点击此处返回通知公告新建页', '.layui-layer-setwin .layui-layer-close', {
                  tips: 3
              });
          },500)
      },
      yse:function (index, layero) {
          layer.close(index); //关闭弹层
      }
  });
}

//弹窗选择表单
function goSelectReport(){
	if('${notice.publishStatus}' == '2'){
		return false;
	}
  var index1 = layui.layer.open({
      title : "选择表单",
      type: 2,
      maxmin: true,
      content : "<%=request.getContextPath() %>/notice/publish/goSelectReport.do",
      btn: ['使用', '取消', '创建空白表单', '编辑'],
      area: ['95%', '95%'],
      yes:function (index, layero) {
    	  var body = layui.layer.getChildFrame('body', index);
    	  var bussCode = body.find("#bussCode").val();
    	  var bussName = body.find("#bussName").val();
    	  if(bussCode != '' && bussCode != undefined && bussName != ''){
	    	  $("#setReport").html('');
	    	  $("#setReport").html('<a class="layui-btn layui-btn-radius layui-btn-primary" title="点击修改" href="javascript:goSelectReport();"><i class="layui-icon">&#xe63c;</i>'+bussName+'</a>');
	    	  $("#reportCode").val(bussCode);
    	  }else{
    		  $("#setReport").html('');
	    	  $("#setReport").html('<a href="javascript:goSelectReport();" >设置填报表单</a>');
    		  $("#reportCode").val('');
    	  }
    	  layui.layer.close(index); //关闭弹层
      },
      btn2: function(index, layero){
    	  layui.layer.close(index); //关闭弹层
   	  },
   	  btn3: function(index, layero){
   		  layer.open({
	   			title : "请输入表单名称",
	   		  	type: 2,
	   		  	content: "<%=request.getContextPath() %>/notice/publish/goReportAdd.do",
	   		 	area: ['250px', '160px'],
	   		 	success: function(layero,index){
	   		 		$("#reportAdd").show();
	   		 	}
   		  });
   		  return false;
   	  },
   	  btn4: function(index, layero){
   		  var body = layui.layer.getChildFrame('body', index);
	  	  var bussCode = body.find("#bussCode").val();
	  	  var bussName = body.find("#bussName").val();
	  	  var defineCode = body.find("#defineCode").val();
	  	  if(bussCode != '' && bussCode != undefined && bussName != ''){
	  		  window.open("<%=request.getContextPath() %>/designController.do?design&type=2&businessCode="+defineCode);
	  	  }else{
	  		  layer.msg('请先选择表单');
	  	  }
	  	  return false;
   	  }
  });
}

//关闭
$("#close").click(function(){
	close();
});

function close(){
	var index=parent.layui.layer.getFrameIndex(window.name);
	parent.layui.layer.close(index);
}
</script>
</body>
</html>