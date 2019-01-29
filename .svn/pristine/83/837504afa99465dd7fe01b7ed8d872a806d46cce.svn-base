package com.tj720.admin.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipTopicCollectionMapper;
import com.tj720.admin.dao.map.MipTopicMapper;
import com.tj720.admin.dto.MipTopicCollectionDto;
import com.tj720.admin.model.MipTopic;
import com.tj720.admin.model.MipTopicCollection;
import com.tj720.admin.service.MipTopicService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Page;

/**
*
* @author:cm
* @date:2018年8月8日16:42:23
*/
@Service("MipTopicService")
public class MipTopicServiceImpl extends BaseServiceImpl<MipTopic> implements MipTopicService {

	@Autowired
	private MipTopicMapper mipTopicMapper;
	@Autowired
	private MipTopicCollectionMapper mipTopicCollectionMapper;
	@Autowired
	private Config config;// 常量的取法
	
	@Override  
    public BaseDao<MipTopic> getBaseDao() {  
        return mipTopicMapper;  
    }

	@Override
	public List<MipTopic> getListByKey(String key, String status, String orgId, List<String> orgIdList, Page page, String museumId) {
		int countListByKey = mipTopicMapper.countListByKey(key, status, orgId, orgIdList, museumId);
		page.setAllRow(countListByKey);
		return mipTopicMapper.selectListByKey(key, status, orgId, orgIdList, page.getStart(), page.getSize(), museumId);
	}

	@Override
	public int updateByidSelect(MipTopic topic) {
		if(StringUtils.isBlank(topic.getId())) {
			return 0;
		}
		return mipTopicMapper.updateByPrimaryKeySelective(topic);
	}  
	
	@Override
	public int updateByid(MipTopic topic) {
		if(StringUtils.isBlank(topic.getId())) {
			return 0;
		}
		return mipTopicMapper.updateByPrimaryKey(topic);
	}  

	@Override
	public List<MipTopic> getListByOrgId(String orgId) {
		List<MipTopic> list = mipTopicMapper.getListByOrgId(orgId);
		if(list!=null && list.size()>0){
			for(MipTopic topic : list){
				if(!StringUtils.isBlank(topic.getIconUrl())){
					topic.setIconUrl(config.getImageUrl()+topic.getIconUrl());
				}
			}
		}
		return list;
	}
	
	@Override
	public List<MipTopic> getListByOrgIdAndTopicId(String orgId,String topicId) {
		List<MipTopic> list = mipTopicMapper.getListByOrgIdAndTopicId(orgId,topicId);
		if(list!=null && list.size()>0){
			for(MipTopic topic : list){
				if(!StringUtils.isBlank(topic.getIconUrl())){
					topic.setIconUrl(config.getImageUrl()+topic.getIconUrl());
				}
			}
		}
		return list;
	}

	@Override
	public int addToTopic(String id, String topicId) {
		MipTopicCollection model = new MipTopicCollection();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		model.setId(uuid);
		model.setCollectionId(id);
		model.setTopicId(topicId);
		int sort = mipTopicCollectionMapper.getMaxSort(topicId);
		model.setSort(sort);
		return mipTopicCollectionMapper.insertSelective(model);
	}

	@Override
	public List<MipTopicCollectionDto> getCollectionList(List<com.tj720.admin.model.MipOrganization> orgId, String topicId, MipTopicCollectionDto search, Page page) {
		int countCollectionList = mipTopicMapper.countCollectionList(orgId, topicId, search);
		page.setAllRow(countCollectionList);
		return mipTopicMapper.getCollectionList(orgId, topicId, search, page.getStart(), page.getSize());
	}
}
