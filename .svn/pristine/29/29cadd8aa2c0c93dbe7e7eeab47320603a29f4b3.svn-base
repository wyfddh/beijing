/** 
 * <pre>项目名称:mip 
 * 文件名称:ApplyAuditingRecordServiceImpl.java 
 * 包名:com.tj720.mip.service.table 
 * 创建日期:2017年1月20日下午7:19:22 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj720.mip.dao.ApplicationDetailsDaoImpl;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.ApplicationDetailsService;
import com.tj720.mip.model.ApplicationDetails;
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
public class ApplicationDetailsServiceImpl extends BaseService<ApplicationDetails> implements ApplicationDetailsService{
	@Resource(name="ApplicationDetailsDao")
	ApplicationDetailsDaoImpl ApplicationDetails;

	@Resource(name="ApplicationDetailsDao")
	public void setDao(IBaseDao<ApplicationDetails> dao) {
		super.setDao(dao);
	}
}
