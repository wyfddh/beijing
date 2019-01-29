/** 
 * <pre>项目名称:mip 
 * 文件名称:VirtualDaoImpl.java 
 * 包名:com.tj720.mip.dao 
 * 创建日期:2017年1月14日上午11:23:51 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.MuseumInfoDao;
import com.tj720.mip.model.MuseumInfo;

/** 
 * <pre>项目名称：mip    
 * 类名称：VirtualDaoImpl    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月14日 上午11:23:51    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月14日 上午11:23:51    
 * 修改备注：       
 * @version </pre>    
 */
@Repository("MuseumInfoDao")
public class MuseInfoDaoImpl extends BaseDao<MuseumInfo> implements MuseumInfoDao{

	@Override
	public MuseumInfo getOneMuseum(String hql) {
		return (MuseumInfo) super.gethibernateTemplate().find(hql);
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.inter.dao.MuseumInfoDao#updateStatus(java.lang.String)    
	 */
	@Override
	@Transactional
	public void updateStatus(String sql) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql); 
		int executeUpdate = query.executeUpdate();  
		System.out.println(executeUpdate);
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.inter.dao.MuseumInfoDao#getAttr(java.lang.String)    
	 */
	@Override
	@Transactional
	public List<Map> getAttr(String hql) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql); 
		List<Map> list = query.list();
		
		return list;
	}
}
