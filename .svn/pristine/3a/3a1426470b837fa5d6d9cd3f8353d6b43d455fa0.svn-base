package com.tj720.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.MipTopicTypeMapper;
import com.tj720.admin.model.MipTopicType;
import com.tj720.admin.service.MipTopicTypeService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Page;

@Service("MipTopicTypeService")
public class MipTopicTypeServiceImpl implements MipTopicTypeService {

	@Autowired
	private MipTopicTypeMapper mipTopicTypeMapper;
	@Autowired
	private Config config;// 常量的取法
	
	@Override
	public List<MipTopicType> getList(String name, Page page) {
		page.setAllRow(mipTopicTypeMapper.countList(name));
		return mipTopicTypeMapper.getList(name, page.getStart(), page.getSize());
	}
	
	@Override
	public int update(MipTopicType topicType) {
		return mipTopicTypeMapper.updateByPrimaryKey(topicType);
	}
	
	@Override
	public int save(MipTopicType topicType) {
		return mipTopicTypeMapper.insert(topicType);
	}
	
	@Override
	public MipTopicType get(String id) {
		return mipTopicTypeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public int delete(String id) {
		return mipTopicTypeMapper.deleteByPrimaryKey(id);
	}
	
}
