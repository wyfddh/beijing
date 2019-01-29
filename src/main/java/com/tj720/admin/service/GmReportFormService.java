package com.tj720.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tj720.admin.model.GmReportForm;

@Service
public interface GmReportFormService {

	void save(GmReportForm gmReportForm);

	GmReportForm getByReportId(String reportId);

	void update(GmReportForm gmReportForm);

	List<GmReportForm> selectMuseumPropertyCount();

	List<GmReportForm> selectMuseumRelationCount();

	List<GmReportForm> selectMuseumTypeCount();

	

}
