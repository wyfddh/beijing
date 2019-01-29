package com.tj720.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.IMuseumPromotionMapper;
import com.tj720.admin.dto.MuseumPromotionDto;
import com.tj720.admin.dto.MuseumWarehouseDto;
import com.tj720.admin.service.IMuseumPromotionService;

@Service("museumPromotionService")
public class MuseumPromotionServiceImpl implements IMuseumPromotionService {

    @Autowired
    IMuseumPromotionMapper museumPromotionDao;

    //条件查询角色分页
    @Override
    public MuseumPromotionDto selectForm(String museumId,String flag){
        MuseumPromotionDto serviceInfo = museumPromotionDao.selectForm(museumId,flag);
        return serviceInfo;
    };
    @Override
    public void insert(MuseumPromotionDto promotionDtoInfo){
        museumPromotionDao.insert(promotionDtoInfo);
    };
    @Override
    public void update(MuseumPromotionDto promotionDtoInfo){
        museumPromotionDao.update(promotionDtoInfo);
    };
    
    @Override
    public void deleteBase(String museumId, String flag){
    	museumPromotionDao.deleteBase(museumId,flag);
    }
    @Override
    public void updateFlag(MuseumPromotionDto promotionDtoInfo){
    	museumPromotionDao.updateFlag(promotionDtoInfo);
    };
}
