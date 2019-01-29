package com.tj720.admin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DcBorrowExample {
	private int startPage;
    private int size;
    
    public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String fields;

    public DcBorrowExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
    }

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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCollectionUnitIsNull() {
            addCriterion("collection_unit is null");
            return (Criteria) this;
        }

        public Criteria andCollectionUnitIsNotNull() {
            addCriterion("collection_unit is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionUnitEqualTo(String value) {
            addCriterion("collection_unit =", value, "collectionUnit");
            return (Criteria) this;
        }

        public Criteria andCollectionUnitNotEqualTo(String value) {
            addCriterion("collection_unit <>", value, "collectionUnit");
            return (Criteria) this;
        }

        public Criteria andCollectionUnitGreaterThan(String value) {
            addCriterion("collection_unit >", value, "collectionUnit");
            return (Criteria) this;
        }

        public Criteria andCollectionUnitGreaterThanOrEqualTo(String value) {
            addCriterion("collection_unit >=", value, "collectionUnit");
            return (Criteria) this;
        }

        public Criteria andCollectionUnitLessThan(String value) {
            addCriterion("collection_unit <", value, "collectionUnit");
            return (Criteria) this;
        }

        public Criteria andCollectionUnitLessThanOrEqualTo(String value) {
            addCriterion("collection_unit <=", value, "collectionUnit");
            return (Criteria) this;
        }

        public Criteria andCollectionUnitLike(String value) {
            addCriterion("collection_unit like", value, "collectionUnit");
            return (Criteria) this;
        }

        public Criteria andCollectionUnitNotLike(String value) {
            addCriterion("collection_unit not like", value, "collectionUnit");
            return (Criteria) this;
        }

        public Criteria andCollectionUnitIn(List<String> values) {
            addCriterion("collection_unit in", values, "collectionUnit");
            return (Criteria) this;
        }

        public Criteria andCollectionUnitNotIn(List<String> values) {
            addCriterion("collection_unit not in", values, "collectionUnit");
            return (Criteria) this;
        }

        public Criteria andCollectionUnitBetween(String value1, String value2) {
            addCriterion("collection_unit between", value1, value2, "collectionUnit");
            return (Criteria) this;
        }

        public Criteria andCollectionUnitNotBetween(String value1, String value2) {
            addCriterion("collection_unit not between", value1, value2, "collectionUnit");
            return (Criteria) this;
        }

        public Criteria andCollectionNameIsNull() {
            addCriterion("collection_name is null");
            return (Criteria) this;
        }

        public Criteria andCollectionNameIsNotNull() {
            addCriterion("collection_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionNameEqualTo(String value) {
            addCriterion("collection_name =", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameNotEqualTo(String value) {
            addCriterion("collection_name <>", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameGreaterThan(String value) {
            addCriterion("collection_name >", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameGreaterThanOrEqualTo(String value) {
            addCriterion("collection_name >=", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameLessThan(String value) {
            addCriterion("collection_name <", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameLessThanOrEqualTo(String value) {
            addCriterion("collection_name <=", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameLike(String value) {
            addCriterion("collection_name like", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameNotLike(String value) {
            addCriterion("collection_name not like", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameIn(List<String> values) {
            addCriterion("collection_name in", values, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameNotIn(List<String> values) {
            addCriterion("collection_name not in", values, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameBetween(String value1, String value2) {
            addCriterion("collection_name between", value1, value2, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameNotBetween(String value1, String value2) {
            addCriterion("collection_name not between", value1, value2, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIsNull() {
            addCriterion("collection_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIsNotNull() {
            addCriterion("collection_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionIdEqualTo(String value) {
            addCriterion("collection_id =", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotEqualTo(String value) {
            addCriterion("collection_id <>", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdGreaterThan(String value) {
            addCriterion("collection_id >", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdGreaterThanOrEqualTo(String value) {
            addCriterion("collection_id >=", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdLessThan(String value) {
            addCriterion("collection_id <", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdLessThanOrEqualTo(String value) {
            addCriterion("collection_id <=", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdLike(String value) {
            addCriterion("collection_id like", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotLike(String value) {
            addCriterion("collection_id not like", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIn(List<String> values) {
            addCriterion("collection_id in", values, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotIn(List<String> values) {
            addCriterion("collection_id not in", values, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdBetween(String value1, String value2) {
            addCriterion("collection_id between", value1, value2, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotBetween(String value1, String value2) {
            addCriterion("collection_id not between", value1, value2, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeIsNull() {
            addCriterion("collection_type is null");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeIsNotNull() {
            addCriterion("collection_type is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeEqualTo(String value) {
            addCriterion("collection_type =", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeNotEqualTo(String value) {
            addCriterion("collection_type <>", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeGreaterThan(String value) {
            addCriterion("collection_type >", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("collection_type >=", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeLessThan(String value) {
            addCriterion("collection_type <", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeLessThanOrEqualTo(String value) {
            addCriterion("collection_type <=", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeLike(String value) {
            addCriterion("collection_type like", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeNotLike(String value) {
            addCriterion("collection_type not like", value, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeIn(List<String> values) {
            addCriterion("collection_type in", values, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeNotIn(List<String> values) {
            addCriterion("collection_type not in", values, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeBetween(String value1, String value2) {
            addCriterion("collection_type between", value1, value2, "collectionType");
            return (Criteria) this;
        }

        public Criteria andCollectionTypeNotBetween(String value1, String value2) {
            addCriterion("collection_type not between", value1, value2, "collectionType");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andWenwuTypeIsNull() {
            addCriterion("wenwu_type is null");
            return (Criteria) this;
        }

        public Criteria andWenwuTypeIsNotNull() {
            addCriterion("wenwu_type is not null");
            return (Criteria) this;
        }

        public Criteria andWenwuTypeEqualTo(String value) {
            addCriterion("wenwu_type =", value, "wenwuType");
            return (Criteria) this;
        }

        public Criteria andWenwuTypeNotEqualTo(String value) {
            addCriterion("wenwu_type <>", value, "wenwuType");
            return (Criteria) this;
        }

        public Criteria andWenwuTypeGreaterThan(String value) {
            addCriterion("wenwu_type >", value, "wenwuType");
            return (Criteria) this;
        }

        public Criteria andWenwuTypeGreaterThanOrEqualTo(String value) {
            addCriterion("wenwu_type >=", value, "wenwuType");
            return (Criteria) this;
        }

        public Criteria andWenwuTypeLessThan(String value) {
            addCriterion("wenwu_type <", value, "wenwuType");
            return (Criteria) this;
        }

        public Criteria andWenwuTypeLessThanOrEqualTo(String value) {
            addCriterion("wenwu_type <=", value, "wenwuType");
            return (Criteria) this;
        }

        public Criteria andWenwuTypeLike(String value) {
            addCriterion("wenwu_type like", value, "wenwuType");
            return (Criteria) this;
        }

        public Criteria andWenwuTypeNotLike(String value) {
            addCriterion("wenwu_type not like", value, "wenwuType");
            return (Criteria) this;
        }

        public Criteria andWenwuTypeIn(List<String> values) {
            addCriterion("wenwu_type in", values, "wenwuType");
            return (Criteria) this;
        }

        public Criteria andWenwuTypeNotIn(List<String> values) {
            addCriterion("wenwu_type not in", values, "wenwuType");
            return (Criteria) this;
        }

        public Criteria andWenwuTypeBetween(String value1, String value2) {
            addCriterion("wenwu_type between", value1, value2, "wenwuType");
            return (Criteria) this;
        }

        public Criteria andWenwuTypeNotBetween(String value1, String value2) {
            addCriterion("wenwu_type not between", value1, value2, "wenwuType");
            return (Criteria) this;
        }

        public Criteria andWenwuLeveIsNull() {
            addCriterion("wenwu_leve is null");
            return (Criteria) this;
        }

        public Criteria andWenwuLeveIsNotNull() {
            addCriterion("wenwu_leve is not null");
            return (Criteria) this;
        }

        public Criteria andWenwuLeveEqualTo(String value) {
            addCriterion("wenwu_leve =", value, "wenwuLeve");
            return (Criteria) this;
        }

        public Criteria andWenwuLeveNotEqualTo(String value) {
            addCriterion("wenwu_leve <>", value, "wenwuLeve");
            return (Criteria) this;
        }

        public Criteria andWenwuLeveGreaterThan(String value) {
            addCriterion("wenwu_leve >", value, "wenwuLeve");
            return (Criteria) this;
        }

        public Criteria andWenwuLeveGreaterThanOrEqualTo(String value) {
            addCriterion("wenwu_leve >=", value, "wenwuLeve");
            return (Criteria) this;
        }

        public Criteria andWenwuLeveLessThan(String value) {
            addCriterion("wenwu_leve <", value, "wenwuLeve");
            return (Criteria) this;
        }

        public Criteria andWenwuLeveLessThanOrEqualTo(String value) {
            addCriterion("wenwu_leve <=", value, "wenwuLeve");
            return (Criteria) this;
        }

        public Criteria andWenwuLeveLike(String value) {
            addCriterion("wenwu_leve like", value, "wenwuLeve");
            return (Criteria) this;
        }

        public Criteria andWenwuLeveNotLike(String value) {
            addCriterion("wenwu_leve not like", value, "wenwuLeve");
            return (Criteria) this;
        }

        public Criteria andWenwuLeveIn(List<String> values) {
            addCriterion("wenwu_leve in", values, "wenwuLeve");
            return (Criteria) this;
        }

        public Criteria andWenwuLeveNotIn(List<String> values) {
            addCriterion("wenwu_leve not in", values, "wenwuLeve");
            return (Criteria) this;
        }

        public Criteria andWenwuLeveBetween(String value1, String value2) {
            addCriterion("wenwu_leve between", value1, value2, "wenwuLeve");
            return (Criteria) this;
        }

        public Criteria andWenwuLeveNotBetween(String value1, String value2) {
            addCriterion("wenwu_leve not between", value1, value2, "wenwuLeve");
            return (Criteria) this;
        }

        public Criteria andZhidiTypeIsNull() {
            addCriterion("zhidi_type is null");
            return (Criteria) this;
        }

        public Criteria andZhidiTypeIsNotNull() {
            addCriterion("zhidi_type is not null");
            return (Criteria) this;
        }

        public Criteria andZhidiTypeEqualTo(String value) {
            addCriterion("zhidi_type =", value, "zhidiType");
            return (Criteria) this;
        }

        public Criteria andZhidiTypeNotEqualTo(String value) {
            addCriterion("zhidi_type <>", value, "zhidiType");
            return (Criteria) this;
        }

        public Criteria andZhidiTypeGreaterThan(String value) {
            addCriterion("zhidi_type >", value, "zhidiType");
            return (Criteria) this;
        }

        public Criteria andZhidiTypeGreaterThanOrEqualTo(String value) {
            addCriterion("zhidi_type >=", value, "zhidiType");
            return (Criteria) this;
        }

        public Criteria andZhidiTypeLessThan(String value) {
            addCriterion("zhidi_type <", value, "zhidiType");
            return (Criteria) this;
        }

        public Criteria andZhidiTypeLessThanOrEqualTo(String value) {
            addCriterion("zhidi_type <=", value, "zhidiType");
            return (Criteria) this;
        }

        public Criteria andZhidiTypeLike(String value) {
            addCriterion("zhidi_type like", value, "zhidiType");
            return (Criteria) this;
        }

        public Criteria andZhidiTypeNotLike(String value) {
            addCriterion("zhidi_type not like", value, "zhidiType");
            return (Criteria) this;
        }

        public Criteria andZhidiTypeIn(List<String> values) {
            addCriterion("zhidi_type in", values, "zhidiType");
            return (Criteria) this;
        }

        public Criteria andZhidiTypeNotIn(List<String> values) {
            addCriterion("zhidi_type not in", values, "zhidiType");
            return (Criteria) this;
        }

        public Criteria andZhidiTypeBetween(String value1, String value2) {
            addCriterion("zhidi_type between", value1, value2, "zhidiType");
            return (Criteria) this;
        }

        public Criteria andZhidiTypeNotBetween(String value1, String value2) {
            addCriterion("zhidi_type not between", value1, value2, "zhidiType");
            return (Criteria) this;
        }

        public Criteria andPictureIdsIsNull() {
            addCriterion("picture_ids is null");
            return (Criteria) this;
        }

        public Criteria andPictureIdsIsNotNull() {
            addCriterion("picture_ids is not null");
            return (Criteria) this;
        }

        public Criteria andPictureIdsEqualTo(String value) {
            addCriterion("picture_ids =", value, "pictureIds");
            return (Criteria) this;
        }

        public Criteria andPictureIdsNotEqualTo(String value) {
            addCriterion("picture_ids <>", value, "pictureIds");
            return (Criteria) this;
        }

        public Criteria andPictureIdsGreaterThan(String value) {
            addCriterion("picture_ids >", value, "pictureIds");
            return (Criteria) this;
        }

        public Criteria andPictureIdsGreaterThanOrEqualTo(String value) {
            addCriterion("picture_ids >=", value, "pictureIds");
            return (Criteria) this;
        }

        public Criteria andPictureIdsLessThan(String value) {
            addCriterion("picture_ids <", value, "pictureIds");
            return (Criteria) this;
        }

        public Criteria andPictureIdsLessThanOrEqualTo(String value) {
            addCriterion("picture_ids <=", value, "pictureIds");
            return (Criteria) this;
        }

        public Criteria andPictureIdsLike(String value) {
            addCriterion("picture_ids like", value, "pictureIds");
            return (Criteria) this;
        }

        public Criteria andPictureIdsNotLike(String value) {
            addCriterion("picture_ids not like", value, "pictureIds");
            return (Criteria) this;
        }

        public Criteria andPictureIdsIn(List<String> values) {
            addCriterion("picture_ids in", values, "pictureIds");
            return (Criteria) this;
        }

        public Criteria andPictureIdsNotIn(List<String> values) {
            addCriterion("picture_ids not in", values, "pictureIds");
            return (Criteria) this;
        }

        public Criteria andPictureIdsBetween(String value1, String value2) {
            addCriterion("picture_ids between", value1, value2, "pictureIds");
            return (Criteria) this;
        }

        public Criteria andPictureIdsNotBetween(String value1, String value2) {
            addCriterion("picture_ids not between", value1, value2, "pictureIds");
            return (Criteria) this;
        }

        public Criteria andGsNoIsNull() {
            addCriterion("gs_No is null");
            return (Criteria) this;
        }

        public Criteria andGsNoIsNotNull() {
            addCriterion("gs_No is not null");
            return (Criteria) this;
        }

        public Criteria andGsNoEqualTo(String value) {
            addCriterion("gs_No =", value, "gsNo");
            return (Criteria) this;
        }

        public Criteria andGsNoNotEqualTo(String value) {
            addCriterion("gs_No <>", value, "gsNo");
            return (Criteria) this;
        }

        public Criteria andGsNoGreaterThan(String value) {
            addCriterion("gs_No >", value, "gsNo");
            return (Criteria) this;
        }

        public Criteria andGsNoGreaterThanOrEqualTo(String value) {
            addCriterion("gs_No >=", value, "gsNo");
            return (Criteria) this;
        }

        public Criteria andGsNoLessThan(String value) {
            addCriterion("gs_No <", value, "gsNo");
            return (Criteria) this;
        }

        public Criteria andGsNoLessThanOrEqualTo(String value) {
            addCriterion("gs_No <=", value, "gsNo");
            return (Criteria) this;
        }

        public Criteria andGsNoLike(String value) {
            addCriterion("gs_No like", value, "gsNo");
            return (Criteria) this;
        }

        public Criteria andGsNoNotLike(String value) {
            addCriterion("gs_No not like", value, "gsNo");
            return (Criteria) this;
        }

        public Criteria andGsNoIn(List<String> values) {
            addCriterion("gs_No in", values, "gsNo");
            return (Criteria) this;
        }

        public Criteria andGsNoNotIn(List<String> values) {
            addCriterion("gs_No not in", values, "gsNo");
            return (Criteria) this;
        }

        public Criteria andGsNoBetween(String value1, String value2) {
            addCriterion("gs_No between", value1, value2, "gsNo");
            return (Criteria) this;
        }

        public Criteria andGsNoNotBetween(String value1, String value2) {
            addCriterion("gs_No not between", value1, value2, "gsNo");
            return (Criteria) this;
        }

        public Criteria andFormerlyIsNull() {
            addCriterion("formerly is null");
            return (Criteria) this;
        }

        public Criteria andFormerlyIsNotNull() {
            addCriterion("formerly is not null");
            return (Criteria) this;
        }

        public Criteria andFormerlyEqualTo(String value) {
            addCriterion("formerly =", value, "formerly");
            return (Criteria) this;
        }

        public Criteria andFormerlyNotEqualTo(String value) {
            addCriterion("formerly <>", value, "formerly");
            return (Criteria) this;
        }

        public Criteria andFormerlyGreaterThan(String value) {
            addCriterion("formerly >", value, "formerly");
            return (Criteria) this;
        }

        public Criteria andFormerlyGreaterThanOrEqualTo(String value) {
            addCriterion("formerly >=", value, "formerly");
            return (Criteria) this;
        }

        public Criteria andFormerlyLessThan(String value) {
            addCriterion("formerly <", value, "formerly");
            return (Criteria) this;
        }

        public Criteria andFormerlyLessThanOrEqualTo(String value) {
            addCriterion("formerly <=", value, "formerly");
            return (Criteria) this;
        }

        public Criteria andFormerlyLike(String value) {
            addCriterion("formerly like", value, "formerly");
            return (Criteria) this;
        }

        public Criteria andFormerlyNotLike(String value) {
            addCriterion("formerly not like", value, "formerly");
            return (Criteria) this;
        }

        public Criteria andFormerlyIn(List<String> values) {
            addCriterion("formerly in", values, "formerly");
            return (Criteria) this;
        }

        public Criteria andFormerlyNotIn(List<String> values) {
            addCriterion("formerly not in", values, "formerly");
            return (Criteria) this;
        }

        public Criteria andFormerlyBetween(String value1, String value2) {
            addCriterion("formerly between", value1, value2, "formerly");
            return (Criteria) this;
        }

        public Criteria andFormerlyNotBetween(String value1, String value2) {
            addCriterion("formerly not between", value1, value2, "formerly");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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