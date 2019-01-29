package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

@Entity
@Table(name="mip_auth")
@GenericGenerator(name="Generator",strategy="com.tj720.mip.framework.IdGenerator")
public class Auth extends BaseModel implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	//权限名称
	private String authName;

	@Column(name="name")
	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}
	
	
	
	

}
