package com.tj720.admin.dto;

import com.tj720.mip.vo.BaseVO;

public class InsideInfoDto extends BaseVO{

	/**
	 * 信息主键
	 */
	private Integer infoId;		 
	/**
	 * 信息标题
	 */
	private String infoTitle;		 
	/**
	 * 信息内容
	 */
	private String infoContent;
	/**
	 *状态 
	 */
	private String status;
	/**
	 *创建人 
	 */
	private String createdBy;
	/**
	 * 创建时间
	 */
	private String createdTime;
	/**
	 * 最后修改时间
	 */
	private String lastUpdatedTime;
	/**
	 * 最后修改人
	 */
	private String lastUpdatedBy;
	
	
	
	/**
	 * 提交时间
	 */
	private String submitTime;
	/**
	 * 提交人
	 */
	private String submitBy;
	/**
	 * 只读标识
	 */
	private Integer readFlag;
	/**
	 * 接收人ID
	 */
	private String receiverId;
	/**
	 * 信息阅读时间
	 */
	private String receiverName;
	private String orgName;
	private String readTime;
	
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public String getInfoTitle() {
		return infoTitle;
	}
	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	public void setLastUpdatedTime(String lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getSubmitBy() {
		return submitBy;
	}
	public void setSubmitBy(String submitBy) {
		this.submitBy = submitBy;
	}
	 
	public Integer getReadFlag() {
		return readFlag;
	}
	public void setReadFlag(Integer readFlag) {
		this.readFlag = readFlag;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getReadTime() {
		return readTime;
	}
	public void setReadTime(String readTime) {
		this.readTime = readTime;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
}
