package com.design.form.service.impl;
import java.io.Serializable;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.design.core.system.service.impl.CommonServiceImpl;
import com.design.entity.CgformSelectFieldEntity;
import com.design.form.service.CgformSelectFieldServiceI;

@Service("cgformSelectFieldService")
@Transactional
public class CgformSelectFieldServiceImpl extends CommonServiceImpl implements CgformSelectFieldServiceI {

	
 	public <T> void delete(T entity) throws Exception {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CgformSelectFieldEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) throws Exception {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((CgformSelectFieldEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) throws Exception {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((CgformSelectFieldEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CgformSelectFieldEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CgformSelectFieldEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CgformSelectFieldEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CgformSelectFieldEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{field_code}",String.valueOf(t.getFieldCode()));
 		sql  = sql.replace("#{field_name}",String.valueOf(t.getFieldName()));
 		sql  = sql.replace("#{main_id}",String.valueOf(t.getMainId()));
 		sql  = sql.replace("#{is_hide}",String.valueOf(t.getIsHide()));
 		sql  = sql.replace("#{field_width}",String.valueOf(t.getFieldWidth()));
 		sql  = sql.replace("#{is_query}",String.valueOf(t.getIsQuery()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}