package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.GmTemporaryExhibitListMapper;
import com.tj720.admin.model.GmTemporaryExhibitList;
import com.tj720.admin.service.GmTemporaryExhibitListService;
@Service
public class GmTemporaryExhibitListServiceImpl implements
		GmTemporaryExhibitListService {
	@Autowired
	private GmTemporaryExhibitListMapper gmTemporaryExhibitListMapper;
	@Override
	public void extractData(List<String[]> readExcel, String id) {
		List<List<String[]>> splitList = Utils.split(readExcel,1000);
		for (int i = 0;i < splitList.size();i++) {
			List<GmTemporaryExhibitList> li = new ArrayList<GmTemporaryExhibitList>();
			for (int j = 0;j < splitList.get(i).size();j++) {
				String[] strings = splitList.get(i).get(j);
				int len = strings.length;
				if ((!StringUtils.isBlank(strings[0])) && Utils.isDigitalNumber(strings[0])) {
					
					GmTemporaryExhibitList gmTemporaryExhibitList = new GmTemporaryExhibitList();
					String nextId = IdUtils.nextId(gmTemporaryExhibitList);
					gmTemporaryExhibitList.setReportUploadId(id);
					gmTemporaryExhibitList.setId(nextId);
					gmTemporaryExhibitList.setNum(strings[0]);
					if (len >= 2) {
						gmTemporaryExhibitList.setExhibitionName(strings[1]);
					}
					if (len >= 3) {
						gmTemporaryExhibitList.setTheme(strings[2]);
					}
					if (len >= 4) {
						gmTemporaryExhibitList.setExhibitsCount(strings[3]);
					}
					if (len >= 5) {
						gmTemporaryExhibitList.setExhibitionHallArea(strings[4]);
					}
					if (len >= 6) {
						gmTemporaryExhibitList.setExhibitionCost(strings[5]);
					}
					if (len >= 7) {
						gmTemporaryExhibitList.setVisitorsCount(strings[6]);
					}
					if (len >= 8) {
						gmTemporaryExhibitList.setStartEndTime(strings[7]);
					}
					
					li.add(gmTemporaryExhibitList);
				}
			}
			if (li.size() > 0) {
				
				this.insertBatch(li);
			}
		}
		
		
	}
	public void insertBatch(List<GmTemporaryExhibitList> list ) {
		gmTemporaryExhibitListMapper.insertBatch(list);
	}
	@Override
	public void deleteByReportUploadId(String id) {
		gmTemporaryExhibitListMapper.deleteByReportUploadId(id);
		
	}
}
