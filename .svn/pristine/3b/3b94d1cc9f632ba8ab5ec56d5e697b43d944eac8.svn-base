/** 
 * <pre>项目名称:mip 
 * 文件名称:MuseumColumn.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年1月18日下午3:55:04 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

/** 
 * <pre>项目名称：mip    
 * 类名称：MuseumColumn    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月18日 下午3:55:04    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月18日 下午3:55:04    
 * 修改备注：       
 * @version </pre>    
 */

@Entity
@Table(name="mip_column")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MuseumColumn extends BaseModel{
	private String introduce;//场馆介绍
	private String ticket;//如何买票
	private String peripheryService;//周边服务
	private String visit;//参观须知
	private String serviceInfo;//服务信息
	private String collection;//馆内藏品
	private String spreadtrum;//展览资讯
	private String virtual;//虚拟展厅
	private Integer orgaId;//跟博物馆对应的id
	@Column(name="introduce")
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	@Column(name="ticket")
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	@Column(name="periphery_service")
	public String getPeripheryService() {
		return peripheryService;
	}
	public void setPeripheryService(String peripheryService) {
		this.peripheryService = peripheryService;
	}
	@Column(name="visit")
	public String getVisit() {
		return visit;
	}
	public void setVisit(String visit) {
		this.visit = visit;
	}
	@Column(name="service_info")
	public String getServiceInfo() {
		return serviceInfo;
	}
	public void setServiceInfo(String serviceInfo) {
		this.serviceInfo = serviceInfo;
	}
	@Column(name="collection")
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	@Column(name="spreadtrum")
	public String getSpreadtrum() {
		return spreadtrum;
	}
	public void setSpreadtrum(String spreadtrum) {
		this.spreadtrum = spreadtrum;
	}
	@Column(name="virtual")
	public String getVirtual() {
		return virtual;
	}
	public void setVirtual(String virtual) {
		this.virtual = virtual;
	}
	
	@Column(name="orga_id")
	public Integer getOrgaId() {
		return orgaId;
	}
	public void setOrgaId(Integer orgaId) {
		this.orgaId = orgaId;
	}
	   
	/**    
	 * <pre>创建一个新的实例 MuseumColumn.    
	 *    
	 * @param introduce
	 * @param ticket
	 * @param peripheryService
	 * @param visit
	 * @param serviceInfo
	 * @param collection
	 * @param spreadtrum
	 * @param virtual
	 * @param orgaId</pre>    
	 */
	public MuseumColumn(String introduce, String ticket, String peripheryService, String visit, String serviceInfo,
			String collection, String spreadtrum, String virtual, Integer orgaId) {
		super();
		this.introduce = introduce;
		this.ticket = ticket;
		this.peripheryService = peripheryService;
		this.visit = visit;
		this.serviceInfo = serviceInfo;
		this.collection = collection;
		this.spreadtrum = spreadtrum;
		this.virtual = virtual;
		this.orgaId = orgaId;
	}
	   
	/**    
	 * <pre>创建一个新的实例 MuseumColumn.    
	 *    </pre>    
	 */
	public MuseumColumn() {
		super();
	}
	   
	
	
	
}
