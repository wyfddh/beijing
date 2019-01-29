package com.tj720.admin.dao.map;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumVisitorDto;

/**
 * 博物馆基础资料DAO接口
 * @author chenshiya
 * @version 2018-8-9
 */
@Repository("museumVisitorDao")
public interface IMuseumVisitorMapper {
	
	public MuseumVisitorDto selectVisitorDay(MuseumVisitorDto info);
	
    public List<MuseumVisitorDto> selectVisitorMonthList(MuseumVisitorDto info);

    public int insert(MuseumVisitorDto info);

    public int updateDay(MuseumVisitorDto info);
    
    public int updateMonth(MuseumVisitorDto info);
    
    public List<Map<String,Integer>> getYearList(String museumId);

}