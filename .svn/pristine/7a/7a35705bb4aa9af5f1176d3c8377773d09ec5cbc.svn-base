package com.tj720.admin.dao.map;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumShowRoomDto;

/**
 * 博物馆基础资料DAO接口
 * @author chenshiya
 * @version 2018-05-17
 */
@Repository("showRoomMapper")
public interface IMuseumShowRoomMapper {

    public MuseumShowRoomDto selectForm(String museumId);

    public List<MuseumShowRoomDto> selectList(String museumId,String flag);

    public void insert(MuseumShowRoomDto info);

    public void update(MuseumShowRoomDto info);

    public int deleteByLogic(String id);
    
    public void deleteBase(String museumId,String flag);
    
    public void updateFlag(MuseumShowRoomDto info);

}