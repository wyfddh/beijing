package com.tj720.mip.inter.dao;

import java.util.List;

import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.model.Auth;
import com.tj720.mip.model.Role;
import com.tj720.mip.model.RoleAuth;

public interface IRoleDao extends IBaseDao<Role>{

	//通过角色id和中间表查询出角色所有的权限集合 by GuHao
	List<Auth> findBySql(String sql);
	//根据角色id删除中间表中角色的权限
	void deleteById(String roleId);
	//保存角色权限
	void save(RoleAuth ra);
	//通过角色名查询出角色id
	String findById(String sql);
	//通过角色id查询出所有子角色
	List<Role> queryBySql(String sql);
	

}