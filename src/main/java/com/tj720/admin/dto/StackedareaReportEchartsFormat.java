package com.tj720.admin.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* @author chengrongkai
* @version 创建时间：2018年8月15日 下午5:05:05
* @ClassName 类名称
* @Description 类描述
*/
public class StackedareaReportEchartsFormat extends ReportEchartsFormat{
	private final static String TYPE = "line";
	protected List<Object> xAxis;
	protected List<Object> yAxis;
	public List<Object> getxAxis() {
		return xAxis;
	}
	public void setxAxis(List<Object> xAxis) {
		this.xAxis = xAxis;
	}
	public List<Object> getyAxis() {
		return yAxis;
	}
	public void setyAxis(List<Object> yAxis) {
		this.yAxis = yAxis;
	}
	StackedareaReportEchartsFormat(){
		super();
	}
	StackedareaReportEchartsFormat(String title,HashMap<String,Object> legend,HashMap<String,Object> tooltip,List<HashMap<String,Object>> series){
		super(title,legend,tooltip,series);
	}
	StackedareaReportEchartsFormat(String title,HashMap<String,Object> legend,HashMap<String,Object> tooltip,List<HashMap<String,Object>> series
			,List<Object> xAxis,List<Object> yAxis){
		super(title,legend,tooltip,series);
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}
	@Override
	public ReportEchartsFormat format(List<HashMap<String,String>> convertData,List<HashMap<String,Object>> data,String title){
		List<String> legendData = new ArrayList<String>();
		
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
				List<Object> valueData =  new ArrayList<Object>();
				legendData.add(name);
				for (int j = 0; j < data.size(); j++) {					
						valueData.add(data.get(j).get(key));
				}		
				series.put("name", name);
				series.put("type", TYPE);
				series.put("data", valueData);
				series.put("stack", "总量");
				HashMap<String,Object> formatter = new HashMap<String,Object>();
//				formatter.put("", value)
				ReportLabel label = new ReportLabel(true,"top",formatter);
				HashMap<String,Object> areaStyle = new HashMap<String,Object>();
				areaStyle.put("normal", null);
				series.put("areaStyle", areaStyle);
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
		this.legend = legend;
		this.xAxis = xAxisData;
		List<Object> yAxisData = new ArrayList<Object>();
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("type", "value");
		yAxisData.add(map);
		this.yAxis = yAxisData;
		HashMap<String,Object> text = new HashMap<String,Object>();
		text.put("text", title);
		this.title = text;	
		return this;
	}
}
