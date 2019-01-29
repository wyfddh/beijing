package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IErrorDao;
import com.tj720.mip.inter.service.table.IErrorService;
import com.tj720.mip.model.Error;

@Service
public class ErrorService extends BaseService<Error>
		implements IErrorService {
	@Resource(name="errorDao")
	IErrorDao errorDao;
	
	@Resource(name="errorDao")
	public void setDao(IBaseDao<Error> dao) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public Error get(String id){
		Error model = errorDao.get(id);
		if(model == null)
			 return new Error();
		return model;
	}
}
