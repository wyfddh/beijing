package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.IModuleDao;
import com.tj720.mip.model.Module;

@Repository("dataCenterDao")
public class ModuleDao extends BaseDao<Module>
		implements IModuleDao {

}