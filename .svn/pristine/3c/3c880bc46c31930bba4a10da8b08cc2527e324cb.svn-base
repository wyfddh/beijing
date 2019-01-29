<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>




<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief_left"  style="margin:0px;" >
  <ul class="layui-tab-title" >
    <li class="
    <c:if test="${type!='1'}">
			layui-this
		</c:if>
    " lay-id="KJ">控件</li>
    	<li class="layui-this" lay-id="ZD" style="display: none;">字段</li>
    <c:if test="${type=='1' }">
    	<li class="layui-this" lay-id="ZB">指标</li>
    </c:if>
  </ul> 
  <div class="layui-tab-content" id="tab_left" style="overflow: auto;background-color: white;">
		<div  class="left-component layui-tab-item  
		<c:if test="${type!='1'}">
			layui-show
		</c:if>
		  " >
		  
		  <c:if test="${type!='1'}">
			<fieldset class="layui-elem-field layui-field-title"
				style="margin: 10px 0px;">
				<legend style="font-size: 14px;">常用控件</legend>
			</fieldset>
			
			<ul class="site-doc-icon site-doc-anim">
			  <li onclick="left_add_new_widget_('text',this)">
				  <i class="design-icon-task_custom_text-box"></i> 
				  <p>单行文本</p>
			  </li>
			  <li onclick="left_add_new_widget_('textarea',this)">
				  <i class="design-icon-editor-font"></i>
				  <p>多行文本</p>
			  </li>
			  <li  onclick="left_add_new_widget_('list',this)">
				  <i class="design-icon-task_custom_btn_unfold"></i> 
				  <p>下拉选择</p>
			  </li>
			  <li  onclick="left_add_new_widget_('radio',this)">
				   <i class="design-icon-task_custom_checkbox"></i> 
				   <p>单选框</p>
			  </li>
			   <li  onclick="left_add_new_widget_('checkbox',this)">
				   <i class="design-icon-task-all"></i> 
				   <p>多选框</p>
			  </li>
			  <li  onclick="left_add_new_widget_('year',this)">
				   <i class="design-icon-task_custom_today"></i> 
				   <p>年</p>
			  </li>
			  <li  onclick="left_add_new_widget_('yymm',this)">
				   <i class="design-icon-calander"></i> 
				   <p>年月</p>
			  </li>
			  <li  onclick="left_add_new_widget_('date',this)">
				   <i class="design-icon-to-tocalendar"></i> 
				   <p>年月日</p>
			  </li>
			  <li  onclick="left_add_new_widget_('datetime',this)">
				   <i class="design-icon-task_custom_date_range"></i> 
				   <p>日期+时分秒</p>
			  </li>
			  <li  onclick="left_add_new_widget_('time',this)">
				   <i class="design-icon-task_custom_today"></i> 
				   <p>时分秒</p>
			  </li>
			  <li  onclick="left_add_new_widget_('number',this)">
				   <i class="design-icon-task_custom_looks_6"></i> 
				   <p>数字输入框</p>
			  </li>
			   <li  onclick="left_add_new_widget_('money',this)">
				   <i class="design-icon-task_custom_amount_money"></i> 
				   <p>金额</p>
			  </li>
			   <li  onclick="left_add_new_widget_('email',this)">
				   <i class="design-icon-chat-at"></i> 
				   <p>邮箱</p>
			  </li>
			  <li  onclick="left_add_new_widget_('phone',this)">
				   <i class="design-icon-tel"></i> 
				   <p>电话</p>
			  </li>
			  <li  onclick="left_add_new_widget_('mobile',this)">
				   <i class="design-icon-mobile"></i> 
				   <p>手机</p>
			  </li>
			  <li  onclick="left_add_new_widget_('personnel',this)">
				   <i class="design-icon-add-member22"></i> 
				   <p>人员选择</p>
			  </li>
			  <li  onclick="left_add_new_widget_('department',this)">
				   <i class="design-icon-organizational_structure"></i> 
				   <p>部门选择</p>
			  </li>
			</ul>
			</c:if>
			<fieldset class="layui-elem-field layui-field-title"
				style="margin: 10px 0px;">
				<legend style="font-size: 14px;">虚拟控件</legend>
			</fieldset>

			<ul class="site-doc-icon site-doc-anim">
			  <!-- <li onclick="left_add_new_widget_('v_formLabel',this)">
				  <i class="design-icon-file"></i> 
				  <p>文字标签</p>
			  </li> -->
			  <li onclick="left_add_new_widget_('v_formPic',this)">
				  <i class="design-icon-pic"></i> 
				  <p>图片</p>
			  </li>
			  <li onclick="left_add_new_widget_('v_formGroupingTitle',this)">
				  <i class="design-icon-task_custom_subsection"></i> 
				  <p>分组标题</p>
			  </li>
			  <li onclick="left_add_new_widget_('v_formDescribeText',this)">
				  <i class="design-icon-dynamic-empty"></i> 
				  <p>描述文字</p>
			  </li>
			  <li onclick="left_add_new_widget_('v_formFile',this)">
				  <i class="design-icon-task_custom_attachment"></i> 
				  <p> 附件</p>
			  </li>
			  <li onclick="left_add_new_widget_('v_formFileByGroup',this)">
				  <i class="design-icon-storage"></i> 
				  <p> 分类附件</p>
			  </li>
			  <li onclick="left_add_new_widget_('v_formTitle',this)">
				  <i class="design-icon-task_custom_form"></i> 
				  <p> 表单标题</p>
			  </li>
			  <c:if test="${type=='1' }"><!-- 只有在业务表单的时候需要显示该控件 -->
				  <li onclick="left_add_new_widget_('v_formButton',this)">
					  <i class="design-icon-chat-unline"></i> 
					  <p> 按钮</p>
				  </li>
				  <li onclick="left_add_new_widget_('v_formGroupButton',this)">
					  <i class="design-icon-link2"></i> 
					  <p> 按钮组</p>
				  </li>
			  </c:if>
			  <c:if test="${type!='1' }">
			  	  <li onclick="left_add_new_widget_('v_formSaveButton',this)">
					  <i class="design-icon-saveToKnowledge"></i> 
					  <p> 保存</p>
				  </li>
				  <li onclick="left_add_new_widget_('v_formSubmitButton',this)">
					  <i class="design-icon-project-success"></i> 
					  <p> 提交</p>
				  </li>
				  <li onclick="left_add_new_widget_('v_formCloseButton',this)">
					  <i class="design-icon-closeelement-bg-circle"></i> 
					  <p> 关闭</p>
				  </li>
			  </c:if>
			  
			  <li  onclick="left_add_new_widget_('region',this)">
				   <i class="design-icon-task_custom_pin_drop"></i> 
				   <p>地区</p>
			  </li>
			  <!-- <li onclick="left_add_new_widget_('v_formOffice',this)">
				  <i class="design-icon-task_custom_form"></i> 
				  <p> 正文</p>
			  </li>
			  <li onclick="left_add_new_widget_('v_formDetailed',this)">
				  <i class="design-icon-task_custom_form"></i> 
				  <p> 表单明细</p>
			  </li>
			  <li onclick="left_add_new_widget_('v_formDetailedTab',this)">
				  <i class="design-icon-task_custom_form"></i> 
				  <p> 多页签</p>
			  </li> -->
			</ul>
		</div>
			<div class="layui-tab-item layui-show " style="display: none;" >
		    	<div id="hideFormFieldDiv" style="display: none;"  >
		    	<table  style="border-spacing: 1px;border-collapse: inherit;" cellpadding="0" cellspacing="1" class="formtable">
					<tr><td style="width:40%;" align="center">已添加所有</td>    </tr>
				</table>
		    	</div>
		    </div>
	    <c:if test="${type=='1' }">
	    	 
		    <div class="layui-tab-item layui-show"  >
			    <div class="input-icon"style=" margin: 3px;"> 														
					<input type='text' id='searchtree' style="width:95%;" placeholder="请输入关键字搜索"  >
				</div>
		    	<ul id="zbFormFieldDiv" class="ztree"  >
		    	
		    	</ul>
		    </div>
	    </c:if>
  </div>
</div>
<!-- 隐藏表字段 表模板 -->
<script id="hideFormList" type="text/html">
{{#  layui.each(d, function(index, item_222_){ }}
	{{#  if(item_222_.isShow === 'N' || item_222_.isShow === '0'){ }}
	<div class='my-control' onclick="show_widget_(this,'{{ item_222_.id }}')"><i class="design-icon-control_point"></i> {{ item_222_.content }}</div>
	{{#  } }} 	
{{#  }); }}
</script>

<script src="designPlug-in/design/designLeft.src.js"></script>

<script type="text/javascript">
var type_="${type}",defineId_="${defineId}",businessCode_="${businessCode}",tableId_="${tableId}";
$(document).ready(function(){
	initzTree();
});

</script>


	