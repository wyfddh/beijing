package com.tj720.mip.service.table;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.AuthDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.inter.service.table.IAuthService;
import com.tj720.mip.model.Auth;

@Service
public class AuthService extends BaseService<Auth> implements IAuthService{
	
	@Resource(name="authDao")
	AuthDao authDao;
	
	@Resource(name="authDao")
	public void setDao(IBaseDao<Auth> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public Auth get(String id){
		Auth model = authDao.get(id);
		if(model == null)
			 return new Auth();
		return model;
	}
	
	
}
