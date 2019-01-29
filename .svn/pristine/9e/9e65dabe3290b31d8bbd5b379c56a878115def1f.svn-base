package com.tj720.admin.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.CulturalOrgInfoMapper;
import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.admin.model.CulturalOrgInfo;
import com.tj720.admin.model.CulturalOrgInfoExample;
import com.tj720.admin.service.RelicsUnitService;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

/**
* @author chengrongkai
* @version 创建时间：2018年8月17日 上午10:11:29
* @ClassName 类名称
* @Description 类描述
*/
@Service
public class RelicsUnitServiceImpl implements RelicsUnitService{
	@Autowired
	CulturalOrgInfoMapper culturalOrgInfoMapper; 
	@Override
	public CulturalOrgInfo selectRelicsUnitById(String relicsUnitId, String level) {
		// TODO Auto-generated method stub
		return culturalOrgInfoMapper.selectRelicsUnitById(relicsUnitId,level);
	}
	@Override
	public int saveBaseInfo(CulturalOrgInfo culturalOrgInfo) {
		// 当前登录者
				String userId = Tools.getUser().getId();
		        String id = culturalOrgInfo.getId();
		        int num = 0;
		        try {
		        	if(!MyString.isEmpty(id)){
		        		culturalOrgInfo.setUpdater(userId);
		        		culturalOrgInfo.setUpdateTime(new Date());
		        		culturalOrgInfo.setDeleteMark("1");
		        		culturalOrgInfoMapper.updateByPrimaryKey(culturalOrgInfo);//保存
		                
		                //删除所有为3状态的记录
		        		culturalOrgInfoMapper.deleteBase(culturalOrgInfo.getOrgId(), "3");
		                //插入一条状态为3的修改记录数据
		        		culturalOrgInfo.setCreater(userId);
		        		culturalOrgInfo.setUpdater(userId);
		        		culturalOrgInfo.setUpdateTime(new Date());
		        		culturalOrgInfo.setCreateTime(new Date());
		        		culturalOrgInfo.setId(IdUtils.nextId(culturalOrgInfo));
		        		culturalOrgInfo.setDeleteMark("3");
		                num = culturalOrgInfoMapper.insert(culturalOrgInfo);
		                
		            }else{
		            	culturalOrgInfo.setCreater(userId);
		            	culturalOrgInfo.setUpdater(userId);
		            	culturalOrgInfo.setUpdateTime(new Date());
		            	culturalOrgInfo.setCreateTime(new Date());
		            	culturalOrgInfo.setId(IdUtils.nextId(culturalOrgInfo));
		            	culturalOrgInfo.setDeleteMark("1");
		                num=culturalOrgInfoMapper.insert(culturalOrgInfo);//保存
		            }
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		    	return num;
	}
	@Override
	public int insertBaseInfoByFlag(CulturalOrgInfo culturalOrgInfo) {
		// TODO Auto-generated method stub
		String userId = Tools.getUser().getId();
        String id = culturalOrgInfo.getId();
        int num = 0;
        culturalOrgInfo.setCreater(userId);
    	culturalOrgInfo.setUpdater(userId);
    	culturalOrgInfo.setUpdateTime(new Date());
    	culturalOrgInfo.setCreateTime(new Date());
    	culturalOrgInfo.setId(IdUtils.nextId(culturalOrgInfo));
        num=culturalOrgInfoMapper.insert(culturalOrgInfo);//保存
	
		return num;
	}
	@Override
	public int updateBaseInfoByFlag(CulturalOrgInfo culturalOrgInfo) {
		// TODO Auto-generated method stub
		String userId = Tools.getUser().getId();
        String id = culturalOrgInfo.getId();
        int num = 0;
		culturalOrgInfo.setUpdater(userId);
		culturalOrgInfo.setUpdateTime(new Date());
		culturalOrgInfoMapper.updateByPrimaryKey(culturalOrgInfo);//保存
	
		return num;
	}
	@Override
	public int delBaseInfo(String orgId, String delFlag) {
		int result = culturalOrgInfoMapper.deleteBase(orgId, delFlag);
		return result;
	}	
	
}
