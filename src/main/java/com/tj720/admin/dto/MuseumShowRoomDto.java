package com.tj720.admin.dto;

import java.text.DecimalFormat;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.mip.vo.BaseVO;

/**
 * 展厅信息Entity
 * @author chenshiya
 * @version 2018-05-18
 */
public class MuseumShowRoomDto extends BaseVO {

	private String museumId;		// '博物馆id',
	private String name;		// '展厅名称',
	private Float area;		// '面积',
	private String roomLighting;		//  '展厅照明符合设计规范要求',
	private String collectionProtect;		//  '展柜微环境适宜展品保护(1所有文物展柜均符合；2珍贵文物展柜均符合；3少部分文物展柜符合；4不符合)',
	private String monitor;		// '是否有入侵报警系统(1:有0：无)',
	private String fireFighting;		// '安防消防设施(1安防消防设施完善，设备齐全，能达到防火防盗防震等条件；2安防消防设施基本完善、设备基本齐全，具备基本的防火防盗防震条件；3有简单的安防消防设施；4没有安防消防设施)',
	private String firePrevention;		// '防火(1:you 0无)',
	private String guardAgainstTheft;		//  '防盗',
	private String lightProtection;		//  '防雷',
	private String shockproof;		//  '防震',
	private String waterproof;		//  '防水',
	String	areaStr;
	
	public String getMuseumId() {
		return museumId;
	}
	public void setMuseumId(String museumId) {
		this.museumId = museumId;
	}
	public String getName() {
		return name;
	}
	
	public Float getArea() {
		return area;
	}
	public void setArea(Float area) {
		this.area = area;
	}
	public String getRoomLighting() {
		return roomLighting;
	}
	public void setRoomLighting(String roomLighting) {
		this.roomLighting = roomLighting;
	}
	public String getCollectionProtect() {
		return collectionProtect;
	}
	public void setCollectionProtect(String collectionProtect) {
		this.collectionProtect = collectionProtect;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String getFireFighting() {
		return fireFighting;
	}
	public void setFireFighting(String fireFighting) {
		this.fireFighting = fireFighting;
	}
	public String getFirePrevention() {
		return firePrevention;
	}
	public void setFirePrevention(String firePrevention) {
		this.firePrevention = firePrevention;
	}
	public String getGuardAgainstTheft() {
		return guardAgainstTheft;
	}
	public void setGuardAgainstTheft(String guardAgainstTheft) {
		this.guardAgainstTheft = guardAgainstTheft;
	}
	public String getLightProtection() {
		return lightProtection;
	}
	public void setLightProtection(String lightProtection) {
		this.lightProtection = lightProtection;
	}
	public String getShockproof() {
		return shockproof;
	}
	public void setShockproof(String shockproof) {
		this.shockproof = shockproof;
	}
	public String getWaterproof() {
		return waterproof;
	}
	public void setWaterproof(String waterproof) {
		this.waterproof = waterproof;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAreaStr() {
		if(area==null){
			return "";
		}
		return floatToString(area);
	}
	public void setAreaStr(String areaStr) {
		this.areaStr = areaStr;
	}
	public String floatToString(Float fVal){
    	DecimalFormat  dec  =  new  DecimalFormat("##0.00");
        return dec.format(fVal);
    }
}