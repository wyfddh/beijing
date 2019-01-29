package com.tj720.admin.model.collection;

import java.io.Serializable;
import java.util.Date;

/**
 * collection_year_type
 * @author 
 */
public class CollectionYearType implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 父Id
     */
    private String parentid;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 全称
     */
    private String fullname;

    /**
     * 藏品数
     */
    private Integer fcCounts;

    /**
     * 公开表
     */
    private Integer openCounts;

    /**
     * 节点结构字符串
     */
    private String path;

    /**
     * json结构path
     */
    private String pathJson;

    /**
     * 年代路径名
     */
    private String pathName;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 状态
     */
    private Byte status;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 简称
     */
    private String shortName;

    //藏品数量
    private Integer collectCount;

    private static final long serialVersionUID = 1L;

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getFcCounts() {
        return fcCounts;
    }

    public void setFcCounts(Integer fcCounts) {
        this.fcCounts = fcCounts;
    }

    public Integer getOpenCounts() {
        return openCounts;
    }

    public void setOpenCounts(Integer openCounts) {
        this.openCounts = openCounts;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPathJson() {
        return pathJson;
    }

    public void setPathJson(String pathJson) {
        this.pathJson = pathJson;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}