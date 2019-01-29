/** 
 * <pre>项目名称:mip 
 * 文件名称:VirtualDaoImpl.java 
 * 包名:com.tj720.mip.dao 
 * 创建日期:2017年1月14日上午11:23:51 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.dao;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.MuseumColumnDao;
import com.tj720.mip.inter.dao.VirtualDao;
import com.tj720.mip.model.MuseumColumn;
import com.tj720.mip.model.VirtualShowroom;

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
@Repository("museumColumnDao")
public class MuseumColumnDaoImpl extends BaseDao<MuseumColumn> implements MuseumColumnDao{

	@Override
	public void updateForStatus(final MuseumColumn column) {

		this.gethibernateTemplate().execute(new HibernateCallback<T>() {

			@Override
			public T doInHibernate(Session session) throws HibernateException {
				String sql = "update MuseumColumn set Status = ? where id = ?";
				Query query = session.createQuery(sql);
				query.setParameter(0, column.getStatus())
					 .setParameter(1,column.getId());
				query.executeUpdate();
				return null;
			}
		});
	
	}
	
}
