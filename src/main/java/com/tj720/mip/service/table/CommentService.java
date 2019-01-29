package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.ICommentDao;
import com.tj720.mip.inter.service.table.ICommentService;
import com.tj720.mip.model.Comment;

@Service
public class CommentService extends BaseService<Comment>
		implements ICommentService {
	@Resource(name="commentDao")
	ICommentDao commentDao;
	
	@Resource(name="commentDao")
	public void setDao(IBaseDao<Comment> dao) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public Comment get(String id){
		Comment model = commentDao.get(id);
		if(model == null)
			 return new Comment();
		return model;
	}
}
