package com.tj720.admin.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.constant.KeyConstants;
import com.tj720.admin.dto.ObjectChangeDto;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.service.DcVersionContentService;
import com.tj720.admin.service.IMipBaseCulturalrelicInfoService;
import com.tj720.admin.service.IMipBaseFossilInfoService;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.MipOpenCulturalrelicInfoService;
import com.tj720.admin.service.MipOpenFossilInfoService;
import com.tj720.admin.service.ObjectChangeService;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.mip.utils.OrgUtil;

@Service("ObjectChangeServiceImpl")
public class ObjectChangeServiceImpl implements ObjectChangeService{
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
	IMipOrganizationService mipOrganizationService;
	
	public ObjectChangeDto getChangeDto(String orgTypeId,String orgId) {
//		int baseCulturalrelicCount = mipBaseCulturalrelicInfoService.getCulturalrelicInfoCount();
//		int baseFossilCount = mipBaseFossilInfoService.getFossilInfoCount();
		int allNumber = 0;
		ObjectChangeDto dto = new ObjectChangeDto();
		if("1".equals(orgTypeId) || "2".equals(orgTypeId)){
			//文物局或者区文委登录
			List<String> orgIdList = new ArrayList<String>();
//			List<MipOrganization> orglist = new ArrayList<MipOrganization>();
			List<MipOrganization> orglist = mipOrganizationService.getOrgList();
			List<MipOrganization> organizations = OrgUtil.getSonOrg(orglist, Integer.valueOf(orgId), true);
//			List<MipOrganization> organizations = mipOrganizationService.getChildListByPid(Integer.valueOf(orgId), orglist);
			for(MipOrganization org:organizations){
				String typeId = org.getOrgTypeId();
				String id = String.valueOf(org.getId());
				//查博物馆，文物修复资质单位，其他文物收藏单位
				if("3".equals(typeId) ||"4".equals(typeId)||"5".equals(typeId)){
					orgIdList.add(id);
				}
			}
			int openCulturalrelicCount = mipOpenCulturalrelicInfoService.getCulturalrelicInfoCount(orgIdList);
			int openFossilCount = mipOpenFossilInfoService.getFossileInfoCount(orgIdList);
			allNumber = openCulturalrelicCount+openFossilCount;
			int editNumber = dcVersionContentService.getByOrgList((byte)2,orgIdList);
			int addNumber = dcVersionContentService.getByOrgList((byte)1,orgIdList);
			dto.setAllNumber(allNumber);
			dto.setAddNumber(addNumber);
			dto.setEditNumber(editNumber);
		}else{
			int editNumber = dcVersionContentService.getByOrgIdCount(Integer.parseInt(orgId),(byte)2);
			int baseCulturalrelicCount = mipOpenCulturalrelicInfoService.countByOrgId(orgId);
			int baseFossilCount = mipOpenFossilInfoService.countByOrgId(orgId);
			allNumber = baseCulturalrelicCount+baseFossilCount;
			int addNumber = dcVersionContentService.getByOrgIdCount(Integer.parseInt(orgId),(byte)1);
			dto.setAllNumber(allNumber);
			dto.setAddNumber(addNumber);
			dto.setEditNumber(editNumber);
			
		}
		return dto;
	}

}
