package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IProjectUserDao;
import com.tj720.mip.inter.service.table.IProjectUserService;
import com.tj720.mip.model.ProjectUser;

@Service
public class ProjectUserService extends BaseService<ProjectUser>
		implements IProjectUserService{
	@Resource(name="projectUserDao")
	IProjectUserDao projectUserDao;

	@Resource(name="projectUserDao")
	public void setDao(IBaseDao<ProjectUser> projectUserDao) {
		super.setDao(projectUserDao);
	}
	
	@Override
	@Transactional
	public ProjectUser get(String id){
		ProjectUser model = projectUserDao.get(id);
		if(model == null)
			 return new ProjectUser();
		return model;
	}
	
}
