package com.tj720.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.GmReportFormMapper;
import com.tj720.admin.model.GmReportForm;
import com.tj720.admin.service.GmReportFormService;
@Service
public class GmReportFormServiceImpl implements GmReportFormService {
	@Autowired 
	private GmReportFormMapper gmReportFormMapper;
	
	@Override
	public void save(GmReportForm gmReportForm) {
		gmReportFormMapper.insert(gmReportForm);
	}

	@Override
	public GmReportForm getByReportId(String reportId) {
		
		return gmReportFormMapper.getByReportId(reportId);
	}

	@Override
	public void update(GmReportForm gmReportForm) {
		
		gmReportFormMapper.updateByPrimaryKey(gmReportForm);
	}

	@Override
	public List<GmReportForm> selectMuseumPropertyCount() {

		return gmReportFormMapper.selectMuseumPropertyCount();
	}

	@Override
	public List<GmReportForm> selectMuseumRelationCount() {
		// TODO Auto-generated method stub
		return gmReportFormMapper.selectMuseumRelationCount();
	}

	@Override
	public List<GmReportForm> selectMuseumTypeCount() {
		// TODO Auto-generated method stub
		return gmReportFormMapper.selectMuseumTypeCount();
	}

	

}
