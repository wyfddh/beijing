package com.tj720.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.IMuseumDepartmentMapper;
import com.tj720.admin.dto.MuseumDepartmentDto;
import com.tj720.admin.service.IMuseumDepartmentService;
import com.tj720.mip.utils.Tools;

@Service("MuseumDepartmentServiceImpl")
public class MuseumDepartmentServiceImpl implements IMuseumDepartmentService {

    @Autowired
    IMuseumDepartmentMapper departmentMapper;

    //条件查询角色分页
    @Override
    public List<MuseumDepartmentDto> selectList(String museumId){
        List<MuseumDepartmentDto> list = departmentMapper.selectList(museumId);
        return list;
    };
    
    public List<MuseumDepartmentDto> getDepByParentId(String fId){
    	List<MuseumDepartmentDto> list = departmentMapper.getDepByParentId(fId);
        return list;
    };
    @Override
    public int insert(MuseumDepartmentDto info){
    	String userId = Tools.getUser().getId();
    	info.setCreatorId(userId);
    	info.setCreateTime(new Date());
    	info.setUpdateId(userId);
    	info.setUpdateTime(new Date());
    	info.setId(IdUtils.nextId(info));
    	return departmentMapper.insert(info);
    }
    @Override
    public int update(MuseumDepartmentDto info){
    	String userId = Tools.getUser().getId();
    	info.setUpdateId(userId);
    	info.setUpdateTime(new Date());
    	return departmentMapper.update(info);
    }
    @Override
    public List<MuseumDepartmentDto> selectDepartByFid(String id){
    	List<MuseumDepartmentDto> list = departmentMapper.selectDepartByFid(id);
        return list;
    };
    
    @Override
    public MuseumDepartmentDto getById(String id){
    	return departmentMapper.getById(id);
    };
    
    @Override
    public MuseumDepartmentDto getParentDepartInfo(String id){
    	return departmentMapper.getParentDepartInfo(id);
    };
}
