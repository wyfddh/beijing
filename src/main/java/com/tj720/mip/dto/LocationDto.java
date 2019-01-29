package com.tj720.mip.dto;

import java.util.List;

public class LocationDto {
	
	private int status;
	private List<LatLong> result;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<LatLong> getResult() {
		return result;
	}
	public void setResult(List<LatLong> result) {
		this.result = result;
	}
	public LocationDto(int status, List<LatLong> result) {
		super();
		this.status = status;
		this.result = result;
	}
	public LocationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
