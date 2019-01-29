package com.tj720.admin.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.IMuseumWarehouseMapper;
import com.tj720.admin.dto.MuseumBaseHouseDto;
import com.tj720.admin.dto.MuseumWarehouseDto;
import com.tj720.admin.service.IMuseumWarehouseService;
import com.tj720.mip.utils.Tools;

@Service("museumWarehouseService")
public class MuseumWarehouseServiceImpl implements IMuseumWarehouseService {

    @Autowired
    IMuseumWarehouseMapper museumWarehouseDao;

    //条件查询角色分页
    @Override
    public MuseumWarehouseDto selectForm(String id){
        MuseumWarehouseDto serviceInfo = museumWarehouseDao.selectForm(id);
        return serviceInfo;
    };

    public List<MuseumWarehouseDto> selectList(String museumId,String flag){
        List<MuseumWarehouseDto> serviceInfo = museumWarehouseDao.selectList(museumId,flag);
        return serviceInfo;
    };
    public void insert(MuseumWarehouseDto warehouseDto){
    	String userId = Tools.getUser().getId();
    	warehouseDto.setCreatorId(userId);
    	warehouseDto.setCreateTime(new Date());
    	warehouseDto.setUpdateId(userId);
    	warehouseDto.setUpdateTime(new Date());
    	warehouseDto.setId(IdUtils.nextId(warehouseDto));
        museumWarehouseDao.insert(warehouseDto);
    };

    public void update(MuseumWarehouseDto warehouseDto){
    	String userId = Tools.getUser().getId();
    	warehouseDto.setUpdateId(userId);
    	warehouseDto.setUpdateTime(new Date());
        museumWarehouseDao.update(warehouseDto);
    };

    public int deleteByLogic(String id){
        return museumWarehouseDao.deleteByLogic(id);
    };
    
    @Override
    public void deleteBase(String museumId, String flag){
    	museumWarehouseDao.deleteBase(museumId,flag);
    }
    @Override
    public void updateFlag(MuseumWarehouseDto warehouseDto){
    	museumWarehouseDao.updateFlag(warehouseDto);
    };
}
