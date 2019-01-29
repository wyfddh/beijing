package com.tj720.admin.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.tj720.admin.dto.MuseumCostDto;
import com.tj720.admin.dto.MuseumPromotionDto;

public interface IMuseumCostService {

    public List<MuseumCostDto> selectCostList(String museumId,String flag);

    public int save(List<MuseumCostDto> list);

    public int deleteByLogic(String id);
    
    public void deleteBase(String museumId, String flag);
    
    public void updateFlag(MuseumCostDto costDto);
    
    public void insertCost(MuseumCostDto costDto);
}
