package com.tj720.mip.dto;

import java.io.Serializable;

public class CollectionDto implements Serializable {
	
	private String id;
	private String name;
	private String pictureThumb;//缩略图url
	private String type;
	private String collectTime;//收藏时间
	private String pictureUrl;//原图url
	
	public CollectionDto() {
		super();
	}
	
	public CollectionDto(String id, String name, String pictureThumb, String type, String collectTime,
			String pictureUrl) {
		super();
		this.id = id;
		this.name = name;
		this.pictureThumb = pictureThumb;
		this.type = type;
		this.collectTime = collectTime;
		this.pictureUrl = pictureUrl;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPictureThumb() {
		return pictureThumb;
	}
	public void setPictureThumb(String pictureThumb) {
		this.pictureThumb = pictureThumb;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	

}
