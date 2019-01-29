package com.tj720.mip.dto;

import java.io.Serializable;
import java.util.List;

public class RelicCountDto implements Serializable {
	
	private String cityName;//市
	private Long relicCount;//每个市可移动文物数量
	private List<MuseumRelicCountDto> museumRelicCountList;//博物馆文物数量集合
	
	public List<MuseumRelicCountDto> getMuseumRelicCountList() {
		return museumRelicCountList;
	}
	public void setMuseumRelicCountList(List<MuseumRelicCountDto> museumRelicCountList) {
		this.museumRelicCountList = museumRelicCountList;
	}
	public RelicCountDto(String cityName, Long relicCount, List<MuseumRelicCountDto> museumRelicCountList) {
		super();
		this.cityName = cityName;
		this.relicCount = relicCount;
		this.museumRelicCountList = museumRelicCountList;
	}
	//private Long museumRelicCount;//每个博物馆可移动文物的数量
	//private String museumName;//博物馆名称
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Long getRelicCount() {
		return relicCount;
	}
	public void setRelicCount(Long relicCount) {
		this.relicCount = relicCount;
	}
	/*public Long getMuseumRelicCount() {
		return museumRelicCount;
	}
	public void setMuseumRelicCount(Long museumRelicCount) {
		this.museumRelicCount = museumRelicCount;
	}
	public String getMuseumName() {
		return museumName;
	}
	public void setMuseumName(String museumName) {
		this.museumName = museumName;
	}*/
	public RelicCountDto() {
		super();
	}
	public RelicCountDto(String cityName, Long relicCount) {
		super();
		this.cityName = cityName;
		this.relicCount = relicCount;
		/*this.museumRelicCount = museumRelicCount;
		this.museumName = museumName;
*/	}
	
	
	

}
