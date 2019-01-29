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
 * @Description: cgform_field_temp
 * @author onlineGenerator
 * @date 2018-07-02 16:09:57
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cgform_field_temp", schema = "")
@SuppressWarnings("serial")
public class CgformFieldTempEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**字段中文名*/
	private java.lang.String content;
	/**创建人*/
	private java.lang.String createBy;
	/**创建时间*/
	private java.util.Date createDate;
	/**创建人中文名*/
	private java.lang.String createName;
	/**字段名*/
	private java.lang.String fieldName;
	/**更新人*/
	private java.lang.String updateBy;
	/**更新时间*/
	private java.util.Date updateDate;
	/**更新人*/
	private java.lang.String updateName;
	/**发布业务id*/
	private java.lang.String bussId;
	/**表单定义id*/
	private java.lang.String defineId;
	/**排序*/
	private java.lang.Integer sort;
	/**对应列表数据存储字段（temp1-50）*/
	private java.lang.String tempField;
	
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
	 *@return: java.lang.String  字段中文名
	 */
	@Column(name ="CONTENT",nullable=true,length=200)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字段中文名
	 */
	public void setContent(java.lang.String content){
		this.content = content;
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
	 *@return: java.lang.String  创建人中文名
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=32)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人中文名
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
	 *@return: java.lang.String  发布业务id
	 */
	@Column(name ="BUSS_ID",nullable=true,length=32)
	public java.lang.String getBussId(){
		return this.bussId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发布业务id
	 */
	public void setBussId(java.lang.String bussId){
		this.bussId = bussId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表单定义id
	 */
	@Column(name ="DEFINE_ID",nullable=true,length=50)
	public java.lang.String getDefineId(){
		return this.defineId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表单定义id
	 */
	public void setDefineId(java.lang.String defineId){
		this.defineId = defineId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序
	 */
	@Column(name ="SORT",nullable=true,length=10)
	public java.lang.Integer getSort(){
		return this.sort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序
	 */
	public void setSort(java.lang.Integer sort){
		this.sort = sort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对应列表数据存储字段（temp1-50）
	 */
	@Column(name ="TEMP_FIELD",nullable=true,length=50)
	public java.lang.String getTempField(){
		return this.tempField;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对应列表数据存储字段（temp1-50）
	 */
	public void setTempField(java.lang.String tempField){
		this.tempField = tempField;
	}
}
