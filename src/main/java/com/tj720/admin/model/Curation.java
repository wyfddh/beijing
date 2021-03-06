package com.tj720.admin.model;

public class Curation {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ext_curation.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ext_curation.title
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ext_curation.collection_ids
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String collectionIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ext_curation.img_src
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String imgSrc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ext_curation.create_time
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ext_curation.modify_time
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ext_curation.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ext_curation.view_counts
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private Integer viewCounts;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ext_curation.user_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String userId;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ext_curation.nice_size
     *
     * @mbggenerated Thu Oct 12 18:05:00 CST 2017
     */
    private Integer niceSize;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ext_curation.description
     *
     * @mbggenerated Tue Jul 25 13:30:23 CST 2017
     */
    
    private String userName;
    private String staTime;
    private String overTime;
    private String publish;
    
    

    public String getStaTime() {
		return staTime;
	}

	public void setStaTime(String staTime) {
		this.staTime = staTime;
	}

	public String getOverTime() {
		return overTime;
	}

	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ext_curation.description
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ext_curation.id
     *
     * @return the value of ext_curation.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ext_curation.id
     *
     * @param id the value for ext_curation.id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ext_curation.title
     *
     * @return the value of ext_curation.title
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ext_curation.title
     *
     * @param title the value for ext_curation.title
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ext_curation.collection_ids
     *
     * @return the value of ext_curation.collection_ids
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getCollectionIds() {
        return collectionIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ext_curation.collection_ids
     *
     * @param collectionIds the value for ext_curation.collection_ids
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setCollectionIds(String collectionIds) {
        this.collectionIds = collectionIds == null ? null : collectionIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ext_curation.img_src
     *
     * @return the value of ext_curation.img_src
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getImgSrc() {
        return imgSrc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ext_curation.img_src
     *
     * @param imgSrc the value for ext_curation.img_src
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc == null ? null : imgSrc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ext_curation.create_time
     *
     * @return the value of ext_curation.create_time
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ext_curation.create_time
     *
     * @param createTime the value for ext_curation.create_time
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ext_curation.modify_time
     *
     * @return the value of ext_curation.modify_time
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ext_curation.modify_time
     *
     * @param modifyTime the value for ext_curation.modify_time
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ext_curation.status
     *
     * @return the value of ext_curation.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ext_curation.status
     *
     * @param status the value for ext_curation.status
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ext_curation.view_counts
     *
     * @return the value of ext_curation.view_counts
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public Integer getViewCounts() {
        return viewCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ext_curation.view_counts
     *
     * @param viewCounts the value for ext_curation.view_counts
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setViewCounts(Integer viewCounts) {
        this.viewCounts = viewCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ext_curation.user_id
     *
     * @return the value of ext_curation.user_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ext_curation.user_id
     *
     * @param userId the value for ext_curation.user_id
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ext_curation.description
     *
     * @return the value of ext_curation.description
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ext_curation.description
     *
     * @param description the value for ext_curation.description
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public Integer getNiceSize() {
		return niceSize;
	}

	public void setNiceSize(Integer niceSize) {
		this.niceSize = niceSize;
	}
    
    
}