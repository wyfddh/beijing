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
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
 .hideBtn{
     display: none;
 }
 .childrenBody{
 	padding:10px;
 }
 .layui-form-label{
 	padding-left:0px;
 	width:120px;
 }
 .childrenBody{
 	padding:20px;
 }
 .label-title{
 	color:#BE9A5B;
 	font-size:18px;
 	font-weight:700;
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
 .pb_10{
	padding-bottom:10px;
}
.pb_20{
	padding-bottom:20px;
}
.pb_30{
	padding-bottom:30px;
}
.pb_40{
	padding-bottom:40px;
}
.pt_10{
	padding-top:10px;
}
.pt_20{
	padding-top:20px;
}
.pt_30{
	padding-top:30px;
}
.pt_40{
	padding-top:40px;
}
</style>
<title>馆舍建筑与基础设施</title>
</head>
<body class="childrenBody">
	<div class="box-build">  
	<form class="mesForm form-horizontal layui-form" role="form"  id="mesForm" name="mesForm">
		<input type="hidden" name="museumId" id="museumId" value="${museumId}">
        <input type="hidden" name="isFull" id="isFull" value="">
        <input type="hidden" name="level" id="level" value="${level}">
        <input type="hidden" name="id" id="id" value="${base.id}">
        <input type="hidden" name="buildListStr" id="buildListStr" value="">
        <input type="hidden" name="warehouseListString" id="warehouseListString" value="">
        <input type="hidden" name="showHouseList" id="showHouseList" value="">
			<div class="layui-row pt_30">    
	          <div class="layui-col-md2 layui-col-md-offset10">
	          	<span style="text-align:center;display:block;">
	          	<c:if test="${'1' eq level}">
					<c:if test="${empty base || base eq null}">
						<a id="btn_submit" type="button" class="layui-btn" lay-submit lay-filter="saveBuild"> 提交</a>
						<a id="btn_edit" type="button" class="layui-btn hideBtn">编辑</a>
	                </c:if>
	                <c:if test="${not empty base && base ne null}">
						<a id="btn_edit" type="button" class="layui-btn">编辑</a>
						<a id="btn_submit" type="button" class="layui-btn hideBtn" lay-submit lay-filter="saveBuild" style="margin-left:0px"> 提交</a>
	                </c:if>
	              </c:if>
	                <a id="btn_back" type="button" class="layui-btn">返回</a>
	                </span>
	    	  </div>
            </div>
           <div class="layui-row pt_10 pb_20">
	            <div class="layui-col-md2">
	                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp基本信息</a>
	            </div>
            </div>
          
            <div class="layui-row pb_20">
            	<div class="layui-col-md4">
                      <label class="layui-form-label" for="mumName">博物馆名称：</label>
                    <div class="layui-input-inline layui-col-md7">
	                    <input type="text" class="layui-input" name="museumName" id="museumName" value="${museumName}">
	                    
                    </div>
                </div>
                <div class="layui-col-md4">
                       <label class="layui-form-label">占地总面积：</label>
                    	<div class="layui-input-inline layui-col-md7">
                    		<input type="text" class="layui-input typeOne" name="allFloorArea" id="allFloorArea"  value="${base.allFloorAreaStr}" placeholder="/m*m">
                   	    </div>
                 </div>
                 <div class="layui-col-md4">
                    <label class="layui-form-label">总建筑面积：</label>
                    <div class="layui-input-inline layui-col-md7">
                      <input type="text" class="layui-input typeOne" name="allBuildingArea" id="allBuildingArea" value="${base.allBuildingAreaStr}" placeholder="/m*m">
                   	</div>
                </div>
            </div>
            
            <div class="layui-row pb_20">
            	<div class="layui-col-md4">
                      <label class="layui-form-label">展陈面积：</label>
                    <div class="layui-input-inline layui-col-md7">
	                    <input type="text" class="layui-input typeOne" name="exhibitionArea" id="exhibitionArea" value="${base.exhibitionAreaStr}">
                    </div>
                </div>
                <div class="layui-col-md4">
                       <label class="layui-form-label">公共服务区面积：</label>
                    	<div class="layui-input-inline layui-col-md7">
                    		<input type="text" class="layui-input typeOne" name="publicArea" id="publicArea"  value="${base.publicAreaStr}" placeholder="/m*m">
                   	    </div>
                 </div>
                 <div class="layui-col-md4">
                    <label class="layui-form-label">藏品管理区面积：</label>
                    <div class="layui-input-inline layui-col-md7">
                      <input type="text" class="layui-input typeOne" name="collectionArea" id="collectionArea" value="${base.collectionAreaStr}" placeholder="/m*m">
                   	</div>
                </div>
            </div>
            
            <div class="layui-row pb_30">
            	<div class="layui-col-md4">
                      <label class="layui-form-label" for="mumName">办公区面积：</label>
                    <div class="layui-input-inline layui-col-md7">
	                    <input type="text" class="layui-input typeOne" name="officeArea" id="officeArea" value="${base.officeAreaStr}">
                    </div>
                </div>
            </div>
            <div class="layui-row pb_10">
	           <div class="layui-col-md2">
	               <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp馆舍信息</a>
	           </div>
    		</div>
                <div class="layui-inline layui-col-md12">
	              	<div class="layui-input-inline layui-col-md12">
	              	   <div class="layui-input-inline layui-col-md1" >
		                  <span>&nbsp</span>
		               </div>
	                   <div class="layui-input-inline layui-col-md3" >
		                  <span style="text-align:center;display:block">馆设名称</span>
		               </div>
	                   <div class="layui-input-inline layui-col-md2" >
	                      <span style="text-align:center;display:block">占地面积</span>
	                   </div>
	                   <div class="layui-input-inline layui-col-md3" >
	                        <span style="text-align:center;display:block">馆设文物建筑级别</span>
	                   </div>
	                   <div class="layui-input-inline layui-col-md3" >
	                       <span style="text-align:center;display:block">建筑所有权</span>
	                   </div>
	                 </div>
                 </div>
                 <div id="houseList">
                   <c:forEach items="${houseList}" var="item" varStatus="sta">
                    <div class="layui-input-inline layui-col-md12 house pt_10" data="${item.id}">
                       <div class="layui-input-inline layui-col-md1">
                          <a id="delete_btn" class="delete_btn" style="padding-left:40px;" onclick="delHouse('${item.id}','house')" ><img src="<%=request.getContextPath() %>/back/images/delete.png" alt="" style="padding-top:3px;width:2rem;height:2rem;border-radius: 1.5rem"></a>
                       </div>
                       <div class="layui-input-inline layui-col-md3" style="padding-right:10px;"> 
                           <input type="text" class="layui-input" lay-verify="required" value="${item.houseName}" name="houseName" placeholder="馆设名称">
                 	   </div>
	                   <div class="layui-input-inline layui-col-md2" style="padding-right:10px;">
	                         <input type="text" class="layui-input" name="floorArea" value="${item.floorAreaStr}" placeholder="/m*m">
	                   </div>
	                   <div class="layui-input-inline layui-col-md3" style="padding-right:10px;">
	                          <select class="layui-col-md3" name="level" value="${item.level}" >
	                              <option value="">请选择</option>
								  <option value="1"  <c:if test="${'1' eq item.level}">selected</c:if>>非文物建筑</option>
								  <option value="2"  <c:if test="${'2' eq item.level}">selected</c:if>>国家重点文物保护单位</option>
								  <option value="3"  <c:if test="${'3' eq item.level}">selected</c:if>>省市级文物保护单位</option>
								  <option value="4"  <c:if test="${'4' eq item.level}">selected</c:if>>区县级文物保护单位</option>
	                          </select>
	                    </div>
	                     <div class="layui-input-inline layui-col-md3">
	                         <select class="layui-col-md3" name="ownership" value="${item.ownership}" >
							<option value="">请选择</option>
							<option value="1"  <c:if test="${'1' eq item.ownership}">selected</c:if>>本馆</option>
							<option value="2"  <c:if test="${'2' eq item.ownership}">selected</c:if>>租用</option>
	                         </select>
	                     </div>
                    </div>  
                   </c:forEach>
                 </div>
                 <div class="layui-inline layui-col-md12 pb_30 pt_10" role="group">
                     <a id="btn_add" class="btn_add" href="javascript:add_row('house');">添加</a>
                 </div>
                 
             <div class="layui-row pb_20">
	           <div class="layui-col-md2">
	               <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp库房信息</a>
	           </div>
    		</div>
                <div class="layui-inline layui-col-md12">
	              	<div class="layui-input-inline layui-col-md12">
	              	   <div class="layui-input-inline layui-col-md1" >
		                  <span>&nbsp</span>
		               </div>
	                   <div class="layui-input-inline layui-col-md2" >
		                  <span style="text-align:center;display:block">库房名称</span>
		               </div>
	                   <div class="layui-input-inline layui-col-md1" >
	                      <span style="text-align:center;display:block">库房面积</span>
	                   </div>
	                   <div class="layui-input-inline layui-col-md2" >
	                        <span style="text-align:center;display:block">温湿度控制设施</span>
	                   </div>
	                   <div class="layui-input-inline layui-col-md2" >
	                       <span style="text-align:center;display:block">安全消防设施</span>
	                   </div>
	                 </div>
                 </div>
                 <div id="wareList">
                   <c:forEach items="${wareList}" var="item" varStatus="sta">
                    <div class="layui-input-inline layui-col-md12 ware pt_10" data="${item.id}">
                       <div class="layui-input-inline layui-col-md1">
                          <a id="delete_btn" class="delete_btn" style="padding-left:40px;" onclick="delHouse('${item.id}','ware')" ><img src="<%=request.getContextPath() %>/back/images/delete.png" alt="" style="padding-top:3px;"></a>
                       </div>
                       <div class="layui-input-inline layui-col-md2" style="padding-right:10px;"> 
                           <input type="text" class="layui-input" lay-verify="required" value="${item.name}" name="name" placeholder="">
                 	   </div>
	                   <div class="layui-input-inline layui-col-md1" style="padding-right:10px;">
	                         <input type="text" class="layui-input" name="houseArea" value="${item.houseAreaStr}" placeholder="/m*m">
	                   </div>
	                   <div class="layui-input-inline layui-col-md2" style="padding-right:10px;">
	                          <select name="temperature">
	                              <option value="">请选择</option>
								  <option value="1"  <c:if test="${'1' eq item.temperature}">selected</c:if>>设施完善，设备齐全</option>
								  <option value="2"  <c:if test="${'2' eq item.temperature}">selected</c:if>>设备基本齐全，能控制温湿度</option>
								  <option value="3"  <c:if test="${'3' eq item.temperature}">selected</c:if>>有简单的温湿度控制设备</option>
								  <option value="4"  <c:if test="${'4' eq item.temperature}">selected</c:if>>没有温湿度控制设备</option>
	                          </select>
	                    </div>
	                    <div class="layui-input-inline layui-col-md2">
	                         <select  name="fireFighting">
							<option value="">请选择</option>
							<option value="1"  <c:if test="${'1' eq item.fireFighting}">selected</c:if>>设施完善，设备齐全</option>
							<option value="2"  <c:if test="${'2' eq item.fireFighting}">selected</c:if>>基本完善、设备基本齐全</option>
							<option value="3"  <c:if test="${'3' eq item.fireFighting}">selected</c:if>>有简单的安防消防设施</option>
							<option value="4"  <c:if test="${'4' eq item.fireFighting}">selected</c:if>>没有安防消防设施</option>
	                         </select>
	                     </div>
	                     
	                     <div class="layui-input-inline layui-col-md4">
	                        <div class="layui-form-item" >
				                 <div class="layui-input-block" style="margin-left: 30px">
				                 	<input type="checkbox" name="collectionNeeds" <c:if test="${'on' eq item.collectionNeeds}">checked</c:if> title="满足藏品收藏需要">
				                 	<input type="checkbox" name="completeRack" <c:if test="${'on' eq item.completeRack}">checked</c:if> title="货架齐全">
				                 	<input type="checkbox" name="ventilationFacility" <c:if test="${'on' eq item.ventilationFacility}">checked</c:if> title="通风设施">
				                 	<input type="checkbox" name="guardAgainstTheft" <c:if test="${'on' eq item.guardAgainstTheft}">checked</c:if> title="防盗">
				                 </div>
                           </div>
                           	<div class="layui-form-item" >
				                 <div class="layui-input-block" style="margin-left: 30px">
				                 	<input type="checkbox" name="airPollution" <c:if test="${'on' eq item.airPollution}">checked</c:if> title="防空气污染设施">
				                 	<input type="checkbox" name="lightProtection" <c:if test="${'on' eq item.lightProtection}">checked</c:if> title="防自然灾害">
				                 	<input type="checkbox" name="mildewResistance" <c:if test="${'on' eq item.mildewResistance}">checked</c:if> title="防霉变设施">
				                 	<input type="checkbox" name="insectControl" <c:if test="${'on' eq item.insectControl}">checked</c:if> title="防虫">
				                 </div>
                           </div>
                           	<div class="layui-form-item" >
				                 <div class="layui-input-block" style="margin-left: 30px">
				                 	<input type="checkbox" name="monitor" <c:if test="${'on' eq item.monitor}">checked</c:if> title="入侵报警系统">
				                 	<input type="checkbox" name="waterproof" <c:if test="${'on' eq item.waterproof}">checked</c:if> title="防水">
				                 	<input type="checkbox" name="roomLighting" <c:if test="${'on' eq item.roomLighting}">checked</c:if> title="照明设施合格">
				                 	<input type="checkbox" name="corrosionProtection" <c:if test="${'on' eq item.corrosionProtection}">checked</c:if> title="防腐蚀设施">
				                 </div>
                           </div>
	                     </div>
                    </div>  
                   </c:forEach>
                 </div>
                 <div class="layui-inline layui-col-md12 pb_30" role="group">
                     <a id="btn_add" class="btn_add" href="javascript:add_row('ware');">添加</a>
                 </div>
                 
                 
            <div class="layui-row pb_20">
	           <div class="layui-col-md2">
	               <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp展厅信息</a>
	           </div>
    		</div>
                <div class="layui-inline layui-col-md12">
	              	<div class="layui-input-inline layui-col-md12">
	              	   <div class="layui-input-inline layui-col-md1" >
		                  <span>&nbsp</span>
		               </div>
	                   <div class="layui-input-inline layui-col-md1" >
		                  <span style="text-align:center;display:block">展厅名称</span>
		               </div>
	                   <div class="layui-input-inline layui-col-md1" >
	                      <span style="text-align:center;display:block">展厅面积</span>
	                   </div>
	                   <div class="layui-input-inline layui-col-md2" >
	                        <span style="text-align:center;display:block">照明符合规范程度</span>
	                   </div>
	                   <div class="layui-input-inline layui-col-md2" >
	                       <span style="text-align:center;display:block">展柜微环境适宜展品保护</span>
	                   </div>
	                   <div class="layui-input-inline layui-col-md2" >
	                       <span style="text-align:center;display:block">安防消防设施</span>
	                   </div>
	                 </div>
                 </div>
                 <div id="roomList">
                   <c:forEach items="${roomList}" var="item" varStatus="sta">
                    <div class="layui-input-inline layui-col-md12 room pt_10" data="${item.id}">
                       <div class="layui-input-inline layui-col-md1">
                          <a id="delete_btn" class="delete_btn" style="padding-left:40px;" onclick="delHouse('${item.id}','room')" ><img src="<%=request.getContextPath() %>/back/images/delete.png" alt="" style="padding-top:3px;"></a>
                       </div>
                       <div class="layui-input-inline layui-col-md1" style="padding-right:10px;"> 
                           <input type="text" class="layui-input"  lay-verify="required" value="${item.name}" name="name" placeholder="">
                 	   </div>
	                   <div class="layui-input-inline layui-col-md1" style="padding-right:10px;">
	                         <input type="text" class="layui-input" name="area" value="${item.areaStr}" placeholder="/m*m">
	                   </div>
	                   <div class="layui-input-inline layui-col-md2" style="padding-right:10px;">
	                          <select name="roomLighting" >
	                              <option value="">请选择</option>
								  <option value="1"  <c:if test="${'1' eq item.roomLighting}">selected</c:if>>完全符合</option>
								  <option value="2"  <c:if test="${'2' eq item.roomLighting}">selected</c:if>>基本符合</option>
								  <option value="3"  <c:if test="${'3' eq item.roomLighting}">selected</c:if>>不符合</option>
	                          </select>
	                    </div>
	                    <div class="layui-input-inline layui-col-md2" style="padding-right:10px;">
	                         <select  name="collectionProtect">
							<option value="">请选择</option>
							<option value="1"  <c:if test="${'1' eq item.collectionProtect}">selected</c:if>>所有文物展柜均符合</option>
							<option value="2"  <c:if test="${'2' eq item.collectionProtect}">selected</c:if>>珍贵文物展柜均符合</option>
							<option value="3"  <c:if test="${'3' eq item.collectionProtect}">selected</c:if>>少部分文物展柜符合</option>
							<option value="4"  <c:if test="${'4' eq item.collectionProtect}">selected</c:if>>不符合</option>
	                         </select>
	                     </div>
	                     
	                     <div class="layui-input-inline layui-col-md2">
	                         <select  name="fireFighting"" >
							<option value="">请选择</option>
							<option value="1"  <c:if test="${'1' eq item.fireFighting}">selected</c:if>>设施完善，设备齐全</option>
							<option value="2"  <c:if test="${'2' eq item.fireFighting}">selected</c:if>>基本完善、设备基本齐全</option>
							<option value="3"  <c:if test="${'3' eq item.fireFighting}">selected</c:if>>有简单的安防消防设施</option>
							<option value="4"  <c:if test="${'4' eq item.fireFighting}">selected</c:if>>没有安防消防设施</option>
	                         </select>
	                     </div>
	                     
	                     <div class="layui-input-inline layui-col-md3">
	                        <div class="layui-form-item" >
				                 <div class="layui-input-block" style="margin-left: 30px">
				                 	<input type="checkbox" name="monitor" <c:if test="${'on' eq item.monitor}">checked</c:if> title="入侵报警系统">
				                 	<input type="checkbox" name="guardAgainstTheft" <c:if test="${'on' eq item.guardAgainstTheft}">checked</c:if> title="防盗">
				                 	<input type="checkbox" name="firePrevention" <c:if test="${'on' eq item.firePrevention}">checked</c:if> title="防火">
				                 </div>
                           </div>
                           <div class="layui-form-item" >
				                 <div class="layui-input-block" style="margin-left: 30px">
				                 	<input type="checkbox" name="lightProtection" <c:if test="${'on' eq item.lightProtection}">checked</c:if> title="防雷">
				                 	<input type="checkbox" name="shockproof" <c:if test="${'on' eq item.shockproof}">checked</c:if> title="防震">
				                 	<input type="checkbox" name="waterproof" <c:if test="${'on' eq item.waterproof}">checked</c:if> title="防水">
				                 </div>
                           </div>
                      </div>
                      </div>  
                   </c:forEach>
                 </div>
                 <div class="layui-inline layui-col-md12 pb_30" role="group">
                     <a id="btn_add" class="btn_add" href="javascript:add_row('room');">添加</a>
                 </div>
             <div class="layui-row pb_30">
	           <div class="layui-col-md2">
	               <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp文物保护修复场所</a>
	           </div>
    		</div>
    		<div class="layui_row">
    			<div class="layui-input-inline layui-col-md5">
                     <label class="layui-form-label" style="width:auto !important;">是否独立拥有藏品保护修复场所：</label>
                     <div class="layui-col-md5" >
                             <input type="radio" name="repairSite" value="1" <c:if test="${'1' eq base.repairSite}">checked</c:if> title="是">
                             <input type="radio" name="repairSite"  value="0" <c:if test="${'0' eq base.repairSite}">checked</c:if> title="否">
                     </div>
                 </div>
                 <div class="layui-col-md5">
                      <label class="layui-form-label">场地面积：</label>
                    <div class="layui-input-inline layui-col-md5">
	                    <input type="text" class="layui-input" name="repairArea" id="repairArea" value="${base.repairAreaStr}">
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

layui.use(['form','laydate'], function() {
	var form = layui.form,
	layer = layui.layer,
	$=layui.jquery;
	var len=$("#houseList").children().length;
	var id = $("#id").val();
	var level=$("#level").val();
	if(level=="2" ||id !=""){
		$('input,select').attr('disabled',"disabled");
		$(".box-build").find(".btn_add").addClass("disabled");
		$(".box-build").find(".delete_btn").addClass("disabled");
		form.render('select');
	}
	initFileds();
	$("#btn_edit").click(function(){
		$('input,select').removeAttr("disabled");
		$("#museumName").attr('disabled','disabled');
		$("#btn_edit").addClass("hideBtn");
		$("#btn_submit").removeClass("hideBtn");
		$(".box-build").find(".btn_add").removeClass("disabled");
		$(".box-build").find(".delete_btn").removeClass("disabled");
		form.render('select');
    });
	
	//添加功能
	window.add_row = function(type){
		var htmlStr;
		if(type=="house"){
			htmlStr = appendHtml(type);
	        $("#houseList").append(htmlStr);
			form.render();
		}else if(type=="ware"){
			htmlStr = appendHtml(type);
			$("#wareList").append(htmlStr);
			form.render();
		}else if(type == "room"){
			htmlStr = appendHtml(type);
			$("#roomList").append(htmlStr);
			form.render();
		}
	}
	
	//删除功能
	window.delHouse = function(id,type){
		var museumId=$("#museumId").val();
		layer.confirm('确定删除该条数据？', {icon: 3, title: '删除确认'}, function (index) {
			layer.close(index);  //关闭弹出层
			if(typeof(id)==="object"){
		        $(id).parents(".layui-col-md12")[0].remove();
		    }else{
		    	var requestUrl;
		    	if(type == "house"){
		    		requestUrl= "<%=request.getContextPath()%>/museumHouseBuilding/deleteHouse.do";
		    	}else if(type=="ware"){
		    		requestUrl= "<%=request.getContextPath()%>/museumHouseBuilding/deleteWarehouse.do";
		    	}else if(type=="room"){
		    		requestUrl= "<%=request.getContextPath()%>/museumHouseBuilding/deleteRoom.do";
		    	}
				$.ajax({
				       url:requestUrl,
				       data:{"id":id},
				       type:"POST",
				       success:function(msg){
				    	   if(msg.success == 1){
			             	layer.msg("删除成功！");
			                 setTimeout(function(){
								window.location.href = window.location.href;
							},1000)
			             }else if(msg.success == 0){
			            	 layer.msg("删除失败！");
			             }
				       }
				});
			}
		});
	}
	
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
    
    //提交表单
     form.on('submit(saveBuild)', function(data){
    	if(checkModification()){
    		//列表数据组装
    		listToString();
    		if(checkFullCom(1) && $("#buildListStr").val() !="" && 
    				$("#warehouseListString").val() !="" && $("#showHouseList").val() !=""){
    			$("#isFull").val("1");
    		}else{
    			$("#isFull").val("0");
    		}
            var loading; 
        	$.ajax({
    	       url:"<%=request.getContextPath()%>/museumHouseBuilding/save.do",
    	       data:$('#mesForm').serialize(),
    	       type:"POST",
    	       beforeSend: function () {
    	    	   loading = layer.load();
    	       },
    	       success:function(msg){
    	    	   layer.close(loading);  
    	    	   if(msg.success == 1){
    	    		   layer.msg("保存成功！");
                        setTimeout(function(){
    							window.location.href = window.location.href;
    						},1000)
                    }else if(msg.success == 0){
                    	layer.msg("保存失败！",{icon: 2});
                    }
    	       },
    	       error:function(msg){
    	    	   layer.close(loading);
    	    	   layer.msg("保存失败！",{icon: 2});
    	       }
    	   });
    	}else{
    		layer.msg("资料没有修改，无需提交！");
    	}
    });
});

function appendHtml(type){
	var htmlStr;
	if(type=="house"){
		htmlStr="<div class=\"layui-col-md12 house pt_10\">\n" +
        "                                       <div class=\"layui-input-inline layui-col-md1\">\n" +
        "                                            <a id=\"delete_btn\" style=\"padding-left:40px;\" onclick=\"delHouse(this)\" ><img src=\"<%=request.getContextPath() %>/back/images/delete.png\" style=\"padding-top:3px;\"></a>\n"+
        "                                        </div>\n" +
        "                                        <div class=\"layui-input-inline layui-col-md3\" style=\"padding-right:10px\">\n" +
        "                                            <input type=\"text\" lay-verify=\"required\" class=\"layui-input\"  name=\"houseName\" placeholder=\"馆设名称\">\n" +
        "                                        </div>\n" +
        "                                        <div class=\"layui-input-inline layui-col-md2\" style=\"padding-right:10px;\">\n" +
        "                                            <input type=\"text\" class=\"layui-input\" name=\"floorArea\"  placeholder=\"\/m*m\">\n" +
        "                                        </div>\n" +
        "                                        <div class=\"layui-input-inline layui-col-md3\" style=\"padding-right:10px;\">\n" +
        "                                            <select class=\"layui-col-md3\" name=\"level\" >\n"+
        "												<option value=\"\">请选择</option>\n"+
        "												<option value=\"1\" >非文物建筑</option>\n"+
		"												<option value=\"2\" >国家重点文物保护单位</option>\n"+
		"												<option value=\"3\" >省市级文物保护单位</option>\n"+
		"												<option value=\"4\" >区县级文物保护单位</option>\n"+
        "											</select>\n" +
        "                                        </div>\n" +
        "                                        <div class=\"layui-input-inline layui-col-md3\">" +
        "                                            <select class=\"layui-col-md3\" name=\"ownership\" >\n"+
		"									            <option value=\"\">请选择</option>\n"+
		"												<option value=\"1\" >本馆</option>\n"+
		"												<option value=\"2\" >租用</option>\n"+
        "											</select>\n" +
        "                                        </div>\n" +
        "                                    </div>";
	}
	if(type=="ware"){
		htmlStr ="<div class=\"layui-input-inline layui-col-md12 ware pt_10\">\n"+
		 "           <div class=\"layui-input-inline layui-col-md1\">\n"+
		 "              <a id=\"delete_btn\" style=\"padding-left:40px;\" onclick=\"delHouse(this)\" ><img src=\"<%=request.getContextPath() %>/back/images/delete.png\" style=\"padding-top:3px;\"></a>\n"+
		 "           </div>\n"+
		 "           <div class=\"layui-input-inline layui-col-md2\" style=\"padding-right:10px;\">\n"+
		 "               <input type=\"text\" class=\"layui-input\" lay-verify=\"required\" name=\"name\" >\n"+
		 "     	   </div>\n"+
		 "           <div class=\"layui-input-inline layui-col-md1\" style=\"padding-right:10px;\">\n"+
		 "                 <input type=\"text\" class=\"layui-input\" name=\"houseArea\" placeholder=\"/m*m\">\n"+
		 "           </div>\n"+
		 "           <div class=\"layui-input-inline layui-col-md2\" style=\"padding-right:10px;\">\n"+
		 "                  <select name=\"temperature\">\n"+
		 "                      <option value=\"\">请选择</option>\n"+
		"						  <option value=\"1\" >设施完善，设备齐全</option>\n"+
		"						  <option value=\"2\" >设备基本齐全，能控制温湿度</option>\n"+
		"						  <option value=\"3\" >有简单的温湿度控制设备</option>\n"+
		"						  <option value=\"4\" >没有温湿度控制设备</option>\n"+
		"                   </select>\n"+
		"             </div>\n"+
		"             <div class=\"layui-input-inline layui-col-md2\">\n"+
		"                  <select  name=\"fireFighting\">\n"+
		"					<option value=\"\">请选择</option>\n"+
		"					<option value=\"1\" >设施完善，设备齐全</option>\n"+
		"					<option value=\"2\" >基本完善、设备基本齐全</option>\n"+
		"					<option value=\"3\" >有简单的安防消防设施</option>\n"+
		"					<option value=\"4\" >没有安防消防设施</option>\n"+
		"                  </select>\n"+
		"              </div>\n"+
		"              <div class=\"layui-input-inline layui-col-md4\">\n"+
		"                 <div class=\"layui-form-item\" >\n"+
		"		                 <div class=\"layui-input-block\" style=\"margin-left: 30px\">\n"+
		"		                 	<input type=\"checkbox\" name=\"collectionNeeds\" title=\"满足藏品收藏需要\">\n"+
		"		                 	<input type=\"checkbox\" name=\"completeRack\" title=\"货架齐全\">\n"+
		"		                 	<input type=\"checkbox\" name=\"ventilationFacility\"  title=\"通风设施\">\n"+
		"		                 	<input type=\"checkbox\" name=\"guardAgainstTheft\"  title=\"防盗\">\n"+
		"		                 </div>\n"+
		"                </div>\n"+
		"                	<div class=\"layui-form-item\" >\n"+
		"		                 <div class=\"layui-input-block\" style=\"margin-left: 30px\">\n"+
		"		                 	<input type=\"checkbox\" name=\"airPollution\" title=\"防空气污染设施\">\n"+
		"		                 	<input type=\"checkbox\" name=\"lightProtection\"  title=\"防自然灾害\">\n"+
		"		                 	<input type=\"checkbox\" name=\"mildewResistance\" title=\"防霉变设施\">\n"+
		"		                 	<input type=\"checkbox\" name=\"insectControl\"  title=\"防虫\">\n"+
		"		                 </div>\n"+
		"                </div>\n"+
		"                	<div class=\"layui-form-item\" >\n"+
		"		                 <div class=\"layui-input-block\" style=\"margin-left: 30px\">\n"+
		"		                 	<input type=\"checkbox\" name=\"monitor\"  title=\"入侵报警系统\">\n"+
		"		                 	<input type=\"checkbox\" name=\"roomLighting\" title=\"照明设施合格\">\n"+
		"		                 	<input type=\"checkbox\" name=\"corrosionProtection\" title=\"防腐蚀设施\">\n"+
		"		                 	<input type=\"checkbox\" name=\"waterproof\"  title=\"防水\">\n"+
		"		                 </div>\n"+
		"                </div>\n"+
		"              </div>\n"+
		"         </div>";
	}
	if(type=="room"){
		htmlStr = " <div class=\"layui-input-inline layui-col-md12 room pt_10\">\n"+
			 "       <div class=\"layui-input-inline layui-col-md1\">\n"+
			 "          <a id=\"delete_btn\" style=\"padding-left:40px;\" onclick=\"delHouse(this)\" ><img src=\"<%=request.getContextPath() %>/back/images/delete.png\"  style=\"padding-top:3px;\"></a>\n"+
			 "       </div>\n"+
			 "       <div class=\"layui-input-inline layui-col-md1\" style=\"padding-right:10px;\"> \n"+
			 "           <input type=\"text\" class=\"layui-input\" lay-verify=\"required\" name=\"name\">\n"+
			 " 	   </div>\n"+
			 "       <div class=\"layui-input-inline layui-col-md1\" style=\"padding-right:10px;\">\n"+
			 "             <input type=\"text\" class=\"layui-input\" name=\"area\" placeholder=\"/m*m\">\n"+
			 "       </div>\n"+
			 "       <div class=\"layui-input-inline layui-col-md2\" style=\"padding-right:10px;\">\n"+
			 "              <select name=\"roomLighting\" >\n"+
			 "                  <option value=\"\">请选择</option>\n"+
			 "						  <option value=\"1\">完全符合</option>\n"+
			 "					  <option value=\"2\"  <c:if test="${'2' eq item.roomLighting}">selected</c:if>>基本符合</option>\n"+
			"					  <option value=\"3\"  <c:if test="${'3' eq item.roomLighting}">selected</c:if>>不符合</option>\n"+
			"               </select>\n"+
			"         </div>\n"+
			"         <div class=\"layui-input-inline layui-col-md2\" style=\"padding-right:10px;\">\n"+
			"              <select  name=\"collectionProtect\">\n"+
			"				<option value=\"\">请选择</option>\n"+
			"				<option value=\"1\">所有文物展柜均符合</option>\n"+
			"				<option value=\"2\" >珍贵文物展柜均符合</option>\n"+
			"				<option value=\"3\">少部分文物展柜符合</option>\n"+
			"				<option value=\"4\">不符合</option>\n"+
			"              </select>\n"+
			"          </div>\n"+
			"          <div class=\"layui-input-inline layui-col-md2\">\n"+
			"              <select  name=\"fireFighting\" >\n"+
			"				<option value=\"\">请选择</option>\n"+
			"				<option value=\"1\" >设施完善，设备齐全</option>\n"+
			"				<option value=\"2\" >基本完善、设备基本齐全</option>\n"+
			"				<option value=\"3\" >有简单的安防消防设施</option>\n"+
			"				<option value=\"4\" >没有安防消防设施</option>\n"+
			"              </select>\n"+
			"          </div>\n"+
			"          <div class=\"layui-input-inline layui-col-md3\">\n"+
			"             <div class=\"layui-form-item\" >\n"+
			"	                 <div class=\"layui-input-block\" style=\"margin-left: 30px\">\n"+
			"	                 	<input type=\"checkbox\" name=\"monitor\" title=\"入侵报警系统\">\n"+
			"	                 	<input type=\"checkbox\" name=\"guardAgainstTheft\"  title=\"防盗\">\n"+
			"	                 	<input type=\"checkbox\" name=\"firePrevention\"  title=\"防火\">\n"+
			"	                 </div>\n"+
			"            </div>\n"+
			"            <div class=\"layui-form-item\" >\n"+
			"	                 <div class=\"layui-input-block\" style=\"margin-left: 30px\">\n"+
			"	                 	<input type=\"checkbox\" name=\"lightProtection\"  title=\"防雷\">\n"+
			"	                 	<input type=\"checkbox\" name=\"shockproof\" title=\"防震\">\n"+
			"	                 	<input type=\"checkbox\" name=\"waterproof\" title=\"防水\">\n"+
			"	                 </div>\n"+
			"            </div>\n"+
			"     </div>"
	}
	return htmlStr;
}

function listToString(){
	var museumId=$("#museumId").val();
	var houseLen=$("#houseList").children().length;
	var houseArray = new Array();
	for(var i =0;i<houseLen;i++){
		var houseName=$("#houseList .house").eq(i).find("input[name='houseName']").val();
        var ids=$("#houseList .house").eq(i).attr("data")?$("#houseList .house").eq(i).attr("data"):"";
        var floorArea= $("#houseList .house").eq(i).find("input[name='floorArea']").val()||"";
        var level= $("#houseList .house").eq(i).find("select[name='level']").find("option:selected").attr('value')||"";
        var ownership= $("#houseList .house").eq(i).find("select[name='ownership']").find("option:selected").attr('value')||"";
        var strHouse = {"museumId":museumId,"houseName":houseName,"floorArea":floorArea,"level":level,"ownership":ownership,"id":ids};
        houseArray[i]=strHouse;
	}
	$("#buildListStr").val(JSON.stringify(houseArray));//馆舍信息
	
	var wareLen=$("#wareList").children().length;
	var wareArray = new Array();
	for(var i =0;i<wareLen;i++){
		var name=$("#wareList .ware").eq(i).find("input[name='name']").val();
        var id=$("#wareList .ware").eq(i).attr("data")?$("#wareList .ware").eq(i).attr("data"):"";
        var houseArea= $("#wareList .ware").eq(i).find("input[name='houseArea']").val()||"";
        var temperature= $("#wareList .ware").eq(i).find("select[name='temperature']").find("option:selected").attr('value')||"";
        var fireFighting= $("#wareList .ware").eq(i).find("select[name='fireFighting']").find("option:selected").attr('value')||"";
        var collectionNeeds= $("#wareList .ware").eq(i).find("input[type='checkbox'][name='collectionNeeds']").is(":checked")?"on":"";
        var completeRack= $("#wareList .ware").eq(i).find("input[type='checkbox'][name='completeRack']").is(":checked")?"on":"";
        var ventilationFacility= $("#wareList .ware").eq(i).find("input[type='checkbox'][name='ventilationFacility']").is(":checked")?"on":"";
        var guardAgainstTheft= $("#wareList .ware").eq(i).find("input[type='checkbox'][name='guardAgainstTheft']").is(":checked")?"on":"";
        var airPollution= $("#wareList .ware").eq(i).find("input[type='checkbox'][name='airPollution']").is(":checked")?"on":"";
        var lightProtection= $("#wareList .ware").eq(i).find("input[type='checkbox'][name='lightProtection']").is(":checked")?"on":"";
        var mildewResistance= $("#wareList .ware").eq(i).find("input[type='checkbox'][name='mildewResistance']").is(":checked")?"on":"";
        var insectControl= $("#wareList .ware").eq(i).find("input[type='checkbox'][name='insectControl']").is(":checked")?"on":"";
        var monitor= $("#wareList .ware").eq(i).find("input[type='checkbox'][name='monitor']").is(":checked")?"on":"";
        var roomLighting= $("#wareList .ware").eq(i).find("input[type='checkbox'][name='roomLighting']").is(":checked")?"on":"";
        var corrosionProtection= $("#wareList .ware").eq(i).find("input[type='checkbox'][name='corrosionProtection']").is(":checked")?"on":"";
        var waterproof= $("#wareList .ware").eq(i).find("input[type='checkbox'][name='waterproof']").is(":checked")?"on":"";
        var strWare = {"museumId":museumId,"name":name,"houseArea":houseArea,"temperature":temperature,"fireFighting":fireFighting,"id":id,
        		"collectionNeeds":collectionNeeds,"completeRack":completeRack,"ventilationFacility":ventilationFacility,
        		"guardAgainstTheft":guardAgainstTheft,"airPollution":airPollution,"lightProtection":lightProtection,
        		"mildewResistance":mildewResistance,"insectControl":insectControl,"monitor":monitor,
        		"roomLighting":roomLighting,"corrosionProtection":corrosionProtection,"waterproof":waterproof
        		};
        wareArray[i]=strWare;
	}
	$("#warehouseListString").val(JSON.stringify(wareArray));//库房
	
	var roomLen=$("#roomList").children().length;
	var roomArray = new Array();
	for(var i =0;i<wareLen;i++){
		var name=$("#roomList .room").eq(i).find("input[name='name']").val();
        var id=$("#roomList .room").eq(i).attr("data")?$("#roomList .room").eq(i).attr("data"):"";
        var area= $("#roomList .room").eq(i).find("input[name='area']").val()||"";
        var roomLighting= $("#roomList .room").eq(i).find("select[name='roomLighting']").find("option:selected").attr('value')||"";
        var collectionProtect= $("#roomList .room").eq(i).find("select[name='collectionProtect']").find("option:selected").attr('value')||"";
        var fireFighting= $("#roomList .room").eq(i).find("select[name='fireFighting']").find("option:selected").attr('value')||"";
        var monitor= $("#roomList .room").eq(i).find("input[type='checkbox'][name='monitor']").is(":checked")?"on":"";
        var guardAgainstTheft= $("#roomList .room").eq(i).find("input[type='checkbox'][name='guardAgainstTheft']").is(":checked")?"on":"";
        var firePrevention= $("#roomList .room").eq(i).find("input[type='checkbox'][name='firePrevention']").is(":checked")?"on":"";
        var lightProtection= $("#roomList .room").eq(i).find("input[type='checkbox'][name='lightProtection']").is(":checked")?"on":"";
        var shockproof= $("#roomList .room").eq(i).find("input[type='checkbox'][name='shockproof']").is(":checked")?"on":"";
        var waterproof= $("#roomList .room").eq(i).find("input[type='checkbox'][name='waterproof']").is(":checked")?"on":"";
        var strRoom = {"museumId":museumId,"name":name,"area":area,"roomLighting":roomLighting,"collectionProtect":collectionProtect,"id":id,
        		"fireFighting":fireFighting,"monitor":monitor,"guardAgainstTheft":guardAgainstTheft,"firePrevention":firePrevention,
        		"lightProtection":lightProtection,"shockproof":shockproof,"waterproof":waterproof};
        roomArray[i]=strRoom;
	}
	$("#showHouseList").val(JSON.stringify(roomArray));//展厅信息
}
</script>
</body>
</html>