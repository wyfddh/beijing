package com.tj720.admin.dao.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.xdgf.usermodel.section.geometry.InfiniteLine;

import com.tj720.admin.model.CulturalSafeList;

public interface CulturalSafeListMapper {
    int deleteByPrimaryKey(String id);

    int insert(CulturalSafeList record);

    int insertSelective(CulturalSafeList record);

    CulturalSafeList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CulturalSafeList record);

    int updateByPrimaryKey(CulturalSafeList record);
    
    List<CulturalSafeList> getCulturalSafeFileList(@Param("museumId") String museumId,@Param("level") String level);
    
    int deleteByExample(@Param("museumId") String museumId,@Param("flag") String flag);
}