package com.tj720.admin.service.collection.impl;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.controller.collection.ExportExcelUtil;
import com.tj720.admin.controller.collection.OrgUtil;
import com.tj720.admin.dao.collection.CollectionAttachmentMapper;
import com.tj720.admin.dao.collection.CollectionCategoryMapper;
import com.tj720.admin.dao.collection.CollectionInfoMapper;
import com.tj720.admin.dao.collection.CollectionSubmitMapper;
import com.tj720.admin.dao.collection.CollectionYearTypeMapper;
import com.tj720.admin.dao.map.IMuseumBaseInfoMapper;
import com.tj720.admin.dao.map.MipOrganizationMapper;
import com.tj720.admin.dto.MuseumBaseInfoDto;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.collection.CollectDict;
import com.tj720.admin.model.collection.CollectionAttachment;
import com.tj720.admin.model.collection.CollectionCategory;
import com.tj720.admin.model.collection.CollectionInfoWithBLOBs;
import com.tj720.admin.model.collection.CollectionSubmit;
import com.tj720.admin.model.collection.CollectionYearType;
import com.tj720.admin.model.collection.collectionCountDto;
import com.tj720.admin.service.collection.CollectDictSevice;
import com.tj720.admin.service.collection.CollectionInfoService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Page;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wyf
 * @date 2018/10/27 15:05
 **/
@Service
public class CollectionInfoServiceImpl implements CollectionInfoService {

    @Autowired
    private CollectionInfoMapper collectionInfoMapper;
    @Autowired
    private CollectDictSevice collectDictSevice;
    @Autowired
    private MipOrganizationMapper mipOrganizationMapper;
    @Autowired
    private CollectionAttachmentMapper collectionAttachmentMapper;
    @Autowired
    private CollectionCategoryMapper collectionCategoryMapper;
    @Autowired
    private CollectionYearTypeMapper collectionYearTypeMapper;
    @Autowired
    private CollectionSubmitMapper collectionSubmitMapper;
    @Autowired
    private Config config;
    
    private static Pattern NUMBER_PATTERN = Pattern.compile("^-?[0-9]+");

    @Override
    public JSONObject getCollectionInfoList(String key, String collectionTexture, String degreeDisability,
            String exhibiting, String collectionComeFrom, String saveState, String org, String screenState,
            String repertoryState, String collectionCategory, String collectionYearType, String collectionLevel,
            String autoCheck,String orgId, Integer currentPage, Integer size) {

        //分页对象
        Page page = new Page();
        page.setCurrentPage(currentPage);
        page.setSize(size);
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(key)) {
        	String[] split = {};
        	String replaceAll = key.replaceAll("，", ",");
        	if (replaceAll.contains(",")) {
        		split = replaceAll.split(",");
        	} else {
        		split = new String[1];
        		split[0] = replaceAll;
        		
        	}
        	map.put("keys", split);
        	
        }
        if (StringUtils.isNotBlank(collectionTexture)) {
            map.put("collectionTexture", collectionTexture);
        }
        if (StringUtils.isNotBlank(degreeDisability)) {
            map.put("degreeDisability", degreeDisability);
        }
        if (StringUtils.isNotBlank(exhibiting)) {
            map.put("exhibiting", exhibiting);
        }
        if (StringUtils.isNotBlank(collectionComeFrom)) {
            map.put("collectionComeFrom", collectionComeFrom);
        }
        if (StringUtils.isNotBlank(saveState)) {
            map.put("saveState", saveState);
        }
        String orgLevel = "1";
        if (StringUtils.isNotBlank(orgId) && isNum(orgId)) {
        	MipOrganization mipOrganization = mipOrganizationMapper.selectByPrimaryKey(Integer.parseInt(orgId));
        	if (mipOrganization != null) {
        		//文物局用户或者超级管理员
            	if ("1".equals(mipOrganization.getOrgTypeId()) || "0".equals(orgId)) {
            		if (StringUtils.isNotBlank(org)) {
                        map.put("org", org);
                        orgLevel = "1";
                    }
            		//博物馆用户或者修复单位
            	} else if ( "3".equals(mipOrganization.getOrgTypeId()) || "4".equals(mipOrganization.getOrgTypeId()) || "5".equals(mipOrganization.getOrgTypeId())) {
            		map.put("org", orgId);
            		orgLevel = "2";
            		//区文委
            	} else if ("2".equals(mipOrganization.getOrgTypeId())) {
            		map.put("org", org);
            		map.put("orgType", "2");
            		map.put("orgTypeId", orgId);
            		orgLevel = "1";
            	}
        	} else {
            	jsonObject.put("code", 1);
                jsonObject.put("msg", "请登录！");
                jsonObject.put("count", 0);
                jsonObject.put("data", "");
            	
            	return jsonObject;
            }
        	
        } else {
        	jsonObject.put("code", 1);
            jsonObject.put("msg", "请登录！");
            jsonObject.put("count", 0);
            jsonObject.put("data", "");
        	
        	return jsonObject;
        }
        if (StringUtils.isNotBlank(repertoryState)) {
            map.put("repertoryState", repertoryState);
            //当点击一普藏品库时才去查询待筛选等状态
            if ("1".equals(repertoryState)) {
                if (StringUtils.isNotBlank(screenState)) {
                    map.put("screenState", screenState);
                }
            }
        }
        if (StringUtils.isNotBlank(collectionCategory)) {
            map.put("collectionCategory", collectionCategory);
        }
        if (StringUtils.isNotBlank(collectionYearType)) {
            map.put("collectionYearType", collectionYearType);
        }
        if (StringUtils.isNotBlank(collectionLevel)) {
            map.put("collectionLevel", collectionLevel);
        }
        if (StringUtils.isNotBlank(autoCheck) && "1".equals(autoCheck)) {
            map.put("autoCheck", autoCheck);
        }

        //符合检索条件的数量
        Integer dataCount = collectionInfoMapper.countCollectionInfoList(map);

        page.setAllRow(dataCount);
        Integer start = page.getStart();
        map.put("start", start);
        map.put("end", size);

        List<CollectionInfoWithBLOBs> list = collectionInfoMapper.getCollectionInfoList(map);
        String jsonString = null;

        if (list != null && list.size() > 0) {
            List<CollectionInfoWithBLOBs> newList = handleData(list);
            jsonString = JSON.toJSONString(newList);
        }
        
        jsonObject.put("code", 0);
        jsonObject.put("msg", orgLevel);
        jsonObject.put("count", page.getAllRow());
        jsonObject.put("data", jsonString);

        return jsonObject;
    }
    
    public static boolean isNum(String str) {
        if (NUMBER_PATTERN.matcher(str).matches()) {
            //数字
            return true;
        } else {
            //非数字
            return false;
        }
    }

    @Override
    public JsonResult modifyState(String[] arr1, String[] arr2, String state) {
        JsonResult jsonResult = null;
        if (StringUtils.isNotBlank(state)) {
            try {
                if (arr1 != null && arr1.length > 0) {
                    List<String> keys1 = Arrays.asList(arr1);
                    //确定同时排除本页其他
                    if ("1".equals(state)) {
                        collectionInfoMapper.batchUpdateData(keys1,"4");
                        if (arr2 != null && arr2.length > 0) {
                            List<String> keys2 = Arrays.asList(arr2);
                            collectionInfoMapper.batchUpdateData(keys2,"3");
                        }
                    } else {
                        collectionInfoMapper.batchUpdateData(keys1,state);
                    }
                } else {
                    if (arr2 != null && arr2.length > 0) {
                        List<String> keys2 = Arrays.asList(arr2);
                        collectionInfoMapper.batchUpdateData(keys2,"3");
                    }
                }
                jsonResult = new JsonResult(1);
            } catch (Exception e) {
                e.printStackTrace();
                jsonResult = new JsonResult(0,"数据异常！");
            }
        } else {
            jsonResult = new JsonResult(0,"数据异常！");
        }
        return jsonResult;
    }

    @Override
    public JsonResult exhibiting(String[] arr1, String state) {

        JsonResult jsonResult = null;
        if (StringUtils.isNotBlank(state)) {
            if (arr1 != null && arr1.length > 0) {
                try {
                    List<String> list = Arrays.asList(arr1);
                    collectionInfoMapper.batchExhibiting(list,state);
                    jsonResult = new JsonResult(1);
                } catch (Exception e) {
                    e.printStackTrace();
                    jsonResult = new JsonResult(0,"数据异常！");
                }
            } else {
                jsonResult = new JsonResult(0,"数据异常！");
            }
        } else {
            jsonResult = new JsonResult(0,"数据异常！");
        }

        return jsonResult;
    }

    @Override
    public void batchExport(String repertoryState, String screenState, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("repertoryState",repertoryState);
        map.put("screenState",screenState);
        List<CollectionInfoWithBLOBs> list = collectionInfoMapper.getCollectionInfoList(map);
        if (list != null && list.size() > 0) {
            List<CollectionInfoWithBLOBs> collectionInfoList = handleData(list);
            String title = "文物库";
            String[] rowName = {"序号", "一普藏品编号","文物藏品名称", "文物藏品数量（件/套）", "藏品类别", "藏品质地", "文物级别",
                    "收藏单位", "单位地址"};
            List<Object[]> dataList = new ArrayList<Object[]>();
            Object[] objs = null;
            for (int i = 0; i < collectionInfoList.size(); i++) {
                objs = new Object[rowName.length];
                objs[0] = i + 1;
                if (StringUtils.isNotBlank(collectionInfoList.get(i).getGeneralSurveyNum())) {
                    objs[1] = collectionInfoList.get(i).getGeneralSurveyNum();
                } else {
                    objs[1] = "";
                }
                if (StringUtils.isNotBlank(collectionInfoList.get(i).getCollectionName())) {
                    objs[2] = collectionInfoList.get(i).getCollectionName();
                }
                if (StringUtils.isNotBlank(collectionInfoList.get(i).getContainCollectionCount())) {
                    objs[3] = collectionInfoList.get(i).getContainCollectionCount();
                }
                if (StringUtils.isNotBlank(collectionInfoList.get(i).getCollectionCategoryName())) {
                    objs[4] = collectionInfoList.get(i).getCollectionCategoryName();
                }
                if (StringUtils.isNotBlank(collectionInfoList.get(i).getCollectionTextureName())) {
                    objs[5] = collectionInfoList.get(i).getCollectionTextureName();
                }
                if (StringUtils.isNotBlank(collectionInfoList.get(i).getCollectionLevelName())) {
                    objs[6] = collectionInfoList.get(i).getCollectionLevelName();
                }
                if (StringUtils.isNotBlank(collectionInfoList.get(i).getCollectionOrgName())) {
                    objs[7] = collectionInfoList.get(i).getCollectionOrgName();
                }
                if (StringUtils.isNotBlank(collectionInfoList.get(i).getAddress())) {
                    objs[8] = collectionInfoList.get(i).getAddress();
                } else {
                    objs[8] = "";
                }

                dataList.add(objs);
            }
            try {
                ExportExcelUtil ex = new ExportExcelUtil(title, rowName, dataList);
                ex.export(response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public JsonResult collectionDetail(String id) {
        JsonResult jsonResult = null;
        try {
            CollectionInfoWithBLOBs collectionInfoWithBLOBs = collectionInfoMapper.getCollectionById(id);
            CollectionInfoWithBLOBs collectionInfo = handelSingleData(collectionInfoWithBLOBs);
            jsonResult = new JsonResult(1,collectionInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult = new JsonResult(0,"数据异常！");
        }

        return jsonResult;
    }

    private List<CollectionInfoWithBLOBs> handleData(List<CollectionInfoWithBLOBs> list) {

        //获取文物级别字典表
        List<CollectDict> collectionLevel = collectDictSevice.getDictListByKey("collection_level");
        //获取藏品质地字典表
        List<CollectDict> collectionTexture = collectDictSevice.getDictListByKey("collection_texture");
        //获取文物来源字典表
        List<CollectDict> collectionComeFrom = collectDictSevice.getDictListByKey("collection_come_from");


        for (CollectionInfoWithBLOBs collectionInfo : list) {
            for (CollectDict sysDict : collectionLevel) {
                if (StringUtils.isNotBlank(collectionInfo.getCollectionLevel()) && sysDict.getDictCode().equals(collectionInfo.getCollectionLevel())) {
                    collectionInfo.setCollectionLevelName(sysDict.getDictName());
                    break;
                }
            }
            for (CollectDict sysDict : collectionTexture) {
                if (StringUtils.isNotBlank(collectionInfo.getCollectionTexture()) && sysDict.getDictCode().equals(collectionInfo.getCollectionTexture())) {
                    collectionInfo.setCollectionTextureName(sysDict.getDictName());
                    break;
                }
            }
            for (CollectDict sysDict : collectionComeFrom) {
                if (StringUtils.isNotBlank(collectionInfo.getCollectionComeFrom()) && sysDict.getDictCode().equals(collectionInfo.getCollectionComeFrom())) {
                    collectionInfo.setCollectionComeFromName(sysDict.getDictName());
                    break;
                }
            }
            //处理一普编号，免得导出科学计数法
            if (StringUtils.isNotBlank(collectionInfo.getGeneralSurveyNum())) {
            	collectionInfo.setGeneralSurveyNum("'" + collectionInfo.getGeneralSurveyNum());
            }
            //处理在展
            if (StringUtils.isNotBlank(collectionInfo.getExhibiting())) {
                if ("1".equals(collectionInfo.getExhibiting())) {
                    collectionInfo.setExhibitingName("是");
                } else if ("0".equals(collectionInfo.getExhibiting())) {
                    collectionInfo.setExhibitingName("否");
                }
            }
              
            //处理组织地址
            //移动不同的项目需修改强转
            if (StringUtils.isNotBlank(collectionInfo.getCollectionOrgId()) && isNum(collectionInfo.getCollectionOrgId())) {
                try {
                	
                	MuseumBaseInfoDto org =(MuseumBaseInfoDto)collectDictSevice.getOrgAreaByOrgId(collectionInfo.getCollectionOrgId());
                	if (org != null) {
                		String address = (org.getProvince()==null?"":org.getProvince()) + (org.getCity()==null?"":org.getCity()) + org.getArea();
                		collectionInfo.setAddress(address);
                	}
                	MipOrganization orgByOrgId = (MipOrganization)collectDictSevice.getOrgByOrgId(collectionInfo.getCollectionOrgId());
                	if (orgByOrgId != null) {
                		collectionInfo.setCollectionOrgName(orgByOrgId.getName());
                	}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    private CollectionInfoWithBLOBs handelSingleData(CollectionInfoWithBLOBs collectionInfo) {

        //获取文物级别字典表
        List<CollectDict> collectionLevel = collectDictSevice.getDictListByKey("collection_level");
        //获取藏品质地字典表
        List<CollectDict> collectionTexture = collectDictSevice.getDictListByKey("collection_texture");
        //获取质地类别字典表
        List<CollectDict> collectionTextureCategory = collectDictSevice.getDictListByKey("collection_texture_category");
        //获取质地子类别字典表
        List<CollectDict> collectionTextureSonCategory = collectDictSevice.getDictListByKey("collection_texture_son_category");
        //获取文物来源字典表
        List<CollectDict> collectionComeFrom = collectDictSevice.getDictListByKey("collection_come_from");
        //获取藏品编号类型字典表
        List<CollectDict> collectionCodeType = collectDictSevice.getDictListByKey("collection_code_type");
        //获取入藏时间范围字典表
        List<CollectDict> timeFrame = collectDictSevice.getDictListByKey("time_frame");
        //获取完残程度字典表
        List<CollectDict> degreeDisability = collectDictSevice.getDictListByKey("degree_disability");
        //获取质量范围字典表
        List<CollectDict> massRange = collectDictSevice.getDictListByKey("mass_range");
        //获取质量单位字典表
        List<CollectDict> massUnit = collectDictSevice.getDictListByKey("mass_unit");
        //获取保存状态字典表
        List<CollectDict> saveState = collectDictSevice.getDictListByKey("save_state");
        //获取包含文物数量字典表
        //        List<CollectDict> containCollectionCount = collectDictSevice.getDictListByKey("contain_collection_count");

        for (CollectDict sysDict : collectionLevel) {
            if (StringUtils.isNotBlank(collectionInfo.getCollectionLevel()) && sysDict.getDictCode().equals(collectionInfo.getCollectionLevel())) {
                collectionInfo.setCollectionLevelName(sysDict.getDictName());
                break;
            }
        }
        for (CollectDict sysDict : collectionTexture) {
            if (StringUtils.isNotBlank(collectionInfo.getCollectionTexture()) && sysDict.getDictCode().equals(collectionInfo.getCollectionTexture())) {
                collectionInfo.setCollectionTextureName(sysDict.getDictName());
                break;
            }
        }
        for (CollectDict sysDict : collectionTextureCategory) {
            if (StringUtils.isNotBlank(collectionInfo.getCollectionTextureCategory()) && sysDict.getDictCode().equals(collectionInfo.getCollectionTextureCategory())) {
                collectionInfo.setCollectionTextureCategoryName(sysDict.getDictName());
                break;
            }
        }
        for (CollectDict sysDict : collectionTextureSonCategory) {
            if (StringUtils.isNotBlank(collectionInfo.getCollectionTextureSonCategory()) && sysDict.getDictCode().equals(collectionInfo.getCollectionTextureSonCategory())) {
                collectionInfo.setCollectionTextureSonCategoryName(sysDict.getDictName());
                break;
            }
        }
        for (CollectDict sysDict : collectionComeFrom) {
            if (StringUtils.isNotBlank(collectionInfo.getCollectionComeFrom()) && sysDict.getDictCode().equals(collectionInfo.getCollectionComeFrom())) {
                collectionInfo.setCollectionComeFromName(sysDict.getDictName());
                break;
            }
        }
        for (CollectDict sysDict : collectionCodeType) {
            if (StringUtils.isNotBlank(collectionInfo.getCollectionCodeType()) && sysDict.getDictCode().equals(collectionInfo.getCollectionCodeType())) {
                collectionInfo.setCollectionCodeTypeName(sysDict.getDictName());
                break;
            }
        }
        for (CollectDict sysDict : timeFrame) {
            if (StringUtils.isNotBlank(collectionInfo.getTimeFrame()) && sysDict.getDictCode().equals(collectionInfo.getTimeFrame())) {
                collectionInfo.setTimeFrameName(sysDict.getDictName());
                break;
            }
        }
        for (CollectDict sysDict : degreeDisability) {
            if (StringUtils.isNotBlank(collectionInfo.getDegreeDisability()) && sysDict.getDictCode().equals(collectionInfo.getDegreeDisability())) {
                collectionInfo.setDegreeDisabilityName(sysDict.getDictName());
                break;
            }
        }
        for (CollectDict sysDict : massRange) {
            if (StringUtils.isNotBlank(collectionInfo.getMassRange()) && sysDict.getDictCode().equals(collectionInfo.getMassRange())) {
                collectionInfo.setMassRangeName(sysDict.getDictName());
                break;
            }
        }
        for (CollectDict sysDict : massUnit) {
            if (StringUtils.isNotBlank(collectionInfo.getMassUnit()) && sysDict.getDictCode().equals(collectionInfo.getMassUnit())) {
                collectionInfo.setMassUnitName(sysDict.getDictName());
                break;
            }
        }
        for (CollectDict sysDict : saveState) {
            if (StringUtils.isNotBlank(collectionInfo.getSaveState()) && sysDict.getDictCode().equals(collectionInfo.getSaveState())) {
                collectionInfo.setSaveStateName(sysDict.getDictName());
                break;
            }
        }
        if (StringUtils.isNotBlank(collectionInfo.getContainCollectionCount())) {
            if ("1".equals(collectionInfo.getContainCollectionCount())) {
                collectionInfo.setContainCollectionCountName("单件");
            } else if ("2".equals(collectionInfo.getContainCollectionCount())) {
                collectionInfo.setContainCollectionCountName("一套多件");
            }
        }

        //处理图片
        if (StringUtils.isNotBlank(collectionInfo.getCollectionPictureid())) {
        	List<CollectionAttachment> picList = null;
            picList = collectionAttachmentMapper.getListByRelationId(collectionInfo.getCollectionPictureid()); 
            if (picList != null && picList.size() > 0) {
            	for (CollectionAttachment mipAttachment : picList) {
                    String path = config.getRootUrl() + mipAttachment.getAttPath();
                    mipAttachment.setAttPath(path);
                }
            } else {
            	picList = new ArrayList<CollectionAttachment>();
            }
            collectionInfo.setPicList(picList);
        }
        try {
			MipOrganization orgByOrgId = (MipOrganization)collectDictSevice.getOrgByOrgId(collectionInfo.getCollectionOrgId());
			if (orgByOrgId != null) {
				collectionInfo.setCollectionOrgName(orgByOrgId.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

        return collectionInfo;
    }
    
    @Override
	public JsonResult getTabData(String repertoryState, String screenState, String orgId, String autoCheck) {
    	
    	JsonResult jsonResult = null;
    	try {
            Map<String,String> map = new HashMap<String,String>();
            map.put("repertoryState",repertoryState);
            if ("1".equals(repertoryState)) {
                map.put("screenState",screenState);
            }
            if (StringUtils.isNotBlank(autoCheck) && "1".equals(autoCheck)) {
                map.put("autoCheck", autoCheck);
            }
            if (StringUtils.isNotBlank(orgId) && isNum(orgId)) {
            	MipOrganization mipOrganization = mipOrganizationMapper.selectByPrimaryKey(Integer.parseInt(orgId));
            	if (mipOrganization != null) {
            		//博物馆用户
                	if ("3".equals(mipOrganization.getOrgTypeId()) || "4".equals(mipOrganization.getOrgTypeId()) || "5".equals(mipOrganization.getOrgTypeId())) {
                		map.put("orgId", orgId);
                		//区文委
                	} else if ("2".equals(mipOrganization.getOrgTypeId())) {
                		map.put("orgType", "2");
                		map.put("orgTypeId", orgId);
                	}
                	//文物局用户或者超级管理员显示全部
            	} else {
               	 jsonResult = new JsonResult(0,"请登录！");
               	 return jsonResult;
               }
            } else {
            	 jsonResult = new JsonResult(0,"请登录！");
            	 return jsonResult;
            }
            
            //查询各库藏品数量
            collectionCountDto countDto = collectionInfoMapper.getCollentionHeadCount(map);


            Map<String,Object> newMap = new HashMap<String,Object>();
          
            newMap.put("countDto",countDto);
            jsonResult = new JsonResult(1,newMap);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult = new JsonResult(0,"数据异常！");
        }
		
		return jsonResult;
	}

	@Override
	public JsonResult getCollectionCategoryHead(String repertoryState, String screenState, String orgId,
			String autoCheck) {
		JsonResult jsonResult = null;
		 try {
	            Map<String,String> map = new HashMap<String,String>();
	            map.put("repertoryState",repertoryState);
	            if ("1".equals(repertoryState)) {
	                map.put("screenState",screenState);
	            }
	            if (StringUtils.isNotBlank(autoCheck) && "1".equals(autoCheck)) {
	                map.put("autoCheck", autoCheck);
	            }
	            if (StringUtils.isNotBlank(orgId) && isNum(orgId)) {
	            	MipOrganization mipOrganization = mipOrganizationMapper.selectByPrimaryKey(Integer.parseInt(orgId));
	            	if (mipOrganization != null) {
	            		//博物馆用户
	                	if ("3".equals(mipOrganization.getOrgTypeId()) || "4".equals(mipOrganization.getOrgTypeId()) || "5".equals(mipOrganization.getOrgTypeId())) {
	                		map.put("orgId", orgId);
	                		//区文委
	                	} else if ("2".equals(mipOrganization.getOrgTypeId())) {
	                		map.put("orgType", "2");
	                		map.put("orgTypeId", orgId);
	                	}
	                	//文物局用户或者超级管理员显示全部
	            	} else {
	               	 jsonResult = new JsonResult(0,"请登录！");
	               	 return jsonResult;
	               }
	            } else {
	            	 jsonResult = new JsonResult(0,"请登录！");
	            	 return jsonResult;
	            }
	            //查询藏品分类（包含藏品数量）
	            List<CollectionCategory> categoryList = collectionCategoryMapper.getListByType(map);


	            Map<String,Object> newMap = new HashMap<String,Object>();
	            newMap.put("categoryList",categoryList);
	            
	            jsonResult = new JsonResult(1,newMap);
	        } catch (Exception e) {
	            e.printStackTrace();
	            jsonResult = new JsonResult(0,"数据异常！");
	        }
		
		return jsonResult;
	}

	@Override
	public JsonResult getYearTypeHead(String repertoryState, String screenState, String collectionCategory,
			String orgId, String autoCheck) {
		JsonResult jsonResult = null;
		 try {
	            Map<String,String> map = new HashMap<String,String>();
	            map.put("repertoryState",repertoryState);
	            if ("1".equals(repertoryState)) {
	                map.put("screenState",screenState);
	            }
	            if (StringUtils.isNotBlank(collectionCategory)) {
	                map.put("collectionCategory",collectionCategory);
	            }
	            
	            if (StringUtils.isNotBlank(autoCheck) && "1".equals(autoCheck)) {
	                map.put("autoCheck", autoCheck);
	            }
	            if (StringUtils.isNotBlank(orgId) && isNum(orgId)) {
	            	MipOrganization mipOrganization = mipOrganizationMapper.selectByPrimaryKey(Integer.parseInt(orgId));
	            	if (mipOrganization != null) {
	            		//博物馆用户
	                	if ("3".equals(mipOrganization.getOrgTypeId()) || "4".equals(mipOrganization.getOrgTypeId()) || "5".equals(mipOrganization.getOrgTypeId())) {
	                		map.put("orgId", orgId);
	                		//区文委
	                	} else if ("2".equals(mipOrganization.getOrgTypeId())) {
	                		map.put("orgType", "2");
	                		map.put("orgTypeId", orgId);
	                	}
	                	//文物局用户或者超级管理员显示全部
	            	} else {
	               	 jsonResult = new JsonResult(0,"请登录！");
	               	 return jsonResult;
	               }
	            } else {
	            	 jsonResult = new JsonResult(0,"请登录！");
	            	 return jsonResult;
	            }
	           
	            //查询藏品常用年代（包含藏品数量）
	            List<CollectionYearType> yearTypeList = collectionYearTypeMapper.getCommonYearList(map);


	            Map<String,Object> newMap = new HashMap<String,Object>();
	            newMap.put("yearTypeList",yearTypeList);
	            jsonResult = new JsonResult(1,newMap);
	        } catch (Exception e) {
	            e.printStackTrace();
	            jsonResult = new JsonResult(0,"数据异常！");
	        }
		
		return jsonResult;
	}

	@Override
	public JsonResult getLevelHead(String repertoryState, String screenState, String collectionCategory,
			String collectionYearType, String orgId, String autoCheck) {
		JsonResult jsonResult = null;
		 try {
	            Map<String,String> map = new HashMap<String,String>();
	            map.put("repertoryState",repertoryState);
	            if ("1".equals(repertoryState)) {
	                map.put("screenState",screenState);
	            }
	            if (StringUtils.isNotBlank(collectionCategory)) {
	                map.put("collectionCategory",collectionCategory);
	            }
	            if (StringUtils.isNotBlank(collectionYearType)) {
	                map.put("collectionYearType",collectionYearType);
	            }
	            if (StringUtils.isNotBlank(autoCheck) && "1".equals(autoCheck)) {
	                map.put("autoCheck", autoCheck);
	            }
	            if (StringUtils.isNotBlank(orgId) && isNum(orgId)) {
	            	MipOrganization mipOrganization = mipOrganizationMapper.selectByPrimaryKey(Integer.parseInt(orgId));
	            	if (mipOrganization != null) {
	            		//博物馆用户
	                	if ("3".equals(mipOrganization.getOrgTypeId()) || "4".equals(mipOrganization.getOrgTypeId()) || "5".equals(mipOrganization.getOrgTypeId())) {
	                		map.put("orgId", orgId);
	                		//区文委
	                	} else if ("2".equals(mipOrganization.getOrgTypeId())) {
	                		map.put("orgType", "2");
	                		map.put("orgTypeId", orgId);
	                	}
	                	//文物局用户或者超级管理员显示全部
	            	} else {
	               	 jsonResult = new JsonResult(0,"请登录！");
	               	 return jsonResult;
	               }
	            } else {
	            	 jsonResult = new JsonResult(0,"请登录！");
	            	 return jsonResult;
	            }
	            //查询藏品级别（包含藏品数量）
	            List<CollectDict> levelList = collectDictSevice.getDictListAndCount("collection_level",map);

	            Map<String,Object> newMap = new HashMap<String,Object>();
	            newMap.put("levelList",levelList);
	            jsonResult = new JsonResult(1,newMap);
	        } catch (Exception e) {
	            e.printStackTrace();
	            jsonResult = new JsonResult(0,"数据异常！");
	        }
		
		return jsonResult;
	}

	@Override
	public JsonResult filterSubmit(String orgId) {
		JsonResult jsonResult = null;
		if (StringUtils.isNotBlank(orgId) && isNum(orgId)) {
			try {
				CollectionSubmit collectionSubmit = null;
				collectionSubmit =collectionSubmitMapper.getInfoByOrgId(orgId);
				//更新
				if (collectionSubmit != null) {
					collectionSubmit.setUpdateDate(new Date());
					collectionSubmit.setDataState("1");
					collectionSubmitMapper.updateByPrimaryKeySelective(collectionSubmit);
					//插入
				} else {
					MipOrganization mipOrganization = mipOrganizationMapper.selectByPrimaryKey(Integer.parseInt(orgId));
					collectionSubmit = new CollectionSubmit();
					String uuid = UUID.randomUUID().toString().replaceAll("-", "");
					collectionSubmit.setId(uuid);
					collectionSubmit.setOrgId(orgId);
					collectionSubmit.setOrgName(mipOrganization.getName());
					collectionSubmit.setCreateDate(new Date());
					collectionSubmit.setUpdateDate(new Date());
					collectionSubmit.setDataState("1");
					collectionSubmitMapper.insertSelective(collectionSubmit);
				}
				jsonResult = new JsonResult(1, "操作成功！");
			} catch (Exception e) {
				e.printStackTrace();
				jsonResult = new JsonResult(0, "系统异常！");
			}
		} else {
			jsonResult = new JsonResult(0, "请登录！");
		}
		return jsonResult;
	}

	@Override
	public JSONObject getSubmitList(String orgId, String dataState, Integer currentPage, Integer size) {
		
		JSONObject jsonObject = new JSONObject();
		if (StringUtils.isNotBlank(orgId) && isNum(orgId)) {
			MipOrganization mipOrganization = mipOrganizationMapper.selectByPrimaryKey(Integer.parseInt(orgId));
			if (mipOrganization != null) {
				Page page = new Page();
		        page.setCurrentPage(currentPage);
		        page.setSize(size);
//				文物局或者超级管理员或者区文委
				if ("1".equals(mipOrganization.getOrgTypeId()) || "0".equals(orgId) || "2".equals(mipOrganization.getOrgTypeId())) {
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("orgId", orgId);
					map.put("orgTypeId", mipOrganization.getOrgTypeId());
					if (StringUtils.isNotBlank(dataState)) {
						map.put("dataState", dataState);
					}
					//区文委
					if ("2".equals(mipOrganization.getOrgTypeId())) {
						List<Integer> orgIdList = new ArrayList<Integer>();
						List<MipOrganization> orgs = mipOrganizationMapper.getOrgList();
						List<MipOrganization> sonOrg = OrgUtil.getSonOrg(orgs,Integer.parseInt(orgId), true);
						for (MipOrganization org : sonOrg) {
							orgIdList.add(org.getId());
						}
						map.put("orgIdList", orgIdList);
					}
					Integer count = collectionSubmitMapper.countSubmitList(map);
					page.setAllRow(count);
				    Integer start = page.getStart();
				    map.put("start", start);
				    map.put("end", size);
					
					List<CollectionSubmit> list = collectionSubmitMapper.getSubmitList(map);
					for (CollectionSubmit collectionSubmit : list) {
						if (collectionSubmit.getUpdateDate() != null) {
							String pattern="yyyy年MM月dd日 HH时mm分";
							SimpleDateFormat sdf= new SimpleDateFormat(pattern);
							collectionSubmit.setUpdateDateStr(sdf.format(collectionSubmit.getUpdateDate()));
						} else {
							collectionSubmit.setUpdateDateStr("");
						}
						if ("1".equals(collectionSubmit.getDataState())) {
							collectionSubmit.setDataState("已完成");
						} else if ("0".equals(collectionSubmit.getDataState())) {
							collectionSubmit.setDataState("未完成");
						}
					}
					
					String jsonString = null;

			        jsonString = JSON.toJSONString(list);
			        jsonObject.put("code", 0);
			        jsonObject.put("msg", "");
			        jsonObject.put("count", page.getAllRow());
			        jsonObject.put("data", jsonString);
				} else {
					jsonObject.put("code", 1);
	                jsonObject.put("msg", "请登录！");
	                jsonObject.put("count", 0);
	                jsonObject.put("data", "");
	            	
				}
			} else {
				jsonObject.put("code", 1);
                jsonObject.put("msg", "请登录！");
                jsonObject.put("count", 0);
                jsonObject.put("data", "");
            	
			}
		} else {
			jsonObject.put("code", 1);
            jsonObject.put("msg", "请登录！");
            jsonObject.put("count", 0);
            jsonObject.put("data", "");
		}
		
		return jsonObject;
	}
}
