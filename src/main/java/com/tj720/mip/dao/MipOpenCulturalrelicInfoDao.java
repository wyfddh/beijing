package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.IFCCollectionDao;
import com.tj720.mip.inter.dao.IMipOpenCulturalrelicInfoDao;
import com.tj720.mip.inter.dao.ISourceDao;
import com.tj720.mip.model.FCCollection;
import com.tj720.mip.model.MipOpenCulturalrelicInfo;
import com.tj720.mip.model.Source;

@Repository("mipOpenCulturalrelicInfoDao")
public class MipOpenCulturalrelicInfoDao extends BaseDao<MipOpenCulturalrelicInfo>
		implements IMipOpenCulturalrelicInfoDao {

}