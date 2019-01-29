package com.design.form.service.impl;
import com.design.form.service.CgformBussListServiceI;
import com.design.core.system.service.impl.CommonServiceImpl;
import com.design.entity.CgformBussListEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("cgformBussListService")
@Transactional
public class CgformBussListServiceImpl extends CommonServiceImpl implements CgformBussListServiceI {

	
 	public <T> void delete(T entity) throws Exception {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CgformBussListEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) throws Exception {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((CgformBussListEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) throws Exception {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((CgformBussListEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CgformBussListEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CgformBussListEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CgformBussListEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CgformBussListEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{content}",String.valueOf(t.getContent()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{field_name}",String.valueOf(t.getFieldName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{buss_id}",String.valueOf(t.getBussId()));
 		sql  = sql.replace("#{define_id}",String.valueOf(t.getDefineId()));
 		sql  = sql.replace("#{is_show_list}",String.valueOf(t.getIsShowList()));
 		sql  = sql.replace("#{is_imagelist_hide}",String.valueOf(t.getIsImagelistHide()));
 		sql  = sql.replace("#{is_imagelist}",String.valueOf(t.getIsImagelist()));
 		sql  = sql.replace("#{is_list_hide}",String.valueOf(t.getIsListHide()));
 		sql  = sql.replace("#{column_width}",String.valueOf(t.getColumnWidth()));
 		sql  = sql.replace("#{sort}",String.valueOf(t.getSort()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}