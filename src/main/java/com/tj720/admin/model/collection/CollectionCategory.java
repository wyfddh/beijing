package com.tj720.admin.model.collection;

import java.io.Serializable;
import java.util.Date;

/**
 * collection_category
 * @author 
 */
public class CollectionCategory implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 文物类型名称
     */
    private String name;

    /**
     * 藏品类型
     */
    private String type;

    /**
     * 状态
     */
    private Byte status;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 缩写
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}