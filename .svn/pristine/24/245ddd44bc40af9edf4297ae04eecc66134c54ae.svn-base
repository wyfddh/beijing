package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipOpenCulturalrelicInfoDao;
import com.tj720.mip.inter.dao.IMipOpenFossilInfoDao;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IMipOpenFossilInfoService;
import com.tj720.mip.model.MipOpenCulturalrelicInfo;
import com.tj720.mip.model.MipOpenFossilInfo;

@Service
public class MipOpenFossilInfoService extends BaseService<MipOpenFossilInfo>
		implements IMipOpenFossilInfoService {

	@Resource(name="mipOpenFossilInfoDao")
	IMipOpenFossilInfoDao mipOpenFossilInfoDao;
	
	@Resource(name="mipOpenFossilInfoDao")
	public void setDao(IBaseDao<MipOpenFossilInfo> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipOpenFossilInfo get(String id){
		MipOpenFossilInfo model = mipOpenFossilInfoDao.get(id);
		if(model == null)
			 return new MipOpenFossilInfo();
		return model;
	}

}
