package com.tj720.mip.dto;
//每日一馆对象
public class EveryDayMuseumDto{


	private String orgId; 
	private String orgName;//博物馆名称
	private String orgImgUrl;
	
	private String sprId;//展览id
	private String sprImgUrl;
	
	private String collId;//藏品id
	private String collImgUrl;
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgImgUrl() {
		return orgImgUrl;
	}
	public void setOrgImgUrl(String orgImgUrl) {
		this.orgImgUrl = orgImgUrl;
	}
	public String getSprId() {
		return sprId;
	}
	public void setSprId(String sprId) {
		this.sprId = sprId;
	}
	public String getSprImgUrl() {
		return sprImgUrl;
	}
	public void setSprImgUrl(String sprImgUrl) {
		this.sprImgUrl = sprImgUrl;
	}
	public String getCollId() {
		return collId;
	}
	public void setCollId(String collId) {
		this.collId = collId;
	}
	public String getCollImgUrl() {
		return collImgUrl;
	}
	public void setCollImgUrl(String collImgUrl) {
		this.collImgUrl = collImgUrl;
	}
	
	
}
