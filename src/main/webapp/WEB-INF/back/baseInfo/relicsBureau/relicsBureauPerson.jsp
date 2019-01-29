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
.headFont{
	font-weight: bold;
	margin-left: 43px;
}
.add{
	color:#BE9A5B;
	margin-left: 43px;
}
.layui-table{
	margin-left: 28px;
	width: 95%;
}
.delbtn{
	width: 35px;
}
</style>
<title>基本信息</title>
</head>
<body class="childrenBody">
 <div>  
    <form action="" id="mesForm" name="mesForm" class="layui-form">
    	<input type="hidden" id="geography" name="geography" value="">
		<input type="hidden" id="level" name="level" value="${level}"/>
        <input type="hidden" name="orgId" id="orgId" value="${orgId}">
        <input type="hidden"  id="totalStatus" value="${totalStatus}">
        <input type="hidden" name="isFull" id="isFull" value="">
		<div class="layui-row">
			<div class="layui-col-md2 layui-col-md-offset10 pt_30">
				<span style="text-align:center;display:block;">
					<c:if test="${'1' eq level}">
						<c:if test="${totalStatus eq 0}">
							<a id="btn_submit" type="button" class="layui-btn" lay-submit lay-filter="saveBase">保存</a>
							<a id="btn_edit" type="button" class="layui-btn hideBtn">编辑</a>
		                </c:if>
		                <c:if test="${totalStatus eq 1}">
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
                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp;&nbsp;专职技术人员变动情况</a>
            </div>
        </div>
        <div>
        	<h3 class="headFont">申请资质时人员</h3>
        </div>
        <input type="text" class="layui-hide" value="1" name="applyAptitude">
        <table id="table1" class="layui-table" lay-skin="nob">
        	<thead>
        		<tr>
        			<th></th>
        			<th>姓名</th>
        			<th>单位性质</th>
        			<th>职称</th>
        		</tr>
        	</thead>
        	<tbody id="tbody1">
        		<c:if test="${status1 eq 1}">
	        		<c:forEach items="${list1}" var="item">
	        			<tr id="tr${item.id}">
	        				<td class="delbtn">
	        					<a id="delete_btn" class="del" href="javascript:;" onclick="deletePerson('${item.id}');" ><img src="<%=request.getContextPath() %>/back/images/delete.png"></a>
	        				</td>
		        			<td>
		        				<input type="text" class="layui-hide" name="id" value="${item.id }">
		        				<input type="text" class="layui-input" name="pName" value="${item.pName}">
		        			</td>
		        			<td>
		        				<select  name="natures" class="typeOne" >
			                        <option value="">请选择</option>
			                        <option value="1" <c:if test="${'1' eq item.natures}">selected</c:if>>在编</option>
			                        <option value="2" <c:if test="${'2' eq item.natures}">selected</c:if>>聘用</option>
			                    </select>
		        			</td>
		        			<td>
		        				<select  name="technicalTitle" class="typeOne">
			                        <option value="">请选择</option>
			                        <option value="1" <c:if test="${'1' eq item.technicalTitle}">selected</c:if>>高级职称</option>
			                        <option value="2" <c:if test="${'2' eq item.technicalTitle}">selected</c:if>>中级职称</option>
			                        <option value="3" <c:if test="${'3' eq item.technicalTitle}">selected</c:if>>初级职称</option>
			                        <option value="4" <c:if test="${'4' eq item.technicalTitle}">selected</c:if>>其他</option>
			                    </select>
		        			</td>
		        		</tr>
	        		</c:forEach>
        		</c:if>
        		<c:if test="${status1 eq 0}">
        			<tr>
        				<td class="delbtn">
        					
        				</td>
	        			<td>
	        				<input type="text" class="layui-input" name="pName" value="">
	        			</td>
	        			<td>
	        				<select  name="natures" class="typeOne" >
		                        <option value="">请选择</option>
		                        <option value="1" >在编</option>
		                        <option value="2" >聘用</option>
		                    </select>
	        			</td>
	        			<td>
	        				<select  name="technicalTitle" class="typeOne">
		                        <option value="">请选择</option>
		                        <option value="1" >高级职称</option>
		                        <option value="2" >中级职称</option>
		                        <option value="3" >初级职称</option>
		                        <option value="4" >其他</option>
		                    </select>
	        			</td>
		            </tr>
        		</c:if>
        	</tbody>
        </table>
        <div>
        	<a class="add" id="add1" href="javascript:;">添加</a><br><br>
        </div>
       
        <div>
        	<h3 class="headFont">获得资质后新增人员</h3>
        </div>
        <input type="text" class="layui-hide" value="1" name="addPersonnel">
        <table id="table2" class="layui-table" lay-skin="nob">
        	<thead>
        		<tr>
        			<th></th>
        			<th>姓名</th>
        			<th>单位性质</th>
        			<th>职称</th>
        		</tr>
        	</thead>
        	<tbody id="tbody2">
        		<c:if test="${status2 eq 1}">
	        		<c:forEach items="${list2}" var="item">
	        			<tr id="tr${item.id}">
	        				<td class="delbtn">
	        					<a id="delete_btn" class="del" href="javascript:;" onclick="deletePerson('${item.id}');" ><img src="<%=request.getContextPath() %>/back/images/delete.png"></a>
	        				</td>
		        			<td>
		        				<input type="text" class="layui-hide" name="id" value="${item.id}">
		        				<input type="text" class="layui-input" name="pName" value="${item.pName}">
		        			</td>
		        			<td>
		        				<select  name="natures" class="typeOne" >
			                        <option value="">请选择</option>
			                        <option value="1" <c:if test="${'1' eq item.natures}">selected</c:if>>在编</option>
			                        <option value="2" <c:if test="${'2' eq item.natures}">selected</c:if>>聘用</option>
			                    </select>
		        			</td>
		        			<td>
		        				<select  name="technicalTitle" class="typeOne">
			                        <option value="">请选择</option>
			                        <option value="1" <c:if test="${'1' eq item.technicalTitle}">selected</c:if>>高级职称</option>
			                        <option value="2" <c:if test="${'2' eq item.technicalTitle}">selected</c:if>>中级职称</option>
			                        <option value="3" <c:if test="${'3' eq item.technicalTitle}">selected</c:if>>初级职称</option>
			                        <option value="4" <c:if test="${'4' eq item.technicalTitle}">selected</c:if>>其他</option>
			                    </select>
		        			</td>
		        		</tr>
	        		</c:forEach>
        		</c:if>
        		<c:if test="${status2 eq 0}">
        			<tr>
        				<td class="delbtn">
        					
        				</td>
	        			<td>
	        				<input type="text" class="layui-input" name="pName" value="">
	        			</td>
	        			<td>
	        				<select  name="natures" class="typeOne" >
		                        <option value="">请选择</option>
		                        <option value="1" >在编</option>
		                        <option value="2" >聘用</option>
		                    </select>
	        			</td>
	        			<td>
	        				<select  name="technicalTitle" class="typeOne">
		                        <option value="">请选择</option>
		                        <option value="1" >高级职称</option>
		                        <option value="2" >中级职称</option>
		                        <option value="3" >初级职称</option>
		                        <option value="4" >其他</option>
		                    </select>
	        			</td>
		            </tr>
        		</c:if>
        	</tbody>
        </table>
        <div>
        	<a class="add" id="add2" href="javascript:;">添加</a><br><br>
        </div>
        <div>
        	<h3 class="headFont">获得资质后新晋人员</h3>
        </div>
        <input type="text" class="layui-hide" value="1" name="newPromotion">
        <table id="table3" class="layui-table" lay-skin="nob">
        	<thead>
        		<tr>
        			<th></th>
        			<th>姓名</th>
        			<th>单位性质</th>
        			<th>职称</th>
        		</tr>
        	</thead>
        	<tbody id="tbody3">
        		<c:if test="${status3 eq 1}">
	        		<c:forEach items="${list3}" var="item">
	        			<tr id="tr${item.id}">
	        				<td class="delbtn">
	        					<a id="delete_btn" class="del" href="javascript:;" onclick="deletePerson('${item.id}');" ><img src="<%=request.getContextPath() %>/back/images/delete.png"></a>
	        				</td>
		        			<td>
		        				<input type="text" class="layui-hide" name="id" value="${item.id}">
		        				<input type="text" class="layui-input" name="pName" value="${item.pName}">
		        			</td>
		        			<td>
		        				<select  name="natures" class="typeOne" >
			                        <option value="">请选择</option>
			                        <option value="1" <c:if test="${'1' eq item.natures}">selected</c:if>>在编</option>
			                        <option value="2" <c:if test="${'2' eq item.natures}">selected</c:if>>聘用</option>
			                    </select>
		        			</td>
		        			<td>
		        				<select  name="technicalTitle" class="typeOne">
			                        <option value="">请选择</option>
			                        <option value="1" <c:if test="${'1' eq item.technicalTitle}">selected</c:if>>高级职称</option>
			                        <option value="2" <c:if test="${'2' eq item.technicalTitle}">selected</c:if>>中级职称</option>
			                        <option value="3" <c:if test="${'3' eq item.technicalTitle}">selected</c:if>>初级职称</option>
			                        <option value="4" <c:if test="${'4' eq item.technicalTitle}">selected</c:if>>其他</option>
			                    </select>
		        			</td>
		        		</tr>
	        		</c:forEach>
        		</c:if>
        		<c:if test="${status3 eq 0}">
        			<tr>
        				<td class="delbtn">
        					
        				</td>
	        			<td>
	        				<input type="text" class="layui-input" name="pName" value="">
	        			</td>
	        			<td>
	        				<select  name="natures" class="typeOne" >
		                        <option value="">请选择</option>
		                        <option value="1" >在编</option>
		                        <option value="2" >聘用</option>
		                    </select>
	        			</td>
	        			<td>
	        				<select  name="technicalTitle" class="typeOne">
		                        <option value="">请选择</option>
		                        <option value="1" >高级职称</option>
		                        <option value="2" >中级职称</option>
		                        <option value="3" >初级职称</option>
		                        <option value="4" >其他</option>
		                    </select>
	        			</td>
		            </tr>
        		</c:if>
        	</tbody>
        </table>
        <div>
        	<a class="add" id="add3" href="javascript:;">添加</a><br><br>
        </div>
        <div>
        	<h3 class="headFont">获得资质后离职人员</h3>
        </div>
        <input type="text" class="layui-hide" value="1" name="dimission">
        <table id="table4" class="layui-table" lay-skin="nob">
        	<thead>
        		<tr>
        			<th></th>
        			<th>姓名</th>
        			<th>单位性质</th>
        			<th>职称</th>
        		</tr>
        	</thead>
        	<tbody id="tbody4">
        		<c:if test="${status4 eq 1}">
	        		<c:forEach items="${list4}" var="item">
	        			<tr id="tr${item.id}">
	        				<td class="delbtn">
	        					<a id="delete_btn" class="del" href="javascript:;" onclick="deletePerson('${item.id}');" ><img src="<%=request.getContextPath() %>/back/images/delete.png"></a>
	        				</td>
		        			<td>
		        				<input type="text" class="layui-hide" name="id" value="${item.id}">
		        				<input type="text" class="layui-input" name="pName" value="${item.pName}">
		        			</td>
		        			<td>
		        				<select  name="natures" class="typeOne" >
			                        <option value="">请选择</option>
			                        <option value="1" <c:if test="${'1' eq item.natures}">selected</c:if>>在编</option>
			                        <option value="2" <c:if test="${'2' eq item.natures}">selected</c:if>>聘用</option>
			                    </select>
		        			</td>
		        			<td>
		        				<select  name="technicalTitle" class="typeOne">
			                        <option value="">请选择</option>
			                        <option value="1" <c:if test="${'1' eq item.technicalTitle}">selected</c:if>>高级职称</option>
			                        <option value="2" <c:if test="${'2' eq item.technicalTitle}">selected</c:if>>中级职称</option>
			                        <option value="3" <c:if test="${'3' eq item.technicalTitle}">selected</c:if>>初级职称</option>
			                        <option value="4" <c:if test="${'4' eq item.technicalTitle}">selected</c:if>>其他</option>
			                    </select>
		        			</td>
		        		</tr>
	        		</c:forEach>
        		</c:if>
        		<c:if test="${status4 eq 0}">
        			<tr>
        				<td class="delbtn">
        					
        				</td>
	        			<td>
	        				<input type="text" class="layui-input" name="pName" value="">
	        			</td>
	        			<td>
	        				<select  name="natures" class="typeOne" >
		                        <option value="">请选择</option>
		                        <option value="1" >在编</option>
		                        <option value="2" >聘用</option>
		                    </select>
	        			</td>
	        			<td>
	        				<select  name="technicalTitle" class="typeOne">
		                        <option value="">请选择</option>
		                        <option value="1" >高级职称</option>
		                        <option value="2" >中级职称</option>
		                        <option value="3" >初级职称</option>
		                        <option value="4" >其他</option>
		                    </select>
	        			</td>
		            </tr>
        		</c:if>
        	</tbody>
        </table>
        <div>
        	<a class="add" id="add4" href="javascript:;">添加</a><br><br>
        </div>
        <div class="layui-row">
            <div class="layui-col-md3">
                <a class="label-title"><img src="<%=request.getContextPath() %>/back/images/baseinfo.png" alt="">&nbsp;&nbsp;专职技术人员详情</a>
            </div>
        </div>
        <table id="table5" class="layui-table" lay-skin="nob">
        	<thead>
        		<tr>
        			<th></th>
        			<th>姓名</th>
        			<th>性别</th>
        			<th>出生年月</th>
        			<th>学历</th>
        			<th>学位</th>
        			<th>职称</th>
        			<th>获得职称年份</th>
        			<th>文物修复工作年限</th>
        			<th>修复专长</th>
        			<th>文物专长类别</th>
        			<th>变动情况</th>
        		</tr>
        	</thead>
        	<tbody id="tbody5">
        		<c:if test="${status5 eq 1}">
	        		<c:forEach items="${list5}" var="item">
	        			<tr id="tr${item.id}">
	        				<td class="delbtn">
	        					<a id="delete_btn" class="del" href="javascript:;" onclick="deleteDetail('${item.id}');" ><img src="<%=request.getContextPath() %>/back/images/delete.png"></a>
	        				</td>
		        			<td>
		        				<input type="text" class="layui-hide" name="id" value="${item.id}">
		        				<input type="text" class="layui-input" name="detailName" value="${item.detailName}">
		        			</td>
		        			<td>
		        				<select  name="sex" class="typeOne" >
			                        <option value="1" <c:if test="${'1' eq item.sex}">selected</c:if>>男</option>
			                        <option value="0" <c:if test="${'0' eq item.sex}">selected</c:if>>女</option>
			                    </select>
		        			</td>
		        			<td>
		        				<input type="text" class="layui-input birthday" name="birthday"  value="${item.birthday}">
		        			</td>
		        			<td>
		        				<select  name="education" class="typeOne" >
			                        <option value="">请选择</option>
			                        <option value="1" <c:if test="${'1' eq item.education}">selected</c:if>>中专</option>
			                        <option value="2" <c:if test="${'2' eq item.education}">selected</c:if>>大专</option>
			                        <option value="3" <c:if test="${'3' eq item.education}">selected</c:if>>本科</option>
			                        <option value="4" <c:if test="${'4' eq item.education}">selected</c:if>>硕士</option>
			                        <option value="5" <c:if test="${'5' eq item.education}">selected</c:if>>博士</option>
			                        <option value="6" <c:if test="${'6' eq item.education}">selected</c:if>>其他</option>
			                    </select>
		        			</td>
		        			<td>
		        				<select  name="academicDegree" class="typeOne" >
			                        <option value="">请选择</option>
			                        <option value="1" <c:if test="${'1' eq item.academicDegree}">selected</c:if>>学士学位</option>
			                        <option value="2" <c:if test="${'2' eq item.academicDegree}">selected</c:if>>硕士学位</option>
			                        <option value="3" <c:if test="${'3' eq item.academicDegree}">selected</c:if>>博士学位</option>
			                    </select>
		        			</td>
		        			<td>
		        				<select  name="technicalTitle" class="typeOne" >
			                        <option value="">请选择</option>
			                        <option value="1" <c:if test="${'1' eq item.technicalTitle}">selected</c:if>>教授</option>
			                        <option value="2" <c:if test="${'2' eq item.technicalTitle}">selected</c:if>>副教授</option>
			                        <option value="3" <c:if test="${'3' eq item.technicalTitle}">selected</c:if>>高级技术工人</option>
			                        <option value="4" <c:if test="${'4' eq item.technicalTitle}">selected</c:if>>工程师</option>
			                        <option value="5" <c:if test="${'5' eq item.technicalTitle}">selected</c:if>>副研究馆员</option>
			                    </select>
		        			</td>
		        			<td>
		        				<input type="text" class="layui-input technicalTitleYear" name="technicalTitleYear"  value="${item.technicalTitleYear}">
		        			</td>
		        			<td>
		        				<input type="number" min="1" max="100" step="1" class="layui-input" name="repairYear"  value="${item.repairYear}">
		        			</td>
		        			<td>
		        				<select  name="repairSpecialty" class="typeOne" >
			                        <option value="">请选择</option>
			                        <option value="1" <c:if test="${'1' eq item.repairSpecialty}">selected</c:if>>文物保护</option>
			                        <option value="2" <c:if test="${'2' eq item.repairSpecialty}">selected</c:if>>文物专长</option>
			                        <option value="3" <c:if test="${'3' eq item.repairSpecialty}">selected</c:if>>文物分析</option>
			                    </select>
		        			</td>
		        			<td>
		        				<input type="text" class="layui-input" name="specialtyType" placeholder="玉石、青铜器"  value="${item.specialtyType}">
		        			</td>
		        			<td>
		        				<select  name="jobChanges" class="typeOne" >
			                        <option value="0">无变动</option>
			                        <option value="1" <c:if test="${'1' eq item.jobChanges}">selected</c:if>>退休</option>
			                        <option value="2" <c:if test="${'2' eq item.jobChanges}">selected</c:if>>调离</option>
			                    </select>
		        			</td>
		        		</tr>
	        		</c:forEach>
        		</c:if>
        		<c:if test="${status5 eq 0}">
        			<tr>
        				<td class="delbtn">
        					
        				</td>
	        			<td>
	        				<input type="text" class="layui-input" lay-verify="required" name="detailName" value="">
	        			</td>
	        			<td>
	        				<select  name="sex" class="typeOne" >
		                        <option value="1" >男</option>
		                        <option value="0" >女</option>
		                    </select>
	        			</td>
	        			<td>
	        				<input type="text" class="layui-input birthday" name="birthday"  value="">
	        			</td>
	        			<td>
	        				<select  name="education" class="typeOne" >
		                        <option value="">请选择</option>
		                        <option value="1" >中专</option>
		                        <option value="2" >大专</option>
		                        <option value="3" >本科</option>
		                        <option value="4" >硕士</option>
		                        <option value="5" >博士</option>
		                        <option value="6" >其他</option>
		                    </select>
	        			</td>
	        			<td>
	        				<select  name="academicDegree" class="typeOne" >
		                        <option value="">请选择</option>
		                        <option value="1" >学士学位</option>
		                        <option value="2" >硕士学位</option>
		                        <option value="3" >博士学位</option>
		                    </select>
	        			</td>
	        			<td>
	        				<select  name="technicalTitle" class="typeOne" >
		                        <option value="">请选择</option>
		                        <option value="1" >教授</option>
		                        <option value="2" >副教授</option>
		                        <option value="3" >高级技术工人</option>
		                        <option value="4" >工程师</option>
		                        <option value="5" >副研究馆员</option>
		                    </select>
	        			</td>
	        			<td>
	        				<input type="text" class="layui-input technicalTitleYear" name="technicalTitleYear"  value="">
	        			</td>
	        			<td>
	        				<input type="number" min="1" max="100" step="1" class="layui-input" name="repairYear"  value="">
	        			</td>
	        			<td>
	        				<select  name="repairSpecialty" class="typeOne" >
		                        <option value="">请选择</option>
		                        <option value="1" >文物保护</option>
		                        <option value="2" >文物专长</option>
		                        <option value="3" >文物分析</option>
		                    </select>
	        			</td>
	        			<td>
	        				<input type="text" class="layui-input" name="specialtyType" placeholder="玉石、青铜器"  value="">
	        			</td>
	        			<td>
	        				<select  name="jobChanges" class="typeOne" >
		                        <option value="0">无变动</option>
		                        <option value="1" >退休</option>
		                        <option value="2" >调离</option>
		                    </select>
	        			</td>
		            </tr>
        		</c:if>
        	</tbody>
        </table>
        <div>
        	<a class="add" id="add5" href="javascript:;">添加</a><br><br>
        </div>
	</form>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/museum/js/commonUtil.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/back/lib/jquery.base64.js"></script>

<script type="text/javascript">

layui.use(['form','layer','upload','laydate'],function(){
	
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
       	laydate=layui.laydate,
        $ = layui.jquery;
    	
    var pathName=window.document.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    
    form.verify({ 
    	num:[/^$|^\d{1,8}(\.\d{1,2})?$/,'请输入1-8位的数字，小数点后最多2位']
   		,phone:[/^(1(3|5|8)\d{9})?$/,'请输入正确电话号码']
    	/* ,phone:[/(^$)|(^(\(\d{3,4}\)|(\d{3,4}-))?\d{7,8}$)/,'请输入正确电话号码'] */
    	,zCode:[/(^$)|(^[1-9][0-9]{5}$)/,'请输入正确的邮编']
    	,email:[/(^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+)|(^$)/,'请输入正确的邮箱']
    });
    
    lay('.birthday').each(function(){
  	   laydate.render({
  	      elem:this,
  	      type:'month',
  	      trigger:'click'
  	   });
    }); 
    
    lay('.technicalTitleYear').each(function(){
   	   laydate.render({
   	      elem:this,
   	      type:'year',
   	      trigger:'click'
   	   });
     }); 
    
	
	//页面初始化
    var totalStatus = $("#totalStatus").val();
    var level = $("#level").val();
	if(level == "2" || (totalStatus == 1)){
		$(".add").hide();
		$(".del").hide();
		$('input,select,textarea').attr('disabled',"disabled");	
		   
		form.render('select');
	}
	initFileds();
  	
    
    //提交
    form.on("submit(saveBase)",function(data){
    	
    	
        	//全页面0个单选框所以传0
        	if(checkFullCom(0)){
        		$("#isFull").val("1");
        	}else{
        		$("#isFull").val("0");
        	}
        	var loading; 
        	
        	var changeList = new Array();
        	var detailList = new Array();
        	
        	$("#table1").find("tr").each(function(){
                var tdArr = $(this).children();
                var id = tdArr.find("[name='id']").val();
                var pName = tdArr.find("[name='pName']").val();
                var natures = tdArr.find("[name='natures']").val();
                var technicalTitle = tdArr.find("[name='technicalTitle']").val();
                if (!isEmpty(pName)) {
                	changeList.push({
                		id:id,
                		pName:pName,
                		natures:natures,
                		technicalTitle:technicalTitle,
                		applyAptitude:1,
                		addPersonnel:0,
                		newPromotion:0,
                		dimission:0
                	});
                }
            });
        	$("#table2").find("tr").each(function(){
                var tdArr = $(this).children();
                var id = tdArr.find("[name='id']").val();
                var pName = tdArr.find("[name='pName']").val();
                var natures = tdArr.find("[name='natures']").val();
                var technicalTitle = tdArr.find("[name='technicalTitle']").val();
                if (!isEmpty(pName)) {
                	changeList.push({
                		id:id,
                		pName:pName,
                		natures:natures,
                		technicalTitle:technicalTitle,
                		applyAptitude:0,
                		addPersonnel:1,
                		newPromotion:0,
                		dimission:0
                	});
                }
            });
        	$("#table3").find("tr").each(function(){
                var tdArr = $(this).children();
                var id = tdArr.find("[name='id']").val();
                var pName = tdArr.find("[name='pName']").val();
                var natures = tdArr.find("[name='natures']").val();
                var technicalTitle = tdArr.find("[name='technicalTitle']").val();
                if (!isEmpty(pName)) {
                	changeList.push({
                		id:id,
                		pName:pName,
                		natures:natures,
                		technicalTitle:technicalTitle,
                		applyAptitude:0,
                		addPersonnel:0,
                		newPromotion:1,
                		dimission:0
                	});
                }
            });
        	$("#table4").find("tr").each(function(){
                var tdArr = $(this).children();
                var id = tdArr.find("[name='id']").val();
                var pName = tdArr.find("[name='pName']").val();
                var natures = tdArr.find("[name='natures']").val();
                var technicalTitle = tdArr.find("[name='technicalTitle']").val();
                if (!isEmpty(pName)) {
                	changeList.push({
                		id:id,
                		pName:pName,
                		natures:natures,
                		technicalTitle:technicalTitle,
                		applyAptitude:0,
                		addPersonnel:0,
                		newPromotion:0,
                		dimission:1
                	});
                }
            });
        	$("#table5").find("tr").each(function(){
                var tdArr = $(this).children();
                var id = tdArr.find("[name='id']").val();
                var detailName = tdArr.find("[name='detailName']").val();
                var sex = tdArr.find("[name='sex']").val();
                var birthday = tdArr.find("[name='birthday']").val();
                var education = tdArr.find("[name='education']").val();
                var academicDegree = tdArr.find("[name='academicDegree']").val();
                var technicalTitle = tdArr.find("[name='technicalTitle']").val();
                var technicalTitleYear = tdArr.find("[name='technicalTitleYear']").val();
                var repairYear = tdArr.find("[name='repairYear']").val();
                var repairSpecialty = tdArr.find("[name='repairSpecialty']").val();
                var specialtyType = tdArr.find("[name='specialtyType']").val();
                var jobChanges = tdArr.find("[name='jobChanges']").val();
                if (!isEmpty(detailName)) {
                	detailList.push({
                		id:id,
                		detailName:detailName,
                		sex:sex,
                		birthday:birthday,
                		education:education,
                		academicDegree:academicDegree,
                		technicalTitle:technicalTitle,
                		technicalTitleYear:technicalTitleYear,
                		repairYear:repairYear,
                		repairSpecialty:repairSpecialty,
                		specialtyType:specialtyType,
                		jobChanges:jobChanges
                	});
                }
            });
        	
        	var dto = {};
        	dto.isFull = $("#isFull").val();
        	dto.orgId = $("#orgId").val();
        	dto.changeList = changeList;
        	dto.detailList = detailList;
    		$.ajax({
   		        url:"<%=request.getContextPath()%>/relicsBureau/personnelChangeSave.do",
   		        data:JSON.stringify(dto),
   		        type:"POST",
   		     	dataType:"json", 
   		     	contentType : 'application/json;charset=utf-8',
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
		$('input,select,textarea',$('form[name="mesForm"]')).removeAttr("disabled");
		$("#museumName").attr('disabled','disabled');
		$("#parentOrgName").attr('disabled','disabled');
		$("#btn_edit").addClass("hideBtn");
		$("#btn_submit").removeClass("hideBtn");
		$(".add").show();
		$(".del").show();
		form.render('select');
    });
	var count1 = 0;
	function addRow1() {
		count1++;
		var str = 
			"<tr id='tr"+count1+"'>"
			+"<td>"  
			+"<a data='"+count1+"' class='deleteRow del'  href='javascript:;'><img src='"+projectName+"/back/images/delete.png'></a>"
			+"</td>"
			+"<td>"
			+"<input type='text' class='layui-input' name='pName' value=''>"
			+"</td>"
			+"<td>"
			+"<select  name='natures' class='typeOne' >"
			+"<option value='0' >请选择</option>"
			+"<option value='1' >在编</option>"
			+"<option value='2' >聘用</option>"
			+"</select>"
			+"</td>"
			+"<td>"
			+"<select  name='technicalTitle' class='typeOne' >"
			+"<option value='0' >请选择</option>"
			+"<option value='1' >高级职称</option>"
			+"<option value='2' >中级职称</option>"
			+"<option value='3' >初级职称</option>"
			+"<option value='4' >其他</option>"
			+"</select>"
			+"</td>"
			+"</tr>";
			
		return str;
	}
	
	var count2 = 0;
	function addRow2() {
		count2++;
		var str = 
			"<tr id='detailtr"+count2+"'>"
			+"<td>"  
			+"<a data='"+count2+"' class='delRow del'  href='javascript:;'><img src='"+projectName+"/back/images/delete.png'></a>"
			+"</td>"
			+"<td>"
			+"<input type='text' class='layui-input' name='detailName' value=''>"
			+"</td>"
			+"<td>"
			+"<select  name='sex' class='typeOne' >"
			+"<option value='1' >男</option>"
			+"<option value='0' >女</option>"
			+"</select>"
			+"</td>"
			+"<td>"
			+"<input type='text' class='layui-input birthday' name='birthday' value=''>"
			+"</td>"
			+"<td>"
			+"<select  name='education' class='typeOne' >"
			+"<option value='' >请选择</option>"
			+"<option value='1' >中专</option>"
			+"<option value='2' >大专</option>"
			+"<option value='3' >本科</option>"
			+"<option value='4' >硕士</option>"
			+"<option value='5' >博士</option>"
			+"<option value='6' >其他</option>"
			+"</select>"
			+"</td>"
			+"<td>"
			+"<select  name='academicDegree' class='typeOne' >"
			+"<option value='' >请选择</option>"
			+"<option value='1' >学士学位</option>"
			+"<option value='2' >硕士学位</option>"
			+"<option value='3' >博士学位</option>"
			+"</select>"
			+"</td>"
			+"<td>"
			+"<select  name='technicalTitle' class='typeOne' >"
			+"<option value='' >请选择</option>"
			+"<option value='1' >教授</option>"
			+"<option value='2' >副教授</option>"
			+"<option value='3' >高级技术工人</option>"
			+"<option value='4' >工程师</option>"
			+"<option value='5' >副研究馆员</option>"
			+"</select>"
			+"</td>"
			+"<td>"
			+"<input type='text' class='layui-input technicalTitleYear' name='technicalTitleYear' value=''>"
			+"</td>"
			+"<td>"
			+"<input type='number' min='1' max='100' step='1' class='layui-input' name='repairYear' value=''>"
			+"</td>"
			+"<td>"
			+"<select  name='repairSpecialty' class='typeOne' >"
			+"<option value='' >请选择</option>"
			+"<option value='1' >文物保护</option>"
			+"<option value='2' >文物专长</option>"
			+"<option value='3' >文物分析</option>"
			+"</select>"
			+"</td>"
			+"<td>"
			+"<input type='text' class='layui-input ' name='specialtyType' placeholder='玉石、青铜器' value=''>"
			+"</td>"
			+"<td>"
			+"<select  name='jobChanges' class='typeOne' >"
			+"<option value='0' >无变动</option>"
			+"<option value='1' >退休</option>"
			+"<option value='2' >调离</option>"
			+"</select>"
			+"</td>"
			+"</tr>";
		
		return str;
	}
	
	$("#add1").click(function() {
		var rowStr = addRow1();
		$("#tbody1").append(rowStr);
		form.render();
		
	})
	$("#add2").click(function() {
		var rowStr = addRow1();
		$("#tbody2").append(rowStr);
		form.render();
	})
	$("#add3").click(function() {
		var rowStr = addRow1();
		$("#tbody3").append(rowStr);
		form.render();
	})
	$("#add4").click(function() {
		var rowStr = addRow1();
		$("#tbody4").append(rowStr);
		form.render();
	})
	$("#add5").click(function() {
		var rowStr = addRow2();
		$("#tbody5").append(rowStr);
		form.render();
		lay('.birthday').each(function(){
			laydate.render({
		  	  elem:this,
		  	  type:'month',
		  	  trigger:'click'
		  	});
		});
		lay('.technicalTitleYear').each(function(){
	   	   laydate.render({
	   	      elem:this,
	   	      type:'year',
	   	      trigger:'click'
	   	   });
	     }); 
	})
	$(document).on('click', '.deleteRow', function() {
		deleteRow($(this));
	})
	$(document).on('click', '.delRow', function() {
		delRow($(this));
	})
	function deleteRow(result) {
		var data = result.attr("data");
		var trId = "tr"+data;
		$('#'+trId).remove();
	}
	function delRow(result) {
		var data = result.attr("data");
		var trId = "detailtr"+data;
		$('#'+trId).remove();
	}
	
	
	function isEmpty(obj){
	    if(typeof obj == "undefined" || obj == null || obj == "")	{
	        return true;
	    }else{
	        return false;
	    }
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
 
function deletePerson(id) {
	$.ajax({
		type:'post',
		url:"<%=request.getContextPath()%>/relicsBureau/deletePerson.do",
		data:{"id":id},
		success:function(result) {
			if (result.success == 1) {
				var trId = "tr" + id
				$('#'+trId).remove();
				top.layer.msg("删除成功！");
			} else {
				layer.msg("删除失败！",{icon:2});
			}
		}
	})
	
}
function deleteDetail(id) {
	$.ajax({
		type:'post',
		url:"<%=request.getContextPath()%>/relicsBureau/deleteDetail.do",
		data:{"id":id},
		success:function(result) {
			if (result.success == 1) {
				var trId = "tr" + id
				$('#'+trId).remove();
				top.layer.msg("删除成功！");
			} else {
				layer.msg("删除失败！",{icon:2});
			}
		}
	})
}

</script>
</body>
</html>