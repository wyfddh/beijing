package com.tj720.mip.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.IRoleDao;
import com.tj720.mip.model.Auth;
import com.tj720.mip.model.Role;
import com.tj720.mip.model.RoleAuth;

@Repository("roleDao")
public class RoleDao extends BaseDao<Role>
		implements IRoleDao {
	/**
	 * 实现方法，应用sql查询三表 
	 * by GuHao
	 * */

	@Override
	public List<Auth> findBySql(String sql) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createSQLQuery(sql);
		
		return query.list();
	}

	@Override
	public void deleteById(String roleId) {
		hibernateTemplate.getSessionFactory().getCurrentSession()
				.delete(roleId);
		
	}

	@Override
	public void save(RoleAuth ra) {
		hibernateTemplate.getSessionFactory().getCurrentSession()
		.save(ra);
		
	}

	@Override
	public String findById(String sql) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createSQLQuery(sql);
		
		return (String) query.uniqueResult();
	}

	@Override
	public List<Role> queryBySql(String sql) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createSQLQuery(sql).addEntity(Role.class);
		return query.list();
	}


}