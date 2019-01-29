package com.tj720.mip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

@Entity
@Table(name="ext_museum_subject")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MuseumSubject extends BaseModel{
	
	private String orgId = "";//博物馆ID
	private String name = "0";//类别名称
	private String description="";//栏目详情
	private String subjectType="";//栏目类型
	private String modelType="";//所属模型
	private String pId="";//冗余字段
	private String updatedTime="";//修改时间
	@Column(name="org_id")
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="subject_type")
	public String getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
	@Column(name="model_type")
	public String getModelType() {
		return modelType;
	}
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
	@Column(name="p_id")
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	@Column(name="updated_time")
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	public MuseumSubject() {
		super();
	}
	public MuseumSubject(String orgId, String name, String description, String subjectType, String modelType,
			String pId, String updatedTime) {
		super();
		this.orgId = orgId;
		this.name = name;
		this.description = description;
		this.subjectType = subjectType;
		this.modelType = modelType;
		this.pId = pId;
		this.updatedTime = updatedTime;
	}

	public MuseumSubject(String id,String orgId, String name, String description, String subjectType, String modelType,
			String pId,String createTime,byte status,int sequence,String updatedTime) {
		super();
		this.id = id;
		this.orgId = orgId;
		this.name = name;
		this.description = description;
		this.subjectType = subjectType;
		this.modelType = modelType;
		this.pId = pId;
		this.createTime = createTime;
		this.status = status;
		this.sequence = sequence;
		this.updatedTime = updatedTime;
	}

}
