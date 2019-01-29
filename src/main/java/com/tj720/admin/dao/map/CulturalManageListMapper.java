package com.tj720.admin.dao.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tj720.admin.model.CulturalManageList;

public interface CulturalManageListMapper {
    int deleteByPrimaryKey(String id);

    int insert(CulturalManageList record);

    int insertSelective(CulturalManageList record);

    CulturalManageList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CulturalManageList record);

    int updateByPrimaryKey(CulturalManageList record);
    
    List<CulturalManageList> getCulturalManageFileList(@Param("museumId") String museumId,@Param("level") String level);
    
    int deleteByExample(@Param("museumId") String museumId,@Param("flag") String flag);
}