package com.tj720.admin.model;

import java.util.ArrayList;
import java.util.List;

public class GmAuditExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public GmAuditExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNull() {
            addCriterion("report_id is null");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNotNull() {
            addCriterion("report_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportIdEqualTo(String value) {
            addCriterion("report_id =", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotEqualTo(String value) {
            addCriterion("report_id <>", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThan(String value) {
            addCriterion("report_id >", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThanOrEqualTo(String value) {
            addCriterion("report_id >=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThan(String value) {
            addCriterion("report_id <", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThanOrEqualTo(String value) {
            addCriterion("report_id <=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLike(String value) {
            addCriterion("report_id like", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotLike(String value) {
            addCriterion("report_id not like", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdIn(List<String> values) {
            addCriterion("report_id in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotIn(List<String> values) {
            addCriterion("report_id not in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdBetween(String value1, String value2) {
            addCriterion("report_id between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotBetween(String value1, String value2) {
            addCriterion("report_id not between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andAuditLevelIsNull() {
            addCriterion("audit_level is null");
            return (Criteria) this;
        }

        public Criteria andAuditLevelIsNotNull() {
            addCriterion("audit_level is not null");
            return (Criteria) this;
        }

        public Criteria andAuditLevelEqualTo(Integer value) {
            addCriterion("audit_level =", value, "auditLevel");
            return (Criteria) this;
        }

        public Criteria andAuditLevelNotEqualTo(Integer value) {
            addCriterion("audit_level <>", value, "auditLevel");
            return (Criteria) this;
        }

        public Criteria andAuditLevelGreaterThan(Integer value) {
            addCriterion("audit_level >", value, "auditLevel");
            return (Criteria) this;
        }

        public Criteria andAuditLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_level >=", value, "auditLevel");
            return (Criteria) this;
        }

        public Criteria andAuditLevelLessThan(Integer value) {
            addCriterion("audit_level <", value, "auditLevel");
            return (Criteria) this;
        }

        public Criteria andAuditLevelLessThanOrEqualTo(Integer value) {
            addCriterion("audit_level <=", value, "auditLevel");
            return (Criteria) this;
        }

        public Criteria andAuditLevelIn(List<Integer> values) {
            addCriterion("audit_level in", values, "auditLevel");
            return (Criteria) this;
        }

        public Criteria andAuditLevelNotIn(List<Integer> values) {
            addCriterion("audit_level not in", values, "auditLevel");
            return (Criteria) this;
        }

        public Criteria andAuditLevelBetween(Integer value1, Integer value2) {
            addCriterion("audit_level between", value1, value2, "auditLevel");
            return (Criteria) this;
        }

        public Criteria andAuditLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_level not between", value1, value2, "auditLevel");
            return (Criteria) this;
        }

        public Criteria andCityAuditerIdIsNull() {
            addCriterion("city_auditer_id is null");
            return (Criteria) this;
        }

        public Criteria andCityAuditerIdIsNotNull() {
            addCriterion("city_auditer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityAuditerIdEqualTo(String value) {
            addCriterion("city_auditer_id =", value, "cityAuditerId");
            return (Criteria) this;
        }

        public Criteria andCityAuditerIdNotEqualTo(String value) {
            addCriterion("city_auditer_id <>", value, "cityAuditerId");
            return (Criteria) this;
        }

        public Criteria andCityAuditerIdGreaterThan(String value) {
            addCriterion("city_auditer_id >", value, "cityAuditerId");
            return (Criteria) this;
        }

        public Criteria andCityAuditerIdGreaterThanOrEqualTo(String value) {
            addCriterion("city_auditer_id >=", value, "cityAuditerId");
            return (Criteria) this;
        }

        public Criteria andCityAuditerIdLessThan(String value) {
            addCriterion("city_auditer_id <", value, "cityAuditerId");
            return (Criteria) this;
        }

        public Criteria andCityAuditerIdLessThanOrEqualTo(String value) {
            addCriterion("city_auditer_id <=", value, "cityAuditerId");
            return (Criteria) this;
        }

        public Criteria andCityAuditerIdLike(String value) {
            addCriterion("city_auditer_id like", value, "cityAuditerId");
            return (Criteria) this;
        }

        public Criteria andCityAuditerIdNotLike(String value) {
            addCriterion("city_auditer_id not like", value, "cityAuditerId");
            return (Criteria) this;
        }

        public Criteria andCityAuditerIdIn(List<String> values) {
            addCriterion("city_auditer_id in", values, "cityAuditerId");
            return (Criteria) this;
        }

        public Criteria andCityAuditerIdNotIn(List<String> values) {
            addCriterion("city_auditer_id not in", values, "cityAuditerId");
            return (Criteria) this;
        }

        public Criteria andCityAuditerIdBetween(String value1, String value2) {
            addCriterion("city_auditer_id between", value1, value2, "cityAuditerId");
            return (Criteria) this;
        }

        public Criteria andCityAuditerIdNotBetween(String value1, String value2) {
            addCriterion("city_auditer_id not between", value1, value2, "cityAuditerId");
            return (Criteria) this;
        }

        public Criteria andCityAuditDateIsNull() {
            addCriterion("city_audit_date is null");
            return (Criteria) this;
        }

        public Criteria andCityAuditDateIsNotNull() {
            addCriterion("city_audit_date is not null");
            return (Criteria) this;
        }

        public Criteria andCityAuditDateEqualTo(String value) {
            addCriterion("city_audit_date =", value, "cityAuditDate");
            return (Criteria) this;
        }

        public Criteria andCityAuditDateNotEqualTo(String value) {
            addCriterion("city_audit_date <>", value, "cityAuditDate");
            return (Criteria) this;
        }

        public Criteria andCityAuditDateGreaterThan(String value) {
            addCriterion("city_audit_date >", value, "cityAuditDate");
            return (Criteria) this;
        }

        public Criteria andCityAuditDateGreaterThanOrEqualTo(String value) {
            addCriterion("city_audit_date >=", value, "cityAuditDate");
            return (Criteria) this;
        }

        public Criteria andCityAuditDateLessThan(String value) {
            addCriterion("city_audit_date <", value, "cityAuditDate");
            return (Criteria) this;
        }

        public Criteria andCityAuditDateLessThanOrEqualTo(String value) {
            addCriterion("city_audit_date <=", value, "cityAuditDate");
            return (Criteria) this;
        }

        public Criteria andCityAuditDateLike(String value) {
            addCriterion("city_audit_date like", value, "cityAuditDate");
            return (Criteria) this;
        }

        public Criteria andCityAuditDateNotLike(String value) {
            addCriterion("city_audit_date not like", value, "cityAuditDate");
            return (Criteria) this;
        }

        public Criteria andCityAuditDateIn(List<String> values) {
            addCriterion("city_audit_date in", values, "cityAuditDate");
            return (Criteria) this;
        }

        public Criteria andCityAuditDateNotIn(List<String> values) {
            addCriterion("city_audit_date not in", values, "cityAuditDate");
            return (Criteria) this;
        }

        public Criteria andCityAuditDateBetween(String value1, String value2) {
            addCriterion("city_audit_date between", value1, value2, "cityAuditDate");
            return (Criteria) this;
        }

        public Criteria andCityAuditDateNotBetween(String value1, String value2) {
            addCriterion("city_audit_date not between", value1, value2, "cityAuditDate");
            return (Criteria) this;
        }

        public Criteria andCityAuditResultIsNull() {
            addCriterion("city_audit_result is null");
            return (Criteria) this;
        }

        public Criteria andCityAuditResultIsNotNull() {
            addCriterion("city_audit_result is not null");
            return (Criteria) this;
        }

        public Criteria andCityAuditResultEqualTo(Integer value) {
            addCriterion("city_audit_result =", value, "cityAuditResult");
            return (Criteria) this;
        }

        public Criteria andCityAuditResultNotEqualTo(Integer value) {
            addCriterion("city_audit_result <>", value, "cityAuditResult");
            return (Criteria) this;
        }

        public Criteria andCityAuditResultGreaterThan(Integer value) {
            addCriterion("city_audit_result >", value, "cityAuditResult");
            return (Criteria) this;
        }

        public Criteria andCityAuditResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_audit_result >=", value, "cityAuditResult");
            return (Criteria) this;
        }

        public Criteria andCityAuditResultLessThan(Integer value) {
            addCriterion("city_audit_result <", value, "cityAuditResult");
            return (Criteria) this;
        }

        public Criteria andCityAuditResultLessThanOrEqualTo(Integer value) {
            addCriterion("city_audit_result <=", value, "cityAuditResult");
            return (Criteria) this;
        }

        public Criteria andCityAuditResultIn(List<Integer> values) {
            addCriterion("city_audit_result in", values, "cityAuditResult");
            return (Criteria) this;
        }

        public Criteria andCityAuditResultNotIn(List<Integer> values) {
            addCriterion("city_audit_result not in", values, "cityAuditResult");
            return (Criteria) this;
        }

        public Criteria andCityAuditResultBetween(Integer value1, Integer value2) {
            addCriterion("city_audit_result between", value1, value2, "cityAuditResult");
            return (Criteria) this;
        }

        public Criteria andCityAuditResultNotBetween(Integer value1, Integer value2) {
            addCriterion("city_audit_result not between", value1, value2, "cityAuditResult");
            return (Criteria) this;
        }

        public Criteria andCityReviewResultIsNull() {
            addCriterion("city_review_result is null");
            return (Criteria) this;
        }

        public Criteria andCityReviewResultIsNotNull() {
            addCriterion("city_review_result is not null");
            return (Criteria) this;
        }

        public Criteria andCityReviewResultEqualTo(String value) {
            addCriterion("city_review_result =", value, "cityReviewResult");
            return (Criteria) this;
        }

        public Criteria andCityReviewResultNotEqualTo(String value) {
            addCriterion("city_review_result <>", value, "cityReviewResult");
            return (Criteria) this;
        }

        public Criteria andCityReviewResultGreaterThan(String value) {
            addCriterion("city_review_result >", value, "cityReviewResult");
            return (Criteria) this;
        }

        public Criteria andCityReviewResultGreaterThanOrEqualTo(String value) {
            addCriterion("city_review_result >=", value, "cityReviewResult");
            return (Criteria) this;
        }

        public Criteria andCityReviewResultLessThan(String value) {
            addCriterion("city_review_result <", value, "cityReviewResult");
            return (Criteria) this;
        }

        public Criteria andCityReviewResultLessThanOrEqualTo(String value) {
            addCriterion("city_review_result <=", value, "cityReviewResult");
            return (Criteria) this;
        }

        public Criteria andCityReviewResultLike(String value) {
            addCriterion("city_review_result like", value, "cityReviewResult");
            return (Criteria) this;
        }

        public Criteria andCityReviewResultNotLike(String value) {
            addCriterion("city_review_result not like", value, "cityReviewResult");
            return (Criteria) this;
        }

        public Criteria andCityReviewResultIn(List<String> values) {
            addCriterion("city_review_result in", values, "cityReviewResult");
            return (Criteria) this;
        }

        public Criteria andCityReviewResultNotIn(List<String> values) {
            addCriterion("city_review_result not in", values, "cityReviewResult");
            return (Criteria) this;
        }

        public Criteria andCityReviewResultBetween(String value1, String value2) {
            addCriterion("city_review_result between", value1, value2, "cityReviewResult");
            return (Criteria) this;
        }

        public Criteria andCityReviewResultNotBetween(String value1, String value2) {
            addCriterion("city_review_result not between", value1, value2, "cityReviewResult");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditerIdIsNull() {
            addCriterion("province_auditer_id is null");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditerIdIsNotNull() {
            addCriterion("province_auditer_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditerIdEqualTo(String value) {
            addCriterion("province_auditer_id =", value, "provinceAuditerId");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditerIdNotEqualTo(String value) {
            addCriterion("province_auditer_id <>", value, "provinceAuditerId");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditerIdGreaterThan(String value) {
            addCriterion("province_auditer_id >", value, "provinceAuditerId");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditerIdGreaterThanOrEqualTo(String value) {
            addCriterion("province_auditer_id >=", value, "provinceAuditerId");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditerIdLessThan(String value) {
            addCriterion("province_auditer_id <", value, "provinceAuditerId");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditerIdLessThanOrEqualTo(String value) {
            addCriterion("province_auditer_id <=", value, "provinceAuditerId");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditerIdLike(String value) {
            addCriterion("province_auditer_id like", value, "provinceAuditerId");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditerIdNotLike(String value) {
            addCriterion("province_auditer_id not like", value, "provinceAuditerId");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditerIdIn(List<String> values) {
            addCriterion("province_auditer_id in", values, "provinceAuditerId");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditerIdNotIn(List<String> values) {
            addCriterion("province_auditer_id not in", values, "provinceAuditerId");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditerIdBetween(String value1, String value2) {
            addCriterion("province_auditer_id between", value1, value2, "provinceAuditerId");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditerIdNotBetween(String value1, String value2) {
            addCriterion("province_auditer_id not between", value1, value2, "provinceAuditerId");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditDateIsNull() {
            addCriterion("province_audit_date is null");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditDateIsNotNull() {
            addCriterion("province_audit_date is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditDateEqualTo(String value) {
            addCriterion("province_audit_date =", value, "provinceAuditDate");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditDateNotEqualTo(String value) {
            addCriterion("province_audit_date <>", value, "provinceAuditDate");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditDateGreaterThan(String value) {
            addCriterion("province_audit_date >", value, "provinceAuditDate");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditDateGreaterThanOrEqualTo(String value) {
            addCriterion("province_audit_date >=", value, "provinceAuditDate");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditDateLessThan(String value) {
            addCriterion("province_audit_date <", value, "provinceAuditDate");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditDateLessThanOrEqualTo(String value) {
            addCriterion("province_audit_date <=", value, "provinceAuditDate");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditDateLike(String value) {
            addCriterion("province_audit_date like", value, "provinceAuditDate");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditDateNotLike(String value) {
            addCriterion("province_audit_date not like", value, "provinceAuditDate");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditDateIn(List<String> values) {
            addCriterion("province_audit_date in", values, "provinceAuditDate");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditDateNotIn(List<String> values) {
            addCriterion("province_audit_date not in", values, "provinceAuditDate");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditDateBetween(String value1, String value2) {
            addCriterion("province_audit_date between", value1, value2, "provinceAuditDate");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditDateNotBetween(String value1, String value2) {
            addCriterion("province_audit_date not between", value1, value2, "provinceAuditDate");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditResultIsNull() {
            addCriterion("province_audit_result is null");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditResultIsNotNull() {
            addCriterion("province_audit_result is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditResultEqualTo(Integer value) {
            addCriterion("province_audit_result =", value, "provinceAuditResult");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditResultNotEqualTo(Integer value) {
            addCriterion("province_audit_result <>", value, "provinceAuditResult");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditResultGreaterThan(Integer value) {
            addCriterion("province_audit_result >", value, "provinceAuditResult");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("province_audit_result >=", value, "provinceAuditResult");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditResultLessThan(Integer value) {
            addCriterion("province_audit_result <", value, "provinceAuditResult");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditResultLessThanOrEqualTo(Integer value) {
            addCriterion("province_audit_result <=", value, "provinceAuditResult");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditResultIn(List<Integer> values) {
            addCriterion("province_audit_result in", values, "provinceAuditResult");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditResultNotIn(List<Integer> values) {
            addCriterion("province_audit_result not in", values, "provinceAuditResult");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditResultBetween(Integer value1, Integer value2) {
            addCriterion("province_audit_result between", value1, value2, "provinceAuditResult");
            return (Criteria) this;
        }

        public Criteria andProvinceAuditResultNotBetween(Integer value1, Integer value2) {
            addCriterion("province_audit_result not between", value1, value2, "provinceAuditResult");
            return (Criteria) this;
        }

        public Criteria andProvinceReviewResultIsNull() {
            addCriterion("province_review_result is null");
            return (Criteria) this;
        }

        public Criteria andProvinceReviewResultIsNotNull() {
            addCriterion("province_review_result is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceReviewResultEqualTo(String value) {
            addCriterion("province_review_result =", value, "provinceReviewResult");
            return (Criteria) this;
        }

        public Criteria andProvinceReviewResultNotEqualTo(String value) {
            addCriterion("province_review_result <>", value, "provinceReviewResult");
            return (Criteria) this;
        }

        public Criteria andProvinceReviewResultGreaterThan(String value) {
            addCriterion("province_review_result >", value, "provinceReviewResult");
            return (Criteria) this;
        }

        public Criteria andProvinceReviewResultGreaterThanOrEqualTo(String value) {
            addCriterion("province_review_result >=", value, "provinceReviewResult");
            return (Criteria) this;
        }

        public Criteria andProvinceReviewResultLessThan(String value) {
            addCriterion("province_review_result <", value, "provinceReviewResult");
            return (Criteria) this;
        }

        public Criteria andProvinceReviewResultLessThanOrEqualTo(String value) {
            addCriterion("province_review_result <=", value, "provinceReviewResult");
            return (Criteria) this;
        }

        public Criteria andProvinceReviewResultLike(String value) {
            addCriterion("province_review_result like", value, "provinceReviewResult");
            return (Criteria) this;
        }

        public Criteria andProvinceReviewResultNotLike(String value) {
            addCriterion("province_review_result not like", value, "provinceReviewResult");
            return (Criteria) this;
        }

        public Criteria andProvinceReviewResultIn(List<String> values) {
            addCriterion("province_review_result in", values, "provinceReviewResult");
            return (Criteria) this;
        }

        public Criteria andProvinceReviewResultNotIn(List<String> values) {
            addCriterion("province_review_result not in", values, "provinceReviewResult");
            return (Criteria) this;
        }

        public Criteria andProvinceReviewResultBetween(String value1, String value2) {
            addCriterion("province_review_result between", value1, value2, "provinceReviewResult");
            return (Criteria) this;
        }

        public Criteria andProvinceReviewResultNotBetween(String value1, String value2) {
            addCriterion("province_review_result not between", value1, value2, "provinceReviewResult");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gm_audit
     *
     * @mbggenerated do_not_delete_during_merge Tue Apr 03 15:22:24 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gm_audit
     *
     * @mbggenerated Tue Apr 03 15:22:24 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}