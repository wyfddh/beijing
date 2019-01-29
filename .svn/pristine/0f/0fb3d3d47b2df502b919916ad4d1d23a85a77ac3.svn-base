package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.UserTagsDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.IUserTagsService;
import com.tj720.mip.model.UserTags;

@Service
public class UserTagsService extends BaseService<UserTags> implements IUserTagsService{

	@Resource(name="userTagsDao")
	UserTagsDao userTagsDao;
	
	@Resource(name="cityDao")
	public void setDao(IBaseDao<UserTags> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public UserTags get(String id){
		UserTags model = userTagsDao.get(id);
		if(model == null)
			 return new UserTags();
		return model;
	}

}
