package com.tj720.admin.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.dto.CCompanyDto;
import com.tj720.admin.model.CCompany;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Page;

public interface CCompanyService extends BaseService<CCompany> {
	
	CCompanyDto getDetail(String id) throws IllegalAccessException, InvocationTargetException;

	Map getAllCompanies(Page page, String companyName, String phone);

	int enable(String id);

	int notEnable(String id);

	Map getCheckCCompanies(Page page, String companyName, int status, String categoryName) throws IllegalAccessException, InvocationTargetException;

	int checkCCompany(String id, String auditMsg, int status);

}
