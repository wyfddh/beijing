/** 
 * <pre>项目名称:mip 
 * 文件名称:OutsideAndAbroadServiceImpl.java 
 * 包名:com.tj720.mip.service.table 
 * 创建日期:2017年2月13日上午11:01:01 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.service.table;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.OutsideAndAbroadDao;
import com.tj720.mip.inter.service.table.OutsideAndAbroadService;
import com.tj720.mip.model.OutsideAndAbroad;
import com.tj720.mip.utils.Tools;

/** 
 * <pre>项目名称：mip    
 * 类名称：OutsideAndAbroadServiceImpl    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月13日 上午11:01:01    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月13日 上午11:01:01    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class OutsideAndAbroadServiceImpl extends BaseService<OutsideAndAbroad>  implements OutsideAndAbroadService {
	@Resource(name="OutsideAndAbroadDao")
	OutsideAndAbroadDao outsideAndAbroadDao;
	
	@Resource(name="OutsideAndAbroadDao")
	public void setDao(IBaseDao<OutsideAndAbroad> dao) {
		super.setDao(dao);
	}

	@Override
	public String getSeachHql(OutsideAndAbroad otherSpreadtrum, String keys, Long staTime, Long endTime) {
		StringBuffer seachHql = new StringBuffer(" from OutsideAndAbroad where 1=1 ");
		if(otherSpreadtrum.getPublish() == -128){
			seachHql.append(" and publish > -128 ");
		}
		if(otherSpreadtrum.getPublish() != -128){
			seachHql.append(" and publish =  " + otherSpreadtrum.getPublish());
		}
		if(otherSpreadtrum.getType() != 0){
			seachHql.append(" and type =  " + otherSpreadtrum.getType());
		}
		if(keys != null && !keys.equals("")){
			String key = keys.replace(" ", "");
			seachHql.append(" and ( content like '%"+key+"%' or headline like '%"+key+"%' or musExhibition like '%"+key+"%' )");
		}
		if(staTime != null && !staTime.equals(0)){
			seachHql.append(" and publishTime >=  " + staTime);
		}
		if(endTime != null && !endTime.equals(0)){
			seachHql.append(" and publishTime <=  " + endTime);
		}
		if(otherSpreadtrum.getUserName() != null && !otherSpreadtrum.getUserName().equals("")){
			seachHql.append(" and userName =  '" + otherSpreadtrum.getUserName().replace(" ", "")+"'");
		}
		seachHql.append(" ORDER BY createTime DESC ");
		return seachHql.toString();
	}
	
}
