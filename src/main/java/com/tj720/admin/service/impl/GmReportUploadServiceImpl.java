package com.tj720.admin.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.GmReportUploadMapper;
import com.tj720.admin.model.GmReportUpload;
import com.tj720.admin.service.GmReportUploadService;

@Service
public class GmReportUploadServiceImpl implements GmReportUploadService {
	@Autowired 
	private GmReportUploadMapper gmReportUploadMapper;
	
	@Override
	public void save(GmReportUpload gmReportUpload) {
		
		gmReportUploadMapper.insert(gmReportUpload);
	}

	@Override
	public List<GmReportUpload> getByReportId(String reportId) {
		// TODO Auto-generated method stub
		return gmReportUploadMapper.getByReportId(reportId);
	}

	@Override
	public void saveList(List<GmReportUpload> reportList) {
		
		gmReportUploadMapper.saveList(reportList);
	}

	

	@Override
	public void update(GmReportUpload gmReportUpload) {
		gmReportUploadMapper.updateByPrimaryKey(gmReportUpload);
		
	}

	@Override
	public GmReportUpload getByRealyName(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return gmReportUploadMapper.getByRealyName(map);
	}

}
