package com.tj720.mip.dto;

public class CollectionAudioDto {
	
	private String id="";
	private String collectionId="";
	private String userId="";
	private byte isOfficial;
	private String url="";
	private int likeCounts;
	private long publishTime;
	private String duration;
	
	private int isLiked = 0;
	private String userName="";
	private String publishTimeStr="";
	private String avatarUrl="";
	private String collectionName="";
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public byte getIsOfficial() {
		return isOfficial;
	}
	public void setIsOfficial(byte isOfficial) {
		this.isOfficial = isOfficial;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getLikeCounts() {
		return likeCounts;
	}
	public void setLikeCounts(int likeCounts) {
		this.likeCounts = likeCounts;
	}
	public long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPublishTimeStr() {
		return publishTimeStr;
	}
	public void setPublishTimeStr(String publishTimeStr) {
		this.publishTimeStr = publishTimeStr;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public int getIsLiked() {
		return isLiked;
	}
	public void setIsLiked(int isLiked) {
		this.isLiked = isLiked;
	}
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	
	

}
