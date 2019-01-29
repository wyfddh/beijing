package com.tj720.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.GovLegalTypeMapper;
import com.tj720.admin.model.GovLegalType;
import com.tj720.admin.service.GovLegalTypeService;

@Service
public class GovLegalTypeServiceImpl implements GovLegalTypeService {

	@Autowired
	private GovLegalTypeMapper govLegalTypeMapper;
	
	@Override
	public List<GovLegalType> getFirstKindList() {
		
		return govLegalTypeMapper.getFirstKindList();
	}

	@Override
	public Integer countList(GovLegalType govLegalType) {
		
		return govLegalTypeMapper.countList(govLegalType);
	}

	@Override
	public List<GovLegalType> getList(Map<String, Object> map) {
		
		return govLegalTypeMapper.getList(map);
	}

	@Override
	public GovLegalType getById(String id) {
		
		return govLegalTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(GovLegalType govLegalType) {
		
		govLegalTypeMapper.insert(govLegalType);
	}

	@Override
	public void delById(String id) {
		
		govLegalTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delAllById(String id) {
		
		govLegalTypeMapper.delAllById(id);
	}

	@Override
	public List<GovLegalType> getSecondKindList(String firstKindId) {
		
		return govLegalTypeMapper.getSecondKindList(firstKindId);
	}

	@Override
	public List<GovLegalType> getAllKind() {
		
		return govLegalTypeMapper.getAllKind();
	}

	@Override
	public void update(GovLegalType govLegalType) {
		
		govLegalTypeMapper.updateByPrimaryKeySelective(govLegalType);
	}

	@Override
	public List<GovLegalType> getKindList() {
		
		return govLegalTypeMapper.getKindList();
	}


}
