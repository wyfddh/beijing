/** 
 * <pre>项目名称:mip 
 * 文件名称:AreaService.java 
 * 包名:com.tj720.mip.inter.service.table 
 * 创建日期:2017年2月23日下午4:21:51 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.inter.service.table;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;

import com.tj720.mip.dto.AreaOrag;
import com.tj720.mip.dto.CityMuseum;
import com.tj720.mip.dto.MuseumInfoDto;
import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.MipArea;
import com.tj720.mip.utils.Page;

/** 
 * <pre>项目名称：mip    
 * 类名称：AreaService    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月23日 下午4:21:51    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月23日 下午4:21:51    
 * 修改备注：       
 * @version </pre>    
 */
public interface AreaService extends IBaseService<MipArea>{

	/** <pre>selectByHql(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年2月23日 下午7:20:30    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年2月23日 下午7:20:30    
	 * 修改备注： 
	 * @param hql</pre>    
	 * @return 
	 */
	List<T> selectByHql(String hql);

	/** <pre>getOrgList(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月2日 下午2:53:41    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月2日 下午2:53:41    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<CityMuseum> getOrgList();

	
	List<CityMuseum> getOrgListMB();
	
	

	/** <pre>queryByDto(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月24日 下午5:25:07    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月24日 下午5:25:07    
	 * 修改备注： 
	 * @param hql
	 * @param map
	 * @param page
	 * @return</pre>    
	 */
	List<?> queryByDto(String hql, Map<String, Object> map, Page page);

	/** <pre>getSeachHql(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月27日 下午1:20:24    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月27日 下午1:20:24    
	 * 修改备注： 
	 * @param museumInfoDto 
	 * @return</pre>    
	 */
	String getSeachHql(MuseumInfoDto museumInfoDto);
	String getSeachHqlMB(MuseumInfoDto museumInfoDto);

}
