package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.model.MipTopicType;
import com.tj720.mip.utils.Page;

/**
 * @author cm
 * @date 2018年11月28日15:51:18
 */
public interface MipTopicTypeService{
	
	List<MipTopicType> getList(String name, Page page);
	
	int update(MipTopicType topicType);
	
	int save(MipTopicType topicType);
	
	MipTopicType get(String id);
	
	int delete(String id); 
	
}
