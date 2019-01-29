package com.tj720.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.MipUserTagsMapper;
import com.tj720.admin.model.MipUserTags;
import com.tj720.admin.service.MipUserTagsService;
@Service
public class MipUserTagsServiceImpl implements MipUserTagsService {

	@Autowired
	private MipUserTagsMapper mipUserTagsMapper;
	@Override
	public List<MipUserTags> getUserTags() {
		
		return mipUserTagsMapper.getUserTags();
	}

}
