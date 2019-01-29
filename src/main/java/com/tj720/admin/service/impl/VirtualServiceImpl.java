package com.tj720.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.MipVirtualExibitionHallMapper;
import com.tj720.admin.model.MipVirtualExibitionHall;
import com.tj720.admin.service.VirtualService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.VirtualDto;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;


@Service
public class VirtualServiceImpl  implements VirtualService{
	@Autowired
	MipVirtualExibitionHallMapper mipVirtualExibitionHallMapper;

	@Override
	public List<VirtualDto> getVirtualList(List<String>orgList, String key,String type,String status,Page page, String currentOrg) {
		List<VirtualDto> virtualList = mipVirtualExibitionHallMapper.getVirtualList(orgList,key,type,status,page.getStart(),page.getSize(),currentOrg);
		int count = mipVirtualExibitionHallMapper.countVirtualList(orgList,key,type,status,currentOrg);
		page.setAllRow(count);
		return virtualList;
	}

	@Override
	public int save(MipVirtualExibitionHall virtual) {
		
		return mipVirtualExibitionHallMapper.insert(virtual);
	}

	@Override
	public int delete(String id) {
		
		return mipVirtualExibitionHallMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(MipVirtualExibitionHall virtual) {
		
		return mipVirtualExibitionHallMapper.updateByPrimaryKeyWithBLOBs(virtual);
	}

	@Override
	public MipVirtualExibitionHall get(String id) {
		
		return mipVirtualExibitionHallMapper.selectByPrimaryKey(id);
	}

	@Override
	public int publish(String id, String status) {
		LoginInfoDto user = Tools.getUser();
		return mipVirtualExibitionHallMapper.publish(id,status,user.getId(),new Date());
	}

	

}
