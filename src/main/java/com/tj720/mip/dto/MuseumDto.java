package com.tj720.mip.dto;

public class MuseumDto {
	
	private String id;
	private String name;
	private String infoId;
	private String picUrl;
	private int clickCounts;
	private double distance;
	
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
	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public int getClickCounts() {
		return clickCounts;
	}
	public void setClickCounts(int clickCounts) {
		this.clickCounts = clickCounts;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public MuseumDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MuseumDto(String id, String name, String infoId, String picUrl, int clickCounts) {
		super();
		this.id = id;
		this.name = name;
		this.infoId = infoId;
		this.picUrl = picUrl;
		this.clickCounts = clickCounts;
	}
	public MuseumDto(String id, String name, String infoId, int clickCounts) {
		super();
		this.id = id;
		this.name = name;
		this.infoId = infoId;
		this.clickCounts = clickCounts;
	}
	public MuseumDto(String id, String name, String infoId, String picUrl, int clickCounts, int distance) {
		super();
		this.id = id;
		this.name = name;
		this.infoId = infoId;
		this.picUrl = picUrl;
		this.clickCounts = clickCounts;
		this.distance = distance;
	}
	
	

}
