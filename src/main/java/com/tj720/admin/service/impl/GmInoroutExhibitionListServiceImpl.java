package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.GmInoroutExhibitionListMapper;
import com.tj720.admin.model.GmInoroutExhibitionList;
import com.tj720.admin.service.GmInoroutExhibitionListService;
@Service
public class GmInoroutExhibitionListServiceImpl implements
		GmInoroutExhibitionListService {

	@Autowired
	private GmInoroutExhibitionListMapper gmInoroutExhibitionListMapper;
	@Override
	public void extractData(List<String[]> readExcel, String id) {
		List<List<String[]>> splitList = Utils.split(readExcel,1000);
		for (int i = 0;i < splitList.size();i++) {
			List<GmInoroutExhibitionList> li = new ArrayList<GmInoroutExhibitionList>();
			for (int j = 0;j < splitList.get(i).size();j++) {
				String[] strings = splitList.get(i).get(j);
				int len = strings.length;
				if ((!StringUtils.isBlank(strings[0])) && Utils.isDigitalNumber(strings[0])) {
					
					GmInoroutExhibitionList gmInoroutExhibitionList = new GmInoroutExhibitionList();
					String nextId = IdUtils.nextId(gmInoroutExhibitionList);
					gmInoroutExhibitionList.setReportUploadId(id);
					gmInoroutExhibitionList.setId(nextId);
					gmInoroutExhibitionList.setNum(strings[0]);
					if (len >= 2) {
						gmInoroutExhibitionList.setExhibitName(strings[1]);
					}
					if (len >= 3) {
						gmInoroutExhibitionList.setTheme(strings[2]);
					}
					if (len >= 4) {
						gmInoroutExhibitionList.setInoroutCompany(strings[3]);
					}
					if (len >= 5) {
						gmInoroutExhibitionList.setExhibitionCost(strings[4]);
					}
					if (len >= 6) {
						gmInoroutExhibitionList.setVisitorsCount(strings[5]);
					}
					if (len >= 7) {
						gmInoroutExhibitionList.setExhibitsCount(strings[6]);
					}
					if (len >= 8) {
						gmInoroutExhibitionList.setStartEndTime(strings[7]);
					}
					
					li.add(gmInoroutExhibitionList);
				}
			}
			if (li.size() > 0) {
				
				this.insertBatch(li);
			}
		}
		
		
	}
	@Transactional
	public void insertBatch(List<GmInoroutExhibitionList> list ) {
		gmInoroutExhibitionListMapper.insertBatch(list);
	}
	@Override
	public void deleteByReportUploadId(String id) {
		gmInoroutExhibitionListMapper.deleteByReportUploadId(id);
		
	}

}
