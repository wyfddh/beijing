package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.NumberUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.MipSearchMapper;
import com.tj720.admin.dto.MipSearchDto;
import com.tj720.admin.model.MipSearch;
import com.tj720.admin.service.MipSearchService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.OrgUtil;
import com.tj720.mip.utils.Tools;

@Service("mipSearchService")
public class MipSearchServiceImpl implements MipSearchService {

	@Autowired
	private Config config;//常量的取法  
	@Autowired
	private MipSearchMapper mipSearchMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private com.tj720.admin.service.IMipOrganizationService imipOrganizationService;
	@Autowired
	private MipOrganizationService organizationService;
	
	@Override
	public List<MipSearchDto> getList(String flag,String type) {
		List<MipSearchDto> list = new ArrayList<MipSearchDto>();
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		if(!StringUtils.isBlank(flag)&&"1".equals(flag)){
			list = mipSearchMapper.getMyQuery(userDto.getId(),type);
		}else{
			list = mipSearchMapper.getOtherQuery(userDto.getId(),us.getOrgId(),type);
		}
		return list;
	}
	
	@Override
	public Integer save(String queryOrgs,String queryTerms,String queryName,String type,String curPid) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		MipSearch search = new MipSearchDto();
		search.setId(uuid);
		search.setQueryOrgs(queryOrgs);
		search.setQueryTerms(queryTerms);
		search.setQueryName(queryName);
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		search.setCreater(userDto.getId());
		search.setOrgId(us.getOrgId());
		search.setCreatTme(new Date());
		search.setStatus("1");
		search.setType(type);
		if(type.equals("1")){
			if(!StringUtils.isBlank(curPid)){
				search.setUniqueName(curPid);
				String sqlstr = getSqlById(curPid);
				search.setSqlstr(sqlstr);
			}
		}
		return mipSearchMapper.insert(search);
	}

	@Override
	public List<Map<String, Object>> query(String queryOrgs, String queryTerms,String type,String sqlstr) {
		LoginInfoDto user = Tools.getUser();
		User user2 = userService.get(user.getId());
		String sqlFlag = "";
		String sqlResult = "";
		if(!StringUtils.isBlank(type)){
			if(type.equals("0")){
				sqlFlag = "zhcx";
				sqlResult = getSqlByUnique(sqlFlag);
				sqlResult = sqlResult.replaceAll("\r|\n|\'", "");
				sqlResult = sqlResult.replaceAll("from", " from");
				sqlResult = sqlResult.replaceAll("left", " left");
				sqlResult = sqlResult.replaceAll("where", " where");
				if(!StringUtils.isBlank(queryOrgs)){
					sqlResult = sqlResult+" and a.id in ("+queryOrgs+")";
				}else {
					MipOrganization mipOrganization2 = organizationService.get(user2.getOrgId());
					if(mipOrganization2 != null && "1".equals(mipOrganization2.getOrgTypeId())) {
						//文物局
					}else {
						//其他
						List<com.tj720.admin.model.MipOrganization> allmuseumList = imipOrganizationService.getMuseumList();
						List<com.tj720.admin.model.MipOrganization> museumList = OrgUtil.getSonOrg(allmuseumList, NumberUtils.stringToInt(user2.getOrgId(), 0), false);
						String currentMuseumString = "";
						if(museumList != null && museumList.size() > 0) {
							for (com.tj720.admin.model.MipOrganization mipOrganization : museumList) {
								currentMuseumString += mipOrganization.getId() + ",";
							}
							if(StringUtils.isNotBlank(currentMuseumString)) {
								currentMuseumString = currentMuseumString.substring(0, currentMuseumString.length() - 1);
								sqlResult = sqlResult+" and a.id in ("+currentMuseumString+")";
							}
						}
					}
				}
			}else if(type.equals("1")){
				sqlResult = sqlstr;
				if(!StringUtils.isBlank(queryOrgs) && !StringUtils.isBlank(sqlResult)){
					sqlResult = sqlResult+" and a.id in ("+queryOrgs+")";
				}else {
					MipOrganization mipOrganization2 = organizationService.get(user2.getOrgId());
					if(mipOrganization2 != null && "1".equals(mipOrganization2.getOrgTypeId())) {
						//文物局
					}else {
						//其他
						List<com.tj720.admin.model.MipOrganization> allmuseumList = imipOrganizationService.getMuseumList();
						List<com.tj720.admin.model.MipOrganization> museumList = OrgUtil.getSonOrg(allmuseumList, NumberUtils.stringToInt(user2.getOrgId(), 0), false);
						String currentMuseumString = "";
						if(museumList != null && museumList.size() > 0) {
							for (com.tj720.admin.model.MipOrganization mipOrganization : museumList) {
								currentMuseumString += mipOrganization.getId() + ",";
							}
							if(StringUtils.isNotBlank(currentMuseumString)) {
								currentMuseumString = currentMuseumString.substring(0, currentMuseumString.length() - 1);
								sqlResult = sqlResult+" and a.id in ("+currentMuseumString+")";
							}
						}
					}
				}
			}
		}
		if(StringUtils.isNotEmpty(sqlResult)) {
			return mipSearchMapper.query(sqlResult);
		}else {
			return null;
		}
	}

	public String getSqlByUnique(String uniqueName){
		return mipSearchMapper.getSqlByUnique(uniqueName);
	}
	
	public String getSqlById(String curPid){
		return mipSearchMapper.getSqlById(curPid);
	}
}
