package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.ICityDao;
import com.tj720.mip.inter.dao.IFCCollectionDao;
import com.tj720.mip.inter.dao.IMipCommentDao;
import com.tj720.mip.inter.dao.ISourceDao;
import com.tj720.mip.inter.dao.IYearTypeDao;
import com.tj720.mip.model.City;
import com.tj720.mip.model.FCCollection;
import com.tj720.mip.model.MipComment;
import com.tj720.mip.model.Source;
import com.tj720.mip.model.YearType;

@Repository("mipCommentDao")
public class MipCommentDao extends BaseDao<MipComment>
		implements IMipCommentDao {

}