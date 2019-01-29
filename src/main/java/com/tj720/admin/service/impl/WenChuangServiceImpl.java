package com.tj720.admin.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipWenchuangMapper;
import com.tj720.admin.dto.CWenChuangDetailDto;
import com.tj720.admin.dto.CWenChuangDto;
import com.tj720.admin.dto.PictureSimpleDto;
import com.tj720.admin.model.CCompany;
import com.tj720.admin.model.MipWenchuang;
import com.tj720.admin.model.MipWenchuangCategory;
import com.tj720.admin.model.MipWenchuangExample;
import com.tj720.admin.model.MipWenchuangExample.Criteria;
import com.tj720.admin.service.CCompanyService;
import com.tj720.admin.service.PictureService;
import com.tj720.admin.service.WenChuangCategoryService;
import com.tj720.admin.service.WenChuangService;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;

@Service("wenChuangServiceImpl")
public class WenChuangServiceImpl extends BaseServiceImpl<MipWenchuang> implements WenChuangService {

	@Autowired
	private MipWenchuangMapper mipWenchuangMapper;
	@Autowired
	private CCompanyService cCompanyService;
	@Autowired
	private WenChuangCategoryService wenChuangCategoryService;
	@Autowired
	private PictureService pictureService;
	
	@Override
	public BaseDao<MipWenchuang> getBaseDao() {
		return mipWenchuangMapper;
	}

	@Override
	public List<CWenChuangDto> getAllPublished(Page page, Integer categoryId, String key) throws IllegalAccessException, InvocationTargetException {
		MipWenchuangExample example = new MipWenchuangExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusGreaterThan((byte)0);
		criteria.andPublishEqualTo((byte)1);
		criteria.andTypeEqualTo(2);
		if (!MyString.isEmpty(categoryId)) {
			criteria.andCategoryIdEqualTo(categoryId);
		}
		if (!MyString.isEmpty(key)) {
			criteria.andProductNameLike("%"+ key +"%");
		}
		int count = mipWenchuangMapper.countByExample(example);
		page.setAllRow(count);
		
		example.setOrderByClause("publish_time desc");
		example.setPageSize(page.getSize());
		example.setStartRow(page.getStart());
		
		List<MipWenchuang> list = mipWenchuangMapper.selectByExample(example);
		List<CWenChuangDto> dtoList = new ArrayList<CWenChuangDto>();
		if (!MyString.isEmpty(list)) {
			for (MipWenchuang mipWenchuang : list) {
				CWenChuangDto dto = new CWenChuangDto();
				BeanUtils.copyProperties(dto, mipWenchuang);
				//设置公司名称
				tranUserName(mipWenchuang, dto);
				//设置类别名称
				tranCategoryName(mipWenchuang, dto);
				//设置时间
				String dateToString = DateUtil.DateToString(mipWenchuang.getCreatetime(), DateStyle.YYYY_MM_DD_HH_MM);
				dto.setCreateTimeStr(dateToString);
				
				dtoList.add(dto);
			}
		}
		return dtoList;
	}

	private void tranCategoryName(MipWenchuang mipWenchuang, CWenChuangDto dto) {
		Integer categoryId2 = mipWenchuang.getCategoryId();
		MipWenchuangCategory category = wenChuangCategoryService.get(categoryId2+"");
		if (!MyString.isEmpty(category)) {
			dto.setCategoryName(category.getCategoryName());
		}
	}

	private void tranUserName(MipWenchuang mipWenchuang, CWenChuangDto dto) {
		String userId = mipWenchuang.getUserId();
		CCompany cCompany = cCompanyService.get(userId);
		if (!MyString.isEmpty(cCompany)) {
			dto.setUserName(cCompany.getCompanyName());
		}
	}

	@Override
	public CWenChuangDetailDto getCWenChuangDetail(String id) throws IllegalAccessException, InvocationTargetException {
		MipWenchuang mipWenchuang = mipWenchuangMapper.selectByPrimaryKey(id);
		CWenChuangDetailDto dto = new CWenChuangDetailDto();
		BeanUtils.copyProperties(dto, mipWenchuang);
		tranCategoryName(mipWenchuang, dto);
		//设置图片
		PictureSimpleDto pictureSimpleDto = pictureService.findPictureUrl(mipWenchuang.getPictureId());
		if (!MyString.isEmpty(pictureSimpleDto)) {
			dto.setPictureUrl(pictureSimpleDto.getPicUrl());
		}
		return dto;
	}

	@Override
	public int updatePublishDown(String id, String reason) {
		MipWenchuang mipWenchuang = new MipWenchuang();
		mipWenchuang.setId(id);
		mipWenchuang.setPublish((byte)2);
		mipWenchuang.setReason(reason);
		int update = mipWenchuangMapper.updateByPrimaryKeySelective(mipWenchuang);
		return update;
	}

	@Override
	public int updatebyCompanyId(String id, byte status) {
		MipWenchuang mipWenchuang = new MipWenchuang();
		mipWenchuang.setStatus((byte)status);
		MipWenchuangExample example = new MipWenchuangExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(id);
		int update = mipWenchuangMapper.updateByExampleSelective(mipWenchuang, example);
		return update;
	}
}
