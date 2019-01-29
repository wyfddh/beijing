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
@Table(name = "cgform_define_js", schema = "")
@SuppressWarnings("serial")
public class CgformDefineJsEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**业务编码*/
	private java.lang.String defineCode;
	private java.lang.String nodeCode;
	
	@Column(name ="NODE_CODE",nullable=true,length=100)
	public java.lang.String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(java.lang.String nodeCode) {
		this.nodeCode = nodeCode;
	}

	/**版本号*/
	private java.lang.Integer version;
	/**创建人*/
	private java.lang.String createBy;
	/**创建时间*/
	private java.util.Date createDate;
	/**创建人*/
	private java.lang.String createName;
	private java.lang.String js;

	private java.lang.String json;
	
	@Column(name ="VERSION",nullable=true,length=100)
	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
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
	 *@return: java.lang.String  业务发布id
	 */
	@Column(name ="js",nullable=true,length=50)
	public java.lang.String getJs(){
		return this.js;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务发布id
	 */
	public void setJs(java.lang.String js){
		this.js = js;
	}
	@Column(name ="json",nullable=true,length=50)
	public java.lang.String getJson() {
		return json;
	}

	public void setJson(java.lang.String json) {
		this.json = json;
	}
}
