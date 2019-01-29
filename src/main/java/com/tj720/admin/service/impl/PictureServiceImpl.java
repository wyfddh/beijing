package com.tj720.admin.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipPictureMapper;
import com.tj720.admin.dto.PictureSimpleDto;
import com.tj720.admin.model.MipPicture;
import com.tj720.admin.service.PictureService;
import com.tj720.mip.model.Picture;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;

@Service("pictureServiceImpl")
public class PictureServiceImpl extends BaseServiceImpl<MipPicture> implements PictureService {
	
	@Autowired
	private MipPictureMapper mipPictureMapper;
	@Autowired
	private Config config;
	
	@Override
	public BaseDao<MipPicture> getBaseDao() {
		return mipPictureMapper;
	}

	/**
	 * 通过pictureId查询图片的访问路径
	 */
	@Override
	public PictureSimpleDto findPictureUrl(String id){
		PictureSimpleDto simpleDto = new PictureSimpleDto();
		String pictureUrl = "";
		if (!MyString.isEmpty(id)) {
			MipPicture picture = mipPictureMapper.selectByPrimaryKey(id);
			if (!MyString.isEmpty(picture)) {
				pictureUrl = MyString.isEmpty(config.getRootUrl()) ? "" : (config.getRootUrl() + picture.getUrl()); 
				simpleDto.setPicWidth(picture.getPicWidth());
				simpleDto.setPicHeight(picture.getPicHeight());
			}
		}
		simpleDto.setPicUrl(pictureUrl);
		return simpleDto;
	}

	@Override
	public List<MipPicture> findPicturesByIds(String[] ids) {
		return mipPictureMapper.selectPicturesByIds(Arrays.asList(ids));
	}

	@Override
	public MipPicture getByObjectId(String id) {
		Integer count = mipPictureMapper.countByObjectId(id);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("count", count);
		return mipPictureMapper.getByObjectId(map);
	}

}
