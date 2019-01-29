package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.UserRoleDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.IUserRoleService;
import com.tj720.mip.model.UserRole;
import com.tj720.mip.model.UserRole;

@Service
public class UserRoleService extends BaseService<UserRole> implements IUserRoleService{
	
	@Resource(name="userRoleDao")
	UserRoleDao userRoleDao;
	
	@Resource(name="userRoleDao")
	public void setDao(IBaseDao<UserRole> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public UserRole get(String id){
		UserRole model = userRoleDao.get(id);
		if(model == null)
			 return new UserRole();
		return model;
	}


}
