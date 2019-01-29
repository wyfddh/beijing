package com.tj720.admin.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.IMuseumShowRoomMapper;
import com.tj720.admin.dto.MuseumShowRoomDto;
import com.tj720.admin.service.IMuseumShowRoomService;
import com.tj720.mip.utils.Tools;

@Service("MuseumShowRoomServiceImpl")
public class MuseumShowRoomServiceImpl implements IMuseumShowRoomService {

    @Autowired
    IMuseumShowRoomMapper showRoomMapper;

    //条件查询角色分页
    @Override
    public MuseumShowRoomDto selectForm(String museumId){
    	MuseumShowRoomDto serviceInfo = showRoomMapper.selectForm(museumId);
        return serviceInfo;
    };

    public List<MuseumShowRoomDto> selectList(String museumId,String flag){
        List<MuseumShowRoomDto> serviceInfo = showRoomMapper.selectList(museumId,flag);
        return serviceInfo;
    };
    public void insert(MuseumShowRoomDto info){
    	String userId = Tools.getUser().getId();
    	info.setCreatorId(userId);
    	info.setCreateTime(new Date());
    	info.setUpdateId(userId);
    	info.setUpdateTime(new Date());
    	info.setId(IdUtils.nextId(info));
    	showRoomMapper.insert(info);
    };

    public void update(MuseumShowRoomDto info){
    	String userId = Tools.getUser().getId();
    	info.setUpdateId(userId);
    	info.setUpdateTime(new Date());
    	showRoomMapper.update(info);
    };

    public int deleteByLogic(String id){
        return showRoomMapper.deleteByLogic(id);
    };
    
    @Override
    public void deleteBase(String museumId, String flag){
    	showRoomMapper.deleteBase(museumId,flag);
    }
    @Override
    public void updateFlag(MuseumShowRoomDto info){
    	showRoomMapper.updateFlag(info);
    };
}
