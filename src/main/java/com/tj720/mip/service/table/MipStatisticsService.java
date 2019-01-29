package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipStatisticsDao;
import com.tj720.mip.inter.service.table.IMipStatisticsService;
import com.tj720.mip.model.MipStatistics;

@Service
public class MipStatisticsService extends BaseService<MipStatistics> implements IMipStatisticsService{

	@Resource(name="mipStatisticsDao")
	IMipStatisticsDao mipStatisticsDao;
	
	@Resource(name="mipStatisticsDao")
	public void setDao(IBaseDao<MipStatistics> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipStatistics get(String id){
		MipStatistics model = mipStatisticsDao.get(id);
		if(model == null)
			 return new MipStatistics();
		return model;
	}

}
