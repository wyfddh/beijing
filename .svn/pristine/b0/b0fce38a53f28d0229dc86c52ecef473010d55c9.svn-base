package com.tj720.admin.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipStatisticsMapper;
import com.tj720.admin.model.MipStatistics;
import com.tj720.admin.model.MipStatisticsExample;
import com.tj720.admin.model.MipStatisticsExample.Criteria;
import com.tj720.admin.service.MipStatisticsService;
import com.tj720.mip.utils.MyString;

@Service("MipStatisticsServiceImpl")
public class MipStatisticsServiceImpl extends BaseServiceImpl<MipStatistics> implements MipStatisticsService{

	@Autowired
	MipStatisticsMapper mipStatisticsMapper;
	@Override
	public BaseDao<MipStatistics> getBaseDao() {
		return mipStatisticsMapper;
	}
	@Override
	public List<MipStatistics> getStatisticsList() {
		MipStatisticsExample example = new MipStatisticsExample();
		return mipStatisticsMapper.selectByExample(example);
	}
	@Override
	public int updateStatistics(MipStatistics mipStatistics) {
		MipStatisticsExample example = new MipStatisticsExample();
		Criteria createCriteria = example.createCriteria();
		//收藏单位id
		if(!MyString.isEmpty(mipStatistics.getCollectionUnit())) {
			createCriteria.andCollectionUnitEqualTo(mipStatistics.getCollectionUnit());
		}else {
			createCriteria.andCollectionUnitEqualTo("");
			mipStatistics.setCollectionUnit("");
		}
		//文物级别
		if(!MyString.isEmpty(mipStatistics.getCollectionLevel())) {
			createCriteria.andCollectionLevelEqualTo(mipStatistics.getCollectionLevel());
		}else {
			createCriteria.andCollectionLevelEqualTo("");
			mipStatistics.setCollectionLevel("");
		}
		//文物类别id
		if(!MyString.isEmpty(mipStatistics.getCollectionsCategory())) {
			createCriteria.andCollectionsCategoryEqualTo(mipStatistics.getCollectionsCategory());
		}else {
			createCriteria.andCollectionsCategoryEqualTo("");
			mipStatistics.setCollectionsCategory("");
		}
		//完残程度
		if(!MyString.isEmpty(mipStatistics.getEndResidueLevel())) {
			createCriteria.andEndResidueLevelEqualTo(mipStatistics.getEndResidueLevel());
		}else {
			createCriteria.andEndResidueLevelEqualTo("");
			mipStatistics.setEndResidueLevel("");
		}
		//入藏时间范围
		if(!MyString.isEmpty(mipStatistics.getGsEntryWarehouseTimeFrame())) {
			createCriteria.andGsEntryWarehouseTimeFrameEqualTo(mipStatistics.getGsEntryWarehouseTimeFrame());
		}else {
			createCriteria.andGsEntryWarehouseTimeFrameEqualTo("");
			mipStatistics.setGsEntryWarehouseTimeFrame("");
		}
		//文物来源
		if(!MyString.isEmpty(mipStatistics.getGsSource())) {
			createCriteria.andGsSourceEqualTo(mipStatistics.getGsSource());
		}else {
			createCriteria.andGsSourceEqualTo("");
			mipStatistics.setGsSource("");
		}
		//保存状态
		if(!MyString.isEmpty(mipStatistics.getGsStorageState())) {
			createCriteria.andGsStorageStateEqualTo(mipStatistics.getGsStorageState());
		}else {
			createCriteria.andGsStorageStateEqualTo("");
			mipStatistics.setGsStorageState("");
		}
		//年代
		if(!MyString.isEmpty(mipStatistics.getYearType())) {
			createCriteria.andYearTypeEqualTo(mipStatistics.getYearType());
		}else {
			createCriteria.andYearTypeEqualTo("");
			mipStatistics.setYearType("");
		}
		List<MipStatistics> selectByExample = mipStatisticsMapper.selectByExample(example);
		if(selectByExample != null && selectByExample.size() == 1) {
			return mipStatisticsMapper.updateNumberOa(example);
		}else {
			mipStatistics.setNumberOall(1L);
			mipStatistics.setId(UUID.randomUUID().toString());
			mipStatistics.setCreatettime(new Date());
			mipStatistics.setNumberYall(0L);
			mipStatistics.setSequence(0);
			mipStatistics.setStatus((byte)1);
			mipStatistics.setUpdatedTime(new Date());
			return mipStatisticsMapper.insert(mipStatistics);
		}
	}
	@Override
	public int updateStatisticsSub(MipStatistics mipStatistics) {
		MipStatisticsExample example = new MipStatisticsExample();
		Criteria createCriteria = example.createCriteria();
		//收藏单位id
		if(!MyString.isEmpty(mipStatistics.getCollectionUnit())) {
			createCriteria.andCollectionUnitEqualTo(mipStatistics.getCollectionUnit());
		}else {
			createCriteria.andCollectionUnitEqualTo("");
			mipStatistics.setCollectionUnit("");
		}
		//文物级别
		if(!MyString.isEmpty(mipStatistics.getCollectionLevel())) {
			createCriteria.andCollectionLevelEqualTo(mipStatistics.getCollectionLevel());
		}else {
			createCriteria.andCollectionLevelEqualTo("");
			mipStatistics.setCollectionLevel("");
		}
		//文物类别id
		if(!MyString.isEmpty(mipStatistics.getCollectionsCategory())) {
			createCriteria.andCollectionsCategoryEqualTo(mipStatistics.getCollectionsCategory());
		}else {
			createCriteria.andCollectionsCategoryEqualTo("");
			mipStatistics.setCollectionsCategory("");
		}
		//完残程度
		if(!MyString.isEmpty(mipStatistics.getEndResidueLevel())) {
			createCriteria.andEndResidueLevelEqualTo(mipStatistics.getEndResidueLevel());
		}else {
			createCriteria.andEndResidueLevelEqualTo("");
			mipStatistics.setEndResidueLevel("");
		}
		//入藏时间范围
		if(!MyString.isEmpty(mipStatistics.getGsEntryWarehouseTimeFrame())) {
			createCriteria.andGsEntryWarehouseTimeFrameEqualTo(mipStatistics.getGsEntryWarehouseTimeFrame());
		}else {
			createCriteria.andGsEntryWarehouseTimeFrameEqualTo("");
			mipStatistics.setGsEntryWarehouseTimeFrame("");
		}
		//文物来源
		if(!MyString.isEmpty(mipStatistics.getGsSource())) {
			createCriteria.andGsSourceEqualTo(mipStatistics.getGsSource());
		}else {
			createCriteria.andGsSourceEqualTo("");
			mipStatistics.setGsSource("");
		}
		//保存状态
		if(!MyString.isEmpty(mipStatistics.getGsStorageState())) {
			createCriteria.andGsStorageStateEqualTo(mipStatistics.getGsStorageState());
		}else {
			createCriteria.andGsStorageStateEqualTo("");
			mipStatistics.setGsStorageState("");
		}
		//年代
		if(!MyString.isEmpty(mipStatistics.getYearType())) {
			createCriteria.andYearTypeEqualTo(mipStatistics.getYearType());
		}else {
			createCriteria.andYearTypeEqualTo("");
			mipStatistics.setYearType("");
		}
		List<MipStatistics> selectByExample = mipStatisticsMapper.selectByExample(example);
		if(selectByExample != null && selectByExample.size() == 1) {
			return mipStatisticsMapper.updateNumberOaSub(example);
		}
		return 0;
	}
}
