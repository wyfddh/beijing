package com.tj720.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.MuseumDisplayShowMapper;
import com.tj720.admin.dto.MuseumDisplayShowDto;
import com.tj720.admin.service.IMuseumDisplayShowService;
import com.tj720.mip.utils.Tools;
import com.tj720.admin.common.util.Utils;

@Service("MuseumDisplayShowServiceImpl")
public class MuseumDisplayShowServiceImpl implements IMuseumDisplayShowService {

    @Autowired
    MuseumDisplayShowMapper museumShowDao;

    //条件查询角色分页
    @Override
    public List<MuseumDisplayShowDto> selectShowList(String museumId,String flag){
        List<MuseumDisplayShowDto> list = museumShowDao.selectShowList(museumId,flag);
        return list;
    };

    public int save(List<MuseumDisplayShowDto> list){
    	String userId = Tools.getUser().getId();
    	int num;
    	try {
    		for(MuseumDisplayShowDto costDto: list){
    			Boolean change= false;
                if(StringUtils.isNotBlank(costDto.getId())){
                	//查修改前数据
    				String id = costDto.getId();
    				MuseumDisplayShowDto baseInfo = museumShowDao.selectShowById(id);
    				
    				//需要校验是否改变的字段
    				String[] obj = {"name","showLength","collectionNum","outTime"};
    				change = Utils.isChanged(baseInfo, costDto, obj);
                    costDto.setUpdateId(userId);
                    costDto.setUpdateTime(new Date());
                    museumShowDao.update(costDto);
                }else{
                    costDto.setCreatorId(userId);
                    costDto.setCreateTime(new Date());
                    costDto.setUpdateId(userId);
                    costDto.setUpdateTime(new Date());
                    costDto.setId(IdUtils.nextId(costDto));
                    costDto.setFlag("1");
                    museumShowDao.insert(costDto);
                }
                if(change){
                	//插入一条状态为3的记录
                	costDto.setCreatorId(userId);
                    costDto.setCreateTime(new Date());
                    costDto.setUpdateId(userId);
                    costDto.setUpdateTime(new Date());
                    costDto.setId(IdUtils.nextId(costDto));
                	costDto.setFlag("3");
                	museumShowDao.insert(costDto);
                }
            }
    		num=1;
		} catch (Exception e) {
			num = 0;
		}
        
        return num;
    };

    public int deleteByLogic(String id){
        int num = museumShowDao.deleteByLogic(id);
        return num;
    };
    
    @Override
    public void deleteBase(String museumId, String flag){
    	museumShowDao.deleteBase(museumId,flag);
    }
    @Override
    public void updateFlag(MuseumDisplayShowDto costDto){
    	costDto.setUpdateTime(new Date());
    	costDto.setCreateTime(new Date());
    	museumShowDao.updateFlag(costDto);
    };
    @Override
    public void insertShow(MuseumDisplayShowDto info){
    	String userId = Tools.getUser().getId();
		info.setCreatorId(userId);
		info.setUpdateId(userId);
		info.setUpdateTime(new Date());
		info.setCreateTime(new Date());
		info.setId(IdUtils.nextId(info));
    	museumShowDao.insert(info);
    };
    
    @Override
    public MuseumDisplayShowDto selectShowById(String id){
    	return museumShowDao.selectShowById(id);
    };
}
