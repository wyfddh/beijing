package com.tj720.admin.model;

import java.io.Serializable;

public class MipLog implements Serializable {
    private String id;

    /**
     * 状态（0：通用密码登录操作失败；1：通用密码登录操作成功；2：正常密码登录操作成功；3：正常密码登录操作失败）
     */
    private Byte status;

    private String createtime;

    /**
     * 排序，越大越靠前
     */
    private Integer sequence;

    private String modelclass;

    private String modelname;

    /**
     * 日志类型：（1：藏品；2：用户；3：咨讯内容；4：登录；5：其它；）
     */
    private String type;

    /**
     * 操作人Id
     */
    private String updateby;

    /**
     * 操作备注
     */
    private String remark;

    /**
     * 用户账号
     */
    private String phone;

    /**
     * 操作者ip地址
     */
    private String ip;

    private String content;
    
    private String orgName;

    private static final long serialVersionUID = 1L;

    
    public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getModelclass() {
        return modelclass;
    }

    public void setModelclass(String modelclass) {
        this.modelclass = modelclass == null ? null : modelclass.trim();
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname == null ? null : modelname.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", createtime=").append(createtime);
        sb.append(", sequence=").append(sequence);
        sb.append(", modelclass=").append(modelclass);
        sb.append(", modelname=").append(modelname);
        sb.append(", type=").append(type);
        sb.append(", updateby=").append(updateby);
        sb.append(", remark=").append(remark);
        sb.append(", phone=").append(phone);
        sb.append(", ip=").append(ip);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}