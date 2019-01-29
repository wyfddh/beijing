package com.tj720.admin.dto;

import java.util.HashMap;

/**
* @author chengrongkai
* @version 创建时间：2018年8月16日 下午2:20:56
* @ClassName 类名称
* @Description 类描述
*/
public class ReportLabel {
	private HashMap<String,Object> normal;
	ReportLabel(boolean show,String position,HashMap<String,Object> formatter){
		normal.put("show", show);
		normal.put("position", position);
		normal.put("formatter", formatter);
	}
}
