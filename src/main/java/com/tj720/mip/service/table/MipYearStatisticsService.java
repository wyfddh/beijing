package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipYearStatisticsDao;
import com.tj720.mip.inter.service.table.IMipYearStatisticsService;
import com.tj720.mip.model.MipYearStatistics;

@Service
public class MipYearStatisticsService extends BaseService<MipYearStatistics> implements IMipYearStatisticsService{

	@Resource(name="mipYearStatisticsDao")
	IMipYearStatisticsDao mipYearStatisticsDao;
	
	@Resource(name="mipYearStatisticsDao")
	public void setDao(IBaseDao<MipYearStatistics> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipYearStatistics get(String id){
		MipYearStatistics model = mipYearStatisticsDao.get(id);
		if(model == null)
			 return new MipYearStatistics();
		return model;
	}

}
