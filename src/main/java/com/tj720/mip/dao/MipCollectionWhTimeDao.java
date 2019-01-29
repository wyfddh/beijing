package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.IMipCollectionWhTimeDao;
import com.tj720.mip.model.MipCollectionWhTime;

@Repository("mipCollectionWhTimeDao")
public class MipCollectionWhTimeDao extends BaseDao<MipCollectionWhTime>
		implements IMipCollectionWhTimeDao {

}