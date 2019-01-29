package com.tj720.mip.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.SpringContextHolder;
import com.tj720.mip.framework.base.BaseModel;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.service.tool.CacheService;

@Entity
@Table(name="mip_error")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGenerator")
public class Error extends BaseModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMsg;
	private String projectId;
	
	@Column(name="errorCode")
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Column(name="errorMsg")
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	@Column(name="moduleId")
	public String getProjectId() {
		if(projectId == null || projectId.equals("-1"))
			return "";
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	@Transient
	public String getProjectName(){
		ICacheService cacheService = SpringContextHolder.getBean("cacheService", CacheService.class);
		return cacheService.getProject(projectId).getName();
	}
	
}