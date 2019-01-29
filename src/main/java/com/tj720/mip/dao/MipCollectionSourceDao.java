package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.IMipCollectionSourceDao;
import com.tj720.mip.model.MipCollectionSource;

@Repository("mipCollectionSourceDao")
public class MipCollectionSourceDao extends BaseDao<MipCollectionSource>
		implements IMipCollectionSourceDao {

}