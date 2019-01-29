package com.tj720.admin.service.impl;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipTourCollectionMapper;
import com.tj720.admin.dto.MipTopicCollectionDto;
import com.tj720.admin.dto.MipTourCollectionDto;
import com.tj720.admin.model.MipTour;
import com.tj720.admin.model.MipTourCollection;
import com.tj720.admin.model.MipTourCollectionExample;
import com.tj720.admin.service.MipTourCollectionService;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("MipTourCollectionService")
public class MipTourCollectionServiceImpl extends BaseServiceImpl<MipTourCollection> implements MipTourCollectionService {

    @Autowired
    private  MipTourCollectionMapper mipTourCollectionMapper;

    @Autowired
    private Config config;
    @Autowired
    private UserService userService;


    @Override
    public BaseDao<MipTourCollection> getBaseDao() {
        return mipTourCollectionMapper;
    }

    @Override
    public MipTourCollection getBytourIdAndCollectionId(MipTourCollection MipTourCollection) {
        return mipTourCollectionMapper.getBytourIdAndCollectionId(MipTourCollection);
    }

    @Override
    public List<MipTourCollection> selectByExample(MipTourCollectionExample example) {
        return mipTourCollectionMapper.selectByExample(example);
    }

    @Override
    public int updateById(MipTourCollection MipTourCollection) {
        return mipTourCollectionMapper.updateByPrimaryKey(MipTourCollection);
    }

    @Override
    public List<MipTourCollectionDto> getListBytourId(String tourId) {
        List<MipTourCollectionDto> selectListByTopicId = mipTourCollectionMapper.selectListBytourId(tourId);
        for (MipTourCollectionDto mipTopicCollectionDto : selectListByTopicId) {
            if(StringUtils.isNotBlank(mipTopicCollectionDto.getUrl())) {
                mipTopicCollectionDto.setUrl(config.getRootUrl() + mipTopicCollectionDto.getUrl());
            }
        }
        return selectListByTopicId;
    }

    @Override
    public int getMaxSort(String tourId) {
        return mipTourCollectionMapper.getMaxSort(tourId);
    }

    @Override
    public int batchSave(List<MipTourCollection> list) {
        return mipTourCollectionMapper.batchSave(list);
    }

    @Override
    public List<MipTour> selectTopicByCollection(String collectionId) {
        return mipTourCollectionMapper.selectTopicByCollection(collectionId);
    }

    @Override
    public int deleteBytourId(MipTourCollection MipTourCollection) {
        return mipTourCollectionMapper.deleteMipTourCollection(MipTourCollection);
    }

    @Override
    public int deleteByCollectionId(List<String> collectionIds) {
        return 0;
    }

    @Override
    public List<MipTourCollectionDto> getListBytourIds(List<String> topics) {
        return null;
    }

}
