package com.tj720.mip.dto;

import java.io.Serializable;

public class LoginDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	public String userName;
	public String password;
	public String rpassword;
	public String remberPwd;
	public String verificationCode;
	public String sessionAdminName; // 如果sessionAdminName 不为null，则表示已经登陆
	public String tipMessage;
	public String phone;
	public int errorTimes;//登录错误次数
	private String nickName;//昵称
	private String secretCode;//手机验证码
	private String headimgurl;//头像
	private byte level;//用户所属组织机构级别
	private String token;//前端用户才有的token
	private String isback;
	
	
	public String getIsback() {
		return isback;
	}
	public void setIsback(String isback) {
		this.isback = isback;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSecretCode() {
		return secretCode;
	}
	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRemberPwd() {
		return remberPwd;
	}
	public void setRemberPwd(String remberPwd) {
		this.remberPwd = remberPwd;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	public String getSessionAdminName() {
		return sessionAdminName;
	}
	public void setSessionAdminName(String sessionAdminName) {
		this.sessionAdminName = sessionAdminName;
	}
	public String getTipMessage() {
		return tipMessage;
	}
	public void setTipMessage(String tipMessage) {
		this.tipMessage = tipMessage;
	}
	public String getRpassword() {
		return rpassword;
	}
	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getErrorTimes() {
		return errorTimes;
	}
	public void setErrorTimes(int errorTimes) {
		this.errorTimes = errorTimes;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public byte getLevel() {
		return level;
	}
	public void setLevel(byte level) {
		this.level = level;
	}
	
}
