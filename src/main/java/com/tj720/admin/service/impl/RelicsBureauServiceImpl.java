package com.tj720.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.CulturalManageListMapper;
import com.tj720.admin.dao.map.CulturalRelicEquipmentDetailMapper;
import com.tj720.admin.dao.map.CulturalRelicInfoMapper;
import com.tj720.admin.dao.map.CulturalRelicMainEquipmentMapper;
import com.tj720.admin.dao.map.CulturalRelicOtherEquipmentMapper;
import com.tj720.admin.dao.map.CulturalRelicPersonnelChangeMapper;
import com.tj720.admin.dao.map.CulturalRelicPersonnelDetailMapper;
import com.tj720.admin.dao.map.CulturalSafeListMapper;
import com.tj720.admin.dao.map.MipAttachmentMapper;
import com.tj720.admin.model.CulturalManageList;
import com.tj720.admin.model.CulturalRelicInfo;
import com.tj720.admin.model.CulturalRelicMainEquipment;
import com.tj720.admin.model.CulturalRelicMainEquipmentExample;
import com.tj720.admin.model.CulturalRelicOtherEquipment;
import com.tj720.admin.model.CulturalRelicOtherEquipmentExample;
import com.tj720.admin.model.CulturalRelicPersonnelChange;
import com.tj720.admin.model.CulturalRelicPersonnelDetail;
import com.tj720.admin.model.CulturalSafeList;
import com.tj720.admin.service.RelicsBureauService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Tools;
@Service
public class RelicsBureauServiceImpl implements RelicsBureauService {

	@Autowired
	private CulturalRelicInfoMapper culturalRelicInfoMapper;
	
	@Autowired
	private CulturalRelicEquipmentDetailMapper culturalRelicEquipmentDetailMapper;
	
	@Autowired
	private CulturalRelicPersonnelChangeMapper culturalRelicPersonnelChangeMapper;
	
	@Autowired
	private CulturalRelicPersonnelDetailMapper culturalRelicPersonnelDetailMapper;
	
	@Autowired
	CulturalRelicMainEquipmentMapper culturalRelicMainEquipmentMapper;
	
	@Autowired
	CulturalRelicOtherEquipmentMapper culturalRelicOtherEquipmentMapper;
	
	@Autowired
	CulturalSafeListMapper culturalSafeListMapper;
	
	@Autowired
	CulturalManageListMapper culturalManageListMapper;
	
	@Autowired
	private MipAttachmentMapper mipAttachmentMapmper;
	
	@Autowired
	Config config;
	
	@Override
	public CulturalRelicInfo getByOrgId(String relicsBureauId) {
		
		return culturalRelicInfoMapper.getByOrgId(relicsBureauId);
	}

	@Override
	public int update(CulturalRelicInfo culturalRelicInfo) {

		return culturalRelicInfoMapper.updateByPrimaryKeySelective(culturalRelicInfo);	
	}

	@Override
	public int insert(CulturalRelicInfo culturalRelicInfo) {
		
		return culturalRelicInfoMapper.insertSelective(culturalRelicInfo);
	}

	
	@Override
	public int insertPlus(CulturalRelicInfo culturalRelicInfo) {
		String userId = Tools.getUser().getId();
		culturalRelicInfo.setCreater(userId);
		culturalRelicInfo.setUpdater(userId);
		culturalRelicInfo.setUpdateTime(new Date());
		culturalRelicInfo.setCreateTime(new Date());
		culturalRelicInfo.setId(IdUtils.nextId(culturalRelicInfo));
		return culturalRelicInfoMapper.insertSelective(culturalRelicInfo);
	}

	/**
	 * 仪器设备
	 */
	/* (non-Javadoc)
	 * @see com.tj720.admin.service.RelicsBureauService#getEquipmentByOrgId(java.lang.String, java.lang.String)
	 */
	@Override
	public List<CulturalRelicMainEquipment> getEquipmentByOrgId(String orgId, String flag) {
		List<CulturalRelicMainEquipment> info = culturalRelicMainEquipmentMapper.getByOrgId(orgId,flag);
		//若未查询到数据，则加载模板数据
		if(null == info || info.size() == 0){
			info = culturalRelicMainEquipmentMapper.getTemplateList();
		}
		return info;
	}
	
	

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.RelicsBureauService#updateEquipment(com.tj720.admin.model.CulturalRelicMainEquipment)
	 */
	@Override
	public int updateEquipment(CulturalRelicMainEquipment culturalRelicMainEquipment) {
		int result = culturalRelicMainEquipmentMapper.updateByPrimaryKeySelective(culturalRelicMainEquipment);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.RelicsBureauService#insertEquipment(com.tj720.admin.model.CulturalRelicMainEquipment)
	 */
	@Override
	public int insertEquipment(CulturalRelicMainEquipment culturalRelicMainEquipment) {
		int result = culturalRelicMainEquipmentMapper.insertSelective(culturalRelicMainEquipment);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.RelicsBureauService#insertEquipmentPlus(com.tj720.admin.model.CulturalRelicMainEquipment)
	 */
	@Override
	public int insertEquipmentPlus(CulturalRelicMainEquipment culturalRelicMainEquipment) {
		String userId = Tools.getUser().getId();
		culturalRelicMainEquipment.setDataType("1");
		culturalRelicMainEquipment.setCreater(userId);
		culturalRelicMainEquipment.setUpdater(userId);
		culturalRelicMainEquipment.setUpdateTime(new Date());
		culturalRelicMainEquipment.setCreateTime(new Date());
		culturalRelicMainEquipment.setId(IdUtils.nextId(culturalRelicMainEquipment));
		int result = culturalRelicMainEquipmentMapper.insertSelective(culturalRelicMainEquipment);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.RelicsBureauService#deleteEquipment(java.lang.String, java.lang.String)
	 */
	@Override
	public int deleteEquipment(String museumId, String flag) {
		CulturalRelicMainEquipmentExample example = new CulturalRelicMainEquipmentExample();
		CulturalRelicMainEquipmentExample.Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(museumId);
		criteria.andDeleteMarkEqualTo(flag);
		int count = culturalRelicMainEquipmentMapper.deleteByExample(example);
		return count;
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.RelicsBureauService#deleteEquipmentByPrimary(java.lang.String)
	 */
	@Override
	public int deleteEquipmentByPrimary(String id) {
		int result = culturalRelicMainEquipmentMapper.deleteByPrimaryKey(id);
		return result;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.tj720.admin.service.RelicsBureauService#getOtherEquipmentByOrgId(java.lang.String, java.lang.String)
	 */
	@Override
	public List<CulturalRelicOtherEquipment> getOtherEquipmentByOrgId(String orgId, String flag) {
		List<CulturalRelicOtherEquipment> info = culturalRelicOtherEquipmentMapper.getByOrgId(orgId,flag);
		return info;
	}
	
	@Override
	public CulturalRelicOtherEquipment getOtherEquipmentById(String id) {
		CulturalRelicOtherEquipment info = culturalRelicOtherEquipmentMapper.selectByPrimaryKey(id);
		return info;
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.RelicsBureauService#updateOtherEquipment(com.tj720.admin.model.CulturalRelicOtherEquipment)
	 */
	@Override
	public int updateOtherEquipment(CulturalRelicOtherEquipment culturalRelicOtherEquipment) {
		int result = culturalRelicOtherEquipmentMapper.updateByPrimaryKeySelective(culturalRelicOtherEquipment);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.RelicsBureauService#insertOtherEquipment(com.tj720.admin.model.CulturalRelicOtherEquipment)
	 */
	@Override
	public int insertOtherEquipment(CulturalRelicOtherEquipment culturalRelicOtherEquipment) {
		int result = culturalRelicOtherEquipmentMapper.insertSelective(culturalRelicOtherEquipment);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.RelicsBureauService#insertOtherEquipmentPlus(com.tj720.admin.model.CulturalRelicOtherEquipment)
	 */
	@Override
	public int insertOtherEquipmentPlus(CulturalRelicOtherEquipment culturalRelicOtherEquipment) {
		String userId = Tools.getUser().getId();
		culturalRelicOtherEquipment.setCreater(userId);
		culturalRelicOtherEquipment.setUpdater(userId);
		culturalRelicOtherEquipment.setUpdateTime(new Date());
		culturalRelicOtherEquipment.setCreateTime(new Date());
		culturalRelicOtherEquipment.setId(IdUtils.nextId(culturalRelicOtherEquipment));
		int result = culturalRelicOtherEquipmentMapper.insertSelective(culturalRelicOtherEquipment);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.RelicsBureauService#deleteOtherEquipment(java.lang.String, java.lang.String)
	 */
	@Override
	public int deleteOtherEquipment(String museumId, String flag) {
		CulturalRelicOtherEquipmentExample example = new CulturalRelicOtherEquipmentExample();
		CulturalRelicOtherEquipmentExample.Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(museumId);
		criteria.andDeleteMarkEqualTo(flag);
		int count = culturalRelicOtherEquipmentMapper.deleteByExample(example);
		return count;
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.RelicsBureauService#deleteOtherEquipmentByPrimary(java.lang.String)
	 */
	@Override
	public int deleteOtherEquipmentByPrimary(String id) {
		int result = culturalRelicOtherEquipmentMapper.deleteByPrimaryKey(id);
		return result;
	}

	/**
	 * 仪器设备
	 */
	
	
	@Override
	public List<CulturalRelicPersonnelChange> getPersonList(String relicsBureauId) {
		
		return culturalRelicPersonnelChangeMapper.getPersonList(relicsBureauId);
	}

	@Override
	public List<CulturalRelicPersonnelDetail> getPersonDetailList(String relicsBureauId) {
		
		return culturalRelicPersonnelDetailMapper.getPersonDetailList(relicsBureauId);
	}

	@Override
	public int savePerson(List<CulturalRelicPersonnelChange> updateChangeList,
			List<CulturalRelicPersonnelChange> insertChangeList,
			List<CulturalRelicPersonnelDetail> updateDetailList,
			List<CulturalRelicPersonnelDetail> insertDetailList) {
		int num = 0;
		if (updateChangeList.size() > 0) {
			int num1 = culturalRelicPersonnelChangeMapper.updateChangeList(updateChangeList);
			if (num1 > 0) {
				num = num1;
			}
		}
		if (insertChangeList.size() > 0) {
			int num2 = culturalRelicPersonnelChangeMapper.insertChangeList(insertChangeList);
			if (num2 > 0) {
				num = num2;
			}
		}
		if (updateDetailList.size() > 0) {
			int num3 = culturalRelicPersonnelDetailMapper.updateDetailList(updateDetailList);
			if (num3 > 0) {
				num = num3;
			}
		}
		if (insertDetailList.size() > 0) {
			int num4 = culturalRelicPersonnelDetailMapper.insertDetailList(insertDetailList);
			if (num4 > 0) {
				num = num4;
			}
		}
		return num;
	}

	@Override
	public void deletePerson(String id) {
		
		culturalRelicPersonnelChangeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteDetail(String id) {

		culturalRelicPersonnelDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<CulturalRelicInfo> getBaseInfo(String orgId,String flag) {
		
		return culturalRelicInfoMapper.getBaseInfo(orgId,flag);
	}

	@Override
	public void deleteInfo(String orgId, String flag) {
		
		culturalRelicInfoMapper.deleteInfo(orgId,flag);
	}

	@Override
	public List<CulturalRelicPersonnelChange> getPersonInfo(String orgId,String flag) {
		
		return culturalRelicPersonnelChangeMapper.getPersonInfo(orgId,flag);
	}

	@Override
	public void deletePersonChange(String orgId, String flag) {
		
		culturalRelicPersonnelChangeMapper.deletePersonChange(orgId,flag);
	}

	@Override
	public void insertPersonChange(CulturalRelicPersonnelChange personnelChange) {
		
		culturalRelicPersonnelChangeMapper.insertSelective(personnelChange);
	}
	
	@Override
	public void insertPersonChangePlus(CulturalRelicPersonnelChange personnelChange) {
		// TODO Auto-generated method stub
		String userId = Tools.getUser().getId();
		personnelChange.setCreater(userId);
		personnelChange.setUpdater(userId);
		personnelChange.setUpdateTime(new Date());
		personnelChange.setCreateTime(new Date());
		personnelChange.setId(IdUtils.nextId(personnelChange));
		culturalRelicPersonnelChangeMapper.insertSelective(personnelChange);
	}

	@Override
	public void updatePersonChange(CulturalRelicPersonnelChange personnelChange) {
		
		culturalRelicPersonnelChangeMapper.updateByPrimaryKeySelective(personnelChange);
	}

	@Override
	public List<CulturalRelicPersonnelDetail> getPersonDetailInfo(String orgId, String flag) {
		
		return culturalRelicPersonnelDetailMapper.getPersonDetailInfo(orgId,flag);
	}

	@Override
	public void deletePersonDetail(String orgId, String flag) {
		culturalRelicPersonnelDetailMapper.deletePersonDetail(orgId,flag);
		
	}

	@Override
	public void insertPersonDetail(CulturalRelicPersonnelDetail personnelDetail) {
		culturalRelicPersonnelDetailMapper.insertSelective(personnelDetail);
		
	}
	@Override
	public void insertPersonDetailPlus(CulturalRelicPersonnelDetail personnelDetail) {
		String userId = Tools.getUser().getId();
		personnelDetail.setCreater(userId);
		personnelDetail.setUpdater(userId);
		personnelDetail.setUpdateTime(new Date());
		personnelDetail.setCreateTime(new Date());
		personnelDetail.setId(IdUtils.nextId(personnelDetail));
		culturalRelicPersonnelDetailMapper.insertSelective(personnelDetail);		
	}

	@Override
	public void updatePersonDetail(CulturalRelicPersonnelDetail personnelDetail) {
		culturalRelicPersonnelDetailMapper.updateByPrimaryKeySelective(personnelDetail);
		
	}

	@Override
	public CulturalRelicPersonnelDetail get(String id) {
		return culturalRelicPersonnelDetailMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<CulturalSafeList> getCulturalSafeFileList(String museumId,String level){
		List<CulturalSafeList> safeLists = culturalSafeListMapper.getCulturalSafeFileList(museumId,level);
		for(CulturalSafeList info:safeLists) {
//			info.setAttPath(config.getRootPath()+info.getAttPath());
			info.setAttPath(info.getAttPath());
		}
		return safeLists;
	}

	@Override
	public JsonResult saveCulturalSafeFileList(List<CulturalSafeList> safeList,String museumId) {
		try {
			for(CulturalSafeList info:safeList) {
				
				if(StringUtils.isNotBlank(info.getId())) {
					//删除的附件
					if("1".equals(info.getIsDelete())) {
						culturalSafeListMapper.deleteByPrimaryKey(info.getId());//删除主表数据
						if(StringUtils.isNotBlank(info.getFkId())) {
							mipAttachmentMapmper.deleteByPrimaryKey(info.getFkId());//删除附件表数据
						}
					}
				}else {
					//新增的附件
					String userId = Tools.getUser().getId();
					info.setId(IdUtils.nextId(info));
					info.setUpdater(userId);
					info.setUpdateTime(new Date());
					info.setCreater(userId);
					info.setCreateTime(new Date());
					info.setMuseumId(museumId);
					info.setDeleteMark("1");//博物馆数据
					culturalSafeListMapper.insert(info);
				}
			}
		}catch (Exception e) {
			return new JsonResult(0,"保存失败");
			// TODO: handle exception
		}
		return new JsonResult(1,"保存成功");
	}
	
	@Override
	public List<CulturalManageList> getCulturalManageFileList(String museumId,String level){
		List<CulturalManageList> safeLists = culturalManageListMapper.getCulturalManageFileList(museumId,level);
		for(CulturalManageList info:safeLists) {
			info.setAttPath(config.getRootPath()+info.getAttPath());
		}
		return safeLists;
	}

	@Override
	public JsonResult saveCulturalManageFileList(List<CulturalManageList> safeList,String museumId) {
		try {
			for(CulturalManageList info:safeList) {
				
				if(StringUtils.isNotBlank(info.getId())) {
					//删除的附件
					if("1".equals(info.getIsDelete())) {
						culturalManageListMapper.deleteByPrimaryKey(info.getId());//删除主表数据
						if(StringUtils.isNotBlank(info.getFkId())) {
							mipAttachmentMapmper.deleteByPrimaryKey(info.getFkId());//删除附件表数据
						}
					}
				}else {
					//新增的附件
					String userId = Tools.getUser().getId();
					info.setId(IdUtils.nextId(info));
					info.setUpdater(userId);
					info.setUpdateTime(new Date());
					info.setCreater(userId);
					info.setCreateTime(new Date());
					info.setMuseumId(museumId);
					info.setDeleteMark("1");//博物馆数据
					culturalManageListMapper.insert(info);
				}
			}
		}catch (Exception e) {
			return new JsonResult(0,"保存失败");
			// TODO: handle exception
		}
		return new JsonResult(1,"保存成功");
	}
	
	@Override
	public int insertSafe(CulturalSafeList info) {
		String userId = Tools.getUser().getId();
		info.setCreater(userId);
		info.setUpdater(userId);
		info.setUpdateTime(new Date());
		info.setCreateTime(new Date());
		info.setId(IdUtils.nextId(info));
		int result = culturalSafeListMapper.insertSelective(info);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.RelicsBureauService#deleteOtherEquipment(java.lang.String, java.lang.String)
	 */
	@Override
	public int deleteSafe(String museumId, String flag) {
		int count = culturalSafeListMapper.deleteByExample(museumId,flag);
		return count;
	}
	
	@Override
	public int insertManage(CulturalManageList info) {
		String userId = Tools.getUser().getId();
		info.setCreater(userId);
		info.setUpdater(userId);
		info.setUpdateTime(new Date());
		info.setCreateTime(new Date());
		info.setId(IdUtils.nextId(info));
		int result = culturalManageListMapper.insertSelective(info);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.RelicsBureauService#deleteOtherEquipment(java.lang.String, java.lang.String)
	 */
	@Override
	public int deleteManage(String museumId, String flag) {
		int count = culturalManageListMapper.deleteByExample(museumId,flag);
		return count;
	}
}
