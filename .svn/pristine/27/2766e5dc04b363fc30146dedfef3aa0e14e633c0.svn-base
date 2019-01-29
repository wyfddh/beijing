/** 
 * <pre>项目名称:mip 
 * 文件名称:CategoryServiceImpl.java 
 * 包名:com.tj720.mip.service.table 
 * 创建日期:2017年3月7日下午7:53:54 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.CategoryDao;
import com.tj720.mip.inter.service.table.CategoryService;
import com.tj720.mip.model.Category;

/** 
 * <pre>项目名称：mip    
 * 类名称：CategoryServiceImpl    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月7日 下午7:53:54    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月7日 下午7:53:54    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class CategoryServiceImpl extends BaseService<Category> implements CategoryService{
	@Resource(name="categoryDao")
	CategoryDao categoryDao;
	
	@Resource(name="categoryDao")
	public void setDao(IBaseDao<Category> dao) {
		super.setDao(dao);
	}
}
