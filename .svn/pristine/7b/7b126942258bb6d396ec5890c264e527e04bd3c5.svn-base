<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>




<t:formvalid formid="formobj_1_" dialog="true" usePlugin="password" layout="table" action='tPProcessBusinessDController.do?${post_method}' tiptype="1">
<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief"  style="margin:0px;" >
  <ul class="layui-tab-title">
    <li class="" lay-id="FieldSet">字段属性</li>
    <li class="layui-this" lay-id="formSet">表单属性</li>
  </ul>
  <div class="layui-tab-content" id="tab_right"  style="overflow: auto;">
    <div class="layui-tab-item" id="help_9">
    <!-- <div class="layui-elem-quote" style="margin-top: 5px;padding: 5px;background-color: #ffffff;color: #009688;">
	  <p>主要属性配置</p>
	</div> -->
    <table id="FieldSetTable" style="border-spacing: 1px;border-collapse: inherit;" cellpadding="0" cellspacing="1" class="formtable">
		<tr><td style="width:40%;" align="center">请先选择控件</td>    </tr>
	</table>
	<!-- <div class="layui-elem-quote" style="margin-top: 10px;padding: 5px;background-color: #ffffff;color: #009688;">
	  <p>其他属性配置</p>
	</div> -->
	<table id="OtherSetTable" style="border-spacing: 1px;border-collapse: inherit;" cellpadding="0" cellspacing="1" class="formtable">
	
	</table>
	
    </div>
    <div class="layui-tab-item layui-show" id="help_10">
    <table id="FormDataTable" style="border-spacing: 1px;border-collapse: inherit;" cellpadding="0" cellspacing="1" class="formtable">
	</table>
    </div>
  </div>
</div>


</t:formvalid>

<script src="designPlug-in/design/designRight.src.js"></script>

<style type="text/css">

.hideTable{
display: none;
}
</style>

<script id="Tdemo" type="text/html">
{{#  layui.each(d, function(index, item_111_){ }}
		{{#  if(item_111_.sType === 'hidden'){ }}
			<input id="{{ item_111_.id }}" name="{{ item_111_.id }}" type="hidden"  class="inputxt"   value=''>
		{{#  }else{ }}
			<tr>
				<td style="width:40%;" align="right">
					<label class="Validform_label">
						{{ item_111_.name }}&nbsp;
					</label>
				</td>
				<td  class="value">
				{{#  if(item_111_.type === 'text'){ }}
				     	 <input id="{{ item_111_.id }}" 
		{{#  if(item_111_.sType === 'readonly'){ }}
			 readonly="readonly"
		{{#  }}}
name="{{ item_111_.id }}" type="text" style="width:80%" class="inputxt" value='{{ item_111_.defvalue }}' >
				{{#  }else if (item_111_.type === 'select'){ }}
						<select style="width: 80%;" name="{{ item_111_.id }}"  id="{{ item_111_.id }}">
							
							{{#  if(item_111_.selfFunction !== undefined){ }}
							{{# var slist_= eval(item_111_.selfFunction+"(item_111_.id)"); layui.each(slist_, function(index1, item1){ }}
								<option subdata="{{ item1.sub }}" value="{{ item1.va }}">{{ item1.name }}</option>
							{{#  }); }}
							{{#  }else{ }} 
									{{#  layui.each(item_111_.subs, function(index1, item1){ }}
									<option  value="{{ item1.va }}">{{ item1.name }}</option>
									{{#  }); }}
							{{#  } }} 
						</select>
{{#  if(item_111_.selfFunction !== undefined&&item_111_.selfFunction==='getSelectList'){ }}
<i class="layui-icon" onclick='jumpSet_()'>&#xe620;</i>
{{#  } }}
				{{#  }else if (item_111_.type === 'textarea'){ }}	
						<textarea id="{{ item_111_.id }}" name="{{ item_111_.id }}" type="text" style="width:80%;height:80px;" class="inputxt">{{ item_111_.defvalue }}</textarea>
				{{#  } }} 
				</td>
			</tr>
		{{#  } }} 

{{#  }); }}

</script>
