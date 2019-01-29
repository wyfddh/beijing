package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.mysql.fabric.xmlrpc.base.Array;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.IMuseumVisitorMapper;
import com.tj720.admin.dto.MuseumCostDto;
import com.tj720.admin.dto.MuseumVisitorDto;
import com.tj720.admin.dto.MuseumVisitorMonth;
import com.tj720.admin.service.IMuseumVisitorService;
import com.tj720.mip.utils.Tools;

@Service("MuseumVisitorServiceImpl")
public class MuseumVisitorServiceImpl implements IMuseumVisitorService {

    @Autowired
    IMuseumVisitorMapper museumVisitorDao;

    @Override
    public List<MuseumVisitorMonth> selectVisitorMonthList(MuseumVisitorDto info){
    	
    	MuseumVisitorMonth monthInfo = new MuseumVisitorMonth();
    	List<MuseumVisitorDto> dateList = museumVisitorDao.selectVisitorMonthList(info);
    	for(MuseumVisitorDto visitorDto:dateList){
    		getMonthInfo(visitorDto,monthInfo);
    	}
    	
    	List<MuseumVisitorMonth> monthList = new ArrayList<MuseumVisitorMonth>();
    	if(monthInfo !=null){
    		monthList.add(monthInfo);
    	}
    	return monthList;
    };

    @Override
    public List<MuseumVisitorDto> selectVisitorDayList(MuseumVisitorDto info){
    	MuseumVisitorDto dayInfo = museumVisitorDao.selectVisitorDay(info);
    	List<MuseumVisitorDto> dayList = new ArrayList<MuseumVisitorDto>();
    	if(dayInfo ==null){
    		MuseumVisitorDto initDay = new MuseumVisitorDto();
    		initDay.setMuseumId(info.getMuseumId());
    		initDay.setYear(info.getYear());
    		initDay.setMonth(info.getMonth());
    		dayList.add(initDay);
    	}else{
    		dayList.add(dayInfo);
    	}
    	return dayList;
    };

    @Override
    public Integer save(MuseumVisitorDto daysDto,MuseumVisitorMonth monthDto){
    	int num = 0;
    	try {
    		//保存日参观人数
    		String userId = Tools.getUser().getId();
            if(StringUtils.isNotBlank(daysDto.getId())){
            	daysDto.setUpdateId(userId);
            	daysDto.setUpdateTime(new Date());
            	num = museumVisitorDao.updateDay(daysDto);
            }else{
            	daysDto.setCreatorId(userId);
            	daysDto.setCreateTime(new Date());
            	daysDto.setUpdateId(userId);
            	daysDto.setUpdateTime(new Date());
            	daysDto.setId(IdUtils.nextId(daysDto));
            	num = museumVisitorDao.insert(daysDto);
            }
            
            //保存月参观人数
            List<MuseumVisitorDto> monthList = museumVisitorDao.selectVisitorMonthList(daysDto);
            Map<String,Object> monthPeopleMap = Utils.objectToMap(monthDto);
            for(int i =1;i<13;i++){
            	 Integer monthTotal = (Integer)monthPeopleMap.get("month"+i);
            	 String handFill = (String)(monthPeopleMap.get("handFill"+i));
                 Boolean exist = false;
                 for(MuseumVisitorDto info:monthList){
                 	if(i == info.getMonth()){
                 		exist = true;
                 		//更新一条月份数据
                 		info.setMonthTotal(monthTotal);
                 		info.setHandFill(handFill);
                 		info.setUpdateId(userId);
                 		info.setUpdateTime(new Date());
                 		museumVisitorDao.updateMonth(info);
                 	}
                 }
                 if(!exist && monthTotal != null){
                 	//插入一条月份数据
                	 MuseumVisitorDto insertDto = new MuseumVisitorDto();
                	 insertDto.setId(IdUtils.nextId(daysDto));
                	 insertDto.setMuseumId(daysDto.getMuseumId());
                	 insertDto.setYear(daysDto.getYear());
                	 insertDto.setMonth(i);
                	 insertDto.setMonthTotal(monthTotal);
                	 museumVisitorDao.insert(insertDto);
                 }
            }
		} catch (Exception e) {
			num = 0;
			e.printStackTrace();
		}
    	return num;
    };
    
    @Override
    public List<Map<String,Integer>> getYearList(String museumId){
    	return museumVisitorDao.getYearList(museumId);
    };
    
    //组装每月参观人数
    private void getMonthInfo(MuseumVisitorDto visitorDto,MuseumVisitorMonth monthInfo){
    	Integer month = visitorDto.getMonth();
		if(month == 1){
			monthInfo.setMonth1(visitorDto.getMonthTotal());
			monthInfo.setHandFill1(visitorDto.getHandFill());
		}
		if(month == 2){
			monthInfo.setMonth2(visitorDto.getMonthTotal());
			monthInfo.setHandFill2(visitorDto.getHandFill());
		}
		if(month == 3){
			monthInfo.setMonth3(visitorDto.getMonthTotal());
			monthInfo.setHandFill3(visitorDto.getHandFill());
		}
		if(month == 4){
			monthInfo.setMonth4(visitorDto.getMonthTotal());
			monthInfo.setHandFill4(visitorDto.getHandFill());
		}
		if(month == 5){
			monthInfo.setMonth5(visitorDto.getMonthTotal());
			monthInfo.setHandFill5(visitorDto.getHandFill());
		}
		if(month == 6){
			monthInfo.setMonth6(visitorDto.getMonthTotal());
			monthInfo.setHandFill6(visitorDto.getHandFill());
		}
		if(month == 7){
			monthInfo.setMonth7(visitorDto.getMonthTotal());
			monthInfo.setHandFill7(visitorDto.getHandFill());
		}
		
		if(month == 8){
			monthInfo.setMonth8(visitorDto.getMonthTotal());
			monthInfo.setHandFill8(visitorDto.getHandFill());
		}
		if(month == 9){
			monthInfo.setMonth9(visitorDto.getMonthTotal());
			monthInfo.setHandFill9(visitorDto.getHandFill());
		}
		if(month == 10){
			monthInfo.setMonth10(visitorDto.getMonthTotal());
			monthInfo.setHandFill10(visitorDto.getHandFill());
		}
		if(month == 11){
			monthInfo.setMonth11(visitorDto.getMonthTotal());
			monthInfo.setHandFill11(visitorDto.getHandFill());
		}
		if(month == 12){
			monthInfo.setMonth12(visitorDto.getMonthTotal());
			monthInfo.setHandFill12(visitorDto.getHandFill());
		}
    }
}
