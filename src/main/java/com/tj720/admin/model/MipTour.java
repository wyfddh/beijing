package com.tj720.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * mip_tour
 * @author 
 */
public class MipTour implements Serializable {
    private String id;

    /**
     * 导览名称
     */
    private String name;

    /**
     * 发布单位
     */
    private String publishOrg;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 导览地址
     */
    private String address;

    /**
     * 数字展厅地址
     */
    private String virtualUrl;

    /**
     * 标签
     */
    private String label;

    /**
     * 标题图链接
     */
    private String iconUrl;

    /**
     * 状态（0：已删除 1：未提交 2：已发布，3已提交待审批 4已驳回）
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 展览介绍
     */
    private String introduction;

    /**
     * 发布单位名称
     */
    private String publishOrgName;

    private double latitude;//经度

    private double longitude;//纬度

    private double meter;//博物馆距离

    private String meterStr;//

    private Integer listenNumber;//收听次数

    private String museumName;//博物馆名称

    private String collectionNum;//藏品个数

    private String museumPicture;//博物馆标题图

    private Date startDate;

    private Date endDate;

    private String tourTime;

    private static final long serialVersionUID = 1L;

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

    public String getPublishOrg() {
        return publishOrg;
    }

    public void setPublishOrg(String publishOrg) {
        this.publishOrg = publishOrg;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVirtualUrl() {
        return virtualUrl;
    }

    public void setVirtualUrl(String virtualUrl) {
        this.virtualUrl = virtualUrl;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getMeter() {
        return meter;
    }

    public void setMeter(double meter) {
        this.meter = meter;
    }

    public String getMeterStr() {
        return meterStr;
    }

    public void setMeterStr(String meterStr) {
        this.meterStr = meterStr;
    }

    public Integer getListenNumber() {
        return listenNumber;
    }

    public void setListenNumber(Integer listenNumber) {
        this.listenNumber = listenNumber;
    }

    public String getMuseumName() {
        return museumName;
    }

    public void setMuseumName(String museumName) {
        this.museumName = museumName;
    }

    public String getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(String collectionNum) {
        this.collectionNum = collectionNum;
    }

    public String getMuseumPicture() {
        return museumPicture;
    }

    public void setMuseumPicture(String museumPicture) {
        this.museumPicture = museumPicture;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPublishOrgName() {
        return publishOrgName;
    }

    public void setPublishOrgName(String publishOrgName) {
        this.publishOrgName = publishOrgName;
    }

    public String getTourTime() {
        return tourTime;
    }

    public void setTourTime(String tourTime) {
        this.tourTime = tourTime;
    }
}