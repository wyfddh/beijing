package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.GmScienceConferenceMapper;
import com.tj720.admin.model.GmScienceConference;
import com.tj720.admin.service.GmScienceConferenceService;

@Service
public class GmScienceConferenceServiceImpl implements
		GmScienceConferenceService {
	@Autowired 
	private GmScienceConferenceMapper gmScienceConferenceMapper;
	@Override
	public void extractData(List<String[]> readExcel, String id) {
		List<List<String[]>> splitList = Utils.split(readExcel,1000);
		for (int i = 0;i < splitList.size();i++) {
			List<GmScienceConference> li = new ArrayList<GmScienceConference>();
			for (int j = 0;j < splitList.get(i).size();j++) {
				String[] strings = splitList.get(i).get(j);
				int len = strings.length;
				if ((!StringUtils.isBlank(strings[0])) && Utils.isDigitalNumber(strings[0])) {
					
					GmScienceConference gmScienceConference = new GmScienceConference();
					String nextId = IdUtils.nextId(gmScienceConference);
					gmScienceConference.setReportUploadId(id);
					gmScienceConference.setId(nextId);
					gmScienceConference.setNum(strings[0]);
					if (len >= 2) {
						gmScienceConference.setMeetingName(strings[1]);
					}
					if (len >= 3) {
						gmScienceConference.setMeetingTheme(strings[2]);
					}
					if (len >= 4) {
						gmScienceConference.setMeetingTime(strings[3]);
					}
					if (len >= 5) {
						gmScienceConference.setMeetingPlace(strings[4]);
					}
					if (len >= 6) {
						gmScienceConference.setMeetingPeopleNumber(strings[5]);
					}
					if (len >= 7) {
						gmScienceConference.setLevel(strings[6]);
					}
					if (len >= 8) {
						gmScienceConference.setPublishNumber(strings[7]);
					}
					
					li.add(gmScienceConference);
				}
			}
			if (li.size() > 0) {
				
				this.insertBatch(li);
			}
		}
		
		
	}
	public void insertBatch(List<GmScienceConference> list ) {
		gmScienceConferenceMapper.insertBatch(list);
	}
	@Override
	public void deleteByReportUploadId(String id) {
		gmScienceConferenceMapper.deleteByReportUploadId(id);
		
	}

}
