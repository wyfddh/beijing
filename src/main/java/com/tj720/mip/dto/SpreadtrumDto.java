package com.tj720.mip.dto;

import com.tj720.admin.model.MipSpreadtrum;

public class SpreadtrumDto extends MipSpreadtrum{


	private String exhibitionTime; //展期
	private String orgName;//博物馆名称
	
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getExhibitionTime() {
		return exhibitionTime;
	}

	public void setExhibitionTime(String exhibitionTime) {
		this.exhibitionTime = exhibitionTime;
	}
	
}
