/** 
 * <pre>项目名称:mip 
 * 文件名称:MipWenchuangService.java 
 * 包名:com.tj720.mip.inter.service.table 
 * 创建日期:2017年3月28日下午4:54:47 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.inter.service.table;

import java.util.List;
import java.util.Map;

import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.MipWenchuang;
import com.tj720.mip.utils.Page;

/** 
 * <pre>项目名称：mip    
 * 类名称：MipWenchuangService    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月28日 下午4:54:47    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月28日 下午4:54:47    
 * 修改备注：       
 * @version </pre>    
 */
public interface MipWenchuangService extends IBaseService<MipWenchuang>{

	/** <pre>getSeachHql(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月28日 下午5:23:38    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月28日 下午5:23:38    
	 * 修改备注： 
	 * @param wenchuang
	 * @param keys
	 * @param level
	 * @param orgId
	 * @return</pre>    
	 */
	String getSeachHql(MipWenchuang wenchuang, String keys, String orgId);
	
	/**
	 * 获取列表数据
	 * @param key		关键词
	 * @param publish		状态
	 * @param categoryId		类别
	 * @param staPrice		开始价格
	 * @param overPrice		结束价格
	 * @param orgId			博物馆id
	 * @param orgList			博物馆集合
	 * @return
	 */
	List<MipWenchuang> getList(String key, String publish, String categoryId, String staPrice, String overPrice, String orgId, List<String> orgList, Page page, String currentOrg);
	
	/**
	 * 获取当前文创的相关文创
	 * @param categoryId
	 * @param size
	 * @return
	 */
	List<MipWenchuang> getReleList(String currentId, String categoryId, Integer size);
	
	/**
	 * 保存自定义表单数据
	 * @param map
	 * @param userId
	 * @param orgId
	 * @return
	 */
	MipWenchuang saveDesignData(Map<String, Object> map, String userId, String orgId);
	
}
