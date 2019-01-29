package com.tj720.admin.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
* @author chengrongkai
* @version 创建时间：2018年8月1日 上午11:41:49
* @ClassName 类名称
* @Description 类描述
*/
public class ReportEchartsFormat implements Serializable{
	protected static final long serialVersionUID = 7553249056983455066L;
	//报表标题
	protected HashMap<String,Object> title;
	//报表分类
	protected HashMap<String,Object> legend;
	//tooltip
	protected HashMap<String,Object> tooltip;
	//报表显示数据
	protected List<HashMap<String,Object>> series;
	public HashMap<String,Object> getTitle() {
		return title;
	}
	public void setTitle(HashMap<String,Object> title) {
		this.title = title;
	}
	public HashMap<String, Object> getLegend() {
		return legend;
	}
	public void setLegend(HashMap<String, Object> legend) {
		this.legend = legend;
	}
	public HashMap<String, Object> getTooltip() {
		return tooltip;
	}
	public void setTooltip(HashMap<String, Object> tooltip) {
		this.tooltip = tooltip;
	}
	public List<HashMap<String, Object>> getSeries() {
		return series;
	}
	public void setSeries(List<HashMap<String, Object>> series) {
		this.series = series;
	}
	ReportEchartsFormat(){

	}
	ReportEchartsFormat(String title,HashMap<String,Object> legend,HashMap<String,Object> tooltip,List<HashMap<String,Object>> series){
		HashMap<String,Object> data = new HashMap<String,Object>();
		data.put("text", title);
		this.title = data;
		this.legend = legend;
		this.tooltip = tooltip;
		this.series = series;
	}
	
	public ReportEchartsFormat format(List<HashMap<String,String>> convertData,List<HashMap<String,Object>> data,String title){
		List<String> legendData = new ArrayList<String>();
		List<Object> valueData =  new ArrayList<Object>();
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
				legendData.add(name);
				for (int j = 0; j < data.size(); j++) {
					
					valueData.add(data.get(j).get(key));
				}	
				series.put("name", name);
//				series.put("type", "pie");
				series.put("data", valueData);
				seriesData.add(series);
			}
			//否则为显示名称字段
			else{
				for (int j = 0; j < data.size(); j++) {	
					xAxisData.add(data.get(j).get(key));
				}
				
			}
			
		}
		this.series = seriesData;
		HashMap<String, Object> legend = new HashMap<String,Object>();
		legend.put("data", legendData);
		legend.put("bottom", 10);
		legend.put("left", "center");
		this.legend = legend;
//		this.yAxis = xAxisData;
		HashMap<String,Object> text = new HashMap<String,Object>();
		text.put("text", title);
		this.title = text;	
		return this;
	}
}
