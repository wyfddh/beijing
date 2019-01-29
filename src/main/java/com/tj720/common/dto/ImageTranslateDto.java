package com.tj720.common.dto;

import java.io.Serializable;
import java.util.List;


public class ImageTranslateDto implements Serializable{
	private static final long serialVersionUID = 5858487368367766315L;
	
	private String opType;//操作类型；add：添加 del：删除
	private List<String> imgPaths; //图片路径
	
	public ImageTranslateDto() {
		super();
	}
	public ImageTranslateDto(String opType, List<String> imgPaths) {
		super();
		this.opType = opType;
		this.imgPaths = imgPaths;
	}
	public String getOpType() {
		return opType;
	}
	public void setOpType(String opType) {
		this.opType = opType;
	}
	public List<String> getImgPaths() {
		return imgPaths;
	}
	public void setImgPaths(List<String> imgPaths) {
		this.imgPaths = imgPaths;
	}

	
}
