package com.tj720.admin.service;

import java.util.List;
import java.util.Map;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.MipSpreadtrum;
import com.tj720.mip.dto.SpreadtrumDto;
import com.tj720.mip.utils.Page;

public interface MipSpreadtrumService extends BaseService<MipSpreadtrum>{
	
	MipSpreadtrum get(String id);
	
	List<SpreadtrumDto> getSpreadtrumList(List<String> orgList, String key,String type,String startTime,String endTime, String status, Page page, String currentOrg);

	int save(MipSpreadtrum spreadtrum);

	int delete(String id);

	int update(MipSpreadtrum spreadtrum);

	int publish(String id, String status);
	
	/**
	 * 保存自定义表单数据
	 * @param map
	 * @return
	 */
	boolean saveDesignData(Map<String, Object> map, String userId, String orgId);
	
}
