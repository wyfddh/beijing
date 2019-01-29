package com.tj720.admin.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.RegisterInfoMapper;
import com.tj720.admin.model.RegisterInfo;
import com.tj720.admin.service.RegisterInfoService;
import com.tj720.mip.model.MipOrganization;
@Service
public class RegisterInfoServiceImpl implements RegisterInfoService {
	@Autowired 
	private RegisterInfoMapper registerInfoMapper;
	
	
	@Override
	public void save(RegisterInfo registerInfo) {
		registerInfoMapper.insert(registerInfo);
	}
	@Override
	public RegisterInfo getById(String id) {
		
		return registerInfoMapper.selectByPrimaryKey(id);
	}
	@Override
	public void update(RegisterInfo registerInfo) {
		registerInfoMapper.updateByPrimaryKeySelective(registerInfo);
		
	}

	

	@Override
	public List<RegisterInfo> findListByMuseumId(String museumId) {
		// TODO Auto-generated method stub
		return registerInfoMapper.findListByMuseumId(museumId);
	}


	@Override
	public int getMaxYears(String museumId) {
		// TODO Auto-generated method stub
		return registerInfoMapper.getMaxYears(museumId);
	}




	@Override
	public List<RegisterInfo> getByEntity(RegisterInfo registerInfo) {
		// TODO Auto-generated method stub
		return registerInfoMapper.getByEntity(registerInfo);
	}


	@Override
	public List<RegisterInfo> selectAll(Integer gmYear) {
		// TODO Auto-generated method stub
		return registerInfoMapper.selectAll(gmYear);
	}





	@Override
	public int selectAllCount(String museumId) {
		// TODO Auto-generated method stub
		return registerInfoMapper.selectAllCount(museumId);
	}




	@Override
	public List<RegisterInfo> findList1(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return registerInfoMapper.findList1(map);
	}


	@Override
	public List<MipOrganization> selectAllCount1(String museumId) {
		// TODO Auto-generated method stub
		return registerInfoMapper.selectAllCount1(museumId);
	}


	@Override
	public Integer countList1(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return registerInfoMapper.countList1(map);
	}
	
	

}
