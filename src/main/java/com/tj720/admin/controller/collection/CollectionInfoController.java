package com.tj720.admin.controller.collection;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tj720.admin.service.collection.CollectionInfoService;
import com.tj720.mip.framework.JsonResult;


/**
 * @author wyf
 * @date 2018/10/27 15:04
 **/
@RestController
@RequestMapping("/collectionInfo")
public class CollectionInfoController {

    @Autowired
    private CollectionInfoService collectionInfoService;


    /**
     * @author wyf
     * @description   获取藏品数据列表，包括一普数据和革命文物数据
     * @date  2018/10/27 15:21
     * @param key     输入的搜索条件
     * @param collectionTexture   藏品质地
     * @param degreeDisability    完残程度
     * @param exhibiting           是否在展
     * @param collectionComeFrom  藏品来源
     * @param saveState            保存状态
     * @param org                   下拉框选中的收藏单位
     * @param screenState          筛选状态1待筛选2疑是3排除
     * @param repertoryState       1一普库2革命库
     * @param collectionCategory   藏品分类
     * @param collectionYearType   藏品年代
     * @param collectionLevel       藏品级别
     * @param autoCheck             自动筛选0关1开
     * @param orgId                当前登录用户的orgId
     * @param currentPage           当前页
     * @param size                   每页大小
     * @return net.sf.json.JSONObject
     */
    @RequestMapping("getCollectionInfoList")
    public JSONObject getCollectionInfoList(String key,String collectionTexture,String degreeDisability,String exhibiting,
            String collectionComeFrom,String saveState,String org,String screenState,String repertoryState,
            String collectionCategory, String collectionYearType, String collectionLevel,String autoCheck,String orgId,
            @RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "20") Integer size) {

        JSONObject jsonObject = collectionInfoService.getCollectionInfoList(key,collectionTexture,degreeDisability,
                exhibiting, collectionComeFrom,saveState,org,screenState,repertoryState,collectionCategory,
                collectionYearType, collectionLevel,autoCheck,orgId,currentPage,size);

        return jsonObject;
    }

    /**
     * @author wyf
     * @description  确定排除疑是
     * @date  2018/10/27 17:29
     * @param arr1   需要确定排除疑是的id数组
     * @param arr2   当点击确定同时排除本页其他按钮时将需要排除的放到这个数组
     * @param state  需要修改的状态1确定同时排除本页其他2疑是3排除4确认
     * @return com.tj720.controller.framework.JsonResult
     */
    @RequestMapping("modifyState")
    public JsonResult modifyState(@RequestParam(value = "arr1[]",required=false) String[] arr1,
            @RequestParam(value = "arr2[]",required=false) String[] arr2, String state) {

        JsonResult jsonResult = collectionInfoService.modifyState(arr1,arr2,state);

        return jsonResult;
    }

    /**
     * @author wyf
     * @description  是否在展
     * @date  2018/10/30 10:25
     * @param arr1   id数组
     * @param state  需要修改的状态
     * @return com.tj720.controller.framework.JsonResult
     */
    @RequestMapping("exhibiting")
    public JsonResult exhibiting(@RequestParam(value = "arr1[]",required=false) String[] arr1,String state) {

        JsonResult jsonResult = collectionInfoService.exhibiting(arr1,state);

        return jsonResult;
    }

    /**
     * @author wyf
     * @description  获取头部动态数据
     * @date  2018/10/30 17:31
     * @param repertoryState   1一普库2革命库
     * @param screenState       1待筛选2疑似3排除
     * @param collectionCategory    选中的分类
     * @param collectionYearType     选中的年代
     * @param  orgId              用户组织id
     * @param autoCheck             自动筛选0关1开
     * @return com.tj720.controller.framework.JsonResult
     */
    @RequestMapping("getTabData")
    public JsonResult getTabData(String repertoryState,String screenState,String collectionCategory,String collectionYearType,String orgId,String autoCheck) {
    	
    	JsonResult jsonResult = collectionInfoService.getTabData(repertoryState,screenState,orgId,autoCheck);
    	
    	return jsonResult;
    }
    
    @RequestMapping("getCollectionCategoryHead")
    public JsonResult getCollectionCategoryHead(String repertoryState,String screenState,String collectionCategory,String collectionYearType,String orgId,String autoCheck) {
    	
    	JsonResult jsonResult = collectionInfoService.getCollectionCategoryHead(repertoryState,screenState,orgId,autoCheck);
    	
    	return jsonResult;
    }
    
    @RequestMapping("getYearTypeHead")
    public JsonResult getYearTypeHead(String repertoryState,String screenState,String collectionCategory,String collectionYearType,String orgId,String autoCheck) {
    	
    	JsonResult jsonResult = collectionInfoService.getYearTypeHead(repertoryState,screenState,collectionCategory,orgId,autoCheck);
    	
    	return jsonResult;
    }
    
    @RequestMapping("getLevelHead")
    public JsonResult getLevelHead(String repertoryState,String screenState,String collectionCategory,String collectionYearType,String orgId,String autoCheck) {
    	
    	JsonResult jsonResult = collectionInfoService.getLevelHead(repertoryState,screenState,collectionCategory,collectionYearType,orgId,autoCheck);
    	
    	return jsonResult;
    }
    
    /**
     * @author wyf
     * @description   批量导出
     * @date  2018/10/30 17:32
     * @param repertoryState  1一普库2革命库
     * @param screenState      1待筛选2疑似3排除
     * @param response
     * @return void
     */
    @RequestMapping("batchExport")
    public void batchExport(String repertoryState,String screenState,HttpServletResponse response) {

        collectionInfoService.batchExport(repertoryState,screenState,response);

    }

    /**
     * @author wyf
     * @description   获取藏品详情
     * @date  2018/10/31 10:08
     * @param    id  藏品id
     * @return com.tj720.controller.framework.JsonResult
     */
    @RequestMapping("collectionDetail")
    public JsonResult collectionDetail(String id) {

        JsonResult jsonResult = collectionInfoService.collectionDetail(id);

        return jsonResult;
    }
    
    @RequestMapping("filterSubmit")
    public JsonResult filterSubmit(String orgId) {
    	
    	JsonResult jsonResult = collectionInfoService.filterSubmit(orgId);
    	
    	return jsonResult;
    }
    
    @RequestMapping("getSubmitList")
    public JSONObject getSubmitList(String orgId,String dataState,
    		@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "20") Integer size) {
    	
    	JSONObject jsonObject = collectionInfoService.getSubmitList(orgId,dataState,currentPage,size);
    	
    	return jsonObject;
    }
}
