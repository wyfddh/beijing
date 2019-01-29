package com.tj720.admin.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
* @author chengrongkai
* @version 创建时间：2018年8月1日 上午11:51:00
* @ClassName 报表格式工厂
* @Description 类描述
*/
public class ReportFormatFactory {
	private ReportEchartsFormat reportEchartsFormat;
	public ReportFormatFactory(String type){
		switch (type){
			case "line":
				reportEchartsFormat = new LineReportEchartsFormat();
			break;
			case "bar":
				reportEchartsFormat = new BarReportEchartsFormat();
				break;
			case "pie":
				reportEchartsFormat = new PieReportEchartsFormat();
				break;
			case "stackedarea":
				reportEchartsFormat = new StackedareaReportEchartsFormat();
				break;
		}
	}
	public ReportFormatFactory(String type,String title,HashMap<String,Object> legend,HashMap<String,Object> tooltip,List<HashMap<String,Object>> series){
		switch (type){
			case "line":
				reportEchartsFormat = new LineReportEchartsFormat(title,legend,tooltip,series);
				break;
			case "bar":
				reportEchartsFormat = new BarReportEchartsFormat(title,legend,tooltip,series);
				break;
			case "pie":
				reportEchartsFormat = new PieReportEchartsFormat(title,legend,tooltip,series);
				break;
			case "stackedarea":
				reportEchartsFormat = new StackedareaReportEchartsFormat(title,legend,tooltip,series);
				break;
		}
	}
	
	public ReportFormatFactory(String type,String title,HashMap<String,Object> legend,HashMap<String,Object> tooltip,List<HashMap<String,Object>> series
			,List<Object> xAxis,List<Object> yAxis){
		switch (type){
			case "line":
				reportEchartsFormat = new LineReportEchartsFormat(title,legend,tooltip,series,xAxis,yAxis);
				break;
			case "bar":
				reportEchartsFormat = new BarReportEchartsFormat(title,legend,tooltip,series,xAxis,yAxis);
				break;
			case "pie":
				reportEchartsFormat = new PieReportEchartsFormat(title,legend,tooltip,series);
				break;
			case "stackedarea":
				reportEchartsFormat = new StackedareaReportEchartsFormat(title,legend,tooltip,series,xAxis,yAxis);
				break;
		}
	}
	public ReportEchartsFormat getReportEchartsFormat(){
		return reportEchartsFormat;
	}
}
