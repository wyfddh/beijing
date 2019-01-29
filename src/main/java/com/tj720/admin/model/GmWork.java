package com.tj720.admin.model;

public class GmWork {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_work.id
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_work.work_name
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    private String workName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_work.museum_id
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    private String museumId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_work.years
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    private String years;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_work.work_status
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    private Integer workStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_work.file_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    private String fileUpload;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_work.creat_date
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    private String creatDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_work.update_date
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    private String updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_work.updater_id
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    private String updaterId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_work.id
     *
     * @return the value of gm_work.id
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    
    private String name; // 博物馆名
    
    private byte level; // 级别
    
    private String area;
    
    private String unit;
    
    
    
    
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_work.id
     *
     * @param id the value for gm_work.id
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_work.work_name
     *
     * @return the value of gm_work.work_name
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public String getWorkName() {
        return workName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_work.work_name
     *
     * @param workName the value for gm_work.work_name
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public void setWorkName(String workName) {
        this.workName = workName == null ? null : workName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_work.museum_id
     *
     * @return the value of gm_work.museum_id
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public String getMuseumId() {
        return museumId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_work.museum_id
     *
     * @param museumId the value for gm_work.museum_id
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public void setMuseumId(String museumId) {
        this.museumId = museumId == null ? null : museumId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_work.years
     *
     * @return the value of gm_work.years
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public String getYears() {
        return years;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_work.years
     *
     * @param years the value for gm_work.years
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public void setYears(String years) {
        this.years = years == null ? null : years.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_work.work_status
     *
     * @return the value of gm_work.work_status
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public Integer getWorkStatus() {
        return workStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_work.work_status
     *
     * @param workStatus the value for gm_work.work_status
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public void setWorkStatus(Integer workStatus) {
        this.workStatus = workStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_work.file_upload
     *
     * @return the value of gm_work.file_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public String getFileUpload() {
        return fileUpload;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_work.file_upload
     *
     * @param fileUpload the value for gm_work.file_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public void setFileUpload(String fileUpload) {
        this.fileUpload = fileUpload == null ? null : fileUpload.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_work.creat_date
     *
     * @return the value of gm_work.creat_date
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public String getCreatDate() {
        return creatDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_work.creat_date
     *
     * @param creatDate the value for gm_work.creat_date
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public void setCreatDate(String creatDate) {
        this.creatDate = creatDate == null ? null : creatDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_work.update_date
     *
     * @return the value of gm_work.update_date
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_work.update_date
     *
     * @param updateDate the value for gm_work.update_date
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_work.updater_id
     *
     * @return the value of gm_work.updater_id
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public String getUpdaterId() {
        return updaterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_work.updater_id
     *
     * @param updaterId the value for gm_work.updater_id
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId == null ? null : updaterId.trim();
    }
}