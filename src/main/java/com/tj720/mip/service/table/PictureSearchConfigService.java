package com.tj720.mip.service.table;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.PictureSearchConfigDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.IPictureSearchConfigService;
import com.tj720.mip.inter.service.tool.ILuceneService;
import com.tj720.mip.model.PictureSearchConfig;

@Service
public class PictureSearchConfigService extends BaseService<PictureSearchConfig>
		implements IPictureSearchConfigService ,ILuceneService<PictureSearchConfig>{

	@Resource(name="pictureSearchConfigDao")
	PictureSearchConfigDao pictureSearchConfigDao;
	
	@Resource(name="pictureSearchConfigDao")
	public void setDao(IBaseDao<PictureSearchConfig> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public PictureSearchConfig get(String id){
		PictureSearchConfig model = pictureSearchConfigDao.get(id);
		if(model == null)
			 return new PictureSearchConfig();
		return model;
	}

	@Override
	@Transactional
	public List<PictureSearchConfig> getAll() {
		return pictureSearchConfigDao.findByMap(null, null, null);
	}
}
