package com.tj720.admin.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.dto.ReceiveNoticeDto;
import com.tj720.admin.model.CmsArticle;
import com.tj720.admin.model.MipVirtualExibitionHall;
import com.tj720.mip.dto.VirtualDto;
import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.VirtualShowroom;
import com.tj720.mip.utils.Page;

public interface VirtualService{

	List<VirtualDto> getVirtualList(List<String> orgList, String key,String type,String status, Page page, String currentOrg);

	int save(MipVirtualExibitionHall virtual);

	int delete(String id);

	int update(MipVirtualExibitionHall virtual);

	MipVirtualExibitionHall get(String id);

	int publish(String id, String status);
	
}
