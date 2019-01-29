package com.tj720.mip.service.table;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IFCFossilDao;
import com.tj720.mip.inter.service.table.IFCFossilService;
import com.tj720.mip.inter.service.tool.ILuceneService;
import com.tj720.mip.model.FCFossil;

@Service
public class FCFossilService extends BaseService<FCFossil>
		implements IFCFossilService ,ILuceneService<FCFossil>{

	@Resource(name="fCFossilDao")
	IFCFossilDao fCFossilDao;
	
	@Resource(name="fCFossilDao")
	public void setDao(IBaseDao<FCFossil> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public FCFossil get(String id){
		FCFossil model = fCFossilDao.get(id);
		if(model == null)
			 return new FCFossil();
		return model;
	}

	@Override
	@Transactional
	public List<FCFossil> getAll() {
		return fCFossilDao.findByMap(null, null, null);
	}
}
