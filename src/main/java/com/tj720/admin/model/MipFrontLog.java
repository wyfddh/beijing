package com.tj720.admin.model;

import java.io.Serializable;

public class MipFrontLog implements Serializable {
    private String id;

    /**
     * 访问路径，不需要加前缀
     */
    private String path;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 用户id(可为空)
     */
    private String userId;

    /**
     * 操作类型（1：浏览，2：操作（增加，删除，修改）；3：登录）
     */
    private String opType;

    /**
     * 操作状态(0：失败；1：成功)
     */
    private String opStatus;

    /**
     * 备注
     */
    private String mark;

    /**
     * 停留时长
     */
    private Integer duration;

    /**
     * 用户账号
     */
    private String phone;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType == null ? null : opType.trim();
    }

    public String getOpStatus() {
        return opStatus;
    }

    public void setOpStatus(String opStatus) {
        this.opStatus = opStatus == null ? null : opStatus.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", path=").append(path);
        sb.append(", ip=").append(ip);
        sb.append(", createTime=").append(createTime);
        sb.append(", userId=").append(userId);
        sb.append(", opType=").append(opType);
        sb.append(", opStatus=").append(opStatus);
        sb.append(", mark=").append(mark);
        sb.append(", duration=").append(duration);
        sb.append(", phone=").append(phone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}