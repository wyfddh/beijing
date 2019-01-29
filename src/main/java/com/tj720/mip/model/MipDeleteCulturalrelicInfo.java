package com.tj720.mip.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

/**
 * MipOpenCulturalrelicInfo generated by hbm2java
 */
@Entity
@Table(name = "mip_delete_culturalrelic_info")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MipDeleteCulturalrelicInfo extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String collectionUnit="";
	private String dwid="";
	private String gsNo="";
	private String fpic="";//藏品缩略图地址
	private int fpicWidth;
	private int fpicHeight;
	private String gsCollectionsNoType="";
	private String gsCollectionsNo="";
	private String collectionType="";
	private String name="";//藏品名称
	private String indexName="";
	private String formerly="";
	private String foreignName="";
	private String yearType="";
	private String gsSpecificYear="";
	private String collectionsCategory="";
	private String gsTextureCategory="";
	private String gsTextureSubcategories="";
	private String gsTexture="";
	private String actualQuantityUnit="";
	private float actualQuantity;
	private float gsLength;
	private float gsWidth;
	private float gsHeight;
	private String size="";
	private String massRange="";
	private String mass="";
	private String massUnit="";
	private String collectionLevel="";
	private String gsSource="";
	private String collectionPlace="";
	private String endResidueLevel="";
	private String endResidualCondition="";
	private String gsStorageType="";
	private String gsStorageState="";
	private String gsEntryWarehouseTimeFrame="";
	private String gsEntryWarehouseYear="";
	private String gsEntryMeseumTime="";
	private String gsAuthor="";
	private String gsVersion="";
	private String gsKeepOnFile="";
	private String creator="";
	private String assessor="";
	private String submitTime;
	private String fCreateDept="";
	private byte isHighQuality;//是否为精品
	private byte isOpen=0;
	private String FKey="";
	private String description="";
	private String remark="";
	private String pictureIds="";
	private String threeDimensionalCollection="";
	private String ringBeatData="";
	private String fVideo="";
	private String fAudio="";
	private int checkState;
	private int clickCounts;
	private int selectCounts;
	private int collectedCounts;

	//业务字段
	private String picUrl;
	
	
	@Transient
	public String getPicUrl() {
		return picUrl;
	}


	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}


	//new MipOpenCulturalrelicInfo(id, createTime, status, sequence, fpic, name, isCollected)
	public MipDeleteCulturalrelicInfo(String id, String createTime, byte status, int sequence, String fpic, String name) {
		super();
		this.id = id;
		this.createTime = createTime;
		this.status = status;
		this.sequence = sequence;
		this.fpic = fpic;
		this.name = name;
	}
	
	public MipDeleteCulturalrelicInfo(String id, String pictureIds){
		this.id = id;
		this.pictureIds = pictureIds;
	}
	

	@Column(name = "collection_unit")
	public String getCollectionUnit() {
		return this.collectionUnit;
	}

	public void setCollectionUnit(String collectionUnit) {
		this.collectionUnit = collectionUnit;
	}
	
	@Column(name = "dwid")
	public String getDwid() {
		return this.dwid;
	}
	public void setDwid(String dwid) {
		this.dwid = dwid;
	}

	@Column(name = "gs_No")
	public String getGsNo() {
		return this.gsNo;
	}

	public void setGsNo(String gsNo) {
		this.gsNo = gsNo;
	}

	@Column(name = "fPic")
	public String getFpic() {
		return this.fpic;
	}
	
	public void setFpic(String fpic) {
		this.fpic = fpic;
	}
	
	@Column(name = "fPic_width")
	public int getFpicWidth() {
		return fpicWidth;
	}
	public void setFpicWidth(int fpicWidth) {
		this.fpicWidth = fpicWidth;
	}
	
	@Column(name = "fPic_height")
	public int getFpicHeight() {
		return fpicHeight;
	}
	public void setFpicHeight(int fpicHeight) {
		this.fpicHeight = fpicHeight;
	}
	
	@Column(name = "gs_collectionsNo_type")
	public String getGsCollectionsNoType() {
		return this.gsCollectionsNoType;
	}

	public void setGsCollectionsNoType(String gsCollectionsNoType) {
		this.gsCollectionsNoType = gsCollectionsNoType;
	}

	@Column(name = "gs_collectionsNo")
	public String getGsCollectionsNo() {
		return this.gsCollectionsNo;
	}

	public void setGsCollectionsNo(String gsCollectionsNo) {
		this.gsCollectionsNo = gsCollectionsNo;
	}

	@Column(name = "collection_type")
	public String getCollectionType() {
		return this.collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "index_name")
	public String getIndexName() {
		return indexName;
	}


	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}


	@Column(name = "formerly")
	public String getFormerly() {
		return this.formerly;
	}

	public void setFormerly(String formerly) {
		this.formerly = formerly;
	}

	@Column(name = "foreign_name")
	public String getForeignName() {
		return this.foreignName;
	}

	public void setForeignName(String foreignName) {
		this.foreignName = foreignName;
	}

	@Column(name = "year_type")
	public String getYearType() {
		return this.yearType;
	}

	public void setYearType(String yearType) {
		this.yearType = yearType;
	}

	@Column(name = "gs_specific_year")
	public String getGsSpecificYear() {
		return this.gsSpecificYear;
	}

	public void setGsSpecificYear(String gsSpecificYear) {
		this.gsSpecificYear = gsSpecificYear;
	}

	@Column(name = "collections_category")
	public String getCollectionsCategory() {
		return this.collectionsCategory;
	}

	public void setCollectionsCategory(String collectionsCategory) {
		this.collectionsCategory = collectionsCategory;
	}

	@Column(name = "gs_texture_category")
	public String getGsTextureCategory() {
		return this.gsTextureCategory;
	}

	public void setGsTextureCategory(String gsTextureCategory) {
		this.gsTextureCategory = gsTextureCategory;
	}

	@Column(name = "gs_texture_subcategories")
	public String getGsTextureSubcategories() {
		return this.gsTextureSubcategories;
	}

	public void setGsTextureSubcategories(String gsTextureSubcategories) {
		this.gsTextureSubcategories = gsTextureSubcategories;
	}

	@Column(name = "gs_texture")
	public String getGsTexture() {
		return this.gsTexture;
	}

	public void setGsTexture(String gsTexture) {
		this.gsTexture = gsTexture;
	}

	@Column(name = "actual_quantity_unit")
	public String getActualQuantityUnit() {
		return this.actualQuantityUnit;
	}

	public void setActualQuantityUnit(String actualQuantityUnit) {
		this.actualQuantityUnit = actualQuantityUnit;
	}

	@Column(name = "actual_quantity")
	public float getActualQuantity() {
		return this.actualQuantity;
	}

	public void setActualQuantity(float actualQuantity) {
		this.actualQuantity = actualQuantity;
	}

	@Column(name = "gs_length")
	public float getGsLength() {
		return this.gsLength;
	}

	public void setGsLength(float gsLength) {
		this.gsLength = gsLength;
	}

	@Column(name = "gs_width")
	public float getGsWidth() {
		return this.gsWidth;
	}

	public void setGsWidth(float gsWidth) {
		this.gsWidth = gsWidth;
	}

	@Column(name = "gs_height")
	public float getGsHeight() {
		return this.gsHeight;
	}

	public void setGsHeight(float gsHeight) {
		this.gsHeight = gsHeight;
	}

	@Column(name = "size")
	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Column(name = "mass_range")
	public String getMassRange() {
		return this.massRange;
	}

	public void setMassRange(String massRange) {
		this.massRange = massRange;
	}

	@Column(name = "mass")
	public String getMass() {
		return this.mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	@Column(name = "mass_unit")
	public String getMassUnit() {
		return this.massUnit;
	}

	public void setMassUnit(String massUnit) {
		this.massUnit = massUnit;
	}

	@Column(name = "collection_level")
	public String getCollectionLevel() {
		return this.collectionLevel;
	}

	public void setCollectionLevel(String collectionLevel) {
		this.collectionLevel = collectionLevel;
	}

	@Column(name = "gs_source")
	public String getGsSource() {
		return this.gsSource;
	}

	public void setGsSource(String gsSource) {
		this.gsSource = gsSource;
	}

	@Column(name = "collection_place")
	public String getCollectionPlace() {
		return this.collectionPlace;
	}

	public void setCollectionPlace(String collectionPlace) {
		this.collectionPlace = collectionPlace;
	}

	@Column(name = "end_residue_level")
	public String getEndResidueLevel() {
		return this.endResidueLevel;
	}

	public void setEndResidueLevel(String endResidueLevel) {
		this.endResidueLevel = endResidueLevel;
	}

	@Column(name = "end_residual_condition")
	public String getEndResidualCondition() {
		return this.endResidualCondition;
	}

	public void setEndResidualCondition(String endResidualCondition) {
		this.endResidualCondition = endResidualCondition;
	}
	
	@Column(name = "gs_storage_type")
	public String getGsStorageType() {
		return gsStorageType;
	}
	public void setGsStorageType(String gsStorageType) {
		this.gsStorageType = gsStorageType;
	}
	
	@Column(name = "gs_storage_state")
	public String getGsStorageState() {
		return this.gsStorageState;
	}

	public void setGsStorageState(String gsStorageState) {
		this.gsStorageState = gsStorageState;
	}

	@Column(name = "gs_entry_warehouse_time_frame")
	public String getGsEntryWarehouseTimeFrame() {
		return this.gsEntryWarehouseTimeFrame;
	}

	public void setGsEntryWarehouseTimeFrame(String gsEntryWarehouseTimeFrame) {
		this.gsEntryWarehouseTimeFrame = gsEntryWarehouseTimeFrame;
	}

	@Column(name = "gs_entry_warehouse_year")
	public String getGsEntryWarehouseYear() {
		return this.gsEntryWarehouseYear;
	}

	public void setGsEntryWarehouseYear(String gsEntryWarehouseYear) {
		this.gsEntryWarehouseYear = gsEntryWarehouseYear;
	}

	@Column(name = "gs_entry_warehouse_time")
	public String getGsEntryMeseumTime() {
		return this.gsEntryMeseumTime;
	}

	public void setGsEntryMeseumTime(String gsEntryMeseumTime) {
		this.gsEntryMeseumTime = gsEntryMeseumTime;
	}

	@Column(name = "gs_author")
	public String getGsAuthor() {
		return this.gsAuthor;
	}

	public void setGsAuthor(String gsAuthor) {
		this.gsAuthor = gsAuthor;
	}

	@Column(name = "gs_version")
	public String getGsVersion() {
		return this.gsVersion;
	}

	public void setGsVersion(String gsVersion) {
		this.gsVersion = gsVersion;
	}

	@Column(name = "gs_keep_on_file")
	public String getGsKeepOnFile() {
		return this.gsKeepOnFile;
	}

	public void setGsKeepOnFile(String gsKeepOnFile) {
		this.gsKeepOnFile = gsKeepOnFile;
	}

	@Column(name = "creator")
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	@Column(name = "assessor")
	public String getAssessor() {
		return assessor;
	}
	public void setAssessor(String assessor) {
		this.assessor = assessor;
	}

	@Column(name = "submitTime")
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	@Column(name = "f_create_dept")
	public String getfCreateDept() {
		return fCreateDept;
	}
	public void setfCreateDept(String fCreateDept) {
		this.fCreateDept = fCreateDept;
	}

	@Column(name = "is_high_quality")
	public byte getIsHighQuality() {
		return isHighQuality;
	}
	public void setIsHighQuality(byte isHighQuality) {
		this.isHighQuality = isHighQuality;
	}

	@Column(name = "is_open")
	public byte getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(byte isOpen) {
		this.isOpen = isOpen;
	}

	@Column(name = "f_key")
	public String getFKey() {
		return this.FKey;
	}
	public void setFKey(String FKey) {
		this.FKey = FKey;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "picture_ids")
	public String getPictureIds() {
		return pictureIds;
	}
	public void setPictureIds(String pictureIds) {
		this.pictureIds = pictureIds;
	}

	@Column(name = "three_dimensional_collection")
	public String getThreeDimensionalCollection() {
		return this.threeDimensionalCollection;
	}
	public void setThreeDimensionalCollection(String threeDimensionalCollection) {
		this.threeDimensionalCollection = threeDimensionalCollection;
	}

	@Column(name = "ring_beat_data")
	public String getRingBeatData() {
		return this.ringBeatData;
	}

	public void setRingBeatData(String ringBeatData) {
		this.ringBeatData = ringBeatData;
	}

	@Column(name = "f_video")
	public String getfVideo() {
		return fVideo;
	}
	public void setfVideo(String fVideo) {
		this.fVideo = fVideo;
	}

	@Column(name = "f_audio")
	public String getfAudio() {
		return fAudio;
	}
	public void setfAudio(String fAudio) {
		this.fAudio = fAudio;
	}

	@Column(name = "check_state")
	public int getCheckState() {
		return this.checkState;
	}

	public void setCheckState(int checkState) {
		this.checkState = checkState;
	}
	
	@Column(name = "click_counts")
	public int getClickCounts() {
		return clickCounts;
	}
	
	public void setClickCounts(int clickCounts) {
		this.clickCounts = clickCounts;
	}
	
	@Column(name = "select_counts")
	public int getSelectCounts() {
		return selectCounts;
	}
	public void setSelectCounts(int selectCounts) {
		this.selectCounts = selectCounts;
	}
	
	@Column(name = "collected_counts")
	public int getCollectedCounts() {
		return collectedCounts;
	}
	public void setCollectedCounts(int collectedCounts) {
		this.collectedCounts = collectedCounts;
	}
	   
	/**    
	 * <pre>创建一个新的实例 MipOpenCulturalrelicInfo.    
	 *    
	 * @param collectionUnit
	 * @param collectionUnitCity
	 * @param dwid
	 * @param gsNo
	 * @param fpic
	 * @param fpicWidth
	 * @param fpicHeight
	 * @param gsCollectionsNoType
	 * @param gsCollectionsNo
	 * @param collectionType
	 * @param name
	 * @param formerly
	 * @param foreignName
	 * @param yearType
	 * @param gsSpecificYear
	 * @param collectionsCategory
	 * @param gsTextureCategory
	 * @param gsTextureSubcategories
	 * @param gsTexture
	 * @param actualQuantityUnit
	 * @param actualQuantity
	 * @param gsLength
	 * @param gsWidth
	 * @param gsHeight
	 * @param size
	 * @param massRange
	 * @param mass
	 * @param massUnit
	 * @param collectionLevel
	 * @param gsSource
	 * @param collectionPlace
	 * @param endResidueLevel
	 * @param endResidualCondition
	 * @param gsStorageType
	 * @param gsStorageState
	 * @param gsEntryWarehouseTimeFrame
	 * @param gsEntryWarehouseYear
	 * @param gsEntryMeseumTime
	 * @param gsAuthor
	 * @param gsVersion
	 * @param gsKeepOnFile
	 * @param creator
	 * @param assessor
	 * @param submitTime
	 * @param fCreateDept
	 * @param isHighQuality
	 * @param isOpen
	 * @param fKey
	 * @param description
	 * @param remark
	 * @param pictureIds
	 * @param threeDimensionalCollection
	 * @param ringBeatData
	 * @param fVideo
	 * @param fAudio
	 * @param checkState
	 * @param clickCounts
	 * @param selectCounts
	 * @param collectedCounts</pre>    
	 */
	public MipDeleteCulturalrelicInfo(String id,String fpic,String name) {
		super();
		this.id = id;
		this.fpic = fpic;
		this.name = name;
	}


	   
	/**    
	 * <pre>创建一个新的实例 MipOpenCulturalrelicInfo.    
	 *    </pre>    
	 */
	public MipDeleteCulturalrelicInfo() {
		super();
	}
	public MipDeleteCulturalrelicInfo(String id,String collectionType, int clickCounts) {
		super();
		this.id = id;
		this.collectionType = collectionType;
		this.clickCounts = clickCounts;
	}
	
	public MipDeleteCulturalrelicInfo(String id, String name, String collectionType, int clickCounts) {
		super();
		this.id = id;
		this.name = name;
		this.collectionType = collectionType;
		this.clickCounts = clickCounts;
	}
	   
	
	public MipDeleteCulturalrelicInfo(String id, String pictureIds, String collectionUnit, String gsNo,
			String gsCollectionsNo, String name, String yearType, String collectionsCategory, String gsTexture,
			String collectionLevel, byte isHighQuality, byte isOpen, int sequence) {
		
		this.id = id;
		this.pictureIds = pictureIds;
		this.collectionUnit = collectionUnit;
		this.gsNo = gsNo;
		this.gsCollectionsNo = gsCollectionsNo;
		this.name = name;
		this.yearType = yearType;
		this.collectionsCategory = collectionsCategory;
		this.gsTexture = gsTexture;
		this.collectionLevel = collectionLevel;
		this.isHighQuality = isHighQuality;
		this.isOpen = isOpen;
		this.sequence = sequence;
	}

	
	
	
}
