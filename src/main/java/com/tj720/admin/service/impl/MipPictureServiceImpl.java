package com.tj720.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipPictureMapper;
import com.tj720.admin.model.MipPicture;
import com.tj720.admin.model.MipPictureExample;
import com.tj720.admin.model.MipPictureExample.Criteria;
import com.tj720.admin.service.MipPictureService;
import com.tj720.mip.utils.MyString;

@Service("MipPictureServiceImpl")
public class MipPictureServiceImpl extends BaseServiceImpl<MipPicture> implements MipPictureService{

	@Autowired
	MipPictureMapper mipPictureMapper;
	@Override
	public BaseDao<MipPicture> getBaseDao() {
		return mipPictureMapper;
	}
	@Override
	public List<MipPicture> getPictureListByObjectId(String id) {
		MipPictureExample example = new MipPictureExample();
		Criteria criteria = example.createCriteria();
		criteria.andObjectIdEqualTo(id);
		return mipPictureMapper.selectByExample(example);
	}
	@Override
	public MipPicture getPictureIsMain(String collectionId) {
		MipPictureExample example = new MipPictureExample();
		Criteria criteria = example.createCriteria();
		criteria.andObjectIdEqualTo(collectionId);
		criteria.andIsMainEqualTo((byte)2);
		List<MipPicture> list = mipPictureMapper.selectByExample(example);
		if(!MyString.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}
	@Override
	public List<MipPicture> getPictureListById(String id) {
		MipPictureExample example = new MipPictureExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		return mipPictureMapper.selectByExample(example);
	}

	@Override
	public MipPicture getPictureByObjectId(String collectionId) {
		MipPictureExample example = new MipPictureExample();
		Criteria criteria = example.createCriteria();
		criteria.andObjectIdEqualTo(collectionId);
		List<MipPicture> list = mipPictureMapper.selectByExample(example);
		if(!MyString.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}
}
