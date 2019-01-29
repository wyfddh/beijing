package com.tj720.admin.model;

public class MuseumTagInfo {
	private String id;
	private String name;
	private String tag;
	
	
	public MuseumTagInfo(String id, String name, String tag) {
		super();
		this.id = id;
		this.name = name;
		this.tag = tag;
	}
	public MuseumTagInfo() {
		super();
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
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
}
