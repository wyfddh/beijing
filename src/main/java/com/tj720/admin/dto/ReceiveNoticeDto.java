package com.tj720.admin.dto;

import java.sql.Date;

import com.tj720.admin.model.GovNoticeOrg;

public class ReceiveNoticeDto extends GovNoticeOrg{
	
   /* private String id;
    private String notice_id;//公告表id
    private String receive_status;//查看填报状态(0：未查阅，1：未填写，2：未提交，3：已撤回，4：已提交，5：已查阅）
    private String org_id;//接收单位id
    private String receiver;//转发接收人：最后转发的接收人
    private Date look_time;//查阅时间：第一次查阅时间
    private Date write_time;//填报时间：最后填报提交时间
*/
	private String title; //通知公告标题
	private Date lastUpdateTime;//发布时间 
	private String isFeedBack; //是否需要填报反馈
	private Date deadlineTime; //填报截止时间
	private String deadlineTimeStr; //填报截止时间
	private String publishOrg; //发布单位
	
	private String reportCode; //自定义表单
	private String bussCode; //自定义表单code
	
	private String receiveOrgName; //发布单位
	
    private String reportName;		//表单名称
    private String defineCode;		//表单业务代码-预览code
    private String defineId;		//
	private String timeTip;
	
	public String getBussCode() {
		return bussCode;
	}
	public void setBussCode(String bussCode) {
		this.bussCode = bussCode;
	}
	public String getReceiveOrgName() {
		return receiveOrgName;
	}
	public void setReceiveOrgName(String receiveOrgName) {
		this.receiveOrgName = receiveOrgName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getIsFeedBack() {
		return isFeedBack;
	}
	public void setIsFeedBack(String isFeedBack) {
		this.isFeedBack = isFeedBack;
	}
	public Date getDeadlineTime() {
		return deadlineTime;
	}
	public void setDeadlineTime(Date deadlineTime) {
		this.deadlineTime = deadlineTime;
	}
	public String getDeadlineTimeStr() {
		return deadlineTimeStr;
	}
	public void setDeadlineTimeStr(String deadlineTimeStr) {
		this.deadlineTimeStr = deadlineTimeStr;
	}
	public String getPublishOrg() {
		return publishOrg;
	}
	public void setPublishOrg(String publishOrg) {
		this.publishOrg = publishOrg;
	}
	public String getReportCode() {
		return reportCode;
	}
	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getDefineCode() {
		return defineCode;
	}
	public void setDefineCode(String defineCode) {
		this.defineCode = defineCode;
	}
	public String getDefineId() {
		return defineId;
	}
	public void setDefineId(String defineId) {
		this.defineId = defineId;
	}
	public String getTimeTip() {
		return timeTip;
	}
	public void setTimeTip(String timeTip) {
		this.timeTip = timeTip;
	}
	
	
}
