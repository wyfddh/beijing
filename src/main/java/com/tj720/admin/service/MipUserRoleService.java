package com.tj720.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tj720.admin.model.MipUserRole;


@Service
public interface MipUserRoleService {

	void batchInsert(List<MipUserRole> userRoleList);

	List<MipUserRole> getByUserId(String id);

	void deleteByUserId(String userId);
	
	void deleteByUserId(String userId, String orgId);

}
