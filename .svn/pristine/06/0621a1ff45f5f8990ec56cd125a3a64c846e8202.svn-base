/** 
 * <pre>项目名称:mip 
 * 文件名称:VirtualService.java 
 * 包名:com.tj720.mip.inter.service.table 
 * 创建日期:2017年1月14日上午11:18:41 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.inter.service.table;

import java.util.List;

import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.ApplyAuditingRecord;
import com.tj720.mip.utils.Page;

/** 
 * <pre>项目名称：mip    
 * 类名称：VirtualService    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月14日 上午11:18:41    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月14日 上午11:18:41    
 * 修改备注：       
 * @version </pre>    
 */
public interface ApplyAuditingRecordService extends IBaseService<ApplyAuditingRecord>{


	/** <pre>getHqlCondition(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年2月6日 下午4:09:31    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年2月6日 下午4:09:31    
	 * 修改备注： 
	 * @param auditingRecord
	 * @param modelName 
	 * @param status 
	 * @return</pre>    
	 */
	String getHqlCondition(ApplyAuditingRecord auditingRecord, String modelName, String status);

	/** <pre>findByHql(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年2月7日 下午2:19:02    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年2月7日 下午2:19:02    
	 * 修改备注： 
	 * @param hqlCondition
	 * @param object
	 * @param page
	 * @return</pre>    
	 */
	List<?> findByHql(String hqlCondition, Object object, Page page);
}
