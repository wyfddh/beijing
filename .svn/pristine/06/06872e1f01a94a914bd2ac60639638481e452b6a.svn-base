package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.tj720.mip.framework.base.BaseModel;

@Entity
@Table(name="mip_role")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class Role extends BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private String parentId;
	private String roleName;
	private String remark;
	private int isdelete;
	private String updateTime;
	private String creatorId;
	private String updaterId;
	private String orgType;

	@Column(name="name")
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
    @Column(name="parent_id")
    public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
    
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    @Column(name="isdelete")
	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
    @Column(name="update_time")
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name="creator_id")
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	@Column(name="updater_id")
	public String getUpdaterId() {
		return updaterId;
	}
	public void setUpdaterId(String updaterId) {
		this.updaterId = updaterId;
	}
	@Column(name="orgType")
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
   
	
	

}