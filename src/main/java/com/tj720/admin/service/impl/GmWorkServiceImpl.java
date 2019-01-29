package com.tj720.admin.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.GmWorkMapper;
import com.tj720.admin.model.GmWork;
import com.tj720.admin.service.GmWorkService;

@Service
public class GmWorkServiceImpl implements GmWorkService {
	@Autowired
	private GmWorkMapper gmWorkMapper;
	

	@Override
	public void save(GmWork gmWork) {
		gmWorkMapper.insert(gmWork);
		
	}
	
	@Override
	public List<GmWork> findListByMuseumId(String museumId) {
		// TODO Auto-generated method stub
		return gmWorkMapper.findListByMuseumId(museumId);
	}

	@Override
	public int getMaxYears(String museumId) {
		// TODO Auto-generated method stub
		return gmWorkMapper.getMaxYears(museumId);
	}

	@Override
	public GmWork selectById(String id) {
		// TODO Auto-generated method stub
		return gmWorkMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(GmWork gmWork) {
		// TODO Auto-generated method stub
		gmWorkMapper.updateByPrimaryKeySelective(gmWork);
	}



	@Override
	public int selectAll(String gmYear) {
		// TODO Auto-generated method stub
		return gmWorkMapper.selectAll(gmYear);
	}

	@Override
	public List<GmWork> findList1(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return gmWorkMapper.findList1(map);
	}

	@Override
	public Integer countList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return gmWorkMapper.countList(map);
	}

	@Override
	public Integer countMySummary(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return gmWorkMapper.countMySummary(map);
	}

	@Override
	public List<GmWork> findMySummary(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return gmWorkMapper.findMySummary(map);
	}


}
