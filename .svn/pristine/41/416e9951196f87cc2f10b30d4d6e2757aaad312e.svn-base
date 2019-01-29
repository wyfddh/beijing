package com.tj720.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tj720.admin.model.MipOpenCollectionInfo;
import com.tj720.mip.framework.JsonResult;
import com.tj720.admin.model.MipOpenCulturalrelicInfo;
import com.tj720.admin.model.MipOpenFossilInfo;
import com.tj720.mip.utils.Page;

public interface MipOpenCollectionInfoService {

	/**
	 * 公开藏品库查询
	 * @param openCollectionInfo
	 * @param page
	 * @param orgId 
	 * @return
	 */
	List<MipOpenCollectionInfo> listCollectionInfo(MipOpenCollectionInfo openCollectionInfo,Page page, String orgId);
	/**
	 * 馆际公开藏品库查询
	 * @param openCollectionInfo
	 * @param page
	 * @param orgId
	 * @return
	 */
	List<MipOpenCulturalrelicInfo> listCollectionInfo4Culturalrelic(MipOpenCulturalrelicInfo openCollectionInfo,Page page, String orgId);
	//2018-7-13新增接口
	
	List<MipOpenFossilInfo> listCollectionInfo4Fossil(MipOpenFossilInfo openCollectionInfo,Page page, String orgId);
	
	JsonResult getCollectionList(String collectionsCategory,String city,String year,String name,Integer isHighQuality,Page page,String type, String userid);
	   
    Integer countCollectionList(String collectionsCategory,String city,String year,String name,Integer isHighQuality);
    
    JsonResult getCollectionCategoryList(Page page);
    
    Integer countCollectionCategoryList();    
    
    Map<String, Object> getCollectionById(String id, String userid);
    
    /**
     * 查询当前博物馆其他藏品
     * @param orgId
     * @param currentId
     * @param size
     * @return
     */
    List<Map<String, Object>> getCollectionOtherList(String orgId, String currentId, Integer size);
    
    /**
     * 根据传入字段进行更新，为null的则不更新
     * @param collection
     * @return
     */
    int update(MipOpenCollectionInfo collection);
}
