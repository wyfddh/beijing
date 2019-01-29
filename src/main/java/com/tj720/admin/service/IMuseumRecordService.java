package com.tj720.admin.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tj720.admin.dto.MuseumBaseHouseDto;
import com.tj720.admin.dto.MuseumBaseInfoDto;
import com.tj720.admin.dto.MuseumCollectionDto;
import com.tj720.admin.dto.MuseumDigitizationDto;
import com.tj720.admin.dto.MuseumHouseBuildingDto;
import com.tj720.admin.dto.MuseumPromotionDto;
import com.tj720.admin.dto.MuseumPublicServiceDto;
import com.tj720.mip.utils.Page;



public interface IMuseumRecordService {

	public Integer baseCount(Map<String, Object> map);
	
    public List<MuseumBaseInfoDto> baseEditList(Map<String, Object> map);
    
    public Integer baseHouseCount(Map<String, Object> map);
	
    public List<MuseumBaseHouseDto> baseHouseEditList(Map<String, Object> map);
    
    public Integer buildCount(Map<String, Object> map);
	
    public List<MuseumHouseBuildingDto> buildEditList(Map<String, Object> map);
    
    public Integer serviceCount(Map<String, Object> map);
    
    public List<MuseumPublicServiceDto> publicServiceEditList(Map<String, Object> map);
    
    public Integer digitizationCount(Map<String, Object> map);
    
    public List<MuseumDigitizationDto> digitizationEditList(Map<String, Object> map);
    
    public Integer promotionCount(Map<String, Object> map);
    
    public List<MuseumPromotionDto> promotionEditList(Map<String, Object> map);
    
    public Integer collectionCount(Map<String, Object> map);
    
    public List<MuseumCollectionDto> collectionEditList(Map<String, Object> map);
    
    /**
     * 查询修改记录-详情页
     * @param museumId 博物馆ID
     * @param delFlag 删除标记
     * @param id 记录ID
     * @param type 类型
     * @return
     */
	public List<HashMap<String, Object>> getEditRecordList(String museumId,String delFlag, String id,String type);
	
	/**
	 * 查询修改记录-列表页
	 * @param museumId 博物馆ID
	 * @param delFlag 删除标记
	 * @param page 分页
	 * @param type 类型
	 * @return
	 */
	public List<HashMap<String, Object>> getEditRecordList(String museumId, String delFlag, Page page, String type);
    

}
