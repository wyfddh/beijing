package com.tj720.mip.service.table;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.ISourceDao;
import com.tj720.mip.inter.service.table.ISourceService;
import com.tj720.mip.inter.service.tool.ILuceneService;
import com.tj720.mip.model.Source;

@Service
public class SourceService extends BaseService<Source>
		implements ISourceService ,ILuceneService<Source>{

	@Resource(name="sourceDao")
	ISourceDao sourceDao;
	
	@Resource(name="sourceDao")
	public void setDao(IBaseDao<Source> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public Source get(String id){
		Source model = sourceDao.get(id);
		if(model == null)
			 return new Source();
		return model;
	}

	@Override
	@Transactional
	public List<Source> getAll() {
		return sourceDao.findByMap(null, null, null);
	}
}
