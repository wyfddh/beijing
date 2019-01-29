package com.tj720.admin.dao.map;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumBaseHouseDto;
import com.tj720.admin.dto.MuseumHouseBuildingDto;

/**
 * 博物馆基础资料DAO接口
 * @author chenshiya
 * @version 2018-05-17
 */
public interface IMuseumHouseBuildingMapper {

    public List<MuseumHouseBuildingDto> selectList(String museumId,String flag);

    public MuseumBaseHouseDto selectForm(String museumId,String flag);

    public void insert(MuseumHouseBuildingDto houseInfo);

    public void update(MuseumHouseBuildingDto houseInfo);

    public void insertBase(MuseumBaseHouseDto baseHouseInfo);

    public void updateBase(MuseumBaseHouseDto baseHouseInfo);

    public int deleteByLogic(String id);
    
    public void deleteBase(String museumId,String flag);
    
    public void deleteBaseTwo(String museumId,String flag);
    
    public void updateFlag(MuseumBaseHouseDto baseHouseInfo);
    
    public MuseumHouseBuildingDto selectBuildingById(String id);
    
    public void updateFlagTwo(MuseumHouseBuildingDto info);

}