package com.tj720.admin.service;


import com.tj720.admin.dto.MuseumBaseInfoDto;
import com.tj720.admin.dto.MuseumPublicServiceDto;



public interface IMuseumPublicServiceService {

    public MuseumPublicServiceDto selectForm(String museumId,String flag);

    public int insert(MuseumPublicServiceDto houseInfo);

    public int update(MuseumPublicServiceDto houseInfo);

    public void deleteBase(String museumId,String flag);
    
    public void updateFlag(MuseumPublicServiceDto houseInfo);
}
