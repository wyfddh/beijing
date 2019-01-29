package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.ICityDao;
import com.tj720.mip.inter.dao.IFCCollectionDao;
import com.tj720.mip.inter.dao.IMipCollectDao;
import com.tj720.mip.inter.dao.ISourceDao;
import com.tj720.mip.inter.dao.IYearTypeDao;
import com.tj720.mip.model.City;
import com.tj720.mip.model.FCCollection;
import com.tj720.mip.model.MipCollect;
import com.tj720.mip.model.Source;
import com.tj720.mip.model.YearType;

@Repository("mipCollectDao")
public class MipCollectDao extends BaseDao<MipCollect>
		implements IMipCollectDao {

}