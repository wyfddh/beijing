package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.DcVersionSelectMapper;
import com.tj720.admin.dto.PictureSimpleDto;
import com.tj720.admin.dto.VersionSelectDto;
import com.tj720.admin.model.DcVersionSelect;
import com.tj720.admin.model.DcVersionSelectExample;
import com.tj720.admin.model.MipCollectionCategory;
import com.tj720.admin.model.MipOpenCulturalrelicInfoWithBLOBs;
import com.tj720.admin.model.MipOpenFossilInfoWithBLOBs;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.MipYearType;
import com.tj720.admin.model.DcVersionSelectExample.Criteria;
import com.tj720.admin.service.DcVersionSelectService;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.MipCollectionCategoryService;
import com.tj720.admin.service.MipOpenCulturalrelicInfoService;
import com.tj720.admin.service.MipOpenFossilInfoService;
import com.tj720.admin.service.MipYearTypeService;
import com.tj720.admin.service.PictureService;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;

@Service("DcVersionSelectServiceImpl")
public class DcVersionSelectServiceImpl extends BaseServiceImpl<DcVersionSelect> implements DcVersionSelectService{

	@Autowired
	DcVersionSelectMapper dcVersionSelectMapper;
	@Autowired
	MipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
	@Autowired
	IMipOrganizationService mipOrganizationService;
	@Autowired
	MipYearTypeService mipYearTypeService;
	@Autowired
	MipCollectionCategoryService mipCollectionCategoryService;
	@Autowired
	MipOpenFossilInfoService mipOpenFossilInfoService;
	@Autowired
	PictureService pictureService;
	
	@Override
	public BaseDao<DcVersionSelect> getBaseDao() {
		return dcVersionSelectMapper;
	}
	@Override
	public void insertDcVersionSelect(DcVersionSelect dcVersionSelect) {
		dcVersionSelectMapper.insertSelective(dcVersionSelect);
	}
	@Override
	public DcVersionSelect selectByCollectionId(String collectionId) {
		DcVersionSelectExample example = new DcVersionSelectExample();
		Criteria criteria = example.createCriteria();
		criteria.andCollectionIdEqualTo(collectionId);
		List<DcVersionSelect> list = dcVersionSelectMapper.selectByExample(example);
		if(!MyString.isEmpty(list)){
			return list.get(0);
		}else{
			return null;
		}
		
	}
	@Override
	public void updateDcVersionSelect(DcVersionSelect dcVersionSelect) {
		dcVersionSelectMapper.updateByPrimaryKeySelective(dcVersionSelect);
	}
	@Override
	public List<VersionSelectDto> getVersionSelectList(DcVersionSelect dcVersion, Page page,int collectionType,String orgTypeId,String orgId) {
		List<VersionSelectDto> versionDtoList = new ArrayList<VersionSelectDto>();
		DcVersionSelectExample example = new DcVersionSelectExample();
		Criteria criteria = example.createCriteria();
		criteria.andCollectionTypeEqualTo((byte)collectionType);
		if(!MyString.isEmpty(dcVersion.getName())){
			criteria.andNameLike("%"+dcVersion.getName()+"%");
		}
		if(!MyString.isEmpty(dcVersion.getCollectionType())){
			criteria.andCollectionTypeEqualTo(dcVersion.getCollectionType());
		}
		if(!MyString.isEmpty(dcVersion.getYearType())){
			criteria.andYearTypeEqualTo(dcVersion.getYearType());
		}
		if(!MyString.isEmpty(dcVersion.getYearTypeEon())){
			criteria.andYearTypeEonEqualTo(dcVersion.getYearTypeEon());
		}
		if(!MyString.isEmpty(dcVersion.getYearTypeEpoch())){
			criteria.andYearTypeEpochEqualTo(dcVersion.getYearTypeEpoch());
		}
		if(!MyString.isEmpty(dcVersion.getYearTypeEra())){
			criteria.andYearTypeEraEqualTo(dcVersion.getYearTypeEra());
		}
		if(!MyString.isEmpty(dcVersion.getCollectionUnit())){
			criteria.andCollectionUnitEqualTo(dcVersion.getCollectionUnit());
		}else {
			if("1".equals(orgTypeId) || "2".equals(orgTypeId)){
				
				//文物局或者区文委登录
				List<String> orgIdList = new ArrayList<String>();
				List<MipOrganization> orglist = new ArrayList<MipOrganization>();
				List<MipOrganization> organizations = mipOrganizationService.getChildListByPid(Integer.valueOf(orgId), orglist);
				for(MipOrganization org:organizations){
					String typeId = org.getOrgTypeId();
					String id = String.valueOf(org.getId());
					//查博物馆，文物修复资质单位，其他文物收藏单位
					if("3".equals(typeId) ||"4".equals(typeId)||"5".equals(typeId)){
						orgIdList.add(id);
					}
				}
				criteria.andCollectionUnitIn(orgIdList);
			}else{
				criteria.andCollectionUnitEqualTo(orgId);
			}
		}
		if(!MyString.isEmpty(dcVersion.getCollectionCategory())){
			criteria.andCollectionCategoryEqualTo(dcVersion.getCollectionCategory());
		}
		int count = dcVersionSelectMapper.countByExample(example);
		example.setSize(page.getSize());
		example.setStartPage(page.getStart());
		page.setAllRow(count);
		
		List<DcVersionSelect> versionList = dcVersionSelectMapper.selectByExample(example);
		if(!MyString.isEmpty(versionList)){
			if(1==collectionType){
				for(DcVersionSelect list : versionList){
					versionDtoList.add(getCulturalrelicInfo(list));
				}
			}else{
				for(DcVersionSelect list : versionList){
					versionDtoList.add(getFossilInfo(list));
				}
			}
		}
		return versionDtoList;
	}

	public VersionSelectDto getCulturalrelicInfo(DcVersionSelect list){
		VersionSelectDto dto = new VersionSelectDto();
		MipOpenCulturalrelicInfoWithBLOBs culturalrelicInfo = mipOpenCulturalrelicInfoService.getCulturalrelicInfo(list.getCollectionId());
		dto.setId(list.getId());
		dto.setName(list.getName());
		if(!MyString.isEmpty(list.getCollectionUnit())){
			MipOrganization org = mipOrganizationService.getOrganization(Integer.parseInt(list.getCollectionUnit()));
			if(org !=null){
				dto.setCollectionUnit(org.getName());
			}
		}
		MipYearType yearType = mipYearTypeService.getYearTypeById(list.getYearType());
		dto.setYearType(yearType.getName());
		MipCollectionCategory category = mipCollectionCategoryService.getCollectionCategoryById(list.getCollectionCategory());
		if(category !=null){
			dto.setCollectionCategory(category.getName());
		}
		if(!MyString.isEmpty(culturalrelicInfo)){
			dto.setFormerly(culturalrelicInfo.getFormerly());
			dto.setGsNo(culturalrelicInfo.getGsNo());
			if("1".equals(culturalrelicInfo.getCollectionLevel())){
				dto.setCollectionLevel("一级");
			}else if("2".equals(culturalrelicInfo.getCollectionLevel())){
				dto.setCollectionLevel("二级");
			}else if("3".equals(culturalrelicInfo.getCollectionLevel())){
				dto.setCollectionLevel("三级");
			}else if("4".equals(culturalrelicInfo.getCollectionLevel())){
				dto.setCollectionLevel("一般");
			}else{
				dto.setCollectionLevel("未定级");
			}
			if(!MyString.isEmpty(culturalrelicInfo.getPictureIds())){
				String[] ids = culturalrelicInfo.getPictureIds().split(",");
				PictureSimpleDto pictureDto = pictureService.findPictureUrl(ids[0]);
				if(pictureDto!=null){
					dto.setImageUrl(pictureDto.getPicUrl());
				}
			}
		}
		return dto;
	}
	
	public VersionSelectDto getFossilInfo(DcVersionSelect list){
		VersionSelectDto dto = new VersionSelectDto();
		MipOpenFossilInfoWithBLOBs fossilInfo = mipOpenFossilInfoService.getFossilInfo(list.getCollectionId());
		dto.setId(list.getId());
		dto.setName(list.getName());
		dto.setFormerly(fossilInfo!=null?fossilInfo.getFormerly():"");
		dto.setGsNo(fossilInfo!=null?fossilInfo.getGsNo():"");
		if(fossilInfo!=null){
			if("1".equals(fossilInfo.getCollectionLevel())){
				dto.setCollectionLevel("珍贵");
			}else if("2".equals(fossilInfo.getCollectionLevel())){
				dto.setCollectionLevel("一般");
			}else{
				dto.setCollectionLevel("其他");
			}
		}
		if(!MyString.isEmpty(list.getCollectionUnit())){
			MipOrganization org = mipOrganizationService.getOrganization(Integer.parseInt(list.getCollectionUnit()));
			dto.setCollectionUnit(org.getName());
		}
		if(!MyString.isEmpty(list.getYearTypeEon())){
			MipYearType yearTypeEon = mipYearTypeService.getYearTypeById(list.getYearTypeEon());
			dto.setYearTypeEon(yearTypeEon.getName());
		}
		if(!MyString.isEmpty(list.getYearTypeEra())){
			MipYearType yearTypeEra = mipYearTypeService.getYearTypeById(list.getYearTypeEra());
			dto.setYearTypeEon(yearTypeEra.getName());
		}
		if(!MyString.isEmpty(list.getYearTypeEpoch())){
			MipYearType yearTypeEpoch = mipYearTypeService.getYearTypeById(list.getYearTypeEpoch());
			dto.setYearTypeEon(yearTypeEpoch.getName());
		}
		if(fossilInfo!=null && !MyString.isEmpty(fossilInfo.getYearType())){
			dto.setYearType(fossilInfo.getYearType());
		}else{
			dto.setYearType(dto.getYearTypeEon()+"."+dto.getYearTypeEra()+"."+dto.getYearTypeEpoch());
		}
		MipCollectionCategory category = mipCollectionCategoryService.getCollectionCategoryById(list.getCollectionCategory());
		dto.setCollectionCategory(category.getName());
		if(fossilInfo!=null && !MyString.isEmpty(fossilInfo.getPictureIds())){
			String[] ids = fossilInfo.getPictureIds().split(",");
			PictureSimpleDto pictureDto = pictureService.findPictureUrl(ids[0]);
			dto.setImageUrl(pictureDto.getPicUrl());
		}
		return dto;
	}
}
