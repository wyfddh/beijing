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
 	padding-right:40px;
 	padding-left:40px;
 }
  .label-title{
 	color:#BE9A5B;
 	font-size:18px;
 	font-weight:700;
 }
.checkbox-style{
	text-align: center;
	padding-top:10px;
}
.inputLength{
	width:212px;
}
.pt_10{
	padding-bottom:10px;
}
.pt_20{
	padding-bottom:20px;
}
.pt_30{
	padding-bottom:30px;
}
.pt_40{
	padding-bottom:40px;
}
.pl_10{
	padding-left:10px;
}
.pl_20{
	padding-left:20px;
}
.pl_30{
	padding-left:30px;
}
.pl_40{
	padding-left:40px;
}
 #btn_add{
 	color:#996600;
 	font-size:16px;
 	font-weight:250;
 	padding-left:40px;
 }
 .disabled{
	 pointer-events: none;
	 cursor: default;
	 opacity: 0.6;
 }
 .label-width{
 width:130px !important;
 }
 .width-auto{
 width:auto !important;
 }
 .layui-form-radio{
	 margin: 6px 0px 0 0;
	 padding-right: 5px;
 }
</style>
<title>陈列展览与社会服务</title>
</head>
<body class="childrenBody">
<div>
        <form class="myform form-horizontal layui-form" role="form"  id="myform" name="myform">
        	<input type="hidden" name="museumId" id="museumId" value="${museumId}">
            <input type="hidden" name="id" id="id" value="${serviceInfo.id}">
            <input type="hidden" name="isFull" id="isFull" value="">
            <input type="hidden" name="hidFree" id="hidFree" value="${serviceInfo.freeOpen}">
            <input type="hidden" name="level" id="level" value="${level}">
            <input type="hidden" name="showListStr" id="showListStr" value="">
        	<div class="layui-row pt_10" style="padding-top:20px;">    
		         <div class="layui-col-md2 layui-col-md-offset10">
		         	<span style="text-align:center;display:block;">
		             <c:if test="${'1' eq level}">
						<c:if test="${empty serviceInfo || serviceInfo eq null}">
							<a id="btn_submit" type="button" class="layui-btn" lay-submit lay-filter="savePublic"> 提交</a>
							<a id="btn_edit" type="button" class="layui-btn hideBtn">编辑</a>
		                </c:if>
		                <c:if test="${not empty serviceInfo && serviceInfo ne null}">
							<a id="btn_edit" type="button" class="layui-btn">编辑</a>
							<a id="btn_submit" type="button" class="layui-btn hideBtn" lay-submit lay-filter="savePublic" style="margin-left:0"> 提交</a>
		                </c:if>
		             </c:if>
		                <a id="btn_back" type="button" class="layui-btn">返回</a>
		             </span>  
		    	  </div>
             </div>
	         <div class="layui-row pt_10">
	            <div class="layui-col-md2">
	                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp影响力</a>
	            </div>
            </div>
            
            <div class="layui-form-item  pt_10" >
                 <label style="width:100px;" class="layui-form-label">已有宣传途径：</label>
                 <div class="layui-input-block">
                 	<input type="checkbox" name="tv" <c:if test="${'on' eq serviceInfo.tv}">checked</c:if> title="广播电视">
                 	<input type="checkbox" name="newspaper" <c:if test="${'on' eq serviceInfo.newspaper}">checked</c:if> title="报刊杂志">
                 	<input type="checkbox" name="wechat" <c:if test="${'on' eq serviceInfo.wechat}">checked</c:if> title="微信">
                 	<input type="checkbox" name="weibo" <c:if test="${'on' eq serviceInfo.weibo}">checked</c:if> title="微博">
                 	<input type="checkbox" name="applets" <c:if test="${'on' eq serviceInfo.applets}">checked</c:if> title="小程序">
                 	<input type="checkbox" name="website" <c:if test="${'on' eq serviceInfo.website}">checked</c:if> title="网站">
                 	<input type="checkbox" name="app" <c:if test="${'on' eq serviceInfo.app}">checked</c:if> title="APP">
                 	<input type="checkbox" name="other" <c:if test="${'on' eq serviceInfo.other}">checked</c:if> title="其他">
                 </div>
             </div>
             
             <div class="layui-row pt_10" >
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label width-auto" >是否拥有博物馆品牌标志：</label>
                     <input type="radio" name="logo" value="1" <c:if test="${'1' eq serviceInfo.logo}">checked</c:if> title="是">
                     <input type="radio" name="logo"  value="0" <c:if test="${'0' eq serviceInfo.logo}">checked</c:if> title="否">
                 </div>
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label width-auto" >是否有特色文创产品：</label>
                     <input type="radio" name="creativeProduct"   value="1" <c:if test="${'1' eq serviceInfo.creativeProduct}">checked</c:if> title="是">
                     <input type="radio" name="creativeProduct" value="0" <c:if test="${'0' eq serviceInfo.creativeProduct}">checked</c:if> title="否">
                 </div>
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label width-auto" >是否为携程等旅游网推荐点：</label>
                     <input type="radio" name="travelRecommend"   value="1" <c:if test="${'1' eq serviceInfo.travelRecommend}">checked</c:if> title="是">
                     <input type="radio" name="travelRecommend"  value="0" <c:if test="${'0' eq serviceInfo.travelRecommend}">checked</c:if> title="否">
                 </div>
			</div>  
			<div class="layui-row pt_20" >
				<div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label width-auto">是否有本馆的专业策展人：</label>
                     <input type="radio" name="curator"   value="1" <c:if test="${'1' eq serviceInfo.curator}">checked</c:if> title="是">
                     <input type="radio" name="curator"  value="0" <c:if test="${'0' eq serviceInfo.curator}">checked</c:if> title="否">
                 </div>
			</div>
			<div class="layui-row pt_10">
	            <div class="layui-col-md2">
	                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp基本陈列</a>
	            </div>
            </div>
            
            <div class="layui-inline layui-col-md12 pt_10">
	                <div class="layui-input-inline layui-col-md12">
	            	   <div class="layui-input-inline layui-col-md1" >
	                     <span>&nbsp</span>
	                    </div>
		                 <div class="layui-input-inline layui-col-md2" >
		                   <span style="text-align:center;display:block">名称</span>
		                 </div>
		                 <div class="layui-input-inline layui-col-md4" >
		                    <span style="text-align:center;display:block">展线长度</span>
		                 </div>
		                 <div class="layui-input-inline layui-col-md2" >
		                      <span style="text-align:center;display:block">文物数量</span>
		                 </div>
		                 <div class="layui-input-inline layui-col-md3" >
		                     <span style="text-align:center;display:block">推出时间</span>
		                 </div>
	               </div>
	           </div>
                <div id="comeInList">
                  <c:forEach items="${showList}" var="item" varStatus="sta">
                      <div class="layui-input-inline layui-col-md12 comeIn pt_10" data="${item.id}">
                          <div class="layui-input-inline layui-col-md1">
                             <a id="delete_btn" style="padding-left:40px;"onclick="deleteCost('${item.id}');" ><img src="<%=request.getContextPath() %>/back/images/delete.png" alt="" style="padding-top:3px;"></a>
                           </div>
                          <div class="layui-input-inline layui-col-md2" style="padding-right:10px;">
                              <input type="text" value="${item.name}" class="layui-input" name="name"  lay-verify="required" placeholder="">
                          </div>
                          <div class="layui-input-inline layui-col-md4" style="padding-right:10px;">
                              <input type="text" value="${item.showLengthStr}" class="layui-input" name="showLength"   placeholder="">
                          </div>
                          <div class="layui-input-inline layui-col-md2" style="padding-right:10px;">
                              <input type="text" value="${item.collectionNum}" lay-verify="num" class="layui-input" name="collectionNum"  placeholder="">
                          </div>
                          <div class="layui-input-inline layui-col-md3" style="padding-right:10px;">
                          		<input type="text" value="${item.outTime}" class="layui-input outTime" name="outTime" placeholder="">
                          </div>
                      </div>
                      </c:forEach>
                  </div>
               <div class="layui-inline layui-col-md12 pt_30">
                   			<a id="btn_add" >添加</a>
               </div>
             <div class="layui-row pt_20">
	            <div class="layui-col-md2">
	                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp参观游览服务</a>
	            </div>
            </div>
            <div class="layui-row">
            	<div class="layui-input-inline layui-col-md4">&nbsp;</div>
            	<div class="layui-col-md2">
            		<span style="text-align:center;display:block">是否满足观众需要</span>
            	</div>
            	<div class="layui-input-inline layui-col-md4">&nbsp;</div>
            	<div class="layui-col-md2">
            		<span style="text-align:center;display:block">是否满足观众需要</span>
            	</div>
            </div>
	        <div class="layui-row pt_20">
                  <div class="layui-input-inline layui-col-md4">
                      <label class="layui-form-label label-width">停车位数量：</label>
                      <div class="layui-input-inline layui-col-md4">
                      <input type="text" class="layui-input inputLength typeOne" lay-verify="num" name="parkNum" id="parkNum" value="${serviceInfo.parkNum}">
                      </div>
                  </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="parkNumEn" title="" lay-skin="primary" <c:if test="${'on' eq serviceInfo.parkNumEn}">checked</c:if>>
                  </div>
                  <div class="layui-input-inline layui-col-md4">
	                   <label class="layui-form-label label-width">商品服务部：</label>
	                   <div class="layui-col-md6">
                           <input type="radio" name="productService" value="1" <c:if test="${'1' eq serviceInfo.productService}">checked</c:if> title="有">
                           <input type="radio" name="productService" value="0" <c:if test="${'0' eq serviceInfo.productService}">checked</c:if> title="无">
	                   </div>
	               </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="productServiceEn" <c:if test="${'on' eq serviceInfo.productServiceEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
             </div>
             <div class="layui-row pt_10">
                  <div class="layui-input-inline layui-col-md4">
                      <label class="layui-form-label label-width">公共厕所数量：</label>
                      <div class="layui-input-inline layui-col-md4">
                      <input type="text" class="layui-input inputLength typeOne" lay-verify="num" name="toiletNum" id="toiletNum" value="${serviceInfo.toiletNum}">
                      </div>
                  </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="toiletNumEn" title="" <c:if test="${'on' eq serviceInfo.toiletNumEn}">checked</c:if> lay-skin="primary">
                  </div>
                  <div class="layui-input-inline layui-col-md4">
	                   <label class="layui-form-label label-width">观众休息设施：</label>
	                   <div class="layui-input-inline">
                           <input type="radio" name="restingArea"  value="1" <c:if test="${'1' eq serviceInfo.restingArea}">checked</c:if> title="有">
                           <input type="radio" name="restingArea"  value="0" <c:if test="${'0' eq serviceInfo.restingArea}">checked</c:if> title="无">
	                   </div>
	               </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="restingAreaEn" title="" <c:if test="${'on' eq serviceInfo.restingAreaEn}">checked</c:if>  lay-skin="primary">
                  </div>
             </div>
             <div class="layui-row pt_10">
                  <div class="layui-input-inline layui-col-md4">
                      <label class="layui-form-label label-width">物品寄存服务处：</label>
                      <div class="layui-col-md6">
                           <input type="radio" name="goodsDepository"  value="1" <c:if test="${'1' eq serviceInfo.goodsDepository}">checked</c:if> title="有">
                           <input type="radio" name="goodsDepository"  value="0" <c:if test="${'0' eq serviceInfo.goodsDepository}">checked</c:if> title="无">
	                   </div>
                  </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="goodsDepositoryEn" title="" <c:if test="${'on' eq serviceInfo.goodsDepositoryEn}">checked</c:if> lay-skin="primary">
                  </div>
                  <div class="layui-input-inline layui-col-md4">
	                   <label class="layui-form-label label-width">wifi：</label>
	                   <div class="layui-col-md6">
                           <input type="radio" name="communicationService"  value="1" <c:if test="${'1' eq serviceInfo.communicationService}">checked</c:if> title="有">
                           <input type="radio" name="communicationService"  value="0" <c:if test="${'0' eq serviceInfo.communicationService}">checked</c:if> title="无">
	                   </div>
	               </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="communicationServiceEn" title=""  <c:if test="${'on' eq serviceInfo.communicationServiceEn}">checked</c:if> lay-skin="primary">
                  </div>
             </div>
             <div class="layui-row pt_10">
                  <div class="layui-input-inline layui-col-md4">
                      <label class="layui-form-label label-width">餐饮服务设施：</label>
                      <div class="layui-col-md6">
                           <input type="radio" name="foodService"  value="1" <c:if test="${'1' eq serviceInfo.foodService}">checked</c:if> title="有">
                           <input type="radio" name="foodService"  value="0" <c:if test="${'0' eq serviceInfo.foodService}">checked</c:if> title="无">
	                   </div>
                  </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="foodServiceEn" title="" <c:if test="${'on' eq serviceInfo.foodServiceEn}">checked</c:if> lay-skin="primary">
                  </div>
                  <div class="layui-input-inline layui-col-md4">
	                   <label class="layui-form-label label-width">提供雨伞、轮椅等：</label>
	                   <div class="layui-col-md6">
                           <input type="radio" name="freeUmbrella" value="1" <c:if test="${'1' eq serviceInfo.freeUmbrella}">checked</c:if> title="有">
                           <input type="radio" name="freeUmbrella" value="0" <c:if test="${'0' eq serviceInfo.freeUmbrella}">checked</c:if> title="无">
	                   </div>
	               </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="freeUmbrellaEn" <c:if test="${'on' eq serviceInfo.freeUmbrellaEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
             </div>
             
             <div class="layui-row pt_10">
                  <div class="layui-input-inline layui-col-md4">
                      <label class="layui-form-label label-width">服务台/问询处：</label>
                      <div class="layui-col-md6">
                           <input type="radio" name="informationDesk"  value="1" <c:if test="${'1' eq serviceInfo.informationDesk}">checked</c:if> title="有">
                           <input type="radio" name="informationDesk"  value="0" <c:if test="${'0' eq serviceInfo.informationDesk}">checked</c:if> title="无">
	                   </div>
                  </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="informationDeskEn" <c:if test="${'on' eq serviceInfo.informationDeskEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
                  <div class="layui-input-inline layui-col-md4">
	                   <label class="layui-form-label label-width">现场救援服务：</label>
	                   <div class="layui-col-md6">
                           <input type="radio" name="spotRescue"  value="1" <c:if test="${'1' eq serviceInfo.spotRescue}">checked</c:if> title="有">
                           <input type="radio" name="spotRescue"  value="0" <c:if test="${'0' eq serviceInfo.spotRescue}">checked</c:if> title="无">
	                   </div>
	               </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="spotRescueEn" <c:if test="${'on' eq serviceInfo.spotRescueEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
             </div>
             
             <div class="layui-row pt_10">
                  <div class="layui-input-inline layui-col-md4">
                      <label class="layui-form-label label-width">ATM取款机：</label>
                      <div class="layui-col-md6">
                           <input type="radio" name="atm"  value="1" <c:if test="${'1' eq serviceInfo.atm}">checked</c:if> title="有">
                           <input type="radio" name="atm"  value="0" <c:if test="${'0' eq serviceInfo.atm}">checked</c:if> title="无">
	                   </div>
                  </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="atmEn" <c:if test="${'1' eq serviceInfo.atmEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
                  <div class="layui-input-inline layui-col-md4">
	                   <label class="layui-form-label label-width">导览图：</label>
	                   <div class="layui-col-md6">
                           <input type="radio" name="guideMap"  value="1" <c:if test="${'1' eq serviceInfo.guideMap}">checked</c:if> title="有">
                           <input type="radio" name="guideMap"  value="0" <c:if test="${'0' eq serviceInfo.guideMap}">checked</c:if> title="无">
	                   </div>
	               </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="guideMapEn" <c:if test="${'on' eq serviceInfo.guideMapEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
             </div>
             
             <div class="layui-row pt_10">
                  <div class="layui-input-inline layui-col-md4">
                      <label class="layui-form-label label-width">无障碍设施：</label>
                      <div class="layui-col-md6">
                           <input type="radio" name="barrierFreeStructures"  value="1" <c:if test="${'1' eq serviceInfo.barrierFreeStructures}">checked</c:if> title="有">
                           <input type="radio" name="barrierFreeStructures"  value="0" <c:if test="${'0' eq serviceInfo.barrierFreeStructures}">checked</c:if> title="无">
	                   </div>
                  </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="barrierFreeStructuresEn" <c:if test="${'on' eq serviceInfo.barrierFreeStructuresEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
                  <div class="layui-input-inline layui-col-md4">
	                   <label class="layui-form-label label-width">参观导览系统：</label>
	                   <div class="layui-col-md6">
                           <input type="radio" name="tourGuide"  value="1" <c:if test="${'1' eq serviceInfo.tourGuide}">checked</c:if> title="有">
                           <input type="radio" name="tourGuide"  value="0" <c:if test="${'0' eq serviceInfo.tourGuide}">checked</c:if> title="无">
	                   </div>
	               </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="tourGuideEn" <c:if test="${'on' eq serviceInfo.tourGuideEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
             </div>
             <div class="layui-row pt_30">
                  <div class="layui-input-inline layui-col-md4">
                      <label class="layui-form-label label-width">母婴室：</label>
                      <div class="layui-col-md6">
                           <input type="radio" name="motherRoom"  value="1" <c:if test="${'1' eq serviceInfo.motherRoom}">checked</c:if> title="有">
                           <input type="radio" name="motherRoom"  value="0" <c:if test="${'0' eq serviceInfo.motherRoom}">checked</c:if> title="无">
	                   </div>
                  </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="motherRoomEn" <c:if test="${'on' eq serviceInfo.motherRoomEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
                  <div class="layui-input-inline layui-col-md4">
	                   <label class="layui-form-label label-width">本馆基本信息资料：</label>
	                   <div class="layui-col-md6">
                           <input type="radio" name="baseIntroduce"  value="1" <c:if test="${'1' eq serviceInfo.baseIntroduce}">checked</c:if> title="有">
                           <input type="radio" name="baseIntroduce"  value="0" <c:if test="${'0' eq serviceInfo.baseIntroduce}">checked</c:if> title="无">
	                   </div>
	               </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="baseIntroduceEn" <c:if test="${'on' eq serviceInfo.baseIntroduceEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
             </div>
             
             <div class="layui-row pt_20">
	            <div class="layui-col-md2">
	                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp讲解服务情况</a>
	            </div>
            </div>
            <div class="layui-row">
            	<div class="layui-input-inline layui-col-md4">&nbsp;</div>
            	<div class="layui-col-md2">
            		<span style="text-align:center;display:block">是否满足观众需要</span>
            	</div>
            	<div class="layui-input-inline layui-col-md4">&nbsp;</div>
            	<div class="layui-col-md2">
            		<span style="text-align:center;display:block">是否满足观众需要</span>
            	</div>
            </div>
	        <div class="layui-row pt_20">
                  <div class="layui-input-inline layui-col-md4">
                      <label class="layui-form-label label-width">讲解员数量：</label>
                      <div class="layui-input-inline layui-col-md6">
                      <input type="text" class="layui-input inputLength typeOne" lay-verify="num" name="expostorNum" id="expostorNum" value="${serviceInfo.expostorNum}">
                      </div>
                  </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="expostorNumEn" <c:if test="${'on' eq serviceInfo.expostorNumEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
                  <div class="layui-input-inline layui-col-md4">
                      <label class="layui-form-label label-width">讲解员基本条件：</label>
                      <div class="layui-input-inline layui-col-md6">
                        <select  name="basicCondition" class="inputLength typeOne">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq serviceInfo.basicCondition}">selected</c:if>>本科以上文化程度</option>
                            <option value="2" <c:if test="${'2' eq serviceInfo.basicCondition}">selected</c:if>>大专以上文化程度</option>
                            <option value="3" <c:if test="${'3' eq serviceInfo.basicCondition}">selected</c:if>>中专以上文化程度</option>
                        </select>
                    </div>
                  </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="basicConditionEn" <c:if test="${'on' eq serviceInfo.basicConditionEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
             </div>
             <div class="layui-row pt_10">
                  <div class="layui-input-inline layui-col-md4">
                      <label class="layui-form-label label-width">讲解语种：</label>
                      <div class="layui-input-inline layui-col-md6">
                        <select  name="explainLanguage" class="inputLength typeOne">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq serviceInfo.explainLanguage}">selected</c:if>>汉语、英语等2种以上语言</option>
                            <option value="2" <c:if test="${'2' eq serviceInfo.explainLanguage}">selected</c:if>>汉语、英语</option>
                            <option value="3" <c:if test="${'3' eq serviceInfo.explainLanguage}">selected</c:if>>仅汉语</option>
                        </select>
                    </div>
                  </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="explainLanguageEn" <c:if test="${'on' eq serviceInfo.explainLanguageEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
                  <div class="layui-input-inline layui-col-md4">
                      <label class="layui-form-label label-width">免费讲解服务：</label>
                      <div class="layui-input-inline layui-col-md6">
                        <select  name="freeExplain" class="inputLength typeOne">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq serviceInfo.freeExplain}">selected</c:if>>全部免费讲解</option>
                            <option value="2" <c:if test="${'2' eq serviceInfo.freeExplain}">selected</c:if>>定时免费讲解</option>
                            <option value="3" <c:if test="${'3' eq serviceInfo.freeExplain}">selected</c:if>>无免费讲解</option>
                        </select>
                    </div>
                  </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="freeExplainEn" <c:if test="${'on' eq serviceInfo.freeExplainEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
             </div>
             <div class="layui-row pt_10">
                  <div class="layui-input-inline layui-col-md4">
	                   <label class="layui-form-label label-width">自助语音导览服务：</label>
	                   <div class="layui-col-md6">
                           <input type="radio" name="audioGuide"  value="1" <c:if test="${'1' eq serviceInfo.audioGuide}">checked</c:if> title="有">
                           <input type="radio" name="audioGuide"  value="0" <c:if test="${'0' eq serviceInfo.audioGuide}">checked</c:if> title="无">
	                   </div>
	               </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="audioGuideEn" <c:if test="${'on' eq serviceInfo.audioGuideEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
                  <div class="layui-input-inline layui-col-md4">
	                   <label class="layui-form-label" style="width: 140px !important;">是否有专家讲解服务：</label>
	                   <div class="layui-col-md6">
                           <input type="radio" name="expertExplain"  value="1" <c:if test="${'1' eq serviceInfo.expertExplain}">checked</c:if> title="有">
                           <input type="radio" name="expertExplain"  value="0" <c:if test="${'0' eq serviceInfo.expertExplain}">checked</c:if> title="无">
	                   </div>
	               </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="expertExplainEn" <c:if test="${'on' eq serviceInfo.expertExplainEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
             </div>
             <div class="layui-row pt_30">
                  <div class="layui-input-inline layui-col-md4">
	                   <label class="layui-form-label label-width">触摸屏导览服务：</label>
	                   <div class="layui-col-md6">
                           <input type="radio" name="touchScreen"  value="1" <c:if test="${'1' eq serviceInfo.touchScreen}">checked</c:if> title="有">
                           <input type="radio" name="touchScreen"  value="0" <c:if test="${'0' eq serviceInfo.touchScreen}">checked</c:if> title="无">
	                   </div>
	               </div>
                  <div class="layui-col-md2 checkbox-style">
                    <input type="checkbox" name="touchScreenEn" <c:if test="${'on' eq serviceInfo.touchScreenEn}">checked</c:if> title="" lay-skin="primary">
                  </div>
             </div>
             
            <div class="layui-row pt_20">
	            <div class="layui-col-md2">
	                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp开放服务</a>
	            </div>
            </div>
            
            <div class="layui-row pt_20" >
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label width-auto" >是否免费开放：</label>
                     <div class="layui-col-md7" >
                             <input type="radio" name="freeOpen" lay-filter="freeType" value="1" <c:if test="${'1' eq serviceInfo.freeOpen}">checked</c:if> title="是">
                             <input type="radio" name="freeOpen"  lay-filter="freeType" value="0" <c:if test="${'0' eq serviceInfo.freeOpen}">checked</c:if> title="否">
                             <input type="radio" name="freeOpen"  lay-filter="freeType" value="2" <c:if test="${'2' eq serviceInfo.freeOpen}">checked</c:if> title="部分免费">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label width-auto">是否有免费开放专项资金：</label>
                     <div class="layui-col-md5" >
                             <input type="radio" name="freeOpenFunds"   value="1" <c:if test="${'1' eq serviceInfo.freeOpenFunds}">checked</c:if> title="是">
                             <input type="radio" name="freeOpenFunds" value="0" <c:if test="${'0' eq serviceInfo.freeOpenFunds}">checked</c:if> title="否">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label width-auto" >是否提供夜场开放服务：</label>
                     <div class="layui-col-md5">
                             <input type="radio" name="openNight"   value="1" <c:if test="${'1' eq serviceInfo.openNight}">checked</c:if> title="是">
                             <input type="radio" name="openNight"  value="0" <c:if test="${'0' eq serviceInfo.openNight}">checked</c:if> title="否">
                     </div>
                 </div>
			</div>  
			
			<div class="layui-row pt_30" >
				    <div class="layui-input-inline layui-col-md4" id="bufenFree">
	                    <label class="layui-form-label width-auto">部分免费开放方式：</label>
	                    <div class="layui-input-inline layui-col-md5">
	                        <select  name="freeOpenStyle" class="inputLength">
	                            <option value="">请选择</option>
	                            <option value="1" <c:if test="${'1' eq serviceInfo.freeOpenStyle}">selected</c:if>>定期免费开放</option>
	                            <option value="2" <c:if test="${'2' eq serviceInfo.freeOpenStyle}">selected</c:if>>对未成年人等特定人群免费开放</option>
	                        </select>
	                    </div>
	                </div> 
            	<div class="layui-input-inline layui-col-md4">
                    <label class="layui-form-label width-auto" >免费开放天数：</label>
                    <div class="layui-input-inline layui-col-md5">
                      <input type="text" class="layui-input inputLength" lay-verify="num" name="freeDays" id="freeDays" value="${serviceInfo.freeDays}">
                      </div>
                </div>  
                 
                <div class="layui-input-inline layui-col-md4">
                    <label class="layui-form-label width-auto">全年开放时间：</label>
                    <div class="layui-input-inline layui-col-md5">
                        <select  name="openDays" class="inputLength typeOne">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq serviceInfo.openDays}">selected</c:if>>300天以上</option>
                            <option value="2" <c:if test="${'2' eq serviceInfo.openDays}">selected</c:if>>240天以上</option>
                            <option value="3" <c:if test="${'3' eq serviceInfo.openDays}">selected</c:if>>更少</option>
                            <option value="4" <c:if test="${'4' eq serviceInfo.openDays}">selected</c:if>>无</option>
                        </select>
                    </div>
                </div>  
            </div> 
            
            <div class="layui-row pt_30">
	            <div class="layui-col-md2">
	                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp志愿者服务</a>
	            </div>
            </div>
            <div class="layui-row pt_20" >
            	<div class="layui-input-inline layui-col-md4">
                    <label class="layui-form-label width-auto" >志愿者数量：</label>
                    <div class="layui-input-inline layui-col-md7">
                      <input type="text" class="layui-input inputLength typeOne" lay-verify="num" name="volunteerNum" id="volunteerNum" value="${serviceInfo.volunteerNum}">
                     </div>
                </div> 
            	<div class="layui-input-inline layui-col-md4">
                    <label class="layui-form-label width-auto" >志愿者服务岗位：</label>
                    <div class="layui-input-inline">
                        <select  name="volunteerPost" class="inputLength">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq serviceInfo.volunteerPost}">selected</c:if>>讲解员</option>
                            <option value="2" <c:if test="${'2' eq serviceInfo.volunteerPost}">selected</c:if>>其他</option>
                        </select>
                    </div>
                </div>  
                <div class="layui-input-inline layui-col-md4">
                    <label class="layui-form-label width-auto">志愿者人群分布：</label>
                    <div class="layui-input-inline">
                        <select  name="volunteerDistribution" class="inputLength">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq serviceInfo.volunteerDistribution}">selected</c:if>>学生</option>
                            <option value="2" <c:if test="${'2' eq serviceInfo.volunteerDistribution}">selected</c:if>>社会人员</option>
                            <option value="3" <c:if test="${'3' eq serviceInfo.volunteerDistribution}">selected</c:if>>志愿者协会成员</option>
                        </select>
                    </div>
                </div>  
            </div> 
             <div class="layui-row pt_30">
             	<div class="layui-input-inline layui-col-md4">
                    <label class="layui-form-label width-auto" >志愿者服务时间：</label>
                    <div class="layui-input-inline">
                        <select  name="volunteerTime" class="inputLength">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq serviceInfo.volunteerTime}">selected</c:if>>每年服务时间不低于48小时</option>
                            <option value="2" <c:if test="${'2' eq serviceInfo.volunteerTime}">selected</c:if>>每年服务时间不低于24小时</option>
                            <option value="3" <c:if test="${'3' eq serviceInfo.volunteerTime}">selected</c:if>>每年服务时间不低于12小时</option>
                        </select>
                    </div>
                </div>
             	<div class="layui-input-inline layui-col-md8">
                    <label class="layui-form-label width-auto" >是否为北京文博志愿者总队注册成员：</label>
                    <div class="layui-input-inline">
                    		<input type="radio" name="volunteerTeam"   value="1" <c:if test="${'1' eq serviceInfo.volunteerTeam}">checked</c:if> title="是">
                             <input type="radio" name="volunteerTeam"  value="0" <c:if test="${'0' eq serviceInfo.volunteerTeam}">checked</c:if> title="否">
                      </div>
                </div> 
             </div>
             
            <div class="layui-row pt_20">
	            <div class="layui-col-md2">
	                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp社教活动</a>
	            </div>
            </div>
            
             <div class="layui-row pt_20" >
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label width-auto" >有无冬夏令营活动：</label>
                     <div class="layui-input-inline layui-col-md5" >
                             <input type="radio" name="campActivities" value="1" <c:if test="${'1' eq serviceInfo.campActivities}">checked</c:if> title="有">
                             <input type="radio" name="campActivities"  value="0" <c:if test="${'0' eq serviceInfo.campActivities}">checked</c:if> title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label width-auto">有无博物馆课程：</label>
                     <div class="layui-input-inline layui-col-md5" >
                             <input type="radio" name="courseTitle"   value="1" <c:if test="${'1' eq serviceInfo.courseTitle}">checked</c:if> title="有">
                             <input type="radio" name="courseTitle" value="0" <c:if test="${'0' eq serviceInfo.courseTitle}">checked</c:if> title="无">
                     </div>
                 </div>
                 <div class="layui-input-inline layui-col-md4">
                     <label class="layui-form-label width-auto" >有无共建学校：</label>
                     <div class="layui-input-inline layui-col-md5">
                             <input type="radio" name="buildingSchool"   value="1" <c:if test="${'1' eq serviceInfo.buildingSchool}">checked</c:if> title="有">
                             <input type="radio" name="buildingSchool"  value="0" <c:if test="${'0' eq serviceInfo.buildingSchool}">checked</c:if> title="无">
                     </div>
                 </div>
			</div>
			<div class="layui-row">
            	<div class="layui-col-md4">
                      <label class="layui-form-label width-auto">专职社教工作人员数量：</label>
                    <div class="layui-input-inline layui-col-md4">
	                    <input type="text" style="width:150px;" class="layui-input inputLength" lay-verify="num" name="educationNumber" id="educationNumber" value="${serviceInfo.educationNumber}" placeholder="">
                    </div>
                </div>
                <div class="layui-col-md4">
                       <label class="layui-form-label width-auto" >博物馆课程名称：</label>
                    	<div class="layui-input-inline layui-col-md6">
                    		<input type="text" class="layui-input inputLength" name="courseTitleName" id="courseTitleName"  value="${serviceInfo.courseTitleName}" placeholder="">
                   	    </div>
                 </div>
                 <div class="layui-col-md4">
                    <label class="layui-form-label width-auto" for="allBuildingArea">特色社教活动：</label>
                    <div class="layui-input-inline layui-col-md6">
                      <input type="text" class="layui-input inputLength" name="educationActivities" id="educationActivities"  value="${serviceInfo.educationActivities}" placeholder="">
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

layui.use(['form', 'laydate'], function() {
	var form = layui.form,
	layer = layui.layer,
	laydate = layui.laydate,
	$=layui.jquery;
	var idStr= $("#id").val();
	var level = $("#level").val();
	if(level=="2" || (idStr !=null && idStr != "")){
		$('input,select').attr('disabled',"disabled");
		$("#btn_add").addClass("disabled");
		$("#comeInList .comeIn").find("#delete_btn").addClass("disabled");
		form.render();
	}
	
	var freeOpen = $("#hidFree").val();
	if(freeOpen == '2'){
		$("#bufenFree").show();
	}else{
		$("#bufenFree").hide();
	}
	lay('.outTime').each(function(){
 	   laydate.render({
 	      elem: this
 	     ,trigger: 'click'
 	   });
 	 }); 
	initFileds();
	$("#btn_edit").click(function(){
		$('input,select').removeAttr("disabled");
		$("#btn_edit").addClass("hideBtn");
		$("#btn_submit").removeClass("hideBtn");
		$("#btn_add").removeClass("disabled");
		$("#comeInList .comeIn").find("#delete_btn").removeClass("disabled");
		form.render();
    });
	
	//校验
    form.verify(
    {num:[/(^$)|(^[0-9]*$)/,'请输入数字']}
	); 
	
	form.on('radio(freeType)',function(data){
		if(data.value == '2'){
			$("#bufenFree").show();
		}else{
			$("#bufenFree").hide();
		}
	})
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
	form.on('submit(savePublic)', function(data){
		if(checkModification()){
			
    		var museumId=$("#museumId").val();
    		var showList=new Array();
			var len=$("#comeInList").children().length;
	        for(var i=0;i<len;i++){
	            var id=$("#comeInList .comeIn").eq(i).attr("data")?$("#comeInList .comeIn").eq(i).attr("data"):"";
	            var name= $("#comeInList .comeIn").eq(i).find("input[name='name']").val()||"";
	            var showLength= $("#comeInList .comeIn").eq(i).find("input[name='showLength']").val()||"";
	            var collectionNum= $("#comeInList .comeIn").eq(i).find("input[name='collectionNum']").val()||"";
	            var outTime= $("#comeInList .comeIn").eq(i).find("input[name='outTime']").val()||"";
	           showList.push({"name":name,"showLength":showLength,"collectionNum":collectionNum,"outTime":outTime,"id":id,"museumId":museumId})
	        }
		    console.log(showList);
		    $("#showListStr").val(JSON.stringify(showList));
		    //28个单选控件
			if(checkFullCom(28)){
				$("#isFull").val("1");
			}else{
				$("#isFull").val("0");
			}
		    var loading; 
	    	$.ajax({
		       url:"<%=request.getContextPath()%>/museumPublicService/save.do",
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
	
	$(document).on('click','#btn_add',function(){
	       var str="<div class=\"layui-input-inline layui-col-md12 comeIn pt_10\">\n" +
	           "                                            <div class=\"layui-input-inline layui-col-md1\">\n" +
	           "                                                   <a style=\"padding-left:40px;\" id =\"delete_btn\" onclick=\"deleteCost(this)\"><img src=\"<%=request.getContextPath() %>/back/images/delete.png\" style=\"padding-top:3px\"></a>\n"+
	           "                                            </div>\n" +
	           "                                            <div class=\"layui-input-inline layui-col-md2\" style=\"padding-right:10px;\">\n" +
	           "                                                <input type=\"text\" class=\"layui-input\" name=\"name\" lay-verify=\"required\" placeholder=\"\">\n" +
	           "                                            </div>\n" +
	           "                                            <div class=\"layui-input-inline layui-col-md4\" style=\"padding-right:10px;\">\n" +
	           "                                                <input type=\"text\" class=\"layui-input\" name=\"showLength\"  placeholder=\"\">\n" +
	           "                                            </div>\n" +
	           "                                            <div class=\"layui-input-inline layui-col-md2\" style=\"padding-right:10px;\">\n" +
	           "                                                <input type=\"text\" class=\"layui-input\" lay-verify=\"num\" name=\"collectionNum\"  placeholder=\"\">\n" +
	           "                                            </div>\n" +
	           "                                            <div class=\"layui-input-inline layui-col-md3\" style=\"padding-right:10px;\">\n" +
	           "                                                <input type=\"text\" class=\"layui-input outTime\" name=\"outTime\" id=\"outTime\" placeholder=\"\">\n" +
	           "                                            </div>\n" +
	           "                                        </div>";
	       $("#comeInList").append(str);
	       form.render('select');
	       var len=$("#comeInList").children().length;
	       $("input[name='outTime']").eq(len-1).attr("id","outTime"+len);
	       laydate.render({
	   	    	elem: '#outTime'+len
	   	   });
	});
});

function deleteCost(id) {

	layer.confirm('确定删除该条数据？', {icon: 3, title: '删除确认'}, function (index) {
		layer.close(index);
		if(typeof(id)==="object"){
	        $(id).parents(".layui-col-md12")[0].remove();
	    }else{
	    	$.ajax({
			       url:"<%=request.getContextPath()%>/museumPublicService/delete.do",
			       data:{"id":id},
			       type:"POST",
			       success:function(msg){
			    	   if(msg.success == 1){
			    		  layer.msg("删除成功");
		                 setTimeout(function(){
							window.location.href = window.location.href;
						},1000)
		             }else if(msg.success == 0){
		            	 layer.msg("删除失败",{icon:2});
		             }
			       }
			 });
	    }
		
    })
}    

</script>
</body>
</html>