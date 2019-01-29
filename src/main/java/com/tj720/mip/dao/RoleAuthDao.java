package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;
import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.IRoleAuthDao;
import com.tj720.mip.model.RoleAuth;

@Repository("roleAuthDao")
public class RoleAuthDao extends BaseDao<RoleAuth>
		implements IRoleAuthDao {

}