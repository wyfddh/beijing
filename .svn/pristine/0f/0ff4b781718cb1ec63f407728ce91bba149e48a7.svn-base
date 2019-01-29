package com.tj720.mip.service.table;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.YearTypeDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.IYearTypeService;
import com.tj720.mip.inter.service.tool.ILuceneService;
import com.tj720.mip.model.YearType;

@Service
public class YearTypeService extends BaseService<YearType>
		implements IYearTypeService ,ILuceneService<YearType>{

	@Resource(name="yearTypeDao")
	YearTypeDao yearTypeDao;
	
	@Resource(name="yearTypeDao")
	public void setDao(IBaseDao<YearType> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public YearType get(String id){
		YearType model = yearTypeDao.get(id);
		if(model == null)
			 return new YearType();
		return model;
	}

	@Override
	@Transactional
	public List<YearType> getAll() {
		return yearTypeDao.findByMap(null, null, null);
	}
}
