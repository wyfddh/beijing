package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipCollectionWhTimeDao;
import com.tj720.mip.inter.service.table.IMipCollectionWhTimeService;
import com.tj720.mip.model.MipCollectionWhTime;

@Service
public class MipCollectionWhTimeService extends BaseService<MipCollectionWhTime> implements IMipCollectionWhTimeService{

	@Resource(name="mipCollectionWhTimeDao")
	IMipCollectionWhTimeDao mipCollectionWhTimeDao;
	
	@Resource(name="mipCollectionWhTimeDao")
	public void setDao(IBaseDao<MipCollectionWhTime> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipCollectionWhTime get(String id){
		MipCollectionWhTime model = mipCollectionWhTimeDao.get(id);
		if(model == null)
			 return new MipCollectionWhTime();
		return model;
	}

}
