package com.tj720.admin.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.admin.model.CulturalOrgInfo;
import com.tj720.mip.utils.Tools;

/**
* @author chengrongkai
* @version 创建时间：2018年8月17日 上午10:10:35
* @ClassName 类名称
* @Description 类描述
*/

@Service
public interface RelicsUnitService {
	CulturalOrgInfo selectRelicsUnitById(String relicsUnitId,String level);
	
	
	int saveBaseInfo(CulturalOrgInfo culturalOrgInfo);
	
	int insertBaseInfoByFlag(CulturalOrgInfo culturalOrgInfo);
	
	int updateBaseInfoByFlag(CulturalOrgInfo culturalOrgInfo);
		
	int delBaseInfo(String orgId,String delFlag);
}
