package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.dto.MipTopicCollectionDto;
import com.tj720.admin.model.MipTopic;
import com.tj720.mip.utils.Page;


/**
 * 
 * @author zwp
 * @date 2017年6月20日 下午12:05:12
 */
public interface MipTopicService extends BaseService<MipTopic>{
	
	/**
	 * 根据key查询专题列表
	 * @param key
	 * @param status
	 * @param orgId
	 * @param page
	 * @return
	 */
	public List<MipTopic> getListByKey(String key, String status, String orgId, List<String> orgIdList, Page page, String museumId);
	
	/**
	 * 根据字段值进行更新
	 * @param topic
	 * @return
	 */
	public int updateByidSelect(MipTopic topic);
	
	/**
	 * 更新所有字段，如果weinull，则更新为null
	 * @param topic
	 * @return
	 */
	public int updateByid(MipTopic topic);
	
	/**
	 * 根据orgId查询专题列表
	 * @param orgId
	 * @return
	 */
	public List<MipTopic> getListByOrgId(String orgId);
	
	public List<MipTopic> getListByOrgIdAndTopicId(String orgId,String TopicId);
	/**
	 * 藏品添加到专题
	 * @param id
	 * @param topicId
	 * @return
	 */
	public int addToTopic(String id, String topicId);
	
	/**
	 * 获取选择藏品列表
	 * @param orgId
	 * @param topicId
	 * @return
	 */
	public List<MipTopicCollectionDto> getCollectionList(List<com.tj720.admin.model.MipOrganization> orgId, String topicId, MipTopicCollectionDto search, Page page);
	
}
