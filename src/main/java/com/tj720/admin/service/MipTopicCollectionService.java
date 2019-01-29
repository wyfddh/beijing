package com.tj720.admin.service;

import java.util.HashMap;
import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.dto.MipTopicCollectionDto;
import com.tj720.admin.model.MipTopic;
import com.tj720.admin.model.MipTopicCollection;
import com.tj720.admin.model.MipTopicCollectionExample;


/**
 * 
 * @author cm
 * @date 2017年6月20日 下午12:05:12
 */
public interface MipTopicCollectionService extends BaseService<MipTopicCollection>{

	/**
	 * 根据专题id，和藏品id查询数据
	 * @param topicId
	 * @param collectionId
	 * @return
	 */
	public MipTopicCollection getByTopicidAndCollectionId(String topicId, String collectionId);
	
	public List<MipTopicCollection> selectByExample(MipTopicCollectionExample example);
	
	public int updateById(MipTopicCollection mipTopicCollection);
	
	/**
	 * 根据主表id，获取藏品列表
	 * @param topicId
	 * @return
	 */
	public List<MipTopicCollectionDto> getListByTopicId(String topicId);
	
	public int getMaxSort(String topicId);
	
	public int batchSave(List<MipTopicCollection> list);
	
	public List<MipTopic> selectTopicByCollection(String collectionId);
	
	HashMap<String,Object> getTopicById(String topicId);
	
	public int deleteByTopicId(MipTopicCollection mipTopicCollection);
	
	/**
	 * 藏品取消公开后，删除专题中的藏品
	 * @param collectionId
	 * @return
	 */
	public int deleteByCollectionId(List<String> collectionIds);
	
	/**
	 * 根据多个专题id，获取藏品列表
	 * @param topics
	 * @return
	 */
	public List<MipTopicCollectionDto> getListByTopicIds(List<String> topics);
	
}
