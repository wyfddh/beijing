package com.tj720.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipWenchuangCategoryMapper;
import com.tj720.admin.model.MipWenchuangCategory;
import com.tj720.admin.model.MipWenchuangCategoryExample;
import com.tj720.admin.service.WenChuangCategoryService;

@Service("newWenChuangCategoryServiceImpl")
public class WenChuangCategoryServiceImpl extends BaseServiceImpl<MipWenchuangCategory> implements WenChuangCategoryService {

	@Autowired
	private MipWenchuangCategoryMapper mipWenchuangCategoryMapper;
	
	@Override
	public BaseDao<MipWenchuangCategory> getBaseDao() {
		return mipWenchuangCategoryMapper;
	}

	@Override
	public List<MipWenchuangCategory> getAll() {
		MipWenchuangCategoryExample example = new MipWenchuangCategoryExample();
		List<MipWenchuangCategory> list = mipWenchuangCategoryMapper.selectByExample(example);
		return list;
	}

}
