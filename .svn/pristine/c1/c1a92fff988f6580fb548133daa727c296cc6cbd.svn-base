/** 
 * <pre>项目名称:mip 
 * 文件名称:AreaServiceImpl.java 
 * 包名:com.tj720.mip.service.table 
 * 创建日期:2017年2月23日下午4:24:42 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.service.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dto.AreaOrag;
import com.tj720.mip.dto.CityMuseum;
import com.tj720.mip.dto.Museum;
import com.tj720.mip.dto.MuseumInfoDto;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.AreaDao;
import com.tj720.mip.inter.service.table.AreaService;
import com.tj720.mip.model.MipArea;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/** 
 * <pre>项目名称：mip    
 * 类名称：AreaServiceImpl    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月23日 下午4:24:42    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月23日 下午4:24:42    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class AreaServiceImpl extends BaseService<MipArea> implements AreaService{
	@Resource(name="areaDao")
	AreaDao areaDao;
	
	@Resource(name="areaDao")
	public void setDao(IBaseDao<MipArea> dao) {
		super.setDao(dao);
	}

	@Autowired
	private Config config;
	@Autowired
	private MipOrganizationService mipOrganizationService;
	/* (non-Javadoc)    
	 * @see com.tj720.mip.inter.service.table.AreaService#selectByHql(java.lang.String)    
	 */
	@Override
	@Transactional
	public List<T> selectByHql(String hql) {
		return areaDao.selectByHql(hql);
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.inter.service.table.AreaService#getOrgList()    
	 */
	@Override
	@Transactional
	public List<CityMuseum> getOrgList() {
		String hql = "SELECT new com.tj720.mip.dto.AreaOrag(c.id as areaId ,c.name as areaName,o.id as oragId,o.name as oragName,o.collectionCount as oragCount) FROM MipOrganization as o, MipArea as c where o.cityId=c.id "
				+ "and c.pid = "+config.getProvinceId()+" and o.orgTypeId='2' and o.open = 1 and o.status > 0 and o.isdelete = 0 order by c.sequence desc, o.sequence desc";
		@SuppressWarnings("unchecked")
		List<AreaOrag> oragList =(List<AreaOrag>) areaDao.queryByHql(hql, Tools.getMap());
		HashMap<String, CityMuseum> cityMap = new HashMap<>();
		List<CityMuseum> cityList=new ArrayList<>();
		ArrayList<String> ids = new ArrayList<>();
		for (AreaOrag area : oragList) {
			String key=area.getAreaId();
			if(cityMap.get(key)==null){
				cityMap.put(key, new CityMuseum(area.getAreaName()));
				ids.add(key);
			}
			CityMuseum cm=cityMap.get(key);
			List<Museum> m=cm.getMuseum();
			m.add(new Museum(area.getOragId(),key,area.getOragName()));
			cm.setMuseum(m);
		}	
		for (String key : ids) {
			cityList.add(cityMap.get(key));
		}
		return cityList;
	}
	
	/* (non-Javadoc)    
	 * @see com.tj720.mip.inter.service.table.AreaService#getOrgList()    
	 */
	@Override
	@Transactional
	public List<CityMuseum> getOrgListMB() {
		String hql = "FROM MipOrganization where provinceId = "+config.getProvinceId()+" and level = 3 and open = 1 and status > 0 and isdelete = 0 order by sequence desc";
		@SuppressWarnings("unchecked")
		List<MipOrganization> oragList =(List<MipOrganization>) mipOrganizationService.queryByHql(hql, Tools.getMap());
		HashMap<String, CityMuseum> cityMap = new HashMap<>();
		List<CityMuseum> cityList=new ArrayList<>();
		ArrayList<String> ids = new ArrayList<>();
		for (MipOrganization mipOrganization : oragList) {
			String pid = mipOrganization.getParentId();
			MipOrganization pOrganization = mipOrganizationService.get(pid);
			String key = pOrganization.getId();
			if(cityMap.get(key)==null){
				cityMap.put(key, new CityMuseum(pOrganization.getShortname()));
				ids.add(key);
			}
			CityMuseum cm=cityMap.get(key);
			List<Museum> m=cm.getMuseum();
			m.add(new Museum(mipOrganization.getId(),pid,mipOrganization.getName()));
			cm.setMuseum(m);
		}	
		for (String key : ids) {
			cityList.add(cityMap.get(key));
		}
		return cityList;
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.inter.service.table.AreaService#queryByDto(java.lang.String, java.util.Map, com.tj720.mip.utils.Page)    
	 */
	@Override
	@Transactional
	public List<?> queryByDto(String hql, Map<String, Object> map, Page page) {
		return  dao.queryByDto(hql, map, page);
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.inter.service.table.AreaService#getSeachHql()    
	 */
	@Override
	public String getSeachHql(MuseumInfoDto museumInfoDto) {
		//Map<String, Object> map = Tools.getMap("cityId",museumInfo.getCityId(),"level", museumInfo.getLevel(),"orgId" ,orgId,"museumName|like",museumInfo.getMuseumName());
		
		String hql = "SELECT new com.tj720.mip.dto.MuseumInfoDto(o.id as museumId ,o.name as museumName,i.cityId as museumCityId,i.level as level,i.id as museumInfoId) FROM MipOrganization as o, MipArea as c,MuseumInfo as i"
				+ " where i.orgId = o.id and  o.cityId=c.id and  o.platformId = "+config.getPlatformId()+" and o.open = 1 and o.status > 0 and o.isdelete = 0 ";
		if(museumInfoDto.getLevel() != null){
			hql += " and i.level = "+museumInfoDto.getLevel();
		}
		if(museumInfoDto.getMuseumId() != null && !museumInfoDto.getMuseumId().equals("")){
			hql += " and o.id = "+museumInfoDto.getMuseumId();
		}
		if(museumInfoDto.getMuseumName() != null && !museumInfoDto.getMuseumName().equals("")){
			hql += " and i.museumName like  '%"+museumInfoDto.getMuseumName()+"%'";
		}
		if(museumInfoDto.getMuseumCityId() != null && !museumInfoDto.getMuseumCityId().equals("")){
			hql += " and i.cityId = '"+museumInfoDto.getMuseumCityId()+"'";
		}
		return hql;
	}
	
	@Override
	public String getSeachHqlMB(MuseumInfoDto museumInfoDto) {
		//Map<String, Object> map = Tools.getMap("cityId",museumInfo.getCityId(),"level", museumInfo.getLevel(),"orgId" ,orgId,"museumName|like",museumInfo.getMuseumName());
		
		String hql = "SELECT new com.tj720.mip.dto.MuseumInfoDto(o.id as museumId ,o.name as museumName,i.cityId as museumCityId,i.level as level,i.id as museumInfoId) FROM MipOrganization as o, MipArea as c,MuseumInfo as i"
				+ " where i.orgId = o.id and  o.cityId=c.id and  o.platformId = "+config.getPlatformId()+" and o.open = 1 and o.status > 0 and o.isdelete = 0 ";
		if(museumInfoDto.getLevel() != null){
			hql += " and i.level = "+museumInfoDto.getLevel();
		}
		if(museumInfoDto.getMuseumId() != null && !museumInfoDto.getMuseumId().equals("")){
			hql += " and o.id = "+museumInfoDto.getMuseumId();
		}
		if(museumInfoDto.getMuseumName() != null && !museumInfoDto.getMuseumName().equals("")){
			hql += " and i.museumName like  '%"+museumInfoDto.getMuseumName()+"%'";
		}
		if(museumInfoDto.getMuseumCityId() != null && !museumInfoDto.getMuseumCityId().equals("")){
			hql += " and o.parentId = '"+museumInfoDto.getMuseumCityId()+"'";
		}
		return hql;
	}
	
	
	
	

}
