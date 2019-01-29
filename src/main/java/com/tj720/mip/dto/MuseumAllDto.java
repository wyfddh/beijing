/** 
 * <pre>项目名称:mip 
 * 文件名称:MuseumAllDto.java 
 * 包名:com.tj720.mip.dto 
 * 创建日期:2017年3月19日下午3:16:24 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.dto;

import javax.persistence.criteria.CriteriaBuilder.In;

/** 
 * <pre>项目名称：mip    
 * 类名称：MuseumAllDto    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月19日 下午3:16:24    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月19日 下午3:16:24    
 * 修改备注：       
 * @version </pre>    
 */
public class MuseumAllDto {
	private Integer orgId;//博物馆id
	private String museumName;//博物馆名称
	private String categoryId = "0";//类别表的外键
	private Integer level;//级别
	private String cityName;//地区
	private String museumInfoId;//博物馆信息表的id
	private Integer cityId;//地区
	private String categoryName;
	
	
	
	
	
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getMuseumInfoId() {
		return museumInfoId;
	}
	public void setMuseumInfoId(String museumInfoId) {
		this.museumInfoId = museumInfoId;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getMuseumName() {
		return museumName;
	}
	public void setMuseumName(String museumName) {
		this.museumName = museumName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	   
	/**    
	 * <pre>创建一个新的实例 MuseumAllDto.    
	 *    
	 * @param orgId
	 * @param museumName
	 * @param categoryId
	 * @param level
	 * @param cityName</pre>    
	 */
	public MuseumAllDto(Integer orgId, String museumName, String categoryId, Integer level, String cityName) {
		super();
		this.orgId = orgId;
		this.museumName = museumName;
		this.categoryId = categoryId;
		this.level = level;
		this.cityName = cityName;
	}
	public MuseumAllDto(String museumName,Integer orgId,Integer cityId,  String categoryId,String museumInfoId, Integer level) {
		super();
		this.museumName = museumName;
		this.orgId = orgId;
		this.cityId = cityId;
		this.categoryId = categoryId;
		this.museumInfoId = museumInfoId;
		this.level = level;
	}
	   
	/**    
	 * <pre>创建一个新的实例 MuseumAllDto.    
	 *    </pre>    
	 */
	public MuseumAllDto() {
		super();
	}
	
}
