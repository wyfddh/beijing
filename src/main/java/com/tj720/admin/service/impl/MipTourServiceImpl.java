package com.tj720.admin.service.impl;
import com.tj720.admin.dao.map.MipTourCollectionMapper;
import com.tj720.admin.dao.map.MipTourMapper;
import com.tj720.admin.dto.MipTourCollectionDto;
import com.tj720.admin.dto.MipTourDto;
import com.tj720.admin.model.MipTour;
import com.tj720.admin.service.MipTourService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("MipTourService")
public class MipTourServiceImpl implements MipTourService {

	@Autowired
	private MipTourMapper mipTourMapper;

	@Autowired
	private MipTourCollectionMapper mipTourCollectionMapper;

	@Autowired
	private Config config;

	/**
	 * 添加导览
	 * @param record
	 * @return
	 */
	@Override
	public int insert(MipTour record) {
		return mipTourMapper.insert(record);
	}

	/**
	 * 查询导览列表
	 * @param
	 * @return
	 */
	@Override
	public List<MipTour> selectMipTourList(String name, String status, Page page, String publishOrg,List<String> orgList, String currentOrgId) {
		if(name != null && name != ""){
			name = "%" + name + "%";
		}
		int countNum = mipTourMapper.countMipTourList(name,status,publishOrg,orgList,currentOrgId);
		page.setAllRow(countNum);
		List<MipTour> result = mipTourMapper.selectMipTourList( name,status,page.getStart(),page.getSize(),publishOrg,orgList,currentOrgId);
		return result;
	}

	/**
	 * 编辑导览
	 * @param record
	 * @return
	 */
	@Override
	public int updateByPrimaryKeySelective(MipTourDto record) {
		record.setUpdateTime(new Date());
		if(StringUtils.isNotBlank(record.getStartDateStr())){
			record.setStartDate(DateUtil.StringToDate(record.getStartDateStr()));
		}
		if(StringUtils.isNotBlank(record.getEndDateStr())){
			record.setEndDate(DateUtil.StringToDate(record.getEndDateStr()));
		}
		return mipTourMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 修改导览状态
	 * @param record
	 * @return
	 */
	@Override
	public int updateByPrimaryKey(MipTourDto record) {
		return mipTourMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	@Override
	public MipTour selectMipTourById(String id) {
		MipTour result = mipTourMapper.selectByPrimaryKey(id);
		if(result != null){
			if(StringUtils.isNotBlank(result.getIconUrl())){
				result.setIconUrl(config.getRootUrl() + result.getIconUrl() );
			}
		}
		return result;
	}

	@Override
	public List<MipTourCollectionDto> getCollectionList(String orgId, String tourId, MipTourCollectionDto search,Page page) {
		int countCollectionList = mipTourMapper.countCollectionList(orgId, tourId, search);
		page.setAllRow(countCollectionList);
		return mipTourMapper.getCollectionList(orgId,tourId,search,page.getStart(),page.getSize());
	}

	@Override
	public int countCollectionList(String orgId, String tourId, MipTourCollectionDto search) {
		return mipTourMapper.countCollectionList(orgId,tourId,search);
	}

	@Override
	public List<MipTourCollectionDto> getListByTourId(String tourId) {
		List<MipTourCollectionDto>  result = mipTourCollectionMapper.selectListBytourId(tourId);
		if(result != null){
			for (MipTourCollectionDto dto:result) {
				if(StringUtils.isNotBlank(dto.getUrl())) {
					dto.setUrl(config.getRootUrl() + dto.getUrl());
				}
			}
		}
		return result;
	}


	@Override
	public MipTour get(String id) {
		return null;
	}

	@Override
	public int create(MipTour model) {
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return 0;
	}
}
