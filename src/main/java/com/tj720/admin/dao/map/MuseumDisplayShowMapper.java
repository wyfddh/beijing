package com.tj720.admin.dao.map;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumDisplayShowDto;

/**
 * 陈列展览DAO接口
 * @author chenshiya
 * @version 2018-07-13
 */
@Repository("museumShowDao")
public interface MuseumDisplayShowMapper {

    public List<MuseumDisplayShowDto> selectShowList(String museumId,String flag);

    public void insert(MuseumDisplayShowDto info);

    public void update(MuseumDisplayShowDto info);

    public int deleteByLogic(String id);
    
    public void deleteBase(String museumId,String flag);
    
    public void updateFlag(MuseumDisplayShowDto info);
    
    public MuseumDisplayShowDto selectShowById(String id);
}