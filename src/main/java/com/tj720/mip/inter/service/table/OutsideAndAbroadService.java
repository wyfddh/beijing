/** 
 * <pre>项目名称:mip 
 * 文件名称:OutsideAndAbroadService.java 
 * 包名:com.tj720.mip.inter.service.table 
 * 创建日期:2017年2月13日上午11:00:15 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.inter.service.table;

import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.OutsideAndAbroad;


/** 
 * <pre>项目名称：mip    
 * 类名称：OutsideAndAbroadService    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月13日 上午11:00:15    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月13日 上午11:00:15    
 * 修改备注：       
 * @version </pre>    
 */
public interface OutsideAndAbroadService extends IBaseService<OutsideAndAbroad>{

	/** <pre>getSeachHql(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月4日 下午2:45:58    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月4日 下午2:45:58    
	 * 修改备注： 
	 * @param otherSpreadtrum
	 * @param keys
	 * @param endTime 
	 * @param staTime 
	 * @return</pre>    
	 */
	String getSeachHql(OutsideAndAbroad otherSpreadtrum, String keys, Long staTime, Long endTime);

}
