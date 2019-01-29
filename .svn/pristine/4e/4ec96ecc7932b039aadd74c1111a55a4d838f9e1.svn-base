package com.tj720.admin.dao.map;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumCostDto;

/**
 * 博物馆基础资料DAO接口
 * @author chenshiya
 * @version 2018-05-17
 */
@Repository("museumCostDao")
public interface IMuseumCostMapper {

    public List<MuseumCostDto> selectCostList(String museumId,String flag);

    public void insert(MuseumCostDto museumCostDto);

    public void update(MuseumCostDto museumCostDto);

    public int deleteByLogic(String id);
    
    public void deleteBase(String museumId,String flag);
    
    public void updateFlag(MuseumCostDto museumCostDto);
    
    public void insertCost(MuseumCostDto costDto);

}