/** 
 * <pre>项目名称:mip 
 * 文件名称:MipJiLinArticleServiceImpl.java 
 * 包名:com.tj720.mip.service.table 
 * 创建日期:2017年3月28日上午11:29:25 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.MipJiLinArticleDao;
import com.tj720.mip.inter.service.table.MipJiLinArticleService;
import com.tj720.mip.model.MipJiLinArticle;

/** 
 * <pre>项目名称：mip    
 * 类名称：MipJiLinArticleServiceImpl    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月28日 上午11:29:25    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月28日 上午11:29:25    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class MipJiLinArticleServiceImpl extends BaseService<MipJiLinArticle> implements MipJiLinArticleService{
	@Resource(name="mipJiLinArticleDao")
	MipJiLinArticleDao mipJiLinArticleDao;
	
	@Resource(name="mipJiLinArticleDao")
	public void setDao(IBaseDao<MipJiLinArticle> dao) {
		super.setDao(dao);
	}

	/** <pre>getSeachHql(这里用一句话描述这个方法的作用)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年3月28日 下午1:48:57    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年3月28日 下午1:48:57    
	 * 修改备注： 
	 * @param jiLinArticle
	 * @param keys
	 * @param staTime
	 * @param endTime
	 * @param level
	 * @param orgId
	 * @return</pre>    
	 */
	public String getSeachHql(MipJiLinArticle jiLinArticle, String keys, Integer staTime, Integer endTime, byte level,
			String orgId) {
		StringBuffer seachHql = new StringBuffer(" from MipJiLinArticle where 1=1 ");
		if(jiLinArticle.getPublish() == -127){
			seachHql.append(" and publish > -128 ");
		}
		if(jiLinArticle.getPublish() != -127){
			seachHql.append(" and publish =  " + jiLinArticle.getPublish());
		}
		if(keys != null && !keys.equals("")){
			String key = keys.replace(" ", "");
			seachHql.append(" and ( content like '%"+key+"%' or headline like '%"+key+"%' )");
		}
		if(staTime != null && !staTime.equals(0)){
			seachHql.append(" and publishTime >=  " + staTime);
		}
		if(endTime != null && !endTime.equals(0)){
			seachHql.append(" and publishTime <=  " + endTime);
		}
		if(jiLinArticle.getArticleCategory() != null && jiLinArticle.getArticleCategory() != 0){
			seachHql.append(" and articleCategory =  " + jiLinArticle.getArticleCategory());
		}
		if (level == 3) {
			seachHql.append(" and orgId =  " + orgId);
		}
		if (level == 2 || level == 1) {
			seachHql.append(" and orgId in (" + orgId + ")");
		}
		seachHql.append(" ORDER BY createTime DESC ");
		return seachHql.toString();
	}
}
