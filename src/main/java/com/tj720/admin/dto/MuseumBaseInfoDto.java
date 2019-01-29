package com.tj720.admin.dto;



import java.util.List;

import com.tj720.mip.vo.BaseVO;

	
/**
 * 博物馆基础资料Entity
 * @author chenshiya
 * @version 2018-05-17
 */
public class MuseumBaseInfoDto extends BaseVO{

	private static final long serialVersionUID = 1L;
	private String museumId;		// 博物馆id
	private String museumName;		// 博物馆名称
	private String phone;		// 电话
	private String museumType;		// 博物馆性质
	private String province;		// 省
	private String city;		// 市
	private String area;		// 区
	private String detailAddress;		// 详细地址
	private String webUrl;		// 网站地址
	private String mailbox;		// 邮箱
	private String fax;		// 传真
	private String zipCode;		// 邮编
	private String firstOpenDate;		// 正式对社会开放时间
	private String isFree;		// 是否免费开放
	private String staticCloseDay;		// 固定闭馆日
	private String museumDescription;		// 博物馆简介
	private String registrationNumber;		// 注册字号
	private String legalPerson;		// 法定代表人
	private String isIndependentPerson;		// 是否具有独立法人资格
	private String registrationOffice;		// 法人登记机关
	private String legalPersonType;		// 法人登记类型
	private String legalPersonTypeName;		// 法人登记类型描述
	private String legalPersonNumber;		// 法人登记号码
	private String certificationLevel;		// 国家认证级别
	private String areaName;//区域描述
	private String museumTypeName;//博物馆性质描述
	private String certificationLevelName;//博物馆等级描述
	private String allDataPer;//总完成度

	private Integer startInt;
	private Integer endInt;
	
	private String busLine;//公交线路
	private String subwayLine;//地铁线路
	private String parkArea;//非机动车停放区
	private String imageId;//图片主键
	private String geography;//地理信息
	private String funcType;//'博物馆类型（1：综合地质类，2考古遗址类，3历史文化类，4艺术类，5自然科技类，6其他类）',
	private String relationShip;//'行政隶属关系(1:央属，2市属，3区，4街道，5乡镇，6村)',
	private String loveCountry;//是否爱过主义教育基地（1全国示范基地，2省市级爱国主义教育基地，3区县级爱国主义教育基地，4非爱国主义教育基地）',
	private String developPlan;//发展规划
	private String ruleBuild;//制度建设
	private String weibo;//微博号
	private String wechat;//微信公众号
	private String manageWay;//法人治理结构（附件id）
	private	String closeType;//固定闭馆日填写类型
	private String imageUrl;//图片相对路径，存储用
	private String resourceUnit;//'是否为“北京中小学生社会大课堂”资源单位(1:是0：否)',
	private String educationBase;//'是否为科普教育基地(1全国科普教育基地；3北京市科普基地;3:不是)',
	private String scenicLevel;//'是否为A级旅游景区(1:5A;2:4A;3:不是)',
	private String operatingExpenses;//'基本运营经费（1：财政拨款2：项目经费3：其他）',
	private String pictureUrl;//图片绝对路径，显示用
	
	private List<String> orgIdList;
	
	
	public List<String> getOrgIdList() {
		return orgIdList;
	}

	public void setOrgIdList(List<String> orgIdList) {
		this.orgIdList = orgIdList;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getLegalPersonTypeName() {
		return legalPersonTypeName;
	}

	public void setLegalPersonTypeName(String legalPersonTypeName) {
		this.legalPersonTypeName = legalPersonTypeName;
	}

	
	public String getAllDataPer() {
		return allDataPer;
	}

	public void setAllDataPer(String allDataPer) {
		this.allDataPer = allDataPer;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getMuseumTypeName() {
		return museumTypeName;
	}

	public void setMuseumTypeName(String museumTypeName) {
		this.museumTypeName = museumTypeName;
	}

	public String getCertificationLevelName() {
		return certificationLevelName;
	}

	public void setCertificationLevelName(String certificationLevelName) {
		this.certificationLevelName = certificationLevelName;
	}

	public String getMuseumId() {
		return museumId;
	}

	public void setMuseumId(String museumId) {
		this.museumId = museumId;
	}
	
	public String getMuseumName() {
		return museumName;
	}

	public void setMuseumName(String museumName) {
		this.museumName = museumName;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMuseumType() {
		return museumType;
	}

	public void setMuseumType(String museumType) {
		this.museumType = museumType;
	}
	
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	
	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	
	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getIsFree() {
		return isFree;
	}

	public void setIsFree(String isFree) {
		this.isFree = isFree;
	}
	
	public String getStaticCloseDay() {
		return staticCloseDay;
	}

	public void setStaticCloseDay(String staticCloseDay) {
		this.staticCloseDay = staticCloseDay;
	}
	
	public String getMuseumDescription() {
		return museumDescription;
	}

	public void setMuseumDescription(String museumDescription) {
		this.museumDescription = museumDescription;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	
	public String getIsIndependentPerson() {
		return isIndependentPerson;
	}

	public void setIsIndependentPerson(String isIndependentPerson) {
		this.isIndependentPerson = isIndependentPerson;
	}
	
	public String getRegistrationOffice() {
		return registrationOffice;
	}

	public void setRegistrationOffice(String registrationOffice) {
		this.registrationOffice = registrationOffice;
	}
	
	public String getLegalPersonType() {
		return legalPersonType;
	}

	public void setLegalPersonType(String legalPersonType) {
		this.legalPersonType = legalPersonType;
	}
	
	public String getLegalPersonNumber() {
		return legalPersonNumber;
	}

	public void setLegalPersonNumber(String legalPersonNumber) {
		this.legalPersonNumber = legalPersonNumber;
	}
	
	public String getCertificationLevel() {
		return certificationLevel;
	}

	public void setCertificationLevel(String certificationLevel) {
		this.certificationLevel = certificationLevel;
	}

	public String getFirstOpenDate() {
		return firstOpenDate;
	}

	public void setFirstOpenDate(String firstOpenDate) {
		this.firstOpenDate = firstOpenDate;
	}

	public Integer getStartInt() {
		return startInt;
	}

	public void setStartInt(Integer startInt) {
		this.startInt = startInt;
	}

	public Integer getEndInt() {
		return endInt;
	}

	public void setEndInt(Integer endInt) {
		this.endInt = endInt;
	}

	public String getBusLine() {
		return busLine;
	}

	public void setBusLine(String busLine) {
		this.busLine = busLine;
	}

	public String getSubwayLine() {
		return subwayLine;
	}

	public void setSubwayLine(String subwayLine) {
		this.subwayLine = subwayLine;
	}

	public String getParkArea() {
		return parkArea;
	}

	public void setParkArea(String parkArea) {
		this.parkArea = parkArea;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getGeography() {
		return geography;
	}

	public void setGeography(String geography) {
		this.geography = geography;
	}

	public String getFuncType() {
		return funcType;
	}

	public void setFuncType(String funcType) {
		this.funcType = funcType;
	}

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	public String getLoveCountry() {
		return loveCountry;
	}

	public void setLoveCountry(String loveCountry) {
		this.loveCountry = loveCountry;
	}

	public String getDevelopPlan() {
		return developPlan;
	}

	public void setDevelopPlan(String developPlan) {
		this.developPlan = developPlan;
	}

	public String getRuleBuild() {
		return ruleBuild;
	}

	public void setRuleBuild(String ruleBuild) {
		this.ruleBuild = ruleBuild;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getManageWay() {
		return manageWay;
	}

	public void setManageWay(String manageWay) {
		this.manageWay = manageWay;
	}

	public String getCloseType() {
		return closeType;
	}

	public void setCloseType(String closeType) {
		this.closeType = closeType;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getResourceUnit() {
		return resourceUnit;
	}

	public void setResourceUnit(String resourceUnit) {
		this.resourceUnit = resourceUnit;
	}

	public String getEducationBase() {
		return educationBase;
	}

	public void setEducationBase(String educationBase) {
		this.educationBase = educationBase;
	}

	public String getScenicLevel() {
		return scenicLevel;
	}

	public void setScenicLevel(String scenicLevel) {
		this.scenicLevel = scenicLevel;
	}

	public String getOperatingExpenses() {
		return operatingExpenses;
	}

	public void setOperatingExpenses(String operatingExpenses) {
		this.operatingExpenses = operatingExpenses;
	}
	
}