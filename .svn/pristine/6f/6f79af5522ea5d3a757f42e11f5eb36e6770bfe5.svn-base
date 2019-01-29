package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.GmBaseDisplayListMapper;
import com.tj720.admin.model.GmBaseDisplayList;
import com.tj720.admin.service.GmBaseDisplayListService;
@Service
public class GmBaseDisplayListServiceImpl implements GmBaseDisplayListService {
	@Autowired GmBaseDisplayListMapper gmBaseDisplayListMapper;
	@Override
	public void extractData(List<String[]> readExcel, String id) {
		
		List<List<String[]>> splitList = Utils.split(readExcel,1000);
		for (int i = 0;i < splitList.size();i++) {
			List<GmBaseDisplayList> li = new ArrayList<GmBaseDisplayList>();
			for (int j = 0;j < splitList.get(i).size();j++) {
				String[] strings = splitList.get(i).get(j);
				int len = strings.length;
				if ((!StringUtils.isBlank(strings[0])) && Utils.isDigitalNumber(strings[0])) {
					GmBaseDisplayList gmBaseDisplayList = new GmBaseDisplayList();
					String nextId = IdUtils.nextId(gmBaseDisplayList);
					gmBaseDisplayList.setReportUploadId(id);
					gmBaseDisplayList.setId(nextId);
					gmBaseDisplayList.setNum(strings[0]);
					if (len >= 2) {
						gmBaseDisplayList.setCreatDate(strings[1]);
					}
					if (len >= 3) {
						gmBaseDisplayList.setDisplayName(strings[2]);
					}
					if (len >= 4) {
						gmBaseDisplayList.setExhibitsCount(strings[3]);
					}
					if (len >= 5) {
						gmBaseDisplayList.setCulturalTreasuresCount(strings[4]);
					}
					if (len >= 6) {	
						gmBaseDisplayList.setDisplayArea(strings[5]);
					}
					if (len >= 7) {	
						gmBaseDisplayList.setExhibitionLength(strings[6]);
					}
					if (len >= 8) {	
						gmBaseDisplayList.setContentUpdate(strings[7]);
					}
					if (len >= 9) {	
						gmBaseDisplayList.setExhibitionProtect(strings[8]);
					}
					if (len >= 10) {	
						gmBaseDisplayList.setPerSquareMeterPay(strings[9]);
					}
					li.add(gmBaseDisplayList);
				}
			}
			if (li.size() > 0) {
				
				this.insertBatch(li);
			}
		}
	}
	@Transactional
	public void insertBatch(List<GmBaseDisplayList> list) {
		gmBaseDisplayListMapper.insertBatch(list);
	}
	@Override
	public void deleteByReportUploadId(String id) {
		gmBaseDisplayListMapper.deleteByReportUploadId(id);
		
	}
	

}
