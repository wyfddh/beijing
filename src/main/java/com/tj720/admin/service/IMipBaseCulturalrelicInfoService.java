package com.tj720.admin.service;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.MipBaseCulturalrelicInfo;

public interface IMipBaseCulturalrelicInfoService extends BaseService<MipBaseCulturalrelicInfo>{
	int getCulturalrelicInfoCount();
	int countByOrgId(String orgId);

}
