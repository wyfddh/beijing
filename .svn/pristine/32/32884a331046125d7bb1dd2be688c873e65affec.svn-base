package com.tj720.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tj720.admin.dto.ReportEchartsFormat;

/**
* @author chengrongkai
* @version 创建时间：2018年8月1日 下午12:45:29
* @ClassName 类名称
* @Description 类描述
*/
@Service
public interface ReportService {
	public ReportEchartsFormat getPriviewData(String sqlStr,List<HashMap<String,String>> convertData,String type,String title);
	/**
	 * 获取图形数据
	 * @param sqlStr sql语句
	 * @param convertData 字段映射关系
	 * @param type 图表类型
	 * @param title 图表标题
	 * @return 指定格式的图表数据
	 */
	public ReportEchartsFormat getReportData(String sqlStr,List<HashMap<String,String>> convertData,String type,String title);
	
	Integer getCollectionCountByCondition(String unitId,String areaId);
	
	List<HashMap<String, Object>> getAreaData(String pid);
	
	List<HashMap<String, Object>> getUnitData(String pid,String areaId);
}
