package com.tj720.mip.service.table;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.PictureSearchSetDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.IPictureSearchSetService;
import com.tj720.mip.inter.service.tool.ILuceneService;
import com.tj720.mip.model.PictureSearchSet;

@Service
public class PictureSearchSetService extends BaseService<PictureSearchSet>
		implements IPictureSearchSetService ,ILuceneService<PictureSearchSet>{

	@Resource(name="pictureSearchSetDao")
	PictureSearchSetDao pictureSearchSetDao;
	
	@Resource(name="pictureSearchSetDao")
	public void setDao(IBaseDao<PictureSearchSet> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public PictureSearchSet get(String id){
		PictureSearchSet model = pictureSearchSetDao.get(id);
		if(model == null)
			 return new PictureSearchSet();
		return model;
	}

	@Override
	@Transactional
	public List<PictureSearchSet> getAll() {
		return pictureSearchSetDao.findByMap(null, null, null);
	}
}
