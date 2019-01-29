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
      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/lib/layui/css/layui.css" media="all"/>
          <link rel="stylesheet" href="<%=request.getContextPath() %>/back/css/public/public.css" media="all" />
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
 .hideBtn{
     display: none;
 }
 .layui-form-label{
 width:100px;
 }
 .childrenBody{
 	padding-top:10px;
 	padding-left:20px;
 	padding-right:20px;
 }
 .layui-inline{
 	margin-top:10px;
 	margin-bottom:10px;
 }
 .label-title{
 	color:#BE9A5B;
 	font-size:18px;
 	font-weight:700;
 }
 .layui-row{
 	padding-bottom:25px;
 }
 
 .map{
		height:350px;
}
#editWrap{
		border-radius: 4px;
		width: 715px;
		height: 350px;
		float:left;
}
#editor{
	margin:0;
}
#edui1{
	height: 350px;
	width:713px!important;
}
#edui1_bottombar{
	display:none!important;
}
#edui1_iframeholder{
	height:310px!important;
}
.disabled{
	 pointer-events: none;
	 cursor: default;
	 opacity: 0.6;
 }
 .preventEvent{
    pointer-events:none
}
.pt_30{
	padding-top:30px;
}
.labelStyle{
	width:100%;
	text-align: left;
	padding-left: 0px;
}
.rowStyle{
	margin-left: 43px;
}
</style>
<title>基本信息</title>
</head>
<body class="childrenBody">
 <div>  
    <form action="" id="mesForm" name="mesForm" class="layui-form">
    	<input type="hidden" id="geography" name="geography" value="">
		<input type="hidden" id="level" name="level" value="${level}"/>
		<input type="hidden" name="id" id="id" value="${culturalRelicInfo.id}">
        <input type="hidden" name="orgId" id="orgId" value="${orgId}">
        <input type="hidden" name="isFull" id="isFull" value="">
		<div class="layui-row">
			<div class="layui-col-md2 layui-col-md-offset10 pt_30">
				<span style="text-align:center;display:block;">
					<c:if test="${'1' eq level}">
						<c:if test="${empty culturalRelicInfo.id || culturalRelicInfo.id eq null}">
							<a id="btn_submit" type="button" class="layui-btn" lay-submit lay-filter="saveBase">保存</a>
							<a id="btn_edit" type="button" class="layui-btn hideBtn">编辑</a>
		                </c:if>
		                <c:if test="${not empty culturalRelicInfo.id && culturalRelicInfo.id ne null}">
							<a id="btn_edit" type="button" class="layui-btn">编辑</a>
							<a id="btn_submit" type="button" class="layui-btn hideBtn" lay-submit lay-filter="saveBase" style="margin-left:0px">保存</a>
		                </c:if>
	                </c:if>
	                <a id="btn_back" type="button" class="layui-btn">返回</a>
                </span>
    		</div>
		</div>
        <div class="layui-row">
            <div class="layui-col-md3">
                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp;&nbsp;单位基本信息</a>
            </div>
        </div>
        <div class="layui-row rowStyle">
            <div class="layui-col-md3">
            	<div>
                	<label class="layui-form-label labelStyle" ><span style="color:red">*</span>单位名称：</label>
            	</div>
                <div class="layui-input-inline layui-col-md8">
                    <input type="text" class="layui-input typeOne" name="cName" disabled="disabled" id="cName" value="${culturalRelicInfo.cName}" lay-verify="required">
                </div>
            </div>
            <div class="layui-col-md3">
            	<div>
                	<label class="layui-form-label labelStyle"><span style="color:red">*</span>单位性质：</label>
             	</div>
                <div class="layui-input-inline layui-col-md8">
                    <select  name="cProperties" class="typeOne" id="cProperties" lay-verify="required">
                        <option value="">请选择</option>
                        <option value="1" <c:if test="${'1' eq culturalRelicInfo.cProperties}">selected</c:if>>事业单位</option>
                        <option value="2" <c:if test="${'2' eq culturalRelicInfo.cProperties}">selected</c:if>>社会团体</option>
                        <option value="3" <c:if test="${'3' eq culturalRelicInfo.cProperties}">selected</c:if>>企业单位</option>
                        <option value="4" <c:if test="${'4' eq culturalRelicInfo.cProperties}">selected</c:if>>民办非企业</option>
                    </select>
                </div>
            </div>
           <%--  <div class="layui-col-md3">
            	<div>
                	<label class="layui-form-label labelStyle" >资质审批部门：</label>
            	</div>
                <div class="layui-input-inline layui-col-md8">
                    <input type="text" class="layui-input" name="aptitudeExamine" id="aptitudeExamine" value="${culturalRelicInfo.aptitudeExamine}">
                </div>
            </div> --%>
            <div class="layui-col-md3">
            	<div>
                	<label class="layui-form-label labelStyle" ><span style="color:red">*</span>获取当前资质年份：</label>
            	</div>
                <div class="layui-input-inline layui-col-md8">
                    <input type="text" class="layui-input typeOne"  name="currentAptitudeYear" id="currentAptitudeYear" value="${culturalRelicInfo.currentAptitudeYear}" lay-verify="required">
                </div>
            </div>
            <div class="layui-col-md3">
       			<div>
                	<label class="layui-form-label labelStyle" >资质证书编号：</label>
       			</div>
                <div class="layui-input-inline layui-col-md8">
                    <input type="text" class="layui-input typeOne" name="aptitudeNum" id="aptitudeNum" value="${culturalRelicInfo.aptitudeNum}">
                </div>
            </div>
        </div>
       	<div class="layui-row rowStyle" >
            <div class="layui-col-md3">
            	<div>
                	<label class="layui-form-label labelStyle" ><span style="color:red">*</span>法定代表人：</label>
            	</div>
                <div class="layui-input-inline layui-col-md8">
                    <input type="text" class="layui-input typeOne" name="legalRepresentative" id="legalRepresentative" value="${culturalRelicInfo.legalRepresentative}" lay-verify="required">
                </div>
            </div>
            <div class="layui-col-md3">
            	<div>
                	<label class="layui-form-label labelStyle" >联系人：</label>
            	</div>
                <div class="layui-input-inline layui-col-md8">
                    <input type="text" class="layui-input typeOne" name="contactsName" id="contactsName" value="${culturalRelicInfo.contactsName}">
                </div>
            </div>
            <div class="layui-col-md3">
            	<div>
                	<label class="layui-form-label labelStyle" ><span style="color:red">*</span>联系人电话：</label>
            	</div>
                <div class="layui-input-inline layui-col-md8">
                    <input type="text" class="layui-input typeOne" name="contactsPhone" lay-verify="required|phone" id="contactsPhone" value="${culturalRelicInfo.contactsPhone}">
                </div>
            </div>
            <div class="layui-col-md3">
       			<div>
                	<label class="layui-form-label labelStyle" >传真：</label>
       			</div>
                <div class="layui-input-inline layui-col-md8">
                    <input type="text" class="layui-input typeOne" name="facsimile" id="facsimile" value="${culturalRelicInfo.facsimile}">
                </div>
            </div>
       	</div>
       	<div class="layui-row rowStyle" >
            <div class="layui-col-md3">
            	<div>
                	<label class="layui-form-label labelStyle" >电子邮箱：</label>
            	</div>
                <div class="layui-input-inline layui-col-md8">
                    <input type="text" class="layui-input typeOne" name="email" id="email" lay-verify="email" value="${culturalRelicInfo.email}">
                </div>
            </div>
            <div class="layui-col-md3">
            	<div>
                	<label class="layui-form-label labelStyle" >邮编：</label>
            	</div>
                <div class="layui-input-inline layui-col-md8">
                    <input type="text" class="layui-input typeOne" name="postalcode" lay-verify="zCode" id="postalcode" value="${culturalRelicInfo.postalcode}">
                </div>
            </div>
            <div class="layui-col-md3">
            	<div>
                	<label class="layui-form-label labelStyle" >单位通信地址：</label>
            	</div>
                <div class="layui-input-inline layui-col-md8">
                    <input type="text" class="layui-input typeOne" name="cAddress" id="cAddress" value="${culturalRelicInfo.cAddress}">
                </div>
            </div>
            <div class="layui-input-inline layui-col-md3">
	   			<div>
		            <label class="layui-form-label labelStyle" >上级主管单位：</label>
	   			</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" name="cManagement" id="cManagement" value="${culturalRelicInfo.cManagement}">
                   </div>
	        </div>
       	</div>
	   	<div class="layui-row rowStyle" >
	   		
	        <div class="layui-input-inline layui-col-md6">
	        	<div>
		            <label class="layui-form-label labelStyle">资质证书核定的业务范围：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md6">
	           		 <input id="ratifiedBusinessRange" name="ratifiedBusinessRange" type="hidden" value=${personDetailInfo.ratifiedBusinessRange }>		
					<select multiple="multiple" id="repairSpecialty1" lay-filter="repairSpecialty1">
						<c:forEach items="${collectionCategoryList}" var="cate">
							<option value="${cate.id }" <c:if test="${cate.checked == 1 }">selected</c:if> >${cate.name }</option>
						</c:forEach>
			      	</select>
                </div>
	        </div>
	       <%--  <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">已承揽项目涉及的业务范围：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
		            <select name="existBusinessRange" class="typeOne" id="existBusinessRange">
		                <option value="">请选择</option>
		                <option value="1" <c:if test="${'1' eq culturalRelicInfo.existBusinessRange}">selected</c:if>>方案设计</option>
		                <option value="2" <c:if test="${'2' eq culturalRelicInfo.existBusinessRange}">selected</c:if>>保护修复</option>
		            </select>
	            </div>
	        </div> --%>
	   	</div>
	   	<%-- <div class="layui-row rowStyle">
	   		<div class="layui-input-inline layui-col-md3">
	   			<div>
		            <label class="layui-form-label labelStyle" >复资质证书核定的业务范围是否发生过变更：</label>
	   			</div>
	            <div class="layui-input-inline" >
	                <input type="radio" name="businessRangeIschange" value="1"  title="是" <c:if test="${'1' eq culturalRelicInfo.businessRangeIschange}">checked</c:if>>
	                <input type="radio" name="businessRangeIschange" value="0"  title="否" <c:if test="${'0' eq culturalRelicInfo.businessRangeIschange}">checked</c:if>>
           		</div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">变更年份：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" name="changeYear" id="changeYear" value="${culturalRelicInfo.changeYear}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">原业务范围：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" name="oldBusinessRange" id="oldBusinessRange" value="${culturalRelicInfo.oldBusinessRange}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">新增业务范围：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" name="newBusinessRange" id="newBusinessRange" value="${culturalRelicInfo.newBusinessRange}">
                   </div>
	        </div>
	   	</div> --%>
	   	<div class="layui-row">
	   		<div class="layui-col-md3">
               	<a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp;&nbsp;修复工作场所基本情况</a>
           	</div>
	   	</div>
	   	<div class="layui-row rowStyle">
	   		<div class="layui-input-inline layui-col-md3">
	   			<div>
		            <label class="layui-form-label labelStyle">办公室（数量/间）：</label>
	   			</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="number" name="officeNumber" id="officeNumber" value="${culturalRelicInfo.officeNumber}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">办公室（面积/平米）：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="num" name="officeArea" id="officeArea" value="${culturalRelicInfo.officeArea}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">仪器分析室（数量/间）：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="number" name="analysisLabNumber" id="analysisLabNumber" value="${culturalRelicInfo.analysisLabNumber}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">仪器分析室（面积/平米）：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="num" name="analysisLabArea" id="analysisLabArea" value="${culturalRelicInfo.analysisLabArea}">
                   </div>
	        </div>
	   	</div>
	   	<div class="layui-row rowStyle">
	   		<div class="layui-input-inline layui-col-md3">
	   			<div>
		            <label class="layui-form-label labelStyle">样品制备及前处理室（数量/间）：</label>
	   			</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="number" name="pretreatmentRoom" id="pretreatmentRoom" value="${culturalRelicInfo.pretreatmentRoom}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">样品制备及前处理室（面积/平米）：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="num" name="pretreatmentRoomArea" id="pretreatmentRoomArea" value="${culturalRelicInfo.pretreatmentRoomArea}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">化学实验室（数量/间）：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="number" name="chemicalLabNumber" id="chemicalLabNumber" value="${culturalRelicInfo.chemicalLabNumber}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">化学实验室（面积/平米）：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="num" name="chemicalLabArea" id="chemicalLabArea" value="${culturalRelicInfo.chemicalLabArea}">
                   </div>
	        </div>
	   	</div>
	   	<div class="layui-row rowStyle">
	   		<div class="layui-input-inline layui-col-md3">
	   			<div>
		            <label class="layui-form-label labelStyle">文物保护修复室面积（数量/间）：</label>
	   			</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="number" name="culturalRelicsNumber" id="culturalRelicsNumber" value="${culturalRelicInfo.culturalRelicsNumber}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">文物保护修复室面积（面积/平米）：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="num" name="culturalRelicsArea" id="culturalRelicsArea" value="${culturalRelicInfo.culturalRelicsArea}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">化学药品库（数量/间）：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="number" name="chemicalStoreNumber" id="chemicalStoreNumber" value="${culturalRelicInfo.chemicalStoreNumber}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">化学药品库（面积/平米）：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="num" name="chemicalStoreArea" id="chemicalStoreArea" value="${culturalRelicInfo.chemicalStoreArea}">
                   </div>
	        </div>
	   	</div>
	   	<div class="layui-row rowStyle">
	   		<div class="layui-input-inline layui-col-md3">
	   			<div>
		            <label class="layui-form-label labelStyle">修复工作临时库房面积（数量/间）：</label>
	   			</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="number" name="repairStorageNumber" id="repairStorageNumber" value="${culturalRelicInfo.repairStorageNumber}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">修复工作临时库房面积（面积/平米）：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="num" name="repairStorageArea" id="repairStorageArea" value="${culturalRelicInfo.repairStorageArea}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">库房（数量/间）：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="number" name="storehouseNumber" id="storehouseNumber" value="${culturalRelicInfo.storehouseNumber}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">库房（面积/平米）：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="num" name="storehouseArea" id="storehouseArea" value="${culturalRelicInfo.storehouseArea}">
                   </div>
	        </div>
	   	</div>
	   	<div class="layui-row rowStyle">
	   		<div class="layui-input-inline layui-col-md3">
	   			<div>
		            <label class="layui-form-label labelStyle">照相绘图室（数量/间）：</label>
	   			</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="number" name="drawingRoomNumber" id="drawingRoomNumber" value="${culturalRelicInfo.drawingRoomNumber}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">照相绘图室（面积/平米）：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="num" name="drawingRoomArea" id="drawingRoomArea" value="${culturalRelicInfo.drawingRoomArea}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	   			<div>
		            <label class="layui-form-label labelStyle">修复工作场所地址：</label>
	   			</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" name="repairWorkplaceAddress" id="repairWorkplaceAddress" value="${culturalRelicInfo.repairWorkplaceAddress}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">修复工作场所面积：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="num" name="repairWorkplaceArea" id="repairWorkplaceArea" value="${culturalRelicInfo.repairWorkplaceArea}">
                   </div>
	        </div>
	   	</div>
	   	<div class="layui-row rowStyle">
	   		<div class="layui-input-inline">
	   			<div>
		            <label class="layui-form-label labelStyle" >修复工作场所合和技术设备是否符合《可移动文物保护修复室规范化建设与仪器装备基本要求》（GB/T30238-2013）：</label>
	   			</div>
	            <div class="layui-input-inline" >
	                <input type="radio" name="conformWorkplaceEquipment" value="1"  title="是" <c:if test="${'1' eq culturalRelicInfo.conformWorkplaceEquipment}">checked</c:if>>
	                <input type="radio" name="conformWorkplaceEquipment" value="0"  title="否" <c:if test="${'0' eq culturalRelicInfo.conformWorkplaceEquipment}">checked</c:if>>
           		</div>
	        </div>
	   	</div>
	   	<div class="layui-row rowStyle">
	   		<div class="layui-input-inline">
	   			<div>
		            <label class="layui-form-label labelStyle" >修复工作场所是否符合《文物系统博物馆风险等级和安全防护级别的规定（GA27-2002）》：</label>
	   			</div>
	            <div class="layui-input-inline" >
	                <input type="radio" name="conformWorkplace" value="1"  title="是" <c:if test="${'1' eq culturalRelicInfo.conformWorkplace}">checked</c:if>>
	                <input type="radio" name="conformWorkplace" value="0"  title="否" <c:if test="${'0' eq culturalRelicInfo.conformWorkplace}">checked</c:if>>
           		</div>
	        </div>
	   	</div>
	   	<%-- <div class="layui-row rowStyle">
	   		<div class="layui-input-inline layui-col-md4">
	   			<div>
		            <label class="layui-form-label labelStyle" >修复室是否有温、湿度调节设施：</label>
	   			</div>
	            <div class="layui-input-inline" >
	                <input type="radio" name="existHumitureAdjust" value="1"  title="是" <c:if test="${'1' eq culturalRelicInfo.existHumitureAdjust}">checked</c:if>>
	                <input type="radio" name="existHumitureAdjust" value="0"  title="否" <c:if test="${'0' eq culturalRelicInfo.existHumitureAdjust}">checked</c:if>>
           		</div>
	        </div>
	        <div class="layui-input-inline layui-col-md4">
	   			<div>
		            <label class="layui-form-label labelStyle" >修复室是否有废气、污水处理排放设施和污物处理措施：</label>
	   			</div>
	            <div class="layui-input-inline" >
	                <input type="radio" name="existSewerage" value="1"  title="是" <c:if test="${'1' eq culturalRelicInfo.existSewerage}">checked</c:if>>
	                <input type="radio" name="existSewerage" value="0"  title="否" <c:if test="${'0' eq culturalRelicInfo.existSewerage}">checked</c:if>>
           		</div>
	        </div>
	   	</div>
	   	<div class="layui-row rowStyle">
	   		<div class="layui-input-inline layui-col-md4">
	   			<div>
		            <label class="layui-form-label labelStyle" >是否为国家文物局重点科研基地：</label>
	   			</div>
	            <div class="layui-input-inline" >
	                <input type="radio" name="existScientificBase" value="1"  title="是" <c:if test="${'1' eq culturalRelicInfo.existScientificBase}">checked</c:if>>
	                <input type="radio" name="existScientificBase" value="0"  title="否" <c:if test="${'0' eq culturalRelicInfo.existScientificBase}">checked</c:if>>
           		</div>
	        </div>
	        <div class="layui-input-inline layui-col-md4">
	   			<div>
		            <label class="layui-form-label labelStyle" >是否为国家文物局重点科研基地工作站：</label>
	   			</div>
	            <div class="layui-input-inline" >
	                <input type="radio" name="existScientificWorkstation" value="1"  title="是" <c:if test="${'1' eq culturalRelicInfo.existScientificWorkstation}">checked</c:if>>
	                <input type="radio" name="existScientificWorkstation" value="0"  title="否" <c:if test="${'0' eq culturalRelicInfo.existScientificWorkstation}">checked</c:if>>
           		</div>
	        </div>
	   	</div> --%>
	   	<div class="layui-row">
	   		<div class="layui-col-md3">
               	<a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp;&nbsp;修复专业技术人员基本情况</a>
           	</div>
	   	</div>
	   	<div class="layui-row rowStyle">
	   		<div class="layui-input-inline layui-col-md3">
	   			<div>
		            <label class="layui-form-label labelStyle">在编人员：</label>
	   			</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="num" name="permanentStaff" id="permanentStaff" value="${culturalRelicInfo.permanentStaff}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">聘用人员：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="num" name="employedStaff" id="employedStaff" value="${culturalRelicInfo.employedStaff}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">高级职称：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="num" name="seniorStaff" id="seniorStaff" value="${culturalRelicInfo.seniorStaff}">
                   </div>
	        </div>
	        <div class="layui-input-inline layui-col-md3">
	        	<div>
		            <label class="layui-form-label labelStyle">中级职称：</label>
	        	</div>
	            <div class="layui-input-inline layui-col-md8">
                       <input type="text" class="layui-input typeOne" lay-verify="num" name="professionalStaff" id="professionalStaff" value="${culturalRelicInfo.professionalStaff}">
                   </div>
	        </div>
	   	</div>
	</form>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/museum/js/commonUtil.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery.base64.js"></script>

<script type="text/javascript">
$(function(){
	var pathName=window.document.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
	layui.config({
		base: projectName + '/js/',
	})
	
	layui.use(['form','layer','upload','laydate','multiSelect'],function(){
	
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
       	laydate=layui.laydate,
       	multiSelect = layui.multiSelect,
        $ = layui.jquery;
    	
    form.verify({ 
    	num:[/^$|^\d{1,8}(\.\d{1,2})?$/,'请输入1-8位的数字，小数点后最多2位']
   		,phone:[/^(1(3|5|8)\d{9})?$/,'请输入正确电话号码']
    	/* ,phone:[/(^$)|(^(\(\d{3,4}\)|(\d{3,4}-))?\d{7,8}$)/,'请输入正确电话号码'] */
    	,zCode:[/(^$)|(^[1-9][0-9]{5}$)/,'请输入正确的邮编']
    	,email:[/(^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+)|(^$)/,'请输入正确的邮箱']
    });
    
    
	    laydate.render({
	        elem: '#currentAptitudeYear', //指定元素
	        type:'year'
	    });
	    laydate.render({
	        elem: '#changeYear', //指定元素
	        type:'year'
	    });
    
	//页面初始化
    var key = $("#id").val();
    var level = $("#level").val();
	if(level == "2" || (key != null && key != "")){
 		$('input,textarea').attr('disabled',"disabled");
 		$("#cProperties").attr('disabled',"disabled");
 		$("#repairSpecialty1").attr('disabled',"disabled");
		form.render('radio');
		multiSelect.render();
	}
 	initFileds();
    
	form.on('select(repairSpecialty1)',function(){
			var vals = getMultiValue();
			var str = vals.join(',');
			$("#ratifiedBusinessRange").val(str);
    })
		
    //获取多选下拉框的值
    function getMultiValue(){
    	var vals = [];
    	$('.layui-form-checked').each(function() {
			vals.push($(this).parent().attr("lay-value"));
		})
		return vals;
    }
    
    //提交
    form.on("submit(saveBase)",function(data){
    	
    	
    	if(checkModification()){
        	//全页面2个单选框所有传2
        	if(checkFullCom(2)){
        		$("#isFull").val("1");
        	}else{
        		$("#isFull").val("0");
        	}
        	var loading; 
    		$.ajax({
    		       url:"<%=request.getContextPath()%>/relicsBureau/relicsBureauSave.do",
    		       data:$('#mesForm').serialize(),
    		       type:"POST",
    		       beforeSend: function () {
    		    	   
	    	       },
    		       success:function(data){
   		    		   layer.msg("保存成功！");
    		    	   if(data.success == 1){
    		    		   setTimeout(function(){
    		    			   window.location.href = window.location.href;
    					   },1000)
    	                }else if(data.success == 0){
    	                    layer.msg("保存失败！",{icon:2});
    	                }
    		       },
	    	       error:function(msg){
	    	    	   layer.msg("保存失败！",{icon:2});
	    	       }
    		 });
    	}else{
    		layer.msg("资料没有修改，无需提交！");
    	}
       return false;
    });
    
    
	
	//返回校验
	$("#btn_back").click(function(){
		if(checkModification()){
			layer.confirm('您修改的信息尚未保存，确定要离开吗？', {  
		        btn: ['确定','取消'] //按钮
		    }, function(index){ 
		    	layer.close(index);  //关闭弹出层
		        //点击确定之后需要执行的函数
		        var orgId = $("#orgId").val();
		        window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+orgId;
		    }, function(index){
		        layer.close(index);  //关闭弹出层
		    });
		}else{
			var orgId = $("#orgId").val();
	        window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+orgId;
		}
    });
	
	//修改
	$("#btn_edit").click(function(){
		$('input,textarea',$('form[name="mesForm"]')).removeAttr("disabled");
		$("#repairSpecialty1").removeAttr('disabled');
		$("#cProperties").removeAttr("disabled");
		$("#cName").attr('disabled','disabled');
		$("#parentOrgName").attr('disabled','disabled');
		$("#btn_edit").addClass("hideBtn");
		$("#btn_submit").removeClass("hideBtn");
		form.render('radio');
		multiSelect.render();
    });
    
    
    function encodeBase64(mingwen,times){    
        var code="";    
        var num=1;    
        if(typeof times=='undefined'||times==null||times==""){    
           num=1;    
        }else{    
           var vt=times+"";    
           num=parseInt(vt);    
        }    
        if(typeof mingwen=='undefined'||mingwen==null||mingwen==""){    
        }else{    
            $.base64.utf8encode = true;    
            code=mingwen;    
            for(var i=0;i<num;i++){    
               code=$.base64.btoa(code);    
            }    
        }    
        return code;    
    }; 
    
});


/**
 * 电话号码
 * @param money
 * @returns {*}
 */
function validatePhone(phone) {
    var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
    if (reg.test(phone)) {
        return "Y";
    }
    return "请输入正确的金额,且最多两位小数!";
}
})



</script>
</body>
</html>