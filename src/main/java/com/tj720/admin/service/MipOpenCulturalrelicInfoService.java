package com.tj720.admin.service;


import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.MipOpenCulturalrelicInfo;
import com.tj720.admin.model.MipOpenCulturalrelicInfoWithBLOBs;

public interface MipOpenCulturalrelicInfoService extends BaseService<MipOpenCulturalrelicInfo>{
	MipOpenCulturalrelicInfoWithBLOBs getCulturalrelicInfo(String id);
	int getCulturalrelicInfoCount(List<String> orgIdList);
	int countByOrgId(String orgId);
}
