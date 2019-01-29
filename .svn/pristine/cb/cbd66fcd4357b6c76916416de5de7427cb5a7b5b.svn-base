package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.ThreeDimDeskDao;
import com.tj720.mip.framework.base.BaseDao2;
import com.tj720.mip.framework.base.BaseService2Impl;
import com.tj720.mip.model.ThreeDimDesk;

@Service("threeDimDeskService")  
@Transactional
public class ThreeDimDeskServiceImpl extends BaseService2Impl<ThreeDimDesk> implements ThreeDimDeskService{

	/** 
     * 注入DAO 
     */  
	@Resource(name = "threeDimDeskDao")
	ThreeDimDeskDao threeDimDeskDao;
	
    @Resource(name = "threeDimDeskDao")  
    public void setDao(BaseDao2<ThreeDimDesk> dao) {  
        super.setDao(dao);  
    }  
    
    
}
