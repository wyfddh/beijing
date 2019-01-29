package com.design.form.service;
import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.design.entity.CgformDefineEntity;

public interface CgformDefineServiceI{
	
 	public <T> void delete(T entity)  throws Exception ;
 	
 	public <T> Serializable save(T entity)  throws Exception ;
 	
 	public <T> void saveOrUpdate(T entity)  throws Exception ;
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CgformDefineEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CgformDefineEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CgformDefineEntity t);

	public Map<String, Object> getCgformDefine(HttpServletRequest request);
}
