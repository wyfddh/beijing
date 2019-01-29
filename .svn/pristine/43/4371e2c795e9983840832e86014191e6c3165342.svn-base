package com.design.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 表单自定义按钮
 * @author XXXX
 * @date 2013-08-07 20:16:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cgform_tab", schema = "")
@SuppressWarnings("serial")
public class CgformTabEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**外键关联cgform_head*/
	private java.lang.String formId;
	/**按钮编码*/
	private java.lang.String tabCode;
	/**按钮名称*/
	private java.lang.String tabName;
	/**0:禁用/1:使用*/
	private java.lang.String tabStatus;
	/**顺序*/
	private java.lang.Integer orderNum;
	/**按钮图标样式*/
	private java.lang.String tabIcon;
	
	@Column(name ="DEFINE_CODE",nullable=true,length=32)
	public java.lang.String getDefineCode() {
		return defineCode;
	}

	public void setDefineCode(java.lang.String defineCode) {
		this.defineCode = defineCode;
	}

	private java.lang.String defineCode;
	
	@Column(name ="LINK_BUSS_CODE",nullable=true,length=32)
	public java.lang.String getLinkBussCode() {
		return linkBussCode;
	}

	public void setLinkBussCode(java.lang.String linkBussCode) {
		this.linkBussCode = linkBussCode;
	}
	@Column(name ="MAIN_FIELD",nullable=true,length=32)
	public java.lang.String getMainField() {
		return mainField;
	}

	public void setMainField(java.lang.String mainField) {
		this.mainField = mainField;
	}
	@Column(name ="DETAIL_FIELD",nullable=true,length=32)
	public java.lang.String getDetailField() {
		return detailField;
	}

	public void setDetailField(java.lang.String detailField) {
		this.detailField = detailField;
	}

	private java.lang.String linkBussCode;
	private java.lang.String mainField;
	private java.lang.String detailField;

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
	@Column(name ="FORM_ID",nullable=true,length=32)
	public java.lang.String getFormId(){
		return this.formId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外键关联cgform_head
	 */
	public void setFormId(java.lang.String formId){
		this.formId = formId;
	}
	@Column(name ="TAB_CODE",nullable=true,length=32)
	public java.lang.String getTabCode(){
		return this.tabCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  按钮编码
	 */
	public void setTabCode(java.lang.String tabCode){
		this.tabCode = tabCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  按钮名称
	 */
	@Column(name ="TAB_NAME",nullable=true,length=32)
	public java.lang.String getTabName(){
		return this.tabName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  按钮名称
	 */
	public void setTabName(java.lang.String tabName){
		this.tabName = tabName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  0:禁用/1:使用
	 */
	@Column(name ="TAB_STATUS",nullable=true,length=32)
	public java.lang.String getTabStatus(){
		return this.tabStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  0:禁用/1:使用
	 */
	public void setTabStatus(java.lang.String tabStatus){
		this.tabStatus = tabStatus;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  顺序
	 */
	@Column(name ="ORDER_NUM",nullable=true,length=32)
	public java.lang.Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(java.lang.Integer orderNum) {
		this.orderNum = orderNum;
	}
	@Column(name ="TAB_ICON",nullable=true,length=32)
	public java.lang.String getTabIcon() {
		return tabIcon;
	}

	public void setTabIcon(java.lang.String tabIcon) {
		this.tabIcon = tabIcon;
	}
	
	
}
