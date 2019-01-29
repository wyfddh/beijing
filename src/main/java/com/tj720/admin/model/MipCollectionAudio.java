package com.tj720.admin.model;

import java.util.Date;

public class MipCollectionAudio {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_audio.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_audio.collection_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String collectionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_audio.user_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_audio.is_official
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Byte isOfficial;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_audio.url
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_audio.like_counts
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Integer likeCounts;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_audio.publish_time
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Long publishTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_audio.duration
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String duration;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_audio.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Byte status =1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_audio.createTime
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_collection_audio.sequence
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Integer sequence;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_audio.id
     *
     * @return the value of mip_collection_audio.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    
    
    private String collectionName;
    private String mueseumName;
    private String userName;
    private String startTime;
    private String endTime;
    
    
    
    
    
    public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public String getMueseumName() {
		return mueseumName;
	}

	public void setMueseumName(String mueseumName) {
		this.mueseumName = mueseumName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_audio.id
     *
     * @param id the value for mip_collection_audio.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_audio.collection_id
     *
     * @return the value of mip_collection_audio.collection_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getCollectionId() {
        return collectionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_audio.collection_id
     *
     * @param collectionId the value for mip_collection_audio.collection_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId == null ? null : collectionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_audio.user_id
     *
     * @return the value of mip_collection_audio.user_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_audio.user_id
     *
     * @param userId the value for mip_collection_audio.user_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_audio.is_official
     *
     * @return the value of mip_collection_audio.is_official
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Byte getIsOfficial() {
        return isOfficial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_audio.is_official
     *
     * @param isOfficial the value for mip_collection_audio.is_official
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setIsOfficial(Byte isOfficial) {
        this.isOfficial = isOfficial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_audio.url
     *
     * @return the value of mip_collection_audio.url
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_audio.url
     *
     * @param url the value for mip_collection_audio.url
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_audio.like_counts
     *
     * @return the value of mip_collection_audio.like_counts
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Integer getLikeCounts() {
        return likeCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_audio.like_counts
     *
     * @param likeCounts the value for mip_collection_audio.like_counts
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setLikeCounts(Integer likeCounts) {
        this.likeCounts = likeCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_audio.publish_time
     *
     * @return the value of mip_collection_audio.publish_time
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Long getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_audio.publish_time
     *
     * @param publishTime the value for mip_collection_audio.publish_time
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_audio.duration
     *
     * @return the value of mip_collection_audio.duration
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getDuration() {
        return duration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_audio.duration
     *
     * @param duration the value for mip_collection_audio.duration
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_audio.status
     *
     * @return the value of mip_collection_audio.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_audio.status
     *
     * @param status the value for mip_collection_audio.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_audio.createTime
     *
     * @return the value of mip_collection_audio.createTime
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_audio.createTime
     *
     * @param createtime the value for mip_collection_audio.createTime
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_collection_audio.sequence
     *
     * @return the value of mip_collection_audio.sequence
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_collection_audio.sequence
     *
     * @param sequence the value for mip_collection_audio.sequence
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}