package com.tj720.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.GmAuditMapper;
import com.tj720.admin.model.GmAudit;
import com.tj720.admin.service.GmAuditService;

@Service
public class GmAuditServiceImpl implements GmAuditService {

	@Autowired 
	private GmAuditMapper gmAuditMapper;
	
	@Override
	public void save(GmAudit gmAudit) {
		
		gmAuditMapper.insertSelective(gmAudit);
	}

	@Override
	public GmAudit getByReportId(String reportId) {
		// TODO Auto-generated method stub
		return gmAuditMapper.getByReportId(reportId);
	}

	@Override
	public void update(GmAudit gmAudit) {
		// TODO Auto-generated method stub
		gmAuditMapper.updateByPrimaryKeySelective(gmAudit);
	}

}
