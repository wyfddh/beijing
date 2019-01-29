package com.tj720.admin.service;


import java.util.List;

import com.tj720.admin.dto.MuseumCostDto;
import com.tj720.admin.dto.MuseumDisplayShowDto;

public interface IMuseumDisplayShowService {

    public List<MuseumDisplayShowDto> selectShowList(String museumId,String flag);

    public int save(List<MuseumDisplayShowDto> list);

    public int deleteByLogic(String id);
    
    public void deleteBase(String museumId, String flag);
    
    public void updateFlag(MuseumDisplayShowDto info);
    
    public void insertShow(MuseumDisplayShowDto costDto);
    
    public MuseumDisplayShowDto selectShowById(String id);
}
