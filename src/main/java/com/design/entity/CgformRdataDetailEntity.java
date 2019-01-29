package com.design.entity;
import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: cgform_rdata_detail
 * @author onlineGenerator
 * @date 2018-07-02 15:25:11
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cgform_rdata_detail", schema = "")
@SuppressWarnings("serial")
public class CgformRdataDetailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人*/
	private java.lang.String createBy;
	/**创建时间*/
	private java.util.Date createDate;
	/**创建人*/
	private java.lang.String createName;
	/**字段名*/
	private java.lang.String fieldName;
	/**值中文名*/
	private java.lang.String fieldValueCn;
	/**值*/
	private java.lang.String fieldValue;
	/**更新人*/
	private java.lang.String updateBy;
	/**更新时间*/
	private java.util.Date updateDate;
	/**更新人*/
	private java.lang.String updateName;
	/**存储主表id*/
	private java.lang.String masterId;
	/**数据版本号*/
	private java.lang.Integer versionnum;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */
	@Column(name ="CREATE_BY",nullable=true,length=255)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=32)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  字段名
	 */
	@Column(name ="FIELD_NAME",nullable=true,length=32)
	public java.lang.String getFieldName(){
		return this.fieldName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字段名
	 */
	public void setFieldName(java.lang.String fieldName){
		this.fieldName = fieldName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  值中文名
	 */
	@Column(name ="FIELD_VALUE_CN",nullable=true,length=32)
	public java.lang.String getFieldValueCn(){
		return this.fieldValueCn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  值中文名
	 */
	public void setFieldValueCn(java.lang.String fieldValueCn){
		this.fieldValueCn = fieldValueCn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  值
	 */
	@Column(name ="FIELD_VALUE",nullable=true,length=65535)
	public java.lang.String getFieldValue(){
		return this.fieldValue;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  值
	 */
	public void setFieldValue(java.lang.String fieldValue){
		this.fieldValue = fieldValue;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=32)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=32)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  存储主表id
	 */
	@Column(name ="MASTER_ID",nullable=true,length=50)
	public java.lang.String getMasterId(){
		return this.masterId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  存储主表id
	 */
	public void setMasterId(java.lang.String masterId){
		this.masterId = masterId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  数据版本号
	 */
	@Column(name ="VERSIONNUM",nullable=true,length=10)
	public java.lang.Integer getVersionnum(){
		return this.versionnum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  数据版本号
	 */
	public void setVersionnum(java.lang.Integer versionnum){
		this.versionnum = versionnum;
	}
}
