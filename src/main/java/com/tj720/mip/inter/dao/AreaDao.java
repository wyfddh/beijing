/** 
 * <pre>项目名称:mip 
 * 文件名称:MipAreaDao.java 
 * 包名:com.tj720.mip.inter.dao 
 * 创建日期:2017年2月23日下午4:23:47 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.inter.dao;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;

import com.tj720.mip.dto.AreaOrag;
import com.tj720.mip.dto.CityMuseum;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.model.MipArea;
import com.tj720.mip.utils.Page;

/** 
 * <pre>项目名称：mip    
 * 类名称：MipAreaDao    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月23日 下午4:23:47    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月23日 下午4:23:47    
 * 修改备注：       
 * @version </pre>    
 */
public interface AreaDao extends IBaseDao<MipArea>{

	
	List<T> selectByHql(String hql);

	/** <pre>queryHql(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月22日 下午2:06:05    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月22日 下午2:06:05    
	 * 修改备注： 
	 * @param hql
	 * @param map
	 * @param page
	 * @return</pre>    
	 */
	List<AreaOrag> queryHql(String hql, Map<String, Object> map, Page page);

}
