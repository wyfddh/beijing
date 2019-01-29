package com.tj720.admin.dto;

import com.tj720.admin.model.GovNotice;

public class ReceiveNoticeDetailDto extends GovNotice{
	
   /* private String id;
    private String notice_id;//公告表id
    private String receive_status;//查看填报状态(0：未查阅，1：未填写，2：未提交，3：已撤回，4：已提交，5：已查阅）
    private String org_id;//接收单位id
    private String receiver;//转发接收人：最后转发的接收人
    private Date look_time;//查阅时间：第一次查阅时间
    private Date write_time;//填报时间：最后填报提交时间
*/
	private String detailId;  //详情id
	private String attachmentTitles; //附件标题
	private String publishOrgName; //发布单位
	private String deadlineTimeStr; //截止时间
	private String publishTime; //发布时间
	private String receiveStatus; //填报状态
	private String reportId; //表单id
	
	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getAttachmentTitles() {
		return attachmentTitles;
	}

	public void setAttachmentTitles(String attachmentTitles) {
		this.attachmentTitles = attachmentTitles;
	}

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public String getPublishOrgName() {
		return publishOrgName;
	}

	public void setPublishOrgName(String publishOrgName) {
		this.publishOrgName = publishOrgName;
	}

	public String getDeadlineTimeStr() {
		return deadlineTimeStr;
	}

	public void setDeadlineTimeStr(String deadlineTimeStr) {
		this.deadlineTimeStr = deadlineTimeStr;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getReceiveStatus() {
		return receiveStatus;
	}

	public void setReceiveStatus(String receiveStatus) {
		this.receiveStatus = receiveStatus;
	}

	
	
	
}
