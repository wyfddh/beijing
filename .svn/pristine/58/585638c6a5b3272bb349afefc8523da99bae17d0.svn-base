package com.design.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OrderBy;

/**   
 * @Title: Entity
 * @Description: cgform_define
 * @author onlineGenerator
 * @date 2018-06-28 17:34:16
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cgform_define", schema = "")
@SuppressWarnings("serial")
public class CgformDefineEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**业务编码*/
	private java.lang.String defineCode;
	/**业务名称*/
	private java.lang.String defineName;
	/**主表*/
	private java.lang.String mtableName;
	/**流程key*/
	private java.lang.String processKey;
	/**流程名称*/
	private java.lang.String processName;
	/**打印模板ID*/
	private java.lang.String printId;
	/**版本号-同流程版本（0代表基础版本）*/
	private java.lang.Integer versionnum;
	/**状态*/
	private java.lang.String status;
	/**列表显示风格*/
	private java.lang.String listStyle;
	/**分类*/
	private java.lang.String type;
	/**创建人*/
	private java.lang.String createBy;
	/**创建时间*/
	private java.util.Date createDate;
	/**创建人*/
	private java.lang.String createName;
	/**业务分类*/
	private java.lang.String bussType;
	/**存储方式（1建表存储、2键值存储）*/
	private java.lang.String saveType;
	private java.lang.String bussId;
	private String resourceId;
	
	/**
	 * 表格列属性
	 */
	private List<CgFormLgFieldEntity> columns;
	
	@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="define_id")
	@OrderBy(clause = "orderNum asc")
	public List<CgFormLgFieldEntity> getColumns() {
		return columns;
	}

	public void setColumns(List<CgFormLgFieldEntity> columns) {
		this.columns = columns;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=40)
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
	 *@return: java.lang.String  业务编码
	 */
	@Column(name ="DEFINE_CODE",nullable=true,length=100)
	public java.lang.String getDefineCode(){
		return this.defineCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务编码
	 */
	public void setDefineCode(java.lang.String defineCode){
		this.defineCode = defineCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务名称
	 */
	@Column(name ="DEFINE_NAME",nullable=true,length=100)
	public java.lang.String getDefineName(){
		return this.defineName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务名称
	 */
	public void setDefineName(java.lang.String defineName){
		this.defineName = defineName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主表
	 */
	@Column(name ="MTABLE_NAME",nullable=true,length=100)
	public java.lang.String getMtableName(){
		return this.mtableName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主表
	 */
	public void setMtableName(java.lang.String mtableName){
		this.mtableName = mtableName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程key
	 */
	@Column(name ="PROCESS_KEY",nullable=true,length=40)
	public java.lang.String getProcessKey(){
		return this.processKey;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程key
	 */
	public void setProcessKey(java.lang.String processKey){
		this.processKey = processKey;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程名称
	 */
	@Column(name ="PROCESS_NAME",nullable=true,length=200)
	public java.lang.String getProcessName(){
		return this.processName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程名称
	 */
	public void setProcessName(java.lang.String processName){
		this.processName = processName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  打印模板ID
	 */
	@Column(name ="PRINT_ID",nullable=true,length=40)
	public java.lang.String getPrintId(){
		return this.printId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  打印模板ID
	 */
	public void setPrintId(java.lang.String printId){
		this.printId = printId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  版本号-同流程版本（0代表基础版本）
	 */
	@Column(name ="VERSIONNUM",nullable=false,length=10)
	public java.lang.Integer getVersionnum(){
		return this.versionnum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  版本号-同流程版本（0代表基础版本）
	 */
	public void setVersionnum(java.lang.Integer versionnum){
		this.versionnum = versionnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	@Column(name ="STATUS",nullable=true,length=32)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  列表显示风格
	 */
	@Column(name ="LIST_STYLE",nullable=true,length=32)
	public java.lang.String getListStyle(){
		return this.listStyle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  列表显示风格
	 */
	public void setListStyle(java.lang.String listStyle){
		this.listStyle = listStyle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分类
	 */
	@Column(name ="TYPE",nullable=true,length=10)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */
	@Column(name ="CREATE_BY",nullable=true,length=32)
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
	 *@return: java.lang.String  业务分类
	 */
	@Column(name ="BUSS_TYPE",nullable=true,length=10)
	public java.lang.String getBussType(){
		return this.bussType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务分类
	 */
	public void setBussType(java.lang.String bussType){
		this.bussType = bussType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  存储方式（1建表存储、2键值存储）
	 */
	@Column(name ="SAVE_TYPE",nullable=true,length=10)
	public java.lang.String getSaveType(){
		return this.saveType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  存储方式（1建表存储、2键值存储）
	 */
	public void setSaveType(java.lang.String saveType){
		this.saveType = saveType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务发布id
	 */
	@Column(name ="buss_id",nullable=true,length=50)
	public java.lang.String getBussId(){
		return this.bussId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务发布id
	 */
	public void setBussId(java.lang.String bussId){
		this.bussId = bussId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务发布id
	 */
	@Column(name ="resource_id",nullable=true,length=50)
	public java.lang.String getResourceId(){
		return this.resourceId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务发布id
	 */
	public void setResourceId(java.lang.String resourceId){
		this.resourceId = resourceId;
	}
}
