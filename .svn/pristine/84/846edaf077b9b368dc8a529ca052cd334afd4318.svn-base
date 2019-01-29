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
 	padding-top:10px;
 	padding-right:20px;
 	padding-left:30px;
 	padding-bottom:20px;
 }
  .label-title{
 	color:#BE9A5B;
 	font-size:18px;
 	font-weight:700;
 }
 .row_pad{
 	padding-top:30px;
 }
.width-auto{
	 width:auto !important;
}
 .layui-form-radio{
 	padding-right: 5px;
 }
</style>
<title>安全保障</title>
</head>
<body class="childrenBody">
<div>
        <form class="myform form-horizontal layui-form" role="form"  id="myform" name="myform">
        	<div class="layui-row" style="padding-bottom:10px;padding-top:30px;">    
		         <div class="layui-col-md2 layui-col-md-offset10">
		         	<span style="text-align:center;display:block;">
		             <c:if test="${'1' eq level}">
						<c:if test="${empty safeEnsureInfo || safeEnsureInfo eq null}">
							<a id="btn_submit" type="button" class="layui-btn" lay-submit lay-filter="saveEnsure"> 提交</a>
							<a id="btn_edit" type="button" class="layui-btn hideBtn">编辑</a>
		                </c:if>
		                <c:if test="${not empty safeEnsureInfo && safeEnsureInfo ne null}">
							<a id="btn_edit" type="button" class="layui-btn">编辑</a>
							<a id="btn_submit" type="button" class="layui-btn hideBtn" lay-submit lay-filter="saveEnsure" style="margin-left:0"> 提交</a>
		                </c:if>
		             </c:if>
		                <a id="btn_back" type="button" class="layui-btn">返回</a>
		               </span>
		               <input type="hidden" name="museumId" id="museumId" value="${museumId}">
		               <input type="hidden" name="id" id="id" value="${safeEnsureInfo.id}">
		               <input type="hidden" name="isFull" id="isFull" value="">
		               <input type="hidden" name="level" id="level" value="${level}">
		    	  </div>
             </div>
	         <div class="layui-row">
	            <div class="layui-col-md2">
	                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp安全保障</a>
	            </div>
            </div>
           <div class="layui-row row_pad">
               <div class="layui-input-inline layui-col-md4">
                   <label class="layui-form-label width-auto">是否建立安全保卫制度：</label>
                   <div class="layui-col-md4">
                         <input type="radio" name="safeSystem" value="1" <c:if test="${'1' eq safeEnsureInfo.safeSystem}">checked</c:if> title="是">
                         <input type="radio" name="safeSystem" value="0" <c:if test="${'0' eq safeEnsureInfo.safeSystem}">checked</c:if> title="否">
                   </div>
               </div>
               <div class="layui-input-inline layui-col-md4">
                   <label  class="layui-form-label width-auto">是否有定期安全保卫巡查记录：</label>
                   <div class="layui-col-md4">
                           <input type="radio" name="safeRecord"  value="1" <c:if test="${'1' eq safeEnsureInfo.safeRecord}">checked</c:if> title="是">
                           <input type="radio" name="safeRecord"  value="0" <c:if test="${'0' eq safeEnsureInfo.safeRecord}">checked</c:if> title="否">
                   </div>
               </div>
               <div class="layui-input-inline layui-col-md4">
                   <label class="layui-form-label width-auto" >是否建立了安全防范应急预案：</label>
                   <div class="layui-col-md4">
                         <input type="radio" name="safePlan"  value="1" <c:if test="${'1' eq safeEnsureInfo.safePlan}">checked</c:if> title="是">
                         <input type="radio" name="safePlan"  value="0" <c:if test="${'0' eq safeEnsureInfo.safePlan}">checked</c:if> title="否">
                   </div>
               </div>
                
           </div>
           
           <div class="layui-row row_pad">
           		
           		<div class="layui-input-inline layui-col-md4">
                   <label class="layui-form-label width-auto" >是否配备安防设施：</label>
                   <div class="layui-col-md4">
                           <input type="radio" name="safeInstallation"  value="1" <c:if test="${'1' eq safeEnsureInfo.safeInstallation}">checked</c:if> title="是">
                           <input type="radio" name="safeInstallation"  value="0" <c:if test="${'0' eq safeEnsureInfo.safeInstallation}">checked</c:if> title="否">
                   </div>
               </div> 
               
               <div class="layui-input-inline layui-col-md4">
                   <label class="layui-form-label width-auto">防盗：</label>
                   <div class="layui-col-md4">
                         <input type="radio" name="guardAgainstTheft" value="1" <c:if test="${'1' eq safeEnsureInfo.guardAgainstTheft}">checked</c:if> title="是">
                         <input type="radio" name="guardAgainstTheft"  value="0" <c:if test="${'0' eq safeEnsureInfo.guardAgainstTheft}">checked</c:if> title="否">
                   </div>
               </div>
               <div class="layui-input-inline layui-col-md4">
                   <label  class="layui-form-label width-auto">防雷：</label>
                   <div class="radio layui-col-md4">
                           <input type="radio" name="lightProtection"  value="1" <c:if test="${'1' eq safeEnsureInfo.lightProtection}">checked</c:if> title="是">
                           <input type="radio" name="lightProtection"  value="0" <c:if test="${'0' eq safeEnsureInfo.lightProtection}">checked</c:if> title="否">
                   </div>
               </div>
               
           </div>
           <div class="layui-row row_pad">
           		<div class="layui-input-inline layui-col-md4">
                   <label class="layui-form-label width-auto">是否配备消防设施：</label>
                   <div class="layui-col-md4">
                         <input type="radio" name="fireDevice" value="1" <c:if test="${'1' eq safeEnsureInfo.fireDevice}">checked</c:if> title="是">
                         <input type="radio" name="fireDevice" value="0" <c:if test="${'0' eq safeEnsureInfo.fireDevice}">checked</c:if> title="否">
                   </div>
               </div>
               
               <div class="layui-input-inline layui-col-md4">
                   <label  class="layui-form-label width-auto">防震：</label>
                   <div class="layui-col-md4">
                         <input type="radio" name="shockproof" value="1" <c:if test="${'1' eq safeEnsureInfo.shockproof}">checked</c:if> title="是">
                         <input type="radio" name="shockproof" value="0" <c:if test="${'0' eq safeEnsureInfo.shockproof}">checked</c:if> title="否">
                   </div>
               </div>
               <div class="layui-input-inline layui-col-md4">
                   <label  class="layui-form-label width-auto">防水：</label>
                   <div class="layui-col-md4">
                           <input type="radio" name="waterproof" value="1" <c:if test="${'1' eq safeEnsureInfo.waterproof}">checked</c:if> title="是">
                           <input type="radio" name="waterproof" value="0" <c:if test="${'0' eq safeEnsureInfo.waterproof}">checked</c:if> title="否">
                   </div>
               </div>
           </div>
           <div class="layui-row row_pad">
               
               <div class="layui-input-inline layui-col-md4">
                   <label  class="layui-form-label width-auto">是否建立消防管理制度：</label>
                   <div class="layui-col-md4">
                           <input type="radio" name="fireSystem"  value="1" <c:if test="${'1' eq safeEnsureInfo.fireSystem}">checked</c:if> title="是">
                           <input type="radio" name="fireSystem"  value="0" <c:if test="${'0' eq safeEnsureInfo.fireSystem}">checked</c:if> title="否">
                   </div>
               </div>
               <div class="layui-input-inline layui-col-md4">
                   <label  class="layui-form-label width-auto">是否有定期消防检查记录：</label>
                   <div class="radio layui-col-md4">
                         <input type="radio" name="fireCheckRecord"  value="1" <c:if test="${'1' eq safeEnsureInfo.fireCheckRecord}">checked</c:if> title="是">
                         <input type="radio" name="fireCheckRecord"  value="0" <c:if test="${'0' eq safeEnsureInfo.fireCheckRecord}">checked</c:if> title="否">
                   </div>
               </div>
               <div class="layui-input-inline layui-col-md4">
                   <label class="layui-form-label width-auto">是否建立参观游览安全管理办法：</label>
                   <div class="layui-col-md4">
                           <input type="radio" name="tourSafety" value="1" <c:if test="${'1' eq safeEnsureInfo.tourSafety}">checked</c:if> title="是">
                           <input type="radio" name="tourSafety" value="0" <c:if test="${'0' eq safeEnsureInfo.tourSafety}">checked</c:if> title="否">
                   </div>
               </div>
           </div>
           
            <div class="layui-row row_pad">
               <div class="layui-input-inline layui-col-md4">
                   <label class="layui-form-label width-auto">是否有应急设施设备：</label>
                   <div class="layui-col-md4">
                         <input type="radio" name="emergencyEquipment" value="1" <c:if test="${'1' eq safeEnsureInfo.emergencyEquipment}">checked</c:if> title="是">
                         <input type="radio" name="emergencyEquipment" value="0" <c:if test="${'0' eq safeEnsureInfo.emergencyEquipment}">checked</c:if> title="否">
                   </div>
               </div>
               <div class="layui-input-inline layui-col-md4">
                   <label class="layui-form-label width-auto">是否建立公共安全应急预案：</label>
                   <div class="layui-col-md4">
                           <input type="radio" name="publicSafePlan"  value="1" <c:if test="${'1' eq safeEnsureInfo.publicSafePlan}">checked</c:if> title="是">
                           <input type="radio" name="publicSafePlan"  value="0" <c:if test="${'0' eq safeEnsureInfo.publicSafePlan}">checked</c:if> title="否">
                   </div>
               </div>
               <div class="layui-input-inline layui-col-md4">
                   <label  class="layui-form-label width-auto">是否设置安全疏散路线图：</label>
                   <div class="layui-col-md4">
                         <input type="radio" name="evacuationMap" value="1" <c:if test="${'1' eq safeEnsureInfo.evacuationMap}">checked</c:if> title="是">
                         <input type="radio" name="evacuationMap" value="0" <c:if test="${'0' eq safeEnsureInfo.evacuationMap}">checked</c:if> title="否">
                   </div>
               </div>
           </div>
           <div class="layui-row row_pad">
           		<div class="layui-input-inline layui-col-md12">
                   <label class="layui-form-label width-auto" >是否符合文物系统博物馆风险等级和安全防护级别的规定（GA27-2012）：</label>
                   <div class="layui-col-md3">
                         <input type="radio" name="riskProvision"  value="1" <c:if test="${'1' eq safeEnsureInfo.riskProvision}">checked</c:if> title="是">
                         <input type="radio" name="riskProvision"  value="0" <c:if test="${'0' eq safeEnsureInfo.riskProvision}">checked</c:if> title="否">
                   </div>
               </div>
               
           </div>
           <div class="layui-row row_pad">
           		<div class="layui-input-inline layui-col-md12">
                   <label class="layui-form-label width-auto" >是否符合《文物系统博物馆安全防范工程设计规范》（GB/T 16571-2012）要求：</label>
                   <div class="layui-col-md3">
                           <input type="radio" name="conformanceNorm"  value="1" <c:if test="${'1' eq safeEnsureInfo.conformanceNorm}">checked</c:if> title="是">
                           <input type="radio" name="conformanceNorm"  value="0" <c:if test="${'0' eq safeEnsureInfo.conformanceNorm}">checked</c:if> title="否">
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
		if( checkModification()){
			layer.confirm('您修改的信息尚未保存，确定要离开吗？', {  
		        btn: ['确定','取消'] //按钮
		    }, function(index){
		    	layer.close(index);  //关闭弹出层
		        //点击确定之后需要执行的函数
		    	var museumId = $("#museumId").val();
		        window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+museumId;
		    }, function(index){
		        layer.close(index);  //关闭弹出层
		    });
		}else{
			var museumId = $("#museumId").val();
	        window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+museumId;
		}
    });
	
	form.on('submit(saveEnsure)', function(data){
		if(checkModification()){
			if($("input[type='radio']:checked").length ==0){
				layer.msg("请先填写资料再提交！",{icon:2});
				return false;
			}
			if(checkFullCom(17)){
				$("#isFull").val("1");
			}else{
				$("#isFull").val("0");
			}
    		var loading;//遮罩
	    	$.ajax({
		       url:"<%=request.getContextPath()%>/safeEnsure/save.do",
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
	                	layer.msg("保存失败！");
	                }
		       },
		       error:function(msg){
    	    	   layer.close(loading);
    	    	   layer.msg("保存失败！");
    	       }
		   });
		}else{
			layer.msg("资料没有修改，无需提交！");
		}
	});
});
</script>
</body>
</html>