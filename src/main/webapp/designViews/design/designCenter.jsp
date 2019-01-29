<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>

<!-- 表单布局插件 
<script src="designPlug-in/jquery-plugs/gridstack/js/jquery.min.js" type="text/javascript"></script>
-->

<script type="text/javascript" src="designPlug-in/easyui/jquery.easyui.min.1.3.2.js"></script>

<script src="designPlug-in/jquery-plugs/gridstack/js/jquery-ui.min.js"></script>
<script src="designPlug-in/jquery-plugs/gridstack/js/bootstrap.min.js"></script>
<script src="designPlug-in/jquery-plugs/gridstack/js/lodash.min.js"></script>
<script src="designPlug-in/jquery-plugs/gridstack/js/knockout-min.js"></script>
<script src="designPlug-in/jquery-plugs/gridstack/js/gridstack.js"></script>
<script src="designPlug-in/design/design.${jsVersion }.js"></script>

<script src="designPlug-in/jquery-plugs/gridstack/js/jquery.contextMenu.min.js" type="text/javascript"></script>

<!-- 地区选择插件 -->
<script type="text/javascript" src="designPlug-in/SelCity/js/Popt.js"></script>
<script type="text/javascript" src="designPlug-in/SelCity/js/citySet.js"></script>
<link href="designPlug-in/SelCity/css/sel.css" rel="stylesheet" media="all">




<div  id="easyui_layout" class="easyui-layout" fit="true"  >
<div region="center" id="help_1" style="height:100%;" split="true">
		<div class="layui-tab layui-tab-brief" lay-filter="designMain"  style="margin:0px;height:100%;" >
			 <ul class="layui-tab-title">
			    <li class="layui-this" lay-id="help_1">表单设计区</li>
			    <li class=""  lay-id="help_2">隐藏字段区</li>
			 </ul>
			<div class="layui-tab-content" style="overflow:hidden;">
			  	<div class="layui-tab-item layui-show"   style="overflow:hidden;height:100%;background-color: white;" >
			  	<!-- 表单编辑区域 -->
					<div id="designMainGrid_show" style="overflow:hidden;height:100%;">
						<div class="htmleaf-container  layui-form"  lay-filter="designMainGrid_show_filter">
						    <div class="htmleaf-content bgcolor-3">
						        <div class="container-fluid">
						            <div data-bind="component: {name: 'designMainGrid', params: $data}">
						            </div>
						        </div>
						    </div>
						</div>
					</div>
			  </div>
			  <div class="layui-tab-item"   style="overflow:hidden;height:100%;background-color: white;">
			  <!-- 隐藏区域 -->
				<div id="designMainGrid_hide" style="overflow:hidden;height:100%;">
					<div class="htmleaf-container  layui-form"   lay-filter="designMainGrid_show_hide">
					    <div class="htmleaf-content bgcolor-3">
					        <div class="container-fluid">
					            <div data-bind="component: {name: 'designMainGrid_hide', params: $data}">
					            </div>
					        </div>
					    </div>
					</div>
				</div>
			  </div>
			</div>
		</div>
	</div>
	<c:if test="${type=='1'}">
	<div region="south" id="design_event"  title="事件设置" split="true" style="overflow-y:auto;height:254px;" >
		<div class="layui-tab layui-tab-brief"  lay-filter="jsTabBrief"  style="margin:0px;" >
				<ul class="layui-tab-title">
				     <li class="layui-this" lay-id="designJsEvent"  >事件绑定</li>
				     <li class="" lay-id="designJsPreview" >预览js</li>
				     <li class="" lay-id="designJsHelp" >帮助</li>
			   </ul>
			   <div class="layui-tab-content"  >
				  	<div class="layui-tab-item layui-show" style="overflow-y: hidden;" >
				  		<iframe scrolling="yes" frameborder="no" border="0" marginwidth="0" marginheight="0" style="height:100%;width:100%;" src=""  id="js_event">
				  		</iframe>
				  	</div>
				  	<div class="layui-tab-item"  style="overflow-y: hidden;" >
				  		<iframe scrolling="yes" frameborder="no" border="0" marginwidth="0" marginheight="0" style="height:100%;width:100%;" src=""  id="js_preview">
				  		</iframe>
				  	</div>
				  	<div class="layui-tab-item"  style="overflow-y: hidden;" >
				  		<iframe  scrolling="yes" frameborder="no" border="0" marginwidth="0" marginheight="0" style="height:100%;width:100%;" src=""  id="js_help">
				  		</iframe>
				  	</div>
				</div>
			</div>
	</div>
	</c:if>
</div>
<script src="designPlug-in/design/designCenter.src.js"></script>
<script type="text/javascript">

$(function() {
	$.bussTemplateId="${bussTemplateId }";
	$.versionNum="${versionNum }";
	$.businessCode="${businessCode }";
	$.isEdit=true;
	$.defineId="${defineId}";
	$.tableId="${tableId}";
	$.getDObject();//初始化中间组件相关信息
	$.widgets_=$.getDesignWidgets_(false);//获取表单编辑区域-控件相关信息
	$.widgets_hide=$.getDesignWidgets_hide(false);//获取隐藏区域-相关信息
	initializeTools_t = window.setInterval("initializeTools('${type}')",500);
	initCenter();
});


</script>
    

 
<style type="text/css">

.profile-user-info{
border: 1px solid #CCCCCC;
}
.select{
/* border:1px dotted #ff0404; */
}
</style>




