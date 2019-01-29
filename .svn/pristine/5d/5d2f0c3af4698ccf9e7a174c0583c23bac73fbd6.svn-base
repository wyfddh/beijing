package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipCollectionResidueLevelDao;
import com.tj720.mip.inter.service.table.IMipCollectionResidueLevelService;
import com.tj720.mip.model.MipCollectionResidueLevel;

@Service
public class MipCollectionResidueLevelService extends BaseService<MipCollectionResidueLevel> implements IMipCollectionResidueLevelService{

	@Resource(name="mipCollectionResidueLevelDao")
	IMipCollectionResidueLevelDao mipCollectionResidueLevelDao;
	
	@Resource(name="mipCollectionResidueLevelDao")
	public void setDao(IBaseDao<MipCollectionResidueLevel> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipCollectionResidueLevel get(String id){
		MipCollectionResidueLevel model = mipCollectionResidueLevelDao.get(id);
		if(model == null)
			 return new MipCollectionResidueLevel();
		return model;
	}

}
