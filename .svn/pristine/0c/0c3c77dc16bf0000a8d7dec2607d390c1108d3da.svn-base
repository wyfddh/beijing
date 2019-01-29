package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipCollectionStorageStateDao;
import com.tj720.mip.inter.service.table.IMipCollectionStorageStateService;
import com.tj720.mip.model.MipCollectionStorageState;

@Service
public class MipCollectionStorageStateService extends BaseService<MipCollectionStorageState> implements IMipCollectionStorageStateService{

	@Resource(name="mipCollectionStorageStateDao")
	IMipCollectionStorageStateDao mipCollectionStorageStateDao;
	
	@Resource(name="mipCollectionStorageStateDao")
	public void setDao(IBaseDao<MipCollectionStorageState> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipCollectionStorageState get(String id){
		MipCollectionStorageState model = mipCollectionStorageStateDao.get(id);
		if(model == null)
			 return new MipCollectionStorageState();
		return model;
	}

}
