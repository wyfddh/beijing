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

import com.fasterxml.jackson.core.sym.Name;
import com.tj720.mip.framework.base.BaseModel;

@Entity
@Table(name = "mip_open_collection_info")
@GenericGenerator(name = "Generator", strategy = "com.tj720.mip.framework.IdGenerator")
public class MipOpenCollectionInfo extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gsNo = "";
	private String name = "";
	private String collectionUnit = "";
	private String collectionLevel = "";
	private String yearType = "";
	private String collectionsCategory = "";
	private String description = "";
	private String fAudio = "";
	private String fVideo = "";
	private String threeDimensionalCollection = "";
	private String pictureIds = "";
	private int clickCounts;
	private int collectedCounts;
	private String updatedTime = "";
	private byte isHighQuality;
	private String collectionType = "";
	private String ringBeatData = "";

	// 业务字段
	private String orgName;
	private String pictureUrl;
	private String pictureHQ;

	@Transient
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Transient
	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	@Transient
	public String getPictureHQ() {
		return pictureHQ;
	}

	public void setPictureHQ(String pictureHQ) {
		this.pictureHQ = pictureHQ;
	}

	@Column(name = "gs_No")
	public String getGsNo() {
		return gsNo;
	}

	public void setGsNo(String gsNo) {
		this.gsNo = gsNo;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "collection_unit")
	public String getCollectionUnit() {
		return collectionUnit;
	}

	public void setCollectionUnit(String collectionUnit) {
		this.collectionUnit = collectionUnit;
	}

	@Column(name = "collection_level")
	public String getCollectionLevel() {
		return collectionLevel;
	}

	public void setCollectionLevel(String collectionLevel) {
		this.collectionLevel = collectionLevel;
	}

	@Column(name = "year_type")
	public String getYearType() {
		return yearType;
	}

	public void setYearType(String yearType) {
		this.yearType = yearType;
	}

	@Column(name = "collections_category")
	public String getCollectionsCategory() {
		return collectionsCategory;
	}

	public void setCollectionsCategory(String collectionsCategory) {
		this.collectionsCategory = collectionsCategory;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "f_audio")
	public String getfAudio() {
		return fAudio;
	}

	public void setfAudio(String fAudio) {
		this.fAudio = fAudio;
	}

	@Column(name = "f_video")
	public String getfVideo() {
		return fVideo;
	}

	public void setfVideo(String fVideo) {
		this.fVideo = fVideo;
	}

	@Column(name = "three_dimensional_collection")
	public String getThreeDimensionalCollection() {
		return threeDimensionalCollection;
	}

	public void setThreeDimensionalCollection(String threeDimensionalCollection) {
		this.threeDimensionalCollection = threeDimensionalCollection;
	}

	@Column(name = "picture_ids")
	public String getPictureIds() {
		return pictureIds;
	}

	public void setPictureIds(String pictureIds) {
		this.pictureIds = pictureIds;
	}

	@Column(name = "click_counts")
	public int getClickCounts() {
		return clickCounts;
	}

	public void setClickCounts(int clickCounts) {
		this.clickCounts = clickCounts;
	}

	@Column(name = "collected_counts")
	public int getCollectedCounts() {
		return collectedCounts;
	}

	public void setCollectedCounts(int collectedCounts) {
		this.collectedCounts = collectedCounts;
	}

	@Column(name = "updated_time")
	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Column(name = "is_high_quality")
	public byte getIsHighQuality() {
		return isHighQuality;
	}

	public void setIsHighQuality(byte isHighQuality) {
		this.isHighQuality = isHighQuality;
	}

	@Column(name = "collection_type")
	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	@Column(name = "ring_beat_data")
	public String getRingBeatData() {
		return ringBeatData;
	}

	public void setRingBeatData(String ringBeatData) {
		this.ringBeatData = ringBeatData;
	}

	public MipOpenCollectionInfo() {
		super();
	}

	public MipOpenCollectionInfo(String id, String name, String pictureIds) {
		this.id = id;
		this.name = name;
		this.pictureIds = pictureIds;
	}

	public MipOpenCollectionInfo(String id, String name, String collectionUnit, String collectionLevel, String yearType,
			String collectionsCategory, String description, String pictureIds) {
		this.id = id;
		this.name = name;
		this.collectionUnit = collectionUnit;
		this.collectionLevel = collectionLevel;
		this.yearType = yearType;
		this.collectionsCategory = collectionsCategory;
		this.description = description;
		this.pictureIds = pictureIds;
	}

	private int isBorrow;

	/**
	 * @return the isBorrow
	 */
	@Transient
	public int getIsBorrow() {
		return isBorrow;
	}

	/**
	 * @param isBorrow
	 *            the isBorrow to set
	 */
	public void setIsBorrow(int isBorrow) {
		this.isBorrow = isBorrow;
	}

	private String gsCollectionsNoType;

	/**
	 * @return the gsCollectionsNoType
	 */
	@Transient
	public String getGsCollectionsNoType() {
		return gsCollectionsNoType;
	}

	/**
	 * @param gsCollectionsNoType
	 *            the gsCollectionsNoType to set
	 */
	public void setGsCollectionsNoType(String gsCollectionsNoType) {
		this.gsCollectionsNoType = gsCollectionsNoType;
	}

	private String gsCollectionsNo = "";

	/**
	 * @return the gsCollectionsNo
	 */
	@Transient
	public String getGsCollectionsNo() {
		return gsCollectionsNo;
	}

	/**
	 * @param gsCollectionsNo
	 *            the gsCollectionsNo to set
	 */
	public void setGsCollectionsNo(String gsCollectionsNo) {
		this.gsCollectionsNo = gsCollectionsNo;
	}

}
