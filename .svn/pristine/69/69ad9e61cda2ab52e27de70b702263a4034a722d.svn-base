<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Hosting Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
        Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<title></title>

<script src='designPlug-in/ace/assets/js/jquery-2.0.3.min.js'></script>

<script src="designPlug-in/layer/layer.js"></script>
<script src="designPlug-in/layer/extend/layer.ext.js"></script>
<script src="designPlug-in/laypage/laypage.js"></script>
<link rel="stylesheet" href="designPlug-in/Validform/css/style.css" type="text/css">
<link href="designPlug-in/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
<script src="designPlug-in/avalon/avalon1.4.js"></script>
<script type="text/javascript" src="designPlug-in/My97DatePicker/WdatePicker.js"></script>

<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/plus.css"/>
<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/ace-rtl.min.css"/>
<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/ace.min.css"/>
<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/font-awesome.min-plus.css"/>
<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/plus-new.css"/>
<link rel="stylesheet" type="text/css" href="designPlug-in/ace/assets/css/my-plus-new.css"/>
<link rel="stylesheet" href="designPlug-in/jquery-plugs/gridstack/css/design-font.css">
<t:base type="layer"></t:base>
<link rel="stylesheet" href="designPlug-in/layui-2.3.0/css/public.css">
<script src="designPlug-in/tools/icmstools.js?1313"></script>
<script src="designPlug-in/layer/SZHLCommon.js"></script>
<script type="text/javascript" src="designPlug-in/jquery/Tdrag.js"></script>
<style type="text/css">
	/* ul li以横排显示 */
	/* 所有class为menu的div中的ul样式 */
	div.menu ul
	{
	    list-style:none; /* 去掉ul前面的符号 */
	    margin: 0px; /* 与外界元素的距离为0 */
	    padding: 0px; /* 与内部元素的距离为0 */
	    width: auto; /* 宽度根据元素内容调整 */
	}
	/* 所有class为menu的div中的ul中的li样式 */
	div.menu ul li
	{
	    float:left; /* 向左漂移，将竖排变为横排 */
	}
	
	div.menu ul li a.active
	{
	    background-color: #bfcbd6; /* 背景色 */
	    color: #465c71; /* 文字颜色 */
	    text-decoration: none; /* 不显示超链接下划线 */
	}
	
	/* 所有class为menu的div中的ul中的a样式(包括尚未点击的和点击过的样式) */
	div.menu ul li a, div.menu ul li a
	{
	    background-color: #465c71; /* 背景色 */
	    border: 1px #4e667d solid; /* 边框 */
	    color: #dde4ec; /* 文字颜色 */
	    display: block; /* 此元素将显示为块级元素，此元素前后会带有换行符 */
	    line-height: 1.35em; /* 行高 */
	    padding: 4px 20px; /* 内部填充的距离 */
	    text-decoration: none; /* 不显示超链接下划线 */
	    white-space: nowrap; /* 对于文本内的空白处，不会换行，文本会在在同一行上继续，直到遇到 <br> 标签为止。 */
	}
	/* 所有class为menu的div中的ul中的a样式(鼠标点击元素时的样式) */
	div.menu ul li a:active
	{
	    background-color: #bfcbd6; /* 背景色 */
	    color: #465c71; /* 文字颜色 */
	    text-decoration: none; /* 不显示超链接下划线 */
	}
	div.menuList ul li{
		margin-top: 2px;
	}
	.title-text {
    display: block;
    color: #000;
    background: #fff;
    margin: 10px 0px;
    border-left: 5px solid #0078fa;
    padding-left: 5px;
    height: 23px;
    padding-top: 2px;
}
</style>

</head>
<body onbeforeunload="refreshParentQuery(${oper!='add'?false:true});">
	<div class=" page-content my-icms" style="padding: 0 10px 10px;">
		<div id="left">
			<div class="menu col-md-12" >
				<ul>
					<li id="li1"><a href="javascript:void(0);" class="active">选择主表单</a></li>
					<li id="li2"><a href="javascript:void(0);">列表页</a></li>
					<li id="li3"><a href="javascript:void(0);">查询条件</a></li>
					<!-- <li><a href="javascript:void(0);">按钮</a></li> -->
				</ul>
			</div>
			<div id="yc1" class="row col-md-12" style="display: block;width: 100%;">
					<div class="bg1">
						<div class="row " id="detailCulHtml" style="padding: 12px;">
							<form method="post" action="#" class="registerform" id="cgform" >
							<input type="hidden" id="id" name="id" value="${bean.id}">
							<!-- 选择主菜单开始 -->
							<div id="demo1"  style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;display: block;">
								<div  style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
									<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
										<div class="profile-info-row">
											<div class="profile-info-name"><span class="rad">*</span>业务类型名称</div>
											<div class="profile-info-value">
												<input class="sl-inputtext-ss" itipmsg datatype="*" onfocus="Validformfocusin(this)" onblur="Validformfocusout(this)" style="width: 80%;" type="text" id="bussName" name="bussName" value="${bean.bussName}">
											</div>
										</div>
									</div>
								</div>
								<div  style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
									<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
										<div class="profile-info-row">
											<div class="profile-info-name">菜单显示名称</div>
											<div class="profile-info-value">
												<input class="sl-inputtext-ss" style="width: 80%;" type="text" id="menuName" name="menuName" value="${bean.menuName}">
											</div>
										</div>
									</div>
								</div>
								<div  style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
									<%-- <div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
										<div class="profile-info-row">
											<div class="profile-info-name"><span class="rad">*</span>业务表单</div>
											<div class="profile-info-value">
												<select style="width:100%;" datatype="/^\s*$/|*" id="defineId" name="defineId">
												  <option value="">请选择</option>
												  		<c:forEach items="${defineList}" var="define">
												  			<option value="${define.id}" <c:if test="${bean.defineId == define.id}">selected</c:if>>${define.define_name}</option>
												 		</c:forEach>
												 </select>
											</div>
										</div>
									</div> --%>
									<input type="hidden"  id="defineId" name="defineId" value="${bean.defineId }" title="引用此表单" >
									<iframe scrolling="yes"  frameborder="no" border="0" marginwidth="0" marginheight="0" style="height:400px;width:100%;" src="cgformBussController.do?getUseBussDefine&id=${bean.id}&defineId=${bean.defineId}"  id="useBussDefine">
				  					</iframe>
								</div>
							</div>
							<!-- 选择主菜单结束 -->
							<!-- 列表页开始 -->
							<div id="demo2"  style="display: none;">
								<div class=" col-md-12 title-text" >列表字段</div>
								<div class="col-md-12" >
									<div class="menuList" style="border-box;height: 20%;" id="menuList">
										<!-- <ul style="height: 38px;width:100%;">
											<li><button class="btn" type="button" onclick="prve()">上一步</button></li>
										</ul>
										<br>
										<ul style="height: 38px;width:100%;">
											<li><button class="btn" type="button" onclick="prve()">上一步</button></li>
										</ul> -->
									</div>
								</div>
								</br>
									<div class=" title-text" style="clear: both;" >列表数据权限</div>
									<div class="" >
									<input type="checkbox">&nbsp;上级查看下级
									</div>
									<div class=" title-text" >其他</div>
									<div class="" >
									<input type="checkbox" <c:if test="${bean.isPage == 'Y'}">checked</c:if>  id="isPage" name="isPage">&nbsp;添加分页&nbsp;&nbsp;
									<input type="checkbox" <c:if test="${bean.isCheckbox == 'Y'}">checked</c:if>  id="isCheckbox" name="isCheckbox">&nbsp;添加复选框&nbsp;&nbsp;
									<%-- <input type="checkbox" <c:if test="${bean.isSum == 'Y'}">checked</c:if>  id="isSum" name="isSum">&nbsp;添加计数&nbsp;&nbsp; --%>
									<input type="checkbox" <c:if test="${bean.isIndex == 'Y'}">checked</c:if> id="isIndex" name="isIndex">&nbsp;添加序号&nbsp;&nbsp;
									</div>
									<div class="" >
										每页显示条数：&nbsp;<input type="text" style="width:20%;" id="pageSize" name="pageSize" value="${bean.pageSize==null||bean.pageSize==''?'10':bean.pageSize}">
										每页条数的选择项：&nbsp;<input type="text"  style="width:20%;" id="limits" name="limits" value="${bean.limits==null||bean.limits==''?'10,20,30':bean.limits}">
										初始排序字段：&nbsp;<input type="text"  style="width:20%;" id="initSort" name="initSort" value="${bean.initSort}">
									</div>
									<div class="" >
										操作列宽：&nbsp;<input type="text" style="width:20%;" id="operationWidth" name="operationWidth" value="${bean.operationWidth==null||bean.operationWidth==''?'100':bean.operationWidth}">
										表格宽：&nbsp;<input type="text" style="width:20%;" id="tableWidth" placeholder="默认为自动适应" name="tableWidth" value="${bean.tableWidth}">
										高：&nbsp;<input type="text" style="width:20%;" id="tableHeight" placeholder="默认为自动适应"  name="tableHeight" value="${bean.tableHeight}">
									</div>
							</div>
							<!-- 列表页结束 -->
							<!-- 查询条件开始 -->
							<div id="demo3" class="col-md-12" style="display: none;">
							<div class="title-text" >选择要展示的查询条件</div>
							<div  >
								<div class="menuList" style="border-box;height: 20%;" id="queryList">
									<!-- <ul style="height: 38px;width:100%;">
										<li><button class="btn" type="button" onclick="prve()">上一步</button></li>
									</ul>
									<br>
									<ul style="height: 38px;width:100%;">
										<li><button class="btn" type="button" onclick="prve()">上一步</button></li>
									</ul> -->
								</div>
							</div>
							<div style="clear: both;" >
								<div class=" title-text" >其他</div>
								<div class="" >
									默认显示条件个数：&nbsp;<input type="text" style="width:20%;" id="initRow" name="initRow" value="${bean.initRow==null||bean.initRow==''?'2':bean.initRow}">
								</div>
							</div>
							</div>
							<!-- 查询条件结束 -->
							<!-- 按钮开始 -->
							<%-- <div>列表操作按钮</div>
							<div class="col-md-6" style="margin-bottom: 1px; padding-right: 0px; padding-left: 0px;">
								<div class="profile-user-info profile-user-info-striped" style="margin: 0 1px; border: 1px solid #CCCCCC;">
									<div class="profile-info-row">
										<div class="profile-info-name">发布后菜单显示名称</div>
										<div class="profile-info-value">
											<input class="sl-inputtext-ss" style="width: 80%;" type="text" id="menuName" name="menuName" value="${bean.menuName}">
										</div>
									</div>
								</div>
							</div>
							<div>全局按钮</div> --%>
							<!-- 按钮结束 -->
							</form>
						</div>
					</div>
			</div>
		</div>
		<div class="row">
			<div class="nav-btu" style="margin-bottom:20px;padding-right: 30px; box-sizing: border-box;">
				<ul>
					<li id="prev" style="display: none;"><button class="btn" type="button" onclick="prve()">上一步</button></li>
					<li id="next"><button class="btn" type="button" onclick="next()">下一步</button></li>
					<li id="saveFunc" style="display: none;"><button class="btn" type="button" onclick="save_1_()"><i class="fa fa-save btn-xs "></i> 保存</button></li>
					<li><button class="btn" type="button" onclick="closePage()"><i class="fa fa-times "></i> 关闭</button></li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="designPlug-in/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="designPlug-in/Validform/js/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript">
	
	//初始化附件拖拽
    function initDrapDrop(){
    	 /* $("#selectUl li").Tdrag({
    	        scope:"#selectUl",
    	        pos:true,
    	        dragChange:true
    	    }); */
    }
	
	
	
	
	
	
		var step=1;
		$(document).ready(function(){
			InitValidform("detailCulHtml");
			initDrapDrop();
		});
		//下一步
		function next(){
			var bussName = $("#bussName").val();
			if(bussName==''||bussName==null){
				parent.layer.msg("请填写业务类型名称！", {icon: 5});
				return false;
			}
			var defineId = $("#defineId").val();
			if(defineId==''||defineId==null){
				parent.layer.msg("请选择业务表单！", {icon: 5});
				return false;
			}
			$("#li"+step).find('a').removeClass('active');
			$("#demo"+step).hide();
			step = step+1;
			$("#li"+step).find('a').addClass('active');
			$("#demo"+step).show();
			if(step==2){
				$("#prev").show();
				var bussId = $("#id").val();
				if(bussId==''||bussId==null){
					doSaveOrUpdate('doAdd',step);
				}else{
					doSaveOrUpdate('doUpdate',step);
				}
				getLgField(1,"cgform_buss_list");
				bussId = $("#id").val();
				$("#useBussDefine").attr("src","cgformBussController.do?getUseBussDefine&id="+bussId);
			}else if(step==3){
				$("#next").hide();
				$("#saveFunc").show();
				getLgField(2,"cgform_buss_query");
				doSaveOrUpdate('doUpdate',step);
			}
		};
		//保存或更新数据
		function doSaveOrUpdate(type,step){
			var form1= $("form").serialize();
			console.log(form1);
			$.ajax({
				async: false,
				url: "<%=path %>/cgformBussController.do?"+type+"&step="+step,
				type: "POST",dataType: "json",//async: false,
				data: form1,
				success: function(data) {
					if(data!=null){
						if(data.success){
							if(type=="doAdd"){
								$("#id").val(data.obj.id);
							}
						}
					}
				}
			});
		}
		
		//上一步
		function prve(){
			$("#li"+step).find('a').removeClass('active');
			$("#demo"+step).hide();
			step = step-1;
			$("#li"+step).find('a').addClass('active');
			$("#demo"+step).show();
			if(step==2){
				$("#saveFunc").hide();
				$("#next").show();
			}else if(step==1){
				$("#prev").hide();
			}
		}
		
		//获取字段信息列表
		function getLgField(flag,tableName){
			var bussId = $("#id").val();
			$.ajax({
				async: false,
				url: "<%=path %>/cgformBussController.do?getLgFieldList",
				type: "POST",dataType: "json",//async: false,
				data: {tableName:tableName,bussId:bussId},
				success: function(data) {
					if(data!=null){
						var lgFieldList = data.obj;
						var fieldHtml = '';
						var fieldStartHtml = '<div style="clear: both;" >已选字段：</div><div  style="clear: both;"><ul style="height: 38px;width:100%;" id="selectUl">';
						var selectButtonHtml = '';
						var fieldMiddleHtml = '</ul></div><div style="clear: both;" >可选字段：</div><div style="clear: both;" ><ul style="height: 38px;width:100%;">';
						var buttonHtml = '';
						var fieldEndHtml = '</ul></div>';
						for(var i=0;i<lgFieldList.length;i++){
							var jsonData = lgFieldList[i];
							if(jsonData.bussListId!=''&&jsonData.bussListId!=null){
								selectButtonHtml += '<li style="width:100px;text-align: left;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;" class="btn" onclick="clickFieldBut(this,'+flag+',\''+jsonData.content+'\')" ><input type="hidden" value="'+jsonData.bussListId+'" lang="select">'+jsonData.content;
								if(jsonData.field_name!='id'){
									selectButtonHtml +='<a type="remove" onclick="deleteSelectFieldBut(this,'+flag+');event.stopPropagation();" id="del_frmb-fld-1" class="design-icon-closeelement-bg-circle" style="color: red;background-color: white;border-radius: 50%;position: absolute;'+
								    'top: 0px;'+
								    'right: -5px;'+
								    'z-index: 2;'+
								    '" title="删除"></a>';
								}
							    selectButtonHtml +='</li>';
							}else{
								buttonHtml += '<li style="width:100px;text-align: left;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;" class="btn" onclick="clickFieldBut(this,'+flag+',\''+jsonData.content+'\')" ><input type="hidden" value="'+jsonData.id+'" lang="unselect">'+jsonData.content+'</li>';
							}
						}
						fieldHtml = fieldStartHtml+selectButtonHtml+fieldMiddleHtml+buttonHtml+fieldEndHtml;
						if(flag==1){
							$("#menuList").html(fieldHtml);
						}else{
							$("#queryList").html(fieldHtml);
						}
						$("#selectUl").find("li").css("background-color","#7996f7");
					}
				}
			});
			initDrapDrop();
		}
		
		//删除已选择按钮
		function deleteSelectFieldBut(obj,flag){
			var id=$(obj).siblings('input').val();
			var url = "";
			if(flag==1){
				url = "<%=path %>/cgformBussListController.do?doDel";
			}else{
				url = "<%=path %>/cgformBussQueryController.do?doDel";
			}
			myConfirmDialog("您确定要删除吗？", function(){
				$.ajax({
					url: url,
					type: "POST",dataType: "json",//async: false,
					data: {id: id},
					success: function(data) {
						if(data!=null){
							layer.msg(data.msg, {icon: 1});
							if(flag==1){
								getLgField(1,"cgform_buss_list");
							}else{
								getLgField(2,"cgform_buss_query");
							}
						}
					}
				});
				}, function(){ return true; }, "");
		}
		
			//点击按钮
			function clickFieldBut(obj,flag,content){
			  var selectType = $(obj).find('input').attr('lang');
			  var url ='';
			  var sUrl = '';
			  if(flag==1){
			  	url="<%=path %>/cgformBussListController.do?getLgFieldConfig&bussId="+$("#id").val();
			  	sUrl= "cgformBussListController.do?";
			  }else{
			  	url="<%=path %>/cgformBussQueryController.do?getLgFieldConfig&bussId="+$("#id").val();
			  	sUrl= "cgformBussQueryController.do?";
			  }
			  var defineLgId = $(obj).find('input').val();
			  var pageTile = '';
			  if(selectType=='unselect'){
				  url = url+"&defineId="+defineLgId;
				  pageTile = "添加字段配置";
				  sUrl =sUrl+"doAdd";
			  }else{
				  url = url+"&id="+defineLgId;
				  pageTile = "编辑字段配置";
				  sUrl =sUrl+"doUpdate";
			  }
			  layer.open({
				  type: 2,
				  title: pageTile+"-"+content,
				  shadeClose: false,//点击背景不关闭
				  scrollbar: false,//滚动条已锁
				  resize:true,//是否允许放大缩小
				  content: url,
				  area: ['600px', '350px'],
				  maxmin: true,
				  btn: ['保存','关闭'],
		 		  yes: function(index,layero){
		 			  var form1= layer.getChildFrame('form', index);;
		 				console.log($(form1).serialize());
	 					$.ajax({
	 						url: sUrl,
	 						type: "POST",
	 						dataType: "json",
	 						data: $(form1).serialize(),
	 						success: function(data) {
	 							if(data!=null){
	 								layer.close(index);
	 								if(flag==1){
	 									getLgField(1,"cgform_buss_list");
	 								}else{
	 									getLgField(2,"cgform_buss_query");
	 								}
	 							}
	 						},
	 						error: function(){
	 						}
	 					});
		 		   },
		 		   cancel: function(index,layero){
		 			  layer.close(index);
		 		   }
			});
		};
		
		function save_1_(){
			if(!myValidform.check()){ return false; }
			doSaveOrUpdate('doUpdate','3');
			parent.layer.msg("保存成功！", {icon: 1});
			parent.layuiTableReload("${bussCode }",{});
			closePage();
		}
		function closePage(){
			parent.layer.closeAll("iframe");
		}
		
		
		
		
		
	</script>
</body>
</html>

<script type="text/javascript" src="designPlug-in/Validform/js/Validform_v5.3.2_min.js"></script>
<script src="designPlug-in/ace/assets/js/jquery.gritter.min.js"></script>
