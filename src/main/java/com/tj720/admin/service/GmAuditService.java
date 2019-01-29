package com.tj720.admin.service;

import org.springframework.stereotype.Service;

import com.tj720.admin.model.GmAudit;


@Service
public interface GmAuditService {

	void save(GmAudit gmAudit);

	GmAudit getByReportId(String reportId);

	void update(GmAudit gmAudit);

}
