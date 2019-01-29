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
 .layui-form-label{
 width:150px;
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
</style>
<title>基本信息</title>
</head>
<body class="childrenBody">
 <div>  
    <form action="" id="mesForm" name="mesForm" class="layui-form">
    	<input type="hidden" id="uploads" name="uploads" value="${uploads} ">
    	<input name="imageId" id="imageId" type="hidden" value="${result.imageId}">
		<input name="imageUrl" id="imageUrl" type="hidden" value="${result.imageUrl}">
    	<input type="hidden" id="geography" name="geography" value="">
		<input type="hidden" id="level" name="level" value="${level}"/>
		<input type ="hidden" name="id" id="id" value="${result.id}">
        <input type ="hidden" name="museumId" id="museumId" value="${museumId}">
        <input type ="hidden" name="isFull" id="isFull" value="">
		<div class="layui-row" style="padding-bottom:5px;">
			<div class="layui-col-md2 layui-col-md-offset10 pt_30">
				<span style="text-align:center;display:block;">
					<c:if test="${'1' eq level}">
						<c:if test="${empty result.id || result.id eq null}">
							<a id="btn_submit" type="button" class="layui-btn" lay-submit lay-filter="saveBase"> 提交</a>
							<a id="btn_edit" type="button" class="layui-btn hideBtn">编辑</a>
		                </c:if>
		                <c:if test="${not empty result.id && result.id ne null}">
							<a id="btn_edit" type="button" class="layui-btn">编辑</a>
							<a id="btn_submit" type="button" class="layui-btn hideBtn" lay-submit lay-filter="saveBase" style="margin-left:0px"> 提交</a>
		                </c:if>
	                </c:if>
	                <a id="btn_back" type="button" class="layui-btn">返回</a>
                </span>
    		</div>
		</div>
        <div class="layui-row">
            <div class="layui-col-md2">
                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp基本信息</a>
            </div>
        </div>
            <div class="layui-row" >
                <div class="layui-col-md4">
                    <label class="layui-form-label" style="width:180px;">博物馆名称：</label>
                    <div class="layui-input-inline layui-col-md5">
                        <input type="text" class="layui-input" name="museumName" id="museumName" value="${museumName}">
                    </div>
                </div>
                 <div class="layui-col-md4">
                    <label class="layui-form-label">博物馆类型：</label>
                    <div class="layui-input-inline layui-col-md6">
                        <select  name="funcType" class="typeOne" id="funcType">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq result.funcType}">selected</c:if>>综合地质类</option>
                            <option value="2" <c:if test="${'2' eq result.funcType}">selected</c:if>>考古遗址类</option>
                            <option value="3" <c:if test="${'3' eq result.funcType}">selected</c:if>>历史文化类</option>
                            <option value="4" <c:if test="${'4' eq result.funcType}">selected</c:if>>艺术类</option>
                            <option value="5" <c:if test="${'5' eq result.funcType}">selected</c:if>>自然科技类</option>
                            <option value="6" <c:if test="${'6' eq result.funcType}">selected</c:if>>其他类</option>
                        </select>
                    </div>
                </div>
                <div class="layui-col-md4">
                    <label class="layui-form-label">博物馆性质：</label>
                    <div class="layui-input-inline layui-col-md6">
                        <select  name="museumType" class="typeOne" id="museumType">
                            <option value="">请选择</option>
                           <option value="01" <c:if test="${'01' eq result.museumType}">selected</c:if>>文物</option>
                            <option value="02" <c:if test="${'02' eq result.museumType}">selected</c:if>>行业</option>
                            <option value="03" <c:if test="${'03' eq result.museumType}">selected</c:if>>非国有</option>
                        </select>
                    </div>
                </div>
            </div>

		   <div class="layui-row" >
				   <div class="layui-input-inline layui-col-md4">
		            <label class="layui-form-label" style="width:180px;">博物馆级别：</label>
		            <div class="layui-input-inline layui-col-md5">
			            <select name="certificationLevel" class="typeOne" id="identification">
			                <option value="">请选择</option>
			                <option value="01" <c:if test="${'01' eq result.certificationLevel}">selected</c:if>>一级</option>
			                <option value="02" <c:if test="${'02' eq result.certificationLevel}">selected</c:if>>二级</option>
			                <option value="03" <c:if test="${'03' eq result.certificationLevel}">selected</c:if>>三级</option>
			                <option value="04" <c:if test="${'04' eq result.certificationLevel}">selected</c:if>>未定级</option>
			            </select>
		            </div>
		        </div>
		        
		        <div class="layui-input-inline layui-col-md4">
		            <label class="layui-form-label">行政隶属关系：</label>
		            <div class="layui-input-inline layui-col-md6">
			            <select name="relationShip" class="typeOne" id="relationShip">
			                <option value="">请选择</option>
			                <option value="1" <c:if test="${'1' eq result.relationShip}">selected</c:if>>央属</option>
			                <option value="2" <c:if test="${'2' eq result.relationShip}">selected</c:if>>市属</option>
			                <option value="3" <c:if test="${'3' eq result.relationShip}">selected</c:if>>区</option>
			                <option value="4" <c:if test="${'4' eq result.relationShip}">selected</c:if>>街道</option>
			                <option value="5" <c:if test="${'5' eq result.relationShip}">selected</c:if>>乡镇</option>
			                <option value="6" <c:if test="${'6' eq result.relationShip}">selected</c:if>>村</option>
			            </select>
		            </div>
		        </div>
		        
		        <div class="layui-input-inline layui-col-md4">
		            <label class="layui-form-label" for="identification">上级主管单位：</label>
		            <div class="layui-input-inline layui-col-md6">
                        <input type="text" class="layui-input typeOne" name="parentOrgName" id="parentOrgName" value="${parentOrgName}">
                    </div>
		        </div>
		   </div>
		   
		    <div class="layui-row">
		    	<div class="layui-input-inline layui-col-md4">
		            <label class="layui-form-label" for="identification" style="width:180px;">基本运营经费：</label>
		            <div class="layui-input-inline layui-col-md5">
			            <select name="operatingExpenses" class="typeOne" id="operatingExpenses">
			                <option value="">请选择</option>
			                <option value="1" <c:if test="${'1' eq result.operatingExpenses}">selected</c:if>>财政拨款</option>
			                <option value="2" <c:if test="${'2' eq result.operatingExpenses}">selected</c:if>>项目经费</option>
			                <option value="3" <c:if test="${'3' eq result.operatingExpenses}">selected</c:if>>其他</option>
			            </select>
		            </div>
		        </div>
		        
		        <div class="layui-col-md4">
                <label class="layui-form-label" for="firstOpenDate">正式对社会开放时间：</label>
                <div class="layui-input-inline layui-col-md6" >
                <input value="${result.firstOpenDate}" class="layui-input typeOne" name="firstOpenDate" id="firstOpenDate"></input>
                </div>
            </div>
            <div class="layui-col-md4">
                <label class="layui-form-label" for="employ_depart">开馆时间：</label>
	            <div class="layui-input-inline layui-col-md6">
                       <input type="text" class="layui-input typeOne" name="staticCloseDay" id="staticCloseDay" value="${result.staticCloseDay}">
                </div>
             </div>
          </div>
          
          <div class="layui-row">
		    	<div class="layui-input-inline layui-col-md4">
		            <label class="layui-form-label" style="width:180px;">是否为爱国主义教育基地：</label>
		            <div class="layui-input-inline layui-col-md5">
			            <select name="loveCountry" id="loveCountry" class="typeOne">
			                <option value="">请选择</option>
			                <option value="1" <c:if test="${'1' eq result.loveCountry}">selected</c:if>>全国示范基地</option>
			                <option value="2" <c:if test="${'2' eq result.loveCountry}">selected</c:if>>省市级爱国主义教育基地</option>
			                <option value="3" <c:if test="${'3' eq result.loveCountry}">selected</c:if>>区县级爱国主义教育基地</option>
			                <option value="4" <c:if test="${'4' eq result.loveCountry}">selected</c:if>>非爱国主义教育基地</option>
			            </select>
		            </div>
		        </div>
		        <div class="layui-input-inline layui-col-md4">
		            <label class="layui-form-label">是否为A级旅游景区：</label>
		            <div class="layui-input-inline layui-col-md6">
			            <select name="scenicLevel" id="scenicLevel" class="typeOne">
			                <option value="">请选择</option>
			                <option value="1" <c:if test="${'1' eq result.scenicLevel}">selected</c:if>>5A</option>
			                <option value="2" <c:if test="${'2' eq result.scenicLevel}">selected</c:if>>4A</option>
			                <option value="3" <c:if test="${'3' eq result.scenicLevel}">selected</c:if>>3A</option>
			                <option value="4" <c:if test="${'4' eq result.scenicLevel}">selected</c:if>>不是</option>
			            </select>
		            </div>
		        </div>
            <div class="layui-input-inline layui-col-md4">
		            <label class="layui-form-label">是否为科普教育基地：</label>
		            <div class="layui-input-inline layui-col-md6">
			            <select name="educationBase" id="educationBase" class="typeOne">
			                <option value="">请选择</option>
			                <option value="1" <c:if test="${'1' eq result.educationBase}">selected</c:if>>全国科普教育基地</option>
			                <option value="2" <c:if test="${'2' eq result.educationBase}">selected</c:if>>北京市科普教育基地</option>
			                <option value="3" <c:if test="${'3' eq result.educationBase}">selected</c:if>>不是</option>
			            </select>
		            </div>
		        </div>
          </div>
          <div class="layui-row">
          		<div class="layui-input-inline layui-col-md6">
		            <label class="layui-form-label" style="width:auto !important">是否为“北京中小学生社会大课堂”资源单位：</label>
		            <div class="layui-input-inline" >
		                <input type="radio" name="resourceUnit" value="1"  title="是" <c:if test="${'1' eq result.resourceUnit}">checked</c:if>>
		                <input type="radio" name="resourceUnit" value="0"  title="否" <c:if test="${'0' eq result.resourceUnit}">checked</c:if>>
            		</div>
		        </div>
		    </div>
          <div class="layui-row">
          	 <div class="layui-input-inline layui-col-md7">
                <label class="layui-form-label">博物馆简介：</label>
                <div class="layui-input-inline layui-col-md8">
                	<textarea class="layui-textarea typeOne" id="museumDescription" lay-verify ="desLength" name="museumDescription" >${result.museumDescription}</textarea>
                </div>
            </div>
            
            <div class="layui-col-md5">
            	<label class="layui-form-label">博物馆图片：</label>
                <div class="layui-input-inline layui-col-md7" style="width:130px;height: 100px;margin-bottom: 10px;">
                	<c:if test="${result.pictureUrl eq '' || result.pictureUrl eq null}">
						<img id="upLogo" style="width:120px;height: 90px;" src="<%=request.getContextPath() %>/back/images/upLogo.png">
					</c:if>
					<c:if test="${not empty result.pictureUrl && result.pictureUrl ne '' && result.pictureUrl ne null}">
						<img id="upLogo" style="width:120px;height: 90px;"  src="${result.pictureUrl}">
					</c:if>
                </div>
            </div>
          </div>
          
          <div class="layui-row">
          	 <div class="layui-input-inline layui-col-md7">
                <label class="layui-form-label">发展规划：</label>
                <div class="layui-input-inline layui-col-md8">
                	<textarea class="layui-textarea typeOne" id="developPlan" name="developPlan" >${result.developPlan}</textarea>
                </div>
            </div>
            
            <div class="layui-input-inline layui-col-md5">
                <label class="layui-form-label">制度建设：</label>
                <div class="layui-input-inline layui-col-md7">
                	<textarea class="layui-textarea typeOne" id="ruleBuild" name="ruleBuild" >${result.ruleBuild}</textarea>
                </div>
            </div>
          </div>
          
          <div class="layui-row">
            <div class="layui-col-md2">
                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp联系信息</a>
            </div>
        </div>
            <div class="layui-row">
                <div class="layui-col-md8">
                    <label class="layui-form-label" style="width:90px;">地址：</label>
                 <div class="layui-input-inline layui-col-md10">
                 	<div class="layui-input-inline layui-col-md2" style="padding-right:5px">
                     <select class="typeOne" name="province" style="width:100px" readonly="readonly" disabled  placeholder="省">
                         <option value="1" selected>北京市</option>
                     </select>
                     </div>
                     <input type="hidden" name="city" id="city" value="2">
                     <!-- <div class="layui-input-inline layui-col-md2" style="padding-right:5px">
                        <select class="form-control typeOne"  name="city" readonly="readonly" disabled placeholder="市">
                            <option value="2" selected>北京市</option>
                        </select>
                    </div> -->
                    <div class="layui-input-inline layui-col-md2" style="padding-right:5px">
                        <select class="typeOne" id="mumAdress_village" name="area" >
                            <option value="">请选择</option>
                            <c:forEach items="${areaList}" var="u" varStatus="row">
                                <option value="${u.id}" <c:if test="${u.id eq result.area}">selected</c:if> >${u.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="layui-input-inline layui-col-md7">
	                		<input value="${result.detailAddress}"  type="text" class="layui-input typeOne" name="detailAddress" id="detailAddress" placeholder="输入详细地址">
	                </div>
                 </div>
                </div>
                
                <div class="layui-col-md4">
                    <label class="layui-form-label" >电话：</label>
                    <div class="layui-input-inline layui-col-md6">
                        <input value="${result.phone}" name="phone" lay-verify="phone" class="layui-input typeOne" id="phone" placeholder="输入电话号码">
                    </div>
                </div>
                
        </div>
		
        <div class="layui-row">
            <div class="layui-col-md4">
                <label class="layui-form-label" style="width:90px;">传真：</label>
                <div class="layui-input-inline layui-col-md6">
                <input value="${result.fax}" type="text" class="layui-input typeOne" name="fax" id="fax" placeholder="">
                </div>
            </div>
            <div class="layui-col-md4">
                <label class="layui-form-label" for="zipCode">邮编：</label>
                <div class="layui-input-inline layui-col-md6">
                <input value="${result.zipCode}" class="layui-input typeOne" type="number" name="zipCode" id="zipCode" lay-verify="zCode"></input>
                </div>
            </div>
            <div class="layui-col-md4">
                <label class="layui-form-label" for="mailbox">邮箱：</label>
                <div class="layui-input-inline layui-col-md6">
                <input value="${result.mailbox}" class="layui-input typeOne"  name="mailbox" type="email" id="mailbox"></input>
                </div>
            </div>
        </div>
        
        <div class="layui-row">
            <div class="layui-col-md4">
	                <label class="layui-form-label" style="width:90px;">网站地址：</label>
	                <div class="layui-input-inline layui-col-md6">
	                		<input value="${result.webUrl}" type="text" class="layui-input typeOne" name="webUrl" id="webUrl" placeholder="">
                    </div>
            	</div>
            <div class="layui-col-md4">
                <label class="layui-form-label" for="zipCode">微博：</label>
                <div class="layui-input-inline layui-col-md6">
                <input value="${result.weibo}" class="layui-input typeOne" type="text" name="weibo" id="weibo"></input>
                </div>
            </div>
            <div class="layui-col-md4">
                <label class="layui-form-label" for="mailbox">微信公众号：</label>
                <div class="layui-input-inline layui-col-md6">
                <input value="${result.wechat}" class="layui-input typeOne" name="wechat" type="text" id="wechat"></input>
                </div>
            </div>
        </div>
        
         <div class="layui-row">
          	 <div class="layui-input-inline layui-col-md4">
                <label class="layui-form-label" style="width:90px;">公交路线：</label>
                <div class="layui-input-inline layui-col-md6">
                	<textarea class="layui-textarea typeOne" id="busLine" name="busLine" >${result.busLine}</textarea>
                </div>
            </div>
            <div class="layui-input-inline layui-col-md4">
                <label class="layui-form-label">地铁路线：</label>
                <div class="layui-input-inline layui-col-md6">
                	<textarea class="layui-textarea typeOne" id="subwayLine" name="subwayLine" >${result.subwayLine}</textarea>
                </div>
            </div>
            <div class="layui-input-inline layui-col-md4">
                <label class="layui-form-label">非机动车停放区：</label>
                <div class="layui-input-inline layui-col-md6">
                	<textarea class="layui-textarea typeOne" id="parkArea" name="parkArea" >${result.parkArea}</textarea>
                </div>
            </div>
          </div>
         <div class="layui-row map">
         	<div class="layui-col-md12">
                <label class="layui-form-label" style="width:90px;">地图：</label>
                <div id="editWrap">
					<script id="editor" type="text/plain" name="geography1">${result.geography}</script>
				</div>
            </div>
         </div> 
<div class="layui-block">
    <div class="layui-input-inline">
       <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/register.png" alt="">&nbsp&nbsp注册信息</a>
    </div>
</div>

    <div class="layui-row">
        <div class="layui-col-md4">
            <label class="layui-form-label" for="registrationNumber">备案字号：</label>
            <div class="layui-input-inline layui-col-md6">
            <input value="${result.registrationNumber}" type="text" class="layui-input typeOne" name="registrationNumber" id="registrationNumber" placeholder="">
            </div>
        </div>
        <div class="layui-col-md4">
            <label class="layui-form-label" for="legalPerson">法定代表人：</label>
            <div class="layui-input-inline layui-col-md6">
            <input value="${result.legalPerson}" type="text" class="layui-input typeOne" name="legalPerson" id="legalPerson" placeholder="">
            </div>
        </div>
        <div class="layui-col-md4">
            <label class="layui-form-label" for="" style="width:auto !important">是否具有独立法人资格：</label>
            <div class="layui-input-inline layui-col-md6" >
                <input type="radio" name="isIndependentPerson" class="" id="isIndependentPerson1" value="1"  title="是" <c:if test="${'1' eq result.isIndependentPerson}">checked</c:if>>
                <input type="radio" name="isIndependentPerson" class="" id="isIndependentPerson2" value="0"  title="否" <c:if test="${'0' eq result.isIndependentPerson}">checked</c:if>>
            </div>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-input-inline layui-col-md4">
            <label class="layui-form-label" for="registrationOffice" >法人登记机关：</label>
            <div class="layui-input-inline layui-col-md6">
            <input value="${result.registrationOffice}" type="text" class="layui-input typeOne" name="registrationOffice" id="registrationOffice" placeholder="">
            </div>
        </div>
        <div class="layui-input-inline layui-col-md4">
            <label class="layui-form-label" for="registration">法人登记类型：</label>
            <div class="layui-input-inline layui-col-md6">
            <select class="col-sm-12 typeOne" name="legalPersonType" id="registration">
                <option value="">请选择</option>
                <option value="01" <c:if test="${'01' eq result.legalPersonType}">selected</c:if>>法人设立登记</option>
                <option value="02" <c:if test="${'02' eq result.legalPersonType}">selected</c:if>>法人变更登记</option>
                <option value="03" <c:if test="${'03' eq result.legalPersonType}">selected</c:if>>法人注销登记</option>
            </select>
            </div>
        </div>
        <div class="layui-input-inline layui-col-md4">
            <label class="layui-form-label" for="legalPersonNumber">法人登记号码：</label>
            <div class="layui-input-inline layui-col-md6">
            <input value="${result.legalPersonNumber}" type="text" lay-verify="numbers" class="layui-input typeOne" name="legalPersonNumber" id="legalPersonNumber" placeholder="">
            </div>
        </div>

    </div>
    <div class="layui-row" style="padding-bottom:10px;">
        <div class="layui-input-inline layui-col-md12">
            <label class="layui-form-label" for="identification">法人治理结构</label>
            <div class="layui-input-inline layui-col-md8" id="showFile">
            </div>
        </div>
    </div>
    <div class="layui-row">
    	<div class="layui-input-inline" style="padding-left:90px;">
    		<button type="button" class="layui-btn layui-btn-radius layui-btn-primary" id="fileBtn"><i class="layui-icon">&#xe67c;</i>上传法人治理结构文件</button>
    	<div class="layui-input-inline layui-col-md6">
    </div>
</form>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/museum/js/commonUtil.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/admin/lib/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/admin/lib/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery.base64.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/ueditor/lang/zh-cn/zh-cn.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">

//地图
var ue = UE.getEditor('editor',{
	toolbars: [['map']]
}); 

//附件
var uploads = [];

var oldUploads =[];

layui.use(['form','layer','upload','laydate'],function(){
	
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
       	laydate=layui.laydate,
        $ = layui.jquery;
    	
  		//执行一个laydate实例
	    laydate.render({
	        elem: '#firstOpenDate' //指定元素
	    });
    
	//刷新文件显示
	var uploadsJsonString = '${uploads }';
	if(uploadsJsonString != ''){
		console.log(uploadsJsonString);
		uploads = JSON.parse(uploadsJsonString);
		oldUploads = JSON.parse(uploadsJsonString);
		refreshFile();
		console.log(uploads);
	}
	
	//页面初始化
    var key = $("#id").val();
    var level = $("#level").val();
	if(level == "2" || (key != null && key != "")){
		$('input,select,textarea').attr('disabled',"disabled");	
		$("#showFile").find(".delete_btn").addClass("disabled");
		$("#fileBtn").attr('disabled',true);
		$("#upLogo").addClass("disabled");
		form.render('select');
	}
	initFileds();
  	//校验
    form.verify(
    {phone:[/(^$)|(^(\(\d{3,4}\)|(\d{3,4}-))?\d{7,8}$)|(^1[0-9]{10}$)/,'请输入正确电话号码'],
		zCode:[/(^$)|(^[1-9][0-9]{5}$)/,'请输入正确的邮编'],
	    desLength:function(value,item){
	    	var checkVal = value.trim();
	    	$(item).val(checkVal);
	    	if(checkVal.length>400){
	    		return '最多只能输入400个字符';
	    	}
	    },
	    numbers:[/(^$)|^[0-9]*$/,'请输入正确法人登记号码']
    }); 
    
    //提交
    form.on("submit(saveBase)",function(data){
    	var geography = UE.getEditor('editor').getContent();
    	var geographyEncode = encodeBase64(geography);
    	$("#geography").val(geographyEncode);
    	
    	if(checkModification() || JSON.stringify(oldUploads) != JSON.stringify(uploads)){
    		
    		//设置附件
        	if(uploads != undefined && uploads.length != 0){
        		var uploadJson = JSON.stringify(uploads);
            	console.log(uploadJson);
        		$("#uploads").val(uploadJson);
        	}
        	//全页面2个单选框所有传2
        	if(checkFullCom(2) && $("#uploads").val() !="" && $("#imageUrl").val()!="" ){
        		$("#isFull").val("1");
        	}else{
        		$("#isFull").val("0");
        	}
        	var loading; 
    		$.ajax({
    		       url:"<%=request.getContextPath()%>/museuminfo/museuminfoSave.do",
    		       data:$('#mesForm').serialize(),
    		       type:"POST",
    		       beforeSend: function () {
	    	    	   loading = layer.load();
	    	       },
    		       success:function(data){
    		    	   layer.close(loading);  
    		    	   if(data == 1){
    		    		   layer.msg("保存成功！");
    		    		   setTimeout(function(){
    		    			   window.location.href = window.location.href;
    					   },2000)
    	                }else if(data == 0){
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
       return false;
    });
    
    
	
	//返回校验
	$("#btn_back").click(function(){
		if(checkModification() || JSON.stringify(oldUploads) != JSON.stringify(uploads)){
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
	
	//修改
	$("#btn_edit").click(function(){
		$('input,select,textarea',$('form[name="mesForm"]')).removeAttr("disabled");
		$("#museumName").attr('disabled','disabled');
		$("#parentOrgName").attr('disabled','disabled');
		$("#btn_edit").addClass("hideBtn");
		$("#btn_submit").removeClass("hideBtn");
		$("#showFile").find(".delete_btn").removeClass("disabled");
		$("#fileBtn").attr('disabled',false);
		$("#upLogo").removeClass("disabled");
		form.render('select');
    });
	
	//上传附件
	var upload = layui.upload;
    var uploadInst = upload.render({
        elem: '#fileBtn' //绑定元素
        ,url: '<%=request.getContextPath() %>/attach/uploadLegal.do' 
        ,data:{
        	projectName:"museumInfo"
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
        }
        ,error: function(){
          //请求异常回调
        }
      });
    
	//刷新文件显示
	function refreshFile(){
		//清空showFile中的html
		$("#showFile").html("");
		//循环插入文件显示
		for (var i = 0; i < uploads.length; i++) {
			if(uploads[i].isjunk == 0 || uploads[i].isjunk == '0'){
				$("#showFile").append('<div class=\"layui-col-md12\"><a class="layui-btn layui-btn-radius layui-btn-primary" title="下载附件" onclick="downFile(\''+uploads[i].resultPath+'\',\''+uploads[i].realFileName+'\')"><i class="layui-icon">&#xe66e;</i>'+uploads[i].realFileName+'</a><a id="delete_btn" class="delete_btn" onclick="deleteFile(\''+uploads[i].id+'\',\''+uploads[i].realFileName+'\')"><img src="<%=request.getContextPath() %>/back/images/delete.png" ></a></div>');
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
    
    
    $("#upLogo").click(function(){
    	var index = layui.layer.open({
		      title : "裁剪图片",
		      type : 2,
		      content : "<%=request.getContextPath() %>/cropper/museum_crop.jsp",
			  area: ['70%', '600px'],
			  success : function(layero,index,data1){
			  		var body = layui.layer.getChildFrame('body', index);
				},
		      yse:function (index, layero) {
		          layer.close(index); //关闭弹层
		      }
		  });
    });
});

function downFile(path,fileName) {
	var projectName = '<%=request.getContextPath() %>';
	var url = projectName + '/attach/downFile.do?path='+path+'&fileName='+fileName;
	window.location.href = url;
}

//子页面获取当前页面的接收单位
function setTitleImg(absolurl, relativeurl){
	$("#upLogo").attr('src', absolurl); //图片链接（base64）
	$("#imageUrl").val(relativeurl); //相对路径
}


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

</script>
</body>
</html>