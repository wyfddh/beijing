package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;
@Entity
@Table(name = "mip_statistics")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MipStatistics extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String collectionUnit = "";//组织机构ID
	private String yearType = "";//年代
	private String collectionsCategory = "";//类别
	private String collectionLevel = "";//级别
	private String gsSource = "";//来源
	private String gsEntryWarehouseTimeFrame = "";//入藏时间
	private String endResidueLevel = "";//完残程度
	private String gsStorageState = "";//保存状态
	private long numberOall = 0;//藏品数
	private long numberYall = 0;//一普藏品数
	
	
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
	@Column(name = "collections_category")
	public String getCollectionsCategory() {
		return collectionsCategory;
	}
	public void setCollectionsCategory(String collectionsCategory) {
		this.collectionsCategory = collectionsCategory;
	}
	@Column(name = "collection_level")
	public String getCollectionLevel() {
		return collectionLevel;
	}
	public void setCollectionLevel(String collectionLevel) {
		this.collectionLevel = collectionLevel;
	}
	@Column(name = "gs_source")
	public String getGsSource() {
		return gsSource;
	}
	public void setGsSource(String gsSource) {
		this.gsSource = gsSource;
	}
	@Column(name = "gs_entry_warehouse_frame")
	public String getGsEntryWarehouseTimeFrame() {
		return gsEntryWarehouseTimeFrame;
	}
	public void setGsEntryWarehouseTimeFrame(String gsEntryWarehouseTimeFrame) {
		this.gsEntryWarehouseTimeFrame = gsEntryWarehouseTimeFrame;
	}
	@Column(name = "end_residue_level")
	public String getEndResidueLevel() {
		return endResidueLevel;
	}
	public void setEndResidueLevel(String endResidueLevel) {
		this.endResidueLevel = endResidueLevel;
	}
	@Column(name = "gs_storage_state")
	public String getGsStorageState() {
		return gsStorageState;
	}
	public void setGsStorageState(String gsStorageState) {
		this.gsStorageState = gsStorageState;
	}
	@Column(name = "number_oall")
	public long getNumberOall() {
		return numberOall;
	}
	public void setNumberOall(long numberOall) {
		this.numberOall = numberOall;
	}
	@Column(name = "number_yall")
	public long getNumberYall() {
		return numberYall;
	}
	public void setNumberYall(long numberYall) {
		this.numberYall = numberYall;
	}
	

}
