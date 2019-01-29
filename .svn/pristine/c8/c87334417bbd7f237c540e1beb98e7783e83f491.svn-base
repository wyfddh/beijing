package com.tj720.admin.service;


import java.util.List;
import java.util.Map;

import com.tj720.admin.common.vo.SysDictVo;
import com.tj720.admin.dto.MuseumBaseInfoDto;
import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.mip.model.MipOrganization;



public interface IMuseumBaseInfoService {

	public int getCount(MuseumBaseInfoDto museumBaseInfoDto);
	
    public List<MuseumBaseInfoDto> selectMuseumList(MuseumBaseInfoDto museumBaseInfoDto);

    public List<SysDictVo> getDictListByKey(String key);
    
    public MuseumDataProgressDto getDetail(String museumId,String level);
    
    public MuseumBaseInfoDto selectMuseumById(String id,String del);
    
    public int saveBaseInfo(MuseumBaseInfoDto museumBaseInfoDto);
    
    public int insertProgress(MuseumDataProgressDto progressInfo);
    
    public int updateProgress(MuseumDataProgressDto progressInfo);
    
    public void deleteBase(String museumId,String flag);
    
    public void insertBase(MuseumBaseInfoDto museumBaseInfoDto);
    
    public void updateFlag(MuseumBaseInfoDto museumBaseInfoDto);
    
    public int deleteProgress(String museumId);
    
    public List<Map<String,Object>> getAreaList();
}
