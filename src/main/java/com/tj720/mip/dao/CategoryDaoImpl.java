/** 
 * <pre>项目名称:mip 
 * 文件名称:CategoryDaoImpl.java 
 * 包名:com.tj720.mip.dao 
 * 创建日期:2017年3月7日下午7:56:00 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.CategoryDao;
import com.tj720.mip.model.Category;

/** 
 * <pre>项目名称：mip    
 * 类名称：CategoryDaoImpl    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月7日 下午7:56:00    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月7日 下午7:56:00    
 * 修改备注：       
 * @version </pre>    
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDao<Category> implements CategoryDao{
	
}	
