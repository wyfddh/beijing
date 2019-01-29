<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/designContext/mytags.jsp"%>
<!DOCTYPE html >
<html >
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<t:base type="jquery,easyui,DatePicker,layer"></t:base>
<link rel="stylesheet" href="designPlug-in/Validform/css/tablefrom.css" type="text/css">
</head>
<body >
<form name="eventJs" id="eventJs" action="">
<input type="hidden"  id="fieldName" name="fieldName"  value="${fieldName}">
<input type="hidden"  id="businessCode" name="businessCode"  value="${businessCode}">

<input type="hidden"  id="jsJson.id" name="jsJson.id"  value="${id}">
<c:if test="${id!=''}">
<div type="button" class="layui-btn layui-btn-normal" onclick="saveEventJs()" >
	<i class="icon-save"></i>
	保存
</div>
    <table  style="border-spacing: 1px;border-collapse: inherit;" cellpadding="0" cellspacing="1" class="formtable">
    <tr><td style="width:15%;" align="right">当前选择控件</td>
    <td align="left"  class="value">
    <select id="jsJson.dqkj" name="jsJson.dqkj" onchange="dqkjChange(this)" ></select>
    </td>
        </tr>
		<tr >
			<td style="width:15%;" align="right">单击事件&nbsp;</td>
			<td style="width:85%;" align="left"  class="value">
			&nbsp;<input type="checkbox"  id="jsJson.dj_input" name="jsJson.dj_input" title="添加单击事件" value="Y" ${jsJson.dj_input=='Y'?'checked':'' } >
			该事件执行<select id="jsJson.dj_select" name="jsJson.dj_select" >
			 <option value="s_true"  ${jsJson.dj_select=='s_true'?'selected':'' }  >保存</option>
<%-- 			 <option value="s_true_r" ${jsJson.dj_select=='s_true_r'?'selected':'' } > 保存并刷新</option> --%>
			 <option value="s_true_r" ${jsJson.dj_select=='s_true_r'?'selected':'' } > 保存并关闭</option>
			 <option value="p_s_true" ${jsJson.dj_select=='p_s_true'?'selected':'' } > 父窗口执行保存</option>
			 <option value="p_s_true_r" ${jsJson.dj_select=='p_s_true_r'?'selected':'' } > 父窗口执行保存并刷新</option>
			 <option value="w_close" ${jsJson.dj_select=='w_close'?'selected':'' } > 窗口关闭</option>
			 <option value="custom" ${jsJson.dj_select=='custom'?'selected':'' } >自定义</option>
			</select>方法
			&nbsp;
			&nbsp;事件描述：<input type="text"  id="jsJson.dj_remark" name="jsJson.dj_remark" width="150px"  value="${jsJson.dj_remark}" >
			
			<br>$("[id='${id}']").click(function(){
			<textarea id="jsJson.dj_textarea" name="jsJson.dj_textarea" style="height:50px;width:90%">${jsJson.dj_textarea}</textarea>
			<br>
			});
			</td>
		</tr>
		<tr>
			<td style="width:15%;" align="right">双击事件&nbsp;</td>
			<td style="width:85%;" align="left"  class="value">
			&nbsp;<input type="checkbox"  id="jsJson.sj_input" name="jsJson.sj_input" title="添加双击事件" value="Y"  ${jsJson.sj_input=='Y'?'checked':'' }>
			该事件执行<select id="jsJson.sj_select" name="jsJson.sj_select" >
			 <option value="s_true"  ${jsJson.sj_select=='s_true'?'selected':'' }  >保存</option>
<%-- 			 <option value="s_true_r" ${jsJson.sj_select=='s_true_r'?'selected':'' } > 保存并刷新</option> --%>
			 <option value="s_true_r" ${jsJson.sj_select=='s_true_r'?'selected':'' } > 保存并关闭</option>
			 <option value="p_s_true" ${jsJson.sj_select=='p_s_true'?'selected':'' } > 父窗口执行保存</option>
			 <option value="p_s_true_r" ${jsJson.sj_select=='p_s_true_r'?'selected':'' } > 父窗口执行保存并刷新</option>
			 <option value="w_close" ${jsJson.sj_select=='w_close'?'selected':'' } > 窗口关闭</option>
			 <option value="custom" ${jsJson.sj_select=='custom'?'selected':'' } >自定义</option>
			</select>方法
			&nbsp;
			&nbsp;事件描述：<input type="text"  id="jsJson.sj_remark" name="jsJson.sj_remark" width="150px"  value="${jsJson.sj_remark}" >
			
			<br>$("[id='${id}']").dblclick(function(){
			<textarea  id="jsJson.sj_textarea" name="jsJson.sj_textarea"  style="height:50px;width:90%">${jsJson.sj_textarea}</textarea>
			<br>
			});
			</td>
			
		</tr>
		<tr>
			<td style="width:15%;" align="right">获取光标事件&nbsp;</td>
			<td style="width:85%;" align="left"  class="value">
			&nbsp;<input type="checkbox" id="jsJson.hqgb_input" name="jsJson.hqgb_input" title="添加获取光标事件" value="Y"  ${jsJson.hqgb_input=='Y'?'checked':'' } >
			该事件执行<select  id="jsJson.hqgb_select" name="jsJson.hqgb_select">
			 <option value="s_true"  ${jsJson.hqgb_select=='s_true'?'selected':'' }  >保存</option>
<%-- 			 <option value="s_true_r" ${jsJson.hqgb_select=='s_true_r'?'selected':'' } > 保存并刷新</option> --%>
			 <option value="s_true_r" ${jsJson.hqgb_select=='s_true_r'?'selected':'' } > 保存并关闭</option>
			 <option value="p_s_true" ${jsJson.hqgb_select=='p_s_true'?'selected':'' } > 父窗口执行保存</option>
			 <option value="p_s_true_r" ${jsJson.hqgb_select=='p_s_true_r'?'selected':'' } > 父窗口执行保存并刷新</option>
			 <option value="w_close" ${jsJson.hqgb_select=='w_close'?'selected':'' } > 窗口关闭</option>
			 <option value="custom" ${jsJson.hqgb_select=='custom'?'selected':'' } >自定义</option>
			</select>方法
			&nbsp;
			&nbsp;事件描述：<input type="text"  id="jsJson.hqgb_remark" name="jsJson.hqgb_remark" width="150px"  value="${jsJson.hqgb_remark}" >
			
			<br>$("[id='${id}']").focus(function(){
			<textarea  id="jsJson.hqgb_textarea" name="jsJson.hqgb_textarea" style="height:50px;width:90%">${jsJson.hqgb_textarea}</textarea>
			<br>
			});
			</td>
		</tr>
		<tr>
			<td style="width:15%;" align="right">失去光标事件&nbsp;</td>
			<td style="width:85%;" align="left" class="value">
			&nbsp;<input type="checkbox"  id="jsJson.sqgb_input" name="jsJson.sqgb_input" title="添加失去光标事件" value="Y"   ${jsJson.sqgb_input=='Y'?'checked':'' }  >
			该事件执行<select  id="jsJson.sqgb_select" name="jsJson.sqgb_select">
			 <option value="s_true"  ${jsJson.sqgb_select=='s_true'?'selected':'' }  >保存</option>
<%-- 			 <option value="s_true_r" ${jsJson.sqgb_select=='s_true_r'?'selected':'' } > 保存并刷新</option> --%>
			 <option value="s_true_r" ${jsJson.sqgb_select=='s_true_r'?'selected':'' } > 保存并关闭</option>
			 <option value="p_s_true" ${jsJson.sqgb_select=='p_s_true'?'selected':'' } > 父窗口执行保存</option>
			 <option value="p_s_true_r" ${jsJson.sqgb_select=='p_s_true_r'?'selected':'' } > 父窗口执行保存并刷新</option>
			 <option value="w_close" ${jsJson.sqgb_select=='w_close'?'selected':'' } > 窗口关闭</option>
			 <option value="custom" ${jsJson.sqgb_select=='custom'?'selected':'' } >自定义</option>
			</select>方法
			&nbsp;
			&nbsp;事件描述：<input type="text"  id="jsJson.sqgb_remark" name="jsJson.sqgb_remark" width="150px"  value="${jsJson.sqgb_remark}" >
			
			<br>$("[id='${id}']").blur(function(){
			<textarea  id="jsJson.sqgb_textarea" name="jsJson.sqgb_textarea" style="height:50px;width:90%">${jsJson.sqgb_textarea}</textarea>
			<br>
			});
			</td>
		</tr>
		<c:if test="${fieldType=='select'||fieldType=='list'}">
			<tr>
				<td style="width:15%;" align="right">数据更改事件&nbsp;</td>
				<td style="width:85%;" align="left" class="value">
				&nbsp;<input type="checkbox"  id="jsJson.sjgg_input" name="jsJson.sjgg_input" title="添加数据更改事件" value="Y"   ${jsJson.sjgg_input=='Y'?'checked':'' } >
				该事件执行<select  id="jsJson.sjgg_select" name="jsJson.sjgg_select" >
				 <option value="s_true"  ${jsJson.sjgg_select=='s_true'?'selected':'' }  >保存</option>
<%-- 				 <option value="s_true_r" ${jsJson.sjgg_select=='s_true_r'?'selected':'' } > 保存并刷新</option> --%>
				 <option value="s_true_r" ${jsJson.sjgg_select=='s_true_r'?'selected':'' } > 保存并关闭</option>
				 <option value="p_s_true" ${jsJson.sjgg_select=='p_s_true'?'selected':'' } > 父窗口执行保存</option>
				 <option value="p_s_true_r" ${jsJson.sjgg_select=='p_s_true_r'?'selected':'' } > 父窗口执行保存并刷新</option>
				 <option value="w_close" ${jsJson.sjgg_select=='w_close'?'selected':'' } > 窗口关闭</option>
				 <option value="custom" ${jsJson.sjgg_select=='custom'?'selected':'' } >自定义</option>
				</select>方法
				&nbsp;
				&nbsp;事件描述：<input type="text"  id="jsJson.sjgg_remark" name="jsJson.sjgg_remark" width="150px"  value="${jsJson.sjgg_remark}" >
				<br>$("[id='${id}']").change(function(){
				<textarea  id="jsJson.sjgg_textarea" name="jsJson.sjgg_textarea" style="height:50px;width:90%">${jsJson.sjgg_textarea}</textarea>
				<br>
				});
				</td>
			</tr>
		</c:if>
	</table>
</c:if>

</form>
</body>
</html>	


<script type="text/javascript">
$(function() {
	parent.$("#js_event").height($("body").height());
});
$.each(parent.eventJson, function(index, val) {
   var  html_ = "<option value='"+val.id+"' "+((val.id==parent.selectId)?'selected':'')+" >"+val.name+"_"+index+"</option>";
    $("#jsJson\\.dqkj").append(html_);
});

function saveEventJs() {
	$.ajax({
		async : true,
		cache : false,
		type : "POST",
		url : "designController.do?saveEventJs",// 请求的action路径
		data:$("#eventJs").serializeArray(),
		error : function() {// 请求失败处理函数
			parent.layer.msg('保存失败',{icon: 4});
		},
		success : function(data) {
			var data0=data;//eval("("+data+")");
			var msg=(data.msg=="0")?"保存失败":"保存成功";
			var tiptype=(data.msg=="0")?5:1;
			parent.layer.msg(msg, {icon: tiptype});
		}
	});
}

function dqkjChange(ts) {
	parent.selectId=$(ts).val();
	parent.designJsEvent();
}


</script>


	