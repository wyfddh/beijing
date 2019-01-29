package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.IPictureSearchConfigDao;
import com.tj720.mip.model.PictureSearchConfig;

@Repository("pictureSearchConfigDao")
public class PictureSearchConfigDao extends BaseDao<PictureSearchConfig>
		implements IPictureSearchConfigDao {

}