package com.design.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.design.utils.ContextHolderUtils;
import com.design.utils.ResourceUtil;
import com.design.utils.StringUtil;
import com.design.utils.oConvertUtils;

/**
 * 
 *
 */
@SuppressWarnings({ "serial", "rawtypes", "unchecked", "static-access" })
public class LayuiTableTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	protected String bussCode;// 业务 编码
	protected String name;// 表格标示
	protected List<LayuiTableToolBar> toolBarList = new ArrayList<LayuiTableToolBar>();// 工具条列表
	protected List<LayuiButtonTag> toolButtonList = new ArrayList<LayuiButtonTag>();// 工具条列表
	public int pageSize = 10;
	public boolean pagination = true;// 是否显示分页
	private String limits = "10,20,30,40,50,60,70,80,90";
	private String initSort = "";
	private String tableQueryUrl = "";
	private String tableTitleUrl = "";
	private String tableDataUrl = "";
	private String nowUserCode = "";
	private String isIndex = "";
	private String isCheckbox = "false";// 是否显示复选框
	private String tableHeight = "full";
	public void setToolBarList(List<LayuiTableToolBar> toolBarList) {
		this.toolBarList = toolBarList;
	}

	public void setToolButtonList(List<LayuiButtonTag> toolButtonList) {
		this.toolButtonList = toolButtonList;
	}

	public void setNowUserCode(String nowUserCode) {
		this.nowUserCode = nowUserCode;
	}

	public void setTableHeight(String tableHeight) {
		if(StringUtil.isEmpty(tableHeight)){
			tableHeight="full";
		}
		this.tableHeight = tableHeight;
	}

	public void setTableWidth(String tableWidth) {
		if(StringUtil.isEmpty(tableWidth)){
			tableWidth="full";
		}
		this.tableWidth = tableWidth;
	}

	private String tableWidth = "full";
	private String onLoadSuccess;// 数据加载完成调用方法
	private String onClick;// 单击事件调用方法
	private String onDblClick;// 双击事件调用方法
	
	public void setOnLoadSuccess(String onLoadSuccess) {
		this.onLoadSuccess = onLoadSuccess;
	}

	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}

	public void setOnDblClick(String onDblClick) {
		this.onDblClick = onDblClick;
	}

	public void setIsCheckbox(String isCheckbox) {
		this.isCheckbox = isCheckbox;
	}

	public void setIsIndex(String isIndex) {
		this.isIndex = isIndex;
	}

	public void setTableTitleUrl(String tableTitleUrl) {
		this.tableTitleUrl = tableTitleUrl;
	}

	public void setTableDataUrl(String tableDataUrl) {
		this.tableDataUrl = tableDataUrl;
	}

	public void setTableQueryUrl(String tableQueryUrl) {
		this.tableQueryUrl = tableQueryUrl;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}

	public void setLimits(String limits) {
		this.limits = limits;
	}

	public void setInitSort(String initSort) {
		this.initSort = initSort;
	}

	public void setBussCode(String bussCode) {
		this.bussCode = bussCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setButton(String url, String title, String icon, String exp,
			String onclick, String funname, String operationCode,
			String width2, String height2) {
		LayuiButtonTag dataGridUrl = new LayuiButtonTag();
		dataGridUrl.setTitle(title);
		dataGridUrl.setUrl(url);
		dataGridUrl.setType(OptTypeDirection.ToolBar);
		dataGridUrl.setIcon(icon);
		dataGridUrl.setOnclick(onclick);
		dataGridUrl.setExp(oConvertUtils.getString(exp));
		dataGridUrl.setFunname(funname);
		dataGridUrl.setOperationCode(operationCode);
		dataGridUrl.setWidth(String.valueOf(width2));
		dataGridUrl.setHeight(String.valueOf(height2));
		installOperationCode(dataGridUrl, operationCode, toolButtonList);
	}

	public void setToolbar(String url, String title, String icon, String exp,
			String onclick, String funname, String operationCode,
			String width2, String height2) {
		LayuiTableToolBar dataGridUrl = new LayuiTableToolBar();
		dataGridUrl.setTitle(title);
		dataGridUrl.setUrl(url);
		dataGridUrl.setType(OptTypeDirection.ToolBar);
		dataGridUrl.setIcon(icon);
		dataGridUrl.setOnclick(onclick);
		dataGridUrl.setExp(oConvertUtils.getString(exp));
		dataGridUrl.setFunname(funname);
		dataGridUrl.setWidth(String.valueOf(width2));
		dataGridUrl.setOperationCode(operationCode);
		dataGridUrl.setHeight(String.valueOf(height2));
		installOperationCode(dataGridUrl, operationCode, toolBarList);

	}

	/**
	 * 设置自定义函数操作URL
	 */
	public void setFunUrl(String title, String exp, String funname,
			String operationCode) {
		LayuiTableToolBar dataGridUrl = new LayuiTableToolBar();
		dataGridUrl.setTitle(title);
		dataGridUrl.setType(OptTypeDirection.Fun);
		dataGridUrl.setExp(oConvertUtils.getString(exp));
		dataGridUrl.setFunname(funname);
		installOperationCode(dataGridUrl, operationCode, toolBarList);

	}

	/**
	 * 设置自定义函数操作URL
	 */
	public void setOpenUrl(String url, String title, String width,
			String height, String exp, String operationCode, String openModel) {
		LayuiTableToolBar dataGridUrl = new LayuiTableToolBar();
		dataGridUrl.setTitle(title);
		dataGridUrl.setUrl(url);
		dataGridUrl.setWidth(width);
		dataGridUrl.setHeight(height);
		dataGridUrl.setType(OptTypeDirection.valueOf(openModel));
		dataGridUrl.setExp(oConvertUtils.getString(exp));
		installOperationCode(dataGridUrl, operationCode, toolBarList);

	}

	/**
	 * 描述：组装菜单按钮操作权限 dateGridUrl：url operationCode：操作码 optList： 操作列表
	 * 
	 * @version 1.0
	 */
	private void installOperationCode(LayuiButtonTag dataGridUrl,
			String operationCode, List optList) {
		nowUserCode=(String)ContextHolderUtils.getRequest().getSession().getAttribute("create_by");
		if ("admin".equals(nowUserCode) || !Globals.BUTTON_AUTHORITY_CHECK) {
			optList.add(dataGridUrl);
		} else if (oConvertUtils.isNotEmpty(operationCode)) {
			Set<String> operationCodes = (Set<String>) ContextHolderUtils.getRequest().getSession().getAttribute("operationCodes");
			if (null != operationCodes) {
				for (String MyoperationCode : operationCodes) {
					if (MyoperationCode.equals(operationCode)) {
						optList.add(dataGridUrl);
					}
				}
			}
		} else {
			optList.add(dataGridUrl);
		}
	}

	private void installOperationCode(LayuiTableToolBar dataGridUrl,
			String operationCode, List optList) {
		nowUserCode=(String)ContextHolderUtils.getRequest().getSession().getAttribute("create_by");
		if ("admin".equals(nowUserCode) || !Globals.BUTTON_AUTHORITY_CHECK) {
			optList.add(dataGridUrl);
		} else if (!oConvertUtils.isEmpty(operationCode)) {
			Set<String> operationCodes = (Set<String>) ContextHolderUtils.getRequest().getSession().getAttribute("operationCodes");
			if (null != operationCodes) {
				for (String MyoperationCode : operationCodes) {
					if (MyoperationCode.equals(operationCode)) {
						optList.add(dataGridUrl);
					}
				}
			}
		} else {
			optList.add(dataGridUrl);
		}
	}

	public int doStartTag() throws JspException {
		toolBarList.clear();
		toolButtonList.clear();
		return EVAL_PAGE;
	}

	public int doEndTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			out.print(end().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public StringBuffer end() throws Exception {
		//LicenseUtil.valid(ParameterUtil.ATC_K, 30);
		StringBuffer sb = new StringBuffer();
		sb.append(loadIframeHeadConfig());
		sb.append("<div class='my-icms col-xs-12' id='TABLE_" + bussCode
				+ "'  style='overflow-x:hidden;overflow-y:hidden;padding:5px;' >");
//		/****************************位置不能换******************/
//		queryHtml(sb);
//		/****************************位置不能换******************/
		sb.append("<div class='" + bussCode + "_search_area'>");
		sb.append("<div id='" + bussCode + "_query_param' >");
		sb.append("</div>");
		sb.append(layuiButton().toString());
		sb.append("</div>");
		sb.append("<table class='layui-hide' id='" + bussCode
				+ "' lay-filter='" + bussCode + "'></table>");
		sb.append(toolbar().toString());
		
		sb.append("</div>");
		sb.append(loadIframeBottomConfig());
		sb.append("<script type='text/javascript'>var "+bussCode+"_table;");
		sb.append("function clearQueryData_"+bussCode+"() {");
		sb.append("$('#queryTableMainForm_"+bussCode+"').find('.clearList').find('.selectedInfor').each(function(){");
		sb.append("var ere=$(this).closest('.selectedInfor').children('input').get(0);var yxValue = $('#"+bussCode+"_query_param').find('#tiaoJianId_1111_'+$(ere).attr('name')+'_'+$(ere).val());");
		sb.append("if($(this).find('em').attr('isinput')=='false'){");
		sb.append("yxValue.removeClass('brand-icon-official');");
		sb.append("}");
		sb.append("$(this).remove();");
		sb.append("});");
		sb.append("layuiCleanQuery('"+bussCode+"');");
		sb.append("}");
		
		sb.append("function getQueryData_"+bussCode+"() {");
		sb.append("var jsonData = $(\"#queryTableMainForm_" + bussCode
				+ "\").serializeArray();console.log(jsonData);");
		sb.append("var fromMap={};var newValue_='';var name1='';if(jsonData.length==0){return null;}");
		sb.append("$.map(jsonData, function (item) {name1=item.name;var has = name1 in fromMap;var newValue_=item.value;");
		sb.append("if(has){");
		sb.append("newValue_ = fromMap[name1]+\",\"+item.value;");
		sb.append("}");
		sb.append("fromMap[name1] = newValue_;");
		sb.append("});return fromMap; ");
		sb.append("}");
		
		sb.append("function queryData_"+bussCode+"() {");
		sb.append("var fromMap=getQueryData_"+bussCode+"();" + bussCode + "_table.reload('" + bussCode + "', {");
		sb.append("page: {");
		sb.append("curr: 1"); // 重新从第 1 页开始
		sb.append(" }");
		sb.append(",where:fromMap");
		sb.append(" });");
		sb.append("}");
		
		sb.append("layui.use(['table', 'element','laydate'], function(){");
		sb.append("var laypage = layui.laypage"); // 分页
		sb.append(",layer = layui.layer"); // 弹层
		sb.append(",element = layui.element;"); // 元素操作
		sb.append(bussCode + "_table = layui.table;");// 表格
		sb.append("var "+bussCode+"_laydate = layui.laydate;");//日期
		
		
		// sb.append("Array.prototype.remove=function(dx)");
		// sb.append("{");
		// sb.append("if(isNaN(dx)||dx>this.length){return false;}");
		// sb.append("for(var i=0,n=0;i<this.length;i++)");
		// sb.append("{");
		// sb.append("if(this[i]!=this[dx])");
		// sb.append("{");
		// sb.append("this[n++]=this[i]");
		// sb.append("}");
		// sb.append("}");
		// sb.append("this.length-=1");
		// sb.append("};");
		sb.append("var " + bussCode + "_cols = [[]]," + bussCode + "_cols1=[],"
				+ bussCode + "_hideField=[];");
		if ("true".equals(isCheckbox)) {
			sb.append("" + bussCode + "_cols1[" + bussCode
					+ "_cols1.length]={checkbox: true,fixed:'left'};");
		}
		if ("true".equals(isIndex)) {
			sb.append(""
					+ bussCode
					+ "_cols1["
					+ bussCode
					+ "_cols1.length]={type: 'numbers',title:'序号',fixed:'left'};");
		}
		
		sb.append("$.getJSON('" + tableTitleUrl + "',function(resultData) {");
		/****************************位置不能换******************/
		titleHtml(sb);
		/****************************位置不能换******************/
		sb.append("" + bussCode + "_cols[0]=" + bussCode
				+ "_cols1;console.log(" + bussCode + "_cols);");
//		sb.append("layui.use(['table', 'element','laydate'], function(){");
//		sb.append("var laypage = layui.laypage"); // 分页
//		sb.append(",layer = layui.layer"); // 弹层
//		sb.append(",element = layui.element;"); // 元素操作
//		sb.append("" + bussCode + "_table = layui.table;");// 表格
//		sb.append(""+bussCode+"_laydate = layui.laydate;");//日期
		// sb.append("layer.msg('正在加载，请稍后...');");
		sb.append("" + bussCode + "_table.render({");
		sb.append("elem: '#" + bussCode + "'");
		sb.append(",id: '" + bussCode + "'");
		sb.append(",loading:true");
		sb.append(",height: '"+tableHeight+"'");
		sb.append(",width: '"+tableWidth+"'");
		sb.append(",cellMinWidth: 80");
		if (StringUtil.isNotEmpty(initSort)) {
			sb.append(",initSort: " + initSort + "");
		}
		sb.append(",limit: " + pageSize + "");
		sb.append(",limits: [" + limits + "]");
		sb.append(",url: '" + tableDataUrl + "'"); // 数据接口
		sb.append(",page: " + pagination + ""); // 开启分页
		sb.append(",cols: " + bussCode + "_cols");
		sb.append(",done: function(res, curr, count){console.log('111111111');console.log(res);");
		sb.append("for(var o1=0;o1<res.data.length;o1++){");
		sb.append("var obj=res.data[o1];");
		sb.append("var layToolbars=$('#TABLE_" + bussCode + "').find(\"[data-index='\"+obj.LAY_TABLE_INDEX+\"']\").find(\"[lay-toolbar='true']\");");
		sb.append("layToolbars.each( function( index, val ) {");
		sb.append("var ep=$(this).attr('exp');");
		sb.append("if(ep!=''){");
		sb.append("var ep1=ep.split(\"&&\");");
		sb.append("for(var o2=0;o2<ep1.length;o2++){");
		sb.append("var ep11=ep1[o2].split(\"#\");");
		sb.append("if(ep11.length==3){$(this).hide();");
		sb.append("var value=ep11[2];");
		sb.append("var vs=value.split(\",\");");
		sb.append("if (\"eq\"==ep11[1]) {");
		sb.append("if($.inArray(obj[ep11[0]],vs)>=0){$(this).show();");
		sb.append("}else{$(this).remove();}");
		sb.append("}");
		sb.append("if (\"ne\"==ep11[1]) {");
		sb.append("if($.inArray(obj[ep11[0]],vs)<0){$(this).show();");
		sb.append("}else{$(this).remove();}");
		sb.append("}");
		sb.append("if (\"empty\"==ep11[1]&&value==\"true\") {");
		sb.append("if(obj[ep11[0]]==''){$(this).show();");
		sb.append("}else{$(this).remove();}");
		sb.append("}");
		sb.append("if (\"empty\"==ep11[1]&&value==\"false\") {");
		sb.append("if(obj[ep11[0]]!=''){$(this).show();");
		sb.append("}else{$(this).remove();}");
		sb.append("}");
		sb.append("}");
		sb.append("}");
		sb.append("}");
		sb.append("});");
		sb.append("}");
		
		
		sb.append("for(var o=0;o<" + bussCode + "_hideField.length;o++){");
		sb.append("$('#TABLE_" + bussCode + "').find(\"[data-field='\"+" + bussCode
				+ "_hideField[o].field+\"']\").css('display','none');");
		sb.append("}");
		if(StringUtil.isNotEmpty(onClick)){
			sb.append("$('#TABLE_"+bussCode+"').find('.layui-table-body').find('table' ).find('tbody').children('tr').on('click',function(){");
			sb.append("var index = JSON.stringify($('#TABLE_"+bussCode+"').find('.layui-table-body').find('table' ).find('tbody').find('.layui-table-hover').data('index'));");
			sb.append("var obj = res.data[index];console.log(obj);");
			sb.append(onClick + "(index,obj);");
			sb.append("});");
		}
		if(StringUtil.isNotEmpty(onDblClick)&&StringUtil.isEmpty(onClick)){
			sb.append("$('#TABLE_"+bussCode+"').find('.layui-table-body').find('table' ).find('tbody').children('tr').on('dblclick',function(){");
			sb.append("var index = JSON.stringify($('#TABLE_"+bussCode+"').find('.layui-table-body').find('table' ).find('tbody').find('.layui-table-hover').data('index'));");
			sb.append("var obj = res.data[index];");
			sb.append(onDblClick + "(index,obj);");
			sb.append("});");
		}
		if (StringUtil.isNotEmpty(onLoadSuccess)) {
			sb.append(onLoadSuccess + "();");
		}
		sb.append("}");
		sb.append("});");
		sb.append(" var $ = layui.$, active = {");
		int i=0;
		for (LayuiButtonTag toolBar : toolButtonList) {
			sb.append(toolBar.getOperationCode() + "_click: function(){");
			if (StringUtil.isNotEmpty(toolBar.getOnclick())) {
				sb.append(toolBar.getOnclick() + ";");
			} else {
				sb.append(toolBar.getFunname() + "(");
				if (!toolBar.getFunname().equals("doSubmit")) {
					sb.append("\'" + toolBar.getTitle() + "\',");
				}
				String width = toolBar.getWidth().contains("%") ? "'"
						+ toolBar.getWidth() + "'" : toolBar.getWidth();
				String height = toolBar.getHeight().contains("%") ? "'"
						+ toolBar.getHeight() + "'" : toolBar.getHeight();
				sb.append("\'" + toolBar.getUrl() + "\',\'" + name + "\',"
						+ width + "," + height + ");");
			}
			sb.append(" }");
			if((toolButtonList.size()-i)!=1){
				sb.append(" ,");
			}
			i++;
		}
		sb.append(" };");
		sb.append("$('#" + bussCode + "_layui-btn').on('click', function(){");
		sb.append("var type = $(this).data('type');");
		sb.append("active[type] ? active[type].call(this) : '';");
		sb.append("});");
		for (LayuiButtonTag toolBar : toolButtonList) {
			sb.append("$('#" + toolBar.getOperationCode()
					+ "_click').on('click', function(){");
			sb.append("var type = $(this).data('type');");
			sb.append("active[type] ? active[type].call(this) : '';");
			sb.append("});");
		}
		sb.append("" + bussCode + "_table.on('tool(" + bussCode + ")', function(obj){ ");// 注：tool是工具条事件名，test是table原始容器的属性
																		// lay-filter="对应的值"
		sb.append("var data = obj.data ");// 获得当前行数据
		sb.append(",layEvent = obj.event;"); // 获得 lay-event 对应的值

		for (LayuiTableToolBar toolBar : toolBarList) {
			sb.append("if(layEvent === '" + toolBar.getOperationCode() + "'){");
			if (StringUtil.isNotEmpty(toolBar.getOnclick())) {
				sb.append(toolBar.getOnclick() + ";");
			} else {
				sb.append(toolBar.getFunname() + "(");
				if (!toolBar.getFunname().equals("doSubmit")) {
					sb.append("\'" + toolBar.getTitle() + "\',");
				}
				String width = toolBar.getWidth().contains("%") ? "'"
						+ toolBar.getWidth() + "'" : toolBar.getWidth();
				String height = toolBar.getHeight().contains("%") ? "'"
						+ toolBar.getHeight() + "'" : toolBar.getHeight();
				sb.append("\'" + toolBar.getUrl() + "\',\'" + name + "\',"
						+ width + "," + height + ",data);");
			}
			sb.append("}");
		}
		// sb.append("if(layEvent === 'detail'){");
		// sb.append("layer.msg('查看操作');");
		// sb.append("} else if(layEvent === 'del'){");
		// sb.append("layer.confirm('真的删除行么', function(index){");
		// sb.append("obj.del();"); //删除对应行（tr）的DOM结构
		// sb.append("layer.close(index);");
		// sb.append("});");
		// sb.append("} else if(layEvent === 'edit'){");
		// sb.append("layer.msg('编辑操作');");
		// sb.append("}");
		sb.append("});");
//		sb.append("});");
		sb.append("});");
		/****************************位置不能换******************/
		queryHtml(sb);
		/****************************位置不能换******************/
		sb.append("});");
		sb.append("function layuiTableReload(bussCode,data){");
		sb.append("" + bussCode + "_table.reload(bussCode, {");
		sb.append("page: {");
		sb.append("curr: 1"); // 重新从第 1 页开始
		sb.append(" }");
		sb.append(",where:data");
		sb.append(" });");
		sb.append(" }");
		sb.append("function layuiCleanQuery(bussCode){");
		sb.append("$(\"#\"+bussCode+\"_form input\").val(\"\");");
		sb.append("$(\".sl-v-list input\").val(\"\");");
		sb.append("" + bussCode + "_table.reload(bussCode, {");
		sb.append("page: {");
		sb.append("curr: 1"); // 重新从第 1 页开始
		sb.append(" }");
		sb.append(",where:null");
		sb.append(" });");
		sb.append(" }");
		sb.append("</script>");
		return sb;
	}

	private void titleHtml(StringBuffer sb) {
		sb.append("for(var i=0;i<resultData.length;i++){");
		sb.append("var c=new Object();");
		sb.append("c.field=resultData[i].field;");
		sb.append("c.title=resultData[i].title;");
		sb.append("if(resultData[i].width!=\"\"){");
		sb.append("c.width=resultData[i].width;");
		sb.append("}");
		sb.append("if(resultData[i].sort!=\"\"){");
		sb.append("c.sort=resultData[i].sort;");
		sb.append("}");
		sb.append("if(resultData[i].fixed!=\"\"){");
		sb.append("c.fixed=resultData[i].fixed;");
		sb.append("}");
		sb.append("if(resultData[i].minWidth!=\"\"){");
		sb.append("c.minWidth=resultData[i].minWidth;");
		sb.append("}");
		sb.append("if(resultData[i].unresize!=\"\"){");
		sb.append("c.unresize=resultData[i].unresize;");
		sb.append("}");
		sb.append("if(resultData[i].edit!=\"\"){");
		sb.append("c.edit=resultData[i].edit;");
		sb.append("}");
		sb.append("if(resultData[i].style!=\"\"){");
		sb.append("c.style=resultData[i].style;");
		sb.append("}");
		sb.append("if(resultData[i].align!=\"\"){");
		sb.append("c.align=resultData[i].align;");
		sb.append("}");
		sb.append("if(resultData[i].toolbar!=\"\"){");
		sb.append("c.toolbar=resultData[i].toolbar;");
		sb.append("}");

		sb.append("" + bussCode + "_cols1[" + bussCode + "_cols1.length]=c;");
		sb.append("if(resultData[i].isHide=='Y'){");
		sb.append("" + bussCode + "_hideField[" + bussCode
				+ "_hideField.length]=c;");
		// sb.append(""+bussCode+"_cols1.remove("+bussCode+"_cols1.length);");
		sb.append("}");
		sb.append("}");
	}

	private void queryHtml(StringBuffer sb) {
		sb.append("$.getJSON('" + tableQueryUrl + "',function(resultData_1) {");
		sb.append("$('#" + bussCode + "_query_param').html(resultData_1.html);readyQuery('" + bussCode + "');");
		sb.append("var oClearList= $('#"+bussCode+"_query_param #queryModel_11_').find('#clearList_11_');");
		sb.append("var resultData=resultData_1.obj;");
		sb.append("for(var i=0;i<resultData.length;i++){");
		sb.append("if(resultData[i].showType=='year'"
				+ "||resultData[i].showType=='yymm'"
				+ "||resultData[i].showType=='date'"
				+ "||resultData[i].showType=='datetime'"
				+ "||resultData[i].showType=='time'){");
		sb.append("var fieldId_start='';var fieldId_end=resultData[i].field;");
		sb.append("var typename='';");
		sb.append("var typegroupid='';");
		sb.append("if(resultData[i].type=='group'){");
		sb.append("fieldId_start=resultData[i].field+\"_start\";");
		sb.append("typegroupid=$('#'+fieldId_start).attr('typegroupid');");
		sb.append("typename=$('#'+fieldId_start).attr('typename');");
		sb.append(""+bussCode+"_laydate.render({");
		sb.append("elem: '#'+fieldId_start,typegroupid:typegroupid,typename:typename");
		sb.append(",fieldId_start:fieldId_start,done: function(value, date){console.log(this.fieldId_start);");
		sb.append("var infor ='<div class=\"selectedInfor selectedShow\">';");
		sb.append("infor+='<input type=\"hidden\" id=\"query_'+this.typegroupid+'\" name=\"query_'+this.typegroupid+'\" value=\"'+value+'\">';");
		sb.append("infor+='<input type=\"hidden\" id=\"'+this.typegroupid+'_s111s000\" name=\"'+this.typegroupid+'_s111s000\" value=\"'+value+'\">';");
		sb.append("infor+='<span>'+this.typename+'</span>：<label>' + value + '</label><em isinput=\"false\"></em></div>';");
		sb.append(" $('#queryTableMainForm_" + bussCode + " #query_'+this.fieldId_start).closest('.selectedInfor').remove(); oClearList.append(infor);emClick('" + bussCode + "');"
				/*+ "$('#'+fieldId_start).val('');"*/);
		sb.append("}");
		sb.append(",type: ((resultData[i].showType=='yymm')?'month':resultData[i].showType)");
		sb.append("});");
		sb.append("fieldId_end=resultData[i].field+\"_end\";");
		sb.append("}");
		sb.append("typegroupid=$('#'+fieldId_end).attr('typegroupid');");
		sb.append("typename=$('#'+fieldId_end).attr('typename');");
		sb.append(""+bussCode+"_laydate.render({");
		sb.append("elem: '#'+fieldId_end,typegroupid:typegroupid,typename:typename");
		sb.append(",fieldId_end:fieldId_end,done: function(value, date){console.log(this.fieldId_start);");
		sb.append("var infor ='<div class=\"selectedInfor selectedShow\">';");
		sb.append("infor+='<input type=\"hidden\" id=\"query_'+this.typegroupid+'\" name=\"query_'+this.typegroupid+'\" value=\"'+value+'\">';");
		sb.append("infor+='<input type=\"hidden\" id=\"'+this.typegroupid+'_s111s000\" name=\"'+this.typegroupid+'_s111s000\" value=\"'+value+'\">';");
		sb.append("infor+='<span>'+this.typename+'</span>：<label>' + value + '</label><em isinput=\"false\"></em></div>';");
		sb.append(" $('#queryTableMainForm_" + bussCode + " #query_'+this.fieldId_end).closest('.selectedInfor').remove(); oClearList.append(infor);emClick('" + bussCode + "');"
				/*+ "$('#'+fieldId_end).val('');"*/);
		sb.append("}");
		sb.append(",type: ((resultData[i].showType=='yymm')?'month':resultData[i].showType)");
		sb.append("});");
		sb.append("}");
		sb.append("}");
		sb.append("});");
		
//		sb.append("<div id='header' class='wap-header' style='display: block;'>");
//		sb.append("<a id='headerFiltrate' class='wap-header-back wap-header-l' href='javascript:void(0)' title='筛选'>筛选</a>");
//		sb.append("<div class='wap-search'>");
//		sb.append("<form method='post'>");
//		sb.append("<div class='wap-search-text'><input type='text' placeholder='搜索商品、品牌、种类'></div>");
//		sb.append("<input type='submit' value=''>");
//		sb.append("</form>");
//		sb.append("</div>");
//		sb.append("</div>");
//		sb.append("<div id='filtratePage' class='screening-conditions' style='display: none;'>");
//		sb.append("<div class='wap-header'>");
//		sb.append("<a id='filtrateBackContains' class='wap-header-back wap-header-l' href='javascript:void(0)'></a>");
//		sb.append("<h1>筛选</h1>");
//		sb.append("</div>");
//		sb.append("<div class='filtrate-footer'>");
//		sb.append("<ul class='filtrate-btn clearfix'>");
//		sb.append("<li><input class='filtrate-reset' type='button' value='清空筛选条件'></li>");
//		sb.append("<li><input class='filtrate-submit' type='button' value='确定'></li>");
//		sb.append("</ul>");
//		sb.append("</div>");
//		sb.append("</div>");
//		sb.append("<link rel='stylesheet' media='screen' href='designPlug-in/style.css'>");
//		sb.append("<script src='designPlug-in/jquery.filter.js'></script>");
		
	}
	
	

	public StringBuffer toolbar() {
		StringBuffer sb = new StringBuffer();
		sb.append("<script type=\"text/html\" id=\"" + bussCode + "_bar\"> ");
		for (LayuiTableToolBar toolBar : toolBarList) {
			sb.append("<a class=\"" + toolBar.getIcon() + "\" exp='"+toolBar.getExp()+"' lay-toolbar='true' lay-event=\""
					+ toolBar.getOperationCode() + "\">" + toolBar.getTitle()
					+ "</a> ");
		}
		sb.append("</script> ");
		return sb;
	}

	public StringBuffer layuiButton() {
		StringBuffer sb = new StringBuffer();
		for (LayuiButtonTag toolBar : toolButtonList) {
			sb.append("<button class='" + toolBar.getIcon() + "' id='"
					+ toolBar.getOperationCode() + "_click' data-type='"
					+ toolBar.getOperationCode() + "_click' >"
					+ toolBar.getTitle() + "</button>");
		}
		return sb;
	}

	/**
	 * 加载iframe设置
	 * 
	 * @param paras
	 * @param request
	 */
	private StringBuilder loadIframeHeadConfig() {

		StringBuilder sb = new StringBuilder("");
		// sb.append("<script type=text/javascript src='designPlug-in/layer/layer.js'></script>");
		// sb.append("<script type=text/javascript src='designPlug-in/layer/extend/layer.ext.js'></script>");
		// sb.append("<script src=\"designPlug-in/laypage/laypage.js\"></script>");
		sb.append("<link rel='stylesheet' href='designPlug-in/jd/css/list.css' type=text/css >");
		sb.append("<script type=text/javascript src='designPlug-in/jd/js/shaixuan.js'></script>");
		// sb.append("<script src=\"designPlug-in/layer/layer.js\"></script>");
		// sb.append("<script src=\"designPlug-in/layer/extend/layer.ext.js\"></script>");
		// sb.append("<!-- basic styles -->");
		// sb.append("<script src=\"designPlug-in/avalon/avalon1.4.js\"></script>");
		sb.append("<style type=\"text/css\">");
		sb.append(".ms-controller{");
		sb.append("visibility: hidden");
		sb.append("}");
		sb.append(".layui-table-cell .layui-form-checkbox[lay-skin=\"primary\"]{");
		sb.append("top: 50%;");
		sb.append("transform: translateY(-50%);");
		sb.append("}");
		sb.append("</style>");
		return sb;
	}

	private StringBuilder loadIframeBottomConfig() {

		// 如果列表以iframe形式的话，需要加入样式文件
		StringBuilder sb = new StringBuilder("");
		// sb.append("<script src=\"designPlug-in/ace/assets/js/jquery-ui-1.10.3.custom.min.js\"></script>");
		// sb.append("<script src=\"designPlug-in/ace/assets/js/jquery.ui.touch-punch.min.js\"></script>");
		// sb.append("<script src=\"designPlug-in/ace/assets/js/jquery.slimscroll.min.js\"></script>");
		// sb.append("<script src=\"designPlug-in/ace/assets/js/jquery.easy-pie-chart.min.js\"></script>");
		// sb.append("<script src=\"designPlug-in/ace/assets/js/jquery.sparkline.min.js\"></script>");
		// sb.append("<script src=\"designPlug-in/ace/assets/js/flot/jquery.flot.min.js\"></script>");
		// sb.append("<script src=\"designPlug-in/ace/assets/js/flot/jquery.flot.pie.min.js\"></script>");
		// sb.append("<script src=\"designPlug-in/ace/assets/js/flot/jquery.flot.resize.min.js\"></script>");
		// sb.append("<script src=\"designPlug-in/ace/assets/js/ace-elements.min.js\"></script>");
		// sb.append("<script src=\"designPlug-in/ace/assets/js/ace.min.js\"></script>");
		// sb.append("<script src=\"designPlug-in/tools/icmstools.js\"></script>");
		// sb.append("<script src=\"designPlug-in/layer/SZHLCommon.js\"></script>");
		return sb;
	}

}
