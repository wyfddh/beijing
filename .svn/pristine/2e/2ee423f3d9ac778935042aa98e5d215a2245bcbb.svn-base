/** 
 * <pre>项目名称:mip 
 * 文件名称:ApplyAuditingRecordServiceImpl.java 
 * 包名:com.tj720.mip.service.table 
 * 创建日期:2017年1月20日下午7:19:22 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.service.table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj720.mip.dao.ApplyAuditingRecordDaoImpl;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.ApplyAuditingRecordService;
import com.tj720.mip.model.ApplyAuditingRecord;
import com.tj720.mip.utils.HqlWhere;
import com.tj720.mip.utils.Page;
/** 
 * <pre>项目名称：mip    
 * 类名称：ApplyAuditingRecordServiceImpl    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月20日 下午7:19:22    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月20日 下午7:19:22    
 * 修改备注：       
 * @version </pre>
 */
@Service
public class ApplyAuditingRecordServiceImpl extends BaseService<ApplyAuditingRecord> implements ApplyAuditingRecordService{
	@Resource(name="ApplyAuditingRecord")
	ApplyAuditingRecordDaoImpl ApplyAuditingRecord;

	@Resource(name="ApplyAuditingRecord")
	public void setDao(IBaseDao<ApplyAuditingRecord> dao) {
		super.setDao(dao);
	}

	//申请人和时间段查询的hql
	@Override
	public String getHqlCondition(ApplyAuditingRecord auditingRecord, String modelName,String status) {
		
		StringBuilder strHql = new StringBuilder("from "+modelName+" where 1=1 ");
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(status!= null && !status.equals("")){
			strHql.append(HqlWhere.bindEquals("status", status, "and"));
		}
		if(auditingRecord.getStaTime() != null && !auditingRecord.getStaTime().equals("")){
			strHql.append(HqlWhere.bind_LessThan_Equal("createTime", auditingRecord.getStaTime(), "and"));
		}
		if(auditingRecord.getEndTime() != null && !auditingRecord.getEndTime().equals("")){
			strHql.append(HqlWhere.bind_Than_Equal("createTime", auditingRecord.getEndTime(), "and"));
		}
		if(auditingRecord.getApplicant() != null && !auditingRecord.getApplicant().equals("")){
    			strHql.append(HqlWhere.bindEquals("lastPerson", auditingRecord.getApplicant(), "and"));
		}
			return strHql.toString();
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.inter.service.table.ApplyAuditingRecordService#findByHql(java.lang.String, java.lang.Object, com.tj720.mip.utils.Page)    
	 */
	@Override
	public List<?> findByHql(String hqlCondition, Object object, Page page) {
		// TODO Auto-generated method stub
		return null;
	}



}
