package com.tj720.admin.dto;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tj720.mip.vo.BaseVO;

/**
 * 馆舍建筑基本信息Entity
 * @author chenshiya
 * @version 2018-05-18
 */
public class MuseumBaseHouseDto extends BaseVO {

	private String museumId;		// 博物馆id
	private Float allBuildingArea;		// 建筑总面积
	private Float allFloorArea;		// 占地总面积
	private String museumName;		//博物馆名字
	private Float exhibitionArea;		//展陈面积',
	private Float publicArea;		// '公共服务区面积',
	private Float collectionArea;		//'藏品管理区面积',
	private Float officeArea;		// '办公区面积',
	private String repairSite;		// '是否独立拥有藏品保护修复场所',
	private Float repairArea;		// '面积',
	private String buildListStr;	//馆舍str
	private String warehouseListString;//库房str
	private	String showHouseList;//展厅str
	
	String allBuildingAreaStr;
	String allFloorAreaStr;
	String exhibitionAreaStr;
	String publicAreaStr;
	String collectionAreaStr;
	String officeAreaStr;
	String repairAreaStr;
    
	public String getAllFloorAreaStr() {
		if(allFloorArea == null){
			return "";
		}
		return floatToString(allFloorArea);
	}
	
	public void setAllFloorAreaStr(String allFloorAreaStr) {
		this.allFloorAreaStr = allFloorAreaStr;
	}
	
	public String getMuseumId() {
		return museumId;
	}
	public void setMuseumId(String museumId) {
		this.museumId = museumId;
	}
	public Float getAllBuildingArea() {
		return allBuildingArea;
	}
	public void setAllBuildingArea(Float allBuildingArea) {
		this.allBuildingArea = allBuildingArea;
	}
	public Float getAllFloorArea() {
		return allFloorArea;
	}
	public void setAllFloorArea(Float allFloorArea) {
		this.allFloorArea = allFloorArea;
	}
	public String getMuseumName() {
		return museumName;
	}
	public void setMuseumName(String museumName) {
		this.museumName = museumName;
	}
	public Float getExhibitionArea() {
		return exhibitionArea;
	}
	public void setExhibitionArea(Float exhibitionArea) {
		this.exhibitionArea = exhibitionArea;
	}
	public Float getPublicArea() {
		return publicArea;
	}
	public void setPublicArea(Float publicArea) {
		this.publicArea = publicArea;
	}
	public Float getCollectionArea() {
		return collectionArea;
	}
	public void setCollectionArea(Float collectionArea) {
		this.collectionArea = collectionArea;
	}
	public Float getOfficeArea() {
		return officeArea;
	}
	public void setOfficeArea(Float officeArea) {
		this.officeArea = officeArea;
	}
	public String getRepairSite() {
		return repairSite;
	}
	public void setRepairSite(String repairSite) {
		this.repairSite = repairSite;
	}
	public Float getRepairArea() {
		return repairArea;
	}
	public void setRepairArea(Float repairArea) {
		this.repairArea = repairArea;
	}
	public String getBuildListStr() {
		return buildListStr;
	}
	public void setBuildListStr(String buildListStr) {
		this.buildListStr = buildListStr;
	}
	public String getWarehouseListString() {
		return warehouseListString;
	}
	public void setWarehouseListString(String warehouseListString) {
		this.warehouseListString = warehouseListString;
	}
	public String getShowHouseList() {
		return showHouseList;
	}
	public void setShowHouseList(String showHouseList) {
		this.showHouseList = showHouseList;
	}
	
	
    public String getAllBuildingAreaStr() {
    	if(allBuildingArea == null){
			return "";
		}
		return floatToString(allBuildingArea);
	}

	public void setAllBuildingAreaStr(String allBuildingAreaStr) {
		this.allBuildingAreaStr = allBuildingAreaStr;
	}

	public String getExhibitionAreaStr() {
		if(exhibitionArea == null){
			return "";
		}
		return floatToString(exhibitionArea);
	}

	public void setExhibitionAreaStr(String exhibitionAreaStr) {
		this.exhibitionAreaStr = exhibitionAreaStr;
	}

	public String getPublicAreaStr() {
		if(publicArea == null){
			return "";
		}
		return floatToString(publicArea);
	}

	public void setPublicAreaStr(String publicAreaStr) {
		this.publicAreaStr = publicAreaStr;
	}

	public String getCollectionAreaStr() {
		if(collectionArea == null){
			return "";
		}
		return floatToString(collectionArea);
	}

	public void setCollectionAreaStr(String collectionAreaStr) {
		this.collectionAreaStr = collectionAreaStr;
	}

	public String getOfficeAreaStr() {
		if(officeArea == null){
			return "";
		}
		return floatToString(officeArea);
	}

	public void setOfficeAreaStr(String officeAreaStr) {
		this.officeAreaStr = officeAreaStr;
	}


	public String getRepairAreaStr() {
		if(repairArea == null){
			return "";
		}
		return floatToString(repairArea);
	}

	public void setRepairAreaStr(String repairAreaStr) {
		this.repairAreaStr = repairAreaStr;
	}

	public String floatToString(Float fVal){
    	DecimalFormat  dec  =  new  DecimalFormat("##0.00");
        return dec.format(fVal);
    }
}