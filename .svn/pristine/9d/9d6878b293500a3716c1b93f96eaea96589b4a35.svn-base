package com.design.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OrderBy;

/**
 * @Title: Entity
 * @Description: 自动生成表属性
 * @author jueyue
 * @date 2013-06-30 11:36:53
 * @version V1.0
 * 
 */
@Entity
@Table(name = "cgform_lg_head", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class CgFormLgHeadEntity implements java.io.Serializable {
	/** id */
	private java.lang.String id;
	/** 表格名称 */
	private java.lang.String tableName;
	/** dategrid是否为树形 */
	private java.lang.String isTree;
	/** datagrid是否分页 */
	private java.lang.String isPagination;
	/** 是否同步了数据库 */
	private java.lang.String isDbSynch;
	/** datagrid是否显示复选框 */
	private java.lang.String isCheckbox;
	/** 查询模式：single(单条件查询：默认),group(组合查询) */
	private java.lang.String querymode;
	/** 功能注释 */
	private java.lang.String content;
	/** 创建时间 */
	private java.util.Date createDate;
	/** 创建人ID */
	private java.lang.String createBy;
	/** 创建人 */
	private java.lang.String createName;
	/** 修改时间 */
	private java.util.Date updateDate;
	/** 修改人 */
	private java.lang.String updateBy;
	/** 修改人 */
	private java.lang.String updateName;
	/** 表单版本 */
	private java.lang.String jformVersion;
	/** 表单类型 */
	private Integer jformType;
	/** 表单主键策略 */
	private java.lang.String jformPkType;
	/** 表单主键策略-序列(针对oracle等数据库) */
	private java.lang.String jformPkSequence;
	/** 附表关联类型 */
	private Integer relationType;
	/** 附表清单 */
	private String subTableStr;

	/** 一对多Tab顺序 */
	private Integer tabOrder;

	/** 业务类型 */
	private java.lang.String businessType;

	private java.lang.String isMustExist;// varchar2(10) y 是否必须填报数据

	private Integer mustExistCount;// number(11) y 填报数据的条数
	private java.lang.String editUrl;// varchar2(100) y 编辑url
	private java.lang.String viewUrl;// varchar2(100) y 查询url

	/** 用于松耦合设计，可以对单表和主表都形成父子关系 */
	private String subTableName;

	/** 用于显示的名称 */
	private String showTableDesc;

	/** 一对多Tab顺序 */
	private Integer subTabOrder;
	
	/** 业务编码 */
	private java.lang.String bussCode;
	private java.lang.String bussName;
	
	private java.lang.Integer versionNum;
	@Column(name = "VERSIONNUM", length = 11)
	public Integer getVersionNum() {
		return versionNum;
	}
	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}
	@Column(name ="BUSS_NAME",nullable=true,length=1)
	public java.lang.String getBussName() {
		return bussName;
	}

	public void setBussName(java.lang.String bussName) {
		this.bussName = bussName;
	}

	@Column(name ="BUSS_CODE",nullable=true,length=1)
	public java.lang.String getBussCode() {
		return bussCode;
	}

	public void setBussCode(java.lang.String bussCode) {
		this.bussCode = bussCode;
	}

	/**
	 * 方法: 取得java.lang.String varchar2(10) y 是否必须填报数据
	 * 
	 * @return: java.lang.String
	 */
	@Column(name = "is_must_exist", nullable = false, length = 10)
	public java.lang.String getIsMustExist() {
		return isMustExist;
	}

	public void setIsMustExist(java.lang.String isMustExist) {
		this.isMustExist = isMustExist;
	}

	/**
	 * 方法: 取得java.lang.String number(11) y 填报数据的条数
	 * 
	 * @return: Integer
	 */
	@Column(name = "must_exist_count", nullable = false, length = 11)
	public Integer getMustExistCount() {
		return mustExistCount;
	}

	public void setMustExistCount(Integer mustExistCount) {
		this.mustExistCount = mustExistCount;
	}

	/**
	 * 方法: 取得java.lang.String varchar2(100) y 编辑url
	 * 
	 * @return: String
	 */
	@Column(name = "edit_url", nullable = false, length = 100)
	public java.lang.String getEditUrl() {
		return editUrl;
	}

	public void setEditUrl(java.lang.String editUrl) {
		this.editUrl = editUrl;
	}

	/**
	 * 方法: 取得java.lang.String varchar2(100) y 查看url
	 * 
	 * @return: String
	 */
	@Column(name = "view_url", nullable = false, length = 100)
	public java.lang.String getViewUrl() {
		return viewUrl;
	}

	public void setViewUrl(java.lang.String viewUrl) {
		this.viewUrl = viewUrl;
	}

//	/**
//	 * 表格列属性
//	 */
//	private List<CgFormLgFieldEntity> columns;

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String id
	 */

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "id", nullable = false, length = 32)
	public java.lang.String getId() {
		return this.id;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String id
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 业务类型
	 */
	@Column(name = "business_type", nullable = false, length = 20)
	public java.lang.String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(java.lang.String businessType) {
		this.businessType = businessType;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 表格名称
	 */
	@Column(name = "table_name", nullable = false, length = 20)
	public java.lang.String getTableName() {
		return this.tableName;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 表格名称
	 */
	public void setTableName(java.lang.String tableName) {
		this.tableName = tableName;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String dategrid是否为树形
	 */
	@Column(name = "is_tree", nullable = false, length = 5)
	public java.lang.String getIsTree() {
		return this.isTree;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String dategrid是否为树形
	 */
	public void setIsTree(java.lang.String isTree) {
		this.isTree = isTree;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String datagrid是否分页
	 */
	@Column(name = "is_pagination", nullable = false, length = 5)
	public java.lang.String getIsPagination() {
		return this.isPagination;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String datagrid是否分页
	 */
	public void setIsPagination(java.lang.String isPagination) {
		this.isPagination = isPagination;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 是否同步了数据库
	 */
	@Column(name = "is_dbsynch", nullable = false, length = 20)
	public java.lang.String getIsDbSynch() {
		return this.isDbSynch;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 是否同步了数据库
	 */
	public void setIsDbSynch(java.lang.String isDbSynch) {
		this.isDbSynch = isDbSynch;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String datagrid是否显示复选框
	 */
	@Column(name = "is_checkbox", nullable = false, length = 5)
	public java.lang.String getIsCheckbox() {
		return this.isCheckbox;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String datagrid是否显示复选框
	 */
	public void setIsCheckbox(java.lang.String isCheckbox) {
		this.isCheckbox = isCheckbox;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 查询模式：single(单条件查询：默认),group(组合查询)
	 */
	@Column(name = "querymode", nullable = false, length = 10)
	public java.lang.String getQuerymode() {
		return this.querymode;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 查询模式：single(单条件查询：默认),group(组合查询)
	 */
	public void setQuerymode(java.lang.String querymode) {
		this.querymode = querymode;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 功能注释
	 */
	@Column(name = "content", nullable = false, length = 200)
	public java.lang.String getContent() {
		return this.content;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 功能注释
	 */
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 创建时间
	 */
	@Column(name = "create_date", nullable = true)
	public java.util.Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 创建时间
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 创建人ID
	 */
	@Column(name = "create_by", nullable = true, length = 32)
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
	@Column(name = "create_name", nullable = true, length = 32)
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
	 * @return: java.util.Date 修改时间
	 */
	@Column(name = "update_date", nullable = true)
	public java.util.Date getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 修改时间
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 修改人ID
	 */
	@Column(name = "update_by", nullable = true, length = 32)
	public java.lang.String getUpdateBy() {
		return this.updateBy;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 修改人ID
	 */
	public void setUpdateBy(java.lang.String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 修改人
	 */
	@Column(name = "update_name", nullable = true, length = 32)
	public java.lang.String getUpdateName() {
		return this.updateName;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 修改人
	 */
	public void setUpdateName(java.lang.String updateName) {
		this.updateName = updateName;
	}

//	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "table")
//	@OrderBy(clause = "orderNum asc")
//	public List<CgFormLgFieldEntity> getColumns() {
//		return columns;
//	}
//
//	public void setColumns(List<CgFormLgFieldEntity> columns) {
//		this.columns = columns;
//	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 表单版本号
	 */
	@Column(name = "jform_version", nullable = false, length = 10)
	public java.lang.String getJformVersion() {
		return jformVersion;
	}

	public void setJformVersion(java.lang.String jformVersion) {
		this.jformVersion = jformVersion;
	}

	/**
	 * 方法: 取得Integer 1-单表,2-主表,3-从表
	 * 
	 * @return: INteger 表单类型
	 */
	@Column(name = "jform_type", nullable = false, length = 1)
	public Integer getJformType() {
		return jformType;
	}

	public void setJformType(Integer jformType) {
		this.jformType = jformType;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 主键策略
	 */
	@Column(name = "jform_pk_type", nullable = true, length = 100)
	public java.lang.String getJformPkType() {
		return jformPkType;
	}

	public void setJformPkType(java.lang.String jformPkType) {
		this.jformPkType = jformPkType;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 主键策略-序列
	 */
	@Column(name = "jform_pk_sequence", nullable = true, length = 200)
	public java.lang.String getJformPkSequence() {
		return jformPkSequence;
	}

	public void setJformPkSequence(java.lang.String jformPkSequence) {
		this.jformPkSequence = jformPkSequence;
	}

	@Column(name = "sub_table_str", nullable = true, length = 1000)
	public String getSubTableStr() {
		return subTableStr;
	}

	public void setSubTableStr(String subTableStr) {
		this.subTableStr = subTableStr;
	}

	@Column(name = "sub_table_name", nullable = true, length = 1000)
	public String getSubTableName() {
		return subTableName;
	}

	public void setSubTableName(String subTableName) {
		this.subTableName = subTableName;
	}

	@Column(name = "show_table_desc", nullable = true, length = 1000)
	public String getShowTableDesc() {
		return showTableDesc;
	}

	public void setShowTableDesc(String showTableDesc) {
		this.showTableDesc = showTableDesc;
	}

	/**
	 * 方法: 取得Integer 0：一对多 1：一对一
	 * 
	 * @return: INteger 附表关联类型
	 */
	@Column(name = "relation_type", nullable = true, length = 1)
	public Integer getRelationType() {
		return relationType;
	}

	public void setRelationType(Integer relationType) {
		this.relationType = relationType;
	}

	@Column(name = "tab_order", nullable = true, length = 1)
	public Integer getTabOrder() {
		return tabOrder;
	}

	public void setTabOrder(Integer tabOrder) {
		this.tabOrder = tabOrder;
	}

	@Column(name = "sub_tab_order", nullable = true, length = 1)
	public Integer getSubTabOrder() {
		return subTabOrder;
	}

	public void setSubTabOrder(Integer subTabOrder) {
		this.subTabOrder = subTabOrder;
	}
}
