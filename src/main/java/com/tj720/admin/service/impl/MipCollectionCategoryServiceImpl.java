package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipCollectionCategoryMapper;
import com.tj720.admin.dto.CollectionCategoryDto;
import com.tj720.admin.model.MipCollectionCategory;
import com.tj720.admin.model.MipCollectionCategoryExample;
import com.tj720.admin.model.MipCollectionCategoryExample.Criteria;
import com.tj720.admin.service.MipCollectionCategoryService;
import com.tj720.mip.utils.MyString;
@Service("MipCollectionCategoryServiceImpl")
public class MipCollectionCategoryServiceImpl extends BaseServiceImpl<MipCollectionCategory> implements MipCollectionCategoryService{

	@Autowired
	MipCollectionCategoryMapper mipCollectionCategoryMapper;
	@Override
	public BaseDao<MipCollectionCategory> getBaseDao() {
		return mipCollectionCategoryMapper;
	}
	@Override
	public List<CollectionCategoryDto> collectionCategoryList(int type) {
		MipCollectionCategoryExample example = new MipCollectionCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andOpenCountsGreaterThanOrEqualTo(0);
		if(type==1){
			criteria.andTypeNotLike("%化石%");
		}else{
			criteria.andTypeLike("%化石%");
		}
		List<MipCollectionCategory> collextionList = mipCollectionCategoryMapper.selectByExample(example);
		List<CollectionCategoryDto> dtoList = new ArrayList<CollectionCategoryDto>();
		if(!MyString.isEmpty(collextionList)){
			for(MipCollectionCategory list : collextionList){
				CollectionCategoryDto dto = new CollectionCategoryDto();
				dto.setId(list.getId());
				dto.setName(list.getShortName());
				dtoList.add(dto);
			}
		}
		return dtoList;
	}
	@Override
	public MipCollectionCategory getCollectionCategoryById(String id) {
		return mipCollectionCategoryMapper.selectByPrimaryKey(id);
	}
	@Override
	public String getCollectionSplitStringByIdList(List<String> ids) {
		return mipCollectionCategoryMapper.getCollectionSplitStringByIdList(ids);
	}

}
