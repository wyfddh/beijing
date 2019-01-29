package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

@Entity
@Table(name = "mip_role_auth")
@GenericGenerator(name = "Generator", strategy = "com.tj720.mip.framework.IdGenerator")
public class RoleAuth  extends BaseModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String roleId;
	private String authId;
	
	@Column(name="role_id")
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@Column(name="auth_id")
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	
	

}
