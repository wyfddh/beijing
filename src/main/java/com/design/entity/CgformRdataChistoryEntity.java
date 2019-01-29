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
 * @Description: cgform_rdata_chistory
 * @author onlineGenerator
 * @date 2018-07-02 15:25:03
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cgform_rdata_chistory", schema = "")
@SuppressWarnings("serial")
public class CgformRdataChistoryEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**存储主表id*/
	private java.lang.String masterId;
	/**字段名*/
	private java.lang.String fieldName;
	/**旧值*/
	private java.lang.String oldValue;
	/**旧值备注*/
	private java.lang.String oldValueRem;
	/**新值*/
	private java.lang.String newValue;
	/**新值备注*/
	private java.lang.String newValueRem;
	/**创建人*/
	private java.lang.String createBy;
	/**创建时间*/
	private java.util.Date createDate;
	/**创建人*/
	private java.lang.String createName;
	/**updateBy*/
	private java.lang.String updateBy;
	/**updateName*/
	private java.lang.String updateName;
	/**updateDate*/
	private java.util.Date updateDate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  存储主表id
	 */
	@Column(name ="MASTER_ID",nullable=true,length=32)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  字段名
	 */
	@Column(name ="FIELD_NAME",nullable=true,length=100)
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
	 *@return: java.lang.String  旧值
	 */
	@Column(name ="OLD_VALUE",nullable=true,length=4000)
	public java.lang.String getOldValue(){
		return this.oldValue;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  旧值
	 */
	public void setOldValue(java.lang.String oldValue){
		this.oldValue = oldValue;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  旧值备注
	 */
	@Column(name ="OLD_VALUE_REM",nullable=true,length=4000)
	public java.lang.String getOldValueRem(){
		return this.oldValueRem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  旧值备注
	 */
	public void setOldValueRem(java.lang.String oldValueRem){
		this.oldValueRem = oldValueRem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新值
	 */
	@Column(name ="NEW_VALUE",nullable=true,length=4000)
	public java.lang.String getNewValue(){
		return this.newValue;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新值
	 */
	public void setNewValue(java.lang.String newValue){
		this.newValue = newValue;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新值备注
	 */
	@Column(name ="NEW_VALUE_REM",nullable=true,length=4000)
	public java.lang.String getNewValueRem(){
		return this.newValueRem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新值备注
	 */
	public void setNewValueRem(java.lang.String newValueRem){
		this.newValueRem = newValueRem;
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
	 *@return: java.lang.String  updateBy
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=40)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  updateBy
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  updateName
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=100)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  updateName
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  updateDate
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  updateDate
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
}
