package com.tj720.admin.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.MuseumCollectionInfoMapper;
import com.tj720.admin.dto.MuseumCollectionDto;
import com.tj720.admin.service.IMuseumCollectionInfoService;
import com.tj720.mip.utils.Tools;

@Service("MuseumCollectionInfoServiceImpl")
public class MuseumCollectionInfoServiceImpl implements IMuseumCollectionInfoService {

    @Autowired
    MuseumCollectionInfoMapper museumCollectionDao;

    @Override
    public MuseumCollectionDto selectForm(String museumId,String flag){
    	MuseumCollectionDto serviceInfo = museumCollectionDao.selectForm(museumId,flag);
        return serviceInfo;
    };
    @Override
    public void insert(MuseumCollectionDto info){
    	String userId = Tools.getUser().getId();
    	info.setCreatorId(userId);
    	info.setUpdateId(userId);
    	info.setUpdateTime(new Date());
    	info.setCreateTime(new Date());
    	info.setId(IdUtils.nextId(info));
    	museumCollectionDao.insert(info);
    };
    @Override
    public void update(MuseumCollectionDto info){
    	String userId = Tools.getUser().getId();
    	info.setUpdateId(userId);
    	info.setUpdateTime(new Date());
    	museumCollectionDao.update(info);
    };
    
    @Override
    public void deleteBase(String museumId, String flag){
    	museumCollectionDao.deleteBase(museumId,flag);
    }
    @Override
    public void updateFlag(MuseumCollectionDto info){
    	String userId = Tools.getUser().getId();
    	info.setUpdateId(userId);
    	info.setUpdateTime(new Date());
    	museumCollectionDao.updateFlag(info);
    };
}
