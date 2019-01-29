/** 
 * <pre>项目名称:mip 
 * 文件名称:MuseumInfo.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年1月16日下午6:12:52 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

/** 
 * <pre>项目名称：mip    
 * 类名称：MuseumInfo    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月16日 下午6:12:52    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月16日 下午6:12:52    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name="mip_museum_info")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MuseumInfo extends BaseModel{ 
	private String museumName="";
	private Integer level = 0;//级别
	private String categoryId = "0";//类别表的外键
	private Integer ticket=1;//票务类型(1代表免费/2代表收费)
	private String ticketPrice="";//票价
	private String openingHours="";//开放时间
	private String address="";//详细地址
	private String telephone="";//联系电话
	private String geography="";//地理信息
	private Integer cityId=0;//所属地区--跟地区表的外键
	private String introduce = "";//场馆介绍
	private String buyTicket = "";//如何买票
	private String nearby = "";//附近餐饮
	private String visitNotes = "";//参观须知
	private String serviceInformation = "";//服务信息
	private String fAudio="";
	private Integer orgId = 0;//跟组织架构关联的id
	private Integer clickCount = 0;//点击次数
	private byte spreOpen = 0;//展览开启状态
	private byte virOpen = 0;//展厅开启状态
	private String logo = "";//logo链接
	private int thinId = 0;//皮肤编号
	//业务字段
	private String category;//参观须知
	private String levelName;//级别名称
	private String audioPath="";
	private String logoUrl="";
	
	@Transient
	public String getAudioPath() {
		return audioPath;
	}
	public void setAudioPath(String audioPath) {
		this.audioPath = audioPath;
	}
	@Transient
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	@Transient
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	@Column(name="spre_open")
	public byte getSpreOpen() {
		return spreOpen;
	}
	public void setSpreOpen(byte spreOpen) {
		this.spreOpen = spreOpen;
	}
	@Column(name="vir_open")
	public byte getVirOpen() {
		return virOpen;
	}
	public void setVirOpen(byte virOpen) {
		this.virOpen = virOpen;
	}
	@Column(name="click_count")
	public Integer getClickCount() {
		return clickCount;
	}
	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}
	@Column(name="museum_name")
	public String getMuseumName() {
		return museumName;
	}
	public void setMuseumName(String museumName) {
		this.museumName = museumName;
	}
	@Transient
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Column(name="org_id")
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	@Column(name="introduce")
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	@Column(name="buy_ticket")
	public String getBuyTicket() {
		return buyTicket;
	}
	public void setBuyTicket(String buyTicket) {
		this.buyTicket = buyTicket;
	}
	@Column(name="nearby")
	public String getNearby() {
		return nearby;
	}
	public void setNearby(String nearby) {
		this.nearby = nearby;
	}
	@Column(name="visit_notes")
	public String getVisitNotes() {
		return visitNotes;
	}
	public void setVisitNotes(String visitNotes) {
		this.visitNotes = visitNotes;
	}
	@Column(name="service_information")
	public String getServiceInformation() {
		return serviceInformation;
	}
	public void setServiceInformation(String serviceInformation) {
		this.serviceInformation = serviceInformation;
	}
	@Column(name = "f_audio")
	public String getfAudio() {
		return fAudio;
	}
	public void setfAudio(String fAudio) {
		this.fAudio = fAudio;
	}
	@Column(name="level")
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	@Column(name="category_id")
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	@Column(name="ticket")
	public Integer getTicket() {
		return ticket;
	}
	public void setTicket(Integer ticket) {
		this.ticket = ticket;
	}
	@Column(name="ticket_price")
	public String getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	@Column(name="opening_hours")
	public String getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="telephone")
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Column(name="geography")
	public String getGeography() {
		return geography;
	}
	public void setGeography(String geography) {
		this.geography = geography;
	}
	@Column(name="city_id")
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	@Column(name="logo")
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	@Column(name = "thin_id")   
	public int getThinId() {
		return thinId;
	}
	public void setThinId(int thinId) {
		this.thinId = thinId;
	}
	/**    
	 * <pre>创建一个新的实例 MuseumInfo.    
	 *    
	 * @param level
	 * @param categoryId
	 * @param ticket
	 * @param ticketPrice
	 * @param openingHours
	 * @param address
	 * @param telephone
	 * @param geography
	 * @param orgaId
	 * @param cityId</pre>    
	 */
	public MuseumInfo(String categoryId, Integer ticket, String ticketPrice, String openingHours,
			String address, String telephone, String geography, Integer cityId,String buyTicket,
			String nearby,String visitNotes,String serviceInformation,Integer orgId, String introduce) {
		super();
		this.categoryId = categoryId;
		this.ticket = ticket;
		this.ticketPrice = ticketPrice;
		this.openingHours = openingHours;
		this.address = address;
		this.telephone = telephone;
		this.geography = geography;
		this.buyTicket = buyTicket;
		this.cityId = cityId;
		this.nearby = nearby;
		this.visitNotes = visitNotes;
		this.serviceInformation = serviceInformation;
		this.orgId = orgId;
		this.introduce = introduce;
	}
	   
	
	/**    
	 * <pre>创建一个新的实例 MuseumInfo.    
	 *    </pre>    
	 */
	public MuseumInfo() {
		super();
	}
	
	public MuseumInfo(String logo) {
		super();
		this.logo = logo;
	}
	
	public MuseumInfo(String id,String museumName,Integer level,Integer ticket, String openingHours,String address,Integer orgId,Integer cityId) {
		super();
		this.id = id;
		this.museumName = museumName;
		this.level = level;
		this.ticket = ticket;
		this.openingHours = openingHours;
		this.address = address;
		this.orgId = orgId;
		this.cityId = cityId;
	}
	   
	/**    
	 * <pre>创建一个新的实例 MuseumInfo.    
	 *    
	 * @param museumName
	 * @param level
	 * @param categoryId
	 * @param ticket
	 * @param ticketPrice
	 * @param openingHours
	 * @param address
	 * @param telephone
	 * @param geography
	 * @param cityId
	 * @param introduce
	 * @param buyTicket
	 * @param nearby
	 * @param visitNotes
	 * @param serviceInformation
	 * @param fAudio
	 * @param orgId
	 * @param clickCount
	 * @param category</pre>    
	 */
	public MuseumInfo(String id,String museumName, Integer level, String categoryId, Integer ticket, String ticketPrice,
			String openingHours, String address, String telephone, String geography, Integer cityId, String introduce,
			String buyTicket, String nearby, String visitNotes, String serviceInformation, String fAudio, Integer orgId,
			Integer clickCount,byte spreOpen,byte virOpen ) {
		super();
		this.id = id;
		this.museumName = museumName;
		this.level = level;
		this.categoryId = categoryId;
		this.ticket = ticket;
		this.ticketPrice = ticketPrice;
		this.openingHours = openingHours;
		this.address = address;
		this.telephone = telephone;
		this.geography = geography;
		this.cityId = cityId;
		this.introduce = introduce;
		this.buyTicket = buyTicket;
		this.nearby = nearby;
		this.visitNotes = visitNotes;
		this.serviceInformation = serviceInformation;
		this.fAudio=fAudio;
		this.orgId = orgId;
		this.clickCount = clickCount;
		this.spreOpen = spreOpen;
		this.virOpen = virOpen;
	}
	/**    
	 * <pre>创建一个新的实例 MuseumInfo.    
	 *    
	 * @param museumName
	 * @param level
	 * @param categoryId
	 * @param ticket
	 * @param ticketPrice
	 * @param openingHours
	 * @param address
	 * @param telephone
	 * @param geography
	 * @param cityId
	 * @param introduce
	 * @param buyTicket
	 * @param nearby
	 * @param visitNotes
	 * @param serviceInformation
	 * @param orgId
	 * @param clickCount
	 * @param category</pre>    
	 */
	public MuseumInfo(String id,String museumName, Integer level, String categoryId, Integer ticket, String ticketPrice,
			String openingHours, String address, String telephone, String geography, Integer cityId, String introduce,
			String buyTicket, String nearby, String visitNotes, String serviceInformation, Integer orgId,
			Integer clickCount,byte spreOpen,byte virOpen ) {
		super();
		this.id = id;
		this.museumName = museumName;
		this.level = level;
		this.categoryId = categoryId;
		this.ticket = ticket;
		this.ticketPrice = ticketPrice;
		this.openingHours = openingHours;
		this.address = address;
		this.telephone = telephone;
		this.geography = geography;
		this.cityId = cityId;
		this.introduce = introduce;
		this.buyTicket = buyTicket;
		this.nearby = nearby;
		this.visitNotes = visitNotes;
		this.serviceInformation = serviceInformation;
		this.orgId = orgId;
		this.clickCount = clickCount;
		this.spreOpen = spreOpen;
		this.virOpen = virOpen;
	}
	
	public MuseumInfo(String id,String museumName, Integer level, String categoryId, Integer ticket, String ticketPrice,
			String openingHours, String address, String telephone, String geography,Integer orgId,Integer cityId) {
		super();
		this.id = id;
		this.museumName = museumName;
		this.level = level;
		this.categoryId = categoryId;
		this.ticket = ticket;
		this.ticketPrice = ticketPrice;
		this.openingHours = openingHours;
		this.address = address;
		this.telephone = telephone;
		this.geography = geography;
		this.orgId = orgId;
		this.cityId = cityId;
	}
	public MuseumInfo(String id,String museumName, Integer level, String categoryId, Integer ticket, String ticketPrice,
			String openingHours, String address, String telephone, String geography, String fAudio,Integer orgId,Integer cityId,String logo,Integer thinId) {
		super();
		this.id = id;
		this.museumName = museumName;
		this.level = level;
		this.categoryId = categoryId;
		this.ticket = ticket;
		this.ticketPrice = ticketPrice;
		this.openingHours = openingHours;
		this.address = address;
		this.telephone = telephone;
		this.geography = geography;
		this.fAudio=fAudio;
		this.orgId = orgId;
		this.cityId = cityId;
		this.logo = logo;
		this.thinId = thinId;
	}
	   
	/**    
	 * <pre>创建一个新的实例 MuseumInfo.    
	 *    
	 * private String museumName;
	private Integer level;//级别
	private String categoryId;//类别表的外键
	private Integer ticket;//票务类型(1代表免费/2代表收费)
	private String ticketPrice;//票价
	private String openingHours;//开放时间
	private String address;//详细地址
	private String telephone;//联系电话
	private String geography;//地理信息
	private Integer cityId = 0;//所属地区--跟地区表的外键
	private String introduce = "";//场馆介绍
	private String buyTicket = "";//如何买票
	private String nearby = "";//附近餐饮
	private String visitNotes = "";//参观须知
	private String serviceInformation = "";//服务信息
	private Integer orgId = 0;//跟组织架构关联的id
	private Integer clickCount = 0;//点击次数
	
	 */
	public MuseumInfo(String id,String museumName,String introduce,String buyTicket, String nearby, 
			String visitNotes, String serviceInformation, Integer orgId, byte  spreOpen,byte virOpen) {
		super();
		this.id = id;
		this.museumName = museumName;
		this.introduce = introduce;
		this.buyTicket = buyTicket;
		this.nearby = nearby;
		this.visitNotes = visitNotes;
		this.serviceInformation = serviceInformation;
		this.orgId = orgId;
		this.spreOpen = spreOpen;
		this.virOpen = virOpen;
	}
	
	public MuseumInfo(String id,String museumName,String categoryId,Integer level,Integer cityId) {
		super();
		this.id = id;
		this.museumName = museumName;
		this.categoryId = categoryId;
		this.level = level;
		this.cityId = cityId;
	}
	
	
	
}
