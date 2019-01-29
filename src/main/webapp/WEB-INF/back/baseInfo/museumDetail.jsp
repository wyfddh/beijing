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
 	padding:20px;
 }
 .per{
 	width: 96px;
	height: 34px;
	background-color: #009688;
	border-radius: 17px;
 }
 .name_class{
	font-size: 16px;
	color: #333333;
	font-weight: 700;
 }
 .box-b {
	height: 230px;
	background-color: #ffffff;
	box-shadow: -2px 1px 20px 0px rgba(63, 72, 80, 0.2);
	border-radius: 10px;
}
.box-a{
padding-top:60px;
padding-left:60px;
padding-right:60px;
}
.box-c{
    text-align: center;
    padding-top: 25px;
}
.box-d{
    text-align: center;
    padding-top: 10px;
}
.ref-a{
	border-right: 1px solid #0099ff;
	color: #0099ff;
}
.ref-b{
	color: #0099ff;
}
.span-one{
	color: #303236;
	font-size: 18px;
}
.span-two{
	color: #666666;
	font-size: 14px;
}
.span-three{
	color: #e04d31;
	font-size: 14px;
}
.span-four{
	color: #34bfa3;
	font-size: 14px;
}
.pt_30{
	padding-top:30px;
}
</style>
<title>博物馆详情页</title>
</head>
<body class="childrenBody">
	<div>
		<form class="layui-form" role="form"  id="myform" name="myform">
		<input type="hidden" id="orgType" name="orgType" value="${orgType }">
	    <div class="layui-row pt_30">
	    		<div class="layui-col-md5" style="padding-left:40px;">
	    			<label class="layui-form-label name_class" style="width:auto !important">${result.museumName}</label>
	    			 <label class="layui-form-label" style="width: 110px;">资料完成度：</label>
		    			 <c:if test="${'1' eq result.allDataPer}"><span style="display:block;padding: 9px 15px;" class="span-four">已完成</span></c:if>
		    			 <c:if test="${'1' ne result.allDataPer}"><span style="display:block;padding: 9px 15px;" class="span-three">未完成</span></c:if>
	            </div>
	            <div class="layui-col-md4">&nbsp;</div>
	            <div class="layui-col-md3">
	            	<div class="layui-col-md11">
		            	<div class="layui-row">
			            	<span style="text-align:center;display:block;">
			            		<c:if test="${'1' eq level}"><a id="btn_save" type="button" lay-submit lay-filter="saveDetail" class="layui-btn">提交</a></c:if>
			            		<c:if test="${'1' ne level || '0' eq orgId}">
			            		<!-- 超级管理员可以看到返回按钮 -->
			            			<a id="btn_back" type="button" class="layui-btn">返回</a>
			            		</c:if>
			                </span>
		            	</div>
		            	<div class="layui-row" style="padding-top:10px;">
		            		<span style="text-align:center;display:block;">${tipMessage }</span>
		            	</div>
	            	</div>
	            </div>
	    </div>
	    <c:if test="${'3' eq orgType}">
	    <div class="layui-row box-a" >
	    	<div class="layui-col-md2 box-b">
	    		<div class="box-c">
	    			<a><img src="<%=request.getContextPath() %>/back/images/detail_1.png" alt=""></a>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-one">基本信息</span>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-two">资料完成度：</span>&nbsp;
	    			<c:if test="${'1' eq result.basePer}"><span class="span-four">已完成</span></c:if>
	    			<c:if test="${'1' ne result.basePer}"><span class="span-three">未完成</span></c:if>
	    		</div>
	    		<div class="box-d">
	    			<a class="ref-a" href="<%=request.getContextPath()%>/museuminfo/museumBaseInfo.do?museumId=${result.museumId}&museumName=${result.museumName}">
	    			<c:if test="${'1' eq level}">编辑资料</c:if>
	    			 <c:if test="${'1' ne level}">查看资料</c:if>
	    			</a>&nbsp;
	    			<a class="ref-b"  href="javascript:editRecord('${result.museumId}','base','博物馆基本资料修改记录');">修改记录</a>
	    		</div>
	    	</div>
	    	<div class="layui-col-md1" >&nbsp;</div>
	    	<div class="layui-col-md2 box-b">
	    		<div class="box-c">
	    			<a><img src="<%=request.getContextPath() %>/back/images/detail_2.png" alt=""></a>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-one">馆舍建筑与基础设施</span>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-two">资料完成度：</span>&nbsp;
	    			<c:if test="${'1' eq result.housePer}"><span class="span-four">已完成</span></c:if>
	    			<c:if test="${'1' ne result.housePer}"><span class="span-three">未完成</span></c:if>
	    		</div>
	    		<div class="box-d">
	    			<a class="ref-b" href="<%=request.getContextPath()%>/museumHouseBuilding/list.do?museumId=${result.museumId}&museumName=${result.museumName}">
	    			  <c:if test="${'1' eq level}">编辑资料</c:if>
	    			 <c:if test="${'1' ne level}">查看资料</c:if>
	    			</a>&nbsp;
<%-- 	    			<a class="ref-b"  href="javascript:editRecord('${result.museumId}','build','馆舍建筑情况修改记录');">修改记录</a> --%>
	    		</div>
	    	</div>
	    	<div class="layui-col-md1" >&nbsp;</div>
	    	<div class="layui-col-md2 box-b">
	    		<div class="box-c">
	    			<a><img src="<%=request.getContextPath() %>/back/images/detail_5.png" alt=""></a>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-one">机构人员信息</span>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-two">资料完成度：</span>&nbsp;
	    			<c:if test="${'1' eq result.personPer}"><span class="span-four">已完成</span></c:if>
	    			<c:if test="${'1' ne result.personPer}"><span class="span-three">未完成</span></c:if>
	    		</div>
	    		<div class="box-d">
	    			<a class="ref-b" href="<%=request.getContextPath()%>/museumPerson/goList.do?museumId=${result.museumId}">
	    			  <c:if test="${'1' eq level}">编辑资料</c:if>
	    			 <c:if test="${'1' ne level}">查看资料</c:if>
	    			</a>
	    		</div>
	    	</div>
	    	
	    	<div class="layui-col-md1">&nbsp;</div>
	    	<div class="layui-col-md2 box-b">
	    		<div class="box-c">
	    			<a><img src="<%=request.getContextPath() %>/back/images/digitization.png" alt=""></a>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-one">信息智能化建设</span>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-two">资料完成度：</span>&nbsp;
	    			<c:if test="${'1' eq result.digitizationPer}"><span class="span-four">已完成</span></c:if>
	    			<c:if test="${'1' ne result.digitizationPer}"><span class="span-three">未完成</span></c:if>
	    		</div>
	    		<div class="box-d">
	    			<a class="ref-b" href="<%=request.getContextPath()%>/museumDigitization/form.do?museumId=${result.museumId}">
	    			  <c:if test="${'1' eq level}">编辑资料</c:if>
	    			 <c:if test="${'1' ne level}">查看资料</c:if>
	    			</a>&nbsp;
<%-- 	    			<a class="ref-b"  href="javascript:editRecord('${result.museumId}','digitization','藏品数字化程度修改记录');" >修改记录</a> --%>
	    		</div>
	    	</div>
	    	
	    </div>
	    
	    <div class="layui-row box-a" >
	    	<div class="layui-col-md2 box-b">
	    		<div class="box-c">
	    			<a><img src="<%=request.getContextPath() %>/back/images/detail_3.png" alt=""></a>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-one">经费来源与保障</span>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-two">资料完成度：</span>&nbsp;
	    			<c:if test="${'1' eq result.costPer}"><span class="span-four">已完成</span></c:if>
	    			<c:if test="${'1' ne result.costPer}"><span class="span-three">未完成</span></c:if>
	    		</div>
	    		<div class="box-d">
	    			<a class="ref-b" href="<%=request.getContextPath()%>/museumCost/list.do?museumId=${result.museumId}">
	    			 <c:if test="${'1' eq level}">编辑资料</c:if>
	    			 <c:if test="${'1' ne level}">查看资料</c:if>
	    			</a>
	    		</div>
	    	</div>
	    	<div class="layui-col-md1" >&nbsp;</div>
	    	<div class="layui-col-md2 box-b">
	    		<div class="box-c">
	    			<a><img src="<%=request.getContextPath() %>/back/images/collection.png" alt=""></a>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-one">藏品管理与科学研究</span>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-two">资料完成度：</span>&nbsp;
	    			<c:if test="${'1' eq result.collectionPer}"><span class="span-four">已完成</span></c:if>
	    			<c:if test="${'1' ne result.collectionPer}"><span class="span-three">未完成</span></c:if>
	    		</div>
	    		<div class="box-d">
	    			<a class="ref-b" href="<%=request.getContextPath()%>/colletionInfo/form.do?museumId=${result.museumId}">
	    			<c:if test="${'1' eq level}">编辑资料</c:if>
	    			 <c:if test="${'1' ne level}">查看资料</c:if>
	    			</a>&nbsp;
<%-- 	    			<a class="ref-b"  href="javascript:editRecord('${result.museumId}','collection','藏品管理与科学研究修改记录');" >修改记录</a> --%>
	    		</div>
	    	</div>
	    	<div class="layui-col-md1" >&nbsp;</div>
	    	<div class="layui-col-md2 box-b">
	    		<div class="box-c">
	    			<a><img src="<%=request.getContextPath() %>/back/images/detail_4.png" alt=""></a>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-one">陈列展览与社会服务</span>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-two">资料完成度：</span>&nbsp;
	    			<c:if test="${'1' eq result.servicePer}"><span class="span-four">已完成</span></c:if>
	    			<c:if test="${'1' ne result.servicePer}"><span class="span-three">未完成</span></c:if>
	    		</div>
	    		<div class="box-d">
	    			<a class="ref-b" href="<%=request.getContextPath()%>/museumPublicService/form.do?museumId=${result.museumId}">
	    			<c:if test="${'1' eq level}">编辑资料</c:if>
	    			<c:if test="${'1' ne level}">查看资料</c:if>
	    			</a>&nbsp;
<%-- 	    			<a class="ref-b"  href="javascript:editRecord('${result.museumId}','service','陈列展览与社会服务修改记录');">修改记录</a> --%>
	    		</div>
	    	</div>
	    	<div class="layui-col-md1">&nbsp;</div>
	    	<div class="layui-col-md2 box-b">
	    		<div class="box-c">
	    			<a><img src="<%=request.getContextPath() %>/back/images/detail_6.png" alt=""></a>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-one">安全保障</span>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-two">资料完成度：</span>&nbsp;
	    			<c:if test="${'1' eq result.safePer}"><span class="span-four">已完成</span></c:if>
	    			<c:if test="${'1' ne result.safePer}"><span class="span-three">未完成</span></c:if>
	    		</div>
	    		<div class="box-d">
	    			<a class="ref-b" href="<%=request.getContextPath()%>/safeEnsure/form.do?museumId=${result.museumId}">
	    			 <c:if test="${'1' eq level}">编辑资料</c:if>
	    			 <c:if test="${'1' ne level}">查看资料</c:if>
	    			</a>&nbsp;
<%-- 	    			<a class="ref-b"  href="javascript:editRecord('${result.museumId}','safe','安全保障修改记录');">修改记录</a> --%>
	    		</div>
	    	</div>
	    	
	    </div>
	    </c:if>
	    <c:if test="${'4' eq orgType}">
	    	<div class="layui-row box-a" >
	    	<div class="layui-col-md2 box-b">
	    		<div class="box-c">
	    			<a><img src="<%=request.getContextPath() %>/back/images/detail_1.png" alt=""></a>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-one">基本信息</span>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-two">资料完成度：</span>&nbsp;
	    			<c:if test="${'1' eq result.basePer}"><span class="span-four">已完成</span></c:if>
	    			<c:if test="${'1' ne result.basePer}"><span class="span-three">未完成</span></c:if>
	    		</div>
	    		<div class="box-d">
	    			<a class="ref-a" href="<%=request.getContextPath()%>/relicsBureau/relicsBureauInfo.do?relicsBureauId=${result.museumId}&relicsBureauName=${result.museumName}">
	    			<c:if test="${'1' eq level}">编辑资料</c:if>
	    			 <c:if test="${'1' ne level}">查看资料</c:if>
	    			</a>&nbsp;
	    			<a class="ref-b"  href="javascript:editRecord('${result.museumId}','relicsBureau','文物修复单位基本资料修改记录');">修改记录</a>
	    		</div>
	    	</div>
	    	<div class="layui-col-md3" >&nbsp;</div>
	    	<div class="layui-col-md2 box-b">
	    		<div class="box-c">
	    			<a><img src="<%=request.getContextPath() %>/back/images/detail_2.png" alt=""></a>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-one">主要技术人员</span>
	    		</div>
	    		<div class="box-c">
	    			<%-- <span class="span-two">资料完成度：</span>&nbsp;.
	    			<c:if test="${'1' eq result.personPer}"><span class="span-four">已完成</span></c:if>
	    			<c:if test="${'1' ne result.personPer}"><span class="span-three">未完成</span></c:if> --%>
	    		</div>
	    		<div class="box-d">
	    			<a class="ref-b" href="<%=request.getContextPath()%>/relicsBureau/list.do?relicsBureauId=${result.museumId}&relicsBureauName=${result.museumName}">
	    			  <c:if test="${'1' eq level}">编辑资料</c:if>
	    			 <c:if test="${'1' ne level}">查看资料</c:if>
	    			</a>
<%-- 	    			<a class="ref-b"  href="javascript:editRecord('${result.museumId}','relicsBureauPerson','文物修复单位机构人员修改记录');">修改记录</a> --%>
	    		</div>
	    	</div>
	    	<div class="layui-col-md3" >&nbsp;</div>
	    	<div class="layui-col-md2 box-b">
	    		<div class="box-c">
	    			<a><img src="<%=request.getContextPath() %>/back/images/detail_5.png" alt=""></a>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-one">主要仪器设备</span>
	    		</div>
	    		<div class="box-c">
	    			<%-- <span class="span-two">资料完成度：</span>&nbsp;
	    			<c:if test="${'1' eq result.digitizationPer}"><span class="span-four">已完成</span></c:if>
	    			<c:if test="${'1' ne result.digitizationPer}"><span class="span-three">未完成</span></c:if> --%>
	    		</div>
	    		<div class="box-d">
	    			<a class="ref-b" href="<%=request.getContextPath()%>/relicsBureau/goList.do?relicsBureauId=${result.museumId}">
	    			  <c:if test="${'1' eq level}">编辑资料</c:if>
	    			 <c:if test="${'1' ne level}">查看资料</c:if>
	    			</a>
	    		</div>
	    	</div>
	    </div>
	    
	    <div class="layui-row box-a" >
	    	<div class="layui-col-md2 box-b">
	    		<div class="box-c">
	    			<a><img src="<%=request.getContextPath() %>/back/images/u159.png" alt=""></a>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-one">文物保管场所安全条件</span>
	    		</div>
	    		<div class="box-c">
	    		</div>
	    		<div class="box-d">
	    			<a class="ref-b" href="<%=request.getContextPath()%>/relicsBureau/safeFileList.do?relicsBureauId=${result.museumId}">
	    			<c:if test="${'1' eq level}">编辑资料</c:if>
	    			 <c:if test="${'1' ne level}">查看资料</c:if>
	    			</a>
	    		</div>
	    	</div>
	    	<div class="layui-col-md3" >&nbsp;</div>
	    	<div class="layui-col-md2 box-b">
	    		<div class="box-c">
	    			<a><img src="<%=request.getContextPath() %>/back/images/u158.png" alt=""></a>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-one">主要管理制度和质量管理体系</span>
	    		</div>
	    		<div class="box-c">
	    		</div>
	    		<div class="box-d">
	    			<a class="ref-b" href="<%=request.getContextPath()%>/relicsBureau/manageFileList.do?relicsBureauId=${result.museumId}">
	    			  <c:if test="${'1' eq level}">编辑资料</c:if>
	    			 <c:if test="${'1' ne level}">查看资料</c:if>
	    			</a>
	    		</div>
	    	</div>
	    </div>
	    
	    </c:if>
	    <c:if test="${'5' eq orgType}">
	    	<div class="layui-col-md2 box-b">
	    		<div class="box-c">
	    			<a><img src="<%=request.getContextPath() %>/back/images/detail_1.png" alt=""></a>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-one">基本信息</span>
	    		</div>
	    		<div class="box-c">
	    			<span class="span-two">资料完成度：</span>&nbsp;
	    			<c:if test="${'1' eq result.basePer}"><span class="span-four">已完成</span></c:if>
	    			<c:if test="${'1' ne result.basePer}"><span class="span-three">未完成</span></c:if>
	    		</div>
	    		<div class="box-d">
	    			<a class="ref-a" href="<%=request.getContextPath()%>/relicsUnitInfo/relicsUnitInfo.do?relicsUnitId=${result.museumId}&relicsUnitName=${result.museumName}">
	    			<c:if test="${'1' eq level}">编辑资料</c:if>
	    			 <c:if test="${'1' ne level}">查看资料</c:if>
	    			</a>&nbsp;
	    			<a class="ref-b"  href="javascript:editRecord('${result.museumId}','relicsUnit','文物收藏单位基本资料修改记录');">修改记录</a>
	    		</div>
	    	</div>
	    </c:if>
	    <input type="hidden" name="museumId" id="museumId" value="${result.museumId}">
	    </form>
	</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/common.js"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
layui.use(['form','laydate'], function() {
	var form = layui.form,
	layer = layui.layer,
	$=layui.jquery;

	//点击返回按钮
    $("#btn_back").click(function(){
    	layer.confirm('您确定要退出本页面吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.closeAll();  //关闭弹出层
            window.location.href="<%=request.getContextPath()%>/museuminfo/museumList.do";
//          window.history.back(-1);  //关闭弹出层
        }, function(){
            layer.closeAll();  //关闭弹出层
        });
    });
    
    form.on('submit(saveDetail)', function(data){
    	var loading; 
    	var orgType = $("#orgType").val();
    	var urlStr = "<%=request.getContextPath()%>/museuminfo/saveDetail.do";
    	if(orgType == "4"){
    		urlStr = "<%=request.getContextPath()%>/relicsBureau/saveDetail.do";
    	}else if(orgType == "5"){
    		urlStr = "<%=request.getContextPath()%>/relicsUnitInfo/saveDetail.do";
    	}
    	$.ajax({
            url:urlStr,
            data:{"museumId":$("#museumId").val()},
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
                    layer.msg("保存失败！",{icon: 2});
                 }
            },
            error:function(msg){
                layer.close(loading);
                layer.msg("保存失败！",{icon: 2});
            }
      });
    });
}) 
    function editRecord(museumId,type,title) {
		var a = layer.open({
            type: 2,
            title: title,
            shadeClose: true,
            shade: 0.5,
            maxmin: false, //开启最大化最小化按钮
            area: ['1000px', '720px'],
            content: ['<%=request.getContextPath() %>/eidtRecord/goList.do?museumId='+ museumId +'&type='+ type,'yes'],
            success:function(layero, index){
            	resizeLayer(index);
            }
        });
// 		layer.full(a);

	}
</script>
</body>
</html>