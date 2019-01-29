package com.tj720.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipOrganizationMapper;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.MipOrganizationExample;
import com.tj720.admin.model.MipOrganizationExample.Criteria;
import com.tj720.admin.service.IMipOrganizationService;

@Service("mipOrganizationServiceImpl")
public class MipOrganizationServiceImpl extends BaseServiceImpl<MipOrganization> implements IMipOrganizationService{

	@Autowired
	MipOrganizationMapper mipOrganizationMapper;
	
	@Override
	public BaseDao<MipOrganization> getBaseDao() {
		return mipOrganizationMapper;
	}
	@Override
	public MipOrganization getOrganization(Integer orgId) {
		MipOrganization mip = mipOrganizationMapper.selectByPrimaryKey(orgId);
		return mip;
	}
	@Override
	public List<MipOrganization> getCityList(Integer orgId) {
		List<MipOrganization> list = mipOrganizationMapper.selectAllOrganization(orgId);
		return list;
	}
	@Override
	public List<MipOrganization> getListByPId(int orgId) {
		MipOrganizationExample example = new MipOrganizationExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(orgId);
		List<MipOrganization> list = mipOrganizationMapper.selectByExample(example);
		return list;
	}
	@Override
	public List<MipOrganization> getListByLevel(byte level) {
		MipOrganizationExample example = new MipOrganizationExample();
		Criteria criteria = example.createCriteria();
		criteria.andLevelEqualTo(level);
		List<MipOrganization> list = mipOrganizationMapper.selectByExample(example);
		return list;
	}
	@Override
	public List<MipOrganization> getListByPlatformId(Integer platformId) {
		MipOrganizationExample example = new MipOrganizationExample();
		Criteria criteria = example.createCriteria();
		criteria.andPlatformIdEqualTo(platformId);
		List<MipOrganization> list = mipOrganizationMapper.selectByExample(example);
		return list;
	}
	@Override
	public List<MipOrganization> getListByCityId(int cityId) {
		MipOrganizationExample example = new MipOrganizationExample();
		Criteria criteria = example.createCriteria();
		criteria.andCityIdEqualTo(cityId);
		List<MipOrganization> list = mipOrganizationMapper.selectByExample(example);
		return list;
	}
	
	@Override
	public List<MipOrganization> getListByLevelNew(byte level) {
		MipOrganizationExample example = new MipOrganizationExample();
		Criteria criteria = example.createCriteria();
		criteria.andLevelNotEqualTo(level);
		List<MipOrganization> list = mipOrganizationMapper.selectByExample(example);
		return list;
	}
	@Override
	public List<MipOrganization> getMuseumList() {
		return mipOrganizationMapper.getMuseumList();
	}
	
	@Override
	public List<String> getOrgs() {
		return mipOrganizationMapper.getOrgs();
	}
	@Override
	public List<MipOrganization> getListByOrgType(String orgType) {
		MipOrganizationExample example = new MipOrganizationExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrgTypeIdNotEqualTo(orgType);
		criteria.andStatusEqualTo((byte)1);
		List<MipOrganization> list = mipOrganizationMapper.selectByExample(example);
		return list;
	}
	
	@Override
	public List<MipOrganization> getChildListByPid(Integer parentId, List<MipOrganization> list) {
		MipOrganizationExample example = new MipOrganizationExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		criteria.andStatusEqualTo((byte) 1);
		List<MipOrganization> resuleList = mipOrganizationMapper.selectByExample(example);
		list.addAll(resuleList);
		for (MipOrganization mipOrg : resuleList) {
			getChildListByPid(mipOrg.getId(), list);
		}
		return list;
	}
	@Override
	public List<MipOrganization> getMuseumListByAreaId(String areaId){
		List<MipOrganization> resuleList = mipOrganizationMapper.getMuseumListByAreaId(areaId);
		return resuleList;
	}
	@Override
	public List<MipOrganization> getOrgList() {
		
		return mipOrganizationMapper.getOrgList();
	};
}
