package com.tj720.admin.service.impl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.IMuseumPublicServiceMapper;
import com.tj720.admin.dto.MuseumBaseInfoDto;
import com.tj720.admin.dto.MuseumPublicServiceDto;
import com.tj720.admin.service.IMuseumPublicServiceService;
import com.tj720.mip.utils.Tools;

@Service("MuseumPublicServiceServiceImpl")
public class MuseumPublicServiceServiceImpl implements IMuseumPublicServiceService {

    @Autowired
    IMuseumPublicServiceMapper museumPublicServiceDao;

    //条件查询角色分页
    @Override
    public MuseumPublicServiceDto selectForm(String museumId,String flag){
        MuseumPublicServiceDto serviceInfo = museumPublicServiceDao.selectForm(museumId,flag);
        return serviceInfo;
    };
    @Override
    public int insert(MuseumPublicServiceDto serviceDto){
    	String userId = Tools.getUser().getId();
    	serviceDto.setCreatorId(userId);
        serviceDto.setUpdateId(userId);
        serviceDto.setUpdateTime(new Date());
        serviceDto.setCreateTime(new Date());
        serviceDto.setId(IdUtils.nextId(serviceDto));
    	return museumPublicServiceDao.insert(serviceDto);
    };
    @Override
    public int update(MuseumPublicServiceDto houseInfo){
    	String userId = Tools.getUser().getId();
    	houseInfo.setUpdateId(userId);
    	houseInfo.setUpdateTime(new Date());
        return museumPublicServiceDao.update(houseInfo);
    };
    
    @Override
    public void deleteBase(String museumId,String flag){
    	museumPublicServiceDao.deleteBase(museumId,flag);
    };
    
    @Override
    public void updateFlag(MuseumPublicServiceDto houseInfo){
    	String userId = Tools.getUser().getId();
    	houseInfo.setUpdateId(userId);
    	houseInfo.setUpdateTime(new Date());
    	museumPublicServiceDao.updateFlag(houseInfo);
    }
}
