package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.GmMuseumRegisterInfo;
import com.tj720.admin.model.GmMuseumRegisterInfoWithBLOBs;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.utils.Page;

public interface GmMuseumRegisterInfoService extends BaseService<GmMuseumRegisterInfo>{
	
	List<GmMuseumRegisterInfoWithBLOBs> getInfoList(Page page, int orgId, byte level);
	GmMuseumRegisterInfoWithBLOBs saveRegister(GmMuseumRegisterInfo registerInfo);
	GmMuseumRegisterInfoWithBLOBs getRegister(String id);

}
