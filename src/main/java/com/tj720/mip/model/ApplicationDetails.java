/** 
 * <pre>项目名称:mip 
 * 文件名称:IbscApplicationDetails.java 
 * 包名:com.tj720.mip.model 
 * 创建日期:2017年1月20日下午4:45:12 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.framework.base.BaseModel;

/** 
 * <pre>项目名称：mip    
 * 类名称：IbscApplicationDetails    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月20日 下午4:45:12    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月20日 下午4:45:12    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name = "mip_lbsc_application_details")
@GenericGenerator(name = "Generator", strategy = "com.tj720.mip.framework.IdGenerator")
public class ApplicationDetails extends BaseModel {
	private static final long serialVersionUID = 1L;
	private String tableName;//表名
	private byte objectId;//博物馆或者藏品的id
	private Integer auditingId;//审核id
	private String key;//字段名称
	private String value;//字段值
	private String oldValue;//旧字段值
	private String textValue;//文本字段值
	private String oldTextValue;//旧文本字段值
	private Date createdTime;//创建时间
	private Date updatedTime;//最后修改时间
	
	@Column(name = "table_name")
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	@Column(name = "object_id")
	public byte getObjectId() {
		return objectId;
	}
	public void setObjectId(byte objectId) {
		this.objectId = objectId;
	}
	@Column(name = "auditing_id")
	public Integer getAuditingId() {
		return auditingId;
	}
	public void setAuditingId(Integer auditingId) {
		this.auditingId = auditingId;
	}
	@Column(name = "key")
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Column(name = "value")
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Column(name = "old_value")
	public String getOldValue() {
		return oldValue;
	}
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	@Column(name = "text_value")
	public String getTextValue() {
		return textValue;
	}
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}
	@Column(name = "old_text_value")
	public String getOldTextValue() {
		return oldTextValue;
	}
	public void setOldTextValue(String oldTextValue) {
		this.oldTextValue = oldTextValue;
	}
	@Column(name = "created_time")
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Column(name = "updated_time")
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	/**    
	 * <pre>创建一个新的实例 LbscApplicationDetails.    
	 *    
	 * @param tableName
	 * @param objectId
	 * @param auditingId
	 * @param key
	 * @param value
	 * @param oldValue
	 * @param textValue
	 * @param oldTextValue
	 * @param createdTime
	 * @param updatedTime</pre>    
	 */
	public ApplicationDetails(String tableName, byte objectId, Integer auditingId, String key, String value,
			String oldValue, String textValue, String oldTextValue, Date createdTime, Date updatedTime) {
		super();
		this.tableName = tableName;
		this.objectId = objectId;
		this.auditingId = auditingId;
		this.key = key;
		this.value = value;
		this.oldValue = oldValue;
		this.textValue = textValue;
		this.oldTextValue = oldTextValue;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}
	   
	/**    
	 * <pre>创建一个新的实例 LbscApplicationDetails.    
	 *    </pre>    
	 */
	public ApplicationDetails() {
		super();
	}
	   
	
	
	
	
	
}
