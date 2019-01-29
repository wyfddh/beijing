package com.tj720.mip.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.ImuseumSubjectDao;
import com.tj720.mip.model.MuseumInfo;
import com.tj720.mip.model.MuseumSubject;

@Repository("ImuseumSubjectDao")
public class MuseumSubjectDaoImpl extends BaseDao<MuseumSubject> implements ImuseumSubjectDao{

	@Override
	public MuseumSubject getOneMuseum(String hql) {
		return (MuseumSubject) super.gethibernateTemplate().find(hql);
	}
	@Override
	@Transactional
	public List<Map> getAttr(String hql) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql); 
		List<Map> list = query.list();
		return list;
	}
}

