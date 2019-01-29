package com.tj720.mip.service.table;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IRoleDao;
import com.tj720.mip.inter.service.table.IRoleService;
import com.tj720.mip.model.Auth;
import com.tj720.mip.model.Role;
import com.tj720.mip.model.RoleAuth;

@Service
public class RoleService extends BaseService<Role>
		implements IRoleService {
	
	@Autowired
	private IRoleDao roleDao;
	
	@Resource(name="roleDao")
	public void setDao(IBaseDao<Role> dao) {
		super.setDao(dao);
	}
	@Override
	@Transactional
	public Role get(String id){
		Role model = roleDao.get(id);
		if(model == null)
			 return new Role();
		return model;
	}


	@Override
	public List<Auth> findBySql(String sql) {
		
		return roleDao.findBySql(sql);
	}
	@Override
	public void deleteById(String roleId) {
		roleDao.deleteById(roleId);
		
	}
	@Override
	public void save(RoleAuth ra) {
		roleDao.save(ra);
	}
	@Override
	public String findById(String sql) {		// TODO Auto-generated method stub
		return roleDao.findById(sql);
	}
	
	@Override
	@Transactional
	public List<Role> queryBySql(String sql) {
		
		return roleDao.queryBySql(sql);
	}
}
