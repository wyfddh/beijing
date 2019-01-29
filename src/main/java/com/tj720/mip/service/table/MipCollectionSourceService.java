package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipCollectionSourceDao;
import com.tj720.mip.inter.service.table.IMipCollectionSourceService;
import com.tj720.mip.model.MipCollectionSource;

@Service
public class MipCollectionSourceService extends BaseService<MipCollectionSource> implements IMipCollectionSourceService{

	@Resource(name="mipCollectionSourceDao")
	IMipCollectionSourceDao mipCollectionSourceDao;
	
	@Resource(name="mipCollectionSourceDao")
	public void setDao(IBaseDao<MipCollectionSource> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipCollectionSource get(String id){
		MipCollectionSource model = mipCollectionSourceDao.get(id);
		if(model == null)
			 return new MipCollectionSource();
		return model;
	}

}
