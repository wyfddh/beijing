package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.CurationDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.ICurationService;
import com.tj720.mip.model.Curation;

@Service
public class CurationService extends BaseService<Curation> implements ICurationService{

	@Resource(name="curationDao")
	CurationDao curationDao;
	
	@Resource(name="curationDao")
	public void setDao(IBaseDao<Curation> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public Curation get(String id){
		Curation model = curationDao.get(id);
		if(model == null)
			 return new Curation();
		return model;
	}

}
