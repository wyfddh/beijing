package com.tj720.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipBaseFossilInfoMapper;
import com.tj720.admin.model.MipBaseFossilInfo;
import com.tj720.admin.model.MipBaseFossilInfoExample;
import com.tj720.admin.model.MipBaseFossilInfoExample.Criteria;
import com.tj720.admin.service.IMipBaseFossilInfoService;

@Service("IMipBaseFossilInfoServiceImpl")
public class IMipBaseFossilInfoServiceImpl extends BaseServiceImpl<MipBaseFossilInfo> implements IMipBaseFossilInfoService{

	@Autowired
	MipBaseFossilInfoMapper mipBaseFossilInfoMapper;
	@Override
	public BaseDao<MipBaseFossilInfo> getBaseDao() {
		return mipBaseFossilInfoMapper;
	}
	@Override
	public int getFossilInfoCount() {
		MipBaseFossilInfoExample example = new MipBaseFossilInfoExample();
		return mipBaseFossilInfoMapper.countByExample(example);
	}
	@Override
	public int countByOrgId(String orgId) {
		MipBaseFossilInfoExample example = new MipBaseFossilInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andCollectionUnitEqualTo(orgId);
		return mipBaseFossilInfoMapper.countByExample(example);
	}

}
