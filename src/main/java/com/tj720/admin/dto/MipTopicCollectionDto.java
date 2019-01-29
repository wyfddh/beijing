package com.tj720.admin.dto;

import com.tj720.admin.model.MipOpenCollectionInfo;

public class MipTopicCollectionDto extends MipOpenCollectionInfo{
	
	private String topicCollectionId;
	private int sort;
	private String topicId;
	private String url;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	public String getTopicCollectionId() {
		return topicCollectionId;
	}
	public void setTopicCollectionId(String topicCollectionId) {
		this.topicCollectionId = topicCollectionId;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
	
}
