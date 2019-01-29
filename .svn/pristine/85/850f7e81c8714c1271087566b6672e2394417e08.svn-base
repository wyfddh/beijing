package com.tj720.admin.dao.map;

import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumBaseInfoDto;
import com.tj720.admin.dto.MuseumPublicServiceDto;

/**
 * 博物馆基础资料DAO接口
 * @author chenshiya
 * @version 2018-05-17
 */
@Repository("museumPublicServiceDao")
public interface IMuseumPublicServiceMapper {

    public MuseumPublicServiceDto selectForm(String museumId,String flag);

    public int insert(MuseumPublicServiceDto serviceInfo);

    public int update(MuseumPublicServiceDto serviceInfo);

    public void deleteBase(String museumId,String flag);
    
    public void updateFlag(MuseumPublicServiceDto serviceInfo);

}