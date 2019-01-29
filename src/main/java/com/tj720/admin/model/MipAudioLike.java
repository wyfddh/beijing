package com.tj720.admin.model;

import java.util.Date;

public class MipAudioLike {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_audio_like.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_audio_like.user_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_audio_like.audio_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String audioId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_audio_like.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_audio_like.sequence
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Integer sequence;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_audio_like.createTime
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Date createtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_audio_like.id
     *
     * @return the value of mip_audio_like.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_audio_like.id
     *
     * @param id the value for mip_audio_like.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_audio_like.user_id
     *
     * @return the value of mip_audio_like.user_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_audio_like.user_id
     *
     * @param userId the value for mip_audio_like.user_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_audio_like.audio_id
     *
     * @return the value of mip_audio_like.audio_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getAudioId() {
        return audioId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_audio_like.audio_id
     *
     * @param audioId the value for mip_audio_like.audio_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setAudioId(String audioId) {
        this.audioId = audioId == null ? null : audioId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_audio_like.status
     *
     * @return the value of mip_audio_like.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_audio_like.status
     *
     * @param status the value for mip_audio_like.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_audio_like.sequence
     *
     * @return the value of mip_audio_like.sequence
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_audio_like.sequence
     *
     * @param sequence the value for mip_audio_like.sequence
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_audio_like.createTime
     *
     * @return the value of mip_audio_like.createTime
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_audio_like.createTime
     *
     * @param createtime the value for mip_audio_like.createTime
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}