/** 
 * <pre>项目名称:mip 
 * 文件名称:ArticleCategoryServiceImpl.java 
 * 包名:com.tj720.mip.service.table 
 * 创建日期:2017年3月29日上午11:26:20 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.ActivityCategoryDao;
import com.tj720.mip.inter.dao.ArticleCategoryDao;
import com.tj720.mip.inter.service.table.ActivityCategoryService;
import com.tj720.mip.model.ActivityCategory;
import com.tj720.mip.model.ArticleCategory;

/** 
 * <pre>项目名称：mip    
 * 类名称：ArticleCategoryServiceImpl    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月29日 上午11:26:20    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月29日 上午11:26:20    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class ActivityCategoryServiceImpl extends BaseService<ActivityCategory> implements ActivityCategoryService{

	@Resource(name="activityCategoryDao")
	ActivityCategoryDao activityCategoryDao;
	
	@Resource(name="activityCategoryDao")
	public void setDao(IBaseDao<ActivityCategory> dao) {
		super.setDao(dao);
	}
}
