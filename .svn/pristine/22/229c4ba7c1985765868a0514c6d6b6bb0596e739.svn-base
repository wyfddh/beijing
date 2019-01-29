package com.design.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: t_s_buss_template
 * @author onlineGenerator
 * @date 2017-12-05 11:40:51
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_buss_template", schema = "")
@SuppressWarnings("serial")
public class TSBussTemplateEntity implements java.io.Serializable {
	/**ID*/
	private java.lang.String id;
//	/**业务配置表ID*/
//	private CgformDefineEntity TSConfigform;
//	private java.lang.String configformId;
	/**模板名称*/
	private java.lang.String templateName;
	/**备注*/
	private java.lang.String remark;
	/**模板类型-基础模板0/自定义模板1*/
	private java.lang.String templateType;
	/**状态-启用1/停用0*/
	private java.lang.String status;
	/**创建人ID*/
	private java.lang.String createBy;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人ID*/
	private java.lang.String updateBy;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新时间*/
	private java.util.Date updateDate;
	/**模板类型-样式类型-通用TY/公文GW*/
	private java.lang.String cssType;
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  样式类型-通用TY/公文GW
	 */
	@Column(name ="CSS_TYPE",nullable=true,length=100)
	public java.lang.String getCssType(){
		return this.cssType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  样式类型-通用TY/公文GW
	 */
	public void setCssType(java.lang.String cssType){
		this.cssType = cssType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ID
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
	 *@param: java.lang.String  ID
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
//	/**
//	 *方法: 取得java.lang.String
//	 *@return: java.lang.String  业务配置表ID
//	 */
//	@Column(name ="CONFIGFORM_ID",nullable=true,length=32)
//	public java.lang.String getConfigformId(){
//		return this.configformId;
//	}
//
//	/**
//	 *方法: 设置java.lang.String
//	 *@param: java.lang.String  业务配置表ID
//	 */
//	public void setConfigformId(java.lang.String configformId){
//		this.configformId = configformId;
//	}
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "CONFIGFORM_ID")
//	public CgformDefineEntity getTSConfigform() {
//		return this.TSConfigform;
//	}
//
//	public void setTSConfigform(CgformDefineEntity TSConfigform) {
//		this.TSConfigform = TSConfigform;
//	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模板名称
	 */
	@Column(name ="TEMPLATE_NAME",nullable=true,length=100)
	public java.lang.String getTemplateName(){
		return this.templateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模板名称
	 */
	public void setTemplateName(java.lang.String templateName){
		this.templateName = templateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=400)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模板类型-基础模板0/自定义模板1
	 */
	@Column(name ="TEMPLATE_TYPE",nullable=true,length=1)
	public java.lang.String getTemplateType(){
		return this.templateType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模板类型-基础模板0/自定义模板1
	 */
	public void setTemplateType(java.lang.String templateType){
		this.templateType = templateType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态-启用1/停用0
	 */
	@Column(name ="STATUS",nullable=true,length=400)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态-启用1/停用0
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人ID
	 */
	@Column(name ="CREATE_BY",nullable=true,length=32)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人ID
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=100)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人ID
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=32)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人ID
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=100)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
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
}
