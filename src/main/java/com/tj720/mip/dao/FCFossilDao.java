package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.IFCCollectionDao;
import com.tj720.mip.inter.dao.IFCFossilDao;
import com.tj720.mip.inter.dao.ISourceDao;
import com.tj720.mip.model.FCCollection;
import com.tj720.mip.model.FCFossil;
import com.tj720.mip.model.Source;

@Repository("fCFossilDao")
public class FCFossilDao extends BaseDao<FCFossil>
		implements IFCFossilDao {

}