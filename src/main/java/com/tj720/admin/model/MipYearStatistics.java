package com.tj720.admin.model;

import java.util.Date;

public class MipYearStatistics {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_year_statistics.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_year_statistics.tj_yt_name
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String tjYtName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_year_statistics.yt_ids
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String ytIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_year_statistics.sequence
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Integer sequence;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_year_statistics.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_year_statistics.createTime
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Date createtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_year_statistics.id
     *
     * @return the value of mip_year_statistics.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_year_statistics.id
     *
     * @param id the value for mip_year_statistics.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_year_statistics.tj_yt_name
     *
     * @return the value of mip_year_statistics.tj_yt_name
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getTjYtName() {
        return tjYtName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_year_statistics.tj_yt_name
     *
     * @param tjYtName the value for mip_year_statistics.tj_yt_name
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setTjYtName(String tjYtName) {
        this.tjYtName = tjYtName == null ? null : tjYtName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_year_statistics.yt_ids
     *
     * @return the value of mip_year_statistics.yt_ids
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getYtIds() {
        return ytIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_year_statistics.yt_ids
     *
     * @param ytIds the value for mip_year_statistics.yt_ids
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setYtIds(String ytIds) {
        this.ytIds = ytIds == null ? null : ytIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_year_statistics.sequence
     *
     * @return the value of mip_year_statistics.sequence
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_year_statistics.sequence
     *
     * @param sequence the value for mip_year_statistics.sequence
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_year_statistics.status
     *
     * @return the value of mip_year_statistics.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_year_statistics.status
     *
     * @param status the value for mip_year_statistics.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_year_statistics.createTime
     *
     * @return the value of mip_year_statistics.createTime
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_year_statistics.createTime
     *
     * @param createtime the value for mip_year_statistics.createTime
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}