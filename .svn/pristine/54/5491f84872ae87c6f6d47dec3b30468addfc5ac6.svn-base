/** 
 * <pre>项目名称:mip 
 * 文件名称:AreaDaoimpl.java 
 * 包名:com.tj720.mip.dao 
 * 创建日期:2017年2月23日下午4:27:28 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.dao;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.tj720.mip.dto.AreaOrag;
import com.tj720.mip.dto.CityMuseum;
import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.AreaDao;
import com.tj720.mip.model.MipArea;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/** 
 * <pre>项目名称：mip    
 * 类名称：AreaDaoimpl    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月23日 下午4:27:28    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月23日 下午4:27:28    
 * 修改备注：       
 * @version </pre>    
 */
@Repository("areaDao")
public class AreaDaoimpl extends BaseDao<MipArea> implements AreaDao{

	/* (non-Javadoc)    
	 * @see com.tj720.mip.inter.dao.AreaDao#selectByHql(java.lang.String)    
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> selectByHql(String hql) {
		Session currentSession = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query = currentSession.createSQLQuery(hql);
		List<T> list = query.list();
		return list;
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.inter.dao.AreaDao#queryHql(java.lang.String, java.util.Map, com.tj720.mip.utils.Page)    
	 */
	@Override
	public List<AreaOrag> queryHql(String hql, Map<String, Object> map, Page pageBean) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		if(pageBean!=null){
			pageBean.setAllRow(  getCount(map, hql.toUpperCase().indexOf(" WHERE ")>0? hql.substring(  hql.toUpperCase().indexOf(" WHERE")  ) : "")  );
			if(pageBean.getCurrentPage()>pageBean.getTotalPage())
				pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		Tools.setPage(query, pageBean);
		Tools.setQuery(map, query);
		return query.list();
	}

	
}
