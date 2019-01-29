package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.GmEduProjectListMapper;
import com.tj720.admin.model.GmEduProjectList;
import com.tj720.admin.service.GmEduProjectListService;
@Service
public class GmEduProjectListServiceImpl implements GmEduProjectListService {

	@Autowired
	private GmEduProjectListMapper gmEduProjectListMapper;
	@Override
	public void extractData(List<String[]> readExcel, String id) {
		List<List<String[]>> splitList = Utils.split(readExcel,1000);
		for (int i = 0;i < splitList.size();i++) {
			List<GmEduProjectList> li = new ArrayList<GmEduProjectList>();
			for (int j = 0;j < splitList.get(i).size();j++) {
				String[] strings = splitList.get(i).get(j);
				int len = strings.length;
				if ((!StringUtils.isBlank(strings[0])) && Utils.isDigitalNumber(strings[0])) {
					
					GmEduProjectList gmEduProjectList = new GmEduProjectList();
					String nextId = IdUtils.nextId(gmEduProjectList);
					gmEduProjectList.setReportUploadId(id);
					gmEduProjectList.setId(nextId);
					gmEduProjectList.setNum(strings[0]);
					if (len >= 2) {
						gmEduProjectList.setProjectName(strings[1]);
					}
					if (len >= 3) {
						gmEduProjectList.setForGroups(strings[2]);
					}
					if (len >= 4) {
						gmEduProjectList.setActivityType(strings[3]);
					}
					if (len >= 5) {
						gmEduProjectList.setProjectContent(strings[4]);
					}
					if (len >= 6) {
						gmEduProjectList.setExtensionMethod(strings[5]);
					}
					if (len >= 7) {
						gmEduProjectList.setOutlay(strings[6]);
					}
					if (len >= 8) {
						gmEduProjectList.setParticipantsCount(strings[7]);
					}
					if (len >= 9) {
						gmEduProjectList.setStartEndTime(strings[8]);
					}
					li.add(gmEduProjectList);
				}
			}
			if (li.size() > 0) {
				
				this.insertBatch(li);	
			}
		}
		
		
	}
	public void insertBatch(List<GmEduProjectList> list ) {
		gmEduProjectListMapper.insertBatch(list);
	}
	@Override
	public void deleteByReportUploadId(String id) {
		gmEduProjectListMapper.deleteByReportUploadId(id);
		
	}

}
