package com.tj720.admin.dto;

public class MipFrontLogSearchDto {

    /**
     * 访问路径，不需要加前缀
     */
    private String path;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 操作类型（1：浏览，2：操作（增加，删除，修改）；3：登录）
     */
    private String opType;

    /**
     * 操作状态(0：失败；1：成功)
     */
    private String opStatus;

    /**
     * 用户账号
     */
    private String phone;
    
    private String stateTime;
    private String endTime;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getOpType() {
		return opType;
	}
	public void setOpType(String opType) {
		this.opType = opType;
	}
	public String getOpStatus() {
		return opStatus;
	}
	public void setOpStatus(String opStatus) {
		this.opStatus = opStatus;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStateTime() {
		return stateTime;
	}
	public void setStateTime(String stateTime) {
		this.stateTime = stateTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
    
}
