package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipOpenCulturalrelicInfoDao;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.model.MipOpenCulturalrelicInfo;

@Service
public class MipOpenCulturalrelicInfoService extends BaseService<MipOpenCulturalrelicInfo>
		implements IMipOpenCulturalrelicInfoService {

	@Resource(name="mipOpenCulturalrelicInfoDao")
	IMipOpenCulturalrelicInfoDao mipOpenCulturalrelicInfoDao;
	
	@Resource(name="mipOpenCulturalrelicInfoDao")
	public void setDao(IBaseDao<MipOpenCulturalrelicInfo> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipOpenCulturalrelicInfo get(String id){
		MipOpenCulturalrelicInfo model = mipOpenCulturalrelicInfoDao.get(id);
		if(model == null)
			 return new MipOpenCulturalrelicInfo();
		return model;
	}

}
