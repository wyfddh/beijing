package com.tj720.admin.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipCarouselMapper;
import com.tj720.admin.model.MipAttachment;
import com.tj720.admin.model.MipCarousel;
import com.tj720.admin.model.MipCarouselExample;
import com.tj720.admin.model.MipCarouselExample.Criteria;
import com.tj720.admin.service.MipAttachmentService;
import com.tj720.admin.service.MipCarouselService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;



@Service
public class MipCarouselServiceImpl extends BaseServiceImpl<MipCarousel> implements MipCarouselService{

	@Autowired
	MipCarouselMapper mipCarouselMapper;
	
	@Autowired
	MipAttachmentService mipAttachmentService;
	
	@Autowired
	MipOrganizationService mipOrganizationService;
	
	@Autowired
	private Config config;
	
	@Override
	public BaseDao<MipCarousel> getBaseDao() {
		return mipCarouselMapper;
	}

	@Override
	public void insertCarouselInfo(MipCarousel carousel) {
		mipCarouselMapper.insert(carousel);
		
	}

	@Override
	public List<MipCarousel> getCarouselList(String userId) {
		MipCarouselExample example = new MipCarouselExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo((byte)1);
		example.setOrderByClause("sequence");
		List<MipCarousel> carouselList = mipCarouselMapper.selectByExample(example);
		if(!MyString.isEmpty(carouselList)){
			for(MipCarousel list : carouselList){
				MipAttachment mipAttachment = mipAttachmentService.get(list.getPictureId());
				if(mipAttachment != null && !StringUtils.isBlank(mipAttachment.getAttPath())) {
					mipAttachment.setAttPath(config.getImageUrl()+mipAttachment.getAttPath());
				}
				
				if(!StringUtils.isBlank(list.getOrgId())) {
					MipOrganization mipOrganization = mipOrganizationService.get(list.getOrgId());
					if(mipOrganization != null) {
						list.setMuseumName(mipOrganization.getName());
					}
				}
			}
		}
		return carouselList;
	}

	@Override
	public List<MipCarousel> getCarouselList(String userId,String carouselPositionId) {
		MipCarouselExample example = new MipCarouselExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo((byte)1);
		criteria.andCarouselPositionIdEqualTo(carouselPositionId);
		example.setOrderByClause("sequence");
		List<MipCarousel> carouselList = mipCarouselMapper.selectByExample(example);
		if(!MyString.isEmpty(carouselList)){
			for(MipCarousel list : carouselList){
				MipAttachment mipAttachment = mipAttachmentService.get(list.getPictureId());
				if(mipAttachment != null && !StringUtils.isBlank(mipAttachment.getAttPath())) {
					mipAttachment.setAttPath(config.getImageUrl()+mipAttachment.getAttPath());
					list.setImgUrl(mipAttachment.getAttPath());
				}
				list.setAttchment(mipAttachment);
				
				if(!StringUtils.isBlank(list.getOrgId())) {
					MipOrganization mipOrganization = mipOrganizationService.get(list.getOrgId());
					if(mipOrganization != null) {
						list.setMuseumName(mipOrganization.getName());
					}
				}
			}
		}
		return carouselList;
	}

	@Override
	public List<MipCarousel> getCarouselList(MipCarouselExample example){
		List<MipCarousel> carouselList = mipCarouselMapper.selectByExample(example);
		return carouselList;
	}

	@Override
	public void delectCarouselInfo(String id) {
		MipCarousel info = mipCarouselMapper.selectByPrimaryKey(id);
		if(!MyString.isEmpty(info)){
			info.setStatus((byte)0);
			mipCarouselMapper.updateByPrimaryKey(info);
			//删除文件表数据，删除文件数据
			mipAttachmentService.deleteFile(info.getPictureId());
		}
	}

	@Override
	public MipCarousel getCarousel(String id) {
		return mipCarouselMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateCarousel(MipCarousel carousel) {
		mipCarouselMapper.updateByPrimaryKey(carousel);
		
	}

	@Override
	public MipCarousel getCarouselInfo(String uId, String carouselPositionId) {
		MipCarouselExample example = new MipCarouselExample();
		example.setOrderByClause("updateTime desc");
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo((byte)1);
		criteria.andUidEqualTo(uId);
		criteria.andCarouselPositionIdEqualTo(carouselPositionId);
		List<MipCarousel> carouselList = mipCarouselMapper.selectByExample(example);
		MipCarousel info = new MipCarousel();
		if(!MyString.isEmpty(carouselList)){
			info = carouselList.get(0);
			info.setImgUrl(config.getImageUrl()+info.getPictureId());
		}
		return info;
	}

}
