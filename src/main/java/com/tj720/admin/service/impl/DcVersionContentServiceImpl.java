package com.tj720.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.DcVersionContentMapper;
import com.tj720.admin.dto.CollectionObjectDto;
import com.tj720.admin.dto.VersionContentDto;
import com.tj720.admin.model.DcVersionContent;
import com.tj720.admin.model.DcVersionContentExample;
import com.tj720.admin.model.DcVersionContentExample.Criteria;
import com.tj720.admin.model.MipCollectionCategory;
import com.tj720.admin.model.MipOpenCulturalrelicInfoWithBLOBs;
import com.tj720.admin.model.MipOpenFossilInfoWithBLOBs;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.MipPicture;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.model.MipYearType;
import com.tj720.admin.service.DcVersionContentService;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.IMipUserService;
import com.tj720.admin.service.MipCollectionCategoryService;
import com.tj720.admin.service.MipPictureService;
import com.tj720.admin.service.MipYearTypeService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.OrgUtil;

import net.sf.json.JSONObject;

@Service("DcVersionContentServiceImpl")
public class DcVersionContentServiceImpl extends BaseServiceImpl<DcVersionContent> implements DcVersionContentService{

	@Autowired
	DcVersionContentMapper dcVersionContentMapper;
	@Autowired
	IMipUserService mipUserService;
	@Autowired
	IMipOrganizationService mipOrganizationService;
	@Autowired
	MipCollectionCategoryService mipCollectionCategoryService;
	@Autowired
	MipYearTypeService mipYearTypeService;
	@Autowired
	MipPictureService mipPictureService;
	@Autowired
	Config config;
	
	@Override
	public BaseDao<DcVersionContent> getBaseDao() {
		return dcVersionContentMapper;
	}
	@Override
	public void insertDcVersionContent(DcVersionContent content) {
		dcVersionContentMapper.insertSelective(content);
	}
	@Override
	public DcVersionContent selectByVersionId(String versionId) {
		DcVersionContentExample example = new DcVersionContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andVersionIdEqualTo(versionId);
		example.setOrderByClause("creat_time desc");
		List<DcVersionContent> list = dcVersionContentMapper.selectByExample(example);
		if(!MyString.isEmpty(list)){
			return list.get(0);
		}else{
			return null;
		}
	}
	@Override
	public List<VersionContentDto> selectByVersionIdList(String versionId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<VersionContentDto> dtoList = new ArrayList<VersionContentDto>();
		DcVersionContentExample example = new DcVersionContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andVersionIdEqualTo(versionId);
		example.setOrderByClause("creat_time desc");
		List<DcVersionContent> contentList = dcVersionContentMapper.selectByExample(example);
		if(!MyString.isEmpty(contentList)){
			int num = 0;
			for(DcVersionContent list : contentList){
				num+=1;
				MipUser user = mipUserService.getUser(list.getUserId());
				VersionContentDto dto = new VersionContentDto();
				dto.setId(list.getId());
				dto.setVersion(list.getVersion());
				if(!MyString.isEmpty(user)){
					dto.setUserName(user.getName());
				}
				dto.setCreatTime(sdf.format(list.getCreatTime()));
				if(num==1){
					dto.setVersionType("当前版本");
				}else{
					dto.setVersionType("历史版本");
				}
				dtoList.add(dto);
			}
		}
		return dtoList;
	}
	@Override
	public CollectionObjectDto selectById(String id,int contentType) {
		DcVersionContent content = dcVersionContentMapper.selectByPrimaryKey(id);
		JSONObject obj = JSONObject.fromObject(content.getContent());
		CollectionObjectDto collectionObjectDto = null;
		if(1==contentType){
			MipOpenCulturalrelicInfoWithBLOBs info = (MipOpenCulturalrelicInfoWithBLOBs)JSONObject.toBean(obj,MipOpenCulturalrelicInfoWithBLOBs.class);
			collectionObjectDto = culturalrelicInfoWithBLOBs(info);
		}else{
			MipOpenFossilInfoWithBLOBs info = (MipOpenFossilInfoWithBLOBs)JSONObject.toBean(obj,MipOpenFossilInfoWithBLOBs.class);
			MipPicture picture = mipPictureService.getPictureByObjectId(info.getId());
			if(!MyString.isEmpty(picture.getThumb1())){
				info.setPictureIds(config.getImageUrl()+picture.getThumb1());;
			}
			collectionObjectDto = fossilInfoWithBLOBs(info);
		}
		collectionObjectDto.setVersion(content.getVersion());
		return collectionObjectDto;
	}
	public CollectionObjectDto culturalrelicInfoWithBLOBs(MipOpenCulturalrelicInfoWithBLOBs info){
		CollectionObjectDto dto = new CollectionObjectDto();
		MipPicture picture = mipPictureService.getPictureByObjectId(info.getId());
		if(picture !=null &&!MyString.isEmpty(picture.getThumb1())){
			dto.setImageUrl(config.getImageUrl()+picture.getThumb1());;
		}
		try {
			BeanUtils.copyProperties(dto, info);
			if(!MyString.isEmpty(info.getCollectionUnit())){
				MipOrganization org = mipOrganizationService.getOrganization(Integer.parseInt(info.getCollectionUnit()));
				dto.setOrganizationName(org.getName());
			}
			if(!MyString.isEmpty(info.getCollectionsCategory())){
				MipCollectionCategory category = mipCollectionCategoryService.getCollectionCategoryById(info.getCollectionsCategory());
				dto.setCollectionsCategory(category.getName());
			}
			if(!MyString.isEmpty(info.getYearType())){
				MipYearType yeatType = mipYearTypeService.getYearTypeById(info.getYearType());
				dto.setYearType(yeatType.getName());
			}
			if(!MyString.isEmpty(dto.getIsHighQuality())){
				if("1".equals(dto.getIsHighQuality())){
					dto.setIsHighQuality("普通");
				}else{
					dto.setIsHighQuality("精品");
				}
			}
			dto.setCollectionLevel(collectionLevel(info.getCollectionLevel()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public CollectionObjectDto fossilInfoWithBLOBs(MipOpenFossilInfoWithBLOBs info){
		CollectionObjectDto dto = new CollectionObjectDto();
		MipPicture picture = mipPictureService.getPictureByObjectId(info.getId());
		if(picture !=null &&!MyString.isEmpty(picture.getThumb1())){
			dto.setImageUrl(config.getImageUrl()+picture.getThumb1());;
		}
		try {
			BeanUtils.copyProperties(dto, info);
			if(!MyString.isEmpty(info.getCollectionUnit())){
				MipOrganization org = mipOrganizationService.getOrganization(Integer.parseInt(info.getCollectionUnit()));
				dto.setOrganizationName(org.getName());
			}
			if(!MyString.isEmpty(info.getCollectionsCategory())){
				MipCollectionCategory category = mipCollectionCategoryService.getCollectionCategoryById(info.getCollectionsCategory());
				dto.setCollectionsCategory(category.getName());
			}
			if(!MyString.isEmpty(info.getYearType())){
				dto.setYearType(info.getYearType());
			}else{
				MipYearType yeatTypeEon = mipYearTypeService.getYearTypeById(info.getYearTypeEon());
				MipYearType yeatTypeEra = mipYearTypeService.getYearTypeById(info.getYearTypeEra());
				MipYearType yeatTypeEpoch = mipYearTypeService.getYearTypeById(info.getYearTypeEpoch());
				dto.setYearTypeEon(yeatTypeEon.getName());
				dto.setYearTypeEra(yeatTypeEra.getName());
				dto.setYearTypeEpoch(yeatTypeEpoch.getName());
				dto.setYearType(yeatTypeEon.getName()+"."+yeatTypeEra.getName()+"."+yeatTypeEpoch.getName());
			}
			if(!MyString.isEmpty(dto.getIsHighQuality())){
				if("1".equals(dto.getIsHighQuality())){
					dto.setIsHighQuality("普通");
				}else{
					dto.setIsHighQuality("精品");
				}
			}
			dto.setCollectionLevel(collectionLevel(info.getCollectionLevel()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public String collectionLevel(String level){
		if("1".equals(level)){
			return "一级";
		}else if("2".equals(level)){
			return "二级";
		}else if("3".equals(level)){
			return "三级";
		}else if("4".equals(level)){
			return "一般";
		}else{
			return "未定级";
		}
	}
	@Override
	public int getContentCountByStatus(byte status) {
		DcVersionContentExample example = new DcVersionContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(status);
		return dcVersionContentMapper.countByExample(example);
	}
	@Override
	public int getContentCountByTime(String beginTime, String endTime,byte status,String orgId,List<MipOrganization> orglist) {
		DcVersionContentExample example = new DcVersionContentExample();
		Criteria criteria = example.createCriteria();
		Map<String,Object> requestMap = new HashMap<String, Object>();
		if(!MyString.isEmpty(beginTime) && !MyString.isEmpty(endTime)){
			requestMap.put("beginTime", beginTime);
			requestMap.put("endTime", endTime);
		}
		if(!MyString.isEmpty(status) && (1==status||2==status)){
			requestMap.put("status", status);
		}
		//文物局或者区文委登录
		List<String> orgIdList = new ArrayList<String>();
//		List<MipOrganization> orglist = new ArrayList<MipOrganization>();
//		List<MipOrganization> organizations = mipOrganizationService.getChildListByPid(Integer.valueOf(orgId), orglist);
		
		List<MipOrganization> organizations = OrgUtil.getSonOrg(orglist, Integer.valueOf(orgId), true);
		for(MipOrganization org:organizations){
			String typeId = org.getOrgTypeId();
			String id = String.valueOf(org.getId());
			//查博物馆，文物修复资质单位，其他文物收藏单位
			if("3".equals(typeId) ||"4".equals(typeId)||"5".equals(typeId)){
				orgIdList.add(id);
			}
		}
		requestMap.put("orgIdList", orgIdList);
		return dcVersionContentMapper.countByOrgList(requestMap);
	}
	
	@Override
	public int getByOrgList(byte status,List<String> orgList) {
		DcVersionContentExample example = new DcVersionContentExample();
		Criteria criteria = example.createCriteria();
		Map<String,Object> requestMap = new HashMap<String, Object>();
		requestMap.put("status", status);
		requestMap.put("orgIdList", orgList);
		return dcVersionContentMapper.countByOrgList(requestMap);
	}
	@Override
	public void updateInfo(DcVersionContent content) {
		dcVersionContentMapper.updateByPrimaryKeySelective(content);
	}
	@Override
	public int getByAreaIdCount(String areaId,byte status,String beginTime,String endTime) {
		DcVersionContentExample example = new DcVersionContentExample();
		if(!MyString.isEmpty(areaId)){
			example.setAreaId(Integer.parseInt(areaId));
		}else{
			example.setAreaId(0);
		}
		if(!MyString.isEmpty(status)){
			example.setStatus(status);
		}else{
			example.setStatus((byte)0);
		}
		if(!MyString.isEmpty(beginTime)&&!MyString.isEmpty(endTime)){
			example.setBeginTime(beginTime);
			example.setEndTime(endTime);
		}
		int count = dcVersionContentMapper.countByAreaCount(example);
		return count;
	}
	@Override
	public int getByOrgIdCount(int orgId, byte status) {
		DcVersionContentExample example = new DcVersionContentExample();
		if(!MyString.isEmpty(orgId)){
			example.setOrgId(orgId);
		}else{
			example.setOrgId(0);
		}
		if(!MyString.isEmpty(status)){
			example.setStatus(status);
		}else{
			example.setStatus((byte)0);
		}
		int count = dcVersionContentMapper.countByOrgCount(example);
		return count;
	}
	@Override
	public MipOpenCulturalrelicInfoWithBLOBs selectByCulturalrelic(String id) {
		DcVersionContent content = dcVersionContentMapper.selectByPrimaryKey(id);
		JSONObject obj = JSONObject.fromObject(content.getContent());
		MipOpenCulturalrelicInfoWithBLOBs info = (MipOpenCulturalrelicInfoWithBLOBs)JSONObject.toBean(obj,MipOpenCulturalrelicInfoWithBLOBs.class);
		return info;
	}
	@Override
	public MipOpenFossilInfoWithBLOBs selectByFossil(String id) {
		DcVersionContent content = dcVersionContentMapper.selectByPrimaryKey(id);
		JSONObject obj = JSONObject.fromObject(content.getContent());
		MipOpenFossilInfoWithBLOBs info = (MipOpenFossilInfoWithBLOBs)JSONObject.toBean(obj,MipOpenFossilInfoWithBLOBs.class);
		return info;
	}
	@Override
	public int getByOrgIdTimeCount(int orgId, byte status, String beginTime, String endTime) {
		DcVersionContentExample example = new DcVersionContentExample();
		if(!MyString.isEmpty(orgId)){
			example.setOrgId(orgId);
		}else{
			example.setOrgId(0);
		}
		if(!MyString.isEmpty(status)){
			example.setStatus(status);
		}else{
			example.setStatus((byte)0);
		}
		if(!MyString.isEmpty(beginTime)&&!MyString.isEmpty(endTime)){
			example.setBeginTime(beginTime);
			example.setEndTime(endTime);
		}
		int count = dcVersionContentMapper.countByOrgCount(example);
		return count;
	}
	
	@Override
	public int getByAreaIdCountNew(String areaId,byte status,String beginTime,String endTime) {
		DcVersionContentExample example = new DcVersionContentExample();
		if(!MyString.isEmpty(areaId)){
			example.setAreaId(Integer.parseInt(areaId));
		}else{
			example.setAreaId(0);
		}
		if(!MyString.isEmpty(status)){
			example.setStatus(status);
		}else{
			example.setStatus((byte)0);
		}
		if(!MyString.isEmpty(beginTime)&&!MyString.isEmpty(endTime)){
			example.setBeginTime(beginTime);
			example.setEndTime(endTime);
		}
		int count = dcVersionContentMapper.countByAreaCountNew(example);
		return count;
	}

}
