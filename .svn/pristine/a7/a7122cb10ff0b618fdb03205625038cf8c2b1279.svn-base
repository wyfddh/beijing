package com.design.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author XXXX 项目附件父表(其他附件表需继承该表)
 */
@Entity
@Table(name = "cgform_attachment")
@Inheritance(strategy = InheritanceType.JOINED)
public class CgformAttachment implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
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
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * 
	 * @since Ver 1.1
	 */

	private static final long serialVersionUID = 1L;
	private String businessKey;// 原始表单ID
	private String subclassname;// 子类名称全路径
	private String attachmenttitle;// 附件名称
	private byte[] attachmentcontent;// 附件内容
	private String realpath;// 附件物理路径
	private Timestamp createdate;
	private String note;
	private String swfpath;// swf格式路径
	private String extend;// 扩展名
	private String infotypeid;// 业务类型
	private String infotypename;// 业务类型
	
	private String attchtype;// 业务类型

	private String detailid;// 直接业务表ID

	/** 创建人ID */
	private java.lang.String createBy;
	/** 创建人 */
	private java.lang.String createName;
	/** 创建日期 */
	private Date createDate;
	/** 更新人ID */
	private java.lang.String updateBy;
	/** 更新人 */
	private java.lang.String updateName;
	/** 更新时间 */
	private Date updateDate;
	

	@Column(name = "DETAILID", length = 32)
	public String getDetailid() {
		return detailid;
	}

	public void setDetailid(String detailid) {
		this.detailid = detailid;
	}

	@Column(name = "ATTCHTYPE", length = 32)
	public String getAttchtype() {
		return attchtype;
	}

	public void setAttchtype(String attchtype) {
		this.attchtype = attchtype;
	}

	@Column(name = "extend", length = 32)
	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}


	@Column(name = "businesskey", length = 32)
	public String getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	@Column(name = "infotypeid", length = 32)
	public String getInfotypeid() {
		return infotypeid;
	}

	public void setInfotypeid(String infotypeid) {
		this.infotypeid = infotypeid;
	}
	
	@Column(name = "infotypename", length = 400)
	public String getInfotypename() {
		return infotypename;
	}

	public void setInfotypename(String infotypename) {
		this.infotypename = infotypename;
	}


	@Column(name = "attachmenttitle", length = 100)
	public String getAttachmenttitle() {
		return this.attachmenttitle;
	}

	public void setAttachmenttitle(String attachmenttitle) {
		this.attachmenttitle = attachmenttitle;
	}

	@Column(name = "attachmentcontent", length = 3000)
	@Lob
	public byte[] getAttachmentcontent() {
		return this.attachmentcontent;
	}

	public void setAttachmentcontent(byte[] attachmentcontent) {
		this.attachmentcontent = attachmentcontent;
	}

	@Column(name = "realpath", length = 100)
	public String getRealpath() {
		return this.realpath;
	}

	public void setRealpath(String realpath) {
		this.realpath = realpath;
	}

	@Column(name = "createdate", length = 35)
	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	@Column(name = "note", length = 300)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "swfpath", length = 300)
	public String getSwfpath() {
		return this.swfpath;
	}

	public void setSwfpath(String swfpath) {
		this.swfpath = swfpath;
	}

	@Column(name = "subclassname", length = 300)
	public String getSubclassname() {
		return subclassname;
	}

	public void setSubclassname(String subclassname) {
		this.subclassname = subclassname;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 创建人ID
	 */
	@Column(name = "CREATE_BY", nullable = true, length = 40)
	public java.lang.String getCreateBy() {
		return this.createBy;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 创建人ID
	 */
	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 创建人
	 */
	@Column(name = "CREATE_NAME", nullable = true, length = 100)
	public java.lang.String getCreateName() {
		return this.createName;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 创建人
	 */
	public void setCreateName(java.lang.String createName) {
		this.createName = createName;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 创建日期
	 */
	@Column(name = "CREATE_DATE", nullable = true)
	public Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 更新时间
	 */
	@Column(name = "UPDATE_DATE", nullable = true)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 更新人ID
	 */
	@Column(name = "UPDATE_BY", nullable = true, length = 40)
	public java.lang.String getUpdateBy() {
		return this.updateBy;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 更新人ID
	 */
	public void setUpdateBy(java.lang.String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 更新人
	 */
	@Column(name = "UPDATE_NAME", nullable = true, length = 100)
	public java.lang.String getUpdateName() {
		return this.updateName;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 更新人
	 */
	public void setUpdateName(java.lang.String updateName) {
		this.updateName = updateName;
	}

}