package com.tj720.mip.service.table;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IArticleDao;
import com.tj720.mip.inter.service.table.IArticleService;
import com.tj720.mip.inter.service.tool.ILuceneService;
import com.tj720.mip.model.Article;

@Service
public class ArticleService extends BaseService<Article>
		implements IArticleService,ILuceneService<Article> {
	@Resource(name="articleDao")
	IArticleDao webPageDao;

	@Resource(name="articleDao")
	public void setDao(IBaseDao<Article> dao) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public Article get(String id){
		Article model = dao.get(id);
		if(model == null)
			 return new Article();
		return model;
	}

	@Override
	@Transactional
	public List<Article> getAll() {
		return webPageDao.findByMap(null, null, null);
	}
	
	
	
}
