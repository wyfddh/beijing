package com.tj720.mip.dto;

import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.Role;
import com.tj720.mip.model.User;

public class UserManagerDto {

	/*private User user;
	private MipOrganization organization;
	private Role role;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public MipOrganization getOrganization() {
		return organization;
	}
	public void setOrganization(MipOrganization organization) {
		this.organization = organization;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}*/
	private String phone;
	private String userName;
	private String unit;
	private String role;
	private String userId;
	
	
	
	public UserManagerDto(String phone, String userName, String unit, String role,String userId) {
		super();
		this.phone = phone;
		this.userName = userName;
		this.unit = unit;
		this.role = role;
		this.userId = userId;
	}
	
	public UserManagerDto(String phone, String userName, String unit,String userId) {
		super();
		this.phone = phone;
		this.userName = userName;
		this.unit = unit;
		this.userId = userId;
	}



	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
