package com.tj720.mip.inter.service.table;

import java.util.List;

import com.tj720.mip.dto.CityMuseumDto;
import com.tj720.mip.dto.MuseumDto;
import com.tj720.mip.dto.MuseumInfoDto;
import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.utils.Page;

public interface IMipOrganizationService extends IBaseService<MipOrganization>{
	List<MipOrganization> queryBySql(String sql);
	List<CityMuseumDto> getCityMuseum();
	List<CityMuseumDto> getCityMuseumForColl();
	List<MuseumDto> gethots(String cityId, int size);
	String getCityFromLatLong(double latitude, double longitude);
	List<MuseumDto> getNear(String cityId, double latitude, double longitude);
	List<MuseumDto> getHotMuseumsFromCity(String cityId);
	List<MuseumDto> getAllMusFromCity(String cityId, int size);
	List<MuseumDto> getNearAll(String cityId, double latitude, double longitude);
	List<MuseumDto> getHotMuseums(Page page);
	List<MuseumDto> getNearSimple(String cityId, double latitude, double longitude);
	List<MipOrganization> getListById(String orgId);
	List<MipOrganization> getListByArea(String area);
	
	/**
	 * 根据parentID查找下级所有机构，以及下级的下级机构
	 * @param parentId
	 * @return
	 */
	List<com.tj720.admin.model.MipOrganization> getChildListByPid(Integer parentId, List<com.tj720.admin.model.MipOrganization> list);
	
	/**
	 * 根据省查询所有博物馆数据
	 * @param province		省
	 * @param city			市
	 * @param town			区
	 * @param orgTypeId		机构类型
	 * @param key			关键词
	 * @return
	 */
	List<com.tj720.admin.model.MipOrganization> getAllByProvince(String province, String city, String town, String orgTypeId, String key);
	/**
	 * 根据orgTypeId获取相应组织
	 * @param orgTypeId
	 * @return
	 */
	List<MipOrganization> getListByOrgTypeId(String orgTypeId);
	
	/**
	 * 查找传入的博物馆中，隶属关系不为央属和市属的博物馆
	 * @param source
	 * @return
	 */
	List<com.tj720.admin.model.MipOrganization> getLitleOrgByParmOrg(List<com.tj720.admin.model.MipOrganization> source);
}
