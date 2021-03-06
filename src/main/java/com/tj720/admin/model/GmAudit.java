package com.tj720.admin.model;

public class GmAudit {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_audit.id
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_audit.report_id
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    private String reportId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_audit.audit_level
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    private Integer auditLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_audit.city_auditer_id
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    private String cityAuditerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_audit.city_audit_date
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    private String cityAuditDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_audit.city_audit_result
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    private Integer cityAuditResult;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_audit.city_review_result
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    private String cityReviewResult;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_audit.province_auditer_id
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    private String provinceAuditerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_audit.province_audit_date
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    private String provinceAuditDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_audit.province_audit_result
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    private Integer provinceAuditResult;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gm_audit.province_review_result
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    private String provinceReviewResult;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_audit.id
     *
     * @return the value of gm_audit.id
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    
    private String updateDate;  //更新时间
    
    
    
    public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_audit.id
     *
     * @param id the value for gm_audit.id
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_audit.report_id
     *
     * @return the value of gm_audit.report_id
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public String getReportId() {
        return reportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_audit.report_id
     *
     * @param reportId the value for gm_audit.report_id
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_audit.audit_level
     *
     * @return the value of gm_audit.audit_level
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public Integer getAuditLevel() {
        return auditLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_audit.audit_level
     *
     * @param auditLevel the value for gm_audit.audit_level
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void setAuditLevel(Integer auditLevel) {
        this.auditLevel = auditLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_audit.city_auditer_id
     *
     * @return the value of gm_audit.city_auditer_id
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public String getCityAuditerId() {
        return cityAuditerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_audit.city_auditer_id
     *
     * @param cityAuditerId the value for gm_audit.city_auditer_id
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void setCityAuditerId(String cityAuditerId) {
        this.cityAuditerId = cityAuditerId == null ? null : cityAuditerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_audit.city_audit_date
     *
     * @return the value of gm_audit.city_audit_date
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public String getCityAuditDate() {
        return cityAuditDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_audit.city_audit_date
     *
     * @param cityAuditDate the value for gm_audit.city_audit_date
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void setCityAuditDate(String cityAuditDate) {
        this.cityAuditDate = cityAuditDate == null ? null : cityAuditDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_audit.city_audit_result
     *
     * @return the value of gm_audit.city_audit_result
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public Integer getCityAuditResult() {
        return cityAuditResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_audit.city_audit_result
     *
     * @param cityAuditResult the value for gm_audit.city_audit_result
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void setCityAuditResult(Integer cityAuditResult) {
        this.cityAuditResult = cityAuditResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_audit.city_review_result
     *
     * @return the value of gm_audit.city_review_result
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public String getCityReviewResult() {
        return cityReviewResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_audit.city_review_result
     *
     * @param cityReviewResult the value for gm_audit.city_review_result
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void setCityReviewResult(String cityReviewResult) {
        this.cityReviewResult = cityReviewResult == null ? null : cityReviewResult.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_audit.province_auditer_id
     *
     * @return the value of gm_audit.province_auditer_id
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public String getProvinceAuditerId() {
        return provinceAuditerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_audit.province_auditer_id
     *
     * @param provinceAuditerId the value for gm_audit.province_auditer_id
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void setProvinceAuditerId(String provinceAuditerId) {
        this.provinceAuditerId = provinceAuditerId == null ? null : provinceAuditerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_audit.province_audit_date
     *
     * @return the value of gm_audit.province_audit_date
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public String getProvinceAuditDate() {
        return provinceAuditDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_audit.province_audit_date
     *
     * @param provinceAuditDate the value for gm_audit.province_audit_date
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void setProvinceAuditDate(String provinceAuditDate) {
        this.provinceAuditDate = provinceAuditDate == null ? null : provinceAuditDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_audit.province_audit_result
     *
     * @return the value of gm_audit.province_audit_result
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public Integer getProvinceAuditResult() {
        return provinceAuditResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_audit.province_audit_result
     *
     * @param provinceAuditResult the value for gm_audit.province_audit_result
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void setProvinceAuditResult(Integer provinceAuditResult) {
        this.provinceAuditResult = provinceAuditResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gm_audit.province_review_result
     *
     * @return the value of gm_audit.province_review_result
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public String getProvinceReviewResult() {
        return provinceReviewResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gm_audit.province_review_result
     *
     * @param provinceReviewResult the value for gm_audit.province_review_result
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void setProvinceReviewResult(String provinceReviewResult) {
        this.provinceReviewResult = provinceReviewResult == null ? null : provinceReviewResult.trim();
    }
}