package com.tj720.admin.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.tj720.admin.dto.TotalNumDto;

public interface EchartService {
	List<TotalNumDto> getLineData(int type,byte status,String orgId);
	List<TotalNumDto> getLineDataByOrgId(int type,byte status,String orgId);
	List<TotalNumDto> getPieData(byte picType,int picArea,String beginTime,String endTime,List<Map<String,Object>> areaList);
}
