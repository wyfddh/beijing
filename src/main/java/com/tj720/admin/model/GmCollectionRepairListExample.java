package com.tj720.admin.model;

import java.util.ArrayList;
import java.util.List;

public class GmCollectionRepairListExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public GmCollectionRepairListExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
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
     * This method corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
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

        public Criteria andReportUploadIdIsNull() {
            addCriterion("report_upload_id is null");
            return (Criteria) this;
        }

        public Criteria andReportUploadIdIsNotNull() {
            addCriterion("report_upload_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportUploadIdEqualTo(String value) {
            addCriterion("report_upload_id =", value, "reportUploadId");
            return (Criteria) this;
        }

        public Criteria andReportUploadIdNotEqualTo(String value) {
            addCriterion("report_upload_id <>", value, "reportUploadId");
            return (Criteria) this;
        }

        public Criteria andReportUploadIdGreaterThan(String value) {
            addCriterion("report_upload_id >", value, "reportUploadId");
            return (Criteria) this;
        }

        public Criteria andReportUploadIdGreaterThanOrEqualTo(String value) {
            addCriterion("report_upload_id >=", value, "reportUploadId");
            return (Criteria) this;
        }

        public Criteria andReportUploadIdLessThan(String value) {
            addCriterion("report_upload_id <", value, "reportUploadId");
            return (Criteria) this;
        }

        public Criteria andReportUploadIdLessThanOrEqualTo(String value) {
            addCriterion("report_upload_id <=", value, "reportUploadId");
            return (Criteria) this;
        }

        public Criteria andReportUploadIdLike(String value) {
            addCriterion("report_upload_id like", value, "reportUploadId");
            return (Criteria) this;
        }

        public Criteria andReportUploadIdNotLike(String value) {
            addCriterion("report_upload_id not like", value, "reportUploadId");
            return (Criteria) this;
        }

        public Criteria andReportUploadIdIn(List<String> values) {
            addCriterion("report_upload_id in", values, "reportUploadId");
            return (Criteria) this;
        }

        public Criteria andReportUploadIdNotIn(List<String> values) {
            addCriterion("report_upload_id not in", values, "reportUploadId");
            return (Criteria) this;
        }

        public Criteria andReportUploadIdBetween(String value1, String value2) {
            addCriterion("report_upload_id between", value1, value2, "reportUploadId");
            return (Criteria) this;
        }

        public Criteria andReportUploadIdNotBetween(String value1, String value2) {
            addCriterion("report_upload_id not between", value1, value2, "reportUploadId");
            return (Criteria) this;
        }

        public Criteria andRepairCollectionNameIsNull() {
            addCriterion("repair_collection_name is null");
            return (Criteria) this;
        }

        public Criteria andRepairCollectionNameIsNotNull() {
            addCriterion("repair_collection_name is not null");
            return (Criteria) this;
        }

        public Criteria andRepairCollectionNameEqualTo(String value) {
            addCriterion("repair_collection_name =", value, "repairCollectionName");
            return (Criteria) this;
        }

        public Criteria andRepairCollectionNameNotEqualTo(String value) {
            addCriterion("repair_collection_name <>", value, "repairCollectionName");
            return (Criteria) this;
        }

        public Criteria andRepairCollectionNameGreaterThan(String value) {
            addCriterion("repair_collection_name >", value, "repairCollectionName");
            return (Criteria) this;
        }

        public Criteria andRepairCollectionNameGreaterThanOrEqualTo(String value) {
            addCriterion("repair_collection_name >=", value, "repairCollectionName");
            return (Criteria) this;
        }

        public Criteria andRepairCollectionNameLessThan(String value) {
            addCriterion("repair_collection_name <", value, "repairCollectionName");
            return (Criteria) this;
        }

        public Criteria andRepairCollectionNameLessThanOrEqualTo(String value) {
            addCriterion("repair_collection_name <=", value, "repairCollectionName");
            return (Criteria) this;
        }

        public Criteria andRepairCollectionNameLike(String value) {
            addCriterion("repair_collection_name like", value, "repairCollectionName");
            return (Criteria) this;
        }

        public Criteria andRepairCollectionNameNotLike(String value) {
            addCriterion("repair_collection_name not like", value, "repairCollectionName");
            return (Criteria) this;
        }

        public Criteria andRepairCollectionNameIn(List<String> values) {
            addCriterion("repair_collection_name in", values, "repairCollectionName");
            return (Criteria) this;
        }

        public Criteria andRepairCollectionNameNotIn(List<String> values) {
            addCriterion("repair_collection_name not in", values, "repairCollectionName");
            return (Criteria) this;
        }

        public Criteria andRepairCollectionNameBetween(String value1, String value2) {
            addCriterion("repair_collection_name between", value1, value2, "repairCollectionName");
            return (Criteria) this;
        }

        public Criteria andRepairCollectionNameNotBetween(String value1, String value2) {
            addCriterion("repair_collection_name not between", value1, value2, "repairCollectionName");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberIsNull() {
            addCriterion("collection_number is null");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberIsNotNull() {
            addCriterion("collection_number is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberEqualTo(String value) {
            addCriterion("collection_number =", value, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberNotEqualTo(String value) {
            addCriterion("collection_number <>", value, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberGreaterThan(String value) {
            addCriterion("collection_number >", value, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberGreaterThanOrEqualTo(String value) {
            addCriterion("collection_number >=", value, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberLessThan(String value) {
            addCriterion("collection_number <", value, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberLessThanOrEqualTo(String value) {
            addCriterion("collection_number <=", value, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberLike(String value) {
            addCriterion("collection_number like", value, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberNotLike(String value) {
            addCriterion("collection_number not like", value, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberIn(List<String> values) {
            addCriterion("collection_number in", values, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberNotIn(List<String> values) {
            addCriterion("collection_number not in", values, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberBetween(String value1, String value2) {
            addCriterion("collection_number between", value1, value2, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberNotBetween(String value1, String value2) {
            addCriterion("collection_number not between", value1, value2, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberIsNull() {
            addCriterion("reply_number is null");
            return (Criteria) this;
        }

        public Criteria andReplyNumberIsNotNull() {
            addCriterion("reply_number is not null");
            return (Criteria) this;
        }

        public Criteria andReplyNumberEqualTo(String value) {
            addCriterion("reply_number =", value, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberNotEqualTo(String value) {
            addCriterion("reply_number <>", value, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberGreaterThan(String value) {
            addCriterion("reply_number >", value, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberGreaterThanOrEqualTo(String value) {
            addCriterion("reply_number >=", value, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberLessThan(String value) {
            addCriterion("reply_number <", value, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberLessThanOrEqualTo(String value) {
            addCriterion("reply_number <=", value, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberLike(String value) {
            addCriterion("reply_number like", value, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberNotLike(String value) {
            addCriterion("reply_number not like", value, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberIn(List<String> values) {
            addCriterion("reply_number in", values, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberNotIn(List<String> values) {
            addCriterion("reply_number not in", values, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberBetween(String value1, String value2) {
            addCriterion("reply_number between", value1, value2, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberNotBetween(String value1, String value2) {
            addCriterion("reply_number not between", value1, value2, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andRepairDesignCompanyIsNull() {
            addCriterion("repair_design_company is null");
            return (Criteria) this;
        }

        public Criteria andRepairDesignCompanyIsNotNull() {
            addCriterion("repair_design_company is not null");
            return (Criteria) this;
        }

        public Criteria andRepairDesignCompanyEqualTo(String value) {
            addCriterion("repair_design_company =", value, "repairDesignCompany");
            return (Criteria) this;
        }

        public Criteria andRepairDesignCompanyNotEqualTo(String value) {
            addCriterion("repair_design_company <>", value, "repairDesignCompany");
            return (Criteria) this;
        }

        public Criteria andRepairDesignCompanyGreaterThan(String value) {
            addCriterion("repair_design_company >", value, "repairDesignCompany");
            return (Criteria) this;
        }

        public Criteria andRepairDesignCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("repair_design_company >=", value, "repairDesignCompany");
            return (Criteria) this;
        }

        public Criteria andRepairDesignCompanyLessThan(String value) {
            addCriterion("repair_design_company <", value, "repairDesignCompany");
            return (Criteria) this;
        }

        public Criteria andRepairDesignCompanyLessThanOrEqualTo(String value) {
            addCriterion("repair_design_company <=", value, "repairDesignCompany");
            return (Criteria) this;
        }

        public Criteria andRepairDesignCompanyLike(String value) {
            addCriterion("repair_design_company like", value, "repairDesignCompany");
            return (Criteria) this;
        }

        public Criteria andRepairDesignCompanyNotLike(String value) {
            addCriterion("repair_design_company not like", value, "repairDesignCompany");
            return (Criteria) this;
        }

        public Criteria andRepairDesignCompanyIn(List<String> values) {
            addCriterion("repair_design_company in", values, "repairDesignCompany");
            return (Criteria) this;
        }

        public Criteria andRepairDesignCompanyNotIn(List<String> values) {
            addCriterion("repair_design_company not in", values, "repairDesignCompany");
            return (Criteria) this;
        }

        public Criteria andRepairDesignCompanyBetween(String value1, String value2) {
            addCriterion("repair_design_company between", value1, value2, "repairDesignCompany");
            return (Criteria) this;
        }

        public Criteria andRepairDesignCompanyNotBetween(String value1, String value2) {
            addCriterion("repair_design_company not between", value1, value2, "repairDesignCompany");
            return (Criteria) this;
        }

        public Criteria andRepairCompanyIsNull() {
            addCriterion("repair_company is null");
            return (Criteria) this;
        }

        public Criteria andRepairCompanyIsNotNull() {
            addCriterion("repair_company is not null");
            return (Criteria) this;
        }

        public Criteria andRepairCompanyEqualTo(String value) {
            addCriterion("repair_company =", value, "repairCompany");
            return (Criteria) this;
        }

        public Criteria andRepairCompanyNotEqualTo(String value) {
            addCriterion("repair_company <>", value, "repairCompany");
            return (Criteria) this;
        }

        public Criteria andRepairCompanyGreaterThan(String value) {
            addCriterion("repair_company >", value, "repairCompany");
            return (Criteria) this;
        }

        public Criteria andRepairCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("repair_company >=", value, "repairCompany");
            return (Criteria) this;
        }

        public Criteria andRepairCompanyLessThan(String value) {
            addCriterion("repair_company <", value, "repairCompany");
            return (Criteria) this;
        }

        public Criteria andRepairCompanyLessThanOrEqualTo(String value) {
            addCriterion("repair_company <=", value, "repairCompany");
            return (Criteria) this;
        }

        public Criteria andRepairCompanyLike(String value) {
            addCriterion("repair_company like", value, "repairCompany");
            return (Criteria) this;
        }

        public Criteria andRepairCompanyNotLike(String value) {
            addCriterion("repair_company not like", value, "repairCompany");
            return (Criteria) this;
        }

        public Criteria andRepairCompanyIn(List<String> values) {
            addCriterion("repair_company in", values, "repairCompany");
            return (Criteria) this;
        }

        public Criteria andRepairCompanyNotIn(List<String> values) {
            addCriterion("repair_company not in", values, "repairCompany");
            return (Criteria) this;
        }

        public Criteria andRepairCompanyBetween(String value1, String value2) {
            addCriterion("repair_company between", value1, value2, "repairCompany");
            return (Criteria) this;
        }

        public Criteria andRepairCompanyNotBetween(String value1, String value2) {
            addCriterion("repair_company not between", value1, value2, "repairCompany");
            return (Criteria) this;
        }

        public Criteria andRepairOutlayIsNull() {
            addCriterion("repair_outlay is null");
            return (Criteria) this;
        }

        public Criteria andRepairOutlayIsNotNull() {
            addCriterion("repair_outlay is not null");
            return (Criteria) this;
        }

        public Criteria andRepairOutlayEqualTo(String value) {
            addCriterion("repair_outlay =", value, "repairOutlay");
            return (Criteria) this;
        }

        public Criteria andRepairOutlayNotEqualTo(String value) {
            addCriterion("repair_outlay <>", value, "repairOutlay");
            return (Criteria) this;
        }

        public Criteria andRepairOutlayGreaterThan(String value) {
            addCriterion("repair_outlay >", value, "repairOutlay");
            return (Criteria) this;
        }

        public Criteria andRepairOutlayGreaterThanOrEqualTo(String value) {
            addCriterion("repair_outlay >=", value, "repairOutlay");
            return (Criteria) this;
        }

        public Criteria andRepairOutlayLessThan(String value) {
            addCriterion("repair_outlay <", value, "repairOutlay");
            return (Criteria) this;
        }

        public Criteria andRepairOutlayLessThanOrEqualTo(String value) {
            addCriterion("repair_outlay <=", value, "repairOutlay");
            return (Criteria) this;
        }

        public Criteria andRepairOutlayLike(String value) {
            addCriterion("repair_outlay like", value, "repairOutlay");
            return (Criteria) this;
        }

        public Criteria andRepairOutlayNotLike(String value) {
            addCriterion("repair_outlay not like", value, "repairOutlay");
            return (Criteria) this;
        }

        public Criteria andRepairOutlayIn(List<String> values) {
            addCriterion("repair_outlay in", values, "repairOutlay");
            return (Criteria) this;
        }

        public Criteria andRepairOutlayNotIn(List<String> values) {
            addCriterion("repair_outlay not in", values, "repairOutlay");
            return (Criteria) this;
        }

        public Criteria andRepairOutlayBetween(String value1, String value2) {
            addCriterion("repair_outlay between", value1, value2, "repairOutlay");
            return (Criteria) this;
        }

        public Criteria andRepairOutlayNotBetween(String value1, String value2) {
            addCriterion("repair_outlay not between", value1, value2, "repairOutlay");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated do_not_delete_during_merge Wed Apr 11 14:08:20 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gm_collection_repair_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
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