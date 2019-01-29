package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.model.MipOrganization;

public interface IMipOrganizationService {
	public MipOrganization getOrganization(Integer orgId);
	public List<MipOrganization> getCityList(Integer orgId);
	public List<MipOrganization> getListByPId(int orgId);
	public List<MipOrganization> getListByLevel(byte level);
	public List<MipOrganization> getListByPlatformId(Integer platformId);
	public List<MipOrganization> getListByCityId(int cityId);
	public List<MipOrganization> getListByLevelNew(byte level);
	//查 所有博物馆
	public List<MipOrganization> getMuseumList();
	public List<MipOrganization> getListByOrgType(String orgType);
	/**
	 * 根据parentID查找下级所有机构，以及下级的下级机构
	 * @param parentId
	 * @return
	 */
	public List<MipOrganization> getChildListByPid(Integer parentId, List<MipOrganization> list);
	
	//按照城区查询博物馆列表
	public List<MipOrganization> getMuseumListByAreaId(String areaId);
	
	//查直属18家博物馆
	public List<String> getOrgs();
	//获取所有组织
	public List<MipOrganization> getOrgList();
	
}
