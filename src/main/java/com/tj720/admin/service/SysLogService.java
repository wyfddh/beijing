package com.tj720.admin.service;

import com.tj720.admin.model.SysLog;

public interface SysLogService{

	public SysLog get(Integer id) ;

	public int create(SysLog model) ;

	public int deleteByPrimaryKey(Integer id);
}
