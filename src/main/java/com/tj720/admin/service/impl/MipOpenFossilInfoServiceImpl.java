package com.tj720.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipOpenFossilInfoMapper;
import com.tj720.admin.model.MipOpenFossilInfo;
import com.tj720.admin.model.MipOpenFossilInfoExample;
import com.tj720.admin.model.MipOpenFossilInfoExample.Criteria;
import com.tj720.admin.model.MipOpenFossilInfoWithBLOBs;
import com.tj720.admin.service.MipOpenFossilInfoService;
@Service("MipOpenFossilInfoServiceImpl")
public class MipOpenFossilInfoServiceImpl extends BaseServiceImpl<MipOpenFossilInfo> implements MipOpenFossilInfoService{

	@Autowired
	MipOpenFossilInfoMapper mipOpenFossilInfoMapper;
	@Override
	public BaseDao<MipOpenFossilInfo> getBaseDao() {
		return mipOpenFossilInfoMapper;
	}
	@Override
	public MipOpenFossilInfoWithBLOBs getFossilInfo(String id) {
		
		return mipOpenFossilInfoMapper.selectByPrimaryKey(id);
	}
	@Override
	public int getFossileInfoCount(List<String> orgIdList) {
		MipOpenFossilInfoExample example = new MipOpenFossilInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusNotEqualTo((byte)-127);
		criteria.andCollectionUnitIn(orgIdList);
		return mipOpenFossilInfoMapper.countByExample(example);
	}
	@Override
	public int countByOrgId(String orgId) {
		MipOpenFossilInfoExample example = new MipOpenFossilInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andCollectionUnitEqualTo(orgId);
		criteria.andStatusNotEqualTo((byte)-127);
		return mipOpenFossilInfoMapper.countByExample(example);
	}

}
