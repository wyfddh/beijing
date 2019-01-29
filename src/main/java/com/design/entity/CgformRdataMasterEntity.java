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
 * @Description: cgform_rdata_master
 * @author onlineGenerator
 * @date 2018-07-02 15:25:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cgform_rdata_master", schema = "")
@SuppressWarnings("serial")
public class CgformRdataMasterEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**业务id*/
	private java.lang.String bussId;
	/**创建人*/
	private java.lang.String createBy;
	/**创建时间*/
	private java.util.Date createDate;
	/**创建人*/
	private java.lang.String createName;
	/**更新人*/
	private java.lang.String updateBy;
	/**更新时间*/
	private java.util.Date updateDate;
	/**更新人*/
	private java.lang.String updateName;
	/**单位id*/
	private java.lang.String orgId;
	/**状态*/
	private java.lang.String status;
	/**temp1*/
	private java.lang.String temp1;
	/**temp2*/
	private java.lang.String temp2;
	/**temp3*/
	private java.lang.String temp3;
	/**temp4*/
	private java.lang.String temp4;
	/**temp5*/
	private java.lang.String temp5;
	/**temp6*/
	private java.lang.String temp6;
	/**temp7*/
	private java.lang.String temp7;
	/**temp8*/
	private java.lang.String temp8;
	/**temp9*/
	private java.lang.String temp9;
	/**temp10*/
	private java.lang.String temp10;
	/**temp11*/
	private java.lang.String temp11;
	/**temp12*/
	private java.lang.String temp12;
	/**temp13*/
	private java.lang.String temp13;
	/**temp14*/
	private java.lang.String temp14;
	/**temp15*/
	private java.lang.String temp15;
	/**temp16*/
	private java.lang.String temp16;
	/**temp17*/
	private java.lang.String temp17;
	/**temp18*/
	private java.lang.String temp18;
	/**temp19*/
	private java.lang.String temp19;
	/**temp20*/
	private java.lang.String temp20;
	/**temp21*/
	private java.lang.String temp21;
	/**temp22*/
	private java.lang.String temp22;
	/**temp23*/
	private java.lang.String temp23;
	/**temp24*/
	private java.lang.String temp24;
	/**temp25*/
	private java.lang.String temp25;
	/**temp26*/
	private java.lang.String temp26;
	/**temp27*/
	private java.lang.String temp27;
	/**temp28*/
	private java.lang.String temp28;
	/**temp29*/
	private java.lang.String temp29;
	/**temp30*/
	private java.lang.String temp30;
	/**temp31*/
	private java.lang.String temp31;
	/**temp32*/
	private java.lang.String temp32;
	/**temp33*/
	private java.lang.String temp33;
	/**temp34*/
	private java.lang.String temp34;
	/**temp35*/
	private java.lang.String temp35;
	/**temp36*/
	private java.lang.String temp36;
	/**temp37*/
	private java.lang.String temp37;
	/**temp38*/
	private java.lang.String temp38;
	/**temp39*/
	private java.lang.String temp39;
	/**temp40*/
	private java.lang.String temp40;
	/**temp41*/
	private java.lang.String temp41;
	/**temp42*/
	private java.lang.String temp42;
	/**temp43*/
	private java.lang.String temp43;
	/**temp44*/
	private java.lang.String temp44;
	/**temp45*/
	private java.lang.String temp45;
	/**temp46*/
	private java.lang.String temp46;
	/**temp47*/
	private java.lang.String temp47;
	/**temp48*/
	private java.lang.String temp48;
	/**temp49*/
	private java.lang.String temp49;
	/**temp50*/
	private java.lang.String temp50;
	/**temp50*/
	private java.lang.String org_name;
	
	
	public java.lang.String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(java.lang.String org_name) {
		this.org_name = org_name;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=true,length=50)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务id
	 */
	@Column(name ="BUSS_ID",nullable=true,length=50)
	public java.lang.String getBussId(){
		return this.bussId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务id
	 */
	public void setBussId(java.lang.String bussId){
		this.bussId = bussId;
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
	 *@return: java.lang.String  单位id
	 */
	@Column(name ="ORG_ID",nullable=true,length=50)
	public java.lang.String getOrgId(){
		return this.orgId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位id
	 */
	public void setOrgId(java.lang.String orgId){
		this.orgId = orgId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	@Column(name ="STATUS",nullable=true,length=10)
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
	 *@return: java.lang.String  temp1
	 */
	@Column(name ="TEMP1",nullable=true,length=300)
	public java.lang.String getTemp1(){
		return this.temp1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp1
	 */
	public void setTemp1(java.lang.String temp1){
		this.temp1 = temp1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp2
	 */
	@Column(name ="TEMP2",nullable=true,length=300)
	public java.lang.String getTemp2(){
		return this.temp2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp2
	 */
	public void setTemp2(java.lang.String temp2){
		this.temp2 = temp2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp3
	 */
	@Column(name ="TEMP3",nullable=true,length=300)
	public java.lang.String getTemp3(){
		return this.temp3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp3
	 */
	public void setTemp3(java.lang.String temp3){
		this.temp3 = temp3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp4
	 */
	@Column(name ="TEMP4",nullable=true,length=300)
	public java.lang.String getTemp4(){
		return this.temp4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp4
	 */
	public void setTemp4(java.lang.String temp4){
		this.temp4 = temp4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp5
	 */
	@Column(name ="TEMP5",nullable=true,length=300)
	public java.lang.String getTemp5(){
		return this.temp5;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp5
	 */
	public void setTemp5(java.lang.String temp5){
		this.temp5 = temp5;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp6
	 */
	@Column(name ="TEMP6",nullable=true,length=300)
	public java.lang.String getTemp6(){
		return this.temp6;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp6
	 */
	public void setTemp6(java.lang.String temp6){
		this.temp6 = temp6;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp7
	 */
	@Column(name ="TEMP7",nullable=true,length=300)
	public java.lang.String getTemp7(){
		return this.temp7;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp7
	 */
	public void setTemp7(java.lang.String temp7){
		this.temp7 = temp7;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp8
	 */
	@Column(name ="TEMP8",nullable=true,length=300)
	public java.lang.String getTemp8(){
		return this.temp8;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp8
	 */
	public void setTemp8(java.lang.String temp8){
		this.temp8 = temp8;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp9
	 */
	@Column(name ="TEMP9",nullable=true,length=300)
	public java.lang.String getTemp9(){
		return this.temp9;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp9
	 */
	public void setTemp9(java.lang.String temp9){
		this.temp9 = temp9;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp10
	 */
	@Column(name ="TEMP10",nullable=true,length=300)
	public java.lang.String getTemp10(){
		return this.temp10;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp10
	 */
	public void setTemp10(java.lang.String temp10){
		this.temp10 = temp10;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp11
	 */
	@Column(name ="TEMP11",nullable=true,length=300)
	public java.lang.String getTemp11(){
		return this.temp11;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp11
	 */
	public void setTemp11(java.lang.String temp11){
		this.temp11 = temp11;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp12
	 */
	@Column(name ="TEMP12",nullable=true,length=300)
	public java.lang.String getTemp12(){
		return this.temp12;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp12
	 */
	public void setTemp12(java.lang.String temp12){
		this.temp12 = temp12;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp13
	 */
	@Column(name ="TEMP13",nullable=true,length=300)
	public java.lang.String getTemp13(){
		return this.temp13;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp13
	 */
	public void setTemp13(java.lang.String temp13){
		this.temp13 = temp13;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp14
	 */
	@Column(name ="TEMP14",nullable=true,length=300)
	public java.lang.String getTemp14(){
		return this.temp14;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp14
	 */
	public void setTemp14(java.lang.String temp14){
		this.temp14 = temp14;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp15
	 */
	@Column(name ="TEMP15",nullable=true,length=300)
	public java.lang.String getTemp15(){
		return this.temp15;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp15
	 */
	public void setTemp15(java.lang.String temp15){
		this.temp15 = temp15;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp16
	 */
	@Column(name ="TEMP16",nullable=true,length=300)
	public java.lang.String getTemp16(){
		return this.temp16;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp16
	 */
	public void setTemp16(java.lang.String temp16){
		this.temp16 = temp16;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp17
	 */
	@Column(name ="TEMP17",nullable=true,length=300)
	public java.lang.String getTemp17(){
		return this.temp17;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp17
	 */
	public void setTemp17(java.lang.String temp17){
		this.temp17 = temp17;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp18
	 */
	@Column(name ="TEMP18",nullable=true,length=300)
	public java.lang.String getTemp18(){
		return this.temp18;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp18
	 */
	public void setTemp18(java.lang.String temp18){
		this.temp18 = temp18;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp19
	 */
	@Column(name ="TEMP19",nullable=true,length=300)
	public java.lang.String getTemp19(){
		return this.temp19;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp19
	 */
	public void setTemp19(java.lang.String temp19){
		this.temp19 = temp19;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp20
	 */
	@Column(name ="TEMP20",nullable=true,length=300)
	public java.lang.String getTemp20(){
		return this.temp20;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp20
	 */
	public void setTemp20(java.lang.String temp20){
		this.temp20 = temp20;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp21
	 */
	@Column(name ="TEMP21",nullable=true,length=300)
	public java.lang.String getTemp21(){
		return this.temp21;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp21
	 */
	public void setTemp21(java.lang.String temp21){
		this.temp21 = temp21;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp22
	 */
	@Column(name ="TEMP22",nullable=true,length=300)
	public java.lang.String getTemp22(){
		return this.temp22;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp22
	 */
	public void setTemp22(java.lang.String temp22){
		this.temp22 = temp22;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp23
	 */
	@Column(name ="TEMP23",nullable=true,length=300)
	public java.lang.String getTemp23(){
		return this.temp23;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp23
	 */
	public void setTemp23(java.lang.String temp23){
		this.temp23 = temp23;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp24
	 */
	@Column(name ="TEMP24",nullable=true,length=300)
	public java.lang.String getTemp24(){
		return this.temp24;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp24
	 */
	public void setTemp24(java.lang.String temp24){
		this.temp24 = temp24;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp25
	 */
	@Column(name ="TEMP25",nullable=true,length=300)
	public java.lang.String getTemp25(){
		return this.temp25;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp25
	 */
	public void setTemp25(java.lang.String temp25){
		this.temp25 = temp25;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp26
	 */
	@Column(name ="TEMP26",nullable=true,length=300)
	public java.lang.String getTemp26(){
		return this.temp26;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp26
	 */
	public void setTemp26(java.lang.String temp26){
		this.temp26 = temp26;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp27
	 */
	@Column(name ="TEMP27",nullable=true,length=300)
	public java.lang.String getTemp27(){
		return this.temp27;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp27
	 */
	public void setTemp27(java.lang.String temp27){
		this.temp27 = temp27;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp28
	 */
	@Column(name ="TEMP28",nullable=true,length=300)
	public java.lang.String getTemp28(){
		return this.temp28;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp28
	 */
	public void setTemp28(java.lang.String temp28){
		this.temp28 = temp28;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp29
	 */
	@Column(name ="TEMP29",nullable=true,length=300)
	public java.lang.String getTemp29(){
		return this.temp29;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp29
	 */
	public void setTemp29(java.lang.String temp29){
		this.temp29 = temp29;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp30
	 */
	@Column(name ="TEMP30",nullable=true,length=300)
	public java.lang.String getTemp30(){
		return this.temp30;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp30
	 */
	public void setTemp30(java.lang.String temp30){
		this.temp30 = temp30;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp31
	 */
	@Column(name ="TEMP31",nullable=true,length=300)
	public java.lang.String getTemp31(){
		return this.temp31;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp31
	 */
	public void setTemp31(java.lang.String temp31){
		this.temp31 = temp31;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp32
	 */
	@Column(name ="TEMP32",nullable=true,length=300)
	public java.lang.String getTemp32(){
		return this.temp32;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp32
	 */
	public void setTemp32(java.lang.String temp32){
		this.temp32 = temp32;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp33
	 */
	@Column(name ="TEMP33",nullable=true,length=300)
	public java.lang.String getTemp33(){
		return this.temp33;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp33
	 */
	public void setTemp33(java.lang.String temp33){
		this.temp33 = temp33;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp34
	 */
	@Column(name ="TEMP34",nullable=true,length=300)
	public java.lang.String getTemp34(){
		return this.temp34;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp34
	 */
	public void setTemp34(java.lang.String temp34){
		this.temp34 = temp34;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp35
	 */
	@Column(name ="TEMP35",nullable=true,length=300)
	public java.lang.String getTemp35(){
		return this.temp35;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp35
	 */
	public void setTemp35(java.lang.String temp35){
		this.temp35 = temp35;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp36
	 */
	@Column(name ="TEMP36",nullable=true,length=300)
	public java.lang.String getTemp36(){
		return this.temp36;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp36
	 */
	public void setTemp36(java.lang.String temp36){
		this.temp36 = temp36;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp37
	 */
	@Column(name ="TEMP37",nullable=true,length=300)
	public java.lang.String getTemp37(){
		return this.temp37;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp37
	 */
	public void setTemp37(java.lang.String temp37){
		this.temp37 = temp37;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp38
	 */
	@Column(name ="TEMP38",nullable=true,length=300)
	public java.lang.String getTemp38(){
		return this.temp38;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp38
	 */
	public void setTemp38(java.lang.String temp38){
		this.temp38 = temp38;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp39
	 */
	@Column(name ="TEMP39",nullable=true,length=300)
	public java.lang.String getTemp39(){
		return this.temp39;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp39
	 */
	public void setTemp39(java.lang.String temp39){
		this.temp39 = temp39;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp40
	 */
	@Column(name ="TEMP40",nullable=true,length=300)
	public java.lang.String getTemp40(){
		return this.temp40;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp40
	 */
	public void setTemp40(java.lang.String temp40){
		this.temp40 = temp40;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp41
	 */
	@Column(name ="TEMP41",nullable=true,length=300)
	public java.lang.String getTemp41(){
		return this.temp41;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp41
	 */
	public void setTemp41(java.lang.String temp41){
		this.temp41 = temp41;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp42
	 */
	@Column(name ="TEMP42",nullable=true,length=300)
	public java.lang.String getTemp42(){
		return this.temp42;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp42
	 */
	public void setTemp42(java.lang.String temp42){
		this.temp42 = temp42;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp43
	 */
	@Column(name ="TEMP43",nullable=true,length=300)
	public java.lang.String getTemp43(){
		return this.temp43;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp43
	 */
	public void setTemp43(java.lang.String temp43){
		this.temp43 = temp43;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp44
	 */
	@Column(name ="TEMP44",nullable=true,length=300)
	public java.lang.String getTemp44(){
		return this.temp44;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp44
	 */
	public void setTemp44(java.lang.String temp44){
		this.temp44 = temp44;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp45
	 */
	@Column(name ="TEMP45",nullable=true,length=300)
	public java.lang.String getTemp45(){
		return this.temp45;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp45
	 */
	public void setTemp45(java.lang.String temp45){
		this.temp45 = temp45;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp46
	 */
	@Column(name ="TEMP46",nullable=true,length=300)
	public java.lang.String getTemp46(){
		return this.temp46;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp46
	 */
	public void setTemp46(java.lang.String temp46){
		this.temp46 = temp46;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp47
	 */
	@Column(name ="TEMP47",nullable=true,length=300)
	public java.lang.String getTemp47(){
		return this.temp47;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp47
	 */
	public void setTemp47(java.lang.String temp47){
		this.temp47 = temp47;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp48
	 */
	@Column(name ="TEMP48",nullable=true,length=300)
	public java.lang.String getTemp48(){
		return this.temp48;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp48
	 */
	public void setTemp48(java.lang.String temp48){
		this.temp48 = temp48;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp49
	 */
	@Column(name ="TEMP49",nullable=true,length=300)
	public java.lang.String getTemp49(){
		return this.temp49;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp49
	 */
	public void setTemp49(java.lang.String temp49){
		this.temp49 = temp49;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  temp50
	 */
	@Column(name ="TEMP50",nullable=true,length=300)
	public java.lang.String getTemp50(){
		return this.temp50;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  temp50
	 */
	public void setTemp50(java.lang.String temp50){
		this.temp50 = temp50;
	}
}
