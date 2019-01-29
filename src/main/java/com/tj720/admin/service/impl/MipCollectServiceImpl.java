package com.tj720.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.MipCollectMapper;
import com.tj720.admin.model.MipCollect;
import com.tj720.admin.service.MipCollectService;

@Service
public class MipCollectServiceImpl implements MipCollectService {

	@Autowired
	private MipCollectMapper mipCollectMapper;
	


	@Override
	public void delCollect(Map<String, String> map) {
		
		mipCollectMapper.delCollect(map);
	}

	@Override
	public void save(MipCollect mipCollect) {
		
		mipCollectMapper.insert(mipCollect);
	}

	@Override
	public List<MipCollect> getCollectsByUid(Map<String, Object> map) {
		
		return mipCollectMapper.getCollectsByUid(map);
	}

	@Override
	public Integer getCountColByUid(Map<String, Object> map) {
		
		return mipCollectMapper.getCountColByUid(map);
	}

	@Override
	public List<MipCollect> getColByUserID(Map<String, Object> map) {
		
		return mipCollectMapper.getColByUserID(map);
	}

	@Override
	public List<MipCollect> getOrgByUserID(Map<String, Object> map) {
		
		return mipCollectMapper.getOrgByUserID(map);
	}

	@Override
	public MipCollect getCollect(Map<String, String> map) {
		
		return mipCollectMapper.getCollect(map);
	}

	@Override
	public void update(MipCollect mipCollect) {
		
		mipCollectMapper.updateByPrimaryKeySelective(mipCollect);
	}



}
