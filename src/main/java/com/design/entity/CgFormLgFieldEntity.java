package com.design.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**
 * @Title: Entity
 * @Description: 自动生成表的列属性
 * @author jueyue
 * @date 2013-06-30 11:37:32
 * @version V1.0
 * 
 */
@Entity
@Table(name = "cgform_lg_field", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@JsonAutoDetect
@SuppressWarnings("serial")
public class CgFormLgFieldEntity implements java.io.Serializable {
	/** id */
	private java.lang.String id;
	/** 字段名称 */
	private java.lang.String fieldName;
	private java.lang.String fieldRemark;
//	/** 关联的表 */
//	private CgFormLgHeadEntity table;
	/** 字段长度 */
	private java.lang.Integer length;
	/** 小数点长度 */
	private java.lang.Integer pointLength;
	/** 字段类型 */
	private java.lang.String type;
	/** 是否允许空值 */
	private java.lang.String isNull;
	/** 在表中的顺序 */
	private java.lang.Integer orderNum;
	/** 是否主键 */
	private java.lang.String isKey;
	/** 是否显示 */
	private java.lang.String isShow;
	/** 是否在列表上显示 */
	private java.lang.String isShowList;
	/** 显示类型 */
	private java.lang.String showType;
	/** 是否生产查询字段 */
	private java.lang.String isQuery;
	/** 控件长度 */
	private java.lang.Integer fieldLength;
	/** 字段Href */
	private java.lang.String fieldHref;
	/** 控件校验 */
	private java.lang.String fieldValidType;
	/** 查询类型single(默认：单字段查询),group(范围查询) */
	private java.lang.String queryMode;
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
	/** 修改人ID */
	private java.lang.String updateBy;
	/** 修改人 */
	private java.lang.String updateName;
	/** 字典Code */
	private java.lang.String dictField;
	/** 字典Table */
	private java.lang.String dictTable;
	/** 字典Text */
	private java.lang.String dictText;
	/** 主表名 */
	private java.lang.String mainTable;
	/** 主表字段 */
	private java.lang.String mainField;
	/** 旧的字段名称 */
	private java.lang.String oldFieldName;
	/** 字段默认值 */
	private java.lang.String fieldDefault;

	/** 字段填写提醒 */
	private java.lang.String fieldAlert;
	
	
	/**是否图文模式显示*/
	private java.lang.String isImagelist;
	/**是否简明模式显示*/
	private java.lang.String isSimple;
	/**能否编辑*/
	private java.lang.String isEdit;
	private java.lang.String isListHide;
	private java.lang.String deleteflag;
	private java.lang.String detailField;
	
	private java.lang.String windowHeight;
	private java.lang.String windowWidth;
	private java.lang.String inputId;
	private java.lang.String selectId;
	private java.lang.String defineId;
	
	private java.lang.String isIndex;
	private String bussId;
	
	

	@Column(name ="DEFINE_ID",nullable=true,length=50)
	public java.lang.String getDefineId() {
		return defineId;
	}

	public void setDefineId(java.lang.String defineId) {
		this.defineId = defineId;
	}
	
	@Column(name ="IS_INDEX",nullable=true,length=50)
	public java.lang.String getIsIndex() {
		return isIndex;
	}

	public void setIsIndex(java.lang.String isIndex) {
		this.isIndex = isIndex;
	}
	private java.lang.String wherePara;
	@Column(name ="WHERE_PARA",nullable=true,length=50)
	public java.lang.String getWherePara() {
		return wherePara;
	}

	public void setWherePara(java.lang.String wherePara) {
		this.wherePara = wherePara;
	}
	@Column(name ="WINDOW_HEIGHT",nullable=true,length=50)
	public java.lang.String getWindowHeight() {
		return windowHeight;
	}

	public void setWindowHeight(java.lang.String windowHeight) {
		this.windowHeight = windowHeight;
	}
	@Column(name ="WINDOW_WIDTH",nullable=true,length=50)
	public java.lang.String getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(java.lang.String windowWidth) {
		this.windowWidth = windowWidth;
	}
	@Column(name ="INPUT_ID",nullable=true,length=50)
	public java.lang.String getInputId() {
		return inputId;
	}

	public void setInputId(java.lang.String inputId) {
		this.inputId = inputId;
	}
	@Column(name ="SELECT_ID",nullable=true,length=50)
	public java.lang.String getSelectId() {
		return selectId;
	}

	public void setSelectId(java.lang.String selectId) {
		this.selectId = selectId;
	}

	
	
	@Column(name ="DETAIL_FIELD",nullable=true,length=50)
	public java.lang.String getDetailField() {
		return detailField;
	}

	public void setDetailField(java.lang.String detailField) {
		this.detailField = detailField;
	}
	
	@Column(name ="DELETEFLAG",nullable=true,length=10)
	public java.lang.String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(java.lang.String deleteflag) {
		this.deleteflag = deleteflag;
	}

	@Column(name ="IS_LIST_HIDE",nullable=true,length=1)
	public java.lang.String getIsListHide() {
		return isListHide;
	}

	public void setIsListHide(java.lang.String isListHide) {
		this.isListHide = isListHide;
	}
	//业务对应待办列表字段
	private java.lang.String bizdataFieldname;
	@Column(name ="BIZDATA_FIELDNAME",nullable=true,length=40)
	public java.lang.String getBizdataFieldname() {
		return bizdataFieldname;
	}

	public void setBizdataFieldname(java.lang.String bizdataFieldname) {
		this.bizdataFieldname = bizdataFieldname;
	}
	//是否是流程变量
		private java.lang.String isProcessVariables;
		@Column(name ="IS_PROCESS_VARIABLES",nullable=true,length=1)
		public java.lang.String getIsProcessVariables() {
			return isProcessVariables;
		}

		public void setIsProcessVariables(java.lang.String isProcessVariables) {
			this.isProcessVariables = isProcessVariables;
		}

	private java.lang.String isFormHide;
	@Column(name ="IS_FORM_HIDE",nullable=true,length=1)
	public java.lang.String getIsFormHide() {
		return isFormHide;
	}

	public void setIsFormHide(java.lang.String isFormHide) {
		this.isFormHide = isFormHide;
	}
	
	/**能否为空*/
	private java.lang.String isNotnull;
	/** 业务编码 */
	private java.lang.String bussCode;
	private java.lang.String bussName;

	/**
	 * 表单明细行能否编辑
	 */
	private java.lang.String isFormDetailEdit;
	
	/** 版本号-同流程版本（0代表基础版本） */
	private java.lang.Integer versionNum;
	
	/** 业务显示模板表ID */
	private java.lang.String bussTemplateId;
	
	@Column(name = "VERSIONNUM", length = 11)
	public Integer getVersionNum() {
		return versionNum;
	}
	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}
	private java.lang.String indexExtId;
	@Column(name ="INDEX_EXT_ID",nullable=true,length=1)
	public java.lang.String getIndexExtId() {
		return indexExtId;
	}

	public void setIndexExtId(java.lang.String indexExtId) {
		this.indexExtId = indexExtId;
	}
	private java.lang.String linkBussCode;
	@Column(name ="LINK_BUSS_CODE",nullable=true,length=1)
	public java.lang.String getLinkBussCode() {
		return linkBussCode;
	}

	public void setLinkBussCode(java.lang.String linkBussCode) {
		this.linkBussCode = linkBussCode;
	}
	
	
	private java.lang.Integer x;
	private java.lang.Integer y;
	private java.lang.Integer w;
	private java.lang.Integer h;
	
	@Column(name ="x",nullable=true,length=1)
	public java.lang.Integer getX() {
		return x;
	}

	public void setX(java.lang.Integer x) {
		this.x = x;
	}
	@Column(name ="y",nullable=true,length=1)
	public java.lang.Integer getY() {
		return y;
	}

	public void setY(java.lang.Integer y) {
		this.y = y;
	}
	@Column(name ="w",nullable=true,length=1)
	public java.lang.Integer getW() {
		return w;
	}

	public void setW(java.lang.Integer w) {
		this.w = w;
	}
	@Column(name ="h",nullable=true,length=1)
	public java.lang.Integer getH() {
		return h;
	}

	public void setH(java.lang.Integer h) {
		this.h = h;
	}
	
	@Column(name = "BUSS_TEMPLATE_ID", length = 32)
	public java.lang.String getBussTemplateId() {
		return bussTemplateId;
	}

	public void setBussTemplateId(java.lang.String bussTemplateId) {
		this.bussTemplateId = bussTemplateId;
	}
	
	@Column(name ="IS_FORMDETAIL_EDIT",nullable=true,length=1)
	public java.lang.String getIsFormDetailEdit() {
		return isFormDetailEdit;
	}

	public void setIsFormDetailEdit(java.lang.String isFormDetailEdit) {
		this.isFormDetailEdit = isFormDetailEdit;
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

	@Column(name ="IS_NOTNULL",nullable=true,length=1)
	public java.lang.String getIsNotnull() {
		return isNotnull;
	}

	public void setIsNotnull(java.lang.String isNotnull) {
		this.isNotnull = isNotnull;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否图文模式显示
	 */
	@Column(name ="IS_IMAGELIST",nullable=true,length=1)
	public java.lang.String getIsImagelist(){
		return this.isImagelist;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否图文模式显示
	 */
	public void setIsImagelist(java.lang.String isImagelist){
		this.isImagelist = isImagelist;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否简明模式显示
	 */
	@Column(name ="IS_SIMPLE",nullable=true,length=1)
	public java.lang.String getIsSimple(){
		return this.isSimple;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否简明模式显示
	 */
	public void setIsSimple(java.lang.String isSimple){
		this.isSimple = isSimple;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  能否编辑
	 */
	@Column(name ="IS_EDIT",nullable=true,length=1)
	public java.lang.String getIsEdit(){
		return this.isEdit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  能否编辑
	 */
	public void setIsEdit(java.lang.String isEdit){
		this.isEdit = isEdit;
	}

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
	 * @return: java.lang.String 字段名称
	 */
	@Column(name = "field_name", nullable = false, length = 32)
	public java.lang.String getFieldName() {
		return this.fieldName;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 字段名称
	 */
	public void setFieldName(java.lang.String fieldName) {
		this.fieldName = fieldName;
	}
	
	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 字段名称
	 */
	@Column(name = "FIELD_REMARK", nullable = false, length = 32)
	public java.lang.String getFieldRemark() {
		return this.fieldRemark;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 字段备注
	 */
	public void setFieldRemark(java.lang.String fieldRemark) {
		this.fieldRemark = fieldRemark;
	}

	/**
	 * 方法: 取得TablePropertyEntity
	 * 
	 * @return: TablePropertyEntity 关联的表ＩＤ
	 */
//	@ManyToOne
//	@JoinColumn(name = "table_id", nullable = false, referencedColumnName = "id")
//	@JsonIgnore
//	@ForeignKey(name = "null")
//	public CgFormLgHeadEntity getTable() {
//		return this.table;
//	}
//
//	/**
//	 * 方法: 设置TablePropertyEntity
//	 * 
//	 * @param: TablePropertyEntity 关联的表ID
//	 */
//	public void setTable(CgFormLgHeadEntity table) {
//		this.table = table;
//	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 字段长度
	 */
	@Column(name = "length", nullable = false, precision = 10, scale = 0)
	public java.lang.Integer getLength() {
		return this.length;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 字段长度
	 */
	public void setLength(java.lang.Integer length) {
		this.length = length;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 小数点长度
	 */
	@Column(name = "point_length", nullable = true, precision = 10, scale = 0)
	public java.lang.Integer getPointLength() {
		return this.pointLength;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 小数点长度
	 */
	public void setPointLength(java.lang.Integer pointLength) {
		this.pointLength = pointLength;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 字段类型
	 */
	@Column(name = "type", nullable = false, length = 32)
	public java.lang.String getType() {
		return this.type;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 字段类型
	 */
	public void setType(java.lang.String type) {
		this.type = type;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 是否允许空值
	 */
	@Column(name = "is_null", nullable = true, length = 5)
	public java.lang.String getIsNull() {
		return this.isNull;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 是否允许空值
	 */
	public void setIsNull(java.lang.String isNull) {
		this.isNull = isNull;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 是否显示
	 */
	@Column(name = "is_show", nullable = true, length = 5)
	public java.lang.String getIsShow() {
		return this.isShow;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 是否显示
	 */
	public void setIsShow(java.lang.String isShow) {
		this.isShow = isShow;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 显示类型
	 */
	@Column(name = "show_type", nullable = true, length = 10)
	public java.lang.String getShowType() {
		return this.showType;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 显示类型
	 */
	public void setShowType(java.lang.String showType) {
		this.showType = showType;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 是否生产查询字段
	 */
	@Column(name = "is_query", nullable = true, length = 5)
	public java.lang.String getIsQuery() {
		return this.isQuery;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 是否生产查询字段
	 */
	public void setIsQuery(java.lang.String isQuery) {
		this.isQuery = isQuery;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 查询类型single(默认：单字段查询),group(范围查询)
	 */
	@Column(name = "query_mode", nullable = true, length = 10)
	public java.lang.String getQueryMode() {
		return this.queryMode;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 查询类型single(默认：单字段查询),group(范围查询)
	 */
	public void setQueryMode(java.lang.String queryMode) {
		this.queryMode = queryMode;
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
	@Column(name = "create_by", nullable = true)
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

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 在表中的顺序
	 */
	@Column(name = "order_num", nullable = true, length = 4)
	public java.lang.Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(java.lang.Integer orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 是否为主键
	 */
	@Column(name = "is_key", nullable = true, length = 2)
	public java.lang.String getIsKey() {
		return isKey;
	}

	public void setIsKey(java.lang.String isKey) {
		this.isKey = isKey;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 控件长度
	 */
	@Column(name = "field_length", nullable = true, length = 10)
	public java.lang.Integer getFieldLength() {
		return fieldLength;
	}

	public void setFieldLength(java.lang.Integer field_length) {
		this.fieldLength = field_length;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 字段Href
	 */
	@Column(name = "field_href", nullable = true, length = 200)
	public java.lang.String getFieldHref() {
		return fieldHref;
	}

	public void setFieldHref(java.lang.String field_href) {
		this.fieldHref = field_href;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 控件校验
	 */
	@Column(name = "field_valid_type", nullable = true, length = 10)
	public java.lang.String getFieldValidType() {
		return fieldValidType;
	}

	public void setFieldValidType(java.lang.String field_valid_type) {
		this.fieldValidType = field_valid_type;
	}

	/**
	 * 方法: 取得 java.lang.String
	 * 
	 * @return 字典Code
	 * */
	@Column(name = "dict_field", nullable = true, length = 100)
	public java.lang.String getDictField() {
		return dictField;
	}

	public void setDictField(java.lang.String dictField) {
		this.dictField = dictField;
	}

	/**
	 * 方法: 取得 java.lang.String
	 * 
	 * @return 字典Table
	 * */
	@Column(name = "dict_table", nullable = true, length = 100)
	public java.lang.String getDictTable() {
		return dictTable;
	}

	public void setDictTable(java.lang.String dictTable) {
		this.dictTable = dictTable;
	}

	/**
	 * 方法: 取得 java.lang.String
	 * 
	 * @return 主表名称
	 * */
	@Column(name = "main_table", nullable = true, length = 100)
	public java.lang.String getMainTable() {
		return mainTable;
	}

	public void setMainTable(java.lang.String mainTable) {
		this.mainTable = mainTable;
	}

	/**
	 * 方法: 取得 java.lang.String
	 * 
	 * @return 主表名称
	 * */
	@Column(name = "main_field", nullable = true, length = 100)
	public java.lang.String getMainField() {
		return mainField;
	}

	public void setMainField(java.lang.String mainField) {
		this.mainField = mainField;
	}

	/**
	 * 方法: 取得 java.lang.String
	 * 
	 * @return 主表名称
	 * */
	@Column(name = "old_field_name", nullable = true, length = 32)
	public java.lang.String getOldFieldName() {
		return oldFieldName;
	}

	public void setOldFieldName(java.lang.String oldFieldName) {
		this.oldFieldName = oldFieldName;
	}

	/**
	 * 方法: 取得 java.lang.String
	 * 
	 * @return 是否在列表上显示
	 * */
	@Column(name = "is_show_list", nullable = true, length = 5)
	public java.lang.String getIsShowList() {
		return isShowList;
	}

	public void setIsShowList(java.lang.String isShowList) {
		this.isShowList = isShowList;
	}

	/**
	 * 方法: 取得 java.lang.String
	 * 
	 * @return 字典文本
	 * */
	@Column(name = "dict_text", nullable = true, length = 100)
	public java.lang.String getDictText() {
		return dictText;
	}

	public void setDictText(java.lang.String dictText) {
		this.dictText = dictText;
	}

	@Column(name = "field_default", nullable = true, length = 20)
	public java.lang.String getFieldDefault() {
		if (fieldDefault != null) {
			fieldDefault = fieldDefault.trim();
		}
		return fieldDefault;
	}

	public void setFieldDefault(java.lang.String fieldDefault) {
		this.fieldDefault = fieldDefault;
	}

	@Column(name = "field_alert", nullable = true, length = 20)
	public java.lang.String getFieldAlert() {
		if (fieldAlert != null) {
			fieldAlert = fieldAlert.trim();
		}
		return fieldAlert;
	}

	public void setFieldAlert(java.lang.String fieldAlert) {
		this.fieldAlert = fieldAlert;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务发布id
	 */
	@Column(name ="buss_id",nullable=true,length=10)
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
}
