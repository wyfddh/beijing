/** 
 * <pre>项目名称:mip 
 * 文件名称:ApplyAuditingRecordDaoImpl.java 
 * 包名:com.tj720.mip.dao 
 * 创建日期:2017年1月20日下午7:20:42 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.dao;


import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.ApplyAuditingRecordDao;
import com.tj720.mip.model.ApplyAuditingRecord;

/** 
 * <pre>项目名称：mip    
 * 类名称：ApplyAuditingRecordDaoImpl    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月20日 下午7:20:42    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月20日 下午7:20:42    
 * 修改备注：       
 * @version </pre>    
 */
@Repository("ApplyAuditingRecord")
public class ApplyAuditingRecordDaoImpl extends BaseDao<ApplyAuditingRecord> implements ApplyAuditingRecordDao{

	/** <pre>findByObj(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年2月5日 下午6:38:30    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年2月5日 下午6:38:30    
	 * 修改备注： 
	 * @param obj</pre>    
	 */
	public void findByObj(Object obj) {
		//gethibernateTemplate().fin
	}
	
	
}
