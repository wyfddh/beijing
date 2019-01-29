package com.tj720.admin.service;

import java.util.List;
import java.util.Map;



import com.tj720.admin.dto.InsideInfoDto;

 
public interface IInsideInfoService {

	public Integer getCount(Map<String,Object> map) throws Exception;
	
	public List<InsideInfoDto> selectList(Map<String,Object> map) throws Exception;
	
	public int save(InsideInfoDto dto) throws Exception;
	
	public int delete(InsideInfoDto dto) throws Exception;
	
	public InsideInfoDto queryInsideInfoDetailById(Map<String,Object> map) throws Exception;
	
	public List<InsideInfoDto> queryInsideInfoListDetailById(Map<String,Object> map) throws Exception;
	
	public void updateReadFlag(InsideInfoDto dto) throws Exception;
	
	/**
	 * 批量保存站内信
	 * @param dtoList
	 * @return
	 * @throws Exception
	 */
	public int batchSave(List<InsideInfoDto> dtoList) throws Exception;
	
	public List<InsideInfoDto> selectListForDesk(Map<String,Object> map) throws Exception; 
	
	public List<Map<String, String>> getUserListByOrgList(List<String> orgList) throws Exception;
	
	public void saveForDesk(String infoTitle,String infoContent,String receiveOrgs) throws Exception;
	
	public List<InsideInfoDto> selectMessageList(String userId,Integer pageStart,Integer pageSize) throws Exception;
	
	public Integer getMessageCount(String userId) throws Exception;
	
}
