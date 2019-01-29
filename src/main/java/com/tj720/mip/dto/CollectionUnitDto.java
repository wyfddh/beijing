package com.tj720.mip.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.tj720.mip.model.MipOrganization;


public class CollectionUnitDto implements Serializable {
	
	private  String cityName;//市
	private  Long museumCount;//每个市的博物馆的数量
	private  List<MipOrganization> museumList;//每个市下面的博物馆的集合
	//private  String museumId;//博物馆id
	
	/*public String getMuseumId() {
		return museumId;
	}
	public void setMuseumId(String museumId) {
		this.museumId = museumId;
	}*/
	public CollectionUnitDto(String cityName, Long museumCount, List<MipOrganization> museumList) {
		super();
		this.cityName = cityName;
		this.museumCount = museumCount;
		this.museumList = museumList;
	}
	public CollectionUnitDto() {
		super();
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Long getMuseumCount() {
		return museumCount;
	}
	public void setMuseumCount(Long museumCount) {
		this.museumCount = museumCount;
	}
	public List<MipOrganization> getMuseumList() {
		return museumList;
	}
	public void setMuseumList(List<MipOrganization> museumList) {
		this.museumList = museumList;
	}
	
	

}
