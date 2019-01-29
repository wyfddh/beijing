package com.tj720.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipAreaMapper;
import com.tj720.admin.model.MipArea;
import com.tj720.admin.model.MipAreaExample;
import com.tj720.admin.model.MipAreaExample.Criteria;
import com.tj720.admin.service.MipAreaService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
@Service("MipAreaServiceImpl")
public class MipAreaServiceImpl extends BaseServiceImpl<MipArea> implements MipAreaService{
	
	@Autowired
	MipAreaMapper mipAreaMapper;
	@Autowired
	Config config;

	@Override
	public BaseDao<MipArea> getBaseDao() {
		return mipAreaMapper;
	}
	@Override
	public Map<String, String> getCityName() {
		Map<String, String> map = new HashMap<String, String>();
		MipAreaExample example = new MipAreaExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(585);
		List<MipArea> areaList = mipAreaMapper.selectByExample(example);
		if(!MyString.isEmpty(areaList)){
			for(MipArea list : areaList){
				map.put(list.getId().toString(), list.getName());
			}
		}
		return map;
	}
	@Override
	public List<MipArea> getCityList() {
		MipAreaExample example = new MipAreaExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(config.getProvinceId());
		List<MipArea> areaList = mipAreaMapper.selectByExample(example);
		return areaList;
	}
	@Override
	public List<MipArea> getCityListByPid(Integer pid) {
		MipAreaExample example = new MipAreaExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		List<MipArea> areaList = mipAreaMapper.selectByExample(example);
		return areaList;
	}
	@Override
	public List<MipArea> getAreaJson() {
		
		return mipAreaMapper.getAreaJson();
	}

}
