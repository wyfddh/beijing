package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.IMipCollectionLevelDao;
import com.tj720.mip.model.MipCollectionLevel;

@Repository("mipCollectionLevelDao")
public class MipCollectionLevelDao extends BaseDao<MipCollectionLevel>
		implements IMipCollectionLevelDao {

}