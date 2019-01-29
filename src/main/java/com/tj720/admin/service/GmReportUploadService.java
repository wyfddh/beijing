package com.tj720.admin.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tj720.admin.model.GmReportUpload;

@Service
public interface GmReportUploadService {

	void save(GmReportUpload gmReportUpload);

	List<GmReportUpload> getByReportId(String reportId);

	void saveList(List<GmReportUpload> reportList);


	void update(GmReportUpload gmReportUpload);

	GmReportUpload getByRealyName(HashMap<String, String> map);
	
}
