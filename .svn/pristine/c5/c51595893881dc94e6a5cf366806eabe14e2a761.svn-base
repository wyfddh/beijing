package com.design.form.service;
import com.design.entity.CgformBussEntity;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface CgformBussServiceI{
	
 	public <T> void delete(T entity)  throws Exception ;
 	
 	public <T> Serializable save(T entity)  throws Exception ;
 	
 	public <T> void saveOrUpdate(T entity)  throws Exception ;
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CgformBussEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CgformBussEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CgformBussEntity t);

	public Map<String, Object> getCgformBuss(HttpServletRequest request);

	public CgformBussEntity saveAndCopyDefine(CgformBussEntity cgformBuss, HttpServletRequest request)  throws Exception;
}
