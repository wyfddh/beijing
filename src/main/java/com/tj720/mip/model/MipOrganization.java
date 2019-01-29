package com.tj720.mip.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.OverridesAttribute;

import org.apache.commons.lang.NumberUtils;
import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

@Entity
@Table(name = "mip_organization")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGeneratorAutoIncrement")
public class MipOrganization  extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name="";
	private String shortname="";
	private String orgTypeId;
	private String parentId="";
	private byte level;
	private String path="";
	private int platformId;
	private String contact="";
	private String cityId="0";
	private String address="";
	private String mobile="";
	private String tel="";
	private String fex="";
	private String email="";
	private String info="";
	private String remark="";
	private byte open;
	private int creatorUid;
	private int operatorUid;
	private byte isdelete;
	private Date updatedTime=new Date();
	private int collectionCount;//藏品数据
	private String townId="0";
	private String provinceId="0";
	private Integer updatedCount=0;
	private String dwid="";
	private String baseName="";
	private double latitude;
	private double longitude;
	private String hide_relation_ship;
	
	@Column(name = "hide_relation_ship")
	public String getHide_relation_ship() {
		return hide_relation_ship;
	}
	public void setHide_relation_ship(String hide_relation_ship) {
		this.hide_relation_ship = hide_relation_ship;
	}


	//业务字段
	private String logo = "";
	@Transient
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Column(name = "updated_count")
	public Integer getUpdatedCount() {
		return updatedCount;
	}
	
	public void setUpdatedCount(Integer updatedCount) {
		this.updatedCount = updatedCount;
	}

	@Column(name = "collection_count")
	public int getCollectionCount() {
		return collectionCount;
	}

	public void setCollectionCount(int collectionCount) {
		this.collectionCount = collectionCount;
	}

	
	
	public MipOrganization(String id, String shortname, String parentId){
		this.id = id;
		this.shortname = shortname;
		this.parentId = parentId;
	}


	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "shortname", nullable = false, length = 64)
	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	@Column(name = "org_type_id", nullable = false)
	public String getOrgTypeId() {
		return this.orgTypeId;
	}

	public void setOrgTypeId(String orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	@Column(name = "parent_id", nullable = false)
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "level", nullable = false)
	public byte getLevel() {
		return this.level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	@Column(name = "path", nullable = false, length = 64)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "platform_id", nullable = false)
	public int getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(int platformId) {
		this.platformId = platformId;
	}

	@Column(name = "contact", nullable = false, length = 32)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "city_id")
	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	

	@Column(name = "address", nullable = false, length = 128)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "mobile", nullable = false, length = 11)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "tel", nullable = false, length = 11)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "fex", nullable = false, length = 11)
	public String getFex() {
		return this.fex;
	}

	public void setFex(String fex) {
		this.fex = fex;
	}

	@Column(name = "email", nullable = false, length = 64)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "info", nullable = false)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "remark", nullable = false)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "open", nullable = false)
	public byte getOpen() {
		return this.open;
	}

	public void setOpen(byte open) {
		this.open = open;
	}

	@Column(name = "creator_uid", nullable = false)
	public int getCreatorUid() {
		return this.creatorUid;
	}

	public void setCreatorUid(int creatorUid) {
		this.creatorUid = creatorUid;
	}

	@Column(name = "operator_uid", nullable = false)
	public int getOperatorUid() {
		return this.operatorUid;
	}

	public void setOperatorUid(int operatorUid) {
		this.operatorUid = operatorUid;
	}

	@Column(name = "isdelete", nullable = false)
	public byte getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(byte isdelete) {
		this.isdelete = isdelete;
	}
	@Column(name = "dwid")
	public String getDwid() {
		return dwid;
	}

	public void setDwid(String dwid) {
		this.dwid = dwid;
	}
	@Column(name = "base_name")
	public String getBaseName() {
		return baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_time", nullable = false, length = 19)
	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Column(name="town_id")
	public String getTownId() {
		return townId;
	}

	public void setTownId(String townId) {
		this.townId = townId;
	}

	@Column(name="province_id")
	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}   
	
	@Column(name="latitude")
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	@Column(name="longitude")
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/**    
	 * <pre>创建一个新的实例 MipOrganization.    
	 *    
	 * @param name
	 * @param collectionCount</pre>    
	 */
	public MipOrganization(String id,int collectionCount,String name) {
		
		super();
		this.id = id;
		this.collectionCount = collectionCount;
		this.name = name;
	}

	   
	/**    
	 * <pre>创建一个新的实例 MipOrganization.    
	 *    </pre>    
	 */
	public MipOrganization() {
		super();
	}
	
	
	public MipOrganization(String id,String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
