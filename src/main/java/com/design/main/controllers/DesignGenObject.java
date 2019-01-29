package com.design.main.controllers;

import java.sql.SQLException;
import java.util.Map;

import com.design.entity.CgFormLgFieldEntity;
import com.design.entity.CgFormLgHeadEntity;
import com.design.entity.CgformButtonEntity;
import com.design.entity.CgformTabEntity;
import com.design.entity.TSBussTemplateEntity;
import com.design.entity.CgformDefineEntity;
import com.design.utils.oConvertUtils;

public class DesignGenObject {
	
	
	
	public static CgformButtonEntity getCgformButton(Map<String, Object>  res) throws SQLException {
		CgformButtonEntity cgformButton=new CgformButtonEntity();
		cgformButton.setId(oConvertUtils.getString(res.get("id")));
		cgformButton.setButtonCode(oConvertUtils.getString(res.get("button_code")));
		cgformButton.setButtonIcon(oConvertUtils.getString(res.get("button_icon")));
		cgformButton.setButtonName(oConvertUtils.getString(res.get("button_name")));
		cgformButton.setButtonStatus(oConvertUtils.getString(res.get("button_status")));
		cgformButton.setButtonStyle(oConvertUtils.getString(res.get("button_style")));
		cgformButton.setExp(oConvertUtils.getString(res.get("exp")));
		cgformButton.setFormId(oConvertUtils.getString(res.get("form_id")));
		cgformButton.setOptType(oConvertUtils.getString(res.get("opt_type")));
		cgformButton.setOrderNum(oConvertUtils.getInt(res.get("order_num"),0));
		cgformButton.setButtonType(oConvertUtils.getString(res.get("button_type")));
		cgformButton.setDefineCode(oConvertUtils.getString(res.get("define_code")));
		return cgformButton;
	}
	
	public static CgformTabEntity getCgformTab(Map<String, Object>  res) throws SQLException {
		CgformTabEntity cgformTab=new CgformTabEntity();
		cgformTab.setId(oConvertUtils.getString(res.get("id")));
		cgformTab.setTabCode(oConvertUtils.getString(res.get("tab_code")));
		cgformTab.setTabIcon(oConvertUtils.getString(res.get("tab_icon")));
		cgformTab.setTabName(oConvertUtils.getString(res.get("tab_name")));
		cgformTab.setTabStatus(oConvertUtils.getString(res.get("tab_status")));
		cgformTab.setFormId(oConvertUtils.getString(res.get("form_id")));
		cgformTab.setDetailField(oConvertUtils.getString(res.get("detail_field")));
		cgformTab.setLinkBussCode(oConvertUtils.getString(res.get("link_buss_code")));
		cgformTab.setMainField(oConvertUtils.getString(res.get("main_field")));
		cgformTab.setOrderNum(oConvertUtils.getInt(res.get("order_num"),0));
		cgformTab.setDefineCode(oConvertUtils.getString(res.get("define_code")));
		return cgformTab;
	}
	
	public static TSBussTemplateEntity getTSBussTemplate(Map<String, Object>  res) throws SQLException {
		TSBussTemplateEntity tSBussTemplate=new TSBussTemplateEntity();
//		tSBussTemplate.setConfigformId(oConvertUtils.getString(res.get("configform_id")));
		tSBussTemplate.setId(oConvertUtils.getString(res.get("id")));
		tSBussTemplate.setRemark(oConvertUtils.getString(res.get("remark")));
		tSBussTemplate.setStatus(oConvertUtils.getString(res.get("status")));
		tSBussTemplate.setTemplateName(oConvertUtils.getString(res.get("template_name")));
		tSBussTemplate.setTemplateType(oConvertUtils.getString(res.get("template_type")));
		tSBussTemplate.setCssType(oConvertUtils.getString(res.get("css_type")));
		return tSBussTemplate;
		
	}
	
	public static CgFormLgHeadEntity getCgFormLgHead(Map<String, Object>  res) throws SQLException {
		CgFormLgHeadEntity cgFormLgHead=new CgFormLgHeadEntity();
		cgFormLgHead.setId(oConvertUtils.getString(res.get("id")));
		cgFormLgHead.setContent(oConvertUtils.getString(res.get("content")));
		cgFormLgHead.setCreateBy(oConvertUtils.getString(res.get("create_by")));
//		cgFormLgHead.setCreateDate(res.getDate("create_date")));
		cgFormLgHead.setCreateName(oConvertUtils.getString(res.get("create_name")));
		cgFormLgHead.setIsCheckbox(oConvertUtils.getString(res.get("is_checkbox")));
		cgFormLgHead.setIsPagination(oConvertUtils.getString(res.get("is_pagination")));
		cgFormLgHead.setIsTree(oConvertUtils.getString(res.get("is_tree")));
		cgFormLgHead.setJformType(oConvertUtils.getInt(res.get("jform_type")+""));
		cgFormLgHead.setJformVersion(oConvertUtils.getString(res.get("jform_version")));
		cgFormLgHead.setQuerymode(oConvertUtils.getString(res.get("querymode")));
		cgFormLgHead.setRelationType(oConvertUtils.getInt(res.get("relation_type")+""));
		cgFormLgHead.setSubTableStr(oConvertUtils.getString(res.get("sub_table_str")));
		cgFormLgHead.setSubTableName(oConvertUtils.getString(res.get("table_name")));
		cgFormLgHead.setUpdateBy(oConvertUtils.getString(res.get("update_by")));
//		cgFormLgHead.setUpdateDate(res.getDate("update_date")));
		cgFormLgHead.setUpdateName(oConvertUtils.getString(res.get("update_name")));
		cgFormLgHead.setJformPkSequence(oConvertUtils.getString(res.get("jform_pk_sequence")));
		cgFormLgHead.setJformPkType(oConvertUtils.getString(res.get("jform_pk_type")));
		cgFormLgHead.setTabOrder(oConvertUtils.getInt(res.get("tab_order")+""));
		cgFormLgHead.setBusinessType(oConvertUtils.getString(res.get("business_type")));
		cgFormLgHead.setIsMustExist(oConvertUtils.getString(res.get("is_must_exist")));
		cgFormLgHead.setMustExistCount(oConvertUtils.getInt(res.get("must_exist_count")+""));
		cgFormLgHead.setEditUrl(oConvertUtils.getString(res.get("edit_url")));
		cgFormLgHead.setViewUrl(oConvertUtils.getString(res.get("view_url")));
		cgFormLgHead.setSubTableName(oConvertUtils.getString(res.get("sub_table_name")));
		cgFormLgHead.setShowTableDesc(oConvertUtils.getString(res.get("show_table_desc")));
		cgFormLgHead.setSubTabOrder(oConvertUtils.getInt(res.get("sub_tab_order")+""));
		cgFormLgHead.setBussCode(oConvertUtils.getString(res.get("buss_code")));
		cgFormLgHead.setBussName(oConvertUtils.getString(res.get("buss_name")));

		return cgFormLgHead;
	}

	public static CgformDefineEntity getTSConfigform(Map<String, Object>  res)
			throws SQLException {
		CgformDefineEntity tSConfigform= new CgformDefineEntity();
		tSConfigform.setId(oConvertUtils.getString(res.get("configform_id")));
		tSConfigform.setDefineCode(oConvertUtils.getString(res.get("configform_bus_code")));
		tSConfigform.setDefineName(oConvertUtils.getString(res.get("configform_bus_name")));
		tSConfigform.setMtableName(oConvertUtils.getString(res.get("configform_mtable_name")));
		tSConfigform.setProcessKey(oConvertUtils.getString(res.get("configform_process_key")));
		tSConfigform.setPrintId(oConvertUtils.getString(res.get("configform_print_id")));
		  return tSConfigform;
	}
	
	public static CgFormLgFieldEntity getCgFormLgField(CgFormLgFieldEntity res,int x1_,String isTask,boolean y1) throws SQLException {
		int y=oConvertUtils.getInt(oConvertUtils.getString(res.getY(), "1"));
		if("true".equals(isTask)
				&&("v_formGroupButton".equals(oConvertUtils.getString(res.getShowType()))||
						"v_formButton".equals(oConvertUtils.getString(res.getShowType())))){
			return null;
		}
		if(y1){
			y--;
		}
		res.setY(y);
		return res;
	}
	
	

}
