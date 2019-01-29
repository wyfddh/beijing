package com.tj720.admin.service;


import java.util.List;

import com.tj720.admin.dto.MuseumDepartmentDto;

public interface IMuseumDepartmentService {

    public List<MuseumDepartmentDto> selectList(String museumId);

    public int insert(MuseumDepartmentDto info);

    public int update(MuseumDepartmentDto info);
    
    public List<MuseumDepartmentDto> getDepByParentId(String fId);
    
    public List<MuseumDepartmentDto> selectDepartByFid(String id);
    
    public MuseumDepartmentDto getById(String id);
    
    public MuseumDepartmentDto getParentDepartInfo(String id);
    
}
