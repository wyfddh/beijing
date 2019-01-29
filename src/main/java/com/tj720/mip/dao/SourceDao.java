package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.ISourceDao;
import com.tj720.mip.model.Source;

@Repository("sourceDao")
public class SourceDao extends BaseDao<Source>
		implements ISourceDao {

}