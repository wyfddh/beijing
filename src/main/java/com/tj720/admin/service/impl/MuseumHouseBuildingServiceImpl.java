package com.tj720.admin.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.IMuseumHouseBuildingMapper;
import com.tj720.admin.dto.MuseumBaseHouseDto;
import com.tj720.admin.dto.MuseumHouseBuildingDto;
import com.tj720.admin.service.IMuseumHouseBuildingService;
import com.tj720.mip.utils.Tools;

@Service("MuseumHouseBuildingServiceImpl")
public class MuseumHouseBuildingServiceImpl implements IMuseumHouseBuildingService {

    @Autowired
    IMuseumHouseBuildingMapper museumHouseBuildingDao;

    //条件查询角色分页
    @Override
    public List<MuseumHouseBuildingDto> selectList(String museumId,String flag){
        List<MuseumHouseBuildingDto> list = museumHouseBuildingDao.selectList(museumId,flag);
        return list;
    };
    @Override
    public MuseumBaseHouseDto selectForm(String museumId,String flag){
        MuseumBaseHouseDto info = museumHouseBuildingDao.selectForm(museumId,flag);
        return info;
    };
    @Override
    public void insert(MuseumHouseBuildingDto houseInfo){
    	String userId = Tools.getUser().getId();
    	houseInfo.setCreatorId(userId);
		houseInfo.setCreateTime(new Date());
		houseInfo.setUpdateId(userId);
		houseInfo.setUpdateTime(new Date());
	    houseInfo.setId(IdUtils.nextId(houseInfo));
        museumHouseBuildingDao.insert(houseInfo);
    };
    @Override
    public void update(MuseumHouseBuildingDto houseInfo){
    	String userId = Tools.getUser().getId();
    	houseInfo.setUpdateId(userId);
		houseInfo.setUpdateTime(new Date());
        museumHouseBuildingDao.update(houseInfo);
    };
    @Override
    public void insertBase(MuseumBaseHouseDto baseHouseInfo){
    	String userId = Tools.getUser().getId();
    	baseHouseInfo.setCreatorId(userId);
    	baseHouseInfo.setCreateTime(new Date());
    	baseHouseInfo.setUpdateId(userId);
    	baseHouseInfo.setUpdateTime(new Date());
    	baseHouseInfo.setId(IdUtils.nextId(baseHouseInfo));
    	
        museumHouseBuildingDao.insertBase(baseHouseInfo);
    };
    @Override
    public void updateBase(MuseumBaseHouseDto baseHouseInfo){
    	String userId = Tools.getUser().getId();
    	baseHouseInfo.setUpdateId(userId);
    	baseHouseInfo.setUpdateTime(new Date());
        museumHouseBuildingDao.updateBase(baseHouseInfo);
    };
    @Override
    public int deleteByLogic(String id){
       int num= museumHouseBuildingDao.deleteByLogic(id);
       return num;
    };
    @Override
    public void deleteBase(String museumId, String flag){
    	museumHouseBuildingDao.deleteBase(museumId,flag);
    }
    @Override
    public void deleteBaseTwo(String museumId, String flag){
    	museumHouseBuildingDao.deleteBaseTwo(museumId,flag);
    }
    @Override
    public void updateFlag(MuseumBaseHouseDto baseHouseInfo){
    	String userId = Tools.getUser().getId();
    	baseHouseInfo.setUpdateId(userId);
    	baseHouseInfo.setUpdateTime(new Date());
    	museumHouseBuildingDao.updateFlag(baseHouseInfo);
    };
    @Override
    public MuseumHouseBuildingDto selectBuildingById(String id){
    	return museumHouseBuildingDao.selectBuildingById(id);
    };
    @Override
    public void updateFlagTwo(MuseumHouseBuildingDto info){
    	String userId = Tools.getUser().getId();
		info.setUpdateId(userId);
		info.setUpdateTime(new Date());
    	museumHouseBuildingDao.updateFlagTwo(info);
    };
}
