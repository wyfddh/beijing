package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.GmCollectionRepairListMapper;
import com.tj720.admin.model.GmCollectionRepairList;
import com.tj720.admin.service.GmCollectionRepairListService;

@Service
public class GmCollectionRepairListServiceImpl implements GmCollectionRepairListService {
	
	@Autowired GmCollectionRepairListMapper gmCollectionRepairListMapper;
	@Override
	public void extractData(List<String[]> readExcel, String id) {
		List<List<String[]>> splitList = Utils.split(readExcel,1000);
		for (int i = 0;i < splitList.size();i++) {
			List<GmCollectionRepairList> li = new ArrayList<GmCollectionRepairList>();
			for (int j = 0;j < splitList.get(i).size();j++) {
				String[] strings = splitList.get(i).get(j);
				int len = strings.length;
				if ((!StringUtils.isBlank(strings[0])) && Utils.isDigitalNumber(strings[0])) {
					GmCollectionRepairList gmCollectionRepairList = new GmCollectionRepairList();
					String nextId = IdUtils.nextId(gmCollectionRepairList);
					gmCollectionRepairList.setReportUploadId(id);
					gmCollectionRepairList.setId(nextId);
					gmCollectionRepairList.setNum(strings[0]);
					if (len >= 2) {
						gmCollectionRepairList.setRepairCollectionName(strings[1]);
					}
					if (len >= 3) {
						gmCollectionRepairList.setLevel(strings[2]);
					}
					if (len >= 4) {
						gmCollectionRepairList.setCollectionNumber(strings[3]);
					}
					if (len >= 5) {
						gmCollectionRepairList.setReplyNumber(strings[4]);
					}
					if (len >= 6) {
						gmCollectionRepairList.setRepairDesignCompany(strings[5]);
					}
					if (len >= 7) {
						gmCollectionRepairList.setRepairCompany(strings[6]);
					}
					if (len >= 8) {
						gmCollectionRepairList.setRepairOutlay(strings[7]);
					}
					li.add(gmCollectionRepairList);
				}
			}
			if (li.size() > 0) {
				this.insertBatch(li);
				
			}
		}
		
	}
	public void insertBatch(List<GmCollectionRepairList> list) {
		gmCollectionRepairListMapper.insertBatch(list);
	}
	@Override
	public void deleteByReportUploadId(String id) {
		gmCollectionRepairListMapper.deleteByReportUploadId(id);
		
	}
}
