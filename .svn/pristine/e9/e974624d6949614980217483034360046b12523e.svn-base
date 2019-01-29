package com.design.form.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.design.core.common.model.json.AjaxJson;
import com.design.entity.CgFormLgFieldEntity;

public interface EditPageGenServiceI  {
	public List<Map<String, Object>> getBussDataJson(Map<String, Object> pMap,HttpServletRequest request) throws Exception ;
	public Map<String, Object> getLinkBussDataJson(Map<String, Object> pMap,HttpServletRequest request) throws Exception ;
	public List<Map<String, Object>> getAttachDataJson(Map<String, Object> pMap) ;
	public List<Map<String, Object>> getPicDataJson(Map<String, Object> pMap) ;
	public AjaxJson doSaveOrUpdateData(HttpServletRequest request) throws Exception;
	public String getMainStatusNoById(String mainTable, String mainId);
	public List<CgFormLgFieldEntity> getFieldByTable(String tableName,String bussCode,String[] flag,String bussTemplateId,int versions);
	public  Map<String, Object> getRegionDataJson(Map<String, Object> pMap);
}
