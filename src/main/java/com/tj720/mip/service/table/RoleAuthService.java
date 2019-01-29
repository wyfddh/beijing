package com.tj720.mip.service.table;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.RoleAuthDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.IRoleAuthService;
import com.tj720.mip.model.RoleAuth;
@Service
public class RoleAuthService extends BaseService<RoleAuth>
          implements IRoleAuthService{
	
	@Resource(name="roleAuthDao")
	RoleAuthDao roleAuthDao;
	
	@Resource(name="roleAuthDao")
	public void setDao(IBaseDao<RoleAuth> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public RoleAuth get(String id){
		RoleAuth model = roleAuthDao.get(id);
		if(model == null)
			 return new RoleAuth();
		return model;
	}


}
