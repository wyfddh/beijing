package com.tj720.admin.dto;

import com.tj720.mip.vo.BaseVO;

/**
 * 资料完成度Entity
 * @author chenshiya
 * @version 2018-05-18
 */
public class MuseumDataProgressDto extends BaseVO {

	private String museumId;		// 博物馆id
	private String basePer;		// 基本信息完成度1
	private String housePer;		// 馆舍建筑与基础设施完成度2
	private String costPer;		// 经费来源与保障填写完成度5
	private String servicePer;	//陈列展览与社会服务填写完成度7
	private String personPer;    //机构人员信息填写完成度3
	private String digitizationPer;	//信息智能化建设完成度4
	private String collectionPer;//藏品管理与科学研究完成度6
	private String safePer;//安全保障8
	private String allDataPer;	//总完成度
	private String orgType;//机构类型(01文物局02区文委03博物馆04文物修复资质单位)
	private	String museumName;//
	public String getMuseumId() {
		return museumId;
	}
	public void setMuseumId(String museumId) {
		this.museumId = museumId;
	}
	public String getBasePer() {
		return basePer;
	}
	public void setBasePer(String basePer) {
		this.basePer = basePer;
	}
	public String getHousePer() {
		return housePer;
	}
	public void setHousePer(String housePer) {
		this.housePer = housePer;
	}
	public String getCostPer() {
		return costPer;
	}
	public void setCostPer(String costPer) {
		this.costPer = costPer;
	}
	public String getServicePer() {
		return servicePer;
	}
	public void setServicePer(String servicePer) {
		this.servicePer = servicePer;
	}
	public String getPersonPer() {
		return personPer;
	}
	public void setPersonPer(String personPer) {
		this.personPer = personPer;
	}
	public String getDigitizationPer() {
		return digitizationPer;
	}
	public void setDigitizationPer(String digitizationPer) {
		this.digitizationPer = digitizationPer;
	}
	public String getAllDataPer() {
		return allDataPer;
	}
	public void setAllDataPer(String allDataPer) {
		this.allDataPer = allDataPer;
	}
	
	public String getCollectionPer() {
		return collectionPer;
	}
	public void setCollectionPer(String collectionPer) {
		this.collectionPer = collectionPer;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getMuseumName() {
		return museumName;
	}
	public void setMuseumName(String museumName) {
		this.museumName = museumName;
	}
	public String getSafePer() {
		return safePer;
	}
	public void setSafePer(String safePer) {
		this.safePer = safePer;
	}
	
	
}