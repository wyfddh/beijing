package com.tj720.admin.dao.map;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumCostDto;
import com.tj720.admin.dto.MuseumDepartmentDto;

/**
 * 博物馆基础资料DAO接口
 * @author chenshiya
 * @version 2018-05-17
 */
@Repository("departmentMapper")
public interface IMuseumDepartmentMapper {

    public List<MuseumDepartmentDto> selectList(String museumId);

    public int insert(MuseumDepartmentDto info);

    public int update(MuseumDepartmentDto info);

    public List<MuseumDepartmentDto> getDepByParentId(String fId);
    
    public List<MuseumDepartmentDto> selectDepartByFid(String id);
    
    public MuseumDepartmentDto getById(String id);

    public MuseumDepartmentDto getParentDepartInfo(String id);
}