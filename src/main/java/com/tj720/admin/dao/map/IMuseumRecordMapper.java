package com.tj720.admin.dao.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumBaseHouseDto;
import com.tj720.admin.dto.MuseumBaseInfoDto;
import com.tj720.admin.dto.MuseumCollectionDto;
import com.tj720.admin.dto.MuseumDigitizationDto;
import com.tj720.admin.dto.MuseumHouseBuildingDto;
import com.tj720.admin.dto.MuseumPromotionDto;
import com.tj720.admin.dto.MuseumPublicServiceDto;

/**
 * 博物馆基础资料DAO接口
 * @author chenshiya
 * @version 2018-05-17
 */
@Repository("museumRecordMapper")
public interface IMuseumRecordMapper {

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
    
    public List<HashMap<String,Object>> baseEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
    
    public Integer countEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);
    
    public List<HashMap<String,Object>> getEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);
    
    public Integer baseHouseRecordCount(@Param("museumId") String museumId,@Param("delFlag") String delFlag);
    
    public List<HashMap<String,Object>> baseHouseEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
    
    public List<HashMap<String,Object>> getBaseHouseEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);
    
    public Integer buildEditRecordCount(@Param("museumId") String museumId,@Param("delFlag") String delFlag);
    
    public List<HashMap<String,Object>> buildEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
    
    public List<HashMap<String,Object>> getbuildEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);
    
    public Integer publicServiceEditRecordCount(@Param("museumId") String museumId,@Param("delFlag") String delFlag);
    
    public List<HashMap<String,Object>> publicServiceEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
    
    public List<HashMap<String,Object>> getPublicServiceEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);
    
    public Integer digitizationEditRecordCount(@Param("museumId") String museumId,@Param("delFlag") String delFlag);
    
    public List<HashMap<String,Object>> digitizationEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
    
    public List<HashMap<String,Object>> getDigitizationEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);
    
    public Integer promotionEditRecordCount(@Param("museumId") String museumId,@Param("delFlag") String delFlag);
    
    public List<HashMap<String,Object>> promotionEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
    
    public List<HashMap<String,Object>> getPromotionEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);
    
    public Integer collectionEditRecordCount(@Param("museumId") String museumId,@Param("delFlag") String delFlag);
    
    public List<HashMap<String,Object>> collectionEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
    
    public List<HashMap<String,Object>> getCollectionEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);
       
	public List<HashMap<String, Object>> getSafeEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public Integer safeEditRecordCount(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public List<HashMap<String, Object>> safeEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
	
	public List<HashMap<String, Object>> getWarehouseEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public Integer warehouseEditRecordCount(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public List<HashMap<String, Object>> warehouseEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
	
	public List<HashMap<String, Object>> getShowRoomEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public Integer showRoomEditRecordCount(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public List<HashMap<String, Object>> showRoomEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
	
	public List<HashMap<String, Object>> getDisplayShowEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public Integer displayShowEditRecordCount(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public List<HashMap<String, Object>> displayShowEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
	
	public List<HashMap<String, Object>> getRelicsBureauEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public Integer relicsBureauEditRecordCount(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public List<HashMap<String, Object>> relicsBureauEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);

	public List<HashMap<String, Object>> getRelicsBureauPersonChangeEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public Integer relicsBureauPersonChangeEditRecordCount(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public List<HashMap<String, Object>> relicsBureauPersonChangeEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
	
	public List<HashMap<String, Object>> getRelicsBureauPersonDetailEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public Integer relicsBureauPersonDetailEditRecordCount(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public List<HashMap<String, Object>> relicsBureauPersonDetailEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);

	public List<HashMap<String, Object>> getRelicsUnitEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public Integer relicsUnitEditRecordCount(@Param("museumId") String museumId,@Param("delFlag") String delFlag);

	public List<HashMap<String, Object>> relicsUnitEditRecordList(@Param("museumId") String museumId,@Param("delFlag") String delFlag,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
	
	public List<HashMap<String,Object>> getColumnComentList(@Param("tableName") String tableName);
	
	public HashMap<String,Object> getDictList(@Param("key") String key,@Param("number") String number);
    
    
    
    
}