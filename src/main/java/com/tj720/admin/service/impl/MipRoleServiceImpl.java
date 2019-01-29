package com.tj720.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.MipRoleMapper;
import com.tj720.admin.model.MipRole;
import com.tj720.admin.service.MipRoleService;

@Service
public class MipRoleServiceImpl implements MipRoleService{

	@Autowired
	private MipRoleMapper mipRoleMapper;
	
	@Override
	public List<MipRole> getList() {
		
		return mipRoleMapper.getList();
	}

}
