package com.tj720.admin.dto;

import com.tj720.mip.vo.BaseVO;

/**
 * 博物馆资料Entity
 * @author chenshiya
 * @version 2018-05-18
 */
public class PersonAwardRecordDto extends BaseVO {

	private static final long serialVersionUID = 1L;
	private String personId;		// 人员id
	private String awardName;		// 奖项名称
	private String awardTime;		// 获奖时间
	private String awardDescription;		// 奖项说明
	public String getPersonId() {
		return personId;

	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	
	public String getAwardDescription() {
		return awardDescription;
	}

	public void setAwardDescription(String awardDescription) {
		this.awardDescription = awardDescription;
	}

	public String getAwardTime() {
		return awardTime;
	}

	public void setAwardTime(String awardTime) {
		this.awardTime = awardTime;
	}
	
}