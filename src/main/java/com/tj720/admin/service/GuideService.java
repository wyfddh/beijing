/**
 * 
 */
package com.tj720.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tj720.admin.model.MipTour;
import com.tj720.mip.dto.EveryDayMuseumDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Page;

/**
 * @author 程荣凯
 *
 */
@Service
public interface GuideService {
	/**
	 * 获取导览详情-博物馆展览
	 * @return
	 */
	public List<Map<String, Object>> getBjMuseumBaseInfoList();
	
	/**
	 * 获取导览详情-博物馆资料
	 * @param museumId 博物馆Id
	 * @return
	 */
	public Map<String, Object> getBjMuseumBaseInfo(String museumId, String userid);
	/**
	 * 获取导览详情-博物馆藏品
	 * @param museumId 博物馆ID
	 * @return
	 */
	public List<Map<String, Object>> getBjMuseumCollection(String museumId,String type, Page page);
	/**
	 * 获取导览详情-博物馆资讯交通
	 * @param museumId 博物馆ID
	 * @return
	 */
	public Map<String, Object> getBjMuseumInformation(String museumId);
	
	/**
	 * 获取博物馆数量及访问人数
	 * @return
	 */
	public Map<String, Object> getBjMuseumCountAndUserCount();
	
	//首页轮播图
	List<Map<String, Object>> getIndexCarousels(String carouselPositionId);
	
	//九宫格
	JsonResult getMuseumImageList(String museumId,Page page);
	
	List<Map<String, Object>> getSpreadtrumsByKeywordPage(String museumId,String type, Page page);
	
	List<Map<String, Object>> getBjMuseumConditionList(String area,String name);
	
	/**
	 * 根据博物馆id获取虚拟展厅数据
	 * @param orgId
	 * @return
	 */
	List<Map<String, Object>> getVirtualByMuseumId(String orgId);
	
	/**
	 * 根据栏目唯一名称，获取文章信息
	 * @param uniqueName
	 * @param orgId
	 * @return
	 */
	List<Map<String, Object>> getArticleByUniqueName(String uniqueName, String orgId, Integer size);
	
	/**
	 * 根据博物馆名称、区域id，查找博物馆列表
	 * @param name
	 * @param area
	 * @return
	 */
	List<Map<String, Object>> getMuseumListByAreaAndKey(String name, String area);
	
	/**
	 * 根据博物馆名称、区域id，查找博物馆列表-分页
	 * @param name
	 * @param area
	 * @return
	 */
	List<Map<String, Object>> getMuseumListByAreaAndKey(String name, String area, Page page);
	
	/**
	 * 根据博物馆id查询藏品分类
	 * @param orgId
	 * @return
	 */
	List<Map<String, Object>> getCollectionTypeByMuseum(String orgId);

	List<EveryDayMuseumDto> getEveryDayMuseumList();
	/**
	 * 插入访问人数
	 * @param type 类型 默认为1
	 * @param count 访问人数
	 * @return
	 */
	boolean insertUserCount(String type,Integer count);
	
	/**
	 * 更新访问人数
	 * @param type  类型 默认为1
	 * @param count 访问人数
	 * @return
	 */
	boolean setUserCount(String type,Integer count);
	
	Integer getUserCount(String type);
	
	boolean addUserCount(String type);
	
	//移动端导览列表接口
	List<MipTour> getTourListByMuseumId(String museumId);
	
	//移动端-导览详情接口
		Map<String,Object> getTourDetail(String id);

	//移动端导览图片列表
	Map<String,Object> getPictureList(String id);

	//移动端导览藏品信息列表
	Map<String,Object> getCollectInfoList(String tourId,String collectionId);
}
