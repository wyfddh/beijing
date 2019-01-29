package com.tj720.mip.inter.dao;

import java.util.List;

import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.model.MipOrganization;

public interface IMipOrganizationDao extends IBaseDao<MipOrganization>{
	public List<MipOrganization> queryBySql(String sql);

}