package com.tj720.admin.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.dto.CWenChuangDetailDto;
import com.tj720.admin.dto.CWenChuangDto;
import com.tj720.admin.model.MipWenchuang;
import com.tj720.mip.utils.Page;

public interface WenChuangService extends BaseService<MipWenchuang> {

	List<CWenChuangDto> getAllPublished(Page page, Integer categoryId, String key) throws IllegalAccessException, InvocationTargetException;

	CWenChuangDetailDto getCWenChuangDetail(String id) throws IllegalAccessException, InvocationTargetException;

	int updatePublishDown(String id, String reason);
	
	int updatebyCompanyId(String id, byte status);

}
