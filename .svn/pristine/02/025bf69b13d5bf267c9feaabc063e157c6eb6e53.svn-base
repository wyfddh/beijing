/** 
 * <pre>项目名称:mip 
 * 文件名称:VirtualService.java 
 * 包名:com.tj720.mip.inter.service.table 
 * 创建日期:2017年1月14日上午11:18:41 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.inter.service.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tj720.mip.dto.MuseumAllDto;
import com.tj720.mip.dto.MuseumInfoDto;
import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.Category;
import com.tj720.mip.model.MuseumInfo;
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
public interface MuseumInfoService extends IBaseService<MuseumInfo>{

	/** <pre>getOneMuseum(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年1月17日 下午6:06:57    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年1月17日 下午6:06:57    
	 * 修改备注： 
	 * @param getmuseum
	 * @return</pre>    
	 */
	MuseumInfo getOneMuseum(String hql);

	/** <pre>updateStatus(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月16日 下午6:48:32    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月16日 下午6:48:32    
	 * 修改备注： 
	 * @param sql</pre>    
	 */
	void updateStatus(String sql);

	/** <pre>getAttr(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月16日 下午7:51:16    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月16日 下午7:51:16    
	 * 修改备注： 
	 * @param hql
	 * @return</pre>    
	 */
	List<Map> getAttr(String hql);

	/** <pre>getSeachHql(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月24日 下午2:11:26    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月24日 下午2:11:26    
	 * 修改备注： 
	 * @param museumInfo
	 * @return</pre>    
	 */
	String getSeachHql(MuseumInfo museumInfo);

	/** <pre>getMuseumHql(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月27日 下午2:30:02    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月27日 下午2:30:02    
	 * 修改备注： 
	 * @param museumDto
	 * @param orgIds 
	 * @return</pre>    
	 */
	String getMuseumHql(MuseumAllDto museumDto, int platformId, String orgIds);

	/** <pre>queryByDto(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月27日 下午2:33:20    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月27日 下午2:33:20    
	 * 修改备注： 
	 * @param hql
	 * @param map
	 * @param page
	 * @return</pre>    
	 */
	List<?> queryByDto(String hql, Map<String, Object> map, Page page);

	MuseumInfoDto getDetail(String museumId);
	
}
