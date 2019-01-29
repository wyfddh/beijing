package com.tj720.admin.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.constant.KeyConstants;
import com.tj720.admin.dto.MuseumInfoManageDto;
import com.tj720.admin.dto.MuseumInfoManageSpreDto;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.MuseumInfoManageService;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("MuseumInfoManageServiceImpl")
public class MuseumInfoManageServiceImpl implements MuseumInfoManageService{
	@Autowired
	IMipOrganizationService mipOrganizationService;
	@Autowired
	Config config;

	@Override
	public List<MuseumInfoManageDto> getMuseumInfoList(String area, String unit, Page page) {
		List<MuseumInfoManageDto> dtoList = new ArrayList<MuseumInfoManageDto>();
		String listKey = MessageFormat.format(KeyConstants.MUSEUN_INFO_MANAGE_LIST_KEY, "infoList");
		String jsonStr =JedisService.get(listKey);
		if(StringUtils.isNotBlank(jsonStr)) {
			JSONArray jsonArray = JSONArray.fromObject(jsonStr);//把String转换为json
		    for (Object object : jsonArray) {
	            JSONObject jsonObject = (JSONObject) object;
	            MuseumInfoManageDto dto = (MuseumInfoManageDto)JSONObject.toBean(jsonObject,MuseumInfoManageDto.class);
	            if(!MyString.isEmpty(unit)){
	            	if(unit.equals(dto.getUnit())){
	            		dtoList.add(dto);
	            		MipOrganization org = mipOrganizationService.getOrganization(Integer.parseInt(dto.getUnit()));
	            		dto.setUnitName(org.getName());
	            		dto.setPsdUrl(config.getRootUrl()+dto.getPsdUrl());
	            	}
	            }else{
	            	if(!MyString.isEmpty(area)){
	            		if(unit.equals(dto.getArea())){
		            		dtoList.add(dto);
		            		MipOrganization org = mipOrganizationService.getOrganization(Integer.parseInt(dto.getUnit()));
		            		dto.setUnitName(org.getName());
		            		dto.setPsdUrl(config.getRootUrl()+dto.getPsdUrl());
		            	}
	            	}else{
	            		dtoList.add(dto);
	            		MipOrganization org = mipOrganizationService.getOrganization(Integer.parseInt(dto.getUnit()));
	            		dto.setUnitName(org.getName());
	            		dto.setPsdUrl(config.getRootUrl()+dto.getPsdUrl());
	            	}
	            }
	        }
		}
		List<MuseumInfoManageDto> returnList = new ArrayList<MuseumInfoManageDto>();
		int start = page.getCurrentPage();
		int size = page.getSize();
		int end = 10;
		if(start>1){
			start = (start-1)*size+1;
			end = start * size >dtoList.size()?dtoList.size():start * size;
		}else{
			start = 0;
			end = 1 * size >dtoList.size()?dtoList.size():10;
		}
		for(int i = start;i<end;i++){
			returnList.add(dtoList.get(i));
		}
		page.setAllRow(dtoList.size());
		return returnList;
	}
	public List<MuseumInfoManageSpreDto> getMuseumInfoSpreList(Page page,String spreId) {
		List<MuseumInfoManageSpreDto> dtoList = new ArrayList<MuseumInfoManageSpreDto>();
		String listKey = MessageFormat.format(KeyConstants.MUSEUN_INFO_MANAGE_LIST_KEY, spreId);
		String jsonStr =JedisService.get(listKey);
		if(StringUtils.isNotBlank(jsonStr)) {
			JSONArray jsonArray = JSONArray.fromObject(jsonStr);//把String转换为json
			for (Object object : jsonArray) {
				JSONObject jsonObject = (JSONObject) object;
				MuseumInfoManageSpreDto dto = (MuseumInfoManageSpreDto)JSONObject.toBean(jsonObject,MuseumInfoManageSpreDto.class);
				MipOrganization org = mipOrganizationService.getOrganization(Integer.parseInt(dto.getUnit()));
				dto.setUnitName(org.getName());
				dto.setPsdUrl(config.getRootUrl()+dto.getPsdUrl());
				dtoList.add(dto);
			}
		}
		List<MuseumInfoManageSpreDto> returnList = new ArrayList<MuseumInfoManageSpreDto>();
		int start = page.getCurrentPage();
		int size = page.getSize();
		int end = 10;
		if(start>1){
			start = (start-1)*size+1;
			end = start * size >dtoList.size()?dtoList.size():start * size;
		}else{
			start = 0;
			end = 1 * size >dtoList.size()?dtoList.size():10;
		}
		for(int i = start;i<end;i++){
			returnList.add(dtoList.get(i));
		}
		page.setAllRow(dtoList.size());
		return returnList;
	}

	@Override
	public String delectInfo(String id) {
		List<MuseumInfoManageDto> dtoList = new ArrayList<MuseumInfoManageDto>();
		String listKey = MessageFormat.format(KeyConstants.MUSEUN_INFO_MANAGE_LIST_KEY, "infoList");
		String jsonStr =JedisService.get(listKey);
		String result = "0";
		if(StringUtils.isNotBlank(jsonStr)) {
			JSONArray jsonArray = JSONArray.fromObject(jsonStr);//把String转换为json
		    for (Object object : jsonArray) {
	            JSONObject jsonObject = (JSONObject) object;
	            MuseumInfoManageDto dto = (MuseumInfoManageDto)JSONObject.toBean(jsonObject,MuseumInfoManageDto.class);
	            if(id.equals(dto.getId())){
	            	result="1";
	            }else{
	            	dtoList.add(dto);
	            }
	            JSONArray json = JSONArray.fromObject(dtoList); 
				String str = json.toString();
				JedisService.set(listKey, str, KeyConstants.LIST_CACHE_EXPIRE_INTERVAL_HOUR * 60 * 60);
	        }
		}
		return result;
	}
	@Override
	public String delectInfoSpre(String id, String spreId) {
		List<MuseumInfoManageSpreDto> dtoList = new ArrayList<MuseumInfoManageSpreDto>();
		String listKey = MessageFormat.format(KeyConstants.MUSEUN_INFO_MANAGE_LIST_KEY, spreId);
		String jsonStr =JedisService.get(listKey);
		String result = "0";
		if(StringUtils.isNotBlank(jsonStr)) {
			JSONArray jsonArray = JSONArray.fromObject(jsonStr);//把String转换为json
		    for (Object object : jsonArray) {
	            JSONObject jsonObject = (JSONObject) object;
	            MuseumInfoManageSpreDto dto = (MuseumInfoManageSpreDto)JSONObject.toBean(jsonObject,MuseumInfoManageSpreDto.class);
	            if(id.equals(dto.getId())){
	            	result="1";
	            }else{
	            	dtoList.add(dto);
	            }
	            JSONArray json = JSONArray.fromObject(dtoList); 
				String str = json.toString();
				JedisService.set(listKey, str, KeyConstants.LIST_CACHE_EXPIRE_INTERVAL_HOUR * 60 * 60);
	        }
		}
		return result;
	}

}
