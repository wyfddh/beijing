package com.tj720.mip.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.dto.ILuceneDto;
import com.tj720.mip.dto.SearchDto;
import com.tj720.mip.framework.base.BaseModel;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.utils.DateFormartUtil;
import com.tj720.mip.utils.MyString;


/**
 * @date 2016-01-06
 */
@Entity
@Table(name="mip_picture_search_set")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class PictureSearchSet extends BaseModel implements Serializable,ILuceneDto{
	private static final long serialVersionUID = 1L;

	private String pictureId="";//图片id,
	private String objectId="";//反射,
	private String typeId="";//type表id,
	private String gsNo="";//藏品普查编号,
	private String url="";//图片存储位置,
	private String name="";//藏品原名或者英文名或者藏品名称,
	private String yearType="";//年代,
	private String collectionsCategory="";//类别,
	private String orgaName="";//博物馆名称,
	private String uid="";//用户id,
	private String updateTime=DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss);//修改时间,
	@Override
	public SearchDto toSearchDto(ICacheService cacheService) {
		// TODO Auto-generated method stub
		return null;
	}
	@Column(name="picture_id")
	public String getPictureId() {
		return pictureId;
	}
	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
	@Column(name="object_id")
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	@Column(name="type_id")
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	@Column(name="gs_No")
	public String getGsNo() {
		return gsNo;
	}
	public void setGsNo(String gsNo) {
		this.gsNo = gsNo;
	}
	@Column(name="url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.replace(",", "，，");
	}
	@Column(name="year_type")
	public String getYearType() {
		return yearType;
	}
	public void setYearType(String yearType) {
		this.yearType = yearType;
	}
	@Column(name="collections_category")
	public String getCollectionsCategory() {
		return collectionsCategory;
	}
	public void setCollectionsCategory(String collectionsCategory) {
		this.collectionsCategory = collectionsCategory;
	}
	@Column(name="orga_name")
	public String getOrgaName() {
		return orgaName;
	}
	public void setOrgaName(String orgaName) {
		this.orgaName = orgaName.replace(',', '，');
	}
	@Column(name="uid")
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Column(name="updateTime")
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	@Transient
	public String getMetaId(){
		StringBuffer result = new StringBuffer();
		if(!MyString.isEmpty(gsNo))
			result.append("&gsNo:").append(gsNo);
		if(!MyString.isEmpty(collectionsCategory))
			result.append("&collectionsCategory:").append(collectionsCategory);
		if(!MyString.isEmpty(yearType))
			result.append("&yearType:").append(yearType);
		if(!MyString.isEmpty(name))
			result.append("&name:").append(name);
		if(result.length()>0)
			result.deleteCharAt(0);
		return result.toString();
	}
	@Transient
	public String getTags(){
		StringBuffer result = new StringBuffer();
		if(!MyString.isEmpty(gsNo))
			result.append("|").append(gsNo);
		if(!MyString.isEmpty(collectionsCategory))
			result.append("|").append(collectionsCategory);
		if(!MyString.isEmpty(yearType))
			result.append("|").append(yearType);
		if(!MyString.isEmpty(name))
			result.append("|").append(name);
		if(result.length()>0)
			result.deleteCharAt(0);
		return result.toString();
	}
	@Transient
	public String getShortTags(){
		StringBuffer result = new StringBuffer();
		if(!MyString.isEmpty(collectionsCategory))
			result.append("|").append(collectionsCategory);
		if(!MyString.isEmpty(yearType))
			result.append("|").append(yearType);
		if(!MyString.isEmpty(name))
			result.append("|").append(name);
		if(result.length()>0)
			result.deleteCharAt(0);
		return result.toString();
	}
}