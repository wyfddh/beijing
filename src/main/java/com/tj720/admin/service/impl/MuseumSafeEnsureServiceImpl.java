package com.tj720.admin.service.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.IMuseumSafeEnsureMapper;
import com.tj720.admin.dto.MuseumSafeEnsureDto;
import com.tj720.admin.service.IMuseumSafeEnsureService;
import com.tj720.mip.utils.Tools;

@Service("safeEnsureService")
public class MuseumSafeEnsureServiceImpl implements IMuseumSafeEnsureService {

    @Autowired
    IMuseumSafeEnsureMapper safeEnsureDao;

    //条件查询角色分页
    @Override
    public MuseumSafeEnsureDto selectForm(String museumId,String flag){
    	MuseumSafeEnsureDto serviceInfo = safeEnsureDao.selectForm(museumId,flag);
        return serviceInfo;
    };

    public int save(MuseumSafeEnsureDto info){
    	int num;
    	try {
    		String userId = Tools.getUser().getId();
            String serviceId = info.getId();
            if(StringUtils.isNotEmpty(serviceId)){
            	info.setUpdateId(userId);
            	info.setUpdateTime(new Date());
                safeEnsureDao.update(info);
                
                //删除所有为3状态的记录
                safeEnsureDao.deleteBase(info.getMuseumId(), "3");
	            //插入一条状态为3的修改记录数据
                info.setCreatorId(userId);
                info.setUpdateId(userId);
                info.setUpdateTime(new Date());
                info.setCreateTime(new Date());
                info.setId(IdUtils.nextId(info));
                info.setFlag("3");
				safeEnsureDao.insert(info);
            }else{
            	info.setCreatorId(userId);
            	info.setCreateTime(new Date());
            	info.setUpdateId(userId);
            	info.setUpdateTime(new Date());
            	info.setId(IdUtils.nextId(info));
            	info.setFlag("1");
                safeEnsureDao.insert(info);
            }
            num = 1;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			num=0;
		}
    	return num;
    };
    
    @Override
    public void deleteBase(String museumId,String flag){
    	safeEnsureDao.deleteBase(museumId,flag);
    };
    
    @Override
    public void updateFlag(MuseumSafeEnsureDto info){
    	String userId = Tools.getUser().getId();
    	info.setUpdateId(userId);
    	info.setUpdateTime(new Date());
    	safeEnsureDao.updateFlag(info);
    }
    @Override
    public void insertSafeEnsure(MuseumSafeEnsureDto info){
    	String userId = Tools.getUser().getId();
    	info.setCreatorId(userId);
    	info.setUpdateId(userId);
    	info.setUpdateTime(new Date());
    	info.setCreateTime(new Date());
    	info.setId(IdUtils.nextId(info));
    	safeEnsureDao.insert(info);
    };

}
