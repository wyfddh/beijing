package com.tj720.admin.service;


import java.util.List;
import java.util.Map;

import com.tj720.admin.dto.MuseumVisitorDto;
import com.tj720.admin.dto.MuseumVisitorMonth;

public interface IMuseumVisitorService {

    public List<MuseumVisitorMonth> selectVisitorMonthList(MuseumVisitorDto info);

    public List<MuseumVisitorDto> selectVisitorDayList(MuseumVisitorDto info);

    public Integer save(MuseumVisitorDto daysDto,MuseumVisitorMonth monthDto);
    
    public List<Map<String,Integer>> getYearList(String museumId);
    
}
