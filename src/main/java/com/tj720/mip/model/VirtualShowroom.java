/** 
 * <pre>项目名称:mip 
 * 文件名称:VirtualShowroom.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年1月14日上午10:52:57 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseModel;

/** 
 * <pre>项目名称：mip    
 * 类名称：VirtualShowroom    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月14日 上午10:52:57    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月14日 上午10:52:57    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name="mip_virtual_exibition_hall")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class VirtualShowroom extends BaseModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long viCreater = (long) 0;//创建时间	
	private String lastPerson = "";//最后编辑人
	private String viLastTime;//最后编辑时间
	private String viName = "";//虚拟展厅名称
	private Integer viClassify = 0;//分类  1三维虚拟漫游,2 全景漫游
	private String viMasterMap = "";//主图
	private String viPCUrl = "";//PC跳转url
	private String viMoveUrl = "";//移动端跳转url
	private String viIntro = "";//简介
	private byte publish = -127;//发布状态
	private String viUnit = "";//所属单位
	private String viFounder = "";//创建人
	private Long clickNumber = (long) 0;//点击量
	private Long publishTime = (long) 0;//发布时间
	private Integer orgId = 0;//
	
	//业务字段
	private String viAddress;//点击量
	
	private String staTime;
	private String pictureThumb;
	private String musExhibition;
	private String userName;
	private String lastName;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Transient
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Transient
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Transient
	public String getMusExhibition() {
		return musExhibition;
	}
	public void setMusExhibition(String musExhibition) {
		this.musExhibition = musExhibition;
	}
	@Transient
	public String getPictureThumb() {
		return pictureThumb;
	}
	public void setPictureThumb(String pictureThumb) {
		this.pictureThumb = pictureThumb;
	}
	@Column(name="publish_time")
	public Long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Long publishTime) {
		this.publishTime = publishTime;
	}
	@Column(name="org_id")
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	@Transient
	public String getStaTime() {
		return staTime;
	}
	public void setStaTime(String staTime) {
		this.staTime = staTime;
	}
	@Transient
	public String getViAddress() {
		return viAddress;
	}
	public void setViAddress(String viAddress) {
		this.viAddress = viAddress;
	}
	@Column(name="click_number")
	public Long getClickNumber() {
		return clickNumber;
	}
	public void setClickNumber(Long clickNumber) {
		this.clickNumber = clickNumber;
	}
	@Column(name="user_name")
	public String getViFounder() {
		return viFounder;
	}
	public void setViFounder(String viFounder) {
		this.viFounder = viFounder;
	}
	@Column(name="viUnit")
	public String getViUnit() {
		return viUnit;
	}
	public void setViUnit(String viUnit) {
		this.viUnit = viUnit;
	}
	@Column(name="viCreater")
	public Long getViCreater() {
		return viCreater;
	}
	public void setViCreater(Long viCreater) {
		this.viCreater = viCreater;
	}
	
	
	@Column(name="viLastTime")
	public String getViLastTime() {
		return viLastTime;
	}
	public void setViLastTime(String viLastTime) {
		this.viLastTime = viLastTime;
	}
	@Column(name="viLastPerson")
	public String getLastPerson() {
		return lastPerson;
	}
	public void setLastPerson(String lastPerson) {
		this.lastPerson = lastPerson;
	}
	@Column(name="viName")
	public String getViName() {
		return viName;
	}
	public void setViName(String viName) {
		this.viName = viName;
	}
	@Column(name="viClassify")
	public Integer getViClassify() {
		return viClassify;
	}
	public void setViClassify(Integer viClassify) {
		this.viClassify = viClassify;
	}
	@Column(name="picture_id")
	public String getViMasterMap() {
		return viMasterMap;
	}
	public void setViMasterMap(String viMasterMap) {
		this.viMasterMap = viMasterMap;
	}
	@Column(name="viPCUrl")
	public String getViPCUrl() {
		return viPCUrl;
	}
	public void setViPCUrl(String viPCUrl) {
		this.viPCUrl = viPCUrl;
	}
	@Column(name="viMoveUrl")
	public String getViMoveUrl() {
		return viMoveUrl;
	}
	public void setViMoveUrl(String viMoveUrl) {
		this.viMoveUrl = viMoveUrl;
	}
	@Column(name="viIntro")
	public String getViIntro() {
		return viIntro;
	}
	public void setViIntro(String viIntro) {
		this.viIntro = viIntro;
	}
	@Column(name="publish")   
	public byte getPublish() {
		return publish;
	}
	public void setPublish(byte publish) {
		this.publish = publish;
	}
	
	/**    
	 * <pre>创建一个新的实例 VirtualShowroom.    
	 *    </pre>    
	 */
	public VirtualShowroom() {
		super();
	}
	//省级地级管理人员的构造方法
	public VirtualShowroom(String id,String viName,Integer viClassify,  Long viCreater,byte publish,String viUnit) {
		super();
		this.id = id;
		this.viName = viName;
		this.viClassify = viClassify;
		this.viCreater = viCreater;
		this.publish = publish;
		this.viUnit = viUnit;
	}
	//博物馆管理人员的构造方法
	public VirtualShowroom(String id,String viName,Integer viClassify,  Long viCreater,byte publish) {
		super();
		this.id = id;
		this.viName = viName;
		this.viClassify = viClassify;
		this.viCreater = viCreater;
		this.publish = publish;
	}
	//前台展示的虚拟展厅信息
	public VirtualShowroom(String id,String viName,String viIntro, String viPCUrl, String viMoveUrl,String viMasterMap,Integer orgId) {
		super();
		this.id = id;
		this.viName = viName;
		this.viIntro = viIntro;
		this.viPCUrl = viPCUrl;
		this.viMoveUrl = viMoveUrl;
		this.viMasterMap = viMasterMap;
		this.orgId = orgId;
	}
	public VirtualShowroom(String viName, String viMoveUrl, String viMasterMap) {
		this.viName = viName;
		this.viMasterMap = viMasterMap;
		this.viMoveUrl = viMoveUrl;
	}
	
}
