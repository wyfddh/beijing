package com.tj720.mip.vo;


import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseVO {

    /**
     * primary key
     */
    String id;
    String creatorId;
    Date createTime;
    String updateId;

    Date updateTime;
    //数据权限
    private Boolean allPrimession;//是否拥有所有的数据权限
    private String seNo;//员工id
    private String baseLevel;//员工数据权限

    String strCreateTime;
    String strUpdatTime;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	String remarks;	// 备注

    String flag; 	// 查看标记（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））

    public Boolean getAllPrimession() {
        return allPrimession;
    }

    public void setAllPrimession(Boolean allPrimession) {
        this.allPrimession = allPrimession;
    }

    public String getSeNo() {
        return seNo;
    }

    public void setSeNo(String seNo) {
        this.seNo = seNo;
    }

    public String getBaseLevel() {
        return baseLevel;
    }

    public void setBaseLevel(String baseLevel) {
        this.baseLevel = baseLevel;
    }

    public void setStrCreateTime(String strCreateTime) {
        this.strCreateTime = strCreateTime;
    }

    public void setStrUpdatTime(String strUpdatTime) {
        this.strUpdatTime = strUpdatTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getStrCreateTime() {
        if(createTime == null){
            return "";
        }
        return convert(createTime);
    }


    public String getStrUpdatTime() {
        if(updateTime == null){
            return "";
        }
        return convert(updateTime);
    }

    public String convert(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
