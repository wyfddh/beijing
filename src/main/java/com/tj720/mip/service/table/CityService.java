package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.CityDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.ICityDao;
import com.tj720.mip.inter.service.table.ICityService;
import com.tj720.mip.model.City;

@Service
public class CityService extends BaseService<City> implements ICityService{

	@Resource(name="cityDao")
	ICityDao cityDao;
	
	@Resource(name="cityDao")
	public void setDao(IBaseDao<City> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public City get(String id){
		City model = cityDao.get(id);
		if(model == null)
			 return new City();
		return model;
	}

}
