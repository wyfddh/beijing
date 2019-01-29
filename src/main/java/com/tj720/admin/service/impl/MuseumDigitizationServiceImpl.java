package com.tj720.admin.service.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.IMuseumDigitizationMapper;
import com.tj720.admin.dto.MuseumDigitizationDto;
import com.tj720.admin.dto.MuseumPublicServiceDto;
import com.tj720.admin.service.IMuseumDigitizationService;
import com.tj720.mip.utils.Tools;

@Service("museumDigitizationService")
public class MuseumDigitizationServiceImpl implements IMuseumDigitizationService {

    @Autowired
    IMuseumDigitizationMapper museumDigitizationDao;

    //条件查询角色分页
    @Override
    public MuseumDigitizationDto selectForm(String museumId,String flag){
        MuseumDigitizationDto serviceInfo = museumDigitizationDao.selectForm(museumId,flag);
        return serviceInfo;
    };

    public int save(MuseumDigitizationDto digitizationDto){
    	int num;
    	try {
    		String userId = Tools.getUser().getId();
            String serviceId = digitizationDto.getId();
            if(StringUtils.isNotEmpty(serviceId)){
                digitizationDto.setUpdateId(userId);
                digitizationDto.setUpdateTime(new Date());
                museumDigitizationDao.update(digitizationDto);
                
                //删除所有为3状态的记录
                museumDigitizationDao.deleteBase(digitizationDto.getMuseumId(), "3");
	            //插入一条状态为3的修改记录数据
				digitizationDto.setCreatorId(userId);
				digitizationDto.setUpdateId(userId);
				digitizationDto.setUpdateTime(new Date());
				digitizationDto.setCreateTime(new Date());
				digitizationDto.setId(IdUtils.nextId(digitizationDto));
				digitizationDto.setFlag("3");
				museumDigitizationDao.insert(digitizationDto);
            }else{
                digitizationDto.setCreatorId(userId);
                digitizationDto.setCreateTime(new Date());
                digitizationDto.setUpdateId(userId);
                digitizationDto.setUpdateTime(new Date());
                digitizationDto.setId(IdUtils.nextId(digitizationDto));
                digitizationDto.setFlag("1");
                museumDigitizationDao.insert(digitizationDto);
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
    	museumDigitizationDao.deleteBase(museumId,flag);
    };
    
    @Override
    public void updateFlag(MuseumDigitizationDto digitizationDto){
    	String userId = Tools.getUser().getId();
    	digitizationDto.setUpdateId(userId);
    	digitizationDto.setUpdateTime(new Date());
    	museumDigitizationDao.updateFlag(digitizationDto);
    }
    @Override
    public void insertDigitization(MuseumDigitizationDto digitizationDto){
    	String userId = Tools.getUser().getId();
    	digitizationDto.setCreatorId(userId);
    	digitizationDto.setUpdateId(userId);
    	digitizationDto.setUpdateTime(new Date());
    	digitizationDto.setCreateTime(new Date());
    	digitizationDto.setId(IdUtils.nextId(digitizationDto));
    	museumDigitizationDao.insert(digitizationDto);
    };

}
