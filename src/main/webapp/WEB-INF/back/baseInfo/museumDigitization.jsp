<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="<%=request.getContextPath() %>/back/favicon.ico" >
    <link rel="Shortcut Icon" href="<%=request.getContextPath() %>/back/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css"/>
<style type="text/css">
 .hideBtn{
     display: none;
 }
 .childrenBody{
 	padding:20px 20px 0px 20px;
 }
  .label-title{
 	color:#BE9A5B;
 	font-size:18px;
 	font-weight:700;
 }
  .layui-form-label{
 width:130px;
 padding: 9px 5px;
 }

 .layui-row{
 	padding-bottom:20px;
 }
 .pt_30{
 padding-top:30px;
 }
</style>
<title>信息智能化建设</title>
</head>
<body class="childrenBody">
	<div>
        <form class="myform form-horizontal layui-form" role="form" id="myform" name="myform">
              
	         <div class="layui-row pt_30">    
		         <div class="layui-col-md2 layui-col-md-offset10">
		         	<span style="text-align:center;display:block;">
		        	<c:if test="${'1' eq level}">
						<c:if test="${empty digitizationInfo.id || digitizationInfo.id eq null}">
							<a id="btn_submit" type="button" class="layui-btn" lay-submit lay-filter="saveBase"> 提交</a>
							<a id="btn_edit" type="button" class="layui-btn hideBtn">编辑</a>
		                </c:if>
		                <c:if test="${not empty digitizationInfo.id && digitizationInfo.id ne null}">
							<a id="btn_edit" type="button" class="layui-btn">编辑</a>
							<a id="btn_submit" type="button" class="layui-btn hideBtn" lay-submit lay-filter="saveBase" style="margin-left:0"> 提交</a>
		                </c:if>
		              </c:if>
		                <a id="btn_back" type="button" class="layui-btn">返回</a>
		                </span>
		               <input type="hidden" name="museumId" id="museumId" value="${museumId}">
		               <input type="hidden" name="id" id="id" value="${digitizationInfo.id}">
		               <input type="hidden" name="isFull" id="isFull" value="">
		               <input type="hidden" name="level" id="level" value="${level}">
		    	  </div>
             </div>
              <div class="layui-row">
	            <div class="layui-col-md2">
	            	<a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp馆舍信息化</a>
	            </div>
              </div>
              
              <div class="layui-row" >
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label">是否可接入互联网：</label>
                     <div class="radio layui-col-md6" >
                             <input type="radio" name="accessNet" value="1" <c:if test="${'1' eq digitizationInfo.accessNet}">checked</c:if> title="有">
                             <input type="radio" name="accessNet"  value="0" <c:if test="${'0' eq digitizationInfo.accessNet}">checked</c:if> title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label"  >馆内局域网设施：</label>
                     <div class="radio layui-col-md6" >
                             <input type="radio" name="localNet"   value="1" <c:if test="${'1' eq digitizationInfo.localNet}">checked</c:if> title="有">
                             <input type="radio" name="localNet" value="0" <c:if test="${'0' eq digitizationInfo.localNet}">checked</c:if> title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label"  >公共网址：</label>
                     <div class="radio layui-col-md6">
                             <input type="radio" name="netAddress"   value="1" <c:if test="${'1' eq digitizationInfo.netAddress}">checked</c:if> title="有">
                             <input type="radio" name="netAddress"  value="0" <c:if test="${'0' eq digitizationInfo.netAddress}">checked</c:if> title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label"  >馆内WiFi覆盖：</label>
                     <div class="radio layui-col-md6">
                             <input type="radio" name="wifiCover"    value="1" <c:if test="${'1' eq digitizationInfo.wifiCover}">checked</c:if> title="有">
                             <input type="radio" name="wifiCover"    value="0" <c:if test="${'0' eq digitizationInfo.wifiCover}">checked</c:if> title="无">
                     </div>
                 </div>
			</div>
			
			<div class="layui-row">
	            <div class="layui-col-md2">
	            	<a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp藏品信息化</a>
	            </div>
             </div>
             <div class="layui-row">
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label" >藏品智能管理系统：</label>
                     <div class="radio layui-col-md6" >
                             <input type="radio" name="managementSys" value="1" <c:if test="${'1' eq digitizationInfo.managementSys}">checked</c:if> title="有">
                             <input type="radio" name="managementSys" value="0" <c:if test="${'0' eq digitizationInfo.managementSys}">checked</c:if> title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label">藏品管理信息化系统：</label>
                     <div class="radio layui-col-md6" >
                             <input type="radio" name="collectionSystem"  value="1" <c:if test="${'1' eq digitizationInfo.collectionSystem}">checked</c:if> title="有">
                             <input type="radio" name="collectionSystem" value="0"  <c:if test="${'0' eq digitizationInfo.collectionSystem}">checked</c:if>title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label" >专题数据库：</label>
                     <div class="radio layui-col-md6">
                             <input type="radio" name="thematicLibrary" class="layui-input"  value="1" <c:if test="${'1' eq digitizationInfo.thematicLibrary}">checked</c:if> title="有">
                             <input type="radio" name="thematicLibrary" class="layui-input"  value="0" <c:if test="${'0' eq digitizationInfo.thematicLibrary}">checked</c:if> title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label" >文物多维度多媒体信息采集与加工：</label>
                     <div class="radio layui-col-md6">
                             <input type="radio" name="infornationCollection"   value="1" <c:if test="${'1' eq digitizationInfo.infornationCollection}">checked</c:if> title="有">
                             <input type="radio" name="infornationCollection"   value="0" <c:if test="${'0' eq digitizationInfo.infornationCollection}">checked</c:if> title="无">
                     </div>
                 </div>
			</div>
			
			<div class="layui-row">
	            <div class="layui-col-md5">
	            	<a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp展陈及社会服务信息化</a>
	            </div>
             </div>
             <div class="layui-row">
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label">3D：</label>
                     <div class="radio layui-col-md6" >
                             <input type="radio" name="threeD"  value="1" <c:if test="${'1' eq digitizationInfo.threeD}">checked</c:if> title="有">
                             <input type="radio" name="threeD"  value="0" <c:if test="${'0' eq digitizationInfo.threeD}">checked</c:if> title="无">
                         </label>
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label">全景：</label>
                     <div class="radio layui-col-md6">
                             <input type="radio" name="overView" value="1" <c:if test="${'1' eq digitizationInfo.overView}">checked</c:if> title="有">
                             <input type="radio" name="overView" value="0" <c:if test="${'0' eq digitizationInfo.overView}">checked</c:if> title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label" >音视频：</label>
                     <div class="radio layui-col-md6">
                             <input type="radio" name="video" value="1" <c:if test="${'1' eq digitizationInfo.video}">checked</c:if> title="有">
                             <input type="radio" name="video" value="0" <c:if test="${'0' eq digitizationInfo.video}">checked</c:if> title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label" >知识动漫：</label>
                     <div class="radio layui-col-md6">
                             <input type="radio" name="knowledgeAnime" class="layui-input"   value="1" <c:if test="${'1' eq digitizationInfo.knowledgeAnime}">checked</c:if> title="有">
                             <input type="radio" name="knowledgeAnime" class="layui-input"   value="0" <c:if test="${'0' eq digitizationInfo.knowledgeAnime}">checked</c:if> title="无">
                     </div>
                 </div>
             </div>
             
             <div class="layui-row">
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label">益智游戏：</label>
                     <div class="radio layui-col-md6" >
                             <input type="radio" name="game"   value="1" <c:if test="${'1' eq digitizationInfo.game}">checked</c:if> title="有">
                             <input type="radio" name="game"  value="0" <c:if test="${'0' eq digitizationInfo.game}">checked</c:if> title="无">
                         </label>
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label">AR：</label>
                     <div class="radio layui-col-md6">
                             <input type="radio" name="ar" value="1" <c:if test="${'1' eq digitizationInfo.ar}">checked</c:if> title="有">
                             <input type="radio" name="ar" value="0" <c:if test="${'0' eq digitizationInfo.ar}">checked</c:if> title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label" >VR：</label>
                     <div class="radio layui-col-md6" style="margin-top: 0px">
                             <input type="radio" name="vr" value="1" <c:if test="${'1' eq digitizationInfo.vr}">checked</c:if> title="有">
                             <input type="radio" name="vr" value="0" <c:if test="${'0' eq digitizationInfo.vr}">checked</c:if> title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label">数字化（虚拟）展览展示：</label>
                     <div class="radio layui-col-md6" style="margin-top: 0px">
                             <input type="radio" name="virtualDisplay" value="1" <c:if test="${'1' eq digitizationInfo.virtualDisplay}">checked</c:if> title="有">
                             <input type="radio" name="virtualDisplay" value="0" <c:if test="${'0' eq digitizationInfo.virtualDisplay}">checked</c:if> title="无">
                     </div>
                 </div>
             </div>
             
             <div class="layui-row">
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label">互动展示墙：</label>
                     <div class="radio layui-col-md6" >
                             <input type="radio" name="displayWall"   value="1" <c:if test="${'1' eq digitizationInfo.displayWall}">checked</c:if> title="有">
                             <input type="radio" name="displayWall"  value="0" <c:if test="${'0' eq digitizationInfo.displayWall}">checked</c:if> title="无">
                         </label>
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label">高端触摸屏：</label>
                     <div class="radio layui-col-md6">
                             <input type="radio" name="touchScreen" value="1" <c:if test="${'1' eq digitizationInfo.touchScreen}">checked</c:if> title="有">
                             <input type="radio" name="touchScreen" value="0" <c:if test="${'0' eq digitizationInfo.touchScreen}">checked</c:if> title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label" >投影：</label>
                     <div class="radio layui-col-md6" style="margin-top: 0px">
                             <input type="radio" name="shadow" value="1" <c:if test="${'1' eq digitizationInfo.shadow}">checked</c:if> title="有">
                             <input type="radio" name="shadow" value="0" <c:if test="${'0' eq digitizationInfo.shadow}">checked</c:if> title="无">
                     </div>
                 </div>
             </div>
             
             <div class="layui-row">
	            <div class="layui-col-md2">
	            	<a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp安全保障信息化</a>
	            </div>
             </div>
             <div class="layui-row">
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label" >自动报警系统：</label>
                     <div class="radio layui-col-md6" >
                             <input type="radio" name="autoAlarm" value="1" <c:if test="${'1' eq digitizationInfo.autoAlarm}">checked</c:if> title="有">
                             <input type="radio" name="autoAlarm" value="0" <c:if test="${'0' eq digitizationInfo.autoAlarm}">checked</c:if> title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label">自动灭火系统：</label>
                     <div class="radio layui-col-md6" >
                             <input type="radio" name="autoOutfire"  value="1" <c:if test="${'1' eq digitizationInfo.autoOutfire}">checked</c:if> title="有">
                             <input type="radio" name="autoOutfire" value="0"  <c:if test="${'0' eq digitizationInfo.autoOutfire}">checked</c:if>title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label" >文物库房安全监控：</label>
                     <div class="radio layui-col-md6">
                             <input type="radio" name="warehouseMonitor" class="layui-input"  value="1" <c:if test="${'1' eq digitizationInfo.warehouseMonitor}">checked</c:if> title="有">
                             <input type="radio" name="warehouseMonitor" class="layui-input"  value="0" <c:if test="${'0' eq digitizationInfo.warehouseMonitor}">checked</c:if> title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label" >文库展陈安全监控：</label>
                     <div class="radio layui-col-md6">
                             <input type="radio" name="zhanchenMonitor"   value="1" <c:if test="${'1' eq digitizationInfo.zhanchenMonitor}">checked</c:if> title="有">
                             <input type="radio" name="zhanchenMonitor"   value="0" <c:if test="${'0' eq digitizationInfo.zhanchenMonitor}">checked</c:if> title="无">
                     </div>
                 </div>
			</div>
			<div class="layui-row">
                 <div class="layui-input-inline layui-col-md3">
                     <label class="layui-form-label" >文物运输安全监控：</label>
                     <div class="radio layui-col-md6" >
                             <input type="radio" name="yunshuMonitor" value="1" <c:if test="${'1' eq digitizationInfo.yunshuMonitor}">checked</c:if> title="有">
                             <input type="radio" name="yunshuMonitor" value="0" <c:if test="${'0' eq digitizationInfo.yunshuMonitor}">checked</c:if> title="无">
                     </div>
                 </div>
			</div>
			
			<div class="layui-row">
	            <div class="layui-col-md2">
	            	<a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp办公信息化</a>
	            </div>
             </div>
			<div class="layui-row" style="padding-bottom:0px;">
                 <div class="layui-input-inline layui-col-md5">
                     <label class="layui-form-label" style="width:auto !important">是否有数字化办公系统：</label>
                     <div class="radio layui-col-md6" >
                             <input type="radio" name="digitalOffice" value="1" <c:if test="${'1' eq digitizationInfo.digitalOffice}">checked</c:if> title="有">
                             <input type="radio" name="digitalOffice" value="0" <c:if test="${'0' eq digitizationInfo.digitalOffice}">checked</c:if> title="无">
                     </div>
                 </div>
			</div>
       </form>
   </div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/museum/js/commonUtil.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
layui.use(['form'], function() {
	var form = layui.form,
	layer = layui.layer,
	$=layui.jquery;
});

	$(function(){
		
		var idStr= $("#id").val();
		var level = $("#level").val();
		if(level=="2" || (idStr !=null && idStr != "")){
			$('input,textarea').attr('disabled',"disabled");
		}
		initFileds();
		$("#btn_edit").click(function(){
			$('input,textarea').removeAttr("disabled");
			$("#btn_edit").addClass("hideBtn");
			$("#btn_submit").removeClass("hideBtn");
	    });
		$("#btn_back").click(function(){
			var museumId = $("#museumId").val();
			if( checkModification()){
				layer.confirm('您修改的信息尚未保存，确定要离开吗？', {  
			        btn: ['确定','取消'] //按钮
			    }, function(index){
			    	layer.close(index);  //关闭弹出层
			        //点击确定之后需要执行的函数
			        window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+museumId;
			    }, function(index){
				        layer.close(index);  //关闭弹出层
			    });
			}else{
		        window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+museumId;
			}
	    });
		
		$("#btn_submit").click(function(){
			if( checkModification()){
				if($("input[type='radio']:checked").length ==0){
					layer.msg("请先填写资料再提交！");
					return false;
				}
				//25个单选控件
				if(checkFullCom(25)){
					$("#isFull").val("1");
				}else{
					$("#isFull").val("0");
				}
	    		var loading; 
		    	$.ajax({
			       url:"<%=request.getContextPath()%>/museumDigitization/save.do",
			       data:$('#myform').serialize(),
			       type:"POST",
			       beforeSend: function () {
	    	    	   loading = layer.load();
	    	       },
			       success:function(msg){
			    	   layer.close(loading);  
			    	   if(msg == 1){
			    		   layer.msg("保存成功！");
			    		   setTimeout(function(){
								window.location.href = window.location.href;
							},1000)
		                }else if(msg == 0){
		                	layer.msg("保存失败！",{icon:2});
		                }
			       },
			       error:function(msg){
	    	    	   layer.close(loading);
	    	    	   layer.msg("保存失败！",{icon:2});
	    	       }
			   });
			}else{
				layer.msg("资料没有修改，无需提交！");
			}
		});
	})
</script>
</body>
</html>