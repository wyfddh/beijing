package com.tj720.admin.model;

import java.util.Date;

public class MipCollectionLevel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_level.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_level.name
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_level.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_level.createTtime
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Date createttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_level.updated_time
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Date updatedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_level.sequence
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Integer sequence;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_level.id
     *
     * @return the value of mip_collection_level.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_level.id
     *
     * @param id the value for mip_collection_level.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_level.name
     *
     * @return the value of mip_collection_level.name
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_level.name
     *
     * @param name the value for mip_collection_level.name
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_level.status
     *
     * @return the value of mip_collection_level.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_level.status
     *
     * @param status the value for mip_collection_level.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_level.createTtime
     *
     * @return the value of mip_collection_level.createTtime
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Date getCreatettime() {
        return createttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_level.createTtime
     *
     * @param createttime the value for mip_collection_level.createTtime
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setCreatettime(Date createttime) {
        this.createttime = createttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_level.updated_time
     *
     * @return the value of mip_collection_level.updated_time
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_level.updated_time
     *
     * @param updatedTime the value for mip_collection_level.updated_time
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_level.sequence
     *
     * @return the value of mip_collection_level.sequence
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_level.sequence
     *
     * @param sequence the value for mip_collection_level.sequence
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}