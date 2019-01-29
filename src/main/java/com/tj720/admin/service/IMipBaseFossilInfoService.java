package com.tj720.admin.service;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.MipBaseFossilInfo;

public interface IMipBaseFossilInfoService extends BaseService<MipBaseFossilInfo>{
	int getFossilInfoCount();
	int countByOrgId(String orgId);

}
