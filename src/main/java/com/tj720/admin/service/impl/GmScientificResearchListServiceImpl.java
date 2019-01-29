package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.GmScientificResearchListMapper;
import com.tj720.admin.model.GmScientificResearchList;
import com.tj720.admin.service.GmScientificResearchListService;
@Service
public class GmScientificResearchListServiceImpl implements
		GmScientificResearchListService {
	@Autowired
	private GmScientificResearchListMapper gmScientificResearchListMapper;
	@Override
	public void extractData(List<String[]> readExcel, String id) {
		List<List<String[]>> splitList = Utils.split(readExcel,1000);
		for (int i = 0;i < splitList.size();i++) {
			List<GmScientificResearchList> li = new ArrayList<GmScientificResearchList>();
			for (int j = 0;j < splitList.get(i).size();j++) {
				String[] strings = splitList.get(i).get(j);
				int len = strings.length;
				if ((!StringUtils.isBlank(strings[0])) && Utils.isDigitalNumber(strings[0])) {
					
					GmScientificResearchList gmScientificResearchList = new GmScientificResearchList();
					String nextId = IdUtils.nextId(gmScientificResearchList);
					gmScientificResearchList.setReportUploadId(id);
					gmScientificResearchList.setId(nextId);
					gmScientificResearchList.setNum(strings[0]);
					if (len >= 2) {
						gmScientificResearchList.setAchievementName(strings[1]);
					}
					if (len >= 3) {
						gmScientificResearchList.setType(strings[2]);
					}
					if (len >= 4) {
						gmScientificResearchList.setFirstCompletePerson(strings[3]);
					}
					if (len >= 5) {
						gmScientificResearchList.setAuthorizedCompanyName(strings[4]);
					}
					if (len >= 6) {
						gmScientificResearchList.setPatentNumber(strings[5]);
					}
					
				
					li.add(gmScientificResearchList);
				}
			}
			if (li.size() > 0) {
				
				this.insertBatch(li);
			}
		}
		
	}
	public void insertBatch(List<GmScientificResearchList> list ) {
		gmScientificResearchListMapper.insertBatch(list);
	}
	@Override
	public void deleteByReportUploadId(String id) {
		gmScientificResearchListMapper.deleteByReportUploadId(id);
		
	}

}
