package com.design.form.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface CgformReportIndexServiceI  {

	List<Map<String, Object>> getCgformReportIndexList(HttpServletRequest request);

	Map<String, Object> getCgformReportIndex(HttpServletRequest request);
	
}
