package com.tj720.admin.model;

import java.util.ArrayList;
import java.util.List;

public class GmCulturalProductsExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public GmCulturalProductsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
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
     * This method corresponds to the database table gm_cultural_products
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
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
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
     * This class corresponds to the database table gm_cultural_products
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

        public Criteria andNewProdectNameIsNull() {
            addCriterion("new_prodect_name is null");
            return (Criteria) this;
        }

        public Criteria andNewProdectNameIsNotNull() {
            addCriterion("new_prodect_name is not null");
            return (Criteria) this;
        }

        public Criteria andNewProdectNameEqualTo(String value) {
            addCriterion("new_prodect_name =", value, "newProdectName");
            return (Criteria) this;
        }

        public Criteria andNewProdectNameNotEqualTo(String value) {
            addCriterion("new_prodect_name <>", value, "newProdectName");
            return (Criteria) this;
        }

        public Criteria andNewProdectNameGreaterThan(String value) {
            addCriterion("new_prodect_name >", value, "newProdectName");
            return (Criteria) this;
        }

        public Criteria andNewProdectNameGreaterThanOrEqualTo(String value) {
            addCriterion("new_prodect_name >=", value, "newProdectName");
            return (Criteria) this;
        }

        public Criteria andNewProdectNameLessThan(String value) {
            addCriterion("new_prodect_name <", value, "newProdectName");
            return (Criteria) this;
        }

        public Criteria andNewProdectNameLessThanOrEqualTo(String value) {
            addCriterion("new_prodect_name <=", value, "newProdectName");
            return (Criteria) this;
        }

        public Criteria andNewProdectNameLike(String value) {
            addCriterion("new_prodect_name like", value, "newProdectName");
            return (Criteria) this;
        }

        public Criteria andNewProdectNameNotLike(String value) {
            addCriterion("new_prodect_name not like", value, "newProdectName");
            return (Criteria) this;
        }

        public Criteria andNewProdectNameIn(List<String> values) {
            addCriterion("new_prodect_name in", values, "newProdectName");
            return (Criteria) this;
        }

        public Criteria andNewProdectNameNotIn(List<String> values) {
            addCriterion("new_prodect_name not in", values, "newProdectName");
            return (Criteria) this;
        }

        public Criteria andNewProdectNameBetween(String value1, String value2) {
            addCriterion("new_prodect_name between", value1, value2, "newProdectName");
            return (Criteria) this;
        }

        public Criteria andNewProdectNameNotBetween(String value1, String value2) {
            addCriterion("new_prodect_name not between", value1, value2, "newProdectName");
            return (Criteria) this;
        }

        public Criteria andProductCharacteristicIsNull() {
            addCriterion("product_characteristic is null");
            return (Criteria) this;
        }

        public Criteria andProductCharacteristicIsNotNull() {
            addCriterion("product_characteristic is not null");
            return (Criteria) this;
        }

        public Criteria andProductCharacteristicEqualTo(String value) {
            addCriterion("product_characteristic =", value, "productCharacteristic");
            return (Criteria) this;
        }

        public Criteria andProductCharacteristicNotEqualTo(String value) {
            addCriterion("product_characteristic <>", value, "productCharacteristic");
            return (Criteria) this;
        }

        public Criteria andProductCharacteristicGreaterThan(String value) {
            addCriterion("product_characteristic >", value, "productCharacteristic");
            return (Criteria) this;
        }

        public Criteria andProductCharacteristicGreaterThanOrEqualTo(String value) {
            addCriterion("product_characteristic >=", value, "productCharacteristic");
            return (Criteria) this;
        }

        public Criteria andProductCharacteristicLessThan(String value) {
            addCriterion("product_characteristic <", value, "productCharacteristic");
            return (Criteria) this;
        }

        public Criteria andProductCharacteristicLessThanOrEqualTo(String value) {
            addCriterion("product_characteristic <=", value, "productCharacteristic");
            return (Criteria) this;
        }

        public Criteria andProductCharacteristicLike(String value) {
            addCriterion("product_characteristic like", value, "productCharacteristic");
            return (Criteria) this;
        }

        public Criteria andProductCharacteristicNotLike(String value) {
            addCriterion("product_characteristic not like", value, "productCharacteristic");
            return (Criteria) this;
        }

        public Criteria andProductCharacteristicIn(List<String> values) {
            addCriterion("product_characteristic in", values, "productCharacteristic");
            return (Criteria) this;
        }

        public Criteria andProductCharacteristicNotIn(List<String> values) {
            addCriterion("product_characteristic not in", values, "productCharacteristic");
            return (Criteria) this;
        }

        public Criteria andProductCharacteristicBetween(String value1, String value2) {
            addCriterion("product_characteristic between", value1, value2, "productCharacteristic");
            return (Criteria) this;
        }

        public Criteria andProductCharacteristicNotBetween(String value1, String value2) {
            addCriterion("product_characteristic not between", value1, value2, "productCharacteristic");
            return (Criteria) this;
        }

        public Criteria andDevelopmentCostIsNull() {
            addCriterion("development_cost is null");
            return (Criteria) this;
        }

        public Criteria andDevelopmentCostIsNotNull() {
            addCriterion("development_cost is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopmentCostEqualTo(String value) {
            addCriterion("development_cost =", value, "developmentCost");
            return (Criteria) this;
        }

        public Criteria andDevelopmentCostNotEqualTo(String value) {
            addCriterion("development_cost <>", value, "developmentCost");
            return (Criteria) this;
        }

        public Criteria andDevelopmentCostGreaterThan(String value) {
            addCriterion("development_cost >", value, "developmentCost");
            return (Criteria) this;
        }

        public Criteria andDevelopmentCostGreaterThanOrEqualTo(String value) {
            addCriterion("development_cost >=", value, "developmentCost");
            return (Criteria) this;
        }

        public Criteria andDevelopmentCostLessThan(String value) {
            addCriterion("development_cost <", value, "developmentCost");
            return (Criteria) this;
        }

        public Criteria andDevelopmentCostLessThanOrEqualTo(String value) {
            addCriterion("development_cost <=", value, "developmentCost");
            return (Criteria) this;
        }

        public Criteria andDevelopmentCostLike(String value) {
            addCriterion("development_cost like", value, "developmentCost");
            return (Criteria) this;
        }

        public Criteria andDevelopmentCostNotLike(String value) {
            addCriterion("development_cost not like", value, "developmentCost");
            return (Criteria) this;
        }

        public Criteria andDevelopmentCostIn(List<String> values) {
            addCriterion("development_cost in", values, "developmentCost");
            return (Criteria) this;
        }

        public Criteria andDevelopmentCostNotIn(List<String> values) {
            addCriterion("development_cost not in", values, "developmentCost");
            return (Criteria) this;
        }

        public Criteria andDevelopmentCostBetween(String value1, String value2) {
            addCriterion("development_cost between", value1, value2, "developmentCost");
            return (Criteria) this;
        }

        public Criteria andDevelopmentCostNotBetween(String value1, String value2) {
            addCriterion("development_cost not between", value1, value2, "developmentCost");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeIsNull() {
            addCriterion("sales_volume is null");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeIsNotNull() {
            addCriterion("sales_volume is not null");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeEqualTo(String value) {
            addCriterion("sales_volume =", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeNotEqualTo(String value) {
            addCriterion("sales_volume <>", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeGreaterThan(String value) {
            addCriterion("sales_volume >", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeGreaterThanOrEqualTo(String value) {
            addCriterion("sales_volume >=", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeLessThan(String value) {
            addCriterion("sales_volume <", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeLessThanOrEqualTo(String value) {
            addCriterion("sales_volume <=", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeLike(String value) {
            addCriterion("sales_volume like", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeNotLike(String value) {
            addCriterion("sales_volume not like", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeIn(List<String> values) {
            addCriterion("sales_volume in", values, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeNotIn(List<String> values) {
            addCriterion("sales_volume not in", values, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBetween(String value1, String value2) {
            addCriterion("sales_volume between", value1, value2, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeNotBetween(String value1, String value2) {
            addCriterion("sales_volume not between", value1, value2, "salesVolume");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gm_cultural_products
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
     * This class corresponds to the database table gm_cultural_products
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