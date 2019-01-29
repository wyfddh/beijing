package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

@Entity
@Table(name="mip_year_category")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MipYearCategory extends BaseModel implements Serializable{
	
	private String collectionsCategory = "";
	private String yearType = "";
	private String collectionUnit="";
	private String cityId="";
	private int counts;
	private int yearSequence;
	
	//业务字段
	private String name;
	@Transient
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "collections_category")
	public String getCollectionsCategory() {
		return collectionsCategory;
	}
	public void setCollectionsCategory(String collectionsCategory) {
		this.collectionsCategory = collectionsCategory;
	}
	
	@Column(name = "year_type")
	public String getYearType() {
		return yearType;
	}
	public void setYearType(String yearType) {
		this.yearType = yearType;
	}
	
	@Column(name = "collection_unit")
	public String getCollectionUnit() {
		return collectionUnit;
	}
	public void setCollectionUnit(String collectionUnit) {
		this.collectionUnit = collectionUnit;
	}
	
	@Column(name = "city_id")
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
	@Column(name = "counts")
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	
	@Column(name = "year_sequence")
	public int getYearSequence() {
		return yearSequence;
	}
	public void setYearSequence(int yearSequence) {
		this.yearSequence = yearSequence;
	}
	
	public MipYearCategory() {
		super();
	}
	
	public MipYearCategory(String collectionsCategory) {
		this.collectionsCategory = collectionsCategory;
	}
	
	public MipYearCategory(String yearType, int counts) {
		this.yearType = yearType;
		this.counts = counts;
	}
	
	
	
	

}
