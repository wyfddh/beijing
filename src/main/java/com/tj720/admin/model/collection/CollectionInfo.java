package com.tj720.admin.model.collection;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * collection_info
 * @author 
 */
public class CollectionInfo implements Serializable {
    private String id;

    /**
     * 藏品名
     */
    private String collectionName = "";

    /**
     * 藏品年代
     */
    private String collectionYearType;

    /**
     * 藏品级别
     */
    private String collectionLevel;

    /**
     * 藏品类别
     */
    private String collectionCategory;

    /**
     * 藏品质地
     */
    private String collectionTexture;

    /**
     * 藏品质地类别
     */
    private String collectionTextureCategory;

    /**
     * 藏品质地子类别
     */
    private String collectionTextureSonCategory;

    /**
     * 通长
     */
    private BigDecimal collectionLength;

    /**
     * 通宽
     */
    private BigDecimal collectionWidth;

    /**
     * 通高
     */
    private BigDecimal collectionHigh;

    /**
     * 具体尺寸
     */
    private String collectionSpecificSize = "";

    /**
     * 质量范围
     */
    private String massRange;

    /**
     * 具体质量
     */
    private String massConcrete = "";
    
    /**
     * 质量单位
     */
    private String massUnit = "";

    /**
     * 保存状态
     */
    private String saveState;

    /**
     * 完残程度
     */
    private String degreeDisability;

    /**
     * 完残状况
     */
    private String residualStatus = "";

    /**
     * 藏品原用名
     */
    private String collectionOldName = "";

    /**
     * 藏品来源
     */
    private String collectionComeFrom;

    /**
     * 普查编号
     */
    private String generalSurveyNum = "";

    /**
     * 藏品编号
     */
    private String collectionCodeNum = "";

    /**
     * 收藏单位ID
     */
    private String collectionOrgId = "";

    /**
     * 收藏单位名
     */
    private String collectionOrgName = "";

    /**
     * 收藏单位编号
     */
    private String collectionOrgNum = "";

    /**
     * 藏品编号类型
     */
    private String collectionCodeType;

    /**
     * 入藏时间范围
     */
    private String timeFrame;

    /**
     * 入藏年度
     */
    private String collectedYear = "";

    /**
     * 包含文物数量
     */
    private String containCollectionCount;

    /**
     * 实际数量
     */
    private String collectionCount = "";

    /**
     * 著者
     */
    private String collectionWriter = "";

    /**
     * 版本
     */
    private String collectionVersion = "";

    /**
     * 存卷
     */
    private String collectionKeepFile = "";

    /**
     * 录入员名
     */
    private String entryDataPerson = "";

    /**
     * 审核人名
     */
    private String reviewPerson = "";

    /**
     * 藏品图片关联id
     */
    private String collectionPictureid = "";

    /**
     * 是否在展出(0否1是）
     */
    private String exhibiting;

    /**
     * 创建人
     */
    private String createBy = "";

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 数据状态（1待筛选2疑似革命文物3排除革命文物4确认革命文物）
     */
    private String dataState;

    //藏品类别名
    private String collectionCategoryName = "";
    //藏品年代名
    private String collectionYearTypeName = "";
    //文物级别名
    private String collectionLevelName = "";
    //藏品质地名
    private String collectionTextureName = "";
    //是否在展名
    private String exhibitingName = "";
    //图片列表
    private List<CollectionAttachment> picList ;
    //收藏单位地址
    private String address = "";
    //包含文物数量名
    private String containCollectionCountName = "";
    //质地类别名
    private String collectionTextureCategoryName = "";
    //质地子类别名
    private String collectionTextureSonCategoryName = "";
    //质量范围名
    private String massRangeName = "";
    //质量单位名
    private String massUnitName = "";
    //保存状态名
    private String saveStateName = "";
    //完残程度名
    private String degreeDisabilityName = "";
    //文物来源名
    private String collectionComeFromName = "";
    //藏品编号类型名
    private String collectionCodeTypeName = "";
    //入藏时间范围名
    private String timeFrameName = "";

    private static final long serialVersionUID = 1L;
    
	public String getMassUnitName() {
		return massUnitName;
	}

	public void setMassUnitName(String massUnitName) {
		this.massUnitName = massUnitName;
	}

	public String getMassUnit() {
		return massUnit;
	}

	public void setMassUnit(String massUnit) {
		this.massUnit = massUnit;
	}

	public String getCollectionTextureCategoryName() {
        return collectionTextureCategoryName;
    }

    public void setCollectionTextureCategoryName(String collectionTextureCategoryName) {
        this.collectionTextureCategoryName = collectionTextureCategoryName;
    }

    public String getCollectionTextureSonCategoryName() {
        return collectionTextureSonCategoryName;
    }

    public void setCollectionTextureSonCategoryName(String collectionTextureSonCategoryName) {
        this.collectionTextureSonCategoryName = collectionTextureSonCategoryName;
    }

    public String getMassRangeName() {
        return massRangeName;
    }

    public void setMassRangeName(String massRangeName) {
        this.massRangeName = massRangeName;
    }

    public String getSaveStateName() {
        return saveStateName;
    }

    public void setSaveStateName(String saveStateName) {
        this.saveStateName = saveStateName;
    }

    public String getDegreeDisabilityName() {
        return degreeDisabilityName;
    }

    public void setDegreeDisabilityName(String degreeDisabilityName) {
        this.degreeDisabilityName = degreeDisabilityName;
    }

    public String getCollectionComeFromName() {
        return collectionComeFromName;
    }

    public void setCollectionComeFromName(String collectionComeFromName) {
        this.collectionComeFromName = collectionComeFromName;
    }

    public String getCollectionCodeTypeName() {
        return collectionCodeTypeName;
    }

    public void setCollectionCodeTypeName(String collectionCodeTypeName) {
        this.collectionCodeTypeName = collectionCodeTypeName;
    }

    public String getTimeFrameName() {
        return timeFrameName;
    }

    public void setTimeFrameName(String timeFrameName) {
        this.timeFrameName = timeFrameName;
    }

    public String getContainCollectionCountName() {
        return containCollectionCountName;
    }

    public void setContainCollectionCountName(String containCollectionCountName) {
        this.containCollectionCountName = containCollectionCountName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCollectionTextureName() {
        return collectionTextureName;
    }

    public void setCollectionTextureName(String collectionTextureName) {
        this.collectionTextureName = collectionTextureName;
    }

    public List<CollectionAttachment> getPicList() {
        return picList;
    }

    public void setPicList(List<CollectionAttachment> picList) {
        this.picList = picList;
    }

    public String getCollectionYearTypeName() {
        return collectionYearTypeName;
    }

    public void setCollectionYearTypeName(String collectionYearTypeName) {
        this.collectionYearTypeName = collectionYearTypeName;
    }

    public String getCollectionCategoryName() {
        return collectionCategoryName;
    }

    public void setCollectionCategoryName(String collectionCategoryName) {
        this.collectionCategoryName = collectionCategoryName;
    }

    public String getCollectionLevelName() {
        return collectionLevelName;
    }

    public void setCollectionLevelName(String collectionLevelName) {
        this.collectionLevelName = collectionLevelName;
    }

    public String getExhibitingName() {
        return exhibitingName;
    }

    public void setExhibitingName(String exhibitingName) {
        this.exhibitingName = exhibitingName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionYearType() {
        return collectionYearType;
    }

    public void setCollectionYearType(String collectionYearType) {
        this.collectionYearType = collectionYearType;
    }

    public String getCollectionLevel() {
        return collectionLevel;
    }

    public void setCollectionLevel(String collectionLevel) {
        this.collectionLevel = collectionLevel;
    }

    public String getCollectionCategory() {
        return collectionCategory;
    }

    public void setCollectionCategory(String collectionCategory) {
        this.collectionCategory = collectionCategory;
    }

    public String getCollectionTexture() {
        return collectionTexture;
    }

    public void setCollectionTexture(String collectionTexture) {
        this.collectionTexture = collectionTexture;
    }

    public String getCollectionTextureCategory() {
        return collectionTextureCategory;
    }

    public void setCollectionTextureCategory(String collectionTextureCategory) {
        this.collectionTextureCategory = collectionTextureCategory;
    }

    public String getCollectionTextureSonCategory() {
        return collectionTextureSonCategory;
    }

    public void setCollectionTextureSonCategory(String collectionTextureSonCategory) {
        this.collectionTextureSonCategory = collectionTextureSonCategory;
    }

    public BigDecimal getCollectionLength() {
        return collectionLength;
    }

    public void setCollectionLength(BigDecimal collectionLength) {
        this.collectionLength = collectionLength;
    }

    public BigDecimal getCollectionWidth() {
        return collectionWidth;
    }

    public void setCollectionWidth(BigDecimal collectionWidth) {
        this.collectionWidth = collectionWidth;
    }

    public BigDecimal getCollectionHigh() {
        return collectionHigh;
    }

    public void setCollectionHigh(BigDecimal collectionHigh) {
        this.collectionHigh = collectionHigh;
    }

    public String getCollectionSpecificSize() {
        return collectionSpecificSize;
    }

    public void setCollectionSpecificSize(String collectionSpecificSize) {
        this.collectionSpecificSize = collectionSpecificSize;
    }

    public String getMassRange() {
        return massRange;
    }

    public void setMassRange(String massRange) {
        this.massRange = massRange;
    }

    public String getMassConcrete() {
        return massConcrete;
    }

    public void setMassConcrete(String massConcrete) {
        this.massConcrete = massConcrete;
    }

    public String getSaveState() {
        return saveState;
    }

    public void setSaveState(String saveState) {
        this.saveState = saveState;
    }

    public String getDegreeDisability() {
        return degreeDisability;
    }

    public void setDegreeDisability(String degreeDisability) {
        this.degreeDisability = degreeDisability;
    }

    public String getResidualStatus() {
        return residualStatus;
    }

    public void setResidualStatus(String residualStatus) {
        this.residualStatus = residualStatus;
    }

    public String getCollectionOldName() {
        return collectionOldName;
    }

    public void setCollectionOldName(String collectionOldName) {
        this.collectionOldName = collectionOldName;
    }

    public String getCollectionComeFrom() {
        return collectionComeFrom;
    }

    public void setCollectionComeFrom(String collectionComeFrom) {
        this.collectionComeFrom = collectionComeFrom;
    }

    public String getGeneralSurveyNum() {
        return generalSurveyNum;
    }

    public void setGeneralSurveyNum(String generalSurveyNum) {
        this.generalSurveyNum = generalSurveyNum;
    }

    public String getCollectionCodeNum() {
        return collectionCodeNum;
    }

    public void setCollectionCodeNum(String collectionCodeNum) {
        this.collectionCodeNum = collectionCodeNum;
    }

    public String getCollectionOrgId() {
        return collectionOrgId;
    }

    public void setCollectionOrgId(String collectionOrgId) {
        this.collectionOrgId = collectionOrgId;
    }

    public String getCollectionOrgName() {
        return collectionOrgName;
    }

    public void setCollectionOrgName(String collectionOrgName) {
        this.collectionOrgName = collectionOrgName;
    }

    public String getCollectionOrgNum() {
        return collectionOrgNum;
    }

    public void setCollectionOrgNum(String collectionOrgNum) {
        this.collectionOrgNum = collectionOrgNum;
    }

    public String getCollectionCodeType() {
        return collectionCodeType;
    }

    public void setCollectionCodeType(String collectionCodeType) {
        this.collectionCodeType = collectionCodeType;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    public String getCollectedYear() {
        return collectedYear;
    }

    public void setCollectedYear(String collectedYear) {
        this.collectedYear = collectedYear;
    }

    public String getContainCollectionCount() {
        return containCollectionCount;
    }

    public void setContainCollectionCount(String containCollectionCount) {
        this.containCollectionCount = containCollectionCount;
    }

    public String getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(String collectionCount) {
        this.collectionCount = collectionCount;
    }

    public String getCollectionWriter() {
        return collectionWriter;
    }

    public void setCollectionWriter(String collectionWriter) {
        this.collectionWriter = collectionWriter;
    }

    public String getCollectionVersion() {
        return collectionVersion;
    }

    public void setCollectionVersion(String collectionVersion) {
        this.collectionVersion = collectionVersion;
    }

    public String getCollectionKeepFile() {
        return collectionKeepFile;
    }

    public void setCollectionKeepFile(String collectionKeepFile) {
        this.collectionKeepFile = collectionKeepFile;
    }

    public String getEntryDataPerson() {
        return entryDataPerson;
    }

    public void setEntryDataPerson(String entryDataPerson) {
        this.entryDataPerson = entryDataPerson;
    }

    public String getReviewPerson() {
        return reviewPerson;
    }

    public void setReviewPerson(String reviewPerson) {
        this.reviewPerson = reviewPerson;
    }

    public String getCollectionPictureid() {
        return collectionPictureid;
    }

    public void setCollectionPictureid(String collectionPictureid) {
        this.collectionPictureid = collectionPictureid;
    }

    public String getExhibiting() {
        return exhibiting;
    }

    public void setExhibiting(String exhibiting) {
        this.exhibiting = exhibiting;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }
}