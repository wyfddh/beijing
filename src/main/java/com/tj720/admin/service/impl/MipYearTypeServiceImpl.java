package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipYearTypeMapper;
import com.tj720.admin.model.MipYearType;
import com.tj720.admin.model.MipYearTypeExample;
import com.tj720.admin.model.MipYearTypeExample.Criteria;
import com.tj720.admin.service.MipYearTypeService;
import com.tj720.mip.dto.YearTypeDto;
import com.tj720.mip.model.YearType;
import com.tj720.mip.utils.MyString;

@Service("MipYearTypeServiceImpl")
public class MipYearTypeServiceImpl extends BaseServiceImpl<MipYearType> implements MipYearTypeService{

	@Autowired
	MipYearTypeMapper mipYearTypeMapper;
	@Override
	public BaseDao<MipYearType> getBaseDao() {
		return mipYearTypeMapper;
	}
	//获取文物年代
	@Override
	public List<YearTypeDto> yearTypeList() {
		List<YearTypeDto> dtoList = new ArrayList<YearTypeDto>();
		MipYearTypeExample example = new MipYearTypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andCodeNotLike("1%");
		criteria.andCodeNotEqualTo("200000");
		criteria.andCodeNotEqualTo("300000");
		criteria.andCodeNotEqualTo("400000");
		example.setOrderByClause("sequence");
		List<MipYearType> yearList = mipYearTypeMapper.selectByExample(example);
		if(!MyString.isEmpty(yearList)){
			for(MipYearType list : yearList){
				YearTypeDto dto = new YearTypeDto();
				dto.setId(list.getId());
				dto.setName(list.getName());
				dtoList.add(dto);
			}
		}
		return dtoList;
	}
	//获取化石年代
	@Override
	public List<YearTypeDto> yearhsTypeList() {
		List<YearTypeDto> dtoList = new ArrayList<YearTypeDto>();
		MipYearTypeExample example = new MipYearTypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andCodeLike("1%");
		example.setOrderByClause("sequence");
		List<MipYearType> yearList = mipYearTypeMapper.selectByExample(example);
		if(!MyString.isEmpty(yearList)){
			for(MipYearType list : yearList){
				YearTypeDto dto = new YearTypeDto();
				dto.setId(list.getId());
				dto.setName(list.getPathName());
				
				dtoList.add(dto);
			}
		}
		return dtoList;
	}
	@Override
	public MipYearType getYearTypeById(String id) {
		return mipYearTypeMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<YearTypeDto> yearTypeByParentIdList(String parentId) {
		List<YearTypeDto> dtoList = new ArrayList<YearTypeDto>();
		MipYearTypeExample example = new MipYearTypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(parentId);
		example.setOrderByClause("sequence");
		List<MipYearType> yearList = mipYearTypeMapper.selectByExample(example);
		if(!MyString.isEmpty(yearList)){
			for(MipYearType list : yearList){
				YearTypeDto dto = new YearTypeDto();
				dto.setId(list.getId());
				dto.setName(list.getName());
				dtoList.add(dto);
			}
		}
		return dtoList;
	}
	@Override
	public List<YearType> getEraList(String eon) {
		
		return mipYearTypeMapper.getEraList(eon);
	}

}
