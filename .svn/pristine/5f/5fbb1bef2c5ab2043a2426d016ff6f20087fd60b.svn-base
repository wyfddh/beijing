package com.tj720.admin.dao.map;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumBaseHouseDto;
import com.tj720.admin.dto.MuseumWarehouseDto;

/**
 * 博物馆基础资料DAO接口
 * @author chenshiya
 * @version 2018-05-17
 */
@Repository("museumWarehouseDao")
public interface IMuseumWarehouseMapper {

    public MuseumWarehouseDto selectForm(String id);

    public List<MuseumWarehouseDto> selectList(String museumId,String flag);

    public void insert(MuseumWarehouseDto serviceInfo);

    public void update(MuseumWarehouseDto serviceInfo);

    public int deleteByLogic(String id);
    
    public void deleteBase(String museumId,String flag);
    
    public void updateFlag(MuseumWarehouseDto serviceInfo);

}