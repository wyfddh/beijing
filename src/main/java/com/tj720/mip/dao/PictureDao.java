package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.IPictureDao;
import com.tj720.mip.model.Picture;

@Repository("pictureDao")
public class PictureDao extends BaseDao<Picture>
		implements IPictureDao {

}