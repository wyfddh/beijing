package com.tj720.mip.dto;

import java.io.Serializable;
import java.util.List;

import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.utils.MyString;

public class CollectionAttributesDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String collectionsCategory="";
	private String id="";
	private String gsNo="";
	private String name="";
	private String formerly="";
	private String foreignName="";
	private String orgaName="";
	private String yearType="";
	private String collectionUnit="";
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFormerly() {
		return formerly;
	}
	public void setFormerly(String formerly) {
		this.formerly = formerly;
	}
	public String getForeignName() {
		return foreignName;
	}
	public void setForeignName(String foreignName) {
		this.foreignName = foreignName;
	}
	public String getCollectionsCategory() {
		return collectionsCategory;
	}
	public void setCollectionsCategory(String collectionsCategory) {
		this.collectionsCategory = collectionsCategory;
	}
	public String getGsNo() {
		return gsNo;
	}
	public void setGsNo(String gsNo) {
		this.gsNo = gsNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrgaName() {
		return orgaName;
	}
	public void setOrgaName(String orgaName) {
		this.orgaName = orgaName;
	}
	public String getYearType() {
		return yearType;
	}
	public void setYearType(String yearType) {
		this.yearType = yearType;
	}
	public String getCollectionUnit() {
		return collectionUnit;
	}
	public void setCollectionUnit(String collectionUnit) {
		this.collectionUnit = collectionUnit;
	}
	public CollectionAttributesDto(String id, String collectionsCategory, String gsNo, String name, String formerly, String foreignName, String yearType, String collectionUnit) {
		super();
		this.id=id;
		this.collectionsCategory = collectionsCategory;
		this.gsNo = gsNo;
		this.name = name;
		this.formerly = formerly;
		this.foreignName = foreignName;
		this.yearType = yearType;
		this.collectionUnit=collectionUnit;
	}
	public CollectionAttributesDto(String collectionsCategory, String gsNo, String name, String formerly, String foreignName, String yearType, String collectionUnit) {
		super();
		this.collectionsCategory = collectionsCategory;
		this.gsNo = gsNo;
		this.name = name;
		this.formerly = formerly;
		this.foreignName = foreignName;
		this.yearType = yearType;
		this.collectionUnit=collectionUnit;
	}
	public CollectionAttributesDto(String id) {
		super();
		this.id=id;
		// TODO Auto-generated constructor stub
	}
	public CollectionAttributesDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSearchYearType() {
		return yearType.replace('.', '|');
	}
	public String getSearchName(){
		return MyString.isEmpty(foreignName)?(MyString.isEmpty(formerly)?name:formerly):foreignName;
	}
}