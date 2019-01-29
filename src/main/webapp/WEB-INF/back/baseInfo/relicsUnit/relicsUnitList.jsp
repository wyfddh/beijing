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
.leftLabel{
    text-align:left!important;
    margin-left:-15px!important;
    width:200px;
}
</style>
<title>单位基本信息</title>
</head>
<body class="childrenBody">
 <div>  
    <form action="" id="mesForm" name="mesForm" class="layui-form">
        <input type="hidden" id="level" name="level" value="${level}"/>
        <input type ="hidden" name="id" id="id" value="${result.id}">
        <input type ="hidden" name="orgId" id="relicsUnitId" value="${relicsUnitId}">
        <input type ="hidden" name="isFull" id="isFull" value="">
        <div class="layui-row">
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
                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp单位信息</a>
            </div>
        </div>
            <div class="layui-row" >
                <div class="layui-col-md2">
                    <label class="layui-form-label leftLabel" >单位名称：</label>
                    <div class="layui-input-inline layui-col-md8">
                        <input type="text" class="layui-input" lay-verify="required" name="cName" id="cName" value="${relicsUnitName}">
                    </div>
                </div>
                <div class="layui-col-md1">
                </div>
                <div class="layui-col-md2">
                    <label class="layui-form-label leftLabel" >组织机构代码：</label>
                    <div class="layui-input-inline layui-col-md8">
                        <input type="text" class="layui-input" name="orgCode" id="orgCode" value="${result.orgCode}">
                    </div>
                </div>
                 <div class="layui-col-md1">
                </div>
                <div class="layui-col-md2">
                    <label class="layui-form-label leftLabel" >上级主管机构：</label>
                    <div class="layui-input-inline layui-col-md8">
                        <input type="text" class="layui-input" name="orgManager" id="orgManager" value="${result.orgManager}">
                    </div>
                </div>
                 <div class="layui-col-md1">
                </div>
                <div class="layui-col-md2">
                    <label class="layui-form-label leftLabel">隶属关系：</label>
                    <div class="layui-input-inline layui-col-md8">
                        <select  name="orgRelation" class="typeOne" id="orgRelation">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq result.orgRelation}">selected</c:if>>其他</option>
                            <option value="2" <c:if test="${'2' eq result.orgRelation}">selected</c:if>>县区属</option>
                            <option value="3" <c:if test="${'3' eq result.orgRelation}">selected</c:if>>中央属</option>
                            <option value="4" <c:if test="${'4' eq result.orgRelation}">selected</c:if>>地市属</option>
                            <option value="5" <c:if test="${'5' eq result.orgRelation}">selected</c:if>>省属</option>
                            <option value="6" <c:if test="${'6' eq result.orgRelation}">selected</c:if>>乡镇街道属</option>
                        </select>
                    </div>
                </div>
                 <div class="layui-col-md1">
                </div>
            </div>

           <div class="layui-row" >
                   <div class="layui-input-inline layui-col-md2">
                    <label class="layui-form-label leftLabel">所属行业、系统：</label>
                    <div class="layui-input-inline layui-col-md8">
                        <select name="industry" class="typeOne" id="industry">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq result.industry}">selected</c:if>>文化文物、体育和娱乐业</option>
                            <option value="2" <c:if test="${'2' eq result.industry}">selected</c:if>>教育</option>
                            <option value="3" <c:if test="${'3' eq result.industry}">selected</c:if>>农、林、牧、渔业</option>
                            <option value="4" <c:if test="${'4' eq result.industry}">selected</c:if>>批发和零售业</option>
                            <option value="5" <c:if test="${'5' eq result.industry}">selected</c:if>>公共管理和社会组织</option>
                            <option value="6" <c:if test="${'6' eq result.industry}">selected</c:if>>卫生、社会保障和社会福利业</option>
                            <option value="7" <c:if test="${'7' eq result.industry}">selected</c:if>>制造业</option>
                            <option value="8" <c:if test="${'8' eq result.industry}">selected</c:if>>科学研究、技术服务和地质勘查业</option>
                            <option value="9" <c:if test="${'9' eq result.industry}">selected</c:if>>交通运输、仓储和邮政业</option>
                            <option value="10" <c:if test="${'10' eq result.industry}">selected</c:if>>住宿和餐饮业</option>
                            <option value="11" <c:if test="${'11' eq result.industry}">selected</c:if>>水利、环境和公共设施管理业</option>
                            <option value="12" <c:if test="${'12' eq result.industry}">selected</c:if>>信息传输、计算机服务和软件业</option>
                            <option value="13" <c:if test="${'13' eq result.industry}">selected</c:if>>金融业</option>
                            <option value="14" <c:if test="${'14' eq result.industry}">selected</c:if>>电力、燃气及水的生产和供应业</option>
                        </select>
                    </div>
                </div>
                 <div class="layui-col-md1">
                </div>
                <div class="layui-input-inline layui-col-md2">
                    <label class="layui-form-label leftLabel">单位性质：</label>
                    <div class="layui-input-inline layui-col-md8">
                        <select name="orgProperty" class="typeOne" id="orgProperty">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq result.orgProperty}">selected</c:if>>事业单位</option>
                            <option value="2" <c:if test="${'2' eq result.orgProperty}">selected</c:if>>国有企业</option>
                            <option value="3" <c:if test="${'3' eq result.orgProperty}">selected</c:if>>国家机关</option>
                            <option value="4" <c:if test="${'4' eq result.orgProperty}">selected</c:if>>其他</option>
                        </select>
                    </div>
                </div>
                 <div class="layui-col-md1">
                </div>
                <div class="layui-input-inline layui-col-md2">
                    <label class="layui-form-label leftLabel">单位类型：</label>
                    <div class="layui-input-inline layui-col-md8">
                        <select name="orgType" class="typeOne" id="orgType">
                            <option value="">请选择</option>
                            <option value="0" <c:if test="${'0' eq result.orgType}">selected</c:if>>图书馆</option>
                            <option value="1" <c:if test="${'1' eq result.orgType}">selected</c:if>>博物馆、纪念馆</option>
                            <option value="2" <c:if test="${'2' eq result.orgType}">selected</c:if>>档案馆</option>
                            <option value="3" <c:if test="${'3' eq result.orgType}">selected</c:if>>美术馆</option>
                            <option value="4" <c:if test="${'4' eq result.orgType}">selected</c:if>>其他</option>
                        </select>
                    </div>
                </div>
                 <div class="layui-col-md1">
                </div>
                <div class="layui-input-inline layui-col-md2">
                    <label class="layui-form-label leftLabel">是否属于文物系统：</label>
                    <div class="layui-input-inline layui-col-md8">
                        <input type="radio" name="isCulturalRelicSystem" value="0" title="否" <c:if test="${'0' eq result.isCulturalRelicSystem}">checked</c:if>>
                        <input type="radio" name="isCulturalRelicSystem" value="1" title="是" <c:if test="${'1' eq result.isCulturalRelicSystem}">checked</c:if>>
                    </div>
                </div>
                 <div class="layui-col-md1">
                </div>
           </div>
           
            <div class="layui-row">
                <div class="layui-col-md2">
	                <label class="layui-form-label leftLabel" for="employ_depart">通讯地址：</label>
	                <div class="layui-input-inline layui-col-md8">
	                       <input type="text" class="layui-input typeOne" name="address" id="address" value="${result.address}">
	                </div>
	             </div>
	              <div class="layui-col-md1">
                </div>
	             <div class="layui-col-md2">
                    <label class="layui-form-label leftLabel" for="employ_depart">邮政编码：</label>
                    <div class="layui-input-inline layui-col-md8">
                           <input type="text" class="layui-input typeOne" lay-verify="zCode"  name="postalcode" id="postalcode" value="${result.postalcode}">
                    </div>
                 </div>
                  <div class="layui-col-md1">
                </div>
                 <div class="layui-col-md1">
                    <label class="layui-form-label leftLabel" for="employ_depart">联系电话：</label>
                    <div class="layui-input-inline layui-col-md8">
                           <input type="text" class="layui-input typeOne" name="orgPhone" id="orgPhone" value="${result.orgPhone}">
                    </div>
                 </div>
                  <div class="layui-col-md1">
                </div>
                  <div class="layui-col-md1">
                    <label class="layui-form-label leftLabel" for="employ_depart">传真：</label>
                    <div class="layui-input-inline layui-col-md8">
                           <input type="text" class="layui-input typeOne" name="fax" id="fax" value="${result.fax}">
                    </div>
                 </div>
                  <div class="layui-col-md1">
                </div>
                 <div class="layui-col-md1">
                    <label class="layui-form-label leftLabel" for="employ_depart">单位网址：</label>
                    <div class="layui-input-inline layui-col-md8">
                           <input type="text" class="layui-input typeOne" name="orgUrl" id="orgUrl" value="${result.orgUrl}">
                    </div>
                 </div>
                  <div class="layui-col-md1">
                </div>
          </div>         
          <div class="layui-row">
                <div class="layui-input-inline layui-col-md2">
                    <label class="layui-form-label leftLabel" >所属行政区划：</label>
                    <div class="layui-input-inline layui-col-md8">
                        <select name="administrativeArea" id="administrativeArea" class="typeOne">
                        	<option value="">请选择</option>
                            <c:forEach items="${areaList}" var="u" varStatus="row">
                                <option value="${u.id}" <c:if test="${u.id eq result.administrativeArea}">selected</c:if> >${u.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-col-md1">
                </div>
                <div class="layui-input-inline layui-col-md2">
                    <label class="layui-form-label leftLabel" >所属普查机构：</label>
                    <div class="layui-input-inline layui-col-md8">
                        <select name="censusOrg" id="censusOrg" class="typeOne">
                            <option value="">请选择</option>
                            <option value="1" <c:if test="${'1' eq result.censusOrg}">selected</c:if>>东城区普查办</option>
                            <option value="2" <c:if test="${'2' eq result.censusOrg}">selected</c:if>>朝阳区普查办</option>
                            <option value="3" <c:if test="${'3' eq result.censusOrg}">selected</c:if>>丰台区普查办</option>
                            <option value="4" <c:if test="${'4' eq result.censusOrg}">selected</c:if>>石景山区普查办</option>
                            <option value="5" <c:if test="${'5' eq result.censusOrg}">selected</c:if>>海淀区普查办</option>
                            <option value="6" <c:if test="${'6' eq result.censusOrg}">selected</c:if>>门头沟区普查办</option>
                            <option value="7" <c:if test="${'7' eq result.censusOrg}">selected</c:if>>房山区普查办</option>
                            <option value="8" <c:if test="${'8' eq result.censusOrg}">selected</c:if>>通州区普查办</option>
                             <option value="9" <c:if test="${'9' eq result.censusOrg}">selected</c:if>>顺义区普查办</option>
                            <option value="10" <c:if test="${'10' eq result.censusOrg}">selected</c:if>>昌平区普查办</option>
                            <option value="11" <c:if test="${'11' eq result.censusOrg}">selected</c:if>>大兴区普查办</option>
                            <option value="12" <c:if test="${'12' eq result.censusOrg}">selected</c:if>>怀柔区普查办</option>
                            <option value="13" <c:if test="${'13' eq result.censusOrg}">selected</c:if>>平谷区普查办</option>
                            <option value="14" <c:if test="${'14' eq result.censusOrg}">selected</c:if>>密云县普查办</option>
                            <option value="15" <c:if test="${'15' eq result.censusOrg}">selected</c:if>>延庆县普查办</option>
                            <option value="16" <c:if test="${'16' eq result.censusOrg}">selected</c:if>>西城区普查办</option>
                             <option value="17" <c:if test="${'17' eq result.censusOrg}">selected</c:if>>北京市普查办</option>
                        </select>
                    </div>
                </div>
                <div class="layui-col-md1">
                </div>
                <div class="layui-input-inline layui-col-md2">
                    <label class="layui-form-label leftLabel" style="width:280px;">是否已建立文物纸质档案：</label>
                    <div class="layui-input-inline" >
                        <input type="radio" name="existPaperArchive" value="1"  title="是" <c:if test="${'1' eq result.existPaperArchive}">checked</c:if>>
                        <input type="radio" name="existPaperArchive" value="0"  title="否" <c:if test="${'0' eq result.existPaperArchive}">checked</c:if>>
                    </div>
                </div>
                <div class="layui-col-md1">
                </div>
                <div class="layui-input-inline layui-col-md2">
                    <label class="layui-form-label leftLabel" style="width:280px;">是否已建立文物数字档案：</label>
                    <div class="layui-input-inline" >
                        <input type="radio" name="existNumberArchive" value="1"  title="是" <c:if test="${'1' eq result.existNumberArchive}">checked</c:if>>
                        <input type="radio" name="existNumberArchive" value="0"  title="否" <c:if test="${'0' eq result.existNumberArchive}">checked</c:if>>
                    </div>
                </div>
                <div class="layui-col-md1">
                </div>
          </div>
          <div class="layui-row">
                <div class="layui-col-md2">
                    <label class="layui-form-label leftLabel" for="employ_depart">库房面积：</label>
                    <div class="layui-input-inline layui-col-md8">
                           <input type="text"  class="layui-input typeOne" name="storeroomArea" id="storeroomArea" value="${result.storeroomArea}">
                    </div>
                 </div>
                 <div class="layui-col-md4">
                </div>
                 <div class="layui-col-md2">
                    <label class="layui-form-label leftLabel" for="employ_depart">保管人员数量（人）：</label>
                    <div class="layui-input-inline layui-col-md8">
                           <input type="number" min="0" class="layui-input typeOne" name="storemanCount" id="storemanCount" value="${result.storemanCount}">
                    </div>
                 </div>
                  <div class="layui-col-md4">
                </div>
            </div>
         <div class="layui-row">
          <div class="layui-col-md2">
              <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp领导信息</a>
          </div>
         </div> 
          <div class="layui-row">
             <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">姓名：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="text" class="layui-input typeOne" name="leaderName" id="leaderName" value="${result.leaderName}">
                </div>
            </div>
             <div class="layui-col-md1">
                </div>
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">职务：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="text" class="layui-input typeOne" name="job" id="job" value="${result.job}">
                </div>
            </div>
             <div class="layui-col-md1">
                </div>
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">固定电话：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="text" class="layui-input typeOne" name="telephone" id="telephone" value="${result.telephone}">
                </div>
            </div>
             <div class="layui-col-md1">
                </div>
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">移动电话：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="text" class="layui-input typeOne" name="mobilePhone" id="mobilePhone" value="${result.mobilePhone}">
                </div>
            </div>
             <div class="layui-col-md1">
                </div>
          </div> 
           <div class="layui-row">
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">电子邮箱：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="text" class="layui-input typeOne" lay-verify="email" name="email" id="email" value="${result.email}">
                </div>
            </div>
             <div class="layui-col-md4">
                </div>
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">任职起始时间：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="text" class="layui-input typeOne" name="workStartTime" id="workStartTime" value="${result.workStartTime}">
                </div>
            </div>   
            <div class="layui-col-md4">
                </div>        
        </div> 
         <div class="layui-row">
            <div class="layui-col-md2">
                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp&nbsp收藏信息</a>
            </div>
        </div> 
        <div class="layui-row">
             <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">已登录文物数量（件）：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="number" min="0" class="layui-input typeOne" name="culturalRelicCount" id="culturalRelicCount" value="${result.culturalRelicCount}">
                </div>
            </div>
            <div class="layui-col-md4">
                </div>
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">已登录藏品总数（件/套）：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="number" min="0"  class="layui-input typeOne" name="collectionCount" id="collectionCount" value="${result.collectionCount}">
                </div>
            </div>
            <div class="layui-col-md4">
                </div>
          </div>     
          <div class="layui-row">
             <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">一级文物（件/套）：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="number" min="0" class="layui-input typeOne" name="oneLevelCulturalRelic" id="oneLevelCulturalRelic" value="${result.oneLevelCulturalRelic}">
                </div>
            </div>
            <div class="layui-col-md1">
                </div>
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">二级文物（件/套）：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="number" min="0" class="layui-input typeOne" name="secondLevelCulturalRelic" id="secondLevelCulturalRelic" value="${result.secondLevelCulturalRelic}">
                </div>
            </div>
            <div class="layui-col-md1">
                </div>
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">三级文物（件/套）：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="number" min="0" class="layui-input typeOne" name="threeLevelCulturalRelic" id="threeLevelCulturalRelic" value="${result.threeLevelCulturalRelic}">
                </div>
            </div>
            <div class="layui-col-md1">
                </div>
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">一般文物（件/套）：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="number" min="0" class="layui-input typeOne" name="commonlyCulturalRelic" id="commonlyCulturalRelic" value="${result.commonlyCulturalRelic}">
                </div>
            </div>
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">未定级文物（件/套）：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="number" min="0" class="layui-input typeOne" name="noGradeCulturalRelic" id="noGradeCulturalRelic" value="${result.noGradeCulturalRelic}">
                </div>
            </div>
            <div class="layui-col-md1">
                </div>
          </div> 
          <div class="layui-row">
             <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">一级藏品（件/套）：：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="number" min="0" class="layui-input typeOne" name="oneLevelCollection" id="oneLevelCollection" value="${result.oneLevelCollection}">
                </div>
            </div>            
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">二级藏品（件/套）：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="number" min="0" class="layui-input typeOne" name="secondLevelCollection" id="secondLevelCollection" value="${result.secondLevelCollection}">
                </div>
            </div>
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">三级藏品（件/套）：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="number" min="0" class="layui-input typeOne" name="threeLevelCollection" id="threeLevelCollection" value="${result.threeLevelCollection}">
                </div>
            </div>
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">一般藏品（件/套）：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="number" min="0" class="layui-input typeOne" name="commonlyCollection" id="commonlyCollection" value="${result.commonlyCollection}">
                </div>
            </div>
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">未定级藏品（件/套）：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="number" min="0" class="layui-input typeOne" name="noGradeCollection" id="noGradeCollection" value="${result.noGradeCollection}">
                </div>
            </div>
            <div class="layui-input-inline layui-col-md2">
                <label class="layui-form-label leftLabel">自然类数量：</label>
                <div class="layui-input-inline layui-col-md9">
                    <input type="number" min="0" class="layui-input typeOne" name="naturalCollection" id="naturalCollection" value="${result.naturalCollection}">
                </div>
            </div>
          </div> 
</form>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/museum/js/commonUtil.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery.base64.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">

layui.use(['form','layer','upload','laydate'],function(){
    
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laydate=layui.laydate,
        $ = layui.jquery;
        
        //执行一个laydate实例
        laydate.render({
            elem: '#firstOpenDate' //指定元素
        });
    
    //页面初始化
    var key = $("#id").val();
    var level = $("#level").val();
    if(level == "2" || (key != null && key != "")){
        $('input,select,textarea').attr('disabled',"disabled"); 
        form.render('select');
    }
    initFileds();
    //校验
    form.verify(
    {phone:[/(^$)|(^(\(\d{3,4}\)|(\d{3,4}-))?\d{7,8}$)/,'请输入正确电话号码'],
        zCode:[/(^$)|(^[1-9][0-9]{5}$)/,'请输入正确的邮编'],
        desLength:function(value,item){
            var checkVal = value.trim();
            $(item).val(checkVal);
            if(checkVal.length>400){
                return '最多只能输入400个字符';
            }
        }
    }); 
    
    //提交
    form.on("submit(saveBase)",function(data){     
        if(checkModification() ){           
            //全页面3个单选框所有传3
            if(checkFullCom(3)){
                $("#isFull").val("1");
            }else{
                $("#isFull").val("0");
            }
            var loading; 
            $.ajax({
                   url:"<%=request.getContextPath()%>/relicsUnitInfo/relicsUnitSave.do",
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
        if(checkModification() ){
            layer.confirm('您修改的信息尚未保存，确定要离开吗？', {  
                btn: ['确定','取消'] //按钮
            }, function(index){
                layer.close(index);  //关闭弹出层
                //点击确定之后需要执行的函数
                var relicsUnitId = $("#relicsUnitId").val();
                window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+relicsUnitId;
            }, function(index){
                layer.close(index);  //关闭弹出层
            });
        }else{
            var relicsUnitId = $("#relicsUnitId").val();
            window.location.href = "<%=request.getContextPath()%>/museuminfo/museumDetail.do?museumId="+relicsUnitId;
        }
    });
    
    //修改
    $("#btn_edit").click(function(){
        $('input,select,textarea',$('form[name="mesForm"]')).removeAttr("disabled");
        $("#museumName").attr('disabled','disabled');
        $("#parentOrgName").attr('disabled','disabled');
        $("#btn_edit").addClass("hideBtn");
        $("#btn_submit").removeClass("hideBtn");
        form.render('select');
    });
    
});


//子页面获取当前页面的接收单位
function setTitleImg(absolurl, relativeurl){
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