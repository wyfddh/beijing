package com.design.list.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.design.entity.CgFormLgFieldEntity;

public interface ListPageGenServiceI  {

	
	/**
	 * 获得各种情况下的json数据
	 * 
	 * @param request
	 * @param jsonType
	 * @param gno
	 * @return
	 * @throws Exception 
	 */
	public String getJsonByBussData(HttpServletRequest request) throws Exception;
	public String getJYJsonByBussData(HttpServletRequest request) throws Exception;
	public List<CgFormLgFieldEntity> getFieldByTable(String tableName,String bussCode,String[] flag,String bussTemplateId,int versions);
}
