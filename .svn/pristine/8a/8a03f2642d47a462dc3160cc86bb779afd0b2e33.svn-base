package com.design.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.design.utils.ParameterUtil;
import com.design.utils.StringUtil;
import com.design.utils.oConvertUtils;
import com.zxlhdata.framework.auth.util.LicenseUtil;

/**
 * 
 *
 */
@SuppressWarnings({"serial","rawtypes","unchecked","static-access"})
public class ConfigformTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	protected String bussCode;//业务 编码
	protected String linkBussCode;//明细业务 编码
	
	public void setLinkBussCode(String linkBussCode) {
		this.linkBussCode = linkBussCode;
	}

	protected String versions;//版本号
	protected String name;// 表格标示
	protected List<ConfigformToolBar> toolBarList = new ArrayList<ConfigformToolBar>();// 工具条列表
	public int pageSize = 10;
	public boolean pagination = true;// 是否显示分页
	private String listStyle = "db";// 列表样式db,zc
	private String configformId = "";
	private String detailListUrl = "";
	private String mainId = "";
	private String formServerUrl = "";
	private String nowUserCode = "";
	
	public void setMainId(String mainId) {
		this.mainId = mainId;
	}
	public void setDetailListUrl(String detailListUrl) {
		this.detailListUrl = detailListUrl;
	}
	public void setFormServerUrl(String formServerUrl) {
		this.formServerUrl = formServerUrl;
	}
	
	
	public void setConfigformId(String configformId) {
		this.configformId = configformId;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}
	public void setListStyle(String listStyle) {
		this.listStyle = listStyle;
	}
	public void setBussCode(String bussCode) {
		this.bussCode = bussCode;
	}
	public void setVersions(String versions) {
		this.versions = versions;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * 设置工具条
	 * @param height2 
	 * @param width2 
	 */
	public void setToolbar(String id,String url, String title, String icon, String exp,
			String onclick, String funname,String operationCode, String width2, String height2,String filterStatus) {
		ConfigformToolBar dataGridUrl = new ConfigformToolBar();
		dataGridUrl.setId(id);
		dataGridUrl.setTitle(title);
		dataGridUrl.setUrl(url);
		dataGridUrl.setType(OptTypeDirection.ToolBar);
		dataGridUrl.setIcon(icon);
		dataGridUrl.setOnclick(onclick);
		dataGridUrl.setExp(exp);
		dataGridUrl.setFunname(funname);
		dataGridUrl.setWidth(String.valueOf(width2));
		dataGridUrl.setHeight(String.valueOf(height2));
		dataGridUrl.setFilterStatus(filterStatus);
		installOperationCode(dataGridUrl, operationCode,toolBarList);
		
	}
	
	/**
	 * 描述：组装菜单按钮操作权限
	 * dateGridUrl：url
	 * operationCode：操作码
	 * optList： 操作列表
	 * @version 1.0
	 */
	private void installOperationCode(ConfigformToolBar dataGridUrl,String operationCode,List optList){
		if("admin".equals(nowUserCode)|| !Globals.BUTTON_AUTHORITY_CHECK){
			optList.add(dataGridUrl);
		}else if(!oConvertUtils.isEmpty(operationCode)){
			Set<String> operationCodes = (Set<String>) super.pageContext.getRequest().getAttribute("operationCodes");
			if (null!=operationCodes) {
				for (String MyoperationCode : operationCodes) {
					if(MyoperationCode.equals(operationCode)){
						optList.add(dataGridUrl);
					}
				}
			}
		}else {
			optList.add(dataGridUrl);
		}
	}
	
	
	
	public int doStartTag() throws JspException {
		toolBarList.clear();
		return EVAL_PAGE;
	}

	
	public int doEndTag() throws JspException {
		try {
			JspWriter out = this.pageContext.getOut();
			
			
			out.print(end().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
	public StringBuffer end() {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		sb.append(loadIframeHeadConfig());
		
		sb.append("<div class='my-icms col-xs-12'  style='overflow-x:hidden;overflow-y:hidden;' id='"+name+"' ms-controller='"+name+"_table'>");
		sb.append("<!-- 查询条件----------start -->");
		sb.append("<div ms-include-src='queryPageCodeRdm' data-include-rendered='queryTemprender' ></div>");
		sb.append("<!-- 查询条件----------end -->	");
		sb.append("<!-- 按钮区----------start -->");
		sb.append(toolbar().toString());
		sb.append("<!-- 按钮区----------end -->");
		sb.append("<!-- 简明模式 start------------------------------>");
		sb.append("<div class=\"table-responsive\" ms-if=\"!"+name+"_cf.isnull\">");
		sb.append("<div class=\"col\" >");
		sb.append("<div class=\"bd\" id=\"bd\" style=\"margin-top: 10px;\">");
		sb.append("<table border=\"0\" style=\"background: #eff3f8\"  class=\"table\"  >");
		sb.append("<!-- 主数据的head start -->");
		sb.append("<tr style=\"background: #EEEEEE;color: #666;\" id=\""+name+"_cf_title\">");
		sb.append("</tr>");
		sb.append("<!-- 主数据的head end -->");
		sb.append("<!-- 主数据 start -->");
		sb.append("<tbody id=\""+name+"_cf_body\" >");
		sb.append("</tbody>");
		sb.append("<!-- 主数据 end -->");
		sb.append("</table>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");

		sb.append("<!--简明模式  end------------------------------>");
		sb.append("<table ms-if=\""+name+"_cf.isnull\" style=\"margin-top: 10px;background: #EEEEEE;width:100%;height:35px;margin-bottom:3px;\">");
		sb.append("<tbody>");
		sb.append("<tr >");
		sb.append("<td align=\"center\" style=\"width:100%;\">暂无数据</td>");
		sb.append("</tr>");
		sb.append("</tbody>");
		sb.append("</table>");
		
		sb.append("<!-- 分页----------start -->");
		sb.append("<div style=\"height:50px;line-height:45px;text-align:center\">");
		sb.append("<div style=\"float:right;height:50px;line-height:45px;text-align:center\">");
		sb.append("<div class=\"ui-datatable-page ft14 pl20\">");
		sb.append("<div id=\"pageDiv\" ms-visible=\""+name+"_cf.page.total>"+name+"_cf.pageNum[0].num\" class=\"pull-right\"></div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<div style=\"float:left;height:50px;line-height:45px;text-align:center\">");
		sb.append("<div class=\"pull-right\" ms-visible=\""+name+"_cf.listDataSize!=0\">");
		sb.append("<span>共查询到{{"+name+"_cf.page.total}}条记录</span>");
		sb.append("<span ms-visible=\""+name+"_cf.page.total>"+name+"_cf.pageNum[0].num\">");
		sb.append("<!--  选择每页条数");
		sb.append("<select style=\"height: 25px; width: 50px;\" ms-change=\"selNum(this.value)\" ms-duplex=\""+name+"_cf.page.pagecount\">");
		sb.append("<option ms-repeat-pg=\"pageNum\" ms-attr-value=\"pg.num\" ms-attr-selected=\"pg.num=="+name+"_cf.page.pagecount?'selected':''\">{{pg.num}}</option>");
		sb.append("</select>");
		sb.append("-->");
		sb.append("</span>");
		sb.append(" </div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<!-- 分页----------end-->	");
		sb.append("</div>");
		
		sb.append(loadIframeBottomConfig());
		
		
		sb.append("<script type='text/javascript'>");
		
		//新建-----------------------
		sb.append("function addMain(title,url,name,width,height,filterStatus) {");
		sb.append("window.open(url,'_blank');");
		sb.append("}");
		//新建-----------------------
		//修改-----------------------
		sb.append("function updateMain(title,url,name,width,height,filterStatus) {");
		sb.append("var id=\"\";");
		sb.append("var selIndex=0,msg='';");
		sb.append("$(\"#"+name+"_cf_body\").find(\"[type='checkbox']\").each(function(index, domEle) {");
		sb.append("if (domEle.checked) {");
		sb.append("var filterStatus_=filterStatus.split(',');");
		sb.append("if(filterStatus_.length>0){");
		sb.append("for(var a=0;a<filterStatus_.length;a++){");
		sb.append("var filterS_=filterStatus_[a].split('|');");
		sb.append("if(filterS_.length>0){");
		sb.append("var q=''; try{q=$(this).attr(filterS_[0]);}catch(e){q=null;}");
		sb.append("if(q==null||q==undefined||q=='undefined'){");
		sb.append("msg=\"业务配置中未配置当前属性，请核对\";");
		sb.append("return ;");
		sb.append("}");
		sb.append("if(q==filterS_[1]){");
		sb.append("msg=filterS_[2];");
		sb.append("}");
		sb.append("var id_=$(this).attr('id');");
		sb.append("if(id_==''||id_==null||id_==undefined||id_=='undefined'){");
		sb.append("msg=\"请在业务配置中设置id为列表显示，并且隐藏\";");
		sb.append("return ;");
		sb.append("}");
		
		sb.append("id+=id_+',';");
		sb.append("}else{");
		sb.append("msg=\"filterStatus参数不规范，请修改filterStatus参数，例如：status|01|草稿状态不允许删除,status|02|已提交的状态不允许提交！\";");
		sb.append("return ;");
		sb.append("}");
		sb.append("}");
		sb.append("}else{");
		sb.append("var id_=$(this).attr('id');");
		sb.append("if(id_==''||id_==null||id_==undefined){");
		sb.append("msg=\"请在业务配置中设置id为列表显示，并且隐藏\";");
		sb.append("return ;");
		sb.append("}");
		sb.append("id+=id_+\",\";");
		sb.append("}");
		sb.append("selIndex++;");
		sb.append("}");
		sb.append("});");
		sb.append("if(msg!=\"\"){");
		sb.append("layer.msg(msg, {icon: 5});");
		sb.append("return false;");
		sb.append("}");
		sb.append("if(id==\"\"){");
		sb.append("layer.msg(\"请选择要修改的记录！\", {icon: 5});");
		sb.append("return false;");
		sb.append("}");
		sb.append("if(selIndex>1){");
		sb.append("layer.msg(\"只能选择一条记录！\", {icon: 5});");
		sb.append("return false;");
		sb.append("}");
		sb.append("id=noRepeatStr(id);");
		sb.append("window.open(url+\"&id=\"+id,\"_blank\");");
		sb.append("}");
		//修改-----------------------
		
		//查看-----------------------
		sb.append("function detail(title,url,name,width,height,filterStatus) {");
		sb.append("var id=\"\";");
		sb.append("var selIndex=0;");
		sb.append("$(\"#"+name+"_cf_body\").find(\"[type='checkbox']\").each(function(index, domEle) {");
		sb.append("if (domEle.checked) {");
		sb.append("id+=$(this).attr(\"id\")+\",\";");
		sb.append("selIndex++;");
		sb.append("}");
		sb.append("});");
		sb.append("if(id==\"\"){");
		sb.append("layer.msg(\"请选择要查看的记录！\", {icon: 5});");
		sb.append("return true;");
		sb.append("}");
		sb.append("if(selIndex>1){");
		sb.append("layer.msg(\"只能选择一条记录！\", {icon: 5});");
		sb.append("return false;");
		sb.append("}");
		sb.append("id=noRepeatStr(id);");
		sb.append("window.open(url+\"&id=\"+id,\"_blank\");");
		sb.append("}");
		//查看-----------------------
		
		//提交审核-----------------------
		sb.append("function submitMainByBusiness(title,url,name,width,height,filterStatus) {");
		sb.append("var id=\"\";");
		sb.append("var selIndex=0;");
		sb.append("$(\"#"+name+"_cf_body\").find(\"[type='checkbox']\").each(function(index, domEle) {");
		sb.append("if (domEle.checked) {");
		sb.append("id+=$(this).attr(\"id\")+\",\";");
		sb.append("selIndex++;");
		sb.append("}");
		sb.append("});");
		sb.append("if(id==\"\"){");
		sb.append("layer.msg(\"请选择要提交的记录！\", {icon: 5});");
		sb.append("return true;");
		sb.append("}");
		sb.append("id=noRepeatStr(id);");
		sb.append("window.open(url+\"&id=\"+id,\"_blank\");");
		sb.append("}");
		//提交审核-----------------------
		
		sb.append("function noRepeatStr(ids){");
		sb.append("var tempArr=new Array();");
		sb.append("var idsArr=ids.split(',');");
		sb.append("var s=0;");
		sb.append("for(var i=0;i<idsArr.length;i++){     ");
		sb.append(" if(tempArr.join('').indexOf(idsArr[i])==-1){");
		sb.append("tempArr[s]=idsArr[i];");
		sb.append("s++;");
		sb.append(" }");
		sb.append("}     ");
		sb.append("return tempArr.join(',');     ");
		sb.append("}");
		
		//删除-----------------------
		sb.append("function deleteSelect(title,url,name,width,height,filterStatus){");
		sb.append("var id=\"\";");
		sb.append("var selIndex=0;");
		sb.append("$(\"#"+name+"_cf_body\").find(\"[type='checkbox']\").each(function(index, domEle) {");
		sb.append("if (domEle.checked) {");
		sb.append("id+=$(this).attr(\"id\")+\",\";");
		sb.append("selIndex++;");
		sb.append("}");
		sb.append("});");
		sb.append("if(id==\"\"){");
		sb.append("layer.msg(\"请选择要删除的记录！\", {icon: 5});");
		sb.append("return true;");
		sb.append("}");
		sb.append("id=noRepeatStr(id);");
		sb.append("myConfirmDialog('您确定要删除吗？', function() {");
		sb.append(""+name+"_cf."+name+"_cf_body.clear();");
		sb.append("$.getJSON(url+'&id='+id,");
		sb.append("{id:id}, function (resultData) {");
		sb.append("$.ajaxSettings.async = false;");
		sb.append(""+bussCode+"_doQuery();");
		sb.append("layer.msg('删除成功！', {icon: 1});");
		sb.append("return true;");
		sb.append("});");
		sb.append("}, function() {");
		sb.append("return true;");
		sb.append("},'');");
		sb.append("}");
		//删除-----------------------
		
		sb.append("var "+name+"_cf = avalon.define({");
		sb.append("$id : '"+name+"_table',");
		sb.append(""+name+"_cf_title : [],");
		sb.append(""+name+"_cf_body : [],");
		sb.append("listDataSize :0,");
		sb.append("xianshigeshu : 20,");
		sb.append("showListType:'"+listStyle+"',");
		sb.append("isnull: false,");
		sb.append("page: { pageindex: 1, pagecount: "+pageSize+", total: 0 }, ");
		sb.append("pageNum: [{ 'num': 10 }, { 'num': 20 }, { 'num': 30 }, { 'num': 50 }, { 'num': 100 }],");
		sb.append("search: { seartype: '1', searchcontent: '1' },");
		sb.append("queryPageCodeRdm : 'listPageGenController.do?goQueryMain&query="+name+"&versions=-1&bussCode="+(oConvertUtils.getString(linkBussCode, bussCode))+"',");
		sb.append("queryTemprender : function() {");
		sb.append("queryTableMainAvalon"+name+".impQueryTJ = '';");
		sb.append("queryTableMainAvalon"+name+".InitWigetData();");
		sb.append("queryTableMainAvalon"+name+".clearReturnFunction = '"+name+"_clearQueryData()';");
		sb.append("queryTableMainAvalon"+name+".queryReturnFunction = '"+bussCode+"_doQuery()';");
		sb.append("},");
		sb.append("selNum : function(item) {");
		sb.append(""+name+"_cf.page.pagecount = item;");
		sb.append("},");
		sb.append("getJYListData : function(rFData) { ");
		sb.append("var url_='listPageGenController.do?getTWorJYListData&mainId="+mainId+"&versions=-1&configformId="+configformId+"&linkBussCode="+linkBussCode+"&bussCode="+bussCode+"&jsonType="+listStyle+"&currpage='");
		sb.append("+ "+name+"_cf.search.searchcontent");
		sb.append("+ '&pagecount='");
		sb.append("+ "+name+"_cf.page.pagecount;");
		sb.append("$.getJSON(url_,rFData,function(resultData) {");
		sb.append(""+name+"_cf.isnull=true;");
		sb.append("if(resultData.success){");
		sb.append(""+name+"_setData(resultData);");
		sb.append(""+name+"_myLayPage('pageDiv',resultData.obj[0].DataLength,'listPageGenController.do?getTWorJYListData&mainId="+mainId+"&configformId="+configformId+"&divId=&linkBussCode="+linkBussCode+"&bussCode="+bussCode+"&jsonType="+listStyle+"',rFData);");
		sb.append("}");
		sb.append("});");
		sb.append("}");
		sb.append("});");
		sb.append("function "+name+"_myLayPage(domId,dataLength,jsonUrl,rFData){");
		sb.append("var pageindex="+name+"_cf.page.pageindex;");
		sb.append("var pagecount="+name+"_cf.page.pagecount;");
		sb.append(""+name+"_cf.page.total = dataLength;");
		sb.append("jsonUrl='listPageGenController.do?getTWorJYListData&mainId="+mainId+"&versions=-1&linkBussCode="+linkBussCode+"&bussCode="+bussCode+"&jsonType="+listStyle+"';");
		sb.append("laypage({");
		sb.append("cont : domId,");
		sb.append("pages : Math.ceil(parseInt(dataLength)* 1.0/ pagecount),");
		sb.append("curr : 1,");
		sb.append("skin : 'molv',");
		sb.append("groups : 3,");
		sb.append("jump : function(e) {");
		sb.append("if (e.curr != "+name+"_cf.page.pageindex) {");
		sb.append(""+name+"_cf.search.searchcontent = e.curr;");
		sb.append("var url_=jsonUrl+'&currpage='+ e.curr+ '&pagecount='+ "+name+"_cf.page.pagecount;");
		sb.append("$.getJSON(url_,rFData,function(resultData) {");
		sb.append("if(resultData.success){");
		sb.append(""+name+"_setData(resultData);");
		sb.append("}else{");
		sb.append(""+name+"_cf.isnull=true;");
		sb.append("}");
		sb.append(""+name+"_cf.page.pageindex = e.curr;");
		sb.append("});");
		sb.append("}");
		sb.append("}");
		sb.append("});");
		sb.append("}");
		sb.append("function "+name+"_setData(resultData) {");
		sb.append("if (resultData.success) {");
		sb.append("if(resultData.obj[0].DataLength>0){");
		sb.append(""+name+"_cf.isnull = false;");
		sb.append("}");
		sb.append(""+name+"_cf."+name+"_cf_title=resultData.obj[0].mainColumnsTitle;");
		sb.append(""+name+"_cf."+name+"_cf_body = resultData.obj[0].mainColumns;");
		sb.append(""+name+"_cf.listDataSize = resultData.obj[0].DataLength;");
		sb.append("JD_BUSSTitleDataHtml("+name+"_cf."+name+"_cf_title,'"+name+"_cf_title','"+name+"');");
		sb.append("JD_BUSSBodyDataHtml("+name+"_cf."+name+"_cf_body,'"+name+"_cf_body','"+listStyle+"','"+name+"');");
		sb.append("$('avalon').remove();} else {");
		sb.append(""+name+"_cf.isnull = true;");
		sb.append(""+name+"_cf."+name+"_cf_title.clear();");
		sb.append(""+name+"_cf."+name+"_cf_body.clear();");
		sb.append("}");
		sb.append("}");

		sb.append("function "+bussCode+"_doQuery() {");
		sb.append(""+name+"_cf.search.searchcontent='1';");
		sb.append(""+name+"_cf.search.seartype='1';");
		sb.append(""+name+"_cf.search.pageindex=5;");
		sb.append(""+name+"_cf.search.pagecount="+pageSize+";");
		sb.append(""+name+"_cf.search.total=0;");
		sb.append(""+name+"_cf.page.total = 0;");
		sb.append("var rFData = queryTableMainAvalon"+name+".returnFormData();");
		sb.append("if (rFData.queryFromFieldNmae != null");
		sb.append("&& rFData.queryFromFieldNmae != undefined) {");
		sb.append(""+name+"_cf.getJYListData(rFData);");
		sb.append("}else{");
		sb.append(""+name+"_cf.getJYListData('');");
		sb.append("}");
		sb.append("}");
		
		sb.append("function "+name+"_clearQueryData() {");
		sb.append(""+name+"_cf.search.searchcontent='1';");
		sb.append(""+name+"_cf.search.seartype='1';");
		sb.append(""+name+"_cf.search.pageindex=5;");
		sb.append(""+name+"_cf.search.pagecount="+pageSize+";");
		sb.append(""+name+"_cf.search.total=0;");
		sb.append(""+name+"_cf.page.total = 0;");
		sb.append(""+name+"_cf.getJYListData('');");
		sb.append("}");
		sb.append("avalon.ready(function() {");
		sb.append("$.ajaxSettings.async = true;");
		sb.append(""+name+"_cf.search.searchcontent='1';");
		sb.append(""+name+"_cf.search.seartype='1';");
		sb.append(""+name+"_cf.search.pageindex=5;");
		sb.append(""+name+"_cf.search.pagecount="+pageSize+";");
		sb.append(""+name+"_cf.search.total=0;");
		sb.append(""+name+"_cf.isnull=true;");
		sb.append(""+name+"_cf.page.total = 0;");
		sb.append(""+name+"_cf.getJYListData('');");
		sb.append(""+name+"_cf.showListType='"+listStyle+"';");
		sb.append("});");
		sb.append("function thatclick(that){");
		sb.append("$(that).closest('table').find('tr > td:first-child input:checkbox').each(function(){");
		sb.append("this.checked = that.checked;");
		sb.append("$(this).closest('tr').toggleClass('selected');");
		sb.append("});");
		sb.append("}");
		sb.append("function thatClickMain(index,that,showListType){");
		sb.append("$('#detailHtml'+index).find('input:checkbox').each(function(){");
		sb.append("this.checked = that.checked;");
		sb.append("$(this).closest('tr').toggleClass('selected');");
		sb.append("});");
		sb.append("}");
		sb.append("</script>");
		if("zc".equals(listStyle)){//主从关系列表展示
			sb.append("<script type='text/javascript'>");
			sb.append("var "+name+"_isShow=false;");
			sb.append("function "+name+"_goRightWindows(mainId){");	
			sb.append("var jt4 = document.getElementById('"+name+"_right_windows');");
			sb.append("var wwwtop=$('#"+name+"').offset().top;");
			sb.append("var wwwheight_ =$('html').height()-88;");
			sb.append("var wwwwidth_=$('#"+name+"').width();");
			sb.append("jt4.style.top=wwwtop+'px';");
//			sb.append("if("+name+"_isShow){");
//			sb.append("jt4.style.right='-903px';");
//			sb.append(""+name+"_isShow=false;");
//			sb.append("$('#"+name+"_right_windows iframe').attr('src','');");
//			sb.append("}else{");
			sb.append(""+name+"_isShow=true;");
			sb.append("jt4.style.right='0px';");
			sb.append("$('#"+name+"_right_windows iframe').attr('src','"+detailListUrl+"&mainId='+mainId);");
			sb.append("$('#"+name+"_right_windows iframe').attr('width',(wwwwidth_/2));");
			sb.append("$('#"+name+"_right_windows iframe').attr('height',(wwwheight_));");
//			sb.append("}");
			sb.append("jt4.style.transition='all 0.2s ';");
			sb.append("}");
			sb.append("function  "+name+"_hideRightWindows(){");
			sb.append("var jt4 = document.getElementById('"+name+"_right_windows');");
			sb.append("jt4.style.right='-903px';");
			sb.append(""+name+"_isShow=false;");
			sb.append("$('#"+name+"_right_windows iframe').attr('src','');");
			sb.append("}");
			sb.append("</script>");
			sb.append("<div id='"+name+"_right_windows' style='z-index:99999;background-color: #ffffff;position:fixed;right:-903px;bottom:0px;box-shadow: 1px 1px 50px rgba(0,0,0,.3);'>");
			sb.append("<div class='ui_close' onclick='"+name+"_hideRightWindows()' style='position:absolute;color: #ffffff;");
			sb.append("font-size: 20px;");
			sb.append("width: 20px;");
			sb.append("height: 20px;");
			sb.append("line-height: 18px;");
			sb.append("border-radius: 2px;");
			sb.append("left: -20px;");
			sb.append("top: -0px;cursor: pointer;");
			sb.append("background-color: #d84718;'>");
			sb.append("×");
			sb.append("</div>");
			sb.append("<iframe   src=''  frameborder='0' border='0' marginwidth='0' allowtransparency='true' marginheight='0' ></iframe>");
			sb.append("</div>");
		}
		
		return sb;
	}
	
	public StringBuffer toolbar() {
		StringBuffer sb = new StringBuffer();
		
		for (ConfigformToolBar toolBar : toolBarList) {
			sb.append("<div type='button'  ");
			sb.append( "id='"+toolBar.getId()+"' class='btn'  ");
			if(StringUtil.isNotEmpty(toolBar.getOnclick()))
			{
				sb.append(" onclick="+toolBar.getOnclick()+"");
			}
			else {
				sb.append("onclick=\""+toolBar.getFunname()+"(");
				if(!toolBar.getFunname().equals("doSubmit"))
				{
				sb.append("\'"+toolBar.getTitle()+"\',");
				}
				String width = toolBar.getWidth().contains("%")?"'"+toolBar.getWidth()+"'":toolBar.getWidth();
				String height = toolBar.getHeight().contains("%")?"'"+toolBar.getHeight()+"'":toolBar.getHeight();
				sb.append("\'"+toolBar.getUrl()+"\',\'"+name+"\',"+width+","+height+",'"+toolBar.getFilterStatus()+"')\"");
			}
			sb.append(">");
			sb.append("<i  class='"+oConvertUtils.getString(toolBar.getIcon(), "")+"'  ></i>");
			sb.append(toolBar.getTitle());
			sb.append("</div>");
		}
		
		return sb;
	}
	
	/**
	 * 加载iframe设置
	 * @param paras
	 * @param request
	 */
	private StringBuilder loadIframeHeadConfig() {
		
		StringBuilder sb= new StringBuilder("");
//		sb.append("<script src=\"designPlug-in/layer/layer.js\"></script>");
//		sb.append("<script src=\"designPlug-in/layer/extend/layer.ext.js\"></script>");
//		sb.append("<script src=\"designPlug-in/laypage/laypage.js\"></script>");
//		sb.append("<!-- basic styles -->");
//		sb.append("<script src=\"designPlug-in/avalon/avalon1.4.js\"></script>");
		sb.append("<style type=\"text/css\">");
		sb.append(".ms-controller{");
		sb.append("visibility: hidden");
		sb.append("}");
		sb.append("</style>");
		return sb;
	}
	
	private StringBuilder loadIframeBottomConfig() {
		
		//如果列表以iframe形式的话，需要加入样式文件
		StringBuilder sb= new StringBuilder("");
//		sb.append("<script src=\"designPlug-in/ace/assets/js/jquery-ui-1.10.3.custom.min.js\"></script>");
//		sb.append("<script src=\"designPlug-in/ace/assets/js/jquery.ui.touch-punch.min.js\"></script>");
//		sb.append("<script src=\"designPlug-in/ace/assets/js/jquery.slimscroll.min.js\"></script>");
//		sb.append("<script src=\"designPlug-in/ace/assets/js/jquery.easy-pie-chart.min.js\"></script>");
//		sb.append("<script src=\"designPlug-in/ace/assets/js/jquery.sparkline.min.js\"></script>");
//		sb.append("<script src=\"designPlug-in/ace/assets/js/flot/jquery.flot.min.js\"></script>");
//		sb.append("<script src=\"designPlug-in/ace/assets/js/flot/jquery.flot.pie.min.js\"></script>");
//		sb.append("<script src=\"designPlug-in/ace/assets/js/flot/jquery.flot.resize.min.js\"></script>");
//		sb.append("<script src=\"designPlug-in/ace/assets/js/ace-elements.min.js\"></script>");
//		sb.append("<script src=\"designPlug-in/ace/assets/js/ace.min.js\"></script>");
		sb.append("<script src=\"designPlug-in/tools/icmstools.js\"></script>");
//		sb.append("<script src=\"designPlug-in/layer/SZHLCommon.js\"></script>");
		return sb;
	}

}
