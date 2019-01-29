package com.tj720.admin.dao.map;


import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumDigitizationDto;
import com.tj720.admin.dto.MuseumPublicServiceDto;

/**
 * 博物馆基础资料DAO接口
 * @author chenshiya
 * @version 2018-05-17
 */
@Repository("museumDigitizationDao")
public interface IMuseumDigitizationMapper {

    public MuseumDigitizationDto selectForm(String museumId,String flag);

    public void insert(MuseumDigitizationDto serviceInfo);

    public void update(MuseumDigitizationDto serviceInfo);

    public void deleteBase(String museumId,String flag);
    
    public void updateFlag(MuseumDigitizationDto serviceInfo);
}