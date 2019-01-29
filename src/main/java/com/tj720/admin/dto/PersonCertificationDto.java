package com.tj720.admin.dto;


import com.tj720.mip.vo.BaseVO;

/**
 * 博物馆资料Entity
 * @author chenshiya
 * @version 2018-05-18
 */
public class PersonCertificationDto extends BaseVO{

	private String personId;		// 博物馆人员id
	private String certificationName;		// 证书名称
	private String getTime;		// 获得时间
	private String certificationDescription;		// 证书说明


	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}
	
	public String getCertificationDescription() {
		return certificationDescription;
	}

	public void setCertificationDescription(String certificationDescription) {
		this.certificationDescription = certificationDescription;
	}

	public String getGetTime() {
		return getTime;
	}

	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}
	
}