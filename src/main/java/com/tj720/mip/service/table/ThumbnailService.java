package com.tj720.mip.service.table;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.ThumbnailDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.IThumbnailService;
import com.tj720.mip.inter.service.tool.ILuceneService;
import com.tj720.mip.model.Thumbnail;

@Service
public class ThumbnailService extends BaseService<Thumbnail>
		implements IThumbnailService ,ILuceneService<Thumbnail>{

	@Resource(name="thumbnailDao")
	ThumbnailDao thumbnailDao;
	
	@Resource(name="thumbnailDao")
	public void setDao(IBaseDao<Thumbnail> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public Thumbnail get(String id){
		Thumbnail model = thumbnailDao.get(id);
		if(model == null)
			 return new Thumbnail();
		return model;
	}

	@Override
	@Transactional
	public List<Thumbnail> getAll() {
		return thumbnailDao.findByMap(null, null, null);
	}
}
