package com.tj720.admin.service;


import java.util.List;

import com.tj720.admin.dto.MuseumBaseHouseDto;
import com.tj720.admin.dto.MuseumWarehouseDto;

public interface IMuseumWarehouseService {

    public MuseumWarehouseDto selectForm(String id);

    public List<MuseumWarehouseDto> selectList(String museumId,String flag);

    public void insert(MuseumWarehouseDto warehouseDto);

    public void update(MuseumWarehouseDto warehouseDto);

    public int deleteByLogic(String id);
    
    public void deleteBase(String museumId, String flag);
    
    public void updateFlag(MuseumWarehouseDto warehouseDto);
}
