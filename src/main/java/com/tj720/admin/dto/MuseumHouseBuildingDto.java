package com.tj720.admin.dto;

import java.text.DecimalFormat;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.mip.vo.BaseVO;

/**
 * 馆舍建筑Entity
 * @author chenshiya
 * @version 2018-05-18
 */
public class MuseumHouseBuildingDto extends BaseVO {

	private String museumId;		// 博物馆id
	private  String houseName; //馆舍名称
	private String level;		// 馆舍文物建筑级别
	private String ownership;		// 建筑所有权

	private Float floorArea;
	
	String floorAreaStr;

	public String getMuseumId() {
		return museumId;
	}

	public void setMuseumId(String museumId) {
		this.museumId = museumId;
	}

	public Float getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Float floorArea) {
		this.floorArea = floorArea;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getFloorAreaStr() {
		if(floorArea ==null){
			return "";
		}
		return floatToString(floorArea);
	}

	public void setFloorAreaStr(String floorAreaStr) {
		this.floorAreaStr = floorAreaStr;
	}
	
	public String floatToString(Float fVal){
    	DecimalFormat  dec  =  new  DecimalFormat("##0.00");
        return dec.format(fVal);
    }
	
}