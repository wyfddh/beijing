package com.tj720.admin.dto;

import java.text.DecimalFormat;

import com.tj720.mip.vo.BaseVO;

/**
 * 库房情况Entity
 * @author chenshiya
 * @version 2018-05-18
 */
public class MuseumWarehouseDto extends BaseVO {

	private String museumId;		// '博物馆id',
	private String name;		// '库房名称',
	private Float houseArea;		//  '库房面积',
	private String collectionNeeds;		// '是否满足藏品收藏需要(1满足；2基本满足；3否)',
	private String completeRack;		//  '柜架齐全(1:有0：无)',
	private String monitor;		//  '是否有入侵报警系统(1:有0：无)',
	private String temperature;		// '温湿度控制设施(1温湿度设施完善，设备齐全，按藏品质地控制温湿度；2温湿度设施基本完善、设备基本齐全，能控制温湿度；3有简单的温湿度控制设备；4没有温湿度控制设施)',
	private String roomLighting;		//  '库房照明设施是否符合设计规范要求(1:有0：无)',
	private String fireFighting;		//  '安防消防设施(1安防消防设施完善，设备齐全，能达到防火防盗防震等条件；2安防消防设施基本完善、设备基本齐全，具备基本的防火防盗防震条件；3有简单的安防消防设施；4没有安防消防设施)',
	private String firePrevention;		//  '防火(1:you 0无)', 没用上
	private String guardAgainstTheft;		//  '防盗',
	private String lightProtection;		//  '防雷',放自然灾害
	private String shockproof;		// '防震', 没用上
	private String waterproof;		// '防水',
	private String ventilationFacility;		//  '是否有通风设施',
	private String corrosionProtection;		//  '是否有防腐蚀设施',
	private String mildewResistance;		//  '是否有防霉变设施',
	private String airPollution;		//  '是否有防空气污染设施',
	private String insectControl;		//  '是否有防虫设施',
	private String waterproofFacility;		// '是否有防水设施', 没用上
	String houseAreaStr;
	public String getMuseumId() {
		return museumId;
	}
	public void setMuseumId(String museumId) {
		this.museumId = museumId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(Float houseArea) {
		this.houseArea = houseArea;
	}
	public String getCollectionNeeds() {
		return collectionNeeds;
	}
	public void setCollectionNeeds(String collectionNeeds) {
		this.collectionNeeds = collectionNeeds;
	}
	public String getCompleteRack() {
		return completeRack;
	}
	public void setCompleteRack(String completeRack) {
		this.completeRack = completeRack;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getRoomLighting() {
		return roomLighting;
	}
	public void setRoomLighting(String roomLighting) {
		this.roomLighting = roomLighting;
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
	public String getVentilationFacility() {
		return ventilationFacility;
	}
	public void setVentilationFacility(String ventilationFacility) {
		this.ventilationFacility = ventilationFacility;
	}
	public String getCorrosionProtection() {
		return corrosionProtection;
	}
	public void setCorrosionProtection(String corrosionProtection) {
		this.corrosionProtection = corrosionProtection;
	}
	public String getMildewResistance() {
		return mildewResistance;
	}
	public void setMildewResistance(String mildewResistance) {
		this.mildewResistance = mildewResistance;
	}
	public String getAirPollution() {
		return airPollution;
	}
	public void setAirPollution(String airPollution) {
		this.airPollution = airPollution;
	}
	public String getInsectControl() {
		return insectControl;
	}
	public void setInsectControl(String insectControl) {
		this.insectControl = insectControl;
	}
	public String getWaterproofFacility() {
		return waterproofFacility;
	}
	public void setWaterproofFacility(String waterproofFacility) {
		this.waterproofFacility = waterproofFacility;
	}
	public String getHouseAreaStr() {
		if(houseArea ==null){
			return "";
		}
		return floatToString(houseArea);
	}
	public void setHouseAreaStr(String houseAreaStr) {
		this.houseAreaStr = houseAreaStr;
	}
	
	public String floatToString(Float fVal){
    	DecimalFormat  dec  =  new  DecimalFormat("##0.00");
        return dec.format(fVal);
    }
}