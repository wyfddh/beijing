package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.MipOpenCollectionInfoMapper;
import com.tj720.admin.dao.map.MipOpenCulturalrelicInfoMapper;
import com.tj720.admin.dao.map.MipOpenFossilInfoMapper;
import com.tj720.admin.model.MipOpenCollectionInfo;
import com.tj720.admin.model.MipOpenCollectionInfoExample;
import com.tj720.admin.model.MipOpenCollectionInfoExample.Criteria;
import com.tj720.admin.model.MipOpenCulturalrelicInfoExample;
import com.tj720.admin.model.MipOpenFossilInfo;
import com.tj720.admin.model.MipOpenFossilInfoExample;
import com.tj720.admin.model.MipPicture;
import com.tj720.admin.service.MipOpenCollectionInfoService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.admin.model.MipOpenCulturalrelicInfo;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.OrgUtil;
import com.tj720.mip.utils.Page;

@Service
public class MipOpenCollectionInfoServiceImpl implements MipOpenCollectionInfoService {

	@Autowired
	private MipOpenCollectionInfoMapper mipOpenCollectionInfoMapper;
	@Autowired
	MipPictureServiceImpl mipPictureServiceImpl;
	@Autowired
	private MipOrganizationService organizationService;
	@Autowired
	private MipOpenCulturalrelicInfoMapper mipOpenCulturalrelicInfoMapper;
	
	@Autowired
	private MipOpenFossilInfoMapper mipOpenFossilInfoMapper;
	@Autowired
	Config config;
	@Override
	public List<MipOpenCollectionInfo> listCollectionInfo(MipOpenCollectionInfo openCollectionInfo,Page page,String orgId) {
		MipOpenCollectionInfoExample example = new MipOpenCollectionInfoExample();
		Criteria createCriteria = example.createCriteria();
//		createCriteria.andStatusEqualTo((byte)1);
		//条件
		//名称
		if(!MyString.isEmpty(openCollectionInfo.getName())) {
			createCriteria.andNameLike("%"+openCollectionInfo.getName()+"%");
		}
		//普查编号
		if(!MyString.isEmpty(openCollectionInfo.getGsNo())) {
			createCriteria.andGsNoEqualTo(openCollectionInfo.getGsNo());
		}
		//年代
		if(!MyString.isEmpty(openCollectionInfo.getYearType())) {
			createCriteria.andYearTypeEqualTo(openCollectionInfo.getYearType());
		}
		//收藏单位
		if(!MyString.isEmpty(openCollectionInfo.getCollectionUnit())) {
			createCriteria.andCollectionUnitEqualTo(openCollectionInfo.getCollectionUnit());
		} else if (!orgId.equals("0")) {
			List<String> list = new ArrayList<String>();
			List<com.tj720.admin.model.MipOrganization> orgList = organizationService.getList();
			List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(orgList, Integer.parseInt(orgId), true);
			for (com.tj720.admin.model.MipOrganization mipOrganization : sonOrg) {
				if (mipOrganization != null) {
					list.add(mipOrganization.getId().toString());
				}
			}
			createCriteria.andCollectionUnitIn(list);
		}
		//文物类别
		if(!MyString.isEmpty(openCollectionInfo.getCollectionsCategory())) {
			createCriteria.andCollectionsCategoryEqualTo(openCollectionInfo.getCollectionsCategory());
		}
		//文物或化石
		if(!MyString.isEmpty(openCollectionInfo.getCollectionType())) {
			createCriteria.andCollectionTypeEqualTo(openCollectionInfo.getCollectionType());
		}
		int countByExample = mipOpenCollectionInfoMapper.countByExample(example);
		page.setAllRow(countByExample);
		example.setStartPage(page.getStart());
		example.setSize(page.getSize());
		List<MipOpenCollectionInfo> selectByExample = mipOpenCollectionInfoMapper.selectByExample(example);
		return selectByExample;
	}
	
	public List<MipOpenCulturalrelicInfo> listCollectionInfo4Culturalrelic(MipOpenCulturalrelicInfo openCollectionInfo,Page page,String orgId) {
		MipOpenCulturalrelicInfoExample example = new MipOpenCulturalrelicInfoExample();
		MipOpenCulturalrelicInfoExample.Criteria createCriteria = example.createCriteria();
//		createCriteria.andStatusEqualTo((byte)1);
		//条件
		//名称
		createCriteria.andGjOpenEqualTo((byte)2);
		if(!MyString.isEmpty(openCollectionInfo.getName())) {
			createCriteria.andNameLike("%"+openCollectionInfo.getName()+"%");
		}
		//普查编号
		if(!MyString.isEmpty(openCollectionInfo.getGsNo())) {
			createCriteria.andGsNoEqualTo(openCollectionInfo.getGsNo());
		}
		//年代
		if(!MyString.isEmpty(openCollectionInfo.getYearType())) {
			createCriteria.andYearTypeEqualTo(openCollectionInfo.getYearType());
		}
		//收藏单位
		if(!MyString.isEmpty(openCollectionInfo.getCollectionUnit())) {
			createCriteria.andCollectionUnitEqualTo(openCollectionInfo.getCollectionUnit());
		} 
		//博物馆只能看自己的数据（已屏蔽）
//		else if (!orgId.equals("0")) {
//			List<String> list = new ArrayList<String>();
//			List<com.tj720.admin.model.MipOrganization> orgList = organizationService.getList();
//			List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(orgList, Integer.parseInt(orgId), true);
//			for (com.tj720.admin.model.MipOrganization mipOrganization : sonOrg) {
//				if (mipOrganization != null) {
//					list.add(mipOrganization.getId().toString());
//				}
//			}
//			createCriteria.andCollectionUnitIn(list);
//		}
		//文物类别
		if(!MyString.isEmpty(openCollectionInfo.getCollectionsCategory())) {
			createCriteria.andCollectionsCategoryEqualTo(openCollectionInfo.getCollectionsCategory());
		}
		//文物或化石
		if(!MyString.isEmpty(openCollectionInfo.getCollectionType())) {
			createCriteria.andCollectionTypeEqualTo(openCollectionInfo.getCollectionType());
		}
		int countByExample = mipOpenCulturalrelicInfoMapper.countByExample(example);
		page.setAllRow(countByExample);
		example.setStartPage(page.getStart());
		example.setSize(page.getSize());
		List<MipOpenCulturalrelicInfo> selectByExample = mipOpenCulturalrelicInfoMapper.selectByExample(example);
		return selectByExample;
	}
	
	public List<MipOpenFossilInfo> listCollectionInfo4Fossil(MipOpenFossilInfo openCollectionInfo,Page page,String orgId) {
		MipOpenFossilInfoExample example = new MipOpenFossilInfoExample();
		MipOpenFossilInfoExample.Criteria createCriteria = example.createCriteria();
//		createCriteria.andStatusEqualTo((byte)1);
		//条件
		//名称
		createCriteria.andGjOpenEqualTo((byte)2);
		if(!MyString.isEmpty(openCollectionInfo.getName())) {
			createCriteria.andNameLike("%"+openCollectionInfo.getName()+"%");
		}
		//普查编号
		if(!MyString.isEmpty(openCollectionInfo.getGsNo())) {
			createCriteria.andGsNoEqualTo(openCollectionInfo.getGsNo());
		}
		//年代
		if(!MyString.isEmpty(openCollectionInfo.getYearType())) {
			createCriteria.andYearTypeEqualTo(openCollectionInfo.getYearType());
		}
		//收藏单位
		if(!MyString.isEmpty(openCollectionInfo.getCollectionUnit())) {
			createCriteria.andCollectionUnitEqualTo(openCollectionInfo.getCollectionUnit());
		} 
		//博物馆只能看自己的数据（已屏蔽）
//		else if (!orgId.equals("0")) {
//			List<String> list = new ArrayList<String>();
//			List<com.tj720.admin.model.MipOrganization> orgList = organizationService.getList();
//			List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(orgList, Integer.parseInt(orgId), true);
//			for (com.tj720.admin.model.MipOrganization mipOrganization : sonOrg) {
//				if (mipOrganization != null) {
//					list.add(mipOrganization.getId().toString());
//				}
//			}
//			createCriteria.andCollectionUnitIn(list);
//		}
		//文物类别
		if(!MyString.isEmpty(openCollectionInfo.getCollectionsCategory())) {
			createCriteria.andCollectionsCategoryEqualTo(openCollectionInfo.getCollectionsCategory());
		}
		//文物或化石
		if(!MyString.isEmpty(openCollectionInfo.getCollectionType())) {
			createCriteria.andCollectionTypeEqualTo(openCollectionInfo.getCollectionType());
		}
		int countByExample = mipOpenFossilInfoMapper.countByExample(example);
		page.setAllRow(countByExample);
		example.setStartPage(page.getStart());
		example.setSize(page.getSize());
		List<MipOpenFossilInfo> selectByExample = mipOpenFossilInfoMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public JsonResult getCollectionList(String collectionsCategory,String city,String year, String name, Integer isHighQuality,Page page,String type,String userid) {
		// TODO Auto-generated method stub
		int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		Integer allCounts = mipOpenCollectionInfoMapper.countCollectionList(collectionsCategory, city, year, name, isHighQuality);
		page.setAllRow(allCounts);
		List<HashMap<String, Object>> map = mipOpenCollectionInfoMapper.getCollectionList(userid, collectionsCategory, city, year, name, isHighQuality, startRow, page.getSize());
		if(map.size()>0&& !map.isEmpty()){
			for (int i = 0; i < map.size(); i++) {
				HashMap temp = map.get(i);
				if(null != temp.get("pictureIds"))
				{
					List<MipPicture> pics = new ArrayList<MipPicture>();
					String picUrl = temp.get("pictureIds").toString();
					String id = temp.get("id").toString();
					if(picUrl.contains(",")){
						String[] picArray = picUrl.split(",");
						Set<String> picIds = new HashSet<>();
						for (int j = 0; j < picArray.length; j++) {
							if(!picIds.contains(picArray[j])) {		//判断图片id是否已经查询过，如果没有查询过，则查询，并插入到已经查询的队列中
								List<MipPicture> picture = mipPictureServiceImpl.getPictureListById(picArray[j]);
								if(picture != null && picture.size() > 0) {
									pics.addAll(picture);
								}
								picIds.add(picArray[j]);
							}
						}
					}else{
						pics = mipPictureServiceImpl.getPictureListById(picUrl);
					}
					if(pics == null || pics.size() == 0) {
//						if(type.equals("1")){
							pics = mipPictureServiceImpl.getPictureListByObjectId(id);
//						}
					}
					for (MipPicture mipPicture : pics) {
						if(mipPicture != null && !StringUtils.isBlank(mipPicture.getUrl())) {
							if(mipPicture.getUrl().indexOf(config.getRootUrl())==-1)
							{
								mipPicture.setUrl(config.getRootUrl() + mipPicture.getThumb2());
							}
						}
					}
					//查询关联的图片列表					
					temp.put("pics", pics);
					temp.put("fAudio", config.getRootUrl()+temp.get("fAudio"));
				}
				
			}
		}		
		return new JsonResult(1,map,page);
	}

	@Override
	public Integer countCollectionList(String collectionsCategory,String city,String year, String name, Integer isHighQuality) {
		// TODO Auto-generated method stub
		Integer allCounts = mipOpenCollectionInfoMapper.countCollectionList(collectionsCategory, city, year, name, isHighQuality);
		return allCounts;
	}

	@Override
	public JsonResult getCollectionCategoryList(Page page) {
		int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		Integer allCounts = mipOpenCollectionInfoMapper.countCollectionCategoryList();
		page.setAllRow(allCounts);
		List<HashMap<String, Object>> map = mipOpenCollectionInfoMapper.getCollectionCategoryList(startRow, page.getSize());
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		if(null != map && map.size()>0){
			for (int i = 0; i < map.size(); i++) {
				//查询关联的图片列表
				List<MipPicture> pics = new ArrayList<MipPicture>();
				String picUrl = map.get(i).get("pictureIds").toString();
				if(picUrl.contains(",")){
					String[] picArray = picUrl.split(",");
					Set<String> picIds = new HashSet<>();
					for (int j = 0; j < picArray.length; j++) {
						if(!picIds.contains(picArray[j])) {		//判断图片id是否已经查询过，如果没有查询过，则查询，并插入到已经查询的队列中
							List<MipPicture> picture = mipPictureServiceImpl.getPictureListById(picArray[j]);
							if(picture != null && picture.size() > 0) {
								pics.addAll(picture);
							}
							picIds.add(picArray[j]);
						}
					}
				}else{
					pics = mipPictureServiceImpl.getPictureListById(picUrl);
				}
				for (MipPicture mipPicture : pics) {
					if(mipPicture != null && !StringUtils.isBlank(mipPicture.getUrl())) {
						if(mipPicture.getUrl().indexOf(config.getRootUrl())==-1)
						{
							mipPicture.setUrl(config.getRootUrl() + mipPicture.getUrl());
						}
					}
				}
				map.get(i).put("pics", pics);
				if(map.get(i).get("fAudio") != null && !StringUtils.isBlank(map.get(i).get("fAudio").toString())) {
					map.get(i).put("fAudio", config.getRootUrl()+map.get(i).get("fAudio"));
				}
			}
		}
//		for (int i = 0; i < map.size(); i++) {
//			result.add(addPicUrl(map.get(i)));
//		}
		return new JsonResult(1,map,page);
	}


	@Override
	public Map<String, Object> getCollectionById(String id, String userid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = mipOpenCollectionInfoMapper.getCollectionById(id, userid);
		if(null != map.get("pictureIds"))
		{
			String picUrl = map.get("pictureIds").toString();
			//查询关联的图片列表
			List<MipPicture> pics = new ArrayList<MipPicture>();
			if(picUrl.contains(",")){
				String[] picArray = picUrl.split(",");
				Set<String> picIds = new HashSet<>();
				for (int j = 0; j < picArray.length; j++) {
					if(!picIds.contains(picArray[j])) {		//判断图片id是否已经查询过，如果没有查询过，则查询，并插入到已经查询的队列中
						List<MipPicture> picture = mipPictureServiceImpl.getPictureListById(picArray[j]);
						if(picture != null && picture.size() > 0) {
							pics.addAll(picture);
						}
						picIds.add(picArray[j]);
					}
				}
			}else{
				pics = mipPictureServiceImpl.getPictureListById(picUrl);
			}
			if(pics == null || pics.size() == 0) {
				pics = mipPictureServiceImpl.getPictureListByObjectId(id);
			}
			for (MipPicture mipPicture : pics) {
				if(mipPicture != null && !StringUtils.isBlank(mipPicture.getUrl())) {
					mipPicture.setUrl(config.getRootUrl() + mipPicture.getUrl());
					System.out.println(mipPicture.getId());
				}
			}
			map.put("pics", pics);
			if(map.get("fAudio") != null && !StringUtils.isBlank(map.get("fAudio").toString())) {
				map.put("fAudio", config.getRootUrl()+map.get("fAudio"));
			}
		}
		return map;
	}

	@Override
	public Integer countCollectionCategoryList() {
		// TODO Auto-generated method stub
		Integer allCounts = mipOpenCollectionInfoMapper.countCollectionCategoryList();
		return allCounts;
	}

	@Override
	public List<Map<String, Object>> getCollectionOtherList(String orgId, String currentId, Integer size) {
		List<Map<String, Object>> collectionOtherList = mipOpenCollectionInfoMapper.getCollectionOtherList(orgId, currentId, size);
		for (Map<String, Object> map : collectionOtherList) {
			String picUrl = map.get("pictureIds").toString();
			List<MipPicture> pics = new ArrayList<MipPicture>();
			if(!StringUtils.isBlank(picUrl)) {
				if(picUrl.contains(",")){
					String[] picArray = picUrl.split(",");
					Set<String> picIds = new HashSet<>();
					for (int j = 0; j < picArray.length; j++) {
						if(!picIds.contains(picArray[j])) {		//判断图片id是否已经查询过，如果没有查询过，则查询，并插入到已经查询的队列中
							List<MipPicture> picture = mipPictureServiceImpl.getPictureListById(picArray[j]);
							if(picture != null && picture.size() > 0) {
								pics.addAll(picture);
							}
							picIds.add(picArray[j]);
						}
					}
				}else {
					pics = mipPictureServiceImpl.getPictureListById(picUrl);
				}
				for (MipPicture mipPicture : pics) {
					if(mipPicture != null && !StringUtils.isBlank(mipPicture.getUrl())) {
						mipPicture.setUrl(config.getRootUrl() + mipPicture.getThumb2());
						System.out.println(mipPicture.getId());
					}
				}
				map.put("pics", pics);
				map.put("fAudio", config.getRootUrl()+map.get("fAudio"));
			}
		}
		return collectionOtherList;
	}

	@Override
	public int update(MipOpenCollectionInfo collection) {
		return mipOpenCollectionInfoMapper.updateByPrimaryKeySelective(collection);
	}
	
	public HashMap<String,Object> addPicUrl(HashMap<String,Object> map){
		if(map.containsKey("pics")){
			List<MipPicture> pics = (List<MipPicture>)map.get("pics");
			for (int i = 0; i < pics.size(); i++) {
				pics.get(i).setUrl(config.getRootUrl() + pics.get(i).getUrl());
			}
		}
		return map;
	}

}
