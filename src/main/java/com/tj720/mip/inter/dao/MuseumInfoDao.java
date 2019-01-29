/** 
 * <pre>项目名称:mip 
 * 文件名称:VirtualService.java 
 * 包名:com.tj720.mip.inter.service.table 
 * 创建日期:2017年1月14日上午11:18:41 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.inter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.MuseumInfo;

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
public interface MuseumInfoDao extends IBaseDao<MuseumInfo>{

	/** <pre>getOneMuseum(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年1月17日 下午6:07:43    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年1月17日 下午6:07:43    
	 * 修改备注： 
	 * @param hql
	 * @return</pre>    
	 */
	MuseumInfo getOneMuseum(String hql);

	/** <pre>updateStatus(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月16日 下午6:48:53    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月16日 下午6:48:53    
	 * 修改备注： 
	 * @param sql</pre>    
	 */
	void updateStatus(String sql);

	/** <pre>getAttr(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月16日 下午7:52:31    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月16日 下午7:52:31    
	 * 修改备注： 
	 * @param hql
	 * @return</pre>    
	 */
	List<Map> getAttr(String hql);
}
