/** 
 * <pre>项目名称:mip 
 * 文件名称:OutsideAndAbroad.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年2月13日上午10:54:42 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

/** 
 * <pre>项目名称：mip    
 * 类名称：OutsideAndAbroad    
 * 类描述：    省外跟省内的展讯
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月13日 上午10:54:42    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月13日 上午10:54:42    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name="mip_outside_abroad")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class OutsideAndAbroad extends BaseModel{
	private Long beginTime = (long) 0;//开始时间
	private Long endTime = (long) 0;//结束时间
	private String userName = "";//创建人的id
	private String picture = "";//主图
	private String content = "";//内容
	private String headline = "";//标题
	private Long publishTime = (long) 0;//发布时间
	private byte publish = -128;//发布状态
	private byte type = 1;//展讯类型---省外1还是国外2
	private String musExhibition = "";//展馆名称
	private Integer exhibitioType = 0;//常设1/临时0  
	//业务字段
	private String staTime;
	private String overTime;
	private String issueTime;
	private String nickName;
	private String pictureThumb;
	
	
	
	
	@Transient
	public String getPictureThumb() {
		return pictureThumb;
	}
	public void setPictureThumb(String pictureThumb) {
		this.pictureThumb = pictureThumb;
	}
	@Transient
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Transient
	public String getIssueTime() {
		return issueTime;
	}
	public void setIssueTime(String issueTime) {
		this.issueTime = issueTime;
	}
	@Column(name = "begin_time")
	public Long getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}
	@Column(name = "end_time")
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "picture_id")
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Column(name = "content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "headline")
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	@Column(name = "publish_time")
	public Long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Long publishTime) {
		this.publishTime = publishTime;
	}
	@Column(name = "publish")
	public byte getPublish() {
		return publish;
	}
	public void setPublish(byte publish) {
		this.publish = publish;
	}
	@Column(name = "type")
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	@Column(name = "mus_exhibition")
	public String getMusExhibition() {
		return musExhibition;
	}
	public void setMusExhibition(String musExhibition) {
		this.musExhibition = musExhibition;
	}
	@Column(name = "exhibition_type")
	public Integer getExhibitioType() {
		return exhibitioType;
	}
	public void setExhibitioType(Integer exhibitioType) {
		this.exhibitioType = exhibitioType;
	}
	@Transient
	public String getStaTime() {
		return staTime;
	}
	public void setStaTime(String staTime) {
		this.staTime = staTime;
	}
	@Transient
	public String getOverTime() {
		return overTime;
	}
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}
	   
	/**    
	 * <pre>创建一个新的实例 OutsideAndAbroad.    
	 *    
	 * @param beginTime
	 * @param endTime
	 * @param userName
	 * @param picture
	 * @param content
	 * @param headline
	 * @param publishTime
	 * @param publish
	 * @param type
	 * @param musExhibition
	 * @param exhibitioType
	 * @param staTime
	 * @param overTime</pre>    
	 */
	public OutsideAndAbroad(Long beginTime, Long endTime, String userName, String picture, String content,
			String headline, Long publishTime, byte publish, byte type, String musExhibition, Integer exhibitioType,
			String staTime, String overTime) {
		super();
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.userName = userName;
		this.picture = picture;
		this.content = content;
		this.headline = headline;
		this.publishTime = publishTime;
		this.publish = publish;
		this.type = type;
		this.musExhibition = musExhibition;
		this.exhibitioType = exhibitioType;
		this.staTime = staTime;
		this.overTime = overTime;
	}
	public OutsideAndAbroad(String id,String headline,Long beginTime,Long endTime,String musExhibition,byte publish,String userName,Long publishTime,String content) {
		super();
		this.id = id;
		this.headline = headline;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.musExhibition = musExhibition;
		this.publish = publish;
		this.userName = userName;
		this.publishTime = publishTime;
		this.content = content;
	}
	public OutsideAndAbroad(String id,String headline,Long beginTime,Long endTime,String musExhibition,String content,String picture,byte type) {
		super();
		this.id = id;
		this.headline = headline;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.musExhibition = musExhibition;
		this.content = content;
		this.picture = picture;
		this.type = type;
	}
	
	/**    
	 * <pre>创建一个新的实例 OutsideAndAbroad.    
	 *    </pre>    
	 */
	public OutsideAndAbroad() {
		super();
	}
	
	
	
	
	
}
