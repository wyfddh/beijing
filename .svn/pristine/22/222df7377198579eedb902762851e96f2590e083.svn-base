package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipYearCategoryDao;
import com.tj720.mip.inter.service.table.IMipYearCategoryService;
import com.tj720.mip.model.MipYearCategory;

@Service
public class MipYearCategoryService extends BaseService<MipYearCategory> implements IMipYearCategoryService{

	@Resource(name="mipYearCategoryDao")
	IMipYearCategoryDao mipYearCategoryDao;
	
	@Resource(name="mipYearCategoryDao")
	public void setDao(IBaseDao<MipYearCategory> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipYearCategory get(String id){
		MipYearCategory model = mipYearCategoryDao.get(id);
		if(model == null)
			 return new MipYearCategory();
		return model;
	}

}
