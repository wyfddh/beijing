package com.design.form.service.impl;
import java.io.Serializable;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.design.core.system.service.impl.CommonServiceImpl;
import com.design.entity.CgformSelectBackEntity;
import com.design.form.service.CgformSelectBackServiceI;

@Service("cgformSelectBackService")
@Transactional
public class CgformSelectBackServiceImpl extends CommonServiceImpl implements CgformSelectBackServiceI {

	
 	public <T> void delete(T entity) throws Exception {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CgformSelectBackEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) throws Exception {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((CgformSelectBackEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) throws Exception {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((CgformSelectBackEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CgformSelectBackEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CgformSelectBackEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CgformSelectBackEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CgformSelectBackEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{s_name}",String.valueOf(t.getSelectName()));
 		sql  = sql.replace("#{s_code}",String.valueOf(t.getSelectCode()));
 		sql  = sql.replace("#{json_url}",String.valueOf(t.getJsonUrl()));
 		sql  = sql.replace("#{json_sql}",String.valueOf(t.getJsonSql()));
 		sql  = sql.replace("#{back_function}",String.valueOf(t.getBackFunction()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{json_url}",String.valueOf(t.getJsonUrl()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}