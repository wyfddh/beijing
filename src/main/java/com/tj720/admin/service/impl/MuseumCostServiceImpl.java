package com.tj720.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.IMuseumCostMapper;
import com.tj720.admin.dto.MuseumCostDto;
import com.tj720.admin.dto.MuseumPromotionDto;
import com.tj720.admin.service.IMuseumCostService;
import com.tj720.mip.utils.Tools;
import com.tj720.mip.vo.BaseVO;

@Service("museumCoseService")
public class MuseumCostServiceImpl implements IMuseumCostService {

    @Autowired
    IMuseumCostMapper museumCostDao;

    //条件查询角色分页
    @Override
    public List<MuseumCostDto> selectCostList(String museumId,String flag){
        List<MuseumCostDto> list = museumCostDao.selectCostList(museumId,flag);
        return list;
    };

    public int save(List<MuseumCostDto> list){
    	String userId = Tools.getUser().getId();
    	int num;
    	try {
    		for(MuseumCostDto costDto: list){
                if(StringUtils.isNotBlank(costDto.getId())){
                	BaseVO vo = new BaseVO();
                	vo.setUpdateId(userId);
                	vo.setUpdateTime(new Date());
//                	MuseumCostDto dto = (MuseumCostDto)vo;
                	
                    costDto.setUpdateId(userId);
                    costDto.setUpdateTime(new Date());
                    museumCostDao.update(costDto);
                }else{
                    costDto.setCreatorId(userId);
                    costDto.setCreateTime(new Date());
                    costDto.setUpdateId(userId);
                    costDto.setUpdateTime(new Date());
                    costDto.setId(IdUtils.nextId(costDto));
                    costDto.setFlag("1");
                    museumCostDao.insert(costDto);
                }
            }
    		num=1;
		} catch (Exception e) {
			num = 0;
		}
        
        return num;
    };

    public int deleteByLogic(String id){
        int num = museumCostDao.deleteByLogic(id);
        return num;
    };
    
    @Override
    public void deleteBase(String museumId, String flag){
    	museumCostDao.deleteBase(museumId,flag);
    }
    @Override
    public void updateFlag(MuseumCostDto costDto){
    	String userId = Tools.getUser().getId();
    	costDto.setUpdateId(userId);
    	costDto.setUpdateTime(new Date());
    	museumCostDao.updateFlag(costDto);
    };
    @Override
    public void insertCost(MuseumCostDto costDto){
    	String userId = Tools.getUser().getId();
    	costDto.setCreatorId(userId);
    	costDto.setUpdateId(userId);
    	costDto.setUpdateTime(new Date());
    	costDto.setCreateTime(new Date());
    	costDto.setId(IdUtils.nextId(costDto));
    	museumCostDao.insert(costDto);
    };
}
