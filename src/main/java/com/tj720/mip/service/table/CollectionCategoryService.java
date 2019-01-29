package com.tj720.mip.service.table;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.CollectionCategoryDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.ICollectionCategoryService;
import com.tj720.mip.inter.service.tool.ILuceneService;
import com.tj720.mip.model.CollectionCategory;

@Service
public class CollectionCategoryService extends BaseService<CollectionCategory>
		implements ICollectionCategoryService ,ILuceneService<CollectionCategory>{

	@Resource(name="collectionCategoryDao")
	CollectionCategoryDao collectionCategoryDao;
	
	@Resource(name="collectionCategoryDao")
	public void setDao(IBaseDao<CollectionCategory> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public CollectionCategory get(String id){
		CollectionCategory model = collectionCategoryDao.get(id);
		if(model == null)
			 return new CollectionCategory();
		return model;
	}

	@Override
	@Transactional
	public List<CollectionCategory> getAll() {
		return collectionCategoryDao.findByMap(null, null, null);
	}
}
