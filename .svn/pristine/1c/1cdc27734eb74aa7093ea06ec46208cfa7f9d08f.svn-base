package com.tj720.admin.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipOpenCulturalrelicInfoMapper;
import com.tj720.admin.model.MipOpenCulturalrelicInfo;
import com.tj720.admin.model.MipOpenCulturalrelicInfoExample;
import com.tj720.admin.model.MipOpenCulturalrelicInfoExample.Criteria;
import com.tj720.admin.model.MipOpenCulturalrelicInfoWithBLOBs;
import com.tj720.admin.model.MipStatistics;
import com.tj720.admin.service.MipOpenCulturalrelicInfoService;
import com.tj720.mip.utils.MyString;

@Service("MipOpenCulturalrelicInfoServiceImpl")
public class MipOpenCulturalrelicInfoServiceImpl extends BaseServiceImpl<MipOpenCulturalrelicInfo> implements MipOpenCulturalrelicInfoService{

	@Autowired
	MipOpenCulturalrelicInfoMapper mipOpenCulturalrelicInfoMapper;
	@Override
	public BaseDao<MipOpenCulturalrelicInfo> getBaseDao() {
		return mipOpenCulturalrelicInfoMapper;
	}
	@Override
	public MipOpenCulturalrelicInfoWithBLOBs getCulturalrelicInfo(String id) {
		return mipOpenCulturalrelicInfoMapper.selectByPrimaryKey(id);
	}
	@Override
	public int getCulturalrelicInfoCount(List<String> orgIdList) {
		MipOpenCulturalrelicInfoExample example = new MipOpenCulturalrelicInfoExample();
		Criteria criteria = example.createCriteria();
		List<Byte> list = new ArrayList<Byte>();
		list.add((byte)1);
		list.add((byte)2);
		criteria.andStatusIn(list);
//		criteria.andStatusNotEqualTo((byte)-127);
		criteria.andCollectionUnitIn(orgIdList);
		return mipOpenCulturalrelicInfoMapper.countByExample(example);
	}
	@Override
	public int countByOrgId(String orgId) {
		MipOpenCulturalrelicInfoExample example = new MipOpenCulturalrelicInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andCollectionUnitEqualTo(orgId);
		criteria.andStatusNotEqualTo((byte)-127);
		return mipOpenCulturalrelicInfoMapper.countByExample(example);
	}
}
