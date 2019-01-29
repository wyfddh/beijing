package com.tj720.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.admin.model.CulturalManageList;
import com.tj720.admin.model.CulturalRelicInfo;
import com.tj720.admin.model.CulturalRelicMainEquipment;
import com.tj720.admin.model.CulturalRelicOtherEquipment;
import com.tj720.admin.model.CulturalRelicPersonnelChange;
import com.tj720.admin.model.CulturalRelicPersonnelDetail;
import com.tj720.admin.model.CulturalSafeList;
import com.tj720.mip.framework.JsonResult;

@Service
public interface RelicsBureauService {

	CulturalRelicInfo getByOrgId(String relicsBureauId);

	int update(CulturalRelicInfo culturalRelicInfo);

	int insert(CulturalRelicInfo culturalRelicInfo);
	
	int insertPlus(CulturalRelicInfo culturalRelicInfo);
	
	/**
	 * 主要仪器设备
	 */
//	List<CulturalRelicEquipmentDetail> getEquipmentByOrgId(String orgId,String flag);

	List<CulturalRelicMainEquipment> getEquipmentByOrgId(String orgId,String flag);
	
	List<CulturalRelicOtherEquipment> getOtherEquipmentByOrgId(String orgId,String flag);
	
	CulturalRelicOtherEquipment getOtherEquipmentById(String id);
	
//	int updateEquipment(CulturalRelicEquipmentDetail culturalRelicEquipmentDetail);
	
	int updateEquipment(CulturalRelicMainEquipment culturalRelicMainEquipment);
	
	int updateOtherEquipment(CulturalRelicOtherEquipment culturalRelicOtherEquipment);
	
//	int insertEquipment(CulturalRelicEquipmentDetail culturalRelicEquipmentDetail);
	
	int insertEquipment(CulturalRelicMainEquipment culturalRelicMainEquipment);
	
	int insertOtherEquipment(CulturalRelicOtherEquipment culturalRelicOtherEquipment);
	
//	int insertEquipmentPlus(CulturalRelicEquipmentDetail culturalRelicEquipmentDetail);
	
	int insertEquipmentPlus(CulturalRelicMainEquipment culturalRelicMainEquipment);
	
	int insertOtherEquipmentPlus(CulturalRelicOtherEquipment culturalRelicOtherEquipment);
	
//	int deleteEquipment(String museumId,String flag);
	
	int deleteEquipment(String museumId,String flag);
	
	int deleteOtherEquipment(String museumId,String flag);
	
//	int deleteEquipmentByPrimary(String id);
	
	int deleteEquipmentByPrimary(String id);
	
	int deleteOtherEquipmentByPrimary(String id);
	
	List<CulturalRelicPersonnelChange> getPersonList(String relicsBureauId);

	List<CulturalRelicPersonnelDetail> getPersonDetailList(String relicsBureauId);

	@Transactional
	int savePerson(List<CulturalRelicPersonnelChange> updateChangeList,
			List<CulturalRelicPersonnelChange> insertChangeList,
			List<CulturalRelicPersonnelDetail> updateDetailList,
			List<CulturalRelicPersonnelDetail> insertDetailList);

	void deletePerson(String id);

	void deleteDetail(String id);

	List<CulturalRelicInfo> getBaseInfo(String orgId,String flag);

	void deleteInfo(String orgId, String flag);

	List<CulturalRelicPersonnelChange> getPersonInfo(String orgId,String flag);

	void deletePersonChange(String orgId, String flag);

	void insertPersonChange(CulturalRelicPersonnelChange personnelChange);
	
	void insertPersonChangePlus(CulturalRelicPersonnelChange personnelChange);

	void updatePersonChange(CulturalRelicPersonnelChange personnelChange);

	List<CulturalRelicPersonnelDetail> getPersonDetailInfo(String museumId,
			String flag1);

	void deletePersonDetail(String museumId, String flag1);

	void insertPersonDetail(CulturalRelicPersonnelDetail personnelDetail);

	void insertPersonDetailPlus(CulturalRelicPersonnelDetail personnelDetail);
	
	void updatePersonDetail(CulturalRelicPersonnelDetail personnelDetail);

	CulturalRelicPersonnelDetail get(String id);
	
	List<CulturalSafeList> getCulturalSafeFileList(String museumId,String level);
	
	JsonResult saveCulturalSafeFileList(List<CulturalSafeList> safeList,String museumId);
	
	List<CulturalManageList> getCulturalManageFileList(String museumId,String level);
	
	JsonResult saveCulturalManageFileList(List<CulturalManageList> safeList,String museumId);
	
	int deleteSafe(String museumId,String flag);
	
	int insertSafe(CulturalSafeList info);
	
	int deleteManage(String museumId,String flag);
	
	int insertManage(CulturalManageList info);
}
