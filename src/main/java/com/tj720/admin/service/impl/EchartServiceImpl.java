package com.tj720.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dto.TotalNumDto;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.service.DcVersionContentService;
import com.tj720.admin.service.EchartService;
import com.tj720.admin.service.IMipBaseCulturalrelicInfoService;
import com.tj720.admin.service.IMipBaseFossilInfoService;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.MipAreaService;
import com.tj720.admin.service.MipOpenCulturalrelicInfoService;
import com.tj720.admin.service.MipOpenFossilInfoService;
import com.tj720.mip.utils.MyString;

@Service("EchartServiceImpl")
public class EchartServiceImpl implements EchartService{
	@Autowired
	MipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
	
	@Autowired
	MipOpenFossilInfoService mipOpenFossilInfoService;
	
	@Autowired
	DcVersionContentService dcVersionContentService;
	
	@Autowired
	IMipBaseFossilInfoService mipBaseFossilInfoService;
	
	@Autowired
	IMipBaseCulturalrelicInfoService mipBaseCulturalrelicInfoService;
	
	@Autowired
	MipAreaService mipAreaService;
	
	@Autowired
	IMipOrganizationService mipOrganizationService;
	
	@Override
	public List<TotalNumDto> getLineData(int type,byte status,String orgId) {
		List<TotalNumDto> numDto = new ArrayList<TotalNumDto>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, + 1);
		List<MipOrganization> orglist = mipOrganizationService.getOrgList();
		if(1==type){
	        for(int i=0;i<7;i++) {
	        	TotalNumDto dto = new TotalNumDto();
	        	c.setTime(c.getTime());
	        	Date endDay = c.getTime();
	        	c.add(Calendar.DATE, - 1);
	        	Date beginDay = c.getTime();
	        	int editNumber = dcVersionContentService.getContentCountByTime(format.format(beginDay),format.format(endDay),status,orgId,orglist);
	        	dto.setWeek(format.format(beginDay));
	        	dto.setCount(editNumber);
	        	numDto.add(dto);
	        }
		}else if(2==type){
			 for(int i=0;i<30;i++) {
		        	TotalNumDto dto = new TotalNumDto();
		        	c.setTime(c.getTime());
		        	Date endDay = c.getTime();
		        	c.add(Calendar.DATE, - 1);
		        	Date beginDay = c.getTime();
		        	int editNumber = dcVersionContentService.getContentCountByTime(format.format(beginDay),format.format(endDay),status,orgId,orglist);
		        	dto.setWeek(format.format(beginDay));
		        	dto.setCount(editNumber);
		        	numDto.add(dto);
		        }
		}else{
			 for(int i=0;i<12;i++) {
		        	TotalNumDto dto = new TotalNumDto();
		        	c.setTime(c.getTime());
		        	dto.setWeek(c.get(Calendar.MONTH )+1+"月");
		        	Date endDay = c.getTime();
		        	c.add(Calendar.MONTH, - 1);
		        	Date beginDay = c.getTime();
		        	int editNumber = dcVersionContentService.getContentCountByTime(format.format(beginDay),format.format(endDay),status,orgId,orglist);
		        	
		        	dto.setCount(editNumber);
		        	numDto.add(dto);
		        }
		}
		return numDto;
	}

	@Override
	public List<TotalNumDto> getPieData(byte picType,int picArea,String beginTime,String endTime,List<Map<String,Object>> areaList) {
		List<TotalNumDto> numDto = new ArrayList<TotalNumDto>();
		if(0==picArea){
			for (Map<String,Object> map:areaList) {
				int count =  dcVersionContentService.getByAreaIdCountNew(String.valueOf(map.get("id")),picType,beginTime,endTime);
				if(count > 0){
					TotalNumDto dto = new TotalNumDto();
					dto.setWeek(String.valueOf(map.get("name")));
					dto.setCount(count);
					dto.setId(String.valueOf(map.get("id")));
					numDto.add(dto);
				}
			}
		}else{
			List<MipOrganization> orgList = mipOrganizationService.getMuseumListByAreaId(String.valueOf(picArea));
			if(!MyString.isEmpty(orgList)){
				for(MipOrganization list : orgList){
					TotalNumDto dto = new TotalNumDto();
					int count =  dcVersionContentService.getByOrgIdCount(list.getId(),picType);
					if(count > 0){
						dto.setWeek(list.getName());
						dto.setCount(count);
						numDto.add(dto);
					}
				}
			}
		}
		return numDto;
	}

	@Override
	public List<TotalNumDto> getLineDataByOrgId(int type, byte status, String orgId) {
		List<TotalNumDto> numDto = new ArrayList<TotalNumDto>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		if(1==type){
	        for(int i=0;i<7;i++) {
	        	TotalNumDto dto = new TotalNumDto();
	        	c.setTime(c.getTime());
	        	Date beginDay = c.getTime();
	        	c.add(Calendar.DATE, - 1);
	        	Date endDay = c.getTime();
	        	int editNumber = dcVersionContentService.getByOrgIdTimeCount(Integer.parseInt(orgId),status,format.format(endDay),format.format(beginDay));
	        	dto.setWeek(format.format(endDay));
	        	dto.setCount(editNumber);
	        	numDto.add(dto);
	        }
		}else if(2==type){
			 for(int i=0;i<30;i++) {
		        	TotalNumDto dto = new TotalNumDto();
		        	c.setTime(c.getTime());
		        	Date beginDay = c.getTime();
		        	c.add(Calendar.DATE, - 1);
		        	Date endDay = c.getTime();
		        	int editNumber = dcVersionContentService.getByOrgIdTimeCount(Integer.parseInt(orgId),status,format.format(endDay),format.format(beginDay));
		        	dto.setWeek(format.format(endDay));
		        	dto.setCount(editNumber);
		        	numDto.add(dto);
		        }
		}else{
			 for(int i=0;i<12;i++) {
		        	TotalNumDto dto = new TotalNumDto();
		        	c.setTime(c.getTime());
		        	dto.setWeek(c.get(Calendar.MONTH )+1+"月");
		        	Date beginDay = c.getTime();
		        	c.add(Calendar.MONTH, - 1);
		        	Date endDay = c.getTime();
		        	int editNumber = dcVersionContentService.getByOrgIdTimeCount(Integer.parseInt(orgId),status,format.format(endDay),format.format(beginDay));
		        	dto.setCount(editNumber);
		        	numDto.add(dto);
		        }
		}
		return numDto;
	}

}
