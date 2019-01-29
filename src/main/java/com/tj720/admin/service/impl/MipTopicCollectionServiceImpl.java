package com.tj720.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipTopicCollectionMapper;
import com.tj720.admin.dto.MipTopicCollectionDto;
import com.tj720.admin.model.MipTopic;
import com.tj720.admin.model.MipTopicCollection;
import com.tj720.admin.model.MipTopicCollectionExample;
import com.tj720.admin.model.MipTopicCollectionExample.Criteria;
import com.tj720.admin.service.MipTopicCollectionService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Tools;

/**
*
* @author:cm
* @date:2018年8月8日16:42:23
*/
@Service("MipTopicCollectionService")
public class MipTopicCollectionServiceImpl extends BaseServiceImpl<MipTopicCollection> implements MipTopicCollectionService {

	@Autowired
	private MipTopicCollectionMapper mipTopicCollectionMapper;
	@Autowired
	private Config config;
	@Autowired
	private UserService userService;
	
	@Override  
    public BaseDao<MipTopicCollection> getBaseDao() {  
        return mipTopicCollectionMapper;  
    }

	@Override
	public MipTopicCollection getByTopicidAndCollectionId(String topicId, String collectionId) {
		MipTopicCollectionExample example = new MipTopicCollectionExample();
		Criteria criteria = example.createCriteria();
		criteria.andTopicIdEqualTo(topicId);
		criteria.andCollectionIdEqualTo(collectionId);
		List<MipTopicCollection> selectByExample = mipTopicCollectionMapper.selectByExample(example);
		if(selectByExample != null && selectByExample.size() == 1) {
			return selectByExample.get(0);
		}
		return null;
	}

	@Override
	public List<MipTopicCollection> selectByExample(MipTopicCollectionExample example) {
		return mipTopicCollectionMapper.selectByExample(example);
	}

	@Override
	public int updateById(MipTopicCollection mipTopicCollection) {
		return mipTopicCollectionMapper.updateByPrimaryKey(mipTopicCollection);
	}

	@Override
	public List<MipTopicCollectionDto> getListByTopicId(String topicId) {
		List<MipTopicCollectionDto> selectListByTopicId = mipTopicCollectionMapper.selectListByTopicId(topicId);
		for (MipTopicCollectionDto mipTopicCollectionDto : selectListByTopicId) {
			if(StringUtils.isNotBlank(mipTopicCollectionDto.getUrl())) {
				mipTopicCollectionDto.setUrl(config.getRootUrl() + mipTopicCollectionDto.getUrl());
			}
		}
		return selectListByTopicId;
	}

	@Override
	public int getMaxSort(String topicId) {
		return mipTopicCollectionMapper.getMaxSort(topicId);
	}

	@Override
	public int batchSave(List<MipTopicCollection> list) {
		return mipTopicCollectionMapper.batchSave(list);
	}

	@Override
	public List<MipTopic> selectTopicByCollection(String collectionId) {
		return mipTopicCollectionMapper.selectTopicByCollection(collectionId);
	}
	
	@Override
	public HashMap<String, Object> getTopicById(String topicId) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = mipTopicCollectionMapper.getCollectionTopicById(topicId);
		if(null!=map){
			LoginInfoDto user = Tools.getUser();
			User user2 = userService.get(user.getId());
			if(user2.getOrgId().equals((String) map.get("publishOrg"))) {
				map.put("isShow", "1");
			}else {
				map.put("isShow", "0");
			}
			if(null != map.get("iconUrl")){
				map.put("iconUrl", config.getRootUrl()+map.get("iconUrl").toString());
			}
			if(null != map.get("startTime")&&null != map.get("endTime")){
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
				try {
					Date startTime = sdf1.parse(map.get("startTime").toString());
					Date endTime = sdf1.parse(map.get("endTime").toString());
					String time = sdf.format(startTime)+"-"+sdf.format(endTime);
					map.put("startTime", sdf.format(startTime));
					map.put("endTime", sdf.format(endTime));
					map.put("time", time);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}		
		return map;
	}
	
	public int deleteByTopicId(MipTopicCollection mipTopicCollection){
		return mipTopicCollectionMapper.deleteMipTopicCollection(mipTopicCollection);
	}

	@Override
	public int deleteByCollectionId(List<String> collectionIds) {
		return mipTopicCollectionMapper.deleteByCollectionId(collectionIds);
	}

	@Override
	public List<MipTopicCollectionDto> getListByTopicIds(List<String> topicIds) {
		return mipTopicCollectionMapper.getListByTopicIds(topicIds);
	}
	
}
