package com.design.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: cgform_report_index
 * @author onlineGenerator
 * @date 2018-06-28 17:32:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cgform_report_index", schema = "")
@SuppressWarnings("serial")
public class CgformReportIndexEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**指标中文名*/
	private java.lang.String content;
	/**创建人*/
	private java.lang.String createBy;
	/**创建时间*/
	private java.util.Date createDate;
	/**创建人*/
	private java.lang.String createName;
	/**字典字段*/
	private java.lang.String dictField;
	/**字典表*/
	private java.lang.String dictTable;
	/**字典对应查询字段*/
	private java.lang.String dictText;
	/**字段url*/
	private java.lang.String fieldHref;
	/**控件长度*/
	private java.lang.Integer fieldLength;
	/**指标名*/
	private java.lang.String fieldName;
	/**指标验证规则*/
	private java.lang.String fieldValidType;
	/**是否是主键*/
	private java.lang.String isKey;
	/**是否为空*/
	private java.lang.String isNull;
	/**字段长度*/
	private java.lang.Integer length;
	/**关联主表字段*/
	private java.lang.String mainField;
	/**关联主表*/
	private java.lang.String mainTable;
	/**小数点*/
	private java.lang.Integer pointLength;
	/**查询方式*/
	private java.lang.String queryMode;
	/**控件类型*/
	private java.lang.String showType;
	/**指标类型*/
	private java.lang.String type;
	/**更新人*/
	private java.lang.String updateBy;
	/**更新时间*/
	private java.util.Date updateDate;
	/**更新人*/
	private java.lang.String updateName;
	/**字段默认值*/
	private java.lang.String fieldDefault;
	/**帮助信息*/
	private java.lang.String fieldAlert;
	/**是否必填*/
	private java.lang.String isNotnull;
	/**指标组id*/
	private java.lang.String groupId;
	/**指标id*/
	private java.lang.String indexId;
	/**备注信息*/
	private java.lang.String fieldRemark;
	/**是否表单隐藏*/
	private java.lang.String isFormHide;
	/**是否列表隐藏*/
	private java.lang.String isListHide;
	/**流程变量*/
	private java.lang.String isProcessVariables;
	/**表单名词列表是否可编辑*/
	private java.lang.String isFormdetailEdit;
	/**版本号*/
	private java.lang.Integer versionnum;
	/**关联明细字段*/
	private java.lang.String detailField;
	/**弹窗高度*/
	private java.lang.String windowHeight;
	/**弹窗宽度*/
	private java.lang.String windowWidth;
	/**赋值控件id*/
	private java.lang.String inputId;
	/**选择控件id*/
	private java.lang.String selectId;
	/**过滤条件*/
	private java.lang.String wherePara;
	/**是否查看历史记录*/
	private java.lang.String isHistVal;
	/**列表显示宽度*/
	private java.lang.String columnWidth;
	
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
	 *@return: java.lang.String  指标中文名
	 */
	@Column(name ="CONTENT",nullable=true,length=200)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  指标中文名
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
	 *@return: java.lang.String  字典字段
	 */
	@Column(name ="DICT_FIELD",nullable=true,length=100)
	public java.lang.String getDictField(){
		return this.dictField;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字典字段
	 */
	public void setDictField(java.lang.String dictField){
		this.dictField = dictField;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  字典表
	 */
	@Column(name ="DICT_TABLE",nullable=true,length=100)
	public java.lang.String getDictTable(){
		return this.dictTable;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字典表
	 */
	public void setDictTable(java.lang.String dictTable){
		this.dictTable = dictTable;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  字典对应查询字段
	 */
	@Column(name ="DICT_TEXT",nullable=true,length=100)
	public java.lang.String getDictText(){
		return this.dictText;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字典对应查询字段
	 */
	public void setDictText(java.lang.String dictText){
		this.dictText = dictText;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  字段url
	 */
	@Column(name ="FIELD_HREF",nullable=true,length=200)
	public java.lang.String getFieldHref(){
		return this.fieldHref;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字段url
	 */
	public void setFieldHref(java.lang.String fieldHref){
		this.fieldHref = fieldHref;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  控件长度
	 */
	@Column(name ="FIELD_LENGTH",nullable=true,length=19)
	public java.lang.Integer getFieldLength(){
		return this.fieldLength;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  控件长度
	 */
	public void setFieldLength(java.lang.Integer fieldLength){
		this.fieldLength = fieldLength;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  指标名
	 */
	@Column(name ="FIELD_NAME",nullable=true,length=32)
	public java.lang.String getFieldName(){
		return this.fieldName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  指标名
	 */
	public void setFieldName(java.lang.String fieldName){
		this.fieldName = fieldName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  指标验证规则
	 */
	@Column(name ="FIELD_VALID_TYPE",nullable=true,length=10)
	public java.lang.String getFieldValidType(){
		return this.fieldValidType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  指标验证规则
	 */
	public void setFieldValidType(java.lang.String fieldValidType){
		this.fieldValidType = fieldValidType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否是主键
	 */
	@Column(name ="IS_KEY",nullable=true,length=2)
	public java.lang.String getIsKey(){
		return this.isKey;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否是主键
	 */
	public void setIsKey(java.lang.String isKey){
		this.isKey = isKey;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否为空
	 */
	@Column(name ="IS_NULL",nullable=true,length=5)
	public java.lang.String getIsNull(){
		return this.isNull;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否为空
	 */
	public void setIsNull(java.lang.String isNull){
		this.isNull = isNull;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  字段长度
	 */
	@Column(name ="LENGTH",nullable=false,length=19)
	public java.lang.Integer getLength(){
		return this.length;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  字段长度
	 */
	public void setLength(java.lang.Integer length){
		this.length = length;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关联主表字段
	 */
	@Column(name ="MAIN_FIELD",nullable=true,length=100)
	public java.lang.String getMainField(){
		return this.mainField;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关联主表字段
	 */
	public void setMainField(java.lang.String mainField){
		this.mainField = mainField;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关联主表
	 */
	@Column(name ="MAIN_TABLE",nullable=true,length=100)
	public java.lang.String getMainTable(){
		return this.mainTable;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关联主表
	 */
	public void setMainTable(java.lang.String mainTable){
		this.mainTable = mainTable;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  小数点
	 */
	@Column(name ="POINT_LENGTH",nullable=true,length=19)
	public java.lang.Integer getPointLength(){
		return this.pointLength;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  小数点
	 */
	public void setPointLength(java.lang.Integer pointLength){
		this.pointLength = pointLength;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  查询方式
	 */
	@Column(name ="QUERY_MODE",nullable=true,length=10)
	public java.lang.String getQueryMode(){
		return this.queryMode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  查询方式
	 */
	public void setQueryMode(java.lang.String queryMode){
		this.queryMode = queryMode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  控件类型
	 */
	@Column(name ="SHOW_TYPE",nullable=true,length=50)
	public java.lang.String getShowType(){
		return this.showType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  控件类型
	 */
	public void setShowType(java.lang.String showType){
		this.showType = showType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  指标类型
	 */
	@Column(name ="TYPE",nullable=true,length=15)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  指标类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
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
	 *@return: java.lang.String  字段默认值
	 */
	@Column(name ="FIELD_DEFAULT",nullable=true,length=20)
	public java.lang.String getFieldDefault(){
		return this.fieldDefault;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字段默认值
	 */
	public void setFieldDefault(java.lang.String fieldDefault){
		this.fieldDefault = fieldDefault;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  帮助信息
	 */
	@Column(name ="FIELD_ALERT",nullable=true,length=2000)
	public java.lang.String getFieldAlert(){
		return this.fieldAlert;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  帮助信息
	 */
	public void setFieldAlert(java.lang.String fieldAlert){
		this.fieldAlert = fieldAlert;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否必填
	 */
	@Column(name ="IS_NOTNULL",nullable=true,length=5)
	public java.lang.String getIsNotnull(){
		return this.isNotnull;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否必填
	 */
	public void setIsNotnull(java.lang.String isNotnull){
		this.isNotnull = isNotnull;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  指标组id
	 */
	@Column(name ="GROUP_ID",nullable=true,length=50)
	public java.lang.String getGroupId(){
		return this.groupId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  指标组id
	 */
	public void setGroupId(java.lang.String groupId){
		this.groupId = groupId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  指标id
	 */
	@Column(name ="INDEX_ID",nullable=true,length=100)
	public java.lang.String getIndexId(){
		return this.indexId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  指标id
	 */
	public void setIndexId(java.lang.String indexId){
		this.indexId = indexId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注信息
	 */
	@Column(name ="FIELD_REMARK",nullable=true,length=200)
	public java.lang.String getFieldRemark(){
		return this.fieldRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注信息
	 */
	public void setFieldRemark(java.lang.String fieldRemark){
		this.fieldRemark = fieldRemark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否表单隐藏
	 */
	@Column(name ="IS_FORM_HIDE",nullable=true,length=5)
	public java.lang.String getIsFormHide(){
		return this.isFormHide;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否表单隐藏
	 */
	public void setIsFormHide(java.lang.String isFormHide){
		this.isFormHide = isFormHide;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否列表隐藏
	 */
	@Column(name ="IS_LIST_HIDE",nullable=true,length=5)
	public java.lang.String getIsListHide(){
		return this.isListHide;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否列表隐藏
	 */
	public void setIsListHide(java.lang.String isListHide){
		this.isListHide = isListHide;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程变量
	 */
	@Column(name ="IS_PROCESS_VARIABLES",nullable=true,length=5)
	public java.lang.String getIsProcessVariables(){
		return this.isProcessVariables;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程变量
	 */
	public void setIsProcessVariables(java.lang.String isProcessVariables){
		this.isProcessVariables = isProcessVariables;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表单名词列表是否可编辑
	 */
	@Column(name ="IS_FORMDETAIL_EDIT",nullable=true,length=1)
	public java.lang.String getIsFormdetailEdit(){
		return this.isFormdetailEdit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表单名词列表是否可编辑
	 */
	public void setIsFormdetailEdit(java.lang.String isFormdetailEdit){
		this.isFormdetailEdit = isFormdetailEdit;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  版本号
	 */
	@Column(name ="VERSIONNUM",nullable=true,length=10)
	public java.lang.Integer getVersionnum(){
		return this.versionnum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  版本号
	 */
	public void setVersionnum(java.lang.Integer versionnum){
		this.versionnum = versionnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关联明细字段
	 */
	@Column(name ="DETAIL_FIELD",nullable=true,length=50)
	public java.lang.String getDetailField(){
		return this.detailField;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关联明细字段
	 */
	public void setDetailField(java.lang.String detailField){
		this.detailField = detailField;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  弹窗高度
	 */
	@Column(name ="WINDOW_HEIGHT",nullable=true,length=50)
	public java.lang.String getWindowHeight(){
		return this.windowHeight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  弹窗高度
	 */
	public void setWindowHeight(java.lang.String windowHeight){
		this.windowHeight = windowHeight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  弹窗宽度
	 */
	@Column(name ="WINDOW_WIDTH",nullable=true,length=50)
	public java.lang.String getWindowWidth(){
		return this.windowWidth;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  弹窗宽度
	 */
	public void setWindowWidth(java.lang.String windowWidth){
		this.windowWidth = windowWidth;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  赋值控件id
	 */
	@Column(name ="INPUT_ID",nullable=true,length=200)
	public java.lang.String getInputId(){
		return this.inputId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  赋值控件id
	 */
	public void setInputId(java.lang.String inputId){
		this.inputId = inputId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选择控件id
	 */
	@Column(name ="SELECT_ID",nullable=true,length=200)
	public java.lang.String getSelectId(){
		return this.selectId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选择控件id
	 */
	public void setSelectId(java.lang.String selectId){
		this.selectId = selectId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  过滤条件
	 */
	@Column(name ="WHERE_PARA",nullable=true,length=500)
	public java.lang.String getWherePara(){
		return this.wherePara;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  过滤条件
	 */
	public void setWherePara(java.lang.String wherePara){
		this.wherePara = wherePara;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否查看历史记录
	 */
	@Column(name ="IS_HIST_VAL",nullable=true,length=10)
	public java.lang.String getIsHistVal(){
		return this.isHistVal;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否查看历史记录
	 */
	public void setIsHistVal(java.lang.String isHistVal){
		this.isHistVal = isHistVal;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  列表显示宽度
	 */
	@Column(name ="COLUMN_WIDTH",nullable=true,length=50)
	public java.lang.String getColumnWidth(){
		return this.columnWidth;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  列表显示宽度
	 */
	public void setColumnWidth(java.lang.String columnWidth){
		this.columnWidth = columnWidth;
	}
}
