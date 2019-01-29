package com.tj720.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tj720.admin.model.MipRole;

@Service
public interface MipRoleService {

	List<MipRole> getList();

	
}
