package com.tj720.admin.service;

import java.util.List;
import java.util.Map;

import com.tj720.admin.dto.MipSearchDto;

public interface MipSearchService{
	//flag=1表示查自己的常用查询  
	//type：0汇总查询 1明细查询
	List<MipSearchDto> getList(String flag,String type);
	
	Integer save(String queryOrgs,String queryTerms,String queryName,String type,String curPid);

	List<Map<String, Object>> query(String queryOrgs,String queryTerms,String type,String sql);
	
	String getSqlByUnique(String uniqueName);
}
