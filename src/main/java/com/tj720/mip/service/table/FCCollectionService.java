package com.tj720.mip.service.table;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IFCCollectionDao;
import com.tj720.mip.inter.service.table.IFCCollectionService;
import com.tj720.mip.inter.service.tool.ILuceneService;
import com.tj720.mip.model.FCCollection;

@Service
public class FCCollectionService extends BaseService<FCCollection>
		implements IFCCollectionService ,ILuceneService<FCCollection>{

	@Resource(name="fCCollectionDao")
	IFCCollectionDao fCCollectionDao;
	
	@Resource(name="fCCollectionDao")
	public void setDao(IBaseDao<FCCollection> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public FCCollection get(String id){
		FCCollection model = fCCollectionDao.get(id);
		if(model == null)
			 return new FCCollection();
		return model;
	}

	@Override
	@Transactional
	public List<FCCollection> getAll() {
		return fCCollectionDao.findByMap(null, null, null);
	}
}
