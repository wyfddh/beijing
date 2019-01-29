/**
 * 
 */
package com.tj720.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.BjMuseumBaseInfoMapper;
import com.tj720.admin.model.MipPicture;
import com.tj720.admin.model.MipToorCollection;
import com.tj720.admin.model.MipTour;
import com.tj720.admin.service.GuideService;
import com.tj720.admin.service.MipPictureService;
import com.tj720.mip.dto.EveryDayMuseumDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Page;

/**
 * @author 程荣凯
 *
 */
@Service
public class GuideServiceImpl implements GuideService{
	
	@Autowired
	BjMuseumBaseInfoMapper bjMuseumBaseInfoMapper;
	@Autowired
	MipPictureService mipPictureService;
	@Autowired
	MipPictureServiceImpl mipPictureServiceImpl;
	@Autowired
	Config config;
	@Override
	public List<Map<String,Object>> getBjMuseumBaseInfoList() {
		List<Map<String, Object>> BjMuseumBaseInfoList = bjMuseumBaseInfoMapper.getBjMuseumBaseInfoList();
		return BjMuseumBaseInfoList;
	}
	
	@Override
	public Map<String,Object> getBjMuseumBaseInfo(String museumId, String userid) {
		Map<String,Object> info = bjMuseumBaseInfoMapper.getBjMuseumBaseInfoByMuseumId(museumId, userid);
		if(info.get("imageUrl") != null) {
			info.put("imageUrl", config.getRootUrl() + info.get("imageUrl").toString());
		}
		return info;
	}

	@Override
	public List<Map<String, Object>> getBjMuseumCollection(String museumId, String type, Page page) {
		int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		Integer allCounts = bjMuseumBaseInfoMapper.countBjMuseumCollectionByMuseumId(museumId,type);
		page.setAllRow(allCounts);
		List<Map<String, Object>> collections = bjMuseumBaseInfoMapper.getBjMuseumCollectionByMuseumId(museumId,type,startRow, page.getSize());
		if(null != collections && collections.size()>0){
			
			for (int i = 0; i < collections.size(); i++) {
				Map<String, Object> temp = collections.get(i);
				if(temp.get("pictureIds") != null && !StringUtils.isBlank(temp.get("pictureIds").toString())) {
					temp.put("pics", getPics(temp.get("pictureIds")==null?"":temp.get("pictureIds").toString(), temp.get("id").toString()));
				}
			}
		}
		return collections;
	}

	@Override
	public Map<String, Object> getBjMuseumInformation(String museumId) {		
		Map<String, Object> info = bjMuseumBaseInfoMapper.getMuseumInformationByMuseumId(museumId);
		return info;
	}

	@Override
	public Map<String, Object> getBjMuseumCountAndUserCount() {
		Map<String, Object> countMap = bjMuseumBaseInfoMapper.getBjMuseumCountAndUserCount();
		return countMap;
	}

	@Override
	public List<Map<String, Object>> getIndexCarousels(String carouselPositionId) {
		return bjMuseumBaseInfoMapper.getIndexCarousels(carouselPositionId);
	}
	
	@Override
	public JsonResult getMuseumImageList(String museumId,Page page) {
		int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		Integer allCounts = bjMuseumBaseInfoMapper.countBjMuseumImageList(museumId);
		page.setAllRow(allCounts);
		List<Map<String, Object>> data = bjMuseumBaseInfoMapper.getBjMuseumImageList(museumId,startRow, page.getSize());
		if(null != data && data.size()>0){
			for (int i = 0; i < data.size(); i++) {
				Map<String, Object> temp = data.get(i);
				temp.put("url", addRootUrl(temp.get("url")==null?"":temp.get("url").toString()));
			}
		}		
		return new JsonResult(1,data,page);		
	}

	@Override
	public List<Map<String, Object>> getSpreadtrumsByKeywordPage(String museumId,String type, Page page) {
		int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		Integer allCounts = bjMuseumBaseInfoMapper.countBjMuseumSpreadtrumByMuseumId(museumId, type);
		page.setAllRow(allCounts);
		List<Map<String, Object>> bjMuseumSpreadtrumByMuseumId = bjMuseumBaseInfoMapper.getBjMuseumSpreadtrumByMuseumId(museumId,type, startRow,page.getSize());
		for (Map<String, Object> map : bjMuseumSpreadtrumByMuseumId) {
			if(map.get("picUrl") != null) {
				map.put("picUrl", config.getRootUrl() + map.get("picUrl").toString());
			}
		}
		return bjMuseumSpreadtrumByMuseumId;
	}

	@Override
	public List<Map<String, Object>> getBjMuseumConditionList(String area, String name) {		
		return bjMuseumBaseInfoMapper.getBjMuseumConditionList(area, name);
	}
	private String addRootUrl(String url){
		if(null != url && !"".equals(url)){
			return config.getRootUrl() + url;
		}
		else{
			return url;
		}
	}
	private List<MipPicture> getPics(String pic, String collectionId){
		if("" != pic){
			List<MipPicture> list = new ArrayList<MipPicture>();
			String[] picStr = pic.split(",");
			if(picStr.length>1){
				for (int j = 0; j < picStr.length; j++) {
					List<MipPicture> map = mipPictureService.getPictureListById(picStr[j]);
					if(null != map && map.size()>0){
						list.addAll(map);
					}
				}
			}else{
				List<MipPicture> map = mipPictureService.getPictureListById(pic);
				if(null != map && map.size()>0){
					list.addAll(map);
				}
			}
			
			//当查询到的图片为空时，则用藏品id来查询
			if(list == null || list.size() == 0) {
				List<MipPicture> pictureListByObjectId = mipPictureService.getPictureListByObjectId(collectionId);
				if(null != pictureListByObjectId && pictureListByObjectId.size()>0){
					list.addAll(pictureListByObjectId);
				}
			}
			
			Set<String> set = new HashSet<>();
			for (MipPicture picture : list) {
				if(!StringUtils.isBlank(picture.getUrl())) {
					if(!set.contains(picture.getId())) {
						picture.setUrl(config.getRootUrl() + picture.getUrl());
						set.add(picture.getId());
					}
				}
			}
			return list;
		}
		else return null;
	}

	@Override
	public List<Map<String, Object>> getVirtualByMuseumId(String orgId) {
		List<Map<String, Object>> virtualByMuseumId = bjMuseumBaseInfoMapper.getVirtualByMuseumId(orgId);
		for (Map<String, Object> map : virtualByMuseumId) {
			if(map.get("picUrl") != null) {
				map.put("picUrl", config.getRootUrl() + map.get("picUrl").toString());
			}
		}
		return virtualByMuseumId;
	}

	@Override
	public List<Map<String, Object>> getArticleByUniqueName(String uniqueName, String orgId, Integer size) {
		List<Map<String, Object>> articleByUniqueName = bjMuseumBaseInfoMapper.getArticleByUniqueName(uniqueName, orgId, size);
		for (Map<String, Object> map : articleByUniqueName) {
			if(map.get("titleImageSrc") != null) {
				map.put("titleImageSrc", config.getRootUrl() + map.get("titleImageSrc").toString());
			}
		}
		return articleByUniqueName;
	}

	@Override
	public List<Map<String, Object>> getMuseumListByAreaAndKey(String name, String area) {
		List<Map<String, Object>> museumListByAreaAndKey = bjMuseumBaseInfoMapper.getMuseumListByAreaAndKey(name, area, -1, 99999999);
		for (Map<String, Object> map : museumListByAreaAndKey) {
			if(map != null && !StringUtils.isBlank(map.get("imageUrl").toString())) {
				map.put("imageUrl", config.getRootUrl() + map.get("imageUrl").toString());
			}
		}
		return museumListByAreaAndKey;
	}

	@Override
	public List<Map<String, Object>> getCollectionTypeByMuseum(String orgId) {
		return bjMuseumBaseInfoMapper.getCollectionTypeByMuseum(orgId);
	}

	@Override
	public List<EveryDayMuseumDto> getEveryDayMuseumList() {
		List<EveryDayMuseumDto> everyDayMuseumList = bjMuseumBaseInfoMapper.getEveryDayMuseumList();
		for(EveryDayMuseumDto everyDayMuseumDto : everyDayMuseumList){
			if(!StringUtils.isBlank(everyDayMuseumDto.getOrgImgUrl())){
				everyDayMuseumDto.setOrgImgUrl(config.getRootUrl()+everyDayMuseumDto.getOrgImgUrl());
			}
			EveryDayMuseumDto spr = bjMuseumBaseInfoMapper.getEveryDayMuseumSpr(everyDayMuseumDto.getOrgId());
			if(spr != null){
				everyDayMuseumDto.setSprId(spr.getSprId());
				if(!StringUtils.isBlank(spr.getSprImgUrl())){
					everyDayMuseumDto.setSprImgUrl(config.getRootUrl()+spr.getSprImgUrl());
				}
			}
			EveryDayMuseumDto coll = bjMuseumBaseInfoMapper.getEveryDayMuseumColl(everyDayMuseumDto.getOrgId());
			if(coll != null){
				everyDayMuseumDto.setCollId(coll.getCollId());
				String firstImgId = coll.getCollImgUrl().split(",")[0];
				List<MipPicture> pics = mipPictureServiceImpl.getPictureListById(firstImgId);
				if(pics != null && pics.size() > 0) {
					if(!StringUtils.isBlank(pics.get(0).getUrl())){
						everyDayMuseumDto.setCollImgUrl(config.getRootUrl()+pics.get(0).getUrl());
					}
				}
			}
		}
		List<EveryDayMuseumDto> everyDayMuseumListNew = new ArrayList<EveryDayMuseumDto>();
		for(int i=0; i < 31; i++){
			int num = i % everyDayMuseumList.size();
			everyDayMuseumListNew.add(everyDayMuseumList.get(num));
		}
		return everyDayMuseumListNew;
	}

	@Override
	public boolean insertUserCount(String type, Integer count) {
		int result = bjMuseumBaseInfoMapper.insertUserCount(type, count);
		if(result >0){
			return true;
		}
		return false;
	}

	@Override
	public boolean setUserCount(String type, Integer count) {
		int result = bjMuseumBaseInfoMapper.setUserCount(type,count);
		if(result >0){
			return true;
		}
		return false;
	}
	
	@Override
	public Integer getUserCount(String type) {
		int result = bjMuseumBaseInfoMapper.getUserCount(type);
		return result;
	}

	@Override
	public List<Map<String, Object>> getMuseumListByAreaAndKey(String name, String area, Page page) {
		int countMuseumListByAreaAndKey = bjMuseumBaseInfoMapper.countMuseumListByAreaAndKey(name, area);
		page.setAllRow(countMuseumListByAreaAndKey);
		List<Map<String, Object>> museumListByAreaAndKey = bjMuseumBaseInfoMapper.getMuseumListByAreaAndKey(name, area,page.getStart(),page.getSize());
		for (Map<String, Object> map : museumListByAreaAndKey) {
			if(map != null && !StringUtils.isBlank(map.get("imageUrl").toString())) {
				map.put("imageUrl", config.getRootUrl() + map.get("imageUrl").toString());
			}
		}
		return museumListByAreaAndKey;
	}

	@Override
	public boolean addUserCount(String type) {
		boolean flag = false;
		Integer count = bjMuseumBaseInfoMapper.getUserCount(type);
		count++;
		int result = bjMuseumBaseInfoMapper.setUserCount(type, count);
		if(result>0){
			flag = true;
		}
		return flag;
	}
	
	@Override
	public List<MipTour> getTourListByMuseumId(String museumId){
		
		List<MipTour>  tourList = bjMuseumBaseInfoMapper.getTourListByMuseumId(museumId);
		for(MipTour tour:tourList) {
			String iconUrl = tour.getIconUrl();
			if(StringUtils.isNotBlank(iconUrl)) {
				tour.setIconUrl(config.getRootUrl()+iconUrl);
			}
		}
		return tourList;
	};
	
	/**
	 * 移动端-导览详情
	 * @param id
	 * @return
	 */
	@Override
	public Map<String,Object> getTourDetail(String id){

		Map<String,Object> tourMap = new HashMap<String,Object>();
		MipTour tourInfo =  bjMuseumBaseInfoMapper.getTourDetail(id);
		if(tourInfo !=null){
			String tourTime = "";
			if(tourInfo.getStartDate() !=null && tourInfo.getEndDate() !=null){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
				String startTime = sdf.format(tourInfo.getStartDate());
				String endTime = sdf.format(tourInfo.getEndDate());
				tourTime = startTime+"-"+endTime;
			}else{
				tourTime = "展期未定";
			}
			tourInfo.setTourTime(tourTime);
		}
		tourMap.put("tourDetailInfo",tourInfo);
		//查藏品图片列表
		Map<String,Object> searchMap = new HashMap<String,Object>();
		searchMap.put("type","1");
		searchMap.put("start",0);
		searchMap.put("end",3);
		searchMap.put("id",id);
		List<MipToorCollection>  picList =  bjMuseumBaseInfoMapper.getTourCollectionList(searchMap);
		for(MipToorCollection info:picList){
			if(StringUtils.isNotBlank(info.getPictureUrl())){
				info.setPictureUrl(config.getRootUrl()+info.getPictureUrl());
			}
		}
		tourMap.put("picList",picList);
		//查音频列表
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id",id);
		map.put("type","2");
		List<MipToorCollection>  videoList =  bjMuseumBaseInfoMapper.getTourCollectionList(map);
		for(MipToorCollection videoInfo:videoList){
			if(StringUtils.isNotBlank(videoInfo.getAudioUrl())){
				videoInfo.setAudioUrl(config.getRootUrl()+videoInfo.getAudioUrl());
			}
			if(StringUtils.isNotBlank(videoInfo.getPictureUrl())){
				videoInfo.setPictureUrl(config.getRootUrl()+videoInfo.getPictureUrl());
			}
		}
		tourMap.put("videoList",videoList);
		return tourMap;
	};

	@Override
	public Map<String,Object>  getPictureList(String id){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<MipToorCollection>  pictureList = new ArrayList<MipToorCollection>();
		pictureList =  bjMuseumBaseInfoMapper.getPictureList(id);
		for(MipToorCollection info:pictureList){
			if(StringUtils.isNotBlank(info.getPictureUrl())){
				info.setPictureUrl(config.getRootUrl()+info.getPictureUrl());
			}
		}
		resultMap.put("pictureList",pictureList);
		resultMap.put("pictureNumber",pictureList.size());
		MipTour tourInfo =  bjMuseumBaseInfoMapper.getTourDetail(id);
		if(tourInfo != null){
			resultMap.put("tourName",tourInfo.getName());
		}

		resultMap.put("tourId",id);
		return resultMap;
	}

	@Override
	public Map<String,Object>  getCollectInfoList(String tourId,String collectionId){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<MipToorCollection>  collectionList = new ArrayList<MipToorCollection>();
		collectionList =  bjMuseumBaseInfoMapper.getCollectionList(tourId);
		for(MipToorCollection info:collectionList){
			if(StringUtils.isNotBlank(info.getPictureUrl())){
				info.setPictureUrl(config.getRootUrl()+info.getPictureUrl());
			}
			if(StringUtils.isNotBlank(info.getAudioUrl())){
				info.setAudioUrl(config.getRootUrl()+info.getAudioUrl());
			}
			if(collectionId.equals(info.getCollectionId())){
				resultMap.put("showNum",info.getRowNum());
			}
		}
		resultMap.put("collectionList",collectionList);
		return resultMap;
	}
}
