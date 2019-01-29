package com.tj720.mip.inter.service.table;

import java.util.List;

import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.Auth;
import com.tj720.mip.model.Role;
import com.tj720.mip.model.RoleAuth;

public interface IRoleService extends IBaseService<Role>{

	List<Auth> findBySql(String sql);
	void deleteById(String roleId);
	void save(RoleAuth ra);
	//通过角色名查询出角色id
	String findById(String sql);
	
	List<Role> queryBySql(String sql);

}
