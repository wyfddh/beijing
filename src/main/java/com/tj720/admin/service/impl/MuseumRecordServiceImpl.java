package com.tj720.admin.service.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.IMuseumRecordMapper;
import com.tj720.admin.dto.MuseumBaseHouseDto;
import com.tj720.admin.dto.MuseumBaseInfoDto;
import com.tj720.admin.dto.MuseumCollectionDto;
import com.tj720.admin.dto.MuseumDigitizationDto;
import com.tj720.admin.dto.MuseumHouseBuildingDto;
import com.tj720.admin.dto.MuseumPromotionDto;
import com.tj720.admin.dto.MuseumPublicServiceDto;
import com.tj720.admin.service.IMuseumRecordService;
import com.tj720.mip.utils.Page;

@Service("MuseumRecordServiceImpl")
public class MuseumRecordServiceImpl implements IMuseumRecordService {
	private final String VERSION = "1.0";
	
    @Autowired
    IMuseumRecordMapper museumRecordMapper;

    public Integer baseCount(Map<String, Object> map){
    	return museumRecordMapper.baseCount(map);
    };
    
    public List<MuseumBaseInfoDto> baseEditList(Map<String, Object> map){
    	return museumRecordMapper.baseEditList(map);
    };
    
    public Integer baseHouseCount(Map<String, Object> map){
    	return museumRecordMapper.baseHouseCount(map);
    };
	
    public List<MuseumBaseHouseDto> baseHouseEditList(Map<String, Object> map){
    	return museumRecordMapper.baseHouseEditList(map);
    };
    
    public Integer buildCount(Map<String, Object> map){
    	return museumRecordMapper.buildCount(map);
    };
	
    public List<MuseumHouseBuildingDto> buildEditList(Map<String, Object> map){
    	return museumRecordMapper.buildEditList(map);
    };
    
    public Integer serviceCount(Map<String, Object> map){
    	return museumRecordMapper.serviceCount(map);
    };
    
    public List<MuseumPublicServiceDto> publicServiceEditList(Map<String, Object> map){
    	return museumRecordMapper.publicServiceEditList(map);
    };
    
    public Integer digitizationCount(Map<String, Object> map){
    	return museumRecordMapper.digitizationCount(map);
    };
    
    public List<MuseumDigitizationDto> digitizationEditList(Map<String, Object> map){
    	return museumRecordMapper.digitizationEditList(map);
    };
    
    public Integer promotionCount(Map<String, Object> map){
    	return museumRecordMapper.promotionCount(map);
    };
    
    public List<MuseumPromotionDto> promotionEditList(Map<String, Object> map){
    	return museumRecordMapper.promotionEditList(map);
    };
    
    public Integer collectionCount(Map<String, Object> map){
    	return museumRecordMapper.collectionCount(map);
    };
    
    public List<MuseumCollectionDto> collectionEditList(Map<String, Object> map){
    	return museumRecordMapper.collectionEditList(map);
    }
    
	
	@Override
	public List<HashMap<String, Object>> getEditRecordList(String museumId, String delFlag, String id, String type) {

		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String tableName = null;
		switch(type){
			case "base": 
				list = museumRecordMapper.getEditRecordList(museumId,delFlag);
				tableName = "bj_museum_base_info";
				break;
			case "baseHouse": 
				list = museumRecordMapper.getBaseHouseEditRecordList(museumId,delFlag);
				tableName = "museum_base_house";
				break;
			case "publicService": 
				list = museumRecordMapper.getPublicServiceEditRecordList(museumId,delFlag);
				tableName = "museum_public_service";
				break;
			case "build": 
				list = museumRecordMapper.getbuildEditRecordList(museumId,delFlag);
				tableName = "museum_house_building";
				break;
			case "digitization": 
				list = museumRecordMapper.getDigitizationEditRecordList(museumId,delFlag);
				tableName = "museum_digitization";
				break;
			case "promotion": 
				list = museumRecordMapper.getPromotionEditRecordList(museumId,delFlag);
				tableName = "museum_promotion";
				break;
			case "collection": 
				list = museumRecordMapper.getCollectionEditRecordList(museumId,delFlag);
				tableName = "museum_collection_info";
				break;
			case "safe": 
				list = museumRecordMapper.getSafeEditRecordList(museumId,delFlag);
				tableName = "museum_safe_ensure";
				break;
			case "warehouse": 
				list = museumRecordMapper.getWarehouseEditRecordList(museumId,delFlag);
				tableName = "museum_warehouse";
				break;
			case "showRoom": 
				list = museumRecordMapper.getShowRoomEditRecordList(museumId,delFlag);
				tableName = "museum_show_room";
				break;
			case "displayShow": 
				list = museumRecordMapper.getDisplayShowEditRecordList(museumId,delFlag);
				tableName = "museum_display_show";
				break;
			case "relicsBureau": 
				list = museumRecordMapper.getRelicsBureauEditRecordList(museumId,delFlag);
				tableName = "cultural_relic_info";
				break;
			case "relicsBureauPersonChange": 
				list = museumRecordMapper.getRelicsBureauPersonChangeEditRecordList(museumId,delFlag);
				tableName = "cultural_relic_personnel_change";
				break;
			case "relicsBureauPersonDetail": 
				list = museumRecordMapper.getRelicsBureauPersonDetailEditRecordList(museumId,delFlag);
				tableName = "cultural_relic_personnel_detail";
				break;
			case "relicsUnit": 
				list = museumRecordMapper.getRelicsUnitEditRecordList(museumId,delFlag);
				tableName = "cultural_org_info";
				break;
		}
		if(null != list && list.size()>0){	
			HashMap<String, Object> currentMap = new HashMap<String, Object>(16);
			HashMap<String, Object> nextMap = new HashMap<String, Object>(16);
			for (int i = 0; i < list.size(); i++) {
				HashMap<String, Object> map = list.get(i);
				if(map.get("id").equals(id)){
					currentMap = map;
					if(i!=list.size()-1){
						nextMap = list.get(i+1);
					}
					else{
						nextMap = null;
					}
				}				
			}
			List<HashMap<String, Object>> returnList = convert(currentMap,nextMap,tableName,"id","museum_id","delete_mark","create_date","create_by","update_date","update_by",
					"spare_data1","spare_data2","spare_data3");
			return returnList;
		}
		return null;	
	}
	
	@Override
	public List<HashMap<String, Object>> getEditRecordList(String museumId, String delFlag,Page page, String type) {
		Integer allCounts = 0;
		List<HashMap<String, Object>> queryResult = new ArrayList<HashMap<String, Object>>();
		
		int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		switch(type){
			case "base": 
				allCounts = museumRecordMapper.countEditRecordList(museumId,delFlag);
				queryResult = museumRecordMapper.baseEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
			case "baseHouse": 
				allCounts = museumRecordMapper.baseHouseRecordCount(museumId,delFlag);
				queryResult = museumRecordMapper.baseHouseEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
			case "publicService": 
				allCounts = museumRecordMapper.publicServiceEditRecordCount(museumId,delFlag);
				queryResult = museumRecordMapper.publicServiceEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
			case "build": 
				allCounts = museumRecordMapper.buildEditRecordCount(museumId,delFlag);
				queryResult = museumRecordMapper.buildEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
			case "digitization": 
				allCounts = museumRecordMapper.digitizationEditRecordCount(museumId,delFlag);
				queryResult = museumRecordMapper.digitizationEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
			case "promotion": 
				allCounts = museumRecordMapper.promotionEditRecordCount(museumId,delFlag);
				queryResult = museumRecordMapper.promotionEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
			case "collection": 
				allCounts = museumRecordMapper.collectionEditRecordCount(museumId,delFlag);
				queryResult = museumRecordMapper.collectionEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
			case "safe": 
				allCounts = museumRecordMapper.safeEditRecordCount(museumId,delFlag);
				queryResult = museumRecordMapper.safeEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
			case "warehouse": 
				allCounts = museumRecordMapper.warehouseEditRecordCount(museumId,delFlag);
				queryResult = museumRecordMapper.warehouseEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
			case "showRoom": 
				allCounts = museumRecordMapper.showRoomEditRecordCount(museumId,delFlag);
				queryResult = museumRecordMapper.showRoomEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
			case "displayShow": 
				allCounts = museumRecordMapper.displayShowEditRecordCount(museumId,delFlag);
				queryResult = museumRecordMapper.displayShowEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
			case "relicsBureau": 
				allCounts = museumRecordMapper.relicsBureauEditRecordCount(museumId,delFlag);
				queryResult = museumRecordMapper.relicsBureauEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
			case "relicsBureauPersonChange": 
				allCounts = museumRecordMapper.relicsBureauPersonChangeEditRecordCount(museumId,delFlag);
				queryResult = museumRecordMapper.relicsBureauPersonChangeEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
			case "relicsBureauPersonDetail": 
				allCounts = museumRecordMapper.relicsBureauPersonDetailEditRecordCount(museumId,delFlag);
				queryResult = museumRecordMapper.relicsBureauPersonDetailEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
			case "relicsUnit": 
				allCounts = museumRecordMapper.relicsUnitEditRecordCount(museumId,delFlag);
				queryResult = museumRecordMapper.relicsUnitEditRecordList(museumId,delFlag,startRow,page.getSize());
				break;
		}
		page.setAllRow(allCounts);
		if(null != queryResult && queryResult.size()>0){
			for (int i = 0; i < queryResult.size(); i++) {
				HashMap<String, Object> temp = queryResult.get(i);
//				String delFlag = temp.get("delFlag") == null ? "" :temp.get("delFlag").toString();
				Double currentVersion = Float.valueOf(VERSION) + 0.1*(queryResult.size()-i-1);
				temp.put("version",String.valueOf(currentVersion));
				
				if(i == 0){
					temp.put("type", "当前版本");
				}else{
					temp.put("type", "历史版本");
				}
				if(i==queryResult.size()-1){
					temp.put("type", "初始版本");	
					temp.put("version",VERSION);	
				}
//				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        Date parse;
				try {
//					Timestamp date = (Timestamp)temp.get("createDate");
					parse = dateFormat.parse(temp.get("createDate").toString());
					String dateStr = dateFormat.format(parse);
					temp.put("createDate",dateStr);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		}
		return queryResult;	
	}
	
	private List<HashMap<String, Object>> convert(HashMap<String, Object> currentMap,HashMap<String, Object> nextMap,String tableName,String ...strings){
		List<HashMap<String, Object>> comments = museumRecordMapper.getColumnComentList(tableName);
		List<HashMap<String, Object>> returnList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < comments.size(); i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			HashMap<String, Object> tempMap = comments.get(i);
			if(null == tempMap || tempMap.get("COLUMN_NAME")==null){
				break;
			}
			boolean continues = true;
			for (int j = 0; j < strings.length; j++) {
				if(strings[j].equals(tempMap.get("COLUMN_NAME"))){
					continues = false;
					break;
				}
			}
			if(continues){
				String column = tempMap.get("column_comment").toString();		

				String key = tempMap.get("COLUMN_NAME")==null?"":tempMap.get("COLUMN_NAME").toString();
				if(nextMap!=null){
					String number = nextMap.get(tempMap.get("COLUMN_NAME"))==null?"":nextMap.get(tempMap.get("COLUMN_NAME")).toString();
					String value = getDictValueByKey(key,number);
//					if(column.indexOf("(")>-1){
//						String data = column.substring(column.indexOf("(")+1,column.indexOf(")"));
//						String[] entitys = data.split(";");
//						for (int j = 0; j < entitys.length; j++) {
//							String keyNumber = entitys[j].split(",")[0];
//							String nameNumber = entitys[j].split(",")[1];
//							if(number.equals(keyNumber)){
//								value = nameNumber;
//								break;
//							}
//						}
//					}
					if(column.contains("是否满足观众需求")){
						if(number.equals("1")){
							value = "是";
						}else{
							value = "否";
						}
					}
					else if(column.contains("是否满足观众需要")){
						if(number.equals("1")){
							value = "是";
						}else{
							value = "否";
						}
					}
					else if(column.contains("是否有")){
						if(number.equals("1")){
							value = "是";
						}else{
							value = "否";
						}
					}
					else if(column.contains("(1:是0：否)")){
						if(number.equals("1")){
							value = "是";
						}else{
							value = "否";
						}
					}
					else if(column.contains("(1:是；0否)")){
						if(number.equals("1")){
							value = "是";
						}else{
							value = "否";
						}
					}
					else if(column.indexOf("(1：有0：无)")>-1){
						if(number.equals("1")){
							value = "有";
						}else{
							value = "无";
						}
					}
					else if(column.indexOf("(1:有 0无)")>-1){
						if(number.equals("1")){
							value = "有";
						}else{
							value = "无";
						}
					}
					
					map.put("beforeEdit", value);
				}else{
					map.put("beforeEdit", null);
				}
				if(currentMap != null){
					String number = currentMap.get(tempMap.get("COLUMN_NAME"))==null?"":currentMap.get(tempMap.get("COLUMN_NAME")).toString();
					String value = getDictValueByKey(key,number);
//					if(column.indexOf("(")>-1){
//						String data = column.substring(column.indexOf("(")+1,column.indexOf(")"));
//						String[] entitys = data.split(";");
//						for (int j = 0; j < entitys.length; j++) {
//							String keyNumber = entitys[j].split(",")[0];
//							String nameNumber = entitys[j].split(",")[1];
//							if(number.equals(keyNumber)){
//								value = nameNumber;
//								break;
//							}
//						}
//					}
					 if(column.contains("是否满足观众需求")){
						if(number.equals("1")){
							value = "是";
						}else{
							value = "否";
						}
					}
					else if(column.contains("是否满足观众需要")){
						if(number.equals("1")){
							value = "是";
						}else{
							value = "否";
						}
					}
					else if(column.contains("是否有")){
						if(number.equals("1")){
							value = "是";
						}else{
							value = "否";
						}
					}
					else if(column.contains("(1:是0：否)")){
						if(number.equals("1")){
							value = "是";
						}else{
							value = "否";
						}
					}
					else if(column.contains("(1:是；0否)")){
						if(number.equals("1")){
							value = "是";
						}else{
							value = "否";
						}
					}
					else if(column.indexOf("(1：有0：无)")>-1){
						if(number.equals("1")){
							value = "有";
						}else{
							value = "无";
						}
					}
					else if(column.indexOf("(1:有 0无)")>-1){
						if(number.equals("1")){
							value = "有";
						}else{
							value = "无";
						}
					}
					
					map.put("afterEdit", value);
				}
				else{
					map.put("afterEdit", null);
				}
				if(column.indexOf("（")>-1){
					column = column.substring(0, column.indexOf("（"));
				}
				if(column.indexOf("(")>-1){
					column = column.substring(0, column.indexOf("("));
				}
				map.put("property", column);
				returnList.add(map);
			}
		}
		return returnList;
	}
	
	private String getDictValueByKey(String key,String number){
		if(null == key || key.equals("") || null == number||number.equals("")){
			return number;
		} 
		HashMap<String,Object> dicts  = museumRecordMapper.getDictList(key,number);
		 if(null == dicts || dicts.size()==0){
			 return number;
		 }else{
			 String value = dicts.get("dictValue").toString();
			 return value;
		 }
	}
	

	
}
