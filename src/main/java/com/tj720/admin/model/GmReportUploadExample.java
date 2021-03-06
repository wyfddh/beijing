package com.tj720.admin.model;

import java.util.ArrayList;
import java.util.List;

public class GmReportUploadExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public GmReportUploadExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
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
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
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

        public Criteria andUoloadUrlIsNull() {
            addCriterion("uoload_url is null");
            return (Criteria) this;
        }

        public Criteria andUoloadUrlIsNotNull() {
            addCriterion("uoload_url is not null");
            return (Criteria) this;
        }

        public Criteria andUoloadUrlEqualTo(String value) {
            addCriterion("uoload_url =", value, "uoloadUrl");
            return (Criteria) this;
        }

        public Criteria andUoloadUrlNotEqualTo(String value) {
            addCriterion("uoload_url <>", value, "uoloadUrl");
            return (Criteria) this;
        }

        public Criteria andUoloadUrlGreaterThan(String value) {
            addCriterion("uoload_url >", value, "uoloadUrl");
            return (Criteria) this;
        }

        public Criteria andUoloadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("uoload_url >=", value, "uoloadUrl");
            return (Criteria) this;
        }

        public Criteria andUoloadUrlLessThan(String value) {
            addCriterion("uoload_url <", value, "uoloadUrl");
            return (Criteria) this;
        }

        public Criteria andUoloadUrlLessThanOrEqualTo(String value) {
            addCriterion("uoload_url <=", value, "uoloadUrl");
            return (Criteria) this;
        }

        public Criteria andUoloadUrlLike(String value) {
            addCriterion("uoload_url like", value, "uoloadUrl");
            return (Criteria) this;
        }

        public Criteria andUoloadUrlNotLike(String value) {
            addCriterion("uoload_url not like", value, "uoloadUrl");
            return (Criteria) this;
        }

        public Criteria andUoloadUrlIn(List<String> values) {
            addCriterion("uoload_url in", values, "uoloadUrl");
            return (Criteria) this;
        }

        public Criteria andUoloadUrlNotIn(List<String> values) {
            addCriterion("uoload_url not in", values, "uoloadUrl");
            return (Criteria) this;
        }

        public Criteria andUoloadUrlBetween(String value1, String value2) {
            addCriterion("uoload_url between", value1, value2, "uoloadUrl");
            return (Criteria) this;
        }

        public Criteria andUoloadUrlNotBetween(String value1, String value2) {
            addCriterion("uoload_url not between", value1, value2, "uoloadUrl");
            return (Criteria) this;
        }

        public Criteria andUoloadNameIsNull() {
            addCriterion("uoload_name is null");
            return (Criteria) this;
        }

        public Criteria andUoloadNameIsNotNull() {
            addCriterion("uoload_name is not null");
            return (Criteria) this;
        }

        public Criteria andUoloadNameEqualTo(String value) {
            addCriterion("uoload_name =", value, "uoloadName");
            return (Criteria) this;
        }

        public Criteria andUoloadNameNotEqualTo(String value) {
            addCriterion("uoload_name <>", value, "uoloadName");
            return (Criteria) this;
        }

        public Criteria andUoloadNameGreaterThan(String value) {
            addCriterion("uoload_name >", value, "uoloadName");
            return (Criteria) this;
        }

        public Criteria andUoloadNameGreaterThanOrEqualTo(String value) {
            addCriterion("uoload_name >=", value, "uoloadName");
            return (Criteria) this;
        }

        public Criteria andUoloadNameLessThan(String value) {
            addCriterion("uoload_name <", value, "uoloadName");
            return (Criteria) this;
        }

        public Criteria andUoloadNameLessThanOrEqualTo(String value) {
            addCriterion("uoload_name <=", value, "uoloadName");
            return (Criteria) this;
        }

        public Criteria andUoloadNameLike(String value) {
            addCriterion("uoload_name like", value, "uoloadName");
            return (Criteria) this;
        }

        public Criteria andUoloadNameNotLike(String value) {
            addCriterion("uoload_name not like", value, "uoloadName");
            return (Criteria) this;
        }

        public Criteria andUoloadNameIn(List<String> values) {
            addCriterion("uoload_name in", values, "uoloadName");
            return (Criteria) this;
        }

        public Criteria andUoloadNameNotIn(List<String> values) {
            addCriterion("uoload_name not in", values, "uoloadName");
            return (Criteria) this;
        }

        public Criteria andUoloadNameBetween(String value1, String value2) {
            addCriterion("uoload_name between", value1, value2, "uoloadName");
            return (Criteria) this;
        }

        public Criteria andUoloadNameNotBetween(String value1, String value2) {
            addCriterion("uoload_name not between", value1, value2, "uoloadName");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andUoloadStatusIsNull() {
            addCriterion("uoload_status is null");
            return (Criteria) this;
        }

        public Criteria andUoloadStatusIsNotNull() {
            addCriterion("uoload_status is not null");
            return (Criteria) this;
        }

        public Criteria andUoloadStatusEqualTo(String value) {
            addCriterion("uoload_status =", value, "uoloadStatus");
            return (Criteria) this;
        }

        public Criteria andUoloadStatusNotEqualTo(String value) {
            addCriterion("uoload_status <>", value, "uoloadStatus");
            return (Criteria) this;
        }

        public Criteria andUoloadStatusGreaterThan(String value) {
            addCriterion("uoload_status >", value, "uoloadStatus");
            return (Criteria) this;
        }

        public Criteria andUoloadStatusGreaterThanOrEqualTo(String value) {
            addCriterion("uoload_status >=", value, "uoloadStatus");
            return (Criteria) this;
        }

        public Criteria andUoloadStatusLessThan(String value) {
            addCriterion("uoload_status <", value, "uoloadStatus");
            return (Criteria) this;
        }

        public Criteria andUoloadStatusLessThanOrEqualTo(String value) {
            addCriterion("uoload_status <=", value, "uoloadStatus");
            return (Criteria) this;
        }

        public Criteria andUoloadStatusLike(String value) {
            addCriterion("uoload_status like", value, "uoloadStatus");
            return (Criteria) this;
        }

        public Criteria andUoloadStatusNotLike(String value) {
            addCriterion("uoload_status not like", value, "uoloadStatus");
            return (Criteria) this;
        }

        public Criteria andUoloadStatusIn(List<String> values) {
            addCriterion("uoload_status in", values, "uoloadStatus");
            return (Criteria) this;
        }

        public Criteria andUoloadStatusNotIn(List<String> values) {
            addCriterion("uoload_status not in", values, "uoloadStatus");
            return (Criteria) this;
        }

        public Criteria andUoloadStatusBetween(String value1, String value2) {
            addCriterion("uoload_status between", value1, value2, "uoloadStatus");
            return (Criteria) this;
        }

        public Criteria andUoloadStatusNotBetween(String value1, String value2) {
            addCriterion("uoload_status not between", value1, value2, "uoloadStatus");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gm_report_upload
     *
     * @mbggenerated do_not_delete_during_merge Wed Mar 28 12:15:25 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
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