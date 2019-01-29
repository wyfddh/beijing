/** 
 * <pre>项目名称:mip 
 * 文件名称:Spreadtrum.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年2月4日下午4:38:16 
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
 * 类名称：Spreadtrum    
 * 类描述：   展讯
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月4日 下午4:38:16    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月4日 下午4:38:16    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name="mip_spreadtrum")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class Spreadtrum  extends BaseModel{
	private Long beginTime = (long) 0;//开始时间
	private Long endTime = (long) 0;//结束时间
	private Integer orgId = 0;//发布单位
	private String userName = "";//创建人的名字
	private String picture = "";//主图
	private String fAudio="";//语音或背景音乐
	private String viPCUrl = "";//PC虚拟展厅url
	private String viMoveUrl = "";//移动端虚拟展厅url
	private String content = "";//内容
	private byte source = 0;//来源
	private String headline = "";//标题
	private String editor = "";//编辑
	private Long publishTime = (long) 0;//发布时间
	private byte publish = -127;//发布状态
	private Integer exhibitioType = 0;//常设1/临时0   
	private String updatedTime;//修改时间
	
	//业务字段
	private String staTime = "";
	private String overTime = "";
	private String musExhibition;
	private String issemTime;
	private String pictureThumb;
	private String nickName;
	private String audioPath="";
	
	
	
	
	
	
	
	@Transient
	public String getAudioPath() {
		return audioPath;
	}
	public void setAudioPath(String audioPath) {
		this.audioPath = audioPath;
	}
	@Transient
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Transient
	public String getPictureThumb() {
		return pictureThumb;
	}
	public void setPictureThumb(String pictureThumb) {
		this.pictureThumb = pictureThumb;
	}
	@Transient
	public String getIssemTime() {
		return issemTime;
	}
	public void setIssemTime(String issemTime) {
		this.issemTime = issemTime;
	}

	
	
	
	@Column(name = "exhibition_type")
	public Integer getExhibitioType() {
		return exhibitioType;
	}
	public void setExhibitioType(Integer exhibitioType) {
		this.exhibitioType = exhibitioType;
	}
	
	@Column(name = "publish")
	public byte getPublish() {
		return publish;
	}
	public void setPublish(byte publish) {
		this.publish = publish;
	}
	@Transient
	public String getStaTime() {
		return staTime;
	}
	public void setStaTime(String staTime) {
		this.staTime = staTime;
	}
	@Transient
	public String getMusExhibition() {
		return musExhibition;
	}
	public void setMusExhibition(String musExhibition) {
		this.musExhibition = musExhibition;
	}
	
	@Transient
	public String getOverTime() {
		return overTime;
	}
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}
	@Column(name = "publish_time")
	public Long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Long publishTime) {
		this.publishTime = publishTime;
	}
	@Column(name = "headline")
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
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
	@Column(name = "org_id")
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	
	
	@Column(name="editor")
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	@Column(name = "user_id")
	
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
	
	@Column(name = "f_audio")
	public String getfAudio() {
		return fAudio;
	}
	public void setfAudio(String fAudio) {
		this.fAudio = fAudio;
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
	@Column(name = "content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "source")
	public byte getSource() {
		return source;
	}
	public void setSource(byte source) {
		this.source = source;
	}
	@Column(name = "updated_time")
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	
	public Spreadtrum(String id, String picture, String headline) {
		this.id = id;
		this.picture = picture;
		this.headline = headline;
	}
	/**    
	 * <pre>创建一个新的实例 Spreadtrum.    
	 *    
	 * @param beginTime
	 * @param endTime
	 * @param releaseUnit
	 * @param founder
	 * @param picture
	 * @param content
	 * @param source</pre>    
	 */
	public Spreadtrum(String id,String headline,Long beginTime, Long endTime,String userName, 
			byte source,String createTime,byte publish) {
		super();
		this.id = id;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.userName = userName;
		this.headline = headline;
		this.createTime = createTime;
		this.source = source;
		this.publish = publish;
	}
	
	public Spreadtrum(String headline,Long beginTime, Long endTime, Integer orgId, String userName, 
			byte source,String createTime,Long publishTime ,byte publish) {
		super();
		
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.orgId = orgId;
		this.userName = userName;
		this.headline = headline;
		this.createTime = createTime;
		this.source = source;
		this.publishTime = publishTime;
		this.publish = publish;
	}
	
	//前台展示的数据
	public Spreadtrum(String id, String headline, Long beginTime, Long endTime,Integer orgId, String content, String picture,Integer exhibitioType) {
		super();
		this.id = id;
		this.headline = headline;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.orgId = orgId;
		this.content = content;
		this.picture = picture;
		this.exhibitioType = exhibitioType;
	}
	//WYU:20170517,new,前台展示的数据
	public Spreadtrum(String id, String headline, Long beginTime, Long endTime,Integer orgId, String content, String picture,Integer exhibitioType,String editor) {
		super();
		this.id = id;
		this.headline = headline;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.orgId = orgId;
		this.content = content;
		this.picture = picture;
		this.exhibitioType = exhibitioType;
		this.editor=editor;
	}
	//首页展示的数据
	public Spreadtrum(String id, String headline, Long beginTime, Long endTime,Integer orgId, String content, String picture) {
		super();
		this.id = id;
		this.headline = headline;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.orgId = orgId;
		this.content = content;
		this.picture = picture;
	}
	
	
	   
	/**    
	 * <pre>创建一个新的实例 Spreadtrum.    
	 *    </pre>    
	 */
	public Spreadtrum() {
		super();
	}
	
	
}
