package com.tj720.admin.service;

import java.util.List;
import java.util.Map;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.MipArea;

public interface MipAreaService extends BaseService<MipArea>{
	Map<String, String> getCityName();
	List<MipArea> getCityList();
	
	/**
	 * 根据父id查询下面所有数据
	 * @param pid
	 * @return
	 */
	List<MipArea> getCityListByPid(Integer pid);
	
	List<MipArea> getAreaJson();
}
