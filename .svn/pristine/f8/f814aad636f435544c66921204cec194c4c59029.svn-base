package com.tj720.admin.model;

import java.io.Serializable;
import java.util.Map;

public class ESModel implements Serializable {

	private static final long serialVersionUID = -2176331898295262935L;
	// String index(数据库), String type(表), String id(document一行数据id)

	private String index = "jx"; // 索引(数据库名)
	private String type; // 类型type(表)
	private String id; // id(document一行数据id)

	/* 对象 */
	private String jsonString;
	
	
	/* 条件 */
	/** and并且*/
	private Map<String,String> andObject;
	/** not排除*/
	private Map<String,String> notObject;
	/** or或*/
	private Map<String,String> orObject;
	/** is null or not null */
	private Map<String,String> isNullObject;
	/** 模糊搜索*/
	private Map<String,String> likeObject;
	/** 模糊搜索（可容错，效率低）*/
	private Map<String,String> likeFaultObject;
	/** 范围查找（名字，【开始，结束】）*/
	private Map<String,String[]> rangeObject;
	/** in查询*/
	private Map<String,String[]> inObject;
	/** 排序（key:排序字段 value:[asc,desc]）*/
	private Map<String,String> sortObject;
	/** 分页*/
	//private Page page;

	/** 索引(数据库名) */
	public String getIndex() {
		return index;
	}

	/** 索引(数据库名) */
	public void setIndex(String index) {
		this.index = index;
	}

	/** 类型type(表名) */
	public String getType() {
		return type;
	}

	/** 类型type(表名) */
	public void setType(String type) {
		this.type = type;
	}

	/** id(document一行数据id) */
	public String getId() {
		return id;
	}

	/** id(document一行数据id) */
	public void setId(String id) {
		this.id = id;
	}

	/** 数据json字符串 */
	public String getJsonString() {
		return jsonString;
	}

	/** 数据json字符串 */
	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	// 条件
	/** and并且*/
	public Map<String, String> getAndObject() {
		return andObject;
	}
	/** and并且*/
	public void setAndObject(Map<String, String> andObject) {
		this.andObject = andObject;
	}
	/** not排除*/
	public Map<String, String> getNotObject() {
		return notObject;
	}
	/** not排除*/
	public void setNotObject(Map<String, String> notObject) {
		this.notObject = notObject;
	}
	/** or或*/
	public Map<String, String> getOrObject() {
		return orObject;
	}
	/** or或*/
	public void setOrObject(Map<String, String> orObject) {
		this.orObject = orObject;
	}
	/** 模糊搜索*/
	public Map<String, String> getLikeObject() {
		return likeObject;
	}
	/** 模糊搜索*/
	public void setLikeObject(Map<String, String> likeObject) {
		this.likeObject = likeObject;
	}
	/** 模糊搜索（可容错，效率低）*/
	public Map<String, String> getLikeFaultObject() {
		return likeFaultObject;
	}
	/** 模糊搜索（可容错，效率低）*/
	public void setLikeFaultObject(Map<String, String> likeFaultObject) {
		this.likeFaultObject = likeFaultObject;
	}
	/** 范围查找（名字，【开始，结束】）*/
	public Map<String, String[]> getRangeObject() {
		return rangeObject;
	}
	/** 范围查找（名字，【开始，结束】）*/
	public void setRangeObject(Map<String, String[]> rangeObject) {
		this.rangeObject = rangeObject;
	}
	/** 排序（key:排序字段 value:[asc,desc]）*/
	public Map<String, String> getSortObject() {
		return sortObject;
	}
	/** 排序（key:排序字段 value:[asc,desc]）*/
	public void setSortObject(Map<String, String> sortObject) {
		this.sortObject = sortObject;
	}
	/** 范围查找（名字，【str1，str2...】）*/
	public Map<String, String[]> getInObject() {
		return inObject;
	}
	/** 范围查找（名字，【str1，str2...】）*/
	public void setInObject(Map<String, String[]> inObject) {
		this.inObject = inObject;
	}
	/**
	 * key:isNull 或 notNull
	 * value:字段名
	 * @return
	 */
	public Map<String, String> getIsNullObject() {
		return isNullObject;
	}
	/**
	 * key:isNull 或 notNull
	 * value:字段名
	 * @return
	 */
	public void setIsNullObject(Map<String, String> isNullObject) {
		this.isNullObject = isNullObject;
	}
	
//	/** 分页*/
//	public Page getPage() {
//		return page;
//	}
//	/** 分页*/
//	public void setPage(Page page) {
//		this.page = page;
//	}

	
	
}

