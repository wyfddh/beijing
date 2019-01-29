package com.tj720.admin.service;


import org.springframework.stereotype.Service;

import com.tj720.admin.model.GmMuseumMediaDevelop;

@Service
public interface GmMuseumMediaDevelopService {

	void save(GmMuseumMediaDevelop gmMuseumMediaDevelop);

	void extractData(String substring1, String substring2, String id);

	void deleteByReportUploadId(String id);


}
