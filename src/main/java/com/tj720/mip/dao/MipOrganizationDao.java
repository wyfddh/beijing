package com.tj720.mip.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.IMipOrganizationDao;
import com.tj720.mip.model.MipOrganization;

@Repository("mipOrganizationDao")
public class MipOrganizationDao extends BaseDao<MipOrganization>
		implements IMipOrganizationDao {

	@Override
	public List<MipOrganization> queryBySql(String sql) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createSQLQuery(sql).addEntity(MipOrganization.class);
		return query.list();
	}

}