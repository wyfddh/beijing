package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;


//角色和用户中间表实体类 
@Entity
@Table(name="mip_user_role" )
@GenericGenerator(name = "Generator", strategy = "com.tj720.mip.framework.IdGenerator")
public class UserRole extends BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String roleId;

	@Column(name="user_id")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Column(name="role_id")
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	
}
