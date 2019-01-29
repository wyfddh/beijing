/** 
 * <pre>项目名称:mip 
 * 文件名称:ApplyAuditingRecord.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年1月20日下午5:02:02 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

/** 
 * <pre>项目名称：mip    
 * 类名称：ApplyAuditingRecord    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月20日 下午5:02:02    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月20日 下午5:02:02    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name = "mip_lbsc_apply_auditing_record")
@GenericGenerator(name = "Generator", strategy = "com.tj720.mip.framework.IdGenerator")
public class ApplyAuditingRecord extends BaseModel{
	private Integer addTime;//申请时间
	private Integer updateTime; //修改时间
	private Integer auditingTime;//审核时间
	private String mainModel;//主模型名
	private Integer objId;//主对象id
	private byte applyType;//申请类型:0新增、1变更
	private String applicant;//申请人
	private String auditor;//审核人
	private String auditingStep;//分步骤审核状态JSON
	private Integer lockTime;//锁定时间
	private String reason;//未通过原因
	private Date createdTime;//创建时间
	private Date updatedTime;//最后修改时间
	//业务字段
	private String staTime;
	private String endTime;
	
	
	
	
	
	@Transient
	public String getStaTime() {
		return staTime;
	}
	public void setStaTime(String staTime) {
		this.staTime = staTime;
	}
	@Transient
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Column(name = "add_time")
	public Integer getAddTime() {
		return addTime;
	}
	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}
	@Column(name = "update_time")
	public Integer getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}
	@Column(name = "auditing_time")
	public Integer getAuditingTime() {
		return auditingTime;
	}
	public void setAuditingTime(Integer auditingTime) {
		this.auditingTime = auditingTime;
	}
	@Column(name = "main_model")
	public String getMainModel() {
		return mainModel;
	}
	public void setMainModel(String mainModel) {
		this.mainModel = mainModel;
	}
	@Column(name = "obj_id")
	public Integer getObjId() {
		return objId;
	}
	public void setObjId(Integer objId) {
		this.objId = objId;
	}
	@Column(name = "apply_type")
	public byte getApplyType() {
		return applyType;
	}
	public void setApplyType(byte applyType) {
		this.applyType = applyType;
	}
	@Column(name = "applicant")
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	@Column(name = "auditor")
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	@Column(name = "auditing_step")
	public String getAuditingStep() {
		return auditingStep;
	}
	public void setAuditingStep(String auditingStep) {
		this.auditingStep = auditingStep;
	}
	@Column(name = "lock_time")
	public Integer getLockTime() {
		return lockTime;
	}
	public void setLockTime(Integer lockTime) {
		this.lockTime = lockTime;
	}
	@Column(name = "reason")
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Column(name = "created_time")
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Column(name = "updated_time")
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	   
	/**    
	 * <pre>创建一个新的实例 ApplyAuditingRecord.    
	 *    
	 * @param addTime
	 * @param updateTime
	 * @param auditingTime
	 * @param mainModel
	 * @param objId
	 * @param applyType
	 * @param applicant
	 * @param auditor
	 * @param auditingStep
	 * @param lockTime
	 * @param reason
	 * @param createdTime
	 * @param updatedTime</pre>    
	 */
	public ApplyAuditingRecord(Integer addTime, Integer updateTime, Integer auditingTime, String mainModel,
			Integer objId, byte applyType, String applicant, String auditor, String auditingStep, Integer lockTime,
			String reason, Date createdTime, Date updatedTime) {
		super();
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.auditingTime = auditingTime;
		this.mainModel = mainModel;
		this.objId = objId;
		this.applyType = applyType;
		this.applicant = applicant;
		this.auditor = auditor;
		this.auditingStep = auditingStep;
		this.lockTime = lockTime;
		this.reason = reason;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}
	   
	/**    
	 * <pre>创建一个新的实例 ApplyAuditingRecord.    
	 *    </pre>    
	 */
	public ApplyAuditingRecord() {
		super();
	}
	
	
	
}
