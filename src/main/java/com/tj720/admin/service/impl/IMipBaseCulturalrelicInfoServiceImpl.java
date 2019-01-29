package com.tj720.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipBaseCulturalrelicInfoMapper;
import com.tj720.admin.model.MipBaseCulturalrelicInfo;
import com.tj720.admin.model.MipBaseCulturalrelicInfoExample;
import com.tj720.admin.model.MipBaseCulturalrelicInfoExample.Criteria;
import com.tj720.admin.service.IMipBaseCulturalrelicInfoService;

@Service("IMipBaseCulturalrelicInfoServiceImpl")
public class IMipBaseCulturalrelicInfoServiceImpl extends BaseServiceImpl<MipBaseCulturalrelicInfo> implements IMipBaseCulturalrelicInfoService{

	@Autowired
	MipBaseCulturalrelicInfoMapper mipBaseCulturalrelicInfoMapper;
	@Override
	public BaseDao<MipBaseCulturalrelicInfo> getBaseDao() {
		return mipBaseCulturalrelicInfoMapper;
	}
	@Override
	public int getCulturalrelicInfoCount() {
		MipBaseCulturalrelicInfoExample example = new MipBaseCulturalrelicInfoExample();
		return mipBaseCulturalrelicInfoMapper.countByExample(example);
	}
	@Override
	public int countByOrgId(String orgId) {
		MipBaseCulturalrelicInfoExample example = new MipBaseCulturalrelicInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andCollectionUnitEqualTo(orgId);
		return mipBaseCulturalrelicInfoMapper.countByExample(example);
	}

}
