/** 
 * <pre>项目名称:mip 
 * 文件名称:VirtualServiceImpl.java 
 * 包名:com.tj720.mip.service.content 
 * 创建日期:2017年1月14日上午11:20:02 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */
package com.tj720.mip.service.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dto.MuseumAllDto;
import com.tj720.mip.dto.MuseumInfoDto;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.MuseumInfoDao;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.MuseumCarouselService;
import com.tj720.mip.inter.service.table.MuseumInfoService;
import com.tj720.mip.model.Category;
import com.tj720.mip.model.MipMuseumCarousel;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MuseumInfo;
import com.tj720.mip.model.Picture;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/**
 * <pre>
 * 项目名称：mip    
 * 类名称：VirtualServiceImpl    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月14日 上午11:20:02    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月14日 上午11:20:02    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
@Service
public class MuseumInfoServiceImpl extends BaseService<MuseumInfo> implements MuseumInfoService {
	@Resource(name = "MuseumInfoDao")
	MuseumInfoDao museumInfoDao;

	@Autowired
	private Config config;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private MuseumCarouselService museumCarouselService;//博物馆轮播图
	@Autowired
	private PictureService pictureService;//图片表的service

	@Resource(name = "MuseumInfoDao")
	public void setDao(IBaseDao<MuseumInfo> dao) {
		super.setDao(dao);
	}

	@Override
	public MuseumInfo getOneMuseum(String hql) {
		return museumInfoDao.getOneMuseum(hql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tj720.mip.inter.service.table.MuseumInfoService#updateStatus(java.
	 * lang.String)
	 */
	@Override
	public void updateStatus(String sql) {
		museumInfoDao.updateStatus(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tj720.mip.inter.service.table.MuseumInfoService#getAttr(java.lang.
	 * String)
	 */
	@Override
	public List<Map> getAttr(String hql) {
		return museumInfoDao.getAttr(hql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tj720.mip.inter.service.table.MuseumInfoService#getSeachHql(com.tj720
	 * .mip.model.MuseumInfo)
	 */
	@Override
	public String getSeachHql(MuseumInfo museumInfo) {
		String hql = "SELECT new com.tj720.mip.dto.MuseumAllDto(i.museumName as museumName,i.orgId as orgId,i.cityId as cityId,i.categoryId as categoryId,i.id as museumInfoId,i.level as level ) "
				+ "FROM MipOrganization as o, MuseumInfo as i where i.orgId=o.id "
				+ "and o.open = 1 and o.status > 0 and o.isdelete = 0 and o.platformId = " + config.getPlatformId()
				+ " and o.level =3 ";
		StringBuffer seachHql = new StringBuffer(hql);
		if (museumInfo.getLevel() != 0) {
			museumInfo.setLevel(null);
			seachHql.append(" and i.level = " + museumInfo.getLevel());
		}
		if (!museumInfo.getCategoryId().equals("0")) {
			museumInfo.setCategoryId(null);
			seachHql.append(" and i.categoryId = " + museumInfo.getCategoryId());
		}
		seachHql.append(" ORDER BY o.sequence DESC ");
		return seachHql.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tj720.mip.inter.service.table.MuseumInfoService#getMuseumHql(com.
	 * tj720.mip.model.MuseumInfo)
	 */
	@Override
	public String getMuseumHql(MuseumAllDto museumDto, int platformId, String orgIds) {
		String hql = "SELECT new com.tj720.mip.dto.MuseumAllDto(i.museumName as museumName,i.orgId as orgId,i.cityId as cityId,i.categoryId as categoryId,i.id as museumInfoId, i.level as level) "
				+ "FROM MipOrganization as o,MuseumInfo as i, MipArea as c where o.cityId=c.id "
				+ "and i.orgId = o.id and o.open = 1 and o.status > 0 and o.isdelete = 0 and o.platformId=" + platformId
				+ " and o.id in (" + orgIds + ")";
		if (museumDto.getLevel() != null && museumDto.getLevel() != 0) {
			hql += " and i.level = " + museumDto.getLevel();
		}
		if (museumDto.getCategoryId() != null && !museumDto.getCategoryId().equals("0")) {
			hql += " and i.categoryId = " + museumDto.getCategoryId();
		}
		if (museumDto.getMuseumName() != null && !museumDto.getMuseumName().equals("")) {
			hql += " and i.museumName = '" + museumDto.getMuseumName() + "'";
		}
		hql += " order by o.sequence desc ";
		return hql;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tj720.mip.inter.service.table.MuseumInfoService#queryByDto(java.lang.
	 * String, java.util.Map, com.tj720.mip.utils.Page)
	 */
	@Override
	@Transactional
	public List<?> queryByDto(String hql, Map<String, Object> map, Page page) {
		return dao.queryByDto2(hql, map, page);
	}

	/**
	 * 查询博物馆详细信息
	 */
	@Override
	@Transactional
	public MuseumInfoDto getDetail(String museumId) {
		MuseumInfoDto museumInfoDto = new MuseumInfoDto();
		String hql = "from MuseumInfo where orgId = '"+ museumId +"' and status > 0";
		List<MuseumInfo> museumInfos = (List<MuseumInfo>) museumInfoDao.queryByHql(hql, Tools.getMap());
		if (!MyString.isEmpty(museumInfos)){
			MuseumInfo museumInfo = museumInfos.get(0);
			//查询博物馆信息
			MipOrganization org = mipOrganizationService.get(museumId);
			if (!MyString.isEmpty(org)) {
				museumInfoDto.setMuseumName(org.getName());//设置博物馆名称
			}
			museumInfoDto.setMuseumAddress(museumInfo.getAddress());//设置博物馆地址
			MipOrganization mipOrganization = mipOrganizationService.get(museumId);
			if (!MyString.isEmpty(mipOrganization)) {
				museumInfoDto.setLatitude(mipOrganization.getLatitude());
				museumInfoDto.setLongitude(mipOrganization.getLongitude());
			}
			String audioPath = museumInfo.getfAudio();
			if (!MyString.isEmpty(audioPath)) {
				museumInfoDto.setAudio(config.getRootUrl() + audioPath);//设置博物馆音频介绍
			}
			
			String logoId = museumInfo.getLogo();
			Picture picture = pictureService.get(logoId);
			if (!MyString.isEmpty(picture)) {
				String logo = picture.getUrl();
				if (!MyString.isEmpty(logo)) {
					museumInfoDto.setLogo(config.getRootUrl() + logo);//设置博物馆logo
				}
			}
			museumInfoDto.setIntroduce(museumInfo.getIntroduce());//设置博物馆场馆介绍
			museumInfoDto.setBuyTicket(museumInfo.getBuyTicket());//设置博物馆如何买票
			museumInfoDto.setNearby(museumInfo.getNearby());//设置博物馆附近餐饮
			museumInfoDto.setVisitNotes(museumInfo.getVisitNotes());//设置博物馆参观须知
			museumInfoDto.setServiceInformation(museumInfo.getServiceInformation());//设置博物馆服务信息
			museumInfoDto.setOpeningHours(museumInfo.getOpeningHours());//设置开放时间
			museumInfoDto.setThinId(museumInfo.getThinId());//设置皮肤
			//博物馆的轮播图
			List<MipMuseumCarousel> carouselList = museumCarouselService.findByMap(Tools.getMap("museumInfoId",museumInfo.getId()), " new  MipMuseumCarousel(id,pictureid,url)", null, null);
			if(carouselList.size() > 0){
				for (MipMuseumCarousel carousel : carouselList) {
					Picture pic = pictureService.get(carousel.getPictureid());
					if (!MyString.isEmpty(pic.getUrl())) {
						carousel.setBackUrl(config.getRootUrl()+pic.getUrl());
					} else {
						carousel.setBackUrl("");
					}
				}
			}
			museumInfoDto.setCarouselList(carouselList);//设置博物馆轮播图
		}
		return museumInfoDto;
	}

	
	
}
