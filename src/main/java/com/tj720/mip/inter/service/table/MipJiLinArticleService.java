/** 
 * <pre>项目名称:mip 
 * 文件名称:MipJiLinArticleService.java 
 * 包名:com.tj720.mip.inter.service.table 
 * 创建日期:2017年3月28日上午11:27:41 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.inter.service.table;

import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.MipJiLinArticle;

/** 
 * <pre>项目名称：mip    
 * 类名称：MipJiLinArticleService    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月28日 上午11:27:41    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月28日 上午11:27:41    
 * 修改备注：       
 * @version </pre>    
 */
public interface MipJiLinArticleService extends IBaseService<MipJiLinArticle>{

	/** <pre>getSeachHql(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月28日 下午1:58:44    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月28日 下午1:58:44    
	 * 修改备注： 
	 * @param jiLinArticle
	 * @param keys
	 * @param staTime
	 * @param endTime
	 * @param level
	 * @param orgId
	 * @return</pre>    
	 */
	String getSeachHql(MipJiLinArticle jiLinArticle, String keys, Integer staTime, Integer endTime, byte level,
			String orgId);
	
}
