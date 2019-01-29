package com.tj720.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.GovLegalMapper;
import com.tj720.admin.model.GovLegal;
import com.tj720.admin.service.GovLegalService;
@Service
public class GovLegalServiceImpl implements GovLegalService {

	@Autowired
	private GovLegalMapper govLegalMapper;

	@Override
	public List<GovLegal> getList(Map<String, Object> map) {
		
		return govLegalMapper.getList(map);
	}

	@Override
	public List<GovLegal> getPublisherList() {
		
		return govLegalMapper.getPublisherList();
	}

	@Override
	public Integer countList(GovLegal govLegal) {
		
		return govLegalMapper.countList(govLegal);
	}

	@Override
	public void save(GovLegal govLegal) {
	
		govLegalMapper.insert(govLegal);
	}

	@Override
	public void update(GovLegal govLegal) {
		
		govLegalMapper.updateByPrimaryKeySelective(govLegal);
	}

	@Override
	public void delete(String id) {
		
		govLegalMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer countByLegalTypeId(String id) {
		
		return govLegalMapper.countByLegalTypeId(id);
	}
	
	@Override
	public List<GovLegal> getGovListForDesk(Map<String,String> map) {
		
		return govLegalMapper.getGovListForDesk(map);
	}
	@Override
	public GovLegal getGovByid(String id){
		return govLegalMapper.getGovByid(id);
	}

}
