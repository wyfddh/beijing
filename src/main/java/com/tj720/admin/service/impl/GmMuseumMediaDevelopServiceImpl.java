package com.tj720.admin.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.GmMuseumMediaDevelopMapper;
import com.tj720.admin.model.GmMuseumMediaDevelop;
import com.tj720.admin.service.GmMuseumMediaDevelopService;
@Service
public class GmMuseumMediaDevelopServiceImpl implements
		GmMuseumMediaDevelopService {

	@Autowired
	private GmMuseumMediaDevelopMapper gmMuseumMediaDevelopMapper;
	
	@Transactional
	public void save(GmMuseumMediaDevelop gmMuseumMediaDevelop) {
		gmMuseumMediaDevelopMapper.insert(gmMuseumMediaDevelop);
	}
	@Override
	public void extractData(String substring1, String substring2, String id) {
		GmMuseumMediaDevelop gmMuseumMediaDevelop = new GmMuseumMediaDevelop();
		String nextId = IdUtils.nextId(gmMuseumMediaDevelop);
		gmMuseumMediaDevelop.setReportUploadId(id);
		gmMuseumMediaDevelop.setId(nextId);
		gmMuseumMediaDevelop.setAudienceAccess(substring1);
		gmMuseumMediaDevelop.setNumberStatistics(substring2);
		this.save(gmMuseumMediaDevelop);
	}
	@Override
	public void deleteByReportUploadId(String id) {
		gmMuseumMediaDevelopMapper.deleteByReportUploadId(id);
		
	}

}
