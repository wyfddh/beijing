package com.design.form.service.impl;
import java.io.Serializable;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.design.core.system.service.impl.CommonServiceImpl;
import com.design.entity.CgformRdataMasterEntity;
import com.design.form.service.CgformRdataMasterServiceI;

@Service("cgformRdataMasterService")
@Transactional
public class CgformRdataMasterServiceImpl extends CommonServiceImpl implements CgformRdataMasterServiceI {

	
 	public <T> void delete(T entity) throws Exception  {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CgformRdataMasterEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) throws Exception  {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((CgformRdataMasterEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) throws Exception  {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((CgformRdataMasterEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CgformRdataMasterEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CgformRdataMasterEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CgformRdataMasterEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CgformRdataMasterEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{buss_id}",String.valueOf(t.getBussId()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{org_id}",String.valueOf(t.getOrgId()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{temp1}",String.valueOf(t.getTemp1()));
 		sql  = sql.replace("#{temp2}",String.valueOf(t.getTemp2()));
 		sql  = sql.replace("#{temp3}",String.valueOf(t.getTemp3()));
 		sql  = sql.replace("#{temp4}",String.valueOf(t.getTemp4()));
 		sql  = sql.replace("#{temp5}",String.valueOf(t.getTemp5()));
 		sql  = sql.replace("#{temp6}",String.valueOf(t.getTemp6()));
 		sql  = sql.replace("#{temp7}",String.valueOf(t.getTemp7()));
 		sql  = sql.replace("#{temp8}",String.valueOf(t.getTemp8()));
 		sql  = sql.replace("#{temp9}",String.valueOf(t.getTemp9()));
 		sql  = sql.replace("#{temp10}",String.valueOf(t.getTemp10()));
 		sql  = sql.replace("#{temp11}",String.valueOf(t.getTemp11()));
 		sql  = sql.replace("#{temp12}",String.valueOf(t.getTemp12()));
 		sql  = sql.replace("#{temp13}",String.valueOf(t.getTemp13()));
 		sql  = sql.replace("#{temp14}",String.valueOf(t.getTemp14()));
 		sql  = sql.replace("#{temp15}",String.valueOf(t.getTemp15()));
 		sql  = sql.replace("#{temp16}",String.valueOf(t.getTemp16()));
 		sql  = sql.replace("#{temp17}",String.valueOf(t.getTemp17()));
 		sql  = sql.replace("#{temp18}",String.valueOf(t.getTemp18()));
 		sql  = sql.replace("#{temp19}",String.valueOf(t.getTemp19()));
 		sql  = sql.replace("#{temp20}",String.valueOf(t.getTemp20()));
 		sql  = sql.replace("#{temp21}",String.valueOf(t.getTemp21()));
 		sql  = sql.replace("#{temp22}",String.valueOf(t.getTemp22()));
 		sql  = sql.replace("#{temp23}",String.valueOf(t.getTemp23()));
 		sql  = sql.replace("#{temp24}",String.valueOf(t.getTemp24()));
 		sql  = sql.replace("#{temp25}",String.valueOf(t.getTemp25()));
 		sql  = sql.replace("#{temp26}",String.valueOf(t.getTemp26()));
 		sql  = sql.replace("#{temp27}",String.valueOf(t.getTemp27()));
 		sql  = sql.replace("#{temp28}",String.valueOf(t.getTemp28()));
 		sql  = sql.replace("#{temp29}",String.valueOf(t.getTemp29()));
 		sql  = sql.replace("#{temp30}",String.valueOf(t.getTemp30()));
 		sql  = sql.replace("#{temp31}",String.valueOf(t.getTemp31()));
 		sql  = sql.replace("#{temp32}",String.valueOf(t.getTemp32()));
 		sql  = sql.replace("#{temp33}",String.valueOf(t.getTemp33()));
 		sql  = sql.replace("#{temp34}",String.valueOf(t.getTemp34()));
 		sql  = sql.replace("#{temp35}",String.valueOf(t.getTemp35()));
 		sql  = sql.replace("#{temp36}",String.valueOf(t.getTemp36()));
 		sql  = sql.replace("#{temp37}",String.valueOf(t.getTemp37()));
 		sql  = sql.replace("#{temp38}",String.valueOf(t.getTemp38()));
 		sql  = sql.replace("#{temp39}",String.valueOf(t.getTemp39()));
 		sql  = sql.replace("#{temp40}",String.valueOf(t.getTemp40()));
 		sql  = sql.replace("#{temp41}",String.valueOf(t.getTemp41()));
 		sql  = sql.replace("#{temp42}",String.valueOf(t.getTemp42()));
 		sql  = sql.replace("#{temp43}",String.valueOf(t.getTemp43()));
 		sql  = sql.replace("#{temp44}",String.valueOf(t.getTemp44()));
 		sql  = sql.replace("#{temp45}",String.valueOf(t.getTemp45()));
 		sql  = sql.replace("#{temp46}",String.valueOf(t.getTemp46()));
 		sql  = sql.replace("#{temp47}",String.valueOf(t.getTemp47()));
 		sql  = sql.replace("#{temp48}",String.valueOf(t.getTemp48()));
 		sql  = sql.replace("#{temp49}",String.valueOf(t.getTemp49()));
 		sql  = sql.replace("#{temp50}",String.valueOf(t.getTemp50()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}