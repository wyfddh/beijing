package com.tj720.mip.dto;


public class FullTextSearchDto {
	private String id;
	private String name;//标题
	private String content;//内容
	private String type;//1 藏品  2 博物馆 3展览展讯  4虚拟展厅  5资讯公告  6学术书刊 7学术论文 8专家舞台  9讲座  10活动
	private String url; //学刊下载地址、虚拟展厅地址
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	
}
