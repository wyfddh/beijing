package com.tj720.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;

import com.tj720.admin.common.vo.ConditionVo;
import com.tj720.admin.model.MipActivity;
import com.tj720.mip.dto.ActivityDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Page;


/**
 * 
 * @author zwp
 * @date 2017年6月20日 下午12:05:12
 */
public interface ActivityService{
	
	List<T> listActivity(ConditionVo<T> conditionVo);
	
	 //根据类型查询活动列表
    JsonResult getActivityListByType(String activityCategory,String orgid,Page page);
    //根据ID查询活动详情
    HashMap getActivityListById(String activityId);
    
    
    
    
    
    
    
    //后台接口
    MipActivity get(String id);
	
	List<ActivityDto> getActivityList(List<String> orgList, String key,String type,String startTime,String endTime, String status, Page page, String currentOrg);

	int save(MipActivity activity);

	int delete(String id);

	int update(MipActivity activity);

	int publish(String id, String status);

	JsonResult fullTextSearch(Page page, String key, String type);
	
	/**
	 * 自定义表单数据保存
	 * @param map		表单数据
	 * @param userId		用户id
	 * @param orgId		机构id
	 * @param type		活动类型 1：活动 2：讲座
	 * @return
	 */
	boolean saveDesignData(Map<String, Object> map, String userId, String orgId, String type);
}
