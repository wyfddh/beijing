package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipDeleteCulturalrelicInfoDao;
import com.tj720.mip.inter.service.table.IMipDeleteCulturalrelicInfoService;
import com.tj720.mip.model.MipDeleteCulturalrelicInfo;

@Service
public class MipDeleteCulturalrelicInfoService extends BaseService<MipDeleteCulturalrelicInfo>
		implements IMipDeleteCulturalrelicInfoService {

	@Resource(name="mipDeleteCulturalrelicInfoDao")
	IMipDeleteCulturalrelicInfoDao mipDeleteCulturalrelicInfoDao;
	
	@Resource(name="mipDeleteCulturalrelicInfoDao")
	public void setDao(IBaseDao<MipDeleteCulturalrelicInfo> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipDeleteCulturalrelicInfo get(String id){
		MipDeleteCulturalrelicInfo model = mipDeleteCulturalrelicInfoDao.get(id);
		if(model == null)
			 return new MipDeleteCulturalrelicInfo();
		return model;
	}

}
