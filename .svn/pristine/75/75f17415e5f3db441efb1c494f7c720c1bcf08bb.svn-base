package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.dto.VersionSelectDto;
import com.tj720.admin.model.DcVersionSelect;
import com.tj720.mip.utils.Page;

public interface DcVersionSelectService extends BaseService<DcVersionSelect>{
	void insertDcVersionSelect(DcVersionSelect dcVersionSelect);
	DcVersionSelect selectByCollectionId(String collectionId);
	void updateDcVersionSelect(DcVersionSelect dcVersionSelect);
	List<VersionSelectDto> getVersionSelectList(DcVersionSelect dcVersion,Page page,int collectionType,String orgTypeId,String orgId);

}
