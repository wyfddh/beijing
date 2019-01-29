package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.dto.ILuceneDto;
import com.tj720.mip.dto.SearchDto;
import com.tj720.mip.framework.base.BaseModel;
import com.tj720.mip.inter.service.tool.ICacheService;

@Entity
@Table(name="mip_collection_audio")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class MipCollectionAudio extends BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String collectionId="";
	private String userId="";
	private byte isOfficial;
	private String url="";
	private int likeCounts;
	private long publishTime;
	private String duration;
	
	//业务字段
	private String userName="";
	private String publishTimeStr="";
	private String avatarUrl="";
	
	@Transient
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Transient
	public String getPublishTimeStr() {
		return publishTimeStr;
	}
	public void setPublishTimeStr(String publishTimeStr) {
		this.publishTimeStr = publishTimeStr;
	}
	@Transient
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
	@Column(name="collection_id")
	public String getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}
	@Column(name="user_id")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Column(name="is_official")
	public byte getIsOfficial() {
		return isOfficial;
	}
	public void setIsOfficial(byte isOfficial) {
		this.isOfficial = isOfficial;
	}
	@Column(name="url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name="like_counts")
	public int getLikeCounts() {
		return likeCounts;
	}
	public void setLikeCounts(int likeCounts) {
		this.likeCounts = likeCounts;
	}
	@Column(name="publish_time")
	public long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}
	@Column(name="duration")
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	

}
