package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.dto.ILuceneDto;
import com.tj720.mip.dto.SearchDto;
import com.tj720.mip.enumeration.ProjectType;
import com.tj720.mip.framework.SpringContextHolder;
import com.tj720.mip.framework.base.BaseModel;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.service.tool.CacheService;
import com.tj720.mip.utils.GetTextFromFile;
import com.tj720.mip.utils.MyString;


/**
 * @date 2016-01-06
 */
@Entity
@Table(name="mip_base_fossil_info")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class FCFossil extends BaseModel implements Serializable,ILuceneDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String collectionUnit;//收藏单位collection_unit
	private String dwId;//收藏单位编号dwid
	private String gsNo;//普查编号gs_No
	private String gsCollectionsNoType; //藏品编号类型gs_collectionsNo_type
	private String gsCollectionsNo; //藏品编号类型gs_collectionsNo
	private String collectionType; //藏品编号类型collection_type
	private String name; //名称name
	private String formerly; //原名formerly
	private String foreign_name; //英文名/拉丁文名foreign_name
	private String yearTypeEon; //年代（宙）year_type_eon
	private String yearTypeEra; //年代（代）year_type_era
	private String yearTypeEpoch; //年代（纪）year_type_epoch
	private String yearType;//年代
	private String gsSpecificYear; //具体年代gs_specific_year
	private String collectionsCategory; //文物类别collections_category
	private String gsTextureCategory; //质地类别gs_texture_category
	private String gsTextureSubcategories; //质地子类别gs_texture_subcategories
	private String gsTexture; //质地gs_texture
	private String actualQuantityUnit; //数量actual_quantity_unit
	private Float actualQuantity; //实际数量actual_quantity
	private Float gsLength; //通长gs_length
	private Float gsWidth; //通宽gs_width
	private Float gsHeight; //通高gs_height
	private String size; //具体尺寸size
	private String massRange; //质量范围mass_range
	private String mass; //具体质量mass
	private String massUnit; //质量单位mass_unit
	private String collectionLevel; //文物级别collection_level
	private String gsSource; //文物来源gs_source
	private String collectionPlace; //采集地collection_place
	private String endResidueLevel; //完残程度end_residue_level
	private String endResidualCondition; //完残状况end_residual_condition
	private String gsStorageType;//保存方式gs_storage_type
	private String gsStorageState; //保存状态gs_storage_state
	private String gsEntryWarehouseTimeFrame; //入藏时间范围gs_entry_warehouse_time_frame
	private String gsEntryWarehouseYear; //入藏年度gs_entry_warehouse_year
	private String gsEntryWarehouseTime; //入库日期gs_entry_warehouse_time
	private String gsAuthor; //著者gs_author
	private String gsVersion; //版本gs_version
	private String gsKeepOnFile; //存卷gs_keep_on_file
	private byte isHighQuality = 1; //是否为精品（1：否；2：是）is_high_quality
	private byte isOpen = 2; //是否公开（1：否；2：是）is_high_quality
	private String description; //描述  description
	private String remark; //备注  remark
	private String creator; //录入员  creator
	private String assessor; //收藏单位审核员  assessor
	private String submitTime; //提交时间  submitTime
	private String pictureIds;
	
	public FCFossil(){}
	
	public FCFossil(String id, String createTime, byte status, int sequence, String collectionUnit, String gsNo, String gsCollectionsNo, String name, String yearTypeEon,
			String yearTypeEra, String yearTypeEpoch, String collectionsCategory, String collectionLevel, String thumbnailUrl, byte isHighQuality, byte isOpen) {
		this.id = id;
		this.createTime = createTime;
		this.status = status;
		this.sequence = sequence;
		this.name = name;
		this.collectionUnit = collectionUnit;
		this.gsNo = gsNo;
		this.gsCollectionsNo = gsCollectionsNo;
		this.name = name;
		this.yearTypeEon = yearTypeEon;
		this.yearTypeEra = yearTypeEra;
		this.yearTypeEpoch = yearTypeEpoch;
		this.collectionsCategory = collectionsCategory;
		this.collectionLevel = collectionLevel;
		this.isHighQuality = isHighQuality;
		this.isOpen = isOpen;
	}
	
	
	public FCFossil(String collectionUnit, String dwId, String gsNo, String gsCollectionsNoType, String gsCollectionsNo,
			String collectionType, String name, String formerly, String foreign_name, String yearTypeEon,
			String yearTypeEra, String yearTypeEpoch, String gsSpecificYear, String collectionsCategory,
			String gsTextureCategory, String gsTextureSubcategories, String gsTexture, String actualQuantityUnit,
			Float actualQuantity, Float gsLength, Float gsWidth, Float gsHeight, String size, String massRange,
			String mass, String massUnit, String collectionLevel, String gsSource, String collectionPlace,
			String endResidueLevel, String endResidualCondition, String gsStorageState,
			String gsEntryWarehouseTimeFrame, String gsEntryWarehouseYear, String gsEntryWarehouseTime, String gsAuthor,
			String gsVersion, String gsKeepOnFile, String thumbnailUrl, byte isHighQuality, byte isOpen,
			String description, String remark, String creator, String assessor, String submitTime) {
		super();
		this.collectionUnit = collectionUnit;
		this.dwId = dwId;
		this.gsNo = gsNo;
		this.gsCollectionsNoType = gsCollectionsNoType;
		this.gsCollectionsNo = gsCollectionsNo;
		this.collectionType = collectionType;
		this.name = name;
		this.formerly = formerly;
		this.foreign_name = foreign_name;
		this.yearTypeEon = yearTypeEon;
		this.yearTypeEra = yearTypeEra;
		this.yearTypeEpoch = yearTypeEpoch;
		this.gsSpecificYear = gsSpecificYear;
		this.collectionsCategory = collectionsCategory;
		this.gsTextureCategory = gsTextureCategory;
		this.gsTextureSubcategories = gsTextureSubcategories;
		this.gsTexture = gsTexture;
		this.actualQuantityUnit = actualQuantityUnit;
		this.actualQuantity = actualQuantity;
		this.gsLength = gsLength;
		this.gsWidth = gsWidth;
		this.gsHeight = gsHeight;
		this.size = size;
		this.massRange = massRange;
		this.mass = mass;
		this.massUnit = massUnit;
		this.collectionLevel = collectionLevel;
		this.gsSource = gsSource;
		this.collectionPlace = collectionPlace;
		this.endResidueLevel = endResidueLevel;
		this.endResidualCondition = endResidualCondition;
		this.gsStorageState = gsStorageState;
		this.gsEntryWarehouseTimeFrame = gsEntryWarehouseTimeFrame;
		this.gsEntryWarehouseYear = gsEntryWarehouseYear;
		this.gsEntryWarehouseTime = gsEntryWarehouseTime;
		this.gsAuthor = gsAuthor;
		this.gsVersion = gsVersion;
		this.gsKeepOnFile = gsKeepOnFile;
		this.isHighQuality = isHighQuality;
		this.isOpen = isOpen;
		this.description = description;
		this.remark = remark;
		this.creator = creator;
		this.assessor = assessor;
		this.submitTime = submitTime;
	}

	@Column(name="collection_unit")
	public String getCollectionUnit() {
		return collectionUnit;
	}
	public void setCollectionUnit(String collectionUnit) {
		this.collectionUnit = collectionUnit;
	}

	@Column(name="dwid")
	public String getDwId() {
		return dwId;
	}
	public void setDwId(String dwId) {
		this.dwId = dwId;
	}

	@Column(name="gs_No")
	public String getGsNo() {
		return gsNo;
	}
	public void setGsNo(String gsNo) {
		this.gsNo = gsNo;
	}

	@Column(name="gs_collectionsNo_type")
	public String getGsCollectionsNoType() {
		return gsCollectionsNoType;
	}
	public void setGsCollectionsNoType(String gsCollectionsNoType) {
		this.gsCollectionsNoType = gsCollectionsNoType;
	}

	@Column(name="gs_collectionsNo")
	public String getGsCollectionsNo() {
		return gsCollectionsNo;
	}
	public void setGsCollectionsNo(String gsCollectionsNo) {
		this.gsCollectionsNo = gsCollectionsNo;
	}

	@Column(name="collection_type")
	public String getCollectionType() {
		return collectionType;
	}
	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="formerly")
	public String getFormerly() {
		return formerly;
	}
	public void setFormerly(String formerly) {
		this.formerly = formerly;
	}

	@Column(name="foreign_name")
	public String getForeign_name() {
		return foreign_name;
	}
	public void setForeign_name(String foreign_name) {
		this.foreign_name = foreign_name;
	}

	
	@Column(name="year_type_eon")
	public String getYearTypeEon() {
		return yearTypeEon;
	}
	public void setYearTypeEon(String yearTypeEon) {
		this.yearTypeEon = yearTypeEon;
	}

	@Column(name="year_type_era")
	public String getYearTypeEra() {
		return yearTypeEra;
	}
	public void setYearTypeEra(String yearTypeEra) {
		this.yearTypeEra = yearTypeEra;
	}

	@Column(name="year_type_epoch")
	public String getYearTypeEpoch() {
		return yearTypeEpoch;
	}
	public void setYearTypeEpoch(String yearTypeEpoch) {
		this.yearTypeEpoch = yearTypeEpoch;
	}

	@Column(name="year_type")
	public String getYearType() {
		return yearType;
	}
	public void setYearType(String yearType) {
		this.yearType = yearType;
	}

	@Column(name="gs_specific_year")
	public String getGsSpecificYear() {
		return gsSpecificYear;
	}
	public void setGsSpecificYear(String gsSpecificYear) {
		this.gsSpecificYear = gsSpecificYear;
	}

	@Column(name="collections_category")
	public String getCollectionsCategory() {
		return collectionsCategory;
	}
	public void setCollectionsCategory(String collectionsCategory) {
		this.collectionsCategory = collectionsCategory;
	}

	@Column(name="gs_texture_category")
	public String getGsTextureCategory() {
		return gsTextureCategory;
	}
	public void setGsTextureCategory(String gsTextureCategory) {
		this.gsTextureCategory = gsTextureCategory;
	}
	@Column(name="gs_texture_subcategories")
	public String getGsTextureSubcategories() {
		return gsTextureSubcategories;
	}
	public void setGsTextureSubcategories(String gsTextureSubcategories) {
		this.gsTextureSubcategories = gsTextureSubcategories;
	}
	
	@Column(name="gs_texture")
	public String getGsTexture() {
		return gsTexture;
	}
	public void setGsTexture(String gsTexture) {
		this.gsTexture = gsTexture;
	}
	
	@Column(name="actual_quantity_unit")
	public String getActualQuantityUnit() {
		return actualQuantityUnit;
	}
	public void setActualQuantityUnit(String actualQuantityUnit) {
		this.actualQuantityUnit = actualQuantityUnit;
	}
	
	@Column(name="actual_quantity")
	public Float getActualQuantity() {
		return actualQuantity;
	}
	public void setActualQuantity(Float actualQuantity) {
		this.actualQuantity = actualQuantity;
	}

	@Column(name="gs_length")
	public Float getGsLength() {
		return gsLength;
	}
	public void setGsLength(Float gsLength) {
		this.gsLength = gsLength;
	}

	@Column(name="gs_width")
	public Float getGsWidth() {
		return gsWidth;
	}
	public void setGsWidth(Float gsWidth) {
		this.gsWidth = gsWidth;
	}

	@Column(name="gs_height")
	public Float getGsHeight() {
		return gsHeight;
	}
	public void setGsHeight(Float gsHeight) {
		this.gsHeight = gsHeight;
	}

	@Column(name="size")
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	@Column(name="mass_range")
	public String getMassRange() {
		return massRange;
	}
	public void setMassRange(String massRange) {
		this.massRange = massRange;
	}

	@Column(name="mass")
	public String getMass() {
		return mass;
	}
	public void setMass(String mass) {
		this.mass = mass;
	}

	@Column(name="mass_unit")
	public String getMassUnit() {
		return massUnit;
	}
	public void setMassUnit(String massUnit) {
		this.massUnit = massUnit;
	}

	@Column(name="collection_level")
	public String getCollectionLevel() {
		return collectionLevel;
	}
	public void setCollectionLevel(String collectionLevel) {
		this.collectionLevel = collectionLevel;
	}

	@Column(name="gs_source")
	public String getGsSource() {
		return gsSource;
	}
	public void setGsSource(String gsSource) {
		this.gsSource = gsSource;
	}

	@Column(name="collection_place")
	public String getCollectionPlace() {
		return collectionPlace;
	}
	public void setCollectionPlace(String collectionPlace) {
		this.collectionPlace = collectionPlace;
	}

	@Column(name="end_residue_level")
	public String getEndResidueLevel() {
		return endResidueLevel;
	}
	public void setEndResidueLevel(String endResidueLevel) {
		this.endResidueLevel = endResidueLevel;
	}

	@Column(name="end_residual_condition")
	public String getEndResidualCondition() {
		return endResidualCondition;
	}
	public void setEndResidualCondition(String endResidualCondition) {
		this.endResidualCondition = endResidualCondition;
	}

	@Column(name="gs_storage_state")
	public String getGsStorageState() {
		return gsStorageState;
	}
	public void setGsStorageState(String gsStorageState) {
		this.gsStorageState = gsStorageState;
	}
	
	@Column(name="gs_entry_warehouse_time_frame")
	public String getGsEntryWarehouseTimeFrame() {
		return gsEntryWarehouseTimeFrame;
	}
	public void setGsEntryWarehouseTimeFrame(String gsEntryWarehouseTimeFrame) {
		this.gsEntryWarehouseTimeFrame = gsEntryWarehouseTimeFrame;
	}

	@Column(name="gs_entry_warehouse_year")
	public String getGsEntryWarehouseYear() {
		return gsEntryWarehouseYear;
	}
	public void setGsEntryWarehouseYear(String gsEntryWarehouseYear) {
		this.gsEntryWarehouseYear = gsEntryWarehouseYear;
	}

	@Column(name="gs_entry_warehouse_time")
	public String getGsEntryWarehouseTime() {
		return gsEntryWarehouseTime;
	}
	public void setGsEntryWarehouseTime(String gsEntryWarehouseTime) {
		this.gsEntryWarehouseTime = gsEntryWarehouseTime;
	}

	@Column(name="gs_author")
	public String getGsAuthor() {
		return gsAuthor;
	}
	public void setGsAuthor(String gsAuthor) {
		this.gsAuthor = gsAuthor;
	}

	@Column(name="gs_version")
	public String getGsVersion() {
		return gsVersion;
	}
	public void setGsVersion(String gsVersion) {
		this.gsVersion = gsVersion;
	}

	@Column(name="gs_keep_on_file")
	public String getGsKeepOnFile() {
		return gsKeepOnFile;
	}
	public void setGsKeepOnFile(String gsKeepOnFile) {
		this.gsKeepOnFile = gsKeepOnFile;
	}
	
	@Column(name="is_high_quality")
	public byte getIsHighQuality() {
		return isHighQuality;
	}
	public void setIsHighQuality(byte isHighQuality) {
		this.isHighQuality = isHighQuality;
	};
	
	@Column(name="is_open")
	public byte getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(byte isOpen) {
		this.isOpen = isOpen;
	}

	@Column(name="creator")
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	@Column(name="assessor")
	public String getAssessor() {
		return assessor;
	}
	public void setAssessor(String assessor) {
		this.assessor = assessor;
	}

	@Column(name="submitTime")
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	
	
	@Column(name = "description")
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
	
	
	@Column(name="gs_storage_type")
	public String getGsStorageType() {
		return gsStorageType;
	}
	public void setGsStorageType(String gsStorageType) {
		this.gsStorageType = gsStorageType;
	}

	@Column(name="picture_ids")
	public String getPictureIds() {
		return pictureIds;
	}

	public void setPictureIds(String pictureIds) {
		this.pictureIds = pictureIds;
	}

	@Override
	public SearchDto toSearchDto(ICacheService cacheService) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
}