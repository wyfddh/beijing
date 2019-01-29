package com.tj720.mip.model;

import javax.persistence.Transient;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;
import com.tj720.mip.utils.MyString;

@Entity
@Table(name = "mip_user")
@GenericGenerator(name = "Generator", strategy = "com.tj720.mip.framework.IdGenerator")
public class User extends BaseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orgId = "";
	private String password = "";
	private String phone = "";
	private byte sex;
	private String nickName = "";
	private String userName = "";
	private String avatarUrl = "";// 用户头像
	private byte isDelete;
	private int LoginType;
	private String weixinUnionid = "";
	private int lastLoginTime = 0;
	private String roleId = "";
	private String roleName = "";
	private String qqOpenid = "";
	private String areaId = "";
	private String job = "";
	private String tags;
	private String birthday = "1000-01-01";
	private String description;
	private Integer province;
	private Integer city;
	private Integer county;
	private String token;//前端用户才有的token

	// 业务字段
	private String orgName = "";
	private String UserTags = "";
	private String provinceStr = "";
	private String cityStr = "";
	private String countyStr = "";
	
	
	@Transient
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Transient
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	@Transient
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	@Transient
	public String getUserTags() {
		return UserTags;
	}

	public void setUserTags(String userTags) {
		UserTags = userTags;
	}
	
	@Transient
	public String getProvinceStr() {
		return provinceStr;
	}

	public void setProvinceStr(String provinceStr) {
		this.provinceStr = provinceStr;
	}

	@Transient
	public String getCityStr() {
		return cityStr;
	}

	public void setCityStr(String cityStr) {
		this.cityStr = cityStr;
	}

	@Transient
	public String getCountyStr() {
		return countyStr;
	}

	public void setCountyStr(String countyStr) {
		this.countyStr = countyStr;
	}
	

	@Column(name = "qq_openid")
	public String getQqOpenid() {
		return qqOpenid;
	}

	public void setQqOpenid(String qqOpenid) {
		this.qqOpenid = qqOpenid;
	}

	@Column(name = "area_id")
	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	@Column(name = "job")
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "tags")
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Column(name = "birthday")
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column(name = "last_login_time")
	public int getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(int lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "phone")
	public String getPhone() {
		if (!MyString.isEmpty(phone))
			return phone.toLowerCase();
		return "";
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "avatarUrl")
	public String getAvatarUrl() {
		if (MyString.isEmpty(avatarUrl))
			return "";
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	@Column(name = "org_id")
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	@Column(name = "nick_name")
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "isdelete")
	public byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "login_type")
	public int getLoginType() {
		return LoginType;
	}

	public void setLoginType(int loginType) {
		LoginType = loginType;
	}

	@Column(name = "weixin_unionid")
	public String getWeixinUnionid() {
		return weixinUnionid;
	}

	public void setWeixinUnionid(String weixinUnionid) {
		this.weixinUnionid = weixinUnionid;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "sex")
	public byte getSex() {
		return sex;
	}

	public void setSex(byte sex) {
		this.sex = sex;
	}

	@Column(name = "province")
	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	@Column(name = "city")
	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	@Column(name = "county")
	public Integer getCounty() {
		return county;
	}

	public void setCounty(Integer county) {
		this.county = county;
	}
	@Transient
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}