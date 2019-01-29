package com.tj720.admin.common.constant;
/**
 * 
 * @author zwp
 * @date 2017年6月20日 上午11:18:49
 */
public class KeyConstants {
	// 用户Token码
	public static final String USER_TOKEN_CODE_KEY = "userTokenCode:{0}";
	
	// 博物馆-水印地址
	public static final String ORGANIZATION_WATERMARK_KEY = "organization:{0}";
	
	//博物馆水印时长key，原则上处理过水印只能5天后才能继续处理
	public static final String ORGANIZATION_WATERMARK_TIME_KEY = "org:{0}:process:watermark:time";

	//文物列表缓存key
	public static final String COLLECTION_INFO_LIST_KEY = "collectionInfoList:{0}{1}";
	//一普文物列表缓存key
	public static final String YP_COLLECTION_INFO_LIST_KEY = "ypCollectionInfoList:{0}";
	
	public static final String MUSEUN_INFO_MANAGE_LIST_KEY = "museunInfoManageList:{0}";
	
	//化石列表缓存key
	public static final String FOSSIL_INFO_LIST_KEY = "fossilInfoList:{0}";
	//一普化石列表缓存key
	public static final String YP_FOSSIL_INFO_LIST_KEY = "ypFossilInfoList:{0}";

	//列表缓存有效时长
	public static final int LIST_CACHE_EXPIRE_INTERVAL_HOUR = 6;
	
	//首页缓存key
	public static final String HOME_PAGE_DATA_KEY = "home:page:data";
	
	//web端用户token缓存
	public static final String USER_IP_TOKEN_CODE_KEY = "expire:userIpTokenCode:";
}
