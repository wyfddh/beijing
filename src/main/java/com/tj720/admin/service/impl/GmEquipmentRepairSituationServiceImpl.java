package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.GmEquipmentRepairSituationMapper;
import com.tj720.admin.model.GmEquipmentRepairSituation;
import com.tj720.admin.service.GmEquipmentRepairSituationService;
@Service
public class GmEquipmentRepairSituationServiceImpl implements
		GmEquipmentRepairSituationService {

	@Autowired GmEquipmentRepairSituationMapper gmEquipmentRepairSituationMapper;
	
	@Override
	public void extractData(List<String[]> readExcel, String id) {
		List<List<String[]>> splitList = Utils.split(readExcel,1000);
		for (int i = 0;i < splitList.size();i++) {
			List<GmEquipmentRepairSituation> li = new ArrayList<GmEquipmentRepairSituation>();
			for (int j = 0;j < splitList.get(i).size();j++) {
				String[] strings = splitList.get(i).get(j);
				int len = strings.length;
				if ((!StringUtils.isBlank(strings[0])) && Utils.isDigitalNumber(strings[0])) {
					
					GmEquipmentRepairSituation gmEquipmentRepairSituation = new GmEquipmentRepairSituation();
					String nextId = IdUtils.nextId(gmEquipmentRepairSituation);
					gmEquipmentRepairSituation.setReportUploadId(id);
					gmEquipmentRepairSituation.setId(nextId);
					gmEquipmentRepairSituation.setNum(strings[0]);
					if (len >= 2) {
						gmEquipmentRepairSituation.setEquipmentType(strings[1]);
					}
					if (len >= 3) {
						gmEquipmentRepairSituation.setEquipmentName(strings[2]);
					}
					if (len >= 4) {
						gmEquipmentRepairSituation.setOutlay(strings[3]);
					}
					if (len >= 5) {
						gmEquipmentRepairSituation.setIsRepair(strings[4]);
					}
					
					li.add(gmEquipmentRepairSituation);
				}
			}
			if (li.size() > 0) {
				
				this.insertBatch(li);
			}
		}
		
		
	}
	public void insertBatch(List<GmEquipmentRepairSituation> list ) {
		gmEquipmentRepairSituationMapper.insertBatch(list);
	}
	@Override
	public void deleteByReportUploadId(String id) {
		gmEquipmentRepairSituationMapper.deleteByReportUploadId(id);
		
	}

}
