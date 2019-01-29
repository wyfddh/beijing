package com.tj720.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipCarouselPositionMapper;
import com.tj720.admin.model.MipCarouselPosition;
import com.tj720.admin.model.MipCarouselPositionExample;
import com.tj720.admin.model.MipCarouselPositionExample.Criteria;
import com.tj720.admin.service.MipCarouselPositionService;


@Service
public class MipCarouselPositionServiceimpl extends BaseServiceImpl<MipCarouselPosition> implements MipCarouselPositionService{

	@Autowired
	MipCarouselPositionMapper mipCarouselPositionMapper;
	
	@Override
	public BaseDao<MipCarouselPosition> getBaseDao() {
		return mipCarouselPositionMapper;
	}
	@Override
	public List<MipCarouselPosition> getPositionList() {
		MipCarouselPositionExample example = new MipCarouselPositionExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo((byte) 1);
		example.setOrderByClause("createTime");
		return mipCarouselPositionMapper.selectByExample(example);
	}

}
