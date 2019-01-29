package com.tj720.mip.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.IUserDao;
import com.tj720.mip.model.User;

@Repository("userDao")
public class UserDao extends BaseDao<User>
		implements IUserDao {

	@Override
	public int getCountBySql(String sql) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createSQLQuery(sql);
		
		return (int) query.uniqueResult();
	}

	@Override
	public String getBySql(String sql) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createSQLQuery(sql);
		return  (String) query.uniqueResult();
	}

	@Override
	public List<User> queryListBySql(String sql) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createSQLQuery(sql).addEntity(User.class);
		return query.list();
	}

	@Override
	public User findOne(String hql) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		return (User) query.uniqueResult();
	}

	@Override
	public String findMaxByHql(String phoneStart) {
		Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createCriteria(User.class);
		criteria.add(Restrictions.ilike("phone", phoneStart, MatchMode.START));
		String phone = (String) criteria.setProjection(Projections.projectionList().add(Projections.max("phone"))).uniqueResult();
		return phone;
	}

	

	

}