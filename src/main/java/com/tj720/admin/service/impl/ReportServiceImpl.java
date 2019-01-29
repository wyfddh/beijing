package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.ReportConfigMapper;
import com.tj720.admin.dto.BarReportEchartsFormat;
import com.tj720.admin.dto.ReportEchartsFormat;
import com.tj720.admin.dto.ReportFormatFactory;
import com.tj720.admin.service.ReportService;

/**
* @author chengrongkai
* @version 创建时间：2018年8月1日 下午12:46:03
* @ClassName 类名称
* @Description 类描述
*/
@Service
public class ReportServiceImpl implements ReportService{
@Autowired
ReportConfigMapper reportConfigMapper;
	@Override
	public ReportEchartsFormat getPriviewData(String sqlStr,List<HashMap<String,String>> convertData,String type,String title) {
		List<HashMap<String,Object>> map = reportConfigMapper.getPriviewData(sqlStr);
		ReportFormatFactory factory = new ReportFormatFactory(type);
		
		ReportEchartsFormat data = factory.getReportEchartsFormat();
		data = data.format(convertData, map, title);
		// TODO Auto-generated method stub
		return data;
	}
	@Override
	public ReportEchartsFormat getReportData(String sqlStr, List<HashMap<String, String>> convertData, String type,
			String title) {
		List<HashMap<String,Object>> map = reportConfigMapper.getReportData(sqlStr);
		ReportFormatFactory factory = new ReportFormatFactory(type);
		
		ReportEchartsFormat data = factory.getReportEchartsFormat();
		data = data.format(convertData, map, title);
		// TODO Auto-generated method stub
		return data;
	}
	@Override
	public Integer getCollectionCountByCondition(String unitId, String areaId) {
		// TODO Auto-generated method stub
		return reportConfigMapper.getCollectionCountByCondition(unitId, areaId);
	}
	@Override
	public List<HashMap<String, Object>> getAreaData(String pid) {
		// TODO Auto-generated method stub
		return reportConfigMapper.getArea(pid);
	}
	@Override
	public List<HashMap<String, Object>> getUnitData(String pid,String areaId) {
		// TODO Auto-generated method stub
		return reportConfigMapper.getUnit(pid, areaId);
	}
}
