package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.GmCollectionListMapper;
import com.tj720.admin.model.GmCollectionList;
import com.tj720.admin.service.GmCollectionListService;

@Service
public class GmCollectionListServiceImpl implements GmCollectionListService {

	@Autowired
	private GmCollectionListMapper gmCollectionListMapper;
	
	public void insertBatch(List<GmCollectionList> list) {
		
		gmCollectionListMapper.insertBatch(list);
	}

	@Override
	public void extractData(List<String[]> readExcel,String reportUploadId){
		List<List<String[]>> splitList = Utils.split(readExcel,1000);
		for (int i = 0;i < splitList.size();i++) {
			List<GmCollectionList> li = new ArrayList<GmCollectionList>();
			for (int j = 0;j < splitList.get(i).size();j++) {
				String[] strings = splitList.get(i).get(j);
				int len = strings.length;
				if ((!StringUtils.isBlank(strings[0])) && Utils.isDigitalNumber(strings[0])) {
					GmCollectionList gmCollectionList = new GmCollectionList();
					String nextId = IdUtils.nextId(gmCollectionList);
					gmCollectionList.setReportUploadId(reportUploadId);
					gmCollectionList.setId(nextId);
					gmCollectionList.setNum(strings[0]);
					if (len >= 2) {
						gmCollectionList.setLevel(strings[1]);
					}
					if (len >= 3) {
						gmCollectionList.setCollectionName(strings[2]);
						
					}
					if (len >= 4) {
						gmCollectionList.setQuality(strings[3]);
						
					}
					if (len >= 5) {
						gmCollectionList.setYears(strings[4]);
						
					}
					if (len >= 6) {
						gmCollectionList.setCollectionNumber(strings[5]);
						
					}
					if (len >= 7) {
						gmCollectionList.setCollectTime(strings[6]);
						
					}
					if (len >= 8) {
						gmCollectionList.setCollectChannel(strings[7]);
						
					}
					if (len >= 9) {
						gmCollectionList.setCollectOutlay(strings[8]);
						
					}
					li.add(gmCollectionList);
				}
			}
			if (li.size() > 0) {
				this.insertBatch(li);
			}
		}
		
		
	}

	@Override
	public void deleteByReportUploadId(String id) {
		gmCollectionListMapper.deleteByReportUploadId(id);
		
	}
	


}
