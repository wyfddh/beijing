package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.ThreeDimDeskDao;
import com.tj720.mip.framework.base.BaseDao2;
import com.tj720.mip.framework.base.BaseService2Impl;
import com.tj720.mip.model.ThreeDimItem;
import com.tj720.mip.dao.ThreeDimtItemDao;

@Service("threeDimItemService")  
@Transactional
public class ThreeDimItemServiceImpl extends BaseService2Impl<ThreeDimItem> implements ThreeDimItemService{

	/** 
     * 注入DAO 
     */  
	@Resource(name = "threeDimItemDao")
	ThreeDimtItemDao threeDimItemDao;
	
    @Resource(name = "threeDimItemDao")  
    public void setDao(BaseDao2<ThreeDimItem> dao) {  
        super.setDao(dao);  
    }  
    
    
}
