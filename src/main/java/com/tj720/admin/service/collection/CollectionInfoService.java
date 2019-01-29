package com.tj720.admin.service.collection;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.tj720.mip.framework.JsonResult;

/**
 * @author wyf
 * @date 2018/10/27 15:04
 **/
@Service
public interface CollectionInfoService {

    JSONObject getCollectionInfoList(String key, String collectionTexture, String degreeDisability,String exhibiting,
            String collectionComeFrom, String saveState, String org, String screenState, String repertoryState,
            String collectionCategory, String collectionYearType, String collectionLevel,
            String autoCheck,String orgId, Integer currentPage, Integer size);


    JsonResult modifyState(String[] arr1, String[] arr2, String state);

    JsonResult exhibiting(String[] arr1, String state);

    void batchExport(String repertoryState, String screenState, HttpServletResponse response);

    JsonResult collectionDetail(String id);


	JsonResult getCollectionCategoryHead(String repertoryState, String screenState, String orgId, String autoCheck);


	JsonResult getYearTypeHead(String repertoryState, String screenState, String collectionCategory, String orgId,
			String autoCheck);


	JsonResult getLevelHead(String repertoryState, String screenState, String collectionCategory,
			String collectionYearType, String orgId, String autoCheck);


	JsonResult getTabData(String repertoryState, String screenState, String orgId, String autoCheck);


	JsonResult filterSubmit(String orgId);


	JSONObject getSubmitList(String orgId, String dataState, Integer currentPage, Integer size);
}
