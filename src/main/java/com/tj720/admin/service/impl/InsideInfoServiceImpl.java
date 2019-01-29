package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.admin.dao.map.InsideInfoMapper;
import com.tj720.admin.dto.InsideInfoDto;
import com.tj720.admin.service.IInsideInfoService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

@Service
public class InsideInfoServiceImpl implements IInsideInfoService {

	@Autowired 
	private InsideInfoMapper insideInfoMapper;

	@Override
	public List<InsideInfoDto> selectList(Map<String, Object> map) throws Exception {
		return insideInfoMapper.selectList(map);
	}

	@Override
	public Integer getCount(Map<String, Object> map) throws Exception {
		return insideInfoMapper.getCount(map);
	}

	@Override
	@Transactional
	public int save(InsideInfoDto dto) throws Exception {
		 dto.setStatus("2");//已发布
		 int result = 0;
		 result = insideInfoMapper.save(dto);
		 result = insideInfoMapper.saveRecInfo(dto);
		 return result;
	}

	@Override
	public InsideInfoDto queryInsideInfoDetailById(Map<String,Object> map) throws Exception {
		return insideInfoMapper.queryInsideInfoDetailById(map);
	}
	
	@Override
	public List<InsideInfoDto> queryInsideInfoListDetailById(Map<String,Object> map) throws Exception {
		return insideInfoMapper.queryInsideInfoListDetailById(map);
	}

	@Override
	public void updateReadFlag(InsideInfoDto dto) throws Exception {
		  insideInfoMapper.updateReadFlag(dto);
	}

	@Override
	public int delete(InsideInfoDto dto) throws Exception {
		return insideInfoMapper.delete(dto);
	}

	@Override
	public int batchSave(List<InsideInfoDto> dtoList) throws Exception {
		int result = 0;
		result = insideInfoMapper.batchSave(dtoList);
		result = insideInfoMapper.batchSaveRecInfo(dtoList);
		return result;
	}
	
	@Override
	public List<InsideInfoDto> selectListForDesk(Map<String, Object> map) throws Exception {
		return insideInfoMapper.selectListForDesk(map);
	}
	
	@Override
	public List<Map<String,String>> getUserListByOrgList(List<String> orgList) throws Exception {
		return insideInfoMapper.getUserListByOrgList(orgList);
	}
	
	@Override
	public void saveForDesk(String infoTitle,String infoContent,String receiveOrgs) throws Exception {
		
		LoginInfoDto user = Tools.getUser();
		//查询所选组织下所有的人员
		String orgListString [] = receiveOrgs.split(",");
		List<String> orgList=new ArrayList<String>();
		for(int i =0;i<orgListString.length;i++){
			orgList.add(orgListString[i]);
		}
		List<Map<String,String>> personList = insideInfoMapper.getUserListByOrgList(orgList);
		InsideInfoDto messageInfo = new InsideInfoDto();
		// 插入当前消息
		messageInfo.setCreatedBy(user.getId());
		messageInfo.setLastUpdatedBy(user.getId());
		messageInfo.setInfoTitle(infoTitle);
		messageInfo.setInfoContent(infoContent);
		messageInfo.setStatus("2");//发布
		insideInfoMapper.save(messageInfo);
		
		int infoId = messageInfo.getInfoId();
		List<InsideInfoDto> receiverList = new ArrayList<InsideInfoDto>();
		for(Map<String,String> personMap :personList){
			String personId = personMap.get("id");
			InsideInfoDto receiverMap = new InsideInfoDto();
			receiverMap.setInfoId(infoId);
			receiverMap.setCreatedBy(user.getId());
			receiverMap.setReceiverId(personId);
			receiverList.add(receiverMap);
		}
		insideInfoMapper.batchSaveRecInfo(receiverList);
	}
	
	@Override
	public List<InsideInfoDto> selectMessageList(String userId,Integer pageStart,Integer pageSize) throws Exception{
		return insideInfoMapper.selectMessageList(userId,pageStart,pageSize);
	}
	
	@Override
	public Integer getMessageCount(String userId) throws Exception {
		return insideInfoMapper.getMessageCount(userId);
	}
}
