package com.design.form.service;
import java.io.Serializable;

import com.design.core.system.service.CommonService;
import com.design.entity.CgformRdataDetailEntity;

public interface CgformRdataDetailServiceI extends CommonService{
	
 	public <T> void delete(T entity) throws Exception ;
 	
 	public <T> Serializable save(T entity) throws Exception ;
 	
 	public <T> void saveOrUpdate(T entity) throws Exception ;
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CgformRdataDetailEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CgformRdataDetailEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CgformRdataDetailEntity t);
}
