package com.tj720.admin.dao.map;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.beust.jcommander.Parameter;
import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.dto.InsideInfoDto;

public interface InsideInfoMapper extends BaseDao<InsideInfoDto>{

	 Integer getCount(Map<String, Object> map) throws Exception;

	 List<InsideInfoDto> selectList(Map<String, Object> map) throws Exception;
	
	 int save(InsideInfoDto dto) throws Exception;
	 
	 int saveRecInfo(InsideInfoDto dto) throws Exception;
	
	 void update(InsideInfoDto dto) throws Exception;
	
	 InsideInfoDto queryInsideInfoDetailById(Map<String,Object> map) throws Exception;
	 
	 List<InsideInfoDto> queryInsideInfoListDetailById(Map<String,Object> map) throws Exception;
	
	 void updateReadFlag(InsideInfoDto dto) throws Exception;
	
	 int delete(InsideInfoDto dto) throws Exception;
	 
	 int batchSave(@Param("list")List<InsideInfoDto> list) throws Exception;
	 
	 int batchSaveRecInfo(@Param("list")List<InsideInfoDto> list) throws Exception;
	 
	 List<InsideInfoDto> selectListForDesk(Map<String, Object> map) throws Exception;
	 
	 public List<Map<String,String>> getUserListByOrgList(List<String> orgList) throws Exception;
	 
	 List<InsideInfoDto> selectMessageList(@Param("userId")String userId,@Param("pageStart")Integer pageStart,@Param("pageSize")Integer pageSize) throws Exception;
	 
	 Integer getMessageCount(String userId) throws Exception;
	
}
