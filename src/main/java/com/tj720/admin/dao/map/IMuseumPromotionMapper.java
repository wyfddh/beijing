package com.tj720.admin.dao.map;


import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumPromotionDto;
import com.tj720.admin.dto.MuseumWarehouseDto;

/**
 * 博物馆基础资料DAO接口
 * @author chenshiya
 * @version 2018-05-17
 */
@Repository("museumPromotionDao")
public interface IMuseumPromotionMapper {

    public MuseumPromotionDto selectForm(String museumId,String flag);

    public void insert(MuseumPromotionDto serviceInfo);

    public void update(MuseumPromotionDto serviceInfo);

    public void deleteBase(String museumId,String flag);
    
    public void updateFlag(MuseumPromotionDto serviceInfo);

}