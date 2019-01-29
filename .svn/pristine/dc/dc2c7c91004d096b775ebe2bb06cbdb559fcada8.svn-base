package com.tj720.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.SysLogMapper;
import com.tj720.admin.model.SysLog;
import com.tj720.admin.service.SysLogService;

@Service
public class SysLogServiceImpl implements  SysLogService{

	@Autowired
	private SysLogMapper sysLogMapper;

	@Override
	public SysLog get(Integer id) {
		return sysLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public int create(SysLog model) {
		return sysLogMapper.insert(model);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sysLogMapper.deleteByPrimaryKey(id);
	}
	
}
