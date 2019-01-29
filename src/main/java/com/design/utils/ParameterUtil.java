package com.design.utils;

import java.util.Map;

public class ParameterUtil {
	
	public static Map<String,String> parameter = null;
	
	public static String C_CUL_ISGENDETAIL_UNIQUECODE = "CUL_ISGENDETAIL_UNIQUECODE";//藏品是否生成明细标签（0否、1是）
	public static String C_CUL_ISGENMAIN_UNIQUECODE = "";//藏品是否生成主标签（0否、1是）
	public static String C_CUL_DETAIL_CANEDIT = "CUL_DETAIL_CANEDIT";//藏品明细是否能修改（0否、1是），控制明细能否修改
	
	public static String C_CUL_ISMAGDETAIL = "CUL_ISMAGDETAIL";//藏品是否管到明细（0否、1是）
	//public static String C_CUL_SHELVING_MAGDETAIL = "CUL_SHELVING_MAGDETAIL";//藏品是否按明细排架、移库（0否、1是）
	public static String C_CUL_SHIELD_IMG_DOWNLOAD = "CUL_SHIELD_IMG_DOWNLOAD";//是否屏蔽图片下载功能（0否、1是）
	public static String C_CUL_LC_IMGACC_PIXEL = "CUL_LC_IMGACC_PIXEL";//略大图像素300*300、600*600、Original_Pixel
	public static String C_CUL_SHIELD_HDIMG_ACCESS = "CUL_SHIELD_HDIMG_ACCESS";//是否屏蔽高清图片查看功能（0否、1是）
	
	public static String C_CUL_LIFECYCLE_BUTTON_ASCRIPTION = "CUL_LIFECYCLE_BUTTON_ASCRIPTION";//藏品生命周期界面，按钮对应的版本控制
	
	public static String C_CUL_MAGSCOPE_STORAGE = "CUL_MAGSCOPE_STORAGE";//藏品管理范围--保管（入库后）
	public static String C_CUL_MAGSCOPE_APPRAISA = "CUL_MAGSCOPE_APPRAISA";//藏品管理范围--鉴定
	public static String C_CUL_MAGSCOPE_REPAIR = "CUL_MAGSCOPE_REPAIR";//藏品管理范围--修复
	public static String C_CUL_MAGSCOPE_INVENTORY = "CUL_MAGSCOPE_INVENTORY";//藏品管理范围--盘点
	public static String C_CUL_MAGSCOPE_LOGOUT = "CUL_MAGSCOPE_LOGOUT";//藏品管理范围--注销
	public static String C_CUL_MAGSCOPE_QUERY = "CUL_MAGSCOPE_QUERY";//藏品管理范围--藏品查询
	public static String C_CUL_MAGSCOPE_STAT = "CUL_MAGSCOPE_STAT";//藏品管理范围--统计
	public static String C_CUL_MAGSCOPE_FIRSTPAGE_DYNAMIC = "CUL_MAGSCOPE_FIRSTPAGE_DYNAMIC";//藏品管理范围--首页--藏品动态
	public static String C_CUL_MAGSCOPE_FIRSTPAGE_STAT = "CUL_MAGSCOPE_FIRSTPAGE_STAT";//藏品管理范围--首页--藏品统计
	public static String C_CUL_MAGSCOPE_EXHIBITION = "CUL_MAGSCOPE_EXHIBITION";//藏品管理范围--展览
	public static String C_CUL_MAGSCOPE_COPYING = "CUL_MAGSCOPE_COPYING";//藏品管理范围--复仿制
	
	public static String C_DEPOT_DEFAULT_ICON_0 = "DEPOT_DEFAULT_ICON_0";//库房图
	public static String C_DEPOT_DEFAULT_ICON_1 = "DEPOT_DEFAULT_ICON_1";//排架图
	public static String C_DEPOT_DEFAULT_ICON_2 = "DEPOT_DEFAULT_ICON_2";//柜子图

	public static String ATC_K = "1f9156a0114915050e40917cf8b69260";
	public static String OPEN_LOGIN_AUTH = "OPEN_LOGIN_AUTH";//是否登录验证授权(0:否 1:是)
	public static String SYS_LIC_NAME = "license.lic";
	public static String SYS_MODULE_NAME = "SYS_MODULE_NAME";
	public static String SYS_HIELD_RIGHTCLICK = "SYS_HIELD_RIGHTCLICK";//是否屏蔽右键功能（0否、1是）
	public static String SYS_IS_DEVELOPERMODE = "SYS_IS_DEVELOPERMODE";//是否启用开发者模式（0否、1是），目前主要用在菜单和按钮的建立控制上
	public static String SYS_BRANDNAME = "sysBrandName";//系统品牌信息
	public static String SYS_COPYRIGHTNAME = "sysCopyrightName";//系统版权信息

	public static String IMG_COMPRESS = "IMG_COMPRESS";  //图片压缩格式数组
	
	public static String CUL_DORMANCYSTAGE_CONTROLTYPE = "CUL_DORMANCYSTAGE_CONTROLTYPE";//休眠期控制范围
	public static String CUL_DORMANCYSTAGE_UPDATENODE = "CUL_DORMANCYSTAGE_UPDATENODE";//休眠期结束日期更新节点（E03：回库、H01：展览）
	
	public static String CUL_TOTALREGISTRATIONNO_RULE = "CUL_TOTALREGISTRATIONNO_RULE";//总登记号生成规则（SZMX_-_6_新品,SZML_-_4_老品,SZMM_-_6_民俗,SZMB_-_6_标本）
	
	public static String CUL_ARCHIVES_CULIMG_CATA = "CUL_ARCHIVES_CULIMG_CATA";//藏品档案图片目录
	
	public static String CUL_ARCHIVES_EXPBAK_CATA = "CUL_ARCHIVES_EXPBAK_CATA";//藏品档案导出服务器备份目录
	
	
	public static String DATA_MANAGE_LINK = "DATA_MANAGE_LINK";//是否进入资源管理环节（0否、1是）
	public static String C_CUL_GL_LC_ISSEEDETAIL = "CUL_GL_LC_ISSEEDETAIL";//总账、藏品生命周期是否查看藏品明细（0否、1是）
	
	public static String SUBO_NOT_INVOLVED_BUSI_STATUS = "SUBO_NOT_INVOLVED_BUSI_STATUS";//苏博-不参与业务的藏品状态
	
	
	/**
	 * 根据code获取Value，直接返回数据库中的value
	 * @param code
	 * @return
	 */
	public static String getParameterValue(String code){
		return parameter.get(code);
	}
	
	/**
	 * 根据code获取Value,返回SQL中in的格式,如：'1','2','3'
	 * @param code
	 * @return
	 */
	public static String getSQLInFormatParameterValue(String code){
		String value = parameter.get(code);
		String strReturn = "";
		if(value != null){
			String[]  vArr = value.split(",");
			for(int i=0;i<vArr.length;i++){
				strReturn += "'" + vArr[i] + "'";
				if(i < vArr.length -1){
					strReturn += ",";
				}
			}
		}
		return strReturn;
	}

	/**
	 * 根据code获取Value，根据逗号分隔成数组后返回
	 * @param code
	 * @return
	 */
	public static String[] getArrFormatParameterValue(String code){
		String[]  vArr = null;
		String value = parameter.get(code);
		if(value != null){
			vArr = value.split(",");
		}
		return vArr;
	}
}
