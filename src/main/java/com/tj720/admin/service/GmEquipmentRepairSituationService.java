package com.tj720.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface GmEquipmentRepairSituationService {

	void extractData(List<String[]> readExcel, String id);

	void deleteByReportUploadId(String id);

}
