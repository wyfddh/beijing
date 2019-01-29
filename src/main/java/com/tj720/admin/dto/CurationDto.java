package com.tj720.admin.dto;

import java.util.List;

import com.tj720.admin.model.Curation;


public class CurationDto extends Curation{
	
	private String userName;
	private String avatarUrl;
	private String timeStr;
	private String imgUrl;
	private List<CurationChapterDto> curationChapterDtos;

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getTimeStr() {
		return timeStr;
	}
	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public List<CurationChapterDto> getCurationChapterDtos() {
		return curationChapterDtos;
	}
	public void setCurationChapterDtos(List<CurationChapterDto> curationChapterDtos) {
		this.curationChapterDtos = curationChapterDtos;
	}
	
}
