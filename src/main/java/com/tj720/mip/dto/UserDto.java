package com.tj720.mip.dto;

import java.util.List;

import com.tj720.admin.model.MipMenu;

public class UserDto {
	
	private String userId;
	private String authStr;
	private String nickname;
	private String avatarUrl;
	private byte level;
	private String orgName;
	private String orgId;
	private String platformId;
	private String passwordType;
	private String Phone;
	private String orgTypeId;
	private List<MipMenu> menusByRoles;//当前用户的所有角色所拥有的菜单
	private List<MipMenu> parentMenus;//当前用户所拥有的父菜单
	private List<MipMenu> sonMenus;//当前用户所拥有的子菜单
	private List<MipMenu> btnsByRoles;//当前用户的所有角色所拥有的按钮
	
	public UserDto() {
		super();
	}
	
	public UserDto(String userId, String authStr, String nickname, String avatarUrl) {
		super();
		this.userId = userId;
		this.authStr = authStr;
		this.nickname = nickname;
		this.avatarUrl = avatarUrl;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAuthStr() {
		return authStr;
	}
	public void setAuthStr(String authStr) {
		this.authStr = authStr;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getPasswordType() {
		return passwordType;
	}

	public void setPasswordType(String passwordType) {
		this.passwordType = passwordType;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getOrgTypeId() {
		return orgTypeId;
	}

	public void setOrgTypeId(String orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	public List<MipMenu> getMenusByRoles() {
		return menusByRoles;
	}

	public void setMenusByRoles(List<MipMenu> menusByRoles) {
		this.menusByRoles = menusByRoles;
	}

	public List<MipMenu> getBtnsByRoles() {
		return btnsByRoles;
	}

	public void setBtnsByRoles(List<MipMenu> btnsByRoles) {
		this.btnsByRoles = btnsByRoles;
	}

	public List<MipMenu> getParentMenus() {
		return parentMenus;
	}

	public void setParentMenus(List<MipMenu> parentMenus) {
		this.parentMenus = parentMenus;
	}

	public List<MipMenu> getSonMenus() {
		return sonMenus;
	}

	public void setSonMenus(List<MipMenu> sonMenus) {
		this.sonMenus = sonMenus;
	}
}
