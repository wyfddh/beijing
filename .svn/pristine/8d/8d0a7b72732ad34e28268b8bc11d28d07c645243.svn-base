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
  .childrenBody{
 	padding-left:20px;
 	padding-right:20px;
 	padding-bottom:20px;
 }
  .label-title{
 	color:#BE9A5B;
 	font-size:18px;
 	font-weight:700;
 }
 .layui-row{
 	padding-bottom:20px;
 }
 .disabled{
	 pointer-events: none;
	 cursor: default;
	 opacity: 0.6;
 }
 .layui-form-label{
 width:100px;
 }
</style>
<title>基本信息</title>
</head>
<body class="childrenBody">
	  <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
  			<ul class="layui-tab-title">
			    <li id="tab1" class="layui-this">基本信息</li>
			    <li id="tab2"><a onclick="changTab('2')" >获奖与资质</a></li>
			    <li id="tab2"><a onclick="changTab('3')">资质证书</a></li>
			</ul>
		   <div class="layui-tab-content">
		     <form class="layui-form" role="form"  id="personForm" name="personForm">
		               <input type="hidden" name="museumId" id="museumId" value="${museumId}">
		               <input type="hidden" name="id" id="id" value="${personId}">
		               <input type="hidden" name="level" id="level" value="${level}">
		               <input type="hidden" id="department" name="department" value="${department}">
		   		<div class="layui-row">
	                <div class="layui-input-inline layui-col-xs6">
	                    <label class="layui-form-label" for="">姓名：</label>
	                    <div class="layui-input-inline layui-col-xs8">
	                        <input type="text" class="layui-input" name="name" id="name" value="${personInfo.name}" placeholder="">
	                    </div>
	                </div>
	                <div class="layui-input-inline layui-col-xs6">
					    <label class="layui-form-label">性别：</label>
					    <div class="layui-input-inline layui-col-xs8">
					      <input type="radio" name="sex" value="1" title="男" <c:if test="${'1' eq personInfo.sex}">checked</c:if>>
					      <input type="radio" name="sex" value="0" title="女" <c:if test="${'0' eq personInfo.sex}">checked</c:if>>
					    </div>
	  				</div>
	            </div>
	            <div class="layui-row">
	            	<div class="layui-input-inline layui-col-xs6">
		            	<label  class="layui-form-label">婚姻状况：</label>
	            		<div class="layui-input-inline layui-col-xs8">
					      <input type="radio" name="isMarry" value="1" title="已婚" <c:if test="${'1' eq personInfo.isMarry}">checked</c:if>>
					      <input type="radio" name="isMarry" value="0" title="未婚" <c:if test="${'0' eq personInfo.isMarry}">checked</c:if>>
					    </div>
				    </div>
				    <div class="layui-input-inline layui-col-xs6">
				    	<label  class="layui-form-label">有无子女：</label>
	            		<div class="layui-input-inline layui-col-xs8">
					      <input type="radio" name="haveChildren" value="1" title="有" <c:if test="${'1' eq personInfo.haveChildren}">checked</c:if>>
					      <input type="radio" name="haveChildren" value="0" title="无" <c:if test="${'0' eq personInfo.haveChildren}">checked</c:if>>
					    </div>
				    </div>
	            </div>
	            <div class="layui-row">
	                <div class="layui-input-inline layui-col-xs6">
	                    <label class="layui-form-label" for="">民族：</label>
	                    <div class="layui-input-inline layui-col-xs8">
	                        <input type="text" class="layui-input" name="nation" id="nation"  placeholder="" value="${personInfo.nation}">
	                    </div>
	                </div>
	                <div class="layui-input-inline layui-col-xs6">
	                    <label class="layui-form-label" for="">身份证号：</label>
	                    <div class="layui-input-inline layui-col-xs8">
	                        <input type="text" class="layui-input"  name="idNumber" id="idNumber"  placeholder="" value="${personInfo.idNumber}">
	                    </div>
	                </div>
	            </div>
	            <div class="layui-row">
	                <div class="layui-input-inline layui-col-xs6">
	                    <label class="layui-form-label" for="">户口类型：</label>
	                    <div class="layui-input-inline layui-col-xs8">
		                    <select value="${personInfo.accountType}"  name="accountType" id="accountType">
	                            <option value="">请选择</option>
	                            <option value="01" <c:if test="${'01' eq personInfo.accountType}">selected</c:if>>本市城镇</option>
	                            <option value="02" <c:if test="${'02' eq personInfo.accountType}">selected</c:if>>本市农村</option>
	                            <option value="03" <c:if test="${'03' eq personInfo.accountType}">selected</c:if>>外阜城镇</option>
	                            <option value="04" <c:if test="${'04' eq personInfo.accountType}">selected</c:if>>外阜农村</option>
	                            <option value="05" <c:if test="${'05' eq personInfo.accountType}">selected</c:if>>其他</option>
	                        </select>
	                    </div>
	                </div>
	                
	                <div class="layui-input-inline layui-col-xs6">
	                    <label class="layui-form-label" for="">文化程度：</label>
	                    <div class="layui-input-inline layui-col-xs8">
	                        <select value="${personInfo.education}" name="education" id="education">
	                            <option value="">请选择</option>
	                            <option value="01" <c:if test="${'01' eq personInfo.education}">selected</c:if>>博士</option>
	                            <option value="02" <c:if test="${'02' eq personInfo.education}">selected</c:if>>硕士</option>
	                            <option value="03" <c:if test="${'03' eq personInfo.education}">selected</c:if>>本科</option>
	                            <option value="04" <c:if test="${'04' eq personInfo.education}">selected</c:if>>大专</option>
	                            <option value="05" <c:if test="${'05' eq personInfo.education}">selected</c:if>>中专</option>
	                            <option value="06" <c:if test="${'06' eq personInfo.education}">selected</c:if>>高中</option>
	                            <option value="07" <c:if test="${'07' eq personInfo.education}">selected</c:if>>初中</option>
	                            <option value="08" <c:if test="${'08' eq personInfo.education}">selected</c:if>>小学</option>
	                        </select>
	                    </div>
	                </div>
	            </div>
	            
	            <div class="layui-row">
	                <div class="layui-input-inline layui-col-xs6">
	                    <label class="layui-form-label" for="">手机号：</label>
	                    <div class="layui-input-inline layui-col-xs8">
	                        <input type="text" class="layui-input" name="phone" lay-verify ="num" id="phone"  placeholder=""  value="${personInfo.phone}">
	                    </div>
	                </div>
	                <div class="layui-input-inline layui-col-xs6">
					    <label class="layui-form-label">邮箱：</label>
					     <div class="layui-input-inline layui-col-xs8">
	                        <input type="text" class="layui-input" name="email" id="email" placeholder="" value="${personInfo.email}">
	                    </div>
	  				</div>
	            </div>
	            
	            <div class="layui-row">
	                <div class="layui-input-inline layui-col-xs6">
	                    <label class="layui-form-label" for="">职称：</label>
	                    <div class="layui-input-inline layui-col-xs8">
	                        <select value="${personInfo.jobTitle}"  name="jobTitle" id="jobTitle">
	                            <option value="">请选择</option>
	                            <option value="01" <c:if test="${'01' eq personInfo.jobTitle}">selected</c:if>>初级职称</option>
	                            <option value="02" <c:if test="${'02' eq personInfo.jobTitle}">selected</c:if>>中级职称</option>
	                            <option value="03" <c:if test="${'03' eq personInfo.jobTitle}">selected</c:if>>副高级职称</option>
	                            <option value="04" <c:if test="${'04' eq personInfo.jobTitle}">selected</c:if>>正高级职称</option>
	                        </select>
	                    </div>
	                </div>
	                <div class="layui-input-inline layui-col-xs6">
	                    <label class="layui-form-label" for="">职务：</label>
	                    <div class="layui-input-inline layui-col-xs8">
	                        <input type="text" class="layui-input" name="job" id="job"  placeholder="" value="${personInfo.job}">
	                    </div>
	                </div>
	            </div>
	            <%-- <div class="layui-row">
	            	<div class="layui-input-inline layui-col-xs6">
					    <label class="layui-form-label">毕业院校：</label>
					     <div class="layui-input-inline layui-col-xs8">
	                        <input type="text" class="layui-input" name="graduatedSchool" id="graduatedSchool" placeholder="毕业院校" value="${personInfo.graduatedSchool}">
	                    </div>
	  				</div>
	                <div class="layui-input-inline layui-col-xs6">
	                    <label class="layui-form-label" for="">政治面貌：</label>
	                    <div class="layui-input-inline layui-col-xs8">
	                        <select value="${personInfo.politicalStatus}"  name="politicalStatus" id="politicalStatus">
	                            <option value="">请选择</option>
	                            <option value="01" <c:if test="${'01' eq personInfo.politicalStatus}">selected</c:if>>中共党员</option>
	                            <option value="02" <c:if test="${'02' eq personInfo.politicalStatus}">selected</c:if>>预备党员</option>
	                            <option value="03" <c:if test="${'03' eq personInfo.politicalStatus}">selected</c:if>>共青团员</option>
	                            <option value="04" <c:if test="${'04' eq personInfo.politicalStatus}">selected</c:if>>少先队员</option>
	                            <option value="05" <c:if test="${'05' eq personInfo.politicalStatus}">selected</c:if>>群众</option>
	                        </select>
	                    </div>
	                </div>
	            </div> --%>
	            <div class="layui-row">
	                <div class="layui-input-inline layui-col-xs6">
					    <label class="layui-form-label">研究方向：</label>
					     <div class="layui-input-inline layui-col-xs8">
	                        <select value="${personInfo.jobTitle}"  name="researchDirection" id="researchDirection">
	                            <option value="">请选择</option>
	                            <option value="01" <c:if test="${'01' eq personInfo.jobTitle}">selected</c:if>>考古学发掘研究</option>
	                            <option value="02" <c:if test="${'02' eq personInfo.jobTitle}">selected</c:if>>文物保护技术研究</option>
	                            <option value="03" <c:if test="${'03' eq personInfo.jobTitle}">selected</c:if>>文物研究</option>
	                            <option value="04" <c:if test="${'04' eq personInfo.jobTitle}">selected</c:if>>古代建筑研究</option>
	                            <option value="05" <c:if test="${'05' eq personInfo.jobTitle}">selected</c:if>>古代艺术研究</option>
	                            <option value="06" <c:if test="${'06' eq personInfo.jobTitle}">selected</c:if>>民族民俗研究</option>
	                            <option value="07" <c:if test="${'07' eq personInfo.jobTitle}">selected</c:if>>文物鉴定</option>
	                            <option value="08" <c:if test="${'08' eq personInfo.jobTitle}">selected</c:if>>文物修复</option>
	                            <option value="09" <c:if test="${'09' eq personInfo.jobTitle}">selected</c:if>>文物保管</option>
	                        </select>
	                    </div>
	  				</div>
	                <div class="layui-input-inline layui-col-xs6">
					    <label class="layui-form-label">雇佣关系：</label>
					     <div class="layui-input-inline layui-col-xs8">
	                        <select value="${personInfo.employmentRelation}"  name="employmentRelation" id="employmentRelation">
	                            <option value="">请选择</option>
	                            <option value="01" <c:if test="${'01' eq personInfo.employmentRelation}">selected</c:if>>正式员工</option>
	                            <option value="02" <c:if test="${'02' eq personInfo.employmentRelation}">selected</c:if>>劳务派遣</option>
	                            <option value="03" <c:if test="${'03' eq personInfo.employmentRelation}">selected</c:if>>临时用工</option>
	                        </select>
	                    </div>
	  				</div>
	            </div>
	            <div class="layui-row">
		  				<div class="layui-input-inline layui-col-xs2 layui-col-xs-offset5">
		  				  <c:if test="${'1' eq level}">
					      	<a id="saveBtn" type="button" class="layui-btn" lay-submit lay-filter="savePerson"> 保存</a>
					      </c:if>
						  <a id="close" type="button" class="layui-btn">关闭</a>
					    </div>
				    </div>
	          </form>
		  </div>
  </div>  
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/museum/js/commonUtil.js"></script>
<!--请在下方写此页面业务相关的脚本-->

<script type="text/javascript">

layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    
    initFileds();
    
    var level=$("#level").val();
	if(level=="2"){
		$('input,select,textarea',$('form[name="personForm"]')).attr('disabled',"disabled");
	}
    form.verify({
	    num:[/(^$)|(^([\d]{11})?$)/,'请输入正确手机号']      
	}); 
    form.on("submit(savePerson)",function(data){
    	if(checkModification()){
    		var loading; 
    		$.ajax({
    		       url:"<%=request.getContextPath()%>/museumPerson/savePerson.do",
    		       data:$('#personForm').serialize(),
    		       type:"POST",
    		       beforeSend: function () {
	    	    	   loading = layer.load();
	    	       },
    		       success:function(msg){
    		    	   layer.close(loading); 
    		    	   if(msg.success == 1){
    		    		   var map = msg.data;
    		    		   var personId = map.personId;
    		    		   var museumId = map.museumId;
    		    		   var department = map.department;
    		    		   layer.msg("保存成功！");
    		               	setTimeout(function(){
    		               		window.location.href='<%=request.getContextPath() %>/museumPerson/personInfo.do?personId=' + personId+'&museumId='+museumId+'&department='+department;
    		   				},1000);
    	                }else if(msg.success == 0){
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
       return false;
    })
})

	function changTab(tab) {
		var personId = $("#id").val();
		var museumId = $("#museumId").val();
		if(personId != null && personId != "" && personId != "undefind"){
			if(tab == "2"){
				window.location.href='<%=request.getContextPath() %>/museumPerson/awardList.do?personId=' + personId+'&museumId='+museumId;
			}else if(tab == "3"){
				window.location.href='<%=request.getContextPath() %>/museumPerson/certificationList.do?personId=' + personId+'&museumId='+museumId;
			}
			return true;
		}else{
			$("#tab1").click();
		}
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