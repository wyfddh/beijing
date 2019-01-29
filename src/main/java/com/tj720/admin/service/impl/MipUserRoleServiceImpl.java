package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.MipUserRoleMapper;
import com.tj720.admin.model.MipRole;
import com.tj720.admin.model.MipUserRole;
import com.tj720.admin.service.MipRoleService;
import com.tj720.admin.service.MipUserRoleService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.service.table.MipOrganizationService;

@Service
public class MipUserRoleServiceImpl implements MipUserRoleService{
	
	@Autowired
	private MipUserRoleMapper mipUserRoleMapper;
	@Autowired
	private MipOrganizationService organizationService;
	@Autowired
	private MipRoleService mipRoleService;
	
	@Override
	public void batchInsert(List<MipUserRole> userRoleList) {

		mipUserRoleMapper.batchInsert(userRoleList);
		
	}

	@Override
	public List<MipUserRole> getByUserId(String id) {
	
		return mipUserRoleMapper.getByUserId(id);
	}

	@Override
	public void deleteByUserId(String userId) {
		mipUserRoleMapper.deleteByUserId(userId);
	}
	
	@Override
	public void deleteByUserId(String userId, String orgId) {
		mipUserRoleMapper.deleteByUserIdAndOrgId(userId, orgId);
	}

}
