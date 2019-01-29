package com.tj720.admin.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* @author chengrongkai
* @version 创建时间：2018年8月2日 下午1:16:29
* @ClassName 类名称
* @Description 类描述
*/
public class PieReportEchartsFormat extends ReportEchartsFormat{
	private final static String TYPE = "pie";
	PieReportEchartsFormat(){

	}
	PieReportEchartsFormat(String title,HashMap<String,Object> legend,HashMap<String,Object> tooltip,List<HashMap<String,Object>> series){
		super(title,legend,tooltip,series);
	}
	
	public PieReportEchartsFormat format(List<HashMap<String,String>> convertData,List<HashMap<String,Object>> data,String title){
		List<String> legendData = new ArrayList<String>();
		List<Object> numberData = new ArrayList<Object>();
		List<HashMap<String,Object>> valueData =  new ArrayList<HashMap<String,Object>>();
		List<Object> xAxisData =  new ArrayList<Object>();
		List<HashMap<String,Object>> seriesData = new ArrayList<HashMap<String,Object>>();
		for (int i = 0; i < convertData.size(); i++) {
			HashMap<String,Object> series = new HashMap<String,Object>();
			
			HashMap<String,String> map = convertData.get(i);
			String key = map.get("key");
			String name = map.get("name");
			String isValueKey = map.get("isValueKey");
			//查询的项目,若指标被指定为项目维度，则添加至项目集合
			if(isValueKey.equals("1")){
				
				for (int j = 0; j < data.size(); j++) {
					numberData.add(data.get(j).get(key));
				}	
				series.put("name", name);
				series.put("type", TYPE);
				series.put("data", valueData);
				HashMap<String,Object> normal = new HashMap<String,Object>();
				normal.put("normal", null);
				series.put("areaStyle", normal);
				series.put("stack", "总量");
				List<String> radius = new ArrayList<String>();
				radius.add("50%");
				radius.add("70%");
				series.put("radius", radius);
				seriesData.add(series);
			}
			//否则为显示名称字段
			else{
				for (int j = 0; j < data.size(); j++) {	
					xAxisData.add(data.get(j).get(key));
					legendData.add(data.get(j).get(key).toString());
				}
			}
			
		}
		for (int i = 0; i < xAxisData.size(); i++) {
			HashMap<String,Object> temp = new HashMap<String,Object>();
			temp.put("name", xAxisData.get(i));			
			temp.put("value", numberData.get(i));
			valueData.add(temp);
		}
		
		this.series = seriesData;
		HashMap<String, Object> legend = new HashMap<String,Object>();
		legend.put("data", legendData);
		legend.put("y", "top");
		this.legend = legend;
//		this.yAxis = xAxisData;
		HashMap<String,Object> text = new HashMap<String,Object>();
		text.put("text", title);
		text.put("left", "left");
		this.title = text;	
		return this;
	}
}
