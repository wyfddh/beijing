package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.GmEmployeeTrainSituationMapper;
import com.tj720.admin.model.GmEmployeeTrainSituation;
import com.tj720.admin.service.GmEmployeeTrainSituationService;
@Service
public class GmEmployeeTrainSituationServiceImpl implements
		GmEmployeeTrainSituationService {

	@Autowired 
	private GmEmployeeTrainSituationMapper gmEmployeeTrainSituationMapper;
	@Override
	public void extractData(List<String[]> readExcel, String id) {
		List<List<String[]>> splitList = Utils.split(readExcel,1000);
		for (int i = 0;i < splitList.size();i++) {
			List<GmEmployeeTrainSituation> li = new ArrayList<GmEmployeeTrainSituation>();
			for (int j = 0;j < splitList.get(i).size();j++) {
				String[] strings = splitList.get(i).get(j);
				int len = strings.length;
				if ((!StringUtils.isBlank(strings[0])) && Utils.isDigitalNumber(strings[0])) {
					
					GmEmployeeTrainSituation gmEmployeeTrainSituation = new GmEmployeeTrainSituation();
					String nextId = IdUtils.nextId(gmEmployeeTrainSituation);
					gmEmployeeTrainSituation.setReportUploadId(id);
					gmEmployeeTrainSituation.setId(nextId);
					gmEmployeeTrainSituation.setNum(strings[0]);
					if (len >= 2) {
						gmEmployeeTrainSituation.setActivityName(strings[1]);
					}
					if (len >= 3) {
						gmEmployeeTrainSituation.setMainContent(strings[2]);
					}
					if (len >= 4) {
						gmEmployeeTrainSituation.setTrainType(strings[3]);
					}
					if (len >= 5) {
						gmEmployeeTrainSituation.setStartEndTime(strings[4]);
					}
					if (len >= 6) {
						gmEmployeeTrainSituation.setPlace(strings[5]);
					}
					if (len >= 7) {
						gmEmployeeTrainSituation.setPeopleCount(strings[6]);
					}
					if (len >= 8) {
					}
					if (len >= 9) {
					}
					li.add(gmEmployeeTrainSituation);
				}
			}
			if (li.size() > 0) {
				
				this.insertBatch(li);
			}
		}
		
		
	}
	public void insertBatch(List<GmEmployeeTrainSituation> list ) {
		gmEmployeeTrainSituationMapper.insertBatch(list);
	}
	@Override
	public void deleteByReportUploadId(String id) {
		gmEmployeeTrainSituationMapper.deleteByReportUploadId(id);
		
	}
}
