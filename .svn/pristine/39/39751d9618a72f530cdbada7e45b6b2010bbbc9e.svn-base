package com.tj720.admin.dao.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
* @author chengrongkai
* @version 创建时间：2018年8月1日 下午12:14:22
* @ClassName 类名称
* @Description 类描述
*/
public interface ReportConfigMapper {
	List<HashMap<String,Object>> getPriviewData(@Param("sqlStr") String sqlStr);
	
	List<HashMap<String,Object>> getReportData(@Param("sqlStr") String sqlStr);
	
	Integer getCollectionCountByCondition(@Param("unitId") String unitId,@Param("areaId") String areaId);
	
	List<HashMap<String, Object>> getArea(@Param("pid") String pid);
	
	List<HashMap<String, Object>> getUnit(@Param("pid") String pid,@Param("areaId") String areaId);
}
