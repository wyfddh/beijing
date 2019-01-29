package com.tj720.admin.service;

import java.util.Date;
import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.dto.CollectionObjectDto;
import com.tj720.admin.dto.VersionContentDto;
import com.tj720.admin.model.DcVersionContent;
import com.tj720.admin.model.MipOpenCollectionInfo;
import com.tj720.admin.model.MipOpenCulturalrelicInfo;
import com.tj720.admin.model.MipOpenCulturalrelicInfoWithBLOBs;
import com.tj720.admin.model.MipOpenFossilInfo;
import com.tj720.admin.model.MipOpenFossilInfoWithBLOBs;
import com.tj720.admin.model.MipOrganization;

public interface DcVersionContentService extends BaseService<DcVersionContent>{

	int getContentCountByStatus(byte status);
	int getContentCountByTime(String beginTime,String endTime,byte status,String orgId, List<MipOrganization> orglist);
	void insertDcVersionContent(DcVersionContent content);
	DcVersionContent selectByVersionId(String versionId);
	List<VersionContentDto> selectByVersionIdList(String versionId);
	CollectionObjectDto selectById(String id,int contentType);
	void updateInfo(DcVersionContent content);
	int getByAreaIdCount(String areaId,byte status,String beginTime,String endTime);
	int getByOrgIdCount(int orgId,byte status);
	int getByOrgIdTimeCount(int orgId,byte status,String beginTime,String endTime);
	MipOpenCulturalrelicInfoWithBLOBs selectByCulturalrelic(String id);
	MipOpenFossilInfoWithBLOBs selectByFossil(String id);
	int getByAreaIdCountNew(String areaId,byte status,String beginTime,String endTime);
	int getByOrgList(byte status,List<String> orgList);
}
