package com.tj720.admin.model;

import java.math.BigDecimal;
import java.util.Date;

public class MipWenchuang {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.category_id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private Integer categoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.product_price
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private BigDecimal productPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.user_id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.picture_id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private String pictureId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.publish_time
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private Integer publishTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.publish
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private Byte publish;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.product_number
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private String productNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.product_name
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private String productName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.design_elements
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private String designElements;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.org_id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private Integer orgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.status
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.sequence
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private Integer sequence;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.createTime
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.type
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.reason
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private String reason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_wenchuang.content
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.id
     *
     * @return the value of mip_wenchuang.id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.id
     *
     * @param id the value for mip_wenchuang.id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.category_id
     *
     * @return the value of mip_wenchuang.category_id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.category_id
     *
     * @param categoryId the value for mip_wenchuang.category_id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.product_price
     *
     * @return the value of mip_wenchuang.product_price
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.product_price
     *
     * @param productPrice the value for mip_wenchuang.product_price
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.user_id
     *
     * @return the value of mip_wenchuang.user_id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.user_id
     *
     * @param userId the value for mip_wenchuang.user_id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.picture_id
     *
     * @return the value of mip_wenchuang.picture_id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public String getPictureId() {
        return pictureId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.picture_id
     *
     * @param pictureId the value for mip_wenchuang.picture_id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setPictureId(String pictureId) {
        this.pictureId = pictureId == null ? null : pictureId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.publish_time
     *
     * @return the value of mip_wenchuang.publish_time
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public Integer getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.publish_time
     *
     * @param publishTime the value for mip_wenchuang.publish_time
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setPublishTime(Integer publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.publish
     *
     * @return the value of mip_wenchuang.publish
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public Byte getPublish() {
        return publish;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.publish
     *
     * @param publish the value for mip_wenchuang.publish
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setPublish(Byte publish) {
        this.publish = publish;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.product_number
     *
     * @return the value of mip_wenchuang.product_number
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public String getProductNumber() {
        return productNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.product_number
     *
     * @param productNumber the value for mip_wenchuang.product_number
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber == null ? null : productNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.product_name
     *
     * @return the value of mip_wenchuang.product_name
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.product_name
     *
     * @param productName the value for mip_wenchuang.product_name
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.design_elements
     *
     * @return the value of mip_wenchuang.design_elements
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public String getDesignElements() {
        return designElements;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.design_elements
     *
     * @param designElements the value for mip_wenchuang.design_elements
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setDesignElements(String designElements) {
        this.designElements = designElements == null ? null : designElements.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.org_id
     *
     * @return the value of mip_wenchuang.org_id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public Integer getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.org_id
     *
     * @param orgId the value for mip_wenchuang.org_id
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.status
     *
     * @return the value of mip_wenchuang.status
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.status
     *
     * @param status the value for mip_wenchuang.status
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.sequence
     *
     * @return the value of mip_wenchuang.sequence
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.sequence
     *
     * @param sequence the value for mip_wenchuang.sequence
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.createTime
     *
     * @return the value of mip_wenchuang.createTime
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.createTime
     *
     * @param createtime the value for mip_wenchuang.createTime
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.type
     *
     * @return the value of mip_wenchuang.type
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.type
     *
     * @param type the value for mip_wenchuang.type
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.reason
     *
     * @return the value of mip_wenchuang.reason
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public String getReason() {
        return reason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.reason
     *
     * @param reason the value for mip_wenchuang.reason
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_wenchuang.content
     *
     * @return the value of mip_wenchuang.content
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_wenchuang.content
     *
     * @param content the value for mip_wenchuang.content
     *
     * @mbggenerated Thu Aug 24 15:57:03 CST 2017
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}